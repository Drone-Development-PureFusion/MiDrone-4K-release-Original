package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;
import java.util.Map;
import javax.crypto.KeyGenerator;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.amap.api.mapcore.util.fb */
/* loaded from: classes.dex */
public class C0986fb {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.fb$a */
    /* loaded from: classes.dex */
    public static class C0988a {

        /* renamed from: a */
        String f3094a;

        /* renamed from: b */
        String f3095b;

        /* renamed from: c */
        String f3096c;

        /* renamed from: d */
        String f3097d;

        /* renamed from: e */
        String f3098e;

        /* renamed from: f */
        String f3099f;

        /* renamed from: g */
        String f3100g;

        /* renamed from: h */
        String f3101h;

        /* renamed from: i */
        String f3102i;

        /* renamed from: j */
        String f3103j;

        /* renamed from: k */
        String f3104k;

        /* renamed from: l */
        String f3105l;

        /* renamed from: m */
        String f3106m;

        /* renamed from: n */
        String f3107n;

        /* renamed from: o */
        String f3108o;

        /* renamed from: p */
        String f3109p;

        /* renamed from: q */
        String f3110q;

        /* renamed from: r */
        String f3111r;

        /* renamed from: s */
        String f3112s;

        /* renamed from: t */
        String f3113t;

        private C0988a() {
        }
    }

    /* renamed from: a */
    public static String m18151a() {
        String str;
        Throwable th;
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                int length = valueOf.length();
                return valueOf.substring(0, length - 2) + "1" + valueOf.substring(length - 1);
            } catch (Throwable th2) {
                str = valueOf;
                th = th2;
                C1002fl.m18028a(th, "CInfo", "getTS");
                return str;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
    }

