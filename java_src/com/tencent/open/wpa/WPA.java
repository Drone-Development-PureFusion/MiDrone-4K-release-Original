package com.tencent.open.wpa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.p229b.C4340d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public class WPA extends BaseApi {
    public WPA(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public WPA(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getWPAUserOnlineState(String str, IUiListener iUiListener) {
        try {
            if (str == null) {
                C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, Constants.VIA_REPORT_TYPE_WPA_STATE, "18", "1");
                throw new Exception("uin null");
            } else if (str.length() < 5) {
                C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, Constants.VIA_REPORT_TYPE_WPA_STATE, "18", "1");
                throw new Exception("uin length < 5");
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (!Character.isDigit(str.charAt(i))) {
                        C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, Constants.VIA_REPORT_TYPE_WPA_STATE, "18", "1");
                        throw new Exception("uin not digit");
                    }
                }
                HttpUtils.requestAsync(this.mToken, Global.getContext(), "http://webpresence.qq.com/getonline?Type=1&" + str + ":", null, "GET", new BaseApi.TempRequestListener(iUiListener));
                C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, Constants.VIA_REPORT_TYPE_WPA_STATE, "18", "0");
            }
        } catch (Exception e) {
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, null));
            }
            C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, Constants.VIA_REPORT_TYPE_WPA_STATE, "18", "1");
        }
    }

    public int startWPAConversation(Activity activity, String str, String str2) {
        int i;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (TextUtils.isEmpty(str)) {
            C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP, "18", "1");
            return -1;
        } else if (str.length() < 5) {
            C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP, "18", "1");
            return -3;
        } else {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!Character.isDigit(str.charAt(i2))) {
                    C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP, "18", "1");
                    return -4;
                }
            }
            String str3 = "";
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str3 = Base64.encodeToString(str2.getBytes("UTF-8"), 2);
                } catch (UnsupportedEncodingException e) {
                }
            }
            intent.setData(Uri.parse(String.format("mqqwpa://im/chat?chat_type=wpa&uin=%1$s&version=1&src_type=app&attach_content=%2$s", str, str3)));
            PackageManager packageManager = Global.getContext().getPackageManager();
            if (packageManager.queryIntentActivities(intent, 65536).size() > 0) {
                activity.startActivity(intent);
                i = 0;
            } else {
                intent.setData(Uri.parse("http://www.myapp.com/forward/a/45592?g_f=990935"));
                if (packageManager.queryIntentActivities(intent, 65536).size() > 0) {
                    activity.startActivity(intent);
                    i = 0;
                } else {
                    C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP, "18", "1");
                    i = -2;
                }
            }
            C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP, "18", "0");
            return i;
        }
    }
}
