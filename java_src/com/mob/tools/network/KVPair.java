package com.mob.tools.network;

import com.github.moduth.blockcanary.p215b.C3947a;
/* loaded from: classes.dex */
public class KVPair<T> {
    public final String name;
    public final T value;

    public KVPair(String str, T t) {
        this.name = str;
        this.value = t;
    }

    public String toString() {
        return this.name + C3947a.f16891b + this.value;
    }
}
