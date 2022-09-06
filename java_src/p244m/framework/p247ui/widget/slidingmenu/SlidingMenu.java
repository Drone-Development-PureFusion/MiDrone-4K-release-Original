package p244m.framework.p247ui.widget.slidingmenu;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import java.lang.reflect.Method;
import java.util.HashMap;
/* renamed from: m.framework.ui.widget.slidingmenu.SlidingMenu */
/* loaded from: classes2.dex */
public class SlidingMenu extends RelativeLayout {

    /* renamed from: a */
    private C4998c f21383a;

    /* renamed from: b */
    private HashMap<C5000e, View> f21384b;

    /* renamed from: c */
    private View.OnClickListener f21385c;

    /* renamed from: d */
    private View.OnTouchListener f21386d;

    /* renamed from: e */
    private AbstractC4997b f21387e;

    /* renamed from: f */
    private int f21388f;

    /* renamed from: g */
    private int f21389g;

    /* renamed from: h */
    private int f21390h;

    /* renamed from: i */
    private boolean f21391i;

    /* renamed from: j */
    private FrameLayout f21392j;

    /* renamed from: k */
    private LinearLayout f21393k;

    /* renamed from: l */
    private View f21394l;

    /* renamed from: m */
    private C4996a f21395m;

    /* renamed from: n */
    private LinearLayout f21396n;

    /* renamed from: o */
    private View f21397o;

    public SlidingMenu(Context context) {
        super(context);
        m2366a(context);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2366a(context);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2366a(context);
    }

