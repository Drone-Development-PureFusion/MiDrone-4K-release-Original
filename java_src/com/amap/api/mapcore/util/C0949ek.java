package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.ek */
/* loaded from: classes.dex */
public class C0949ek extends ScrollView {

    /* renamed from: a */
    public static final String f2914a = C0949ek.class.getSimpleName();

    /* renamed from: c */
    private Context f2916c;

    /* renamed from: d */
    private LinearLayout f2917d;

    /* renamed from: f */
    private List<String> f2919f;

    /* renamed from: h */
    private int f2921h;

    /* renamed from: n */
    private int f2927n;

    /* renamed from: o */
    private int f2928o;

    /* renamed from: p */
    private Runnable f2929p;

    /* renamed from: r */
    private AbstractC0955a f2931r;

    /* renamed from: e */
    private int f2918e = 0;

    /* renamed from: g */
    private int f2920g = -1;

    /* renamed from: i */
    private Bitmap f2922i = null;

    /* renamed from: j */
    private int f2923j = Color.parseColor("#eeffffff");

    /* renamed from: k */
    private int f2924k = Color.parseColor("#44383838");

    /* renamed from: l */
    private int f2925l = 4;

    /* renamed from: m */
    private int f2926m = 1;

    /* renamed from: b */
    int f2915b = 1;

    /* renamed from: q */
    private int f2930q = 50;

    /* renamed from: com.amap.api.mapcore.util.ek$a */
    /* loaded from: classes.dex */
    public interface AbstractC0955a {
        /* renamed from: a */
        void mo18273a(int i);
    }

    public C0949ek(Context context) {
        super(context);
        m18303a(context);
    }

    /* renamed from: a */
    public static int m18302a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* renamed from: a */
    public static int m18301a(View view) {
        m18293b(view);
        return view.getMeasuredHeight();
    }

