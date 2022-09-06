package com.fimi.soul.module.setting;

import android.content.Context;
import android.view.View;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.drone.C2657a;
/* renamed from: com.fimi.soul.module.setting.b */
/* loaded from: classes.dex */
public class C3479b extends AbstractC3477a {

    /* renamed from: a */
    C2657a f13730a;

    public C3479b(Context context, C2657a c2657a) {
        super(context);
        this.f13730a = c2657a;
    }

    /* renamed from: g */
    private void m8327g() {
        a(C2300R.C2303string.follow_mode, "", new View.OnClickListener() { // from class: com.fimi.soul.module.setting.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        a(C2300R.C2303string.follow_sensitivity, "", (View.OnClickListener) null);
        a(C2300R.C2303string.follow_dead_zone, "", (View.OnClickListener) null);
        a(C2300R.C2303string.work_mode, "", (View.OnClickListener) null);
        a(C2300R.C2303string.angle_limit, "", (View.OnClickListener) null);
        a(C2300R.C2303string.platform_correct, "", (View.OnClickListener) null);
        a(C2300R.C2303string.cloud_platform_upgrade, "", (View.OnClickListener) null);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
    }

    @Override // com.fimi.soul.module.setting.AbstractC3477a
    /* renamed from: c */
    public View mo8322c() {
        m8327g();
        return b();
    }
}
