package org.codehaus.jackson.smile;

import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.impl.JsonGeneratorBase;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.p316io.IOContext;
import org.codehaus.jackson.p316io.SerializedString;
/* loaded from: classes2.dex */
public class SmileGenerator extends JsonGeneratorBase {
    protected static final long MAX_INT_AS_LONG = 2147483647L;
    private static final int MIN_BUFFER_LENGTH = 770;
    protected static final long MIN_INT_AS_LONG = -2147483648L;
    protected static final int SURR1_FIRST = 55296;
    protected static final int SURR1_LAST = 56319;
    protected static final int SURR2_FIRST = 56320;
    protected static final int SURR2_LAST = 57343;
    protected static final byte TOKEN_BYTE_BIG_DECIMAL = 42;
    protected static final byte TOKEN_BYTE_BIG_INTEGER = 38;
    protected static final byte TOKEN_BYTE_FLOAT_32 = 40;
    protected static final byte TOKEN_BYTE_FLOAT_64 = 41;
    protected static final byte TOKEN_BYTE_INT_32 = 36;
    protected static final byte TOKEN_BYTE_INT_64 = 37;
    protected static final byte TOKEN_BYTE_LONG_STRING_ASCII = -32;
    protected static final byte TOKEN_BYTE_LONG_STRING_UNICODE = -28;
    protected static final ThreadLocal<SoftReference<SmileBufferRecycler<SharedStringNode>>> _smileRecyclerRef = new ThreadLocal<>();
    protected boolean _bufferRecyclable;
    protected int _bytesWritten;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected final IOContext _ioContext;
    protected final OutputStream _out;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected int _outputTail;
    protected int _seenNameCount;
    protected SharedStringNode[] _seenNames;
    protected int _seenStringValueCount;
    protected SharedStringNode[] _seenStringValues;
    protected final SmileBufferRecycler<SharedStringNode> _smileBufferRecycler;
    protected int _smileFeatures;

    /* loaded from: classes2.dex */
    public enum Feature {
        WRITE_HEADER(true),
        WRITE_END_MARKER(false),
        ENCODE_BINARY_AS_7BIT(true),
        CHECK_SHARED_NAMES(true),
        CHECK_SHARED_STRING_VALUES(false);
        
        protected final boolean _defaultState;
        protected final int _mask = 1 << ordinal();

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            Feature[] values;
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public int getMask() {
            return this._mask;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class SharedStringNode {
        public final int index;
        public SharedStringNode next;
        public final String value;

        public SharedStringNode(String str, int i, SharedStringNode sharedStringNode) {
            this.value = str;
            this.index = i;
            this.next = sharedStringNode;
        }
    }

    public SmileGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, OutputStream outputStream) {
        super(i, objectCodec);
        this._outputTail = 0;
        this._smileFeatures = i2;
        this._ioContext = iOContext;
        this._smileBufferRecycler = _smileBufferRecycler();
        this._out = outputStream;
        this._bufferRecyclable = true;
        this._outputBuffer = iOContext.allocWriteEncodingBuffer();
        this._outputEnd = this._outputBuffer.length;
        this._charBuffer = iOContext.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
        if (this._outputEnd < 770) {
            throw new IllegalStateException("Internal encoding buffer length (" + this._outputEnd + ") too short, must be at least 770");
        }
        if ((Feature.CHECK_SHARED_NAMES.getMask() & i2) == 0) {
            this._seenNames = null;
            this._seenNameCount = -1;
        } else {
            this._seenNames = this._smileBufferRecycler.allocSeenNamesBuffer();
            if (this._seenNames == null) {
                this._seenNames = new SharedStringNode[64];
            }
            this._seenNameCount = 0;
        }
        if ((Feature.CHECK_SHARED_STRING_VALUES.getMask() & i2) == 0) {
            this._seenStringValues = null;
            this._seenStringValueCount = -1;
            return;
        }
        this._seenStringValues = this._smileBufferRecycler.allocSeenStringValuesBuffer();
        if (this._seenStringValues == null) {
            this._seenStringValues = new SharedStringNode[64];
        }
        this._seenStringValueCount = 0;
    }

    public SmileGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, OutputStream outputStream, byte[] bArr, int i3, boolean z) {
        super(i, objectCodec);
        this._outputTail = 0;
        this._smileFeatures = i2;
        this._ioContext = iOContext;
        this._smileBufferRecycler = _smileBufferRecycler();
        this._out = outputStream;
        this._bufferRecyclable = z;
        this._outputTail = i3;
        this._outputBuffer = bArr;
        this._outputEnd = this._outputBuffer.length;
        this._charBuffer = iOContext.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
        if (this._outputEnd < 770) {
            throw new IllegalStateException("Internal encoding buffer length (" + this._outputEnd + ") too short, must be at least 770");
        }
        if ((Feature.CHECK_SHARED_NAMES.getMask() & i2) == 0) {
            this._seenNames = null;
            this._seenNameCount = -1;
        } else {
            this._seenNames = this._smileBufferRecycler.allocSeenNamesBuffer();
            if (this._seenNames == null) {
                this._seenNames = new SharedStringNode[64];
            }
            this._seenNameCount = 0;
        }
        if ((Feature.CHECK_SHARED_STRING_VALUES.getMask() & i2) == 0) {
            this._seenStringValues = null;
            this._seenStringValueCount = -1;
            return;
        }
        this._seenStringValues = this._smileBufferRecycler.allocSeenStringValuesBuffer();
        if (this._seenStringValues == null) {
            this._seenStringValues = new SharedStringNode[64];
        }
        this._seenStringValueCount = 0;
    }

    private final void _addSeenName(String str) {
        if (this._seenNameCount == this._seenNames.length) {
            if (this._seenNameCount == 1024) {
                Arrays.fill(this._seenNames, (Object) null);
                this._seenNameCount = 0;
            } else {
                SharedStringNode[] sharedStringNodeArr = this._seenNames;
                this._seenNames = new SharedStringNode[1024];
                for (SharedStringNode sharedStringNode : sharedStringNodeArr) {
                    for (; sharedStringNode != null; sharedStringNode = sharedStringNode.next) {
                        int hashCode = sharedStringNode.value.hashCode() & 1023;
                        sharedStringNode.next = this._seenNames[hashCode];
                        this._seenNames[hashCode] = sharedStringNode;
                    }
                }
            }
        }
        int hashCode2 = str.hashCode() & (this._seenNames.length - 1);
        this._seenNames[hashCode2] = new SharedStringNode(str, this._seenNameCount, this._seenNames[hashCode2]);
        this._seenNameCount++;
    }

