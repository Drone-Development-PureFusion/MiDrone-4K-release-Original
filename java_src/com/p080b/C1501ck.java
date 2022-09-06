package com.p080b;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.ck */
/* loaded from: classes.dex */
public final class C1501ck extends PhoneStateListener {

    /* renamed from: a */
    private /* synthetic */ C1499ci f5373a;

    private C1501ck(C1499ci c1499ci) {
        this.f5373a = c1499ci;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1501ck(C1499ci c1499ci, byte b) {
        this(c1499ci);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCellLocationChanged(CellLocation cellLocation) {
        try {
            this.f5373a.f5371y = System.currentTimeMillis();
            this.f5373a.f5344C = cellLocation;
            super.onCellLocationChanged(cellLocation);
        } catch (Exception e) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState serviceState) {
        TelephonyManager telephonyManager;
        String[] m15807b;
        try {
            if (serviceState.getState() == 0) {
                this.f5373a.f5362p = true;
                telephonyManager = this.f5373a.f5353g;
                m15807b = C1499ci.m15807b(telephonyManager);
                this.f5373a.f5366t = Integer.parseInt(m15807b[0]);
                this.f5373a.f5367u = Integer.parseInt(m15807b[1]);
            } else {
                this.f5373a.f5362p = false;
            }
            super.onServiceStateChanged(serviceState);
        } catch (Exception e) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        boolean z;
        int i;
        int i2;
        try {
            z = this.f5373a.f5360n;
            if (z) {
                this.f5373a.f5361o = signalStrength.getCdmaDbm();
            } else {
                this.f5373a.f5361o = signalStrength.getGsmSignalStrength();
                i = this.f5373a.f5361o;
                if (i == 99) {
                    this.f5373a.f5361o = -1;
                } else {
                    C1499ci c1499ci = this.f5373a;
                    i2 = this.f5373a.f5361o;
                    c1499ci.f5361o = (i2 * 2) - 113;
                }
            }
            super.onSignalStrengthsChanged(signalStrength);
        } catch (Exception e) {
        }
    }
}
