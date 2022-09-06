package com.fimi.kernel.view.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.p001v4.view.MarginLayoutParamsCompat;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fimi.kernel.C2168R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.kernel.view.percent.a */
/* loaded from: classes.dex */
public class C2296a {

    /* renamed from: a */
    private static final String f7659a = "PercentLayout";

    /* renamed from: c */
    private static final String f7660c = "^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)%([wh]?)$";

    /* renamed from: b */
    private final ViewGroup f7661b;

    /* renamed from: com.fimi.kernel.view.percent.a$a */
    /* loaded from: classes.dex */
    public static class C2297a {

        /* renamed from: a */
        public C2298a f7662a;

        /* renamed from: b */
        public C2298a f7663b;

        /* renamed from: c */
        public C2298a f7664c;

        /* renamed from: d */
        public C2298a f7665d;

        /* renamed from: e */
        public C2298a f7666e;

        /* renamed from: f */
        public C2298a f7667f;

        /* renamed from: g */
        public C2298a f7668g;

        /* renamed from: h */
        public C2298a f7669h;

        /* renamed from: i */
        public C2298a f7670i;

        /* renamed from: j */
        public C2298a f7671j;

        /* renamed from: k */
        public C2298a f7672k;

        /* renamed from: l */
        public C2298a f7673l;

        /* renamed from: m */
        public C2298a f7674m;

        /* renamed from: n */
        public C2298a f7675n;

        /* renamed from: o */
        public C2298a f7676o;

        /* renamed from: p */
        public C2298a f7677p;

        /* renamed from: q */
        public C2298a f7678q;

        /* renamed from: r */
        final ViewGroup.MarginLayoutParams f7679r = new ViewGroup.MarginLayoutParams(0, 0);

        /* renamed from: com.fimi.kernel.view.percent.a$a$a */
        /* loaded from: classes.dex */
        public static class C2298a {

            /* renamed from: a */
            public float f7680a;

            /* renamed from: b */
            public boolean f7681b;

            public C2298a() {
                this.f7680a = -1.0f;
            }

            public C2298a(float f, boolean z) {
                this.f7680a = -1.0f;
                this.f7680a = f;
                this.f7681b = z;
            }

            public String toString() {
                return "PercentVal{percent=" + this.f7680a + ", isBaseWidth=" + this.f7681b + C0359h.f726w;
            }
        }

        /* renamed from: a */
        public void m12630a(ViewGroup.LayoutParams layoutParams) {
            layoutParams.width = this.f7679r.width;
            layoutParams.height = this.f7679r.height;
        }

        /* renamed from: a */
        public void m12629a(ViewGroup.LayoutParams layoutParams, int i, int i2) {
            this.f7679r.width = layoutParams.width;
            this.f7679r.height = layoutParams.height;
            if (this.f7662a != null) {
                layoutParams.width = (int) ((this.f7662a.f7681b ? i : i2) * this.f7662a.f7680a);
            }
            if (this.f7663b != null) {
                if (!this.f7663b.f7681b) {
                    i = i2;
                }
                layoutParams.height = (int) (i * this.f7663b.f7680a);
            }
        }

