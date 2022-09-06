package com.baidu.tts.p085b.p086a.p088b;

import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.C1599a;
import com.baidu.tts.auth.C1607c;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p096e.EnumC1696b;
import com.baidu.tts.p096e.EnumC1700c;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p096e.EnumC1713o;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p108l.C1740d;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.p112o.C1774a;
import com.baidu.tts.tools.CommonUtility;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
/* renamed from: com.baidu.tts.b.a.b.f */
/* loaded from: classes.dex */
public class C1634f extends AbstractC1624a {

    /* renamed from: b */
    private C1636b f5751b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.b.a.b.f$a */
    /* loaded from: classes.dex */
    public class CallableC1635a implements Callable<C1744h> {

        /* renamed from: b */
        private int f5753b;

        /* renamed from: c */
        private String f5754c;

        /* renamed from: d */
        private C1745i f5755d;

        /* renamed from: e */
        private C1636b f5756e;

        /* renamed from: f */
        private C1744h f5757f;

        /* renamed from: g */
        private SyncHttpClient f5758g;

        public CallableC1635a(int i, String str, C1745i c1745i, C1636b c1636b, C1744h c1744h) {
            this.f5753b = i;
            this.f5754c = str;
            this.f5755d = c1745i;
            this.f5756e = c1636b;
            this.f5757f = c1744h;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C1744h call() {
            try {
                HttpEntity m15200a = C1634f.this.m15200a(this.f5753b, this.f5754c, this.f5755d, this.f5756e);
                this.f5758g = new SyncHttpClient();
                this.f5758g.setMaxRetriesAndTimeout(this.f5756e.m15164m(), this.f5756e.m15163n());
                int m15162o = this.f5756e.m15162o();
                LoggerProxy.m15091d("OnlineSynthesizer", "timeout=" + m15162o);
                this.f5758g.setTimeout(m15162o);
                C1639h c1639h = new C1639h(this.f5757f);
                c1639h.m15155a(this.f5756e);
                try {
                    if (!Thread.currentThread().isInterrupted()) {
                        LoggerProxy.m15091d("OnlineSynthesizer", "before post");
                        this.f5758g.post(null, EnumC1713o.TTS_SERVER.m14884a(), m15200a, null, c1639h);
                        LoggerProxy.m15091d("OnlineSynthesizer", "after post");
                    }
                } catch (Exception e) {
                    LoggerProxy.m15090e("OnlineSynthesizer", "loopj exception = " + e.getMessage());
                }
                return this.f5757f;
            } catch (C1774a e2) {
                this.f5757f.m14759a(C1717c.m14880a().m14873b(EnumC1711n.ONLINE_TOKEN_IS_NULL));
                return this.f5757f;
            }
        }

        /* renamed from: b */
        public void m15190b() {
            if (this.f5758g != null) {
                this.f5758g.stop();
            }
        }
    }

    /* renamed from: com.baidu.tts.b.a.b.f$b */
    /* loaded from: classes.dex */
    public static class C1636b extends C1740d<C1636b> {

        /* renamed from: p */
        private static Set<String> f5759p = new HashSet();

        /* renamed from: a */
        private String f5760a;

        /* renamed from: e */
        private String f5764e;

        /* renamed from: f */
        private String f5765f;

        /* renamed from: g */
        private String f5766g;

        /* renamed from: h */
        private String f5767h;

        /* renamed from: i */
        private String f5768i;

        /* renamed from: j */
        private String f5769j;

        /* renamed from: k */
        private String f5770k;

        /* renamed from: l */
        private String f5771l;

        /* renamed from: b */
        private EnumC1696b f5761b = EnumC1696b.AMR;

        /* renamed from: c */
        private EnumC1700c f5762c = EnumC1700c.AMR_15K85;

        /* renamed from: d */
        private String f5763d = "0";

        /* renamed from: m */
        private int f5772m = 5;

        /* renamed from: n */
        private int f5773n = 1000;

        /* renamed from: o */
        private int f5774o = EnumC1709l.DEFAULT.m14890b();

        static {
            f5759p.add(EnumC1704g.SPEED.m14896b());
        }

        /* renamed from: a */
        public int m15187a(EnumC1696b enumC1696b) {
            if (enumC1696b != null) {
                this.f5761b = enumC1696b;
                return 0;
            }
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }

        /* renamed from: a */
        public String m15189a() {
            return this.f5770k;
        }

        /* renamed from: a */
        public void m15188a(int i) {
            this.f5772m = i;
        }

        /* renamed from: a */
        public void m15186a(EnumC1700c enumC1700c) {
            this.f5762c = enumC1700c;
        }

