package com.tencent.open.weiyun;

import com.tencent.tauth.UiError;
/* loaded from: classes2.dex */
public interface IDownLoadFileCallBack {
    void onDownloadProgress(int i);

    void onDownloadStart();

    void onDownloadSuccess(String str);

    void onError(UiError uiError);

    void onPrepareStart();
}
