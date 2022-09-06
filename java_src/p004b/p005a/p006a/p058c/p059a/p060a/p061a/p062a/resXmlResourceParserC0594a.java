package p004b.p005a.p006a.p058c.p059a.p060a.p061a.p062a;

import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParserException;
import p004b.p005a.p006a.p058c.p059a.p060a.C0593a;
import p004b.p005a.p006a.p058c.p059a.p060a.p061a.p063b.C0598a;
import p004b.p005a.p006a.p058c.p059a.p065c.C0601b;
import p004b.p005a.p006a.p058c.p066b.p067a.p068a.C0602a;
/* renamed from: b.a.a.c.a.a.a.a.a  reason: invalid class name */
/* loaded from: classes.dex */
public class resXmlResourceParserC0594a implements XmlResourceParser {

    /* renamed from: A */
    private static final int f1322A = 1048832;

    /* renamed from: B */
    private static final int f1323B = 1048832;

    /* renamed from: C */
    private static final int f1324C = 1048833;

    /* renamed from: D */
    private static final int f1325D = 1048834;

    /* renamed from: E */
    private static final int f1326E = 1048835;

    /* renamed from: F */
    private static final int f1327F = 1048836;

    /* renamed from: G */
    private static final int f1328G = 1048836;

    /* renamed from: q */
    private static final Logger f1329q = Logger.getLogger(resXmlResourceParserC0594a.class.getName());

    /* renamed from: r */
    private static final String f1330r = "Method is not supported.";

    /* renamed from: s */
    private static final int f1331s = 0;

    /* renamed from: t */
    private static final int f1332t = 1;

    /* renamed from: u */
    private static final int f1333u = 2;

    /* renamed from: v */
    private static final int f1334v = 3;

    /* renamed from: w */
    private static final int f1335w = 4;

    /* renamed from: x */
    private static final int f1336x = 5;

    /* renamed from: y */
    private static final int f1337y = 524291;

    /* renamed from: z */
    private static final int f1338z = 524672;

    /* renamed from: a */
    private C0601b f1339a;

    /* renamed from: b */
    private C0596b f1340b;

    /* renamed from: c */
    private C0593a f1341c;

    /* renamed from: d */
    private boolean f1342d;

    /* renamed from: e */
    private C0597c f1343e;

    /* renamed from: f */
    private int[] f1344f;

    /* renamed from: g */
    private C0595a f1345g;

    /* renamed from: h */
    private boolean f1346h;

    /* renamed from: i */
    private int f1347i;

    /* renamed from: j */
    private int f1348j;

    /* renamed from: k */
    private int f1349k;

    /* renamed from: l */
    private int f1350l;

    /* renamed from: m */
    private int[] f1351m;

    /* renamed from: n */
    private int f1352n;

    /* renamed from: o */
    private int f1353o;

    /* renamed from: p */
    private int f1354p;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b.a.a.c.a.a.a.a.a$a */
    /* loaded from: classes.dex */
    public static final class C0595a {

        /* renamed from: a */
        private int[] f1355a = new int[32];

        /* renamed from: b */
        private int f1356b;

        /* renamed from: c */
        private int f1357c;

        /* renamed from: d */
        private int f1358d;

        /* renamed from: a */
        private final int m20022a(int i, boolean z) {
            if (this.f1356b == 0) {
                return -1;
            }
            int i2 = this.f1356b - 1;
            for (int i3 = this.f1358d; i3 != 0; i3--) {
                i2 -= 2;
                for (int i4 = this.f1355a[i2]; i4 != 0; i4--) {
                    if (z) {
                        if (this.f1355a[i2] == i) {
                            return this.f1355a[i2 + 1];
                        }
                    } else if (this.f1355a[i2 + 1] == i) {
                        return this.f1355a[i2];
                    }
                    i2 -= 2;
                }
            }
            return -1;
        }

        /* renamed from: b */
        private final int m20018b(int i, boolean z) {
            if (this.f1356b == 0 || i < 0) {
                return -1;
            }
            int i2 = 0;
            for (int i3 = this.f1358d; i3 != 0; i3--) {
                int i4 = this.f1355a[i2];
                if (i < i4) {
                    int i5 = (i * 2) + 1 + i2;
                    if (!z) {
                        i5++;
                    }
                    return this.f1355a[i5];
                }
                i -= i4;
                i2 += (i4 * 2) + 2;
            }
            return -1;
        }

