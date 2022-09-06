package com.fimi.x1bh.module.camerasetting;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.utils.C3658ar;
import com.fimi.x1bh.module.X1bhBaseActivity;
/* loaded from: classes.dex */
public class CloudCameraSettingActivity extends X1bhBaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private ListView f16612a;

    /* renamed from: b */
    private Button f16613b;

    /* renamed from: c */
    private TextView f16614c;

    /* renamed from: d */
    private C3905a f16615d;

    /* renamed from: a */
    private void m6602a() {
        this.f16613b = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f16614c = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f16612a = (ListView) findViewById(C2300R.C2302id.setting_lv);
        this.f16612a.setOverScrollMode(2);
        this.f16614c.setText(C2300R.C2303string.camera_setting);
        this.f16613b.setOnClickListener(this);
        C3658ar.m7612a(getAssets(), this.f16614c);
    }

    /* renamed from: a */
    private void m6601a(C2423d c2423d) {
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 2;
        if ("menu_album".equals("") || !c2423d.e()) {
            return;
        }
        c2423d.m12233u().m12298a("menu_album", C2427e.f8308cE);
    }

    /* renamed from: b */
    private void m6600b() {
        this.f16615d = new C3905a(this);
        this.f16615d.m6599a();
        this.f16615d.m6589b();
        this.f16612a.setAdapter((ListAdapter) this.f16615d);
        this.f16612a.setOnItemClickListener(this.f16615d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2300R.C2302id.black_btn) {
            ((C2423d) C2379b.m12410a().m12394d()).m12233u().m12289e();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_camera_setting);
        m6602a();
        m6600b();
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ((C2423d) C2379b.m12410a().m12394d()).m12233u().m12289e();
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
