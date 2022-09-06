package com.fimi.soul.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.android.volley.C1337o;
import com.android.volley.C1384u;
import com.android.volley.toolbox.C1366k;
import com.android.volley.toolbox.C1383t;
import com.fimi.kernel.utils.C2266k;
import com.fimi.kernel.utils.C2269n;
/* renamed from: com.fimi.soul.utils.au */
/* loaded from: classes.dex */
public class C3665au {

    /* renamed from: a */
    private Context f14859a;

    /* renamed from: b */
    private int f14860b;

    /* renamed from: c */
    private int f14861c;

    /* renamed from: d */
    private int f14862d;

    /* renamed from: e */
    private Drawable f14863e;

    /* renamed from: f */
    private View f14864f;

    /* renamed from: g */
    private Drawable f14865g;

    /* renamed from: h */
    private Drawable f14866h;

    /* renamed from: i */
    private C1337o f14867i;

    /* renamed from: j */
    private C1366k f14868j;

    /* renamed from: k */
    private AbstractC3669b f14869k = null;

    /* renamed from: l */
    private AbstractC3668a f14870l = null;

    /* renamed from: com.fimi.soul.utils.au$a */
    /* loaded from: classes.dex */
    public interface AbstractC3668a {
        /* renamed from: a */
        void m7530a();
    }

    /* renamed from: com.fimi.soul.utils.au$b */
    /* loaded from: classes.dex */
    public interface AbstractC3669b {
        /* renamed from: a */
        void m7529a(Bitmap bitmap);
    }

    public C3665au(Context context) {
        this.f14859a = null;
        this.f14868j = null;
        this.f14859a = context;
        this.f14867i = C1383t.m16574a(context);
        this.f14868j = new C1366k(this.f14867i, C3663at.m7561a());
    }

    /* renamed from: a */
    public static C3665au m7552a(Context context) {
        return new C3665au(context);
    }

    /* renamed from: a */
    public int m7554a() {
        return this.f14860b;
    }

    /* renamed from: a */
    public void m7553a(int i) {
        this.f14863e = this.f14859a.getResources().getDrawable(i);
    }

    /* renamed from: a */
    public void m7551a(View view) {
        this.f14864f = view;
    }

    /* renamed from: a */
    public void m7550a(final ImageView imageView, String str) {
        if (C2269n.m12889b(str)) {
            if (this.f14866h != null) {
                if (this.f14864f != null) {
                    this.f14864f.setVisibility(4);
                }
                imageView.setVisibility(0);
                imageView.setImageDrawable(this.f14866h);
            }
            if (this.f14870l == null) {
                return;
            }
            this.f14870l.m7530a();
            return;
        }
        if (this.f14864f != null) {
            this.f14864f.setVisibility(0);
            imageView.setVisibility(4);
        } else if (this.f14863e != null) {
            imageView.setImageDrawable(this.f14863e);
            imageView.setVisibility(0);
        }
        imageView.setTag(str);
        this.f14868j.m16613a(str, new C1366k.AbstractC1374d() { // from class: com.fimi.soul.utils.au.1
            @Override // com.android.volley.toolbox.C1366k.AbstractC1374d
            /* renamed from: a */
            public void mo7532a(C1366k.C1373c c1373c, boolean z) {
                Bitmap m16597b = c1373c.m16597b();
                if (C3665au.this.f14869k != null) {
                    C3665au.this.f14869k.m7529a(m16597b);
                }
                if (C3665au.this.f14870l != null) {
                    C3665au.this.f14870l.m7530a();
                }
                C2266k.m12947a(C3665au.class, "获取到图片：" + m16597b);
                if (!c1373c.m16596c().equals(imageView.getTag())) {
                    return;
                }
                if (m16597b != null) {
                    imageView.setImageBitmap(m16597b);
                } else if (C3665au.this.f14866h != null) {
                    imageView.setImageDrawable(C3665au.this.f14866h);
                }
                if (C3665au.this.f14864f != null) {
                    C3665au.this.f14864f.setVisibility(4);
                }
                imageView.setVisibility(0);
            }

            @Override // com.android.volley.C1341p.AbstractC1342a
            /* renamed from: a */
            public void mo7531a(C1384u c1384u) {
                if (C3665au.this.f14865g != null) {
                    imageView.setImageDrawable(C3665au.this.f14865g);
                }
                if (C3665au.this.f14870l != null) {
                    C3665au.this.f14870l.m7530a();
                }
                imageView.setVisibility(0);
                if (C3665au.this.f14864f != null) {
                    C3665au.this.f14864f.setVisibility(4);
                }
            }
        }, this.f14860b, this.f14861c);
    }

    /* renamed from: a */
    public void m7549a(AbstractC3668a abstractC3668a) {
        this.f14870l = abstractC3668a;
    }

    /* renamed from: a */
    public void m7548a(AbstractC3669b abstractC3669b) {
        this.f14869k = abstractC3669b;
    }

    /* renamed from: a */
    public void m7546a(String str) {
        if (C2269n.m12889b(str)) {
            return;
        }
        this.f14868j.m16613a(str, new C1366k.AbstractC1374d() { // from class: com.fimi.soul.utils.au.2
            @Override // com.android.volley.toolbox.C1366k.AbstractC1374d
            /* renamed from: a */
            public void mo7532a(C1366k.C1373c c1373c, boolean z) {
                Bitmap m16597b = c1373c.m16597b();
                if (C3665au.this.f14869k != null) {
                    C3665au.this.f14869k.m7529a(m16597b);
                }
                C2266k.m12947a(C3665au.class, "获取到图片：" + m16597b);
            }

            @Override // com.android.volley.C1341p.AbstractC1342a
            /* renamed from: a */
            public void mo7531a(C1384u c1384u) {
            }
        }, this.f14860b, this.f14861c);
    }

    /* renamed from: b */
    public int m7545b() {
        return this.f14861c;
    }

    /* renamed from: b */
    public void m7544b(int i) {
        this.f14865g = this.f14859a.getResources().getDrawable(i);
    }

    /* renamed from: c */
    public int m7542c() {
        return this.f14862d;
    }

    /* renamed from: c */
    public void m7541c(int i) {
        this.f14866h = this.f14859a.getResources().getDrawable(i);
    }

    /* renamed from: d */
    public AbstractC3669b m7539d() {
        return this.f14869k;
    }

    /* renamed from: d */
    public void m7538d(int i) {
        this.f14860b = i;
    }

    /* renamed from: e */
    public AbstractC3668a m7536e() {
        return this.f14870l;
    }

    /* renamed from: e */
    public void m7535e(int i) {
        this.f14861c = i;
    }

    /* renamed from: f */
    public void m7533f(int i) {
        this.f14862d = i;
    }
}
