package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.bw */
/* loaded from: classes.dex */
public interface AbstractC0858bw {

    /* renamed from: com.amap.api.mapcore.util.bw$a */
    /* loaded from: classes.dex */
    public enum EnumC0859a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        

        /* renamed from: f */
        private int f2400f;

        EnumC0859a(int i) {
            this.f2400f = i;
        }
    }

    /* renamed from: a */
    void mo18738a(long j, long j2);

    /* renamed from: a */
    void mo18737a(EnumC0859a enumC0859a);

    /* renamed from: n */
    void mo18736n();

    /* renamed from: o */
    void mo18735o();

    /* renamed from: p */
    void mo18734p();
}
