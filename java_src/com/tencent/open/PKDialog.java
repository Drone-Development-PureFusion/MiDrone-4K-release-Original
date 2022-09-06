package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.C4315a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4343g;
import com.tencent.open.p230c.C4352a;
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
public class PKDialog extends AbstractDialogC4335b implements C4352a.AbstractC4353a {
    private static final int MSG_CANCEL = 2;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_ON_LOAD = 4;
    private static final int MSG_SHOW_PROCESS = 5;
    private static final int MSG_SHOW_TIPS = 3;
    private static final int WEBVIEW_HEIGHT = 185;
    private IUiListener listener;
    private C4352a mFlMain;
    private Handler mHandler;
    private OnTimeListener mListener;
    private String mUrl;
    private WeakReference<Context> mWeakContext;
    private C4354b mWebView;
    private int mWebviewHeight;
    private static final String TAG = PKDialog.class.getName();
    static Toast sToast = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            PKDialog.this.mWebView.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Util.logd(PKDialog.TAG, "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            PKDialog.this.mListener.onError(new UiError(i, str, str2));
            if (PKDialog.this.mWeakContext != null && PKDialog.this.mWeakContext.get() != null) {
                Toast.makeText((Context) PKDialog.this.mWeakContext.get(), "网络连接异常或系统错误", 0).show();
            }
            PKDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Util.logd(PKDialog.TAG, "Redirect URL: " + str);
            if (str.startsWith(ServerSetting.getInstance().getEnvUrl((Context) PKDialog.this.mWeakContext.get(), ServerSetting.DEFAULT_REDIRECT_URI))) {
                PKDialog.this.mListener.onComplete(Util.parseUrlToJson(str));
                PKDialog.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                PKDialog.this.mListener.onCancel();
                PKDialog.this.dismiss();
                return true;
            } else if (!str.startsWith("auth://close")) {
                return false;
            } else {
                PKDialog.this.dismiss();
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class JsListener extends C4315a.C4317b {
        private JsListener() {
        }

        public void onCancel(String str) {
            PKDialog.this.mHandler.obtainMessage(2, str).sendToTarget();
            PKDialog.this.dismiss();
        }

        public void onComplete(String str) {
            PKDialog.this.mHandler.obtainMessage(1, str).sendToTarget();
            C4331f.m5439e("onComplete", str);
            PKDialog.this.dismiss();
        }

        public void onLoad(String str) {
            PKDialog.this.mHandler.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            PKDialog.this.mHandler.obtainMessage(3, str).sendToTarget();
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
        private OnTimeListener f17948mL;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f17948mL = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C4331f.m5445b("PKDialog", "msg = " + message.what);
            switch (message.what) {
                case 1:
                    this.f17948mL.onComplete((String) message.obj);
                    return;
                case 2:
                    this.f17948mL.onCancel();
                    return;
                case 3:
                    if (PKDialog.this.mWeakContext == null || PKDialog.this.mWeakContext.get() == null) {
                        return;
                    }
                    PKDialog.showTips((Context) PKDialog.this.mWeakContext.get(), (String) message.obj);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    if (PKDialog.this.mWeakContext == null || PKDialog.this.mWeakContext.get() == null) {
                        return;
                    }
                    PKDialog.showProcessDialog((Context) PKDialog.this.mWeakContext.get(), (String) message.obj);
                    return;
            }
        }
    }

    public PKDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.mWeakContext = new WeakReference<>(context);
        this.mUrl = str2;
        this.mListener = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.mHandler = new THandler(this.mListener, context.getMainLooper());
        this.listener = iUiListener;
        this.mWebviewHeight = Math.round(185.0f * context.getResources().getDisplayMetrics().density);
        C4331f.m5439e(TAG, "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.mWebviewHeight);
    }

    private void createViews() {
        this.mFlMain = new C4352a(this.mWeakContext.get());
        this.mFlMain.setBackgroundColor(1711276032);
        this.mFlMain.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mWebView = new C4354b(this.mWeakContext.get());
        this.mWebView.setBackgroundColor(0);
        this.mWebView.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.mWebView, 1, new Paint());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mWebviewHeight);
        layoutParams.addRule(13, -1);
        this.mWebView.setLayoutParams(layoutParams);
        this.mFlMain.addView(this.mWebView);
        this.mFlMain.m5387a(this);
        setContentView(this.mFlMain);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initViews() {
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(new FbWebViewClient());
        this.mWebView.setWebChromeClient(this.mChromeClient);
        this.mWebView.clearFormData();
        WebSettings settings = this.mWebView.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        if (this.mWeakContext != null && this.mWeakContext.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.mWeakContext.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.jsBridge.m5498a(new JsListener(), "sdk_js_if");
        this.mWebView.clearView();
        this.mWebView.loadUrl(this.mUrl);
        this.mWebView.getSettings().setSavePassword(false);
    }

    private void loadUrlWithBrowser(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        if (this.mWeakContext == null || this.mWeakContext.get() == null) {
            return;
        }
        this.mWeakContext.get().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showProcessDialog(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject parseJson = Util.parseJson(str);
            int i = parseJson.getInt(AuthActivity.ACTION_KEY);
            parseJson.getString(SocialConstants.PARAM_SEND_MSG);
            if (i == 1) {
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showTips(Context context, String str) {
        try {
            JSONObject parseJson = Util.parseJson(str);
            int i = parseJson.getInt("type");
            String string = parseJson.getString(SocialConstants.PARAM_SEND_MSG);
            if (i == 0) {
                if (sToast == null) {
                    sToast = Toast.makeText(context, string, 0);
                } else {
                    sToast.setView(sToast.getView());
                    sToast.setText(string);
                    sToast.setDuration(0);
                }
                sToast.show();
            } else if (i != 1) {
            } else {
                if (sToast == null) {
                    sToast = Toast.makeText(context, string, 1);
                } else {
                    sToast.setView(sToast.getView());
                    sToast.setText(string);
                    sToast.setDuration(1);
                }
                sToast.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void callJs(String str, String str2) {
        this.mWebView.loadUrl("javascript:" + str + "(" + str2 + ")");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.AbstractDialogC4335b
    protected void onConsoleMessage(String str) {
        C4331f.m5445b("PKDialog", "--onConsoleMessage--");
        try {
            this.jsBridge.mo5343a(this.mWebView, str);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.AbstractDialogC4335b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        createViews();
        initViews();
    }

    @Override // com.tencent.open.p230c.C4352a.AbstractC4353a
    public void onKeyboardHidden() {
        this.mWebView.getLayoutParams().height = this.mWebviewHeight;
        C4331f.m5439e(TAG, "keyboard hide");
    }

    @Override // com.tencent.open.p230c.C4352a.AbstractC4353a
    public void onKeyboardShown(int i) {
        if (this.mWeakContext != null && this.mWeakContext.get() != null) {
            if (i >= this.mWebviewHeight || 2 != this.mWeakContext.get().getResources().getConfiguration().orientation) {
                this.mWebView.getLayoutParams().height = this.mWebviewHeight;
            } else {
                this.mWebView.getLayoutParams().height = i;
            }
        }
        C4331f.m5439e(TAG, "keyboard show");
    }
}
