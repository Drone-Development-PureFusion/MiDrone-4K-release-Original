package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: it.sephiroth.android.library.widget.c */
/* loaded from: classes2.dex */
public class C4935c implements Filterable, WrapperListAdapter {

    /* renamed from: c */
    static final ArrayList<HListView.C4931b> f21232c = new ArrayList<>();

    /* renamed from: a */
    ArrayList<HListView.C4931b> f21233a;

    /* renamed from: b */
    ArrayList<HListView.C4931b> f21234b;

    /* renamed from: d */
    boolean f21235d;

    /* renamed from: e */
    private final ListAdapter f21236e;

    /* renamed from: f */
    private final boolean f21237f;

    public C4935c(ArrayList<HListView.C4931b> arrayList, ArrayList<HListView.C4931b> arrayList2, ListAdapter listAdapter) {
        this.f21236e = listAdapter;
        this.f21237f = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f21233a = f21232c;
        } else {
            this.f21233a = arrayList;
        }
        if (arrayList2 == null) {
            this.f21234b = f21232c;
        } else {
            this.f21234b = arrayList2;
        }
        this.f21235d = m2644a(this.f21233a) && m2644a(this.f21234b);
    }

    /* renamed from: a */
    private boolean m2644a(ArrayList<HListView.C4931b> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.C4931b> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!it2.next().f21166c) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public int m2646a() {
        return this.f21233a.size();
    }

    /* renamed from: a */
    public boolean m2645a(View view) {
        boolean z = false;
        for (int i = 0; i < this.f21233a.size(); i++) {
            if (this.f21233a.get(i).f21164a == view) {
                this.f21233a.remove(i);
                if (m2644a(this.f21233a) && m2644a(this.f21234b)) {
                    z = true;
                }
                this.f21235d = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.f21236e != null) {
            return this.f21235d && this.f21236e.areAllItemsEnabled();
        }
        return true;
    }

    /* renamed from: b */
    public int m2643b() {
        return this.f21234b.size();
    }

    /* renamed from: b */
    public boolean m2642b(View view) {
        boolean z = false;
        for (int i = 0; i < this.f21234b.size(); i++) {
            if (this.f21234b.get(i).f21164a == view) {
                this.f21234b.remove(i);
                if (m2644a(this.f21233a) && m2644a(this.f21234b)) {
                    z = true;
                }
                this.f21235d = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21236e != null ? m2643b() + m2646a() + this.f21236e.getCount() : m2643b() + m2646a();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f21237f) {
            return ((Filterable) this.f21236e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int m2646a = m2646a();
        if (i < m2646a) {
            return this.f21233a.get(i).f21165b;
        }
        int i2 = i - m2646a;
        int i3 = 0;
        return (this.f21236e == null || i2 >= (i3 = this.f21236e.getCount())) ? this.f21234b.get(i2 - i3).f21165b : this.f21236e.getItem(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int m2646a = m2646a();
        if (this.f21236e == null || i < m2646a || (i2 = i - m2646a) >= this.f21236e.getCount()) {
            return -1L;
        }
        return this.f21236e.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int m2646a = m2646a();
        if (this.f21236e == null || i < m2646a || (i2 = i - m2646a) >= this.f21236e.getCount()) {
            return -2;
        }
        return this.f21236e.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int m2646a = m2646a();
        if (i < m2646a) {
            return this.f21233a.get(i).f21164a;
        }
        int i2 = i - m2646a;
        int i3 = 0;
        return (this.f21236e == null || i2 >= (i3 = this.f21236e.getCount())) ? this.f21234b.get(i2 - i3).f21164a : this.f21236e.getView(i2, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        if (this.f21236e != null) {
            return this.f21236e.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f21236e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        if (this.f21236e != null) {
            return this.f21236e.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.f21236e == null || this.f21236e.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int m2646a = m2646a();
        if (i < m2646a) {
            return this.f21233a.get(i).f21166c;
        }
        int i2 = i - m2646a;
        int i3 = 0;
        return (this.f21236e == null || i2 >= (i3 = this.f21236e.getCount())) ? this.f21234b.get(i2 - i3).f21166c : this.f21236e.isEnabled(i2);
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f21236e != null) {
            this.f21236e.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f21236e != null) {
            this.f21236e.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
