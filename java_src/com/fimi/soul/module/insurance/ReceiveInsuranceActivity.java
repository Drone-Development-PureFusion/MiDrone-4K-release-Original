package com.fimi.soul.module.insurance;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class ReceiveInsuranceActivity extends Activity {

    /* renamed from: a */
    public static String f12938a = "https://api.jr.mi.com/insurance/uav.html?from=uav";

    /* renamed from: b */
    private WebView f12939b;

    /* renamed from: a */
    private void m8680a() {
        this.f12939b = (WebView) findViewById(C2300R.C2302id.webView);
        WebSettings settings = this.f12939b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        this.f12939b.setWebViewClient(new WebViewClient() { // from class: com.fimi.soul.module.insurance.ReceiveInsuranceActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f12939b.loadUrl("http://staging.mifi.pt.xiaomi.com/insurance/uav.html");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_receive_insurance);
        m8680a();
    }
}
