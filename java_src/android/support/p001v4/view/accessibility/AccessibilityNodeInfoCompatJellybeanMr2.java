package android.support.p001v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2 */
/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatJellybeanMr2 {
    AccessibilityNodeInfoCompatJellybeanMr2() {
    }

    public static String getViewIdResourceName(Object obj) {
        return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
    }

    public static void setViewIdResourceName(Object obj, String str) {
        ((AccessibilityNodeInfo) obj).setViewIdResourceName(str);
    }
}
