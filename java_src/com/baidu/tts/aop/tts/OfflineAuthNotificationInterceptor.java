package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.auth.C1599a;
import com.baidu.tts.auth.C1605b;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p096e.EnumC1710m;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.p108l.C1746j;
import com.baidu.tts.p110n.p111a.C1771c;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class OfflineAuthNotificationInterceptor extends AInterceptor {

    /* renamed from: b */
    private AtomicInteger f5667b = new AtomicInteger(-1);

    /* renamed from: a */
    private Object m15333a(C1771c c1771c, C1746j c1746j, C1745i c1745i) {
        m15334a(C1599a.m15330a().m15328a(c1746j.m14725d()), c1745i);
        return AInterceptorHandler.DEFAULT;
    }

    /* renamed from: a */
    private void m15334a(C1605b.C1606a c1606a, C1745i c1745i) {
        if (c1606a.m15303d()) {
            c1745i.m14740a(String.format(Locale.US, "百度语音试用服务%d天后到期，", Integer.valueOf(c1606a.m15310a())));
        }
        if (c1606a.m15301f()) {
            c1745i.m14740a("百度语音试用服务已经到期，请及时更新授权，");
        }
        c1745i.m14742a();
    }

    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected Object mo15331a(Object obj, Method method, Object[] objArr) {
        C1771c c1771c = (C1771c) obj;
        if (!c1771c.m14684q()) {
            c1771c.m14685p();
            return AInterceptorHandler.END;
        }
        EnumC1710m mode = c1771c.getMode();
        if (mode == null) {
            c1771c.m14685p();
            return AInterceptorHandler.END;
        }
        switch (mode) {
            case MIX:
            case OFFLINE:
                int incrementAndGet = this.f5667b.incrementAndGet();
                LoggerProxy.m15091d("OfflineAuthNotificationInterceptor", "currentCount=" + incrementAndGet);
                if (incrementAndGet % 20 == 0) {
                    C1745i c1745i = (C1745i) objArr[0];
                    C1746j ttsParams = c1771c.getTtsParams();
                    if (ttsParams != null) {
                        return m15333a(c1771c, ttsParams, c1745i);
                    }
                    c1771c.m14685p();
                    return AInterceptorHandler.END;
                }
                break;
        }
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected void mo15332a() {
        this.f5663a.add("speak");
    }
}
