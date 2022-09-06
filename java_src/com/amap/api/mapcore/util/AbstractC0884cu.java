package com.amap.api.mapcore.util;

import android.graphics.Rect;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.cu */
/* loaded from: classes.dex */
public interface AbstractC0884cu extends IOverlayImage {
    /* renamed from: a */
    void mo18568a(GL10 gl10, AbstractC1115l abstractC1115l);

    IMarkerAction getIMarkerAction();

    /* renamed from: h */
    Rect mo18563h();

    /* renamed from: i */
    boolean mo18562i();

    boolean isInfoWindowShown();

    /* renamed from: j */
    boolean mo18561j();

    /* renamed from: k */
    boolean mo18560k();

    /* renamed from: l */
    void mo18559l();

    /* renamed from: m */
    boolean mo18558m();
}
