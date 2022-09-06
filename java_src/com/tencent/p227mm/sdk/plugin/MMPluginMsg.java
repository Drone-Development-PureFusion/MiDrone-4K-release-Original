package com.tencent.p227mm.sdk.plugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.p227mm.sdk.openapi.IWXAPI;
import com.tencent.p227mm.sdk.openapi.SendMessageToWX;
import com.tencent.p227mm.sdk.openapi.WXAPIFactory;
import com.tencent.p227mm.sdk.openapi.WXAppExtendObject;
import com.tencent.p227mm.sdk.openapi.WXMediaMessage;
import com.tencent.p227mm.sdk.platformtools.Util;
/* renamed from: com.tencent.mm.sdk.plugin.MMPluginMsg */
/* loaded from: classes2.dex */
public class MMPluginMsg {
    public static final String ACTION_AUTO_MSG = "ACTION_AUTO_MSG";
    public static final String RECV_MSG = "recv_msg";
    public static final String RECV_PKG = "recv_pkg";
    public static final String RECV_THUMB = "recv_thumb";
    public static final String SEND_ERR_CODE = "send_err_code";
    public static final String SEND_ERR_TYPE = "send_err_type";
    public static final String SEND_ID = "send_id";
    public static final String TYPE = "type";
    public static final int TYPE_RECV_MSG = 2;
    public static final int TYPE_SEND_RET = 1;
    public String content;
    public long msgClientId;

    /* renamed from: com.tencent.mm.sdk.plugin.MMPluginMsg$ReceiverHelper */
    /* loaded from: classes2.dex */
    public static class ReceiverHelper {
        Intent intent;
        int type;

        public ReceiverHelper(Intent intent) {
            this.type = intent.getIntExtra("type", 0);
            this.intent = intent;
        }

        public String getMsgContent() {
            if (isRecvNew()) {
                return this.intent.getStringExtra(MMPluginMsg.RECV_MSG);
            }
            return null;
        }

        public Integer getSendErrCode() {
            if (isSendRet()) {
                return Integer.valueOf(this.intent.getIntExtra(MMPluginMsg.SEND_ERR_CODE, 0));
            }
            return null;
        }

        public Integer getSendErrType() {
            if (isSendRet()) {
                return Integer.valueOf(this.intent.getIntExtra(MMPluginMsg.SEND_ERR_TYPE, 0));
            }
            return null;
        }

        public Long getSendMsgId() {
            if (isSendRet()) {
                return Long.valueOf(this.intent.getLongExtra(MMPluginMsg.SEND_ID, 0L));
            }
            return null;
        }

        public boolean isRecvNew() {
            return this.type == 2;
        }

        public boolean isSendRet() {
            return this.type == 1;
        }
    }

    public static MMPluginMsg WXAppExtentObjectToPluginMsg(WXAppExtendObject wXAppExtendObject) {
        if (wXAppExtendObject == null) {
            return null;
        }
        MMPluginMsg mMPluginMsg = new MMPluginMsg();
        mMPluginMsg.msgClientId = Util.getLong(wXAppExtendObject.extInfo, -1L);
        if (mMPluginMsg.msgClientId == -1 || Util.isNullOrNil(wXAppExtendObject.fileData)) {
            return null;
        }
        mMPluginMsg.content = new String(wXAppExtendObject.fileData);
        if (Util.isNullOrNil(mMPluginMsg.content)) {
            return null;
        }
        return mMPluginMsg;
    }

    public static WXAppExtendObject pluginMsgToWXAppExtendObject(MMPluginMsg mMPluginMsg) {
        if (mMPluginMsg == null) {
            return null;
        }
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.extInfo = new StringBuilder().append(mMPluginMsg.msgClientId).toString();
        wXAppExtendObject.fileData = mMPluginMsg.content.getBytes();
        return wXAppExtendObject;
    }

    public static long sendMessage(Context context, String str) {
        if (Util.isNullOrNil(str)) {
            return -1L;
        }
        MMPluginMsg mMPluginMsg = new MMPluginMsg();
        mMPluginMsg.msgClientId = Util.nowMilliSecond();
        mMPluginMsg.content = str;
        WXAppExtendObject pluginMsgToWXAppExtendObject = pluginMsgToWXAppExtendObject(mMPluginMsg);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = pluginMsgToWXAppExtendObject;
        wXMediaMessage.description = "";
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, null);
        if (createWXAPI == null) {
            return -2L;
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "appdata" + mMPluginMsg.msgClientId;
        req.message = wXMediaMessage;
        if (createWXAPI.sendReq(req)) {
            return mMPluginMsg.msgClientId;
        }
        return -3L;
    }
}
