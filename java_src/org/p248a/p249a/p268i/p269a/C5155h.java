package org.p248a.p249a.p268i.p269a;

import android.util.Base64;
import com.fimi.soul.biz.camera.C2427e;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.impl.auth.NTLMEngine;
import org.apache.http.impl.auth.NTLMEngineException;
import org.apache.http.util.EncodingUtils;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.p250a.AbstractC5006c;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0383e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* JADX INFO: Access modifiers changed from: package-private */
@AbstractC5006c
/* renamed from: org.a.a.i.a.h */
/* loaded from: classes2.dex */
public final class C5155h implements NTLMEngine {

    /* renamed from: a */
    protected static final int f21838a = 1;

    /* renamed from: b */
    protected static final int f21839b = 4;

    /* renamed from: c */
    protected static final int f21840c = 16;

    /* renamed from: d */
    protected static final int f21841d = 32;

    /* renamed from: e */
    protected static final int f21842e = 128;

    /* renamed from: f */
    protected static final int f21843f = 512;

    /* renamed from: g */
    protected static final int f21844g = 4096;

    /* renamed from: h */
    protected static final int f21845h = 8192;

    /* renamed from: i */
    protected static final int f21846i = 32768;

    /* renamed from: j */
    protected static final int f21847j = 524288;

    /* renamed from: k */
    protected static final int f21848k = 33554432;

    /* renamed from: l */
    protected static final int f21849l = 8388608;

    /* renamed from: m */
    protected static final int f21850m = 536870912;

    /* renamed from: n */
    protected static final int f21851n = 1073741824;

    /* renamed from: o */
    protected static final int f21852o = Integer.MIN_VALUE;

    /* renamed from: p */
    static final String f21853p = "ASCII";

    /* renamed from: q */
    private static final SecureRandom f21854q;

    /* renamed from: s */
    private static final byte[] f21855s;

    /* renamed from: r */
    private String f21856r = f21853p;

    /* renamed from: org.a.a.i.a.h$a */
    /* loaded from: classes2.dex */
    protected static class C5156a {

        /* renamed from: a */
        protected final String f21857a;

        /* renamed from: b */
        protected final String f21858b;

        /* renamed from: c */
        protected final String f21859c;

        /* renamed from: d */
        protected final byte[] f21860d;

        /* renamed from: e */
        protected final String f21861e;

        /* renamed from: f */
        protected final byte[] f21862f;

        /* renamed from: g */
        protected byte[] f21863g;

        /* renamed from: h */
        protected byte[] f21864h;

        /* renamed from: i */
        protected byte[] f21865i;

        /* renamed from: j */
        protected byte[] f21866j;

        /* renamed from: k */
        protected byte[] f21867k;

        /* renamed from: l */
        protected byte[] f21868l;

        /* renamed from: m */
        protected byte[] f21869m;

        /* renamed from: n */
        protected byte[] f21870n;

        /* renamed from: o */
        protected byte[] f21871o;

        /* renamed from: p */
        protected byte[] f21872p;

        /* renamed from: q */
        protected byte[] f21873q;

        /* renamed from: r */
        protected byte[] f21874r;

        /* renamed from: s */
        protected byte[] f21875s;

        /* renamed from: t */
        protected byte[] f21876t;

        /* renamed from: u */
        protected byte[] f21877u;

        /* renamed from: v */
        protected byte[] f21878v;

        /* renamed from: w */
        protected byte[] f21879w;

        /* renamed from: x */
        protected byte[] f21880x;

        /* renamed from: y */
        protected byte[] f21881y;

        /* renamed from: z */
        protected byte[] f21882z;

        public C5156a(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(str, str2, str3, bArr, str4, bArr2, null, null, null, null);
        }

        public C5156a(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            this.f21867k = null;
            this.f21868l = null;
            this.f21869m = null;
            this.f21870n = null;
            this.f21871o = null;
            this.f21872p = null;
            this.f21873q = null;
            this.f21874r = null;
            this.f21875s = null;
            this.f21876t = null;
            this.f21877u = null;
            this.f21878v = null;
            this.f21879w = null;
            this.f21880x = null;
            this.f21881y = null;
            this.f21882z = null;
            this.f21857a = str;
            this.f21861e = str4;
            this.f21858b = str2;
            this.f21859c = str3;
            this.f21860d = bArr;
            this.f21862f = bArr2;
            this.f21863g = bArr3;
            this.f21864h = bArr4;
            this.f21865i = bArr5;
            this.f21866j = bArr6;
        }

        /* renamed from: a */
        public byte[] m1857a() {
            if (this.f21863g == null) {
                this.f21863g = C5155h.m1870e();
            }
            return this.f21863g;
        }

        /* renamed from: b */
        public byte[] m1856b() {
            if (this.f21864h == null) {
                this.f21864h = C5155h.m1870e();
            }
            return this.f21864h;
        }

        /* renamed from: c */
        public byte[] m1855c() {
            if (this.f21865i == null) {
                this.f21865i = C5155h.m1866f();
            }
            return this.f21865i;
        }

