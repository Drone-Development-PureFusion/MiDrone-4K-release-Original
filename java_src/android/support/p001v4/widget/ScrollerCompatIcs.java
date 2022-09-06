package android.support.p001v4.widget;

import android.widget.OverScroller;
/* renamed from: android.support.v4.widget.ScrollerCompatIcs */
/* loaded from: classes.dex */
class ScrollerCompatIcs {
    ScrollerCompatIcs() {
    }

    public static float getCurrVelocity(Object obj) {
        return ((OverScroller) obj).getCurrVelocity();
    }
}
