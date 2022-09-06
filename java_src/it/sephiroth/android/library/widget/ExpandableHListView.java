package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import it.sephiroth.android.library.C4881R;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ExpandableHListView extends HListView {

    /* renamed from: aX */
    public static final int f21097aX = 0;

    /* renamed from: aY */
    public static final int f21098aY = 1;

    /* renamed from: aZ */
    public static final int f21099aZ = 2;

    /* renamed from: bA */
    private static final int[] f21100bA = new int[0];

    /* renamed from: bB */
    private static final int[] f21101bB = {16842920};

    /* renamed from: bC */
    private static final int[] f21102bC = {16842921};

    /* renamed from: bD */
    private static final int[] f21103bD = {16842920, 16842921};

    /* renamed from: bE */
    private static final int[][] f21104bE = {f21100bA, f21101bB, f21102bC, f21103bD};

    /* renamed from: bF */
    private static final int[] f21105bF = {16842918};

    /* renamed from: ba */
    public static final long f21106ba = 4294967295L;

    /* renamed from: bb */
    public static final int f21107bb = -1;

    /* renamed from: bi */
    private static final long f21108bi = 4294967295L;

    /* renamed from: bj */
    private static final long f21109bj = 9223372032559808512L;

    /* renamed from: bk */
    private static final long f21110bk = Long.MIN_VALUE;

    /* renamed from: bl */
    private static final long f21111bl = 32;

    /* renamed from: bm */
    private static final long f21112bm = 63;

    /* renamed from: bn */
    private static final long f21113bn = -1;

    /* renamed from: bo */
    private static final long f21114bo = 2147483647L;

    /* renamed from: bx */
    private static final int f21115bx = -2;

    /* renamed from: bG */
    private Drawable f21116bG;

    /* renamed from: bH */
    private final Rect f21117bH;

    /* renamed from: bI */
    private final Rect f21118bI;

    /* renamed from: bJ */
    private int f21119bJ;

    /* renamed from: bK */
    private int f21120bK;

    /* renamed from: bL */
    private int f21121bL;

    /* renamed from: bM */
    private int f21122bM;

    /* renamed from: bN */
    private AbstractC4927d f21123bN;

    /* renamed from: bO */
    private AbstractC4928e f21124bO;

    /* renamed from: bP */
    private AbstractC4926c f21125bP;

    /* renamed from: bQ */
    private AbstractC4925b f21126bQ;

    /* renamed from: bp */
    private ExpandableHListConnector f21127bp;

    /* renamed from: bq */
    private ExpandableListAdapter f21128bq;

    /* renamed from: br */
    private int f21129br;

    /* renamed from: bs */
    private int f21130bs;

    /* renamed from: bt */
    private int f21131bt;

    /* renamed from: bu */
    private int f21132bu;

    /* renamed from: bv */
    private int f21133bv;

    /* renamed from: bw */
    private int f21134bw;

    /* renamed from: by */
    private Drawable f21135by;

    /* renamed from: bz */
    private Drawable f21136bz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: it.sephiroth.android.library.widget.ExpandableHListView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        ArrayList<ExpandableHListConnector.GroupMetadata> f21137a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f21137a = new ArrayList<>();
            parcel.readList(this.f21137a, ExpandableHListConnector.class.getClassLoader());
        }

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.f21137a = arrayList;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.f21137a);
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListView$a */
    /* loaded from: classes2.dex */
    public static class ContextMenu$ContextMenuInfoC4924a implements ContextMenu.ContextMenuInfo {

        /* renamed from: a */
        public View f21138a;

        /* renamed from: b */
        public long f21139b;

        /* renamed from: c */
        public long f21140c;

        public ContextMenu$ContextMenuInfoC4924a(View view, long j, long j2) {
            this.f21138a = view;
            this.f21139b = j;
            this.f21140c = j2;
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListView$b */
    /* loaded from: classes2.dex */
    public interface AbstractC4925b {
        /* renamed from: a */
        boolean m2736a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListView$c */
    /* loaded from: classes2.dex */
    public interface AbstractC4926c {
        /* renamed from: a */
        boolean m2735a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListView$d */
    /* loaded from: classes2.dex */
    public interface AbstractC4927d {
        /* renamed from: a */
        void m2734a(int i);
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListView$e */
    /* loaded from: classes2.dex */
    public interface AbstractC4928e {
        /* renamed from: a */
        void m2733a(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C4881R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21117bH = new Rect();
        this.f21118bI = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4881R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(3));
        setChildIndicator(obtainStyledAttributes.getDrawable(4));
        this.f21130bs = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f21129br = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f21131bt = obtainStyledAttributes.getInt(0, 0);
        this.f21132bu = obtainStyledAttributes.getInt(1, 0);
        this.f21134bw = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.f21133bv = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f21116bG = obtainStyledAttributes.getDrawable(2);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: D */
    private void m2760D() {
        if (this.f21135by != null) {
            this.f21119bJ = this.f21135by.getIntrinsicWidth();
            this.f21120bK = this.f21135by.getIntrinsicHeight();
            return;
        }
        this.f21119bJ = 0;
        this.f21120bK = 0;
    }

    /* renamed from: E */
    private void m2759E() {
        if (this.f21136bz != null) {
            this.f21121bL = this.f21136bz.getIntrinsicWidth();
            this.f21122bM = this.f21136bz.getIntrinsicHeight();
            return;
        }
        this.f21121bL = 0;
        this.f21122bM = 0;
    }

    /* renamed from: a */
    private long m2755a(C4934b c4934b) {
        return c4934b.f21231f == 1 ? this.f21128bq.getChildId(c4934b.f21228c, c4934b.f21229d) : this.f21128bq.getGroupId(c4934b.f21228c);
    }

    /* renamed from: a */
    private Drawable m2756a(ExpandableHListConnector.C4921b c4921b) {
        char c = 1;
        char c2 = 0;
        if (c4921b.f21094a.f21231f != 2) {
            Drawable drawable = this.f21136bz;
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(c4921b.f21094a.f21230e == c4921b.f21095b.f21088c ? f21105bF : f21100bA);
            }
            return drawable;
        }
        Drawable drawable2 = this.f21135by;
        if (drawable2 == null || !drawable2.isStateful()) {
            return drawable2;
        }
        boolean z = c4921b.f21095b == null || c4921b.f21095b.f21088c == c4921b.f21095b.f21087b;
        if (!c4921b.m2763b()) {
            c = 0;
        }
        if (z) {
            c2 = 2;
        }
        drawable2.setState(f21104bE[c | c2]);
        return drawable2;
    }

    /* renamed from: b */
    public static int m2753b(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    /* renamed from: c */
    public static int m2750c(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((f21109bj & j) >> 32);
    }

    /* renamed from: d */
    public static int m2749d(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    /* renamed from: i */
    public static long m2747i(int i, int i2) {
        return Long.MIN_VALUE | ((i & f21114bo) << 32) | (i2 & f21113bn);
    }

    /* renamed from: n */
    public static long m2742n(int i) {
        return (i & f21114bo) << 32;
    }

    /* renamed from: r */
    private boolean m2741r(int i) {
        return i < getHeaderViewsCount() || i >= this.f21061aP - getFooterViewsCount();
    }

    /* renamed from: s */
    private int m2740s(int i) {
        return i - getHeaderViewsCount();
    }

    /* renamed from: t */
    private int m2739t(int i) {
        return getHeaderViewsCount() + i;
    }

    /* renamed from: a */
    public int m2758a(long j) {
        C4934b m2650a = C4934b.m2650a(j);
        ExpandableHListConnector.C4921b m2778a = this.f21127bp.m2778a(m2650a);
        m2650a.m2649b();
        int i = m2778a.f21094a.f21230e;
        m2778a.m2765a();
        return m2739t(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // it.sephiroth.android.library.widget.HListView
    /* renamed from: a */
    public void mo2722a(Canvas canvas, Rect rect, int i) {
        int i2 = this.f21067aw + i;
        if (i2 >= 0) {
            ExpandableHListConnector.C4921b m2783a = this.f21127bp.m2783a(m2740s(i2));
            if (m2783a.f21094a.f21231f == 1 || (m2783a.m2763b() && m2783a.f21095b.f21088c != m2783a.f21095b.f21087b)) {
                Drawable drawable = this.f21116bG;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                m2783a.m2765a();
                return;
            }
            m2783a.m2765a();
        }
        super.mo2722a(canvas, rect, i2);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView
    /* renamed from: a */
    public boolean mo2757a(View view, int i, long j) {
        return m2741r(i) ? super.a(view, i, j) : m2748d(view, m2740s(i), j);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    /* renamed from: b */
    ContextMenu.ContextMenuInfo mo2752b(View view, int i, long j) {
        if (m2741r(i)) {
            return new AdapterView.ContextMenu$ContextMenuInfoC4913a(view, i, j);
        }
        ExpandableHListConnector.C4921b m2783a = this.f21127bp.m2783a(m2740s(i));
        C4934b c4934b = m2783a.f21094a;
        long m2755a = m2755a(c4934b);
        long m2654a = c4934b.m2654a();
        m2783a.m2765a();
        return new ContextMenu$ContextMenuInfoC4924a(view, m2654a, m2755a);
    }

    /* renamed from: b */
    public boolean m2754b(int i, int i2, boolean z) {
        C4934b m2652a = C4934b.m2652a(i, i2);
        ExpandableHListConnector.C4921b m2778a = this.f21127bp.m2778a(m2652a);
        if (m2778a == null) {
            if (!z) {
                return false;
            }
            m2746j(i);
            m2778a = this.f21127bp.m2778a(m2652a);
            if (m2778a == null) {
                throw new IllegalStateException("Could not find child");
            }
        }
        super.setSelection(m2739t(m2778a.f21094a.f21230e));
        m2652a.m2649b();
        m2778a.m2765a();
        return true;
    }

    /* renamed from: c */
    public boolean m2751c(int i, boolean z) {
        C4934b m2651a = C4934b.m2651a(2, i, -1, -1);
        ExpandableHListConnector.C4921b m2778a = this.f21127bp.m2778a(m2651a);
        m2651a.m2649b();
        boolean m2773b = this.f21127bp.m2773b(m2778a);
        if (this.f21124bO != null) {
            this.f21124bO.m2733a(i);
        }
        if (z) {
            int headerViewsCount = m2778a.f21094a.f21230e + getHeaderViewsCount();
            e(this.f21128bq.getChildrenCount(i) + headerViewsCount, headerViewsCount);
        }
        m2778a.m2765a();
        return m2773b;
    }

    /* renamed from: d */
    boolean m2748d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.C4921b m2783a = this.f21127bp.m2783a(i);
        long m2755a = m2755a(m2783a.f21094a);
        if (m2783a.f21094a.f21231f == 2) {
            if (this.f21125bP != null && this.f21125bP.m2735a(this, view, m2783a.f21094a.f21228c, m2755a)) {
                m2783a.m2765a();
                return true;
            }
            if (m2783a.m2763b()) {
                this.f21127bp.m2780a(m2783a);
                playSoundEffect(0);
                if (this.f21123bN != null) {
                    this.f21123bN.m2734a(m2783a.f21094a.f21228c);
                }
            } else {
                this.f21127bp.m2773b(m2783a);
                playSoundEffect(0);
                if (this.f21124bO != null) {
                    this.f21124bO.m2733a(m2783a.f21094a.f21228c);
                }
                int i2 = m2783a.f21094a.f21228c;
                int headerViewsCount = m2783a.f21094a.f21230e + getHeaderViewsCount();
                e(this.f21128bq.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.f21126bQ != null) {
            playSoundEffect(0);
            return this.f21126bQ.m2736a(this, view, m2783a.f21094a.f21228c, m2783a.f21094a.f21229d, m2755a);
        } else {
            z = false;
        }
        m2783a.m2765a();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f21136bz == null && this.f21135by == null) {
            return;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = ((this.f21061aP - getFooterViewsCount()) - headerViewsCount) - 1;
        int right = getRight();
        Rect rect = this.f21117bH;
        int childCount = getChildCount();
        int i = this.f21067aw - headerViewsCount;
        int i2 = -4;
        int i3 = 0;
        int i4 = i;
        while (i3 < childCount) {
            if (i4 >= 0) {
                if (i4 > footerViewsCount) {
                    return;
                }
                View childAt = getChildAt(i3);
                int left = childAt.getLeft();
                int right2 = childAt.getRight();
                if (right2 >= 0 && left <= right) {
                    ExpandableHListConnector.C4921b m2783a = this.f21127bp.m2783a(i4);
                    if (m2783a.f21094a.f21231f != i2) {
                        if (m2783a.f21094a.f21231f == 1) {
                            rect.top = childAt.getTop() + this.f21133bv;
                            rect.bottom = childAt.getBottom() + this.f21133bv;
                        } else {
                            rect.top = childAt.getTop() + this.f21129br;
                            rect.bottom = childAt.getBottom() + this.f21129br;
                        }
                        i2 = m2783a.f21094a.f21231f;
                    }
                    if (rect.top != rect.bottom) {
                        if (m2783a.f21094a.f21231f == 1) {
                            rect.left = this.f21134bw + left;
                            rect.right = this.f21134bw + right2;
                        } else {
                            rect.left = this.f21130bs + left;
                            rect.right = this.f21130bs + right2;
                        }
                        Drawable m2756a = m2756a(m2783a);
                        if (m2756a != null) {
                            if (m2783a.f21094a.f21231f == 1) {
                                Gravity.apply(this.f21132bu, this.f21121bL, this.f21122bM, rect, this.f21118bI);
                            } else {
                                Gravity.apply(this.f21131bt, this.f21119bJ, this.f21120bK, rect, this.f21118bI);
                            }
                            m2756a.setBounds(this.f21118bI);
                            m2756a.draw(canvas);
                        }
                    }
                    m2783a.m2765a();
                }
            }
            i3++;
            i4++;
        }
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.f21128bq;
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return f21113bn;
        }
        int m2750c = m2750c(selectedPosition);
        return m2753b(selectedPosition) == 0 ? this.f21128bq.getGroupId(m2750c) : this.f21128bq.getChildId(m2750c, m2749d(selectedPosition));
    }

    public long getSelectedPosition() {
        return m2744l(getSelectedItemPosition());
    }

    /* renamed from: j */
    public boolean m2746j(int i) {
        return m2751c(i, false);
    }

    /* renamed from: k */
    public boolean m2745k(int i) {
        boolean m2774b = this.f21127bp.m2774b(i);
        if (this.f21123bN != null) {
            this.f21123bN.m2734a(i);
        }
        return m2774b;
    }

    /* renamed from: l */
    public long m2744l(int i) {
        if (m2741r(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.C4921b m2783a = this.f21127bp.m2783a(m2740s(i));
        long m2654a = m2783a.f21094a.m2654a();
        m2783a.m2765a();
        return m2654a;
    }

    /* renamed from: m */
    public boolean m2743m(int i) {
        return this.f21127bp.m2771d(i);
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f21127bp == null || savedState.f21137a == null) {
            return;
        }
        this.f21127bp.m2777a(savedState.f21137a);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        m2760D();
        m2759E();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f21127bp != null ? this.f21127bp.m2775b() : null);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.f21128bq = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.f21127bp = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.f21127bp = null;
        }
        super.setAdapter((ListAdapter) this.f21127bp);
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public void setChildDivider(Drawable drawable) {
        this.f21116bG = drawable;
    }

    public void setChildIndicator(Drawable drawable) {
        this.f21136bz = drawable;
        m2759E();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.f21135by = drawable;
        m2760D();
    }

    public void setOnChildClickListener(AbstractC4925b abstractC4925b) {
        this.f21126bQ = abstractC4925b;
    }

    public void setOnGroupClickListener(AbstractC4926c abstractC4926c) {
        this.f21125bP = abstractC4926c;
    }

    public void setOnGroupCollapseListener(AbstractC4927d abstractC4927d) {
        this.f21123bN = abstractC4927d;
    }

    public void setOnGroupExpandListener(AbstractC4928e abstractC4928e) {
        this.f21124bO = abstractC4928e;
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    public void setOnItemClickListener(AdapterView.AbstractC4915c abstractC4915c) {
        super.setOnItemClickListener(abstractC4915c);
    }

    public void setSelectedGroup(int i) {
        C4934b m2653a = C4934b.m2653a(i);
        ExpandableHListConnector.C4921b m2778a = this.f21127bp.m2778a(m2653a);
        m2653a.m2649b();
        super.setSelection(m2739t(m2778a.f21094a.f21230e));
        m2778a.m2765a();
    }
}
