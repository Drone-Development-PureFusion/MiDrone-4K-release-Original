package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.C1384u;
import com.android.volley.toolbox.C1366k;
/* loaded from: classes.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: a */
    private String f4622a;

    /* renamed from: b */
    private int f4623b;

    /* renamed from: c */
    private int f4624c;

    /* renamed from: d */
    private C1366k f4625d;

    /* renamed from: e */
    private C1366k.C1373c f4626e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.volley.toolbox.NetworkImageView$1 */
    /* loaded from: classes.dex */
    public class C13481 implements C1366k.AbstractC1374d {

        /* renamed from: a */
        final /* synthetic */ boolean f4627a;

        C13481(boolean z) {
            this.f4627a = z;
        }

        @Override // com.android.volley.toolbox.C1366k.AbstractC1374d
        /* renamed from: a */
        public void mo7532a(final C1366k.C1373c c1373c, boolean z) {
            if (z && this.f4627a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.android.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C13481.this.mo7532a(c1373c, false);
                    }
                });
            } else if (c1373c.m16597b() != null) {
                NetworkImageView.this.setImageBitmap(c1373c.m16597b());
            } else if (NetworkImageView.this.f4623b == 0) {
            } else {
                NetworkImageView.this.setImageResource(NetworkImageView.this.f4623b);
            }
        }

        @Override // com.android.volley.C1341p.AbstractC1342a
        /* renamed from: a */
        public void mo7531a(C1384u c1384u) {
            if (NetworkImageView.this.f4624c != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.f4624c);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m16680a() {
        if (this.f4623b != 0) {
            setImageResource(this.f4623b);
        } else {
            setImageBitmap(null);
        }
    }

    /* renamed from: a */
    public void m16678a(String str, C1366k c1366k) {
        this.f4622a = str;
        this.f4625d = c1366k;
        m16677a(false);
    }

    /* renamed from: a */
    void m16677a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        if (getLayoutParams() != null) {
            z3 = getLayoutParams().width == -2;
            z2 = getLayoutParams().height == -2;
        } else {
            z2 = false;
            z3 = false;
        }
        if (!z3 || !z2) {
            z4 = false;
        }
        if (width == 0 && height == 0 && !z4) {
            return;
        }
        if (TextUtils.isEmpty(this.f4622a)) {
            if (this.f4626e != null) {
                this.f4626e.m16600a();
                this.f4626e = null;
            }
            m16680a();
            return;
        }
        if (this.f4626e != null && this.f4626e.m16596c() != null) {
            if (this.f4626e.m16596c().equals(this.f4622a)) {
                return;
            }
            this.f4626e.m16600a();
            m16680a();
        }
        int i = z3 ? 0 : width;
        if (z2) {
            height = 0;
        }
        this.f4626e = this.f4625d.m16612a(this.f4622a, new C13481(z), i, height, scaleType);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public String getImageURL() {
        return this.f4622a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.f4626e != null) {
            this.f4626e.m16600a();
            setImageBitmap(null);
            this.f4626e = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m16677a(true);
    }

    public void setDefaultImageResId(int i) {
        this.f4623b = i;
    }

    public void setErrorImageResId(int i) {
        this.f4624c = i;
    }
}
