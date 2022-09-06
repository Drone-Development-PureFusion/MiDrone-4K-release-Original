package com.fimi.soul.module.calibcompass;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.p207b.C3057d;
/* loaded from: classes.dex */
public class BaseCaliCompassFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    protected Context f11391a;

    /* renamed from: b */
    protected C2657a f11392b;

    /* renamed from: c */
    protected FragmentManager f11393c;

    /* renamed from: d */
    protected C3057d f11394d;

    /* renamed from: e */
    protected AbstractC3058a f11395e;

    /* renamed from: com.fimi.soul.module.calibcompass.BaseCaliCompassFragment$a */
    /* loaded from: classes.dex */
    protected interface AbstractC3058a {
        /* renamed from: a */
        void mo9790a();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11395e = (AbstractC3058a) activity;
        this.f11391a = activity.getApplicationContext();
        this.f11392b = ((DroidPlannerApp) activity.getApplication()).f7895a;
        this.f11393c = getFragmentManager();
        this.f11394d = C3057d.m9823a(this.f11392b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f11395e != null) {
            this.f11395e = null;
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11392b.mo11219a(this);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f11392b.mo11214b(this);
    }
}
