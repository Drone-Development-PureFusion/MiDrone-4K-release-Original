package com.fimi.soul.p167b;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.Describehistor;
import com.fimi.soul.utils.C3630aa;
import java.util.List;
/* renamed from: com.fimi.soul.b.a */
/* loaded from: classes.dex */
public class C2311a extends BaseAdapter {

    /* renamed from: a */
    SharedPreferences f7707a;

    /* renamed from: b */
    private Context f7708b;

    /* renamed from: c */
    private List<Describehistor> f7709c;

    /* renamed from: com.fimi.soul.b.a$a */
    /* loaded from: classes.dex */
    class C2312a {

        /* renamed from: a */
        TextView f7710a;

        /* renamed from: b */
        TextView f7711b;

        /* renamed from: c */
        TextView f7712c;

        /* renamed from: d */
        SimpleDraweeView f7713d;

        C2312a() {
        }
    }

    public C2311a(Context context) {
        this.f7708b = context;
        this.f7707a = context.getSharedPreferences("imagehead", 0);
    }

    /* renamed from: a */
    public void m12611a() {
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m12610a(List<Describehistor> list) {
        this.f7709c = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7709c == null) {
            return 0;
        }
        return this.f7709c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f7709c == null) {
            return null;
        }
        return this.f7709c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2312a c2312a;
        Describehistor describehistor = this.f7709c.get(i);
        if (this.f7707a != null && describehistor.getUserID().equals(this.f7707a.getString("name", ""))) {
            describehistor.setUserImgUrl(this.f7707a.getString(describehistor.getUserID(), ""));
        }
        if (view == null) {
            view = LayoutInflater.from(this.f7708b).inflate(C2300R.layout.describehistoryitem, (ViewGroup) null);
            C2312a c2312a2 = new C2312a();
            c2312a2.f7711b = (TextView) view.findViewById(C2300R.C2302id.nickname);
            c2312a2.f7710a = (TextView) view.findViewById(C2300R.C2302id.listnum);
            c2312a2.f7712c = (TextView) view.findViewById(C2300R.C2302id.flytimedescribe);
            c2312a2.f7713d = (SimpleDraweeView) view.findViewById(C2300R.C2302id.imageView1);
            view.setTag(c2312a2);
            c2312a = c2312a2;
        } else {
            c2312a = (C2312a) view.getTag();
        }
        c2312a.f7711b.setText(describehistor.getName());
        c2312a.f7710a.setText((i + 1) + "");
        c2312a.f7712c.setText(C2275t.m12793a(describehistor.getSumTime() / 60.0d, 2) + "Hrs");
        C3630aa.m7744a(c2312a.f7713d, describehistor.getUserImgUrl());
        return view;
    }
}
