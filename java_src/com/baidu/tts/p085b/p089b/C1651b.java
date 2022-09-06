package com.baidu.tts.p085b.p089b;

import com.baidu.tts.p085b.p089b.p091b.AbstractC1655c;
import com.baidu.tts.p085b.p089b.p091b.C1653b;
/* renamed from: com.baidu.tts.b.b.b */
/* loaded from: classes.dex */
public class C1651b {

    /* renamed from: a */
    private static volatile C1651b f5795a = null;

    private C1651b() {
    }

    /* renamed from: a */
    public static C1651b m15120a() {
        if (f5795a == null) {
            synchronized (C1651b.class) {
                if (f5795a == null) {
                    f5795a = new C1651b();
                }
            }
        }
        return f5795a;
    }

    /* renamed from: c */
    private C1653b m15118c() {
        return new C1653b();
    }

    /* renamed from: b */
    public AbstractC1655c m15119b() {
        return m15118c();
    }
}
