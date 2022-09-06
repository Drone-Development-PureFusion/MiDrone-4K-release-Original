package com.fimi.x1bh.p213b;

import android.util.Log;
import android.view.View;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.p172b.AbstractC2386d;
import com.fimi.soul.entity.CameraMountState;
import com.fimi.soul.module.droneFragment.View$OnTouchListenerC3156b;
import com.fimi.x1bh.module.main.CloudTerraceMainActivity;
/* renamed from: com.fimi.x1bh.b.a */
/* loaded from: classes.dex */
public class C3893a implements AbstractC2386d, AbstractC3895b {

    /* renamed from: a */
    private View$OnTouchListenerC3156b f16561a;

    /* renamed from: b */
    private C2423d f16562b;

    /* renamed from: c */
    private CloudTerraceMainActivity f16563c;

    /* renamed from: d */
    private CameraMountState f16564d = CameraMountState.IDLE;

    /* renamed from: a */
    public void m6640a() {
        this.f16561a.m9404s();
        this.f16562b.a((AbstractC2386d) null);
        this.f16562b.r();
    }

    /* renamed from: a */
    public void m6639a(CloudTerraceMainActivity cloudTerraceMainActivity, View view) {
        this.f16563c = cloudTerraceMainActivity;
        this.f16561a = new View$OnTouchListenerC3156b(cloudTerraceMainActivity, view);
        this.f16562b = (C2423d) C2379b.m12410a().m12394d();
        this.f16562b.c(new AbstractC2221d() { // from class: com.fimi.x1bh.b.a.1
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
            /* renamed from: a */
            public void mo6431a(String str) {
            }
        });
        this.f16562b.a(this);
    }

    /* renamed from: b */
    public void m6638b() {
        this.f16561a.m9430a(this.f16562b.e());
        this.f16561a.m9421d();
        this.f16561a.m9415h();
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2386d
    /* renamed from: b */
    public void mo6637b(boolean z, Object obj) {
        Log.i("istep", "onMount");
        this.f16561a.m9426b((String) null);
        this.f16564d = CameraMountState.MOUNT;
        this.f16561a.m9428b(this.f16564d);
        this.f16562b.m12233u().m12296b();
        this.f16563c.m6560h();
    }

    /* renamed from: c */
    public void m6636c() {
        this.f16561a.m9411l();
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2386d
    /* renamed from: c */
    public void mo6635c(boolean z, Object obj) {
        Log.i("istep", "onDisMount");
        this.f16562b.a(AbstractC2390c.EnumC2400a.Normal);
        this.f16561a.m9437a(CameraMountState.DISMOUNT);
        this.f16564d = CameraMountState.DISMOUNT;
        this.f16561a.m9428b(this.f16564d);
    }

    /* renamed from: d */
    public void m6634d() {
        this.f16561a.m9412k();
    }

    @Override // com.fimi.x1bh.p213b.AbstractC3895b
    /* renamed from: e */
    public void mo6633e() {
        this.f16561a.m9413j();
    }

    @Override // com.fimi.x1bh.p213b.AbstractC3895b
    /* renamed from: f */
    public void mo6632f() {
        this.f16561a.m9410m();
    }
}
