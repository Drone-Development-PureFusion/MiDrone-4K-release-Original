package android.support.p001v4.widget;

import android.view.View;
import android.widget.PopupMenu;
/* renamed from: android.support.v4.widget.PopupMenuCompatKitKat */
/* loaded from: classes.dex */
class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}
