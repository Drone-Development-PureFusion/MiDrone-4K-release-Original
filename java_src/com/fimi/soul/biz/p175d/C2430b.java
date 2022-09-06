package com.fimi.soul.biz.p175d;

import android.text.TextUtils;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p178g.C2444a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.service.CameraSocketService;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
/* renamed from: com.fimi.soul.biz.d.b */
/* loaded from: classes.dex */
public class C2430b {

    /* renamed from: a */
    private final int f8384a;

    /* renamed from: b */
    private final int f8385b;

    /* renamed from: c */
    private EnumC2433b f8386c;

    /* renamed from: d */
    private final C2437d f8387d;

    /* renamed from: e */
    private boolean f8388e;

    /* renamed from: f */
    private BlockingDeque<C2770c> f8389f;

    /* renamed from: g */
    private int f8390g;

    /* renamed from: h */
    private LinkedList<C2770c> f8391h;

    /* renamed from: i */
    private volatile boolean f8392i;

    /* renamed from: j */
    private boolean f8393j;

    /* renamed from: com.fimi.soul.biz.d.b$a */
    /* loaded from: classes.dex */
    public static class C2432a {

        /* renamed from: a */
        public static final C2430b f8395a = new C2430b();
    }

    /* renamed from: com.fimi.soul.biz.d.b$b */
    /* loaded from: classes.dex */
    public enum EnumC2433b {
        Nornal,
        WriteCom,
        WritingSky,
        WritingFool
    }

    private C2430b() {
        this.f8384a = 100;
        this.f8385b = 10000;
        this.f8386c = EnumC2433b.Nornal;
        this.f8387d = C2437d.m12192a();
        this.f8389f = new LinkedBlockingDeque();
        this.f8390g = CameraSocketService.f14616b;
        this.f8391h = new LinkedList<>();
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    if (C2430b.this.f8389f.size() > 0) {
                        C2430b.this.m12205b((C2770c) C2430b.this.f8389f.poll());
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public static C2430b m12212a() {
        return C2432a.f8395a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12205b(C2770c c2770c) {
        if (this.f8388e) {
            if (!this.f8387d.m12178j()) {
                this.f8387d.m12188b();
                m12197h();
                this.f8387d.m12183e();
                this.f8387d.m12182f();
                this.f8393j = false;
            }
            this.f8387d.m12191a(c2770c);
            m12202c(true);
            return;
        }
        if (this.f8387d.m12178j()) {
            this.f8387d.m12177k();
        }
        if (!this.f8387d.m12184d()) {
            this.f8387d.m12186c();
            this.f8393j = false;
        }
        this.f8387d.m12187b(c2770c);
        m12202c(false);
        if (this.f8391h.size() < this.f8390g) {
            this.f8391h.add(c2770c);
            return;
        }
        this.f8391h.removeFirst();
        this.f8391h.addLast(c2770c);
    }

    /* renamed from: c */
    private void m12202c(boolean z) {
        if (TextUtils.isEmpty(C2444a.m12164a().m12161b()) || this.f8393j) {
            return;
        }
        this.f8393j = true;
        File m12176l = z ? this.f8387d.m12176l() : this.f8387d.m12175m();
        if (m12176l == null) {
            return;
        }
        this.f8387d.m12190a(m12176l);
    }

    /* renamed from: h */
    private void m12197h() {
        if (this.f8391h == null || this.f8391h.size() <= 0) {
            return;
        }
        while (this.f8391h.size() > 0) {
            this.f8387d.m12191a(this.f8391h.pollFirst());
        }
        this.f8391h.clear();
    }

    /* renamed from: i */
    private void m12196i() {
        if (this.f8391h == null || this.f8391h.size() <= 0) {
            return;
        }
        while (this.f8391h.size() > 0) {
            this.f8387d.m12191a(this.f8391h.pollFirst());
        }
        this.f8387d.m12177k();
    }

    /* renamed from: a */
    public void m12211a(EnumC2433b enumC2433b) {
        this.f8386c = enumC2433b;
    }

    /* renamed from: a */
    public void m12208a(C2770c c2770c) {
        this.f8389f.add(c2770c);
    }

    /* renamed from: a */
    public void m12207a(boolean z) {
        this.f8392i = z;
    }

    /* renamed from: b */
    public void m12204b(boolean z) {
        this.f8388e = z;
    }

    /* renamed from: b */
    public boolean m12206b() {
        return this.f8387d.m12178j();
    }

    /* renamed from: c */
    public LinkedList m12203c() {
        return this.f8391h;
    }

    /* renamed from: d */
    public void m12201d() {
        this.f8391h.clear();
    }

    /* renamed from: e */
    public boolean m12200e() {
        return this.f8392i;
    }

    /* renamed from: f */
    public EnumC2433b m12199f() {
        return this.f8386c;
    }

    /* renamed from: g */
    public boolean m12198g() {
        return this.f8388e;
    }
}
