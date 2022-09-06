package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews;
import it.sephiroth.android.library.C4881R;
import it.sephiroth.android.library.widget.AbsHListView;
import java.util.ArrayList;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {

    /* renamed from: aX */
    private static final float f21141aX = 0.33f;

    /* renamed from: aY */
    private static final int f21142aY = 2;

    /* renamed from: aZ */
    private static final String f21143aZ = "HListView";

    /* renamed from: bc */
    static final int f21144bc = -1;

    /* renamed from: ba */
    private ArrayList<C4931b> f21145ba;

    /* renamed from: bb */
    private ArrayList<C4931b> f21146bb;

    /* renamed from: bd */
    Drawable f21147bd;

    /* renamed from: be */
    int f21148be;

    /* renamed from: bf */
    int f21149bf;

    /* renamed from: bg */
    Drawable f21150bg;

    /* renamed from: bh */
    Drawable f21151bh;

    /* renamed from: bi */
    private boolean f21152bi;

    /* renamed from: bj */
    private boolean f21153bj;

    /* renamed from: bk */
    private boolean f21154bk;

    /* renamed from: bl */
    private boolean f21155bl;

    /* renamed from: bm */
    private boolean f21156bm;

    /* renamed from: bn */
    private boolean f21157bn;

    /* renamed from: bo */
    private final Rect f21158bo;

    /* renamed from: bp */
    private Paint f21159bp;

    /* renamed from: bq */
    private final C4930a f21160bq;

    /* renamed from: br */
    private RunnableC4932c f21161br;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: it.sephiroth.android.library.widget.HListView$a */
    /* loaded from: classes2.dex */
    public static class C4930a {

        /* renamed from: a */
        private int f21162a;

        /* renamed from: b */
        private int f21163b;

        private C4930a() {
        }

        /* renamed from: a */
        public int m2668a() {
            return this.f21162a;
        }

        /* renamed from: a */
        void m2667a(int i, int i2) {
            this.f21162a = i;
            this.f21163b = i2;
        }

        /* renamed from: b */
        public int m2666b() {
            return this.f21163b;
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.HListView$b */
    /* loaded from: classes2.dex */
    public static class C4931b {

        /* renamed from: a */
        public View f21164a;

        /* renamed from: b */
        public Object f21165b;

        /* renamed from: c */
        public boolean f21166c;
    }

    /* renamed from: it.sephiroth.android.library.widget.HListView$c */
    /* loaded from: classes2.dex */
    private class RunnableC4932c implements Runnable {

        /* renamed from: b */
        private int f21168b;

        /* renamed from: c */
        private int f21169c;

        private RunnableC4932c() {
        }

        /* renamed from: a */
        public RunnableC4932c m2665a(int i, int i2) {
            this.f21168b = i;
            this.f21169c = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.m2686j(this.f21168b, this.f21169c);
        }
    }

    public HListView(Context context) {
        this(context, null);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C4881R.attr.hlv_listViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        CharSequence[] charSequenceArr;
        int i2;
        boolean z;
        int i3 = -1;
        boolean z2 = true;
        this.f21145ba = new ArrayList<>();
        this.f21146bb = new ArrayList<>();
        this.f21156bm = true;
        this.f21157bn = false;
        this.f21158bo = new Rect();
        this.f21160bq = new C4930a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4881R.styleable.HListView, i, 0);
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(0);
            drawable3 = obtainStyledAttributes.getDrawable(1);
            drawable2 = obtainStyledAttributes.getDrawable(5);
            drawable = obtainStyledAttributes.getDrawable(6);
            i2 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            z = obtainStyledAttributes.getBoolean(3, true);
            z2 = obtainStyledAttributes.getBoolean(4, true);
            i3 = obtainStyledAttributes.getInteger(7, -1);
            obtainStyledAttributes.recycle();
        } else {
            drawable = null;
            drawable2 = null;
            drawable3 = null;
            charSequenceArr = null;
            i2 = 0;
            z = true;
        }
        if (charSequenceArr != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, 17367043, charSequenceArr));
        }
        if (drawable3 != null) {
            setDivider(drawable3);
        }
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        if (drawable != null) {
            setOverscrollFooter(drawable);
        }
        if (i2 != 0) {
            setDividerWidth(i2);
        }
        this.f21154bk = z;
        this.f21155bl = z2;
        this.f21149bf = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r1 <= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
        if (r1 < 0) goto L9;
     */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m2730D() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.f20918af) {
                right = getChildAt(0).getLeft() - this.f20900M.left;
                if (this.f21067aw != 0) {
                    right -= this.f21148be;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.f20900M.right);
                if (childCount + this.f21067aw < this.f21061aP) {
                    right += this.f21148be;
                }
            }
            if (i == 0) {
                return;
            }
            e(-i);
        }
    }

    /* renamed from: E */
    private boolean m2729E() {
        return this.f21067aw > 0 || getChildAt(0).getLeft() > getScrollX() + this.f20900M.left;
    }

    /* renamed from: F */
    private boolean m2728F() {
        int childCount = getChildCount();
        return (childCount + this.f21067aw) + (-1) < this.f21061aP + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.f20900M.right;
    }

    /* renamed from: a */
    private int m2723a(int i, View view, int i2) {
        view.getDrawingRect(this.f21158bo);
        offsetDescendantRectToMyCoords(view, this.f21158bo);
        if (i == 33) {
            if (this.f21158bo.left >= this.f20900M.left) {
                return 0;
            }
            int i3 = this.f20900M.left - this.f21158bo.left;
            return i2 > 0 ? i3 + getArrowScrollPreviewLength() : i3;
        }
        int width = getWidth() - this.f20900M.right;
        if (this.f21158bo.bottom <= width) {
            return 0;
        }
        int i4 = this.f21158bo.right - width;
        return i2 < this.f21061aP + (-1) ? i4 + getArrowScrollPreviewLength() : i4;
    }

    /* renamed from: a */
    private View m2724a(int i, int i2, boolean z, int i3, boolean z2) {
        View m2818c;
        if (!this.f21056aK && (m2818c = this.f20895H.m2818c(i)) != null) {
            m2717a(m2818c, i, i2, z, i3, z2, true);
            return m2818c;
        }
        View a = a(i, this.f20924am);
        m2717a(a, i, i2, z, i3, z2, this.f20924am[0]);
        return a;
    }

    /* renamed from: a */
    private View m2716a(View view, View view2, int i, int i2, int i3) {
        View m2724a;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.f21059aN;
        int m2698d = m2698d(i2, horizontalFadingEdgeLength, i4);
        int m2702c = m2702c(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View m2724a2 = m2724a(i4 - 1, view.getLeft(), true, this.f20900M.top, false);
            int i5 = this.f21148be;
            m2724a = m2724a(i4, m2724a2.getRight() + i5, true, this.f20900M.top, true);
            if (m2724a.getRight() > m2702c) {
                int min = Math.min(Math.min(m2724a.getLeft() - m2698d, m2724a.getRight() - m2702c), (i3 - i2) / 2);
                m2724a2.offsetLeftAndRight(-min);
                m2724a.offsetLeftAndRight(-min);
            }
            if (!this.f20918af) {
                m2683k(this.f21059aN - 2, m2724a.getLeft() - i5);
                m2730D();
                m2689i(this.f21059aN + 1, m2724a.getRight() + i5);
            } else {
                m2689i(this.f21059aN + 1, m2724a.getRight() + i5);
                m2730D();
                m2683k(this.f21059aN - 2, m2724a.getLeft() - i5);
            }
        } else if (i < 0) {
            m2724a = view2 != null ? m2724a(i4, view2.getLeft(), true, this.f20900M.top, true) : m2724a(i4, view.getLeft(), false, this.f20900M.top, true);
            if (m2724a.getLeft() < m2698d) {
                m2724a.offsetLeftAndRight(Math.min(Math.min(m2698d - m2724a.getLeft(), m2702c - m2724a.getRight()), (i3 - i2) / 2));
            }
            m2720a(m2724a, i4);
        } else {
            int left = view.getLeft();
            m2724a = m2724a(i4, left, true, this.f20900M.top, true);
            if (left < i2 && m2724a.getRight() < i2 + 20) {
                m2724a.offsetLeftAndRight(i2 - m2724a.getLeft());
            }
            m2720a(m2724a, i4);
        }
        return m2724a;
    }

    /* renamed from: a */
    private void m2720a(View view, int i) {
        int i2 = this.f21148be;
        if (!this.f20918af) {
            m2683k(i - 1, view.getLeft() - i2);
            m2730D();
            m2689i(i + 1, i2 + view.getRight());
            return;
        }
        m2689i(i + 1, view.getRight() + i2);
        m2730D();
        m2683k(i - 1, view.getLeft() - i2);
    }

    /* renamed from: a */
    private void m2719a(View view, int i, int i2) {
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.f20974a = this.f20889B.getItemViewType(i);
        layoutParams.f20976c = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.f20900M.top + this.f20900M.bottom, layoutParams.height);
        int i3 = layoutParams.width;
        view.measure(i3 > 0 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    /* renamed from: a */
    private void m2718a(View view, int i, int i2, boolean z) {
        View view2;
        int i3;
        boolean z2;
        boolean z3 = true;
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i4 = this.f21059aN - this.f21067aw;
        int i5 = i2 - this.f21067aw;
        if (i == 33) {
            view2 = getChildAt(i5);
            i3 = i5;
            i5 = i4;
            z2 = true;
        } else {
            view2 = view;
            view = getChildAt(i5);
            i3 = i4;
            z2 = false;
        }
        int childCount = getChildCount();
        if (view2 != null) {
            view2.setSelected(!z && z2);
            m2706b(view2, i3, childCount);
        }
        if (view == null) {
            return;
        }
        if (z || z2) {
            z3 = false;
        }
        view.setSelected(z3);
        m2706b(view, i5, childCount);
    }

    @TargetApi(11)
    /* renamed from: a */
    private void m2717a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        boolean z4 = z2 && k();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.f20913aa;
        boolean z6 = i4 > 0 && i4 < 3 && this.f20906S == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        AbsHListView.LayoutParams layoutParams2 = layoutParams == null ? (AbsHListView.LayoutParams) generateDefaultLayoutParams() : layoutParams;
        layoutParams2.f20974a = this.f20889B.getItemViewType(i);
        if ((!z3 || layoutParams2.f20976c) && (!layoutParams2.f20975b || layoutParams2.f20974a != -2)) {
            layoutParams2.f20976c = false;
            if (layoutParams2.f20974a == -2) {
                layoutParams2.f20975b = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams2, true);
        } else {
            attachViewToParent(view, z ? -1 : 0, layoutParams2);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.f20963t != 0 && this.f20967x != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.f20967x.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.f20967x.get(i, false).booleanValue());
            }
        }
        if (z8) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f20901N, this.f20900M.top + this.f20900M.bottom, layoutParams2.height);
            int i5 = layoutParams2.width;
            view.measure(i5 > 0 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (!z) {
            i2 -= measuredWidth;
        }
        if (z8) {
            view.layout(i2, i3, measuredWidth + i2, measuredHeight + i3);
        } else {
            view.offsetLeftAndRight(i2 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.f20904Q && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT < 11 || !z3 || ((AbsHListView.LayoutParams) view.getLayoutParams()).f20977d == i) {
            return;
        }
        view.jumpDrawablesToCurrentState();
    }

    /* renamed from: a */
    private void m2714a(View view, ArrayList<C4931b> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f21164a == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m2713a(ArrayList<C4931b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) arrayList.get(i).f21164a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f20975b = false;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017b  */
    @TargetApi(11)
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m2725a(int i, int i2, KeyEvent keyEvent) {
        boolean z;
        if (this.f20889B == null || !this.f20927ap) {
            return false;
        }
        if (this.f21056aK) {
            mo2691h();
        }
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        int action = keyEvent.getAction();
        if (action != 1) {
            switch (i) {
                case 19:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!r() && !m2673p(33)) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = r();
                        if (!z) {
                            while (true) {
                                int i3 = i2;
                                i2 = i3 - 1;
                                if (i3 > 0 && m2672q(33)) {
                                    z = true;
                                }
                            }
                        }
                    }
                    break;
                case 20:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!r() && !m2673p(130)) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = r();
                        if (!z) {
                            while (true) {
                                int i4 = i2;
                                i2 = i4 - 1;
                                if (i4 > 0 && m2672q(130)) {
                                    z = true;
                                }
                            }
                        }
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = m2678m(17);
                        break;
                    }
                    break;
                case 22:
                    if (keyEvent.hasNoModifiers()) {
                        z = m2678m(66);
                        break;
                    }
                    break;
                case 23:
                case 66:
                    if (keyEvent.hasNoModifiers()) {
                        z = r();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            l();
                            z = true;
                            break;
                        }
                    }
                    break;
                case 62:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || r() || m2674o(33) : r() || m2674o(130)) {
                    }
                    z = true;
                    break;
                case Opcodes.DUP2 /* 92 */:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!r() && !m2673p(33)) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        }
                    } else if (!r() && !m2674o(33)) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case Opcodes.DUP2_X1 /* 93 */:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!r() && !m2673p(130)) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        }
                    } else if (!r() && !m2674o(130)) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case 122:
                    if (keyEvent.hasNoModifiers()) {
                        if (!r() && !m2673p(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case Opcodes.LSHR /* 123 */:
                    if (keyEvent.hasNoModifiers()) {
                        if (!r() && !m2673p(130)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
            }
            if (!z) {
                return true;
            }
            switch (action) {
                case 0:
                    return super.onKeyDown(i, keyEvent);
                case 1:
                    return super.onKeyUp(i, keyEvent);
                case 2:
                    return super.onKeyMultiple(i, i2, keyEvent);
                default:
                    return false;
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* renamed from: b */
    private View m2711b(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.f21059aN;
        int m2698d = m2698d(i2, horizontalFadingEdgeLength, i4);
        int m2702c = m2702c(i3, horizontalFadingEdgeLength, i4);
        View m2724a = m2724a(i4, i, true, this.f20900M.top, true);
        if (m2724a.getRight() > m2702c) {
            m2724a.offsetLeftAndRight(-Math.min(m2724a.getLeft() - m2698d, m2724a.getRight() - m2702c));
        } else if (m2724a.getLeft() < m2698d) {
            m2724a.offsetLeftAndRight(Math.min(m2698d - m2724a.getLeft(), m2702c - m2724a.getRight()));
        }
        m2720a(m2724a, i4);
        if (!this.f20918af) {
            m2684k(getChildCount());
        } else {
            m2681l(getChildCount());
        }
        return m2724a;
    }

    /* renamed from: b */
    private View m2707b(View view, int i) {
        int i2 = i - 1;
        View a = a(i2, this.f20924am);
        m2717a(a, i2, view.getLeft() - this.f21148be, false, this.f20900M.top, false, this.f20924am[0]);
        return a;
    }

    /* renamed from: b */
    private void m2706b(View view, int i, int i2) {
        int width = view.getWidth();
        m2688i(view);
        if (view.getMeasuredWidth() != width) {
            m2685j(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    /* renamed from: b */
    private boolean m2705b(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m2705b((View) parent, view2);
    }

    /* renamed from: c */
    private int m2702c(int i, int i2, int i3) {
        return i3 != this.f21061aP + (-1) ? i - i2 : i;
    }

    /* renamed from: c */
    private View m2700c(View view, int i) {
        int i2 = i + 1;
        View a = a(i2, this.f20924am);
        m2717a(a, i2, this.f21148be + view.getRight(), true, this.f20900M.top, false, this.f20924am[0]);
        return a;
    }

    /* renamed from: d */
    private int m2698d(int i, int i2, int i3) {
        return i3 > 0 ? i + i2 : i;
    }

    /* renamed from: g */
    private View m2692g(View view) {
        ViewParent parent = view.getParent();
        while ((parent instanceof View) && parent != this) {
            parent = parent.getParent();
            view = (View) parent;
        }
        if (!(parent instanceof View)) {
            return null;
        }
        return view;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    /* renamed from: h */
    private boolean m2690h(View view) {
        ArrayList<C4931b> arrayList = this.f21145ba;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).f21164a) {
                return true;
            }
        }
        ArrayList<C4931b> arrayList2 = this.f21146bb;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).f21164a) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private View m2689i(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.f21061aP) {
            boolean z = i4 == this.f21059aN;
            View m2724a = m2724a(i4, i3, true, this.f20900M.top, z);
            i3 = m2724a.getRight() + this.f21148be;
            if (!z) {
                m2724a = view;
            }
            i4++;
            view = m2724a;
        }
        h(this.f21067aw, (this.f21067aw + getChildCount()) - 1);
        return view;
    }

    /* renamed from: i */
    private void m2688i(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f20901N, this.f20900M.top + this.f20900M.bottom, layoutParams.height);
        int i = layoutParams.width;
        view.measure(i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    /* renamed from: j */
    private View m2687j(int i) {
        this.f21067aw = Math.min(this.f21067aw, this.f21059aN);
        this.f21067aw = Math.min(this.f21067aw, this.f21061aP - 1);
        if (this.f21067aw < 0) {
            this.f21067aw = 0;
        }
        return m2689i(this.f21067aw, i);
    }

    /* renamed from: j */
    private void m2685j(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.f20900M.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    /* renamed from: k */
    private int m2682k(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m2705b(view, getChildAt(i))) {
                return i + this.f21067aw;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    /* renamed from: k */
    private View m2683k(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.f21059aN;
            View m2724a = m2724a(i4, i3, false, this.f20900M.top, z);
            i3 = m2724a.getLeft() - this.f21148be;
            if (!z) {
                m2724a = view;
            }
            i4--;
            view = m2724a;
        }
        this.f21067aw = i4 + 1;
        h(this.f21067aw, (this.f21067aw + getChildCount()) - 1);
        return view;
    }

    /* renamed from: k */
    private void m2684k(int i) {
        if ((this.f21067aw + i) - 1 != this.f21061aP - 1 || i <= 0) {
            return;
        }
        int right = ((getRight() - getLeft()) - this.f20900M.right) - getChildAt(i - 1).getRight();
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        if (right <= 0) {
            return;
        }
        if (this.f21067aw <= 0 && left >= this.f20900M.top) {
            return;
        }
        if (this.f21067aw == 0) {
            right = Math.min(right, this.f20900M.top - left);
        }
        e(right);
        if (this.f21067aw <= 0) {
            return;
        }
        m2683k(this.f21067aw - 1, childAt.getLeft() - this.f21148be);
        m2730D();
    }

    /* renamed from: l */
    private int m2679l(View view) {
        view.getDrawingRect(this.f21158bo);
        offsetDescendantRectToMyCoords(view, this.f21158bo);
        int right = (getRight() - getLeft()) - this.f20900M.right;
        if (this.f21158bo.right < this.f20900M.left) {
            return this.f20900M.left - this.f21158bo.right;
        }
        if (this.f21158bo.left <= right) {
            return 0;
        }
        return this.f21158bo.left - right;
    }

    /* renamed from: l */
    private View m2680l(int i, int i2) {
        int i3 = i2 - i;
        int p = p();
        View m2724a = m2724a(p, i, true, this.f20900M.top, true);
        this.f21067aw = p;
        int measuredWidth = m2724a.getMeasuredWidth();
        if (measuredWidth <= i3) {
            m2724a.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        m2720a(m2724a, p);
        if (!this.f20918af) {
            m2684k(getChildCount());
        } else {
            m2681l(getChildCount());
        }
        return m2724a;
    }

    /* renamed from: l */
    private void m2681l(int i) {
        if (this.f21067aw != 0 || i <= 0) {
            return;
        }
        int left = getChildAt(0).getLeft();
        int i2 = this.f20900M.left;
        int right = (getRight() - getLeft()) - this.f20900M.right;
        int i3 = left - i2;
        View childAt = getChildAt(i - 1);
        int right2 = childAt.getRight();
        int i4 = (this.f21067aw + i) - 1;
        if (i3 <= 0) {
            return;
        }
        if (i4 >= this.f21061aP - 1 && right2 <= right) {
            if (i4 != this.f21061aP - 1) {
                return;
            }
            m2730D();
            return;
        }
        if (i4 == this.f21061aP - 1) {
            i3 = Math.min(i3, right2 - right);
        }
        e(-i3);
        if (i4 >= this.f21061aP - 1) {
            return;
        }
        m2689i(i4 + 1, childAt.getRight() + this.f21148be);
        m2730D();
    }

    /* renamed from: m */
    private View m2677m(int i, int i2) {
        View m2689i;
        View m2683k;
        boolean z = i == this.f21059aN;
        View m2724a = m2724a(i, i2, true, this.f20900M.top, z);
        this.f21067aw = i;
        int i3 = this.f21148be;
        if (!this.f20918af) {
            m2683k = m2683k(i - 1, m2724a.getLeft() - i3);
            m2730D();
            m2689i = m2689i(i + 1, i3 + m2724a.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                m2684k(childCount);
            }
        } else {
            m2689i = m2689i(i + 1, m2724a.getRight() + i3);
            m2730D();
            m2683k = m2683k(i - 1, m2724a.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                m2681l(childCount2);
            }
        }
        return z ? m2724a : m2683k != null ? m2683k : m2689i;
    }

    /* renamed from: m */
    private boolean m2678m(int i) {
        View selectedView;
        if (i == 17 || i == 66) {
            int childCount = getChildCount();
            if (this.f21157bn && childCount > 0 && this.f21059aN != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
                View findFocus = selectedView.findFocus();
                View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
                if (findNextFocus != null) {
                    findFocus.getFocusedRect(this.f21158bo);
                    offsetDescendantRectToMyCoords(findFocus, this.f21158bo);
                    offsetRectIntoDescendantCoords(findNextFocus, this.f21158bo);
                    if (findNextFocus.requestFocus(i, this.f21158bo)) {
                        return true;
                    }
                }
                View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
                if (findNextFocus2 != null) {
                    return m2705b(findNextFocus2, this);
                }
            }
            return false;
        }
        throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }

    /* renamed from: n */
    private int m2675n(int i, int i2) {
        int width = getWidth() - this.f20900M.right;
        int i3 = this.f20900M.left;
        int childCount = getChildCount();
        if (i != 130) {
            int i4 = i2 != -1 ? i2 - this.f21067aw : 0;
            int i5 = this.f21067aw + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
            if (childAt.getLeft() >= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 != -1 && childAt.getRight() - arrowScrollPreviewLength >= getMaxScrollAmount()) {
                return 0;
            }
            int left = arrowScrollPreviewLength - childAt.getLeft();
            if (this.f21067aw == 0) {
                left = Math.min(left, i3 - getChildAt(0).getLeft());
            }
            return Math.min(left, getMaxScrollAmount());
        }
        int i6 = childCount - 1;
        if (i2 != -1) {
            i6 = i2 - this.f21067aw;
        }
        int i7 = this.f21067aw + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 < this.f21061aP + (-1) ? width - getArrowScrollPreviewLength() : width;
        if (childAt2.getRight() <= arrowScrollPreviewLength2) {
            return 0;
        }
        if (i2 != -1 && arrowScrollPreviewLength2 - childAt2.getLeft() >= getMaxScrollAmount()) {
            return 0;
        }
        int right = childAt2.getRight() - arrowScrollPreviewLength2;
        if (this.f21067aw + childCount == this.f21061aP) {
            right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
        }
        return Math.min(right, getMaxScrollAmount());
    }

    /* renamed from: n */
    private boolean m2676n(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.f21059aN;
        int m2671r = m2671r(i);
        int m2675n = m2675n(i, m2671r);
        C4930a m2670s = this.f21157bn ? m2670s(i) : null;
        if (m2670s != null) {
            m2671r = m2670s.m2668a();
            m2675n = m2670s.m2666b();
        }
        boolean z = m2670s != null;
        if (m2671r != -1) {
            m2718a(selectedView, i, m2671r, m2670s != null);
            setSelectedPositionInt(m2671r);
            setNextSelectedPositionInt(m2671r);
            view = getSelectedView();
            if (this.f21157bn && m2670s == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            y();
            z = true;
            i2 = m2671r;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (m2675n > 0) {
            m2669t(i == 33 ? m2675n : -m2675n);
            z = true;
        }
        if (this.f21157bn && m2670s == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!m2705b(findFocus, this) || m2679l(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (m2671r != -1 || view == null || m2705b(view, this)) {
            view2 = view;
        } else {
            o();
            this.f20921ai = -1;
            view2 = null;
        }
        if (!z) {
            return false;
        }
        if (view2 != null) {
            a(i2, view2);
            this.f20917ae = view2.getLeft();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        c();
        return true;
    }

    /* renamed from: r */
    private int m2671r(int i) {
        int i2 = this.f21067aw;
        if (i == 130) {
            int i3 = this.f21059aN != -1 ? this.f21059aN + 1 : i2;
            if (i3 >= this.f20889B.getCount()) {
                return -1;
            }
            if (i3 < i2) {
                i3 = i2;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i3 <= lastVisiblePosition) {
                if (adapter.isEnabled(i3) && getChildAt(i3 - i2).getVisibility() == 0) {
                    return i3;
                }
                i3++;
            }
        } else {
            int childCount = (getChildCount() + i2) - 1;
            int childCount2 = this.f21059aN != -1 ? this.f21059aN - 1 : (getChildCount() + i2) - 1;
            if (childCount2 < 0 || childCount2 >= this.f20889B.getCount()) {
                return -1;
            }
            if (childCount2 <= childCount) {
                childCount = childCount2;
            }
            ListAdapter adapter2 = getAdapter();
            while (childCount >= i2) {
                if (adapter2.isEnabled(childCount) && getChildAt(childCount - i2).getVisibility() == 0) {
                    return childCount;
                }
                childCount--;
            }
        }
        return -1;
    }

    /* renamed from: s */
    private C4930a m2670s(int i) {
        View findNextFocusFromRect;
        int m2671r;
        boolean z = true;
        View selectedView = getSelectedView();
        if (selectedView == null || !selectedView.hasFocus()) {
            if (i == 130) {
                if (this.f21067aw <= 0) {
                    z = false;
                }
                int arrowScrollPreviewLength = (z ? getArrowScrollPreviewLength() : 0) + this.f20900M.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.f21158bo.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                if ((this.f21067aw + getChildCount()) - 1 >= this.f21061aP) {
                    z = false;
                }
                int width = (getWidth() - this.f20900M.right) - (z ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.f21158bo.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.f21158bo, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        }
        if (findNextFocusFromRect != null) {
            int m2682k = m2682k(findNextFocusFromRect);
            if (this.f21059aN != -1 && m2682k != this.f21059aN && (m2671r = m2671r(i)) != -1 && ((i == 130 && m2671r < m2682k) || (i == 33 && m2671r > m2682k))) {
                return null;
            }
            int m2723a = m2723a(i, findNextFocusFromRect, m2682k);
            int maxScrollAmount = getMaxScrollAmount();
            if (m2723a < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.f21160bq.m2667a(m2682k, m2723a);
                return this.f21160bq;
            } else if (m2679l(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.f21160bq.m2667a(m2682k, maxScrollAmount);
                return this.f21160bq;
            }
        }
        return null;
    }

    /* renamed from: t */
    private void m2669t(int i) {
        int i2;
        e(i);
        int width = getWidth() - this.f20900M.right;
        int i3 = this.f20900M.left;
        AbsHListView.C4908j c4908j = this.f20895H;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.f21067aw + childCount) - 1 < this.f21061aP - 1) {
                childAt = m2700c(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                e(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() >= i3) {
                    return;
                }
                if (c4908j.m2820b(((AbsHListView.LayoutParams) view.getLayoutParams()).f20974a)) {
                    detachViewFromParent(view);
                    c4908j.m2825a(view, this.f21067aw);
                } else {
                    removeViewInLayout(view);
                }
                childAt2 = getChildAt(0);
                this.f21067aw++;
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.f21067aw > 0) {
                childAt3 = m2707b(childAt3, this.f21067aw);
                this.f21067aw--;
            }
            if (childAt3.getLeft() > i3) {
                e(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() <= width) {
                    return;
                }
                if (c4908j.m2820b(((AbsHListView.LayoutParams) view2.getLayoutParams()).f20974a)) {
                    detachViewFromParent(view2);
                    c4908j.m2825a(view2, this.f21067aw + i4);
                } else {
                    removeViewInLayout(view2);
                }
                childCount2 = i4 - 1;
                childAt4 = getChildAt(childCount2);
            }
        }
    }

    @ViewDebug.ExportedProperty(category = "list")
    /* renamed from: B */
    protected boolean m2732B() {
        return true;
    }

    /* renamed from: C */
    public void m2731C() {
        int size = this.f21145ba.size();
        if (size > 0) {
            this.f21057aL = 0;
        } else if (this.f20889B != null) {
            setSelection(size);
        } else {
            this.f21057aL = size;
            this.f20969z = 2;
        }
    }

    /* renamed from: a */
    final int m2727a(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.f20889B;
        if (listAdapter == null) {
            return this.f20900M.left + this.f20900M.right;
        }
        int i7 = this.f20900M.left + this.f20900M.right;
        int i8 = (this.f21148be <= 0 || this.f21147bd == null) ? 0 : this.f21148be;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.C4908j c4908j = this.f20895H;
        boolean m2732B = m2732B();
        boolean[] zArr = this.f20924am;
        while (i2 <= i3) {
            View a = a(i2, zArr);
            m2719a(a, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (m2732B && c4908j.m2820b(((AbsHListView.LayoutParams) a.getLayoutParams()).f20974a)) {
                c4908j.m2825a(a, -1);
            }
            i7 = a.getMeasuredWidth() + i9;
            if (i7 >= i4) {
                return (i5 < 0 || i2 <= i5 || i6 <= 0 || i7 == i4) ? i4 : i6;
            }
            if (i5 >= 0 && i2 >= i5) {
                i6 = i7;
            }
            i2++;
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2722a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.f21147bd;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    /* renamed from: a */
    void m2721a(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.left = rect.right - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    public void m2715a(View view, Object obj, boolean z) {
        if (this.f20889B == null || (this.f20889B instanceof C4935c)) {
            C4931b c4931b = new C4931b();
            c4931b.f21164a = view;
            c4931b.f21165b = obj;
            c4931b.f21166c = z;
            this.f21145ba.add(c4931b);
            if (this.f20889B == null || this.f20888A == null) {
                return;
            }
            this.f20888A.onChanged();
            return;
        }
        throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: a */
    protected void mo2712a(boolean z) {
        int i = 0;
        int childCount = getChildCount();
        if (!z) {
            m2683k(this.f21067aw - 1, childCount > 0 ? getChildAt(0).getLeft() - this.f21148be : getWidth() - 0);
            m2681l(getChildCount());
            return;
        }
        if (childCount > 0) {
            i = getChildAt(childCount - 1).getRight() + this.f21148be;
        }
        m2689i(childCount + this.f21067aw, i);
        m2684k(getChildCount());
    }

    /* renamed from: a */
    final int[] m2726a(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.f20889B;
        if (listAdapter == null) {
            return new int[]{this.f20900M.left + this.f20900M.right, this.f20900M.top + this.f20900M.bottom};
        }
        int i7 = this.f20900M.left + this.f20900M.right;
        int i8 = this.f20900M.top + this.f20900M.bottom;
        int i9 = (this.f21148be <= 0 || this.f21147bd == null) ? 0 : this.f21148be;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.C4908j c4908j = this.f20895H;
        boolean m2732B = m2732B();
        boolean[] zArr = this.f20924am;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View a = a(i2, zArr);
            m2719a(a, i2, i);
            if (m2732B && c4908j.m2820b(((AbsHListView.LayoutParams) a.getLayoutParams()).f20974a)) {
                c4908j.m2825a(a, -1);
            }
            i10 = Math.max(i10, a.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, a.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView
    /* renamed from: b */
    public int mo2710b(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.f20889B;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (this.f21156bm) {
            if (i >= 0 && i < count) {
                return i;
            }
            return -1;
        }
        if (z) {
            min = Math.max(0, i);
            while (min < count && !listAdapter.isEnabled(min)) {
                min++;
            }
        } else {
            min = Math.min(i, count - 1);
            while (min >= 0 && !listAdapter.isEnabled(min)) {
                min--;
            }
        }
        if (min >= 0 && min < count) {
            return min;
        }
        return -1;
    }

    /* renamed from: b */
    void m2709b(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.right = minimumWidth + rect.left;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* renamed from: b */
    public void m2708b(View view) {
        m2715a(view, (Object) null, true);
    }

    /* renamed from: b */
    public void m2704b(View view, Object obj, boolean z) {
        C4931b c4931b = new C4931b();
        c4931b.f21164a = view;
        c4931b.f21165b = obj;
        c4931b.f21166c = z;
        this.f21146bb.add(c4931b);
        if (this.f20889B == null || this.f20888A == null) {
            return;
        }
        this.f20888A.onChanged();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: c */
    public void mo2703c(int i) {
        super.mo2703c(i);
    }

    /* renamed from: c */
    public boolean m2701c(View view) {
        boolean z;
        if (this.f21145ba.size() > 0) {
            if (this.f20889B == null || !((C4935c) this.f20889B).m2645a(view)) {
                z = false;
            } else {
                if (this.f20888A != null) {
                    this.f20888A.onChanged();
                }
                z = true;
            }
            m2714a(view, this.f21145ba);
            return z;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.f21061aP > 0;
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: d */
    public void mo2699d(int i) {
        super.mo2699d(i);
    }

    /* renamed from: d */
    public void m2697d(View view) {
        m2704b(view, (Object) null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int left;
        if (this.f20904Q) {
            this.f20905R = true;
        }
        int i = this.f21148be;
        Drawable drawable = this.f21150bg;
        Drawable drawable2 = this.f21151bh;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.f21147bd != null;
        if (z3 || z || z2) {
            Rect rect = this.f21158bo;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.f21145ba.size();
            int i2 = this.f21061aP;
            int size2 = (i2 - this.f21146bb.size()) - 1;
            boolean z4 = this.f21154bk;
            boolean z5 = this.f21155bl;
            int i3 = this.f21067aw;
            boolean z6 = this.f21156bm;
            ListAdapter listAdapter = this.f20889B;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.f21159bp == null && this.f21152bi) {
                this.f21159bp = new Paint();
                this.f21159bp.setColor(getCacheColorHint());
            }
            Paint paint = this.f21159bp;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.f20918af) {
                int scrollX2 = getScrollX();
                if (childCount > 0 && scrollX2 < 0) {
                    if (z) {
                        rect.right = 0;
                        rect.left = scrollX2;
                        m2721a(canvas, drawable, rect);
                    } else if (z3) {
                        rect.right = 0;
                        rect.left = -i;
                        mo2722a(canvas, rect, -1);
                    }
                }
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    if ((z4 || i3 + i5 >= size) && (z5 || i3 + i5 < size2)) {
                        i4 = getChildAt(i5).getRight();
                        if (z3 && i4 < scrollX && (!z2 || i5 != childCount - 1)) {
                            if (z6 || (listAdapter.isEnabled(i3 + i5) && (i5 == childCount - 1 || listAdapter.isEnabled(i3 + i5 + 1)))) {
                                rect.left = i4;
                                rect.right = i4 + i;
                                mo2722a(canvas, rect, i5);
                            } else if (z7) {
                                rect.left = i4;
                                rect.right = i4 + i;
                                canvas.drawRect(rect, paint);
                            }
                        }
                    }
                }
                int right = getRight() + getScrollX();
                if (z2 && i3 + childCount == i2 && right > i4) {
                    rect.left = i4;
                    rect.right = right;
                    m2709b(canvas, drawable2, rect);
                }
            } else {
                int scrollX3 = getScrollX();
                if (childCount > 0 && z) {
                    rect.left = scrollX3;
                    rect.right = getChildAt(0).getLeft();
                    m2721a(canvas, drawable, rect);
                }
                for (int i6 = z ? 1 : 0; i6 < childCount; i6++) {
                    if ((z4 || i3 + i6 >= size) && ((z5 || i3 + i6 < size2) && (left = getChildAt(i6).getLeft()) > 0)) {
                        if (z6 || (listAdapter.isEnabled(i3 + i6) && (i6 == childCount - 1 || listAdapter.isEnabled(i3 + i6 + 1)))) {
                            rect.left = left - i;
                            rect.right = left;
                            mo2722a(canvas, rect, i6 - 1);
                        } else if (z7) {
                            rect.left = left - i;
                            rect.right = left;
                            canvas.drawRect(rect, paint);
                        }
                    }
                }
                if (childCount > 0 && scrollX3 > 0) {
                    if (z2) {
                        int right2 = getRight();
                        rect.left = right2;
                        rect.right = right2 + scrollX3;
                        m2709b(canvas, drawable2, rect);
                    } else if (z3) {
                        rect.left = scrollX;
                        rect.right = scrollX + i;
                        mo2722a(canvas, rect, -1);
                    }
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.f20905R) {
            this.f20905R = false;
        }
        return drawChild;
    }

    /* renamed from: e */
    public boolean m2696e(View view) {
        boolean z;
        if (this.f21146bb.size() > 0) {
            if (this.f20889B == null || !((C4935c) this.f20889B).m2642b(view)) {
                z = false;
            } else {
                if (this.f20888A != null) {
                    this.f20888A.onChanged();
                }
                z = true;
            }
            m2714a(view, this.f21146bb);
            return z;
        }
        return false;
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: f */
    protected int mo2695f(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.f20918af) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (i <= getChildAt(i2).getRight()) {
                        return i2 + this.f21067aw;
                    }
                }
            } else {
                for (int i3 = childCount - 1; i3 >= 0; i3--) {
                    if (i >= getChildAt(i3).getLeft()) {
                        return i3 + this.f21067aw;
                    }
                }
            }
        }
        return -1;
    }

    /* renamed from: f */
    public int[] m2694f(View view) {
        m2688i(view);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: g */
    public void mo2693g() {
        m2713a(this.f21145ba);
        m2713a(this.f21146bb);
        super.mo2693g();
        this.f20969z = 0;
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f20889B;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        int i;
        if (this.f20889B == null || !this.f20889B.hasStableIds()) {
            if (this.f20963t == 0 || this.f20967x == null || this.f20889B == null) {
                return new long[0];
            }
            SparseArrayCompat<Boolean> sparseArrayCompat = this.f20967x;
            int size = sparseArrayCompat.size();
            long[] jArr = new long[size];
            ListAdapter listAdapter = this.f20889B;
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (sparseArrayCompat.valueAt(i2).booleanValue()) {
                    i = i3 + 1;
                    jArr[i3] = listAdapter.getItemId(sparseArrayCompat.keyAt(i2));
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            if (i3 == size) {
                return jArr;
            }
            long[] jArr2 = new long[i3];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            return jArr2;
        }
        return getCheckedItemIds();
    }

    public Drawable getDivider() {
        return this.f21147bd;
    }

    public int getDividerWidth() {
        return this.f21148be;
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.f21146bb.size();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.f21145ba.size();
    }

    public boolean getItemsCanFocus() {
        return this.f21157bn;
    }

    public int getMaxScrollAmount() {
        return (int) (f21141aX * (getRight() - getLeft()));
    }

    public Drawable getOverscrollFooter() {
        return this.f21151bh;
    }

    public Drawable getOverscrollHeader() {
        return this.f21150bg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: h */
    public void mo2691h() {
        View view;
        View view2;
        View view3;
        View m2716a;
        boolean z = this.f21066aW;
        if (!z) {
            this.f21066aW = true;
            try {
                super.mo2691h();
                invalidate();
                if (this.f20889B == null) {
                    mo2693g();
                    c();
                    if (z) {
                        return;
                    }
                    return;
                }
                int i = this.f20900M.left;
                int right = (getRight() - getLeft()) - this.f20900M.right;
                int childCount = getChildCount();
                int i2 = 0;
                View view4 = null;
                View view5 = null;
                View view6 = null;
                switch (this.f20969z) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        view = null;
                        break;
                    case 2:
                        int i3 = this.f21057aL - this.f21067aw;
                        if (i3 < 0 || i3 >= childCount) {
                            view = null;
                            break;
                        } else {
                            view5 = getChildAt(i3);
                            view = null;
                            break;
                        }
                    default:
                        int i4 = this.f21059aN - this.f21067aw;
                        if (i4 >= 0 && i4 < childCount) {
                            view4 = getChildAt(i4);
                        }
                        View childAt = getChildAt(0);
                        if (this.f21057aL >= 0) {
                            i2 = this.f21057aL - this.f21059aN;
                        }
                        view5 = getChildAt(i4 + i2);
                        view = childAt;
                        break;
                }
                boolean z2 = this.f21056aK;
                if (z2) {
                    u();
                }
                if (this.f21061aP == 0) {
                    mo2693g();
                    c();
                    if (z) {
                        return;
                    }
                    this.f21066aW = false;
                } else if (this.f21061aP != this.f20889B.getCount()) {
                    throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.f20889B.getClass() + ")]");
                } else {
                    setSelectedPositionInt(this.f21057aL);
                    int i5 = this.f21067aw;
                    AbsHListView.C4908j c4908j = this.f20895H;
                    View view7 = null;
                    if (z2) {
                        for (int i6 = 0; i6 < childCount; i6++) {
                            c4908j.m2825a(getChildAt(i6), i5 + i6);
                        }
                    } else {
                        c4908j.m2826a(childCount, i5);
                    }
                    View focusedChild = getFocusedChild();
                    if (focusedChild != null) {
                        if (!z2 || m2690h(focusedChild)) {
                            view6 = findFocus();
                            if (view6 != null) {
                                view6.onStartTemporaryDetach();
                            }
                            view7 = focusedChild;
                        }
                        requestFocus();
                        view2 = view6;
                        view3 = view7;
                    } else {
                        view2 = null;
                        view3 = null;
                    }
                    detachAllViewsFromParent();
                    c4908j.m2817d();
                    switch (this.f20969z) {
                        case 1:
                            this.f21067aw = 0;
                            View m2687j = m2687j(i);
                            m2730D();
                            m2716a = m2687j;
                            break;
                        case 2:
                            if (view5 != null) {
                                m2716a = m2711b(view5.getLeft(), i, right);
                                break;
                            } else {
                                m2716a = m2680l(i, right);
                                break;
                            }
                        case 3:
                            View m2683k = m2683k(this.f21061aP - 1, right);
                            m2730D();
                            m2716a = m2683k;
                            break;
                        case 4:
                            m2716a = m2677m(p(), this.f21068ax);
                            break;
                        case 5:
                            m2716a = m2677m(this.f21069ay, this.f21068ax);
                            break;
                        case 6:
                            m2716a = m2716a(view4, view5, i2, i, right);
                            break;
                        default:
                            if (childCount == 0) {
                                if (!this.f20918af) {
                                    setSelectedPositionInt(mo2710b(0, true));
                                    m2716a = m2687j(i);
                                    break;
                                } else {
                                    setSelectedPositionInt(mo2710b(this.f21061aP - 1, false));
                                    m2716a = m2683k(this.f21061aP - 1, right);
                                    break;
                                }
                            } else if (this.f21059aN < 0 || this.f21059aN >= this.f21061aP) {
                                if (this.f21067aw < this.f21061aP) {
                                    int i7 = this.f21067aw;
                                    if (view != null) {
                                        i = view.getLeft();
                                    }
                                    m2716a = m2677m(i7, i);
                                    break;
                                } else {
                                    m2716a = m2677m(0, i);
                                    break;
                                }
                            } else {
                                int i8 = this.f21059aN;
                                if (view4 != null) {
                                    i = view4.getLeft();
                                }
                                m2716a = m2677m(i8, i);
                                break;
                            }
                    }
                    c4908j.m2815e();
                    if (m2716a != null) {
                        if (!this.f21157bn || !hasFocus() || m2716a.hasFocus()) {
                            a(-1, m2716a);
                        } else if (!((m2716a == view3 && view2 != null && view2.requestFocus()) || m2716a.requestFocus())) {
                            View focusedChild2 = getFocusedChild();
                            if (focusedChild2 != null) {
                                focusedChild2.clearFocus();
                            }
                            a(-1, m2716a);
                        } else {
                            m2716a.setSelected(false);
                            this.f20894G.setEmpty();
                        }
                        this.f20917ae = m2716a.getLeft();
                    } else {
                        if (this.f20913aa <= 0 || this.f20913aa >= 3) {
                            this.f20917ae = 0;
                            this.f20894G.setEmpty();
                        } else {
                            View childAt2 = getChildAt(this.f20906S - this.f21067aw);
                            if (childAt2 != null) {
                                a(this.f20906S, childAt2);
                            }
                        }
                        if (hasFocus() && view2 != null) {
                            view2.requestFocus();
                        }
                    }
                    if (view2 != null && view2.getWindowToken() != null) {
                        view2.onFinishTemporaryDetach();
                    }
                    this.f20969z = 0;
                    this.f21056aK = false;
                    if (this.f20923al != null) {
                        post(this.f20923al);
                        this.f20923al = null;
                    }
                    this.f21050aB = false;
                    setNextSelectedPositionInt(this.f21059aN);
                    i();
                    if (this.f21061aP > 0) {
                        y();
                    }
                    c();
                    if (z) {
                        return;
                    }
                    this.f21066aW = false;
                }
            } finally {
                if (!z) {
                    this.f21066aW = false;
                }
            }
        }
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.f20905R && this.f21152bi && this.f21153bj) || super.isOpaque();
        if (z) {
            int paddingLeft = this.f20900M != null ? this.f20900M.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.f20900M != null ? this.f20900M.right : getPaddingRight());
            View childAt2 = getChildAt(getChildCount() - 1);
            if (childAt2 == null || childAt2.getRight() < width) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: j */
    public void m2686j(int i, int i2) {
        if (this.f20889B == null) {
            return;
        }
        if (!isInTouchMode()) {
            i = mo2710b(i, true);
            if (i >= 0) {
                setNextSelectedPositionInt(i);
            }
        } else {
            this.f20921ai = i;
        }
        if (i < 0) {
            return;
        }
        this.f20969z = 4;
        this.f21068ax = this.f20900M.left + i2;
        if (this.f21050aB) {
            this.f21069ay = i;
            this.f21070az = this.f20889B.getItemId(i);
        }
        if (this.f20916ad != null) {
            this.f20916ad.m2834a();
        }
        requestLayout();
    }

    /* renamed from: o */
    boolean m2674o(int i) {
        int i2;
        boolean z;
        int mo2710b;
        if (i == 33) {
            i2 = Math.max(0, (this.f21059aN - getChildCount()) - 1);
            z = false;
        } else if (i == 130) {
            i2 = Math.min(this.f21061aP - 1, (this.f21059aN + getChildCount()) - 1);
            z = true;
        } else {
            i2 = -1;
            z = false;
        }
        if (i2 < 0 || (mo2710b = mo2710b(i2, z)) < 0) {
            return false;
        }
        this.f20969z = 4;
        this.f21068ax = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && mo2710b > this.f21061aP - getChildCount()) {
            this.f20969z = 3;
        }
        if (!z && mo2710b < getChildCount()) {
            this.f20969z = 1;
        }
        setSelectionInt(mo2710b);
        c();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                m2708b(getChildAt(i));
            }
            removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        int i2;
        int i3;
        int i4 = 0;
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.f20889B;
        int i5 = -1;
        if (listAdapter != null && z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.f21067aw) {
                this.f20969z = 0;
                mo2691h();
            }
            Rect rect2 = this.f21158bo;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.f21067aw;
            int i8 = 0;
            while (i8 < childCount) {
                if (!listAdapter.isEnabled(i7 + i8)) {
                    i2 = i4;
                    i3 = i5;
                } else {
                    View childAt = getChildAt(i8);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int a = a(rect, rect2, i);
                    if (a < i6) {
                        i3 = i8;
                        i6 = a;
                        i2 = childAt.getLeft();
                    } else {
                        i2 = i4;
                        i3 = i5;
                    }
                }
                i8++;
                i5 = i3;
                i4 = i2;
            }
        }
        if (i5 >= 0) {
            m2686j(this.f21067aw + i5, i4);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return m2725a(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return m2725a(i, i2, keyEvent);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return m2725a(i, 1, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    @TargetApi(11)
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        this.f21061aP = this.f20889B == null ? 0 : this.f20889B.getCount();
        if (this.f21061aP > 0 && (mode == 0 || mode2 == 0)) {
            View a = a(0, this.f20924am);
            m2719a(a, 0, i2);
            i3 = a.getMeasuredWidth();
            i4 = a.getMeasuredHeight();
            if (Build.VERSION.SDK_INT >= 11) {
                i5 = combineMeasuredStates(0, a.getMeasuredState());
            }
            if (m2732B() && this.f20895H.m2820b(((AbsHListView.LayoutParams) a.getLayoutParams()).f20974a)) {
                this.f20895H.m2825a(a, -1);
            }
        }
        int i6 = i3;
        int horizontalScrollbarHeight = mode2 == 0 ? i4 + this.f20900M.top + this.f20900M.bottom + getHorizontalScrollbarHeight() : (mode2 != Integer.MIN_VALUE || this.f21061aP <= 0 || this.f21149bf <= -1) ? Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & i5) : size2 : m2726a(i2, this.f21149bf, this.f21149bf, size, size2, -1)[1];
        if (mode == 0) {
            size = this.f20900M.left + this.f20900M.right + i6 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = m2727a(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, horizontalScrollbarHeight);
        this.f20901N = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.f21067aw + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.f21161br == null) {
                this.f21161br = new RunnableC4932c();
            }
            post(this.f21161br.m2665a(indexOfChild, left));
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* renamed from: p */
    boolean m2673p(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.f21059aN != 0) {
                int mo2710b = mo2710b(0, true);
                if (mo2710b >= 0) {
                    this.f20969z = 1;
                    setSelectionInt(mo2710b);
                    c();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.f21059aN < this.f21061aP - 1) {
                int mo2710b2 = mo2710b(this.f21061aP - 1, true);
                if (mo2710b2 >= 0) {
                    this.f20969z = 3;
                    setSelectionInt(mo2710b2);
                    c();
                }
            }
            z = false;
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    /* renamed from: q */
    boolean m2672q(int i) {
        try {
            this.f21052aG = true;
            boolean m2676n = m2676n(i);
            if (m2676n) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return m2676n;
        } finally {
            this.f21052aG = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int i;
        int i2 = rect.left;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i3 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (m2729E() && (this.f21059aN > 0 || i2 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (m2728F() && (this.f21059aN < this.f21061aP - 1 || rect.right < right - horizontalFadingEdgeLength)) {
            i3 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i3 && rect.left > scrollX) {
            i = Math.min(rect.width() > width ? (rect.left - scrollX) + 0 : (rect.right - i3) + 0, right - i3);
        } else if (rect.left >= scrollX || rect.right >= i3) {
            i = 0;
        } else {
            i = Math.max(rect.width() > width ? 0 - (i3 - rect.right) : 0 - (scrollX - rect.left), getChildAt(0).getLeft() - scrollX);
        }
        boolean z2 = i != 0;
        if (z2) {
            m2669t(-i);
            a(-1, view);
            this.f20917ae = view.getTop();
            invalidate();
        }
        return z2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f20889B != null && this.f20888A != null) {
            this.f20889B.unregisterDataSetObserver(this.f20888A);
        }
        mo2693g();
        this.f20895H.m2821b();
        if (this.f21145ba.size() > 0 || this.f21146bb.size() > 0) {
            this.f20889B = new C4935c(this.f21145ba, this.f21146bb, listAdapter);
        } else {
            this.f20889B = listAdapter;
        }
        this.f21064aU = -1;
        this.f21065aV = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.f20889B != null) {
            this.f21156bm = this.f20889B.areAllItemsEnabled();
            this.f21062aQ = this.f21061aP;
            this.f21061aP = this.f20889B.getCount();
            w();
            this.f20888A = new AbsHListView.C4895a();
            this.f20889B.registerDataSetObserver(this.f20888A);
            this.f20895H.m2827a(this.f20889B.getViewTypeCount());
            int mo2710b = this.f20918af ? mo2710b(this.f21061aP - 1, false) : mo2710b(0, true);
            setSelectedPositionInt(mo2710b);
            setNextSelectedPositionInt(mo2710b);
            if (this.f21061aP == 0) {
                y();
            }
        } else {
            this.f21156bm = true;
            w();
            y();
        }
        requestLayout();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.f21152bi = z;
        if (z) {
            if (this.f21159bp == null) {
                this.f21159bp = new Paint();
            }
            this.f21159bp.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.f21148be = drawable.getIntrinsicWidth();
        } else {
            this.f21148be = 0;
        }
        this.f21147bd = drawable;
        if (drawable == null || drawable.getOpacity() == -1) {
            z = true;
        }
        this.f21153bj = z;
        requestLayout();
        invalidate();
    }

    public void setDividerWidth(int i) {
        this.f21148be = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.f21155bl = z;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.f21154bk = z;
        invalidate();
    }

    public void setItemsCanFocus(boolean z) {
        this.f21157bn = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.f21151bh = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.f21150bg = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    public void setSelection(int i) {
        m2686j(i, 0);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.f21059aN;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.f20916ad != null) {
            this.f20916ad.m2834a();
        }
        mo2691h();
        if (z) {
            awakenScrollBars();
        }
    }
}