    /* renamed from: a */
    public static String m18150a(Context context) {
        try {
            C0988a c0988a = new C0988a();
            c0988a.f3097d = C0976ey.m18169c(context);
            c0988a.f3102i = C0976ey.m18168d(context);
            return m18149a(context, c0988a);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "InitXInfo");
            return null;
        }
    }

    /* renamed from: a */
    private static String m18149a(Context context, C0988a c0988a) {
        return C0991fd.m18102a(m18141b(context, c0988a));
    }

    @Deprecated
    /* renamed from: a */
    public static String m18148a(Context context, C0996fh c0996fh, Map<String, String> map, boolean z) {
        try {
            return m18149a(context, m18140b(context, z));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "rsaLocClineInfo");
            return null;
        }
    }

    /* renamed from: a */
    public static String m18146a(Context context, String str, String str2) {
        try {
            return C0992fe.m18092b(C0976ey.m18167e(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "Scode");
            return null;
        }
    }

    /* renamed from: a */
    public static void m18143a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            C0999fi.m18049a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, C0999fi.m18047a(str));
        } else {
            C0999fi.m18049a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* renamed from: a */
    private static byte[] m18147a(Context context, ByteArrayOutputStream byteArrayOutputStream) {
        return m18138c(context, C0999fi.m18041b(byteArrayOutputStream.toByteArray()));
    }

    /* renamed from: a */
    public static byte[] m18145a(Context context, boolean z) {
        try {
            return m18141b(context, m18140b(context, z));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "getGZipXInfo");
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m18144a(Context context, byte[] bArr) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey m18051a = C0999fi.m18051a(context);
        if (m18051a == null) {
            return null;
        }
        byte[] m18101a = C0991fd.m18101a(encoded, m18051a);
        byte[] m18100a = C0991fd.m18100a(encoded, bArr);
        byte[] bArr2 = new byte[m18101a.length + m18100a.length];
        System.arraycopy(m18101a, 0, bArr2, 0, m18101a.length);
        System.arraycopy(m18100a, 0, bArr2, m18101a.length, m18100a.length);
        return bArr2;
    }

    /* renamed from: b */
    private static C0988a m18140b(Context context, boolean z) {
        C0988a c0988a = new C0988a();
        c0988a.f3094a = C0989fc.m18113q(context);
        c0988a.f3095b = C0989fc.m18121i(context);
        String m18124f = C0989fc.m18124f(context);
        if (m18124f == null) {
            m18124f = "";
        }
        c0988a.f3096c = m18124f;
        c0988a.f3097d = C0976ey.m18169c(context);
        c0988a.f3098e = Build.MODEL;
        c0988a.f3099f = Build.MANUFACTURER;
        c0988a.f3100g = Build.DEVICE;
        c0988a.f3101h = C0976ey.m18170b(context);
        c0988a.f3102i = C0976ey.m18168d(context);
        c0988a.f3103j = String.valueOf(Build.VERSION.SDK_INT);
        c0988a.f3104k = C0989fc.m18112r(context);
        c0988a.f3105l = C0989fc.m18114p(context);
        c0988a.f3106m = C0989fc.m18117m(context) + "";
        c0988a.f3107n = C0989fc.m18118l(context) + "";
        c0988a.f3108o = C0989fc.m18111s(context);
        c0988a.f3109p = C0989fc.m18119k(context);
        if (z) {
            c0988a.f3110q = "";
        } else {
            c0988a.f3110q = C0989fc.m18122h(context);
        }
        if (z) {
            c0988a.f3111r = "";
        } else {
            c0988a.f3111r = C0989fc.m18123g(context);
        }
        if (z) {
            c0988a.f3112s = "";
            c0988a.f3113t = "";
        } else {
            String[] m18120j = C0989fc.m18120j(context);
            c0988a.f3112s = m18120j[0];
            c0988a.f3113t = m18120j[1];
        }
        return c0988a;
    }

    /* renamed from: b */
    public static String m18142b(Context context) {
        try {
            return m18149a(context, m18140b(context, false));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "getClientXInfo");
            return null;
        }
    }

    /* renamed from: b */
    public static String m18139b(Context context, byte[] bArr) {
        try {
            return m18137d(context, bArr);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "AESData");
            return "";
        }
    }

    /* renamed from: b */
    private static byte[] m18141b(Context context, C0988a c0988a) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                m18143a(byteArrayOutputStream, c0988a.f3094a);
                m18143a(byteArrayOutputStream, c0988a.f3095b);
                m18143a(byteArrayOutputStream, c0988a.f3096c);
                m18143a(byteArrayOutputStream, c0988a.f3097d);
                m18143a(byteArrayOutputStream, c0988a.f3098e);
                m18143a(byteArrayOutputStream, c0988a.f3099f);
                m18143a(byteArrayOutputStream, c0988a.f3100g);
                m18143a(byteArrayOutputStream, c0988a.f3101h);
                m18143a(byteArrayOutputStream, c0988a.f3102i);
                m18143a(byteArrayOutputStream, c0988a.f3103j);
                m18143a(byteArrayOutputStream, c0988a.f3104k);
                m18143a(byteArrayOutputStream, c0988a.f3105l);
                m18143a(byteArrayOutputStream, c0988a.f3106m);
                m18143a(byteArrayOutputStream, c0988a.f3107n);
                m18143a(byteArrayOutputStream, c0988a.f3108o);
                m18143a(byteArrayOutputStream, c0988a.f3109p);
                m18143a(byteArrayOutputStream, c0988a.f3110q);
                m18143a(byteArrayOutputStream, c0988a.f3111r);
                m18143a(byteArrayOutputStream, c0988a.f3112s);
                m18143a(byteArrayOutputStream, c0988a.f3113t);
                bArr = m18147a(context, byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    C1002fl.m18028a(th, "CInfo", "InitXInfo");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    return bArr;
                } finally {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m18138c(Context context, byte[] bArr) {
        PublicKey m18051a = C0999fi.m18051a(context);
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[Opcodes.LNEG];
            System.arraycopy(bArr, 0, bArr2, 0, Opcodes.LNEG);
            byte[] m18101a = C0991fd.m18101a(bArr2, m18051a);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(m18101a, 0, bArr3, 0, 128);
            System.arraycopy(bArr, Opcodes.LNEG, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return C0991fd.m18101a(bArr, m18051a);
    }

    /* renamed from: d */
    static String m18137d(Context context, byte[] bArr) {
        byte[] m18041b = C0999fi.m18041b(m18144a(context, bArr));
        return m18041b != null ? C0991fd.m18102a(m18041b) : "";
    }

    /* renamed from: e */
    public static String m18136e(Context context, byte[] bArr) {
        try {
            return m18137d(context, bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
