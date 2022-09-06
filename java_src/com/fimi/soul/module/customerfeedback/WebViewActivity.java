package com.fimi.soul.module.customerfeedback;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class WebViewActivity extends Activity {

    /* renamed from: a */
    public static final String f11532a = "WebUrl";

    /* renamed from: b */
    private WebView f11533b;

    /* renamed from: c */
    private String f11534c = "http://www.hao123.com";

    /* renamed from: d */
    private String f11535d;

    /* renamed from: com.fimi.soul.module.customerfeedback.WebViewActivity$a */
    /* loaded from: classes.dex */
    class C3081a extends WebChromeClient {
        C3081a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    /* renamed from: com.fimi.soul.module.customerfeedback.WebViewActivity$b */
    /* loaded from: classes.dex */
    class C3082b extends WebViewClient {
        C3082b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            super.onScaleChanged(webView, f, f2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.webview_activity);
        this.f11533b = (WebView) findViewById(C2300R.C2302id.webview);
        WebSettings settings = this.f11533b.getSettings();
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        this.f11533b.setWebChromeClient(new C3081a());
        this.f11533b.setWebViewClient(new C3082b());
        this.f11533b.loadUrl(this.f11534c);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f11533b.canGoBack()) {
            this.f11533b.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