    /* renamed from: a */
    private void m2366a(Context context) {
        this.f21383a = new C4998c();
        this.f21384b = new HashMap<>();
        this.f21385c = new View.OnClickListener() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C5000e c5000e = (C5000e) view.getTag();
                if (c5000e == null || SlidingMenu.this.f21387e == null || SlidingMenu.this.f21387e.m2329b(c5000e)) {
                    return;
                }
                SlidingMenu.this.postDelayed(new Runnable() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlidingMenu.this.m2354d();
                    }
                }, 500L);
            }
        };
        this.f21386d = new View.OnTouchListener() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setBackgroundResource(SlidingMenu.this.f21383a.f21414a);
                        return false;
                    case 1:
                    case 3:
                        view.setBackgroundResource(SlidingMenu.this.f21383a.f21415b);
                        return false;
                    case 2:
                    default:
                        return false;
                }
            }
        };
        this.f21388f = context.getResources().getDisplayMetrics().widthPixels;
        this.f21389g = (int) (this.f21388f * this.f21383a.f21416c);
        this.f21390h = (this.f21388f - this.f21389g) / 2;
        setBackgroundResource(this.f21383a.f21417d);
        m2360b(context);
        m2356c(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SlidingMenu.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                SlidingMenu.this.post(new Runnable() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlidingMenu.this.m2354d();
                    }
                });
            }
        });
    }

    /* renamed from: a */
    private void m2365a(View view) {
        if (Build.VERSION.SDK_INT < 9) {
            return;
        }
        try {
            Method method = View.class.getMethod("setOverScrollMode", Integer.TYPE);
            method.setAccessible(true);
            method.invoke(view, 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m2360b(Context context) {
        this.f21392j = new FrameLayout(context) { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.4
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (!SlidingMenu.this.f21391i) {
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        };
        this.f21392j.setLayoutParams(new FrameLayout.LayoutParams(this.f21389g, -1));
        addView(this.f21392j);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f21392j.addView(linearLayout);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setVerticalFadingEdgeEnabled(false);
        m2365a(scrollView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        scrollView.setLayoutParams(layoutParams);
        linearLayout.addView(scrollView);
        this.f21393k = new LinearLayout(context);
        this.f21393k.setOrientation(1);
        this.f21393k.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.f21393k);
        this.f21394l = new View(context);
        this.f21394l.setBackgroundColor(0);
        this.f21394l.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f21392j.addView(this.f21394l);
    }

    /* renamed from: c */
    private void m2356c(Context context) {
        this.f21395m = new C4996a(this);
        this.f21395m.setHorizontalScrollBarEnabled(false);
        this.f21395m.setHorizontalFadingEdgeEnabled(false);
        m2365a(this.f21395m);
        this.f21395m.setLayoutParams(new FrameLayout.LayoutParams(this.f21388f, -1));
        addView(this.f21395m);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(this.f21388f + this.f21389g, -1));
        this.f21395m.addView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f21389g, -1));
        linearLayout.addView(frameLayout);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(this.f21383a.f21424k);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 5;
        imageView.setLayoutParams(layoutParams);
        frameLayout.addView(imageView);
        this.f21396n = new LinearLayout(context) { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.5
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return true;
            }
        };
        this.f21396n.setBackgroundResource(this.f21383a.f21423j);
        this.f21396n.setLayoutParams(new LinearLayout.LayoutParams(this.f21388f, -1));
        linearLayout.addView(this.f21396n);
    }

    /* renamed from: d */
    private void m2353d(Context context) {
        this.f21388f = context.getResources().getDisplayMetrics().widthPixels;
        this.f21389g = (int) (this.f21388f * this.f21383a.f21416c);
        this.f21390h = (this.f21388f - this.f21389g) / 2;
        setBackgroundResource(this.f21383a.f21417d);
        m2350e(context);
        m2347f(context);
    }

    /* renamed from: e */
    private void m2350e(Context context) {
        View m2342a;
        ViewGroup.LayoutParams layoutParams = this.f21392j.getLayoutParams();
        layoutParams.width = this.f21389g;
        this.f21392j.setLayoutParams(layoutParams);
        this.f21393k.setPadding(this.f21383a.f21418e, this.f21383a.f21419f, this.f21383a.f21420g, this.f21383a.f21421h);
        if (this.f21387e == null || (m2342a = this.f21387e.m2342a()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = m2342a.getLayoutParams();
        int i = -2;
        if (layoutParams2 != null) {
            i = layoutParams2.height;
        }
        m2342a.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        ((LinearLayout) this.f21392j.getChildAt(0)).addView(m2342a);
    }

    /* renamed from: f */
    private void m2348f() {
        Context context = getContext();
        this.f21393k.removeAllViews();
        int m2332b = this.f21387e.m2332b();
        for (int i = 0; i < m2332b; i++) {
            this.f21393k.addView(this.f21387e.m2339a(i, this.f21393k));
            int m2327a = this.f21387e.m2341a(i).m2327a();
            for (int i2 = 0; i2 < m2327a; i2++) {
                C5000e m2340a = this.f21387e.m2340a(i, i2);
                View m2334a = this.f21387e.m2334a(m2340a, this.f21393k);
                this.f21393k.addView(m2334a);
                this.f21393k.addView(m2346g(context));
                this.f21384b.put(m2340a, m2334a);
                m2334a.setTag(m2340a);
                m2334a.setOnClickListener(this.f21385c);
                m2334a.setOnTouchListener(this.f21386d);
            }
            int childCount = this.f21393k.getChildCount();
            if (childCount > 0) {
                this.f21393k.removeViewAt(childCount - 1);
            }
        }
    }

    /* renamed from: f */
    private void m2347f(Context context) {
        ViewGroup.LayoutParams layoutParams = this.f21395m.getLayoutParams();
        layoutParams.width = this.f21388f;
        this.f21395m.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) this.f21395m.getChildAt(0);
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        layoutParams2.width = this.f21388f + this.f21389g;
        linearLayout.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = (FrameLayout) linearLayout.getChildAt(0);
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        layoutParams3.width = this.f21389g;
        frameLayout.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f21396n.getLayoutParams();
        layoutParams4.width = this.f21388f;
        this.f21396n.setLayoutParams(layoutParams4);
        this.f21396n.setBackgroundResource(this.f21383a.f21423j);
        ((ImageView) frameLayout.getChildAt(0)).setImageResource(this.f21383a.f21424k);
        if (!this.f21391i) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.6
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SlidingMenu.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    SlidingMenu.this.post(new Runnable() { // from class: m.framework.ui.widget.slidingmenu.SlidingMenu.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SlidingMenu.this.f21395m.scrollTo(SlidingMenu.this.f21389g, 0);
                        }
                    });
                }
            });
        }
    }

    /* renamed from: g */
    private View m2346g(Context context) {
        View view = new View(context);
        view.setBackgroundResource(this.f21383a.f21425l);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
        return view;
    }

    /* renamed from: a */
    View m2363a(C5000e c5000e) {
        return this.f21384b.get(c5000e);
    }

    /* renamed from: a */
    public void m2369a() {
        if (this.f21387e != null) {
            m2353d(getContext());
            m2348f();
        }
    }

    /* renamed from: a */
    public void m2368a(int i, int i2) {
        this.f21383a.f21414a = i;
        this.f21383a.f21415b = i2;
    }

    /* renamed from: a */
    public void m2367a(int i, int i2, int i3, int i4) {
        this.f21383a.f21418e = i;
        this.f21383a.f21419f = i2;
        this.f21383a.f21420g = i3;
        this.f21383a.f21421h = i4;
    }

    /* renamed from: b */
    public void m2362b() {
        if (this.f21391i) {
            m2354d();
        } else {
            m2357c();
        }
    }

    /* renamed from: b */
    public void m2361b(int i, int i2) {
        C5000e m2330b;
        if (this.f21387e == null || (m2330b = this.f21387e.m2330b(i, i2)) == null) {
            return;
        }
        this.f21387e.m2329b(m2330b);
    }

    /* renamed from: b */
    public void m2358b(C5000e c5000e) {
        if (this.f21387e == null || c5000e == null) {
            return;
        }
        this.f21387e.m2329b(c5000e);
    }

    /* renamed from: c */
    public void m2357c() {
        this.f21391i = true;
        this.f21395m.smoothScrollTo(0, 0);
        if (this.f21387e != null) {
            this.f21387e.m2333a(this.f21391i);
        }
    }

    /* renamed from: d */
    public void m2354d() {
        this.f21391i = false;
        this.f21395m.smoothScrollTo(this.f21389g, 0);
        if (this.f21387e != null) {
            this.f21387e.m2333a(this.f21391i);
        }
    }

    /* renamed from: e */
    public boolean m2351e() {
        return this.f21391i;
    }

    public View getBodyView() {
        return this.f21397o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4998c getMenuConfig() {
        return this.f21383a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMenuCover() {
        return this.f21394l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuWidth() {
        return this.f21389g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getShowMenuWidth() {
        return this.f21390h;
    }

    public void setAdapter(AbstractC4997b abstractC4997b) {
        this.f21387e = abstractC4997b;
        m2369a();
    }

    public void setBodyBackground(int i) {
        this.f21383a.f21423j = i;
    }

    public void setBodyView(View view) {
        this.f21397o = view;
        this.f21396n.removeAllViews();
        if (this.f21397o != null) {
            this.f21397o.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f21396n.addView(this.f21397o);
        }
    }

    public void setMenuBackground(int i) {
        this.f21383a.f21417d = i;
    }

    public void setMenuDivider(int i) {
        this.f21383a.f21425l = i;
    }

    public void setMenuWeight(float f) {
        this.f21383a.f21416c = f;
    }

    public void setShadowRes(int i) {
        this.f21383a.f21424k = i;
    }

    public void setTtleHeight(int i) {
        this.f21383a.f21422i = i;
    }
}
