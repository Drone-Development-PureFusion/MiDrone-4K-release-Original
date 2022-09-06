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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class UIRefreshListView extends ListView implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private static final String f15604a = "MM-dd HH:mm";

    /* renamed from: b */
    private static final int f15605b = 3;

    /* renamed from: c */
    private static final int f15606c = 0;

    /* renamed from: d */
    private static final int f15607d = 1;

    /* renamed from: e */
    private static final int f15608e = 2;

    /* renamed from: f */
    private static final int f15609f = 3;

    /* renamed from: g */
    private static final int f15610g = 4;

    /* renamed from: h */
    private static final int f15611h = 1;

    /* renamed from: i */
    private static final int f15612i = 2;

    /* renamed from: j */
    private static final int f15613j = 3;

    /* renamed from: A */
    private RotateAnimation f15614A;

    /* renamed from: B */
    private boolean f15615B;

    /* renamed from: C */
    private int f15616C;

    /* renamed from: D */
    private int f15617D;

    /* renamed from: E */
    private int f15618E;

    /* renamed from: F */
    private boolean f15619F;

    /* renamed from: G */
    private int f15620G;

    /* renamed from: H */
    private int f15621H;

    /* renamed from: I */
    private int f15622I;

    /* renamed from: J */
    private boolean f15623J;

    /* renamed from: K */
    private AbstractC3747c f15624K;

    /* renamed from: L */
    private AbstractC3746b f15625L;

    /* renamed from: M */
    private AbstractC3745a f15626M;

    /* renamed from: k */
    private int f15627k;

    /* renamed from: l */
    private int f15628l;

    /* renamed from: m */
    private boolean f15629m = false;

    /* renamed from: n */
    private boolean f15630n = false;

    /* renamed from: o */
    private boolean f15631o = true;

    /* renamed from: p */
    private boolean f15632p = false;

    /* renamed from: q */
    private LayoutInflater f15633q;

    /* renamed from: r */
    private LinearLayout f15634r;

    /* renamed from: s */
    private TextView f15635s;

    /* renamed from: t */
    private TextView f15636t;

    /* renamed from: u */
    private ImageView f15637u;

    /* renamed from: v */
    private ProgressBar f15638v;

    /* renamed from: w */
    private View f15639w;

    /* renamed from: x */
    private ProgressBar f15640x;

    /* renamed from: y */
    private TextView f15641y;

    /* renamed from: z */
    private RotateAnimation f15642z;

    /* renamed from: com.fimi.soul.view.UIRefreshListView$a */
    /* loaded from: classes.dex */
    public interface AbstractC3745a {
        /* renamed from: a */
        void m7175a(AbsListView absListView, int i);

        /* renamed from: a */
        void m7174a(AbsListView absListView, int i, int i2, int i3);
    }

    /* renamed from: com.fimi.soul.view.UIRefreshListView$b */
    /* loaded from: classes.dex */
    public interface AbstractC3746b {
        /* renamed from: a */
        void m7173a();
    }

    /* renamed from: com.fimi.soul.view.UIRefreshListView$c */
    /* loaded from: classes.dex */
    public interface AbstractC3747c {
        /* renamed from: a */
        void m7172a();
    }

    public UIRefreshListView(Context context) {
        super(context);
        m7197a(context);
    }

    public UIRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7197a(context);
    }

    public UIRefreshListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7197a(context);
    }

    /* renamed from: a */
    private void m7198a(int i) {
        if (i <= 0) {
            i = 250;
        }
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f15642z = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f15642z.setInterpolator(linearInterpolator);
        this.f15642z.setDuration(i);
        this.f15642z.setFillAfter(true);
        this.f15614A = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f15614A.setInterpolator(linearInterpolator);
        this.f15614A.setDuration(i);
        this.f15614A.setFillAfter(true);
    }

    /* renamed from: a */
    private void m7197a(Context context) {
        setCacheColorHint(context.getResources().getColor(AsyncImageView.f21295a));
        this.f15633q = LayoutInflater.from(context);
        m7181h();
        m7180i();
        setOnScrollListener(this);
        m7198a(0);
    }

    /* renamed from: a */
    private void m7196a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* renamed from: h */
    private void m7181h() {
        this.f15634r = (LinearLayout) this.f15633q.inflate(C2300R.layout.rebound_listview_header, (ViewGroup) null);
        this.f15637u = (ImageView) this.f15634r.findViewById(C2300R.C2302id.head_arrowImageView);
        this.f15637u.setMinimumWidth(70);
        this.f15637u.setMinimumHeight(50);
        this.f15638v = (ProgressBar) this.f15634r.findViewById(C2300R.C2302id.head_progressBar);
        this.f15635s = (TextView) this.f15634r.findViewById(C2300R.C2302id.head_tipsTextView);
        this.f15636t = (TextView) this.f15634r.findViewById(C2300R.C2302id.head_lastUpdatedTextView);
        m7196a(this.f15634r);
        this.f15617D = this.f15634r.getMeasuredHeight();
        this.f15616C = this.f15634r.getMeasuredWidth();
        this.f15634r.setPadding(0, this.f15617D * (-1), 0, 0);
        this.f15634r.invalidate();
        Log.v("size", "width:" + this.f15616C + " height:" + this.f15617D);
        addHeaderView(this.f15634r, null, false);
        this.f15627k = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7180i() {
        this.f15639w = this.f15633q.inflate(C2300R.layout.rebound_listview_footer, (ViewGroup) null);
        this.f15639w.setVisibility(0);
        this.f15640x = (ProgressBar) this.f15639w.findViewById(C2300R.C2302id.pull_to_refresh_progress);
        this.f15641y = (TextView) this.f15639w.findViewById(C2300R.C2302id.load_more);
        this.f15639w.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.UIRefreshListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UIRefreshListView.this.f15629m) {
                    if (!UIRefreshListView.this.f15630n) {
                        if (UIRefreshListView.this.f15628l == 1) {
                            return;
                        }
                        UIRefreshListView.this.f15628l = 1;
                        UIRefreshListView.this.m7176m();
                    } else if (UIRefreshListView.this.f15628l == 1 || UIRefreshListView.this.f15627k == 2) {
                    } else {
                        UIRefreshListView.this.f15628l = 1;
                        UIRefreshListView.this.m7176m();
                    }
                }
            }
        });
        addFooterView(this.f15639w);
        if (this.f15631o) {
            this.f15628l = 3;
        } else {
            this.f15628l = 2;
        }
    }

    /* renamed from: j */
    private void m7179j() {
        if (this.f15629m) {
            switch (this.f15628l) {
                case 1:
                    if (this.f15641y.getText().equals(Integer.valueOf((int) C2300R.C2303string.refresh_doing_end_refresh))) {
                        return;
                    }
                    this.f15641y.setText(C2300R.C2303string.refresh_doing_end_refresh);
                    this.f15641y.setVisibility(0);
                    this.f15640x.setVisibility(0);
                    return;
                case 2:
                    this.f15641y.setText(C2300R.C2303string.refresh_end_click_load_more);
                    this.f15641y.setVisibility(0);
                    this.f15640x.setVisibility(8);
                    this.f15639w.setVisibility(0);
                    return;
                case 3:
                    this.f15641y.setText(C2300R.C2303string.refresh_end_load_more);
                    this.f15641y.setVisibility(0);
                    this.f15640x.setVisibility(8);
                    this.f15639w.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: k */
    private void m7178k() {
        switch (this.f15627k) {
            case 0:
                this.f15637u.setVisibility(0);
                this.f15638v.setVisibility(8);
                this.f15635s.setVisibility(0);
                this.f15636t.setVisibility(0);
                this.f15637u.clearAnimation();
                this.f15637u.startAnimation(this.f15642z);
                this.f15635s.setText(C2300R.C2303string.refresh_release_refresh);
                return;
            case 1:
                this.f15638v.setVisibility(8);
                this.f15635s.setVisibility(0);
                this.f15636t.setVisibility(0);
                this.f15637u.clearAnimation();
                this.f15637u.setVisibility(0);
                if (!this.f15619F) {
                    this.f15635s.setText(C2300R.C2303string.refresh_pull_to_refresh);
                    return;
                }
                this.f15619F = false;
                this.f15637u.clearAnimation();
                this.f15637u.startAnimation(this.f15614A);
                this.f15635s.setText(C2300R.C2303string.refresh_pull_to_refresh);
                return;
            case 2:
                this.f15634r.setPadding(0, 0, 0, 0);
                this.f15638v.setVisibility(0);
                this.f15637u.clearAnimation();
                this.f15637u.setVisibility(8);
                this.f15635s.setText(C2300R.C2303string.refresh_doing_head_refresh);
                this.f15636t.setVisibility(0);
                return;
            case 3:
                this.f15634r.setPadding(0, this.f15617D * (-1), 0, 0);
                this.f15638v.setVisibility(8);
                this.f15637u.clearAnimation();
                this.f15637u.setImageResource(C2300R.C2301drawable.uet_rebound_listview_arrow);
                this.f15635s.setText(C2300R.C2303string.refresh_pull_to_refresh);
                this.f15636t.setVisibility(0);
                return;
            default:
                return;
        }
    }

    /* renamed from: l */
    private void m7177l() {
        if (this.f15624K != null) {
            this.f15624K.m7172a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m7176m() {
        if (this.f15625L != null) {
            this.f15641y.setText(C2300R.C2303string.refresh_doing_end_refresh);
            this.f15641y.setVisibility(0);
            this.f15640x.setVisibility(0);
            this.f15625L.m7173a();
        }
    }

    /* renamed from: a */
    public boolean m7199a() {
        return this.f15629m;
    }

    /* renamed from: b */
    public boolean m7193b() {
        return this.f15630n;
    }

    /* renamed from: c */
    public boolean m7191c() {
        return this.f15631o;
    }

    /* renamed from: d */
    public boolean m7189d() {
        return this.f15632p;
    }

    /* renamed from: e */
    public void m7187e() {
        if (this.f15632p) {
            setSelection(0);
        }
        this.f15627k = 3;
        this.f15636t.setText(getResources().getString(C2300R.C2303string.refresh_refresh_lasttime) + new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date()));
        m7178k();
    }

    /* renamed from: f */
    public void m7185f() {
        if (this.f15631o) {
            this.f15628l = 3;
        } else {
            this.f15628l = 2;
        }
        m7179j();
    }

    /* renamed from: g */
    public void m7183g() {
        removeFooterView(this.f15639w);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f15620G = i;
        this.f15621H = (i + i2) - 2;
        this.f15622I = i3 - 2;
        if (i3 > i2) {
            this.f15623J = true;
        } else {
            this.f15623J = false;
        }
        if (this.f15626M != null) {
            this.f15626M.m7174a(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f15629m) {
            if (this.f15621H == this.f15622I && i == 0 && this.f15628l != 1) {
                if (!this.f15631o) {
                    this.f15628l = 2;
                    m7179j();
                } else if (!this.f15630n) {
                    this.f15628l = 1;
                    m7176m();
                    m7179j();
                } else if (this.f15627k != 2) {
                    this.f15628l = 1;
                    m7176m();
                    m7179j();
                }
            }
        } else if (this.f15639w != null && this.f15639w.getVisibility() == 0) {
            System.out.println("this.removeFooterView(endRootView);...");
            this.f15639w.setVisibility(8);
            removeFooterView(this.f15639w);
        }
        if (this.f15626M != null) {
            this.f15626M.m7175a(absListView, i);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f15630n) {
            if (this.f15629m && this.f15628l == 1) {
                return super.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.f15620G == 0 && !this.f15615B) {
                        this.f15615B = true;
                        this.f15618E = (int) motionEvent.getY();
                        break;
                    }
                    break;
                case 1:
                    if (this.f15627k != 2 && this.f15627k != 4) {
                        if (this.f15627k == 3) {
                        }
                        if (this.f15627k == 1) {
                            this.f15627k = 3;
                            m7178k();
                        }
                        if (this.f15627k == 0) {
                            this.f15627k = 2;
                            m7178k();
                            m7177l();
                        }
                    }
                    this.f15615B = false;
                    this.f15619F = false;
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.f15615B && this.f15620G == 0) {
                        this.f15615B = true;
                        this.f15618E = y;
                    }
                    if (this.f15627k != 2 && this.f15615B && this.f15627k != 4) {
                        if (this.f15627k == 0) {
                            setSelection(0);
                            if ((y - this.f15618E) / 3 < this.f15617D && y - this.f15618E > 0) {
                                this.f15627k = 1;
                                m7178k();
                            } else if (y - this.f15618E <= 0) {
                                this.f15627k = 3;
                                m7178k();
                            }
                        }
                        if (this.f15627k == 1) {
                            setSelection(0);
                            if ((y - this.f15618E) / 3 >= this.f15617D) {
                                this.f15627k = 0;
                                this.f15619F = true;
                                m7178k();
                            } else if (y - this.f15618E <= 0) {
                                this.f15627k = 3;
                                m7178k();
                            }
                        }
                        if (this.f15627k == 3 && y - this.f15618E > 0) {
                            this.f15627k = 1;
                            m7178k();
                        }
                        if (this.f15627k == 1) {
                            this.f15634r.setPadding(0, (this.f15617D * (-1)) + ((y - this.f15618E) / 3), 0, 0);
                        }
                        if (this.f15627k == 0) {
                            this.f15634r.setPadding(0, ((y - this.f15618E) / 3) - this.f15617D, 0, 0);
                            break;
                        }
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.f15636t.setText(getResources().getString(C2300R.C2303string.refresh_refresh_lasttime) + new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date()));
        super.setAdapter((ListAdapter) baseAdapter);
    }

    public void setAutoLoadMore(boolean z) {
        this.f15631o = z;
    }

    public void setCanLoadMore(final boolean z) {
        this.f15629m = z;
        if (this.f15639w == null) {
            m7180i();
        }
        this.f15639w.post(new Runnable() { // from class: com.fimi.soul.view.UIRefreshListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!z || UIRefreshListView.this.getFooterViewsCount() != 0) {
                    UIRefreshListView.this.m7183g();
                } else {
                    UIRefreshListView.this.m7180i();
                }
                UIRefreshListView.this.f15639w.setVisibility(z ? 0 : 8);
                UIRefreshListView.this.f15639w.setPadding(0, z ? 0 : -UIRefreshListView.this.f15639w.getHeight(), 0, 0);
            }
        });
    }

    public void setCanRefresh(boolean z) {
        this.f15630n = z;
    }

    public void setListViewOnScrollListener(AbstractC3745a abstractC3745a) {
        this.f15626M = abstractC3745a;
    }

    public void setMoveToFirstItemAfterRefresh(boolean z) {
        this.f15632p = z;
    }

    public void setOnLoadListener(AbstractC3746b abstractC3746b) {
        if (abstractC3746b != null) {
            this.f15625L = abstractC3746b;
            if (!this.f15629m || getFooterViewsCount() != 0) {
                return;
            }
            m7180i();
        }
    }

    public void setOnRefreshListener(AbstractC3747c abstractC3747c) {
        if (abstractC3747c != null) {
            this.f15624K = abstractC3747c;
        }
    }
}
