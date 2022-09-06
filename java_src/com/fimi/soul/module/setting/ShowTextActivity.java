package com.fimi.soul.module.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
/* loaded from: classes.dex */
public class ShowTextActivity extends BaseActivity {

    /* renamed from: a */
    public static final String f13677a = "URL_TITLE";

    /* renamed from: b */
    public static final String f13678b = "URL_LOCAL";

    /* renamed from: c */
    public static final String f13679c = "URL_ONLINE";

    /* renamed from: d */
    private WebView f13680d;

    /* renamed from: e */
    private Button f13681e;

    /* renamed from: f */
    private Button f13682f;

    /* renamed from: g */
    private TextView f13683g;

    /* renamed from: a */
    private void m8367a(Intent intent) {
        this.f13681e = (Button) findViewById(C2300R.C2302id.backBtn);
        this.f13682f = (Button) findViewById(C2300R.C2302id.down_bt);
        this.f13682f.setVisibility(8);
        intent.getStringExtra(f13679c);
        String stringExtra = intent.getStringExtra(f13678b);
        final int intExtra = intent.getIntExtra(f13677a, 0);
        if (intExtra != 0) {
            this.f13683g.setText(intExtra);
        }
        if (intExtra == 0 || getString(intExtra).equals(getString(C2300R.C2303string.agreement_shengming))) {
            this.f13682f.setVisibility(8);
        } else {
            this.f13682f.setVisibility(0);
        }
        this.f13681e.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.ShowTextActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShowTextActivity.this.finish();
            }
        });
        this.f13682f.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.ShowTextActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShowTextActivity.this.m8365a(ShowTextActivity.this.getString(intExtra));
            }
        });
        this.f13680d = (WebView) findViewById(C2300R.C2302id.web_view);
        this.f13680d.getSettings().setJavaScriptEnabled(true);
        this.f13680d.getSettings().setDomStorageEnabled(true);
        this.f13680d.setWebViewClient(new WebViewClient() { // from class: com.fimi.soul.module.setting.ShowTextActivity.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f13680d.loadUrl(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8365a(String str) {
        if (getString(C2300R.C2303string.agreement_privacy).equals(str) || getString(C2300R.C2303string.agreement_protocol).equals(str)) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://cdn.cnbj1.fds.api.mi-img.com/xiaoqiang/feimi/%s.pdf", str))));
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_show_text);
        this.f13683g = (TextView) findViewById(C2300R.C2302id.title);
        m8367a(getIntent());
    }
}
