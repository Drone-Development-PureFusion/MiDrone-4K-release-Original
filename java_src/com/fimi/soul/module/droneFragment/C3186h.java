package com.fimi.soul.module.droneFragment;

import android.view.View;
import android.widget.ImageView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2427e;
/* renamed from: com.fimi.soul.module.droneFragment.h */
/* loaded from: classes.dex */
public class C3186h {

    /* renamed from: a */
    private String f12126a = C2427e.m12218d();

    /* renamed from: b */
    private ImageView f12127b;

    /* renamed from: c */
    private ImageView f12128c;

    public C3186h(View view) {
        this.f12127b = (ImageView) view.findViewById(C2300R.C2302id.targeImage);
        this.f12128c = (ImageView) view.findViewById(C2300R.C2302id.control_cantairn);
    }

    /* renamed from: a */
    public void m9302a() {
        this.f12127b.setVisibility(8);
        this.f12128c.setVisibility(0);
    }

    /* renamed from: b */
    public void m9301b() {
        this.f12128c.setVisibility(8);
    }
}
