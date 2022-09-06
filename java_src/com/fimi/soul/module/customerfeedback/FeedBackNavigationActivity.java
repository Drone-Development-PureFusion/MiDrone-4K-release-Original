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
public class FeedBackNavigationActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Button f11520a;

    /* renamed from: b */
    private TextView f11521b;

    /* renamed from: c */
    private List<String> f11522c = new ArrayList();

    /* renamed from: d */
    private C3090e f11523d;

    /* renamed from: e */
    private ListView f11524e;

    /* renamed from: a */
    private void m9709a() {
        String[] stringArray;
        for (String str : getResources().getStringArray(C2300R.array.feedback_navigation)) {
            if (!this.f11522c.contains(str)) {
                this.f11522c.add(str);
            }
        }
    }

    /* renamed from: a */
    private void m9708a(Class cls) {
        startActivity(new Intent(this, cls));
    }

    /* renamed from: b */
    private void m9707b() {
        C3658ar.m7598b(getAssets(), this.f11521b);
    }

    /* renamed from: c */
    private void m9706c() {
        this.f11520a = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f11520a.setOnClickListener(this);
        this.f11521b = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f11521b.setText(C2300R.C2303string.help);
        this.f11524e = (ListView) findViewById(C2300R.C2302id.navigation_listview);
        this.f11523d = new C3090e(this.f11522c, getApplicationContext());
        this.f11524e.setAdapter((ListAdapter) this.f11523d);
        this.f11524e.setOnItemClickListener(this);
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
        m9709a();
        m9706c();
        m9707b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) adapterView.getItemAtPosition(i);
        if (str.equals(getString(C2300R.C2303string.faq))) {
            m9708a(FaqActivity.class);
        } else if (str.equals(getString(C2300R.C2303string.totural))) {
            m9708a(WebViewActivity.class);
        } else if (!str.equals(getString(C2300R.C2303string.feedback_help))) {
        } else {
            m9708a(CustomerFeedBackActivity.class);
        }
    }
}