        /* renamed from: a */
        public void m15185a(String str) {
            this.f5770k = str;
        }

        /* renamed from: b */
        public String m15184b() {
            return this.f5771l;
        }

        /* renamed from: b */
        public void m15183b(int i) {
            this.f5773n = i;
        }

        /* renamed from: b */
        public void m15182b(String str) {
            this.f5771l = str;
        }

        /* renamed from: c */
        public String m15181c() {
            return this.f5761b.m14906a();
        }

        /* renamed from: c */
        public void m15180c(int i) {
            this.f5774o = i;
        }

        /* renamed from: c */
        public void m15179c(String str) {
            this.f5760a = str;
        }

        /* renamed from: d */
        public String m15178d() {
            return this.f5760a;
        }

        /* renamed from: d */
        public void m15177d(String str) {
            this.f5763d = str;
        }

        /* renamed from: e */
        public String m15176e() {
            return this.f5762c.m14904a();
        }

        /* renamed from: e */
        public void m15175e(String str) {
            this.f5766g = str;
        }

        /* renamed from: f */
        public String m15174f() {
            return this.f5763d;
        }

        /* renamed from: f */
        public void m15173f(String str) {
            this.f5767h = str;
        }

        /* renamed from: g */
        public String m15172g() {
            return this.f5764e;
        }

        /* renamed from: g */
        public void m15171g(String str) {
            this.f5768i = str;
        }

        /* renamed from: h */
        public String m15170h() {
            return this.f5765f;
        }

        /* renamed from: h */
        public void m15169h(String str) {
            this.f5769j = str;
        }

        /* renamed from: i */
        public String m15168i() {
            return this.f5766g;
        }

        /* renamed from: j */
        public String m15167j() {
            return this.f5767h;
        }

        /* renamed from: k */
        public String m15166k() {
            return this.f5768i;
        }

        /* renamed from: l */
        public String m15165l() {
            return this.f5769j;
        }

        /* renamed from: m */
        public int m15164m() {
            return this.f5772m;
        }

        /* renamed from: n */
        public int m15163n() {
            return this.f5773n;
        }

        /* renamed from: o */
        public int m15162o() {
            return this.f5774o;
        }
    }

    /* renamed from: com.baidu.tts.b.a.b.f$c */
    /* loaded from: classes.dex */
    private class CallableC1637c implements Callable<TtsError> {

        /* renamed from: b */
        private C1745i f5776b;

        /* renamed from: c */
        private String f5777c = CommonUtility.generateSerialNumber();

        public CallableC1637c(C1745i c1745i) {
            this.f5776b = c1745i;
        }

        /* renamed from: a */
        private boolean m15160a(C1744h c1744h) {
            return c1744h != null && c1744h.m14743f() == null && c1744h.m14761a() == 0;
        }

