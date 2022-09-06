package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
/* loaded from: classes.dex */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {

    /* renamed from: aD */
    static final int f21039aD = 0;

    /* renamed from: aE */
    static final int f21040aE = 1;

    /* renamed from: aF */
    static final int f21041aF = 100;

    /* renamed from: aS */
    public static final int f21042aS = -1;

    /* renamed from: aT */
    public static final long f21043aT = Long.MIN_VALUE;

    /* renamed from: as */
    public static final String f21044as = "AdapterView";

    /* renamed from: at */
    public static final boolean f21045at = false;

    /* renamed from: au */
    public static final int f21046au = -1;

    /* renamed from: av */
    public static final int f21047av = -2;

    /* renamed from: a */
    private int f21048a;

    /* renamed from: aA */
    protected long f21049aA;

    /* renamed from: aC */
    int f21051aC;

    /* renamed from: aH */
    AbstractC4917e f21053aH;

    /* renamed from: aI */
    AbstractC4915c f21054aI;

    /* renamed from: aJ */
    AbstractC4916d f21055aJ;

    /* renamed from: aK */
    public boolean f21056aK;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: aP */
    protected int f21061aP;

    /* renamed from: aQ */
    protected int f21062aQ;

    /* renamed from: aR */
    AccessibilityManager f21063aR;

    /* renamed from: ax */
    protected int f21068ax;

    /* renamed from: ay */
    protected int f21069ay;

    /* renamed from: b */
    private View f21071b;

    /* renamed from: c */
    private boolean f21072c;

    /* renamed from: d */
    private boolean f21073d;

    /* renamed from: e */
    private AdapterView<T>.RunnableC4918f f21074e;
    @ViewDebug.ExportedProperty(category = "scrolling")

    /* renamed from: aw */
    protected int f21067aw = 0;

    /* renamed from: az */
    protected long f21070az = Long.MIN_VALUE;

    /* renamed from: aB */
    protected boolean f21050aB = false;

    /* renamed from: aG */
    protected boolean f21052aG = false;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: aL */
    protected int f21057aL = -1;

    /* renamed from: aM */
    protected long f21058aM = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: aN */
    protected int f21059aN = -1;

    /* renamed from: aO */
    protected long f21060aO = Long.MIN_VALUE;

    /* renamed from: aU */
    protected int f21064aU = -1;

    /* renamed from: aV */
    protected long f21065aV = Long.MIN_VALUE;

    /* renamed from: aW */
    protected boolean f21066aW = false;

    /* renamed from: it.sephiroth.android.library.widget.AdapterView$a */
    /* loaded from: classes2.dex */
    public static class ContextMenu$ContextMenuInfoC4913a implements ContextMenu.ContextMenuInfo {

        /* renamed from: a */
        public View f21075a;

        /* renamed from: b */
        public int f21076b;

        /* renamed from: c */
        public long f21077c;

        public ContextMenu$ContextMenuInfoC4913a(View view, int i, long j) {
            this.f21075a = view;
            this.f21076b = i;
            this.f21077c = j;
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.AdapterView$b */
    /* loaded from: classes2.dex */
    class C4914b extends DataSetObserver {

        /* renamed from: a */
        private Parcelable f21078a = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4914b() {
        }

        /* renamed from: a */
        public void mo2789a() {
            this.f21078a = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AdapterView.this.f21056aK = true;
            AdapterView.this.f21062aQ = AdapterView.this.f21061aP;
            AdapterView.this.f21061aP = AdapterView.this.getAdapter().getCount();
            if (!AdapterView.this.getAdapter().hasStableIds() || this.f21078a == null || AdapterView.this.f21062aQ != 0 || AdapterView.this.f21061aP <= 0) {
                AdapterView.this.m2807A();
            } else {
                AdapterView.this.onRestoreInstanceState(this.f21078a);
                this.f21078a = null;
            }
            AdapterView.this.m2793w();
            AdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AdapterView.this.f21056aK = true;
            if (AdapterView.this.getAdapter().hasStableIds()) {
                this.f21078a = AdapterView.this.onSaveInstanceState();
            }
            AdapterView.this.f21062aQ = AdapterView.this.f21061aP;
            AdapterView.this.f21061aP = 0;
            AdapterView.this.f21059aN = -1;
            AdapterView.this.f21060aO = Long.MIN_VALUE;
            AdapterView.this.f21057aL = -1;
            AdapterView.this.f21058aM = Long.MIN_VALUE;
            AdapterView.this.f21050aB = false;
            AdapterView.this.m2793w();
            AdapterView.this.requestLayout();
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.AdapterView$c */
    /* loaded from: classes2.dex */
    public interface AbstractC4915c {
        /* renamed from: a */
        void m2788a(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* renamed from: it.sephiroth.android.library.widget.AdapterView$d */
    /* loaded from: classes2.dex */
    public interface AbstractC4916d {
        /* renamed from: a */
        boolean m2787a(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* renamed from: it.sephiroth.android.library.widget.AdapterView$e */
    /* loaded from: classes2.dex */
    public interface AbstractC4917e {
        /* renamed from: a */
        void m2786a(AdapterView<?> adapterView);

        /* renamed from: a */
        void m2785a(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: it.sephiroth.android.library.widget.AdapterView$f */
    /* loaded from: classes2.dex */
    public class RunnableC4918f implements Runnable {
        private RunnableC4918f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AdapterView.this.f21056aK) {
                AdapterView.this.m2806a();
                AdapterView.this.m2801b();
            } else if (AdapterView.this.getAdapter() == null) {
            } else {
                AdapterView.this.post(this);
            }
        }
    }

    public AdapterView(Context context) {
        super(context);
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(16)
    public AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (!isInEditMode()) {
            this.f21063aR = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2806a() {
        if (this.f21053aH == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition < 0) {
            this.f21053aH.m2786a(this);
            return;
        }
        this.f21053aH.m2785a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
    }

    @SuppressLint({"WrongCall"})
    /* renamed from: a */
    private void m2802a(boolean z) {
        if (m2794v()) {
            z = false;
        }
        if (!z) {
            if (this.f21071b != null) {
                this.f21071b.setVisibility(8);
            }
            setVisibility(0);
            return;
        }
        if (this.f21071b != null) {
            this.f21071b.setVisibility(0);
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        if (!this.f21056aK) {
            return;
        }
        onLayout(false, getLeft(), getTop(), getRight(), getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2801b() {
        if (this.f21063aR.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    /* renamed from: c */
    private boolean m2799c() {
        int count;
        T adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        return getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count + (-1);
    }

    /* renamed from: A */
    public void m2807A() {
        if (getChildCount() > 0) {
            this.f21050aB = true;
            this.f21049aA = this.f21048a;
            if (this.f21059aN >= 0) {
                View childAt = getChildAt(this.f21059aN - this.f21067aw);
                this.f21070az = this.f21058aM;
                this.f21069ay = this.f21057aL;
                if (childAt != null) {
                    this.f21068ax = childAt.getLeft();
                }
                this.f21051aC = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.f21067aw < 0 || this.f21067aw >= adapter.getCount()) {
                this.f21070az = -1L;
            } else {
                this.f21070az = adapter.getItemId(this.f21067aw);
            }
            this.f21069ay = this.f21067aw;
            if (childAt2 != null) {
                this.f21068ax = childAt2.getLeft();
            }
            this.f21051aC = 1;
        }
    }

    /* renamed from: a */
    public int m2805a(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException e) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i + this.f21067aw;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo2757a(View view, int i, long j) {
        if (this.f21054aI != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.f21054aI.m2788a(this, view, i, j);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public int mo2710b(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.f21061aP > 0;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.f21061aP;
    }

    public View getEmptyView() {
        return this.f21071b;
    }

    public int getFirstVisiblePosition() {
        return this.f21067aw;
    }

    public int getLastVisiblePosition() {
        return (this.f21067aw + getChildCount()) - 1;
    }

    public final AbstractC4915c getOnItemClickListener() {
        return this.f21054aI;
    }

    public final AbstractC4916d getOnItemLongClickListener() {
        return this.f21055aJ;
    }

    public final AbstractC4917e getOnItemSelectedListener() {
        return this.f21053aH;
    }

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.f21058aM;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.f21057aL;
    }

    public abstract View getSelectedView();

    /* renamed from: h */
    public Object m2797h(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return null;
        }
        return adapter.getItem(i);
    }

    /* renamed from: i */
    public long m2796i(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f21074e);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AdapterView.class.getName());
        accessibilityEvent.setScrollable(m2799c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterView.class.getName());
        accessibilityNodeInfo.setScrollable(m2799c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f21048a = getWidth();
    }

    @Override // android.view.ViewGroup
    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(obtain);
            view.dispatchPopulateAccessibilityEvent(obtain);
            accessibilityEvent.appendRecord(obtain);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public abstract void setAdapter(T t);

    @TargetApi(16)
    public void setEmptyView(View view) {
        boolean z = true;
        this.f21071b = view;
        if (Build.VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        T adapter = getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            z = false;
        }
        m2802a(z);
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2 = true;
        T adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f21072c = z;
        if (!z) {
            this.f21073d = false;
        }
        if (!z || (z3 && !m2794v())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        T adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f21073d = z;
        if (z) {
            this.f21072c = true;
        }
        if (!z || (z3 && !m2794v())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.f21057aL = i;
        this.f21058aM = m2796i(i);
        if (!this.f21050aB || this.f21051aC != 0 || i < 0) {
            return;
        }
        this.f21069ay = i;
        this.f21070az = this.f21058aM;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(AbstractC4915c abstractC4915c) {
        this.f21054aI = abstractC4915c;
    }

    public void setOnItemLongClickListener(AbstractC4916d abstractC4916d) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f21055aJ = abstractC4916d;
    }

    public void setOnItemSelectedListener(AbstractC4917e abstractC4917e) {
        this.f21053aH = abstractC4917e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.f21059aN = i;
        this.f21060aO = m2796i(i);
    }

    public abstract void setSelection(int i);

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void mo2795u() {
        boolean z;
        boolean z2;
        int i = this.f21061aP;
        if (i > 0) {
            if (this.f21050aB) {
                this.f21050aB = false;
                int m2790z = m2790z();
                if (m2790z >= 0 && mo2710b(m2790z, true) == m2790z) {
                    setNextSelectedPositionInt(m2790z);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int mo2710b = mo2710b(selectedItemPosition, true);
                        int mo2710b2 = mo2710b < 0 ? mo2710b(selectedItemPosition, false) : mo2710b;
                        if (mo2710b2 >= 0) {
                            setNextSelectedPositionInt(mo2710b2);
                            m2791y();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (!z2) {
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.f21059aN = -1;
            this.f21060aO = Long.MIN_VALUE;
            this.f21057aL = -1;
            this.f21058aM = Long.MIN_VALUE;
            this.f21050aB = false;
            m2791y();
        }
    }

    /* renamed from: v */
    boolean m2794v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public void m2793w() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || m2794v();
        super.setFocusableInTouchMode(z2 && this.f21073d);
        super.setFocusable(z2 && this.f21072c);
        if (this.f21071b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            m2802a(z);
        }
    }

    /* renamed from: x */
    void m2792x() {
        if (this.f21053aH != null || this.f21063aR.isEnabled()) {
            if (!this.f21052aG && !this.f21066aW) {
                m2806a();
                m2801b();
                return;
            }
            if (this.f21074e == null) {
                this.f21074e = new RunnableC4918f();
            }
            post(this.f21074e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: y */
    public void m2791y() {
        if (this.f21059aN == this.f21064aU && this.f21060aO == this.f21065aV) {
            return;
        }
        m2792x();
        this.f21064aU = this.f21059aN;
        this.f21065aV = this.f21060aO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public int m2790z() {
        int i = this.f21061aP;
        if (i == 0) {
            return -1;
        }
        long j = this.f21070az;
        int i2 = this.f21069ay;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i4) == j) {
                return i4;
            }
            boolean z2 = min == i + (-1);
            boolean z3 = i3 == 0;
            if (z2 && z3) {
                break;
            } else if (z3 || (z && !z2)) {
                min++;
                z = false;
                i4 = min;
            } else if (z2 || (!z && !z3)) {
                i3--;
                z = true;
                i4 = i3;
            }
        }
        return -1;
    }
}
