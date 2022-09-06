package com.fimi.soul.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.UpgradeResultDetail;
import java.util.List;
/* renamed from: com.fimi.soul.b.h */
/* loaded from: classes.dex */
public class C2344h extends BaseAdapter {

    /* renamed from: a */
    private Context f7876a;

    /* renamed from: b */
    private List<UpgradeResultDetail> f7877b;

    /* renamed from: com.fimi.soul.b.h$a */
    /* loaded from: classes.dex */
    class C2345a {

        /* renamed from: a */
        TextView f7878a;

        /* renamed from: b */
        TextView f7879b;

        /* renamed from: c */
        View f7880c;

        /* renamed from: d */
        ImageView f7881d;

        C2345a() {
        }
    }

    public C2344h(Context context, List<UpgradeResultDetail> list) {
        this.f7876a = context;
        this.f7877b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7877b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7877b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2345a c2345a;
        if (view == null) {
            c2345a = new C2345a();
            view = LayoutInflater.from(this.f7876a).inflate(C2300R.layout.list_update_result_item, (ViewGroup) null);
            c2345a.f7878a = (TextView) view.findViewById(C2300R.C2302id.time);
            c2345a.f7879b = (TextView) view.findViewById(C2300R.C2302id.info_tv);
            c2345a.f7880c = view.findViewById(C2300R.C2302id.divider);
            c2345a.f7881d = (ImageView) view.findViewById(C2300R.C2302id.info_tv2);
            view.setTag(c2345a);
        } else {
            c2345a = (C2345a) view.getTag();
        }
        c2345a.f7879b.setText(this.f7877b.get(i).getDetail());
        c2345a.f7881d.setImageResource(this.f7877b.get(i).getImg());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
