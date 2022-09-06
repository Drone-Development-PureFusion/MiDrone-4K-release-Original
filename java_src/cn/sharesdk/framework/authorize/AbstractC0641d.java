package cn.sharesdk.framework.authorize;

import android.content.Intent;
/* renamed from: cn.sharesdk.framework.authorize.d */
/* loaded from: classes.dex */
public abstract class AbstractC0641d {

    /* renamed from: a */
    protected C0640c f1466a;

    /* renamed from: b */
    protected int f1467b;

    /* renamed from: c */
    protected SSOListener f1468c;

    public AbstractC0641d(C0640c c0640c) {
        this.f1466a = c0640c;
        this.f1468c = c0640c.a().getSSOListener();
    }

    /* renamed from: a */
    public abstract void mo19466a();

    /* renamed from: a */
    public void m19719a(int i) {
        this.f1467b = i;
    }

    /* renamed from: a */
    public void mo19465a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m19718a(Intent intent) {
    }
}
