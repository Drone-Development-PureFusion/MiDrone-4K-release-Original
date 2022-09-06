package com.fimi.p153h;

import android.os.SystemClock;
import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p151f.C2145d;
import com.fimi.p153h.C2151c;
import com.fimi.soul.media.player.IMediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.h.e */
/* loaded from: classes.dex */
public class C2156e extends Thread {

    /* renamed from: c */
    private AbstractC2157a f7254c;

    /* renamed from: a */
    private List<AbstractC2103b> f7252a = new ArrayList();

    /* renamed from: b */
    private boolean f7253b = false;

    /* renamed from: d */
    private long f7255d = SystemClock.uptimeMillis();

    /* renamed from: com.fimi.h.e$a */
    /* loaded from: classes.dex */
    public interface AbstractC2157a {
        /* renamed from: a */
        void mo13388a(int i);
    }

    public C2156e(AbstractC2157a abstractC2157a) {
        this.f7254c = abstractC2157a;
    }

    /* renamed from: a */
    public void m13392a() {
        this.f7253b = true;
        interrupt();
    }

    /* renamed from: a */
    public void m13391a(int i) {
        AbstractC2103b abstractC2103b;
        synchronized (this.f7252a) {
            Iterator<AbstractC2103b> it2 = this.f7252a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    abstractC2103b = null;
                    break;
                }
                abstractC2103b = it2.next();
                if (abstractC2103b.m13718d() == i) {
                    break;
                }
            }
            if (abstractC2103b != null) {
                this.f7252a.remove(abstractC2103b);
            }
        }
    }

    /* renamed from: a */
    public void m13390a(AbstractC2103b abstractC2103b) {
        byte[] m13703f = abstractC2103b.mo13473g().m13703f();
        C2145d.m13447b().m13448a(m13703f, m13703f.length);
    }

    /* renamed from: a */
    public void m13389a(AbstractC2103b abstractC2103b, C2151c.EnumC2154a enumC2154a) {
        byte[] m13703f = abstractC2103b.mo13473g().m13703f();
        C2145d.m13447b().m13448a(m13703f, m13703f.length);
        this.f7255d = SystemClock.uptimeMillis();
        synchronized (this.f7252a) {
            this.f7252a.add(abstractC2103b);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        AbstractC2103b abstractC2103b;
        while (!this.f7253b) {
            synchronized (this.f7252a) {
                int i = 0;
                while (true) {
                    if (i >= this.f7252a.size()) {
                        abstractC2103b = null;
                        break;
                    }
                    abstractC2103b = this.f7252a.get(i);
                    if (SystemClock.uptimeMillis() - this.f7255d >= ((long) IMediaPlayer.MEDIA_INFO_BAD_INTERLEAVING)) {
                        int m13720c = abstractC2103b.m13720c();
                        if (m13720c > 10) {
                            break;
                        }
                        abstractC2103b.m13723a(m13720c + 1);
                        m13390a(abstractC2103b);
                        this.f7255d = SystemClock.uptimeMillis();
                    }
                    i++;
                }
                if (abstractC2103b != null) {
                    this.f7254c.mo13388a(abstractC2103b.m13718d());
                    this.f7252a.remove(abstractC2103b);
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        this.f7253b = true;
                        return;
                    }
                }
            }
        }
    }
}