        /* renamed from: f */
        private void m20010f(int i) {
            int length = this.f1355a.length - this.f1356b;
            if (length > i) {
                return;
            }
            int[] iArr = new int[(length + this.f1355a.length) * 2];
            System.arraycopy(this.f1355a, 0, iArr, 0, this.f1356b);
            this.f1355a = iArr;
        }

        /* renamed from: a */
        public final int m20024a(int i) {
            int i2 = 0;
            if (this.f1356b != 0 && i >= 0) {
                if (i > this.f1358d) {
                    i = this.f1358d;
                }
                int i3 = 0;
                while (i != 0) {
                    int i4 = this.f1355a[i3];
                    i--;
                    i3 = (i4 * 2) + 2 + i3;
                    i2 += i4;
                }
            }
            return i2;
        }

        /* renamed from: a */
        public final void m20025a() {
            this.f1356b = 0;
            this.f1357c = 0;
            this.f1358d = 0;
        }

        /* renamed from: a */
        public final void m20023a(int i, int i2) {
            if (this.f1358d == 0) {
                m20011f();
            }
            m20010f(2);
            int i3 = this.f1356b - 1;
            int i4 = this.f1355a[i3];
            this.f1355a[(i3 - 1) - (i4 * 2)] = i4 + 1;
            this.f1355a[i3] = i;
            this.f1355a[i3 + 1] = i2;
            this.f1355a[i3 + 2] = i4 + 1;
            this.f1356b += 2;
            this.f1357c++;
        }

        /* renamed from: b */
        public final int m20021b() {
            return this.f1357c;
        }

        /* renamed from: b */
        public final int m20020b(int i) {
            return m20018b(i, true);
        }

        /* renamed from: b */
        public final boolean m20019b(int i, int i2) {
            if (this.f1356b == 0) {
                return false;
            }
            int i3 = this.f1356b - 1;
            int i4 = this.f1355a[i3];
            int i5 = i3 - 2;
            int i6 = 0;
            while (i6 != i4) {
                if (this.f1355a[i5] == i && this.f1355a[i5 + 1] == i2) {
                    int i7 = i4 - 1;
                    if (i6 == 0) {
                        this.f1355a[i5] = i7;
                        this.f1355a[i5 - ((i7 * 2) + 1)] = i7;
                    } else {
                        this.f1355a[i3] = i7;
                        this.f1355a[i3 - ((i7 * 2) + 3)] = i7;
                        System.arraycopy(this.f1355a, i5 + 2, this.f1355a, i5, this.f1356b - i5);
                    }
                    this.f1356b -= 2;
                    this.f1357c--;
                    return true;
                }
                i6++;
                i5 -= 2;
            }
            return false;
        }

        /* renamed from: c */
        public final int m20017c() {
            if (this.f1356b == 0) {
                return 0;
            }
            return this.f1355a[this.f1356b - 1];
        }

        /* renamed from: c */
        public final int m20016c(int i) {
            return m20018b(i, false);
        }

        /* renamed from: d */
        public final int m20014d(int i) {
            return m20022a(i, false);
        }

        /* renamed from: d */
        public final boolean m20015d() {
            int i;
            int i2;
            if (this.f1356b == 0 || (i2 = this.f1355a[this.f1356b - 1]) == 0) {
                return false;
            }
            int i3 = i2 - 1;
            int i4 = i - 2;
            this.f1355a[i4] = i3;
            this.f1355a[i4 - ((i3 * 2) + 1)] = i3;
            this.f1356b -= 2;
            this.f1357c--;
            return true;
        }

        /* renamed from: e */
        public final int m20013e() {
            return this.f1358d;
        }

        /* renamed from: e */
        public final int m20012e(int i) {
            return m20022a(i, true);
        }

        /* renamed from: f */
        public final void m20011f() {
            m20010f(2);
            int i = this.f1356b;
            this.f1355a[i] = 0;
            this.f1355a[i + 1] = 0;
            this.f1356b += 2;
            this.f1358d++;
        }

