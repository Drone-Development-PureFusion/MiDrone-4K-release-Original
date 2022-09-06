package com.autonavi.amap.mapcore;

import java.util.Hashtable;
/* loaded from: classes.dex */
class TilesProcessingCtrl {
    long lastInsertTime;
    private Hashtable<String, ProcessingTile> processingTiles = new Hashtable<>();
    int requiresize = 0;
    boolean threadFlag = true;

    public TilesProcessingCtrl() {
        updateLastInsertTime();
    }

    public void addProcessingTile(String str) {
        this.processingTiles.put(str, new ProcessingTile(str, 0));
    }

    public void clearAll() {
        this.processingTiles.clear();
    }

    public int getSize() {
        return this.processingTiles.size();
    }

    public boolean isProcessing(String str) {
        return this.processingTiles.get(str) != null;
    }

    public void removeTile(String str) {
        this.processingTiles.remove(str);
    }

    public void updateLastInsertTime() {
        this.lastInsertTime = System.currentTimeMillis();
    }
}
