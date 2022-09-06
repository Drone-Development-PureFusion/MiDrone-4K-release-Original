package p244m.framework.p247ui.widget.pulltorefresh;

import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
/* renamed from: m.framework.ui.widget.pulltorefresh.f */
/* loaded from: classes2.dex */
public abstract class AbstractC4979f extends AbstractC4978e {

    /* renamed from: a */
    private ScrollableGridView f21361a = new ScrollableGridView(a());

    /* renamed from: b */
    private C4974a f21362b = new C4974a(this);

    /* renamed from: c */
    private boolean f21363c;

    /* renamed from: d */
    private AbstractC4975b f21364d;

    public AbstractC4979f(PullToRefreshView pullToRefreshView) {
        super(pullToRefreshView);
        this.f21361a.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: m.framework.ui.widget.pulltorefresh.f.1

            /* renamed from: b */
            private int f21366b;

            /* renamed from: c */
            private int f21367c;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.f21366b = i;
                this.f21367c = i2;
                AbstractC4979f.this.mo2377a(AbstractC4979f.this.f21361a, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                AbstractC4979f.this.f21363c = i == 2;
                if (i == 0) {
                    if (AbstractC4979f.this.f21364d != null) {
                        AbstractC4979f.this.f21364d.m2415a(this.f21366b, this.f21367c);
                    } else if (AbstractC4979f.this.f21362b == null) {
                    } else {
                        AbstractC4979f.this.f21362b.notifyDataSetChanged();
                    }
                }
            }
        });
        this.f21361a.setAdapter((ListAdapter) this.f21362b);
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4978e
    /* renamed from: a */
    public void mo2377a(AbstractC4986i abstractC4986i, int i, int i2, int i3) {
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: c */
    public void mo2375c() {
        super.c();
        this.f21362b.notifyDataSetChanged();
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: e */
    public AbstractC4986i mo2373e() {
        return this.f21361a;
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4977d
    /* renamed from: f */
    public boolean mo2372f() {
        return this.f21361a.m2424a();
    }

    @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4978e
    /* renamed from: j */
    public boolean mo2371j() {
        return this.f21363c;
    }

    /* renamed from: k */
    public GridView m2399k() {
        return this.f21361a;
    }
}
