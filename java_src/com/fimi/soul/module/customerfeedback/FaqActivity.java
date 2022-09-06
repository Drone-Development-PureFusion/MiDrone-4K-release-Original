package com.fimi.soul.module.customerfeedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.utils.C3658ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FaqActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Button f11515a;

    /* renamed from: b */
    private TextView f11516b;

    /* renamed from: c */
    private ListView f11517c;

    /* renamed from: d */
    private List<String> f11518d = new ArrayList();

    /* renamed from: e */
    private C3085b f11519e;

    /* renamed from: a */
    private void m9713a() {
        String[] stringArray;
        for (String str : getResources().getStringArray(C2300R.array.faq_list_content)) {
            if (!this.f11518d.contains(str)) {
                this.f11518d.add(str);
            }
        }
    }

    /* renamed from: a */
    private void m9712a(Class cls) {
        startActivity(new Intent(this, cls));
    }

    /* renamed from: b */
    private void m9711b() {
        C3658ar.m7598b(getAssets(), this.f11516b);
    }

    /* renamed from: c */
    private void m9710c() {
        this.f11515a = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f11515a.setOnClickListener(this);
        this.f11516b = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f11516b.setText(C2300R.C2303string.help);
        this.f11517c = (ListView) findViewById(C2300R.C2302id.navigation_listview);
        this.f11519e = new C3085b(this.f11518d, getApplicationContext());
        this.f11517c.setAdapter((ListAdapter) this.f11519e);
        this.f11517c.setOnItemClickListener(this);
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
        setContentView(C2300R.layout.navifation_feedback_activity);
        m9713a();
        m9710c();
        m9711b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) adapterView.getItemAtPosition(i);
        if (!str.equals(getString(C2300R.C2303string.hot_answer)) && !str.equals(getString(C2300R.C2303string.drone)) && !str.equals(getString(C2300R.C2303string.remote)) && !str.equals(getString(C2300R.C2303string.cloud_camera)) && !str.equals(getString(C2300R.C2303string.faq_battery)) && !str.equals(getString(C2300R.C2303string.app)) && !str.equals(getString(C2300R.C2303string.faq_secure)) && str.equals(getString(C2300R.C2303string.others))) {
        }
    }
}
