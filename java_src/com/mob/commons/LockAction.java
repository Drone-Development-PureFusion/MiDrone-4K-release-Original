package com.mob.commons;

import com.mob.tools.utils.FileLocker;
/* loaded from: classes.dex */
public interface LockAction {
    boolean run(FileLocker fileLocker);
}
