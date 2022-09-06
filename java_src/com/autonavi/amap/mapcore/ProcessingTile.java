package com.autonavi.amap.mapcore;
/* loaded from: classes.dex */
class ProcessingTile {
    public static final int STATE_REQUESTING = 1;
    public static final int STATE_WAITING = 0;
    int flag;
    String keyname;

    public ProcessingTile(String str, int i) {
        this.keyname = str;
        this.flag = i;
    }
}
