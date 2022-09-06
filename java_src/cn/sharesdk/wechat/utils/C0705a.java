package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0683d;
/* renamed from: cn.sharesdk.wechat.utils.a */
/* loaded from: classes.dex */
public class C0705a extends AbstractC0716j {

    /* renamed from: a */
    public String f1688a;

    /* renamed from: b */
    public String f1689b;

    @Override // cn.sharesdk.wechat.utils.AbstractC0716j
    /* renamed from: a */
    public int mo19343a() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0716j
    /* renamed from: a */
    public void mo19342a(Bundle bundle) {
        super.mo19342a(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", this.f1688a);
        bundle.putString("_wxapi_sendauth_req_state", this.f1689b);
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0716j
    /* renamed from: b */
    public boolean mo19341b() {
        if (this.f1688a == null || this.f1688a.length() == 0 || this.f1688a.length() > 1024) {
            C0683d.m19513a().m5972d("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
            return false;
        } else if (this.f1689b == null || this.f1689b.length() <= 1024) {
            return true;
        } else {
            C0683d.m19513a().m5972d("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
            return false;
        }
    }
}
