package com.p080b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
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
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.b.do */
/* loaded from: classes.dex */
public class C1535do {
    /* renamed from: a */
    public static String m15654a() {
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
                C1450b.m16187a(th, "CInfo", "getTS");
                return str;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
    }

    /* renamed from: a */
    public static String m15653a(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"").append(C1533dm.m15662f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(C1542dq.m15615q(context)).append("\",\"pkg\":\"").append(C1533dm.m15666c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appname\":\"").append(C1533dm.m15668b(context)).append("\",\"appversion\":\"").append(C1533dm.m15664d(context)).append("\",\"sysversion\":\"").append(Build.VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            C1450b.m16187a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m15652a(Context context, C1549dv c1549dv) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sim\":\"").append(C1542dq.m15627e(context)).append("\",\"sdkversion\":\"").append(c1549dv.f5527a).append("\",\"product\":\"").append(c1549dv.f5529c).append("\",\"ed\":\"").append(c1549dv.m15576d()).append("\",\"nt\":\"").append(C1542dq.m15629c(context)).append("\",\"np\":\"").append(C1542dq.m15635a(context)).append("\",\"mnc\":\"").append(C1542dq.m15630b(context)).append("\",\"ant\":\"").append(C1542dq.m15628d(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m15651a(Context context, C1549dv c1549dv, Map<String, String> map, boolean z) {
        byte[] m15605a;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m15647a(byteArrayOutputStream, C1542dq.m15615q(context));
            m15647a(byteArrayOutputStream, C1542dq.m15623i(context));
            String m15626f = C1542dq.m15626f(context);
            if (m15626f == null) {
                m15626f = "";
            }
            m15647a(byteArrayOutputStream, m15626f);
            m15647a(byteArrayOutputStream, C1533dm.m15666c(context));
            m15647a(byteArrayOutputStream, Build.MODEL);
            m15647a(byteArrayOutputStream, Build.MANUFACTURER);
            m15647a(byteArrayOutputStream, Build.DEVICE);
            m15647a(byteArrayOutputStream, C1533dm.m15668b(context));
            m15647a(byteArrayOutputStream, C1533dm.m15664d(context));
            m15647a(byteArrayOutputStream, String.valueOf(Build.VERSION.SDK_INT));
            m15647a(byteArrayOutputStream, C1542dq.m15614r(context));
            m15647a(byteArrayOutputStream, C1542dq.m15616p(context));
            m15647a(byteArrayOutputStream, C1542dq.m15619m(context) + "");
            m15647a(byteArrayOutputStream, C1542dq.m15620l(context) + "");
            m15647a(byteArrayOutputStream, C1542dq.m15613s(context));
            m15647a(byteArrayOutputStream, C1542dq.m15621k(context));
            if (z) {
                m15647a(byteArrayOutputStream, "");
            } else {
                m15647a(byteArrayOutputStream, C1542dq.m15624h(context));
            }
            if (z) {
                m15647a(byteArrayOutputStream, "");
            } else {
                m15647a(byteArrayOutputStream, C1542dq.m15625g(context));
            }
            if (z) {
                m15647a(byteArrayOutputStream, "");
                m15647a(byteArrayOutputStream, "");
            } else {
                String[] m15622j = C1542dq.m15622j(context);
                m15647a(byteArrayOutputStream, m15622j[0]);
                m15647a(byteArrayOutputStream, m15622j[1]);
            }
            byte[] m15556a = C1552dw.m15556a(byteArrayOutputStream.toByteArray());
            PublicKey m15561a = C1552dw.m15561a(context);
            if (m15556a.length > 117) {
                byte[] bArr = new byte[Opcodes.LNEG];
                System.arraycopy(m15556a, 0, bArr, 0, Opcodes.LNEG);
                byte[] m15605a2 = C1544dr.m15605a(bArr, m15561a);
                m15605a = new byte[(m15556a.length + 128) - 117];
                System.arraycopy(m15605a2, 0, m15605a, 0, 128);
                System.arraycopy(m15556a, Opcodes.LNEG, m15605a, 128, m15556a.length - 117);
            } else {
                m15605a = C1544dr.m15605a(m15556a, m15561a);
            }
            return C1544dr.m15602b(m15605a);
        } catch (Throwable th) {
            C1450b.m16187a(th, "CInfo", "InitXInfo");
            return null;
        }
    }

    /* renamed from: a */
    public static String m15650a(Context context, String str, String str2) {
        try {
            return C1545ds.m15596b(C1533dm.m15663e(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            C1450b.m16187a(th, "CInfo", "Scode");
            return null;
        }
    }

    /* renamed from: a */
    public static String m15649a(Context context, byte[] bArr) {
        try {
            return m15646b(context, bArr);
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

    /* renamed from: a */
    private static void m15648a(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        boolean z = true;
        try {
            byteArrayOutputStream.write(new byte[]{b});
            boolean z2 = b > 0;
            if ((b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >= 255) {
                z = false;
            }
            if (z && z2) {
                byteArrayOutputStream.write(bArr);
            } else if ((b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            C1450b.m16187a(e, "CInfo", "writeField");
        }
    }

    /* renamed from: a */
    private static void m15647a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            m15648a(byteArrayOutputStream, (byte) 0, new byte[0]);
            return;
        }
        byte length = str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length;
        try {
            m15648a(byteArrayOutputStream, length, str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            m15648a(byteArrayOutputStream, length, str.getBytes());
        }
    }

    /* renamed from: b */
    static String m15646b(Context context, byte[] bArr) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey m15561a = C1552dw.m15561a(context);
        if (m15561a == null) {
            return null;
        }
        byte[] m15605a = C1544dr.m15605a(encoded, m15561a);
        byte[] m15604a = C1544dr.m15604a(encoded, bArr);
        byte[] bArr2 = new byte[m15605a.length + m15604a.length];
        System.arraycopy(m15605a, 0, bArr2, 0, m15605a.length);
        System.arraycopy(m15604a, 0, bArr2, m15605a.length, m15604a.length);
        byte[] m15556a = C1552dw.m15556a(bArr2);
        return m15556a != null ? C1544dr.m15602b(m15556a) : "";
    }

    /* renamed from: c */
    public static String m15645c(Context context, byte[] bArr) {
        try {
            return m15646b(context, bArr);
        } catch (IOException e) {
            C1450b.m16187a(e, "CInfo", "AESData");
            return "";
        } catch (InvalidKeyException e2) {
            C1450b.m16187a(e2, "CInfo", "AESData");
            return "";
        } catch (NoSuchAlgorithmException e3) {
            C1450b.m16187a(e3, "CInfo", "AESData");
            return "";
        } catch (CertificateException e4) {
            C1450b.m16187a(e4, "CInfo", "AESData");
            return "";
        } catch (InvalidKeySpecException e5) {
            C1450b.m16187a(e5, "CInfo", "AESData");
            return "";
        } catch (BadPaddingException e6) {
            C1450b.m16187a(e6, "CInfo", "AESData");
            return "";
        } catch (IllegalBlockSizeException e7) {
            C1450b.m16187a(e7, "CInfo", "AESData");
            return "";
        } catch (NoSuchPaddingException e8) {
            C1450b.m16187a(e8, "CInfo", "AESData");
            return "";
        } catch (Throwable th) {
            C1450b.m16187a(th, "CInfo", "AESData");
            return "";
        }
    }
}
