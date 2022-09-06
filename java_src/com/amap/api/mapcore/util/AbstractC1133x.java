package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.x */
/* loaded from: classes.dex */
public abstract class AbstractC1133x {

    /* renamed from: c */
    protected float f3557c;

    /* renamed from: d */
    protected float f3558d;

    /* renamed from: e */
    protected boolean f3559e;

    /* renamed from: f */
    protected boolean f3560f;

    /* renamed from: a */
    protected int f3555a = 0;

    /* renamed from: b */
    protected float f3556b = 1.0f;

    /* renamed from: g */
    protected boolean f3561g = false;

    /* renamed from: h */
    protected boolean f3562h = false;

    public AbstractC1133x() {
        this.f3559e = false;
        this.f3560f = false;
        this.f3559e = false;
        this.f3560f = false;
    }

    /* renamed from: a */
    static float m17447a(float f) {
        return f * f * 8.0f;
    }

    /* renamed from: a */
    public void mo17437a() {
        this.f3559e = false;
        this.f3560f = false;
        this.f3555a = 0;
        this.f3556b = 1.0f;
        this.f3559e = false;
        this.f3560f = false;
        this.f3561g = false;
        this.f3562h = false;
    }

    /* renamed from: a */
    public void m17446a(int i, float f) {
        this.f3555a = i;
        this.f3556b = f;
    }

    /* renamed from: b */
    public void m17444b(float f) {
        this.f3557c = f;
        switch (this.f3555a) {
            case 0:
                break;
            case 1:
                f = (float) Math.pow(f, this.f3556b * 2.0f);
                break;
            case 2:
                if (this.f3556b != 1.0f) {
                    f = (float) (1.0d - Math.pow(1.0f - f, this.f3556b * 2.0f));
                    break;
                } else {
                    f = 1.0f - ((1.0f - f) * (1.0f - f));
                    break;
                }
            case 3:
                f = (float) ((Math.cos((f + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d);
                break;
            case 4:
                float f2 = 1.1226f * f;
                if (f2 >= 0.3535f) {
                    if (f2 >= 0.7408f) {
                        if (f2 >= 0.9644f) {
                            f = m17447a(f2 - 1.0435f) + 0.95f;
                            break;
                        } else {
                            f = m17447a(f2 - 0.8526f) + 0.9f;
                            break;
                        }
                    } else {
                        f = m17447a(f2 - 0.54719f) + 0.7f;
                        break;
                    }
                } else {
                    f = m17447a(f2);
                    break;
                }
            case 5:
                float f3 = f - 1.0f;
                f = (((f3 * (2.0f + 1.0f)) + 2.0f) * f3 * f3) + 1.0f;
                break;
            case 6:
                if (f >= 0.0f) {
                    if (f >= 0.25f) {
                        if (f >= 0.5f) {
                            if (f >= 0.75f) {
                                if (f > 1.0f) {
                                    f = 0.0f;
                                    break;
                                } else {
                                    f = 4.0f - (4.0f * f);
                                    break;
                                }
                            } else {
                                f = (4.0f * f) - 2.0f;
                                break;
                            }
                        } else {
                            f = 2.0f - (4.0f * f);
                            break;
                        }
                    } else {
                        f *= 4.0f;
                        break;
                    }
                } else {
                    f = 0.0f;
                    break;
                }
            default:
                f = 0.0f;
                break;
        }
        this.f3558d = f;
    }

    /* renamed from: b */
    public boolean m17445b() {
        if (!this.f3559e) {
            mo17434d();
        }
        return this.f3559e && this.f3560f;
    }

    /* renamed from: c */
    public float m17443c() {
        return this.f3558d;
    }

    /* renamed from: d */
    public abstract void mo17434d();
}