    private final void _addSeenStringValue(String str) {
        if (this._seenStringValueCount == this._seenStringValues.length) {
            if (this._seenStringValueCount == 1024) {
                Arrays.fill(this._seenStringValues, (Object) null);
                this._seenStringValueCount = 0;
            } else {
                SharedStringNode[] sharedStringNodeArr = this._seenStringValues;
                this._seenStringValues = new SharedStringNode[1024];
                for (SharedStringNode sharedStringNode : sharedStringNodeArr) {
                    for (; sharedStringNode != null; sharedStringNode = sharedStringNode.next) {
                        int hashCode = sharedStringNode.value.hashCode() & 1023;
                        sharedStringNode.next = this._seenStringValues[hashCode];
                        this._seenStringValues[hashCode] = sharedStringNode;
                    }
                }
            }
        }
        int hashCode2 = str.hashCode() & (this._seenStringValues.length - 1);
        this._seenStringValues[hashCode2] = new SharedStringNode(str, this._seenStringValueCount, this._seenStringValues[hashCode2]);
        this._seenStringValueCount++;
    }

    private int _convertSurrogate(int i, int i2) {
        if (i2 < SURR2_FIRST || i2 > SURR2_LAST) {
            throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
        }
        return 65536 + ((i - SURR1_FIRST) << 10) + (i2 - SURR2_FIRST);
    }

