package android.support.p001v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat */
/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatKitKat {
    AccessibilityNodeInfoCompatKitKat() {
    }

    public static int getLiveRegion(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLiveRegion();
    }

    public static void setLiveRegion(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setLiveRegion(i);
    }
}
