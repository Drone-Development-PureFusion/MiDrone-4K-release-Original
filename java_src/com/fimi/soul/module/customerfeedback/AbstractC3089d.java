package com.fimi.soul.module.customerfeedback;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
/* renamed from: com.fimi.soul.module.customerfeedback.d */
/* loaded from: classes.dex */
public abstract class AbstractC3089d<T> extends BaseAdapter {

    /* renamed from: a */
    protected List<T> f11551a;

    /* renamed from: b */
    protected Context f11552b;

    /* renamed from: a */
    abstract View mo9690a(int i, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f11551a == null) {
            return 0;
        }
        return this.f11551a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f11551a == null) {
            return null;
        }
        return this.f11551a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mo9690a(i, view, viewGroup);
    }
}
