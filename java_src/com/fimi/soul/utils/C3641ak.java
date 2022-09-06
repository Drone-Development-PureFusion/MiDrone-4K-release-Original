package com.fimi.soul.utils;

import android.annotation.SuppressLint;
import java.util.LinkedList;
/* renamed from: com.fimi.soul.utils.ak */
/* loaded from: classes.dex */
public class C3641ak {

    /* renamed from: b */
    private int f14800b = 10;

    /* renamed from: a */
    private LinkedList f14799a = new LinkedList();

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public Object m7696a() {
        return this.f14799a.peekFirst();
    }

    /* renamed from: a */
    public void m7695a(int i) {
        this.f14800b = i;
    }

    /* renamed from: a */
    public void m7694a(Object obj) {
        if (this.f14800b <= 0) {
            this.f14799a.removeFirst();
        }
        this.f14799a.addLast(obj);
        this.f14800b--;
    }

    /* renamed from: a */
    public void m7693a(LinkedList linkedList) {
        this.f14799a = linkedList;
    }

    /* renamed from: b */
    public void m7692b() {
        this.f14799a.removeFirst();
    }

    /* renamed from: c */
    public int m7691c() {
        return this.f14799a.size();
    }

    /* renamed from: d */
    public LinkedList m7690d() {
        return this.f14799a;
    }

    /* renamed from: e */
    public int m7689e() {
        return this.f14800b;
    }
}
