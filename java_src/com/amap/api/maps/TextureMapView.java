package com.amap.api.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C1032gj;
import com.amap.api.mapcore.util.C1119p;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
/* loaded from: classes.dex */
public class TextureMapView extends FrameLayout {

    /* renamed from: a */
    private IMapFragmentDelegate f3628a;

    /* renamed from: b */
    private AMap f3629b;

    /* renamed from: c */
    private int f3630c;

    public TextureMapView(Context context) {
        super(context);
        this.f3630c = 0;
        getMapFragmentDelegate().setContext(context);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3630c = 0;
        this.f3630c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.f3630c);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3630c = 0;
        this.f3630c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.f3630c);
    }

    public TextureMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.f3630c = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.f3629b == null) {
                this.f3629b = new AMap(map);
            }
            return this.f3629b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.f3628a == null) {
            try {
                this.f3628a = (IMapFragmentDelegate) C1032gj.m17904a(getContext(), C0945eh.m18310e(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", C1119p.class, new Class[]{Integer.TYPE}, new Object[]{0});
            } catch (Throwable th) {
            }
            if (this.f3628a == null) {
                this.f3628a = new C1119p(1);
            }
        }
        return this.f3628a;
    }

    public final void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().setVisibility(i);
    }
}
