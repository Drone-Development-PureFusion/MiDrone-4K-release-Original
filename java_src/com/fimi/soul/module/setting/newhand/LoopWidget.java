package com.fimi.soul.module.setting.newhand;

import android.content.Context;
import android.os.Handler;
import android.support.p001v4.view.PagerAdapter;
import android.support.p001v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fimi.soul.C2300R;
import com.p118d.p119a.p120a.p121a.p124b.C1865c;
import com.p118d.p119a.p127b.C1904c;
import com.p118d.p119a.p127b.C1914d;
import com.p118d.p119a.p127b.C1921e;
import com.p118d.p119a.p127b.p128a.EnumC1895g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LoopWidget extends FrameLayout {

    /* renamed from: a */
    private int f14007a;

    /* renamed from: b */
    private C1914d f14008b;

    /* renamed from: c */
    private List<ImageView> f14009c;

    /* renamed from: d */
    private Context f14010d;

    /* renamed from: e */
    private ViewPager f14011e;

    /* renamed from: f */
    private boolean f14012f;

    /* renamed from: g */
    private int f14013g;

    /* renamed from: h */
    private int f14014h;

    /* renamed from: i */
    private LinearLayout f14015i;

    /* renamed from: j */
    private List<ImageView> f14016j;

    /* renamed from: k */
    private Handler f14017k;

    /* renamed from: l */
    private C1904c f14018l;

    /* renamed from: m */
    private final Runnable f14019m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.module.setting.newhand.LoopWidget$a */
    /* loaded from: classes.dex */
    public class C3526a extends PagerAdapter {
        C3526a() {
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) LoopWidget.this.f14009c.get(i));
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public int getCount() {
            return LoopWidget.this.f14009c.size();
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) LoopWidget.this.f14009c.get(i));
            return LoopWidget.this.f14009c.get(i);
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.module.setting.newhand.LoopWidget$b */
    /* loaded from: classes.dex */
    public class C3527b implements ViewPager.OnPageChangeListener {
        C3527b() {
        }

        @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    if (LoopWidget.this.f14011e.getCurrentItem() == 0) {
                        LoopWidget.this.f14011e.setCurrentItem(LoopWidget.this.f14007a, false);
                    } else if (LoopWidget.this.f14011e.getCurrentItem() == LoopWidget.this.f14007a + 1) {
                        LoopWidget.this.f14011e.setCurrentItem(1, false);
                    }
                    LoopWidget.this.f14013g = LoopWidget.this.f14011e.getCurrentItem();
                    LoopWidget.this.f14012f = true;
                    return;
                case 1:
                    LoopWidget.this.f14012f = false;
                    return;
                case 2:
                    LoopWidget.this.f14012f = true;
                    return;
                default:
                    return;
            }
        }

        @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < LoopWidget.this.f14016j.size()) {
                    if (i3 == i - 1) {
                        ((ImageView) LoopWidget.this.f14016j.get(i3)).setImageResource(C2300R.C2301drawable.dot_focus);
                    } else {
                        ((ImageView) LoopWidget.this.f14016j.get(i3)).setImageResource(C2300R.C2301drawable.dot_blur);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public LoopWidget(Context context) {
        this(context, null);
    }

    public LoopWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoopWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14017k = new Handler();
        this.f14019m = new Runnable() { // from class: com.fimi.soul.module.setting.newhand.LoopWidget.1
            @Override // java.lang.Runnable
            public void run() {
                if (!LoopWidget.this.f14012f) {
                    LoopWidget.this.f14017k.postDelayed(LoopWidget.this.f14019m, 5000L);
                    return;
                }
                LoopWidget.this.f14013g = (LoopWidget.this.f14013g % (LoopWidget.this.f14007a + 1)) + 1;
                if (LoopWidget.this.f14013g == 1) {
                    LoopWidget.this.f14011e.setCurrentItem(LoopWidget.this.f14013g, false);
                    LoopWidget.this.f14017k.post(LoopWidget.this.f14019m);
                    return;
                }
                LoopWidget.this.f14011e.setCurrentItem(LoopWidget.this.f14013g);
                LoopWidget.this.f14017k.postDelayed(LoopWidget.this.f14019m, 2000L);
            }
        };
        this.f14010d = context;
        m8161a(context);
        m8162a();
    }

    /* renamed from: a */
    private void m8162a() {
        this.f14009c = new ArrayList();
        this.f14016j = new ArrayList();
        this.f14014h = 400;
    }

    /* renamed from: a */
    private void m8157a(int[] iArr) {
        this.f14007a = iArr.length;
        for (int i = 0; i < this.f14007a; i++) {
            ImageView imageView = new ImageView(this.f14010d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            imageView.setImageResource(C2300R.C2301drawable.dot_blur);
            this.f14015i.addView(imageView, layoutParams);
            this.f14016j.add(imageView);
        }
        this.f14016j.get(0).setImageResource(C2300R.C2301drawable.dot_focus);
        for (int i2 = 0; i2 <= this.f14007a + 1; i2++) {
            ImageView imageView2 = new ImageView(this.f14010d);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            if (i2 == 0) {
                imageView2.setImageResource(iArr[this.f14007a - 1]);
            } else if (i2 == this.f14007a + 1) {
                imageView2.setImageResource(iArr[0]);
            } else {
                imageView2.setImageResource(iArr[i2 - 1]);
            }
            this.f14009c.add(imageView2);
        }
    }

    /* renamed from: a */
    private void m8156a(String[] strArr) {
        this.f14007a = strArr.length;
        for (int i = 0; i < this.f14007a; i++) {
            ImageView imageView = new ImageView(this.f14010d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            imageView.setImageResource(C2300R.C2301drawable.dot_blur);
            this.f14015i.addView(imageView, layoutParams);
            this.f14016j.add(imageView);
        }
        this.f14016j.get(0).setImageResource(C2300R.C2301drawable.dot_focus);
        for (int i2 = 0; i2 <= this.f14007a + 1; i2++) {
            ImageView imageView2 = new ImageView(this.f14010d);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            if (i2 == 0) {
                this.f14008b.m14028a(strArr[this.f14007a - 1], imageView2, this.f14018l);
            } else if (i2 == this.f14007a + 1) {
                this.f14008b.m14028a(strArr[0], imageView2, this.f14018l);
            } else {
                this.f14008b.m14028a(strArr[i2 - 1], imageView2, this.f14018l);
            }
            this.f14009c.add(imageView2);
        }
    }

    /* renamed from: b */
    private void m8155b() {
        this.f14009c.clear();
        View inflate = LayoutInflater.from(this.f14010d).inflate(C2300R.layout.kanner_layout, (ViewGroup) this, true);
        this.f14011e = (ViewPager) inflate.findViewById(C2300R.C2302id.vp);
        this.f14015i = (LinearLayout) inflate.findViewById(C2300R.C2302id.ll_dot);
        this.f14015i.setVisibility(8);
        this.f14015i.removeAllViews();
    }

    /* renamed from: c */
    private void m8153c() {
        this.f14011e.setAdapter(new C3526a());
        this.f14011e.setFocusable(true);
        this.f14011e.setCurrentItem(1);
        this.f14013g = 1;
        this.f14011e.setOnPageChangeListener(new C3527b());
        m8151d();
    }

    /* renamed from: d */
    private void m8151d() {
        this.f14012f = true;
        this.f14017k.postDelayed(this.f14019m, 2000L);
    }

    /* renamed from: a */
    public void m8161a(Context context) {
        C1914d.m14036a().m14032a(new C1921e.C1923a(context).m13962b(3).m13976a().m13959b(new C1865c()).m13969a(EnumC1895g.LIFO).m13963b().m13956c());
        this.f14018l = new C1904c.C1906a().m14066b(true).m14057d(true).m14060d();
        this.f14008b = C1914d.m14036a();
    }

    public void setImagesRes(int[] iArr) {
        m8155b();
        m8157a(iArr);
        m8153c();
    }

    public void setImagesUrl(String[] strArr) {
        m8155b();
        m8156a(strArr);
        m8153c();
    }
}
