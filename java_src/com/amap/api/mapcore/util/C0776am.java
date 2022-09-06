package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* renamed from: com.amap.api.mapcore.util.am */
/* loaded from: classes.dex */
public class C0776am {

    /* renamed from: a */
    private final Context f2072a;

    /* renamed from: b */
    private final AbstractC0777a f2073b;

    /* renamed from: c */
    private boolean f2074c;

    /* renamed from: d */
    private MotionEvent f2075d;

    /* renamed from: e */
    private MotionEvent f2076e;

    /* renamed from: f */
    private float f2077f;

    /* renamed from: g */
    private float f2078g;

    /* renamed from: h */
    private float f2079h;

    /* renamed from: i */
    private float f2080i;

    /* renamed from: j */
    private float f2081j;

    /* renamed from: k */
    private float f2082k;

    /* renamed from: l */
    private float f2083l;

    /* renamed from: m */
    private float f2084m;

    /* renamed from: n */
    private float f2085n;

    /* renamed from: o */
    private float f2086o;

    /* renamed from: p */
    private float f2087p;

    /* renamed from: q */
    private long f2088q;

    /* renamed from: r */
    private final float f2089r;

    /* renamed from: s */
    private float f2090s;

    /* renamed from: t */
    private float f2091t;

    /* renamed from: u */
    private boolean f2092u;

    /* renamed from: v */
    private boolean f2093v;

    /* renamed from: w */
    private int f2094w;

    /* renamed from: x */
    private int f2095x;

    /* renamed from: y */
    private boolean f2096y;

    /* renamed from: com.amap.api.mapcore.util.am$a */
    /* loaded from: classes.dex */
    public interface AbstractC0777a {
        /* renamed from: a */
        boolean mo19055a(C0776am c0776am);

        /* renamed from: b */
        boolean mo19054b(C0776am c0776am);

        /* renamed from: c */
        void mo19053c(C0776am c0776am);
    }

