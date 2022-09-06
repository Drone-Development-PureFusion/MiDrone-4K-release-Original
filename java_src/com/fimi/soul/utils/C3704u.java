package com.fimi.soul.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/* renamed from: com.fimi.soul.utils.u */
/* loaded from: classes.dex */
public class C3704u {
    /* renamed from: a */
    public static FileOutputStream m7421a() {
        File file = new File(C3681j.m7479b());
        file.mkdirs();
        File file2 = new File(file, "Parameters-" + C3695s.m7432a() + ".param");
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    /* renamed from: a */
    public static FileOutputStream m7420a(String str) {
        File file = new File(C3681j.m7476c());
        file.mkdirs();
        File file2 = new File(file, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + C3695s.m7432a() + ".txt");
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    /* renamed from: b */
    public static FileOutputStream m7419b() {
        File file = new File(C3681j.m7471h());
        file.mkdirs();
        File file2 = new File(file, C3695s.m7432a() + ".txt");
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    /* renamed from: c */
    public static BufferedOutputStream m7418c() {
        File file = new File(C3681j.m7474e());
        file.mkdirs();
        File file2 = new File(file, C3695s.m7432a() + ".tlog");
        if (file2.exists()) {
            file2.delete();
        }
        return new BufferedOutputStream(new FileOutputStream(file2));
    }

    /* renamed from: d */
    public static void m7417d() {
        File file = new File(C3681j.m7473f());
        file.mkdirs();
        new File(file, ".nomedia").createNewFile();
    }
}
