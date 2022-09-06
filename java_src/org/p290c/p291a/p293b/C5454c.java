package org.p290c.p291a.p293b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.C5629j;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5606b;
/* renamed from: org.c.a.b.c */
/* loaded from: classes2.dex */
public class C5454c implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final Map<String, Long> f22522a = new HashMap();

    /* renamed from: b */
    private final Map<String, Long> f22523b = new HashMap();

    /* renamed from: c */
    private final File f22524c;

    /* renamed from: org.c.a.b.c$a */
    /* loaded from: classes2.dex */
    private final class C5456a extends C5606b {

        /* renamed from: b */
        private long f22526b;

        /* renamed from: c */
        private Map<C5619c, Long> f22527c;

        private C5456a() {
            this.f22526b = System.currentTimeMillis();
            this.f22527c = new HashMap();
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: a */
        public void mo476a(C5605a c5605a) {
            C5454c.this.m1016a(c5605a.m574b(), this.f22526b);
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: a */
        public void mo475a(C5619c c5619c) {
            C5454c.this.m1012b(c5619c, System.nanoTime() - this.f22527c.get(c5619c).longValue());
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: a */
        public void mo474a(C5629j c5629j) {
            C5454c.this.m1011c();
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: b */
        public void mo553b(C5619c c5619c) {
            this.f22527c.put(c5619c, Long.valueOf(System.nanoTime()));
        }
    }

    /* renamed from: org.c.a.b.c$b */
    /* loaded from: classes2.dex */
    private class C5457b implements Comparator<C5619c> {
        private C5457b() {
        }

        /* renamed from: a */
        private Long m1009a(C5619c c5619c) {
            Long m1017a = C5454c.this.m1017a(c5619c);
            if (m1017a == null) {
                return 0L;
            }
            return m1017a;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C5619c c5619c, C5619c c5619c2) {
            if (C5454c.this.m1013b(c5619c)) {
                return -1;
            }
            if (C5454c.this.m1013b(c5619c2)) {
                return 1;
            }
            int compareTo = m1009a(c5619c2).compareTo(m1009a(c5619c));
            return compareTo == 0 ? C5454c.this.m1010c(c5619c).compareTo(C5454c.this.m1010c(c5619c2)) : compareTo;
        }
    }

    private C5454c(File file) {
        this.f22524c = file;
    }

    /* renamed from: a */
    public static C5454c m1019a(File file) {
        if (file.exists()) {
            try {
                return m1014b(file);
            } catch (C5450a e) {
                e.printStackTrace();
                file.delete();
            }
        }
        return new C5454c(file);
    }

    /* renamed from: b */
    private static C5454c m1014b(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            C5454c c5454c = (C5454c) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return c5454c;
        } catch (Exception e) {
            throw new C5450a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1011c() {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f22524c));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    /* renamed from: a */
    Long m1017a(C5619c c5619c) {
        return this.f22523b.get(c5619c.toString());
    }

    /* renamed from: a */
    public C5606b m1020a() {
        return new C5456a();
    }

    /* renamed from: a */
    void m1016a(C5619c c5619c, long j) {
        this.f22523b.put(c5619c.toString(), Long.valueOf(j));
    }

    /* renamed from: b */
    public Comparator<C5619c> m1015b() {
        return new C5457b();
    }

    /* renamed from: b */
    void m1012b(C5619c c5619c, long j) {
        this.f22522a.put(c5619c.toString(), Long.valueOf(j));
    }

    /* renamed from: b */
    boolean m1013b(C5619c c5619c) {
        return !this.f22522a.containsKey(c5619c.toString());
    }

    /* renamed from: c */
    Long m1010c(C5619c c5619c) {
        return this.f22522a.get(c5619c.toString());
    }
}
