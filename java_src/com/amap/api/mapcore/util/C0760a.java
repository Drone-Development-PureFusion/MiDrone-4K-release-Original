package com.amap.api.mapcore.util;

import android.content.Context;
import com.autonavi.amap.mapcore.BaseMapCallImplement;
import com.autonavi.amap.mapcore.Convert;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapSourceGridData;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.mapcore.util.a */
/* loaded from: classes.dex */
public class C0760a extends BaseMapCallImplement {

    /* renamed from: a */
    private C0802b f2011a;

    public C0760a(C0802b c0802b) {
        this.f2011a = c0802b;
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void OnMapDestory(GL10 gl10, MapCore mapCore) {
        super.OnMapDestory(mapCore);
    }

    @Override // com.autonavi.amap.mapcore.IBaseMapCallback
    public void OnMapLoaderError(int i) {
    }

    @Override // com.autonavi.amap.mapcore.BaseMapCallImplement, com.autonavi.amap.mapcore.IMapCallback
    public void OnMapProcessEvent(MapCore mapCore) {
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void OnMapReferencechanged(MapCore mapCore, String str, String str2) {
        this.f2011a.m18899s();
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void OnMapSufaceChanged(GL10 gl10, MapCore mapCore, int i, int i2) {
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void OnMapSurfaceCreate(GL10 gl10, MapCore mapCore) {
        super.OnMapSurfaceCreate(mapCore);
    }

    @Override // com.autonavi.amap.mapcore.BaseMapCallImplement, com.autonavi.amap.mapcore.IMapCallback
    public void OnMapSurfaceRenderer(GL10 gl10, MapCore mapCore, int i) {
        super.OnMapSurfaceRenderer(gl10, mapCore, i);
        if (i == 3) {
            this.f2011a.m18910j();
            this.f2011a.f2247b.m17625a(gl10, true, this.f2011a.getMapTextZIndex());
            if (this.f2011a.f2260o == null) {
                return;
            }
            this.f2011a.f2260o.onDrawFrame(gl10);
        }
    }

    @Override // com.autonavi.amap.mapcore.IBaseMapCallback
    public Context getContext() {
        return this.f2011a.m18897t();
    }

    @Override // com.autonavi.amap.mapcore.IBaseMapCallback
    public String getMapSvrAddress() {
        return "http://mps.amap.com";
    }

    @Override // com.autonavi.amap.mapcore.IBaseMapCallback
    public boolean isMapEngineValid() {
        if (this.f2011a.mo17557a() != null) {
            return this.f2011a.mo17557a().isMapEngineValid();
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void onIndoorBuildingActivity(MapCore mapCore, byte[] bArr) {
        int i;
        C0784aq c0784aq = null;
        if (bArr != null) {
            try {
                C0784aq c0784aq2 = new C0784aq();
                byte b = bArr[0];
                c0784aq2.f2117a = new String(bArr, 1, b, "utf-8");
                int i2 = b + 1;
                int i3 = i2 + 1;
                byte b2 = bArr[i2];
                c0784aq2.f2118b = new String(bArr, i3, b2, "utf-8");
                int i4 = b2 + i3;
                int i5 = i4 + 1;
                byte b3 = bArr[i4];
                c0784aq2.activeFloorName = new String(bArr, i5, b3, "utf-8");
                int i6 = b3 + i5;
                c0784aq2.activeFloorIndex = Convert.getInt(bArr, i6);
                int i7 = i6 + 4;
                int i8 = i7 + 1;
                byte b4 = bArr[i7];
                c0784aq2.poiid = new String(bArr, i8, b4, "utf-8");
                int i9 = b4 + i8;
                c0784aq2.f2119c = Convert.getInt(bArr, i9);
                int i10 = i9 + 4;
                c0784aq2.floor_indexs = new int[c0784aq2.f2119c];
                c0784aq2.floor_names = new String[c0784aq2.f2119c];
                c0784aq2.f2120d = new String[c0784aq2.f2119c];
                for (int i11 = 0; i11 < c0784aq2.f2119c; i11++) {
                    c0784aq2.floor_indexs[i11] = Convert.getInt(bArr, i10);
                    int i12 = i10 + 4;
                    int i13 = i12 + 1;
                    byte b5 = bArr[i12];
                    if (b5 > 0) {
                        c0784aq2.floor_names[i11] = new String(bArr, i13, b5, "utf-8");
                        i = i13 + b5;
                    } else {
                        i = i13;
                    }
                    i10 = i + 1;
                    byte b6 = bArr[i];
                    if (b6 > 0) {
                        c0784aq2.f2120d[i11] = new String(bArr, i10, b6, "utf-8");
                        i10 += b6;
                    }
                }
                c0784aq2.f2121e = Convert.getInt(bArr, i10);
                int i14 = i10 + 4;
                if (c0784aq2.f2121e > 0) {
                    c0784aq2.f2122f = new int[c0784aq2.f2121e];
                    int i15 = i14;
                    for (int i16 = 0; i16 < c0784aq2.f2121e; i16++) {
                        c0784aq2.f2122f[i16] = Convert.getInt(bArr, i15);
                        i15 += 4;
                    }
                }
                c0784aq = c0784aq2;
            } catch (Throwable th) {
                th.printStackTrace();
                C1007fo.m18012b(th, "AMapCallback", "onIndoorBuildingActivity");
                return;
            }
        }
        this.f2011a.m18952a(c0784aq);
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void onIndoorDataRequired(MapCore mapCore, int i, String[] strArr, int[] iArr, int[] iArr2) {
        ArrayList<MapSourceGridData> reqGridList;
        if (strArr == null || strArr.length == 0 || (reqGridList = getReqGridList(i)) == null) {
            return;
        }
        reqGridList.clear();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            reqGridList.add(new MapSourceGridData(strArr[i2], i, iArr[i2], iArr2[i2]));
        }
        if (i == 5) {
            return;
        }
        proccessRequiredData(mapCore, reqGridList, i);
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void requestRender() {
        this.f2011a.setRunLowFrame(false);
    }
}
