package com.fimi.soul.module.push;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.entity.HistoryPushMessage;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.p211a.C3628c;
import java.util.List;
/* loaded from: classes.dex */
public class HistoryMessageActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private C3407a f13311a;

    /* renamed from: b */
    private ListView f13312b;

    /* renamed from: c */
    private List<HistoryPushMessage> f13313c;

    /* renamed from: d */
    private C3628c f13314d;

    /* renamed from: e */
    private TextView f13315e;

    /* renamed from: f */
    private ImageView f13316f;

    /* renamed from: a */
    private void m8490a() {
        TextView textView = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        textView.setText(C2300R.C2303string.setting_history_message);
        Button button = (Button) findViewById(C2300R.C2302id.black_btn);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.push.HistoryMessageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HistoryMessageActivity.this.finish();
            }
        });
        this.f13312b = (ListView) findViewById(C2300R.C2302id.history_message_lv);
        this.f13312b.setOnItemClickListener(this);
        this.f13312b.setOverScrollMode(2);
        this.f13315e = (TextView) findViewById(C2300R.C2302id.history_message_no_tv);
        this.f13316f = (ImageView) findViewById(C2300R.C2302id.history_message_no_iv);
        C3658ar.m7612a(getAssets(), textView, button, this.f13315e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_history_message);
        m8490a();
        this.f13314d = C3628c.m7748a(this);
        this.f13313c = this.f13314d.m7749a();
        if (this.f13313c.size() <= 0) {
            this.f13315e.setVisibility(0);
            this.f13316f.setVisibility(0);
            return;
        }
        this.f13315e.setVisibility(8);
        this.f13316f.setVisibility(8);
        this.f13311a = new C3407a(this, this.f13313c);
        this.f13312b.setAdapter((ListAdapter) this.f13311a);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, MessageDetailActivity.class);
        intent.putExtra("redirectURL", this.f13313c.get(i).getRedirectURL());
        startActivity(intent);
    }
}
