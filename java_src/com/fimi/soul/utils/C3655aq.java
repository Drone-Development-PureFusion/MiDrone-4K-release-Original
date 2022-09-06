package com.fimi.soul.utils;

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
/* renamed from: com.fimi.soul.utils.aq */
/* loaded from: classes.dex */
public class C3655aq {

    /* renamed from: a */
    public static final int f14829a = -1728053248;

    /* renamed from: i */
    private static boolean f14830i;

    /* renamed from: b */
    private final C3657a f14831b;

    /* renamed from: c */
    private boolean f14832c;

    /* renamed from: d */
    private boolean f14833d;

    /* renamed from: e */
    private boolean f14834e;

    /* renamed from: f */
    private boolean f14835f;

    /* renamed from: g */
    private View f14836g;

    /* renamed from: h */
    private View f14837h;

    /* renamed from: com.fimi.soul.utils.aq$a */
    /* loaded from: classes.dex */
    public static class C3657a {

        /* renamed from: a */
        private static final String f14838a = "status_bar_height";

        /* renamed from: b */
        private static final String f14839b = "navigation_bar_height";

        /* renamed from: c */
        private static final String f14840c = "navigation_bar_height_landscape";

        /* renamed from: d */
        private static final String f14841d = "navigation_bar_width";

        /* renamed from: e */
        private final boolean f14842e;

        /* renamed from: f */
        private final boolean f14843f;

        /* renamed from: g */
        private final int f14844g;

        /* renamed from: h */
        private final int f14845h;

        /* renamed from: i */
        private final boolean f14846i;

        /* renamed from: j */
        private final int f14847j;

        /* renamed from: k */
        private final int f14848k;

        /* renamed from: l */
        private final boolean f14849l;

        /* renamed from: m */
        private final float f14850m;

        private C3657a(Activity activity, boolean z, boolean z2) {
            boolean z3 = true;
            Resources resources = activity.getResources();
            this.f14849l = resources.getConfiguration().orientation == 1;
            this.f14850m = m7636a(activity);
            this.f14844g = m7634a(resources, f14838a);
            this.f14845h = m7635a((Context) activity);
            this.f14847j = m7631b(activity);
            this.f14848k = m7629c(activity);
            this.f14846i = this.f14847j <= 0 ? false : z3;
            this.f14842e = z;
            this.f14843f = z2;
        }

        @SuppressLint({"NewApi"})
        /* renamed from: a */
        private float m7636a(Activity activity) {
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
        private int m7635a(Context context) {
            if (Build.VERSION.SDK_INT >= 14) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16843499, typedValue, true);
                return context.getResources().getDimensionPixelSize(typedValue.resourceId);
            }
            return 0;
        }