        /* renamed from: d */
        public byte[] m1854d() {
            if (this.f21867k == null) {
                this.f21867k = C5155h.m1859i(this.f21859c);
            }
            return this.f21867k;
        }

        /* renamed from: e */
        public byte[] m1853e() {
            if (this.f21868l == null) {
                this.f21868l = C5155h.m1872d(m1854d(), this.f21860d);
            }
            return this.f21868l;
        }

        /* renamed from: f */
        public byte[] m1852f() {
            if (this.f21869m == null) {
                this.f21869m = C5155h.m1858j(this.f21859c);
            }
            return this.f21869m;
        }

        /* renamed from: g */
        public byte[] m1851g() {
            if (this.f21870n == null) {
                this.f21870n = C5155h.m1872d(m1852f(), this.f21860d);
            }
            return this.f21870n;
        }

        /* renamed from: h */
        public byte[] m1850h() {
            if (this.f21872p == null) {
                this.f21872p = C5155h.m1880c(this.f21857a, this.f21858b, m1852f());
            }
            return this.f21872p;
        }

        /* renamed from: i */
        public byte[] m1849i() {
            if (this.f21871o == null) {
                this.f21871o = C5155h.m1874d(this.f21857a, this.f21858b, m1852f());
            }
            return this.f21871o;
        }

        /* renamed from: j */
        public byte[] m1848j() {
            if (this.f21866j == null) {
                long currentTimeMillis = AbstractC0517a.f1169e * (System.currentTimeMillis() + 11644473600000L);
                this.f21866j = new byte[8];
                for (int i = 0; i < 8; i++) {
                    this.f21866j[i] = (byte) currentTimeMillis;
                    currentTimeMillis >>>= 8;
                }
            }
            return this.f21866j;
        }

        /* renamed from: k */
        public byte[] m1847k() {
            if (this.f21874r == null) {
                this.f21874r = C5155h.m1867e(m1856b(), this.f21862f, m1848j());
            }
            return this.f21874r;
        }

        /* renamed from: l */
        public byte[] m1846l() {
            if (this.f21875s == null) {
                this.f21875s = C5155h.m1871d(m1849i(), this.f21860d, m1847k());
            }
            return this.f21875s;
        }

        /* renamed from: m */
        public byte[] m1845m() {
            if (this.f21873q == null) {
                this.f21873q = C5155h.m1871d(m1850h(), this.f21860d, m1857a());
            }
            return this.f21873q;
        }

        /* renamed from: n */
        public byte[] m1844n() {
            if (this.f21876t == null) {
                this.f21876t = C5155h.m1891a(m1852f(), this.f21860d, m1857a());
            }
            return this.f21876t;
        }

        /* renamed from: o */
        public byte[] m1843o() {
            if (this.f21877u == null) {
                byte[] m1857a = m1857a();
                this.f21877u = new byte[24];
                System.arraycopy(m1857a, 0, this.f21877u, 0, m1857a.length);
                Arrays.fill(this.f21877u, m1857a.length, this.f21877u.length, (byte) 0);
            }
            return this.f21877u;
        }

        /* renamed from: p */
        public byte[] m1842p() {
            if (this.f21878v == null) {
                this.f21878v = new byte[16];
                System.arraycopy(m1854d(), 0, this.f21878v, 0, 8);
                Arrays.fill(this.f21878v, 8, 16, (byte) 0);
            }
            return this.f21878v;
        }

        /* renamed from: q */
        public byte[] m1841q() {
            if (this.f21879w == null) {
                C5158c c5158c = new C5158c();
                c5158c.m1833a(m1852f());
                this.f21879w = c5158c.m1834a();
            }
            return this.f21879w;
        }

        /* renamed from: r */
        public byte[] m1840r() {
            if (this.f21880x == null) {
                byte[] m1849i = m1849i();
                byte[] bArr = new byte[16];
                System.arraycopy(m1846l(), 0, bArr, 0, 16);
                this.f21880x = C5155h.m1892a(bArr, m1849i);
            }
            return this.f21880x;
        }

        /* renamed from: s */
        public byte[] m1839s() {
            if (this.f21881y == null) {
                byte[] m1843o = m1843o();
                byte[] bArr = new byte[this.f21860d.length + m1843o.length];
                System.arraycopy(this.f21860d, 0, bArr, 0, this.f21860d.length);
                System.arraycopy(m1843o, 0, bArr, this.f21860d.length, m1843o.length);
                this.f21881y = C5155h.m1892a(bArr, m1841q());
            }
            return this.f21881y;
        }

