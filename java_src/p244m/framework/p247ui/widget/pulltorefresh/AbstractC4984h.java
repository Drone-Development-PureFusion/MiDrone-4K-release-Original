package p244m.framework.p247ui.widget.pulltorefresh;

import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* renamed from: m.framework.ui.widget.pulltorefresh.h */
/* loaded from: classes2.dex */
public abstract class AbstractC4984h extends AbstractC4978e {

    /* renamed from: a */
    private ScrollableListView f21376a = new ScrollableListView(a());

    /* renamed from: b */
    private C4974a f21377b = new C4974a(this);

    /* renamed from: c */
    private boolean f21378c;

    /* renamed from: d */
    private AbstractC4975b f21379d;

    public AbstractC4984h(PullToRefreshView pullToRefreshView) {
        super(pullToRefreshView);
        this.f21376a.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: m.framework.ui.widget.pulltorefresh.h.1

            /* renamed from: b */
            private int f21381b;

            /* renamed from: c */
            private int f21382c;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.f21381b = i;
                this.f21382c = i2;
                AbstractC4984h.this.mo2377a(AbstractC4984h.this.f21376a, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                AbstractC4984h.this.f21378c = i == 2;
                if (i == 0) {
                    if (AbstractC4984h.this.f21379d != null) {
                        AbstractC4984h.this.f21379d.m2415a(this.f21381b, this.f21382c);
                    } else if (AbstractC4984h.this.f21377b == null) {
                    } else {
                        AbstractC4984h.this.f21377b.notifyDataSetChanged();
                    }
                }
            }
        });
        this.f21376a.setAdapter((ListAdapter) this.f21377b);
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4978e
    /* renamed from: a */
    public void mo2377a(AbstractC4986i abstractC4986i, int i, int i2, int i3) {
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: c */
    public void mo2375c() {
        super.c();
        this.f21377b.notifyDataSetChanged();
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: e */
    public AbstractC4986i mo2373e() {
        return this.f21376a;
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: f */
    public boolean mo2372f() {
        return this.f21376a.m2418a();
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4978e
    /* renamed from: j */
    public boolean mo2371j() {
        return this.f21378c;
    }

    /* renamed from: k */
    public ListView m2370k() {
        return this.f21376a;
    }
}
