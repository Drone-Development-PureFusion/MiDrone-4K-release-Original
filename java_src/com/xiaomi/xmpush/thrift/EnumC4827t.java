package com.xiaomi.xmpush.thrift;
/* renamed from: com.xiaomi.xmpush.thrift.t */
/* loaded from: classes2.dex */
public enum EnumC4827t {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: d */
    private final int f20492d;

    EnumC4827t(int i) {
        this.f20492d = i;
    }

    /* renamed from: a */
    public static EnumC4827t m3256a(int i) {
        switch (i) {
            case 0:
                return RegIdExpired;
            case 1:
                return PackageUnregistered;
            case 2:
                return Init;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public int m3257a() {
        return this.f20492d;
    }
}
