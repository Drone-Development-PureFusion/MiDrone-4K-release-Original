package com.baidu.tts.p093d;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.baidu.tts.d.a */
/* loaded from: classes.dex */
public class C1668a {

    /* renamed from: a */
    private boolean f5875a = false;

    /* renamed from: b */
    private Map<String, Integer> f5876b = new HashMap();

    /* renamed from: a */
    public void m15049a(String str, int i) {
        this.f5876b.put(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m15048a(boolean z) {
        this.f5875a = z;
    }

    /* renamed from: a */
    public boolean m15050a() {
        return this.f5875a;
    }

    /* renamed from: b */
    public boolean m15047b() {
        for (Integer num : this.f5876b.values()) {
            if (num.intValue() != 7) {
                return false;
            }
        }
        return true;
    }
}