        /* renamed from: a */
        private int m7634a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        /* renamed from: b */
        private int m7631b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return 0;
            }
            return m7634a(resources, this.f14849l ? f14839b : f14840c);
        }

        @TargetApi(14)
        /* renamed from: c */
        private int m7629c(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return 0;
            }
            return m7634a(resources, f14841d);
        }

        /* renamed from: a */
        public int m7633a(boolean z) {
            int i = 0;
            int i2 = this.f14842e ? this.f14844g : 0;
            if (z) {
                i = this.f14845h;
            }
            return i + i2;
        }

        /* renamed from: a */
        public boolean m7637a() {
            return this.f14850m >= 600.0f || this.f14849l;
        }

        /* renamed from: b */
        public int m7632b() {
            return this.f14844g;
        }

        /* renamed from: c */
        public int m7630c() {
            return this.f14845h;
        }

        /* renamed from: d */
        public boolean m7628d() {
            return this.f14846i;
        }

        /* renamed from: e */
        public int m7627e() {
            return this.f14847j;
        }

        /* renamed from: f */
        public int m7626f() {
            return this.f14848k;
        }

        /* renamed from: g */
        public int m7625g() {
            if (!this.f14843f || !m7637a()) {
                return 0;
            }
            return this.f14847j;
        }

        /* renamed from: h */
        public int m7624h() {
            if (!this.f14843f || m7637a()) {
                return 0;
            }
            return this.f14848k;
        }
    }

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f14830i = "V6".equals((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.miui.ui.version.name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(19)
    public C3655aq(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f14832c = obtainStyledAttributes.getBoolean(0, false);
                this.f14833d = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f14832c = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f14833d = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f14831b = new C3657a(activity, this.f14832c, this.f14833d);
        if (!this.f14831b.m7628d()) {
            this.f14833d = false;
        }
        if (this.f14832c) {
            m7654a(activity, viewGroup);
        }
        if (this.f14833d) {
            m7647b(activity, viewGroup);
        }
    }

    /* renamed from: a */
    private void m7654a(Context context, ViewGroup viewGroup) {
        this.f14836g = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f14831b.m7632b());
        layoutParams.gravity = 48;
        if (this.f14833d && !this.f14831b.m7637a()) {
            layoutParams.rightMargin = this.f14831b.m7626f();
        }
        this.f14836g.setLayoutParams(layoutParams);
        this.f14836g.setBackgroundColor(-1728053248);
        this.f14836g.setVisibility(8);
        viewGroup.addView(this.f14836g);
    }

    /* renamed from: b */
    private void m7647b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f14837h = new View(context);
        if (this.f14831b.m7637a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f14831b.m7627e());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f14831b.m7626f(), -1);
            layoutParams.gravity = 5;
        }
        this.f14837h.setLayoutParams(layoutParams);
        this.f14837h.setBackgroundColor(-1728053248);
        this.f14837h.setVisibility(8);
        viewGroup.addView(this.f14837h);
    }

    /* renamed from: a */
    public C3657a m7657a() {
        return this.f14831b;
    }

    /* renamed from: a */
    public void m7656a(float f) {
        m7649b(f);
        m7643c(f);
    }

    /* renamed from: a */
    public void m7655a(int i) {
        m7642c(i);
        m7639e(i);
    }

    /* renamed from: a */
    public void m7653a(Drawable drawable) {
        m7646b(drawable);
        m7641c(drawable);
    }

    /* renamed from: a */
    public void m7652a(boolean z) {
        this.f14834e = z;
        if (this.f14832c) {
            this.f14836g.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void m7651a(boolean z, Activity activity) {
        int i = 0;
        if (f14830i) {
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
    public void m7649b(float f) {
        if (!this.f14832c || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f14836g.setAlpha(f);
    }

    /* renamed from: b */
    public void m7648b(int i) {
        m7640d(i);
        m7638f(i);
    }

    /* renamed from: b */
    public void m7646b(Drawable drawable) {
        if (this.f14832c) {
            this.f14836g.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: b */
    public void m7645b(boolean z) {
        this.f14835f = z;
        if (this.f14833d) {
            this.f14837h.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: b */
    public boolean m7650b() {
        return this.f14834e;
    }

    @TargetApi(11)
    /* renamed from: c */
    public void m7643c(float f) {
        if (!this.f14833d || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f14837h.setAlpha(f);
    }

    /* renamed from: c */
    public void m7642c(int i) {
        if (this.f14832c) {
            this.f14836g.setBackgroundColor(i);
        }
    }

    /* renamed from: c */
    public void m7641c(Drawable drawable) {
        if (this.f14833d) {
            this.f14837h.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: c */
    public boolean m7644c() {
        return this.f14835f;
    }

    /* renamed from: d */
    public void m7640d(int i) {
        if (this.f14832c) {
            this.f14836g.setBackgroundResource(i);
        }
    }

    /* renamed from: e */
    public void m7639e(int i) {
        if (this.f14833d) {
            this.f14837h.setBackgroundColor(i);
        }
    }

    /* renamed from: f */
    public void m7638f(int i) {
        if (this.f14833d) {
            this.f14837h.setBackgroundResource(i);
        }
    }
}
