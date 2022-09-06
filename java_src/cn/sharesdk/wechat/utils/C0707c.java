package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* renamed from: cn.sharesdk.wechat.utils.c */
/* loaded from: classes.dex */
public class C0707c extends WechatResp {

    /* renamed from: a */
    public WXMediaMessage f1695a;

    public C0707c(Bundle bundle) {
        super(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: a */
    public int mo19375a() {
        return 3;
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: a */
    public void mo19374a(Bundle bundle) {
        super.mo19374a(bundle);
        this.f1695a = WXMediaMessage.C0703a.m19407a(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* renamed from: b */
    public void mo19373b(Bundle bundle) {
        super.mo19373b(bundle);
        bundle.putAll(WXMediaMessage.C0703a.m19406a(this.f1695a));
    }
}
