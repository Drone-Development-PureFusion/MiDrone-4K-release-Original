package p244m.framework.p247ui.widget.pulltorefresh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.GridView;
/* renamed from: m.framework.ui.widget.pulltorefresh.ScrollableGridView */
/* loaded from: classes2.dex */
public class ScrollableGridView extends GridView implements AbstractC4986i {

    /* renamed from: a */
    private AbstractC4976c f21349a;

    /* renamed from: b */
    private boolean f21350b;

    public ScrollableGridView(Context context) {
        super(context);
        m2423a(context);
    }

    public ScrollableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2423a(context);
    }

    public ScrollableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2423a(context);
    }

    /* renamed from: a */
    private void m2423a(Context context) {
        setCacheColorHint(0);
        setSelector(new ColorDrawable());
        this.f21349a = new AbstractC4976c() { // from class: m.framework.ui.widget.pulltorefresh.ScrollableGridView.1
            @Override // p244m.framework.p247ui.widget.pulltorefresh.AbstractC4976c
            /* renamed from: a */
            public void mo2414a(AbstractC4986i abstractC4986i, int i, int i2, int i3, int i4) {
                ScrollableGridView.this.f21350b = i2 <= 0 && i4 <= 0;
            }
        };
    }

    /* renamed from: a */
    public boolean m2424a() {
        return this.f21350b;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected int computeVerticalScrollOffset() {
        int computeVerticalScrollOffset = super.computeVerticalScrollOffset();
        if (this.f21349a != null) {
            this.f21349a.mo2414a(this, 0, computeVerticalScrollOffset, 0, 0);
        }
        return computeVerticalScrollOffset;
    }
}
