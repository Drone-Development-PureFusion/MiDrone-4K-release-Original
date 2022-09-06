package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.p108l.C1744h;
/* loaded from: classes.dex */
public interface TtsListener {
    void onError(C1744h c1744h);

    void onPlayFinished(C1744h c1744h);

    void onPlayProgressUpdate(C1744h c1744h);

    void onPlayStart(C1744h c1744h);

    void onSynthesizeDataArrived(C1744h c1744h);

    void onSynthesizeFinished(C1744h c1744h);

    void onSynthesizeStart(C1744h c1744h);
}
