package com.fimi.soul.module.setting;

import com.fimi.soul.utils.C3681j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.module.setting.f */
/* loaded from: classes.dex */
public class C3495f implements Serializable {

    /* renamed from: a */
    public static final String f13782a = ".vfm";

    /* renamed from: f */
    long f13787f;

    /* renamed from: i */
    boolean f13790i;

    /* renamed from: j */
    private boolean f13791j;

    /* renamed from: k */
    private long f13792k;

    /* renamed from: l */
    private long f13793l;

    /* renamed from: q */
    private int f13798q;

    /* renamed from: r */
    private long f13799r;

    /* renamed from: s */
    private String f13800s;

    /* renamed from: b */
    String f13783b = "";

    /* renamed from: c */
    String f13784c = "";

    /* renamed from: d */
    int f13785d = 0;

    /* renamed from: e */
    String f13786e = "0 k";

    /* renamed from: g */
    int f13788g = 0;

    /* renamed from: h */
    boolean f13789h = false;

    /* renamed from: m */
    private List<C3495f> f13794m = new ArrayList();

    /* renamed from: n */
    private List<C3495f> f13795n = new ArrayList();

    /* renamed from: o */
    private List<C3495f> f13796o = new ArrayList();

    /* renamed from: p */
    private int f13797p = 1;

    /* renamed from: A */
    public boolean m8280A() {
        return this.f13791j;
    }

    /* renamed from: B */
    public boolean m8279B() {
        return this.f13790i;
    }

    /* renamed from: a */
    public List<C3495f> m8278a() {
        return this.f13794m;
    }

    /* renamed from: a */
    public void m8277a(int i) {
        this.f13785d = i;
    }

    /* renamed from: a */
    public void m8276a(long j) {
        this.f13792k = j;
        this.f13793l = this.f13792k;
    }

    /* renamed from: a */
    public void m8275a(String str) {
        m8265c(str);
        m8269b(str);
        m8262d(str);
    }

    /* renamed from: a */
    public void m8274a(List<C3495f> list) {
        this.f13794m = list;
    }

    /* renamed from: a */
    public void m8273a(boolean z) {
        this.f13789h = z;
    }

    /* renamed from: b */
    public List<C3495f> m8272b() {
        return this.f13795n;
    }

    /* renamed from: b */
    public void m8271b(int i) {
        this.f13788g = i;
    }

    /* renamed from: b */
    public void m8270b(long j) {
        this.f13787f = j;
    }

