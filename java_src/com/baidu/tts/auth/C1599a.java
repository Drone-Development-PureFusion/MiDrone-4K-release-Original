package com.baidu.tts.auth;

import com.baidu.tts.auth.C1605b;
import com.baidu.tts.auth.C1607c;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p086a.p088b.C1631e;
import com.baidu.tts.p085b.p086a.p088b.C1634f;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p096e.EnumC1710m;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p099g.p101b.C1718a;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p105j.C1727c;
import com.baidu.tts.p108l.C1738b;
import com.baidu.tts.p108l.C1746j;
import com.baidu.tts.tools.StringTool;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* renamed from: com.baidu.tts.auth.a */
/* loaded from: classes.dex */
public class C1599a {

    /* renamed from: a */
    private static volatile C1599a f5679a = null;

    /* renamed from: b */
    private C1727c<C1607c, C1607c.C1608a> f5680b = new C1727c<>();

    /* renamed from: c */
    private C1727c<C1605b, C1605b.C1606a> f5681c = new C1727c<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.auth.a$a */
    /* loaded from: classes.dex */
    public class CallableC1603a implements Callable<C1605b.C1606a> {

        /* renamed from: b */
        private C1631e.C1632a f5690b;

        public CallableC1603a(C1631e.C1632a c1632a) {
            this.f5690b = c1632a;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C1605b.C1606a call() {
            C1605b.C1606a c1606a = new C1605b.C1606a();
            C1718a m14865g = C1719b.m14869a().m14865g();
            if (m14865g == null) {
                c1606a.m15308a(C1717c.m14880a().m14873b(EnumC1711n.APP_RESOURCE_IS_NULL));
                return c1606a;
            }
            String m15204h = this.f5690b.m15204h();
            String m15206g = this.f5690b.m15206g();
            if (StringTool.isEmpty(m15206g)) {
                m15206g = m14865g.m14871b();
            }
            LoggerProxy.m15091d("AuthClient", "appCode=" + m15204h);
            LoggerProxy.m15091d("AuthClient", "licenseFilePath=" + m15206g);
            C1605b c1605b = new C1605b();
            c1605b.m15314a(m15204h);
            c1605b.m15312b(m15206g);
            return (C1605b.C1606a) C1599a.this.f5681c.m14830a(c1605b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.auth.a$b */
    /* loaded from: classes.dex */
    public class CallableC1604b implements Callable<C1607c.C1608a> {

        /* renamed from: b */
        private C1634f.C1636b f5692b;

        public CallableC1604b(C1634f.C1636b c1636b) {
            this.f5692b = c1636b;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C1607c.C1608a call() {
            String m15178d = this.f5692b.m15178d();
            String m15189a = this.f5692b.m15189a();
            String m15184b = this.f5692b.m15184b();
            LoggerProxy.m15091d("AuthClient", "pid=" + m15178d);
            LoggerProxy.m15091d("AuthClient", "ak=" + m15189a);
            LoggerProxy.m15091d("AuthClient", "sk=" + m15184b);
            C1607c c1607c = new C1607c();
            c1607c.m15297a(m15178d);
            c1607c.m15294b(m15189a);
            c1607c.m15291c(m15184b);
            return (C1607c.C1608a) C1599a.this.f5680b.m14830a(c1607c);
        }
    }

    private C1599a() {
    }

    /* renamed from: a */
    public static C1599a m15330a() {
        if (f5679a == null) {
            synchronized (C1599a.class) {
                if (f5679a == null) {
                    f5679a = new C1599a();
                }
            }
        }
        return f5679a;
    }

    /* renamed from: a */
    private <T> T m15323a(Callable<T> callable, long j) {
        return m15324a(callable).get(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    private <T> FutureTask<T> m15324a(Callable<T> callable) {
        FutureTask<T> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        return futureTask;
    }

    /* renamed from: a */
    public AuthInfo m15326a(EnumC1710m enumC1710m, C1746j c1746j) {
        C1738b m14730a = c1746j.m14730a();
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(enumC1710m);
        switch (enumC1710m) {
            case ONLINE:
                authInfo.setOnlineResult(m15327a(m14730a.m14796a()));
                return authInfo;
            case OFFLINE:
                authInfo.setOfflineResult(m15328a(m14730a.m14793b()));
                return authInfo;
            case MIX:
                return m15325a(m14730a);
            default:
                return authInfo;
        }
    }

    /* renamed from: a */
    public AuthInfo m15325a(final C1738b c1738b) {
        C1605b.C1606a c1606a;
        LoggerProxy.m15091d("AuthClient", "enter authMix");
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        FutureTask futureTask = new FutureTask(new Callable<C1607c.C1608a>() { // from class: com.baidu.tts.auth.a.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public C1607c.C1608a call() {
                try {
                    return C1599a.this.m15327a(c1738b.m14796a());
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        FutureTask futureTask2 = new FutureTask(new Callable<C1605b.C1606a>() { // from class: com.baidu.tts.auth.a.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public C1605b.C1606a call() {
                try {
                    return C1599a.this.m15328a(c1738b.m14793b());
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        try {
            LoggerProxy.m15091d("AuthClient", "+ await");
            countDownLatch.await();
            LoggerProxy.m15091d("AuthClient", "- await");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            futureTask2.cancel(true);
        }
        C1607c.C1608a c1608a = new C1607c.C1608a();
        LoggerProxy.m15091d("AuthClient", "+ mix online get onlineResult=" + c1608a);
        try {
            c1608a = (C1607c.C1608a) futureTask.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_INTERRUPTED_EXCEPTION, e2));
        } catch (CancellationException e3) {
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_CANCELLATION_EXCEPTION, e3));
        } catch (ExecutionException e4) {
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_EXECUTION_EXCEPTION, e4.getCause()));
        }
        LoggerProxy.m15091d("AuthClient", "- online get");
        C1605b.C1606a c1606a2 = new C1605b.C1606a();
        LoggerProxy.m15091d("AuthClient", "+ mix offline get offlineResult=" + c1606a2);
        try {
            c1606a = (C1605b.C1606a) futureTask2.get();
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            futureTask2.cancel(true);
            c1606a2.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_INTERRUPTED_EXCEPTION, e5));
            c1606a = c1606a2;
        } catch (CancellationException e6) {
            c1606a2.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_CANCELLATION_EXCEPTION, e6));
            c1606a = c1606a2;
        } catch (ExecutionException e7) {
            c1606a2.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_EXECUTION_EXCEPTION, e7.getCause()));
            c1606a = c1606a2;
        }
        LoggerProxy.m15091d("AuthClient", "- offline get");
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(EnumC1710m.MIX);
        authInfo.setOnlineResult(c1608a);
        authInfo.setOfflineResult(c1606a);
        LoggerProxy.m15091d("AuthClient", "end authMix");
        return authInfo;
    }

