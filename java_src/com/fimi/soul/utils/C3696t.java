package com.fimi.soul.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
/* renamed from: com.fimi.soul.utils.t */
/* loaded from: classes.dex */
public class C3696t {

    /* renamed from: com.fimi.soul.utils.t$a */
    /* loaded from: classes.dex */
    public class C3701a implements FilenameFilter {
        public C3701a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return new File(new StringBuilder().append(file.getAbsolutePath()).append("/").append(str).toString()).isDirectory();
        }
    }

    /* renamed from: com.fimi.soul.utils.t$b */
    /* loaded from: classes.dex */
    public class C3702b implements FilenameFilter {

        /* renamed from: a */
        String f15107a;

        public C3702b(String str) {
            this.f15107a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(this.f15107a) && !str.contains("&synced");
        }
    }

    /* renamed from: com.fimi.soul.utils.t$c */
    /* loaded from: classes.dex */
    public class C3703c implements FilenameFilter {

        /* renamed from: a */
        String f15109a;

        public C3703c(String str) {
            this.f15109a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(this.f15109a);
        }
    }

    /* renamed from: a */
    public String m7429a(String str) {
        File[] listFiles = new File(str).listFiles(new C3701a());
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.fimi.soul.utils.t.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        return listFiles[0].getAbsolutePath();
    }

    /* renamed from: a */
    public boolean m7430a(File file) {
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (String str : list) {
                if (!m7430a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    public File[] m7428a(String str, String str2) {
        File[] listFiles = new File(str).listFiles(new C3703c(str2));
        if (listFiles != null && listFiles.length > 0) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.fimi.soul.utils.t.4
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file, File file2) {
                    return (int) (file2.lastModified() - file.lastModified());
                }
            });
        }
        return listFiles;
    }

    /* renamed from: b */
    public String m7427b(String str) {
        File[] listFiles = new File(str).listFiles(new C3702b(".fc"));
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.fimi.soul.utils.t.2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        return listFiles[0].getName().replace(".fc", "");
    }

    /* renamed from: c */
    public File[] m7426c(String str) {
        File[] listFiles = new File(str).listFiles(new C3701a());
        if (listFiles != null && listFiles.length > 0) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.fimi.soul.utils.t.3
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file, File file2) {
                    return file2.getName().compareTo(file.getName());
                }
            });
        }
        return listFiles;
    }
}
