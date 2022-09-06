package com.fimi.soul.module.setting.newhand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.util.ArrayList;
/* renamed from: com.fimi.soul.module.setting.newhand.g */
/* loaded from: classes.dex */
public class C3549g extends BaseAdapter {

    /* renamed from: a */
    private Context f14247a;

    /* renamed from: b */
    private ArrayList<String> f14248b;

    /* renamed from: c */
    private LayoutInflater f14249c;

    /* renamed from: d */
    private int f14250d;

    /* renamed from: com.fimi.soul.module.setting.newhand.g$a */
    /* loaded from: classes.dex */
    class C3550a {

        /* renamed from: a */
        TextView f14251a;

        C3550a() {
        }
    }

    public C3549g(Context context, ArrayList<String> arrayList) {
        this.f14247a = context;
        this.f14248b = arrayList;
        this.f14249c = LayoutInflater.from(this.f14247a);
    }

    /* renamed from: a */
    public void m8103a(int i) {
        this.f14250d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14248b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f14248b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3550a c3550a;
        if (view == null) {
            c3550a = new C3550a();
            view = this.f14249c.inflate(C2300R.layout.item_set_newhand_mode, (ViewGroup) null);
            view.setTag(c3550a);
            c3550a.f14251a = (TextView) view.findViewById(C2300R.C2302id.tv_group_item);
        } else {
            c3550a = (C3550a) view.getTag();
        }
        if (i == this.f14250d) {
            c3550a.f14251a.setTextColor(this.f14247a.getResources().getColor(C2300R.color.color_set_model));
        } else {
            c3550a.f14251a.setTextColor(this.f14247a.getResources().getColor(17170443));
        }
        c3550a.f14251a.setText(this.f14248b.get(i));
        C3658ar.m7612a(this.f14247a.getAssets(), c3550a.f14251a);
        return view;
    }
}
