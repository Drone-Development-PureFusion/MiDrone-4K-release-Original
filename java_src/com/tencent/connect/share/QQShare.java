package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.p223a.C4188a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4340d;
import com.tencent.open.utils.AsynLoadImg;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 60;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 45;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_APP = 6;
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;

    /* renamed from: a */
    private static final String f17491a = C4331f.f18119d + ".QQShare";
    public String mViaShareQQType = "";

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private StringBuffer m5841a(StringBuffer stringBuffer, Bundle bundle) {
        C4331f.m5442c(C4331f.f18119d, "fillShareToQQParams() --start");
        bundle.putString(AuthActivity.ACTION_KEY, SystemUtils.QQ_SHARE_CALLBACK_ACTION);
        bundle.putString("appId", this.mToken.getAppId());
        bundle.putString("sdkp", "a");
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        if (bundle.containsKey("content") && bundle.getString("content").length() > 40) {
            bundle.putString("content", bundle.getString("content").substring(0, 40) + "...");
        }
        if (bundle.containsKey("summary") && bundle.getString("summary").length() > 80) {
            bundle.putString("summary", bundle.getString("summary").substring(0, 80) + "...");
        }
        stringBuffer.append("&" + Util.encodeUrl(bundle).replaceAll("\\+", "%20"));
        C4331f.m5442c(C4331f.f18119d, "fillShareToQQParams() --end");
        return stringBuffer;
    }

    /* renamed from: a */
    private void m5844a(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        C4331f.m5442c(C4331f.f18119d, "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        final String string2 = bundle.getString("title");
        final String string3 = bundle.getString("summary");
        C4331f.m5445b(f17491a, "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            m5840b(activity, bundle, iUiListener);
        } else if (!Util.isValidUrl(string)) {
            bundle.putString("imageUrl", null);
            if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_3_0) < 0) {
                C4331f.m5445b(f17491a, "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                m5840b(activity, bundle, iUiListener);
            } else {
                C4331f.m5445b(f17491a, "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                C4220a.m5833a(activity, string, new AsynLoadImgBack() { // from class: com.tencent.connect.share.QQShare.2
                    @Override // com.tencent.open.utils.AsynLoadImgBack
                    public void batchSaved(int i, ArrayList<String> arrayList) {
                    }

                    @Override // com.tencent.open.utils.AsynLoadImgBack
                    public void saved(int i, String str) {
                        if (i == 0) {
                            bundle.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            if (iUiListener != null) {
                                iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                C4331f.m5439e(QQShare.f17491a, "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, QQShare.this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.m5840b(activity, bundle, iUiListener);
                    }
                });
            }
        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                C4331f.m5439e(f17491a, Constants.MSG_SHARE_NOSD_ERROR);
            }
            C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
            return;
        } else if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_3_0) >= 0) {
            m5840b(activity, bundle, iUiListener);
        } else {
            new AsynLoadImg(activity).save(string, new AsynLoadImgBack() { // from class: com.tencent.connect.share.QQShare.1
                @Override // com.tencent.open.utils.AsynLoadImgBack
                public void batchSaved(int i, ArrayList<String> arrayList) {
                }

                @Override // com.tencent.open.utils.AsynLoadImgBack
                public void saved(int i, String str) {
                    if (i == 0) {
                        bundle.putString("imageLocalUrl", str);
                    } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                        if (iUiListener != null) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                            C4331f.m5439e(QQShare.f17491a, "shareToMobileQQ -- error: 获取分享图片失败!");
                        }
                        C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, QQShare.this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                        return;
                    }
                    QQShare.this.m5840b(activity, bundle, iUiListener);
                }
            });
        }
        C4331f.m5442c(C4331f.f18119d, "shareToMobileQQ() -- end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5840b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        C4331f.m5442c(C4331f.f18119d, "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        int i2 = bundle.getInt("cflag", 0);
        String string6 = bundle.getString("share_qq_ext_str");
        String applicationLable = Util.getApplicationLable(activity);
        if (applicationLable == null) {
            applicationLable = bundle.getString("appName");
        }
        String string7 = bundle.getString("imageLocalUrl");
        String appId = this.mToken.getAppId();
        String openId = this.mToken.getOpenId();
        C4331f.m5448a(f17491a, "doShareToQQ -- openid: " + openId);
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(Util.getBytesUTF8(string), 2));
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(Util.getBytesUTF8(string7), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(Util.getBytesUTF8(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(Util.getBytesUTF8(string3), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(Util.getBytesUTF8(string4), 2));
        }
        if (!TextUtils.isEmpty(applicationLable)) {
            if (applicationLable.length() > 20) {
                applicationLable = applicationLable.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(Util.getBytesUTF8(applicationLable), 2));
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(Util.getBytesUTF8(openId), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(Util.getBytesUTF8(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i)), 2));
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(Util.getBytesUTF8(string6), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i2)), 2));
        C4331f.m5448a(f17491a, "doShareToQQ -- url: " + stringBuffer.toString());
        C4188a.m5956a(Global.getContext(), this.mToken, "requireApi", "shareToNativeQQ");
        this.mActivityIntent = new Intent("android.intent.action.VIEW");
        this.mActivityIntent.setData(Uri.parse(stringBuffer.toString()));
        this.mActivityIntent.putExtra("pkg_name", activity.getPackageName());
        if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_6_0) < 0) {
            C4331f.m5442c(f17491a, "doShareToQQ, qqver below 4.6.");
            if (hasActivityForIntent()) {
                startAssitActivity(activity, iUiListener);
            }
        } else {
            Object obj = TemporaryStorage.set(SystemUtils.QQ_SHARE_CALLBACK_ACTION, iUiListener);
            if (obj != null) {
                ((IUiListener) obj).onCancel();
                C4331f.m5442c(f17491a, "doShareToQQ, last listener is not null, cancel it.");
            }
            if (hasActivityForIntent()) {
                AssistActivity.isQQMobileShare = true;
                startAssistActivity(activity, Constants.REQUEST_QQ_SHARE);
            }
        }
        if (hasActivityForIntent()) {
            C4340d.m5413a().m5409a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SHARE_TO_QQ, "10", "3", "0", this.mViaShareQQType, "0", "1", "0");
            C4340d.m5413a().m5412a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            C4340d.m5413a().m5409a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SHARE_TO_QQ, "10", "3", "1", this.mViaShareQQType, "0", "1", "0");
            C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        C4331f.m5442c(C4331f.f18119d, "doShareToQQ() --end");
    }

    /* renamed from: c */
    private void m5838c(Activity activity, Bundle bundle, IUiListener iUiListener) {
        C4331f.m5442c(C4331f.f18119d, "shareToH5QQ() -- start");
        Object obj = TemporaryStorage.set(SystemUtils.QQ_SHARE_CALLBACK_ACTION, iUiListener);
        if (obj != null) {
            C4331f.m5442c(f17491a, "shareToH5QQ, last listener is not null, cancel it.");
            ((IUiListener) obj).onCancel();
        }
        StringBuffer stringBuffer = new StringBuffer("http://openmobile.qq.com/api/check?page=shareindex.html&style=9");
        if (bundle == null) {
            bundle = new Bundle();
        }
        StringBuffer m5841a = m5841a(stringBuffer, bundle);
        C4188a.m5956a(Global.getContext(), this.mToken, "requireApi", "shareToH5QQ");
        Bundle bundle2 = new Bundle();
        bundle2.putString("callbackAction", SystemUtils.QQ_SHARE_CALLBACK_ACTION);
        bundle2.putString("viaShareType", this.mViaShareQQType);
        bundle2.putString("url", m5841a.toString());
        bundle2.putString("openId", this.mToken.getOpenId());
        bundle2.putString("appId", this.mToken.getAppId());
        startAssistActivity(activity, bundle2, Constants.REQUEST_QQ_SHARE);
        C4340d.m5413a().m5412a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToH5QQ");
        C4331f.m5442c(C4331f.f18119d, "shareToH5QQ() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        TemporaryStorage.remove(SystemUtils.QQ_SHARE_CALLBACK_ACTION);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        C4331f.m5442c(f17491a, "shareToQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("imageLocalUrl");
        int i = bundle.getInt("req_type", 1);
        C4331f.m5442c(f17491a, "shareToQQ -- type: " + i);
        switch (i) {
            case 1:
                this.mViaShareQQType = "1";
                break;
            case 2:
                this.mViaShareQQType = "3";
                break;
            case 5:
                this.mViaShareQQType = "2";
                break;
            case 6:
                this.mViaShareQQType = "4";
                break;
        }
        if (i == 6) {
            if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_5_0_0) < 0) {
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                C4331f.m5439e(f17491a, "shareToQQ, app share is not support below qq5.0.");
                C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format(ServerSetting.APP_DETAIL_PAGE, this.mToken.getAppId(), "mqq");
            bundle.putString("targetUrl", string4);
        }
        if (!Util.hasSDCard() && SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_5_0) < 0) {
            iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
            C4331f.m5439e(f17491a, "shareToQQ sdcard is null--end");
            C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
            return;
        }
        if (i == 5) {
            if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_3_0) < 0) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_QQ_VERSION_ERROR, null));
                C4331f.m5439e(f17491a, "shareToQQ, version below 4.3 is not support.");
                C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                return;
            } else if (!Util.fileExists(string5)) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                C4331f.m5439e(f17491a, "shareToQQ -- error: 非法的图片地址!");
                C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR);
                return;
            }
        }
        if (i != 5) {
            if (TextUtils.isEmpty(string4) || (!string4.startsWith("http://") && !string4.startsWith("https://"))) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_ERROR, null));
                C4331f.m5439e(f17491a, "shareToQQ, targetUrl is empty or illegal..");
                C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                return;
            } else if (TextUtils.isEmpty(string2)) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                C4331f.m5439e(f17491a, "shareToQQ, title is empty.");
                C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                return;
            }
        }
        if (!TextUtils.isEmpty(string) && !string.startsWith("http://") && !string.startsWith("https://") && !new File(string).exists()) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
            C4331f.m5439e(f17491a, " shareToQQ, image url is emprty or illegal.");
            C4340d.m5413a().m5412a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        if (!TextUtils.isEmpty(string2) && string2.length() > 45) {
            bundle.putString("title", Util.subString(string2, 45, null, null));
        }
        if (!TextUtils.isEmpty(string3) && string3.length() > 60) {
            bundle.putString("summary", Util.subString(string3, 60, null, null));
        }
        if (Util.isMobileQQSupportShare(activity)) {
            m5844a(activity, bundle, iUiListener);
        } else {
            m5838c(activity, bundle, iUiListener);
        }
        C4331f.m5442c(f17491a, "shareToQQ() -- end.");
    }
}