    private final void _ensureRoomForOutput(int i) {
        if (this._outputTail + i >= this._outputEnd) {
            _flushBuffer();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
        r0 = r1.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
        if (r0.hashCode() != r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        if (r0.equals(r6) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
        return r1.index;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
        r1 = r1.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
        if (r1 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int _findSeenName(String str) {
        int hashCode = str.hashCode();
        SharedStringNode sharedStringNode = this._seenNames[(this._seenNames.length - 1) & hashCode];
        if (sharedStringNode == null) {
            return -1;
        }
        if (sharedStringNode.value == str) {
            return sharedStringNode.index;
        }
        SharedStringNode sharedStringNode2 = sharedStringNode;
        do {
            sharedStringNode2 = sharedStringNode2.next;
            if (sharedStringNode2 != null) {
            }
        } while (sharedStringNode2.value != str);
        return sharedStringNode2.index;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0.hashCode() != r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0.equals(r5) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r1.index;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        r1 = r1.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r1 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        r0 = r1.value;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int _findSeenStringValue(String str) {
        int hashCode = str.hashCode();
        SharedStringNode sharedStringNode = this._seenStringValues[(this._seenStringValues.length - 1) & hashCode];
        if (sharedStringNode != null) {
            SharedStringNode sharedStringNode2 = sharedStringNode;
            while (sharedStringNode2.value != str) {
                sharedStringNode2 = sharedStringNode2.next;
                if (sharedStringNode2 == null) {
                    break;
                }
            }
            return sharedStringNode2.index;
        }
        return -1;
    }

    private void _mediumUTF8Encode(char[] cArr, int i, int i2) {
        char c;
        int i3 = this._outputEnd - 4;
        int i4 = i;
        while (i4 < i2) {
            if (this._outputTail >= i3) {
                _flushBuffer();
            }
            int i5 = i4 + 1;
            char c2 = cArr[i4];
            if (c2 <= 127) {
                byte[] bArr = this._outputBuffer;
                int i6 = this._outputTail;
                this._outputTail = i6 + 1;
                bArr[i6] = (byte) c2;
                int i7 = i2 - i5;
                int i8 = i3 - this._outputTail;
                if (i7 <= i8) {
                    i8 = i7;
                }
                int i9 = i8 + i5;
                while (i5 < i9) {
                    int i10 = i5 + 1;
                    char c3 = cArr[i5];
                    if (c3 > 127) {
                        c = c3;
                        i4 = i10;
                    } else {
                        byte[] bArr2 = this._outputBuffer;
                        int i11 = this._outputTail;
                        this._outputTail = i11 + 1;
                        bArr2[i11] = (byte) c3;
                        i5 = i10;
                    }
                }
                i4 = i5;
            } else {
                i4 = i5;
                c = c2;
            }
            if (c < 2048) {
                byte[] bArr3 = this._outputBuffer;
                int i12 = this._outputTail;
                this._outputTail = i12 + 1;
                bArr3[i12] = (byte) ((c >> 6) | 192);
                byte[] bArr4 = this._outputBuffer;
                int i13 = this._outputTail;
                this._outputTail = i13 + 1;
                bArr4[i13] = (byte) ((c & '?') | 128);
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                byte[] bArr5 = this._outputBuffer;
                int i14 = this._outputTail;
                this._outputTail = i14 + 1;
                bArr5[i14] = (byte) ((c >> '\f') | 224);
                byte[] bArr6 = this._outputBuffer;
                int i15 = this._outputTail;
                this._outputTail = i15 + 1;
                bArr6[i15] = (byte) (((c >> 6) & 63) | 128);
                byte[] bArr7 = this._outputBuffer;
                int i16 = this._outputTail;
                this._outputTail = i16 + 1;
                bArr7[i16] = (byte) ((c & '?') | 128);
            } else {
                if (c > SURR1_LAST) {
                    _throwIllegalSurrogate(c);
                }
                if (i4 >= i2) {
                    _throwIllegalSurrogate(c);
                }
                int i17 = i4 + 1;
                int _convertSurrogate = _convertSurrogate(c, cArr[i4]);
                if (_convertSurrogate > 1114111) {
                    _throwIllegalSurrogate(_convertSurrogate);
                }
                byte[] bArr8 = this._outputBuffer;
                int i18 = this._outputTail;
                this._outputTail = i18 + 1;
                bArr8[i18] = (byte) ((_convertSurrogate >> 18) | 240);
                byte[] bArr9 = this._outputBuffer;
                int i19 = this._outputTail;
                this._outputTail = i19 + 1;
                bArr9[i19] = (byte) (((_convertSurrogate >> 12) & 63) | 128);
                byte[] bArr10 = this._outputBuffer;
                int i20 = this._outputTail;
                this._outputTail = i20 + 1;
                bArr10[i20] = (byte) (((_convertSurrogate >> 6) & 63) | 128);
                byte[] bArr11 = this._outputBuffer;
                int i21 = this._outputTail;
                this._outputTail = i21 + 1;
                bArr11[i21] = (byte) ((_convertSurrogate & 63) | 128);
                i4 = i17;
            }
        }
    }

    private final int _shortUTF8Encode(char[] cArr, int i, int i2) {
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        while (true) {
            char c = cArr[i];
            if (c > 127) {
                return _shortUTF8Encode2(cArr, i, i2, i3);
            }
            int i4 = i3 + 1;
            bArr[i3] = (byte) c;
            i++;
            if (i >= i2) {
                int i5 = i4 - this._outputTail;
                this._outputTail = i4;
                return i5;
            }
            i3 = i4;
        }
    }

    private final int _shortUTF8Encode2(char[] cArr, int i, int i2, int i3) {
        byte[] bArr = this._outputBuffer;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                bArr[i3] = (byte) c;
                i3++;
                i = i4;
            } else if (c < 2048) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i5 + 1;
                bArr[i5] = (byte) ((c & '?') | 128);
                i = i4;
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                int i6 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((c >> 6) & 63) | 128);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((c & '?') | 128);
                i = i4;
            } else {
                if (c > SURR1_LAST) {
                    _throwIllegalSurrogate(c);
                }
                if (i4 >= i2) {
                    _throwIllegalSurrogate(c);
                }
                i = i4 + 1;
                int _convertSurrogate = _convertSurrogate(c, cArr[i4]);
                if (_convertSurrogate > 1114111) {
                    _throwIllegalSurrogate(_convertSurrogate);
                }
                int i8 = i3 + 1;
                bArr[i3] = (byte) ((_convertSurrogate >> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((_convertSurrogate >> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((_convertSurrogate >> 6) & 63) | 128);
                i3 = i10 + 1;
                bArr[i10] = (byte) ((_convertSurrogate & 63) | 128);
            }
        }
        int i11 = i3 - this._outputTail;
        this._outputTail = i3;
        return i11;
    }

    private void _slowUTF8Encode(String str) {
        char c;
        int length = str.length();
        int i = 0;
        int i2 = this._outputEnd - 4;
        while (i < length) {
            if (this._outputTail >= i2) {
                _flushBuffer();
            }
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                byte[] bArr = this._outputBuffer;
                int i4 = this._outputTail;
                this._outputTail = i4 + 1;
                bArr[i4] = (byte) charAt;
                int i5 = length - i3;
                int i6 = i2 - this._outputTail;
                if (i5 <= i6) {
                    i6 = i5;
                }
                int i7 = i6 + i3;
                while (i3 < i7) {
                    int i8 = i3 + 1;
                    char charAt2 = str.charAt(i3);
                    if (charAt2 > 127) {
                        c = charAt2;
                        i = i8;
                    } else {
                        byte[] bArr2 = this._outputBuffer;
                        int i9 = this._outputTail;
                        this._outputTail = i9 + 1;
                        bArr2[i9] = (byte) charAt2;
                        i3 = i8;
                    }
                }
                i = i3;
            } else {
                i = i3;
                c = charAt;
            }
            if (c < 2048) {
                byte[] bArr3 = this._outputBuffer;
                int i10 = this._outputTail;
                this._outputTail = i10 + 1;
                bArr3[i10] = (byte) ((c >> 6) | 192);
                byte[] bArr4 = this._outputBuffer;
                int i11 = this._outputTail;
                this._outputTail = i11 + 1;
                bArr4[i11] = (byte) ((c & '?') | 128);
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                byte[] bArr5 = this._outputBuffer;
                int i12 = this._outputTail;
                this._outputTail = i12 + 1;
                bArr5[i12] = (byte) ((c >> '\f') | 224);
                byte[] bArr6 = this._outputBuffer;
                int i13 = this._outputTail;
                this._outputTail = i13 + 1;
                bArr6[i13] = (byte) (((c >> 6) & 63) | 128);
                byte[] bArr7 = this._outputBuffer;
                int i14 = this._outputTail;
                this._outputTail = i14 + 1;
                bArr7[i14] = (byte) ((c & '?') | 128);
            } else {
                if (c > SURR1_LAST) {
                    _throwIllegalSurrogate(c);
                }
                if (i >= length) {
                    _throwIllegalSurrogate(c);
                }
                int i15 = i + 1;
                int _convertSurrogate = _convertSurrogate(c, str.charAt(i));
                if (_convertSurrogate > 1114111) {
                    _throwIllegalSurrogate(_convertSurrogate);
                }
                byte[] bArr8 = this._outputBuffer;
                int i16 = this._outputTail;
                this._outputTail = i16 + 1;
                bArr8[i16] = (byte) ((_convertSurrogate >> 18) | 240);
                byte[] bArr9 = this._outputBuffer;
                int i17 = this._outputTail;
                this._outputTail = i17 + 1;
                bArr9[i17] = (byte) (((_convertSurrogate >> 12) & 63) | 128);
                byte[] bArr10 = this._outputBuffer;
                int i18 = this._outputTail;
                this._outputTail = i18 + 1;
                bArr10[i18] = (byte) (((_convertSurrogate >> 6) & 63) | 128);
                byte[] bArr11 = this._outputBuffer;
                int i19 = this._outputTail;
                this._outputTail = i19 + 1;
                bArr11[i19] = (byte) ((_convertSurrogate & 63) | 128);
                i = i15;
            }
        }
    }

    protected static final SmileBufferRecycler<SharedStringNode> _smileBufferRecycler() {
        SoftReference<SmileBufferRecycler<SharedStringNode>> softReference = _smileRecyclerRef.get();
        SmileBufferRecycler<SharedStringNode> smileBufferRecycler = softReference == null ? null : softReference.get();
        if (smileBufferRecycler == null) {
            SmileBufferRecycler<SharedStringNode> smileBufferRecycler2 = new SmileBufferRecycler<>();
            _smileRecyclerRef.set(new SoftReference<>(smileBufferRecycler2));
            return smileBufferRecycler2;
        }
        return smileBufferRecycler;
    }

    private void _throwIllegalSurrogate(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < SURR1_FIRST) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i > SURR1_LAST) {
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }

    private final void _writeByte(byte b) {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
    }

    private final void _writeBytes(byte b, byte b2) {
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = b2;
    }

    private final void _writeBytes(byte b, byte b2, byte b3) {
        if (this._outputTail + 2 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = b2;
        byte[] bArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr3[i3] = b3;
    }

    private final void _writeBytes(byte b, byte b2, byte b3, byte b4) {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = b2;
        byte[] bArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr3[i3] = b3;
        byte[] bArr4 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr4[i4] = b4;
    }

    private final void _writeBytes(byte b, byte b2, byte b3, byte b4, byte b5) {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = b2;
        byte[] bArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr3[i3] = b3;
        byte[] bArr4 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr4[i4] = b4;
        byte[] bArr5 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        bArr5[i5] = b5;
    }

    private final void _writeBytes(byte b, byte b2, byte b3, byte b4, byte b5, byte b6) {
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = b2;
        byte[] bArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr3[i3] = b3;
        byte[] bArr4 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr4[i4] = b4;
        byte[] bArr5 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        bArr5[i5] = b5;
        byte[] bArr6 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr6[i6] = b6;
    }

    private final void _writeBytes(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        if (this._outputTail + i2 >= this._outputEnd) {
            _writeBytesLong(bArr, i, i2);
            return;
        }
        System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i2);
        this._outputTail += i2;
    }

    private final void _writeBytesLong(byte[] bArr, int i, int i2) {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        while (true) {
            int min = Math.min(i2, this._outputEnd - this._outputTail);
            System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, min);
            this._outputTail += min;
            i2 -= min;
            if (i2 == 0) {
                return;
            }
            i += min;
            _flushBuffer();
        }
    }

    private final void _writeFieldName(String str) {
        int _findSeenName;
        byte b = SmileConstants.TOKEN_KEY_LONG_STRING;
        int length = str.length();
        if (length == 0) {
            _writeByte((byte) 32);
        } else if (this._seenNameCount >= 0 && (_findSeenName = _findSeenName(str)) >= 0) {
            _writeSharedNameReference(_findSeenName);
        } else if (length > 56) {
            _writeNonShortFieldName(str, length);
        } else {
            if (this._outputTail + SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING >= this._outputEnd) {
                _flushBuffer();
            }
            str.getChars(0, length, this._charBuffer, 0);
            int i = this._outputTail;
            this._outputTail++;
            int _shortUTF8Encode = _shortUTF8Encode(this._charBuffer, 0, length);
            if (_shortUTF8Encode == length) {
                if (_shortUTF8Encode <= 64) {
                    b = (byte) (_shortUTF8Encode + 127);
                } else {
                    byte[] bArr = this._outputBuffer;
                    int i2 = this._outputTail;
                    this._outputTail = i2 + 1;
                    bArr[i2] = -4;
                }
            } else if (_shortUTF8Encode <= 56) {
                b = (byte) (_shortUTF8Encode + Opcodes.ARRAYLENGTH);
            } else {
                byte[] bArr2 = this._outputBuffer;
                int i3 = this._outputTail;
                this._outputTail = i3 + 1;
                bArr2[i3] = -4;
            }
            this._outputBuffer[i] = b;
            if (this._seenNameCount < 0) {
                return;
            }
            _addSeenName(str);
        }
    }

    private final void _writeNonSharedString(String str, int i) {
        if (i > this._charBufferLength) {
            _writeByte(TOKEN_BYTE_LONG_STRING_UNICODE);
            _slowUTF8Encode(str);
            _writeByte((byte) -4);
            return;
        }
        str.getChars(0, i, this._charBuffer, 0);
        int i2 = i + i + i + 2;
        if (i2 > this._outputBuffer.length) {
            _writeByte(TOKEN_BYTE_LONG_STRING_UNICODE);
            _mediumUTF8Encode(this._charBuffer, 0, i);
            _writeByte((byte) -4);
            return;
        }
        if (i2 + this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        _writeByte(TOKEN_BYTE_LONG_STRING_ASCII);
        if (_shortUTF8Encode(this._charBuffer, 0, i) > i) {
            this._outputBuffer[i3] = TOKEN_BYTE_LONG_STRING_UNICODE;
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr[i4] = -4;
    }

    private final void _writeNonShortFieldName(String str, int i) {
        _writeByte(SmileConstants.TOKEN_KEY_LONG_STRING);
        if (i > this._charBufferLength) {
            _slowUTF8Encode(str);
        } else {
            str.getChars(0, i, this._charBuffer, 0);
            int i2 = i + i + i;
            if (i2 <= this._outputBuffer.length) {
                if (i2 + this._outputTail >= this._outputEnd) {
                    _flushBuffer();
                }
                _shortUTF8Encode(this._charBuffer, 0, i);
            } else {
                _mediumUTF8Encode(this._charBuffer, 0, i);
            }
        }
        if (this._seenNameCount >= 0) {
            _addSeenName(str);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = -4;
    }

    private void _writePositiveVInt(int i) {
        _ensureRoomForOutput(5);
        byte b = (byte) ((i & 63) + 128);
        int i2 = i >> 6;
        if (i2 <= 127) {
            if (i2 > 0) {
                byte[] bArr = this._outputBuffer;
                int i3 = this._outputTail;
                this._outputTail = i3 + 1;
                bArr[i3] = (byte) i2;
            }
            byte[] bArr2 = this._outputBuffer;
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            bArr2[i4] = b;
            return;
        }
        byte b2 = (byte) (i2 & 127);
        int i5 = i2 >> 7;
        if (i5 <= 127) {
            byte[] bArr3 = this._outputBuffer;
            int i6 = this._outputTail;
            this._outputTail = i6 + 1;
            bArr3[i6] = (byte) i5;
            byte[] bArr4 = this._outputBuffer;
            int i7 = this._outputTail;
            this._outputTail = i7 + 1;
            bArr4[i7] = b2;
            byte[] bArr5 = this._outputBuffer;
            int i8 = this._outputTail;
            this._outputTail = i8 + 1;
            bArr5[i8] = b;
            return;
        }
        byte b3 = (byte) (i5 & 127);
        int i9 = i5 >> 7;
        if (i9 <= 127) {
            byte[] bArr6 = this._outputBuffer;
            int i10 = this._outputTail;
            this._outputTail = i10 + 1;
            bArr6[i10] = (byte) i9;
            byte[] bArr7 = this._outputBuffer;
            int i11 = this._outputTail;
            this._outputTail = i11 + 1;
            bArr7[i11] = b3;
            byte[] bArr8 = this._outputBuffer;
            int i12 = this._outputTail;
            this._outputTail = i12 + 1;
            bArr8[i12] = b2;
            byte[] bArr9 = this._outputBuffer;
            int i13 = this._outputTail;
            this._outputTail = i13 + 1;
            bArr9[i13] = b;
            return;
        }
        byte[] bArr10 = this._outputBuffer;
        int i14 = this._outputTail;
        this._outputTail = i14 + 1;
        bArr10[i14] = (byte) (i9 >> 7);
        byte[] bArr11 = this._outputBuffer;
        int i15 = this._outputTail;
        this._outputTail = i15 + 1;
        bArr11[i15] = (byte) (i9 & 127);
        byte[] bArr12 = this._outputBuffer;
        int i16 = this._outputTail;
        this._outputTail = i16 + 1;
        bArr12[i16] = b3;
        byte[] bArr13 = this._outputBuffer;
        int i17 = this._outputTail;
        this._outputTail = i17 + 1;
        bArr13[i17] = b2;
        byte[] bArr14 = this._outputBuffer;
        int i18 = this._outputTail;
        this._outputTail = i18 + 1;
        bArr14[i18] = b;
    }

    private final void _writeSharedNameReference(int i) {
        if (i >= this._seenNameCount) {
            throw new IllegalArgumentException("Internal error: trying to write shared name with index " + i + "; but have only seen " + this._seenNameCount + " so far!");
        }
        if (i < 64) {
            _writeByte((byte) (i + 64));
        } else {
            _writeBytes((byte) ((i >> 8) + 48), (byte) i);
        }
    }

    private final void _writeSharedStringValueReference(int i) {
        if (i >= this._seenStringValueCount) {
            throw new IllegalArgumentException("Internal error: trying to write shared String value with index " + i + "; but have only seen " + this._seenStringValueCount + " so far!");
        }
        if (i < 31) {
            _writeByte((byte) (i + 1));
        } else {
            _writeBytes((byte) ((i >> 8) + SmileConstants.TOKEN_MISC_SHARED_STRING_LONG), (byte) i);
        }
    }

    private void _writeSignedVInt(int i) {
        _writePositiveVInt(SmileUtil.zigzagEncode(i));
    }

    protected final void _flushBuffer() {
        if (this._outputTail > 0) {
            this._bytesWritten += this._outputTail;
            this._out.write(this._outputBuffer, 0, this._outputTail);
            this._outputTail = 0;
        }
    }

    protected UnsupportedOperationException _notSupported() {
        return new UnsupportedOperationException();
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase
    protected void _releaseBuffers() {
        byte[] bArr = this._outputBuffer;
        if (bArr != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(bArr);
        }
        char[] cArr = this._charBuffer;
        if (cArr != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
        SharedStringNode[] sharedStringNodeArr = this._seenNames;
        if (sharedStringNodeArr != null && sharedStringNodeArr.length == 64) {
            this._seenNames = null;
            this._smileBufferRecycler.releaseSeenNamesBuffer(sharedStringNodeArr);
        }
        SharedStringNode[] sharedStringNodeArr2 = this._seenStringValues;
        if (sharedStringNodeArr2 == null || sharedStringNodeArr2.length != 64) {
            return;
        }
        this._seenStringValues = null;
        this._smileBufferRecycler.releaseSeenStringValuesBuffer(sharedStringNodeArr2);
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase
    protected final void _verifyValueWrite(String str) {
        if (this._writeContext.writeValue() == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
    }

    protected void _write7BitBinaryWithLength(byte[] bArr, int i, int i2) {
        _writePositiveVInt(i2);
        while (i2 >= 7) {
            if (this._outputTail + 8 >= this._outputEnd) {
                _flushBuffer();
            }
            int i3 = i + 1;
            byte b = bArr[i];
            byte[] bArr2 = this._outputBuffer;
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            bArr2[i4] = (byte) ((b >> 1) & 127);
            int i5 = i3 + 1;
            int i6 = (bArr[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | (b << 8);
            byte[] bArr3 = this._outputBuffer;
            int i7 = this._outputTail;
            this._outputTail = i7 + 1;
            bArr3[i7] = (byte) ((i6 >> 2) & 127);
            int i8 = i5 + 1;
            int i9 = (i6 << 8) | (bArr[i5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr4 = this._outputBuffer;
            int i10 = this._outputTail;
            this._outputTail = i10 + 1;
            bArr4[i10] = (byte) ((i9 >> 3) & 127);
            int i11 = i8 + 1;
            int i12 = (i9 << 8) | (bArr[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr5 = this._outputBuffer;
            int i13 = this._outputTail;
            this._outputTail = i13 + 1;
            bArr5[i13] = (byte) ((i12 >> 4) & 127);
            int i14 = i11 + 1;
            int i15 = (i12 << 8) | (bArr[i11] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr6 = this._outputBuffer;
            int i16 = this._outputTail;
            this._outputTail = i16 + 1;
            bArr6[i16] = (byte) ((i15 >> 5) & 127);
            int i17 = i14 + 1;
            int i18 = (i15 << 8) | (bArr[i14] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr7 = this._outputBuffer;
            int i19 = this._outputTail;
            this._outputTail = i19 + 1;
            bArr7[i19] = (byte) ((i18 >> 6) & 127);
            i = i17 + 1;
            int i20 = (i18 << 8) | (bArr[i17] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr8 = this._outputBuffer;
            int i21 = this._outputTail;
            this._outputTail = i21 + 1;
            bArr8[i21] = (byte) ((i20 >> 7) & 127);
            byte[] bArr9 = this._outputBuffer;
            int i22 = this._outputTail;
            this._outputTail = i22 + 1;
            bArr9[i22] = (byte) (i20 & 127);
            i2 -= 7;
        }
        if (i2 > 0) {
            if (this._outputTail + 7 >= this._outputEnd) {
                _flushBuffer();
            }
            int i23 = i + 1;
            byte b2 = bArr[i];
            byte[] bArr10 = this._outputBuffer;
            int i24 = this._outputTail;
            this._outputTail = i24 + 1;
            bArr10[i24] = (byte) ((b2 >> 1) & 127);
            if (i2 <= 1) {
                byte[] bArr11 = this._outputBuffer;
                int i25 = this._outputTail;
                this._outputTail = i25 + 1;
                bArr11[i25] = (byte) (b2 & 1);
                return;
            }
            int i26 = i23 + 1;
            int i27 = (bArr[i23] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((b2 & 1) << 8);
            byte[] bArr12 = this._outputBuffer;
            int i28 = this._outputTail;
            this._outputTail = i28 + 1;
            bArr12[i28] = (byte) ((i27 >> 2) & 127);
            if (i2 <= 2) {
                byte[] bArr13 = this._outputBuffer;
                int i29 = this._outputTail;
                this._outputTail = i29 + 1;
                bArr13[i29] = (byte) (i27 & 3);
                return;
            }
            int i30 = i26 + 1;
            int i31 = ((i27 & 3) << 8) | (bArr[i26] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr14 = this._outputBuffer;
            int i32 = this._outputTail;
            this._outputTail = i32 + 1;
            bArr14[i32] = (byte) ((i31 >> 3) & 127);
            if (i2 <= 3) {
                byte[] bArr15 = this._outputBuffer;
                int i33 = this._outputTail;
                this._outputTail = i33 + 1;
                bArr15[i33] = (byte) (i31 & 7);
                return;
            }
            int i34 = i30 + 1;
            int i35 = ((i31 & 7) << 8) | (bArr[i30] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr16 = this._outputBuffer;
            int i36 = this._outputTail;
            this._outputTail = i36 + 1;
            bArr16[i36] = (byte) ((i35 >> 4) & 127);
            if (i2 <= 4) {
                byte[] bArr17 = this._outputBuffer;
                int i37 = this._outputTail;
                this._outputTail = i37 + 1;
                bArr17[i37] = (byte) (i35 & 15);
                return;
            }
            int i38 = i34 + 1;
            int i39 = ((i35 & 15) << 8) | (bArr[i34] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr18 = this._outputBuffer;
            int i40 = this._outputTail;
            this._outputTail = i40 + 1;
            bArr18[i40] = (byte) ((i39 >> 5) & 127);
            if (i2 <= 5) {
                byte[] bArr19 = this._outputBuffer;
                int i41 = this._outputTail;
                this._outputTail = i41 + 1;
                bArr19[i41] = (byte) (i39 & 31);
                return;
            }
            int i42 = i38 + 1;
            int i43 = ((i39 & 31) << 8) | (bArr[i38] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            byte[] bArr20 = this._outputBuffer;
            int i44 = this._outputTail;
            this._outputTail = i44 + 1;
            bArr20[i44] = (byte) ((i43 >> 6) & 127);
            byte[] bArr21 = this._outputBuffer;
            int i45 = this._outputTail;
            this._outputTail = i45 + 1;
            bArr21[i45] = (byte) (i43 & 63);
        }
    }

    protected final void _writeFieldName(SerializableString serializableString) {
        int _findSeenName;
        int charLength = serializableString.charLength();
        if (charLength == 0) {
            _writeByte((byte) 32);
            return;
        }
        byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = asUnquotedUTF8.length;
        if (length != charLength) {
            _writeFieldNameUnicode(serializableString, asUnquotedUTF8);
        } else if (this._seenNameCount >= 0 && (_findSeenName = _findSeenName(serializableString.getValue())) >= 0) {
            _writeSharedNameReference(_findSeenName);
        } else if (length <= 64) {
            if (this._outputTail + length >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) (length + 127);
            System.arraycopy(asUnquotedUTF8, 0, this._outputBuffer, this._outputTail, length);
            this._outputTail += length;
            if (this._seenNameCount < 0) {
                return;
            }
            _addSeenName(serializableString.getValue());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = SmileConstants.TOKEN_KEY_LONG_STRING;
            if (this._outputTail + length + 1 < this._outputEnd) {
                System.arraycopy(asUnquotedUTF8, 0, this._outputBuffer, this._outputTail, length);
                this._outputTail += length;
            } else {
                _flushBuffer();
                if (length < 770) {
                    System.arraycopy(asUnquotedUTF8, 0, this._outputBuffer, this._outputTail, length);
                    this._outputTail += length;
                } else {
                    if (this._outputTail > 0) {
                        _flushBuffer();
                    }
                    this._out.write(asUnquotedUTF8, 0, length);
                }
            }
            byte[] bArr3 = this._outputBuffer;
            int i3 = this._outputTail;
            this._outputTail = i3 + 1;
            bArr3[i3] = -4;
            if (this._seenNameCount < 0) {
                return;
            }
            _addSeenName(serializableString.getValue());
        }
    }

    protected final void _writeFieldNameUnicode(SerializableString serializableString, byte[] bArr) {
        int _findSeenName;
        if (this._seenNameCount >= 0 && (_findSeenName = _findSeenName(serializableString.getValue())) >= 0) {
            _writeSharedNameReference(_findSeenName);
            return;
        }
        int length = bArr.length;
        if (length <= 56) {
            if (this._outputTail + length >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr2[i] = (byte) (length + Opcodes.ARRAYLENGTH);
            System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
            this._outputTail = length + this._outputTail;
            if (this._seenNameCount < 0) {
                return;
            }
            _addSeenName(serializableString.getValue());
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr3[i2] = SmileConstants.TOKEN_KEY_LONG_STRING;
        if (this._outputTail + length + 1 < this._outputEnd) {
            System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
            this._outputTail = length + this._outputTail;
        } else {
            _flushBuffer();
            if (length < 770) {
                System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
                this._outputTail = length + this._outputTail;
            } else {
                if (this._outputTail > 0) {
                    _flushBuffer();
                }
                this._out.write(bArr, 0, length);
            }
        }
        byte[] bArr4 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr4[i3] = -4;
        if (this._seenNameCount < 0) {
            return;
        }
        _addSeenName(serializableString.getValue());
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean z = this._closed;
        super.close();
        if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonWriteContext outputContext = getOutputContext();
                if (!outputContext.inArray()) {
                    if (!outputContext.inObject()) {
                        break;
                    }
                    writeEndObject();
                } else {
                    writeEndArray();
                }
            }
        }
        if (!z && isEnabled(Feature.WRITE_END_MARKER)) {
            _writeByte((byte) -1);
        }
        _flushBuffer();
        if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
            this._out.close();
        } else {
            this._out.flush();
        }
        _releaseBuffers();
    }

    public SmileGenerator configure(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    public SmileGenerator disable(Feature feature) {
        this._smileFeatures &= feature.getMask() ^ (-1);
        return this;
    }

    public SmileGenerator enable(Feature feature) {
        this._smileFeatures |= feature.getMask();
        return this;
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public final void flush() {
        _flushBuffer();
        if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._out.flush();
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public Object getOutputTarget() {
        return this._out;
    }

    public final boolean isEnabled(Feature feature) {
        return (this._smileFeatures & feature.getMask()) != 0;
    }

    protected long outputOffset() {
        return this._bytesWritten + this._outputTail;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        return this;
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public JsonGenerator useDefaultPrettyPrinter() {
        return this;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write Binary value");
        if (isEnabled(Feature.ENCODE_BINARY_AS_7BIT)) {
            _writeByte((byte) -24);
            _write7BitBinaryWithLength(bArr, i, i2);
            return;
        }
        _writeByte((byte) -3);
        _writePositiveVInt(i2);
        _writeBytes(bArr, i, i2);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeBoolean(boolean z) {
        _verifyValueWrite("write boolean value");
        if (z) {
            _writeByte(SmileConstants.TOKEN_LITERAL_TRUE);
        } else {
            _writeByte(SmileConstants.TOKEN_LITERAL_FALSE);
        }
    }

    public void writeBytes(byte[] bArr, int i, int i2) {
        _writeBytes(bArr, i, i2);
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public final void writeEndArray() {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            _writeByte((byte) -7);
        }
        this._writeContext = this._writeContext.mo22000getParent();
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public final void writeEndObject() {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        this._writeContext = this._writeContext.mo22000getParent();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            _writeByte((byte) -5);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeFieldName(String str) {
        if (this._writeContext.writeFieldName(str) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) {
        if (this._writeContext.writeFieldName(serializableString.getValue()) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeFieldName(SerializedString serializedString) {
        if (this._writeContext.writeFieldName(serializedString.getValue()) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializedString);
    }

    public void writeHeader() {
        int i = 0;
        if ((this._smileFeatures & Feature.CHECK_SHARED_NAMES.getMask()) != 0) {
            i = 1;
        }
        if ((this._smileFeatures & Feature.CHECK_SHARED_STRING_VALUES.getMask()) != 0) {
            i |= 2;
        }
        if ((this._smileFeatures & Feature.ENCODE_BINARY_AS_7BIT.getMask()) == 0) {
            i |= 4;
        }
        _writeBytes(SmileConstants.HEADER_BYTE_1, (byte) 41, (byte) 10, (byte) i);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNull() {
        _verifyValueWrite("write null value");
        _writeByte(SmileConstants.TOKEN_LITERAL_NULL);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(double d) {
        _ensureRoomForOutput(11);
        _verifyValueWrite("write number");
        long doubleToRawLongBits = Double.doubleToRawLongBits(d);
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = 41;
        int i2 = (int) (doubleToRawLongBits >>> 35);
        this._outputBuffer[this._outputTail + 4] = (byte) (i2 & 127);
        int i3 = i2 >> 7;
        this._outputBuffer[this._outputTail + 3] = (byte) (i3 & 127);
        int i4 = i3 >> 7;
        this._outputBuffer[this._outputTail + 2] = (byte) (i4 & 127);
        int i5 = i4 >> 7;
        this._outputBuffer[this._outputTail + 1] = (byte) (i5 & 127);
        this._outputBuffer[this._outputTail] = (byte) (i5 >> 7);
        this._outputTail += 5;
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr2[i6] = (byte) (((int) (doubleToRawLongBits >> 28)) & 127);
        int i7 = (int) doubleToRawLongBits;
        this._outputBuffer[this._outputTail + 3] = (byte) (i7 & 127);
        int i8 = i7 >> 7;
        this._outputBuffer[this._outputTail + 2] = (byte) (i8 & 127);
        int i9 = i8 >> 7;
        this._outputBuffer[this._outputTail + 1] = (byte) (i9 & 127);
        this._outputBuffer[this._outputTail] = (byte) ((i9 >> 7) & 127);
        this._outputTail += 4;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(float f) {
        _ensureRoomForOutput(6);
        _verifyValueWrite("write number");
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = TOKEN_BYTE_FLOAT_32;
        this._outputBuffer[this._outputTail + 4] = (byte) (floatToRawIntBits & 127);
        int i2 = floatToRawIntBits >> 7;
        this._outputBuffer[this._outputTail + 3] = (byte) (i2 & 127);
        int i3 = i2 >> 7;
        this._outputBuffer[this._outputTail + 2] = (byte) (i3 & 127);
        int i4 = i3 >> 7;
        this._outputBuffer[this._outputTail + 1] = (byte) (i4 & 127);
        this._outputBuffer[this._outputTail] = (byte) ((i4 >> 7) & 127);
        this._outputTail += 5;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(int i) {
        _verifyValueWrite("write number");
        int zigzagEncode = SmileUtil.zigzagEncode(i);
        if (zigzagEncode <= 63 && zigzagEncode >= 0) {
            if (zigzagEncode <= 31) {
                _writeByte((byte) (zigzagEncode + 192));
                return;
            } else {
                _writeBytes(TOKEN_BYTE_INT_32, (byte) (zigzagEncode + 128));
                return;
            }
        }
        byte b = (byte) ((zigzagEncode & 63) + 128);
        int i2 = zigzagEncode >>> 6;
        if (i2 <= 127) {
            _writeBytes(TOKEN_BYTE_INT_32, (byte) i2, b);
            return;
        }
        byte b2 = (byte) (i2 & 127);
        int i3 = i2 >> 7;
        if (i3 <= 127) {
            _writeBytes(TOKEN_BYTE_INT_32, (byte) i3, b2, b);
            return;
        }
        byte b3 = (byte) (i3 & 127);
        int i4 = i3 >> 7;
        if (i4 <= 127) {
            _writeBytes(TOKEN_BYTE_INT_32, (byte) i4, b3, b2, b);
            return;
        }
        _writeBytes(TOKEN_BYTE_INT_32, (byte) (i4 >> 7), (byte) (i4 & 127), b3, b2, b);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(long j) {
        if (j <= MAX_INT_AS_LONG && j >= MIN_INT_AS_LONG) {
            writeNumber((int) j);
            return;
        }
        _verifyValueWrite("write number");
        long zigzagEncode = SmileUtil.zigzagEncode(j);
        int i = (int) zigzagEncode;
        byte b = (byte) ((i & 63) + 128);
        byte b2 = (byte) ((i >> 6) & 127);
        byte b3 = (byte) ((i >> 13) & 127);
        byte b4 = (byte) ((i >> 20) & 127);
        long j2 = zigzagEncode >>> 27;
        byte b5 = (byte) (((int) j2) & 127);
        int i2 = (int) (j2 >> 7);
        if (i2 == 0) {
            _writeBytes(TOKEN_BYTE_INT_64, b5, b4, b3, b2, b);
        } else if (i2 <= 127) {
            _writeBytes(TOKEN_BYTE_INT_64, (byte) i2);
            _writeBytes(b5, b4, b3, b2, b);
        } else {
            byte b6 = (byte) (i2 & 127);
            int i3 = i2 >> 7;
            if (i3 <= 127) {
                _writeBytes(TOKEN_BYTE_INT_64, (byte) i3);
                _writeBytes(b6, b5, b4, b3, b2, b);
                return;
            }
            byte b7 = (byte) (i3 & 127);
            int i4 = i3 >> 7;
            if (i4 <= 127) {
                _writeBytes(TOKEN_BYTE_INT_64, (byte) i4, b7);
                _writeBytes(b6, b5, b4, b3, b2, b);
                return;
            }
            byte b8 = (byte) (i4 & 127);
            int i5 = i4 >> 7;
            if (i5 <= 127) {
                _writeBytes(TOKEN_BYTE_INT_64, (byte) i5, b8, b7);
                _writeBytes(b6, b5, b4, b3, b2, b);
                return;
            }
            _writeBytes(TOKEN_BYTE_INT_64, (byte) (i5 >> 7), (byte) (i5 & 127), b8, b7);
            _writeBytes(b6, b5, b4, b3, b2, b);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(String str) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write number");
        _writeByte(TOKEN_BYTE_BIG_DECIMAL);
        _writeSignedVInt(bigDecimal.scale());
        byte[] byteArray = bigDecimal.unscaledValue().toByteArray();
        _write7BitBinaryWithLength(byteArray, 0, byteArray.length);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(BigInteger bigInteger) {
        if (bigInteger == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write number");
        _writeByte(TOKEN_BYTE_BIG_INTEGER);
        byte[] byteArray = bigInteger.toByteArray();
        _write7BitBinaryWithLength(byteArray, 0, byteArray.length);
    }

    public void writeRaw(byte b) {
        _writeByte((byte) -8);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(char c) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(String str) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(String str, int i, int i2) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) {
        _verifyValueWrite("write String value");
        if (i2 == 0) {
            _writeByte((byte) 32);
        } else if (this._seenStringValueCount >= 0) {
            throw new UnsupportedOperationException("Can not use direct UTF-8 write methods when 'Feature.CHECK_SHARED_STRING_VALUES' enabled");
        } else {
            if (i2 <= 65) {
                if (this._outputTail + i2 >= this._outputEnd) {
                    _flushBuffer();
                }
                if (i2 != 1) {
                    byte[] bArr2 = this._outputBuffer;
                    int i3 = this._outputTail;
                    this._outputTail = i3 + 1;
                    bArr2[i3] = (byte) (i2 + 126);
                    System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i2);
                    this._outputTail += i2;
                    return;
                }
                byte[] bArr3 = this._outputBuffer;
                int i4 = this._outputTail;
                this._outputTail = i4 + 1;
                bArr3[i4] = 64;
                byte[] bArr4 = this._outputBuffer;
                int i5 = this._outputTail;
                this._outputTail = i5 + 1;
                bArr4[i5] = bArr[i];
                return;
            }
            int i6 = i2 + i2 + i2 + 2;
            if (i6 > this._outputBuffer.length) {
                _writeByte(TOKEN_BYTE_LONG_STRING_UNICODE);
                _writeBytes(bArr, i, i2);
                _writeByte((byte) -4);
                return;
            }
            if (i6 + this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr5 = this._outputBuffer;
            int i7 = this._outputTail;
            this._outputTail = i7 + 1;
            bArr5[i7] = TOKEN_BYTE_LONG_STRING_UNICODE;
            System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i2);
            this._outputTail += i2;
            byte[] bArr6 = this._outputBuffer;
            int i8 = this._outputTail;
            this._outputTail = i8 + 1;
            bArr6[i8] = -4;
        }
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public void writeRawValue(String str) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public void writeRawValue(String str, int i, int i2) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) {
        throw _notSupported();
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public final void writeStartArray() {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
        } else {
            _writeByte((byte) -8);
        }
    }

    @Override // org.codehaus.jackson.impl.JsonGeneratorBase, org.codehaus.jackson.JsonGenerator
    public final void writeStartObject() {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
        } else {
            _writeByte((byte) -6);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeString(String str) {
        int _findSeenStringValue;
        if (str == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write String value");
        int length = str.length();
        if (length == 0) {
            _writeByte((byte) 32);
        } else if (length > 65) {
            _writeNonSharedString(str, length);
        } else if (this._seenStringValueCount >= 0 && (_findSeenStringValue = _findSeenStringValue(str)) >= 0) {
            _writeSharedStringValueReference(_findSeenStringValue);
        } else {
            if (this._outputTail + SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING >= this._outputEnd) {
                _flushBuffer();
            }
            str.getChars(0, length, this._charBuffer, 0);
            int i = this._outputTail;
            this._outputTail++;
            int _shortUTF8Encode = _shortUTF8Encode(this._charBuffer, 0, length);
            if (_shortUTF8Encode > 64) {
                this._outputBuffer[i] = _shortUTF8Encode == length ? TOKEN_BYTE_LONG_STRING_ASCII : TOKEN_BYTE_LONG_STRING_UNICODE;
                byte[] bArr = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr[i2] = -4;
                return;
            }
            if (this._seenStringValueCount >= 0) {
                _addSeenStringValue(str);
            }
            if (_shortUTF8Encode == length) {
                this._outputBuffer[i] = (byte) (_shortUTF8Encode + 63);
            } else {
                this._outputBuffer[i] = (byte) (_shortUTF8Encode + 126);
            }
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeString(SerializableString serializableString) {
        int _findSeenStringValue;
        _verifyValueWrite("write String value");
        String value = serializableString.getValue();
        int length = value.length();
        if (length == 0) {
            _writeByte((byte) 32);
        } else if (length <= 65 && this._seenStringValueCount >= 0 && (_findSeenStringValue = _findSeenStringValue(value)) >= 0) {
            _writeSharedStringValueReference(_findSeenStringValue);
        } else {
            byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
            int length2 = asUnquotedUTF8.length;
            if (length2 > 64) {
                _writeByte(length2 == length ? TOKEN_BYTE_LONG_STRING_ASCII : TOKEN_BYTE_LONG_STRING_UNICODE);
                _writeBytes(asUnquotedUTF8, 0, asUnquotedUTF8.length);
                _writeByte((byte) -4);
                return;
            }
            if (this._outputTail + length2 + 1 >= this._outputEnd) {
                _flushBuffer();
            }
            int i = length2 == length ? length2 + 63 : length2 + 126;
            byte[] bArr = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr[i2] = (byte) i;
            System.arraycopy(asUnquotedUTF8, 0, this._outputBuffer, this._outputTail, length2);
            this._outputTail += length2;
            if (this._seenStringValueCount < 0) {
                return;
            }
            _addSeenStringValue(serializableString.getValue());
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) {
        byte b = TOKEN_BYTE_LONG_STRING_UNICODE;
        if (i2 <= 65 && this._seenStringValueCount >= 0 && i2 > 0) {
            writeString(new String(cArr, i, i2));
            return;
        }
        _verifyValueWrite("write String value");
        if (i2 == 0) {
            _writeByte((byte) 32);
        } else if (i2 <= 64) {
            if (this._outputTail + SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING >= this._outputEnd) {
                _flushBuffer();
            }
            int i3 = this._outputTail;
            this._outputTail++;
            int _shortUTF8Encode = _shortUTF8Encode(cArr, i, i + i2);
            if (_shortUTF8Encode <= 64) {
                b = _shortUTF8Encode == i2 ? (byte) (_shortUTF8Encode + 63) : (byte) (_shortUTF8Encode + 126);
            } else {
                byte[] bArr = this._outputBuffer;
                int i4 = this._outputTail;
                this._outputTail = i4 + 1;
                bArr[i4] = -4;
            }
            this._outputBuffer[i3] = b;
        } else {
            int i5 = i2 + i2 + i2 + 2;
            if (i5 > this._outputBuffer.length) {
                _writeByte(TOKEN_BYTE_LONG_STRING_UNICODE);
                _mediumUTF8Encode(cArr, i, i + i2);
                _writeByte((byte) -4);
                return;
            }
            if (i5 + this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            int i6 = this._outputTail;
            _writeByte(TOKEN_BYTE_LONG_STRING_UNICODE);
            if (_shortUTF8Encode(cArr, i, i + i2) == i2) {
                this._outputBuffer[i6] = TOKEN_BYTE_LONG_STRING_ASCII;
            }
            byte[] bArr2 = this._outputBuffer;
            int i7 = this._outputTail;
            this._outputTail = i7 + 1;
            bArr2[i7] = -4;
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeStringField(String str, String str2) {
        if (this._writeContext.writeFieldName(str) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str);
        writeString(str2);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeUTF8String(byte[] bArr, int i, int i2) {
        writeRawUTF8String(bArr, i, i2);
    }
}
