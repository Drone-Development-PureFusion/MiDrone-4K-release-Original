package com.p080b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.zip.CRC32;
/* renamed from: com.b.bo */
/* loaded from: classes.dex */
public class C1472bo {

    /* renamed from: a */
    public String f5112a = "1";

    /* renamed from: b */
    public short f5113b = 0;

    /* renamed from: c */
    public String f5114c = null;

    /* renamed from: d */
    public String f5115d = null;

    /* renamed from: e */
    public String f5116e = null;

    /* renamed from: f */
    public String f5117f = null;

    /* renamed from: g */
    public String f5118g = null;

    /* renamed from: h */
    public String f5119h = null;

    /* renamed from: i */
    public String f5120i = null;

    /* renamed from: j */
    public String f5121j = null;

    /* renamed from: k */
    public String f5122k = null;

    /* renamed from: l */
    public String f5123l = null;

    /* renamed from: m */
    public String f5124m = null;

    /* renamed from: n */
    public String f5125n = null;

    /* renamed from: o */
    public String f5126o = null;

    /* renamed from: p */
    public String f5127p = null;

    /* renamed from: q */
    public String f5128q = null;

    /* renamed from: r */
    public String f5129r = null;

    /* renamed from: s */
    public String f5130s = null;

    /* renamed from: t */
    public String f5131t = null;

    /* renamed from: u */
    public String f5132u = null;

    /* renamed from: v */
    public String f5133v = null;

    /* renamed from: w */
    public String f5134w = null;

    /* renamed from: x */
    public String f5135x = null;

    /* renamed from: y */
    public String f5136y = null;

    /* renamed from: z */
    public String f5137z = null;

    /* renamed from: A */
    public String f5105A = null;

    /* renamed from: B */
    public String f5106B = null;

    /* renamed from: C */
    public String f5107C = null;

    /* renamed from: D */
    public String f5108D = null;

    /* renamed from: E */
    public String f5109E = null;

    /* renamed from: F */
    public String f5110F = null;

    /* renamed from: G */
    public byte[] f5111G = null;

    /* renamed from: a */
    private String m16059a(String str, int i) {
        String[] split = this.f5106B.split("\\*")[i].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (str.equals("lac")) {
            return split[0];
        }
        if (str.equals("cellid")) {
            return split[1];
        }
        if (!str.equals("signal")) {
            return null;
        }
        return split[2];
    }

    /* renamed from: a */
    public static void m16058a(byte[] bArr, int i) {
    }

