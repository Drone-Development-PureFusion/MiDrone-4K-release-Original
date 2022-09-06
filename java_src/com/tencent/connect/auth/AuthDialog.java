package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.AuthMap;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4343g;
import com.tencent.open.p230c.C4355c;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.open.web.security.C4366b;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public class AuthDialog extends Dialog {

    /* renamed from: a */
    private static final String f17380a = C4331f.f18119d + ".authDlg";

    /* renamed from: b */
    private String f17381b;

    /* renamed from: c */
    private OnTimeListener f17382c;

    /* renamed from: d */
    private IUiListener f17383d;

    /* renamed from: e */
    private Handler f17384e;

    /* renamed from: f */
    private FrameLayout f17385f;

    /* renamed from: g */
    private LinearLayout f17386g;

    /* renamed from: h */
    private FrameLayout f17387h;

    /* renamed from: i */
    private ProgressBar f17388i;

    /* renamed from: j */
    private String f17389j;

    /* renamed from: k */
    private C4355c f17390k;

    /* renamed from: l */
    private Context f17391l;

    /* renamed from: o */
    private int f17394o;

    /* renamed from: p */
    private String f17395p;

    /* renamed from: q */
    private String f17396q;

    /* renamed from: t */
    private HashMap<String, Runnable> f17399t;

    /* renamed from: n */
    private boolean f17393n = false;

    /* renamed from: r */
    private long f17397r = 0;

    /* renamed from: s */
    private long f17398s = 30000;

    /* renamed from: m */
    private C4366b f17392m = new C4366b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LoginWebViewClient extends WebViewClient {
        private LoginWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C4331f.m5445b(AuthDialog.f17380a, "-->onPageFinished, url: " + str);
            AuthDialog.this.f17387h.setVisibility(8);
            if (AuthDialog.this.f17390k != null) {
                AuthDialog.this.f17390k.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                AuthDialog.this.f17384e.removeCallbacks((Runnable) AuthDialog.this.f17399t.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C4331f.m5445b(AuthDialog.f17380a, "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            AuthDialog.this.f17387h.setVisibility(0);
            AuthDialog.this.f17397r = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(AuthDialog.this.f17395p)) {
                AuthDialog.this.f17384e.removeCallbacks((Runnable) AuthDialog.this.f17399t.remove(AuthDialog.this.f17395p));
            }
            AuthDialog.this.f17395p = str;
            TimeOutRunable timeOutRunable = new TimeOutRunable(AuthDialog.this.f17395p);
            AuthDialog.this.f17399t.put(str, timeOutRunable);
            AuthDialog.this.f17384e.postDelayed(timeOutRunable, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            C4331f.m5442c(AuthDialog.f17380a, "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!Util.checkNetWork(AuthDialog.this.f17391l)) {
                AuthDialog.this.f17382c.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                AuthDialog.this.dismiss();
            } else if (AuthDialog.this.f17395p.startsWith(ServerSetting.DOWNLOAD_QQ_URL)) {
                AuthDialog.this.f17382c.onError(new UiError(i, str, str2));
                AuthDialog.this.dismiss();
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime() - AuthDialog.this.f17397r;
                if (AuthDialog.this.f17394o >= 1 || elapsedRealtime >= AuthDialog.this.f17398s) {
                    AuthDialog.this.f17390k.loadUrl(AuthDialog.this.m5927b());
                    return;
                }
                AuthDialog.m5908m(AuthDialog.this);
                AuthDialog.this.f17384e.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.AuthDialog.LoginWebViewClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AuthDialog.this.f17390k.loadUrl(AuthDialog.this.f17395p);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            AuthDialog.this.f17382c.onError(new UiError(sslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
            AuthDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C4331f.m5445b(AuthDialog.f17380a, "-->Redirect URL: " + str);
            if (str.startsWith(AuthConstants.REDIRECT_BROWSER_URI)) {
                JSONObject parseUrlToJson = Util.parseUrlToJson(str);
                AuthDialog.this.f17393n = AuthDialog.this.m5916f();
                if (!AuthDialog.this.f17393n) {
                    if (parseUrlToJson.optString("fail_cb", null) != null) {
                        AuthDialog.this.callJs(parseUrlToJson.optString("fail_cb"), "");
                    } else if (parseUrlToJson.optInt("fall_to_wv") == 1) {
                        AuthDialog.m5931a(AuthDialog.this, (Object) (AuthDialog.this.f17381b.indexOf(C0228a.f351a) > -1 ? "&" : C0228a.f351a));
                        AuthDialog.m5931a(AuthDialog.this, (Object) "browser_error=1");
                        AuthDialog.this.f17390k.loadUrl(AuthDialog.this.f17381b);
                    } else {
                        String optString = parseUrlToJson.optString("redir", null);
                        if (optString != null) {
                            AuthDialog.this.f17390k.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith(ServerSetting.DEFAULT_REDIRECT_URI)) {
                AuthDialog.this.f17382c.onComplete(Util.parseUrlToJson(str));
                AuthDialog.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                AuthDialog.this.f17382c.onCancel();
                AuthDialog.this.dismiss();
                return true;
            } else if (str.startsWith("auth://close")) {
                AuthDialog.this.dismiss();
                return true;
            } else if (str.startsWith("download://")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring("download://".length()))));
                    intent.addFlags(268435456);
                    AuthDialog.this.f17391l.startActivity(intent);
                } catch (Exception e) {
                    C4331f.m5445b(AuthDialog.f17380a, "-->start download activity exception, e: " + e.getMessage());
                }
                return true;
            } else if (!str.startsWith(AuthConstants.PROGRESS_URI)) {
                if (str.startsWith(AuthConstants.ON_LOGIN_URI)) {
                    try {
                        List<String> pathSegments = Uri.parse(str).getPathSegments();
                        if (!pathSegments.isEmpty()) {
                            AuthDialog.this.f17396q = pathSegments.get(0);
                        }
                    } catch (Exception e2) {
                    }
                    return true;
                } else if (AuthDialog.this.f17392m.mo5343a(AuthDialog.this.f17390k, str)) {
                    return true;
                } else {
                    C4331f.m5442c(AuthDialog.f17380a, "-->Redirect URL: return false");
                    return false;
                }
            } else {
                try {
                    List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                    if (pathSegments2.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments2.get(0)).intValue();
                    if (intValue == 0) {
                        AuthDialog.this.f17387h.setVisibility(8);
                        AuthDialog.this.f17390k.setVisibility(0);
                    } else if (intValue == 1) {
                        AuthDialog.this.f17387h.setVisibility(0);
                    }
                    return true;
                } catch (Exception e3) {
                    return true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class OnTimeListener implements IUiListener {

        /* renamed from: a */
        String f17405a;

        /* renamed from: b */
        String f17406b;

        /* renamed from: d */
        private String f17408d;

        /* renamed from: e */
        private IUiListener f17409e;

        public OnTimeListener(String str, String str2, String str3, IUiListener iUiListener) {
            this.f17408d = str;
            this.f17405a = str2;
            this.f17406b = str3;
            this.f17409e = iUiListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m5903a(String str) {
            try {
                onComplete(Util.parseJson(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.f17409e != null) {
                this.f17409e.onCancel();
                this.f17409e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C4343g.m5402a().m5397a(this.f17408d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f17405a, false);
            if (this.f17409e != null) {
                this.f17409e.onComplete(jSONObject);
                this.f17409e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str = uiError.errorMessage != null ? uiError.errorMessage + this.f17405a : this.f17405a;
            C4343g.m5402a().m5397a(this.f17408d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            AuthDialog.this.m5928a(str);
            if (this.f17409e != null) {
                this.f17409e.onError(uiError);
                this.f17409e = null;
            }
        }
    }

    /* loaded from: classes.dex */
    private class THandler extends Handler {

        /* renamed from: b */
        private OnTimeListener f17411b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f17411b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f17411b.m5903a((String) message.obj);
                    return;
                case 2:
                    this.f17411b.onCancel();
                    return;
                case 3:
                    AuthDialog.m5926b(AuthDialog.this.f17391l, (String) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    class TimeOutRunable implements Runnable {

        /* renamed from: a */
        String f17412a;

        public TimeOutRunable(String str) {
            this.f17412a = "";
            this.f17412a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4331f.m5445b(AuthDialog.f17380a, "-->timeoutUrl: " + this.f17412a + " | mRetryUrl: " + AuthDialog.this.f17395p);
            if (this.f17412a.equals(AuthDialog.this.f17395p)) {
                AuthDialog.this.f17382c.onError(new UiError(9002, "请求页面超时，请稍后重试！", AuthDialog.this.f17395p));
                AuthDialog.this.dismiss();
            }
        }
    }

    static {
        Context context;
        try {
            if (Global.getContext() == null) {
                C4331f.m5445b(f17380a, "-->load wbsafeedit lib fail, because context is null.");
            } else if (new File(context.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                System.load(context.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
                C4331f.m5445b(f17380a, "-->load wbsafeedit lib success.");
            } else {
                C4331f.m5445b(f17380a, "-->load wbsafeedit lib fail, because so is not exists.");
            }
        } catch (Exception e) {
            C4331f.m5444b(f17380a, "-->load wbsafeedit lib error.", e);
        }
    }

    public AuthDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f17391l = context;
        this.f17381b = str2;
        this.f17382c = new OnTimeListener(str, str2, qQToken.getAppId(), iUiListener);
        this.f17384e = new THandler(this.f17382c, context.getMainLooper());
        this.f17383d = iUiListener;
        this.f17389j = str;
        getWindow().setSoftInputMode(32);
    }

    /* renamed from: a */
    static /* synthetic */ String m5931a(AuthDialog authDialog, Object obj) {
        String str = authDialog.f17381b + obj;
        authDialog.f17381b = str;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m5928a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f17396q) && this.f17396q.length() >= 4) {
            sb.append("_u_").append(this.f17396q.substring(this.f17396q.length() - 4));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m5927b() {
        String str = ServerSetting.DOWNLOAD_QQ_URL + this.f17381b.substring(this.f17381b.indexOf(C0228a.f351a) + 1);
        C4331f.m5442c(f17380a, "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m5926b(Context context, String str) {
        try {
            JSONObject parseJson = Util.parseJson(str);
            int i = parseJson.getInt("type");
            Toast.makeText(context.getApplicationContext(), parseJson.getString(SocialConstants.PARAM_SEND_MSG), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m5923c() {
        m5920d();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f17390k = new C4355c(this.f17391l);
        this.f17390k.setLayoutParams(layoutParams);
        this.f17385f = new FrameLayout(this.f17391l);
        layoutParams.gravity = 17;
        this.f17385f.setLayoutParams(layoutParams);
        this.f17385f.addView(this.f17390k);
        this.f17385f.addView(this.f17387h);
        setContentView(this.f17385f);
    }

    /* renamed from: d */
    private void m5920d() {
        this.f17388i = new ProgressBar(this.f17391l);
        this.f17388i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f17386g = new LinearLayout(this.f17391l);
        TextView textView = null;
        if (this.f17389j.equals(SystemUtils.ACTION_LOGIN)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f17391l);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f17386g.setLayoutParams(layoutParams2);
        this.f17386g.addView(this.f17388i);
        if (textView != null) {
            this.f17386g.addView(textView);
        }
        this.f17387h = new FrameLayout(this.f17391l);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = 80;
        layoutParams3.rightMargin = 80;
        layoutParams3.topMargin = 40;
        layoutParams3.bottomMargin = 40;
        layoutParams3.gravity = 17;
        this.f17387h.setLayoutParams(layoutParams3);
        this.f17387h.setBackgroundResource(17301504);
        this.f17387h.addView(this.f17386g);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: e */
    private void m5918e() {
        this.f17390k.setVerticalScrollBarEnabled(false);
        this.f17390k.setHorizontalScrollBarEnabled(false);
        this.f17390k.setWebViewClient(new LoginWebViewClient());
        this.f17390k.setWebChromeClient(new WebChromeClient());
        this.f17390k.clearFormData();
        this.f17390k.clearSslPreferences();
        this.f17390k.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.AuthDialog.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f17390k.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.AuthDialog.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (view.hasFocus()) {
                            return false;
                        }
                        view.requestFocus();
                        return false;
                    default:
                        return false;
                }
            }
        });
        WebSettings settings = this.f17390k.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f17391l.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        C4331f.m5445b(f17380a, "-->mUrl : " + this.f17381b);
        this.f17395p = this.f17381b;
        this.f17390k.loadUrl(this.f17381b);
        this.f17390k.setVisibility(4);
        this.f17390k.getSettings().setSavePassword(false);
        this.f17392m.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.AuthDialog.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m5916f() {
        AuthMap authMap = AuthMap.getInstance();
        String makeKey = authMap.makeKey();
        AuthMap.Auth auth = new AuthMap.Auth();
        auth.listener = this.f17383d;
        auth.dialog = this;
        auth.key = makeKey;
        String str = authMap.set(auth);
        String substring = this.f17381b.substring(0, this.f17381b.indexOf(C0228a.f351a));
        Bundle parseUrl = Util.parseUrl(this.f17381b);
        parseUrl.putString("token_key", makeKey);
        parseUrl.putString("serial", str);
        parseUrl.putString("browser", "1");
        this.f17381b = substring + C0228a.f351a + Util.encodeUrl(parseUrl);
        return Util.openBrowser(this.f17391l, this.f17381b);
    }

    /* renamed from: m */
    static /* synthetic */ int m5908m(AuthDialog authDialog) {
        int i = authDialog.f17394o;
        authDialog.f17394o = i + 1;
        return i;
    }

    public void callJs(String str, String str2) {
        this.f17390k.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f17399t.clear();
        this.f17384e.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        if (this.f17390k != null) {
            this.f17390k.destroy();
            this.f17390k = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f17393n) {
            this.f17382c.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        m5923c();
        m5918e();
        this.f17399t = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }
}
