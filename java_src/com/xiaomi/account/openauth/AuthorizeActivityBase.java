package com.xiaomi.account.openauth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.XiaomiOAuthResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public abstract class AuthorizeActivityBase extends Activity {
    private static final String KEY_KEEP_COOKIES = "extra_keep_cookies ";
    private static final String KEY_MY_BUNDLE = "extra_my_bundle";
    private static final String KEY_MY_INTENT = "extra_my_intent";
    public static final String KEY_REDIRECT_URI = "redirect_uri";
    private static final String KEY_RESPONSE = "extra_response";
    private static final String KEY_RESULT_CODE = "extra_result_code";
    private static final String LOCALE_KEY_IN_URL = "_locale";
    private static final int REQUEST_CODE = 1001;
    private static final String UTF8 = "UTF-8";
    private boolean mKeepCookies = false;
    private boolean mMiddleActivityMode = false;
    private XiaomiOAuthResponse mResponse;
    private WebSettings mSettings;
    private String mUrl;
    private WebView mWebView;
    public static int RESULT_SUCCESS = -1;
    public static int RESULT_FAIL = 1;
    public static int RESULT_CANCEL = 0;
    private static final String AUTHORIZE_PATH = AuthorizeHelper.OAUTH2_HOST + "/oauth2/authorize";

    /* loaded from: classes.dex */
    class AuthorizeWebViewClient extends WebViewClient {
        private final String mRedirectUrlOf3rdPartyApp;

        AuthorizeWebViewClient(String str) {
            this.mRedirectUrlOf3rdPartyApp = str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AuthorizeActivityBase.this.onHideProgress();
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthorizeActivityBase.this.onShowProgress();
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            AuthorizeActivityBase.this.onShowErrorUI();
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AuthorizeActivityBase.this.onShowErrorUI();
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.mRedirectUrlOf3rdPartyApp == null || str.toLowerCase().startsWith(this.mRedirectUrlOf3rdPartyApp.toLowerCase())) {
                String str2 = new String(str);
                int indexOf = str2.indexOf(63);
                if (indexOf > 0) {
                    String substring = str2.substring(indexOf + 1);
                    if (substring.startsWith("code=") || substring.contains("&code=")) {
                        AuthorizeActivityBase.this.setResultAndFinish(AuthorizeActivityBase.RESULT_SUCCESS, str2);
                        return true;
                    } else if (substring.startsWith("error=") || substring.contains("&error=")) {
                        AuthorizeActivityBase.this.setResultAndFinish(AuthorizeActivityBase.RESULT_FAIL, str2);
                        return true;
                    }
                } else {
                    int indexOf2 = str2.indexOf(35);
                    if (indexOf2 > 0) {
                        String substring2 = str2.substring(indexOf2 + 1);
                        if (substring2.startsWith("access_token=") || substring2.contains("&access_token=")) {
                            AuthorizeActivityBase.this.setResultAndFinish(AuthorizeActivityBase.RESULT_SUCCESS, str2.replace("#", C0228a.f351a));
                            return true;
                        } else if (substring2.startsWith("error=") || substring2.contains("&error=")) {
                            AuthorizeActivityBase.this.setResultAndFinish(AuthorizeActivityBase.RESULT_FAIL, str2.replace("#", C0228a.f351a));
                            return true;
                        }
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private Bundle addLocaleIfNeeded(Bundle bundle) {
        if (bundle != null && !bundle.containsKey(LOCALE_KEY_IN_URL)) {
            String localeString = getLocaleString(Locale.getDefault());
            if (!TextUtils.isEmpty(localeString)) {
                bundle.putString(LOCALE_KEY_IN_URL, localeString);
            }
        }
        return bundle;
    }

    private void appendPassportUserAgent() {
        String userAgentString = this.mSettings.getUserAgentString();
        if (!TextUtils.isEmpty(userAgentString)) {
            this.mSettings.setUserAgentString(String.format("%s Passport/OAuthSDK/%d.%d", userAgentString, 1, 4));
        }
    }

    public static Intent asMiddleActivity(Activity activity, int i, Bundle bundle, Class<? extends AuthorizeActivityBase> cls) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(KEY_MY_BUNDLE, bundle);
        intent.putExtra(KEY_RESULT_CODE, i);
        return intent;
    }

    public static Intent asMiddleActivity(Activity activity, Intent intent, IXiaomiAuthResponse iXiaomiAuthResponse, Class<? extends AuthorizeActivityBase> cls) {
        Intent intent2 = new Intent(activity, cls);
        intent2.putExtra(KEY_MY_INTENT, intent);
        intent2.putExtra("extra_response", new XiaomiOAuthResponse(iXiaomiAuthResponse));
        return intent2;
    }

    public static Intent getIntent(Activity activity, String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z, IXiaomiAuthResponse iXiaomiAuthResponse, Class<? extends AuthorizeActivityBase> cls) {
        Intent intent = new Intent(activity, cls);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PARAM_CLIENT_ID, String.valueOf(str));
        bundle.putString(KEY_REDIRECT_URI, str2);
        bundle.putString("response_type", str3);
        bundle.putString("scope", str4);
        bundle.putString(XiaomiOAuthConstants.EXTRA_STATE_2, str5);
        if (bool != null) {
            bundle.putString("skip_confirm", String.valueOf(bool));
        }
        intent.putExtra("url_param", bundle);
        intent.putExtra(KEY_KEEP_COOKIES, z);
        intent.putExtra("extra_response", new XiaomiOAuthResponse(iXiaomiAuthResponse));
        return intent;
    }

    private static String getLocaleString(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return !TextUtils.isEmpty(country) ? String.format("%s_%s", language, country) : language;
    }

    private String parseBundle(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            String string = bundle.getString(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string)) {
                arrayList.add(new BasicNameValuePair(str, string));
            }
        }
        return URLEncodedUtils.format(arrayList, "UTF-8");
    }

    private Bundle parseUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                        bundle.putString(nameValuePair.getName(), nameValuePair.getValue());
                    }
                }
            } catch (URISyntaxException e) {
                Log.e("openauth", e.getMessage());
            }
        }
        return bundle;
    }

    private void removeCookiesIfNeeded() {
        if (!this.mKeepCookies) {
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebView getWebView() {
        return this.mWebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isMiddleActivityMode() {
        return this.mMiddleActivityMode;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            setResultAndFinish(i2, intent != null ? intent.getExtras() : null);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            setResultAndFinish(RESULT_CANCEL, (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        Intent intent = getIntent();
        Bundle bundleExtra = intent.getBundleExtra(KEY_MY_BUNDLE);
        if (bundleExtra != null) {
            setResultAndFinish(intent.getIntExtra(KEY_RESULT_CODE, -1), bundleExtra);
            return;
        }
        this.mResponse = (XiaomiOAuthResponse) intent.getParcelableExtra("extra_response");
        Intent intent2 = (Intent) intent.getParcelableExtra(KEY_MY_INTENT);
        if (intent2 != null) {
            startActivityForResult(intent2, 1001);
            this.mMiddleActivityMode = true;
            return;
        }
        this.mKeepCookies = intent.getBooleanExtra(KEY_KEEP_COOKIES, false);
        this.mWebView = new WebView(this);
        this.mSettings = this.mWebView.getSettings();
        this.mSettings.setJavaScriptEnabled(true);
        this.mSettings.setSavePassword(false);
        this.mSettings.setSaveFormData(false);
        Bundle addLocaleIfNeeded = addLocaleIfNeeded(intent.getBundleExtra("url_param"));
        this.mUrl = AUTHORIZE_PATH + C0228a.f351a + parseBundle(addLocaleIfNeeded);
        removeCookiesIfNeeded();
        appendPassportUserAgent();
        refreshWebView(false);
        this.mWebView.setWebViewClient(new AuthorizeWebViewClient(addLocaleIfNeeded.getString(KEY_REDIRECT_URI)));
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.xiaomi.account.openauth.AuthorizeActivityBase.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                AuthorizeActivityBase.this.onUpdateProgress(i);
            }
        });
    }

    protected abstract void onHideErrorUI();

    protected abstract void onHideProgress();

    protected abstract void onShowErrorUI();

    protected abstract void onShowProgress();

    protected abstract void onUpdateProgress(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void refreshWebView() {
        refreshWebView(true);
    }

    protected final void refreshWebView(boolean z) {
        this.mWebView.loadUrl(this.mUrl);
        if (z) {
            onHideErrorUI();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.xiaomi.account.openauth.AuthorizeActivityBase.2
                @Override // java.lang.Runnable
                public void run() {
                    AuthorizeActivityBase.this.onHideErrorUI();
                }
            });
        }
    }

    void setResultAndFinish(int i, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(i, intent);
        if (this.mResponse != null) {
            if (i == 0) {
                this.mResponse.onCancel();
            } else {
                this.mResponse.onResult(bundle);
            }
        }
        removeCookiesIfNeeded();
        finish();
    }

    void setResultAndFinish(int i, String str) {
        setResultAndFinish(i, parseUrl(str));
    }
}
