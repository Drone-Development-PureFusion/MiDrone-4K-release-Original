package com.autonavi.amap.mapcore;
/* loaded from: classes.dex */
class VTmcData {
    int createTime;
    byte[] data;
    String eTag;
    String girdName;
    int timeStamp;

    public VTmcData(byte[] bArr) {
        try {
            this.createTime = (int) (System.currentTimeMillis() / 1000);
            byte b = bArr[4];
            this.girdName = new String(bArr, 5, b, "utf-8");
            int i = b + 5;
            int i2 = i + 1;
            byte b2 = bArr[i];
            this.eTag = new String(bArr, i2, (int) b2);
            int i3 = b2 + i2;
            this.timeStamp = Convert.getInt(bArr, i3);
            int i4 = i3 + 4;
            this.data = bArr;
        } catch (Exception e) {
            this.data = null;
        }
    }

    public void updateTimeStamp(int i) {
        if (this.data == null) {
            return;
        }
        this.createTime = (int) (System.currentTimeMillis() / 1000);
        int i2 = this.data[4] + 5;
        byte[] bArr = this.data;
        Convert.writeInt(bArr, this.data[i2] + i2 + 1, i);
        this.timeStamp = i;
    }
}
