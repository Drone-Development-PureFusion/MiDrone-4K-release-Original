package com.baidu.tts.aop.tts;

import android.content.Context;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1710m;
import com.baidu.tts.p104i.AbstractC1724b;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.p108l.C1746j;
/* loaded from: classes.dex */
public interface ITts extends AbstractC1724b {
    AuthInfo auth(EnumC1710m enumC1710m);

    int freeCustomResource(C1741e c1741e);

    EnumC1710m getMode();

    TtsListener getTtsListener();

    C1746j getTtsParams();

    int loadCustomResource(C1741e c1741e);

    int loadEnglishModel(C1742f c1742f);

    int loadModel(C1743g c1743g);

    int setAudioStreamType(int i);

    void setContext(Context context);

    void setMode(EnumC1710m enumC1710m);

    int setParam(EnumC1704g enumC1704g, String str);

    int setStereoVolume(float f, float f2);

    void setTtsListener(TtsListener ttsListener);

    void speak(C1745i c1745i);

    void synthesize(C1745i c1745i);
}