    /* renamed from: a */
    public C1605b.C1606a m15328a(C1631e.C1632a c1632a) {
        C1605b.C1606a c1606a = new C1605b.C1606a();
        try {
            return (C1605b.C1606a) m15323a(new CallableC1603a(c1632a), EnumC1709l.DEFAULT.m14891a());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            c1606a.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_INTERRUPTED_EXCEPTION, e));
            return c1606a;
        } catch (CancellationException e2) {
            c1606a.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_CANCELLATION_EXCEPTION, e2));
            return c1606a;
        } catch (ExecutionException e3) {
            c1606a.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_EXECUTION_EXCEPTION, e3.getCause()));
            return c1606a;
        } catch (TimeoutException e4) {
            c1606a.m15308a(C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_AUTH_TIMEOUT_EXCEPTION, e4));
            return c1606a;
        }
    }

    /* renamed from: a */
    public C1607c.C1608a m15327a(C1634f.C1636b c1636b) {
        C1607c.C1608a c1608a = new C1607c.C1608a();
        try {
            return (C1607c.C1608a) m15323a(new CallableC1604b(c1636b), EnumC1709l.DEFAULT.m14891a());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_INTERRUPTED_EXCEPTION, e));
            return c1608a;
        } catch (CancellationException e2) {
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_CANCELLATION_EXCEPTION, e2));
            return c1608a;
        } catch (ExecutionException e3) {
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_EXECUTION_EXCEPTION, e3.getCause()));
            return c1608a;
        } catch (TimeoutException e4) {
            c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_AUTH_TIMEOUT_EXCEPTION, e4));
            return c1608a;
        }
    }

    /* renamed from: b */
    public void m15322b() {
        if (this.f5680b != null) {
            this.f5680b.m14831a();
        }
        if (this.f5681c != null) {
            this.f5681c.m14831a();
        }
    }
}
