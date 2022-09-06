package com.tencent.p227mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;
/* renamed from: com.tencent.mm.sdk.platformtools.MMEntryLock */
/* loaded from: classes.dex */
public final class MMEntryLock {

    /* renamed from: aF */
    private static Set<String> f17834aF = new HashSet();

    private MMEntryLock() {
    }

    public static boolean isLocked(String str) {
        return f17834aF.contains(str);
    }

    public static boolean lock(String str) {
        if (isLocked(str)) {
            Log.m5649d("MicroMsg.MMEntryLock", "locked-" + str);
            return false;
        }
        Log.m5649d("MicroMsg.MMEntryLock", "lock-" + str);
        return f17834aF.add(str);
    }

    public static void unlock(String str) {
        f17834aF.remove(str);
        Log.m5649d("MicroMsg.MMEntryLock", "unlock-" + str);
    }
}
