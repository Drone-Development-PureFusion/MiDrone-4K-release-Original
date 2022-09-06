package com.fimi.soul.view.horizontallistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {

    /* renamed from: b */
    protected ListAdapter f15990b;

    /* renamed from: c */
    protected int f15991c;

    /* renamed from: d */
    protected int f15992d;

    /* renamed from: e */
    protected Scroller f15993e;

    /* renamed from: j */
    private GestureDetector f15998j;

    /* renamed from: l */
    private AdapterView.OnItemSelectedListener f16000l;

    /* renamed from: m */
    private AdapterView.OnItemClickListener f16001m;

    /* renamed from: n */
    private AdapterView.OnItemLongClickListener f16002n;

    /* renamed from: p */
    private AbstractC3825a f16004p;

    /* renamed from: q */
    private AbstractC3826b f16005q;

    /* renamed from: a */
    public boolean f15989a = true;

    /* renamed from: f */
    private int f15994f = -1;

    /* renamed from: g */
    private int f15995g = 0;

    /* renamed from: h */
    private int f15996h = Integer.MAX_VALUE;

    /* renamed from: i */
    private int f15997i = 0;

    /* renamed from: k */
    private Queue<View> f15999k = new LinkedList();

    /* renamed from: o */
    private boolean f16003o = false;

    /* renamed from: r */
    private DataSetObserver f16006r = new DataSetObserver() { // from class: com.fimi.soul.view.horizontallistview.HorizontalListView.1
        @Override // android.database.DataSetObserver
        public void onChanged() {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.f16003o = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.m6940c();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    };

    /* renamed from: s */
    private final int f16007s = 270;

    /* renamed from: t */
    private GestureDetector.OnGestureListener f16008t = new GestureDetector.SimpleOnGestureListener() { // from class: com.fimi.soul.view.horizontallistview.HorizontalListView.4
        /* renamed from: a */
        private boolean m6933a(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.m6949a(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.m6948a(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int childCount = HorizontalListView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = HorizontalListView.this.getChildAt(i);
                if (m6933a(motionEvent, childAt)) {
                    if (HorizontalListView.this.f16002n == null) {
                        return;
                    }
                    HorizontalListView.this.f16002n.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.f15994f + 1 + i, HorizontalListView.this.f15990b.getItemId(i + HorizontalListView.this.f15994f + 1));
                    return;
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.f15992d += (int) f;
            }
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < HorizontalListView.this.getChildCount()) {
                    View childAt = HorizontalListView.this.getChildAt(i2);
                    if (m6933a(motionEvent, childAt)) {
                        if (HorizontalListView.this.f16001m != null) {
                            HorizontalListView.this.f16001m.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.f15994f + 1 + i2, HorizontalListView.this.f15990b.getItemId(HorizontalListView.this.f15994f + 1 + i2));
                        }
                        if (HorizontalListView.this.f16000l == null) {
                            return true;
                        }
                        HorizontalListView.this.f16000l.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.f15994f + 1 + i2, HorizontalListView.this.f15990b.getItemId(HorizontalListView.this.f15994f + 1 + i2));
                        return true;
                    }
                    i = i2 + 1;
                } else {
                    return true;
                }
            }
        }
    };

    /* renamed from: com.fimi.soul.view.horizontallistview.HorizontalListView$a */
    /* loaded from: classes.dex */
    public interface AbstractC3825a {
        /* renamed from: a */
        void mo6932a();
    }

    /* renamed from: com.fimi.soul.view.horizontallistview.HorizontalListView$b */
    /* loaded from: classes.dex */
    public interface AbstractC3826b {
        /* renamed from: a */
        void mo6931a(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6944b();
    }

    /* renamed from: a */
    private void m6947a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    /* renamed from: b */
    private synchronized void m6944b() {
        this.f15994f = -1;
        this.f15995g = 0;
        this.f15997i = 0;
        this.f15991c = 0;
        this.f15992d = 0;
        this.f15996h = Integer.MAX_VALUE;
        this.f15993e = new Scroller(getContext());
        this.f15998j = new GestureDetector(getContext(), this.f16008t);
    }

    /* renamed from: b */
    private void m6943b(int i) {
        int i2 = 0;
        View childAt = getChildAt(getChildCount() - 1);
        m6942b(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        if (childAt2 != null) {
            i2 = childAt2.getLeft();
        }
        m6938c(i2, i);
        if (this.f16004p != null) {
            this.f16004p.mo6932a();
        }
    }

    /* renamed from: b */
    private void m6942b(int i, int i2) {
        while (i + i2 < getWidth() && this.f15995g < this.f15990b.getCount()) {
            View view = this.f15990b.getView(this.f15995g, this.f15999k.poll(), this);
            m6947a(view, -1);
            i += view.getMeasuredWidth();
            if (this.f15995g == this.f15990b.getCount() - 1) {
                this.f15996h = (this.f15991c + i) - getWidth();
            }
            if (this.f15996h < 0) {
                this.f15996h = 0;
            }
            this.f15995g++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m6940c() {
        m6944b();
        removeAllViewsInLayout();
        requestLayout();
    }

    /* renamed from: c */
    private void m6939c(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.f15997i += childAt.getMeasuredWidth();
            this.f15999k.offer(childAt);
            removeViewInLayout(childAt);
            this.f15994f++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.f15999k.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f15995g--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* renamed from: c */
    private void m6938c(int i, int i2) {
        while (i + i2 > 0 && this.f15994f >= 0) {
            View view = this.f15990b.getView(this.f15994f, this.f15999k.poll(), this);
            m6947a(view, 0);
            i -= view.getMeasuredWidth();
            this.f15994f--;
            this.f15997i -= view.getMeasuredWidth();
        }
    }

    /* renamed from: d */
    private void m6936d(int i) {
        if (getChildCount() > 0) {
            this.f15997i += i;
            int i2 = this.f15997i;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    /* renamed from: a */
    public void m6952a() {
        if (this.f15990b == null || this.f16005q == null) {
            return;
        }
        if (this.f15994f == -1) {
            this.f16005q.mo6931a(0);
        } else if (this.f15995g == this.f15990b.getCount()) {
            this.f16005q.mo6931a(2);
        } else {
            this.f16005q.mo6931a(1);
        }
    }

    /* renamed from: a */
    public synchronized void m6951a(int i) {
        this.f15993e.startScroll(this.f15992d, 0, i - this.f15992d, 0);
        requestLayout();
    }

    /* renamed from: a */
    public synchronized void m6950a(int i, int i2) {
        final int i3 = (i == 0 ? 0 : i == i2 + (-1) ? i - 2 : i - 1) * 270;
        post(new Runnable() { // from class: com.fimi.soul.view.horizontallistview.HorizontalListView.3
            @Override // java.lang.Runnable
            public void run() {
                HorizontalListView.this.f15993e.startScroll(HorizontalListView.this.f15991c, 0, 0, 0, 500);
                HorizontalListView.this.f15993e.setFinalX(i3);
                HorizontalListView.this.requestLayout();
            }
        });
    }

    /* renamed from: a */
    protected boolean m6949a(MotionEvent motionEvent) {
        this.f15993e.forceFinished(true);
        return true;
    }

    /* renamed from: a */
    protected boolean m6948a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.f15993e.fling(this.f15992d, 0, (int) (-f), 0, 0, this.f15996h, 0, 0);
        }
        requestLayout();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.f15998j.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f15990b;
    }

    public AbstractC3825a getOnChangeListener() {
        return this.f16004p;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f15990b != null) {
            if (this.f16003o) {
                int i5 = this.f15991c;
                m6944b();
                removeAllViewsInLayout();
                this.f15992d = i5;
                this.f16003o = false;
            }
            if (this.f15993e.computeScrollOffset()) {
                this.f15992d = this.f15993e.getCurrX();
            }
            if (this.f15992d <= 0) {
                this.f15992d = 0;
                this.f15993e.forceFinished(true);
            }
            if (this.f15992d >= this.f15996h) {
                this.f15992d = this.f15996h;
                this.f15993e.forceFinished(true);
            }
            int i6 = this.f15991c - this.f15992d;
            m6939c(i6);
            m6943b(i6);
            m6936d(i6);
            this.f15991c = this.f15992d;
            m6952a();
            if (!this.f15993e.isFinished()) {
                post(new Runnable() { // from class: com.fimi.soul.view.horizontallistview.HorizontalListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HorizontalListView.this.requestLayout();
                    }
                });
            }
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f15990b != null) {
            this.f15990b.unregisterDataSetObserver(this.f16006r);
        }
        this.f15990b = listAdapter;
        this.f15990b.registerDataSetObserver(this.f16006r);
        m6940c();
    }

    public void setOnChangeListener(AbstractC3825a abstractC3825a) {
        this.f16004p = abstractC3825a;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f16001m = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f16002n = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f16000l = onItemSelectedListener;
    }

    public void setOnListViewGuide(AbstractC3826b abstractC3826b) {
        this.f16005q = abstractC3826b;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }
}
