package com.tencent.p227mm.sdk.platformtools;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.p227mm.sdk.platformtools.PhoneUtil;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.tencent.mm.sdk.platformtools.PhoneUtil20Impl */
/* loaded from: classes.dex */
class PhoneUtil20Impl {

    /* renamed from: aK */
    private static int f17846aK = 10000;

    /* renamed from: aL */
    private static int f17847aL = 10000;

    /* renamed from: aM */
    private TelephonyManager f17848aM;

    /* renamed from: aN */
    private PhoneStateListener f17849aN = new PhoneStateListener() { // from class: com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (PhoneUtil20Impl.this.f17850aP == 2) {
                int unused = PhoneUtil20Impl.f17847aL = signalStrength.getCdmaDbm();
            }
            if (PhoneUtil20Impl.this.f17850aP == 1) {
                int unused2 = PhoneUtil20Impl.f17847aL = (signalStrength.getGsmSignalStrength() * 2) - 113;
            }
            if (PhoneUtil20Impl.this.f17848aM != null) {
                PhoneUtil20Impl.this.f17848aM.listen(PhoneUtil20Impl.this.f17849aN, 0);
            }
        }
    };

    /* renamed from: aP */
    private int f17850aP;

    public List<PhoneUtil.CellInfo> getCellInfoList(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        LinkedList linkedList = new LinkedList();
        String str2 = "460";
        String str3 = "";
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator == null || networkOperator.equals("")) {
                String simOperator = telephonyManager.getSimOperator();
                if (simOperator != null && !simOperator.equals("")) {
                    str2 = simOperator.substring(0, 3);
                    str3 = simOperator.substring(3, 5);
                }
                str = str3;
            } else {
                str2 = networkOperator.substring(0, 3);
                str = networkOperator.substring(3, 5);
            }
            if (telephonyManager.getPhoneType() == 2) {
                try {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                    if (cdmaCellLocation != null) {
                        String sb = f17847aL == f17846aK ? "" : new StringBuilder().append(f17847aL).toString();
                        if (cdmaCellLocation.getBaseStationId() != -1 && cdmaCellLocation.getNetworkId() != -1 && cdmaCellLocation.getSystemId() != -1) {
                            linkedList.add(new PhoneUtil.CellInfo(str2, str, "", "", sb, PhoneUtil.CELL_CDMA, new StringBuilder().append(cdmaCellLocation.getBaseStationId()).toString(), new StringBuilder().append(cdmaCellLocation.getNetworkId()).toString(), new StringBuilder().append(cdmaCellLocation.getSystemId()).toString()));
                        }
                    }
                } catch (Exception e) {
                    try {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                        if (gsmCellLocation != null) {
                            int cid = gsmCellLocation.getCid();
                            int lac = gsmCellLocation.getLac();
                            if (lac < 65535 && lac != -1 && cid != -1) {
                                linkedList.add(new PhoneUtil.CellInfo(str2, str, String.valueOf(lac), String.valueOf(cid), "", PhoneUtil.CELL_GSM, "", "", ""));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                    if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                        for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                            if (neighboringCellInfo2.getCid() != -1 && neighboringCellInfo2.getLac() <= 65535 && neighboringCellInfo2.getLac() != -1) {
                                linkedList.add(new PhoneUtil.CellInfo(str2, str, new StringBuilder().append(neighboringCellInfo2.getLac()).toString(), new StringBuilder().append(neighboringCellInfo2.getCid()).toString(), new StringBuilder().append((neighboringCellInfo2.getRssi() * 2) - 113).toString(), PhoneUtil.CELL_GSM, "", "", ""));
                            }
                        }
                    }
                }
            } else {
                try {
                    GsmCellLocation gsmCellLocation2 = (GsmCellLocation) telephonyManager.getCellLocation();
                    if (gsmCellLocation2 != null) {
                        int cid2 = gsmCellLocation2.getCid();
                        int lac2 = gsmCellLocation2.getLac();
                        if (lac2 < 65535 && lac2 != -1 && cid2 != -1) {
                            linkedList.add(new PhoneUtil.CellInfo(str2, str, String.valueOf(lac2), String.valueOf(cid2), f17847aL == f17846aK ? "" : new StringBuilder().append(f17847aL).toString(), PhoneUtil.CELL_GSM, "", "", ""));
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                List<NeighboringCellInfo> neighboringCellInfo3 = telephonyManager.getNeighboringCellInfo();
                if (neighboringCellInfo3 != null && neighboringCellInfo3.size() > 0) {
                    for (NeighboringCellInfo neighboringCellInfo4 : neighboringCellInfo3) {
                        if (neighboringCellInfo4.getCid() != -1 && neighboringCellInfo4.getLac() <= 65535) {
                            String sb2 = new StringBuilder().append((neighboringCellInfo4.getRssi() * 2) - 113).toString();
                            Log.m5641v("checked", "lac:" + neighboringCellInfo4.getLac() + "  cid:" + neighboringCellInfo4.getCid() + " dbm:" + sb2);
                            linkedList.add(new PhoneUtil.CellInfo(str2, str, new StringBuilder().append(neighboringCellInfo4.getLac()).toString(), new StringBuilder().append(neighboringCellInfo4.getCid()).toString(), sb2, PhoneUtil.CELL_GSM, "", "", ""));
                        }
                    }
                }
            }
            return linkedList;
        } catch (Exception e4) {
            e4.printStackTrace();
            return linkedList;
        }
    }

    public void getSignalStrength(Context context) {
        this.f17848aM = (TelephonyManager) context.getSystemService("phone");
        this.f17848aM.listen(this.f17849aN, 256);
        this.f17850aP = this.f17848aM.getPhoneType();
    }
}
