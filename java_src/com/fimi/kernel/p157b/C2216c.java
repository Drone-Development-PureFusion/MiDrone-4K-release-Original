package com.fimi.kernel.p157b;

import com.fimi.kernel.p157b.p158a.C2185b;
import com.fimi.kernel.p157b.p159b.C2211e;
import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.kernel.p157b.p162e.C2230b;
/* renamed from: com.fimi.kernel.b.c */
/* loaded from: classes.dex */
public final class C2216c {
    /* renamed from: a */
    public static AbstractC2194b m13192a(EnumC2222d enumC2222d) {
        switch (enumC2222d) {
            case Ftp:
                return C2185b.m13318b();
            case Volley:
                return new C2230b();
            case Socket:
                return new C2225c();
            case Http:
                return new C2211e();
            default:
                return null;
        }
    }
}
