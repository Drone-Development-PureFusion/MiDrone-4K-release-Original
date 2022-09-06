package com.github.moduth.blockcanary.p215b;

import android.os.Environment;
import com.github.moduth.blockcanary.C3953c;
import java.io.File;
import java.io.FilenameFilter;
/* renamed from: com.github.moduth.blockcanary.b.b */
/* loaded from: classes.dex */
public final class C3948b {

    /* renamed from: com.github.moduth.blockcanary.b.b$a */
    /* loaded from: classes.dex */
    static class C3949a implements FilenameFilter {

        /* renamed from: a */
        private String f16936a = ".txt";

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f16936a);
        }
    }

    private C3948b() {
        throw new AssertionError();
    }

    /* renamed from: a */
    public static String m6393a() {
        return (!"mounted".equals(Environment.getExternalStorageState()) || !Environment.getExternalStorageDirectory().canWrite()) ? Environment.getDataDirectory().getAbsolutePath() + C3953c.m6380b().mo6366c() : Environment.getExternalStorageDirectory().getPath() + (C3953c.m6380b() == null ? "" : C3953c.m6380b().mo6366c());
    }

    /* renamed from: b */
    public static File m6392b() {
        File file = new File(m6393a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: c */
    public static File[] m6391c() {
        File m6392b = m6392b();
        if (!m6392b.exists() || !m6392b.isDirectory()) {
            return null;
        }
        return m6392b.listFiles(new C3949a());
    }
}
