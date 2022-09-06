package com.xiaomi.xmpush.thrift;
/* renamed from: com.xiaomi.xmpush.thrift.h */
/* loaded from: classes2.dex */
public enum EnumC4806h {
    Baidu(0),
    Tencent(1),
    AutoNavi(2),
    Google(3),
    GPS(4);
    

    /* renamed from: f */
    private final int f20230f;

    EnumC4806h(int i) {
        this.f20230f = i;
    }

    /* renamed from: a */
    public static EnumC4806h m3432a(int i) {
        switch (i) {
            case 0:
                return Baidu;
            case 1:
                return Tencent;
            case 2:
                return AutoNavi;
            case 3:
                return Google;
            case 4:
                return GPS;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public int m3433a() {
        return this.f20230f;
    }
}
