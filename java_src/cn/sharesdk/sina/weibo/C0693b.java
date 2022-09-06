package cn.sharesdk.sina.weibo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AbstractC0639b;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0642e;
import cn.sharesdk.framework.utils.C0683d;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.util.HashMap;
/* renamed from: cn.sharesdk.sina.weibo.b */
/* loaded from: classes.dex */
public class C0693b extends AbstractC0639b {

    /* renamed from: d */
    private boolean f1641d;

    public C0693b(C0642e c0642e) {
        super(c0642e);
    }

    /* renamed from: a */
    static /* synthetic */ AuthorizeListener m19471a(C0693b c0693b) {
        return c0693b.f1463c;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.sina.weibo.b$1] */
    /* renamed from: a */
    private void m19472a(final Platform platform, final String str) {
        new Thread() { // from class: cn.sharesdk.sina.weibo.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    String m19457a = C0696d.m19455a(platform).m19457a(platform.getContext(), str);
                    if (m19457a == null) {
                        C0693b.this.f1463c.onError(new Throwable("Authorize token is empty"));
                        return;
                    }
                    HashMap fromJson = new Hashon().fromJson(m19457a);
                    Bundle bundle = new Bundle();
                    bundle.putString(C3947a.f16896g, String.valueOf(fromJson.get(C3947a.f16896g)));
                    bundle.putString("remind_in", String.valueOf(fromJson.get("remind_in")));
                    bundle.putString("expires_in", String.valueOf(fromJson.get("expires_in")));
                    bundle.putString("access_token", String.valueOf(fromJson.get("access_token")));
                    C0693b.this.f1463c.onComplete(bundle);
                } catch (Throwable th) {
                    C0683d.m19513a().m5971d(th);
                }
            }
        }.start();
    }

    /* renamed from: b */
    private Intent m19468b(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.setFlags(268435456);
        return intent;
    }

    /* renamed from: a */
    protected void m19470a(String str) {
        if (this.f1641d) {
            return;
        }
        this.f1641d = true;
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        String string = urlToBundle.getString(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
        String string2 = urlToBundle.getString("error_code");
        if (this.f1463c == null) {
            return;
        }
        if (string == null && string2 == null) {
            String string3 = urlToBundle.getString(XiaomiOAuthConstants.EXTRA_CODE_2);
            if (TextUtils.isEmpty(string3)) {
                this.f1463c.onError(new Throwable("Authorize code is empty"));
            }
            m19472a(this.f1461a.a().getPlatform(), string3);
        } else if (string.equals("access_denied")) {
            this.f1463c.onCancel();
        } else {
            int i = 0;
            try {
                i = ResHelper.parseInt(string2);
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
            this.f1463c.onError(new Throwable(string + " (" + i + ")"));
        }
    }

    @Override // cn.sharesdk.framework.C0668d, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(this.f1462b) && str.startsWith(this.f1462b)) {
            webView.stopLoading();
            this.f1461a.finish();
            m19470a(str);
        } else if (!str.startsWith("sms:")) {
            super.onPageStarted(webView, str, bitmap);
        } else {
            String substring = str.substring(4);
            try {
                Intent m19468b = m19468b(substring);
                m19468b.setPackage("com.android.mms");
                webView.getContext().startActivity(m19468b);
            } catch (Throwable th) {
                try {
                    webView.getContext().startActivity(m19468b(substring));
                } catch (Throwable th2) {
                    if (this.f1463c == null) {
                        return;
                    }
                    this.f1463c.onError(th2);
                }
            }
        }
    }

    @Override // cn.sharesdk.framework.C0668d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(this.f1462b) && str.startsWith(this.f1462b)) {
            webView.stopLoading();
            this.f1461a.finish();
            m19470a(str);
            return true;
        } else if (!str.startsWith("sms:")) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            String substring = str.substring(4);
            try {
                Intent m19468b = m19468b(substring);
                m19468b.setPackage("com.android.mms");
                webView.getContext().startActivity(m19468b);
                return true;
            } catch (Throwable th) {
                try {
                    webView.getContext().startActivity(m19468b(substring));
                    return true;
                } catch (Throwable th2) {
                    if (this.f1463c == null) {
                        return true;
                    }
                    this.f1463c.onError(th2);
                    return true;
                }
            }
        }
    }
}
