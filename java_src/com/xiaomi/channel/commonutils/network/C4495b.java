package com.xiaomi.channel.commonutils.network;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.channel.commonutils.network.b */
/* loaded from: classes2.dex */
public class C4495b {

    /* renamed from: a */
    public int f18570a;

    /* renamed from: b */
    public Map<String, String> f18571b = new HashMap();

    /* renamed from: c */
    public String f18572c;

    /* renamed from: a */
    public String m5003a() {
        return this.f18572c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f18570a), this.f18571b.toString(), this.f18572c);
    }
}
