package p244m.framework.p247ui.widget.asyncview;

import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.WeakHashMap;
import p244m.framework.p245a.AbstractC4945h;
import p244m.framework.p245a.C4944g;
import p244m.framework.p246b.C4949a;
import p244m.framework.p246b.C4955f;
/* renamed from: m.framework.ui.widget.asyncview.c */
/* loaded from: classes2.dex */
public class C4958c {

    /* renamed from: a */
    private static final int f21303a = 5;

    /* renamed from: b */
    private static final int f21304b = 200;

    /* renamed from: c */
    private static final int f21305c = 40;

    /* renamed from: d */
    private static final int f21306d = 50;

    /* renamed from: e */
    private static C4958c f21307e;

    /* renamed from: g */
    private boolean f21309g;

    /* renamed from: i */
    private File f21311i;

    /* renamed from: h */
    private Vector<C4959a> f21310h = new Vector<>();

    /* renamed from: k */
    private Vector<C4959a> f21313k = new Vector<>();

    /* renamed from: j */
    private C4963d[] f21312j = new C4963d[5];

    /* renamed from: f */
    private WeakHashMap<String, Bitmap> f21308f = new WeakHashMap<>();

    /* renamed from: m.framework.ui.widget.asyncview.c$a */
    /* loaded from: classes2.dex */
    public static class C4959a {

        /* renamed from: a */
        private String f21314a;

        /* renamed from: b */
        private AbstractC4957b f21315b;

        /* renamed from: c */
        private C4963d f21316c;

        /* renamed from: d */
        private long f21317d = System.currentTimeMillis();

        /* renamed from: e */
        private Bitmap f21318e;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2461a(Bitmap bitmap) {
            this.f21318e = bitmap;
            if (this.f21315b != null) {
                this.f21315b.mo2473a(this.f21314a, this.f21318e);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("url=").append(this.f21314a);
            sb.append("time=").append(this.f21317d);
            sb.append("worker=").append(this.f21316c.getName()).append(" (").append(this.f21316c.getId()).append("");
            return sb.toString();
        }
    }

    /* renamed from: m.framework.ui.widget.asyncview.c$b */
    /* loaded from: classes2.dex */
    private static class C4960b extends Timer {

        /* renamed from: a */
        private C4958c f21319a;

        public C4960b(C4958c c4958c) {
            this.f21319a = c4958c;
            schedule(new TimerTask() { // from class: m.framework.ui.widget.asyncview.c.b.1

                /* renamed from: b */
                private int f21321b;

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (C4960b.this.f21319a.f21309g) {
                        this.f21321b--;
                        if (this.f21321b > 0) {
                            return;
                        }
                        this.f21321b = 100;
                        C4960b.this.m2455a();
                    }
                }
            }, 0L, 200L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2455a() {
            if (!this.f21319a.f21309g) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            while (i < this.f21319a.f21312j.length) {
                if (this.f21319a.f21312j[i] == null) {
                    this.f21319a.f21312j[i] = new C4963d(this.f21319a);
                    this.f21319a.f21312j[i].setName("worker " + i);
                    this.f21319a.f21312j[i].f21325c = i == 0;
                    this.f21319a.f21312j[i].start();
                } else if (currentTimeMillis - this.f21319a.f21312j[i].f21324b > 20000) {
                    this.f21319a.f21312j[i].interrupt();
                    boolean z = this.f21319a.f21312j[i].f21325c;
                    this.f21319a.f21312j[i] = new C4963d(this.f21319a);
                    this.f21319a.f21312j[i].setName("worker " + i);
                    this.f21319a.f21312j[i].f21325c = z;
                    this.f21319a.f21312j[i].start();
                }
                i++;
            }
        }
    }

    /* renamed from: m.framework.ui.widget.asyncview.c$c */
    /* loaded from: classes2.dex */
    private static class C4962c extends FilterInputStream {

        /* renamed from: a */
        InputStream f21322a;

