package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.p110n.p111a.C1771c;
import com.baidu.tts.tools.ResourceTools;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ArgsCheckInterceptor extends AInterceptor {
    /* renamed from: a */
    private Object m15335a(Object obj, C1745i c1745i, EnumC1711n enumC1711n) {
        C1744h m14749b = C1744h.m14749b(c1745i);
        m14749b.m14759a(C1717c.m14880a().m14873b(enumC1711n));
        m15336a(obj, m14749b);
        return AInterceptorHandler.END;
    }

    /* renamed from: a */
    private void m15336a(Object obj, C1744h c1744h) {
        TtsListener ttsListener = ((C1771c) obj).getTtsListener();
        if (ttsListener != null) {
            ttsListener.onError(c1744h);
        }
    }

    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected Object mo15331a(Object obj, Method method, Object[] objArr) {
        C1745i c1745i = (C1745i) objArr[0];
        String m14737c = c1745i.m14737c();
        LoggerProxy.m15091d("ArgsCheckInterceptor", "text=" + m14737c);
        return ResourceTools.isTextValid(m14737c) == null ? AInterceptorHandler.DEFAULT : m15335a(obj, c1745i, EnumC1711n.TEXT_IS_TOO_LONG);
    }

    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected void mo15332a() {
        this.f5663a.add("speak");
        this.f5663a.add("synthesize");
    }
}
