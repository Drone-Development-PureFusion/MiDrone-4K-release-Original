package com.fimi.soul.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class UIRefreshEXPView extends ExpandableListView implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private static final String f15562a = "MM-dd HH:mm";

    /* renamed from: b */
    private static final int f15563b = 3;

    /* renamed from: c */
    private static final int f15564c = 0;

    /* renamed from: d */
    private static final int f15565d = 1;

    /* renamed from: e */
    private static final int f15566e = 2;

    /* renamed from: f */
    private static final int f15567f = 3;

    /* renamed from: g */
    private static final int f15568g = 4;

    /* renamed from: h */
    private static final int f15569h = 1;

    /* renamed from: i */
    private static final int f15570i = 2;

    /* renamed from: j */
    private static final int f15571j = 3;

    /* renamed from: A */
    private RotateAnimation f15572A;

    /* renamed from: B */
    private boolean f15573B;

    /* renamed from: C */
    private int f15574C;

    /* renamed from: D */
    private int f15575D;

    /* renamed from: E */
    private int f15576E;

    /* renamed from: F */
    private boolean f15577F;

    /* renamed from: G */
    private int f15578G;

    /* renamed from: H */
    private int f15579H;

    /* renamed from: I */
    private int f15580I;

    /* renamed from: J */
    private boolean f15581J;

    /* renamed from: K */
    private AbstractC3742c f15582K;

    /* renamed from: L */
    private AbstractC3741b f15583L;

    /* renamed from: M */
    private AbstractC3740a f15584M;

    /* renamed from: k */
    private int f15585k;

    /* renamed from: l */
    private int f15586l;

    /* renamed from: m */
    private boolean f15587m = false;

    /* renamed from: n */
    private boolean f15588n = false;

    /* renamed from: o */
    private boolean f15589o = true;

    /* renamed from: p */
    private boolean f15590p = false;

    /* renamed from: q */
    private LayoutInflater f15591q;

    /* renamed from: r */
    private LinearLayout f15592r;

    /* renamed from: s */
    private TextView f15593s;

    /* renamed from: t */
    private TextView f15594t;

    /* renamed from: u */
    private ImageView f15595u;

    /* renamed from: v */
    private ProgressBar f15596v;

    /* renamed from: w */
    private View f15597w;

    /* renamed from: x */
    private ProgressBar f15598x;

    /* renamed from: y */
    private TextView f15599y;

    /* renamed from: z */
    private RotateAnimation f15600z;

    /* renamed from: com.fimi.soul.view.UIRefreshEXPView$a */
    /* loaded from: classes.dex */
    public interface AbstractC3740a {
        /* renamed from: a */
        void m7203a(AbsListView absListView, int i);

        /* renamed from: a */
        void m7202a(AbsListView absListView, int i, int i2, int i3);
    }

    /* renamed from: com.fimi.soul.view.UIRefreshEXPView$b */
    /* loaded from: classes.dex */
    public interface AbstractC3741b {
        /* renamed from: a */
        void m7201a();
    }

    /* renamed from: com.fimi.soul.view.UIRefreshEXPView$c */
    /* loaded from: classes.dex */
    public interface AbstractC3742c {
        /* renamed from: a */
        void m7200a();
    }

    public UIRefreshEXPView(Context context) {
        super(context);
        m7225a(context);
    }

    public UIRefreshEXPView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7225a(context);
    }

    public UIRefreshEXPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7225a(context);
    }

    /* renamed from: a */
    private void m7226a(int i) {
        if (i <= 0) {
            i = 250;
        }
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f15600z = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f15600z.setInterpolator(linearInterpolator);
        this.f15600z.setDuration(i);
        this.f15600z.setFillAfter(true);
        this.f15572A = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f15572A.setInterpolator(linearInterpolator);
        this.f15572A.setDuration(i);
        this.f15572A.setFillAfter(true);
    }

    /* renamed from: a */
    private void m7225a(Context context) {
        setCacheColorHint(context.getResources().getColor(AsyncImageView.f21295a));
        this.f15591q = LayoutInflater.from(context);
        m7209h();
        m7208i();
        setOnScrollListener(this);
        m7226a(0);
    }

    /* renamed from: a */
    private void m7224a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* renamed from: h */
    private void m7209h() {
        this.f15592r = (LinearLayout) this.f15591q.inflate(C2300R.layout.rebound_listview_header, (ViewGroup) null);
        this.f15595u = (ImageView) this.f15592r.findViewById(C2300R.C2302id.head_arrowImageView);
        this.f15595u.setMinimumWidth(70);
        this.f15595u.setMinimumHeight(50);
        this.f15596v = (ProgressBar) this.f15592r.findViewById(C2300R.C2302id.head_progressBar);
        this.f15593s = (TextView) this.f15592r.findViewById(C2300R.C2302id.head_tipsTextView);
        this.f15594t = (TextView) this.f15592r.findViewById(C2300R.C2302id.head_lastUpdatedTextView);
        m7224a(this.f15592r);
        this.f15575D = this.f15592r.getMeasuredHeight();
        this.f15574C = this.f15592r.getMeasuredWidth();
        this.f15592r.setPadding(0, this.f15575D * (-1), 0, 0);
        this.f15592r.invalidate();
        Log.v("size", "width:" + this.f15574C + " height:" + this.f15575D);
        addHeaderView(this.f15592r, null, false);
        this.f15585k = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7208i() {
        this.f15597w = this.f15591q.inflate(C2300R.layout.rebound_listview_footer, (ViewGroup) null);
        this.f15597w.setVisibility(0);
        this.f15598x = (ProgressBar) this.f15597w.findViewById(C2300R.C2302id.pull_to_refresh_progress);
        this.f15599y = (TextView) this.f15597w.findViewById(C2300R.C2302id.load_more);
        this.f15597w.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.UIRefreshEXPView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UIRefreshEXPView.this.f15587m) {
                    if (!UIRefreshEXPView.this.f15588n) {
                        if (UIRefreshEXPView.this.f15586l == 1) {
                            return;
                        }
                        UIRefreshEXPView.this.f15586l = 1;
                        UIRefreshEXPView.this.m7204m();
                    } else if (UIRefreshEXPView.this.f15586l == 1 || UIRefreshEXPView.this.f15585k == 2) {
                    } else {
                        UIRefreshEXPView.this.f15586l = 1;
                        UIRefreshEXPView.this.m7204m();
                    }
                }
            }
        });
        addFooterView(this.f15597w);
        if (this.f15589o) {
            this.f15586l = 3;
        } else {
            this.f15586l = 2;
        }
    }

    /* renamed from: j */
    private void m7207j() {
        if (this.f15587m) {
            switch (this.f15586l) {
                case 1:
                    if (this.f15599y.getText().equals(Integer.valueOf((int) C2300R.C2303string.refresh_doing_end_refresh))) {
                        return;
                    }
                    this.f15599y.setText(C2300R.C2303string.refresh_doing_end_refresh);
                    this.f15599y.setVisibility(0);
                    this.f15598x.setVisibility(0);
                    return;
                case 2:
                    this.f15599y.setText(C2300R.C2303string.refresh_end_click_load_more);
                    this.f15599y.setVisibility(0);
                    this.f15598x.setVisibility(8);
                    this.f15597w.setVisibility(0);
                    return;
                case 3:
                    this.f15599y.setText(C2300R.C2303string.refresh_end_load_more);
                    this.f15599y.setVisibility(0);
                    this.f15598x.setVisibility(8);
                    this.f15597w.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: k */
    private void m7206k() {
        switch (this.f15585k) {
            case 0:
                this.f15595u.setVisibility(0);
                this.f15596v.setVisibility(8);
                this.f15593s.setVisibility(0);
                this.f15594t.setVisibility(0);
                this.f15595u.clearAnimation();
                this.f15595u.startAnimation(this.f15600z);
                this.f15593s.setText(C2300R.C2303string.refresh_release_refresh);
                return;
            case 1:
                this.f15596v.setVisibility(8);
                this.f15593s.setVisibility(0);
                this.f15594t.setVisibility(0);
                this.f15595u.clearAnimation();
                this.f15595u.setVisibility(0);
                if (!this.f15577F) {
                    this.f15593s.setText(C2300R.C2303string.refresh_pull_to_refresh);
                    return;
                }
                this.f15577F = false;
                this.f15595u.clearAnimation();
                this.f15595u.startAnimation(this.f15572A);
                this.f15593s.setText(C2300R.C2303string.refresh_pull_to_refresh);
                return;
            case 2:
                this.f15592r.setPadding(0, 0, 0, 0);
                this.f15596v.setVisibility(0);
                this.f15595u.clearAnimation();
                this.f15595u.setVisibility(8);
                this.f15593s.setText(C2300R.C2303string.refresh_doing_head_refresh);
                this.f15594t.setVisibility(0);
                return;
            case 3:
                this.f15592r.setPadding(0, this.f15575D * (-1), 0, 0);
                this.f15596v.setVisibility(8);
                this.f15595u.clearAnimation();
                this.f15595u.setImageResource(C2300R.C2301drawable.uet_rebound_listview_arrow);
                this.f15593s.setText(C2300R.C2303string.refresh_pull_to_refresh);
                this.f15594t.setVisibility(0);
                return;
            default:
                return;
        }
    }

    /* renamed from: l */
    private void m7205l() {
        if (this.f15582K != null) {
            this.f15582K.m7200a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m7204m() {
        if (this.f15583L != null) {
            this.f15599y.setText(C2300R.C2303string.refresh_doing_end_refresh);
            this.f15599y.setVisibility(0);
            this.f15598x.setVisibility(0);
            this.f15583L.m7201a();
        }
    }

    /* renamed from: a */
    public boolean m7227a() {
        return this.f15587m;
    }

    /* renamed from: b */
    public boolean m7221b() {
        return this.f15588n;
    }

    /* renamed from: c */
    public boolean m7219c() {
        return this.f15589o;
    }

    /* renamed from: d */
    public boolean m7217d() {
        return this.f15590p;
    }

    /* renamed from: e */
    public void m7215e() {
        if (this.f15590p) {
            setSelection(0);
        }
        this.f15585k = 3;
        this.f15594t.setText(getResources().getString(C2300R.C2303string.refresh_refresh_lasttime) + new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date()));
        m7206k();
    }

    /* renamed from: f */
    public void m7213f() {
        if (this.f15589o) {
            this.f15586l = 3;
        } else {
            this.f15586l = 2;
        }
        m7207j();
    }

    /* renamed from: g */
    public void m7211g() {
        removeFooterView(this.f15597w);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f15578G = i;
        this.f15579H = (i + i2) - 2;
        this.f15580I = i3 - 2;
        if (i3 > i2) {
            this.f15581J = true;
        } else {
            this.f15581J = false;
        }
        if (this.f15584M != null) {
            this.f15584M.m7202a(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f15587m) {
            if (this.f15579H == this.f15580I && i == 0 && this.f15586l != 1) {
                if (!this.f15589o) {
                    this.f15586l = 2;
                    m7207j();
                } else if (!this.f15588n) {
                    this.f15586l = 1;
                    m7204m();
                    m7207j();
                } else if (this.f15585k != 2) {
                    this.f15586l = 1;
                    m7204m();
                    m7207j();
                }
            }
        } else if (this.f15597w != null && this.f15597w.getVisibility() == 0) {
            System.out.println("this.removeFooterView(endRootView);...");
            this.f15597w.setVisibility(8);
            removeFooterView(this.f15597w);
        }
        if (this.f15584M != null) {
            this.f15584M.m7203a(absListView, i);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f15588n) {
            if (this.f15587m && this.f15586l == 1) {
                return super.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.f15578G == 0 && !this.f15573B) {
                        this.f15573B = true;
                        this.f15576E = (int) motionEvent.getY();
                        break;
                    }
                    break;
                case 1:
                    if (this.f15585k != 2 && this.f15585k != 4) {
                        if (this.f15585k == 3) {
                        }
                        if (this.f15585k == 1) {
                            this.f15585k = 3;
                            m7206k();
                        }
                        if (this.f15585k == 0) {
                            this.f15585k = 2;
                            m7206k();
                            m7205l();
                        }
                    }
                    this.f15573B = false;
                    this.f15577F = false;
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.f15573B && this.f15578G == 0) {
                        this.f15573B = true;
                        this.f15576E = y;
                    }
                    if (this.f15585k != 2 && this.f15573B && this.f15585k != 4) {
                        if (this.f15585k == 0) {
                            setSelection(0);
                            if ((y - this.f15576E) / 3 < this.f15575D && y - this.f15576E > 0) {
                                this.f15585k = 1;
                                m7206k();
                            } else if (y - this.f15576E <= 0) {
                                this.f15585k = 3;
                                m7206k();
                            }
                        }
                        if (this.f15585k == 1) {
                            setSelection(0);
                            if ((y - this.f15576E) / 3 >= this.f15575D) {
                                this.f15585k = 0;
                                this.f15577F = true;
                                m7206k();
                            } else if (y - this.f15576E <= 0) {
                                this.f15585k = 3;
                                m7206k();
                            }
                        }
                        if (this.f15585k == 3 && y - this.f15576E > 0) {
                            this.f15585k = 1;
                            m7206k();
                        }
                        if (this.f15585k == 1) {
                            this.f15592r.setPadding(0, (this.f15575D * (-1)) + ((y - this.f15576E) / 3), 0, 0);
                        }
                        if (this.f15585k == 0) {
                            this.f15592r.setPadding(0, ((y - this.f15576E) / 3) - this.f15575D, 0, 0);
                            break;
                        }
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.f15594t.setText(getResources().getString(C2300R.C2303string.refresh_refresh_lasttime) + new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date()));
        super.setAdapter((ListAdapter) baseAdapter);
    }

    public void setAutoLoadMore(boolean z) {
        this.f15589o = z;
    }

    public void setCanLoadMore(final boolean z) {
        this.f15587m = z;
        if (this.f15597w == null) {
            m7208i();
        }
        this.f15597w.post(new Runnable() { // from class: com.fimi.soul.view.UIRefreshEXPView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!z || UIRefreshEXPView.this.getFooterViewsCount() != 0) {
                    UIRefreshEXPView.this.m7211g();
                } else {
                    UIRefreshEXPView.this.m7208i();
                }
                UIRefreshEXPView.this.f15597w.setVisibility(z ? 0 : 8);
                UIRefreshEXPView.this.f15597w.setPadding(0, z ? 0 : -UIRefreshEXPView.this.f15597w.getHeight(), 0, 0);
            }
        });
    }

    public void setCanRefresh(boolean z) {
        this.f15588n = z;
    }

    public void setListViewOnScrollListener(AbstractC3740a abstractC3740a) {
        this.f15584M = abstractC3740a;
    }

    public void setMoveToFirstItemAfterRefresh(boolean z) {
        this.f15590p = z;
    }

    public void setOnLoadListener(AbstractC3741b abstractC3741b) {
        if (abstractC3741b != null) {
            this.f15583L = abstractC3741b;
            if (!this.f15587m || getFooterViewsCount() != 0) {
                return;
            }
            m7208i();
        }
    }

    public void setOnRefreshListener(AbstractC3742c abstractC3742c) {
        if (abstractC3742c != null) {
            this.f15582K = abstractC3742c;
        }
    }
}
