package p244m.framework.p247ui.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
/* renamed from: m.framework.ui.widget.pulltorefresh.GroupListView */
/* loaded from: classes2.dex */
public class GroupListView extends ListView {

    /* renamed from: m.framework.ui.widget.pulltorefresh.GroupListView$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC4968a {

        /* renamed from: a */
        private BaseAdapter f21333a;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2439a(BaseAdapter baseAdapter) {
            this.f21333a = baseAdapter;
        }

        /* renamed from: a */
        public abstract int mo2385a();

        /* renamed from: a */
        public abstract View mo2382a(int i, int i2, View view, ViewGroup viewGroup);

        /* renamed from: a */
        public abstract View mo2381a(int i, View view, ViewGroup viewGroup);

        /* renamed from: a */
        public abstract Object mo2383a(int i, int i2);

        /* renamed from: a */
        public abstract String mo2384a(int i);

        /* renamed from: b */
        public abstract int mo2380b(int i);

        /* renamed from: b */
        public void m2437b() {
            this.f21333a.notifyDataSetChanged();
        }
    }

    /* renamed from: m.framework.ui.widget.pulltorefresh.GroupListView$b */
    /* loaded from: classes2.dex */
    private static class C4969b {

        /* renamed from: a */
        public LinearLayout f21334a;

        /* renamed from: b */
        public View f21335b;

        /* renamed from: c */
        public View f21336c;

        private C4969b() {
        }

        /* synthetic */ C4969b(C4969b c4969b) {
            this();
        }
    }

    public GroupListView(Context context) {
        super(context);
    }

    public GroupListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GroupListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(final AbstractC4968a abstractC4968a) {
        BaseAdapter baseAdapter = new BaseAdapter() { // from class: m.framework.ui.widget.pulltorefresh.GroupListView.1
            /* renamed from: a */
            private int[] m2440a(int i) {
                int[] iArr = {-1, -2};
                int mo2385a = abstractC4968a.mo2385a();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= mo2385a) {
                        break;
                    }
                    int mo2380b = abstractC4968a.mo2380b(i2) + 1;
                    if (i3 + mo2380b > i) {
                        iArr[0] = i2;
                        iArr[1] = (i - i3) - 1;
                        break;
                    }
                    i3 += mo2380b;
                    i2++;
                }
                return iArr;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                int mo2385a = abstractC4968a.mo2385a();
                int i = 0;
                for (int i2 = 0; i2 < mo2385a; i2++) {
                    i += abstractC4968a.mo2380b(i2) + 1;
                }
                return i;
            }

            @Override // android.widget.Adapter
            public Object getItem(int i) {
                int[] m2440a = m2440a(i);
                int i2 = m2440a[0];
                int i3 = m2440a[1];
                if (i2 > -1) {
                    if (i3 == -1) {
                        return abstractC4968a.mo2384a(i3);
                    }
                    if (i3 > -1) {
                        return abstractC4968a.mo2383a(i2, i3);
                    }
                }
                return null;
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return i;
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                int[] m2440a = m2440a(i);
                int i2 = m2440a[0];
                int i3 = m2440a[1];
                if (view == null) {
                    C4969b c4969b = new C4969b(null);
                    c4969b.f21334a = new LinearLayout(viewGroup.getContext());
                    c4969b.f21334a.setOrientation(1);
                    c4969b.f21334a.setTag(c4969b);
                    if (i2 > -1) {
                        if (i3 == -1) {
                            c4969b.f21335b = abstractC4968a.mo2381a(i2, c4969b.f21335b, c4969b.f21334a);
                            c4969b.f21334a.addView(c4969b.f21335b);
                        } else if (i3 > -1) {
                            c4969b.f21336c = abstractC4968a.mo2382a(i2, i3, c4969b.f21336c, c4969b.f21334a);
                            c4969b.f21334a.addView(c4969b.f21336c);
                        }
                    }
                    return c4969b.f21334a;
                }
                C4969b c4969b2 = (C4969b) view.getTag();
                if (i2 <= -1) {
                    return view;
                }
                if (i3 == -1) {
                    c4969b2.f21335b = abstractC4968a.mo2381a(i2, c4969b2.f21335b, c4969b2.f21334a);
                    if (c4969b2.f21336c == null) {
                        return view;
                    }
                    c4969b2.f21334a.removeView(c4969b2.f21336c);
                    return view;
                } else if (i3 <= -1) {
                    return view;
                } else {
                    c4969b2.f21336c = abstractC4968a.mo2382a(i2, i3, c4969b2.f21336c, c4969b2.f21334a);
                    if (c4969b2.f21335b == null) {
                        return view;
                    }
                    c4969b2.f21334a.removeView(c4969b2.f21335b);
                    return view;
                }
            }
        };
        abstractC4968a.m2439a(baseAdapter);
        super.setAdapter((ListAdapter) baseAdapter);
    }
}
