package com.fimi.soul.module.droneTrack;

import com.fimi.soul.drone.p203i.C2875af;
import com.fimi.soul.drone.p203i.C2876ag;
import com.fimi.soul.drone.p203i.C2877ah;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2894ay;
import com.fimi.soul.drone.p203i.C2900bd;
import com.fimi.soul.drone.p203i.C2909d;
import com.fimi.soul.drone.p203i.p204a.C2864c;
import com.fimi.soul.drone.p203i.p204a.C2867f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
/* renamed from: com.fimi.soul.module.droneTrack.a */
/* loaded from: classes.dex */
public class C3200a {

    /* renamed from: a */
    public static final int f12268a = 2;

    /* renamed from: b */
    public static final int f12269b = 3;

    /* renamed from: c */
    public static final int f12270c = 4;

    /* renamed from: d */
    public static final int f12271d = 5;

    /* renamed from: e */
    public static final int f12272e = 7;

    /* renamed from: f */
    public static final int f12273f = 9;

    /* renamed from: g */
    public static final int f12274g = 10;

    /* renamed from: h */
    public static final int f12275h = 11;

    /* renamed from: i */
    public static final int f12276i = 64;

    /* renamed from: j */
    public static final int f12277j = 63;

    /* renamed from: w */
    private float f12290w;

    /* renamed from: u */
    private List<String> f12288u = new ArrayList();

    /* renamed from: v */
    private long f12289v = 0;

    /* renamed from: x */
    private List<Integer> f12291x = new ArrayList();

    /* renamed from: k */
    public LinkedHashMap<Long, C2909d> f12278k = new LinkedHashMap<>();

    /* renamed from: l */
    public LinkedHashMap<Long, C2864c> f12279l = new LinkedHashMap<>();

    /* renamed from: m */
    public LinkedHashMap<Long, C2875af> f12280m = new LinkedHashMap<>();

    /* renamed from: n */
    public LinkedHashMap<Long, C2876ag> f12281n = new LinkedHashMap<>();

    /* renamed from: o */
    public LinkedHashMap<Long, C2877ah> f12282o = new LinkedHashMap<>();

    /* renamed from: p */
    public LinkedHashMap<Long, C2886aq> f12283p = new LinkedHashMap<>();

    /* renamed from: q */
    public LinkedHashMap<Long, C2894ay> f12284q = new LinkedHashMap<>();

    /* renamed from: s */
    public LinkedHashMap<Long, C2900bd> f12286s = new LinkedHashMap<>();

    /* renamed from: r */
    public LinkedHashMap<Long, C3212b> f12285r = new LinkedHashMap<>();

    /* renamed from: t */
    public LinkedHashMap<Long, C2867f> f12287t = new LinkedHashMap<>();

    /* renamed from: com.fimi.soul.module.droneTrack.a$a */
    /* loaded from: classes.dex */
    static class C3201a {

        /* renamed from: a */
        public static C3200a f12292a = new C3200a();

        C3201a() {
        }
    }

    /* renamed from: a */
    public static C3200a m9192a() {
        return C3201a.f12292a;
    }

    /* renamed from: a */
    public HashMap m9190a(int i) {
        switch (i) {
            case 2:
                return this.f12281n;
            case 3:
                return this.f12283p;
            case 4:
                return this.f12282o;
            case 5:
                return this.f12278k;
            case 7:
                return this.f12279l;
            case 9:
                return this.f12285r;
            case 10:
                return this.f12280m;
            case 11:
                return this.f12287t;
            case 63:
                return this.f12284q;
            case 64:
                return this.f12286s;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m9191a(float f) {
        this.f12290w = f;
    }

    /* renamed from: a */
    public void m9189a(long j) {
        this.f12289v = j;
    }

    /* renamed from: b */
    public List<String> m9188b() {
        return this.f12288u;
    }

    /* renamed from: c */
    public List<Integer> m9187c() {
        return this.f12291x;
    }

    /* renamed from: d */
    public long m9186d() {
        return this.f12289v;
    }

    /* renamed from: e */
    public float m9185e() {
        return this.f12290w;
    }

    /* renamed from: f */
    public void m9184f() {
        this.f12278k.clear();
        this.f12279l.clear();
        this.f12280m.clear();
        this.f12281n.clear();
        this.f12282o.clear();
        this.f12283p.clear();
        this.f12284q.clear();
        this.f12286s.clear();
        this.f12285r.clear();
        this.f12287t.clear();
        this.f12288u.clear();
        this.f12291x.clear();
    }
}
