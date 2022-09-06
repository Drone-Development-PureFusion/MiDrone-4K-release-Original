package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.SwipeDismissTouchListener;
/* loaded from: classes.dex */
public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a */
    SwipeDismissView f3603a;

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.f3603a = swipeDismissView;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        if (this.f3603a.onDismissCallback != null) {
            this.f3603a.onDismissCallback.onDismiss();
        }
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        if (this.f3603a.onDismissCallback != null) {
            this.f3603a.onDismissCallback.onNotifySwipe();
        }
    }
}
