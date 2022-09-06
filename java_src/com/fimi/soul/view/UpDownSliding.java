package com.fimi.soul.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class UpDownSliding extends RelativeLayout {

    /* renamed from: B */
    private static final int f15646B = 1;

    /* renamed from: C */
    private static final int f15647C = 2;

    /* renamed from: r */
    private static final int f15648r = 0;

    /* renamed from: s */
    private static final int f15649s = 1;

    /* renamed from: t */
    private static final int f15650t = 2;

    /* renamed from: u */
    private static final int f15651u = 3;

    /* renamed from: y */
    private static int f15652y = -1;

    /* renamed from: z */
    private static int f15653z = -2130706433;

    /* renamed from: a */
    int f15656a;

    /* renamed from: b */
    int f15657b;

    /* renamed from: c */
    int f15658c;

    /* renamed from: d */
    int f15659d;

    /* renamed from: g */
    private int[] f15662g;

    /* renamed from: h */
    private int[] f15663h;

    /* renamed from: i */
    private int[] f15664i;

    /* renamed from: j */
    private LinearLayout[] f15665j;

    /* renamed from: k */
    private ImageView f15666k;

    /* renamed from: l */
    private VelocityTracker f15667l;

    /* renamed from: m */
    private TextView[] f15668m;

    /* renamed from: n */
    private AbstractC3757c f15669n;

    /* renamed from: v */
    private RelativeLayout.LayoutParams f15673v;

    /* renamed from: w */
    private RelativeLayout.LayoutParams f15674w;

    /* renamed from: x */
    private RelativeLayout.LayoutParams f15675x;

    /* renamed from: f */
    private String[] f15661f = {getResources().getString(C2300R.C2303string.record_title), getResources().getString(C2300R.C2303string.photograph), getResources().getString(C2300R.C2303string.stream_live)};

    /* renamed from: e */
    boolean f15660e = false;

    /* renamed from: o */
    private Boolean f15670o = false;

    /* renamed from: p */
    private EnumC3756b f15671p = EnumC3756b.TakePhoto;

    /* renamed from: q */
    private final int f15672q = 10;

    /* renamed from: A */
    private EnumC3756b f15654A = EnumC3756b.TakePhoto;

    /* renamed from: D */
    private Handler f15655D = new Handler() { // from class: com.fimi.soul.view.UpDownSliding.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    UpDownSliding.this.m7169a(EnumC3756b.TakePhoto, EnumC3756b.Live);
                    return;
                case 1:
                    UpDownSliding.this.m7169a(EnumC3756b.TakePhoto, EnumC3756b.Record);
                    return;
                case 2:
                    UpDownSliding.this.m7171a(2, EnumC3755a.DOWN, (Boolean) true);
                    return;
                case 3:
                    UpDownSliding.this.m7171a(1, EnumC3755a.UP, (Boolean) true);
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.view.UpDownSliding$a */
    /* loaded from: classes.dex */
    public enum EnumC3755a {
        UP,
        DOWN
    }

    /* renamed from: com.fimi.soul.view.UpDownSliding$b */
    /* loaded from: classes.dex */
    public enum EnumC3756b {
        Record(0),
        TakePhoto(1),
        Live(2);
        

        /* renamed from: d */
        private int f15691d;

        EnumC3756b(int i) {
            this.f15691d = i;
        }

        /* renamed from: a */
        public int m7159a() {
            return this.f15691d;
        }
    }

    /* renamed from: com.fimi.soul.view.UpDownSliding$c */
    /* loaded from: classes.dex */
    public interface AbstractC3757c {
        /* renamed from: a */
        void mo7158a(EnumC3756b enumC3756b);
    }

    public UpDownSliding(Context context) {
        super(context);
        m7170a(context);
    }

    public UpDownSliding(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7170a(context);
    }

    public UpDownSliding(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7170a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7169a(EnumC3756b enumC3756b, EnumC3756b enumC3756b2) {
        if (enumC3756b == EnumC3756b.Record && enumC3756b2 == EnumC3756b.TakePhoto) {
            m7171a(2, EnumC3755a.UP, (Boolean) false);
        } else if (enumC3756b == EnumC3756b.TakePhoto && enumC3756b2 == EnumC3756b.Live) {
            m7171a(1, EnumC3755a.UP, (Boolean) false);
        } else if (enumC3756b == EnumC3756b.Live && enumC3756b2 == EnumC3756b.TakePhoto) {
            m7171a(1, EnumC3755a.DOWN, (Boolean) false);
        } else if (enumC3756b == EnumC3756b.TakePhoto && enumC3756b2 == EnumC3756b.Record) {
            m7171a(2, EnumC3755a.DOWN, (Boolean) false);
        } else if (enumC3756b == EnumC3756b.Record && enumC3756b2 == EnumC3756b.Live) {
            m7169a(EnumC3756b.Record, EnumC3756b.TakePhoto);
            this.f15655D.sendEmptyMessageAtTime(0, 1000L);
        } else if (enumC3756b != EnumC3756b.Live || enumC3756b2 != EnumC3756b.Record) {
        } else {
            m7169a(EnumC3756b.Live, EnumC3756b.TakePhoto);
            this.f15655D.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* renamed from: a */
    public void m7171a(int i, EnumC3755a enumC3755a, Boolean bool) {
        ValueAnimator ofInt;
        ValueAnimator ofInt2;
        ValueAnimator ofInt3 = enumC3755a == EnumC3755a.DOWN ? ValueAnimator.ofInt(this.f15673v.topMargin, this.f15664i[i]) : ValueAnimator.ofInt(this.f15673v.topMargin, this.f15664i[i - 1]);
        switch (i) {
            case 1:
                if (enumC3755a == EnumC3755a.DOWN) {
                    ofInt2 = ValueAnimator.ofInt(0, this.f15663h[0]);
                    this.f15668m[0].setTextColor(f15653z);
                    this.f15668m[1].setTextColor(f15652y);
                    this.f15668m[2].setTextColor(f15653z);
                    this.f15671p = EnumC3756b.TakePhoto;
                } else {
                    ofInt2 = ValueAnimator.ofInt(this.f15663h[0], 0);
                    this.f15668m[0].setTextColor(f15653z);
                    this.f15668m[1].setTextColor(f15653z);
                    this.f15668m[2].setTextColor(f15652y);
                    this.f15671p = EnumC3756b.Live;
                }
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.UpDownSliding.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        UpDownSliding.this.f15673v.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        UpDownSliding.this.f15675x.leftMargin = (((Integer) valueAnimator.getAnimatedValue()).intValue() / (UpDownSliding.this.f15658c / UpDownSliding.this.f15659d)) + UpDownSliding.this.f15658c;
                        UpDownSliding.this.f15674w.leftMargin = UpDownSliding.this.f15663h[1] - (((Integer) valueAnimator.getAnimatedValue()).intValue() / (UpDownSliding.this.f15658c / UpDownSliding.this.f15659d));
                    }
                });
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.UpDownSliding.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        UpDownSliding.this.f15673v.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        UpDownSliding.this.f15675x.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue() + UpDownSliding.this.f15656a;
                        UpDownSliding.this.f15674w.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue() + (UpDownSliding.this.f15656a * 2);
                        UpDownSliding.this.f15665j[0].setLayoutParams(UpDownSliding.this.f15673v);
                        UpDownSliding.this.f15665j[1].setLayoutParams(UpDownSliding.this.f15675x);
                        UpDownSliding.this.f15665j[2].setLayoutParams(UpDownSliding.this.f15674w);
                    }
                });
                if (this.f15669n != null && bool.booleanValue()) {
                    this.f15669n.mo7158a(this.f15671p);
                    C2238c.m13123e().m12786a(this.f15671p.m7159a());
                }
                ofInt2.setDuration(250L);
                ofInt3.setDuration(250L);
                ofInt2.start();
                ofInt3.start();
                return;
            case 2:
                if (enumC3755a == EnumC3755a.DOWN) {
                    ofInt = ValueAnimator.ofInt(this.f15663h[0], this.f15663h[1]);
                    this.f15668m[0].setTextColor(f15652y);
                    this.f15668m[1].setTextColor(f15653z);
                    this.f15668m[2].setTextColor(f15653z);
                    this.f15671p = EnumC3756b.Record;
                } else {
                    ofInt = ValueAnimator.ofInt(this.f15663h[1], this.f15663h[0]);
                    this.f15668m[0].setTextColor(f15653z);
                    this.f15668m[1].setTextColor(f15652y);
                    this.f15668m[2].setTextColor(f15653z);
                    this.f15671p = EnumC3756b.TakePhoto;
                }
                ofInt.setDuration(500L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.UpDownSliding.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        UpDownSliding.this.f15673v.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        UpDownSliding.this.f15675x.leftMargin = UpDownSliding.this.f15663h[1] - (((Integer) valueAnimator.getAnimatedValue()).intValue() - UpDownSliding.this.f15663h[0]);
                        UpDownSliding.this.f15674w.leftMargin = (UpDownSliding.this.f15663h[1] - ((Integer) valueAnimator.getAnimatedValue()).intValue()) * (UpDownSliding.this.f15658c / UpDownSliding.this.f15659d);
                    }
                });
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.UpDownSliding.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        UpDownSliding.this.f15673v.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        UpDownSliding.this.f15675x.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue() + UpDownSliding.this.f15656a;
                        UpDownSliding.this.f15674w.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue() + (UpDownSliding.this.f15656a * 2);
                        UpDownSliding.this.f15665j[0].setLayoutParams(UpDownSliding.this.f15673v);
                        UpDownSliding.this.f15665j[1].setLayoutParams(UpDownSliding.this.f15675x);
                        UpDownSliding.this.f15665j[2].setLayoutParams(UpDownSliding.this.f15674w);
                    }
                });
                if (this.f15669n != null && bool.booleanValue()) {
                    this.f15669n.mo7158a(this.f15671p);
                    C2238c.m13123e().m12786a(this.f15671p.m7159a());
                }
                ofInt.setDuration(250L);
                ofInt3.setDuration(250L);
                ofInt.start();
                ofInt3.start();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m7170a(Context context) {
        this.f15656a = (int) getResources().getDimension(C2300R.dimen.updownsliding_top_margin);
        this.f15658c = (int) getResources().getDimension(C2300R.dimen.updownsliding_left_margin);
        this.f15659d = (int) getResources().getDimension(C2300R.dimen.updownsliding_left_second_margin);
        this.f15657b = (int) getResources().getDimension(C2300R.dimen.updownaliding_textsize);
        this.f15662g = new int[]{this.f15656a, this.f15656a * 2, this.f15656a * 3};
        this.f15663h = new int[]{this.f15658c, this.f15658c + this.f15659d, this.f15658c};
        this.f15664i = new int[]{0, this.f15656a, this.f15656a * 2};
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f15665j = new LinearLayout[3];
        this.f15668m = new TextView[3];
        for (final int i = 0; i < this.f15661f.length; i++) {
            this.f15665j[i] = new LinearLayout(context);
            this.f15668m[i] = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f15668m[i].setTextColor(-1);
            this.f15668m[i].setText(this.f15661f[i]);
            this.f15668m[i].setTextSize(0, this.f15657b);
            this.f15668m[i].setTextColor(f15653z);
            this.f15668m[i].setLayoutParams(layoutParams);
            this.f15668m[i].setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.UpDownSliding.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UpDownSliding.this.isEnabled() && i != UpDownSliding.this.f15671p.m7159a()) {
                        if (i == EnumC3756b.Record.m7159a() && UpDownSliding.this.f15671p == EnumC3756b.TakePhoto) {
                            UpDownSliding.this.m7171a(2, EnumC3755a.DOWN, (Boolean) true);
                        } else if (i == EnumC3756b.TakePhoto.m7159a() && UpDownSliding.this.f15671p == EnumC3756b.Record) {
                            UpDownSliding.this.m7171a(2, EnumC3755a.UP, (Boolean) true);
                        } else if (i == EnumC3756b.Record.m7159a() && UpDownSliding.this.f15671p == EnumC3756b.Live) {
                            UpDownSliding.this.m7171a(1, EnumC3755a.DOWN, (Boolean) false);
                            UpDownSliding.this.f15655D.sendEmptyMessageAtTime(2, 1000L);
                        } else if (i == EnumC3756b.TakePhoto.m7159a() && UpDownSliding.this.f15671p == EnumC3756b.Live) {
                            UpDownSliding.this.m7171a(1, EnumC3755a.DOWN, (Boolean) true);
                        } else if (i == EnumC3756b.Live.m7159a() && UpDownSliding.this.f15671p == EnumC3756b.Record) {
                            UpDownSliding.this.m7171a(2, EnumC3755a.UP, (Boolean) false);
                            UpDownSliding.this.f15655D.sendEmptyMessageAtTime(3, 1000L);
                        } else if (i != EnumC3756b.Live.m7159a() || UpDownSliding.this.f15671p != EnumC3756b.TakePhoto) {
                        } else {
                            UpDownSliding.this.m7171a(1, EnumC3755a.UP, (Boolean) true);
                        }
                    }
                }
            });
            C3658ar.m7612a(context.getAssets(), this.f15668m[i]);
            this.f15668m[i].getPaint().setFakeBoldText(true);
            this.f15665j[i].setId(i + 100);
            this.f15665j[i].addView(this.f15668m[i]);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = this.f15662g[i];
            layoutParams2.leftMargin = this.f15663h[i];
            this.f15665j[i].setLayoutParams(layoutParams2);
            relativeLayout.addView(this.f15665j[i]);
        }
        relativeLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.f15668m[0].getMeasuredHeight();
        int measuredWidth = this.f15668m[0].getMeasuredWidth();
        this.f15668m[1].setTextColor(f15652y);
        if (C2367d.m12459a().m12438k()) {
            this.f15668m[2].setVisibility(8);
        } else {
            this.f15668m[2].setVisibility(0);
        }
        this.f15666k = new ImageView(context);
        this.f15666k.setBackgroundResource(C2300R.C2301drawable.mode_selected_dot);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        int dimension = (int) getResources().getDimension(C2300R.dimen.updownsliding_dot_diameter);
        layoutParams3.height = dimension;
        layoutParams3.width = dimension;
        layoutParams3.topMargin = ((this.f15656a * 2) + (measuredHeight / 2)) - (dimension / 2);
        layoutParams3.leftMargin = (int) (measuredWidth + this.f15663h[1] + getResources().getDimension(C2300R.dimen.updownsliding_dot_text) + (dimension / 5));
        this.f15666k.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.f15666k);
        addView(relativeLayout);
        this.f15673v = (RelativeLayout.LayoutParams) this.f15665j[0].getLayoutParams();
        this.f15675x = (RelativeLayout.LayoutParams) this.f15665j[1].getLayoutParams();
        this.f15674w = (RelativeLayout.LayoutParams) this.f15665j[2].getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams4.height = ((this.f15656a * 2) + (measuredHeight / 2)) * 2;
        relativeLayout.setLayoutParams(layoutParams4);
    }

    /* renamed from: b */
    public void m7166b(Context context) {
        this.f15668m[2].setVisibility(0);
    }

    public EnumC3756b getCurrentState() {
        EnumC3756b enumC3756b = EnumC3756b.Record;
        switch (C2238c.m13123e().m12775c()) {
            case 0:
                return EnumC3756b.Record;
            case 1:
                return EnumC3756b.TakePhoto;
            case 2:
                return EnumC3756b.Live;
            default:
                return enumC3756b;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f15667l == null) {
                    this.f15667l = VelocityTracker.obtain();
                } else {
                    this.f15667l.clear();
                }
                this.f15667l.addMovement(motionEvent);
                this.f15660e = true;
                break;
            case 1:
                this.f15667l.recycle();
                this.f15667l = null;
                break;
            case 2:
                this.f15667l.addMovement(motionEvent);
                this.f15667l.computeCurrentVelocity(1000);
                if (Math.abs(this.f15667l.getYVelocity()) >= 10.0f) {
                    if (this.f15660e) {
                        this.f15660e = false;
                        if (this.f15667l.getYVelocity() <= 0.0f) {
                            if (this.f15667l.getYVelocity() < 0.0f) {
                                int i = 0;
                                while (true) {
                                    if (i >= this.f15664i.length) {
                                        i = 0;
                                    } else if (this.f15664i[i] != this.f15673v.topMargin) {
                                        i++;
                                    }
                                }
                                if (i != 0) {
                                    if (i == 1) {
                                        this.f15654A = EnumC3756b.Live;
                                    }
                                    if (i == 2) {
                                        this.f15654A = EnumC3756b.TakePhoto;
                                    }
                                    m7171a(i, EnumC3755a.UP, (Boolean) true);
                                    break;
                                } else {
                                    return super.onTouchEvent(motionEvent);
                                }
                            }
                        } else {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= this.f15664i.length) {
                                    i2 = 0;
                                } else if (this.f15664i[i2] != this.f15673v.topMargin) {
                                    i2++;
                                }
                            }
                            if (i2 != 2) {
                                if (i2 + 1 == 1) {
                                    this.f15654A = EnumC3756b.TakePhoto;
                                }
                                if (i2 + 1 == 2) {
                                    this.f15654A = EnumC3756b.Record;
                                }
                                m7171a(i2 + 1, EnumC3755a.DOWN, (Boolean) true);
                                break;
                            } else {
                                return super.onTouchEvent(motionEvent);
                            }
                        }
                    }
                } else {
                    return super.onTouchEvent(motionEvent);
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnUpDownSliding(AbstractC3757c abstractC3757c) {
        this.f15669n = abstractC3757c;
    }

    public void setState(EnumC3756b enumC3756b) {
        if (enumC3756b == this.f15654A) {
            return;
        }
        this.f15654A = enumC3756b;
        if (this.f15670o.booleanValue()) {
            m7169a(this.f15671p, enumC3756b);
            return;
        }
        this.f15670o = true;
        switch (enumC3756b) {
            case Record:
                this.f15673v.topMargin = this.f15662g[1];
                this.f15675x.topMargin = this.f15662g[2];
                this.f15674w.topMargin = this.f15656a * 4;
                this.f15673v.leftMargin = this.f15663h[1];
                this.f15675x.leftMargin = this.f15663h[2];
                this.f15674w.leftMargin = 0;
                this.f15668m[0].setTextColor(f15652y);
                this.f15668m[1].setTextColor(f15653z);
                this.f15668m[2].setTextColor(f15653z);
                this.f15671p = EnumC3756b.Record;
                break;
            case TakePhoto:
                this.f15673v.topMargin = this.f15662g[0];
                this.f15675x.topMargin = this.f15662g[1];
                this.f15674w.topMargin = this.f15662g[2];
                this.f15673v.leftMargin = this.f15663h[0];
                this.f15675x.leftMargin = this.f15663h[1];
                this.f15674w.leftMargin = this.f15663h[2];
                this.f15668m[0].setTextColor(f15653z);
                this.f15668m[1].setTextColor(f15652y);
                this.f15668m[2].setTextColor(f15653z);
                this.f15671p = EnumC3756b.TakePhoto;
                break;
            case Live:
                this.f15673v.topMargin = 0;
                this.f15675x.topMargin = this.f15662g[0];
                this.f15674w.topMargin = this.f15662g[1];
                this.f15673v.leftMargin = 0;
                this.f15675x.leftMargin = this.f15663h[0];
                this.f15674w.leftMargin = this.f15663h[1];
                this.f15668m[0].setTextColor(f15653z);
                this.f15668m[1].setTextColor(f15653z);
                this.f15668m[2].setTextColor(f15652y);
                this.f15671p = EnumC3756b.Live;
                break;
        }
        this.f15665j[0].setLayoutParams(this.f15673v);
        this.f15665j[1].setLayoutParams(this.f15675x);
        this.f15665j[2].setLayoutParams(this.f15674w);
    }
}
