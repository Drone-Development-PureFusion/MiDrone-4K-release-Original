package android.support.p001v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;
/* renamed from: android.support.v4.content.ContextCompatHoneycomb */
/* loaded from: classes.dex */
class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startActivities(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }
}
