package com.fimi.soul.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.soul.b.i */
/* loaded from: classes.dex */
public class C2346i extends BaseAdapter {

    /* renamed from: a */
    List<UpdateVersonBean> f7883a;

    /* renamed from: b */
    private Context f7884b;

    /* renamed from: com.fimi.soul.b.i$a */
    /* loaded from: classes.dex */
    class C2347a {

        /* renamed from: a */
        TextView f7885a;

        /* renamed from: b */
        TextView f7886b;

        /* renamed from: c */
        View f7887c;

        C2347a() {
        }
    }

    public C2346i(Context context, List<UpdateVersonBean> list) {
        this.f7883a = null;
        this.f7884b = context;
        this.f7883a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7883a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7883a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2347a c2347a;
        if (view == null) {
            C2347a c2347a2 = new C2347a();
            view = LayoutInflater.from(this.f7884b).inflate(C2300R.layout.list_firmware_info_item, (ViewGroup) null);
            c2347a2.f7885a = (TextView) view.findViewById(C2300R.C2302id.serial);
            c2347a2.f7886b = (TextView) view.findViewById(C2300R.C2302id.info_tv);
            c2347a2.f7887c = view.findViewById(C2300R.C2302id.divider);
            C3658ar.m7612a(this.f7884b.getAssets(), c2347a2.f7885a);
            C3658ar.m7612a(this.f7884b.getAssets(), c2347a2.f7886b);
            c2347a2.f7886b.setTag(Integer.valueOf(i));
            view.setTag(c2347a2);
            c2347a = c2347a2;
        } else {
            c2347a = (C2347a) view.getTag();
        }
        c2347a.f7885a.setText("" + (i + 1));
        c2347a.f7886b.setText(this.f7883a.get(i).getSysname() + ":" + this.f7883a.get(i).getUpdcontents());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
