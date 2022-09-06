package cn.sharesdk.framework.authorize;

import android.content.Intent;
/* renamed from: cn.sharesdk.framework.authorize.c */
/* loaded from: classes.dex */
public class C0640c extends C0638a {

    /* renamed from: b */
    protected SSOListener f1464b;

    /* renamed from: c */
    private AbstractC0641d f1465c;

    /* renamed from: a */
    public void m19720a(SSOListener sSOListener) {
        this.f1464b = sSOListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f1465c.mo19465a(i, i2, intent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.f1465c = this.f1460a.getSSOProcessor(this);
        if (this.f1465c != null) {
            this.f1465c.m19719a(32973);
            this.f1465c.mo19466a();
            return;
        }
        finish();
        AuthorizeListener authorizeListener = this.f1460a.getAuthorizeListener();
        if (authorizeListener == null) {
            return;
        }
        authorizeListener.onError(new Throwable("Failed to start SSO for " + this.f1460a.getPlatform().getName()));
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        this.f1465c.m19718a(intent);
    }
}
