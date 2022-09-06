package com.fimi.soul.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.fimi.soul.C2300R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {

    /* renamed from: e */
    private static final int f15325e = -1;

    /* renamed from: f */
    private static final int f15326f = 0;

    /* renamed from: g */
    private static final float f15327g = 30.0f;

    /* renamed from: h */
    private static final float f15328h = 0.009f;

    /* renamed from: i */
    private static final String f15329i = "BUNDLE_ID_CURRENT_X";

    /* renamed from: j */
    private static final String f15330j = "BUNDLE_ID_PARENT_STATE";

    /* renamed from: D */
    private EdgeEffectCompat f15334D;

    /* renamed from: E */
    private EdgeEffectCompat f15335E;

    /* renamed from: F */
    private int f15336F;

    /* renamed from: I */
    private View.OnClickListener f15339I;

    /* renamed from: b */
    protected ListAdapter f15343b;

    /* renamed from: c */
    protected int f15344c;

    /* renamed from: d */
    protected int f15345d;

    /* renamed from: l */
    private GestureDetector f15347l;

    /* renamed from: m */
    private int f15348m;

    /* renamed from: v */
    private int f15357v;

    /* renamed from: w */
    private int f15358w;

    /* renamed from: x */
    private int f15359x;

    /* renamed from: a */
    protected Scroller f15342a = new Scroller(getContext());

    /* renamed from: k */
    private final C3718a f15346k = new C3718a();

    /* renamed from: n */
    private List<Queue<View>> f15349n = new ArrayList();

    /* renamed from: o */
    private boolean f15350o = false;

    /* renamed from: p */
    private Rect f15351p = new Rect();

    /* renamed from: q */
    private View f15352q = null;

    /* renamed from: r */
    private int f15353r = 0;

    /* renamed from: s */
    private Drawable f15354s = null;

    /* renamed from: t */
    private Integer f15355t = null;

    /* renamed from: u */
    private int f15356u = Integer.MAX_VALUE;

    /* renamed from: y */
    private AbstractC3723e f15360y = null;

    /* renamed from: z */
    private int f15361z = 0;

    /* renamed from: A */
    private boolean f15331A = false;

    /* renamed from: B */
    private AbstractC3721d f15332B = null;

    /* renamed from: C */
    private AbstractC3721d.EnumC3722a f15333C = AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE;

    /* renamed from: G */
    private boolean f15337G = false;

    /* renamed from: H */
    private boolean f15338H = false;

    /* renamed from: J */
    private DataSetObserver f15340J = new DataSetObserver() { // from class: com.fimi.soul.view.HorizontalListView.2
        @Override // android.database.DataSetObserver
        public void onChanged() {
            HorizontalListView.this.f15350o = true;
            HorizontalListView.this.f15331A = false;
            HorizontalListView.this.m7289f();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.f15331A = false;
            HorizontalListView.this.m7289f();
            HorizontalListView.this.m7299c();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    };

    /* renamed from: K */
    private Runnable f15341K = new Runnable() { // from class: com.fimi.soul.view.HorizontalListView.3
        @Override // java.lang.Runnable
        public void run() {
            HorizontalListView.this.requestLayout();
        }
    };

    /* renamed from: com.fimi.soul.view.HorizontalListView$a */
    /* loaded from: classes.dex */
    private class C3718a extends GestureDetector.SimpleOnGestureListener {
        private C3718a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.m7318a(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.m7317a(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.m7289f();
            int m7297c = HorizontalListView.this.m7297c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (m7297c < 0 || HorizontalListView.this.f15337G) {
                return;
            }
            View childAt = HorizontalListView.this.getChildAt(m7297c);
            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
            if (onItemLongClickListener == null) {
                return;
            }
            int i = HorizontalListView.this.f15357v + m7297c;
            if (!onItemLongClickListener.onItemLongClick(HorizontalListView.this, childAt, i, HorizontalListView.this.f15343b.getItemId(i))) {
                return;
            }
            HorizontalListView.this.performHapticFeedback(0);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListView.this.m7307a((Boolean) true);
            HorizontalListView.this.setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.m7289f();
            HorizontalListView.this.f15345d += (int) f;
            HorizontalListView.this.m7280j(Math.round(f));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.m7289f();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int m7297c = HorizontalListView.this.m7297c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (m7297c >= 0 && !HorizontalListView.this.f15337G) {
                View childAt = HorizontalListView.this.getChildAt(m7297c);
                int i = HorizontalListView.this.f15357v + m7297c;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListView.this, childAt, i, HorizontalListView.this.f15343b.getItemId(i));
                    return true;
                }
            }
            if (HorizontalListView.this.f15339I != null && !HorizontalListView.this.f15337G) {
                HorizontalListView.this.f15339I.onClick(HorizontalListView.this);
            }
            return false;
        }
    }

    @TargetApi(11)
    /* renamed from: com.fimi.soul.view.HorizontalListView$b */
    /* loaded from: classes.dex */
    private static final class C3719b {
        static {
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        private C3719b() {
        }

        /* renamed from: a */
        public static void m7279a(Scroller scroller, float f) {
            if (scroller != null) {
                scroller.setFriction(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* renamed from: com.fimi.soul.view.HorizontalListView$c */
    /* loaded from: classes.dex */
    public static final class C3720c {
        static {
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        private C3720c() {
        }

        /* renamed from: a */
        public static float m7278a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    /* renamed from: com.fimi.soul.view.HorizontalListView$d */
    /* loaded from: classes.dex */
    public interface AbstractC3721d {

        /* renamed from: com.fimi.soul.view.HorizontalListView$d$a */
        /* loaded from: classes.dex */
        public enum EnumC3722a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        /* renamed from: a */
        void m7277a(EnumC3722a enumC3722a);
    }

    /* renamed from: com.fimi.soul.view.HorizontalListView$e */
    /* loaded from: classes.dex */
    public interface AbstractC3723e {
        /* renamed from: a */
        void m7276a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15334D = new EdgeEffectCompat(context);
        this.f15335E = new EdgeEffectCompat(context);
        this.f15347l = new GestureDetector(context, this.f15346k);
        m7325a();
        m7306b();
        m7321a(context, attributeSet);
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            C3719b.m7279a(this.f15342a, f15328h);
        }
    }

    /* renamed from: a */
    private void m7325a() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.view.HorizontalListView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListView.this.f15347l.onTouchEvent(motionEvent);
            }
        });
    }

    /* renamed from: a */
    private void m7323a(int i, int i2) {
        while (i + i2 + this.f15353r < getWidth() && this.f15358w + 1 < this.f15343b.getCount()) {
            this.f15358w++;
            if (this.f15357v < 0) {
                this.f15357v = this.f15358w;
            }
            View view = this.f15343b.getView(this.f15358w, m7298c(this.f15358w), this);
            m7315a(view, -1);
            i += (this.f15358w == 0 ? 0 : this.f15353r) + view.getMeasuredWidth();
            m7284h();
        }
    }

    /* renamed from: a */
    private void m7322a(int i, View view) {
        int itemViewType = this.f15343b.getItemViewType(i);
        if (m7294d(itemViewType)) {
            this.f15349n.get(itemViewType).offer(view);
        }
    }

    /* renamed from: a */
    private void m7321a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.HorizontalListView);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setDivider(drawable);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            if (dimensionPixelSize != 0) {
                setDividerWidth(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m7320a(Canvas canvas) {
        if (this.f15334D != null && !this.f15334D.isFinished() && m7282i()) {
            int save = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.f15334D.setSize(getRenderHeight(), getRenderWidth());
            if (this.f15334D.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
        } else if (this.f15335E == null || this.f15335E.isFinished() || !m7282i()) {
        } else {
            int save2 = canvas.save();
            int width = getWidth();
            canvas.rotate(90.0f, 0.0f, 0.0f);
            canvas.translate(getPaddingTop(), -width);
            this.f15335E.setSize(getRenderHeight(), getRenderWidth());
            if (this.f15335E.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save2);
        }
    }

    /* renamed from: a */
    private void m7319a(Canvas canvas, Rect rect) {
        if (this.f15354s != null) {
            this.f15354s.setBounds(rect);
            this.f15354s.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m7316a(View view) {
        ViewGroup.LayoutParams m7302b = m7302b(view);
        view.measure(m7302b.width > 0 ? View.MeasureSpec.makeMeasureSpec(m7302b.width, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.f15336F, getPaddingTop() + getPaddingBottom(), m7302b.height));
    }

    /* renamed from: a */
    private void m7315a(View view, int i) {
        addViewInLayout(view, i, m7302b(view), true);
        m7316a(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7307a(Boolean bool) {
        if (this.f15338H != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.f15338H = bool.booleanValue();
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private ViewGroup.LayoutParams m7302b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    /* renamed from: b */
    private void m7306b() {
        this.f15357v = -1;
        this.f15358w = -1;
        this.f15348m = 0;
        this.f15344c = 0;
        this.f15345d = 0;
        this.f15356u = Integer.MAX_VALUE;
        setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE);
    }

    /* renamed from: b */
    private void m7305b(int i) {
        this.f15349n.clear();
        for (int i2 = 0; i2 < i; i2++) {
            this.f15349n.add(new LinkedList());
        }
    }

    /* renamed from: b */
    private void m7304b(int i, int i2) {
        while ((i + i2) - this.f15353r > 0 && this.f15357v >= 1) {
            this.f15357v--;
            View view = this.f15343b.getView(this.f15357v, m7298c(this.f15357v), this);
            m7315a(view, 0);
            i -= this.f15357v == 0 ? view.getMeasuredWidth() : this.f15353r + view.getMeasuredWidth();
            this.f15348m -= i + i2 == 0 ? view.getMeasuredWidth() : this.f15353r + view.getMeasuredWidth();
        }
    }

    /* renamed from: b */
    private void m7303b(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.f15351p;
        this.f15351p.top = getPaddingTop();
        this.f15351p.bottom = this.f15351p.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !m7281i(this.f15358w)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.f15353r;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                m7319a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    m7319a(canvas, rect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m7297c(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.f15351p);
            if (this.f15351p.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: c */
    private View m7298c(int i) {
        int itemViewType = this.f15343b.getItemViewType(i);
        if (m7294d(itemViewType)) {
            return this.f15349n.get(itemViewType).poll();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7299c() {
        m7306b();
        removeAllViewsInLayout();
        requestLayout();
    }

    /* renamed from: d */
    private float m7295d() {
        if (Build.VERSION.SDK_INT >= 14) {
            return C3720c.m7278a(this.f15342a);
        }
        return 30.0f;
    }

    /* renamed from: d */
    private boolean m7294d(int i) {
        return i < this.f15349n.size();
    }

    /* renamed from: e */
    private void m7291e(int i) {
        int i2 = 0;
        View rightmostChild = getRightmostChild();
        m7323a(rightmostChild != null ? rightmostChild.getRight() : 0, i);
        View leftmostChild = getLeftmostChild();
        if (leftmostChild != null) {
            i2 = leftmostChild.getLeft();
        }
        m7304b(i2, i);
    }

    /* renamed from: e */
    private boolean m7292e() {
        View rightmostChild;
        if (!m7281i(this.f15358w) || (rightmostChild = getRightmostChild()) == null) {
            return false;
        }
        int i = this.f15356u;
        this.f15356u = ((rightmostChild.getRight() - getPaddingLeft()) + this.f15344c) - getRenderWidth();
        if (this.f15356u < 0) {
            this.f15356u = 0;
        }
        return this.f15356u != i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7289f() {
        if (this.f15352q != null) {
            this.f15352q.setPressed(false);
            refreshDrawableState();
            this.f15352q = null;
        }
    }

    /* renamed from: f */
    private void m7288f(int i) {
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i <= 0) {
            this.f15348m = (m7281i(this.f15357v) ? leftmostChild.getMeasuredWidth() : this.f15353r + leftmostChild.getMeasuredWidth()) + this.f15348m;
            m7322a(this.f15357v, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.f15357v++;
            leftmostChild = getLeftmostChild();
        }
        View rightmostChild = getRightmostChild();
        while (rightmostChild != null && rightmostChild.getLeft() + i >= getWidth()) {
            m7322a(this.f15358w, rightmostChild);
            removeViewInLayout(rightmostChild);
            this.f15358w--;
            rightmostChild = getRightmostChild();
        }
    }

    /* renamed from: g */
    private void m7286g() {
        if (this.f15334D != null) {
            this.f15334D.onRelease();
        }
        if (this.f15335E != null) {
            this.f15335E.onRelease();
        }
    }

    /* renamed from: g */
    private void m7285g(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            this.f15348m += i;
            int i2 = this.f15348m;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                int paddingLeft = getPaddingLeft() + i2;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                i2 += childAt.getMeasuredWidth() + this.f15353r;
            }
        }
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    /* renamed from: h */
    private View m7283h(int i) {
        if (i < this.f15357v || i > this.f15358w) {
            return null;
        }
        return getChildAt(i - this.f15357v);
    }

    /* renamed from: h */
    private void m7284h() {
        if (this.f15360y == null || this.f15343b == null || this.f15343b.getCount() - (this.f15358w + 1) >= this.f15361z || this.f15331A) {
            return;
        }
        this.f15331A = true;
        this.f15360y.m7276a();
    }

    /* renamed from: i */
    private boolean m7282i() {
        return this.f15343b != null && !this.f15343b.isEmpty() && this.f15356u > 0;
    }

    /* renamed from: i */
    private boolean m7281i(int i) {
        return i == this.f15343b.getCount() + (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7280j(int i) {
        if (this.f15334D == null || this.f15335E == null) {
            return;
        }
        int i2 = this.f15344c + i;
        if (this.f15342a != null && !this.f15342a.isFinished()) {
            return;
        }
        if (i2 < 0) {
            this.f15334D.onPull(Math.abs(i) / getRenderWidth());
            if (this.f15335E.isFinished()) {
                return;
            }
            this.f15335E.onRelease();
        } else if (i2 <= this.f15356u) {
        } else {
            this.f15335E.onPull(Math.abs(i) / getRenderWidth());
            if (this.f15334D.isFinished()) {
                return;
            }
            this.f15334D.onRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentScrollState(AbstractC3721d.EnumC3722a enumC3722a) {
        if (this.f15333C != enumC3722a && this.f15332B != null) {
            this.f15332B.m7277a(enumC3722a);
        }
        this.f15333C = enumC3722a;
    }

    /* renamed from: a */
    public void m7324a(int i) {
        this.f15342a.startScroll(this.f15345d, 0, i - this.f15345d, 0);
        setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_FLING);
        requestLayout();
    }

    /* renamed from: a */
    public void m7314a(AbstractC3723e abstractC3723e, int i) {
        this.f15360y = abstractC3723e;
        this.f15361z = i;
    }

    /* renamed from: a */
    protected boolean m7318a(MotionEvent motionEvent) {
        int m7297c;
        this.f15337G = !this.f15342a.isFinished();
        this.f15342a.forceFinished(true);
        setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE);
        m7289f();
        if (!this.f15337G && (m7297c = m7297c((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            this.f15352q = getChildAt(m7297c);
            if (this.f15352q != null) {
                this.f15352q.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    /* renamed from: a */
    protected boolean m7317a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f15342a.fling(this.f15345d, 0, (int) (-f), 0, 0, this.f15356u, 0, 0);
        setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m7320a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f15343b;
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.f15357v;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.f15358w;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.f15344c == 0) {
            return 0.0f;
        }
        if (this.f15344c >= horizontalFadingEdgeLength) {
            return 1.0f;
        }
        return this.f15344c / horizontalFadingEdgeLength;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.f15344c == this.f15356u) {
            return 0.0f;
        }
        if (this.f15356u - this.f15344c >= horizontalFadingEdgeLength) {
            return 1.0f;
        }
        return (this.f15356u - this.f15344c) / horizontalFadingEdgeLength;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return m7283h(this.f15359x);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m7303b(canvas);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f15343b == null) {
            return;
        }
        invalidate();
        if (this.f15350o) {
            int i5 = this.f15344c;
            m7306b();
            removeAllViewsInLayout();
            this.f15345d = i5;
            this.f15350o = false;
        }
        if (this.f15355t != null) {
            this.f15345d = this.f15355t.intValue();
            this.f15355t = null;
        }
        if (this.f15342a.computeScrollOffset()) {
            this.f15345d = this.f15342a.getCurrX();
        }
        if (this.f15345d < 0) {
            this.f15345d = 0;
            if (this.f15334D.isFinished()) {
                this.f15334D.onAbsorb((int) m7295d());
            }
            this.f15342a.forceFinished(true);
            setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE);
        } else if (this.f15345d > this.f15356u) {
            this.f15345d = this.f15356u;
            if (this.f15335E.isFinished()) {
                this.f15335E.onAbsorb((int) m7295d());
            }
            this.f15342a.forceFinished(true);
            setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE);
        }
        int i6 = this.f15344c - this.f15345d;
        m7288f(i6);
        m7291e(i6);
        m7285g(i6);
        this.f15344c = this.f15345d;
        if (m7292e()) {
            onLayout(z, i, i2, i3, i4);
        } else if (!this.f15342a.isFinished()) {
            ViewCompat.postOnAnimation(this, this.f15341K);
        } else if (this.f15333C != AbstractC3721d.EnumC3722a.SCROLL_STATE_FLING) {
        } else {
            setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f15336F = i2;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f15355t = Integer.valueOf(bundle.getInt(f15329i));
            super.onRestoreInstanceState(bundle.getParcelable(f15330j));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f15330j, super.onSaveInstanceState());
        bundle.putInt(f15329i, this.f15344c);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f15342a == null || this.f15342a.isFinished()) {
                setCurrentScrollState(AbstractC3721d.EnumC3722a.SCROLL_STATE_IDLE);
            }
            m7307a((Boolean) false);
            m7286g();
        } else if (motionEvent.getAction() == 3) {
            m7289f();
            m7286g();
            m7307a((Boolean) false);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f15343b != null) {
            this.f15343b.unregisterDataSetObserver(this.f15340J);
        }
        if (listAdapter != null) {
            this.f15331A = false;
            this.f15343b = listAdapter;
            this.f15343b.registerDataSetObserver(this.f15340J);
        }
        m7305b(this.f15343b.getViewTypeCount());
        m7299c();
    }

    public void setDivider(Drawable drawable) {
        this.f15354s = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i) {
        this.f15353r = i;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f15339I = onClickListener;
    }

    public void setOnScrollStateChangedListener(AbstractC3721d abstractC3721d) {
        this.f15332B = abstractC3721d;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        this.f15359x = i;
    }
}
