package com.amap.api.services.core;

import android.content.Context;
import android.os.Build;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
/* renamed from: com.amap.api.services.core.y */
/* loaded from: classes.dex */
public class C1261y {
    /* renamed from: a */
    public static String m16917a() {
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
                C1190ay.m17177a(th, "CInfo", "getTS");
                th.printStackTrace();
                return str;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
    }

    /* renamed from: a */
    public static String m16916a(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"").append(C1259w.m16920f(context)).append("\",\"ct\":\"android\",\"ime\":\"").append(C1262z.m16892m(context)).append("\",\"pkg\":\"").append(C1259w.m16924b(context)).append("\",\"mod\":\"").append(Build.MODEL).append("\",\"apn\":\"").append(C1259w.m16926a(context)).append("\",\"apv\":\"").append(C1259w.m16923c(context)).append("\",\"sv\":\"").append(Build.VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            C1190ay.m17177a(th, "CInfo", "getPublicJSONInfo");
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m16915a(Context context, C1166ad c1166ad) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sim\":\"").append(C1262z.m16888q(context)).append("\",\"av\":\"").append(c1166ad.f3980a).append("\",\"pro\":\"").append(c1166ad.f3982c).append("\",\"ed\":\"").append(c1166ad.m17261d()).append("\",\"nt\":\"").append(C1262z.m16894k(context)).append("\",\"np\":\"").append(C1262z.m16889p(context)).append("\",\"mnc\":\"").append(C1262z.m16900e(context)).append("\",\"lnt\":\"").append(C1262z.m16899f(context)).append("\",\"ant\":\"").append(C1262z.m16897h(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m16914a(Context context, C1166ad c1166ad, Map<String, String> map) {
        try {
            String m16911b = m16911b(context, c1166ad, map);
            if (!"".equals(m16911b)) {
                return m16910b(context, m16911b.getBytes("utf-8"));
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            C1190ay.m17177a(e, "CInfo", "rsaInfo");
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m16913a(Context context, String str, String str2) {
        try {
            return C1164ab.m17277a(C1259w.m16922d(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "CInfo", "Scode");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m16912a(Context context, byte[] bArr) {
        try {
            return m16909c(context, bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        } catch (CertificateException e4) {
            e4.printStackTrace();
            return "";
        } catch (InvalidKeySpecException e5) {
            e5.printStackTrace();
            return "";
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return "";
        } catch (IllegalBlockSizeException e7) {
            e7.printStackTrace();
            return "";
        } catch (NoSuchPaddingException e8) {
            e8.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static String m16911b(Context context, C1166ad c1166ad, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        try {
            String m16892m = C1262z.m16892m(context);
            sb.append("ct=android");
            sb.append("&ime=").append(m16892m);
            sb.append("&pkg=").append(C1259w.m16924b(context));
            sb.append("&mod=");
            sb.append(Build.MODEL);
            sb.append("&apn=").append(C1259w.m16926a(context));
            sb.append("&apv=").append(C1259w.m16923c(context));
            sb.append("&sv=");
            sb.append(Build.VERSION.RELEASE);
            sb.append("&sim=").append(C1262z.m16891n(context));
            sb.append("&av=").append(c1166ad.f3980a);
            sb.append("&pro=").append(c1166ad.f3982c);
            sb.append("&cid=").append(C1262z.m16901d(context));
            sb.append("&dmac=").append(C1262z.m16902c(context));
            sb.append("&wmac=").append(C1262z.m16903b(context));
            sb.append("&nt=");
            sb.append(C1262z.m16893l(context));
            String m16890o = C1262z.m16890o(context);
            sb.append("&np=");
            sb.append(m16890o);
            sb.append("&ia=1&");
            String m16907a = C1262z.m16907a(context);
            if (m16907a == null) {
                m16907a = "";
            }
            sb.append("utd=").append(m16907a).append("&");
            String m16920f = C1259w.m16920f(context);
            if (m16920f != null && m16920f.length() > 0) {
                sb.append("key=");
                sb.append(m16920f);
                sb.append("&");
            }
            sb.append("ctm=" + System.currentTimeMillis());
            sb.append("&re=" + C1262z.m16895j(context));
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "CInfo", "InitXInfo");
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m16910b(Context context, byte[] bArr) {
        try {
            return m16909c(context, bArr);
        } catch (IOException e) {
            C1190ay.m17177a(e, "CInfo", "AESData");
            e.printStackTrace();
            return "";
        } catch (InvalidKeyException e2) {
            C1190ay.m17177a(e2, "CInfo", "AESData");
            e2.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e3) {
            C1190ay.m17177a(e3, "CInfo", "AESData");
            e3.printStackTrace();
            return "";
        } catch (CertificateException e4) {
            C1190ay.m17177a(e4, "CInfo", "AESData");
            e4.printStackTrace();
            return "";
        } catch (InvalidKeySpecException e5) {
            C1190ay.m17177a(e5, "CInfo", "AESData");
            e5.printStackTrace();
            return "";
        } catch (BadPaddingException e6) {
            C1190ay.m17177a(e6, "CInfo", "AESData");
            e6.printStackTrace();
            return "";
        } catch (IllegalBlockSizeException e7) {
            C1190ay.m17177a(e7, "CInfo", "AESData");
            e7.printStackTrace();
            return "";
        } catch (NoSuchPaddingException e8) {
            C1190ay.m17177a(e8, "CInfo", "AESData");
            e8.printStackTrace();
            return "";
        } catch (Throwable th) {
            C1190ay.m17177a(th, "CInfo", "AESData");
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    private static String m16909c(Context context, byte[] bArr) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey m17248a = C1169ae.m17248a(context);
        if (m17248a == null) {
            return null;
        }
        byte[] m17283a = C1163aa.m17283a(encoded, m17248a);
        byte[] m17282a = C1163aa.m17282a(encoded, bArr);
        byte[] bArr2 = new byte[m17283a.length + m17282a.length];
        System.arraycopy(m17283a, 0, bArr2, 0, m17283a.length);
        System.arraycopy(m17282a, 0, bArr2, m17283a.length, m17282a.length);
        byte[] m17246a = C1169ae.m17246a(bArr2);
        return m17246a != null ? C1163aa.m17284a(m17246a) : "";
    }
}
