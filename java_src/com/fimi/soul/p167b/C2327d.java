package com.fimi.soul.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.soul.b.d */
/* loaded from: classes.dex */
public class C2327d extends BaseAdapter {

    /* renamed from: a */
    List<FirmwareInfo> f7794a;

    /* renamed from: b */
    private Context f7795b;

    /* renamed from: com.fimi.soul.b.d$a */
    /* loaded from: classes.dex */
    class C2328a {

        /* renamed from: a */
        TextView f7796a;

        /* renamed from: b */
        TextView f7797b;

        /* renamed from: c */
        View f7798c;

        C2328a() {
        }
    }

    public C2327d(Context context, List<FirmwareInfo> list) {
        this.f7794a = null;
        this.f7795b = context;
        this.f7794a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7794a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7794a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2328a c2328a;
        if (view == null) {
            C2328a c2328a2 = new C2328a();
            view = LayoutInflater.from(this.f7795b).inflate(C2300R.layout.list_firmware_info_item, (ViewGroup) null);
            c2328a2.f7796a = (TextView) view.findViewById(C2300R.C2302id.serial);
            c2328a2.f7797b = (TextView) view.findViewById(C2300R.C2302id.info_tv);
            c2328a2.f7798c = view.findViewById(C2300R.C2302id.divider);
            C3658ar.m7612a(this.f7795b.getAssets(), c2328a2.f7796a);
            C3658ar.m7612a(this.f7795b.getAssets(), c2328a2.f7797b);
            c2328a2.f7797b.setTag(Integer.valueOf(i));
            view.setTag(c2328a2);
            c2328a = c2328a2;
        } else {
            c2328a = (C2328a) view.getTag();
        }
        c2328a.f7796a.setText("" + (i + 1));
        c2328a.f7797b.setText(this.f7794a.get(i).getSysName() + ":" + this.f7794a.get(i).getUpdcontents());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
