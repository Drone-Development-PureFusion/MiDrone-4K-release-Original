package p244m.framework.p247ui.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
/* renamed from: m.framework.ui.widget.pulltorefresh.PullToRefreshView */
/* loaded from: classes2.dex */
public class PullToRefreshView extends RelativeLayout {

    /* renamed from: a */
    private static final long f21337a = 1000;

    /* renamed from: b */
    private AbstractC4977d f21338b;

    /* renamed from: c */
    private View f21339c;

    /* renamed from: d */
    private View f21340d;

    /* renamed from: e */
    private int f21341e;

    /* renamed from: f */
    private int f21342f;

    /* renamed from: g */
    private float f21343g;

    /* renamed from: h */
    private boolean f21344h;

    /* renamed from: i */
    private boolean f21345i;

    /* renamed from: j */
    private Runnable f21346j;

    /* renamed from: k */
    private long f21347k;

    public PullToRefreshView(Context context) {
        super(context);
        m2429d();
    }

    public PullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2429d();
    }

    public PullToRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2429d();
    }

    /* renamed from: a */
    private MotionEvent m2435a(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* renamed from: d */
    private void m2429d() {
        this.f21346j = new Runnable() { // from class: m.framework.ui.widget.pulltorefresh.PullToRefreshView.1
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshView.this.m2426g();
                PullToRefreshView.this.m2427f();
            }
        };
    }

    /* renamed from: e */
    private void m2428e() {
        this.f21347k = System.currentTimeMillis();
        this.f21344h = true;
        if (this.f21338b != null) {
            this.f21338b.m2409g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2427f() {
        this.f21344h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2426g() {
        this.f21342f = 0;
        scrollTo(0, 0);
        if (this.f21338b != null) {
            this.f21338b.m2408h();
        }
    }

    /* renamed from: h */
    private boolean m2425h() {
        return !this.f21345i && this.f21338b.mo2372f();
    }

    /* renamed from: a */
    public void m2436a() {
        long currentTimeMillis = System.currentTimeMillis() - this.f21347k;
        if (currentTimeMillis < 1000) {
            postDelayed(this.f21346j, 1000 - currentTimeMillis);
        } else {
            post(this.f21346j);
        }
    }

    /* renamed from: a */
    public void m2433a(boolean z) {
        this.f21342f = this.f21341e;
        scrollTo(0, -this.f21342f);
        if (z) {
            m2428e();
        }
    }

    /* renamed from: b */
    public void m2432b() {
        this.f21345i = true;
    }

    /* renamed from: c */
    public void m2430c() {
        this.f21345i = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f21343g = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.f21344h) {
                    this.f21342f = this.f21341e;
                    scrollTo(0, -this.f21342f);
                    break;
                } else if (this.f21342f <= this.f21341e) {
                    if (this.f21342f != 0) {
                        m2426g();
                        if (this.f21338b != null) {
                            this.f21338b.m2412a(0);
                            break;
                        }
                    }
                } else {
                    this.f21342f = this.f21341e;
                    scrollTo(0, -this.f21342f);
                    if (this.f21338b != null) {
                        this.f21338b.m2412a(100);
                    }
                    m2428e();
                    motionEvent = m2435a(motionEvent);
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.f21344h || m2425h()) {
                    this.f21342f = (int) (this.f21342f + ((y - this.f21343g) / 2.0f));
                    if (this.f21342f > 0) {
                        scrollTo(0, -this.f21342f);
                        if (!this.f21344h && this.f21338b != null) {
                            this.f21338b.m2412a((this.f21342f * 100) / this.f21341e);
                        }
                        motionEvent = m2435a(motionEvent);
                    } else {
                        this.f21342f = 0;
                        scrollTo(0, 0);
                    }
                }
                this.f21343g = y;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setAdapter(AbstractC4977d abstractC4977d) {
        this.f21338b = abstractC4977d;
        removeAllViews();
        this.f21340d = (View) abstractC4977d.mo2373e();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(10, -1);
        addView(this.f21340d, layoutParams);
        this.f21339c = abstractC4977d.m2410d();
        this.f21339c.measure(0, 0);
        this.f21341e = this.f21339c.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.f21341e);
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(10, -1);
        layoutParams2.topMargin = -this.f21341e;
        addView(this.f21339c, layoutParams2);
    }
}
