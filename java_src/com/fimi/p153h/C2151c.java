package com.fimi.p153h;

import android.util.Log;
import com.fimi.p139b.p140a.C2085a;
import com.fimi.p139b.p140a.C2088d;
import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p145f.C2112b;
import com.fimi.p147d.AbstractC2118a;
import com.fimi.p147d.AbstractC2119b;
import com.fimi.p147d.AbstractC2120c;
import com.fimi.p148e.p149a.C2125d;
import com.fimi.p148e.p149a.C2126e;
import com.fimi.p148e.p149a.C2127f;
import com.fimi.p148e.p149a.C2128g;
import com.fimi.p148e.p149a.C2129h;
import com.fimi.p148e.p149a.C2130i;
import com.fimi.p148e.p150b.C2132b;
import com.fimi.p148e.p150b.C2133c;
import com.fimi.p148e.p150b.C2134d;
import com.fimi.p148e.p150b.C2135e;
import com.fimi.p148e.p150b.C2136f;
import com.fimi.p148e.p150b.C2137g;
import com.fimi.p151f.C2139b;
import com.fimi.p151f.C2145d;
import com.fimi.p153h.C2156e;
import com.fimi.p154i.C2162c;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* renamed from: com.fimi.h.c */
/* loaded from: classes.dex */
public class C2151c implements AbstractC2118a, AbstractC2119b, C2156e.AbstractC2157a {

    /* renamed from: m */
    private static final String f7221m = "UpgradeManager";

    /* renamed from: a */
    private AbstractC2120c f7222a;

    /* renamed from: b */
    private C2156e f7223b;

    /* renamed from: c */
    private List<C2162c> f7224c;

    /* renamed from: e */
    private int f7226e;

    /* renamed from: f */
    private C2162c f7227f;

    /* renamed from: g */
    private C2150b f7228g;

    /* renamed from: i */
    private int f7230i;

    /* renamed from: j */
    private long f7231j;

    /* renamed from: k */
    private Timer f7232k;

    /* renamed from: l */
    private Timer f7233l;

    /* renamed from: d */
    private boolean f7225d = false;

    /* renamed from: h */
    private EnumC2154a f7229h = EnumC2154a.UNINIT;

    /* renamed from: com.fimi.h.c$a */
    /* loaded from: classes.dex */
    public enum EnumC2154a {
        UNINIT,
        IDLE,
        C1,
        CC,
        C7,
        C9,
        CA,
        CB,
        RESTART
    }

    public C2151c(List<C2162c> list) {
        this.f7224c = new ArrayList();
        this.f7224c = list;
    }

    /* renamed from: b */
    static /* synthetic */ int m13413b(C2151c c2151c) {
        int i = c2151c.f7230i;
        c2151c.f7230i = i + 1;
        return i;
    }

    /* renamed from: a */
    public void m13420a() {
        this.f7223b = new C2156e(this);
        C2139b.m13466b().m13468a(this);
        C2145d.m13447b().m13451a(this);
        this.f7223b.start();
        m13415b();
        m13412c();
    }

    /* renamed from: a */
    public void m13419a(byte b) {
        this.f7229h = EnumC2154a.CC;
        C2137g c2137g = new C2137g();
        c2137g.c(this.f7227f.m13357d());
        c2137g.d(1);
        c2137g.a(0);
        c2137g.b(204);
        c2137g.a(this.f7227f.m13355f().m13376b());
        c2137g.m13474b(b);
        m13418a(c2137g);
    }

    @Override // com.fimi.p153h.C2156e.AbstractC2157a
    /* renamed from: a */
    public void mo13388a(int i) {
        m13408d("数据发送超时 " + C2112b.m13639h(i));
    }

