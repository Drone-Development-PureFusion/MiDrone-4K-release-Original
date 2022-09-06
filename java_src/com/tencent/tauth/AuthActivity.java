package com.tencent.tauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.auth.AuthMap;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AuthActivity extends Activity {
    private static final String ACTION_ADD_TO_QQFAVORITES = "addToQQFavorites";
    public static final String ACTION_KEY = "action";
    private static final String ACTION_SEND_TO_MY_COMPUTER = "sendToMyComputer";
    public static final String ACTION_SHARE_PRIZE = "sharePrize";
    private static final String ACTION_SHARE_TO_QQ = "shareToQQ";
    private static final String ACTION_SHARE_TO_QZONE = "shareToQzone";
    private static final String ACTION_SHARE_TO_TROOP_BAR = "shareToTroopBar";
    private static final String SHARE_PRIZE_ACTIVITY_ID = "activityid";
    private static final String TAG = C4331f.f18119d + ".AuthActivity";
    private static int mShareQzoneBackTime = 0;

    private void execAuthCallback(Bundle bundle, String str) {
        AuthMap authMap = AuthMap.getInstance();
        String string = bundle.getString("serial");
        AuthMap.Auth auth = authMap.get(string);
        if (auth != null) {
            if (str.indexOf("://cancel") != -1) {
                auth.listener.onCancel();
                auth.dialog.dismiss();
            } else {
                String string2 = bundle.getString("access_token");
                if (string2 != null) {
                    bundle.putString("access_token", authMap.decode(string2, auth.key));
                }
                JSONObject decodeUrlToJson = Util.decodeUrlToJson(new JSONObject(), Util.encodeUrl(bundle));
                String optString = decodeUrlToJson.optString("cb");
                if (!"".equals(optString)) {
                    auth.dialog.callJs(optString, decodeUrlToJson.toString());
                } else {
                    auth.listener.onComplete(decodeUrlToJson);
                    auth.dialog.dismiss();
                }
            }
            authMap.remove(string);
        }
        finish();
    }

    private void handleActionUri(Uri uri) {
        if (uri == null || uri.toString().equals("")) {
            finish();
            return;
        }
        String uri2 = uri.toString();
        Bundle decodeUrl = Util.decodeUrl(uri2.substring(uri2.indexOf("#") + 1));
        String string = decodeUrl.getString(ACTION_KEY);
        C4331f.m5445b(TAG, "-->handleActionUri, action: " + string);
        if (string == null) {
            execAuthCallback(decodeUrl, uri2);
        } else if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
            if (string.equals("shareToQzone") && SystemUtils.getAppVersionName(this, "com.tencent.mobileqq") != null && SystemUtils.compareQQVersion(this, SystemUtils.QQ_VERSION_NAME_5_2_0) < 0) {
                mShareQzoneBackTime++;
                if (mShareQzoneBackTime == 2) {
                    mShareQzoneBackTime = 0;
                    finish();
                    return;
                }
            }
            Intent intent = new Intent(this, AssistActivity.class);
            intent.putExtras(decodeUrl);
            intent.setFlags(603979776);
            startActivity(intent);
            finish();
        } else if (string.equals("addToQQFavorites")) {
            Intent intent2 = getIntent();
            intent2.putExtras(decodeUrl);
            intent2.putExtra(Constants.KEY_ACTION, SystemUtils.ACTION_SHARE);
            Object obj = TemporaryStorage.get(string);
            if (obj != null) {
                BaseApi.handleDataToListener(intent2, (IUiListener) obj);
            }
            finish();
        } else if (!string.equals(ACTION_SHARE_PRIZE)) {
            execAuthCallback(decodeUrl, uri2);
        } else {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            String str = "";
            try {
                str = Util.parseJson(decodeUrl.getString("response")).getString("activityid");
            } catch (Exception e) {
                C4331f.m5439e(TAG, "sharePrize parseJson has exception.");
            }
            if (!TextUtils.isEmpty(str)) {
                launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                Bundle bundle = new Bundle();
                bundle.putString("activityid", str);
                launchIntentForPackage.putExtras(bundle);
            }
            startActivity(launchIntentForPackage);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        C4331f.m5445b(TAG, "-->onCreate, uri: " + data);
        handleActionUri(data);
    }
}
