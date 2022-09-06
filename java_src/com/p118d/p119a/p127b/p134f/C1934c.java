package com.p118d.p119a.p127b.p134f;

import android.widget.AbsListView;
import com.p118d.p119a.p127b.C1914d;
/* renamed from: com.d.a.b.f.c */
/* loaded from: classes.dex */
public class C1934c implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private C1914d f6873a;

    /* renamed from: b */
    private final boolean f6874b;

    /* renamed from: c */
    private final boolean f6875c;

    /* renamed from: d */
    private final AbsListView.OnScrollListener f6876d;

    public C1934c(C1914d c1914d, boolean z, boolean z2) {
        this(c1914d, z, z2, null);
    }

    public C1934c(C1914d c1914d, boolean z, boolean z2, AbsListView.OnScrollListener onScrollListener) {
        this.f6873a = c1914d;
        this.f6874b = z;
        this.f6875c = z2;
        this.f6876d = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f6876d != null) {
            this.f6876d.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
                this.f6873a.m13999j();
                break;
            case 1:
                if (this.f6874b) {
                    this.f6873a.m14000i();
                    break;
                }
                break;
            case 2:
                if (this.f6875c) {
                    this.f6873a.m14000i();
                    break;
                }
                break;
        }
        if (this.f6876d != null) {
            this.f6876d.onScrollStateChanged(absListView, i);
        }
    }
}
