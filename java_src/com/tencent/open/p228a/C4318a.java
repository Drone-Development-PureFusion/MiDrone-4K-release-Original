package com.tencent.open.p228a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* renamed from: com.tencent.open.a.a */
/* loaded from: classes.dex */
public class C4318a extends AbstractC4334i implements Handler.Callback {

    /* renamed from: a */
    private C4319b f18067a;

    /* renamed from: b */
    private FileWriter f18068b;

    /* renamed from: c */
    private File f18069c;

    /* renamed from: d */
    private char[] f18070d;

    /* renamed from: e */
    private volatile C4332g f18071e;

    /* renamed from: f */
    private volatile C4332g f18072f;

    /* renamed from: g */
    private volatile C4332g f18073g;

    /* renamed from: h */
    private volatile C4332g f18074h;

    /* renamed from: i */
    private volatile boolean f18075i;

    /* renamed from: j */
    private HandlerThread f18076j;

    /* renamed from: k */
    private Handler f18077k;

    public C4318a(int i, boolean z, C4333h c4333h, C4319b c4319b) {
        super(i, z, c4333h);
        this.f18075i = false;
        m5497a(c4319b);
        this.f18071e = new C4332g();
        this.f18072f = new C4332g();
        this.f18073g = this.f18071e;
        this.f18074h = this.f18072f;
        this.f18070d = new char[c4319b.m5469f()];
        c4319b.m5484b();
        m5493g();
        this.f18076j = new HandlerThread(c4319b.m5479c(), c4319b.m5466h());
        if (this.f18076j != null) {
            this.f18076j.start();
        }
        if (!this.f18076j.isAlive() || this.f18076j.getLooper() == null) {
            return;
        }
        this.f18077k = new Handler(this.f18076j.getLooper(), this);
    }

    public C4318a(C4319b c4319b) {
        this(C4323c.f18095c, true, C4333h.f18123a, c4319b);
    }

    /* renamed from: f */
    private void m5494f() {
        if (Thread.currentThread() == this.f18076j && !this.f18075i) {
            this.f18075i = true;
            m5491i();
            try {
                this.f18074h.m5437a(m5493g(), this.f18070d);
            } catch (IOException e) {
            } finally {
                this.f18074h.m5435b();
            }
            this.f18075i = false;
        }
    }

    /* renamed from: g */
    private Writer m5493g() {
        File m5490a = m5495c().m5490a();
        if (m5490a != null && !m5490a.equals(this.f18069c)) {
            this.f18069c = m5490a;
            m5492h();
            try {
                this.f18068b = new FileWriter(this.f18069c, true);
            } catch (IOException e) {
                return null;
            }
        }
        return this.f18068b;
    }

    /* renamed from: h */
    private void m5492h() {
        try {
            if (this.f18068b == null) {
                return;
            }
            this.f18068b.flush();
            this.f18068b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    private void m5491i() {
        synchronized (this) {
            if (this.f18073g == this.f18071e) {
                this.f18073g = this.f18072f;
                this.f18074h = this.f18071e;
            } else {
                this.f18073g = this.f18071e;
                this.f18074h = this.f18072f;
            }
        }
    }

    public void a() {
        if (this.f18077k.hasMessages(1024)) {
            this.f18077k.removeMessages(1024);
        }
        this.f18077k.sendEmptyMessage(1024);
    }

    @Override // com.tencent.open.p228a.AbstractC4334i
    /* renamed from: a */
    protected void mo5431a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().m5433a(i, thread, j, str, str2, th));
    }

    /* renamed from: a */
    public void m5497a(C4319b c4319b) {
        this.f18067a = c4319b;
    }

    protected void a(String str) {
        this.f18073g.m5436a(str);
        if (this.f18073g.m5438a() >= m5495c().m5469f()) {
            a();
        }
    }

    /* renamed from: b */
    public void m5496b() {
        m5492h();
        this.f18076j.quit();
    }

    /* renamed from: c */
    public C4319b m5495c() {
        return this.f18067a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1024:
                m5494f();
                return true;
            default:
                return true;
        }
    }
}
