package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class Marker {

    /* renamed from: a */
    private IMarker f3710a;

    public Marker(IMarker iMarker) {
        this.f3710a = iMarker;
    }

    public void destroy() {
        try {
            if (this.f3710a == null) {
                return;
            }
            this.f3710a.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Marker) {
                return this.f3710a.equalsRemote(((Marker) obj).f3710a);
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getAlpha() {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getAlpha();
        }
        return 1.0f;
    }

    public float getAnchorU() {
        return this.f3710a.getAnchorU();
    }

    public float getAnchorV() {
        return this.f3710a.getAnchorV();
    }

    public int getDisplayLevel() {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getDisplayLevel();
        }
        return 5;
    }

    public IPoint getGeoPoint() {
        return this.f3710a.getGeoPoint();
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.f3710a.getIcons();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f3710a.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Object getObject() {
        return this.f3710a.getObject();
    }

    public MarkerOptions getOptions() {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getOptions();
        }
        return null;
    }

    public int getPeriod() {
        try {
            return this.f3710a.getPeriod();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.f3710a.getPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotateAngle() {
        return this.f3710a.getRotateAngle();
    }

    public String getSnippet() {
        try {
            return this.f3710a.getSnippet();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getTitle() {
        try {
            return this.f3710a.getTitle();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        return this.f3710a.getZIndex();
    }

    public int hashCode() {
        return this.f3710a.hashCodeRemote();
    }

    public void hideInfoWindow() {
        try {
            this.f3710a.hideInfoWindow();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isClickable() {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isClickable();
        }
        return false;
    }

    public boolean isDraggable() {
        return this.f3710a.isDraggable();
    }

    public boolean isFlat() {
        return this.f3710a.isFlat();
    }

    public boolean isInfoWindowAutoOverturn() {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isInfoWindowAutoOverturn();
        }
        return false;
    }

    public boolean isInfoWindowEnable() {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isInfoWindowEnable();
        }
        return false;
    }

    public boolean isInfoWindowShown() {
        return this.f3710a.isInfoWindowShown();
    }

    public boolean isPerspective() {
        try {
            return this.f3710a.isPerspective();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f3710a.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.f3710a.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAlpha(float f) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setAlpha(f);
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            this.f3710a.setAnchor(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAnimation(Animation animation) {
        try {
            this.f3710a.setAnimation(animation);
        } catch (Throwable th) {
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f3710a.setAnimationListener(animationListener);
    }

    public void setAutoOverturnInfoWindow(boolean z) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setAutoOverturnInfoWindow(z);
        }
    }

    public void setBelowMaskLayer(boolean z) {
        this.f3710a.setBelowMaskLayer(z);
    }

    public void setClickable(boolean z) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setClickable(z);
        }
    }

    public void setDisplayLevel(int i) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setDisplayLevel(i);
        }
    }

    public void setDraggable(boolean z) {
        try {
            this.f3710a.setDraggable(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFixingPointEnable(boolean z) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setFixingPointEnable(z);
        }
    }

    public void setFlat(boolean z) {
        try {
            this.f3710a.setFlat(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeoPoint(IPoint iPoint) {
        this.f3710a.setGeoPoint(iPoint);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                this.f3710a.setIcon(bitmapDescriptor);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.f3710a.setIcons(arrayList);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setInfoWindowEnable(boolean z) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setInfoWindowEnable(z);
        }
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setMarkerOptions(markerOptions);
        }
    }

    public void setObject(Object obj) {
        this.f3710a.setObject(obj);
    }

    public void setPeriod(int i) {
        try {
            this.f3710a.setPeriod(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPerspective(boolean z) {
        try {
            this.f3710a.setPerspective(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f3710a.setPosition(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPositionByPixels(int i, int i2) {
        this.f3710a.setPositionByPixels(i, i2);
    }

    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    public void setRotateAngle(float f) {
        try {
            this.f3710a.setRotateAngle(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotateAngleNotUpdate(float f) {
        IMarkerAction iMarkerAction = this.f3710a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setRotateAngleNotUpdate(f);
        }
    }

    public void setSnippet(String str) {
        try {
            this.f3710a.setSnippet(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTitle(String str) {
        try {
            this.f3710a.setTitle(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setToTop() {
        try {
            this.f3710a.set2Top();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f3710a.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        this.f3710a.setZIndex(f);
    }

    public void showInfoWindow() {
        try {
            this.f3710a.showInfoWindow();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean startAnimation() {
        return this.f3710a.startAnimation();
    }
}
