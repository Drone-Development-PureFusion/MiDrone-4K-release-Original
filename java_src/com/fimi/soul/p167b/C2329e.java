package com.fimi.soul.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.FmMenuItem;
import java.util.List;
/* renamed from: com.fimi.soul.b.e */
/* loaded from: classes.dex */
public class C2329e extends BaseAdapter {

    /* renamed from: a */
    private Context f7800a;

    /* renamed from: b */
    private List<FmMenuItem> f7801b;

    /* renamed from: c */
    private int f7802c = C2300R.layout.item_list_pop;

    /* renamed from: com.fimi.soul.b.e$a */
    /* loaded from: classes.dex */
    static class C2330a {

        /* renamed from: a */
        TextView f7803a;

        C2330a() {
        }
    }

    public C2329e(Context context, List<FmMenuItem> list) {
        this.f7800a = context;
        this.f7801b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7801b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7801b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2330a c2330a;
        if (view == null) {
            view = LayoutInflater.from(this.f7800a).inflate(this.f7802c, (ViewGroup) null);
            c2330a = new C2330a();
            c2330a.f7803a = (TextView) view.findViewById(C2300R.C2302id.pop_item);
            view.setTag(c2330a);
        } else {
            c2330a = (C2330a) view.getTag();
        }
        FmMenuItem fmMenuItem = this.f7801b.get(i);
        c2330a.f7803a.setText(fmMenuItem.getText());
        view.setId(fmMenuItem.getId());
        return view;
    }
}