    @Override // com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public void mo6481a(int i, C2104c c2104c) {
        AbstractC2103b m13702g = c2104c.m13702g();
        if (m13702g == null) {
            return;
        }
        this.f7223b.m13391a(m13702g.m13718d());
        if (m13702g instanceof C2125d) {
            m13414b(m13702g);
        } else if (m13702g instanceof C2130i) {
            m13411c(m13702g);
        } else if (m13702g instanceof C2126e) {
            m13409d(m13702g);
        } else if (m13702g instanceof C2127f) {
            m13406e(m13702g);
        } else if (m13702g instanceof C2128g) {
            m13404f(m13702g);
        } else if (!(m13702g instanceof C2129h)) {
        } else {
            m13402g(m13702g);
        }
    }

    /* renamed from: a */
    public void m13418a(AbstractC2103b abstractC2103b) {
        this.f7223b.m13389a(abstractC2103b, this.f7229h);
    }

    /* renamed from: a */
    public void m13417a(AbstractC2120c abstractC2120c) {
        this.f7222a = abstractC2120c;
    }

    @Override // com.fimi.p147d.AbstractC2118a
    /* renamed from: a */
    public void mo6477a(String str) {
    }

    /* renamed from: b */
    public void m13415b() {
        this.f7227f = this.f7224c.get(this.f7226e);
        this.f7228g = new C2150b();
        this.f7228g.m13431a(this.f7227f.m13354g(), this.f7227f.m13355f().m13372f(), this.f7227f.m13355f().m13371g(), this.f7227f.m13355f().m13370h());
    }

    /* renamed from: b */
    public void m13414b(AbstractC2103b abstractC2103b) {
        ((C2125d) abstractC2103b).m13549l();
        m13419a((byte) 1);
    }

    @Override // com.fimi.p147d.AbstractC2118a
    /* renamed from: b */
    public void mo6446b(String str) {
        if (this.f7225d) {
            return;
        }
        m13407e();
        this.f7222a.mo6421d("升级中断-失败");
    }

    /* renamed from: c */
    public void m13412c() {
        this.f7231j = System.currentTimeMillis();
        int m13356e = this.f7227f.m13356e();
        this.f7222a.mo6422c("current upgrade type: " + ((int) this.f7227f.m13355f().m13376b()) + " sysId " + m13356e + " - ");
        if (m13356e == C2088d.f6980a) {
            m13403g();
        } else if (m13356e == C2088d.f6981b) {
            m13405f();
        } else if (m13356e != C2088d.f6982c) {
        } else {
            m13403g();
        }
    }

    /* renamed from: c */
    public void m13411c(AbstractC2103b abstractC2103b) {
        if (abstractC2103b.m13724a() && ((C2130i) abstractC2103b).m13542h() == 1) {
            m13401h();
        } else if (!abstractC2103b.m13724a() || ((C2130i) abstractC2103b).m13542h() != 2) {
            m13408d("CC has error code");
        } else if (this.f7224c.get(this.f7226e).m13356e() == C2088d.f6980a) {
            m13395n();
        } else {
            m13397l();
        }
    }

    @Override // com.fimi.p147d.AbstractC2118a
    /* renamed from: c */
    public void mo6556c(String str) {
    }

    /* renamed from: d */
    public void m13410d() {
        this.f7223b.m13392a();
        C2139b.m13466b().m13465b(this);
        C2145d.m13447b().m13446b(this);
    }

    /* renamed from: d */
    public void m13409d(AbstractC2103b abstractC2103b) {
        if (!abstractC2103b.m13724a()) {
            m13408d("CC has error code");
        } else if (this.f7229h == EnumC2154a.UNINIT) {
            m13394o();
            m13403g();
        } else if (this.f7229h != EnumC2154a.C7) {
        } else {
            m13400i();
        }
    }

    /* renamed from: d */
    public void m13408d(String str) {
        this.f7222a.mo6423b(str);
        this.f7224c.get(this.f7226e).m13362a(str);
        m13397l();
    }

    /* renamed from: e */
    public void m13407e() {
        m13410d();
        m13394o();
        m13393p();
    }

    /* renamed from: e */
    public void m13406e(AbstractC2103b abstractC2103b) {
        Log.i("update", "onC9Response: " + abstractC2103b.toString());
        Log.i("update", "onC9Response: " + ((C2127f) abstractC2103b).toString());
        if (!abstractC2103b.m13724a()) {
            m13408d("C9 has error code");
        } else if (((C2127f) abstractC2103b).m13546h() - 1 == this.f7228g.m13436a()) {
            this.f7228g.m13429b();
            this.f7222a.mo6428a(this.f7228g.m13425d(), this.f7228g.m13424e());
            Log.i("update", "onC9Response: ");
            m13400i();
        } else {
            Log.i("update1", "onC9Response: xxxxx ");
            this.f7228g.m13435a(((C2127f) abstractC2103b).m13546h() - 1);
            this.f7222a.mo6428a(this.f7228g.m13425d(), this.f7228g.m13424e());
            Log.i("update1", "onC9Response: xxxxx");
            m13400i();
        }
    }

    /* renamed from: f */
    public void m13405f() {
        this.f7229h = EnumC2154a.UNINIT;
        final C2133c c2133c = new C2133c();
        c2133c.c(3);
        c2133c.d(1);
        c2133c.a(0);
        c2133c.b(199);
        c2133c.a(this.f7227f.m13355f().m13376b());
        c2133c.m13487b((byte) 90);
        c2133c.m13486c((byte) 1);
        this.f7232k = new Timer();
        this.f7230i = 0;
        this.f7232k.schedule(new TimerTask() { // from class: com.fimi.h.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                byte[] m13703f = c2133c.mo13473g().m13703f();
                C2145d.m13447b().m13448a(m13703f, m13703f.length);
                if (C2151c.this.f7230i > 45) {
                    C2151c.this.m13394o();
                }
                C2151c.m13413b(C2151c.this);
            }
        }, 0L, 1000L);
    }

    /* renamed from: f */
    public void m13404f(AbstractC2103b abstractC2103b) {
        if (abstractC2103b.m13724a()) {
            m13398k();
        } else {
            m13408d("CA has error code");
        }
    }

    /* renamed from: g */
    public void m13403g() {
        this.f7229h = EnumC2154a.C1;
        C2132b c2132b = new C2132b();
        c2132b.c((int) this.f7227f.m13357d());
        c2132b.d(1);
        c2132b.a(0);
        c2132b.b(C2132b.f7144a);
        c2132b.mo13507a(this.f7227f.m13355f().m13376b());
        m13418a(c2132b);
    }

    /* renamed from: g */
    public void m13402g(AbstractC2103b abstractC2103b) {
        if (!abstractC2103b.m13724a()) {
            m13408d("CB has error code");
            return;
        }
        this.f7224c.get(this.f7226e).m13361a(true);
        this.f7222a.mo6425a(this.f7224c);
        m13419a((byte) 2);
    }

    /* renamed from: h */
    public void m13401h() {
        this.f7229h = EnumC2154a.C7;
        C2133c c2133c = new C2133c();
        c2133c.c((int) this.f7227f.m13357d());
        c2133c.d(1);
        c2133c.a(0);
        c2133c.b(199);
        c2133c.a(this.f7227f.m13355f().m13376b());
        c2133c.m13487b((byte) 0);
        c2133c.m13486c((byte) 1);
        m13418a(c2133c);
    }

    /* renamed from: i */
    public void m13400i() {
        this.f7229h = EnumC2154a.C9;
        if (this.f7228g.m13426c()) {
            m13399j();
            return;
        }
        C2134d c2134d = new C2134d();
        c2134d.c(this.f7227f.m13357d());
        c2134d.d(1);
        c2134d.a(0);
        c2134d.b(201);
        c2134d.a(this.f7227f.m13355f().m13376b());
        c2134d.m13482e(this.f7228g.m13436a());
        C2085a m13422g = this.f7228g.m13422g();
        c2134d.m13481f(m13422g.f6971b);
        c2134d.m13483a(m13422g.f6970a);
        Log.i("update", "sendC9: " + c2134d.toString());
        m13418a(c2134d);
    }

    /* renamed from: j */
    public void m13399j() {
        this.f7229h = EnumC2154a.CA;
        C2135e c2135e = new C2135e();
        c2135e.c(this.f7227f.m13357d());
        c2135e.d(1);
        c2135e.a(0);
        c2135e.b(202);
        c2135e.a(this.f7227f.m13355f().m13376b());
        m13418a(c2135e);
    }

    /* renamed from: k */
    public void m13398k() {
        this.f7229h = EnumC2154a.CB;
        C2136f c2136f = new C2136f();
        c2136f.c(this.f7227f.m13357d());
        c2136f.d(1);
        c2136f.a(0);
        c2136f.b(203);
        c2136f.a(this.f7227f.m13355f().m13376b());
        m13418a(c2136f);
    }

    /* renamed from: l */
    public void m13397l() {
        this.f7226e++;
        if (this.f7226e < this.f7224c.size()) {
            m13415b();
            m13412c();
            return;
        }
        this.f7225d = true;
        m13410d();
        this.f7222a.mo6426a("升级完成", this.f7224c);
    }

    /* renamed from: m */
    public void m13396m() {
        this.f7229h = EnumC2154a.RESTART;
        C2132b c2132b = new C2132b();
        c2132b.c((int) this.f7227f.m13357d());
        c2132b.d(1);
        c2132b.a(0);
        c2132b.b(C2132b.f7144a);
        c2132b.mo13507a(this.f7227f.m13355f().m13376b());
        if (this.f7226e < this.f7224c.size() - 1) {
            m13418a(c2132b);
            return;
        }
        this.f7222a.mo6424a(true, "升级包数据发送完成 耗时：" + (System.currentTimeMillis() - this.f7231j));
    }

    /* renamed from: n */
    public void m13395n() {
        this.f7233l = new Timer();
        this.f7233l.schedule(new TimerTask() { // from class: com.fimi.h.c.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                C2151c.this.m13397l();
            }
        }, 20000L);
    }

    /* renamed from: o */
    public void m13394o() {
        if (this.f7232k != null) {
            this.f7232k.cancel();
            this.f7232k = null;
        }
    }

    /* renamed from: p */
    public void m13393p() {
        if (this.f7233l != null) {
            this.f7233l.cancel();
            this.f7233l = null;
        }
    }
}
