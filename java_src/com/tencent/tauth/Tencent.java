package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.GameAppOperation;
import com.tencent.open.LocationApi;
import com.tencent.open.SocialApi;
import com.tencent.open.SocialConstants;
import com.tencent.open.TaskGuide;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4340d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.yyb.AppbarAgent;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Tencent {
    private static Tencent sInstance;
    private AppbarAgent mAgent;
    private LocationApi mLocationApi;
    private final QQAuth mQQAuth;

    private Tencent(String str, Context context) {
        Global.setContext(context.getApplicationContext());
        this.mQQAuth = QQAuth.createInstance(str, context);
    }

    private static boolean checkManifestConfig(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                C4331f.m5439e("AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity", "没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"portrait\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>");
                return false;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            C4331f.m5439e("AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity", ("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.open.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.util.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n     <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>");
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        Tencent tencent;
        synchronized (Tencent.class) {
            C4331f.m5448a(C4331f.f18119d, "createInstance()  -- start");
            if (sInstance == null) {
                sInstance = new Tencent(str, context);
            } else if (!str.equals(sInstance.getAppId())) {
                sInstance.logout(context);
                sInstance = new Tencent(str, context);
            }
            if (!checkManifestConfig(context, str)) {
                tencent = null;
            } else {
                C4331f.m5448a(C4331f.f18119d, "createInstance()  -- end");
                tencent = sInstance;
            }
        }
        return tencent;
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        BaseApi.handleDataToListener(intent, iUiListener);
    }

    public void addToQQFavorites(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new GameAppOperation(getQQToken()).addToQQFavorites(activity, bundle, iUiListener);
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).ask(activity, bundle, iUiListener);
        return 0;
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        new GameAppOperation(getQQToken()).bindQQGroup(activity, bundle);
    }

    public int brag(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).brag(activity, bundle, iUiListener);
        return 0;
    }

    public int challenge(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).challenge(activity, bundle, iUiListener);
        return 0;
    }

    public void checkLogin(IUiListener iUiListener) {
        this.mQQAuth.checkLogin(iUiListener);
    }

    public int deleteLocation(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (this.mLocationApi == null) {
            this.mLocationApi = new LocationApi(this.mQQAuth.getQQToken());
        }
        this.mLocationApi.deleteLocation(activity, bundle, iUiListener);
        return 0;
    }

    public String getAccessToken() {
        return this.mQQAuth.getQQToken().getAccessToken();
    }

    public String getAppId() {
        return this.mQQAuth.getQQToken().getAppId();
    }

    public long getExpiresIn() {
        return this.mQQAuth.getQQToken().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.mQQAuth.getQQToken().getOpenId();
    }

    public QQToken getQQToken() {
        return this.mQQAuth.getQQToken();
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).gift(activity, bundle, iUiListener);
        return 0;
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).grade(activity, bundle, iUiListener);
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        BaseApi.handleDataToListener(intent, iUiListener);
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).invite(activity, bundle, iUiListener);
        return 0;
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public boolean isSessionValid() {
        return this.mQQAuth.isSessionValid();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        if (SystemUtils.getAppVersionName(activity, "com.tencent.mobileqq") == null) {
            return false;
        }
        return SystemUtils.checkMobileQQ(activity);
    }

    public boolean joinQQGroup(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
        try {
            activity.startActivity(intent);
            C4340d.m5413a().m5411a(this.mQQAuth.getQQToken().getOpenId(), this.mQQAuth.getQQToken().getAppId(), Constants.VIA_JOIN_GROUP, "13", "18", "0");
            return true;
        } catch (Exception e) {
            C4340d.m5413a().m5411a(this.mQQAuth.getQQToken().getOpenId(), this.mQQAuth.getQQToken().getAppId(), Constants.VIA_JOIN_GROUP, "13", "18", "1");
            return false;
        }
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        return this.mQQAuth.login(activity, str, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        return this.mQQAuth.login(fragment, str, iUiListener, "");
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        return this.mQQAuth.loginWithOEM(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        this.mQQAuth.getQQToken().setAccessToken(null, "0");
        this.mQQAuth.getQQToken().setOpenId(null);
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        new GameAppOperation(getQQToken()).makeFriend(activity, bundle);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        return this.mQQAuth.reAuth(activity, str, iUiListener);
    }

    public int reactive(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).reactive(activity, bundle, iUiListener);
        return 0;
    }

    public void releaseResource() {
        TemporaryStorage.remove(SystemUtils.QQ_SHARE_CALLBACK_ACTION);
        TemporaryStorage.remove(SystemUtils.QZONE_SHARE_CALLBACK_ACTION);
        TemporaryStorage.remove(SystemUtils.QQDATALINE_CALLBACK_ACTION);
        TemporaryStorage.remove(SystemUtils.QQFAVORITES_CALLBACK_ACTION);
        TemporaryStorage.remove(SystemUtils.TROOPBAR_CALLBACK_ACTION);
    }

    public void reportDAU() {
        this.mQQAuth.reportDAU();
    }

    public JSONObject request(String str, Bundle bundle, String str2) {
        return HttpUtils.request(this.mQQAuth.getQQToken(), Global.getContext(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        HttpUtils.requestAsync(this.mQQAuth.getQQToken(), Global.getContext(), str, bundle, str2, iRequestListener);
    }

    public int searchNearby(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (this.mLocationApi == null) {
            this.mLocationApi = new LocationApi(this.mQQAuth.getQQToken());
        }
        this.mLocationApi.searchNearby(activity, bundle, iUiListener);
        return 0;
    }

    public void sendToMyComputer(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new GameAppOperation(getQQToken()).sendToMyComputer(activity, bundle, iUiListener);
    }

    public void setAccessToken(String str, String str2) {
        C4331f.m5448a(C4331f.f18119d, "setAccessToken(), expiresIn = " + str2 + "");
        this.mQQAuth.setAccessToken(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String string = bundle.getString(SocialConstants.PARAM_AVATAR_URI);
        new QQAvatar(this.mQQAuth.getQQToken()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i, int i2) {
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public void setOpenId(String str) {
        C4331f.m5448a(C4331f.f18119d, "setOpenId() --start");
        this.mQQAuth.setOpenId(Global.getContext(), str);
        C4331f.m5448a(C4331f.f18119d, "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new QQShare(activity, this.mQQAuth.getQQToken()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new QzoneShare(activity, this.mQQAuth.getQQToken()).shareToQzone(activity, bundle, iUiListener);
    }

    public void shareToTroopBar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new GameAppOperation(getQQToken()).shareToTroopBar(activity, bundle, iUiListener);
    }

    public void showTaskGuideWindow(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new TaskGuide(activity, this.mQQAuth.getQQToken()).showTaskGuideWindow(activity, bundle, iUiListener);
    }

    public void startAppbar(Activity activity, String str) {
        if (this.mAgent == null) {
            this.mAgent = new AppbarAgent(this.mQQAuth.getQQToken());
        }
        this.mAgent.startAppbar(activity, str);
    }

    public void startAppbarLabel(Activity activity, String str) {
        if (this.mAgent == null) {
            this.mAgent = new AppbarAgent(this.mQQAuth.getQQToken());
        }
        this.mAgent.startAppbarLabel(activity, str);
    }

    public void startAppbarThread(Activity activity, String str) {
        if (this.mAgent == null) {
            this.mAgent = new AppbarAgent(this.mQQAuth.getQQToken());
        }
        this.mAgent.startAppbarThread(activity, str);
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).story(activity, bundle, iUiListener);
        return 0;
    }

    public void voice(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new SocialApi(this.mQQAuth.getQQToken()).voice(activity, bundle, iUiListener);
    }
}
