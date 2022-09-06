package android.support.p001v4.p003os;

import android.os.Environment;
import java.io.File;
/* renamed from: android.support.v4.os.EnvironmentCompatKitKat */
/* loaded from: classes.dex */
class EnvironmentCompatKitKat {
    EnvironmentCompatKitKat() {
    }

    public static String getStorageState(File file) {
        return Environment.getStorageState(file);
    }
}
