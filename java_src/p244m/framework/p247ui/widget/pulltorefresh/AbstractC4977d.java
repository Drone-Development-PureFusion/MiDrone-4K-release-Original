package p244m.framework.p247ui.widget.pulltorefresh;

import android.content.Context;
import android.view.View;
/* renamed from: m.framework.ui.widget.pulltorefresh.d */
/* loaded from: classes2.dex */
public abstract class AbstractC4977d {

    /* renamed from: a */
    private Context f21359a;

    /* renamed from: b */
    private PullToRefreshView f21360b;

    public AbstractC4977d(PullToRefreshView pullToRefreshView) {
        this.f21359a = pullToRefreshView.getContext();
        this.f21360b = pullToRefreshView;
    }

    /* renamed from: a */
    public Context m2413a() {
        return this.f21359a;
    }

    /* renamed from: a */
    public abstract void m2412a(int i);

    /* renamed from: b */
    protected PullToRefreshView m2411b() {
        return this.f21360b;
    }

    /* renamed from: c */
    public void mo2375c() {
        this.f21360b.m2436a();
    }

    /* renamed from: d */
    public abstract View m2410d();

    /* renamed from: e */
    public abstract AbstractC4986i mo2373e();

    /* renamed from: f */
    public abstract boolean mo2372f();

    /* renamed from: g */
    public abstract void m2409g();

    /* renamed from: h */
    public void m2408h() {
    }
}
