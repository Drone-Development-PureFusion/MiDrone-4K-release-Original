package p244m.framework.p247ui.widget.pulltorefresh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import p244m.framework.p247ui.widget.pulltorefresh.GroupListView;
/* renamed from: m.framework.ui.widget.pulltorefresh.g */
/* loaded from: classes2.dex */
public abstract class AbstractC4981g extends AbstractC4977d {

    /* renamed from: a */
    private ScrollableGroupListView f21368a = new ScrollableGroupListView(a());

    /* renamed from: b */
    private GroupListView.AbstractC4968a f21369b = new GroupListView.AbstractC4968a() { // from class: m.framework.ui.widget.pulltorefresh.g.2
        @Override // p244m.framework.p247ui.widget.pulltorefresh.GroupListView.AbstractC4968a
        /* renamed from: a */
        public int mo2385a() {
            return AbstractC4981g.this.m2388i();
        }

        @Override // p244m.framework.p247ui.widget.pulltorefresh.GroupListView.AbstractC4968a
        /* renamed from: a */
        public View mo2382a(int i, int i2, View view, ViewGroup viewGroup) {
            return AbstractC4981g.this.m2397a(i, i2, view, viewGroup);
        }

        @Override // p244m.framework.p247ui.widget.pulltorefresh.GroupListView.AbstractC4968a
        /* renamed from: a */
        public View mo2381a(int i, View view, ViewGroup viewGroup) {
            return AbstractC4981g.this.m2396a(i, view, viewGroup);
        }

        @Override // p244m.framework.p247ui.widget.pulltorefresh.GroupListView.AbstractC4968a
        /* renamed from: a */
        public Object mo2383a(int i, int i2) {
            return AbstractC4981g.this.m2398a(i, i2);
        }

        @Override // p244m.framework.p247ui.widget.pulltorefresh.GroupListView.AbstractC4968a
        /* renamed from: a */
        public String mo2384a(int i) {
            return AbstractC4981g.this.m2392b(i);
        }

        @Override // p244m.framework.p247ui.widget.pulltorefresh.GroupListView.AbstractC4968a
        /* renamed from: b */
        public int mo2380b(int i) {
            return AbstractC4981g.this.m2390c(i);
        }
    };

    /* renamed from: c */
    private boolean f21370c;

    /* renamed from: d */
    private AbstractC4975b f21371d;

    public AbstractC4981g(PullToRefreshView pullToRefreshView) {
        super(pullToRefreshView);
        this.f21368a.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: m.framework.ui.widget.pulltorefresh.g.1

            /* renamed from: b */
            private int f21373b;

            /* renamed from: c */
            private int f21374c;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.f21373b = i;
                this.f21374c = i2;
                AbstractC4981g.this.m2393a(AbstractC4981g.this.f21368a, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                AbstractC4981g.this.f21370c = i == 2;
                if (i == 0) {
                    if (AbstractC4981g.this.f21371d != null) {
                        AbstractC4981g.this.f21371d.m2415a(this.f21373b, this.f21374c);
                    } else if (AbstractC4981g.this.f21369b == null) {
                    } else {
                        AbstractC4981g.this.f21369b.m2437b();
                    }
                }
            }
        });
        this.f21368a.setAdapter(this.f21369b);
    }

    /* renamed from: a */
    public abstract View m2397a(int i, int i2, View view, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract View m2396a(int i, View view, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract Object m2398a(int i, int i2);

    /* renamed from: a */
    public void m2393a(AbstractC4986i abstractC4986i, int i, int i2, int i3) {
    }

    /* renamed from: b */
    public abstract String m2392b(int i);

    /* renamed from: c */
    public abstract int m2390c(int i);

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: c */
    public void mo2375c() {
        super.mo2375c();
        this.f21369b.m2437b();
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: e */
    public AbstractC4986i mo2373e() {
        return this.f21368a;
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: f */
    public boolean mo2372f() {
        return this.f21368a.m2421a();
    }

    /* renamed from: i */
    public abstract int m2388i();

    /* renamed from: j */
    public GroupListView m2387j() {
        return this.f21368a;
    }

    /* renamed from: k */
    public boolean m2386k() {
        return this.f21370c;
    }
}
