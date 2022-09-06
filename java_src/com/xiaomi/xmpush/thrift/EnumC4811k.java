package com.xiaomi.xmpush.thrift;
/* renamed from: com.xiaomi.xmpush.thrift.k */
/* loaded from: classes2.dex */
public enum EnumC4811k {
    Circle(0),
    Polygon(1);
    

    /* renamed from: c */
    private final int f20290c;

    EnumC4811k(int i) {
        this.f20290c = i;
    }

    /* renamed from: a */
    public static EnumC4811k m3379a(int i) {
        switch (i) {
            case 0:
                return Circle;
            case 1:
                return Polygon;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public int m3380a() {
        return this.f20290c;
    }
}
