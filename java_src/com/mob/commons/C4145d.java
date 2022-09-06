package com.mob.commons;

import com.mob.tools.MobLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;
/* renamed from: com.mob.commons.d */
/* loaded from: classes.dex */
public class C4145d {
    /* renamed from: a */
    public static final void m6037a(File file, LockAction lockAction) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileLocker fileLocker = new FileLocker();
            fileLocker.setLockFile(file.getAbsolutePath());
            if (!fileLocker.lock(true) || lockAction.run(fileLocker)) {
                return;
            }
            fileLocker.release();
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }
}
