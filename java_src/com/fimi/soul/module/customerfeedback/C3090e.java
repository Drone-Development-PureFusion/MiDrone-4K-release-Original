package com.fimi.soul.module.customerfeedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.util.List;
/* renamed from: com.fimi.soul.module.customerfeedback.e */
/* loaded from: classes.dex */
public class C3090e<T> extends AbstractC3089d<T> {

    /* renamed from: com.fimi.soul.module.customerfeedback.e$a */
    /* loaded from: classes.dex */
    class C3091a {

        /* renamed from: a */
        TextView f11553a;

        C3091a() {
        }
    }

    public C3090e(List<T> list, Context context) {
        this.f11551a = list;
        this.f11552b = context;
    }

    @Override // com.fimi.soul.module.customerfeedback.AbstractC3089d
    /* renamed from: a */
    View mo9690a(int i, View view, ViewGroup viewGroup) {
        C3091a c3091a;
        if (view == null) {
            view = LayoutInflater.from(this.f11552b).inflate(C2300R.layout.navigation_item_adapter, (ViewGroup) null);
            c3091a = new C3091a();
            c3091a.f11553a = (TextView) view.findViewById(C2300R.C2302id.head_name);
            view.setTag(c3091a);
        } else {
            c3091a = (C3091a) view.getTag();
        }
        T t = this.f11551a.get(i);
        if (t instanceof String) {
            c3091a.f11553a.setText((String) t);
        }
        return view;
    }
}
