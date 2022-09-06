package android.support.p001v4.view;

import android.view.VelocityTracker;
/* renamed from: android.support.v4.view.VelocityTrackerCompatHoneycomb */
/* loaded from: classes.dex */
class VelocityTrackerCompatHoneycomb {
    VelocityTrackerCompatHoneycomb() {
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
