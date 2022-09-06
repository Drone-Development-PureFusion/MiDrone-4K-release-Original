package com.fimi.p139b;
/* renamed from: com.fimi.b.g */
/* loaded from: classes.dex */
public class C2114g {

    /* renamed from: a */
    private EnumC2115a f7062a;

    /* renamed from: b */
    private EnumC2115a f7063b;

    /* renamed from: com.fimi.b.g$a */
    /* loaded from: classes.dex */
    public enum EnumC2115a {
        IDLE,
        MOUNT,
        UNMONT
    }

    /* renamed from: a */
    public boolean m13629a(boolean z) {
        if (z) {
            this.f7063b = EnumC2115a.MOUNT;
        } else {
            this.f7063b = EnumC2115a.UNMONT;
        }
        if (this.f7062a == this.f7063b) {
            return false;
        }
        this.f7062a = this.f7063b;
        return true;
    }
}
