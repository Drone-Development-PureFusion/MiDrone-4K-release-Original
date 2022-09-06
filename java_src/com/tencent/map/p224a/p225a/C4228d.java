package com.tencent.map.p224a.p225a;

import com.tencent.map.p226b.C4257h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.tencent.map.a.a.d */
/* loaded from: classes.dex */
public class C4228d {

    /* renamed from: A */
    private long f17530A;

    /* renamed from: a */
    public int f17531a;

    /* renamed from: b */
    public double f17532b;

    /* renamed from: c */
    public double f17533c;

    /* renamed from: d */
    public double f17534d;

    /* renamed from: e */
    public double f17535e;

    /* renamed from: f */
    public double f17536f;

    /* renamed from: g */
    public double f17537g;

    /* renamed from: h */
    public int f17538h;

    /* renamed from: i */
    public String f17539i;

    /* renamed from: j */
    public String f17540j;

    /* renamed from: k */
    public String f17541k;

    /* renamed from: l */
    public String f17542l;

    /* renamed from: m */
    public String f17543m;

    /* renamed from: n */
    public String f17544n;

    /* renamed from: o */
    public String f17545o;

    /* renamed from: p */
    public String f17546p;

    /* renamed from: q */
    public String f17547q;

    /* renamed from: r */
    public String f17548r;

    /* renamed from: s */
    public String f17549s;

    /* renamed from: t */
    public String f17550t;

    /* renamed from: u */
    public String f17551u;

    /* renamed from: v */
    public String f17552v;

    /* renamed from: w */
    public ArrayList<C4227c> f17553w;

    /* renamed from: x */
    public boolean f17554x;

    /* renamed from: y */
    public int f17555y;

    /* renamed from: z */
    public int f17556z;

    public C4228d() {
        this.f17531a = 1;
        this.f17532b = 0.0d;
        this.f17533c = 0.0d;
        this.f17534d = -1.0d;
        this.f17535e = 0.0d;
        this.f17536f = 0.0d;
        this.f17537g = 0.0d;
        this.f17538h = 0;
        this.f17539i = null;
        this.f17540j = null;
        this.f17541k = null;
        this.f17542l = null;
        this.f17543m = null;
        this.f17544n = null;
        this.f17545o = null;
        this.f17546p = null;
        this.f17547q = null;
        this.f17548r = null;
        this.f17549s = null;
        this.f17550t = null;
        this.f17551u = null;
        this.f17552v = null;
        this.f17553w = null;
        this.f17554x = false;
        this.f17555y = 0;
        this.f17556z = -1;
        this.f17530A = -1L;
        this.f17535e = 0.0d;
        this.f17534d = 0.0d;
        this.f17533c = 0.0d;
        this.f17532b = 0.0d;
        this.f17546p = null;
        this.f17545o = null;
        this.f17544n = null;
        this.f17543m = null;
        this.f17554x = false;
        this.f17530A = System.currentTimeMillis();
        this.f17555y = 0;
        this.f17556z = -1;
        this.f17553w = null;
    }

