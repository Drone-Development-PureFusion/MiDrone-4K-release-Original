package it.sephiroth.android.library.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* renamed from: it.sephiroth.android.library.widget.b */
/* loaded from: classes2.dex */
class C4934b {

    /* renamed from: a */
    public static final int f21224a = 1;

    /* renamed from: b */
    public static final int f21225b = 2;

    /* renamed from: g */
    private static final int f21226g = 5;

    /* renamed from: h */
    private static ArrayList<C4934b> f21227h = new ArrayList<>(5);

    /* renamed from: c */
    public int f21228c;

    /* renamed from: d */
    public int f21229d;

    /* renamed from: e */
    int f21230e;

    /* renamed from: f */
    public int f21231f;

    private C4934b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C4934b m2653a(int i) {
        return m2651a(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C4934b m2652a(int i, int i2) {
        return m2651a(1, i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C4934b m2651a(int i, int i2, int i3, int i4) {
        C4934b m2647d = m2647d();
        m2647d.f21231f = i;
        m2647d.f21228c = i2;
        m2647d.f21229d = i3;
        m2647d.f21230e = i4;
        return m2647d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C4934b m2650a(long j) {
        if (j == 4294967295L) {
            return null;
        }
        C4934b m2647d = m2647d();
        m2647d.f21228c = ExpandableListView.getPackedPositionGroup(j);
        if (ExpandableListView.getPackedPositionType(j) != 1) {
            m2647d.f21231f = 2;
            return m2647d;
        }
        m2647d.f21231f = 1;
        m2647d.f21229d = ExpandableListView.getPackedPositionChild(j);
        return m2647d;
    }

    /* renamed from: c */
    private void m2648c() {
        this.f21228c = 0;
        this.f21229d = 0;
        this.f21230e = 0;
        this.f21231f = 0;
    }

    /* renamed from: d */
    private static C4934b m2647d() {
        C4934b c4934b;
        synchronized (f21227h) {
            if (f21227h.size() > 0) {
                c4934b = f21227h.remove(0);
                c4934b.m2648c();
            } else {
                c4934b = new C4934b();
            }
        }
        return c4934b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public long m2654a() {
        return this.f21231f == 1 ? ExpandableListView.getPackedPositionForChild(this.f21228c, this.f21229d) : ExpandableListView.getPackedPositionForGroup(this.f21228c);
    }

    /* renamed from: b */
    public void m2649b() {
        synchronized (f21227h) {
            if (f21227h.size() < 5) {
                f21227h.add(this);
            }
        }
    }
}
