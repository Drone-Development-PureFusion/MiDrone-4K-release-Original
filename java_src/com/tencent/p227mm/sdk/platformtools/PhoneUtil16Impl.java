package com.tencent.p227mm.sdk.platformtools;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.p227mm.sdk.platformtools.PhoneUtil;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.tencent.mm.sdk.platformtools.PhoneUtil16Impl */
/* loaded from: classes.dex */
class PhoneUtil16Impl {

    /* renamed from: aK */
    private static int f17841aK = 10000;

    /* renamed from: aL */
    private static int f17842aL = 10000;

    /* renamed from: aM */
    private TelephonyManager f17843aM;

    /* renamed from: aN */
    private PhoneStateListener f17844aN = new PhoneStateListener() { // from class: com.tencent.mm.sdk.platformtools.PhoneUtil16Impl.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
            int unused = PhoneUtil16Impl.f17842aL = (i * 2) - 113;
            if (PhoneUtil16Impl.this.f17843aM != null) {
                PhoneUtil16Impl.this.f17843aM.listen(PhoneUtil16Impl.this.f17844aN, 0);
            }
        }
    };

    public List<PhoneUtil.CellInfo> getCellInfoList(Context context) {
        LinkedList linkedList = new LinkedList();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator == null || networkOperator.equals("")) {
            return linkedList;
        }
        String str = "460";
        String str2 = "";
        try {
            str = networkOperator.substring(0, 3);
            str2 = networkOperator.substring(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
            if (gsmCellLocation != null) {
                int cid = gsmCellLocation.getCid();
                int lac = gsmCellLocation.getLac();
                if (lac < 65535 && lac != -1 && cid != -1) {
                    linkedList.add(new PhoneUtil.CellInfo(str, str2, String.valueOf(lac), String.valueOf(cid), f17842aL == f17841aK ? "" : new StringBuilder().append(f17842aL).toString(), PhoneUtil.CELL_GSM, "", "", ""));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
        if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
            for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                if (neighboringCellInfo2.getCid() != -1) {
                    linkedList.add(new PhoneUtil.CellInfo(str, str2, "", new StringBuilder().append(neighboringCellInfo2.getCid()).toString(), "", PhoneUtil.CELL_GSM, "", "", ""));
                }
            }
        }
        return linkedList;
    }

    public void getSignalStrength(Context context) {
        this.f17843aM = (TelephonyManager) context.getSystemService("phone");
        this.f17843aM.listen(this.f17844aN, 256);
    }
}
