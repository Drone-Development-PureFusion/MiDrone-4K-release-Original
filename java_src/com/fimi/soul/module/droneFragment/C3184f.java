package com.fimi.soul.module.droneFragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2427e;
/* renamed from: com.fimi.soul.module.droneFragment.f */
/* loaded from: classes.dex */
public class C3184f {

    /* renamed from: a */
    private View f12116a;

    /* renamed from: b */
    private String f12117b = C2427e.m12218d();

    /* renamed from: c */
    private ImageView f12118c;

    /* renamed from: d */
    private Context f12119d;

    public C3184f(View view, Context context) {
        this.f12116a = view;
        this.f12118c = (ImageView) view.findViewById(C2300R.C2302id.targeImage);
        this.f12119d = context;
    }

    /* renamed from: c */
    private void m9311c() {
    }

    /* renamed from: a */
    public void m9313a() {
        m9311c();
    }

    /* renamed from: b */
    public void m9312b() {
        this.f12118c.setVisibility(8);
    }
}
