package android.support.p001v4.widget;

import android.view.View;
import android.widget.ListPopupWindow;
/* renamed from: android.support.v4.widget.ListPopupWindowCompatKitKat */
/* loaded from: classes.dex */
class ListPopupWindowCompatKitKat {
    ListPopupWindowCompatKitKat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object obj, View view) {
        return ((ListPopupWindow) obj).createDragToOpenListener(view);
    }
}
