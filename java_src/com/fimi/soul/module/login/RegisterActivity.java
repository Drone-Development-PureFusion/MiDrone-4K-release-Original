package com.fimi.soul.module.login;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class RegisterActivity extends Activity {

    /* renamed from: a */
    private WebView f13098a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_register);
        this.f13098a = (WebView) findViewById(C2300R.C2302id.web_view);
        this.f13098a.getSettings().setJavaScriptEnabled(true);
        this.f13098a.setWebViewClient(new WebViewClient() { // from class: com.fimi.soul.module.login.RegisterActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f13098a.loadUrl("https://account.xiaomi.com/pass/register");
    }
}
