package com.fimi.soul.biz.camera.p171a;

import android.os.Message;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p160c.AbstractC2218a;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.p172b.AbstractC2389g;
/* renamed from: com.fimi.soul.biz.camera.a.b */
/* loaded from: classes.dex */
public class C2377b extends AbstractC2180b implements AbstractC2389g {

    /* renamed from: a */
    private C2225c f8038a = (C2225c) C2238c.m13128a(EnumC2222d.Socket);

    /* renamed from: b */
    private C2225c f8039b = (C2225c) C2238c.m13128a(EnumC2222d.Socket);

    public C2377b() {
        C2227d m13167f = this.f8038a.m13167f();
        m13167f.a(C2427e.m12221a());
        m13167f.a(C2427e.f8356e);
        m13167f.m13162b(C2227d.f7442b);
        m13167f.m13160b(true);
        C2227d m13167f2 = this.f8039b.m13167f();
        m13167f2.a(C2427e.m12221a());
        m13167f2.a(C2427e.f8355d);
        m13167f2.m13162b(C2227d.f7442b);
        m13167f2.m13160b(true);
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: a */
    public void mo12386a(AbstractC2218a abstractC2218a) {
        this.f8039b.m13178b(abstractC2218a);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: a */
    public void mo12385a(AbstractC2221d abstractC2221d) {
        this.f8038a.m13188a(abstractC2221d);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2385c
    /* renamed from: a */
    public synchronized void mo12362a(final byte[] bArr) {
        a(new Runnable() { // from class: com.fimi.soul.biz.camera.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!C2377b.this.f8038a.m13179b()) {
                        C2377b.this.f8038a.m13171d();
                    }
                    C2377b.this.f8038a.m13181a(bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: a */
    public synchronized void mo12361a(byte[] bArr, int i, int i2) {
        if (!this.f8039b.m13179b()) {
            this.f8039b.m13171d();
        }
        this.f8039b.m13180a(bArr, i, i2);
    }

    /* renamed from: b */
    public void m12416b() {
        this.f8038a.m13165g();
        this.f8039b.m13165g();
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: b */
    public void mo12360b(AbstractC2218a abstractC2218a) {
        this.f8039b.m13189a(abstractC2218a);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: b */
    public void mo12359b(AbstractC2221d abstractC2221d) {
        this.f8038a.m13177b(abstractC2221d);
    }

    /* renamed from: c */
    public boolean m12415c() {
        return this.f8038a.m13179b();
    }

    /* renamed from: d */
    public void m12414d() {
        this.f8038a.m13165g();
        C2227d m13167f = this.f8038a.m13167f();
        m13167f.a(C2427e.m12221a());
        m13167f.a(C2427e.f8356e);
        m13167f.m13162b(C2227d.f7442b);
        m13167f.m13160b(true);
        this.f8038a.m13171d();
    }

    /* renamed from: e */
    public void m12413e() {
        this.f8039b.m13165g();
        this.f8039b.m13171d();
    }

    /* renamed from: f */
    public C2225c m12412f() {
        return this.f8038a;
    }

    /* renamed from: g */
    public C2225c m12411g() {
        return this.f8039b;
    }
}
