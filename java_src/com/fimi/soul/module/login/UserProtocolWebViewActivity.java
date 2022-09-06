package com.fimi.soul.module.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.fimi.kernel.utils.C2271p;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class UserProtocolWebViewActivity extends BasePersonActivity {

    /* renamed from: i */
    private static final String f13135i = "UserProtocolWebViewActi";

    /* renamed from: e */
    DialogC3387e f13136e;

    /* renamed from: f */
    private TitleView f13137f;

    /* renamed from: g */
    private ImageButton f13138g;

    /* renamed from: h */
    private WebView f13139h;

    /* renamed from: g */
    private void m8560g() {
        final String stringExtra = getIntent().getStringExtra("web_url");
        String stringExtra2 = getIntent().getStringExtra("web_title");
        this.f13137f = (TitleView) findViewById(C2300R.C2302id.title_view);
        this.f13137f.setTvTitle(stringExtra2);
        this.f13138g = (ImageButton) findViewById(C2300R.C2302id.btn_back);
        this.f13139h = (WebView) findViewById(C2300R.C2302id.web_view);
        this.f13139h.getSettings().setJavaScriptEnabled(true);
        this.f13139h.getSettings().setDomStorageEnabled(true);
        if (C2271p.m12860b(this) >= 2000.0f) {
            this.f13139h.getSettings().setTextSize(WebSettings.TextSize.SMALLER);
        }
        this.f13136e = new DialogC3387e(this.f12945b, C2300R.style.network_load_progress_dialog, true);
        this.f13139h.setWebViewClient(new WebViewClient() { // from class: com.fimi.soul.module.login.UserProtocolWebViewActivity.1
            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProtocolWebViewActivity.this);
                builder.setMessage("Certificate error");
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.login.UserProtocolWebViewActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.proceed();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.login.UserProtocolWebViewActivity.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.cancel();
                    }
                });
                builder.create().show();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f13139h.setWebChromeClient(new WebChromeClient() { // from class: com.fimi.soul.module.login.UserProtocolWebViewActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (((UserProtocolWebViewActivity) UserProtocolWebViewActivity.this.f12945b).isFinishing()) {
                    return;
                }
                if (i == 100) {
                    if (UserProtocolWebViewActivity.this.f13136e == null) {
                        return;
                    }
                    try {
                        UserProtocolWebViewActivity.this.f13136e.dismiss();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                try {
                    if (UserProtocolWebViewActivity.this.f13136e.isShowing()) {
                        return;
                    }
                    UserProtocolWebViewActivity.this.f13136e.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.f13139h.postDelayed(new Runnable() { // from class: com.fimi.soul.module.login.UserProtocolWebViewActivity.3
            @Override // java.lang.Runnable
            public void run() {
                UserProtocolWebViewActivity.this.f13139h.loadUrl(stringExtra);
            }
        }, 500L);
    }

    @Override // com.fimi.soul.module.login.BasePersonActivity, com.fimi.soul.module.login.BaseActivity
    /* renamed from: b */
    protected void mo8564b() {
    }

    @Override // com.fimi.soul.module.login.BaseActivity
    /* renamed from: c */
    public void mo8563c() {
        m8560g();
        PercentRelativeLayout.LayoutParams layoutParams = (PercentRelativeLayout.LayoutParams) this.f13137f.getLayoutParams();
        layoutParams.setMargins(0, this.f12946c + this.f12947d, 0, 0);
        this.f13137f.setLayoutParams(layoutParams);
    }

    @Override // com.fimi.soul.module.login.BaseActivity
    /* renamed from: d */
    public void mo8562d() {
        this.f13137f.setIvLeftListener(new View.OnClickListener() { // from class: com.fimi.soul.module.login.UserProtocolWebViewActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserProtocolWebViewActivity.this.f13139h.canGoBack()) {
                    UserProtocolWebViewActivity.this.f13139h.goBack();
                } else {
                    UserProtocolWebViewActivity.this.finish();
                }
            }
        });
    }

    @Override // com.fimi.soul.module.login.BaseActivity
    /* renamed from: e */
    protected int mo8561e() {
        return C2300R.layout.activity_user_protocol_web_view;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f13139h.canGoBack()) {
            this.f13139h.goBack();
        } else {
            finish();
        }
    }
}
