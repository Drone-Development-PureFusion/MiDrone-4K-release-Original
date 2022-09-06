package cn.sharesdk.wechat.utils;

import android.os.Bundle;
/* loaded from: classes.dex */
public abstract class WechatResp {

    /* renamed from: f */
    public int f1685f;

    /* renamed from: g */
    public String f1686g;

    /* renamed from: h */
    public String f1687h;

    /* loaded from: classes.dex */
    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public WechatResp(Bundle bundle) {
        mo19374a(bundle);
    }

    /* renamed from: a */
    public abstract int mo19375a();

    /* renamed from: a */
    public void mo19374a(Bundle bundle) {
        this.f1685f = bundle.getInt("_wxapi_baseresp_errcode");
        this.f1686g = bundle.getString("_wxapi_baseresp_errstr");
        this.f1687h = bundle.getString("_wxapi_baseresp_transaction");
    }

    /* renamed from: b */
    public void mo19373b(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", mo19375a());
        bundle.putInt("_wxapi_baseresp_errcode", this.f1685f);
        bundle.putString("_wxapi_baseresp_errstr", this.f1686g);
        bundle.putString("_wxapi_baseresp_transaction", this.f1687h);
    }
}
