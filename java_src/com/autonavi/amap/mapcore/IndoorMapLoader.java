package com.autonavi.amap.mapcore;

import android.text.TextUtils;
import com.amap.api.mapcore.util.C0976ey;
import com.amap.api.mapcore.util.C0986fb;
import com.amap.api.mapcore.util.C0999fi;
import com.amap.api.mapcore.util.C1022g;
import com.xiaomi.mipush.sdk.Constants;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public class IndoorMapLoader extends BaseMapLoader {
    private static final String IndoorSignKey = "@1071a2a4e3gte2Uc32cY3a98Tf33H1c4Gc23f";
    private String mIndoorChannel = "amap7";

    public IndoorMapLoader(MapCore mapCore, BaseMapCallImplement baseMapCallImplement, int i) {
        this.datasource = i;
        this.mGLMapEngine = mapCore;
        this.mMapCallback = baseMapCallImplement;
        this.createtime = System.currentTimeMillis();
    }

    private String assScodeToParma(StringBuffer stringBuffer) {
        String m18038d = C0999fi.m18038d(stringBuffer.toString());
        String m18151a = C0986fb.m18151a();
        stringBuffer.append("&ts=" + m18151a + "&");
        stringBuffer.append("scode=" + C0986fb.m18146a(this.mMapCallback.getContext(), m18151a, m18038d));
        return stringBuffer.toString();
    }

    private String getIndoorMD5Params(String str) {
        return Md5Utility.getStringMD5(this.mIndoorChannel + str + IndoorSignKey).toUpperCase();
    }

    private String getIndoorRequestParams() {
        String str;
        String str2 = null;
        int i = 0;
        String str3 = null;
        String str4 = null;
        while (i < this.mapTiles.size()) {
            String gridName = this.mapTiles.get(i).getGridName();
            int i2 = this.mapTiles.get(i).mIndoorIndex;
            int i3 = this.mapTiles.get(i).mIndoorVersion;
            if (gridName == null || gridName.length() == 0 || containllegal(gridName)) {
                str = str2;
            } else if (!isAssic(gridName)) {
                str = str2;
            } else {
                str4 = str4 == null ? gridName + ";" : str4 + gridName + ";";
                str3 = str3 == null ? i2 + ";" : str3 + i2 + ";";
                str = str2 == null ? i3 + ";" : str2 + i3 + ";";
            }
            i++;
            str4 = str4;
            str3 = str3;
            str2 = str;
        }
        if (!TextUtils.isEmpty(str4) && (str4.endsWith(";") || str4.endsWith(" "))) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        if (!TextUtils.isEmpty(str3) && (str3.endsWith(";") || str3.endsWith(" "))) {
            str3 = str3.substring(0, str3.length() - 1);
        }
        if (!TextUtils.isEmpty(str2) && (str2.endsWith(";") || str2.endsWith(" "))) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("poiid=").append(str4).append("&").append("floor=").append(str3).append("&").append("version=").append(str2).append("&").append("diver=").append(C1022g.f3203e).append("&").append("servicetype=unify").append("&").append("zoomlevel=").append((int) this.mGLMapEngine.getMapstate().getMapZoomer()).append("&").append("key=").append(C0976ey.m18166f(this.mMapCallback.getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return assScodeToParma(stringBuffer);
    }

    public static int getInt2(byte[] bArr, int i) {
        return ((bArr[i + 0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) + ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) + ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) + ((bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 0);
    }

    public static short getShort2(byte[] bArr, int i) {
        return (short) (((bArr[i + 0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) + ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 0));
    }

    private void processReceivedIndoorData() {
        if (this.nextImgDataLength == 0) {
            if (this.recievedDataSize < 6) {
                return;
            }
            this.nextImgDataLength = getInt2(this.recievedDataBuffer, 0);
            processReceivedIndoorData();
        } else if (this.recievedDataSize < this.nextImgDataLength) {
        } else {
            processReceivedTileDataV4(this.recievedDataBuffer, 0, this.nextImgDataLength);
            Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
            this.recievedDataSize -= this.nextImgDataLength;
            this.nextImgDataLength = 0;
            processReceivedIndoorData();
        }
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected String getGridParma() {
        return getIndoorRequestParams();
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected String getMapAddress() {
        return "http://restapi.amap.com/v3/indoor/indoormaps";
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected String getMapSvrPath() {
        switch (this.datasource) {
            case 10:
                return C0228a.f351a;
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
        return this.mMapCallback.isIndoorGridsInScreen(this.mapTiles, this.datasource);
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected boolean processReceivedDataHeader(int i) {
        if (this.recievedDataSize > 5) {
            Convert.moveArray(this.recievedDataBuffer, 6, this.recievedDataBuffer, 0, i - 6);
            this.recievedDataSize -= 6;
            this.nextImgDataLength = 0;
            this.recievedHeader = true;
            processReceivedIndoorData();
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected void processReceivedTileDataV4(byte[] bArr, int i, int i2) {
        int i3 = i + 4;
        int i4 = i3 + 1;
        int i5 = bArr[i3];
        if (i5 > 10) {
            return;
        }
        String str = (i5 <= 0 || (i4 + i5) + (-1) >= i2) ? "" : new String(bArr, i4, i5, "utf-8");
        int i6 = i4 + i5;
        if (!this.mGLMapEngine.isMapEngineValid() || i2 <= i3) {
            return;
        }
        short short2 = getShort2(bArr, i6);
        boolean z = !this.mMapCallback.isIndoorGridInScreen(this.datasource, str, short2);
        if (this.mGLMapEngine.putMapData(bArr, i3, i2 - i3, this.datasource, 0)) {
            VMapDataCache.getInstance().putRecoder(null, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((int) short2), this.datasource);
        }
        if (!z) {
            return;
        }
        doCancel();
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected void processRecivedDataByType() {
        processReceivedIndoorData();
    }

    @Override // com.autonavi.amap.mapcore.BaseMapLoader
    protected void processRecivedVersionOrScenicWidgetData() {
        if (this.datasource == 9) {
            processRecivedVersionData(this.recievedDataBuffer, 0, this.recievedDataSize);
        }
    }
}
