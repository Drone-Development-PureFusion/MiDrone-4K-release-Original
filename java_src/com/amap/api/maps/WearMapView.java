package com.amap.api.maps;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.mapcore.util.C1119p;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
@TargetApi(20)
/* loaded from: classes.dex */
public class WearMapView extends ViewGroup {

    /* renamed from: f */
    private static int f3634f = 0;

    /* renamed from: g */
    private static int f3635g = 0;

    /* renamed from: a */
    private final String f3636a;

    /* renamed from: b */
    private IMapFragmentDelegate f3637b;

    /* renamed from: c */
    private AMap f3638c;

    /* renamed from: d */
    private View f3639d;

    /* renamed from: e */
    private SwipeDismissView f3640e;

    /* renamed from: h */
    private int f3641h;

    /* loaded from: classes.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    public WearMapView(Context context) {
        super(context);
        this.f3636a = WearMapView.class.getSimpleName();
        this.f3641h = 0;
        getMapFragmentDelegate().setContext(context);
        m17418a(context);
        m17416b(context);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3636a = WearMapView.class.getSimpleName();
        this.f3641h = 0;
        this.f3641h = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.f3641h);
        m17418a(context);
        m17416b(context);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3636a = WearMapView.class.getSimpleName();
        this.f3641h = 0;
        this.f3641h = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.f3641h);
        m17418a(context);
        m17416b(context);
    }

    public WearMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.f3636a = WearMapView.class.getSimpleName();
        this.f3641h = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
        m17418a(context);
        m17416b(context);
    }

    /* renamed from: a */
    private void m17418a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        f3634f = point.x;
        f3635g = point.y;
    }

    /* renamed from: a */
    private void m17417a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        int makeMeasureSpec = i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(makeMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* renamed from: b */
    private void m17416b(Context context) {
        this.f3640e = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f), f3635g);
        this.f3640e.setBackgroundColor(Color.argb(0, 0, 0, 0));
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        addView(this.f3640e, layoutParams);
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.f3638c == null) {
                this.f3638c = new AMap(map);
            }
            return this.f3638c;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.f3637b == null) {
            this.f3637b = new C1119p(1);
        }
        return this.f3637b;
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.f3639d = getMapFragmentDelegate().onCreateView(null, null, bundle);
            addView(this.f3639d, 0, new ViewGroup.LayoutParams(-1, -1));
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

    public void onDismiss() {
        removeAllViews();
    }

    public void onEnterAmbient(Bundle bundle) {
        onResume();
    }

    public void onExitAmbient() {
        onPause();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt == this.f3639d) {
                childAt.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.f3640e) {
                m17417a(this.f3640e);
                this.f3640e.layout(0, 0, this.f3640e.getMeasuredWidth(), i3);
            }
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof SwipeDismissView) {
                SwipeDismissView swipeDismissView = (SwipeDismissView) childAt;
                childAt.measure(swipeDismissView.getLayoutParams().width, swipeDismissView.getLayoutParams().height);
            } else {
                childAt.measure(i, i2);
            }
        }
        super.onMeasure(i, i2);
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
    public void setLayerType(int i, Paint paint) {
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        if (this.f3640e != null) {
            this.f3640e.setCallback(onDismissCallback);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().setVisibility(i);
    }
}
