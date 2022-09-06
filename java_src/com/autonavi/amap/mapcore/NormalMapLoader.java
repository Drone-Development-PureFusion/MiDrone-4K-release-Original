package com.autonavi.amap.mapcore;

import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class NormalMapLoader extends BaseMapLoader {
    public NormalMapLoader(MapCore mapCore, BaseMapCallImplement baseMapCallImplement, int i) {
        this.datasource = i;
        this.mGLMapEngine = mapCore;
        this.mMapCallback = baseMapCallImplement;
        this.createtime = System.currentTimeMillis();
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected String getGridParma() {
        return getGridParmaV4();
    }

    public String getGridParmaV4() {
        String str;
        String str2;
        int i = 0;
        String str3 = null;
        while (i < this.mapTiles.size()) {
            String gridName = this.mapTiles.get(i).getGridName();
            if (gridName == null || gridName.length() == 0 || containllegal(gridName)) {
                str = str3;
            } else if (!isAssic(gridName)) {
                str = str3;
            } else {
                if (this.datasource != 4 || this.mapTiles.get(i).obj == null) {
                    str2 = gridName;
                } else {
                    try {
                        str2 = gridName + Constants.ACCEPT_TIME_SEPARATOR_SERVER + URLEncoder.encode((String) this.mapTiles.get(i).obj, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        str = str3;
                    }
                }
                str = str3 == null ? str2 + ";" : str3 + str2 + ";";
            }
            i++;
            str3 = str;
        }
        if (str3 == null) {
            return null;
        }
        if (str3.length() > 0) {
            String str4 = str3;
            while (str4 != null && (str4.endsWith(";") || str4.endsWith(" "))) {
                str4 = str3.substring(0, str4.length() - 1);
            }
            str3 = str4;
        }
        if (str3.length() <= 0) {
            return null;
        }
        if (this.datasource == 0) {
            return "mapdataver=5&type=20&mesh=" + str3;
        }
        if (this.datasource == 1) {
            return "mapdataver=5&type=11&mesh=" + str3;
        }
        if (this.datasource == 7) {
            return "mapdataver=5&type=1&mesh=" + str3;
        }
        if (this.datasource == 8) {
            return "mapdataver=5&type=13&mesh=" + str3;
        }
        if (this.datasource == 9) {
            return "mapdataver=5&type=40&mesh=" + str3;
        }
        if (this.datasource == 2) {
            return "t=BMPBM&mapdataver=5&mesh=" + str3;
        }
        if (this.datasource == 3) {
            return "mapdataver=5&mesh=" + str3;
        }
        if (this.datasource == 4) {
            return "mapdataver=5&v=6.0.0&bver=2&mesh=" + str3;
        }
        if (this.datasource != 6) {
            return null;
        }
        return "t=VMMV3&mapdataver=5&type=mod&cp=0&mid=" + str3;
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected String getMapAddress() {
        return this.mMapCallback.getMapSvrAddress();
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected String getMapSvrPath() {
        switch (this.datasource) {
            case 0:
            case 1:
            case 7:
            case 8:
            case 9:
                return "/ws/mps/vmap?";
            case 2:
            case 6:
                return "/amapsrv/MPS?";
            case 3:
                return "/ws/mps/smap?";
            case 4:
                return "/ws/mps/rtt?";
            case 5:
            default:
                return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected boolean isNeedProcessReturn() {
        return this.datasource == 9;
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    public boolean isRequestValid() {
        return this.mMapCallback.isGridsInScreen(this.mapTiles, this.datasource);
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected boolean processReceivedDataHeader(int i) {
        if (this.recievedDataSize > 7) {
            if (Convert.getInt(this.recievedDataBuffer, 0) != 0) {
                doCancel();
                return false;
            }
            Convert.moveArray(this.recievedDataBuffer, 8, this.recievedDataBuffer, 0, i - 8);
            this.recievedDataSize -= 8;
            this.nextImgDataLength = 0;
            this.recievedHeader = true;
            if (this.datasource == 0 || this.datasource == 1 || this.datasource == 8 || this.datasource == 7) {
                processReceivedDataV4();
            } else {
                super.processRecivedData();
            }
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected void processRecivedDataByType() {
        if (this.datasource == 0 || this.datasource == 1 || this.datasource == 8 || this.datasource == 7) {
            processReceivedDataV4();
        } else {
            super.processRecivedData();
        }
    }

    void processRecivedModels(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return;
        }
        String str = new String(bArr, i3, b, "utf-8");
        if (!this.mGLMapEngine.isMapEngineValid() || i2 <= i) {
            return;
        }
        boolean z = !this.mMapCallback.isGridInScreen(this.datasource, str);
        this.mGLMapEngine.putMapData(bArr, i, i2 - i, this.datasource, 0);
        if (!z) {
            return;
        }
        doCancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    public void processRecivedTileData(byte[] bArr, int i, int i2) {
        if (i == 0) {
            super.processRecivedTileData(bArr, i, i2);
        } else if (this.datasource == 2 || this.datasource == 3) {
            processRecivedTileDataBmp(bArr, i, i2);
        } else if (this.datasource == 4) {
            processRecivedTileDataVTmc(bArr, i, i2);
        } else if (this.datasource == 6) {
            processRecivedModels(bArr, i, i2);
        } else {
            super.processRecivedTileData(bArr, i, i2);
        }
    }

    void processRecivedTileDataBmp(byte[] bArr, int i, int i2) {
        int i3 = i + 4;
        int i4 = i3 + 1;
        int i5 = bArr[i3];
        String str = (i5 <= 0 || (i4 + i5) + (-1) >= i2) ? "" : new String(bArr, i4, i5, "utf-8");
        int i6 = i4 + i5;
        if (this.mGLMapEngine.isMapEngineValid() && i2 > i) {
            boolean z = !this.mMapCallback.isGridInScreen(this.datasource, str);
            if (this.mGLMapEngine.putMapData(bArr, i, i2 - i, this.datasource, 0)) {
                VMapDataCache.getInstance().putRecoder(null, str, this.datasource);
            }
            if (!z) {
                return;
            }
            doCancel();
        }
    }

    void processRecivedTileDataVTmc(byte[] bArr, int i, int i2) {
        int i3 = i + 4;
        int i4 = i3 + 1;
        int i5 = bArr[i3];
        if (i4 + i5 > bArr.length || i4 > bArr.length - 1 || i5 < 0) {
            return;
        }
        String str = new String(bArr, i4, i5, "utf-8");
        int i6 = i5 + i4;
        int i7 = bArr[i6] + i6 + 1 + 4;
        if (!this.mGLMapEngine.isMapEngineValid()) {
            return;
        }
        VTMCDataCache vTMCDataCache = VTMCDataCache.getInstance();
        if (i2 <= i) {
            return;
        }
        byte[] bArr2 = new byte[i2 - i];
        System.arraycopy(bArr, i, bArr2, 0, i2 - i);
        VTmcData putData = vTMCDataCache.putData(bArr2);
        boolean z = !this.mMapCallback.isGridInScreen(this.datasource, str);
        if (putData != null) {
            this.mGLMapEngine.putMapData(putData.data, 0, putData.data.length, this.datasource, putData.createTime);
        }
        if (!z) {
            return;
        }
        doCancel();
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected void processRecivedVersionOrScenicWidgetData() {
        if (this.datasource == 9) {
            processRecivedVersionData(this.recievedDataBuffer, 0, this.recievedDataSize);
        }
    }
}