        /* renamed from: t */
        public byte[] m1838t() {
            if (this.f21882z == null) {
                try {
                    byte[] bArr = new byte[14];
                    System.arraycopy(m1854d(), 0, bArr, 0, 8);
                    Arrays.fill(bArr, 8, bArr.length, (byte) -67);
                    Key m1860h = C5155h.m1860h(bArr, 0);
                    Key m1860h2 = C5155h.m1860h(bArr, 7);
                    byte[] bArr2 = new byte[8];
                    System.arraycopy(m1853e(), 0, bArr2, 0, bArr2.length);
                    Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, m1860h);
                    byte[] doFinal = cipher.doFinal(bArr2);
                    Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher2.init(1, m1860h2);
                    byte[] doFinal2 = cipher2.doFinal(bArr2);
                    this.f21882z = new byte[16];
                    System.arraycopy(doFinal, 0, this.f21882z, 0, doFinal.length);
                    System.arraycopy(doFinal2, 0, this.f21882z, doFinal.length, doFinal2.length);
                } catch (Exception e) {
                    throw new NTLMEngineException(e.getMessage(), e);
                }
            }
            return this.f21882z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.a.h$b */
    /* loaded from: classes2.dex */
    public static class C5157b {

        /* renamed from: a */
        protected byte[] f21883a;

        /* renamed from: b */
        protected byte[] f21884b;

        /* renamed from: c */
        protected MessageDigest f21885c;

        C5157b(byte[] bArr) {
            try {
                this.f21885c = MessageDigest.getInstance("MD5");
                this.f21883a = new byte[64];
                this.f21884b = new byte[64];
                int length = bArr.length;
                if (length > 64) {
                    this.f21885c.update(bArr);
                    bArr = this.f21885c.digest();
                    length = bArr.length;
                }
                int i = 0;
                while (i < length) {
                    this.f21883a[i] = (byte) (bArr[i] ^ 54);
                    this.f21884b[i] = (byte) (bArr[i] ^ 92);
                    i++;
                }
                for (int i2 = i; i2 < 64; i2++) {
                    this.f21883a[i2] = 54;
                    this.f21884b[i2] = 92;
                }
                this.f21885c.reset();
                this.f21885c.update(this.f21883a);
            } catch (Exception e) {
                throw new NTLMEngineException("Error getting md5 message digest implementation: " + e.getMessage(), e);
            }
        }

        /* renamed from: a */
        void m1836a(byte[] bArr) {
            this.f21885c.update(bArr);
        }

        /* renamed from: a */
        void m1835a(byte[] bArr, int i, int i2) {
            this.f21885c.update(bArr, i, i2);
        }

