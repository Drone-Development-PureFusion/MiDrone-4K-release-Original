package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.open.p229b.C4340d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QQAvatar extends BaseApi {

    /* renamed from: a */
    private IUiListener f17459a;

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private Intent m5861a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    /* renamed from: a */
    private void m5860a(Activity activity, Bundle bundle) {
        m5859a(bundle);
        this.mActivityIntent.putExtra(Constants.KEY_ACTION, "action_avatar");
        this.mActivityIntent.putExtra(Constants.KEY_PARAMS, bundle);
        startAssitActivity(activity, this.f17459a);
    }

    /* renamed from: a */
    private void m5859a(Bundle bundle) {
        if (this.mToken != null) {
            bundle.putString("appid", this.mToken.getAppId());
            if (this.mToken.isSessionValid()) {
                bundle.putString(Constants.PARAM_KEY_STR, this.mToken.getAccessToken());
                bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
            }
            String openId = this.mToken.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
            try {
                bundle.putString(Constants.PARAM_PLATFORM_ID, Global.getContext().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
            } catch (Exception e) {
                e.printStackTrace();
                bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            }
        }
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            this.f17459a.onCancel();
            return;
        }
        int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (intExtra != 0) {
            this.f17459a.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
        if (stringExtra == null) {
            this.f17459a.onComplete(new JSONObject());
            return;
        }
        try {
            this.f17459a.onComplete(Util.parseJson(stringExtra));
        } catch (JSONException e) {
            this.f17459a.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra));
        }
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i) {
        if (this.f17459a != null) {
            this.f17459a.onCancel();
        }
        this.f17459a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_AVATAR_URI, uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", this.mToken.getAppId());
        bundle.putString("access_token", this.mToken.getAccessToken());
        bundle.putLong("expires_in", this.mToken.getExpireTimeInSecond());
        bundle.putString("openid", this.mToken.getOpenId());
        this.mActivityIntent = m5861a(activity);
        if (!hasActivityForIntent()) {
            C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SET_AVATAR, "12", "18", "1");
            return;
        }
        m5860a(activity, bundle);
        C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SET_AVATAR, "12", "18", "0");
    }
}
