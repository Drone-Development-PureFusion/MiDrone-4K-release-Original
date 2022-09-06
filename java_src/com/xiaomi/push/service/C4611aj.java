package com.xiaomi.push.service;

import com.xiaomi.xmpush.thrift.EnumC4804f;
import com.xiaomi.xmpush.thrift.EnumC4805g;
/* renamed from: com.xiaomi.push.service.aj */
/* loaded from: classes2.dex */
/* synthetic */ class C4611aj {

    /* renamed from: a */
    static final /* synthetic */ int[] f18949a;

    /* renamed from: b */
    static final /* synthetic */ int[] f18950b = new int[EnumC4805g.values().length];

    static {
        try {
            f18950b[EnumC4805g.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f18950b[EnumC4805g.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f18950b[EnumC4805g.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f18950b[EnumC4805g.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f18949a = new int[EnumC4804f.values().length];
        try {
            f18949a[EnumC4804f.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f18949a[EnumC4804f.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
