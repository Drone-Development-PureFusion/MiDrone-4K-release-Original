package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AbstractC0641d;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0640c;
import cn.sharesdk.framework.authorize.C0642e;
import cn.sharesdk.framework.authorize.SSOListener;
/* renamed from: cn.sharesdk.framework.b */
/* loaded from: classes.dex */
public abstract class AbstractC0647b implements AuthorizeHelper {

    /* renamed from: a */
    protected Platform f1477a;

    /* renamed from: b */
    private AuthorizeListener f1478b;

    /* renamed from: c */
    private SSOListener f1479c;

    public AbstractC0647b(Platform platform) {
        this.f1477a = platform;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m19712a(SSOListener sSOListener) {
        this.f1479c = sSOListener;
        C0640c c0640c = new C0640c();
        c0640c.m19720a(sSOListener);
        c0640c.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m19711b(AuthorizeListener authorizeListener) {
        this.f1478b = authorizeListener;
        C0642e c0642e = new C0642e();
        c0642e.m19717a(this.f1478b);
        c0642e.a(this);
    }

    /* renamed from: c */
    public int m19710c() {
        return this.f1477a.getPlatformId();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AuthorizeListener getAuthorizeListener() {
        return this.f1478b;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public Platform getPlatform() {
        return this.f1477a;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public SSOListener getSSOListener() {
        return this.f1479c;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0641d getSSOProcessor(C0640c c0640c) {
        return null;
    }
}
