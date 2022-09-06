package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* renamed from: com.amap.api.mapcore.util.hi */
/* loaded from: classes.dex */
public class C1080hi {

    /* renamed from: a */
    private Context f3375a;

    /* renamed from: b */
    private String f3376b;

    /* renamed from: c */
    private String f3377c;

    /* renamed from: d */
    private String f3378d;

    /* renamed from: e */
    private String f3379e;

    public C1080hi(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new C0975ex("无效的参数 - IllegalArgumentException");
        }
        this.f3375a = context.getApplicationContext();
        this.f3377c = str;
        this.f3378d = str2;
        this.f3376b = str3;
    }

    /* renamed from: a */
    public void m17679a(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new C0975ex("无效的参数 - IllegalArgumentException");
        }
        this.f3379e = str;
    }

    /* renamed from: a */
    public byte[] m17681a() {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = new byte[0];
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            C0999fi.m18048a(byteArrayOutputStream, this.f3377c);
            C0999fi.m18048a(byteArrayOutputStream, this.f3378d);
            C0999fi.m18048a(byteArrayOutputStream, this.f3376b);
            C0999fi.m18048a(byteArrayOutputStream, String.valueOf(C0989fc.m18117m(this.f3375a)));
            new SimpleDateFormat("SSS").format(new Date());
            byteArrayOutputStream.write(m17680a(Calendar.getInstance().get(14)));
            byteArrayOutputStream.write(m17678b(this.f3379e));
            byteArrayOutputStream.write(C0999fi.m18047a(this.f3379e));
            bArr = byteArrayOutputStream.toByteArray();
            if (byteArrayOutputStream != null) {
                try {
                } catch (Throwable th2) {
                    return bArr;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                C1002fl.m18028a(th, "StatisticsEntity", "toDatas");
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th = th4;
                        return bArr;
                    }
                }
                return bArr;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public byte[] m17680a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: b */
    public byte[] m17678b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        int length = str.length();
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }
}
