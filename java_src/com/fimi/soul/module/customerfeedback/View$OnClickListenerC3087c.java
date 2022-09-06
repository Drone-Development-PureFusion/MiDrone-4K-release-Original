package com.fimi.soul.module.customerfeedback;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3630aa;
import java.util.LinkedList;
/* renamed from: com.fimi.soul.module.customerfeedback.c */
/* loaded from: classes.dex */
public class View$OnClickListenerC3087c extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a */
    LinkedList<Object> f11544a;

    /* renamed from: b */
    private Context f11545b;

    /* renamed from: c */
    private int f11546c;

    /* renamed from: d */
    private int f11547d;

    /* renamed from: com.fimi.soul.module.customerfeedback.c$a */
    /* loaded from: classes.dex */
    class C3088a {

        /* renamed from: a */
        SimpleDraweeView f11548a;

        /* renamed from: b */
        ImageView f11549b;

        C3088a() {
        }
    }

    public View$OnClickListenerC3087c(LinkedList<Object> linkedList, Context context) {
        this.f11544a = linkedList;
        this.f11545b = context;
        m9692a();
    }

    /* renamed from: a */
    private void m9692a() {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f11545b.getResources(), C2300R.C2301drawable.add_images_box);
        this.f11546c = decodeResource.getWidth();
        this.f11547d = decodeResource.getHeight();
        if (decodeResource.isRecycled()) {
            decodeResource.recycle();
        }
    }

    /* renamed from: a */
    public void m9691a(LinkedList<Object> linkedList) {
        this.f11544a = linkedList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f11544a == null) {
            return 0;
        }
        return this.f11544a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f11544a == null) {
            return null;
        }
        return this.f11544a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3088a c3088a;
        if (view == null) {
            view = LayoutInflater.from(this.f11545b).inflate(C2300R.layout.add_feedback_item_adapter, (ViewGroup) null);
            c3088a = new C3088a();
            c3088a.f11548a = (SimpleDraweeView) view.findViewById(C2300R.C2302id.add_feedback_pic);
            c3088a.f11549b = (ImageView) view.findViewById(C2300R.C2302id.delete_feedback_pic);
            c3088a.f11549b.setOnClickListener(this);
            view.setTag(c3088a);
            c3088a.f11548a.getLayoutParams().height = this.f11547d;
            c3088a.f11548a.getLayoutParams().width = this.f11546c;
        } else {
            c3088a = (C3088a) view.getTag();
        }
        Object obj = this.f11544a.get(i);
        if (obj != null) {
            if (obj instanceof Uri) {
                Uri uri = (Uri) obj;
                c3088a.f11549b.setTag(new Integer(i));
                C3630aa.m7744a(c3088a.f11548a, uri.toString());
                C3083a.m9700a().m9699a(uri);
                c3088a.f11549b.setVisibility(0);
            } else if (obj instanceof Integer) {
                c3088a.f11548a.setImageResource(((Integer) obj).intValue());
                c3088a.f11549b.setVisibility(8);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (this.f11544a == null || num.intValue() >= this.f11544a.size()) {
                return;
            }
            Object obj = this.f11544a.get(num.intValue());
            if (!this.f11544a.contains(obj)) {
                return;
            }
            this.f11544a.remove(obj);
            m9691a(this.f11544a);
        }
    }
}
