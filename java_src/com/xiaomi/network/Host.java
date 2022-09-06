package com.xiaomi.network;

import java.net.InetSocketAddress;
/* loaded from: classes2.dex */
public final class Host {

    /* renamed from: a */
    private String f18699a;

    /* renamed from: b */
    private int f18700b;

    public Host(String str, int i) {
        this.f18699a = str;
        this.f18700b = i;
    }

    /* renamed from: a */
    public static Host m4755a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
                str = substring;
            } catch (NumberFormatException e) {
                str = substring;
            }
        }
        return new Host(str, i);
    }

    /* renamed from: b */
    public static InetSocketAddress m4753b(String str, int i) {
        Host m4755a = m4755a(str, i);
        return new InetSocketAddress(m4755a.m4754b(), m4755a.m4756a());
    }

    /* renamed from: a */
    public int m4756a() {
        return this.f18700b;
    }

    /* renamed from: b */
    public String m4754b() {
        return this.f18699a;
    }

    public String toString() {
        return this.f18700b > 0 ? this.f18699a + ":" + this.f18700b : this.f18699a;
    }
}
