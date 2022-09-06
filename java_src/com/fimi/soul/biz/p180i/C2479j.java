package com.fimi.soul.biz.p180i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.util.ArrayList;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.fimi.soul.biz.i.j */
/* loaded from: classes.dex */
public class C2479j {

    /* renamed from: a */
    private static BitmapDescriptor f8552a;

    /* renamed from: a */
    public static BitmapDescriptor m12014a(int i) {
        f8552a = BitmapDescriptorFactory.fromResource(i);
        return f8552a;
    }

    /* renamed from: a */
    public static BitmapDescriptor m12013a(Context context, int i, int i2, boolean z) {
        View inflate = LayoutInflater.from(context).inflate(C2300R.layout.action_markericon, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.point_heightValue);
        textView.setText(i2 + C0413a.f922b);
        if (z) {
            textView.setTextColor(context.getResources().getColor(C2300R.color.onmarker_color));
        } else {
            textView.setTextColor(context.getResources().getColor(C2300R.color.mystyle_markerinfo));
        }
        C3658ar.m7598b(context.getAssets(), textView);
        ImageView imageView = (ImageView) inflate.findViewById(C2300R.C2302id.markerIcon);
        if (i != 0) {
            imageView.setBackgroundResource(i);
        }
        return BitmapDescriptorFactory.fromView(inflate);
    }

    /* renamed from: a */
    public static ArrayList<BitmapDescriptor> m12012a(Context context, int i, boolean z, int i2, int i3) {
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        arrayList.add(m12011b(context, i2, i, z));
        arrayList.add(m12011b(context, i3, i, z));
        return arrayList;
    }

    /* renamed from: a */
    public static void m12015a() {
        if (f8552a != null) {
            f8552a.recycle();
        }
    }

    /* renamed from: b */
    public static BitmapDescriptor m12011b(Context context, int i, int i2, boolean z) {
        View inflate = LayoutInflater.from(context).inflate(C2300R.layout.action_markericon_animation, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.point_heightValue);
        textView.setText(i2 + C0413a.f922b);
        if (z) {
            textView.setTextColor(context.getResources().getColor(C2300R.color.onmarker_color));
        } else {
            textView.setTextColor(context.getResources().getColor(C2300R.color.mystyle_markerinfo));
        }
        C3658ar.m7598b(context.getAssets(), textView);
        ImageView imageView = (ImageView) inflate.findViewById(C2300R.C2302id.markerIcon);
        if (i != 0) {
            imageView.setBackgroundResource(i);
        }
        return BitmapDescriptorFactory.fromView(inflate);
    }
}
