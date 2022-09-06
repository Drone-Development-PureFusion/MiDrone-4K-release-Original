package p244m.framework.p247ui.widget.pulltorefresh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ListView;
/* renamed from: m.framework.ui.widget.pulltorefresh.ScrollableListView */
/* loaded from: classes2.dex */
public class ScrollableListView extends ListView implements AbstractC4986i {

    /* renamed from: a */
    private AbstractC4976c f21355a;

    /* renamed from: b */
    private boolean f21356b;

    public ScrollableListView(Context context) {
        super(context);
        m2417a(context);
    }

    public ScrollableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2417a(context);
    }

    public ScrollableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2417a(context);
    }

    /* renamed from: a */
    private void m2417a(Context context) {
        setCacheColorHint(0);
        setSelector(new ColorDrawable());
        this.f21355a = new AbstractC4976c() { // from class: m.framework.ui.widget.pulltorefresh.ScrollableListView.1
            @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4976c
            /* renamed from: a */
            public void mo2414a(AbstractC4986i abstractC4986i, int i, int i2, int i3, int i4) {
                ScrollableListView.this.f21356b = i2 <= 0 && i4 <= 0;
            }
        };
    }

    /* renamed from: a */
    public boolean m2418a() {
        return this.f21356b;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected int computeVerticalScrollOffset() {
        int computeVerticalScrollOffset = super.computeVerticalScrollOffset();
        if (this.f21355a != null) {
            this.f21355a.mo2414a(this, 0, computeVerticalScrollOffset, 0, 0);
        }
        return computeVerticalScrollOffset;
    }
}
