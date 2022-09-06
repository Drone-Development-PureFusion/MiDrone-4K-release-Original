package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BadgeView extends TextView {

    /* renamed from: a */
    public static final int f15158a = 1;

    /* renamed from: b */
    public static final int f15159b = 2;

    /* renamed from: c */
    public static final int f15160c = 3;

    /* renamed from: d */
    public static final int f15161d = 4;

    /* renamed from: e */
    public static final int f15162e = 5;

    /* renamed from: f */
    public static final int f15163f = 10;

    /* renamed from: g */
    private static final int f15164g = 5;

    /* renamed from: h */
    private static final int f15165h = 5;

    /* renamed from: i */
    private static final int f15166i = 8;

    /* renamed from: j */
    private static final int f15167j = 2;

    /* renamed from: k */
    private static final int f15168k = Color.parseColor("#CCFF0000");

    /* renamed from: l */
    private static final int f15169l = -1;

    /* renamed from: m */
    private static Animation f15170m;

    /* renamed from: n */
    private static Animation f15171n;

    /* renamed from: o */
    private Context f15172o;

    /* renamed from: p */
    private View f15173p;

    /* renamed from: q */
    private int f15174q;

    /* renamed from: r */
    private int f15175r;

    /* renamed from: s */
    private int f15176s;

    /* renamed from: t */
    private int f15177t;

    /* renamed from: u */
    private boolean f15178u;

    /* renamed from: v */
    private ShapeDrawable f15179v;

    /* renamed from: w */
    private int f15180w;

    public BadgeView(Context context) {
        this(context, (AttributeSet) null, 16842884);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 0);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i, View view, int i2) {
        super(context, attributeSet, i);
        m7374a(context, view, i2);
    }

    public BadgeView(Context context, View view) {
        this(context, null, 16842884, view, 0);
    }

    public BadgeView(Context context, TabWidget tabWidget, int i) {
        this(context, null, 16842884, tabWidget, i);
    }

    /* renamed from: a */
    private void m7374a(Context context, View view, int i) {
        this.f15172o = context;
        this.f15173p = view;
        this.f15180w = i;
        this.f15174q = 2;
        this.f15175r = m7361c(5);
        this.f15176s = this.f15175r;
        this.f15177t = f15168k;
        setTypeface(Typeface.DEFAULT_BOLD);
        int m7361c = m7361c(5);
        setPadding(m7361c, 0, m7361c, 0);
        setTextColor(-1);
        f15170m = new AlphaAnimation(0.0f, 1.0f);
        f15170m.setInterpolator(new DecelerateInterpolator());
        f15170m.setDuration(500L);
        f15171n = new AlphaAnimation(1.0f, 0.0f);
        f15171n.setInterpolator(new AccelerateInterpolator());
        f15171n.setDuration(500L);
        this.f15178u = false;
        if (this.f15173p != null) {
            m7373a(this.f15173p);
        } else {
            m7377a();
        }
    }

    /* renamed from: a */
    private void m7373a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = new FrameLayout(this.f15172o);
        if (view instanceof TabWidget) {
            View childTabViewAt = ((TabWidget) view).getChildTabViewAt(this.f15180w);
            this.f15173p = childTabViewAt;
            ((ViewGroup) childTabViewAt).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            setVisibility(8);
            frameLayout.addView(this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(frameLayout, indexOfChild, layoutParams);
        frameLayout.addView(view);
        setVisibility(8);
        frameLayout.addView(this);
        viewGroup.invalidate();
    }

    /* renamed from: a */
    private void m7369a(boolean z, Animation animation) {
        if (getBackground() == null) {
            if (this.f15179v == null) {
                this.f15179v = getDefaultBackground();
            }
            setBackgroundDrawable(this.f15179v);
        }
        m7359d();
        if (z) {
            startAnimation(animation);
        }
        setVisibility(0);
        this.f15178u = true;
    }

    /* renamed from: a */
    private void m7368a(boolean z, Animation animation, Animation animation2) {
        boolean z2 = true;
        if (this.f15178u) {
            if (!z || animation2 == null) {
                z2 = false;
            }
            m7363b(z2, animation2);
            return;
        }
        if (!z || animation == null) {
            z2 = false;
        }
        m7369a(z2, animation);
    }

    /* renamed from: b */
    private void m7363b(boolean z, Animation animation) {
        setVisibility(8);
        if (z) {
            startAnimation(animation);
        }
        this.f15178u = false;
    }

    /* renamed from: c */
    private int m7361c(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    /* renamed from: d */
    private void m7359d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        switch (this.f15174q) {
            case 1:
                layoutParams.gravity = 51;
                layoutParams.setMargins(this.f15175r, this.f15176s, 0, 0);
                break;
            case 2:
                layoutParams.gravity = 53;
                layoutParams.setMargins(0, this.f15176s, this.f15175r, 0);
                break;
            case 3:
                layoutParams.gravity = 83;
                layoutParams.setMargins(this.f15175r, 0, 0, this.f15176s);
                break;
            case 4:
                layoutParams.gravity = 85;
                layoutParams.setMargins(0, 0, this.f15175r, this.f15176s);
                break;
            case 5:
                layoutParams.gravity = 17;
                layoutParams.setMargins(0, 0, 0, 0);
                break;
            case 10:
                layoutParams.gravity = 17;
                layoutParams.setMargins(this.f15175r, 0, 0, 0);
                break;
        }
        setLayoutParams(layoutParams);
    }

    private ShapeDrawable getDefaultBackground() {
        int m7361c = m7361c(8);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{m7361c, m7361c, m7361c, m7361c, m7361c, m7361c, m7361c, m7361c}, null, null));
        shapeDrawable.getPaint().setColor(this.f15177t);
        return shapeDrawable;
    }

    /* renamed from: a */
    public int m7376a(int i) {
        int i2 = 0;
        CharSequence text = getText();
        if (text != null) {
            try {
                i2 = Integer.parseInt(text.toString());
            } catch (NumberFormatException e) {
            }
        }
        int i3 = i2 + i;
        setText(String.valueOf(i3));
        return i3;
    }

    /* renamed from: a */
    public void m7377a() {
        m7369a(false, (Animation) null);
    }

    /* renamed from: a */
    public void m7375a(int i, int i2) {
        this.f15175r = i;
        this.f15176s = i2;
    }

    /* renamed from: a */
    public void m7372a(Animation animation) {
        m7369a(true, animation);
    }

    /* renamed from: a */
    public void m7371a(Animation animation, Animation animation2) {
        m7368a(true, animation, animation2);
    }

    /* renamed from: a */
    public void m7370a(boolean z) {
        m7369a(z, f15170m);
    }

    /* renamed from: b */
    public int m7366b(int i) {
        return m7376a(-i);
    }

    /* renamed from: b */
    public void m7367b() {
        m7363b(false, null);
    }

    /* renamed from: b */
    public void m7365b(Animation animation) {
        m7363b(true, animation);
    }

    /* renamed from: b */
    public void m7364b(boolean z) {
        m7363b(z, f15171n);
    }

    /* renamed from: c */
    public void m7362c() {
        m7368a(false, (Animation) null, (Animation) null);
    }

    /* renamed from: c */
    public void m7360c(boolean z) {
        m7368a(z, f15170m, f15171n);
    }

    public int getBadgeBackgroundColor() {
        return this.f15177t;
    }

    public int getBadgePosition() {
        return this.f15174q;
    }

    public int getHorizontalBadgeMargin() {
        return this.f15175r;
    }

    public View getTarget() {
        return this.f15173p;
    }

    public int getVerticalBadgeMargin() {
        return this.f15176s;
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.f15178u;
    }

    public void setBadgeBackgroundColor(int i) {
        this.f15177t = i;
        this.f15179v = getDefaultBackground();
    }

    public void setBadgeMargin(int i) {
        this.f15175r = i;
        this.f15176s = i;
    }

    public void setBadgePosition(int i) {
        this.f15174q = i;
    }
}
