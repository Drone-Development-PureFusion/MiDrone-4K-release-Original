package com.tencent.tauth;
/* loaded from: classes.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);
}
