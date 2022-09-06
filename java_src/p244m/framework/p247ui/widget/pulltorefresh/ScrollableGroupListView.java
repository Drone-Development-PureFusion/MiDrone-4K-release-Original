package p244m.framework.p247ui.widget.pulltorefresh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
/* renamed from: m.framework.ui.widget.pulltorefresh.ScrollableGroupListView */
/* loaded from: classes2.dex */
public class ScrollableGroupListView extends GroupListView implements AbstractC4986i {

    /* renamed from: a */
    private AbstractC4976c f21352a;

    /* renamed from: b */
    private boolean f21353b;

    public ScrollableGroupListView(Context context) {
        super(context);
        m2420a(context);
    }

    public ScrollableGroupListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2420a(context);
    }

    public ScrollableGroupListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2420a(context);
    }

    /* renamed from: a */
    private void m2420a(Context context) {
        setCacheColorHint(0);
        setSelector(new ColorDrawable());
        this.f21352a = new AbstractC4976c() { // from class: m.framework.ui.widget.pulltorefresh.ScrollableGroupListView.1
            @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4976c
            /* renamed from: a */
            public void mo2414a(AbstractC4986i abstractC4986i, int i, int i2, int i3, int i4) {
                ScrollableGroupListView.this.f21353b = i2 <= 0 && i4 <= 0;
            }
        };
    }

    /* renamed from: a */
    public boolean m2421a() {
        return this.f21353b;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected int computeVerticalScrollOffset() {
        int computeVerticalScrollOffset = super.computeVerticalScrollOffset();
        if (this.f21352a != null) {
            this.f21352a.mo2414a(this, 0, computeVerticalScrollOffset, 0, 0);
        }
        return computeVerticalScrollOffset;
    }
}
