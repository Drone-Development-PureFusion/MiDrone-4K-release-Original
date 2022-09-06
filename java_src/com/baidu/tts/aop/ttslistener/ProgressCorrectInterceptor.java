package com.baidu.tts.aop.ttslistener;

import android.text.TextUtils;
import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p108l.C1744h;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ProgressCorrectInterceptor extends AInterceptor {
    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected Object mo15331a(Object obj, Method method, Object[] objArr) {
        C1744h c1744h = (C1744h) objArr[0];
        if (c1744h != null) {
            String m14739b = c1744h.m14744e().m14739b();
            if (!TextUtils.isEmpty(m14739b)) {
                int length = m14739b.length();
                int m14748c = c1744h.m14748c();
                int i = m14748c > length ? m14748c - length : 0;
                LoggerProxy.m15091d("ProgressCorrectInterceptor", "prefixLength=" + length + "--progress=" + m14748c);
                C1744h y = c1744h.y();
                y.m14747c(i);
                objArr[0] = y;
            }
        }
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected void mo15332a() {
        this.f5663a.add("onSynthesizeDataArrived");
        this.f5663a.add("onPlayProgressUpdate");
    }
}
