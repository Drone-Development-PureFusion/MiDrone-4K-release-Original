package com.fimi.soul.view.sliding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fimi.kernel.utils.C2271p;
/* loaded from: classes.dex */
public class FmTabItemView extends LinearLayout {

    /* renamed from: a */
    private Context f16455a;

    /* renamed from: b */
    private int f16456b;

    /* renamed from: c */
    private TextView f16457c;

    /* renamed from: d */
    private Drawable f16458d;

    /* renamed from: e */
    private Drawable f16459e;

    /* renamed from: f */
    private Drawable f16460f;

    /* renamed from: g */
    private Drawable f16461g;

    /* renamed from: h */
    private int f16462h;

    /* renamed from: i */
    private int f16463i;

    /* renamed from: j */
    private int f16464j;

    /* renamed from: k */
    private int f16465k;

    public FmTabItemView(Context context) {
        this(context, null);
    }

    public FmTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(17);
        setPadding(10, 10, 10, 10);
        this.f16455a = context;
        this.f16457c = new TextView(context);
        this.f16457c.setGravity(17);
        this.f16457c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f16457c.setFocusable(true);
        this.f16457c.setPadding(0, 0, 0, 0);
        this.f16457c.setCompoundDrawablePadding(10);
        this.f16457c.setSingleLine();
        addView(this.f16457c);
    }

    /* renamed from: a */
    public void m6711a(int i, int i2, int i3, int i4) {
        this.f16462h = C2271p.m12850e(this.f16455a, i);
        this.f16463i = C2271p.m12850e(this.f16455a, i2);
        this.f16464j = C2271p.m12850e(this.f16455a, i3);
        this.f16465k = C2271p.m12850e(this.f16455a, i4);
    }

    /* renamed from: a */
    public void m6710a(int i, String str) {
        this.f16456b = i;
        this.f16457c.setText(str);
    }

    /* renamed from: a */
    public void m6709a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.f16458d = drawable;
        this.f16459e = drawable2;
        this.f16460f = drawable3;
        this.f16461g = drawable4;
        if (this.f16458d != null) {
            this.f16458d.setBounds(this.f16462h, this.f16463i, this.f16464j, this.f16465k);
        }
        if (this.f16459e != null) {
            this.f16459e.setBounds(this.f16462h, this.f16463i, this.f16464j, this.f16465k);
        }
        if (this.f16460f != null) {
            this.f16460f.setBounds(this.f16462h, this.f16463i, this.f16464j, this.f16465k);
        }
        if (this.f16461g != null) {
            this.f16461g.setBounds(this.f16462h, this.f16463i, this.f16464j, this.f16465k);
        }
        this.f16457c.setCompoundDrawables(this.f16458d, this.f16459e, this.f16460f, this.f16461g);
    }

    public int getIndex() {
        return this.f16456b;
    }

    public TextView getTextView() {
        return this.f16457c;
    }

    public void setTabBackgroundDrawable(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setTabBackgroundResource(int i) {
        setBackgroundResource(i);
    }

    public void setTabTextColor(int i) {
        this.f16457c.setTextColor(i);
    }

    public void setTabTextSize(int i) {
        C2271p.m12855b(this.f16457c, i);
    }
}
