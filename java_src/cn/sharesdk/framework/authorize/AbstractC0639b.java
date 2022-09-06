package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.C0668d;
/* renamed from: cn.sharesdk.framework.authorize.b */
/* loaded from: classes.dex */
public abstract class AbstractC0639b extends C0668d {

    /* renamed from: a */
    protected C0642e f1461a;

    /* renamed from: b */
    protected String f1462b;

    /* renamed from: c */
    protected AuthorizeListener f1463c;

    public AbstractC0639b(C0642e c0642e) {
        this.f1461a = c0642e;
        AuthorizeHelper a = c0642e.a();
        this.f1462b = a.getRedirectUri();
        this.f1463c = a.getAuthorizeListener();
    }

    @Override // cn.sharesdk.framework.C0668d, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.stopLoading();
        AuthorizeListener authorizeListener = this.f1461a.a().getAuthorizeListener();
        this.f1461a.finish();
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable(str + " (" + i + "): " + str2));
        }
    }
}