        /* renamed from: a */
        public void m12628a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            m12630a((ViewGroup.LayoutParams) marginLayoutParams);
            marginLayoutParams.leftMargin = this.f7679r.leftMargin;
            marginLayoutParams.topMargin = this.f7679r.topMargin;
            marginLayoutParams.rightMargin = this.f7679r.rightMargin;
            marginLayoutParams.bottomMargin = this.f7679r.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, MarginLayoutParamsCompat.getMarginStart(this.f7679r));
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.f7679r));
        }

        /* renamed from: a */
        public void m12627a(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
            m12629a((ViewGroup.LayoutParams) marginLayoutParams, i, i2);
            this.f7679r.leftMargin = marginLayoutParams.leftMargin;
            this.f7679r.topMargin = marginLayoutParams.topMargin;
            this.f7679r.rightMargin = marginLayoutParams.rightMargin;
            this.f7679r.bottomMargin = marginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(this.f7679r, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(this.f7679r, MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams));
            if (this.f7664c != null) {
                marginLayoutParams.leftMargin = (int) ((this.f7664c.f7681b ? i : i2) * this.f7664c.f7680a);
            }
            if (this.f7665d != null) {
                marginLayoutParams.topMargin = (int) ((this.f7665d.f7681b ? i : i2) * this.f7665d.f7680a);
            }
            if (this.f7666e != null) {
                marginLayoutParams.rightMargin = (int) ((this.f7666e.f7681b ? i : i2) * this.f7666e.f7680a);
            }
            if (this.f7667f != null) {
                marginLayoutParams.bottomMargin = (int) ((this.f7667f.f7681b ? i : i2) * this.f7667f.f7680a);
            }
            if (this.f7668g != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, (int) ((this.f7668g.f7681b ? i : i2) * this.f7668g.f7680a));
            }
            if (this.f7669h != null) {
                if (!this.f7669h.f7681b) {
                    i = i2;
                }
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, (int) (i * this.f7669h.f7680a));
            }
            if (Log.isLoggable(C2296a.f7659a, 3)) {
                Log.d(C2296a.f7659a, "after fillMarginLayoutParams: (" + marginLayoutParams.width + ", " + marginLayoutParams.height + ")");
            }
        }

        public String toString() {
            return "PercentLayoutInfo{widthPercent=" + this.f7662a + ", heightPercent=" + this.f7663b + ", leftMarginPercent=" + this.f7664c + ", topMarginPercent=" + this.f7665d + ", rightMarginPercent=" + this.f7666e + ", bottomMarginPercent=" + this.f7667f + ", startMarginPercent=" + this.f7668g + ", endMarginPercent=" + this.f7669h + ", textSizePercent=" + this.f7670i + ", maxWidthPercent=" + this.f7671j + ", maxHeightPercent=" + this.f7672k + ", minWidthPercent=" + this.f7673l + ", minHeightPercent=" + this.f7674m + ", paddingLeftPercent=" + this.f7675n + ", paddingRightPercent=" + this.f7676o + ", paddingTopPercent=" + this.f7677p + ", paddingBottomPercent=" + this.f7678q + ", mPreservedParams=" + this.f7679r + C0359h.f726w;
        }
    }

    /* renamed from: com.fimi.kernel.view.percent.a$b */
    /* loaded from: classes.dex */
    public interface AbstractC2299b {
        /* renamed from: a */
        C2297a mo12626a();
    }

    public C2296a(ViewGroup viewGroup) {
        this.f7661b = viewGroup;
    }

    /* renamed from: a */
    private static C2297a.C2298a m12645a(TypedArray typedArray, int i, boolean z) {
        return m12639a(typedArray.getString(i), z);
    }

    /* renamed from: a */
    private static C2297a.C2298a m12639a(String str, boolean z) {
        boolean z2 = true;
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(f7660c).matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException("the value of layout_xxxPercent invalid! ==>" + str);
        }
        int length = str.length();
        String group = matcher.group(1);
        String substring = str.substring(length - 1);
        float parseFloat = Float.parseFloat(group) / 100.0f;
        if ((!z || substring.equals("h")) && !substring.equals("w")) {
            z2 = false;
        }
        return new C2297a.C2298a(parseFloat, z2);
    }

    /* renamed from: a */
    public static C2297a m12646a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2168R.styleable.PercentLayout_Layout);
        C2297a m12631e = m12631e(obtainStyledAttributes, m12633c(obtainStyledAttributes, m12636b(obtainStyledAttributes, m12632d(obtainStyledAttributes, m12644a(obtainStyledAttributes, (C2297a) null)))));
        Log.d(f7659a, "constructed: " + m12631e);
        obtainStyledAttributes.recycle();
        if (Log.isLoggable(f7659a, 3)) {
            Log.d(f7659a, "constructed: " + m12631e);
        }
        return m12631e;
    }

    /* renamed from: a */
    private static C2297a m12644a(TypedArray typedArray, C2297a c2297a) {
        C2297a.C2298a m12645a = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_widthPercent, true);
        if (m12645a != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent width: " + m12645a.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7662a = m12645a;
        }
        C2297a.C2298a m12645a2 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_heightPercent, false);
        if (m12645a2 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent height: " + m12645a2.f7680a);
            }
            C2297a m12641a = m12641a(c2297a);
            m12641a.f7663b = m12645a2;
            return m12641a;
        }
        return c2297a;
    }

    @NonNull
    /* renamed from: a */
    private static C2297a m12641a(C2297a c2297a) {
        return c2297a != null ? c2297a : new C2297a();
    }

    /* renamed from: a */
    private void m12647a(int i, int i2, View view, C2297a c2297a) {
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        C2297a.C2298a c2298a = c2297a.f7675n;
        if (c2298a != null) {
            paddingLeft = (int) ((c2298a.f7681b ? i : i2) * c2298a.f7680a);
        }
        C2297a.C2298a c2298a2 = c2297a.f7676o;
        if (c2298a2 != null) {
            paddingRight = (int) ((c2298a2.f7681b ? i : i2) * c2298a2.f7680a);
        }
        C2297a.C2298a c2298a3 = c2297a.f7677p;
        if (c2298a3 != null) {
            paddingTop = (int) ((c2298a3.f7681b ? i : i2) * c2298a3.f7680a);
        }
        C2297a.C2298a c2298a4 = c2297a.f7678q;
        if (c2298a4 != null) {
            if (!c2298a4.f7681b) {
                i = i2;
            }
            paddingBottom = (int) (i * c2298a4.f7680a);
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* renamed from: a */
    public static void m12642a(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    /* renamed from: a */
    private void m12640a(String str, int i, int i2, View view, Class cls, C2297a.C2298a c2298a) {
        if (c2298a != null) {
            Method method = cls.getMethod(str, Integer.TYPE);
            method.setAccessible(true);
            if (!c2298a.f7681b) {
                i = i2;
            }
            method.invoke(view, Integer.valueOf((int) (i * c2298a.f7680a)));
        }
    }

    /* renamed from: a */
    private static boolean m12643a(View view, C2297a c2297a) {
        return c2297a != null && c2297a.f7662a != null && c2297a.f7679r != null && (ViewCompat.getMeasuredWidthAndState(view) & ViewCompat.MEASURED_STATE_MASK) == 16777216 && c2297a.f7662a.f7680a >= 0.0f && c2297a.f7679r.width == -2;
    }

    /* renamed from: b */
    private static C2297a m12636b(TypedArray typedArray, C2297a c2297a) {
        C2297a.C2298a m12645a = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_textSizePercent, false);
        if (m12645a != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent text size: " + m12645a.f7680a);
            }
            C2297a m12641a = m12641a(c2297a);
            m12641a.f7670i = m12645a;
            return m12641a;
        }
        return c2297a;
    }

    /* renamed from: b */
    private void m12637b(int i, int i2, View view, C2297a c2297a) {
        try {
            Class<?> cls = view.getClass();
            m12640a("setMaxWidth", i, i2, view, cls, c2297a.f7671j);
            m12640a("setMaxHeight", i, i2, view, cls, c2297a.f7672k);
            m12640a("setMinWidth", i, i2, view, cls, c2297a.f7673l);
            m12640a("setMinHeight", i, i2, view, cls, c2297a.f7674m);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    private static boolean m12635b(View view, C2297a c2297a) {
        return c2297a != null && c2297a.f7663b != null && c2297a.f7679r != null && (ViewCompat.getMeasuredHeightAndState(view) & ViewCompat.MEASURED_STATE_MASK) == 16777216 && c2297a.f7663b.f7680a >= 0.0f && c2297a.f7679r.height == -2;
    }

    /* renamed from: c */
    private static C2297a m12633c(TypedArray typedArray, C2297a c2297a) {
        C2297a.C2298a m12645a = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_maxWidthPercent, true);
        if (m12645a != null) {
            m12641a(c2297a);
            c2297a.f7671j = m12645a;
        }
        C2297a.C2298a m12645a2 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_maxHeightPercent, false);
        if (m12645a2 != null) {
            m12641a(c2297a);
            c2297a.f7672k = m12645a2;
        }
        C2297a.C2298a m12645a3 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_minWidthPercent, true);
        if (m12645a3 != null) {
            m12641a(c2297a);
            c2297a.f7673l = m12645a3;
        }
        C2297a.C2298a m12645a4 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_minHeightPercent, false);
        if (m12645a4 != null) {
            m12641a(c2297a);
            c2297a.f7674m = m12645a4;
        }
        return c2297a;
    }

    /* renamed from: c */
    private void m12634c(int i, int i2, View view, C2297a c2297a) {
        C2297a.C2298a c2298a = c2297a.f7670i;
        if (c2298a == null) {
            return;
        }
        if (!c2298a.f7681b) {
            i = i2;
        }
        float f = (int) (c2298a.f7680a * i);
        if (!(view instanceof TextView)) {
            return;
        }
        ((TextView) view).setTextSize(0, f);
    }

    /* renamed from: d */
    private static C2297a m12632d(TypedArray typedArray, C2297a c2297a) {
        C2297a.C2298a m12645a = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginPercent, true);
        if (m12645a != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent margin: " + m12645a.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7664c = m12645a;
            c2297a.f7665d = m12645a;
            c2297a.f7666e = m12645a;
            c2297a.f7667f = m12645a;
        }
        C2297a.C2298a m12645a2 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginLeftPercent, true);
        if (m12645a2 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent left margin: " + m12645a2.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7664c = m12645a2;
        }
        C2297a.C2298a m12645a3 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginTopPercent, false);
        if (m12645a3 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent top margin: " + m12645a3.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7665d = m12645a3;
        }
        C2297a.C2298a m12645a4 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginRightPercent, true);
        if (m12645a4 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent right margin: " + m12645a4.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7666e = m12645a4;
        }
        C2297a.C2298a m12645a5 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginBottomPercent, false);
        if (m12645a5 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent bottom margin: " + m12645a5.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7667f = m12645a5;
        }
        C2297a.C2298a m12645a6 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginStartPercent, true);
        if (m12645a6 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent start margin: " + m12645a6.f7680a);
            }
            c2297a = m12641a(c2297a);
            c2297a.f7668g = m12645a6;
        }
        C2297a.C2298a m12645a7 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_marginEndPercent, true);
        if (m12645a7 != null) {
            if (Log.isLoggable(f7659a, 2)) {
                Log.v(f7659a, "percent end margin: " + m12645a7.f7680a);
            }
            C2297a m12641a = m12641a(c2297a);
            m12641a.f7669h = m12645a7;
            return m12641a;
        }
        return c2297a;
    }

    /* renamed from: e */
    private static C2297a m12631e(TypedArray typedArray, C2297a c2297a) {
        C2297a.C2298a m12645a = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_paddingPercent, true);
        if (m12645a != null) {
            c2297a = m12641a(c2297a);
            c2297a.f7675n = m12645a;
            c2297a.f7676o = m12645a;
            c2297a.f7678q = m12645a;
            c2297a.f7677p = m12645a;
        }
        C2297a.C2298a m12645a2 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_paddingLeftPercent, true);
        if (m12645a2 != null) {
            c2297a = m12641a(c2297a);
            c2297a.f7675n = m12645a2;
        }
        C2297a.C2298a m12645a3 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_paddingRightPercent, true);
        if (m12645a3 != null) {
            c2297a = m12641a(c2297a);
            c2297a.f7676o = m12645a3;
        }
        C2297a.C2298a m12645a4 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_paddingTopPercent, true);
        if (m12645a4 != null) {
            c2297a = m12641a(c2297a);
            c2297a.f7677p = m12645a4;
        }
        C2297a.C2298a m12645a5 = m12645a(typedArray, C2168R.styleable.PercentLayout_Layout_layout_paddingBottomPercent, true);
        if (m12645a5 != null) {
            C2297a m12641a = m12641a(c2297a);
            m12641a.f7678q = m12645a5;
            return m12641a;
        }
        return c2297a;
    }

    /* renamed from: a */
    public void m12649a() {
        int childCount = this.f7661b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f7661b.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable(f7659a, 3)) {
                Log.d(f7659a, "should restore " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof AbstractC2299b) {
                C2297a mo12626a = ((AbstractC2299b) layoutParams).mo12626a();
                if (Log.isLoggable(f7659a, 3)) {
                    Log.d(f7659a, "using " + mo12626a);
                }
                if (mo12626a != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        mo12626a.m12628a((ViewGroup.MarginLayoutParams) layoutParams);
                    } else {
                        mo12626a.m12630a(layoutParams);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m12648a(int i, int i2) {
        if (Log.isLoggable(f7659a, 3)) {
            Log.d(f7659a, "adjustChildren: " + this.f7661b + " widthMeasureSpec: " + View.MeasureSpec.toString(i) + " heightMeasureSpec: " + View.MeasureSpec.toString(i2));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (Log.isLoggable(f7659a, 3)) {
            Log.d(f7659a, "widthHint = " + size + " , heightHint = " + size2);
        }
        int childCount = this.f7661b.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f7661b.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable(f7659a, 3)) {
                Log.d(f7659a, "should adjust " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof AbstractC2299b) {
                C2297a mo12626a = ((AbstractC2299b) layoutParams).mo12626a();
                if (Log.isLoggable(f7659a, 3)) {
                    Log.d(f7659a, "using " + mo12626a);
                }
                if (mo12626a != null) {
                    m12634c(size, size2, childAt, mo12626a);
                    m12647a(size, size2, childAt, mo12626a);
                    m12637b(size, size2, childAt, mo12626a);
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        mo12626a.m12627a((ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                    } else {
                        mo12626a.m12629a(layoutParams, size, size2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public boolean m12638b() {
        C2297a mo12626a;
        boolean z;
        int childCount = this.f7661b.getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f7661b.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof AbstractC2299b) && (mo12626a = ((AbstractC2299b) layoutParams).mo12626a()) != null) {
                if (m12643a(childAt, mo12626a)) {
                    layoutParams.width = -2;
                    z = true;
                } else {
                    z = z2;
                }
                if (m12635b(childAt, mo12626a)) {
                    layoutParams.height = -2;
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
        }
        return z2;
    }
}
