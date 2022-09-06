package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.ADGLAnimation;
import com.autonavi.amap.mapcore.ADGLMapAnimGroup;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.ab */
/* loaded from: classes.dex */
public class C0762ab {

    /* renamed from: a */
    private List<ADGLAnimation> f2022a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    public synchronized void m19115a() {
        this.f2022a.clear();
    }

    /* renamed from: a */
    public void m19114a(ADGLAnimation aDGLAnimation) {
        ADGLAnimation aDGLAnimation2;
        if (aDGLAnimation == null) {
            return;
        }
        synchronized (this.f2022a) {
            if (!aDGLAnimation.isOver() && this.f2022a.size() > 0 && (aDGLAnimation2 = this.f2022a.get(this.f2022a.size() - 1)) != null && (aDGLAnimation instanceof ADGLMapAnimGroup) && (aDGLAnimation2 instanceof ADGLMapAnimGroup) && ((ADGLMapAnimGroup) aDGLAnimation).typeEqueal((ADGLMapAnimGroup) aDGLAnimation2) && !((ADGLMapAnimGroup) aDGLAnimation)._needMove) {
                this.f2022a.remove(aDGLAnimation2);
            }
            this.f2022a.add(aDGLAnimation);
        }
    }

    /* renamed from: a */
    public synchronized void m19113a(MapProjection mapProjection) {
        ADGLAnimation aDGLAnimation;
        if (mapProjection != null) {
            if (this.f2022a.size() > 0 && (aDGLAnimation = this.f2022a.get(0)) != null) {
                if (aDGLAnimation.isOver()) {
                    this.f2022a.remove(aDGLAnimation);
                } else {
                    aDGLAnimation.doAnimation(mapProjection);
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized int m19112b() {
        return this.f2022a.size();
    }
}
