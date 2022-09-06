package com.fimi.soul.module.droneui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.entity.MoreSettingInfo;
import com.fimi.soul.p167b.C2340g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MoreInfoSettingAcitivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Button f12798a;

    /* renamed from: b */
    private TextView f12799b;

    /* renamed from: c */
    private ListView f12800c;

    /* renamed from: d */
    private List<MoreSettingInfo> f12801d;

    /* renamed from: e */
    private C2340g.EnumC2342a[] f12802e = {C2340g.EnumC2342a.FLIHGT_PARAMETER, C2340g.EnumC2342a.GIMBAL_ANGLE};

    /* renamed from: a */
    public void m8798a() {
        this.f12798a = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f12799b = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f12800c = (ListView) findViewById(C2300R.C2302id.setting_lv);
    }

    /* renamed from: b */
    public void m8797b() {
        this.f12799b.setText(getString(C2300R.C2303string.show_more_patter));
        this.f12801d = new ArrayList();
        for (int i = 0; i < this.f12802e.length; i++) {
            MoreSettingInfo moreSettingInfo = new MoreSettingInfo();
            moreSettingInfo.setIndexEnum(this.f12802e[i]);
            this.f12801d.add(moreSettingInfo);
        }
        this.f12800c.setAdapter((ListAdapter) new C2340g(this, this.f12801d));
        this.f12800c.setOnItemClickListener(this);
    }

    /* renamed from: c */
    public void m8796c() {
        this.f12798a.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.black_btn /* 2131493817 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_more_info_setting_acitivity);
        m8798a();
        m8797b();
        m8796c();
    }

    public void onFlightParameter(View view) {
        SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
        if (C2238c.m13123e().m12771d()) {
            C2238c.m13123e().m12780a(false);
            switchButton.m12667a(false, true);
            return;
        }
        C2238c.m13123e().m12780a(true);
        switchButton.m12667a(true, true);
    }

    public void onGimbalAngle(View view) {
        SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
        if (C2238c.m13123e().m12767e()) {
            C2238c.m13123e().m12776b(false);
            switchButton.m12667a(false, true);
            return;
        }
        C2238c.m13123e().m12776b(true);
        switchButton.m12667a(true, true);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.f12801d.get(i).getIndexEnum()) {
            case FLIHGT_PARAMETER:
                onFlightParameter(view);
                return;
            case GIMBAL_ANGLE:
                onGimbalAngle(view);
                return;
            default:
                return;
        }
    }
}
