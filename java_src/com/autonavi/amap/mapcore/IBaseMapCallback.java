package com.autonavi.amap.mapcore;

import android.content.Context;
/* loaded from: classes.dex */
public interface IBaseMapCallback {
    void OnMapLoaderError(int i);

    Context getContext();

    String getMapSvrAddress();

    boolean isMapEngineValid();
}
