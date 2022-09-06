package com.amap.api.maps.model;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IPolyline;
import java.util.List;
/* loaded from: classes.dex */
public class Polyline {

    /* renamed from: a */
    private final IPolyline f3766a;

    public Polyline(IPolyline iPolyline) {
        this.f3766a = iPolyline;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f3766a.equalsRemote(((Polyline) obj).f3766a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getColor() {
        try {
            return this.f3766a.getColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f3766a.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getNearestLatLng(LatLng latLng) {
        return this.f3766a.getNearestLatLng(latLng);
    }

    public PolylineOptions getOptions() {
        return this.f3766a.getOptions();
    }

    public List<LatLng> getPoints() {
        try {
            return this.f3766a.getPoints();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.f3766a.getWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f3766a.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f3766a.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDottedLine() {
        return this.f3766a.isDottedLine();
    }

    public boolean isGeodesic() {
        return this.f3766a.isGeodesic();
    }

    public boolean isVisible() {
        try {
            return this.f3766a.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.f3766a.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAboveMaskLayer(boolean z) {
        this.f3766a.setAboveMaskLayer(z);
    }

    public void setColor(int i) {
        try {
            this.f3766a.setColor(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.f3766a.setCustomTexture(bitmapDescriptor);
    }

    public void setDottedLine(boolean z) {
        this.f3766a.setDottedLine(z);
    }

    public void setGeodesic(boolean z) {
        try {
            if (this.f3766a.isGeodesic() == z) {
                return;
            }
            List<LatLng> points = getPoints();
            this.f3766a.setGeodesic(z);
            setPoints(points);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setOptions(PolylineOptions polylineOptions) {
        this.f3766a.setOptions(polylineOptions);
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f3766a.setPoints(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTransparency(float f) {
        this.f3766a.setTransparency(f);
    }

    public void setVisible(boolean z) {
        try {
            this.f3766a.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float f) {
        try {
            this.f3766a.setWidth(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f3766a.setZIndex(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