    public C4228d(C4228d c4228d) {
        this.f17531a = 1;
        this.f17532b = 0.0d;
        this.f17533c = 0.0d;
        this.f17534d = -1.0d;
        this.f17535e = 0.0d;
        this.f17536f = 0.0d;
        this.f17537g = 0.0d;
        this.f17538h = 0;
        this.f17539i = null;
        this.f17540j = null;
        this.f17541k = null;
        this.f17542l = null;
        this.f17543m = null;
        this.f17544n = null;
        this.f17545o = null;
        this.f17546p = null;
        this.f17547q = null;
        this.f17548r = null;
        this.f17549s = null;
        this.f17550t = null;
        this.f17551u = null;
        this.f17552v = null;
        this.f17553w = null;
        this.f17554x = false;
        this.f17555y = 0;
        this.f17556z = -1;
        this.f17530A = -1L;
        this.f17531a = c4228d.f17531a;
        this.f17532b = c4228d.f17532b;
        this.f17533c = c4228d.f17533c;
        this.f17534d = c4228d.f17534d;
        this.f17535e = c4228d.f17535e;
        this.f17554x = c4228d.f17554x;
        this.f17539i = c4228d.f17539i;
        this.f17538h = 0;
        this.f17540j = c4228d.f17540j;
        this.f17541k = c4228d.f17541k;
        this.f17542l = c4228d.f17542l;
        this.f17543m = c4228d.f17543m;
        this.f17544n = c4228d.f17544n;
        this.f17545o = c4228d.f17545o;
        this.f17546p = c4228d.f17546p;
        this.f17547q = c4228d.f17547q;
        this.f17548r = c4228d.f17548r;
        this.f17549s = c4228d.f17549s;
        this.f17550t = c4228d.f17550t;
        this.f17551u = c4228d.f17551u;
        this.f17552v = c4228d.f17552v;
        this.f17530A = c4228d.m5817a();
        this.f17555y = c4228d.f17555y;
        this.f17556z = c4228d.f17556z;
        this.f17553w = null;
        if (c4228d.f17553w != null) {
            this.f17553w = new ArrayList<>();
            Iterator<C4227c> it2 = c4228d.f17553w.iterator();
            while (it2.hasNext()) {
                this.f17553w.add(it2.next());
            }
        }
    }

    /* renamed from: a */
    public long m5817a() {
        return this.f17530A;
    }

    /* renamed from: a */
    public void m5816a(String str) {
        String[] split;
        this.f17542l = "Unknown";
        this.f17541k = "Unknown";
        this.f17540j = "Unknown";
        this.f17539i = "Unknown";
        if (str == null || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null) {
            return;
        }
        int length = split.length;
        if (length > 0) {
            this.f17539i = split[0];
        }
        if (length > 1) {
            this.f17540j = split[1];
        }
        if (length == 3) {
            this.f17541k = split[1];
        } else if (length > 3) {
            this.f17541k = split[2];
        }
        if (length == 3) {
            this.f17542l = split[2];
        } else if (length <= 3) {
        } else {
            this.f17542l = split[3];
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17556z).append(" ").append(this.f17555y).append(" ").append(this.f17554x ? "Mars" : "WGS84").append(" ").append(this.f17531a == 0 ? "GPS" : "Network").append("\n");
        sb.append(this.f17532b).append(" ").append(this.f17533c).append("\n");
        sb.append(this.f17534d).append(" ").append(this.f17535e).append("\n");
        sb.append(this.f17536f).append(" ").append(this.f17537g).append("\n");
        if (this.f17556z == 3 || this.f17556z == 4) {
            sb.append(this.f17539i).append(" ").append(this.f17540j).append(" ").append(this.f17541k).append(" ").append(this.f17542l).append(" ").append(this.f17543m).append(" ").append(this.f17544n).append(" ").append(this.f17545o).append(" ").append(this.f17546p).append("\n");
        }
        if (this.f17556z == 4 && this.f17553w != null) {
            sb.append(this.f17553w.size()).append("\n");
            Iterator<C4227c> it2 = this.f17553w.iterator();
            while (it2.hasNext()) {
                C4227c next = it2.next();
                sb.append(next.f17524a).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(next.f17525b).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(next.f17526c).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(next.f17527d).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(next.f17528e).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(next.f17529f).append("\n");
            }
        }
        if (this.f17556z == 7) {
            if (this.f17538h == 0) {
                sb.append(this.f17539i).append(" ").append(this.f17540j).append(" ").append(this.f17541k).append(" ").append(this.f17542l).append(" ").append(this.f17543m).append(" ").append(this.f17544n).append(" ").append(this.f17545o).append(" ").append(this.f17546p).append("\n");
            } else if (this.f17538h == 1) {
                sb.append(this.f17539i).append(" ").append(this.f17547q).append(" ").append(this.f17548r).append(" ").append(this.f17549s).append(" ").append(this.f17550t).append(" ").append(this.f17551u).append(" ").append(this.f17552v).append("\n");
            }
        }
        C4257h.m5700a(sb.toString());
        return sb.toString();
    }
}
