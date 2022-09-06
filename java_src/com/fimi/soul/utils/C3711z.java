package com.fimi.soul.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
/* renamed from: com.fimi.soul.utils.z */
/* loaded from: classes.dex */
public class C3711z {

    /* renamed from: a */
    private Context f15143a;

    public C3711z(Context context) {
        this.f15143a = context;
    }

    /* renamed from: a */
    public Toast m7384a(int i) {
        View inflate = LayoutInflater.from(this.f15143a).inflate(i, (ViewGroup) null);
        Toast toast = new Toast(this.f15143a);
        toast.setGravity(53, 12, 40);
        toast.setDuration(1);
        toast.setView(inflate);
        return toast;
    }

    /* renamed from: a */
    public Toast m7383a(String str) {
        return Toast.makeText(this.f15143a, str, 0);
    }

    /* renamed from: a */
    public Toast m7382a(String str, Drawable drawable) {
        Toast makeText = Toast.makeText(this.f15143a, str, 1);
        makeText.setGravity(17, 0, 0);
        ImageView imageView = new ImageView(this.f15143a);
        imageView.setBackgroundDrawable(drawable);
        ((LinearLayout) makeText.getView()).addView(imageView, 0);
        return makeText;
    }
}
