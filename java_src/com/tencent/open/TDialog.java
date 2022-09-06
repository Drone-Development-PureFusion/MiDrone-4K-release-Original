package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.AuthConstants;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.C4315a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4343g;
import com.tencent.open.p230c.C4354b;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.Util;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TDialog extends AbstractDialogC4335b {

    /* renamed from: a */
    static final FrameLayout.LayoutParams f17969a = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: b */
    static Toast f17970b = null;

    /* renamed from: d */
    private static WeakReference<ProgressDialog> f17971d;

    /* renamed from: c */
    private WeakReference<Context> f17972c;

    /* renamed from: e */
    private String f17973e;

    /* renamed from: f */
    private OnTimeListener f17974f;

    /* renamed from: g */
    private IUiListener f17975g;

    /* renamed from: h */
    private FrameLayout f17976h;

    /* renamed from: i */
    private C4354b f17977i;

    /* renamed from: j */
    private Handler f17978j;

    /* renamed from: k */
    private boolean f17979k = false;

    /* renamed from: l */
    private QQToken f17980l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f17977i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Util.logd("TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TDialog.this.f17974f.onError(new UiError(i, str, str2));
            if (TDialog.this.f17972c != null && TDialog.this.f17972c.get() != null) {
                Toast.makeText((Context) TDialog.this.f17972c.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Util.logd("TDialog", "Redirect URL: " + str);
            if (str.startsWith(ServerSetting.getInstance().getEnvUrl((Context) TDialog.this.f17972c.get(), ServerSetting.DEFAULT_REDIRECT_URI))) {
                TDialog.this.f17974f.onComplete(Util.parseUrlToJson(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://cancel")) {
                TDialog.this.f17974f.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://close")) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (!str.startsWith("download://")) {
                return str.startsWith(AuthConstants.PROGRESS_URI);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring("download://".length()))));
                intent.addFlags(268435456);
                if (TDialog.this.f17972c != null && TDialog.this.f17972c.get() != null) {
                    ((Context) TDialog.this.f17972c.get()).startActivity(intent);
                }
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class JsListener extends C4315a.C4317b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            C4331f.m5445b("TDialog", "onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            C4331f.m5445b("TDialog", "onCancel --msg = " + str);
            TDialog.this.f17978j.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            C4331f.m5445b("TDialog", "onCancelAddShare");
            onCancel("cancel");
        }

        public void onCancelInvite() {
            C4331f.m5445b("TDialog", "onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f17978j.obtainMessage(1, str).sendToTarget();
            C4331f.m5439e("onComplete", str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f17978j.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f17978j.obtainMessage(3, str).sendToTarget();
        }
    }

    /* loaded from: classes2.dex */
    private static class OnTimeListener implements IUiListener {
        private String mAction;
        String mAppid;
        String mUrl;
        private WeakReference<Context> mWeakCtx;
        private IUiListener mWeakL;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.mWeakCtx = new WeakReference<>(context);
            this.mAction = str;
            this.mUrl = str2;
            this.mAppid = str3;
            this.mWeakL = iUiListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onComplete(String str) {
            try {
                onComplete(Util.parseJson(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.mWeakL != null) {
                this.mWeakL.onCancel();
                this.mWeakL = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C4343g.m5402a().m5397a(this.mAction + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.mUrl, false);
            if (this.mWeakL != null) {
                this.mWeakL.onComplete(jSONObject);
                this.mWeakL = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            C4343g.m5402a().m5397a(this.mAction + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, uiError.errorMessage != null ? uiError.errorMessage + this.mUrl : this.mUrl, false);
            if (this.mWeakL != null) {
                this.mWeakL.onError(uiError);
                this.mWeakL = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    private class THandler extends Handler {

        /* renamed from: mL */
        private OnTimeListener f17981mL;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f17981mL = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C4331f.m5445b("TAG", "--handleMessage--msg.WHAT = " + message.what);
            switch (message.what) {
                case 1:
                    this.f17981mL.onComplete((String) message.obj);
                    return;
                case 2:
                    this.f17981mL.onCancel();
                    return;
                case 3:
                    if (TDialog.this.f17972c == null || TDialog.this.f17972c.get() == null) {
                        return;
                    }
                    TDialog.m5565c((Context) TDialog.this.f17972c.get(), (String) message.obj);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    if (TDialog.this.f17972c == null || TDialog.this.f17972c.get() == null) {
                        return;
                    }
                    TDialog.m5563d((Context) TDialog.this.f17972c.get(), (String) message.obj);
                    return;
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f17980l = null;
        this.f17972c = new WeakReference<>(context);
        this.f17973e = str2;
        this.f17974f = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f17978j = new THandler(this.f17974f, context.getMainLooper());
        this.f17975g = iUiListener;
        this.f17980l = qQToken;
    }

    /* renamed from: a */
    private void m5571a() {
        new TextView(this.f17972c.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f17977i = new C4354b(this.f17972c.get());
        this.f17977i.setLayoutParams(layoutParams);
        this.f17976h = new FrameLayout(this.f17972c.get());
        layoutParams.gravity = 17;
        this.f17976h.setLayoutParams(layoutParams);
        this.f17976h.addView(this.f17977i);
        setContentView(this.f17976h);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    private void m5568b() {
        this.f17977i.setVerticalScrollBarEnabled(false);
        this.f17977i.setHorizontalScrollBarEnabled(false);
        this.f17977i.setWebViewClient(new FbWebViewClient());
        this.f17977i.setWebChromeClient(this.mChromeClient);
        this.f17977i.clearFormData();
        WebSettings settings = this.f17977i.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        if (this.f17972c != null && this.f17972c.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f17972c.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.jsBridge.m5498a(new JsListener(), "sdk_js_if");
        this.f17977i.loadUrl(this.f17973e);
        this.f17977i.setLayoutParams(f17969a);
        this.f17977i.setVisibility(4);
        this.f17977i.getSettings().setSavePassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m5565c(Context context, String str) {
        try {
            JSONObject parseJson = Util.parseJson(str);
            int i = parseJson.getInt("type");
            String string = parseJson.getString(SocialConstants.PARAM_SEND_MSG);
            if (i == 0) {
                if (f17970b == null) {
                    f17970b = Toast.makeText(context, string, 0);
                } else {
                    f17970b.setView(f17970b.getView());
                    f17970b.setText(string);
                    f17970b.setDuration(0);
                }
                f17970b.show();
            } else if (i != 1) {
            } else {
                if (f17970b == null) {
                    f17970b = Toast.makeText(context, string, 1);
                } else {
                    f17970b.setView(f17970b.getView());
                    f17970b.setText(string);
                    f17970b.setDuration(1);
                }
                f17970b.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m5563d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject parseJson = Util.parseJson(str);
            int i = parseJson.getInt(AuthActivity.ACTION_KEY);
            String string = parseJson.getString(SocialConstants.PARAM_SEND_MSG);
            if (i == 1) {
                if (f17971d == null) {
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f17971d = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else {
                    f17971d.get().setMessage(string);
                    if (!f17971d.get().isShowing()) {
                        f17971d.get().show();
                    }
                }
            } else if (i == 0 && f17971d != null && f17971d.get() != null && f17971d.get().isShowing()) {
                f17971d.get().dismiss();
                f17971d = null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.f17974f != null) {
            this.f17974f.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.AbstractDialogC4335b
    protected void onConsoleMessage(String str) {
        C4331f.m5445b("TDialog", "--onConsoleMessage--");
        try {
            this.jsBridge.mo5343a(this.f17977i, str);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.AbstractDialogC4335b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        m5571a();
        m5568b();
    }
}
