package android.support.p001v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
/* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompatJellyBean */
/* loaded from: classes.dex */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void setSource(Object obj, View view, int i) {
        ((AccessibilityRecord) obj).setSource(view, i);
    }
}
