package com.fimi.soul.module.remote;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.view.KeyEvent;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.remote.BaseRemoteFragment;
import com.fimi.soul.view.DialogC3800f;
/* loaded from: classes.dex */
public class RemoteCalibration extends BaseActivity implements C2678d.AbstractC2680b, BaseRemoteFragment.AbstractC3410a {

    /* renamed from: a */
    private RemoteMidCalibrationFragment f13375a;

    /* renamed from: b */
    private BaseRemoteFragment f13376b;

    /* renamed from: c */
    private FragmentManager f13377c;

    /* renamed from: d */
    private C3057d f13378d;

    /* renamed from: e */
    private RemoteRollerFragment f13379e;

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment.AbstractC3410a
    /* renamed from: a */
    public void mo8480a() {
        DialogC3800f.C3801a c3801a = new DialogC3800f.C3801a(this);
        c3801a.m7031a(getString(C2300R.C2303string.interruptcaliremote));
        c3801a.m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.remote.RemoteCalibration.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.remote.RemoteCalibration.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                RemoteCalibration.this.f13378d.m9803n();
                RemoteCalibration.this.f13378d.m9804m();
                RemoteCalibration.this.finish();
            }
        }).m7035a().show();
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment.AbstractC3410a
    /* renamed from: a */
    public void mo8479a(int i, int i2) {
        this.f13377c.beginTransaction().hide(this.f13377c.findFragmentById(i)).commitAllowingStateLoss();
        this.f13377c.beginTransaction().show(this.f13377c.findFragmentById(i2)).commitAllowingStateLoss();
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment.AbstractC3410a
    /* renamed from: a */
    public void mo8478a(int i, int i2, String str, boolean z) {
        if (!(this.f13377c.findFragmentById(i) instanceof ErrorCaliBretionFragment)) {
            this.f13377c.beginTransaction().hide(this.f13377c.findFragmentById(i)).commitAllowingStateLoss();
            if (this.f13377c.findFragmentById(i2) == null || !(this.f13377c.findFragmentById(i2) instanceof ErrorCaliBretionFragment)) {
                return;
            }
            ErrorCaliBretionFragment errorCaliBretionFragment = (ErrorCaliBretionFragment) this.f13377c.findFragmentById(i2);
            errorCaliBretionFragment.m8482a(str, z);
            if (!errorCaliBretionFragment.isHidden()) {
                return;
            }
            this.f13377c.beginTransaction().show(errorCaliBretionFragment).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.remotecalibration);
        getWindow().setFlags(128, 128);
        this.f13378d = C3057d.m9823a(this.drone);
        this.f13377c = getSupportFragmentManager();
        if (bundle == null) {
            this.f13376b = (BaseRemoteFragment) this.f13377c.findFragmentById(C2300R.C2302id.basefragment);
            if (this.f13376b == null) {
                this.f13376b = new BaseRemoteFragment();
                this.f13377c.beginTransaction().add(C2300R.C2302id.basefragment, this.f13376b).commit();
            }
            this.f13379e = (RemoteRollerFragment) this.f13377c.findFragmentById(C2300R.C2302id.remote_roller_fragment);
            if (this.f13379e == null) {
                this.f13379e = new RemoteRollerFragment();
            }
            this.f13377c.beginTransaction().add(C2300R.C2302id.remote_roller_fragment, this.f13379e).commit();
            RemoteMidcalingFragment remoteMidcalingFragment = (RemoteMidcalingFragment) this.f13377c.findFragmentById(C2300R.C2302id.midcalibrationing);
            if (remoteMidcalingFragment == null) {
                remoteMidcalingFragment = new RemoteMidcalingFragment();
            }
            this.f13377c.beginTransaction().add(C2300R.C2302id.midcalibrationing, remoteMidcalingFragment).hide(remoteMidcalingFragment).commit();
            RemoteEndCaliFragment remoteEndCaliFragment = (RemoteEndCaliFragment) this.f13377c.findFragmentById(C2300R.C2302id.endmidcalibration);
            if (remoteEndCaliFragment == null) {
                remoteEndCaliFragment = new RemoteEndCaliFragment();
            }
            this.f13377c.beginTransaction().add(C2300R.C2302id.endmidcalibration, remoteEndCaliFragment).hide(remoteEndCaliFragment).commit();
            CarliRemoteFragment carliRemoteFragment = (CarliRemoteFragment) this.f13377c.findFragmentById(C2300R.C2302id.caliremotestart);
            if (carliRemoteFragment == null) {
                carliRemoteFragment = new CarliRemoteFragment();
            }
            this.f13377c.beginTransaction().add(C2300R.C2302id.caliremotestart, carliRemoteFragment).hide(carliRemoteFragment).commit();
            WhellRemoteFragment whellRemoteFragment = (WhellRemoteFragment) this.f13377c.findFragmentById(C2300R.C2302id.cariremotecomple);
            if (whellRemoteFragment == null) {
                whellRemoteFragment = new WhellRemoteFragment();
            }
            this.f13377c.beginTransaction().replace(C2300R.C2302id.cariremotecomple, whellRemoteFragment).hide(whellRemoteFragment).commit();
            ErrorCaliBretionFragment errorCaliBretionFragment = (ErrorCaliBretionFragment) this.f13377c.findFragmentById(C2300R.C2302id.errorcalifragment);
            if (errorCaliBretionFragment == null) {
                errorCaliBretionFragment = new ErrorCaliBretionFragment();
            }
            this.f13377c.beginTransaction().add(C2300R.C2302id.errorcalifragment, errorCaliBretionFragment).hide(errorCaliBretionFragment).commit();
            this.drone.m11293g(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.drone.m11293g(false);
        super.onDestroy();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case backControl:
                C3074a.m9756a().m9754a("98");
                return;
            case CLEANALLOBJ:
                for (Fragment fragment : this.f13377c.getFragments()) {
                    if (fragment.isVisible() && this.f13379e != null && !this.f13379e.isVisible()) {
                        mo8478a(fragment.getId(), C2300R.C2302id.errorcalifragment, getString(C2300R.C2303string.calidisconremote), false);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f13379e == null || !this.f13379e.isVisible()) {
                mo8480a();
            } else {
                finish();
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.drone.mo11219a(this);
        this.f13378d.m9807j();
    }
}
