package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4340d;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AssistActivity extends Activity {
    private static final String RESTART_FLAG = "RESTART_FLAG";
    private static final String TAG = "AssistActivity";
    private static BaseApi sApiObject;
    private BaseApi mAPiObject;
    public static boolean isQQMobileShare = false;
    public static boolean hackShareSend = false;

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    private void openBrowser(Bundle bundle) {
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString("appId");
        String str = "";
        String str2 = "";
        if (SystemUtils.QQ_SHARE_CALLBACK_ACTION.equals(string2)) {
            str = Constants.VIA_SHARE_TO_QQ;
            str2 = "10";
        } else if (SystemUtils.QZONE_SHARE_CALLBACK_ACTION.equals(string2)) {
            str = Constants.VIA_SHARE_TO_QZONE;
            str2 = "11";
        }
        if (!Util.openBrowser(this, string3)) {
            IUiListener iUiListener = (IUiListener) TemporaryStorage.get(string2);
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_OPEN_BROWSER_ERROR, null));
            }
            C4340d.m5413a().m5409a(string4, string5, str, str2, "3", "1", string, "0", "2", "0");
            finish();
        } else {
            C4340d.m5413a().m5409a(string4, string5, str, str2, "3", "0", string, "0", "2", "0");
        }
        getIntent().removeExtra("shareH5");
    }

    public static void setApiObject(BaseApi baseApi) {
        sApiObject = baseApi;
    }

    public static void setResultDataForLogin(Activity activity, Intent intent) {
        if (intent == null) {
            activity.setResult(Constants.RESULT_LOGIN, intent);
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
            C4331f.m5445b(TAG, "AssistActivity--setResultDataForLogin-- " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    activity.setResult(12345, intent);
                } else {
                    activity.setResult(Constants.RESULT_LOGIN, intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        C4331f.m5445b(TAG, "AssistActivity--onActivityResult--" + i2 + " data=" + intent);
        C4331f.m5445b(TAG, "--requestCode: " + i + " | resultCode: " + i2 + " | data: " + intent);
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intent != null) {
            intent.putExtra(Constants.KEY_ACTION, SystemUtils.ACTION_LOGIN);
        }
        if (this.mAPiObject != null) {
            C4331f.m5445b(TAG, "AssistActivity--onActivityResult-- mAPiObject != null");
            this.mAPiObject.onActivityResult(this, i, i2, intent);
        } else {
            C4331f.m5445b(TAG, "AssistActivity--onActivityResult-- mAPiObject == null");
            setResultDataForLogin(this, intent);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        requestWindowFeature(1);
        C4331f.m5445b(TAG, "AssistActivity--onCreate--");
        if (sApiObject == null) {
            return;
        }
        this.mAPiObject = sApiObject;
        sApiObject = null;
        Intent activityIntent = this.mAPiObject.getActivityIntent();
        int intExtra = activityIntent == null ? 0 : activityIntent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
        Bundle bundleExtra = getIntent().getBundleExtra(SystemUtils.H5_SHARE_DATA);
        if (bundle != null) {
            z = bundle.getBoolean(RESTART_FLAG);
        }
        if (z) {
            return;
        }
        if (bundleExtra == null) {
            startActivityForResult(activityIntent, intExtra);
        } else {
            openBrowser(bundleExtra);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C4331f.m5445b(TAG, "-->onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Object obj = TemporaryStorage.get(intent.getStringExtra(AuthActivity.ACTION_KEY));
        C4331f.m5445b(TAG, "AssistActivity--onNewIntent--" + (obj == null ? "mAPiObject = null" : "mAPiObject != null"));
        intent.putExtra(Constants.KEY_ACTION, SystemUtils.ACTION_SHARE);
        if (obj != null) {
            BaseApi.handleDataToListener(intent, (IUiListener) obj);
        } else {
            setResult(-1, intent);
        }
        if (!isFinishing()) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        C4331f.m5445b(TAG, "-->onPause");
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        C4331f.m5445b(TAG, "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra(SystemUtils.IS_LOGIN, false) && !intent.getBooleanExtra(SystemUtils.IS_QQ_MOBILE_SHARE, false)) {
            if (!hackShareSend && !isFinishing()) {
                finish();
            }
            hackShareSend = false;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C4331f.m5445b(TAG, "AssistActivity--onSaveInstanceState--");
        bundle.putBoolean(RESTART_FLAG, true);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        C4331f.m5445b(TAG, "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        C4331f.m5445b(TAG, "-->onStop");
        super.onStop();
    }
}
