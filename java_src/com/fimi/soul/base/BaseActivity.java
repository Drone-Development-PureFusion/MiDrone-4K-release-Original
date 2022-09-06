package com.fimi.soul.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
@SuppressLint({"NewApi"})
@TargetApi(11)
/* loaded from: classes.dex */
public class BaseActivity extends BaseFimiActivity implements C2678d.AbstractC2680b {
    public DroidPlannerApp dpa;
    public C2657a drone;
    protected C2277v preferencesUtil;
    public C2244b speakTTs;

    public void hideNavigationBar() {
        getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 5894 : 1799);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dpa = (DroidPlannerApp) getApplication();
        this.drone = this.dpa.f7895a;
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.preferencesUtil = C2277v.m12784a(this);
        if (C2241c.m13113b()) {
            this.speakTTs = C2244b.m13105a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseFimiActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.drone.mo11219a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.drone.mo11214b(this);
    }

    @Override // com.fimi.soul.base.BaseFimiActivity, android.app.Activity
    public void setContentView(int i) {
        setAbContentView(i);
    }
}
