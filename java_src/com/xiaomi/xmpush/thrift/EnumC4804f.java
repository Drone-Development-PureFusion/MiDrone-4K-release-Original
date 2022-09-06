package com.xiaomi.xmpush.thrift;
/* renamed from: com.xiaomi.xmpush.thrift.f */
/* loaded from: classes2.dex */
public enum EnumC4804f {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: c */
    private final int f20217c;

    EnumC4804f(int i) {
        this.f20217c = i;
    }

    /* renamed from: a */
    public static EnumC4804f m3435a(int i) {
        switch (i) {
            case 1:
                return MISC_CONFIG;
            case 2:
                return PLUGIN_CONFIG;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public int m3436a() {
        return this.f20217c;
    }
}
