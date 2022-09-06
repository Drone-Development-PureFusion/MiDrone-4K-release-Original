package com.fimi.kernel.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
/* renamed from: com.fimi.kernel.utils.w */
/* loaded from: classes.dex */
public class C2278w {

    /* renamed from: a */
    public static final int f7581a = -1728053248;

    /* renamed from: i */
    private static boolean f7582i;

    /* renamed from: b */
    private final C2280a f7583b;

    /* renamed from: c */
    private boolean f7584c;

    /* renamed from: d */
    private boolean f7585d;

    /* renamed from: e */
    private boolean f7586e;

    /* renamed from: f */
    private boolean f7587f;

    /* renamed from: g */
    private View f7588g;

    /* renamed from: h */
    private View f7589h;

    /* renamed from: com.fimi.kernel.utils.w$a */
    /* loaded from: classes.dex */
    public static class C2280a {

        /* renamed from: a */
        private static final String f7590a = "status_bar_height";

        /* renamed from: b */
        private static final String f7591b = "navigation_bar_height";

        /* renamed from: c */
        private static final String f7592c = "navigation_bar_height_landscape";

        /* renamed from: d */
        private static final String f7593d = "navigation_bar_width";

        /* renamed from: e */
        private final boolean f7594e;

        /* renamed from: f */
        private final boolean f7595f;

        /* renamed from: g */
        private final int f7596g;

        /* renamed from: h */
        private final int f7597h;

        /* renamed from: i */
        private final boolean f7598i;

        /* renamed from: j */
        private final int f7599j;

        /* renamed from: k */
        private final int f7600k;

        /* renamed from: l */
        private final boolean f7601l;

        /* renamed from: m */
        private final float f7602m;

        private C2280a(Activity activity, boolean z, boolean z2) {
            boolean z3 = true;
            Resources resources = activity.getResources();
            this.f7601l = resources.getConfiguration().orientation == 1;
            this.f7602m = m12718a(activity);
            this.f7596g = m12716a(resources, f7590a);
            this.f7597h = m12717a((Context) activity);
            this.f7599j = m12713b(activity);
            this.f7600k = m12711c(activity);
            this.f7598i = this.f7599j <= 0 ? false : z3;
            this.f7594e = z;
            this.f7595f = z2;
        }

        @SuppressLint({"NewApi"})
        /* renamed from: a */
        private float m12718a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return Math.min(displayMetrics.widthPixels / displayMetrics.density, displayMetrics.heightPixels / displayMetrics.density);
        }

