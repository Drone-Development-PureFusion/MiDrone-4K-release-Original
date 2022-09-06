package com.fimi.soul.media.gallery;

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
    private static final int f11212e = -1;

    /* renamed from: f */
    private static final int f11213f = 0;

    /* renamed from: g */
    private static final float f11214g = 30.0f;

    /* renamed from: h */
    private static final float f11215h = 0.009f;

    /* renamed from: i */
    private static final String f11216i = "BUNDLE_ID_CURRENT_X";

    /* renamed from: j */
    private static final String f11217j = "BUNDLE_ID_PARENT_STATE";

    /* renamed from: D */
    private EdgeEffectCompat f11221D;

    /* renamed from: E */
    private EdgeEffectCompat f11222E;

    /* renamed from: F */
    private int f11223F;

    /* renamed from: I */
    private View.OnClickListener f11226I;

    /* renamed from: b */
    protected ListAdapter f11230b;

    /* renamed from: c */
    protected int f11231c;

    /* renamed from: d */
    protected int f11232d;

    /* renamed from: l */
    private GestureDetector f11234l;

    /* renamed from: m */
    private int f11235m;

    /* renamed from: v */
    private int f11244v;

    /* renamed from: w */
    private int f11245w;

    /* renamed from: x */
    private int f11246x;

    /* renamed from: a */
    protected Scroller f11229a = new Scroller(getContext());

    /* renamed from: k */
    private final C2968a f11233k = new C2968a();

    /* renamed from: n */
    private List<Queue<View>> f11236n = new ArrayList();

    /* renamed from: o */
    private boolean f11237o = false;

    /* renamed from: p */
    private Rect f11238p = new Rect();

    /* renamed from: q */
    private View f11239q = null;

    /* renamed from: r */
    private int f11240r = 0;

    /* renamed from: s */
    private Drawable f11241s = null;

    /* renamed from: t */
    private Integer f11242t = null;

    /* renamed from: u */
    private int f11243u = Integer.MAX_VALUE;

    /* renamed from: y */
    private AbstractC2973e f11247y = null;

    /* renamed from: z */
    private int f11248z = 0;

    /* renamed from: A */
    private boolean f11218A = false;

    /* renamed from: B */
    private AbstractC2971d f11219B = null;

    /* renamed from: C */
    private AbstractC2971d.EnumC2972a f11220C = AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE;

    /* renamed from: G */
    private boolean f11224G = false;

    /* renamed from: H */
    private boolean f11225H = false;

    /* renamed from: J */
    private DataSetObserver f11227J = new DataSetObserver() { // from class: com.fimi.soul.media.gallery.HorizontalListView.2
        @Override // android.database.DataSetObserver
        public void onChanged() {
            HorizontalListView.this.f11237o = true;
            HorizontalListView.this.f11218A = false;
            HorizontalListView.this.m9957f();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.f11218A = false;
            HorizontalListView.this.m9957f();
            HorizontalListView.this.m9967c();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    };

    /* renamed from: K */
    private Runnable f11228K = new Runnable() { // from class: com.fimi.soul.media.gallery.HorizontalListView.3
        @Override // java.lang.Runnable
        public void run() {
            HorizontalListView.this.requestLayout();
        }
    };

    /* renamed from: com.fimi.soul.media.gallery.HorizontalListView$a */
    /* loaded from: classes.dex */
    private class C2968a extends GestureDetector.SimpleOnGestureListener {
        private C2968a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.m9986a(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.m9985a(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.m9957f();
            int m9965c = HorizontalListView.this.m9965c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (m9965c < 0 || HorizontalListView.this.f11224G) {
                return;
            }
            View childAt = HorizontalListView.this.getChildAt(m9965c);
            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
            if (onItemLongClickListener == null) {
                return;
            }
            int i = HorizontalListView.this.f11244v + m9965c;
            if (!onItemLongClickListener.onItemLongClick(HorizontalListView.this, childAt, i, HorizontalListView.this.f11230b.getItemId(i))) {
                return;
            }
            HorizontalListView.this.performHapticFeedback(0);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListView.this.m9975a((Boolean) true);
            HorizontalListView.this.setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.m9957f();
            HorizontalListView.this.f11232d += (int) f;
            HorizontalListView.this.m9948j(Math.round(f));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.m9957f();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int m9965c = HorizontalListView.this.m9965c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (m9965c >= 0 && !HorizontalListView.this.f11224G) {
                View childAt = HorizontalListView.this.getChildAt(m9965c);
                int i = HorizontalListView.this.f11244v + m9965c;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListView.this, childAt, i, HorizontalListView.this.f11230b.getItemId(i));
                    return true;
                }
            }
            if (HorizontalListView.this.f11226I != null && !HorizontalListView.this.f11224G) {
                HorizontalListView.this.f11226I.onClick(HorizontalListView.this);
            }
            return false;
        }
    }

    @TargetApi(11)
    /* renamed from: com.fimi.soul.media.gallery.HorizontalListView$b */
    /* loaded from: classes.dex */
    private static final class C2969b {
        static {
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        private C2969b() {
        }

        /* renamed from: a */
        public static void m9947a(Scroller scroller, float f) {
            if (scroller != null) {
                scroller.setFriction(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* renamed from: com.fimi.soul.media.gallery.HorizontalListView$c */
    /* loaded from: classes.dex */
    public static final class C2970c {
        static {
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        private C2970c() {
        }

        /* renamed from: a */
        public static float m9946a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    /* renamed from: com.fimi.soul.media.gallery.HorizontalListView$d */
    /* loaded from: classes.dex */
    public interface AbstractC2971d {

        /* renamed from: com.fimi.soul.media.gallery.HorizontalListView$d$a */
        /* loaded from: classes.dex */
        public enum EnumC2972a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        /* renamed from: a */
        void m9945a(EnumC2972a enumC2972a);
    }

    /* renamed from: com.fimi.soul.media.gallery.HorizontalListView$e */
    /* loaded from: classes.dex */
    public interface AbstractC2973e {
        /* renamed from: a */
        void m9944a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11221D = new EdgeEffectCompat(context);
        this.f11222E = new EdgeEffectCompat(context);
        this.f11234l = new GestureDetector(context, this.f11233k);
        m9993a();
        m9974b();
        m9989a(context, attributeSet);
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            C2969b.m9947a(this.f11229a, f11215h);
        }
    }

    /* renamed from: a */
    private void m9993a() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.media.gallery.HorizontalListView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListView.this.f11234l.onTouchEvent(motionEvent);
            }
        });
    }

    /* renamed from: a */
    private void m9991a(int i, int i2) {
        while (i + i2 + this.f11240r < getWidth() && this.f11245w + 1 < this.f11230b.getCount()) {
            this.f11245w++;
            if (this.f11244v < 0) {
                this.f11244v = this.f11245w;
            }
            View view = this.f11230b.getView(this.f11245w, m9966c(this.f11245w), this);
            m9983a(view, -1);
            i += (this.f11245w == 0 ? 0 : this.f11240r) + view.getMeasuredWidth();
            m9952h();
        }
    }

    /* renamed from: a */
    private void m9990a(int i, View view) {
        int itemViewType = this.f11230b.getItemViewType(i);
        if (m9962d(itemViewType)) {
            this.f11236n.get(itemViewType).offer(view);
        }
    }

    /* renamed from: a */
    private void m9989a(Context context, AttributeSet attributeSet) {
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
    private void m9988a(Canvas canvas) {
        if (this.f11221D != null && !this.f11221D.isFinished() && m9950i()) {
            int save = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.f11221D.setSize(getRenderHeight(), getRenderWidth());
            if (this.f11221D.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
        } else if (this.f11222E == null || this.f11222E.isFinished() || !m9950i()) {
        } else {
            int save2 = canvas.save();
            int width = getWidth();
            canvas.rotate(90.0f, 0.0f, 0.0f);
            canvas.translate(getPaddingTop(), -width);
            this.f11222E.setSize(getRenderHeight(), getRenderWidth());
            if (this.f11222E.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save2);
        }
    }

    /* renamed from: a */
    private void m9987a(Canvas canvas, Rect rect) {
        if (this.f11241s != null) {
            this.f11241s.setBounds(rect);
            this.f11241s.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m9984a(View view) {
        ViewGroup.LayoutParams m9970b = m9970b(view);
        view.measure(m9970b.width > 0 ? View.MeasureSpec.makeMeasureSpec(m9970b.width, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.f11223F, getPaddingTop() + getPaddingBottom(), m9970b.height));
    }

    /* renamed from: a */
    private void m9983a(View view, int i) {
        addViewInLayout(view, i, m9970b(view), true);
        m9984a(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9975a(Boolean bool) {
        if (this.f11225H != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.f11225H = bool.booleanValue();
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private ViewGroup.LayoutParams m9970b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    /* renamed from: b */
    private void m9974b() {
        this.f11244v = -1;
        this.f11245w = -1;
        this.f11235m = 0;
        this.f11231c = 0;
        this.f11232d = 0;
        this.f11243u = Integer.MAX_VALUE;
        setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE);
    }

    /* renamed from: b */
    private void m9973b(int i) {
        this.f11236n.clear();
        for (int i2 = 0; i2 < i; i2++) {
            this.f11236n.add(new LinkedList());
        }
    }

    /* renamed from: b */
    private void m9972b(int i, int i2) {
        while ((i + i2) - this.f11240r > 0 && this.f11244v >= 1) {
            this.f11244v--;
            View view = this.f11230b.getView(this.f11244v, m9966c(this.f11244v), this);
            m9983a(view, 0);
            i -= this.f11244v == 0 ? view.getMeasuredWidth() : this.f11240r + view.getMeasuredWidth();
            this.f11235m -= i + i2 == 0 ? view.getMeasuredWidth() : this.f11240r + view.getMeasuredWidth();
        }
    }

    /* renamed from: b */
    private void m9971b(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.f11238p;
        this.f11238p.top = getPaddingTop();
        this.f11238p.bottom = this.f11238p.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !m9949i(this.f11245w)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.f11240r;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                m9987a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    m9987a(canvas, rect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m9965c(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.f11238p);
            if (this.f11238p.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: c */
    private View m9966c(int i) {
        int itemViewType = this.f11230b.getItemViewType(i);
        if (m9962d(itemViewType)) {
            return this.f11236n.get(itemViewType).poll();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9967c() {
        m9974b();
        removeAllViewsInLayout();
        requestLayout();
    }

    /* renamed from: d */
    private float m9963d() {
        if (Build.VERSION.SDK_INT >= 14) {
            return C2970c.m9946a(this.f11229a);
        }
        return 30.0f;
    }

    /* renamed from: d */
    private boolean m9962d(int i) {
        return i < this.f11236n.size();
    }

    /* renamed from: e */
    private void m9959e(int i) {
        int i2 = 0;
        View rightmostChild = getRightmostChild();
        m9991a(rightmostChild != null ? rightmostChild.getRight() : 0, i);
        View leftmostChild = getLeftmostChild();
        if (leftmostChild != null) {
            i2 = leftmostChild.getLeft();
        }
        m9972b(i2, i);
    }

    /* renamed from: e */
    private boolean m9960e() {
        View rightmostChild;
        if (!m9949i(this.f11245w) || (rightmostChild = getRightmostChild()) == null) {
            return false;
        }
        int i = this.f11243u;
        this.f11243u = ((rightmostChild.getRight() - getPaddingLeft()) + this.f11231c) - getRenderWidth();
        if (this.f11243u < 0) {
            this.f11243u = 0;
        }
        return this.f11243u != i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m9957f() {
        if (this.f11239q != null) {
            this.f11239q.setPressed(false);
            refreshDrawableState();
            this.f11239q = null;
        }
    }

    /* renamed from: f */
    private void m9956f(int i) {
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i <= 0) {
            this.f11235m = (m9949i(this.f11244v) ? leftmostChild.getMeasuredWidth() : this.f11240r + leftmostChild.getMeasuredWidth()) + this.f11235m;
            m9990a(this.f11244v, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.f11244v++;
            leftmostChild = getLeftmostChild();
        }
        View rightmostChild = getRightmostChild();
        while (rightmostChild != null && rightmostChild.getLeft() + i >= getWidth()) {
            m9990a(this.f11245w, rightmostChild);
            removeViewInLayout(rightmostChild);
            this.f11245w--;
            rightmostChild = getRightmostChild();
        }
    }

    /* renamed from: g */
    private void m9954g() {
        if (this.f11221D != null) {
            this.f11221D.onRelease();
        }
        if (this.f11222E != null) {
            this.f11222E.onRelease();
        }
    }

    /* renamed from: g */
    private void m9953g(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            this.f11235m += i;
            int i2 = this.f11235m;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                int paddingLeft = getPaddingLeft() + i2;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                i2 += childAt.getMeasuredWidth() + this.f11240r;
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
    private View m9951h(int i) {
        if (i < this.f11244v || i > this.f11245w) {
            return null;
        }
        return getChildAt(i - this.f11244v);
    }

    /* renamed from: h */
    private void m9952h() {
        if (this.f11247y == null || this.f11230b == null || this.f11230b.getCount() - (this.f11245w + 1) >= this.f11248z || this.f11218A) {
            return;
        }
        this.f11218A = true;
        this.f11247y.m9944a();
    }

    /* renamed from: i */
    private boolean m9950i() {
        return this.f11230b != null && !this.f11230b.isEmpty() && this.f11243u > 0;
    }

    /* renamed from: i */
    private boolean m9949i(int i) {
        return i == this.f11230b.getCount() + (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m9948j(int i) {
        if (this.f11221D == null || this.f11222E == null) {
            return;
        }
        int i2 = this.f11231c + i;
        if (this.f11229a != null && !this.f11229a.isFinished()) {
            return;
        }
        if (i2 < 0) {
            this.f11221D.onPull(Math.abs(i) / getRenderWidth());
            if (this.f11222E.isFinished()) {
                return;
            }
            this.f11222E.onRelease();
        } else if (i2 <= this.f11243u) {
        } else {
            this.f11222E.onPull(Math.abs(i) / getRenderWidth());
            if (this.f11221D.isFinished()) {
                return;
            }
            this.f11221D.onRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentScrollState(AbstractC2971d.EnumC2972a enumC2972a) {
        if (this.f11220C != enumC2972a && this.f11219B != null) {
            this.f11219B.m9945a(enumC2972a);
        }
        this.f11220C = enumC2972a;
    }

    /* renamed from: a */
    public void m9992a(int i) {
        this.f11229a.startScroll(this.f11232d, 0, i - this.f11232d, 0);
        setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_FLING);
        requestLayout();
    }

    /* renamed from: a */
    public void m9982a(AbstractC2973e abstractC2973e, int i) {
        this.f11247y = abstractC2973e;
        this.f11248z = i;
    }

    /* renamed from: a */
    protected boolean m9986a(MotionEvent motionEvent) {
        int m9965c;
        this.f11224G = !this.f11229a.isFinished();
        this.f11229a.forceFinished(true);
        setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE);
        m9957f();
        if (!this.f11224G && (m9965c = m9965c((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            this.f11239q = getChildAt(m9965c);
            if (this.f11239q != null) {
                this.f11239q.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    /* renamed from: a */
    protected boolean m9985a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f11229a.fling(this.f11232d, 0, (int) (-f), 0, 0, this.f11243u, 0, 0);
        setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m9988a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f11230b;
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.f11244v;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.f11245w;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.f11231c == 0) {
            return 0.0f;
        }
        if (this.f11231c >= horizontalFadingEdgeLength) {
            return 1.0f;
        }
        return this.f11231c / horizontalFadingEdgeLength;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.f11231c == this.f11243u) {
            return 0.0f;
        }
        if (this.f11243u - this.f11231c >= horizontalFadingEdgeLength) {
            return 1.0f;
        }
        return (this.f11243u - this.f11231c) / horizontalFadingEdgeLength;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return m9951h(this.f11246x);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m9971b(canvas);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f11230b == null) {
            return;
        }
        invalidate();
        if (this.f11237o) {
            int i5 = this.f11231c;
            m9974b();
            removeAllViewsInLayout();
            this.f11232d = i5;
            this.f11237o = false;
        }
        if (this.f11242t != null) {
            this.f11232d = this.f11242t.intValue();
            this.f11242t = null;
        }
        if (this.f11229a.computeScrollOffset()) {
            this.f11232d = this.f11229a.getCurrX();
        }
        if (this.f11232d < 0) {
            this.f11232d = 0;
            if (this.f11221D.isFinished()) {
                this.f11221D.onAbsorb((int) m9963d());
            }
            this.f11229a.forceFinished(true);
            setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE);
        } else if (this.f11232d > this.f11243u) {
            this.f11232d = this.f11243u;
            if (this.f11222E.isFinished()) {
                this.f11222E.onAbsorb((int) m9963d());
            }
            this.f11229a.forceFinished(true);
            setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE);
        }
        int i6 = this.f11231c - this.f11232d;
        m9956f(i6);
        m9959e(i6);
        m9953g(i6);
        this.f11231c = this.f11232d;
        if (m9960e()) {
            onLayout(z, i, i2, i3, i4);
        } else if (!this.f11229a.isFinished()) {
            ViewCompat.postOnAnimation(this, this.f11228K);
        } else if (this.f11220C != AbstractC2971d.EnumC2972a.SCROLL_STATE_FLING) {
        } else {
            setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f11223F = i2;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f11242t = Integer.valueOf(bundle.getInt(f11216i));
            super.onRestoreInstanceState(bundle.getParcelable(f11217j));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f11217j, super.onSaveInstanceState());
        bundle.putInt(f11216i, this.f11231c);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f11229a == null || this.f11229a.isFinished()) {
                setCurrentScrollState(AbstractC2971d.EnumC2972a.SCROLL_STATE_IDLE);
            }
            m9975a((Boolean) false);
            m9954g();
        } else if (motionEvent.getAction() == 3) {
            m9957f();
            m9954g();
            m9975a((Boolean) false);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f11230b != null) {
            this.f11230b.unregisterDataSetObserver(this.f11227J);
        }
        if (listAdapter != null) {
            this.f11218A = false;
            this.f11230b = listAdapter;
            this.f11230b.registerDataSetObserver(this.f11227J);
        }
        m9973b(this.f11230b.getViewTypeCount());
        m9967c();
    }

    public void setDivider(Drawable drawable) {
        this.f11241s = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i) {
        this.f11240r = i;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11226I = onClickListener;
    }

    public void setOnScrollStateChangedListener(AbstractC2971d abstractC2971d) {
        this.f11219B = abstractC2971d;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        this.f11246x = i;
    }
}