        /* renamed from: a */
        byte[] m1837a() {
            byte[] digest = this.f21885c.digest();
            this.f21885c.update(this.f21884b);
            return this.f21885c.digest(digest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.a.h$c */
    /* loaded from: classes2.dex */
    public static class C5158c {

        /* renamed from: a */
        protected int f21886a = 1732584193;

        /* renamed from: b */
        protected int f21887b = -271733879;

        /* renamed from: c */
        protected int f21888c = -1732584194;

        /* renamed from: d */
        protected int f21889d = 271733878;

        /* renamed from: e */
        protected long f21890e = 0;

        /* renamed from: f */
        protected byte[] f21891f = new byte[64];

        C5158c() {
        }

        /* renamed from: a */
        void m1833a(byte[] bArr) {
            int i = (int) (this.f21890e & 63);
            int i2 = 0;
            while ((bArr.length - i2) + i >= this.f21891f.length) {
                int length = this.f21891f.length - i;
                System.arraycopy(bArr, i2, this.f21891f, i, length);
                this.f21890e += length;
                i2 += length;
                m1831b();
                i = 0;
            }
            if (i2 < bArr.length) {
                int length2 = bArr.length - i2;
                System.arraycopy(bArr, i2, this.f21891f, i, length2);
                this.f21890e += length2;
                int i3 = i + length2;
            }
        }

        /* renamed from: a */
        protected void m1832a(int[] iArr) {
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1901a(this.f21887b, this.f21888c, this.f21889d) + iArr[0], 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1901a(this.f21886a, this.f21887b, this.f21888c) + iArr[1], 7);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1901a(this.f21889d, this.f21886a, this.f21887b) + iArr[2], 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1901a(this.f21888c, this.f21889d, this.f21886a) + iArr[3], 19);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1901a(this.f21887b, this.f21888c, this.f21889d) + iArr[4], 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1901a(this.f21886a, this.f21887b, this.f21888c) + iArr[5], 7);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1901a(this.f21889d, this.f21886a, this.f21887b) + iArr[6], 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1901a(this.f21888c, this.f21889d, this.f21886a) + iArr[7], 19);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1901a(this.f21887b, this.f21888c, this.f21889d) + iArr[8], 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1901a(this.f21886a, this.f21887b, this.f21888c) + iArr[9], 7);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1901a(this.f21889d, this.f21886a, this.f21887b) + iArr[10], 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1901a(this.f21888c, this.f21889d, this.f21886a) + iArr[11], 19);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1901a(this.f21887b, this.f21888c, this.f21889d) + iArr[12], 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1901a(this.f21886a, this.f21887b, this.f21888c) + iArr[13], 7);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1901a(this.f21889d, this.f21886a, this.f21887b) + iArr[14], 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1901a(this.f21888c, this.f21889d, this.f21886a) + iArr[15], 19);
        }

        /* renamed from: a */
        byte[] m1834a() {
            int i = (int) (this.f21890e & 63);
            int i2 = i < 56 ? 56 - i : 120 - i;
            byte[] bArr = new byte[i2 + 8];
            bArr[0] = Byte.MIN_VALUE;
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i2 + i3] = (byte) ((this.f21890e * 8) >>> (i3 * 8));
            }
            m1833a(bArr);
            byte[] bArr2 = new byte[16];
            C5155h.m1893a(bArr2, this.f21886a, 0);
            C5155h.m1893a(bArr2, this.f21887b, 4);
            C5155h.m1893a(bArr2, this.f21888c, 8);
            C5155h.m1893a(bArr2, this.f21889d, 12);
            return bArr2;
        }

        /* renamed from: b */
        protected void m1831b() {
            int[] iArr = new int[16];
            for (int i = 0; i < 16; i++) {
                iArr[i] = (this.f21891f[i * 4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + ((this.f21891f[(i * 4) + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) + ((this.f21891f[(i * 4) + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) + ((this.f21891f[(i * 4) + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24);
            }
            int i2 = this.f21886a;
            int i3 = this.f21887b;
            int i4 = this.f21888c;
            int i5 = this.f21889d;
            m1832a(iArr);
            m1830b(iArr);
            m1829c(iArr);
            this.f21886a = i2 + this.f21886a;
            this.f21887b += i3;
            this.f21888c += i4;
            this.f21889d += i5;
        }

        /* renamed from: b */
        protected void m1830b(int[] iArr) {
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1889b(this.f21887b, this.f21888c, this.f21889d) + iArr[0] + 1518500249, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1889b(this.f21886a, this.f21887b, this.f21888c) + iArr[4] + 1518500249, 5);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1889b(this.f21889d, this.f21886a, this.f21887b) + iArr[8] + 1518500249, 9);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1889b(this.f21888c, this.f21889d, this.f21886a) + iArr[12] + 1518500249, 13);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1889b(this.f21887b, this.f21888c, this.f21889d) + iArr[1] + 1518500249, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1889b(this.f21886a, this.f21887b, this.f21888c) + iArr[5] + 1518500249, 5);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1889b(this.f21889d, this.f21886a, this.f21887b) + iArr[9] + 1518500249, 9);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1889b(this.f21888c, this.f21889d, this.f21886a) + iArr[13] + 1518500249, 13);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1889b(this.f21887b, this.f21888c, this.f21889d) + iArr[2] + 1518500249, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1889b(this.f21886a, this.f21887b, this.f21888c) + iArr[6] + 1518500249, 5);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1889b(this.f21889d, this.f21886a, this.f21887b) + iArr[10] + 1518500249, 9);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1889b(this.f21888c, this.f21889d, this.f21886a) + iArr[14] + 1518500249, 13);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1889b(this.f21887b, this.f21888c, this.f21889d) + iArr[3] + 1518500249, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1889b(this.f21886a, this.f21887b, this.f21888c) + iArr[7] + 1518500249, 5);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1889b(this.f21889d, this.f21886a, this.f21887b) + iArr[11] + 1518500249, 9);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1889b(this.f21888c, this.f21889d, this.f21886a) + iArr[15] + 1518500249, 13);
        }

        /* renamed from: c */
        protected void m1829c(int[] iArr) {
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1882c(this.f21887b, this.f21888c, this.f21889d) + iArr[0] + 1859775393, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1882c(this.f21886a, this.f21887b, this.f21888c) + iArr[8] + 1859775393, 9);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1882c(this.f21889d, this.f21886a, this.f21887b) + iArr[4] + 1859775393, 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1882c(this.f21888c, this.f21889d, this.f21886a) + iArr[12] + 1859775393, 15);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1882c(this.f21887b, this.f21888c, this.f21889d) + iArr[2] + 1859775393, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1882c(this.f21886a, this.f21887b, this.f21888c) + iArr[10] + 1859775393, 9);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1882c(this.f21889d, this.f21886a, this.f21887b) + iArr[6] + 1859775393, 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1882c(this.f21888c, this.f21889d, this.f21886a) + iArr[14] + 1859775393, 15);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1882c(this.f21887b, this.f21888c, this.f21889d) + iArr[1] + 1859775393, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1882c(this.f21886a, this.f21887b, this.f21888c) + iArr[9] + 1859775393, 9);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1882c(this.f21889d, this.f21886a, this.f21887b) + iArr[5] + 1859775393, 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1882c(this.f21888c, this.f21889d, this.f21886a) + iArr[13] + 1859775393, 15);
            this.f21886a = C5155h.m1902a(this.f21886a + C5155h.m1882c(this.f21887b, this.f21888c, this.f21889d) + iArr[3] + 1859775393, 3);
            this.f21889d = C5155h.m1902a(this.f21889d + C5155h.m1882c(this.f21886a, this.f21887b, this.f21888c) + iArr[11] + 1859775393, 9);
            this.f21888c = C5155h.m1902a(this.f21888c + C5155h.m1882c(this.f21889d, this.f21886a, this.f21887b) + iArr[7] + 1859775393, 11);
            this.f21887b = C5155h.m1902a(this.f21887b + C5155h.m1882c(this.f21888c, this.f21889d, this.f21886a) + iArr[15] + 1859775393, 15);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.a.h$d */
    /* loaded from: classes2.dex */
    public static class C5159d {

        /* renamed from: a */
        private byte[] f21892a;

        /* renamed from: b */
        private int f21893b;

        C5159d() {
            this.f21892a = null;
            this.f21893b = 0;
        }

        C5159d(String str, int i) {
            this.f21892a = null;
            this.f21893b = 0;
            this.f21892a = Base64.decode(EncodingUtils.getBytes(str, C5155h.f21853p), 2);
            if (this.f21892a.length < C5155h.f21855s.length) {
                throw new NTLMEngineException("NTLM message decoding error - packet too short");
            }
            for (int i2 = 0; i2 < C5155h.f21855s.length; i2++) {
                if (this.f21892a[i2] != C5155h.f21855s[i2]) {
                    throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                }
            }
            int m1820c = m1820c(C5155h.f21855s.length);
            if (m1820c != i) {
                throw new NTLMEngineException("NTLM type " + Integer.toString(i) + " message expected - instead got type " + Integer.toString(m1820c));
            }
            this.f21893b = this.f21892a.length;
        }

        /* renamed from: a */
        protected byte m1826a(int i) {
            if (this.f21892a.length < i + 1) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            return this.f21892a[i];
        }

        /* renamed from: a */
        protected int m1828a() {
            return C5155h.f21855s.length + 4;
        }

        /* renamed from: a */
        protected void m1827a(byte b) {
            this.f21892a[this.f21893b] = b;
            this.f21893b++;
        }

        /* renamed from: a */
        protected void m1825a(int i, int i2) {
            this.f21892a = new byte[i];
            this.f21893b = 0;
            m1824a(C5155h.f21855s);
            m1817f(i2);
        }

        /* renamed from: a */
        protected void m1824a(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            for (byte b : bArr) {
                this.f21892a[this.f21893b] = b;
                this.f21893b++;
            }
        }

        /* renamed from: a */
        protected void m1823a(byte[] bArr, int i) {
            if (this.f21892a.length < bArr.length + i) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            System.arraycopy(this.f21892a, i, bArr, 0, bArr.length);
        }

        /* renamed from: b */
        protected int m1822b() {
            return this.f21893b;
        }

        /* renamed from: b */
        protected int m1821b(int i) {
            return C5155h.m1864f(this.f21892a, i);
        }

        /* renamed from: c */
        protected int m1820c(int i) {
            return C5155h.m1868e(this.f21892a, i);
        }

        /* renamed from: c */
        String mo1812c() {
            byte[] bArr;
            if (this.f21892a.length > this.f21893b) {
                bArr = new byte[this.f21893b];
                System.arraycopy(this.f21892a, 0, bArr, 0, this.f21893b);
            } else {
                bArr = this.f21892a;
            }
            return EncodingUtils.getAsciiString(Base64.encode(bArr, 2));
        }

        /* renamed from: d */
        protected byte[] m1819d(int i) {
            return C5155h.m1862g(this.f21892a, i);
        }

        /* renamed from: e */
        protected void m1818e(int i) {
            m1827a((byte) (i & 255));
            m1827a((byte) ((i >> 8) & 255));
        }

        /* renamed from: f */
        protected void m1817f(int i) {
            m1827a((byte) (i & 255));
            m1827a((byte) ((i >> 8) & 255));
            m1827a((byte) ((i >> 16) & 255));
            m1827a((byte) ((i >> 24) & 255));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.a.h$e */
    /* loaded from: classes2.dex */
    public static class C5160e extends C5159d {

        /* renamed from: a */
        protected byte[] f21894a;

        /* renamed from: b */
        protected byte[] f21895b;

        C5160e(String str, String str2) {
            byte[] bArr = null;
            try {
                String m1863g = C5155h.m1863g(str2);
                String m1861h = C5155h.m1861h(str);
                this.f21894a = m1863g != null ? m1863g.getBytes(C5155h.f21853p) : null;
                this.f21895b = m1861h != null ? m1861h.toUpperCase(Locale.ENGLISH).getBytes(C5155h.f21853p) : bArr;
            } catch (UnsupportedEncodingException e) {
                throw new NTLMEngineException("Unicode unsupported: " + e.getMessage(), e);
            }
        }

        @Override // org.p248a.p249a.p268i.p269a.C5155h.C5159d
        /* renamed from: c */
        String mo1812c() {
            a(40, 1);
            f(-1576500735);
            e(0);
            e(0);
            f(40);
            e(0);
            e(0);
            f(40);
            e(C2427e.f8178H);
            f(2600);
            e(3840);
            return super.mo1812c();
        }
    }

    /* renamed from: org.a.a.i.a.h$f */
    /* loaded from: classes2.dex */
    static class C5161f extends C5159d {

        /* renamed from: b */
        protected String f21897b;

        /* renamed from: c */
        protected byte[] f21898c;

        /* renamed from: a */
        protected byte[] f21896a = new byte[8];

        /* renamed from: d */
        protected int f21899d = c(20);

        C5161f(String str) {
            super(str, 2);
            a(this.f21896a, 24);
            if ((this.f21899d & 1) == 0) {
                throw new NTLMEngineException("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.f21899d));
            }
            this.f21897b = null;
            if (b() >= 20) {
                byte[] d = d(12);
                if (d.length != 0) {
                    try {
                        this.f21897b = new String(d, "UnicodeLittleUnmarked");
                    } catch (UnsupportedEncodingException e) {
                        throw new NTLMEngineException(e.getMessage(), e);
                    }
                }
            }
            this.f21898c = null;
            if (b() < 48) {
                return;
            }
            byte[] d2 = d(40);
            if (d2.length == 0) {
                return;
            }
            this.f21898c = d2;
        }

        /* renamed from: d */
        byte[] m1816d() {
            return this.f21896a;
        }

        /* renamed from: e */
        String m1815e() {
            return this.f21897b;
        }

        /* renamed from: f */
        byte[] m1814f() {
            return this.f21898c;
        }

        /* renamed from: g */
        int m1813g() {
            return this.f21899d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.a.h$g */
    /* loaded from: classes2.dex */
    public static class C5162g extends C5159d {

        /* renamed from: a */
        protected int f21900a;

        /* renamed from: b */
        protected byte[] f21901b;

        /* renamed from: c */
        protected byte[] f21902c;

        /* renamed from: d */
        protected byte[] f21903d;

        /* renamed from: e */
        protected byte[] f21904e;

        /* renamed from: f */
        protected byte[] f21905f;

        /* renamed from: g */
        protected byte[] f21906g;

        C5162g(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) {
            byte[] m1838t;
            byte[] bytes;
            this.f21900a = i;
            String m1863g = C5155h.m1863g(str2);
            String m1861h = C5155h.m1861h(str);
            C5156a c5156a = new C5156a(m1861h, str3, str4, bArr, str5, bArr2);
            try {
                if ((8388608 & i) != 0 && bArr2 != null && str5 != null) {
                    this.f21905f = c5156a.m1846l();
                    this.f21904e = c5156a.m1845m();
                    m1838t = (i & 128) != 0 ? c5156a.m1838t() : c5156a.m1840r();
                } else if ((524288 & i) != 0) {
                    this.f21905f = c5156a.m1844n();
                    this.f21904e = c5156a.m1843o();
                    m1838t = (i & 128) != 0 ? c5156a.m1838t() : c5156a.m1839s();
                } else {
                    this.f21905f = c5156a.m1851g();
                    this.f21904e = c5156a.m1853e();
                    m1838t = (i & 128) != 0 ? c5156a.m1838t() : c5156a.m1841q();
                }
            } catch (NTLMEngineException e) {
                this.f21905f = new byte[0];
                this.f21904e = c5156a.m1853e();
                m1838t = (i & 128) != 0 ? c5156a.m1838t() : c5156a.m1842p();
            }
            if ((i & 16) == 0) {
                this.f21906g = null;
            } else if ((C5155h.f21851n & i) != 0) {
                this.f21906g = C5155h.m1885b(c5156a.m1855c(), m1838t);
            } else {
                this.f21906g = m1838t;
            }
            if (m1863g != null) {
                try {
                    bytes = m1863g.getBytes("UnicodeLittleUnmarked");
                } catch (UnsupportedEncodingException e2) {
                    throw new NTLMEngineException("Unicode not supported: " + e2.getMessage(), e2);
                }
            } else {
                bytes = null;
            }
            this.f21902c = bytes;
            this.f21901b = m1861h != null ? m1861h.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked") : null;
            this.f21903d = str3.getBytes("UnicodeLittleUnmarked");
        }

        @Override // org.p248a.p249a.p268i.p269a.C5155h.C5159d
        /* renamed from: c */
        String mo1812c() {
            int i = 0;
            int length = this.f21905f.length;
            int length2 = this.f21904e.length;
            int length3 = this.f21901b != null ? this.f21901b.length : 0;
            int length4 = this.f21902c != null ? this.f21902c.length : 0;
            int length5 = this.f21903d.length;
            if (this.f21906g != null) {
                i = this.f21906g.length;
            }
            int i2 = length2 + 72;
            int i3 = i2 + length;
            int i4 = i3 + length3;
            int i5 = i4 + length5;
            int i6 = i5 + length4;
            a(i6 + i, 3);
            e(length2);
            e(length2);
            f(72);
            e(length);
            e(length);
            f(i2);
            e(length3);
            e(length3);
            f(i3);
            e(length5);
            e(length5);
            f(i4);
            e(length4);
            e(length4);
            f(i5);
            e(i);
            e(i);
            f(i6);
            f((this.f21900a & 128) | (this.f21900a & 512) | (this.f21900a & 524288) | C5155h.f21848k | (this.f21900a & 32768) | (this.f21900a & 32) | (this.f21900a & 16) | (this.f21900a & C5155h.f21850m) | (this.f21900a & Integer.MIN_VALUE) | (this.f21900a & C5155h.f21851n) | (this.f21900a & 8388608) | (this.f21900a & 1) | (this.f21900a & 4));
            e(C2427e.f8178H);
            f(2600);
            e(3840);
            a(this.f21904e);
            a(this.f21905f);
            a(this.f21901b);
            a(this.f21903d);
            a(this.f21902c);
            if (this.f21906g != null) {
                a(this.f21906g);
            }
            return super.mo1812c();
        }
    }

    static {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance(AbstractC0383e.f796d);
        } catch (Exception e) {
        }
        f21854q = secureRandom;
        byte[] bytes = EncodingUtils.getBytes("NTLMSSP", f21853p);
        f21855s = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, f21855s, 0, bytes.length);
        f21855s[bytes.length] = 0;
    }

    /* renamed from: a */
    static int m1902a(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    /* renamed from: a */
    static int m1901a(int i, int i2, int i3) {
        return (i & i2) | ((i ^ (-1)) & i3);
    }

    /* renamed from: a */
    private static void m1895a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            if ((((b >>> 1) ^ ((((((b >>> 7) ^ (b >>> 6)) ^ (b >>> 5)) ^ (b >>> 4)) ^ (b >>> 3)) ^ (b >>> 2))) & 1) == 0) {
                bArr[i] = (byte) (bArr[i] | 1);
            } else {
                bArr[i] = (byte) (bArr[i] & (-2));
            }
        }
    }

    /* renamed from: a */
    static void m1893a(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    /* renamed from: a */
    static byte[] m1892a(byte[] bArr, byte[] bArr2) {
        C5157b c5157b = new C5157b(bArr2);
        c5157b.m1836a(bArr);
        return c5157b.m1837a();
    }

    /* renamed from: a */
    static byte[] m1891a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr2);
            messageDigest.update(bArr3);
            byte[] bArr4 = new byte[8];
            System.arraycopy(messageDigest.digest(), 0, bArr4, 0, 8);
            return m1872d(bArr, bArr4);
        } catch (Exception e) {
            if (!(e instanceof NTLMEngineException)) {
                throw new NTLMEngineException(e.getMessage(), e);
            }
            throw e;
        }
    }

    /* renamed from: b */
    static int m1889b(int i, int i2, int i3) {
        return (i & i2) | (i & i3) | (i2 & i3);
    }

    /* renamed from: b */
    static byte[] m1885b(byte[] bArr, byte[] bArr2) {
        try {
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(bArr2, "RC4"));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* renamed from: c */
    static int m1882c(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static byte[] m1880c(String str, String str2, byte[] bArr) {
        try {
            C5157b c5157b = new C5157b(bArr);
            c5157b.m1836a(str2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                c5157b.m1836a(str.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            }
            return c5157b.m1837a();
        } catch (UnsupportedEncodingException e) {
            throw new NTLMEngineException("Unicode not supported! " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m1874d(String str, String str2, byte[] bArr) {
        try {
            C5157b c5157b = new C5157b(bArr);
            c5157b.m1836a(str2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                c5157b.m1836a(str.getBytes("UnicodeLittleUnmarked"));
            }
            return c5157b.m1837a();
        } catch (UnsupportedEncodingException e) {
            throw new NTLMEngineException("Unicode not supported! " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m1872d(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArr3 = new byte[21];
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            Key m1860h = m1860h(bArr3, 0);
            Key m1860h2 = m1860h(bArr3, 7);
            Key m1860h3 = m1860h(bArr3, 14);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, m1860h);
            byte[] doFinal = cipher.doFinal(bArr2);
            cipher.init(1, m1860h2);
            byte[] doFinal2 = cipher.doFinal(bArr2);
            cipher.init(1, m1860h3);
            byte[] doFinal3 = cipher.doFinal(bArr2);
            byte[] bArr4 = new byte[24];
            System.arraycopy(doFinal, 0, bArr4, 0, 8);
            System.arraycopy(doFinal2, 0, bArr4, 8, 8);
            System.arraycopy(doFinal3, 0, bArr4, 16, 8);
            return bArr4;
        } catch (Exception e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m1871d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        C5157b c5157b = new C5157b(bArr);
        c5157b.m1836a(bArr2);
        c5157b.m1836a(bArr3);
        byte[] m1837a = c5157b.m1837a();
        byte[] bArr4 = new byte[m1837a.length + bArr3.length];
        System.arraycopy(m1837a, 0, bArr4, 0, m1837a.length);
        System.arraycopy(bArr3, 0, bArr4, m1837a.length, bArr3.length);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static int m1868e(byte[] bArr, int i) {
        if (bArr.length < i + 4) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
        }
        return (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static byte[] m1870e() {
        if (f21854q == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] bArr = new byte[8];
        synchronized (f21854q) {
            f21854q.nextBytes(bArr);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static byte[] m1867e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = {1, 1, 0, 0};
        byte[] bArr5 = {0, 0, 0, 0};
        byte[] bArr6 = {0, 0, 0, 0};
        byte[] bArr7 = {0, 0, 0, 0};
        byte[] bArr8 = new byte[bArr4.length + bArr5.length + bArr3.length + 8 + bArr6.length + bArr2.length + bArr7.length];
        System.arraycopy(bArr4, 0, bArr8, 0, bArr4.length);
        int length = bArr4.length + 0;
        System.arraycopy(bArr5, 0, bArr8, length, bArr5.length);
        int length2 = length + bArr5.length;
        System.arraycopy(bArr3, 0, bArr8, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        System.arraycopy(bArr, 0, bArr8, length3, 8);
        int i = length3 + 8;
        System.arraycopy(bArr6, 0, bArr8, i, bArr6.length);
        int length4 = i + bArr6.length;
        System.arraycopy(bArr2, 0, bArr8, length4, bArr2.length);
        int length5 = length4 + bArr2.length;
        System.arraycopy(bArr7, 0, bArr8, length5, bArr7.length);
        int length6 = length5 + bArr7.length;
        return bArr8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static int m1864f(byte[] bArr, int i) {
        if (bArr.length < i + 2) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
        }
        return (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8);
    }

    /* renamed from: f */
    private static String m1865f(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(".");
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static byte[] m1866f() {
        if (f21854q == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] bArr = new byte[16];
        synchronized (f21854q) {
            f21854q.nextBytes(bArr);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static String m1863g(String str) {
        return m1865f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static byte[] m1862g(byte[] bArr, int i) {
        int m1864f = m1864f(bArr, i);
        int m1868e = m1868e(bArr, i + 4);
        if (bArr.length < m1868e + m1864f) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
        }
        byte[] bArr2 = new byte[m1864f];
        System.arraycopy(bArr, m1868e, bArr2, 0, m1864f);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static String m1861h(String str) {
        return m1865f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static Key m1860h(byte[] bArr, int i) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, i, bArr2, 0, 7);
        byte[] bArr3 = {bArr2[0], (byte) ((bArr2[0] << 7) | ((bArr2[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >>> 1)), (byte) ((bArr2[1] << 6) | ((bArr2[2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >>> 2)), (byte) ((bArr2[2] << 5) | ((bArr2[3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >>> 3)), (byte) ((bArr2[3] << 4) | ((bArr2[4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >>> 4)), (byte) ((bArr2[4] << 3) | ((bArr2[5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >>> 5)), (byte) ((bArr2[5] << 2) | ((bArr2[6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >>> 6)), (byte) (bArr2[6] << 1)};
        m1895a(bArr3);
        return new SecretKeySpec(bArr3, "DES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static byte[] m1859i(String str) {
        try {
            byte[] bytes = str.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
            byte[] bArr = new byte[14];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 14));
            Key m1860h = m1860h(bArr, 0);
            Key m1860h2 = m1860h(bArr, 7);
            byte[] bytes2 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, m1860h);
            byte[] doFinal = cipher.doFinal(bytes2);
            cipher.init(1, m1860h2);
            byte[] doFinal2 = cipher.doFinal(bytes2);
            byte[] bArr2 = new byte[16];
            System.arraycopy(doFinal, 0, bArr2, 0, 8);
            System.arraycopy(doFinal2, 0, bArr2, 8, 8);
            return bArr2;
        } catch (Exception e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static byte[] m1858j(String str) {
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            C5158c c5158c = new C5158c();
            c5158c.m1833a(bytes);
            return c5158c.m1834a();
        } catch (UnsupportedEncodingException e) {
            throw new NTLMEngineException("Unicode not supported: " + e.getMessage(), e);
        }
    }

    /* renamed from: a */
    String m1903a() {
        return this.f21856r;
    }

    /* renamed from: a */
    String m1899a(String str, String str2) {
        return new C5160e(str2, str).mo1812c();
    }

    /* renamed from: a */
    final String m1898a(String str, String str2, String str3, String str4, String str5) {
        if (str == null || str.trim().equals("")) {
            return m1899a(str4, str5);
        }
        C5161f c5161f = new C5161f(str);
        return m1897a(str2, str3, str4, str5, c5161f.m1816d(), c5161f.m1813g(), c5161f.m1815e(), c5161f.m1814f());
    }

    /* renamed from: a */
    String m1897a(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) {
        return new C5162g(str4, str3, str, str2, bArr, i, str5, bArr2).mo1812c();
    }

    /* renamed from: a */
    void m1900a(String str) {
        this.f21856r = str;
    }

    public String generateType1Msg(String str, String str2) {
        return m1899a(str2, str);
    }

    public String generateType3Msg(String str, String str2, String str3, String str4, String str5) {
        C5161f c5161f = new C5161f(str5);
        return m1897a(str, str2, str4, str3, c5161f.m1816d(), c5161f.m1813g(), c5161f.m1815e(), c5161f.m1814f());
    }
}
