package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0683d;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* renamed from: cn.sharesdk.wechat.utils.d */
/* loaded from: classes.dex */
public class C0708d extends AbstractC0716j {

    /* renamed from: a */
    public WXMediaMessage f1696a;

    /* renamed from: b */
    public int f1697b;

    @Override // cn.sharesdk.wechat.utils.AbstractC0716j
    /* renamed from: a */
    public int mo19343a() {
        return 2;
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0716j
    /* renamed from: a */
    public void mo19342a(Bundle bundle) {
        super.mo19342a(bundle);
        bundle.putAll(WXMediaMessage.C0703a.m19406a(this.f1696a));
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.f1697b);
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0716j
    /* renamed from: b */
    public boolean mo19341b() {
        if (this.f1696a.getType() == 8 && (this.f1696a.thumbData == null || this.f1696a.thumbData.length <= 0)) {
            C0683d.m19513a().m5972d("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
            return false;
        } else if (this.f1696a.thumbData != null && this.f1696a.thumbData.length > 32768) {
            C0683d.m19513a().m5972d("checkArgs fail, thumbData is invalid", new Object[0]);
            return false;
        } else if (this.f1696a.title != null && this.f1696a.title.length() > 512) {
            C0683d.m19513a().m5972d("checkArgs fail, title is invalid", new Object[0]);
            return false;
        } else {
            if (this.f1696a.description != null && this.f1696a.description.length() > 1024) {
                this.f1696a.description = this.f1696a.description.substring(0, 1021) + "...";
            }
            if (this.f1696a.mediaObject != null) {
                return this.f1696a.mediaObject.checkArgs();
            }
            C0683d.m19513a().m5972d("checkArgs fail, mediaObject is null", new Object[0]);
            return false;
        }
    }
}
