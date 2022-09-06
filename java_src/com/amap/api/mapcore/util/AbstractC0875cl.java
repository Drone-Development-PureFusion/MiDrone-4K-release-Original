package com.amap.api.mapcore.util;

import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.cl */
/* loaded from: classes.dex */
public abstract class AbstractC0875cl {

    /* renamed from: a */
    private AbstractC1115l f2442a;

    public void destroy() {
        if (this.f2442a != null) {
        }
    }

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);
}
