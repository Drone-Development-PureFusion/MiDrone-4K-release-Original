package com.tencent.open;

import android.location.Location;
import com.tencent.map.p224a.p225a.C4226b;
import com.tencent.map.p224a.p225a.C4228d;
import com.tencent.open.C4350c;
import com.tencent.open.p228a.C4331f;
/* renamed from: com.tencent.open.d */
/* loaded from: classes2.dex */
public class C4356d extends C4226b {

    /* renamed from: a */
    private C4350c.AbstractC4351a f18174a;

    public C4356d(C4350c.AbstractC4351a abstractC4351a) {
        super(1, 0, 0, 8);
        this.f18174a = abstractC4351a;
    }

    @Override // com.tencent.map.p224a.p225a.C4226b
    /* renamed from: a */
    public void mo5386a(int i) {
        C4331f.m5442c(C4331f.f18119d, "location: onStatusUpdate = " + i);
        super.mo5386a(i);
    }

    @Override // com.tencent.map.p224a.p225a.C4226b
    /* renamed from: a */
    public void mo5385a(C4228d c4228d) {
        C4331f.m5442c(C4331f.f18119d, "location: onLocationUpdate = " + c4228d);
        super.mo5385a(c4228d);
        if (c4228d == null) {
            return;
        }
        Location location = new Location("passive");
        location.setLatitude(c4228d.f17532b);
        location.setLongitude(c4228d.f17533c);
        if (this.f18174a == null) {
            return;
        }
        this.f18174a.onLocationUpdate(location);
    }

    @Override // com.tencent.map.p224a.p225a.C4226b
    /* renamed from: a */
    public void mo5384a(byte[] bArr, int i) {
        super.mo5384a(bArr, i);
    }
}