        /* renamed from: b */
        private boolean m15159b(C1744h c1744h) {
            return !m15160a(c1744h) || c1744h.m14752b() < 0;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public TtsError call() {
            C1744h m15201a;
            int i = 0;
            do {
                i++;
                LoggerProxy.m15091d("OnlineSynthesizer", "count=" + i);
                m15201a = C1634f.this.m15201a(i, this.f5777c, this.f5776b);
                if (m15160a(m15201a)) {
                    C1634f.this.a(m15201a);
                }
            } while (!m15159b(m15201a));
            return m15201a == null ? C1717c.m14880a().m14873b(EnumC1711n.ONLINE_ENGINE_CALL_EXCEPTION) : m15201a.m14743f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C1744h m15201a(int i, String str, C1745i c1745i) {
        C1744h m14749b = C1744h.m14749b(c1745i);
        C1636b y = this.f5751b.y();
        CallableC1635a callableC1635a = new CallableC1635a(i, str, c1745i, y, m14749b);
        FutureTask futureTask = new FutureTask(callableC1635a);
        new Thread(futureTask).start();
        try {
            return (C1744h) futureTask.get(y.m15162o(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            callableC1635a.m15190b();
            throw e;
        } catch (ExecutionException e2) {
            m14749b.m14759a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_ENGINE_GET_EXECUTION_EXCEPTION, e2.getCause()));
            return m14749b;
        } catch (TimeoutException e3) {
            LoggerProxy.m15091d("OnlineSynthesizer", "startOnceHttpRequest timeout");
            futureTask.cancel(true);
            callableC1635a.m15190b();
            m14749b.m14759a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_ENGINE_GET_TIMEOUT, e3));
            return m14749b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public HttpEntity m15200a(int i, String str, C1745i c1745i, C1636b c1636b) {
        UrlEncodedFormEntity urlEncodedFormEntity;
        if (c1636b == null) {
            return null;
        }
        ArrayList<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(EnumC1704g.INDEX.m14898a(), String.valueOf(i)));
        arrayList.add(new BasicNameValuePair(EnumC1704g.SERIAL_NUMBER.m14898a(), str));
        c1745i.m14736c(c1636b.p());
        String m14735d = c1745i.m14735d();
        if (i == 1) {
            try {
                arrayList.add(new BasicNameValuePair(EnumC1704g.TEXT.m14898a(), URLEncoder.encode(c1745i.m14737c(), m14735d)));
                C1719b m14869a = C1719b.m14869a();
                String m14867a = m14869a.m14867a(EnumC1704g.CTP.m14898a());
                String m14867a2 = m14869a.m14867a(EnumC1704g.VERSION.m14898a());
                arrayList.add(new BasicNameValuePair(EnumC1704g.CTP.m14898a(), m14867a));
                String m14863i = m14869a.m14863i();
                if (m14863i != null) {
                    arrayList.add(new BasicNameValuePair(EnumC1704g.CUID.m14898a(), m14863i));
                }
                arrayList.add(new BasicNameValuePair(EnumC1704g.VERSION.m14898a(), m14867a2));
                String m15178d = c1636b.m15178d();
                if (TextUtils.isEmpty(m15178d)) {
                    LoggerProxy.m15091d("OnlineSynthesizer", "before online auth");
                    C1607c.C1608a m15327a = C1599a.m15330a().m15327a(c1636b);
                    LoggerProxy.m15091d("OnlineSynthesizer", "after online auth");
                    if (!m15327a.mo14832g()) {
                        throw new C1774a();
                    }
                    arrayList.add(new BasicNameValuePair(EnumC1704g.TOKEN.m14898a(), m15327a.m15289a()));
                } else {
                    arrayList.add(new BasicNameValuePair(EnumC1704g.PRODUCT_ID.m14898a(), m15178d));
                }
                arrayList.add(new BasicNameValuePair(EnumC1704g.TEXT_ENCODE.m14898a(), c1636b.q()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.AUDIO_ENCODE.m14898a(), c1636b.m15181c()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.BITRATE.m14898a(), c1636b.m15176e()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.SPEAKER.m14898a(), c1636b.m15174f()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.NUMBER.m14898a(), c1636b.m15172g()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.ENGINE.m14898a(), c1636b.m15170h()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.STYLE.m14898a(), c1636b.m15168i()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.BACKGROUND.m14898a(), c1636b.m15167j()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.TERRITORY.m14898a(), c1636b.m15166k()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.PUNCTUATION.m14898a(), c1636b.m15165l()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.LANGUAGE.m14898a(), c1636b.r()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.SPEED.m14898a(), c1636b.s()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.PITCH.m14898a(), c1636b.t()));
                arrayList.add(new BasicNameValuePair(EnumC1704g.VOLUME.m14898a(), c1636b.u()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (NameValuePair nameValuePair : arrayList) {
                stringBuffer.append(nameValuePair.getName());
                stringBuffer.append("=");
                stringBuffer.append(nameValuePair.getValue());
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            LoggerProxy.m15091d("OnlineSynthesizer", "request params: " + ((Object) stringBuffer));
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, m14735d);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            urlEncodedFormEntity = null;
        }
        return urlEncodedFormEntity;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15197a(C1741e c1741e) {
        return EnumC1711n.ONLINE_UNSUPPORTED_OPERATION.m14886b();
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15196a(C1742f c1742f) {
        return EnumC1711n.ONLINE_UNSUPPORTED_OPERATION.m14886b();
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15195a(C1743g c1743g) {
        return EnumC1711n.ONLINE_UNSUPPORTED_OPERATION.m14886b();
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public TtsError mo15194a(C1745i c1745i) {
        try {
            return new CallableC1637c(c1745i).call();
        } catch (InterruptedException e) {
            throw e;
        } catch (Exception e2) {
            return C1717c.m14880a().m14874a(EnumC1711n.ONLINE_ENGINE_CALL_EXCEPTION, e2);
        }
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public <OnlineSynthesizerParams> void mo15193a(OnlineSynthesizerParams onlinesynthesizerparams) {
        this.f5751b = (C1636b) onlinesynthesizerparams;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: b */
    public int mo15192b(C1741e c1741e) {
        return EnumC1711n.ONLINE_UNSUPPORTED_OPERATION.m14886b();
    }
}