    public C0776am(Context context, AbstractC0777a abstractC0777a) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2072a = context;
        this.f2073b = abstractC0777a;
        this.f2089r = viewConfiguration.getScaledEdgeSlop();
    }

    /* renamed from: a */
    private static float m19069a(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        return i == 0 ? motionEvent.getRawX() : (motionEvent.getRawX() - motionEvent.getX()) + motionEvent.getX(i);
    }

    /* renamed from: a */
    private int m19068a(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != i2 && i3 != findPointerIndex) {
                float f = this.f2089r;
                float f2 = this.f2090s;
                float f3 = this.f2091t;
                float m19069a = m19069a(motionEvent, i3);
                float m19065b = m19065b(motionEvent, i3);
                if (m19069a >= f && m19065b >= f && m19069a <= f2 && m19065b <= f3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    /* renamed from: b */
    private static float m19065b(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        return i == 0 ? motionEvent.getRawY() : (motionEvent.getRawY() - motionEvent.getY()) + motionEvent.getY(i);
    }

    /* renamed from: b */
    private void m19066b(MotionEvent motionEvent) {
        if (this.f2076e != null) {
            this.f2076e.recycle();
        }
        this.f2076e = MotionEvent.obtain(motionEvent);
        this.f2083l = -1.0f;
        this.f2084m = -1.0f;
        this.f2085n = -1.0f;
        MotionEvent motionEvent2 = this.f2075d;
        int findPointerIndex = motionEvent2.findPointerIndex(this.f2094w);
        int findPointerIndex2 = motionEvent2.findPointerIndex(this.f2095x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f2094w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f2095x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.f2093v = true;
            if (!this.f2074c) {
                return;
            }
            this.f2073b.mo19053c(this);
            return;
        }
        float x = motionEvent2.getX(findPointerIndex);
        float y = motionEvent2.getY(findPointerIndex);
        float x2 = motionEvent2.getX(findPointerIndex2);
        float y2 = motionEvent2.getY(findPointerIndex2);
        float x3 = motionEvent.getX(findPointerIndex3);
        float y3 = motionEvent.getY(findPointerIndex3);
        float f = x2 - x;
        float f2 = y2 - y;
        float x4 = motionEvent.getX(findPointerIndex4) - x3;
        float y4 = motionEvent.getY(findPointerIndex4) - y3;
        this.f2079h = f;
        this.f2080i = f2;
        this.f2081j = x4;
        this.f2082k = y4;
        this.f2077f = (x4 * 0.5f) + x3;
        this.f2078g = (y4 * 0.5f) + y3;
        this.f2088q = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.f2086o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.f2087p = motionEvent2.getPressure(findPointerIndex2) + motionEvent2.getPressure(findPointerIndex);
    }

    /* renamed from: j */
    private void m19057j() {
        if (this.f2075d != null) {
            this.f2075d.recycle();
            this.f2075d = null;
        }
        if (this.f2076e != null) {
            this.f2076e.recycle();
            this.f2076e = null;
        }
        this.f2092u = false;
        this.f2074c = false;
        this.f2094w = -1;
        this.f2095x = -1;
        this.f2093v = false;
    }

    /* renamed from: a */
    public float m19071a() {
        return this.f2077f;
    }

    /* renamed from: a */
    public boolean m19070a(MotionEvent motionEvent) {
        int m19068a;
        boolean z;
        int i;
        int m19068a2;
        int i2;
        int i3;
        int i4 = -1;
        boolean z2 = true;
        boolean z3 = false;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            m19057j();
        }
        if (!this.f2093v) {
            if (this.f2074c) {
                switch (action) {
                    case 1:
                        m19057j();
                        break;
                    case 2:
                        m19066b(motionEvent);
                        if (this.f2086o / this.f2087p > 0.67f && this.f2073b.mo19055a(this)) {
                            this.f2075d.recycle();
                            this.f2075d = MotionEvent.obtain(motionEvent);
                            break;
                        }
                        break;
                    case 3:
                        this.f2073b.mo19053c(this);
                        m19057j();
                        break;
                    case 5:
                        this.f2073b.mo19053c(this);
                        int i5 = this.f2094w;
                        int i6 = this.f2095x;
                        m19057j();
                        this.f2075d = MotionEvent.obtain(motionEvent);
                        if (!this.f2096y) {
                            i5 = i6;
                        }
                        this.f2094w = i5;
                        if (Build.VERSION.SDK_INT >= 8) {
                            this.f2095x = motionEvent.getPointerId(motionEvent.getActionIndex());
                        } else {
                            this.f2095x = motionEvent.getPointerId(1);
                        }
                        this.f2096y = false;
                        int findPointerIndex = motionEvent.findPointerIndex(this.f2094w);
                        if (findPointerIndex < 0 || this.f2094w == this.f2095x) {
                            if (this.f2094w != this.f2095x) {
                                i4 = this.f2095x;
                            }
                            this.f2094w = motionEvent.getPointerId(m19068a(motionEvent, i4, findPointerIndex));
                        }
                        m19066b(motionEvent);
                        this.f2074c = this.f2073b.mo19054b(this);
                        break;
                    case 6:
                        int pointerCount = motionEvent.getPointerCount();
                        int actionIndex = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                        int pointerId = motionEvent.getPointerId(actionIndex);
                        if (pointerCount > 2) {
                            if (pointerId == this.f2094w) {
                                int m19068a3 = m19068a(motionEvent, this.f2095x, actionIndex);
                                if (m19068a3 >= 0) {
                                    this.f2073b.mo19053c(this);
                                    this.f2094w = motionEvent.getPointerId(m19068a3);
                                    this.f2096y = true;
                                    this.f2075d = MotionEvent.obtain(motionEvent);
                                    m19066b(motionEvent);
                                    this.f2074c = this.f2073b.mo19054b(this);
                                } else {
                                    z3 = true;
                                }
                            } else if (pointerId == this.f2095x) {
                                int m19068a4 = m19068a(motionEvent, this.f2094w, actionIndex);
                                if (m19068a4 >= 0) {
                                    this.f2073b.mo19053c(this);
                                    this.f2095x = motionEvent.getPointerId(m19068a4);
                                    this.f2096y = false;
                                    this.f2075d = MotionEvent.obtain(motionEvent);
                                    m19066b(motionEvent);
                                    this.f2074c = this.f2073b.mo19054b(this);
                                } else {
                                    z3 = true;
                                }
                            }
                            this.f2075d.recycle();
                            this.f2075d = MotionEvent.obtain(motionEvent);
                            m19066b(motionEvent);
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            m19066b(motionEvent);
                            int i7 = pointerId == this.f2094w ? this.f2095x : this.f2094w;
                            int findPointerIndex2 = motionEvent.findPointerIndex(i7);
                            this.f2077f = motionEvent.getX(findPointerIndex2);
                            this.f2078g = motionEvent.getY(findPointerIndex2);
                            this.f2073b.mo19053c(this);
                            m19057j();
                            this.f2094w = i7;
                            this.f2096y = true;
                            break;
                        }
                        break;
                }
            } else {
                switch (action) {
                    case 0:
                        this.f2094w = motionEvent.getPointerId(0);
                        this.f2096y = true;
                        break;
                    case 1:
                        m19057j();
                        break;
                    case 2:
                        if (this.f2092u) {
                            float f = this.f2089r;
                            float f2 = this.f2090s;
                            float f3 = this.f2091t;
                            int findPointerIndex3 = motionEvent.findPointerIndex(this.f2094w);
                            int findPointerIndex4 = motionEvent.findPointerIndex(this.f2095x);
                            float m19069a = m19069a(motionEvent, findPointerIndex3);
                            float m19065b = m19065b(motionEvent, findPointerIndex3);
                            float m19069a2 = m19069a(motionEvent, findPointerIndex4);
                            float m19065b2 = m19065b(motionEvent, findPointerIndex4);
                            boolean z4 = m19069a < f || m19065b < f || m19069a > f2 || m19065b > f3;
                            boolean z5 = m19069a2 < f || m19065b2 < f || m19069a2 > f2 || m19065b2 > f3;
                            if (!z4 || (m19068a2 = m19068a(motionEvent, this.f2095x, findPointerIndex3)) < 0) {
                                z = z4;
                            } else {
                                this.f2094w = motionEvent.getPointerId(m19068a2);
                                m19069a(motionEvent, m19068a2);
                                m19065b(motionEvent, m19068a2);
                                findPointerIndex3 = m19068a2;
                                z = false;
                            }
                            if (!z5 || (i = m19068a(motionEvent, this.f2094w, findPointerIndex4)) < 0) {
                                i = findPointerIndex4;
                            } else {
                                this.f2095x = motionEvent.getPointerId(i);
                                m19069a(motionEvent, i);
                                m19065b(motionEvent, i);
                                z5 = false;
                            }
                            if (z && z5) {
                                this.f2077f = -1.0f;
                                this.f2078g = -1.0f;
                                break;
                            } else if (!z) {
                                if (!z5) {
                                    this.f2092u = false;
                                    this.f2074c = this.f2073b.mo19054b(this);
                                    break;
                                } else {
                                    this.f2077f = motionEvent.getX(findPointerIndex3);
                                    this.f2078g = motionEvent.getY(findPointerIndex3);
                                    break;
                                }
                            } else {
                                this.f2077f = motionEvent.getX(i);
                                this.f2078g = motionEvent.getY(i);
                                break;
                            }
                        }
                        break;
                    case 5:
                        DisplayMetrics displayMetrics = this.f2072a.getResources().getDisplayMetrics();
                        this.f2090s = displayMetrics.widthPixels - this.f2089r;
                        this.f2091t = displayMetrics.heightPixels - this.f2089r;
                        if (this.f2075d != null) {
                            this.f2075d.recycle();
                        }
                        this.f2075d = MotionEvent.obtain(motionEvent);
                        this.f2088q = 0L;
                        if (Build.VERSION.SDK_INT >= 8) {
                            int actionIndex2 = motionEvent.getActionIndex();
                            int findPointerIndex5 = motionEvent.findPointerIndex(this.f2094w);
                            this.f2095x = motionEvent.getPointerId(actionIndex2);
                            if (findPointerIndex5 < 0 || findPointerIndex5 == actionIndex2) {
                                if (findPointerIndex5 != actionIndex2) {
                                    i4 = this.f2095x;
                                }
                                int m19068a5 = m19068a(motionEvent, i4, findPointerIndex5);
                                this.f2094w = motionEvent.getPointerId(m19068a5);
                                i3 = m19068a5;
                                i2 = actionIndex2;
                            } else {
                                i2 = actionIndex2;
                                i3 = findPointerIndex5;
                            }
                        } else if (motionEvent.getPointerCount() > 0) {
                            i2 = motionEvent.findPointerIndex(1);
                            i3 = motionEvent.findPointerIndex(this.f2094w);
                            this.f2095x = motionEvent.getPointerId(i2);
                        } else {
                            i2 = 0;
                            i3 = 0;
                        }
                        this.f2096y = false;
                        m19066b(motionEvent);
                        float f4 = this.f2089r;
                        float f5 = this.f2090s;
                        float f6 = this.f2091t;
                        float m19069a3 = m19069a(motionEvent, i3);
                        float m19065b3 = m19065b(motionEvent, i3);
                        float m19069a4 = m19069a(motionEvent, i2);
                        float m19065b4 = m19065b(motionEvent, i2);
                        boolean z6 = m19069a3 < f4 || m19065b3 < f4 || m19069a3 > f5 || m19065b3 > f6;
                        boolean z7 = m19069a4 < f4 || m19065b4 < f4 || m19069a4 > f5 || m19065b4 > f6;
                        if (z6 && z7) {
                            this.f2077f = -1.0f;
                            this.f2078g = -1.0f;
                            this.f2092u = true;
                            break;
                        } else if (!z6) {
                            if (!z7) {
                                this.f2092u = false;
                                this.f2074c = this.f2073b.mo19054b(this);
                                break;
                            } else {
                                this.f2077f = motionEvent.getX(i3);
                                this.f2078g = motionEvent.getY(i3);
                                this.f2092u = true;
                                break;
                            }
                        } else {
                            this.f2077f = motionEvent.getX(i2);
                            this.f2078g = motionEvent.getY(i2);
                            this.f2092u = true;
                            break;
                        }
                        break;
                    case 6:
                        if (this.f2092u) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            int actionIndex3 = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                            int pointerId2 = motionEvent.getPointerId(actionIndex3);
                            if (pointerCount2 <= 2) {
                                int findPointerIndex6 = motionEvent.findPointerIndex(pointerId2 == this.f2094w ? this.f2095x : this.f2094w);
                                if (findPointerIndex6 >= 0) {
                                    this.f2094w = motionEvent.getPointerId(findPointerIndex6);
                                    this.f2096y = true;
                                    this.f2095x = -1;
                                    this.f2077f = motionEvent.getX(findPointerIndex6);
                                    this.f2078g = motionEvent.getY(findPointerIndex6);
                                    break;
                                } else {
                                    this.f2093v = true;
                                    if (!this.f2074c) {
                                        return false;
                                    }
                                    this.f2073b.mo19053c(this);
                                    return false;
                                }
                            } else if (pointerId2 != this.f2094w) {
                                if (pointerId2 == this.f2095x && (m19068a = m19068a(motionEvent, this.f2094w, actionIndex3)) >= 0) {
                                    this.f2095x = motionEvent.getPointerId(m19068a);
                                    break;
                                }
                            } else {
                                int m19068a6 = m19068a(motionEvent, this.f2095x, actionIndex3);
                                if (m19068a6 >= 0) {
                                    this.f2094w = motionEvent.getPointerId(m19068a6);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        } else {
            z2 = false;
        }
        return z2;
    }

    /* renamed from: b */
    public float m19067b() {
        return this.f2078g;
    }

    /* renamed from: c */
    public float m19064c() {
        if (this.f2083l == -1.0f) {
            float f = this.f2081j;
            float f2 = this.f2082k;
            this.f2083l = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.f2083l;
    }

    /* renamed from: d */
    public float m19063d() {
        return this.f2081j;
    }

    /* renamed from: e */
    public float m19062e() {
        return this.f2082k;
    }

    /* renamed from: f */
    public float m19061f() {
        if (this.f2084m == -1.0f) {
            float f = this.f2079h;
            float f2 = this.f2080i;
            this.f2084m = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.f2084m;
    }

    /* renamed from: g */
    public float m19060g() {
        return this.f2079h;
    }

    /* renamed from: h */
    public float m19059h() {
        return this.f2080i;
    }

    /* renamed from: i */
    public float m19058i() {
        if (this.f2085n == -1.0f) {
            this.f2085n = m19064c() / m19061f();
        }
        return this.f2085n;
    }
}
