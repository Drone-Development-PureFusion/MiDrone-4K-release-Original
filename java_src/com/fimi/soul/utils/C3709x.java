package com.fimi.soul.utils;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.utils.x */
/* loaded from: classes.dex */
public class C3709x implements Serializable {

    /* renamed from: a */
    private String f15136a;

    /* renamed from: b */
    private String f15137b;

    /* renamed from: c */
    private long f15138c;

    /* renamed from: d */
    private double f15139d;

    /* renamed from: e */
    private String f15140e = "0";

    /* renamed from: f */
    private double f15141f;

    /* renamed from: g */
    private double f15142g;

    /* renamed from: a */
    public String m7405a() {
        return this.f15140e;
    }

    /* renamed from: a */
    public void m7404a(double d) {
        this.f15139d = d;
    }

    /* renamed from: a */
    public void m7403a(long j) {
        this.f15138c = j;
    }

    /* renamed from: a */
    public void m7402a(String str) {
        this.f15140e = str;
    }

    /* renamed from: b */
    public String m7401b() {
        return this.f15136a;
    }

    /* renamed from: b */
    public void m7400b(double d) {
        this.f15141f = d;
    }

    /* renamed from: b */
    public void m7399b(String str) {
        this.f15136a = str;
    }

    /* renamed from: c */
    public String m7398c() {
        return this.f15137b;
    }

    /* renamed from: c */
    public void m7397c(double d) {
        this.f15142g = d;
    }

    /* renamed from: c */
    public void m7396c(String str) {
        this.f15137b = str;
    }

    /* renamed from: d */
    public long m7395d() {
        return this.f15138c;
    }

    /* renamed from: e */
    public double m7394e() {
        return this.f15139d;
    }

    /* renamed from: f */
    public double m7393f() {
        return this.f15141f;
    }

    /* renamed from: g */
    public double m7392g() {
        return this.f15142g;
    }

    public String toString() {
        return "FlyRecordEntity{user_id='" + this.f15136a + C0359h.f729z + ", drone_id='" + this.f15137b + C0359h.f729z + ", flyTime=" + this.f15138c + ", flyDistance=" + this.f15139d + ", deviceType='" + this.f15140e + C0359h.f729z + ", lat=" + this.f15141f + ", lon=" + this.f15142g + C0359h.f726w;
    }
}