    /* renamed from: a */
    private void m18304a(int i) {
        int i2 = (i / this.f2918e) + this.f2926m;
        int i3 = i % this.f2918e;
        int i4 = i / this.f2918e;
        int i5 = i3 == 0 ? this.f2926m + i4 : i3 > this.f2918e / 2 ? this.f2926m + i4 + 1 : i2;
        int childCount = this.f2917d.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            TextView textView = (TextView) this.f2917d.getChildAt(i6);
            if (textView == null) {
                return;
            }
            if (i5 == i6) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    /* renamed from: a */
    private void m18303a(Context context) {
        this.f2916c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f2922i == null) {
                InputStream open = C0943ef.m18372a(context).open("map_indoor_select.png");
                this.f2922i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable th) {
        }
        this.f2917d = new LinearLayout(context);
        this.f2917d.setOrientation(1);
        addView(this.f2917d);
        this.f2929p = new Runnable() { // from class: com.amap.api.mapcore.util.ek.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0949ek.this.f2928o - C0949ek.this.getScrollY() != 0) {
                    C0949ek.this.f2928o = C0949ek.this.getScrollY();
                    C0949ek.this.postDelayed(C0949ek.this.f2929p, C0949ek.this.f2930q);
                    return;
                }
                final int i = C0949ek.this.f2928o % C0949ek.this.f2918e;
                final int i2 = C0949ek.this.f2928o / C0949ek.this.f2918e;
                if (i == 0) {
                    C0949ek.this.f2915b = i2 + C0949ek.this.f2926m;
                    C0949ek.this.m18284f();
                } else if (i > C0949ek.this.f2918e / 2) {
                    C0949ek.this.post(new Runnable() { // from class: com.amap.api.mapcore.util.ek.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C0949ek.this.smoothScrollTo(0, (C0949ek.this.f2928o - i) + C0949ek.this.f2918e);
                            C0949ek.this.f2915b = i2 + C0949ek.this.f2926m + 1;
                            C0949ek.this.m18284f();
                        }
                    });
                } else {
                    C0949ek.this.post(new Runnable() { // from class: com.amap.api.mapcore.util.ek.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            C0949ek.this.smoothScrollTo(0, C0949ek.this.f2928o - i);
                            C0949ek.this.f2915b = i2 + C0949ek.this.f2926m;
                            C0949ek.this.m18284f();
                        }
                    });
                }
            }
        };
    }

    /* renamed from: b */
    private TextView m18291b(String str) {
        TextView textView = new TextView(this.f2916c);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int m18302a = m18302a(this.f2916c, 8.0f);
        int m18302a2 = m18302a(this.f2916c, 6.0f);
        textView.setPadding(m18302a, m18302a2, m18302a, m18302a2);
        if (this.f2918e == 0) {
            this.f2918e = m18301a(textView);
            this.f2917d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f2918e * this.f2927n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f2918e * this.f2927n));
        }
        return textView;
    }

    /* renamed from: b */
    public static void m18293b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    /* renamed from: d */
    private void m18288d() {
        if (this.f2919f == null || this.f2919f.size() == 0) {
            return;
        }
        this.f2917d.removeAllViews();
        this.f2927n = (this.f2926m * 2) + 1;
        for (int size = this.f2919f.size() - 1; size >= 0; size--) {
            this.f2917d.addView(m18291b(this.f2919f.get(size)));
        }
        m18304a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int[] m18286e() {
        if (0 == 0) {
            return new int[]{this.f2918e * this.f2926m, this.f2918e * (this.f2926m + 1)};
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m18284f() {
        if (this.f2931r != null) {
            try {
                this.f2931r.mo18273a(m18294b());
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void m18305a() {
        this.f2928o = getScrollY();
        postDelayed(this.f2929p, this.f2930q);
    }

    /* renamed from: a */
    public void m18300a(AbstractC0955a abstractC0955a) {
        this.f2931r = abstractC0955a;
    }

    /* renamed from: a */
    public void m18297a(String str) {
        if (this.f2919f == null || this.f2919f.size() == 0) {
            return;
        }
        final int size = ((this.f2919f.size() - this.f2926m) - 1) - this.f2919f.indexOf(str);
        this.f2915b = this.f2926m + size;
        post(new Runnable() { // from class: com.amap.api.mapcore.util.ek.3
            @Override // java.lang.Runnable
            public void run() {
                C0949ek.this.smoothScrollTo(0, size * C0949ek.this.f2918e);
            }
        });
    }

    /* renamed from: a */
    public void m18296a(boolean z) {
        if (z) {
            if (m18290c()) {
                return;
            }
            setVisibility(0);
        } else if (!m18290c()) {
        } else {
            setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m18295a(String[] strArr) {
        if (this.f2919f == null) {
            this.f2919f = new ArrayList();
        }
        this.f2919f.clear();
        for (String str : strArr) {
            this.f2919f.add(str);
        }
        for (int i = 0; i < this.f2926m; i++) {
            this.f2919f.add(0, "");
            this.f2919f.add("");
        }
        m18288d();
    }

    /* renamed from: b */
    public int m18294b() {
        if (this.f2919f == null || this.f2919f.size() == 0) {
            return 0;
        }
        return Math.min(this.f2919f.size() - (this.f2926m * 2), Math.max(0, ((this.f2919f.size() - 1) - this.f2915b) - this.f2926m));
    }

    /* renamed from: c */
    public boolean m18290c() {
        return getVisibility() == 0;
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m18304a(i2);
        if (i2 > i4) {
            this.f2920g = 1;
        } else {
            this.f2920g = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2921h = i;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m18305a();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f2923j = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f2921h == 0) {
            this.f2921h = ((Activity) this.f2916c).getWindowManager().getDefaultDisplay().getWidth();
        }
        super.setBackgroundDrawable(new Drawable() { // from class: com.amap.api.mapcore.util.ek.2
            /* renamed from: a */
            private void m18276a(Canvas canvas) {
                canvas.drawColor(C0949ek.this.f2923j);
            }

            /* renamed from: b */
            private void m18275b(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = C0949ek.this.f2922i.getWidth() + 0;
                rect.bottom = C0949ek.this.f2922i.getHeight() + 0;
                rect2.left = 0;
                rect2.top = C0949ek.this.m18286e()[0];
                rect2.right = C0949ek.this.f2921h + 0;
                rect2.bottom = C0949ek.this.m18286e()[1];
                canvas.drawBitmap(C0949ek.this.f2922i, rect, rect2, paint);
            }

            /* renamed from: c */
            private void m18274c(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(C0949ek.this.f2924k);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(C0949ek.this.f2925l);
                canvas.drawRect(clipBounds, paint);
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                try {
                    m18276a(canvas);
                    m18275b(canvas);
                    m18274c(canvas);
                } catch (Throwable th) {
                }
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }
}
