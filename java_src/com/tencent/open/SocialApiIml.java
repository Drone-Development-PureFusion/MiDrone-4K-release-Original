package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.AsyncTaskC4357e;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p230c.C4354b;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: a */
    private static final String f17950a = SocialApiIml.class.getName();

    /* renamed from: b */
    private Activity f17951b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.tencent.open.SocialApiIml$a */
    /* loaded from: classes2.dex */
    public class C4294a implements IUiListener {

        /* renamed from: a */
        C4295b f17956a;

        public C4294a(C4295b c4295b) {
            this.f17956a = c4295b;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            SocialApiIml.this.m5573b();
            AsyncTaskC4357e.m5379a(this.f17956a.f17960c.getString(SocialConstants.PARAM_IMG_DATA));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            boolean z = false;
            if (obj != null) {
                try {
                    z = ((JSONObject) obj).getBoolean("check_result");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            SocialApiIml.this.m5573b();
            if (z) {
                SocialApiIml.this.m5586a(SocialApiIml.this.f17951b, this.f17956a.f17958a, this.f17956a.f17959b, this.f17956a.f17960c, this.f17956a.f17962e);
                return;
            }
            AsyncTaskC4357e.m5379a(this.f17956a.f17960c.getString(SocialConstants.PARAM_IMG_DATA));
            SocialApiIml.this.m5582a(SocialApiIml.this.f17951b, this.f17956a.f17959b, this.f17956a.f17960c, this.f17956a.f17961d, this.f17956a.f17962e);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SocialApiIml.this.m5573b();
            AsyncTaskC4357e.m5379a(this.f17956a.f17960c.getString(SocialConstants.PARAM_IMG_DATA));
            SocialApiIml.this.m5582a(SocialApiIml.this.f17951b, this.f17956a.f17959b, this.f17956a.f17960c, this.f17956a.f17961d, this.f17956a.f17962e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.SocialApiIml$b */
    /* loaded from: classes2.dex */
    public static class C4295b {

        /* renamed from: a */
        Intent f17958a;

        /* renamed from: b */
        String f17959b;

        /* renamed from: c */
        Bundle f17960c;

        /* renamed from: d */
        String f17961d;

        /* renamed from: e */
        IUiListener f17962e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.SocialApiIml$c */
    /* loaded from: classes2.dex */
    public class C4296c implements IUiListener {

        /* renamed from: b */
        private IUiListener f17964b;

        /* renamed from: c */
        private String f17965c;

        /* renamed from: d */
        private String f17966d;

        /* renamed from: e */
        private Bundle f17967e;

        /* renamed from: f */
        private Activity f17968f;

        C4296c(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f17964b = iUiListener;
            this.f17965c = str;
            this.f17966d = str2;
            this.f17967e = bundle;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f17964b.onCancel();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e) {
                e.printStackTrace();
                C4331f.m5444b(C4331f.f18119d, "OpenApi, EncrytokenListener() onComplete error", e);
                str = null;
            }
            this.f17967e.putString("encrytoken", str);
            SocialApiIml.this.m5580a((Context) SocialApiIml.this.f17951b, this.f17965c, this.f17967e, this.f17966d, this.f17964b);
            if (TextUtils.isEmpty(str)) {
                C4331f.m5445b("miles", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f17968f);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            C4331f.m5445b(C4331f.f18119d, "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f17964b.onError(uiError);
        }
    }

    public SocialApiIml(QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private C4295b m5579a(Bundle bundle, String str, String str2, IUiListener iUiListener) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.AgentActivity");
        C4295b c4295b = new C4295b();
        c4295b.f17958a = intent;
        c4295b.f17960c = bundle;
        c4295b.f17961d = str2;
        c4295b.f17962e = iUiListener;
        c4295b.f17959b = str;
        return c4295b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5586a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        C4331f.m5445b(C4331f.f18119d, "-->handleIntentWithAgent " + str + " params=" + bundle + " activityIntent=" + intent);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        this.mActivityIntent = intent;
        startAssitActivity(activity, iUiListener);
    }

    /* renamed from: a */
    private void m5585a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        C4331f.m5445b(C4331f.f18119d, "-->handleIntent " + str + " params=" + bundle + " activityIntent=" + intent);
        if (intent != null) {
            m5586a(activity, intent, str, bundle, iUiListener);
            return;
        }
        if (z || OpenConfig.getInstance(Global.getContext(), this.mToken.getAppId()).getBoolean("C_LoginH5")) {
            m5582a(activity, str, bundle, str2, iUiListener);
        } else {
            handleDownloadLastestQQ(activity, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5584a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_VOICE);
        String envUrl = ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_VOICE);
        if (agentIntentWithTarget != null || !m5587a()) {
            m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_VOICE, bundle, envUrl, iUiListener, true);
            return;
        }
        if (this.mProgressDialog == null || !this.mProgressDialog.isShowing()) {
            this.mProgressDialog = new ProgressDialog(activity);
            this.mProgressDialog.setTitle("请稍候");
            this.mProgressDialog.show();
        }
        m5581a(activity, SocialConstants.ACTION_VOICE, new C4294a(m5579a(bundle, SocialConstants.ACTION_VOICE, envUrl, iUiListener)));
    }

    /* renamed from: a */
    private void m5583a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (agentIntentWithTarget == null) {
            agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        bundle.putAll(composeActivityParams());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        m5585a(activity, agentIntentWithTarget, str, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5582a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        C4331f.m5445b(C4331f.f18119d, "-->handleIntentWithH5 " + str + " params=" + bundle);
        Intent targetActivityIntent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
        IUiListener c4296c = new C4296c(activity, iUiListener, str, str2, bundle);
        Intent targetActivityIntent2 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
        if (targetActivityIntent2 == null || targetActivityIntent == null || targetActivityIntent.getComponent() == null || targetActivityIntent2.getComponent() == null || !targetActivityIntent.getComponent().getPackageName().equals(targetActivityIntent2.getComponent().getPackageName())) {
            String encrypt = Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, encrypt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c4296c.onComplete(jSONObject);
            return;
        }
        targetActivityIntent2.putExtra("oauth_consumer_key", this.mToken.getAppId());
        targetActivityIntent2.putExtra("openid", this.mToken.getOpenId());
        targetActivityIntent2.putExtra("access_token", this.mToken.getAccessToken());
        targetActivityIntent2.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
        this.mActivityIntent = targetActivityIntent2;
        if (!hasActivityForIntent()) {
            return;
        }
        startAssitActivity(activity, c4296c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5580a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        C4331f.m5448a(C4331f.f18119d, "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.mToken.getAppId());
        if (this.mToken.isSessionValid()) {
            bundle.putString("access_token", this.mToken.getAccessToken());
        }
        String openId = this.mToken.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString(Constants.PARAM_PLATFORM_ID, Global.getContext().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        } catch (Exception e) {
            e.printStackTrace();
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        String str3 = str2 + Util.encodeUrl(bundle);
        C4331f.m5445b(C4331f.f18119d, "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f17951b, str, str3, iUiListener, this.mToken).show();
            return;
        }
        C4331f.m5445b(C4331f.f18119d, "OpenUi, showDialog PKDialog");
        new PKDialog(this.f17951b, str, str3, iUiListener, this.mToken).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5573b() {
        if (this.f17951b.isFinishing() || this.mProgressDialog == null || !this.mProgressDialog.isShowing()) {
            return;
        }
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
    }

    /* renamed from: a */
    protected void m5581a(Activity activity, String str, IUiListener iUiListener) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.AgentActivity");
        intent.putExtra(Constants.KEY_ACTION, "action_check");
        Bundle bundle = new Bundle();
        bundle.putString("apiName", str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        this.mActivityIntent = intent;
        startAssitActivity(activity, iUiListener);
    }

    /* renamed from: a */
    protected boolean m5587a() {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, SocialConstants.ACTIVITY_CHECK_FUNCTION);
        return SystemUtils.isActivityExist(Global.getContext(), intent);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        m5583a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    public void brag(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_BRAG);
        bundle.putAll(composeActivityParams());
        m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_BRAG, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_BRAG), iUiListener, false);
    }

    public void challenge(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_CHALLENGE);
        bundle.putAll(composeActivityParams());
        m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_CHALLENGE, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_BRAG), iUiListener, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.connect.common.BaseApi
    public Intent getTargetActivityIntent(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        if (!SystemUtils.isActivityExist(Global.getContext(), intent2) || SystemUtils.compareQQVersion(Global.getContext(), "4.7") < 0) {
            if (!SystemUtils.isActivityExist(Global.getContext(), intent) || SystemUtils.compareVersion(SystemUtils.getAppVersionName(Global.getContext(), Constants.PACKAGE_QZONE), "4.2") < 0) {
                return null;
            }
            if (SystemUtils.isAppSignatureValid(Global.getContext(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
                return intent;
            }
            return null;
        }
        return intent2;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        m5583a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        bundle.putAll(composeActivityParams());
        bundle.putString(GameAppOperation.QQFAV_DATALINE_VERSION, Util.getAppVersion(activity));
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_GRADE);
        if (agentIntentWithTarget != null || !m5587a()) {
            m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_GRADE, bundle, "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", iUiListener, true);
            return;
        }
        this.mProgressDialog = new ProgressDialog(activity);
        this.mProgressDialog.setMessage("请稍候...");
        this.mProgressDialog.show();
        m5581a(activity, SocialConstants.ACTION_GRADE, new C4294a(m5579a(bundle, SocialConstants.ACTION_GRADE, "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", iUiListener)));
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (agentIntentWithTarget == null) {
            agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(composeActivityParams());
        m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_INVITE, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_INVITE), iUiListener, false);
    }

    public void reactive(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (agentIntentWithTarget == null) {
            agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_REACTIVE);
        }
        bundle.putAll(composeActivityParams());
        String envUrl = ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_REACTIVE);
        if (agentIntentWithTarget != null || !m5587a()) {
            bundle.putString(SocialConstants.PARAM_SEND_IMG, bundle.getString(SocialConstants.PARAM_IMG_URL));
            bundle.putString("type", SocialConstants.TYPE_REACTIVE);
            bundle.remove(SocialConstants.PARAM_IMG_URL);
            m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_REACTIVE, bundle, envUrl, iUiListener, false);
            return;
        }
        this.mProgressDialog = new ProgressDialog(activity);
        this.mProgressDialog.setMessage("请稍候...");
        this.mProgressDialog.show();
        bundle.putString("type", SocialConstants.TYPE_REACTIVE);
        m5581a(activity, SocialConstants.ACTION_REACTIVE, new C4294a(m5579a(bundle, SocialConstants.ACTION_REACTIVE, envUrl, iUiListener)));
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f17951b = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(composeActivityParams());
        m5585a(activity, agentIntentWithTarget, SocialConstants.ACTION_STORY, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_SEND_STORY), iUiListener, false);
    }

    public void voice(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        Bitmap bitmap;
        this.f17951b = activity;
        bundle.putAll(composeActivityParams());
        bundle.putString(GameAppOperation.QQFAV_DATALINE_VERSION, Util.getAppVersion(activity));
        if (!AsyncTaskC4357e.m5383a()) {
            iUiListener.onError(new UiError(-12, Constants.MSG_NO_SDCARD, Constants.MSG_NO_SDCARD));
        } else if (!bundle.containsKey(SocialConstants.PARAM_IMG_DATA) || (bitmap = (Bitmap) bundle.getParcelable(SocialConstants.PARAM_IMG_DATA)) == null) {
            m5584a(activity, bundle, iUiListener);
        } else {
            this.mProgressDialog = new ProgressDialog(activity);
            this.mProgressDialog.setMessage("请稍候...");
            this.mProgressDialog.show();
            new AsyncTaskC4357e(new AsyncTaskC4357e.AbstractC4358a() { // from class: com.tencent.open.SocialApiIml.1
                @Override // com.tencent.open.AsyncTaskC4357e.AbstractC4358a
                /* renamed from: a */
                public void mo5374a(String str) {
                    bundle.remove(SocialConstants.PARAM_IMG_DATA);
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString(SocialConstants.PARAM_IMG_DATA, str);
                    }
                    SocialApiIml.this.m5584a(activity, bundle, iUiListener);
                }

                @Override // com.tencent.open.AsyncTaskC4357e.AbstractC4358a
                /* renamed from: b */
                public void mo5373b(String str) {
                    bundle.remove(SocialConstants.PARAM_IMG_DATA);
                    iUiListener.onError(new UiError(-5, Constants.MSG_IMAGE_ERROR, Constants.MSG_IMAGE_ERROR));
                    SocialApiIml.this.m5573b();
                }
            }).execute(bitmap);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String accessToken = this.mToken.getAccessToken();
        String appId = this.mToken.getAppId();
        String openId = this.mToken.getOpenId();
        String encrypt = (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) ? null : Util.encrypt("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        C4354b c4354b = new C4354b(context);
        WebSettings settings = c4354b.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        String str = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.mToken.getOpenId() + "_" + this.mToken.getAppId() + "\"]=\"" + encrypt + "\";</script></head><body></body></html>";
        String envUrl = ServerSetting.getInstance().getEnvUrl(context, ServerSetting.DEFAULT_LOCAL_STORAGE_URI);
        c4354b.loadDataWithBaseURL(envUrl, str, "text/html", "utf-8", envUrl);
    }
}
