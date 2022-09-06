package com.fimi.soul.module.setting.newhand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.util.ArrayList;
/* renamed from: com.fimi.soul.module.setting.newhand.f */
/* loaded from: classes.dex */
public class C3546f {

    /* renamed from: a */
    View f14238a;

    /* renamed from: b */
    ListView f14239b;

    /* renamed from: c */
    ArrayList<String> f14240c;

    /* renamed from: d */
    PopupWindow f14241d;

    /* renamed from: e */
    C3549g f14242e;

    /* renamed from: f */
    TextView f14243f;

    /* renamed from: g */
    AbstractC3548a f14244g;

    /* renamed from: h */
    AdapterView.OnItemClickListener f14245h = new AdapterView.OnItemClickListener() { // from class: com.fimi.soul.module.setting.newhand.f.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3546f.this.f14244g.m8104a(i);
            if (C3546f.this.f14241d != null) {
                C3546f.this.f14241d.dismiss();
                C3546f.this.f14241d = null;
            }
        }
    };

    /* renamed from: com.fimi.soul.module.setting.newhand.f$a */
    /* loaded from: classes.dex */
    public interface AbstractC3548a {
        /* renamed from: a */
        void m8104a(int i);
    }

    /* renamed from: a */
    public void m8105a(TextView textView, Context context, int i, AbstractC3548a abstractC3548a) {
        this.f14243f = textView;
        this.f14244g = abstractC3548a;
        this.f14238a = LayoutInflater.from(context).inflate(C2300R.layout.listview_newhand, (ViewGroup) null);
        this.f14239b = (ListView) this.f14238a.findViewById(C2300R.C2302id.lv_group);
        this.f14240c = new ArrayList<>();
        this.f14240c.add(context.getString(C2300R.C2303string.new_driver_mode));
        this.f14240c.add(context.getString(C2300R.C2303string.normal_driver_model));
        this.f14242e = new C3549g(context, this.f14240c);
        this.f14242e.m8103a(i);
        this.f14239b.setAdapter((ListAdapter) this.f14242e);
        this.f14241d = new PopupWindow(this.f14238a, -2, -2);
        this.f14241d.setBackgroundDrawable(context.getResources().getDrawable(C2300R.C2301drawable.radio));
        this.f14241d.setFocusable(true);
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        this.f14241d.showAtLocation(textView, 0, iArr[0], iArr[1]);
        this.f14239b.setOnItemClickListener(this.f14245h);
    }
}
