package com.fimi.soul.wxapi;

import android.widget.Toast;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
/* loaded from: classes.dex */
public class WXEntryActivity extends WechatHandlerActivity {
    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity
    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    }

    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity
    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null || wXMediaMessage.mediaObject == null || !(wXMediaMessage.mediaObject instanceof WXAppExtendObject)) {
            return;
        }
        Toast.makeText(this, ((WXAppExtendObject) wXMediaMessage.mediaObject).extInfo, 0).show();
    }
}
