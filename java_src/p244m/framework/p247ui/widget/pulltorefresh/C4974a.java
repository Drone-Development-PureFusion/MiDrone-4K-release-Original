package p244m.framework.p247ui.widget.pulltorefresh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/* renamed from: m.framework.ui.widget.pulltorefresh.a */
/* loaded from: classes2.dex */
public class C4974a extends BaseAdapter {

    /* renamed from: a */
    private AbstractC4978e f21358a;

    public C4974a(AbstractC4978e abstractC4978e) {
        this.f21358a = abstractC4978e;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21358a.m2404i();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f21358a.m2405c(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f21358a.m2406b(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f21358a.m2407a(i, view, viewGroup);
    }
}
