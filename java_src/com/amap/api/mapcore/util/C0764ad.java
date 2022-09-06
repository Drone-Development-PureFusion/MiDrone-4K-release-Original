package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.ad */
/* loaded from: classes.dex */
public class C0764ad extends AbstractC0766af {
    @Override // com.autonavi.amap.mapcore.MapMessage
    public void mergeCameraUpdateDelegate(MapMessage mapMessage) {
        mapMessage.geoPoint = this.geoPoint == null ? mapMessage.geoPoint : this.geoPoint;
        mapMessage.zoom = Float.isNaN(this.zoom) ? mapMessage.zoom : this.zoom;
        mapMessage.bearing = Float.isNaN(this.bearing) ? mapMessage.bearing : this.bearing;
        mapMessage.tilt = Float.isNaN(this.tilt) ? mapMessage.tilt : this.tilt;
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        a(mapProjection);
    }
}