    /* renamed from: b */
    public void m8269b(String str) {
        File[] listFiles;
        File file = new File(C3681j.m7463p() + "/" + C3681j.m7462q() + "/" + str);
        if (!file.exists() || (listFiles = new File(file.getAbsolutePath()).listFiles(new FilenameFilter() { // from class: com.fimi.soul.module.setting.f.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.toLowerCase().endsWith(C3495f.f13782a);
            }
        })) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].length() > 0) {
                C3495f c3495f = new C3495f();
                c3495f.m8260e(listFiles[i].getName());
                c3495f.m8277a(0);
                c3495f.m8258f(listFiles[i].getAbsolutePath());
                c3495f.m8271b(0);
                c3495f.m8276a(listFiles[i].length());
                this.f13794m.add(c3495f);
                this.f13797p++;
                this.f13793l += listFiles[i].length();
            }
        }
    }

    /* renamed from: b */
    public void m8268b(List<C3495f> list) {
        this.f13795n = list;
    }

    /* renamed from: b */
    public void m8267b(boolean z) {
        this.f13791j = z;
    }

    /* renamed from: c */
    public List<C3495f> m8266c() {
        return this.f13796o;
    }

    /* renamed from: c */
    public void m8265c(String str) {
        File[] listFiles;
        File file = new File(C3681j.m7463p() + "/" + C3681j.m7461r() + "/" + str);
        if (!file.exists() || (listFiles = new File(file.getAbsolutePath()).listFiles(new FilenameFilter() { // from class: com.fimi.soul.module.setting.f.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.toLowerCase().endsWith(C3495f.f13782a);
            }
        })) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].length() > 0) {
                C3495f c3495f = new C3495f();
                c3495f.m8260e(listFiles[i].getName());
                c3495f.m8277a(0);
                c3495f.m8258f(listFiles[i].getAbsolutePath());
                c3495f.m8271b(0);
                c3495f.m8276a(listFiles[i].length());
                this.f13795n.add(c3495f);
                this.f13797p++;
                this.f13793l += listFiles[i].length();
            }
        }
    }

    /* renamed from: c */
    public void m8264c(boolean z) {
        this.f13790i = z;
    }

    /* renamed from: d */
    public long m8263d() {
        return this.f13792k;
    }

    /* renamed from: d */
    public void m8262d(String str) {
        File[] listFiles;
        File file = new File(C3681j.m7463p() + "/" + C3681j.m7460s() + "/" + str);
        if (!file.exists() || (listFiles = new File(file.getAbsolutePath()).listFiles(new FilenameFilter() { // from class: com.fimi.soul.module.setting.f.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.toLowerCase().endsWith(C3495f.f13782a);
            }
        })) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].length() > 0) {
                C3495f c3495f = new C3495f();
                c3495f.m8260e(listFiles[i].getName());
                c3495f.m8277a(0);
                c3495f.m8258f(listFiles[i].getAbsolutePath());
                c3495f.m8271b(0);
                c3495f.m8276a(listFiles[i].length());
                this.f13796o.add(c3495f);
                this.f13797p++;
                this.f13793l += listFiles[i].length();
            }
        }
    }

    /* renamed from: e */
    public long m8261e() {
        return this.f13793l;
    }

    /* renamed from: e */
    public void m8260e(String str) {
        this.f13783b = str;
    }

    /* renamed from: f */
    public int m8259f() {
        return this.f13797p;
    }

    /* renamed from: f */
    public void m8258f(String str) {
        this.f13784c = str;
        this.f13800s = str;
    }

    /* renamed from: g */
    public void m8257g() {
        if (this.f13798q == 0) {
            this.f13799r = this.f13792k;
            return;
        }
        int size = this.f13794m.size();
        int size2 = this.f13795n.size();
        if (this.f13798q - 1 < size) {
            this.f13799r = this.f13794m.get(this.f13798q - 1).m8263d() + this.f13799r;
        } else if ((this.f13798q - 1) - size >= size2) {
        } else {
            this.f13799r = this.f13795n.get((this.f13798q - 1) - size).m8263d() + this.f13799r;
        }
    }

    /* renamed from: g */
    public void m8256g(String str) {
        this.f13786e = str;
    }

    /* renamed from: h */
    public void m8255h() {
        if (this.f13798q == 0) {
            return;
        }
        int size = this.f13794m.size();
        int size2 = this.f13795n.size();
        if (this.f13798q - 1 < size) {
            C3495f c3495f = this.f13794m.get(this.f13798q - 1);
            c3495f.m8260e(c3495f.m8242u().replace(".", "&synced."));
        } else if ((this.f13798q - 1) - size >= size2) {
        } else {
            C3495f c3495f2 = this.f13795n.get((this.f13798q - 1) - size);
            c3495f2.m8260e(c3495f2.m8242u().replace(".", "&synced."));
        }
    }

    /* renamed from: i */
    public int m8254i() {
        int size = this.f13794m.size();
        int size2 = this.f13795n.size();
        if (this.f13798q - 1 < size) {
            return 5;
        }
        return (this.f13798q + (-1)) - size < size2 ? 4 : 0;
    }

    /* renamed from: j */
    public long m8253j() {
        return this.f13799r;
    }

    /* renamed from: k */
    public void m8252k() {
        this.f13798q++;
    }

    /* renamed from: l */
    public boolean m8251l() {
        return this.f13798q == this.f13797p;
    }

    /* renamed from: m */
    public boolean m8250m() {
        return this.f13798q < this.f13797p;
    }

    /* renamed from: n */
    public C3495f m8249n() {
        int size = this.f13794m.size();
        int size2 = this.f13795n.size();
        if (this.f13798q - 1 < size) {
            C3495f c3495f = this.f13794m.get(this.f13798q - 1);
            this.f13800s = c3495f.m8241v();
            return c3495f;
        } else if ((this.f13798q - 1) - size >= size2) {
            return null;
        } else {
            C3495f c3495f2 = this.f13795n.get((this.f13798q - 1) - size);
            this.f13800s = c3495f2.m8241v();
            return c3495f2;
        }
    }

    /* renamed from: o */
    public String m8248o() {
        return this.f13800s;
    }

    /* renamed from: p */
    public boolean m8247p() {
        if (this.f13794m != null) {
            for (C3495f c3495f : this.f13794m) {
                if (!c3495f.m8242u().contains("&synced")) {
                    return false;
                }
            }
        }
        if (this.f13795n != null) {
            for (C3495f c3495f2 : this.f13795n) {
                if (!c3495f2.m8242u().contains("&synced")) {
                    return false;
                }
            }
        }
        return this.f13783b.contains("&synced");
    }

    /* renamed from: q */
    public boolean m8246q() {
        return this.f13783b.contains("&synced");
    }

    /* renamed from: r */
    public boolean m8245r() {
        return this.f13783b.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && this.f13783b.contains(" ");
    }

    /* renamed from: s */
    public boolean m8244s() {
        return this.f13783b.contains(".sf") || this.f13783b.contains(".fc");
    }

    /* renamed from: t */
    public boolean m8243t() {
        return this.f13789h;
    }

    public String toString() {
        return "LogFileEntity{fileName='" + this.f13783b + C0359h.f729z + ", path='" + this.f13784c + C0359h.f729z + ", hasSync=" + this.f13785d + ", fileSize='" + this.f13786e + C0359h.f729z + ", createDate=" + this.f13787f + ", percent=" + this.f13788g + ", iselect=" + this.f13789h + ", isTitleItem=" + this.f13791j + C0359h.f726w;
    }

    /* renamed from: u */
    public String m8242u() {
        return this.f13783b;
    }

    /* renamed from: v */
    public String m8241v() {
        return this.f13784c;
    }

    /* renamed from: w */
    public int m8240w() {
        return this.f13785d;
    }

    /* renamed from: x */
    public String m8239x() {
        return this.f13786e;
    }

    /* renamed from: y */
    public long m8238y() {
        return this.f13787f;
    }

    /* renamed from: z */
    public int m8237z() {
        return this.f13788g;
    }
}