    /* renamed from: b */
    private byte[] m16056b(String str) {
        String[] split = str.split(":");
        if (split == null || split.length != 6) {
            String[] strArr = new String[6];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = "0";
            }
            split = strArr;
        }
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].length() > 2) {
                split[i2] = split[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(split[i2], 16);
        }
        return bArr;
    }

    /* renamed from: a */
    public String m16060a(String str) {
        if (!this.f5105A.contains(str + ">")) {
            return "0";
        }
        int indexOf = this.f5105A.indexOf(str + ">");
        return this.f5105A.substring(indexOf + str.length() + 1, this.f5105A.indexOf("</" + str));
    }

    /* renamed from: a */
    public byte[] m16061a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int length;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        m16057b();
        int i18 = 3072;
        if (this.f5111G != null) {
            i18 = 3072 + this.f5111G.length + 1;
        }
        byte[] bArr = new byte[i18];
        bArr[0] = Byte.parseByte(this.f5112a);
        byte[] m15995b = C1477bs.m15995b((int) this.f5113b);
        System.arraycopy(m15995b, 0, bArr, 1, m15995b.length);
        int length2 = m15995b.length + 1;
        try {
            byte[] bytes = this.f5114c.getBytes("GBK");
            bArr[length2] = (byte) bytes.length;
            length2++;
            System.arraycopy(bytes, 0, bArr, length2, bytes.length);
            i = length2 + bytes.length;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Req", "buildV4Dot2");
            bArr[length2] = 0;
            i = length2 + 1;
        }
        try {
            byte[] bytes2 = this.f5115d.getBytes("GBK");
            bArr[i] = (byte) bytes2.length;
            i++;
            System.arraycopy(bytes2, 0, bArr, i, bytes2.length);
            i2 = i + bytes2.length;
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "Req", "buildV4Dot21");
            bArr[i] = 0;
            i2 = i + 1;
        }
        try {
            byte[] bytes3 = this.f5126o.getBytes("GBK");
            bArr[i2] = (byte) bytes3.length;
            i2++;
            System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
            i3 = i2 + bytes3.length;
        } catch (Throwable th3) {
            C1514cx.m15728a(th3, "Req", "buildV4Dot22");
            bArr[i2] = 0;
            i3 = i2 + 1;
        }
        try {
            byte[] bytes4 = this.f5116e.getBytes("GBK");
            bArr[i3] = (byte) bytes4.length;
            i3++;
            System.arraycopy(bytes4, 0, bArr, i3, bytes4.length);
            i4 = i3 + bytes4.length;
        } catch (Throwable th4) {
            C1514cx.m15728a(th4, "Req", "buildV4Dot23");
            bArr[i3] = 0;
            i4 = i3 + 1;
        }
        try {
            byte[] bytes5 = this.f5117f.getBytes("GBK");
            bArr[i4] = (byte) bytes5.length;
            i4++;
            System.arraycopy(bytes5, 0, bArr, i4, bytes5.length);
            i5 = i4 + bytes5.length;
        } catch (Throwable th5) {
            C1514cx.m15728a(th5, "Req", "buildV4Dot24");
            bArr[i4] = 0;
            i5 = i4 + 1;
        }
        try {
            byte[] bytes6 = this.f5118g.getBytes("GBK");
            bArr[i5] = (byte) bytes6.length;
            i5++;
            System.arraycopy(bytes6, 0, bArr, i5, bytes6.length);
            i6 = i5 + bytes6.length;
        } catch (Throwable th6) {
            C1514cx.m15728a(th6, "Req", "buildV4Dot25");
            bArr[i5] = 0;
            i6 = i5 + 1;
        }
        try {
            byte[] bytes7 = this.f5132u.getBytes("GBK");
            bArr[i6] = (byte) bytes7.length;
            i6++;
            System.arraycopy(bytes7, 0, bArr, i6, bytes7.length);
            i7 = i6 + bytes7.length;
        } catch (Throwable th7) {
            C1514cx.m15728a(th7, "Req", "buildV4Dot26");
            bArr[i6] = 0;
            i7 = i6 + 1;
        }
        try {
            byte[] bytes8 = this.f5119h.getBytes("GBK");
            bArr[i7] = (byte) bytes8.length;
            i7++;
            System.arraycopy(bytes8, 0, bArr, i7, bytes8.length);
            i8 = i7 + bytes8.length;
        } catch (Throwable th8) {
            C1514cx.m15728a(th8, "Req", "buildV4Dot27");
            bArr[i7] = 0;
            i8 = i7 + 1;
        }
        try {
            byte[] bytes9 = this.f5127p.getBytes("GBK");
            bArr[i8] = (byte) bytes9.length;
            i8++;
            System.arraycopy(bytes9, 0, bArr, i8, bytes9.length);
            i9 = i8 + bytes9.length;
        } catch (Throwable th9) {
            C1514cx.m15728a(th9, "Req", "buildV4Dot28");
            bArr[i8] = 0;
            i9 = i8 + 1;
        }
        try {
            byte[] bytes10 = this.f5128q.getBytes("GBK");
            bArr[i9] = (byte) bytes10.length;
            i9++;
            System.arraycopy(bytes10, 0, bArr, i9, bytes10.length);
            i10 = bytes10.length + i9;
        } catch (Throwable th10) {
            C1514cx.m15728a(th10, "Req", "buildV4Dot29");
            bArr[i9] = 0;
            i10 = i9 + 1;
        }
        if (TextUtils.isEmpty(this.f5131t)) {
            bArr[i10] = 0;
            length = i10 + 1;
        } else {
            byte[] m16056b = m16056b(this.f5131t);
            bArr[i10] = (byte) m16056b.length;
            int i19 = i10 + 1;
            System.arraycopy(m16056b, 0, bArr, i19, m16056b.length);
            length = m16056b.length + i19;
        }
        try {
            byte[] bytes11 = this.f5133v.getBytes("GBK");
            bArr[length] = (byte) bytes11.length;
            length++;
            System.arraycopy(bytes11, 0, bArr, length, bytes11.length);
            i11 = length + bytes11.length;
        } catch (Throwable th11) {
            C1514cx.m15728a(th11, "Req", "buildV4Dot211");
            bArr[length] = 0;
            i11 = length + 1;
        }
        try {
            byte[] bytes12 = this.f5134w.getBytes("GBK");
            bArr[i11] = (byte) bytes12.length;
            i11++;
            System.arraycopy(bytes12, 0, bArr, i11, bytes12.length);
            i12 = i11 + bytes12.length;
        } catch (Throwable th12) {
            C1514cx.m15728a(th12, "Req", "buildV4Dot212");
            bArr[i11] = 0;
            i12 = i11 + 1;
        }
        try {
            byte[] bytes13 = this.f5135x.getBytes("GBK");
            bArr[i12] = (byte) bytes13.length;
            i12++;
            System.arraycopy(bytes13, 0, bArr, i12, bytes13.length);
            i13 = bytes13.length + i12;
        } catch (Throwable th13) {
            C1514cx.m15728a(th13, "Req", "buildV4Dot213");
            bArr[i12] = 0;
            i13 = i12 + 1;
        }
        bArr[i13] = Byte.parseByte(this.f5136y);
        int i20 = i13 + 1;
        bArr[i20] = Byte.parseByte(this.f5121j);
        int i21 = i20 + 1;
        if (this.f5121j.equals("1")) {
            bArr[i21] = Byte.parseByte(this.f5122k);
            i21++;
        }
        if (this.f5121j.equals("1") || this.f5121j.equals("2")) {
            byte[] m15989c = C1477bs.m15989c(Integer.parseInt(this.f5123l));
            System.arraycopy(m15989c, 0, bArr, i21, m15989c.length);
            i21 += m15989c.length;
        }
        if (this.f5121j.equals("1") || this.f5121j.equals("2")) {
            byte[] m15989c2 = C1477bs.m15989c(Integer.parseInt(this.f5124m));
            System.arraycopy(m15989c2, 0, bArr, i21, m15989c2.length);
            i21 += m15989c2.length;
        }
        if (this.f5121j.equals("1") || this.f5121j.equals("2")) {
            byte[] m15980e = C1477bs.m15980e(this.f5125n);
            System.arraycopy(m15980e, 0, bArr, i21, m15980e.length);
            i21 += m15980e.length;
        }
        bArr[i21] = Byte.parseByte(this.f5137z);
        int i22 = i21 + 1;
        if (this.f5137z.equals("1")) {
            byte[] m15980e2 = C1477bs.m15980e(m16060a("mcc"));
            System.arraycopy(m15980e2, 0, bArr, i22, m15980e2.length);
            int length3 = i22 + m15980e2.length;
            byte[] m15980e3 = C1477bs.m15980e(m16060a("mnc"));
            System.arraycopy(m15980e3, 0, bArr, length3, m15980e3.length);
            int length4 = length3 + m15980e3.length;
            byte[] m15980e4 = C1477bs.m15980e(m16060a("lac"));
            System.arraycopy(m15980e4, 0, bArr, length4, m15980e4.length);
            int length5 = length4 + m15980e4.length;
            byte[] m15978f = C1477bs.m15978f(m16060a("cellid"));
            System.arraycopy(m15978f, 0, bArr, length5, m15978f.length);
            int length6 = m15978f.length + length5;
            int parseInt = Integer.parseInt(m16060a("signal"));
            if (parseInt > 127) {
                parseInt = 0;
            }
            bArr[length6] = (byte) parseInt;
            int i23 = length6 + 1;
            if (this.f5106B.length() == 0) {
                bArr[i23] = 0;
                i22 = i23 + 1;
            } else {
                int length7 = this.f5106B.split("\\*").length;
                bArr[i23] = (byte) length7;
                i22 = i23 + 1;
                int i24 = 0;
                while (i24 < length7) {
                    byte[] m15980e5 = C1477bs.m15980e(m16059a("lac", i24));
                    System.arraycopy(m15980e5, 0, bArr, i22, m15980e5.length);
                    int length8 = i22 + m15980e5.length;
                    byte[] m15978f2 = C1477bs.m15978f(m16059a("cellid", i24));
                    System.arraycopy(m15978f2, 0, bArr, length8, m15978f2.length);
                    int length9 = m15978f2.length + length8;
                    int parseInt2 = Integer.parseInt(m16059a("signal", i24));
                    if (parseInt2 > 127) {
                        parseInt2 = 0;
                    }
                    bArr[length9] = (byte) parseInt2;
                    i24++;
                    i22 = length9 + 1;
                }
            }
        } else if (this.f5137z.equals("2")) {
            byte[] m15980e6 = C1477bs.m15980e(m16060a("mcc"));
            System.arraycopy(m15980e6, 0, bArr, i22, m15980e6.length);
            int length10 = i22 + m15980e6.length;
            byte[] m15980e7 = C1477bs.m15980e(m16060a("sid"));
            System.arraycopy(m15980e7, 0, bArr, length10, m15980e7.length);
            int length11 = length10 + m15980e7.length;
            byte[] m15980e8 = C1477bs.m15980e(m16060a("nid"));
            System.arraycopy(m15980e8, 0, bArr, length11, m15980e8.length);
            int length12 = length11 + m15980e8.length;
            byte[] m15980e9 = C1477bs.m15980e(m16060a("bid"));
            System.arraycopy(m15980e9, 0, bArr, length12, m15980e9.length);
            int length13 = length12 + m15980e9.length;
            byte[] m15978f3 = C1477bs.m15978f(m16060a("lon"));
            System.arraycopy(m15978f3, 0, bArr, length13, m15978f3.length);
            int length14 = length13 + m15978f3.length;
            byte[] m15978f4 = C1477bs.m15978f(m16060a("lat"));
            System.arraycopy(m15978f4, 0, bArr, length14, m15978f4.length);
            int length15 = m15978f4.length + length14;
            int parseInt3 = Integer.parseInt(m16060a("signal"));
            if (parseInt3 > 127) {
                parseInt3 = 0;
            }
            bArr[length15] = (byte) parseInt3;
            int i25 = length15 + 1;
            bArr[i25] = 0;
            i22 = i25 + 1;
        }
        if (this.f5107C.length() == 0) {
            bArr[i22] = 0;
            i14 = i22 + 1;
        } else {
            bArr[i22] = 1;
            int i26 = i22 + 1;
            try {
                String[] split = this.f5107C.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                byte[] m16056b2 = m16056b(split[0]);
                System.arraycopy(m16056b2, 0, bArr, i26, m16056b2.length);
                int length16 = i26 + m16056b2.length;
                byte[] bytes14 = split[2].getBytes("GBK");
                bArr[length16] = (byte) bytes14.length;
                int i27 = length16 + 1;
                System.arraycopy(bytes14, 0, bArr, i27, bytes14.length);
                i26 = i27 + bytes14.length;
                int parseInt4 = Integer.parseInt(split[1]);
                if (parseInt4 > 127) {
                    parseInt4 = 0;
                }
                bArr[i26] = Byte.parseByte(String.valueOf(parseInt4));
                i14 = i26 + 1;
            } catch (Throwable th14) {
                C1514cx.m15728a(th14, "Req", "buildV4Dot216");
                byte[] m16056b3 = m16056b("00:00:00:00:00:00");
                System.arraycopy(m16056b3, 0, bArr, i26, m16056b3.length);
                int length17 = m16056b3.length + i26;
                bArr[length17] = 0;
                int i28 = length17 + 1;
                bArr[i28] = Byte.parseByte("0");
                i14 = i28 + 1;
            }
        }
        String[] split2 = this.f5108D.split("\\*");
        if (TextUtils.isEmpty(this.f5108D) || split2.length == 0) {
            bArr[i14] = 0;
            i15 = i14 + 1;
        } else {
            bArr[i14] = (byte) split2.length;
            int i29 = i14 + 1;
            int i30 = 0;
            while (i30 < split2.length) {
                String[] split3 = split2[i30].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                byte[] m16056b4 = m16056b(split3[0]);
                System.arraycopy(m16056b4, 0, bArr, i29, m16056b4.length);
                int length18 = m16056b4.length + i29;
                try {
                    byte[] bytes15 = split3[2].getBytes("GBK");
                    bArr[length18] = (byte) bytes15.length;
                    length18++;
                    System.arraycopy(bytes15, 0, bArr, length18, bytes15.length);
                    i17 = bytes15.length + length18;
                } catch (Throwable th15) {
                    C1514cx.m15728a(th15, "Req", "buildV4Dot217");
                    bArr[length18] = 0;
                    i17 = length18 + 1;
                }
                int parseInt5 = Integer.parseInt(split3[1]);
                if (parseInt5 > 127) {
                    parseInt5 = 0;
                }
                bArr[i17] = Byte.parseByte(String.valueOf(parseInt5));
                i30++;
                i29 = i17 + 1;
            }
            byte[] m15995b2 = C1477bs.m15995b(Integer.parseInt(this.f5109E));
            System.arraycopy(m15995b2, 0, bArr, i29, m15995b2.length);
            i15 = m15995b2.length + i29;
        }
        try {
            byte[] bytes16 = this.f5110F.getBytes("GBK");
            if (bytes16.length > 127) {
                bytes16 = null;
            }
            if (bytes16 == null) {
                bArr[i15] = 0;
                i16 = i15 + 1;
            } else {
                bArr[i15] = (byte) bytes16.length;
                int i31 = i15 + 1;
                System.arraycopy(bytes16, 0, bArr, i31, bytes16.length);
                i16 = bytes16.length + i31;
            }
        } catch (Throwable th16) {
            C1514cx.m15728a(th16, "Req", "buildV4Dot218");
            bArr[i15] = 0;
            i16 = i15 + 1;
        }
        int length19 = this.f5111G != null ? this.f5111G.length : 0;
        byte[] m15995b3 = C1477bs.m15995b(length19);
        System.arraycopy(m15995b3, 0, bArr, i16, m15995b3.length);
        int length20 = i16 + m15995b3.length;
        if (length19 > 0) {
            System.arraycopy(this.f5111G, 0, bArr, length20, this.f5111G.length);
            length20 += this.f5111G.length;
        }
        byte[] bArr2 = new byte[length20];
        System.arraycopy(bArr, 0, bArr2, 0, length20);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr2);
        byte[] m16016a = C1477bs.m16016a(crc32.getValue());
        byte[] bArr3 = new byte[m16016a.length + length20];
        System.arraycopy(bArr2, 0, bArr3, 0, length20);
        System.arraycopy(m16016a, 0, bArr3, length20, m16016a.length);
        int length21 = length20 + m16016a.length;
        m16058a(bArr3, 0);
        return bArr3;
    }

    /* renamed from: b */
    public void m16057b() {
        if (TextUtils.isEmpty(this.f5112a)) {
            this.f5112a = "";
        }
        if (TextUtils.isEmpty(this.f5114c)) {
            this.f5114c = "";
        }
        if (TextUtils.isEmpty(this.f5115d)) {
            this.f5115d = "";
        }
        if (TextUtils.isEmpty(this.f5116e)) {
            this.f5116e = "";
        }
        if (TextUtils.isEmpty(this.f5117f)) {
            this.f5117f = "";
        }
        if (TextUtils.isEmpty(this.f5118g)) {
            this.f5118g = "";
        }
        if (TextUtils.isEmpty(this.f5119h)) {
            this.f5119h = "";
        }
        if (TextUtils.isEmpty(this.f5120i)) {
            this.f5120i = "";
        }
        if (TextUtils.isEmpty(this.f5121j)) {
            this.f5121j = "0";
        } else if (!this.f5121j.equals("1") && !this.f5121j.equals("2")) {
            this.f5121j = "0";
        }
        if (TextUtils.isEmpty(this.f5122k)) {
            this.f5122k = "0";
        } else if (!this.f5122k.equals("0") && !this.f5122k.equals("1")) {
            this.f5122k = "0";
        }
        if (TextUtils.isEmpty(this.f5123l)) {
            this.f5123l = "";
        }
        if (TextUtils.isEmpty(this.f5124m)) {
            this.f5124m = "";
        }
        if (TextUtils.isEmpty(this.f5125n)) {
            this.f5125n = "";
        }
        if (TextUtils.isEmpty(this.f5126o)) {
            this.f5126o = "";
        }
        if (TextUtils.isEmpty(this.f5127p)) {
            this.f5127p = "";
        }
        if (TextUtils.isEmpty(this.f5128q)) {
            this.f5128q = "";
        }
        if (TextUtils.isEmpty(this.f5129r)) {
            this.f5129r = "";
        }
        if (TextUtils.isEmpty(this.f5130s)) {
            this.f5130s = "";
        }
        if (TextUtils.isEmpty(this.f5131t)) {
            this.f5131t = "";
        }
        if (TextUtils.isEmpty(this.f5132u)) {
            this.f5132u = "";
        }
        if (TextUtils.isEmpty(this.f5133v)) {
            this.f5133v = "";
        }
        if (TextUtils.isEmpty(this.f5134w)) {
            this.f5134w = "";
        }
        if (TextUtils.isEmpty(this.f5135x)) {
            this.f5135x = "";
        }
        if (TextUtils.isEmpty(this.f5136y)) {
            this.f5136y = "0";
        } else if (!this.f5136y.equals("1") && !this.f5136y.equals("2")) {
            this.f5136y = "0";
        }
        if (TextUtils.isEmpty(this.f5137z)) {
            this.f5137z = "0";
        } else if (!this.f5137z.equals("1") && !this.f5137z.equals("2")) {
            this.f5137z = "0";
        }
        if (TextUtils.isEmpty(this.f5105A)) {
            this.f5105A = "";
        }
        if (TextUtils.isEmpty(this.f5106B)) {
            this.f5106B = "";
        }
        if (TextUtils.isEmpty(this.f5107C)) {
            this.f5107C = "";
        }
        if (TextUtils.isEmpty(this.f5108D)) {
            this.f5108D = "";
        }
        if (TextUtils.isEmpty(this.f5109E)) {
            this.f5109E = "";
        }
        if (TextUtils.isEmpty(this.f5110F)) {
            this.f5110F = "";
        }
        if (this.f5111G == null) {
            this.f5111G = new byte[0];
        }
    }
}
