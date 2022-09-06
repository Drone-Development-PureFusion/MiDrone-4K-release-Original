package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.p223a.C4188a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.ApkExternalInfoTool;
import com.tencent.open.utils.Global;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
/* loaded from: classes.dex */
public class QQAuth {

    /* renamed from: a */
    private AuthAgent f17416a;

    /* renamed from: b */
    private QQToken f17417b;

    private QQAuth(String str, Context context) {
        C4331f.m5442c(C4331f.f18119d, "new QQAuth() --start");
        this.f17417b = new QQToken(str);
        this.f17416a = new AuthAgent(this.f17417b);
        C4188a.m5954c(context, this.f17417b);
        C4331f.m5442c(C4331f.f18119d, "new QQAuth() --end");
    }

    /* renamed from: a */
    private int m5901a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        String str3;
        String packageName = activity.getApplicationContext().getPackageName();
        Iterator<ApplicationInfo> it2 = activity.getPackageManager().getInstalledApplications(128).iterator();
        while (true) {
            if (!it2.hasNext()) {
                str3 = null;
                break;
            }
            ApplicationInfo next = it2.next();
            if (packageName.equals(next.packageName)) {
                str3 = next.sourceDir;
                break;
            }
        }
        if (str3 != null) {
            try {
                String readChannelId = ApkExternalInfoTool.readChannelId(new File(str3));
                if (!TextUtils.isEmpty(readChannelId)) {
                    C4331f.m5445b(C4331f.f18119d, "-->login channelId: " + readChannelId);
                    return loginWithOEM(activity, str, iUiListener, readChannelId, readChannelId, "");
                }
            } catch (IOException e) {
                C4331f.m5445b(C4331f.f18119d, "-->login get channel id exception." + e.getMessage());
                e.printStackTrace();
            }
        }
        C4331f.m5445b(C4331f.f18119d, "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f17416a.doLogin(activity, str, iUiListener, false, fragment);
    }

    public static QQAuth createInstance(String str, Context context) {
        Global.setContext(context.getApplicationContext());
        C4331f.m5442c(C4331f.f18119d, "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            QQAuth qQAuth = new QQAuth(str, context);
            C4331f.m5442c(C4331f.f18119d, "QQAuth -- createInstance()  --end");
            return qQAuth;
        } catch (PackageManager.NameNotFoundException e) {
            C4331f.m5444b(C4331f.f18119d, "createInstance() error --end", e);
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }

    public void checkLogin(IUiListener iUiListener) {
        this.f17416a.m5946b(iUiListener);
    }

    public QQToken getQQToken() {
        return this.f17417b;
    }

    public boolean isSessionValid() {
        C4331f.m5448a(C4331f.f18119d, "isSessionValid(), result = " + (this.f17417b.isSessionValid() ? "true" : "false") + "");
        return this.f17417b.isSessionValid();
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        C4331f.m5442c(C4331f.f18119d, "login()");
        return login(activity, str, iUiListener, "");
    }

    public int login(Activity activity, String str, IUiListener iUiListener, String str2) {
        C4331f.m5442c(C4331f.f18119d, "-->login activity: " + activity);
        return m5901a(activity, null, str, iUiListener, str2);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        C4331f.m5442c(C4331f.f18119d, "-->login activity: " + activity);
        return m5901a(activity, fragment, str, iUiListener, str2);
    }

    @Deprecated
    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        C4331f.m5442c(C4331f.f18119d, "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = "null";
        }
        if (str3.equals("")) {
            str3 = "null";
        }
        if (str4.equals("")) {
            str4 = "null";
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f17416a.doLogin(activity, str, iUiListener);
    }

    public void logout(Context context) {
        C4331f.m5442c(C4331f.f18119d, "logout() --start");
        CookieSyncManager.createInstance(context);
        setAccessToken(null, null);
        setOpenId(context, null);
        C4331f.m5442c(C4331f.f18119d, "logout() --end");
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        C4331f.m5442c(C4331f.f18119d, "onActivityResult() ,resultCode = " + i2 + "");
        return true;
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        C4331f.m5442c(C4331f.f18119d, "reAuth()");
        return this.f17416a.doLogin(activity, str, iUiListener, true, null);
    }

    public void reportDAU() {
        this.f17416a.m5950a((IUiListener) null);
    }

    public void setAccessToken(String str, String str2) {
        C4331f.m5448a(C4331f.f18119d, "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f17417b.setAccessToken(str, str2);
    }

    public void setOpenId(Context context, String str) {
        C4331f.m5448a(C4331f.f18119d, "setOpenId() --start");
        this.f17417b.setOpenId(str);
        C4188a.m5953d(context, this.f17417b);
        C4331f.m5448a(C4331f.f18119d, "setOpenId() --end");
    }
}
