package com.fimi.soul.base;
/* loaded from: classes.dex */
public class LoadKey {
    static {
        System.loadLibrary("key-service-jni");
    }

    public static native String getKeyToken();
}
