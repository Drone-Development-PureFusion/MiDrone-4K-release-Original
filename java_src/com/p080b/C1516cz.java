package com.p080b;

import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
/* renamed from: com.b.cz */
/* loaded from: classes.dex */
public final class C1516cz {

    /* renamed from: a */
    int f5428a;

    /* renamed from: b */
    int f5429b;

    /* renamed from: c */
    int f5430c;

    /* renamed from: d */
    int f5431d;

    /* renamed from: e */
    int f5432e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1516cz(CellLocation cellLocation) {
        this.f5428a = Integer.MAX_VALUE;
        this.f5429b = Integer.MAX_VALUE;
        this.f5430c = Integer.MAX_VALUE;
        this.f5431d = Integer.MAX_VALUE;
        this.f5432e = Integer.MAX_VALUE;
        if (cellLocation != null) {
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                this.f5432e = gsmCellLocation.getCid();
                this.f5431d = gsmCellLocation.getLac();
            } else if (!(cellLocation instanceof CdmaCellLocation)) {
            } else {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                this.f5430c = cdmaCellLocation.getBaseStationId();
                this.f5429b = cdmaCellLocation.getNetworkId();
                this.f5428a = cdmaCellLocation.getSystemId();
            }
        }
    }
}
