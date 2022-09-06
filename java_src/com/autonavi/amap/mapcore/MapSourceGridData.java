package com.autonavi.amap.mapcore;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class MapSourceGridData {
    public String gridName;
    public String keyGridName;
    public int mIndoorIndex;
    public int mIndoorVersion;
    public Object obj = null;
    public int sourceType;

    public MapSourceGridData(String str, int i) {
        this.gridName = str;
        this.sourceType = i;
        this.keyGridName = i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gridName;
    }

    public MapSourceGridData(String str, int i, int i2, int i3) {
        this.gridName = str;
        this.mIndoorIndex = i2;
        this.mIndoorVersion = i3;
        this.sourceType = i;
        this.keyGridName = i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gridName + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
    }

    public String getGridName() {
        return this.gridName;
    }

    public String getKeyGridName() {
        return this.keyGridName;
    }

    public int getSourceType() {
        return this.sourceType;
    }
}
