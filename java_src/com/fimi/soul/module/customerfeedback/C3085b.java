package com.fimi.soul.module.customerfeedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.util.List;
/* renamed from: com.fimi.soul.module.customerfeedback.b */
/* loaded from: classes.dex */
public class C3085b<T> extends AbstractC3089d<T> {

    /* renamed from: com.fimi.soul.module.customerfeedback.b$a */
    /* loaded from: classes.dex */
    class C3086a {

        /* renamed from: a */
        TextView f11542a;

        C3086a() {
        }
    }

    public C3085b(List<T> list, Context context) {
        this.f11551a = list;
        this.f11552b = context;
    }

    @Override // com.fimi.soul.module.customerfeedback.AbstractC3089d
    /* renamed from: a */
    View mo9690a(int i, View view, ViewGroup viewGroup) {
        C3086a c3086a;
        if (view == null) {
            view = LayoutInflater.from(this.f11552b).inflate(C2300R.layout.navigation_item_adapter, (ViewGroup) null);
            c3086a = new C3086a();
            c3086a.f11542a = (TextView) view.findViewById(C2300R.C2302id.head_name);
            view.setTag(c3086a);
        } else {
            c3086a = (C3086a) view.getTag();
        }
        T t = this.f11551a.get(i);
        if (t instanceof String) {
            c3086a.f11542a.setText((String) t);
        }
        return view;
    }

    /* renamed from: a */
    public void m9693a(List<T> list) {
        this.f11551a = list;
    }
}
