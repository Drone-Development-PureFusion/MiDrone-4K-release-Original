package com.fimi.soul.module.droneTrack.p208a;

import com.fimi.soul.drone.p203i.C2876ag;
import com.fimi.soul.drone.p203i.C2877ah;
import com.fimi.soul.drone.p203i.C2881al;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2894ay;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2909d;
import com.fimi.soul.drone.p203i.C2910e;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.drone.p203i.p204a.C2864c;
import com.fimi.soul.drone.p203i.p204a.C2867f;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.module.droneTrack.a.a */
/* loaded from: classes.dex */
public class C3202a {

    /* renamed from: j */
    C2908c f12302j;

    /* renamed from: k */
    boolean f12303k;

    /* renamed from: a */
    C2876ag f12293a = new C2876ag();

    /* renamed from: b */
    C2886aq f12294b = new C2886aq();

    /* renamed from: c */
    C2877ah f12295c = new C2877ah();

    /* renamed from: d */
    C2909d f12296d = new C2909d();

    /* renamed from: e */
    C2864c f12297e = new C2864c();

    /* renamed from: l */
    C2940x f12304l = new C2940x();

    /* renamed from: f */
    C2867f f12298f = new C2867f();

    /* renamed from: g */
    C2894ay f12299g = new C2894ay();

    /* renamed from: h */
    C2910e f12300h = new C2910e();

    /* renamed from: i */
    C2882am f12301i = new C2882am();

    /* renamed from: m */
    private C2881al f12305m = new C2881al();

    /* renamed from: a */
    public C2867f m9183a() {
        return this.f12298f;
    }

    /* renamed from: a */
    public void m9182a(C2864c c2864c) {
        this.f12297e = c2864c;
    }

    /* renamed from: a */
    public void m9181a(C2867f c2867f) {
        this.f12298f = c2867f;
    }

    /* renamed from: a */
    public void m9180a(C2876ag c2876ag) {
        this.f12293a = c2876ag;
        if (((c2876ag.m10627g() & 240) >> 4) == 1) {
            m9170a(true);
        } else {
            m9170a(false);
        }
    }

    /* renamed from: a */
    public void m9179a(C2877ah c2877ah) {
        this.f12295c = c2877ah;
    }

    /* renamed from: a */
    public void m9178a(C2881al c2881al) {
        this.f12305m = c2881al;
    }

    /* renamed from: a */
    public void m9177a(C2882am c2882am) {
        this.f12301i = c2882am;
    }

    /* renamed from: a */
    public void m9176a(C2886aq c2886aq) {
        this.f12294b = c2886aq;
    }

    /* renamed from: a */
    public void m9175a(C2894ay c2894ay) {
        this.f12299g = c2894ay;
    }

    /* renamed from: a */
    public void m9174a(C2908c c2908c) {
        this.f12302j = c2908c;
    }

    /* renamed from: a */
    public void m9173a(C2909d c2909d) {
        this.f12296d = c2909d;
    }

    /* renamed from: a */
    public void m9172a(C2910e c2910e) {
        this.f12300h = c2910e;
    }

    /* renamed from: a */
    public void m9171a(C2940x c2940x) {
        this.f12304l = c2940x;
    }

    /* renamed from: a */
    public void m9170a(boolean z) {
        this.f12303k = z;
    }

    /* renamed from: b */
    public C2940x m9169b() {
        return this.f12304l;
    }

    /* renamed from: c */
    public C2864c m9168c() {
        return this.f12297e;
    }

    /* renamed from: d */
    public C2909d m9167d() {
        return this.f12296d;
    }

    /* renamed from: e */
    public C2877ah m9166e() {
        return this.f12295c;
    }

    /* renamed from: f */
    public C2886aq m9165f() {
        return this.f12294b;
    }

    /* renamed from: g */
    public C2876ag m9164g() {
        return this.f12293a;
    }

    /* renamed from: h */
    public C2894ay m9163h() {
        return this.f12299g;
    }

    /* renamed from: i */
    public C2910e m9162i() {
        return this.f12300h;
    }

    /* renamed from: j */
    public boolean m9161j() {
        return this.f12303k;
    }

    /* renamed from: k */
    public C2882am m9160k() {
        return this.f12301i;
    }

    /* renamed from: l */
    public C2908c m9159l() {
        return this.f12302j;
    }

    /* renamed from: m */
    public boolean m9158m() {
        return this.f12299g != null && C3658ar.m7621a(this.f12299g.m10440e(), Math.abs(0)) > 0;
    }

    /* renamed from: n */
    public boolean m9157n() {
        return this.f12299g != null && C3658ar.m7621a(this.f12299g.m10440e(), Math.abs(1)) > 0;
    }

    /* renamed from: o */
    public C2881al m9156o() {
        return this.f12305m;
    }
}
