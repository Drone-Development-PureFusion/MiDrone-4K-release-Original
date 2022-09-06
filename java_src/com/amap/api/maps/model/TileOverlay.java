package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
/* loaded from: classes.dex */
public final class TileOverlay {

    /* renamed from: a */
    private ITileOverlay f3804a;

    public TileOverlay(ITileOverlay iTileOverlay) {
        this.f3804a = iTileOverlay;
    }

    public void clearTileCache() {
        this.f3804a.clearTileCache();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        return this.f3804a.equalsRemote(((TileOverlay) obj).f3804a);
    }

    public String getId() {
        return this.f3804a.getId();
    }

    public float getZIndex() {
        return this.f3804a.getZIndex();
    }

    public int hashCode() {
        return this.f3804a.hashCodeRemote();
    }

    public boolean isVisible() {
        return this.f3804a.isVisible();
    }

    public void remove() {
        this.f3804a.remove();
    }

    public void setVisible(boolean z) {
        this.f3804a.setVisible(z);
    }

    public void setZIndex(float f) {
        this.f3804a.setZIndex(f);
    }
}
