package com.fimi.soul.module.remote;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.p207b.C3057d;
/* loaded from: classes.dex */
public class BaseRemoteFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    protected Context f13333a;

    /* renamed from: b */
    protected C2657a f13334b;

    /* renamed from: c */
    protected FragmentManager f13335c;

    /* renamed from: d */
    protected C3057d f13336d;

    /* renamed from: e */
    protected AbstractC3410a f13337e;

    /* renamed from: com.fimi.soul.module.remote.BaseRemoteFragment$a */
    /* loaded from: classes.dex */
    protected interface AbstractC3410a {
        /* renamed from: a */
        void mo8480a();

        /* renamed from: a */
        void mo8479a(int i, int i2);

        /* renamed from: a */
        void mo8478a(int i, int i2, String str, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8486a(int i, int i2, String str, boolean z) {
        if (!this.f13335c.findFragmentById(C2300R.C2302id.errorcalifragment).isHidden() || this.f13337e == null) {
            return;
        }
        this.f13337e.mo8478a(i, i2, str, z);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13337e = (AbstractC3410a) activity;
        this.f13333a = activity.getApplicationContext();
        this.f13334b = ((DroidPlannerApp) activity.getApplication()).f7895a;
        this.f13335c = getFragmentManager();
        this.f13336d = C3057d.m9823a(this.f13334b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13334b.mo11214b(this);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f13337e != null) {
            this.f13337e = null;
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f13334b.mo11219a(this);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
