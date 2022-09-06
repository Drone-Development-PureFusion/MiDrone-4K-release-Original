package cn.sharesdk.framework;

import java.util.HashMap;
/* loaded from: classes.dex */
public interface PlatformActionListener {
    void onCancel(Platform platform, int i);

    void onComplete(Platform platform, int i, HashMap<String, Object> hashMap);

    void onError(Platform platform, int i, Throwable th);
}