        protected C4962c(InputStream inputStream) {
            super(inputStream);
            this.f21322a = inputStream;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.f21322a.skip(j - j2);
                if (skip == 0) {
                    break;
                }
                j2 += skip;
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m.framework.ui.widget.asyncview.c$d */
    /* loaded from: classes2.dex */
    public static class C4963d extends Thread {

        /* renamed from: a */
        private C4958c f21323a;

        /* renamed from: b */
        private long f21324b = System.currentTimeMillis();

        /* renamed from: c */
        private boolean f21325c;

        /* renamed from: d */
        private C4959a f21326d;

        public C4963d(C4958c c4958c) {
            this.f21323a = c4958c;
        }

        /* renamed from: a */
        private void m2452a() {
            int size = this.f21323a.f21310h.size();
            C4959a c4959a = size > 0 ? (C4959a) this.f21323a.f21310h.remove(size - 1) : null;
            if (c4959a == null) {
                this.f21324b = System.currentTimeMillis();
                Thread.sleep(30L);
                return;
            }
            Bitmap bitmap = (Bitmap) this.f21323a.f21308f.get(c4959a.f21314a);
            if (bitmap != null) {
                this.f21326d = c4959a;
                this.f21326d.f21316c = this;
                c4959a.m2461a(bitmap);
            } else if (new File(this.f21323a.f21311i, C4949a.m2551c(c4959a.f21314a)).exists()) {
                m2450a(c4959a);
                this.f21324b = System.currentTimeMillis();
                return;
            } else {
                if (this.f21323a.f21313k.size() > 40) {
                    while (this.f21323a.f21310h.size() > 0) {
                        this.f21323a.f21310h.remove(0);
                    }
                    this.f21323a.f21313k.remove(0);
                }
                this.f21323a.f21313k.add(c4959a);
            }
            this.f21324b = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2451a(Bitmap bitmap, File file) {
            try {
                if (file.exists()) {
                    file.delete();
                }
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                String m2478c = C4955f.m2478c(file.getAbsolutePath());
                if (m2478c != null && (m2478c.endsWith("png") || m2478c.endsWith("gif"))) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                if (!file.exists()) {
                    return;
                }
                file.delete();
            }
        }

        /* renamed from: a */
        private void m2450a(final C4959a c4959a) {
            Bitmap bitmap;
            this.f21326d = c4959a;
            this.f21326d.f21316c = this;
            final File file = new File(this.f21323a.f21311i, C4949a.m2551c(c4959a.f21314a));
            if (file.exists()) {
                bitmap = C4955f.m2479b(file.getAbsolutePath());
                if (bitmap != null) {
                    this.f21323a.f21308f.put(c4959a.f21314a, bitmap);
                    c4959a.m2461a(bitmap);
                }
                this.f21326d = null;
            } else {
                new C4944g().m2567a(c4959a.f21314a, new AbstractC4945h() { // from class: m.framework.ui.widget.asyncview.c.d.1
                    @Override // p244m.framework.p245a.AbstractC4945h
                    /* renamed from: a */
                    public void mo2442a(InputStream inputStream) {
                        Bitmap m2484a = C4955f.m2484a(new C4962c(inputStream));
                        if (m2484a == null || m2484a.isRecycled()) {
                            C4963d.this.f21326d = null;
                            return;
                        }
                        C4963d.this.m2451a(m2484a, file);
                        if (m2484a != null) {
                            C4963d.this.f21323a.f21308f.put(c4959a.f21314a, m2484a);
                            c4959a.m2461a(m2484a);
                        }
                        C4963d.this.f21326d = null;
                    }
                });
                bitmap = null;
            }
            if (bitmap != null) {
                this.f21323a.f21308f.put(c4959a.f21314a, bitmap);
                c4959a.m2461a(bitmap);
            }
            this.f21326d = null;
        }

        /* renamed from: b */
        private void m2445b() {
            int size;
            C4959a c4959a = null;
            if (this.f21323a.f21313k.size() > 0) {
                c4959a = (C4959a) this.f21323a.f21313k.remove(0);
            }
            C4959a c4959a2 = (c4959a != null || (size = this.f21323a.f21310h.size()) <= 0) ? c4959a : (C4959a) this.f21323a.f21310h.remove(size - 1);
            if (c4959a2 == null) {
                this.f21324b = System.currentTimeMillis();
                Thread.sleep(30L);
                return;
            }
            Bitmap bitmap = (Bitmap) this.f21323a.f21308f.get(c4959a2.f21314a);
            if (bitmap != null) {
                this.f21326d = c4959a2;
                this.f21326d.f21316c = this;
                c4959a2.m2461a(bitmap);
            } else {
                m2450a(c4959a2);
            }
            this.f21324b = System.currentTimeMillis();
        }

        @Override // java.lang.Thread
        public void interrupt() {
            try {
                super.interrupt();
            } catch (Throwable th) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f21323a.f21309g) {
                try {
                    if (this.f21325c) {
                        m2452a();
                    } else {
                        m2445b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private C4958c(String str) {
        this.f21311i = new File(str);
        if (!this.f21311i.exists()) {
            this.f21311i.mkdirs();
        }
        new C4960b(this);
    }

    /* renamed from: a */
    public static void m2472a() {
        if (f21307e == null) {
            throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
        }
        f21307e.f21309g = true;
    }

    /* renamed from: a */
    public static synchronized void m2471a(String str) {
        synchronized (C4958c.class) {
            if (f21307e == null) {
                f21307e = new C4958c(str);
            }
        }
    }

    /* renamed from: a */
    public static void m2470a(String str, AbstractC4957b abstractC4957b) {
        if (f21307e == null) {
            throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
        }
        if (str == null) {
            return;
        }
        C4959a c4959a = new C4959a();
        c4959a.f21314a = str;
        c4959a.f21315b = abstractC4957b;
        f21307e.f21310h.add(c4959a);
        if (f21307e.f21310h.size() > 50) {
            while (f21307e.f21310h.size() > 40) {
                f21307e.f21310h.remove(0);
            }
        }
        m2472a();
    }

    /* renamed from: b */
    public static Bitmap m2467b(String str) {
        if (f21307e == null) {
            throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
        }
        return f21307e.f21308f.get(str);
    }

    /* renamed from: b */
    public static void m2468b() {
        if (f21307e != null) {
            f21307e.f21309g = false;
            f21307e.f21310h.clear();
            for (int i = 0; i < f21307e.f21312j.length; i++) {
                if (f21307e.f21312j[i] != null) {
                    f21307e.f21312j[i].interrupt();
                }
            }
            f21307e = null;
        }
    }
}
