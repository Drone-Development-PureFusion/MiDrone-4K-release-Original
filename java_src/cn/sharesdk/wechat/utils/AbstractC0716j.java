package cn.sharesdk.wechat.utils;

import android.os.Bundle;
/* renamed from: cn.sharesdk.wechat.utils.j */
/* loaded from: classes.dex */
public abstract class AbstractC0716j {

    /* renamed from: c */
    public String f1716c;

    /* renamed from: a */
    public abstract int mo19343a();

    /* renamed from: a */
    public void mo19342a(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", mo19343a());
        bundle.putString("_wxapi_basereq_transaction", this.f1716c);
    }

    /* renamed from: b */
    public abstract boolean mo19341b();
}
