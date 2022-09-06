package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.string.C4504a;
import com.xiaomi.xmpush.thrift.C4764aa;
import com.xiaomi.xmpush.thrift.C4766ab;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4776ag;
import com.xiaomi.xmpush.thrift.C4780ai;
import com.xiaomi.xmpush.thrift.C4782aj;
import com.xiaomi.xmpush.thrift.C4786al;
import com.xiaomi.xmpush.thrift.C4790an;
import com.xiaomi.xmpush.thrift.C4794ap;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4828u;
import com.xiaomi.xmpush.thrift.C4832w;
import com.xiaomi.xmpush.thrift.C4834x;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p283b.AbstractC5358a;
/* renamed from: com.xiaomi.mipush.sdk.q */
/* loaded from: classes2.dex */
public class C4541q {

    /* renamed from: a */
    private static final byte[] f18658a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, SmileConstants.TOKEN_KEY_LONG_STRING, 84, 102, 18, 32};

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static <T extends AbstractC5358a<T, ?>> C4766ab m4837a(Context context, T t, EnumC4763a enumC4763a) {
        return m4836a(context, t, enumC4763a, !enumC4763a.equals(EnumC4763a.Registration), context.getPackageName(), C4520a.m4909a(context).m4901c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static <T extends AbstractC5358a<T, ?>> C4766ab m4836a(Context context, T t, EnumC4763a enumC4763a, boolean z, String str, String str2) {
        byte[] m3471a = C4796aq.m3471a(t);
        if (m3471a == null) {
            AbstractC4478b.m5041a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        C4766ab c4766ab = new C4766ab();
        if (z) {
            String m4898f = C4520a.m4909a(context).m4898f();
            if (TextUtils.isEmpty(m4898f)) {
                AbstractC4478b.m5041a("regSecret is empty, return null");
                return null;
            }
            try {
                m3471a = m4832b(C4504a.m4959a(m4898f), m3471a);
            } catch (Exception e) {
                AbstractC4478b.m5036d("encryption error. ");
            }
        }
        C4828u c4828u = new C4828u();
        c4828u.f20500a = 5L;
        c4828u.f20501b = "fakeid";
        c4766ab.m3747a(c4828u);
        c4766ab.m3745a(ByteBuffer.wrap(m3471a));
        c4766ab.m3750a(enumC4763a);
        c4766ab.m3738c(true);
        c4766ab.m3741b(str);
        c4766ab.m3744a(z);
        c4766ab.m3746a(str2);
        return c4766ab;
    }

    /* renamed from: a */
    private static Cipher m4834a(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f18658a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    /* renamed from: a */
    public static AbstractC5358a m4838a(Context context, C4766ab c4766ab) {
        byte[] m3734f;
        if (c4766ab.m3739c()) {
            try {
                m3734f = m4833a(C4504a.m4959a(C4520a.m4909a(context).m4898f()), c4766ab.m3734f());
            } catch (Exception e) {
                throw new C4525c("the aes decrypt failed.", e);
            }
        } else {
            m3734f = c4766ab.m3734f();
        }
        AbstractC5358a m4835a = m4835a(c4766ab.m3751a(), c4766ab.f19626c);
        if (m4835a != null) {
            C4796aq.m3470a(m4835a, m3734f);
        }
        return m4835a;
    }

    /* renamed from: a */
    private static AbstractC5358a m4835a(EnumC4763a enumC4763a, boolean z) {
        switch (C4542r.f18659a[enumC4763a.ordinal()]) {
            case 1:
                return new C4776ag();
            case 2:
                return new C4790an();
            case 3:
                return new C4786al();
            case 4:
                return new C4794ap();
            case 5:
                return new C4782aj();
            case 6:
                return new C4832w();
            case 7:
                return new C4764aa();
            case 8:
                return new C4780ai();
            case 9:
                if (z) {
                    return new C4772ae();
                }
                C4834x c4834x = new C4834x();
                c4834x.m3195a(true);
                return c4834x;
            case 10:
                return new C4764aa();
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static byte[] m4833a(byte[] bArr, byte[] bArr2) {
        return m4834a(bArr, 2).doFinal(bArr2);
    }

    /* renamed from: b */
    public static byte[] m4832b(byte[] bArr, byte[] bArr2) {
        return m4834a(bArr, 1).doFinal(bArr2);
    }
}
