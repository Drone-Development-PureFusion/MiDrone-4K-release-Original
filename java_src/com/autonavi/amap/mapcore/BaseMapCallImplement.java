package com.autonavi.amap.mapcore;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public abstract class BaseMapCallImplement implements IBaseMapCallback, IMapCallback {
    private ArrayList<MapSourceGridData> roadReqMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> bldReqMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> regionReqMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> poiReqMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> versionMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> indoorMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> vectmcReqMapGirds = new ArrayList<>();
    private ArrayList<MapSourceGridData> stiReqMapGirds = new ArrayList<>();
    private ArrayList<MapSourceGridData> curRoadMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> curBldMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> curRegionMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> curPoiMapGrids = new ArrayList<>();
    private ArrayList<MapSourceGridData> curVectmcMapGirds = new ArrayList<>();
    private ArrayList<MapSourceGridData> curStiMapGirds = new ArrayList<>();
    private ArrayList<MapSourceGridData> curScreenGirds = new ArrayList<>();
    private ArrayList<MapSourceGridData> curIndoorMapGirds = new ArrayList<>();
    ConnectionManager connectionManager = null;
    TilesProcessingCtrl tileProcessCtrl = null;
    TextTextureGenerator textTextureGenerator = null;
    Object mapGridFillLock = new Object();

    private boolean isGridInList(String str, ArrayList<MapSourceGridData> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getGridName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIndoorGridInList(String str, ArrayList<MapSourceGridData> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getKeyGridName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public byte[] OnMapCharsWidthsRequired(MapCore mapCore, int[] iArr, int i, int i2) {
        if (this.textTextureGenerator == null) {
            this.textTextureGenerator = new TextTextureGenerator();
        }
        return this.textTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void OnMapDataRequired(MapCore mapCore, int i, String[] strArr) {
        ArrayList<MapSourceGridData> reqGridList;
        if (strArr == null || strArr.length == 0 || (reqGridList = getReqGridList(i)) == null) {
            return;
        }
        reqGridList.clear();
        for (String str : strArr) {
            reqGridList.add(new MapSourceGridData(str, i));
        }
        if (i == 5) {
            return;
        }
        proccessRequiredData(mapCore, reqGridList, i);
    }

    public void OnMapDestory(MapCore mapCore) {
        try {
            destoryMap(mapCore);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.IMapCallback
    public void OnMapLabelsRequired(MapCore mapCore, int[] iArr, int i) {
        if (iArr == null || i <= 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            this.textTextureGenerator = new TextTextureGenerator();
            byte[] textPixelBuffer = this.textTextureGenerator.getTextPixelBuffer(i3);
            if (textPixelBuffer != null) {
                mapCore.putCharbitmap(i3, textPixelBuffer);
            }
        }
    }

    public void OnMapProcessEvent(MapCore mapCore) {
    }

    public void OnMapSurfaceCreate(MapCore mapCore) {
    }

    public void OnMapSurfaceRenderer(GL10 gl10, MapCore mapCore, int i) {
        if (i == 11) {
            synchronized (this.mapGridFillLock) {
                mapCore.fillCurGridListWithDataType(this.curPoiMapGrids, 8);
                mapCore.fillCurGridListWithDataType(this.curRoadMapGrids, 0);
                mapCore.fillCurGridListWithDataType(this.curRegionMapGrids, 7);
                mapCore.fillCurGridListWithDataType(this.curBldMapGrids, 1);
                mapCore.fillCurGridListWithDataType(this.curVectmcMapGirds, 4);
                mapCore.fillCurGridListWithDataType(this.curStiMapGirds, 3);
                mapCore.fillCurGridListWithDataType(this.curIndoorMapGirds, 10);
            }
        }
    }

    public synchronized void destoryMap(MapCore mapCore) {
        if (this.connectionManager != null) {
            this.connectionManager.threadFlag = false;
            if (this.connectionManager.isAlive()) {
                this.connectionManager.interrupt();
                this.connectionManager.shutDown();
                this.connectionManager = null;
            }
        }
        if (this.tileProcessCtrl != null) {
            this.tileProcessCtrl.clearAll();
        }
    }

    public ArrayList<MapSourceGridData> getCurGridList(int i) {
        if (i == 0) {
            return this.curRoadMapGrids;
        }
        if (i == 1) {
            return this.curBldMapGrids;
        }
        if (i == 7) {
            return this.curRegionMapGrids;
        }
        if (i == 8) {
            return this.curPoiMapGrids;
        }
        if (i == 4) {
            return this.curVectmcMapGirds;
        }
        if (i == 5) {
            return this.curScreenGirds;
        }
        if (i == 10) {
            return this.curIndoorMapGirds;
        }
        if (i != 3) {
            return null;
        }
        return this.curStiMapGirds;
    }

    public ArrayList<MapSourceGridData> getReqGridList(int i) {
        if (i == 0) {
            return this.roadReqMapGrids;
        }
        if (i == 1) {
            return this.bldReqMapGrids;
        }
        if (i == 7) {
            return this.regionReqMapGrids;
        }
        if (i == 8) {
            return this.poiReqMapGrids;
        }
        if (i == 4) {
            return this.vectmcReqMapGirds;
        }
        if (i == 5) {
            return this.curScreenGirds;
        }
        if (i == 3) {
            return this.stiReqMapGirds;
        }
        if (i == 9) {
            return this.versionMapGrids;
        }
        if (i != 10) {
            return null;
        }
        return this.indoorMapGrids;
    }

    public boolean isGridInScreen(int i, String str) {
        boolean z = false;
        try {
            if (isMapEngineValid()) {
                synchronized (this.mapGridFillLock) {
                    if (isGridInList(str, getCurGridList(i))) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isGridsInScreen(ArrayList<MapSourceGridData> arrayList, int i) {
        try {
            if (arrayList.size() != 0 && isMapEngineValid()) {
                synchronized (this.mapGridFillLock) {
                    ArrayList<MapSourceGridData> curGridList = getCurGridList(i);
                    if (curGridList == null) {
                        return true;
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (isGridInList(arrayList.get(i2).getGridName(), curGridList)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean isIndoorGridInScreen(int i, String str, short s) {
        boolean z = false;
        try {
            if (isMapEngineValid()) {
                synchronized (this.mapGridFillLock) {
                    if (isIndoorGridInList(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((int) s), getCurGridList(i))) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isIndoorGridsInScreen(ArrayList<MapSourceGridData> arrayList, int i) {
        try {
            if (arrayList.size() != 0 && isMapEngineValid()) {
                synchronized (this.mapGridFillLock) {
                    ArrayList<MapSourceGridData> curGridList = getCurGridList(i);
                    if (curGridList == null) {
                        return true;
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (isIndoorGridInList(arrayList.get(i2).getKeyGridName(), curGridList)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public synchronized void newMap(MapCore mapCore) {
        this.connectionManager = new ConnectionManager();
        this.tileProcessCtrl = new TilesProcessingCtrl();
        this.connectionManager.start();
    }

    public synchronized void onPause() {
        try {
            if (this.connectionManager != null) {
                this.connectionManager.threadFlag = false;
                if (this.connectionManager.isAlive()) {
                    this.connectionManager.interrupt();
                    this.connectionManager.shutDown();
                    this.connectionManager = null;
                }
            }
        } finally {
        }
    }

    public synchronized void onResume(MapCore mapCore) {
        try {
            this.connectionManager = new ConnectionManager();
            this.tileProcessCtrl = new TilesProcessingCtrl();
            this.connectionManager.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void proccessRequiredData(MapCore mapCore, ArrayList<MapSourceGridData> arrayList, int i) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            MapSourceGridData mapSourceGridData = arrayList.get(i2);
            if (this.tileProcessCtrl == null || !this.tileProcessCtrl.isProcessing(mapSourceGridData.getKeyGridName())) {
                if (i == 4) {
                    VTMCDataCache vTMCDataCache = VTMCDataCache.getInstance();
                    VTmcData data = vTMCDataCache.getData(mapSourceGridData.getGridName(), true);
                    VTmcData data2 = vTMCDataCache.getData(mapSourceGridData.getGridName(), false);
                    if (data != null) {
                        mapSourceGridData.obj = data.eTag;
                    }
                    if (data2 == null || data2.data == null || data2.data.length <= 0) {
                        arrayList2.add(mapSourceGridData);
                    } else {
                        mapCore.putMapData(data2.data, 0, data2.data.length, i, data2.createTime);
                    }
                } else {
                    try {
                        String str = mapSourceGridData.gridName;
                        if (i == 10) {
                            str = mapSourceGridData.gridName + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mapSourceGridData.mIndoorIndex;
                        }
                        VMapDataRecoder recoder = VMapDataCache.getInstance().getRecoder(str, i);
                        if (recoder == null || recoder.mGridName == null || recoder.mGridName.length() > 0) {
                        }
                        arrayList2.add(mapSourceGridData);
                    } catch (Exception e) {
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            BaseMapLoader indoorMapLoader = i == 10 ? new IndoorMapLoader(mapCore, this, i) : i == 11 ? null : new NormalMapLoader(mapCore, this, i);
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                MapSourceGridData mapSourceGridData2 = (MapSourceGridData) arrayList2.get(i3);
                this.tileProcessCtrl.addProcessingTile(mapSourceGridData2.getKeyGridName());
                indoorMapLoader.addReuqestTiles(mapSourceGridData2);
            }
            if (this.connectionManager == null) {
                return;
            }
            this.connectionManager.insertConntionTask(indoorMapLoader);
        }
    }
}
