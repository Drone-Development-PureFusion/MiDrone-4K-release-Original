package com.fimi.soul.view.horizontallistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fimi.soul.C2300R;
/* renamed from: com.fimi.soul.view.horizontallistview.a */
/* loaded from: classes.dex */
public class C3827a extends BaseAdapter {

    /* renamed from: a */
    Bitmap f16014a;

    /* renamed from: b */
    private String[] f16015b;

    /* renamed from: c */
    private Context f16016c;

    /* renamed from: d */
    private LayoutInflater f16017d;

    /* renamed from: e */
    private int f16018e = -1;

    /* renamed from: f */
    private int f16019f;

    /* renamed from: g */
    private int f16020g;

    /* renamed from: h */
    private int f16021h;

    /* renamed from: i */
    private int f16022i;

    /* renamed from: com.fimi.soul.view.horizontallistview.a$a */
    /* loaded from: classes.dex */
    private static class C3829a {

        /* renamed from: a */
        private TextView f16023a;

        private C3829a() {
        }
    }

    public C3827a(Context context, String[] strArr) {
        this.f16016c = context;
        this.f16015b = strArr;
        this.f16019f = context.getResources().getColor(C2300R.color.drone_tab_gray_color);
        this.f16021h = context.getResources().getColor(C2300R.color.setting_content);
        this.f16020g = context.getResources().getColor(C2300R.color.black_80);
        this.f16022i = context.getResources().getColor(C2300R.color.white_blance_select);
        this.f16017d = (LayoutInflater) this.f16016c.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public int m6930a() {
        return this.f16018e;
    }

    /* renamed from: a */
    public void m6929a(int i) {
        this.f16018e = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16015b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3829a c3829a;
        if (view == null) {
            C3829a c3829a2 = new C3829a();
            view = this.f16017d.inflate(C2300R.layout.white_blance_horizontal_list_item, (ViewGroup) null);
            c3829a2.f16023a = (TextView) view.findViewById(C2300R.C2302id.text_list_item);
            view.setTag(c3829a2);
            c3829a = c3829a2;
        } else {
            c3829a = (C3829a) view.getTag();
        }
        if (i == this.f16018e) {
            view.setSelected(true);
            c3829a.f16023a.setTextColor(this.f16021h);
            c3829a.f16023a.setBackgroundResource(C2300R.C2301drawable.white_blance_bg2);
        } else {
            view.setSelected(false);
            c3829a.f16023a.setTextColor(this.f16019f);
            c3829a.f16023a.setBackgroundDrawable(null);
        }
        c3829a.f16023a.setText(this.f16015b[i]);
        return view;
    }
}
