package org.codehaus.jackson.sym;

import java.util.Arrays;
import org.codehaus.jackson.util.InternCache;
/* loaded from: classes2.dex */
public final class CharsToNameCanonicalizer {
    protected static final int DEFAULT_TABLE_SIZE = 64;
    static final int MAX_ENTRIES_FOR_REUSE = 12000;
    protected static final int MAX_TABLE_SIZE = 65536;
    static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
    protected Bucket[] _buckets;
    protected final boolean _canonicalize;
    protected boolean _dirty;
    protected int _indexMask;
    protected final boolean _intern;
    protected CharsToNameCanonicalizer _parent;
    protected int _size;
    protected int _sizeThreshold;
    protected String[] _symbols;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Bucket {
        private final String _symbol;
        private final Bucket mNext;

        public Bucket(String str, Bucket bucket) {
            this._symbol = str;
            this.mNext = bucket;
        }

        public String find(char[] cArr, int i, int i2) {
            String str = this._symbol;
            Bucket bucket = this.mNext;
            while (true) {
                if (str.length() == i2) {
                    int i3 = 0;
                    while (str.charAt(i3) == cArr[i + i3] && (i3 = i3 + 1) < i2) {
                    }
                    if (i3 == i2) {
                        return str;
                    }
                }
                if (bucket == null) {
                    return null;
                }
                str = bucket.getSymbol();
                bucket = bucket.getNext();
            }
        }

        public Bucket getNext() {
            return this.mNext;
        }

        public String getSymbol() {
            return this._symbol;
        }
    }

    private CharsToNameCanonicalizer() {
        this._canonicalize = true;
        this._intern = true;
        this._dirty = true;
        initTables(64);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2, String[] strArr, Bucket[] bucketArr, int i) {
        this._parent = charsToNameCanonicalizer;
        this._canonicalize = z;
        this._intern = z2;
        this._symbols = strArr;
        this._buckets = bucketArr;
        this._size = i;
        int length = strArr.length;
        this._sizeThreshold = length - (length >> 2);
        this._indexMask = length - 1;
        this._dirty = false;
    }

    public static int calcHash(String str) {
        int charAt = str.charAt(0);
        int length = str.length();
        for (int i = 1; i < length; i++) {
            charAt = (charAt * 31) + str.charAt(i);
        }
        return charAt;
    }

    public static int calcHash(char[] cArr, int i, int i2) {
        int i3 = 1;
        char c = cArr[0];
        while (i3 < i2) {
            i3++;
            c = (c * 31) + cArr[i3];
        }
        return c;
    }

    private void copyArrays() {
        String[] strArr = this._symbols;
        int length = strArr.length;
        this._symbols = new String[length];
        System.arraycopy(strArr, 0, this._symbols, 0, length);
        Bucket[] bucketArr = this._buckets;
        int length2 = bucketArr.length;
        this._buckets = new Bucket[length2];
        System.arraycopy(bucketArr, 0, this._buckets, 0, length2);
    }

    public static CharsToNameCanonicalizer createRoot() {
        return sBootstrapSymbolTable.makeOrphan();
    }

    private void initTables(int i) {
        this._symbols = new String[i];
        this._buckets = new Bucket[i >> 1];
        this._indexMask = i - 1;
        this._size = 0;
        this._sizeThreshold = i - (i >> 2);
    }

    private CharsToNameCanonicalizer makeOrphan() {
        return new CharsToNameCanonicalizer(null, true, true, this._symbols, this._buckets, this._size);
    }

    private synchronized void mergeChild(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.size() > MAX_ENTRIES_FOR_REUSE) {
            initTables(64);
        } else if (charsToNameCanonicalizer.size() > size()) {
            this._symbols = charsToNameCanonicalizer._symbols;
            this._buckets = charsToNameCanonicalizer._buckets;
            this._size = charsToNameCanonicalizer._size;
            this._sizeThreshold = charsToNameCanonicalizer._sizeThreshold;
            this._indexMask = charsToNameCanonicalizer._indexMask;
        }
        this._dirty = false;
    }

    private void rehash() {
        int length = this._symbols.length;
        int i = length + length;
        if (i > 65536) {
            this._size = 0;
            Arrays.fill(this._symbols, (Object) null);
            Arrays.fill(this._buckets, (Object) null);
            this._dirty = true;
            return;
        }
        String[] strArr = this._symbols;
        Bucket[] bucketArr = this._buckets;
        this._symbols = new String[i];
        this._buckets = new Bucket[i >> 1];
        this._indexMask = i - 1;
        this._sizeThreshold += this._sizeThreshold;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            if (str != null) {
                i2++;
                int calcHash = calcHash(str) & this._indexMask;
                if (this._symbols[calcHash] == null) {
                    this._symbols[calcHash] = str;
                } else {
                    int i4 = calcHash >> 1;
                    this._buckets[i4] = new Bucket(str, this._buckets[i4]);
                }
            }
        }
        int i5 = length >> 1;
        int i6 = i2;
        for (int i7 = 0; i7 < i5; i7++) {
            for (Bucket bucket = bucketArr[i7]; bucket != null; bucket = bucket.getNext()) {
                i6++;
                String symbol = bucket.getSymbol();
                int calcHash2 = calcHash(symbol) & this._indexMask;
                if (this._symbols[calcHash2] == null) {
                    this._symbols[calcHash2] = symbol;
                } else {
                    int i8 = calcHash2 >> 1;
                    this._buckets[i8] = new Bucket(symbol, this._buckets[i8]);
                }
            }
        }
        if (i6 == this._size) {
            return;
        }
        throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + i6 + ".");
    }

    public String findSymbol(char[] cArr, int i, int i2, int i3) {
        int i4;
        String find;
        if (i2 < 1) {
            return "";
        }
        if (!this._canonicalize) {
            return new String(cArr, i, i2);
        }
        int i5 = i3 & this._indexMask;
        String str = this._symbols[i5];
        if (str != null) {
            if (str.length() == i2) {
                int i6 = 0;
                while (str.charAt(i6) == cArr[i + i6] && (i6 = i6 + 1) < i2) {
                }
                if (i6 == i2) {
                    return str;
                }
            }
            Bucket bucket = this._buckets[i5 >> 1];
            if (bucket != null && (find = bucket.find(cArr, i, i2)) != null) {
                return find;
            }
        }
        if (!this._dirty) {
            copyArrays();
            this._dirty = true;
            i4 = i5;
        } else if (this._size >= this._sizeThreshold) {
            rehash();
            i4 = calcHash(cArr, i, i2) & this._indexMask;
        } else {
            i4 = i5;
        }
        this._size++;
        String str2 = new String(cArr, i, i2);
        if (this._intern) {
            str2 = InternCache.instance.intern(str2);
        }
        if (this._symbols[i4] == null) {
            this._symbols[i4] = str2;
            return str2;
        }
        int i7 = i4 >> 1;
        this._buckets[i7] = new Bucket(str2, this._buckets[i7]);
        return str2;
    }

    public synchronized CharsToNameCanonicalizer makeChild(boolean z, boolean z2) {
        return new CharsToNameCanonicalizer(this, z, z2, this._symbols, this._buckets, this._size);
    }

    public boolean maybeDirty() {
        return this._dirty;
    }

    public void release() {
        if (maybeDirty() && this._parent != null) {
            this._parent.mergeChild(this);
            this._dirty = false;
        }
    }

    public int size() {
        return this._size;
    }
}
