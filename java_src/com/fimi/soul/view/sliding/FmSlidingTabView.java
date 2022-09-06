package com.fimi.soul.view.sliding;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fimi.kernel.utils.C2266k;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class FmSlidingTabView extends LinearLayout {

    /* renamed from: a */
    public int f16433a;

    /* renamed from: b */
    private Context f16434b;

    /* renamed from: c */
    private Runnable f16435c;

    /* renamed from: d */
    private ViewPager.OnPageChangeListener f16436d;

    /* renamed from: e */
    private int f16437e;

    /* renamed from: f */
    private int f16438f;

    /* renamed from: g */
    private int f16439g;

    /* renamed from: h */
    private int f16440h;

    /* renamed from: i */
    private int f16441i;

    /* renamed from: j */
    private LinearLayout f16442j;

    /* renamed from: k */
    private HorizontalScrollView f16443k;

    /* renamed from: l */
    private FmViewPager f16444l;

    /* renamed from: m */
    private List<String> f16445m;

    /* renamed from: n */
    private List<Drawable> f16446n;

    /* renamed from: o */
    private ArrayList<Fragment> f16447o;

    /* renamed from: p */
    private ArrayList<TextView> f16448p;

    /* renamed from: q */
    private FmFragmentPagerAdapter f16449q;

    /* renamed from: r */
    private View.OnClickListener f16450r;

    /* loaded from: classes.dex */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public MyOnPageChangeListener() {
        }

        @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (FmSlidingTabView.this.f16436d != null) {
                FmSlidingTabView.this.f16436d.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (FmSlidingTabView.this.f16436d != null) {
                FmSlidingTabView.this.f16436d.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            FmSlidingTabView.this.setCurrentItem(i);
            if (FmSlidingTabView.this.f16436d != null) {
                FmSlidingTabView.this.f16436d.onPageSelected(i);
            }
        }
    }

    public FmSlidingTabView(Fragment fragment) {
        super(fragment.getActivity());
        this.f16438f = -1;
        this.f16439g = 30;
        this.f16440h = ViewCompat.MEASURED_STATE_MASK;
        this.f16441i = ViewCompat.MEASURED_STATE_MASK;
        this.f16442j = null;
        this.f16443k = null;
        this.f16445m = null;
        this.f16446n = null;
        this.f16447o = null;
        this.f16448p = null;
        this.f16449q = null;
        this.f16450r = new View.OnClickListener() { // from class: com.fimi.soul.view.sliding.FmSlidingTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmSlidingTabView.this.f16444l.setCurrentItem(((FmTabItemView) view).getIndex());
            }
        };
        this.f16434b = fragment.getActivity();
        m6727a();
        if (Build.VERSION.SDK_INT <= 17) {
            C2266k.m12934c(FmSlidingTabView.class, "AbSlidingTabView(Fragment fragment) 要求最低SDK版本17");
            return;
        }
        this.f16449q = new FmFragmentPagerAdapter(fragment.getChildFragmentManager(), this.f16447o);
        this.f16444l.setAdapter(this.f16449q);
        this.f16444l.setOnPageChangeListener(new MyOnPageChangeListener());
        this.f16444l.setOffscreenPageLimit(3);
        addView(this.f16444l, new LinearLayout.LayoutParams(-1, -1));
    }

    public FmSlidingTabView(Context context) {
        this(context, null);
    }

    public FmSlidingTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16438f = -1;
        this.f16439g = 30;
        this.f16440h = ViewCompat.MEASURED_STATE_MASK;
        this.f16441i = ViewCompat.MEASURED_STATE_MASK;
        this.f16442j = null;
        this.f16443k = null;
        this.f16445m = null;
        this.f16446n = null;
        this.f16447o = null;
        this.f16448p = null;
        this.f16449q = null;
        this.f16450r = new View.OnClickListener() { // from class: com.fimi.soul.view.sliding.FmSlidingTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmSlidingTabView.this.f16444l.setCurrentItem(((FmTabItemView) view).getIndex());
            }
        };
        this.f16434b = context;
        m6727a();
        this.f16449q = new FmFragmentPagerAdapter(((FragmentActivity) this.f16434b).getFragmentManager(), this.f16447o);
        this.f16444l.setAdapter(this.f16449q);
        this.f16444l.setOnPageChangeListener(new MyOnPageChangeListener());
        this.f16444l.setOffscreenPageLimit(3);
        addView(this.f16444l, new LinearLayout.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    private void m6722a(String str, int i) {
        m6721a(str, i, (Drawable) null);
    }

    /* renamed from: a */
    private void m6721a(String str, int i, Drawable drawable) {
        FmTabItemView fmTabItemView = new FmTabItemView(this.f16434b);
        if (this.f16438f != -1) {
            fmTabItemView.setTabBackgroundResource(this.f16438f);
        }
        if (drawable != null) {
            fmTabItemView.m6709a((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        }
        fmTabItemView.setTabTextColor(this.f16440h);
        fmTabItemView.setTabTextSize(this.f16439g);
        fmTabItemView.m6710a(i, str);
        this.f16448p.add(fmTabItemView.getTextView());
        fmTabItemView.setOnClickListener(this.f16450r);
        this.f16442j.addView(fmTabItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    /* renamed from: b */
    private void m6715b(int i) {
        final View childAt = this.f16442j.getChildAt(i);
        if (this.f16435c != null) {
            removeCallbacks(this.f16435c);
        }
        this.f16435c = new Runnable() { // from class: com.fimi.soul.view.sliding.FmSlidingTabView.2
            @Override // java.lang.Runnable
            public void run() {
                FmSlidingTabView.this.f16443k.smoothScrollTo(childAt.getLeft() - ((FmSlidingTabView.this.getWidth() - childAt.getWidth()) / 2), 0);
                FmSlidingTabView.this.f16435c = null;
            }
        };
        post(this.f16435c);
    }

    /* renamed from: a */
    public void m6727a() {
        setOrientation(1);
        setBackgroundColor(Color.rgb(255, 255, 255));
        this.f16443k = new HorizontalScrollView(this.f16434b);
        this.f16443k.setHorizontalScrollBarEnabled(false);
        this.f16443k.setSmoothScrollingEnabled(true);
        this.f16442j = new LinearLayout(this.f16434b);
        this.f16442j.setOrientation(0);
        this.f16442j.setGravity(17);
        this.f16443k.addView(this.f16442j, new ViewGroup.LayoutParams(-2, -1));
        addView(this.f16443k, new ViewGroup.LayoutParams(-1, -2));
        this.f16444l = new FmViewPager(this.f16434b);
        this.f16444l.setId(1985);
        this.f16447o = new ArrayList<>();
        this.f16448p = new ArrayList<>();
        this.f16445m = new ArrayList();
        this.f16446n = new ArrayList();
        if (!(this.f16434b instanceof FragmentActivity)) {
            C2266k.m12934c(FmSlidingTabView.class, "构造AbSlidingTabView的参数context,必须是FragmentActivity的实例。");
        }
    }

    /* renamed from: a */
    public void m6726a(int i) {
        this.f16442j.removeViewAt(i);
        this.f16447o.remove(i);
        this.f16448p.remove(i);
        this.f16446n.remove(i);
        this.f16445m.remove(i);
        this.f16449q.notifyDataSetChanged();
        m6716b();
    }

    /* renamed from: a */
    public void m6725a(int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.f16448p.size()) {
                this.f16448p.get(i6).setPadding(i, i2, i3, i4);
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m6720a(String str, Fragment fragment) {
        this.f16445m.add(str);
        this.f16447o.add(fragment);
        this.f16449q.notifyDataSetChanged();
        m6716b();
    }

    /* renamed from: a */
    public void m6719a(String str, Fragment fragment, Drawable drawable) {
        this.f16445m.add(str);
        this.f16447o.add(fragment);
        this.f16446n.add(drawable);
        this.f16449q.notifyDataSetChanged();
        m6716b();
    }

    /* renamed from: a */
    public void m6718a(List<String> list, List<Fragment> list2) {
        this.f16445m.addAll(list);
        this.f16447o.addAll(list2);
        this.f16449q.notifyDataSetChanged();
        m6716b();
    }

    /* renamed from: a */
    public void m6717a(List<String> list, List<Fragment> list2, List<Drawable> list3) {
        this.f16445m.addAll(list);
        this.f16447o.addAll(list2);
        this.f16446n.addAll(list3);
        this.f16449q.notifyDataSetChanged();
        m6716b();
    }

    /* renamed from: b */
    public void m6716b() {
        this.f16442j.removeAllViews();
        this.f16448p.clear();
        int count = this.f16449q.getCount();
        for (int i = 0; i < count; i++) {
            if (this.f16446n.size() > 0) {
                m6721a(this.f16445m.get(i), i, this.f16446n.get(i));
            } else {
                m6722a(this.f16445m.get(i), i);
            }
        }
        if (this.f16437e > count) {
            this.f16437e = count - 1;
        }
        setCurrentItem(this.f16437e);
        requestLayout();
    }

    /* renamed from: c */
    public void m6713c() {
        this.f16442j.removeAllViews();
        this.f16447o.clear();
        this.f16448p.clear();
        this.f16446n.clear();
        this.f16445m.clear();
        this.f16449q.notifyDataSetChanged();
        m6716b();
    }

    public ViewPager getViewPager() {
        return this.f16444l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16435c != null) {
            post(this.f16435c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f16435c != null) {
            removeCallbacks(this.f16435c);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        this.f16443k.setFillViewport(z);
        int childCount = this.f16442j.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f16433a = -1;
        } else if (childCount > 2) {
            this.f16433a = (int) (View.MeasureSpec.getSize(i) * 0.4f);
        } else {
            this.f16433a = View.MeasureSpec.getSize(i) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setCurrentItem(this.f16437e);
    }

    public void setCurrentItem(int i) {
        if (this.f16444l == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f16437e = i;
        int childCount = this.f16442j.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            FmTabItemView fmTabItemView = (FmTabItemView) this.f16442j.getChildAt(i2);
            boolean z = i2 == i;
            fmTabItemView.setSelected(z);
            if (z) {
                fmTabItemView.setTabTextColor(this.f16441i);
                m6715b(i);
            } else {
                fmTabItemView.setTabTextColor(this.f16440h);
            }
            i2++;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16436d = onPageChangeListener;
    }

    public void setSlidingEnabled(boolean z) {
        this.f16444l.setPagingEnabled(z);
    }

    public void setTabBackgroundResource(int i) {
        this.f16438f = i;
    }

    public void setTabLayoutBackgroundResource(int i) {
        this.f16442j.setBackgroundResource(i);
    }

    public void setTabSelectColor(int i) {
        this.f16441i = i;
    }

    public void setTabTextColor(int i) {
        this.f16440h = i;
    }

    public void setTabTextSize(int i) {
        this.f16439g = i;
    }
}
