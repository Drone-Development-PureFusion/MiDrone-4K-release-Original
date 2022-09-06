package android.support.p001v4.app;

import android.app.Activity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* renamed from: android.support.v4.app.ActivityCompatHoneycomb */
/* loaded from: classes.dex */
class ActivityCompatHoneycomb {
    ActivityCompatHoneycomb() {
    }

    static void dump(Activity activity, String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        activity.dump(str, fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }
}
