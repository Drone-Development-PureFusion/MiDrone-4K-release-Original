package com.fimi.soul.base;

import android.app.Activity;
import com.fimi.kernel.BaseFragment;
import com.fimi.soul.drone.C2657a;
/* loaded from: classes.dex */
public abstract class BaseDroneFragment extends BaseFragment {

    /* renamed from: a */
    private DroidPlannerApp f7889a;

    /* renamed from: d */
    public DroidPlannerApp m12528d() {
        return this.f7889a;
    }

    /* renamed from: e */
    protected C2657a m12527e() {
        return m12528d().f7895a;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f7889a = (DroidPlannerApp) activity.getApplication();
    }
}
