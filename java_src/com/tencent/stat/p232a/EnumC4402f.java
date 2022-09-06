package com.tencent.stat.p232a;

import com.autonavi.amap.mapcore.ERROR_CODE;
import com.hoho.android.usbserial.driver.UsbId;
/* renamed from: com.tencent.stat.a.f */
/* loaded from: classes2.dex */
public enum EnumC4402f {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(UsbId.VENDOR_ATMEL),
    NETWORK_MONITOR(ERROR_CODE.CANCEL_ERROR);
    

    /* renamed from: i */
    private int f18392i;

    EnumC4402f(int i) {
        this.f18392i = i;
    }

    /* renamed from: a */
    public int m5244a() {
        return this.f18392i;
    }
}
