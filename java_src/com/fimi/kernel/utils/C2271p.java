package com.fimi.kernel.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
/* renamed from: com.fimi.kernel.utils.p */
/* loaded from: classes.dex */
public class C2271p {

    /* renamed from: a */
    public static final int f7550a = Integer.MIN_VALUE;

    /* renamed from: a */
    public static float m12873a(int i, float f, DisplayMetrics displayMetrics) {
        switch (i) {
            case 0:
                return f;
            case 1:
                return f * displayMetrics.density;
            case 2:
                return f * displayMetrics.scaledDensity;
            case 3:
                return displayMetrics.xdpi * f * 0.013888889f;
            case 4:
                return f * displayMetrics.xdpi;
            case 5:
                return displayMetrics.xdpi * f * 0.03937008f;
            default:
                return 0.0f;
        }
    }

    /* renamed from: a */
    public static float m12870a(Context context, float f) {
        return m12873a(1, f, C2252c.m13053d(context));
    }

    /* renamed from: a */
    public static int m12872a(int i, int i2, float f) {
        if (f == 0.0f) {
            return 0;
        }
        float f2 = 1.0f;
        try {
            f2 = Math.min(i / 720.0f, i2 / 1280.0f);
        } catch (Exception e) {
        }
        return Math.round((f2 * f) + 0.5f);
    }

    /* renamed from: a */
    public static int m12871a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: a */
    public static void m12869a(Context context, int i) {
        View findViewById = ((Activity) context).findViewById(i);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
        }
    }

    /* renamed from: a */
    public static void m12868a(Context context, Paint paint, float f) {
        paint.setTextSize(m12848f(context, f));
    }

    /* renamed from: a */
    public static void m12867a(Context context, TextPaint textPaint, float f) {
        textPaint.setTextSize(m12848f(context, f));
    }

    /* renamed from: a */
    public static void m12866a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* renamed from: a */
    public static void m12865a(View view, int i) {
        View findViewById = view.findViewById(i);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
        }
    }

    /* renamed from: a */
    public static void m12864a(View view, int i, int i2) {
        int m12850e = m12850e(view.getContext(), i);
        int m12850e2 = m12850e(view.getContext(), i2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i != Integer.MIN_VALUE) {
            layoutParams.width = m12850e;
        }
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.height = m12850e2;
        }
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public static void m12863a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(m12850e(view.getContext(), i), m12850e(view.getContext(), i2), m12850e(view.getContext(), i3), m12850e(view.getContext(), i4));
    }

    /* renamed from: a */
    public static void m12862a(AbsListView absListView, int i, int i2) {
        int m12856b = m12856b(absListView, i, i2);
        ViewGroup.LayoutParams layoutParams = absListView.getLayoutParams();
        layoutParams.height = m12856b;
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
        absListView.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public static void m12861a(TextView textView, float f) {
        textView.setTextSize(m12848f(textView.getContext(), f));
    }

    /* renamed from: b */
    public static float m12860b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: b */
    public static float m12859b(Context context, float f) {
        return f / C2252c.m13053d(context).density;
    }

    /* renamed from: b */
    public static int m12858b(View view) {
        m12866a(view);
        return view.getMeasuredWidth();
    }

    /* renamed from: b */
    public static int m12856b(AbsListView absListView, int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        absListView.measure(makeMeasureSpec, makeMeasureSpec2);
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            return 0;
        }
        int count = listAdapter.getCount();
        if (absListView instanceof ListView) {
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                View view = listAdapter.getView(i4, null, absListView);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 += view.getMeasuredHeight();
            }
            if (count != 0) {
                i2 = i3 + (((ListView) absListView).getDividerHeight() * (count - 1));
            }
        } else if (absListView instanceof GridView) {
            int i5 = count % i;
            if (i5 > 0) {
                i5 = 1;
            }
            if (listAdapter.getCount() != 0) {
                View view2 = listAdapter.getView(0, null, absListView);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                int i6 = i5 + (count / i);
                i2 = (view2.getMeasuredHeight() * i6) + ((i6 - 1) * i2);
            }
        } else {
            i2 = 0;
        }
        return i2;
    }

    /* renamed from: b */
    public static void m12857b(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int m12850e = m12850e(view.getContext(), i);
        int m12850e2 = m12850e(view.getContext(), i2);
        int m12850e3 = m12850e(view.getContext(), i3);
        int m12850e4 = m12850e(view.getContext(), i4);
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (i != Integer.MIN_VALUE) {
            marginLayoutParams.leftMargin = m12850e;
        }
        if (i3 != Integer.MIN_VALUE) {
            marginLayoutParams.rightMargin = m12850e3;
        }
        if (i2 != Integer.MIN_VALUE) {
            marginLayoutParams.topMargin = m12850e2;
        }
        if (i4 != Integer.MIN_VALUE) {
            marginLayoutParams.bottomMargin = m12850e4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: b */
    public static void m12855b(TextView textView, float f) {
        textView.setTextSize(0, m12848f(textView.getContext(), f));
    }

    /* renamed from: c */
    public static float m12854c(Context context, float f) {
        return m12873a(2, f, C2252c.m13053d(context));
    }

    /* renamed from: c */
    public static int m12853c(View view) {
        m12866a(view);
        return view.getMeasuredHeight();
    }

    /* renamed from: d */
    public static float m12852d(Context context, float f) {
        return f / C2252c.m13053d(context).scaledDensity;
    }

    /* renamed from: d */
    public static void m12851d(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).removeView(view);
    }

    /* renamed from: e */
    public static int m12850e(Context context, float f) {
        DisplayMetrics m13053d = C2252c.m13053d(context);
        if (m13053d.scaledDensity > 2.0f) {
            if (m13053d.widthPixels > 720) {
                f *= 1.3f - (1.0f / m13053d.scaledDensity);
            } else if (m13053d.widthPixels < 720) {
                f *= 1.0f - (1.0f / m13053d.scaledDensity);
            }
        }
        return m12872a(m13053d.widthPixels, m13053d.heightPixels, f);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public static void m12849e(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i = Integer.MIN_VALUE;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            m12855b(textView, textView.getTextSize());
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int i2 = (layoutParams.width == -2 || layoutParams.width == -1) ? Integer.MIN_VALUE : layoutParams.width;
            if (layoutParams.height != -2 && layoutParams.height != -1) {
                i = layoutParams.height;
            }
            m12864a(view, i2, i);
            m12863a(view, view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        if ((view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            m12857b(view, marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            int m12850e = m12850e(view.getContext(), view.getMinimumWidth());
            int m12850e2 = m12850e(view.getContext(), view.getMinimumHeight());
            view.setMinimumWidth(m12850e);
            view.setMinimumHeight(m12850e2);
        }
    }

    /* renamed from: f */
    public static int m12848f(Context context, float f) {
        DisplayMetrics m13053d = C2252c.m13053d(context);
        if (m13053d.scaledDensity > 2.0f) {
        }
        return m12872a(m13053d.widthPixels, m13053d.heightPixels, f);
    }
}
