package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* renamed from: cn.sharesdk.wechat.utils.f */
/* loaded from: classes.dex */
public class C0710f extends WechatResp {

    /* renamed from: a */
    public WXMediaMessage f1698a;

    public C0710f(Bundle bundle) {
        super(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: a */
    public int mo19375a() {
        return 4;
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: a */
    public void mo19374a(Bundle bundle) {
        super.mo19374a(bundle);
        this.f1698a = WXMediaMessage.C0703a.m19407a(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: b */
    public void mo19373b(Bundle bundle) {
        super.mo19373b(bundle);
        bundle.putAll(WXMediaMessage.C0703a.m19406a(this.f1698a));
    }
}
