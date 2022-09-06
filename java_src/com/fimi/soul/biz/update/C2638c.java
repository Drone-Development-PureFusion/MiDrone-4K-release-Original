package com.fimi.soul.biz.update;

import android.content.Context;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p162e.C2230b;
import com.fimi.kernel.utils.C2269n;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.utils.C3681j;
import com.p118d.p119a.p136c.C1947c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* renamed from: com.fimi.soul.biz.update.c */
/* loaded from: classes.dex */
public class C2638c extends AbstractC2636b {

    /* renamed from: f */
    public static final String f9138f = "firmware.zip";

    /* renamed from: g */
    private static final String f9139g = "x1";

    /* renamed from: h */
    private C2230b f9140h;

    public C2638c() {
        this.f9140h = null;
        this.f9140h = (C2230b) C2238c.m13128a(EnumC2222d.Volley);
    }

    /* renamed from: a */
    public static String m11411a(String str) {
        if (str != null) {
            int indexOf = str.indexOf(86);
            int indexOf2 = str.indexOf(66);
            int indexOf3 = str.indexOf("SP");
            if (indexOf3 > 0 && indexOf < indexOf3) {
                return str.substring(indexOf + 1, indexOf3);
            }
            if (indexOf < indexOf2) {
                return str.substring(indexOf + 1, indexOf2);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m11410b() {
        return String.format("%s%s", C3681j.m7457v(), "firmware.zip");
    }

    /* renamed from: c */
    public static String m11409c() {
        return String.format("%s%s", C3681j.m7457v(), C3587b.f14557Z);
    }

    /* renamed from: d */
    public static String m11408d() {
        return "fimware.zip";
    }

    /* renamed from: e */
    public static String m11407e() {
        return C2269n.m12887b(m11408d(), ".zip") + ".bin";
    }

    /* renamed from: a */
    public void m11414a(Context context) {
        String format = String.format("%s/%s/%s", C3681j.m7482a(), "firmware", "firmware.zip");
        File file = new File(String.format("%s/%s", C3681j.m7482a(), "firmware"));
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(format);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            m11412a(context.getAssets().open("firmware.zip"), String.format("%s/%s/%s", C3681j.m7482a(), "firmware", "firmware.zip"));
        } catch (Exception e) {
            C2284z.m12695a(context, "写文件出错：" + e.getMessage());
        }
    }

    /* renamed from: a */
    public void m11413a(AbstractC2651g abstractC2651g) {
        if (i() == null) {
            abstractC2651g.mo6430a(true, 0L, 0L, 0);
        } else {
            a(i(), m11410b(), abstractC2651g);
        }
    }

    /* renamed from: a */
    public void m11412a(InputStream inputStream, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str, true);
            byte[] bArr = new byte[C1947c.f6940b];
            while (true) {
                int read = inputStream.read(bArr, 0, C1947c.f6940b);
                if (read == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
