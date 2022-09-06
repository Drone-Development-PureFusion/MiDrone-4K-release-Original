package com.fimi.soul.module.p206a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.util.List;
/* renamed from: com.fimi.soul.module.a.a */
/* loaded from: classes.dex */
public class C3033a extends BaseAdapter {

    /* renamed from: a */
    private List<C3046d> f11296a;

    /* renamed from: b */
    private LayoutInflater f11297b;

    /* renamed from: c */
    private int f11298c;

    /* renamed from: d */
    private int f11299d;

    /* renamed from: e */
    private int f11300e = -1;

    /* renamed from: com.fimi.soul.module.a.a$a */
    /* loaded from: classes.dex */
    class C3034a {

        /* renamed from: a */
        TextView f11301a;

        /* renamed from: b */
        TextView f11302b;

        /* renamed from: c */
        TextView f11303c;

        /* renamed from: d */
        RelativeLayout f11304d;

        C3034a() {
        }
    }

    public C3033a(Context context, List<C3046d> list) {
        this.f11298c = context.getResources().getColor(C2300R.color.camera_menu_item_text_color_sel);
        this.f11299d = context.getResources().getColor(C2300R.color.camera_menu_item_text_color_def);
        this.f11296a = list;
        this.f11297b = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void m9908a(int i) {
        this.f11300e = i;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m9907a(int i, String str) {
        if (this.f11296a == null || this.f11296a.size() <= 0) {
            return;
        }
        this.f11296a.get(i).m9866b(str);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m9906a(String[] strArr) {
        if (this.f11296a == null || this.f11296a.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                notifyDataSetChanged();
                return;
            }
            if (this.f11296a.get(i2).m9864c()) {
                this.f11296a.get(i2).m9866b(strArr[i2]);
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11296a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11296a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3034a c3034a;
        boolean z = true;
        C3046d c3046d = (C3046d) getItem(i);
        if (view == null) {
            C3034a c3034a2 = new C3034a();
            view = this.f11297b.inflate(C2300R.layout.camera_menu_list_item, (ViewGroup) null);
            c3034a2.f11301a = (TextView) view.findViewById(C2300R.C2302id.tv_lv_item_tag);
            c3034a2.f11302b = (TextView) view.findViewById(C2300R.C2302id.tv_lv_item_value);
            c3034a2.f11304d = (RelativeLayout) view.findViewById(C2300R.C2302id.rl);
            view.setTag(c3034a2);
            c3034a = c3034a2;
        } else {
            c3034a = (C3034a) view.getTag();
        }
        if (c3046d.m9863d()) {
            c3034a.f11301a.setVisibility(8);
            c3034a.f11302b.setVisibility(8);
            c3034a.f11303c.setVisibility(0);
            c3034a.f11303c.setText(c3046d.m9870a());
            c3034a.f11304d.setClickable(!c3046d.m9864c());
        } else {
            c3034a.f11301a.setVisibility(0);
            c3034a.f11302b.setVisibility(0);
            c3034a.f11303c.setVisibility(8);
            c3034a.f11301a.setText(c3046d.m9870a());
            c3034a.f11302b.setText(c3046d.m9867b());
            if (c3046d.m9864c()) {
                RelativeLayout relativeLayout = c3034a.f11304d;
                if (c3046d.m9864c()) {
                    z = false;
                }
                relativeLayout.setClickable(z);
                if (i == this.f11300e) {
                    c3034a.f11301a.setTextColor(this.f11298c);
                    c3034a.f11302b.setTextColor(this.f11298c);
                } else {
                    c3034a.f11301a.setTextColor(this.f11299d);
                    c3034a.f11302b.setTextColor(this.f11299d);
                }
            } else {
                RelativeLayout relativeLayout2 = c3034a.f11304d;
                if (c3046d.m9864c()) {
                    z = false;
                }
                relativeLayout2.setClickable(z);
            }
        }
        return view;
    }
}
