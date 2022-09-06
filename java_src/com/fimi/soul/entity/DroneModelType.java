package com.fimi.soul.entity;
/* loaded from: classes.dex */
public class DroneModelType {
    public static final int AP_STATUS_LOW_POWER_LANDING = 3;
    public static final int AP_STATUS_NO_FLY_LANDING = 4;
    public static final int VCM_AUTO_LANDING = 3;
    public static final int VCM_AUTO_TAKE_OFF = 2;
    public static final int VCM_EMERGENCY_LANDING = 9;
    public static final int VCM_EMERGENCY_RTH = 8;
    public static final int VCM_FLY_TO = 4;
    public static final int VCM_INTEREST_POINT = 5;
    public static final int VCM_MISSION = 6;
    public static final int VCM_NORMAL = 1;
    public static final int VCM_NULL = 0;
    public static final int VCM_RTH = 7;
    public static final int VCM_SELFIE = 10;
    public static final int VEHICLE_CTRL_TYPE_ACRO = 4;
    public static final int VEHICLE_CTRL_TYPE_ASSITED = 3;
    public static final int VEHICLE_CTRL_TYPE_ATTI = 0;
    public static final int VEHICLE_CTRL_TYPE_GLOBAL_AUTO = 1;
    public static final int VEHICLE_CTRL_TYPE_LOCAL_AUTO = 2;
    private int ctrlMode;
    private int ctrlType;

    public int getCtlMode() {
        return this.ctrlMode;
    }

    public boolean isEnforcementAtti() {
        return this.ctrlType == 0;
    }

    public boolean isEnterModel() {
        if (this.ctrlMode == 3 && this.ctrlType == 1) {
            return true;
        }
        if ((this.ctrlMode == 7 && this.ctrlType == 1) || this.ctrlMode == 8) {
            return true;
        }
        return this.ctrlMode == 3 && this.ctrlType == 2;
    }

    public boolean isExceAction() {
        return this.ctrlMode == 6 || this.ctrlMode == 4 || this.ctrlMode == 5 || this.ctrlMode == 10;
    }

    public boolean isGoHome() {
        return this.ctrlMode == 7;
    }

    public boolean isGps() {
        return this.ctrlType == 1;
    }

    public boolean isInWayPoint() {
        return this.ctrlMode == 6;
    }

    public boolean isLanding() {
        return this.ctrlMode == 3;
    }

    public boolean isLightStream() {
        return this.ctrlType == 2;
    }

    public boolean isTakePhotoSelf() {
        return this.ctrlMode == 10;
    }

    public boolean judgeNoAction() {
        return (this.ctrlMode == 6 || this.ctrlMode == 4 || this.ctrlMode == 5 || this.ctrlMode == 10) ? false : true;
    }

    public boolean judgeOpenDrawLayout() {
        return this.ctrlMode == 1 || this.ctrlMode == 0 || this.ctrlMode == 2 || this.ctrlMode == 7 || this.ctrlMode == 3 || this.ctrlMode == 9;
    }

    public void setCtrlMode(int i) {
        this.ctrlMode = i;
    }

    public void setCtrlType(int i) {
        this.ctrlType = i;
    }
}
