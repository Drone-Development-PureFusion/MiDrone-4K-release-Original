package com.amap.api.mapcore.util;

import android.opengl.GLSurfaceView;
/* renamed from: com.amap.api.mapcore.util.m */
/* loaded from: classes.dex */
public interface AbstractC1116m {
    int getHeight();

    int getWidth();

    boolean isEnabled();

    void queueEvent(Runnable runnable);

    void requestRender();

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i);

    void setZOrderOnTop(boolean z);
}
