package com.fimi.soul.utils;

import java.io.File;
import java.io.FilenameFilter;
/* renamed from: com.fimi.soul.utils.r */
/* loaded from: classes.dex */
public class C3690r {
    /* renamed from: a */
    public static String[] m7437a() {
        return m7436a(C3681j.m7476c(), new FilenameFilter() { // from class: com.fimi.soul.utils.r.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.contains(".txt");
            }
        });
    }

    /* renamed from: a */
    public static String[] m7436a(String str, FilenameFilter filenameFilter) {
        File file = new File(str);
        try {
            file.mkdirs();
            if (file.exists()) {
                return file.list(filenameFilter);
            }
        } catch (SecurityException e) {
        }
        return new String[0];
    }

    /* renamed from: b */
    public static String[] m7435b() {
        return m7436a(C3681j.m7479b(), new FilenameFilter() { // from class: com.fimi.soul.utils.r.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.contains(".param");
            }
        });
    }

    /* renamed from: c */
    public static String[] m7434c() {
        return m7436a(C3681j.m7475d(), new FilenameFilter() { // from class: com.fimi.soul.utils.r.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.contains(".kml") || str.contains(".kmz");
            }
        });
    }

    /* renamed from: d */
    public static String[] m7433d() {
        return m7436a(C3681j.m7472g(), new FilenameFilter() { // from class: com.fimi.soul.utils.r.4
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.contains(".xml");
            }
        });
    }
}
