package com.fimi.soul.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.util.HashMap;
import java.util.List;
/* renamed from: com.fimi.soul.b.c */
/* loaded from: classes.dex */
public class C2325c extends BaseExpandableListAdapter {

    /* renamed from: a */
    HashMap<String, List<String>> f7789a;

    /* renamed from: b */
    List<String> f7790b;

    /* renamed from: c */
    Context f7791c;

    /* renamed from: com.fimi.soul.b.c$a */
    /* loaded from: classes.dex */
    class C2326a {

        /* renamed from: a */
        public TextView f7792a;

        C2326a() {
        }
    }

    public C2325c(Context context, HashMap<String, List<String>> hashMap, List<String> list) {
        this.f7791c = context;
        this.f7789a = hashMap;
        this.f7790b = list;
    }

    /* renamed from: a */
    public void m12574a(HashMap<String, List<String>> hashMap, List<String> list) {
        this.f7789a = hashMap;
        this.f7790b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        if (this.f7789a == null) {
            return null;
        }
        return this.f7789a.get(this.f7790b.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C2326a c2326a;
        if (view == null) {
            view = LayoutInflater.from(this.f7791c).inflate(C2300R.layout.errorcodebody, (ViewGroup) null);
            C2326a c2326a2 = new C2326a();
            c2326a2.f7792a = (TextView) view.findViewById(C2300R.C2302id.errorbody);
            view.setTag(c2326a2);
            c2326a = c2326a2;
        } else {
            c2326a = (C2326a) view.getTag();
        }
        c2326a.f7792a.setText(this.f7789a.get(this.f7790b.get(i)).get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        if (this.f7789a == null) {
            return 0;
        }
        return this.f7789a.get(this.f7790b.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f7790b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f7790b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f7791c).inflate(C2300R.layout.errorcodeheard, (ViewGroup) null);
        ((TextView) inflate.findViewById(C2300R.C2302id.errorheard)).setText(this.f7790b.get(i));
        return inflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
