package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.fimi.soul.drone.i.w */
/* loaded from: classes.dex */
public class C2939w extends C2822e {

    /* renamed from: b */
    private long f11107b;

    /* renamed from: c */
    private byte f11108c;

    /* renamed from: d */
    private byte f11109d;

    /* renamed from: a */
    public byte m10146a() {
        return this.f11108c;
    }

    /* renamed from: a */
    public void m10145a(byte b) {
        this.f11108c = b;
    }

    /* renamed from: b */
    public byte m10144b() {
        return this.f11109d;
    }

    /* renamed from: b */
    public void m10143b(byte b) {
        this.f11109d = b;
    }

    /* renamed from: c */
    public boolean m10142c() {
        return this.f11109d == 1;
    }

    /* renamed from: d */
    public boolean m10141d() {
        if (System.currentTimeMillis() - this.f11107b > AbstractC0517a.f1169e) {
            this.f11107b = System.currentTimeMillis();
            return true;
        }
        return false;
    }
}
