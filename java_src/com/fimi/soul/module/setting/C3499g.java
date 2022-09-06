package com.fimi.soul.module.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.soul.module.setting.g */
/* loaded from: classes.dex */
public class C3499g extends BaseAdapter {

    /* renamed from: a */
    List<C3508h> f13804a;

    /* renamed from: b */
    Context f13805b;

    /* renamed from: c */
    ListView f13806c;

    /* renamed from: d */
    C3500a f13807d;

    /* renamed from: e */
    private boolean f13808e = false;

    /* renamed from: f */
    private boolean f13809f = false;

    /* renamed from: com.fimi.soul.module.setting.g$a */
    /* loaded from: classes.dex */
    class C3500a {

        /* renamed from: a */
        TextView f13810a;

        /* renamed from: b */
        ImageView f13811b;

        C3500a() {
        }
    }

    public C3499g(Context context, List<C3508h> list) {
        this.f13805b = context;
        this.f13804a = list;
    }

    /* renamed from: a */
    public void m8236a(int i) {
        if (this.f13804a != null) {
            for (C3508h c3508h : this.f13804a) {
                c3508h.m8194a(false);
            }
            this.f13804a.get(i).m8194a(true);
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m8235a(boolean z) {
        this.f13809f = z;
    }

    /* renamed from: b */
    public void m8234b(boolean z) {
        this.f13808e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f13804a != null) {
            return this.f13804a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f13804a != null) {
            return this.f13804a.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        this.f13806c = (ListView) viewGroup;
        if (view == null) {
            this.f13807d = new C3500a();
            view = LinearLayout.inflate(this.f13805b, C2300R.layout.roller_setting_item, null);
            this.f13807d.f13811b = (ImageView) view.findViewById(C2300R.C2302id.item_icon);
            this.f13807d.f13810a = (TextView) view.findViewById(C2300R.C2302id.item_name);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) this.f13805b.getResources().getDimension(C2300R.dimen.setting_adapt_height)));
            view.setTag(this.f13807d);
            C3658ar.m7612a(this.f13805b.getAssets(), this.f13807d.f13810a);
        } else {
            this.f13807d = (C3500a) view.getTag();
        }
        this.f13807d.f13810a.setText(this.f13804a.get(i).m8196a());
        if (this.f13804a.get(i).m8193b()) {
            this.f13807d.f13811b.setVisibility(0);
            this.f13807d.f13810a.setSelected(true);
        } else {
            this.f13807d.f13811b.setVisibility(4);
            this.f13807d.f13810a.setSelected(false);
        }
        if (this.f13809f) {
            this.f13807d.f13810a.setTextColor(this.f13805b.getResources().getColor(C2300R.color.setting_ash));
        } else if (i != 2 && this.f13808e) {
            this.f13807d.f13810a.setTextColor(this.f13805b.getResources().getColor(C2300R.color.setting_ash));
        } else if (!this.f13808e && i == 2) {
            this.f13807d.f13810a.setTextColor(this.f13805b.getResources().getColor(C2300R.color.setting_ash));
        }
        return view;
    }
}
