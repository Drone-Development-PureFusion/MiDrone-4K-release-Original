package com.tencent.open.weiyun;

import com.tencent.tauth.UiError;
import java.util.List;
/* loaded from: classes2.dex */
public interface IGetFileListListener {
    void onComplete(List<WeiyunFile> list);

    void onError(UiError uiError);
}
