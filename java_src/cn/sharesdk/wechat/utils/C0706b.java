package cn.sharesdk.wechat.utils;

import android.os.Bundle;
/* renamed from: cn.sharesdk.wechat.utils.b */
/* loaded from: classes.dex */
public class C0706b extends WechatResp {

    /* renamed from: a */
    public String f1690a;

    /* renamed from: b */
    public String f1691b;

    /* renamed from: c */
    public int f1692c;

    /* renamed from: d */
    public String f1693d;

    /* renamed from: e */
    public String f1694e;

    public C0706b(Bundle bundle) {
        super(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: a */
    public int mo19375a() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: a */
    public void mo19374a(Bundle bundle) {
        super.mo19374a(bundle);
        this.f1690a = bundle.getString("_wxapi_sendauth_resp_userName");
        this.f1691b = bundle.getString("_wxapi_sendauth_resp_token");
        this.f1692c = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
        this.f1693d = bundle.getString("_wxapi_sendauth_resp_state");
        this.f1694e = bundle.getString("_wxapi_sendauth_resp_url");
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: b */
    public void mo19373b(Bundle bundle) {
        super.mo19373b(bundle);
        bundle.putString("_wxapi_sendauth_resp_userName", this.f1690a);
        bundle.putString("_wxapi_sendauth_resp_token", this.f1691b);
        bundle.putInt("_wxapi_sendauth_resp_expireDate", this.f1692c);
        bundle.putString("_wxapi_sendauth_resp_state", this.f1693d);
        bundle.putString("_wxapi_sendauth_resp_url", this.f1694e);
    }
}
