package com.fimi.soul.view.wheelview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.module.p206a.C3046d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WheelView extends ScrollView {

    /* renamed from: a */
    public static final String f16503a = WheelView.class.getSimpleName();

    /* renamed from: c */
    public static final int f16504c = 1;

    /* renamed from: t */
    private static final int f16505t = 0;

    /* renamed from: u */
    private static final int f16506u = 1;

    /* renamed from: b */
    List<C3046d> f16507b;

    /* renamed from: e */
    int f16509e;

    /* renamed from: g */
    int f16511g;

    /* renamed from: h */
    Runnable f16512h;

    /* renamed from: k */
    int[] f16515k;

    /* renamed from: l */
    Paint f16516l;

    /* renamed from: m */
    int f16517m;

    /* renamed from: n */
    private Context f16518n;

    /* renamed from: o */
    private LinearLayout f16519o;

    /* renamed from: p */
    private int f16520p;

    /* renamed from: q */
    private int f16521q;

    /* renamed from: r */
    private int f16522r;

    /* renamed from: v */
    private float f16524v;

    /* renamed from: w */
    private AbstractC3884a f16525w;

    /* renamed from: d */
    int f16508d = 1;

    /* renamed from: f */
    int f16510f = 1;

    /* renamed from: i */
    int f16513i = 50;

    /* renamed from: j */
    int f16514j = 0;

    /* renamed from: s */
    private int f16523s = -1;

    /* renamed from: com.fimi.soul.view.wheelview.WheelView$a */
    /* loaded from: classes.dex */
    public interface AbstractC3884a {
        /* renamed from: a */
        void mo6674a(int i, Object obj);

        /* renamed from: h */
        void mo6673h();
    }

    public WheelView(Context context) {
        super(context);
        m6685a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6685a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6685a(context);
    }

    /* renamed from: a */
    private int m6688a(float f) {
        return (int) ((this.f16518n.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* renamed from: a */
    private int m6684a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }

    /* renamed from: a */
    private View m6683a(C3046d c3046d) {
        View inflate = LayoutInflater.from(this.f16518n).inflate(C2300R.layout.camera_menu_list_item, (ViewGroup) null);
        if (!c3046d.m9863d()) {
            ((TextView) inflate.findViewById(C2300R.C2302id.tv_lv_item_tag)).setText(c3046d.m9870a());
            ((TextView) inflate.findViewById(C2300R.C2302id.tv_lv_item_value)).setText(c3046d.m9867b());
            ((TextView) inflate.findViewById(C2300R.C2302id.tv_lv_item_default1)).setVisibility(8);
        } else {
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.tv_lv_item_default1);
            ((TextView) inflate.findViewById(C2300R.C2302id.tv_lv_item_tag)).setVisibility(8);
            ((TextView) inflate.findViewById(C2300R.C2302id.tv_lv_item_value)).setVisibility(8);
            textView.setText(c3046d.m9870a());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.wheelview.WheelView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheelView.this.f16525w.mo6673h();
                }
            });
        }
        if (this.f16514j == 0) {
            this.f16514j = m6684a(inflate);
            Log.d(f16503a, "itemHeight: " + this.f16514j);
            this.f16519o.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f16514j * this.f16509e));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.f16514j * this.f16509e));
        }
        return inflate;
    }

    /* renamed from: a */
    private void m6687a(int i) {
        int i2 = (i / this.f16514j) + this.f16508d;
        int i3 = i % this.f16514j;
        int i4 = i / this.f16514j;
        int i5 = i3 == 0 ? this.f16508d + i4 : i3 > this.f16514j / 2 ? this.f16508d + i4 + 1 : i2;
        int childCount = this.f16519o.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = this.f16519o.getChildAt(i6);
            if (childAt == null) {
                return;
            }
            TextView textView = (TextView) childAt.findViewById(C2300R.C2302id.tv_lv_item_tag);
            TextView textView2 = (TextView) childAt.findViewById(C2300R.C2302id.tv_lv_item_value);
            if (i5 == i6) {
                textView.setTextColor(this.f16520p);
                textView2.setTextColor(this.f16520p);
                if (this.f16525w != null) {
                    this.f16525w.mo6674a(i5, this.f16507b.get(i5));
                }
            } else {
                textView.setTextColor(this.f16521q);
                textView2.setTextColor(this.f16521q);
            }
        }
    }

    /* renamed from: a */
    private void m6685a(Context context) {
        this.f16518n = context;
        this.f16524v = context.getResources().getDimension(C2300R.dimen.camera_menu_line_margin);
        this.f16520p = context.getResources().getColor(C2300R.color.camera_menu_item_text_color_sel);
        this.f16521q = context.getResources().getColor(C2300R.color.camera_menu_item_text_color_def);
        Log.d(f16503a, "parent: " + getParent());
        setVerticalScrollBarEnabled(false);
        this.f16519o = new LinearLayout(context);
        this.f16519o.setOrientation(1);
        addView(this.f16519o);
        this.f16512h = new Runnable() { // from class: com.fimi.soul.view.wheelview.WheelView.1
            @Override // java.lang.Runnable
            public void run() {
                if (WheelView.this.f16511g - WheelView.this.getScrollY() != 0) {
                    WheelView.this.f16511g = WheelView.this.getScrollY();
                    WheelView.this.postDelayed(WheelView.this.f16512h, WheelView.this.f16513i);
                    return;
                }
                final int i = WheelView.this.f16511g % WheelView.this.f16514j;
                final int i2 = WheelView.this.f16511g / WheelView.this.f16514j;
                if (i == 0) {
                    WheelView.this.f16510f = i2 + WheelView.this.f16508d;
                    WheelView.this.m6676d();
                } else if (i > WheelView.this.f16514j / 2) {
                    WheelView.this.post(new Runnable() { // from class: com.fimi.soul.view.wheelview.WheelView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WheelView.this.smoothScrollTo(0, (WheelView.this.f16511g - i) + WheelView.this.f16514j);
                            WheelView.this.f16510f = i2 + WheelView.this.f16508d + 1;
                            WheelView.this.m6676d();
                        }
                    });
                } else {
                    WheelView.this.post(new Runnable() { // from class: com.fimi.soul.view.wheelview.WheelView.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            WheelView.this.smoothScrollTo(0, WheelView.this.f16511g - i);
                            WheelView.this.f16510f = i2 + WheelView.this.f16508d;
                            WheelView.this.m6676d();
                        }
                    });
                }
            }
        };
    }

    /* renamed from: b */
    private void m6680b() {
        this.f16509e = (this.f16508d * 2) + 1;
        for (C3046d c3046d : this.f16507b) {
            this.f16519o.addView(m6683a(c3046d));
        }
        m6687a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int[] m6678c() {
        if (this.f16515k == null) {
            this.f16515k = new int[2];
            this.f16515k[0] = this.f16514j * this.f16508d;
            this.f16515k[1] = this.f16514j * (this.f16508d + 1);
        }
        return this.f16515k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6676d() {
        if (this.f16525w != null) {
            this.f16525w.mo6674a(this.f16510f, this.f16507b.get(this.f16510f));
        }
    }

    private List<C3046d> getItems() {
        return this.f16507b;
    }

    /* renamed from: a */
    public void m6689a() {
        this.f16511g = getScrollY();
        postDelayed(this.f16512h, this.f16513i);
    }

    /* renamed from: a */
    public void m6686a(int i, String str) {
        View childAt;
        if (this.f16507b != null && this.f16507b.size() > 0) {
            this.f16507b.get(i).m9866b(str);
        }
        if (this.f16519o.getChildCount() <= 0 || (childAt = this.f16519o.getChildAt(i)) == null) {
            return;
        }
        ((TextView) childAt.findViewById(C2300R.C2302id.tv_lv_item_value)).setText(str);
    }

    /* renamed from: a */
    public void m6681a(String[] strArr) {
        if (this.f16507b == null || this.f16507b.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            this.f16507b.get(i2 + 1).m9866b(strArr[i2]);
            View childAt = this.f16519o.getChildAt(i2 + 1);
            if (childAt == null) {
                return;
            }
            ((TextView) childAt.findViewById(C2300R.C2302id.tv_lv_item_value)).setText(strArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    public int getOffset() {
        return this.f16508d;
    }

    public AbstractC3884a getOnWheelViewListener() {
        return this.f16525w;
    }

    public int getSeletedIndex() {
        return this.f16510f - this.f16508d;
    }

    public C3046d getSeletedItem() {
        return this.f16507b.get(this.f16510f);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m6687a(i2);
        if (i2 > i4) {
            this.f16523s = 1;
        } else {
            this.f16523s = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.d(f16503a, "w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4);
        this.f16517m = i;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m6689a();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f16517m == 0) {
            this.f16517m = ((Activity) this.f16518n).getWindowManager().getDefaultDisplay().getWidth();
            Log.d(f16503a, "viewWidth: " + this.f16517m);
        }
        if (this.f16516l == null) {
            this.f16516l = new Paint();
            this.f16516l.setColor(Color.parseColor("#00cc00"));
            this.f16516l.setStrokeWidth(m6688a(1.0f));
        }
        super.setBackgroundDrawable(new Drawable() { // from class: com.fimi.soul.view.wheelview.WheelView.3
            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                float f = WheelView.this.f16517m - WheelView.this.f16524v;
                canvas.drawLine(WheelView.this.f16524v, WheelView.this.m6678c()[0], f, WheelView.this.m6678c()[0], WheelView.this.f16516l);
                canvas.drawLine(WheelView.this.f16524v, WheelView.this.m6678c()[1], f, WheelView.this.m6678c()[1], WheelView.this.f16516l);
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

    public void setItems(List<C3046d> list) {
        if (this.f16507b == null) {
            this.f16507b = new ArrayList();
        }
        this.f16507b.clear();
        this.f16507b.addAll(list);
        for (int i = 0; i < this.f16508d; i++) {
            this.f16507b.add(0, new C3046d());
            C3046d c3046d = new C3046d();
            c3046d.m9865b(true);
            c3046d.m9869a(this.f16518n.getResources().getString(C2300R.C2303string.camera_menu_redefault));
            this.f16507b.add(c3046d);
        }
        m6680b();
    }

    public void setOffset(int i) {
        this.f16508d = i;
    }

    public void setOnWheelViewListener(AbstractC3884a abstractC3884a) {
        this.f16525w = abstractC3884a;
    }

    public void setSeletion(final int i) {
        this.f16510f = this.f16508d + i;
        post(new Runnable() { // from class: com.fimi.soul.view.wheelview.WheelView.4
            @Override // java.lang.Runnable
            public void run() {
                WheelView.this.smoothScrollTo(0, i * WheelView.this.f16514j);
            }
        });
    }
}