        /* renamed from: g */
        public final void m20009g() {
            if (this.f1356b == 0) {
                return;
            }
            int i = this.f1356b - 1;
            int i2 = this.f1355a[i];
            if ((i - 1) - (i2 * 2) == 0) {
                return;
            }
            this.f1356b -= (i2 * 2) + 2;
            this.f1357c -= i2;
            this.f1358d--;
        }
    }

    public resXmlResourceParserC0594a() {
        this.f1340b = new C0596b();
        this.f1342d = false;
        this.f1345g = new C0595a();
        m20027d();
    }

    public resXmlResourceParserC0594a(InputStream inputStream) {
        this();
        m20033a(inputStream);
    }

    /* renamed from: a */
    private final int m20032a(String str, String str2) {
        int m20003a;
        if (this.f1343e == null || str2 == null || (m20003a = this.f1343e.m20003a(str2)) == -1) {
            return -1;
        }
        int m20003a2 = str != null ? this.f1343e.m20003a(str) : -1;
        for (int i = 0; i != this.f1351m.length; i++) {
            if (m20003a == this.f1351m[i + 1] && (m20003a2 == -1 || m20003a2 == this.f1351m[i + 0])) {
                return i / 5;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private void m20034a(C0593a c0593a) {
        if (this.f1341c == null) {
            this.f1341c = c0593a;
        }
    }

    /* renamed from: c */
    private final int m20028c(int i) {
        if (this.f1347i != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.f1351m.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    /* renamed from: d */
    private final void m20027d() {
        this.f1347i = -1;
        this.f1348j = -1;
        this.f1349k = -1;
        this.f1350l = -1;
        this.f1351m = null;
        this.f1352n = -1;
        this.f1353o = -1;
        this.f1354p = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c1, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0087, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m20026e() {
        if (this.f1343e == null) {
            this.f1339a.m19983b(f1337y);
            this.f1339a.m19988a();
            this.f1343e = C0597c.m20004a(this.f1339a);
            this.f1345g.m20011f();
            this.f1342d = true;
        }
        if (this.f1347i == 1) {
            return;
        }
        int i = this.f1347i;
        m20027d();
        while (true) {
            if (this.f1346h) {
                this.f1346h = false;
                this.f1345g.m20009g();
            }
            if (i == 3 && this.f1345g.m20013e() == 1 && this.f1345g.m20017c() == 0) {
                this.f1347i = 1;
                return;
            }
            int readInt = i == 0 ? f1325D : this.f1339a.readInt();
            if (readInt == f1338z) {
                int readInt2 = this.f1339a.readInt();
                if (readInt2 < 8 || readInt2 % 4 != 0) {
                    break;
                }
                this.f1344f = this.f1339a.m19986a((readInt2 / 4) - 2);
            } else if (readInt < 1048832 || readInt > 1048836) {
                break;
            } else if (readInt == f1325D && i == -1) {
                this.f1347i = 0;
                return;
            } else {
                this.f1339a.m19988a();
                int readInt3 = this.f1339a.readInt();
                this.f1339a.m19988a();
                if (readInt != 1048832 && readInt != f1324C) {
                    this.f1348j = readInt3;
                    if (readInt == f1325D) {
                        this.f1350l = this.f1339a.readInt();
                        this.f1349k = this.f1339a.readInt();
                        this.f1339a.m19988a();
                        int readInt4 = this.f1339a.readInt();
                        this.f1352n = (readInt4 >>> 16) - 1;
                        this.f1353o = this.f1339a.readInt();
                        this.f1354p = (this.f1353o >>> 16) - 1;
                        this.f1353o = (this.f1353o & 65535) - 1;
                        this.f1351m = this.f1339a.m19986a((readInt4 & 65535) * 5);
                        for (int i2 = 3; i2 < this.f1351m.length; i2 += 5) {
                            this.f1351m[i2] = this.f1351m[i2] >>> 24;
                        }
                        this.f1345g.m20011f();
                        this.f1347i = 2;
                        return;
                    } else if (readInt == f1326E) {
                        this.f1350l = this.f1339a.readInt();
                        this.f1349k = this.f1339a.readInt();
                        this.f1347i = 3;
                        this.f1346h = true;
                        return;
                    } else if (readInt == 1048836) {
                        this.f1349k = this.f1339a.readInt();
                        this.f1339a.m19988a();
                        this.f1339a.m19988a();
                        this.f1347i = 4;
                        return;
                    }
                } else if (readInt == 1048832) {
                    this.f1345g.m20023a(this.f1339a.readInt(), this.f1339a.readInt());
                } else {
                    this.f1339a.m19988a();
                    this.f1339a.m19988a();
                    this.f1345g.m20015d();
                }
            }
        }
    }

    /* renamed from: a */
    public int m20036a(int i) {
        return this.f1351m[m20028c(i) + 3];
    }

    /* renamed from: a */
    public C0593a m20037a() {
        return this.f1341c;
    }

    /* renamed from: a */
    public void m20035a(C0596b c0596b) {
        this.f1340b = c0596b;
    }

    /* renamed from: a */
    public void m20033a(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.f1339a = new C0601b(new C0602a(inputStream));
        }
    }

    /* renamed from: b */
    public int m20030b(int i) {
        return this.f1351m[m20028c(i) + 4];
    }

    /* renamed from: b */
    public C0596b m20031b() {
        return this.f1340b;
    }

    /* renamed from: c */
    final C0597c m20029c() {
        return this.f1343e;
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public void close() {
        if (!this.f1342d) {
            return;
        }
        this.f1342d = false;
        this.f1339a = null;
        this.f1343e = null;
        this.f1344f = null;
        this.f1345g.m20025a();
        m20027d();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        throw new XmlPullParserException(f1330r);
    }

    @Override // android.util.AttributeSet
    public boolean getAttributeBooleanValue(int i, boolean z) {
        return getAttributeIntValue(i, z ? 1 : 0) != 0;
    }

    @Override // android.util.AttributeSet
    public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int m20032a = m20032a(str, str2);
        return m20032a == -1 ? z : getAttributeBooleanValue(m20032a, z);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public int getAttributeCount() {
        if (this.f1347i != 2) {
            return -1;
        }
        return this.f1351m.length / 5;
    }

    @Override // android.util.AttributeSet
    public float getAttributeFloatValue(int i, float f) {
        int m20028c = m20028c(i);
        return this.f1351m[m20028c + 3] == 4 ? Float.intBitsToFloat(this.f1351m[m20028c + 4]) : f;
    }

    @Override // android.util.AttributeSet
    public float getAttributeFloatValue(String str, String str2, float f) {
        int m20032a = m20032a(str, str2);
        return m20032a == -1 ? f : getAttributeFloatValue(m20032a, f);
    }

    @Override // android.util.AttributeSet
    public int getAttributeIntValue(int i, int i2) {
        int m20028c = m20028c(i);
        int i3 = this.f1351m[m20028c + 3];
        return (i3 < 16 || i3 > 31) ? i2 : this.f1351m[m20028c + 4];
    }

    @Override // android.util.AttributeSet
    public int getAttributeIntValue(String str, String str2, int i) {
        int m20032a = m20032a(str, str2);
        return m20032a == -1 ? i : getAttributeIntValue(m20032a, i);
    }

    @Override // android.util.AttributeSet
    public int getAttributeListValue(int i, String[] strArr, int i2) {
        return 0;
    }

    @Override // android.util.AttributeSet
    public int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        return 0;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeName(int i) {
        int i2 = this.f1351m[m20028c(i) + 1];
        return i2 == -1 ? "" : this.f1343e.m20006a(i2);
    }

    @Override // android.util.AttributeSet
    public int getAttributeNameResource(int i) {
        int i2 = this.f1351m[m20028c(i) + 1];
        if (this.f1344f == null || i2 < 0 || i2 >= this.f1344f.length) {
            return 0;
        }
        return this.f1344f[i2];
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeNamespace(int i) {
        int i2 = this.f1351m[m20028c(i) + 0];
        return i2 == -1 ? "" : this.f1343e.m20006a(i2);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        int m20014d = this.f1345g.m20014d(this.f1351m[m20028c(i) + 0]);
        return m20014d == -1 ? "" : this.f1343e.m20006a(m20014d);
    }

    @Override // android.util.AttributeSet
    public int getAttributeResourceValue(int i, int i2) {
        int m20028c = m20028c(i);
        return this.f1351m[m20028c + 3] == 1 ? this.f1351m[m20028c + 4] : i2;
    }

    @Override // android.util.AttributeSet
    public int getAttributeResourceValue(String str, String str2, int i) {
        int m20032a = m20032a(str, str2);
        return m20032a == -1 ? i : getAttributeResourceValue(m20032a, i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // android.util.AttributeSet
    public int getAttributeUnsignedIntValue(int i, int i2) {
        return getAttributeIntValue(i, i2);
    }

    @Override // android.util.AttributeSet
    public int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int m20032a = m20032a(str, str2);
        return m20032a == -1 ? i : getAttributeUnsignedIntValue(m20032a, i);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(int i) {
        int m20028c = m20028c(i);
        int i2 = this.f1351m[m20028c + 3];
        int i3 = this.f1351m[m20028c + 4];
        int i4 = this.f1351m[m20028c + 2];
        if (this.f1340b != null) {
            try {
                return this.f1340b.m20008a(i2, i3, i4 == -1 ? null : C0598a.m19994a(this.f1343e.m20006a(i4)), getAttributeNameResource(i));
            } catch (C0593a e) {
                m20034a(e);
                f1329q.log(Level.WARNING, String.format("Could not decode attr value, using undecoded value instead: ns=%s, name=%s, value=0x%08x", getAttributePrefix(i), getAttributeName(i), Integer.valueOf(i3)), (Throwable) e);
            }
        }
        return TypedValue.coerceToString(i2, i3);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(String str, String str2) {
        int m20032a = m20032a(str, str2);
        if (m20032a == -1) {
            return null;
        }
        return getAttributeValue(m20032a);
    }

    @Override // android.util.AttributeSet
    public String getClassAttribute() {
        if (this.f1353o == -1) {
            return null;
        }
        return this.f1343e.m20006a(this.f1351m[m20028c(this.f1353o) + 2]);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.f1345g.m20013e() - 1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.f1347i;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        return false;
    }

    @Override // android.util.AttributeSet
    public String getIdAttribute() {
        if (this.f1352n == -1) {
            return null;
        }
        return this.f1343e.m20006a(this.f1351m[m20028c(this.f1352n) + 2]);
    }

    @Override // android.util.AttributeSet
    public int getIdAttributeResourceValue(int i) {
        if (this.f1352n == -1) {
            return i;
        }
        int m20028c = m20028c(this.f1352n);
        return this.f1351m[m20028c + 3] == 1 ? this.f1351m[m20028c + 4] : i;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.f1348j;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        if (this.f1349k == -1 || !(this.f1347i == 2 || this.f1347i == 3)) {
            return null;
        }
        return this.f1343e.m20006a(this.f1349k);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.f1343e.m20006a(this.f1350l);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        throw new RuntimeException(f1330r);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        return this.f1345g.m20024a(i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.f1343e.m20006a(this.f1345g.m20020b(i));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.f1343e.m20006a(this.f1345g.m20016c(i));
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.f1343e.m20006a(this.f1345g.m20014d(this.f1350l));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        return null;
    }

    @Override // android.util.AttributeSet
    public int getStyleAttribute() {
        if (this.f1354p == -1) {
            return 0;
        }
        return this.f1351m[m20028c(this.f1354p) + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        if (this.f1349k == -1 || this.f1347i != 4) {
            return null;
        }
        return this.f1343e.m20006a(this.f1349k);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() {
        if (this.f1339a == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            m20026e();
            return this.f1347i;
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() {
        if (getEventType() != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        int next = next();
        if (next != 4) {
            if (next != 3) {
                throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
            }
            return "";
        }
        String text = getText();
        if (next() == 3) {
            return text;
        }
        throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() {
        return next();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) {
        if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(TYPES[i] + " is expected.", this, null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        throw new XmlPullParserException(f1330r);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        m20033a(inputStream);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) {
        throw new XmlPullParserException(f1330r);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        throw new XmlPullParserException(f1330r);
    }
}
