package com.tencent.open.p228a;

import com.tencent.open.p228a.C4324d;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.tencent.open.a.b */
/* loaded from: classes.dex */
public class C4319b {

    /* renamed from: a */
    private static SimpleDateFormat f18078a = C4324d.C4329e.m5451a("yyyy-MM-dd");

    /* renamed from: b */
    private static FileFilter f18079b = new FileFilter() { // from class: com.tencent.open.a.b.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && C4319b.m5487a(file) > 0;
        }
    };

    /* renamed from: h */
    private File f18085h;

    /* renamed from: c */
    private String f18080c = "Tracer.File";

    /* renamed from: d */
    private int f18081d = Integer.MAX_VALUE;

    /* renamed from: e */
    private int f18082e = Integer.MAX_VALUE;

    /* renamed from: f */
    private int f18083f = 4096;

    /* renamed from: g */
    private long f18084g = AbstractC0517a.f1169e;

    /* renamed from: i */
    private int f18086i = 10;

    /* renamed from: j */
    private String f18087j = ".log";

    /* renamed from: k */
    private long f18088k = Long.MAX_VALUE;

    /* renamed from: l */
    private FileFilter f18089l = new FileFilter() { // from class: com.tencent.open.a.b.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(C4319b.this.m5465i()) && C4319b.m5468f(file) != -1;
        }
    };

    /* renamed from: m */
    private Comparator<? super File> f18090m = new Comparator<File>() { // from class: com.tencent.open.a.b.3
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return C4319b.m5468f(file) - C4319b.m5468f(file2);
        }
    };

    public C4319b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        m5476c(file);
        m5483b(i);
        m5489a(i2);
        m5478c(i3);
        m5486a(str);
        m5482b(j);
        m5474d(i4);
        m5480b(str2);
        m5477c(j2);
    }

    /* renamed from: a */
    public static long m5487a(File file) {
        try {
            return f18078a.parse(file.getName()).getTime();
        } catch (Exception e) {
            return -1L;
        }
    }

    /* renamed from: d */
    private File m5473d(long j) {
        return m5470e(m5488a(j));
    }

    /* renamed from: e */
    private File m5470e(File file) {
        File[] m5481b = m5481b(file);
        if (m5481b == null || m5481b.length == 0) {
            return new File(file, "1" + m5465i());
        }
        m5485a(m5481b);
        File file2 = m5481b[m5481b.length - 1];
        int length = m5481b.length - m5471e();
        if (((int) file2.length()) > m5475d()) {
            file2 = new File(file, (m5468f(file2) + 1) + m5465i());
            length++;
        }
        for (int i = 0; i < length; i++) {
            m5481b[i].delete();
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static int m5468f(File file) {
        try {
            String name = file.getName();
            return Integer.parseInt(name.substring(0, name.indexOf(46)));
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: a */
    public File m5490a() {
        return m5473d(System.currentTimeMillis());
    }

    /* renamed from: a */
    public File m5488a(long j) {
        File file = new File(m5467g(), f18078a.format(Long.valueOf(j)));
        file.mkdirs();
        return file;
    }

    /* renamed from: a */
    public void m5489a(int i) {
        this.f18081d = i;
    }

    /* renamed from: a */
    public void m5486a(String str) {
        this.f18080c = str;
    }

    /* renamed from: a */
    public File[] m5485a(File[] fileArr) {
        Arrays.sort(fileArr, this.f18090m);
        return fileArr;
    }

    /* renamed from: b */
    public void m5484b() {
        File[] listFiles;
        if (m5467g() == null || (listFiles = m5467g().listFiles(f18079b)) == null) {
            return;
        }
        for (File file : listFiles) {
            if (System.currentTimeMillis() - m5487a(file) > m5464j()) {
                C4324d.C4326b.m5461a(file);
            }
        }
    }

    /* renamed from: b */
    public void m5483b(int i) {
        this.f18082e = i;
    }

    /* renamed from: b */
    public void m5482b(long j) {
        this.f18084g = j;
    }

    /* renamed from: b */
    public void m5480b(String str) {
        this.f18087j = str;
    }

    /* renamed from: b */
    public File[] m5481b(File file) {
        return file.listFiles(this.f18089l);
    }

    /* renamed from: c */
    public String m5479c() {
        return this.f18080c;
    }

    /* renamed from: c */
    public void m5478c(int i) {
        this.f18083f = i;
    }

    /* renamed from: c */
    public void m5477c(long j) {
        this.f18088k = j;
    }

    /* renamed from: c */
    public void m5476c(File file) {
        this.f18085h = file;
    }

    /* renamed from: d */
    public int m5475d() {
        return this.f18081d;
    }

    /* renamed from: d */
    public void m5474d(int i) {
        this.f18086i = i;
    }

    /* renamed from: e */
    public int m5471e() {
        return this.f18082e;
    }

    /* renamed from: f */
    public int m5469f() {
        return this.f18083f;
    }

    /* renamed from: g */
    public File m5467g() {
        return this.f18085h;
    }

    /* renamed from: h */
    public int m5466h() {
        return this.f18086i;
    }

    /* renamed from: i */
    public String m5465i() {
        return this.f18087j;
    }

    /* renamed from: j */
    public long m5464j() {
        return this.f18088k;
    }
}