        @TargetApi(14)
        /* renamed from: a */
        private int m12717a(Context context) {
            if (Build.VERSION.SDK_INT >= 14) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16843499, typedValue, true);
                return context.getResources().getDimensionPixelSize(typedValue.resourceId);
            }
            return 0;
        }

        /* renamed from: a */
        private int m12716a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        /* renamed from: b */
        private int m12713b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return 0;
            }
            return m12716a(resources, this.f7601l ? f7591b : f7592c);
        }

        @TargetApi(14)
        /* renamed from: c */
        private int m12711c(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return 0;
            }
            return m12716a(resources, f7593d);
        }

        /* renamed from: a */
        public int m12715a(boolean z) {
            int i = 0;
            int i2 = this.f7594e ? this.f7596g : 0;
            if (z) {
                i = this.f7597h;
            }
            return i + i2;
        }

        /* renamed from: a */
        public boolean m12719a() {
            return this.f7602m >= 600.0f || this.f7601l;
        }

        /* renamed from: b */
        public int m12714b() {
            return this.f7596g;
        }

        /* renamed from: c */
        public int m12712c() {
            return this.f7597h;
        }

        /* renamed from: d */
        public boolean m12710d() {
            return this.f7598i;
        }

        /* renamed from: e */
        public int m12709e() {
            return this.f7599j;
        }

        /* renamed from: f */
        public int m12708f() {
            return this.f7600k;
        }

        /* renamed from: g */
        public int m12707g() {
            if (!this.f7595f || !m12719a()) {
                return 0;
            }
            return this.f7599j;
        }

        /* renamed from: h */
        public int m12706h() {
            if (!this.f7595f || m12719a()) {
                return 0;
            }
            return this.f7600k;
        }
    }

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f7582i = "V6".equals((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.miui.ui.version.name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(19)
    public C2278w(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f7584c = obtainStyledAttributes.getBoolean(0, false);
                this.f7585d = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f7584c = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f7585d = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f7583b = new C2280a(activity, this.f7584c, this.f7585d);
        if (!this.f7583b.m12710d()) {
            this.f7585d = false;
        }
        if (this.f7584c) {
            m12736a(activity, viewGroup);
        }
        if (this.f7585d) {
            m12729b(activity, viewGroup);
        }
    }

    /* renamed from: a */
    private void m12736a(Context context, ViewGroup viewGroup) {
        this.f7588g = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f7583b.m12714b());
        layoutParams.gravity = 48;
        if (this.f7585d && !this.f7583b.m12719a()) {
            layoutParams.rightMargin = this.f7583b.m12708f();
        }
        this.f7588g.setLayoutParams(layoutParams);
        this.f7588g.setBackgroundColor(-1728053248);
        this.f7588g.setVisibility(8);
        viewGroup.addView(this.f7588g);
    }

    /* renamed from: b */
    private void m12729b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f7589h = new View(context);
        if (this.f7583b.m12719a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f7583b.m12709e());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f7583b.m12708f(), -1);
            layoutParams.gravity = 5;
        }
        this.f7589h.setLayoutParams(layoutParams);
        this.f7589h.setBackgroundColor(-1728053248);
        this.f7589h.setVisibility(8);
        viewGroup.addView(this.f7589h);
    }

    /* renamed from: a */
    public C2280a m12739a() {
        return this.f7583b;
    }

    /* renamed from: a */
    public void m12738a(float f) {
        m12731b(f);
        m12725c(f);
    }

    /* renamed from: a */
    public void m12737a(int i) {
        m12724c(i);
        m12721e(i);
    }

    /* renamed from: a */
    public void m12735a(Drawable drawable) {
        m12728b(drawable);
        m12723c(drawable);
    }

    /* renamed from: a */
    public void m12734a(boolean z) {
        this.f7586e = z;
        if (this.f7584c) {
            this.f7588g.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void m12733a(boolean z, Activity activity) {
        int i = 0;
        if (f7582i) {
            Class<?> cls = activity.getWindow().getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window = activity.getWindow();
                Object[] objArr = new Object[2];
                if (z) {
                    i = i2;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(11)
    /* renamed from: b */
    public void m12731b(float f) {
        if (!this.f7584c || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f7588g.setAlpha(f);
    }

    /* renamed from: b */
    public void m12730b(int i) {
        m12722d(i);
        m12720f(i);
    }

    /* renamed from: b */
    public void m12728b(Drawable drawable) {
        if (this.f7584c) {
            this.f7588g.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: b */
    public void m12727b(boolean z) {
        this.f7587f = z;
        if (this.f7585d) {
            this.f7589h.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: b */
    public boolean m12732b() {
        return this.f7586e;
    }

    @TargetApi(11)
    /* renamed from: c */
    public void m12725c(float f) {
        if (!this.f7585d || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f7589h.setAlpha(f);
    }

    /* renamed from: c */
    public void m12724c(int i) {
        if (this.f7584c) {
            this.f7588g.setBackgroundColor(i);
        }
    }

    /* renamed from: c */
    public void m12723c(Drawable drawable) {
        if (this.f7585d) {
            this.f7589h.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: c */
    public boolean m12726c() {
        return this.f7587f;
    }

    /* renamed from: d */
    public void m12722d(int i) {
        if (this.f7584c) {
            this.f7588g.setBackgroundResource(i);
        }
    }

    /* renamed from: e */
    public void m12721e(int i) {
        if (this.f7585d) {
            this.f7589h.setBackgroundColor(i);
        }
    }

    /* renamed from: f */
    public void m12720f(int i) {
        if (this.f7585d) {
            this.f7589h.setBackgroundResource(i);
        }
    }
}
