package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IText;
/* loaded from: classes.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* renamed from: a */
    private IText f3789a;

    public Text(IText iText) {
        this.f3789a = iText;
    }

    public void destroy() {
        try {
            if (this.f3789a == null) {
                return;
            }
            this.f3789a.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Text) {
                return this.f3789a.equalsRemote(((Text) obj).f3789a);
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getAlignX() {
        try {
            return this.f3789a.getAlignX();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getAlignY() {
        try {
            return this.f3789a.getAlignY();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getBackgroundColor() {
        try {
            return this.f3789a.getBackgroundColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFontColor() {
        try {
            return this.f3789a.getFontColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFontSize() {
        try {
            return this.f3789a.getFontSize();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f3789a.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Object getObject() {
        return this.f3789a.getObject();
    }

    public LatLng getPosition() {
        try {
            return this.f3789a.getPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotate() {
        return this.f3789a.getRotateAngle();
    }

    public String getText() {
        try {
            return this.f3789a.getText();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Typeface getTypeface() {
        try {
            return this.f3789a.getTypeface();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        return this.f3789a.getZIndex();
    }

    public int hashCode() {
        return this.f3789a.hashCodeRemote();
    }

    public boolean isVisible() {
        try {
            return this.f3789a.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.f3789a.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAlign(int i, int i2) {
        try {
            this.f3789a.setAlign(i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setBackgroundColor(int i) {
        try {
            this.f3789a.setBackgroundColor(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFontColor(int i) {
        try {
            this.f3789a.setFontColor(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFontSize(int i) {
        try {
            this.f3789a.setFontSize(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setObject(Object obj) {
        this.f3789a.setObject(obj);
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f3789a.setPosition(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotate(float f) {
        try {
            this.f3789a.setRotateAngle(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setText(String str) {
        try {
            this.f3789a.setText(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTypeface(Typeface typeface) {
        try {
            this.f3789a.setTypeface(typeface);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f3789a.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        this.f3789a.setZIndex(f);
    }
}
