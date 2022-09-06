package com.baidu.tts.p085b.p086a.p088b;

import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.C1599a;
import com.baidu.tts.auth.C1605b;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.p096e.EnumC1695a;
import com.baidu.tts.p096e.EnumC1701d;
import com.baidu.tts.p096e.EnumC1703f;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p108l.C1740d;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.ResourceTools;
import java.util.concurrent.Callable;
/* renamed from: com.baidu.tts.b.a.b.e */
/* loaded from: classes.dex */
public class C1631e extends AbstractC1624a {

    /* renamed from: b */
    private C1632a f5738b;

    /* renamed from: c */
    private long[] f5739c = new long[1];

    /* renamed from: com.baidu.tts.b.a.b.e$a */
    /* loaded from: classes.dex */
    public static class C1632a extends C1740d<C1632a> {

        /* renamed from: a */
        private String f5740a = "0";

        /* renamed from: b */
        private String f5741b = "0";

        /* renamed from: c */
        private String f5742c = "0";

        /* renamed from: d */
        private String f5743d = "0";

        /* renamed from: e */
        private String f5744e;

        /* renamed from: f */
        private String f5745f;

        /* renamed from: g */
        private String f5746g;

        /* renamed from: h */
        private String f5747h;

        /* renamed from: a */
        public int m15217a(String str) {
            if (DataTool.isLong(str)) {
                this.f5740a = str;
                return 0;
            }
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }

        /* renamed from: a */
        public long m15218a() {
            try {
                return Long.parseLong(this.f5740a);
            } catch (Exception e) {
                return 0L;
            }
        }

        /* renamed from: b */
        public long m15216b() {
            try {
                return Long.parseLong(this.f5741b);
            } catch (Exception e) {
                return 0L;
            }
        }

        /* renamed from: b */
        public void m15215b(String str) {
            this.f5741b = str;
        }

        /* renamed from: c */
        public int m15213c(String str) {
            if (DataTool.isLong(str)) {
                this.f5742c = str;
                return 0;
            }
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }

        /* renamed from: c */
        public long m15214c() {
            try {
                return Long.parseLong(this.f5742c);
            } catch (Exception e) {
                return 0L;
            }
        }

        /* renamed from: d */
        public int m15211d(String str) {
            if (DataTool.isLong(str)) {
                this.f5743d = str;
                return 0;
            }
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }

        /* renamed from: d */
        public long m15212d() {
            try {
                return Long.parseLong(this.f5743d);
            } catch (Exception e) {
                return 0L;
            }
        }

        /* renamed from: e */
        public String m15210e() {
            return this.f5744e;
        }

        /* renamed from: e */
        public void m15209e(String str) {
            this.f5744e = str;
        }

        /* renamed from: f */
        public String m15208f() {
            return this.f5745f;
        }

        /* renamed from: f */
        public void m15207f(String str) {
            this.f5745f = str;
        }

        /* renamed from: g */
        public String m15206g() {
            return this.f5746g;
        }

        /* renamed from: g */
        public void m15205g(String str) {
            this.f5746g = str;
        }

        /* renamed from: h */
        public String m15204h() {
            return this.f5747h;
        }

        /* renamed from: h */
        public void m15203h(String str) {
            this.f5747h = str;
        }
    }

    /* renamed from: com.baidu.tts.b.a.b.e$b */
    /* loaded from: classes.dex */
    private class CallableC1633b implements EmbeddedSynthesizerEngine.OnNewDataListener, Callable<TtsError> {

        /* renamed from: b */
        private C1745i f5749b;

        /* renamed from: c */
        private int f5750c = 0;

        public CallableC1633b(C1745i c1745i) {
            this.f5749b = c1745i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public TtsError call() {
            C1605b.C1606a m15328a = C1599a.m15330a().m15328a(C1631e.this.f5738b);
            if (m15328a != null) {
                if (!m15328a.mo14832g()) {
                    return m15328a.m15306b();
                }
                LoggerProxy.m15091d("OfflineSynthesizer", "engineResult = " + EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 0, 0L));
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 5, C1631e.this.f5738b.v());
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 6, C1631e.this.f5738b.w());
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 7, C1631e.this.f5738b.x());
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 17, C1631e.this.f5738b.m15218a());
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 18, C1631e.this.f5738b.m15216b());
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 19, C1631e.this.f5738b.m15214c());
                EmbeddedSynthesizerEngine.bdTTSSetParam(C1631e.this.f5739c[0], 9, C1631e.this.f5738b.m15212d());
                EmbeddedSynthesizerEngine.setOnNewDataListener(this);
                this.f5749b.m14736c(EnumC1701d.GBK.m14902a());
                byte[] m14733e = this.f5749b.m14733e();
                LoggerProxy.m15091d("OfflineSynthesizer", "before bdttssynthesis");
                int bdTTSSynthesis = EmbeddedSynthesizerEngine.bdTTSSynthesis(C1631e.this.f5739c[0], m14733e, m14733e.length);
                LoggerProxy.m15091d("OfflineSynthesizer", "after bdttssynthesis result = " + bdTTSSynthesis);
                if (bdTTSSynthesis != 0) {
                    return C1717c.m14880a().m14878a(EnumC1711n.OFFLINE_ENGINE_SYNTHESIZE_ERROR, bdTTSSynthesis);
                }
                return null;
            }
            return C1717c.m14880a().m14873b(EnumC1711n.OFFLINE_ENGINE_AUTH_NULL);
        }

        @Override // com.baidu.tts.jni.EmbeddedSynthesizerEngine.OnNewDataListener
        public int onNewData(byte[] bArr, int i) {
            C1744h m14749b = C1744h.m14749b(this.f5749b);
            m14749b.m14745d(EnumC1703f.OFFLINE.m14899a());
            m14749b.m14758a(EnumC1695a.PCM);
            m14749b.m14753a(bArr);
            m14749b.m14747c(i);
            this.f5750c++;
            if (bArr.length == 0) {
                this.f5750c = -this.f5750c;
            }
            m14749b.m14751b(this.f5750c);
            C1631e.this.a(m14749b);
            if (Thread.currentThread().isInterrupted()) {
                LoggerProxy.m15091d("OfflineSynthesizer", "interrupted to interrupt syn");
                return -1;
            }
            return 0;
        }
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15197a(C1741e c1741e) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataInit(ResourceTools.stringToByteArrayAddNull(c1741e.m14771a()), this.f5739c[0]);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15196a(C1742f c1742f) {
        String m14767b = c1742f.m14767b();
        String m14769a = c1742f.m14769a();
        boolean isEmpty = TextUtils.isEmpty(m14767b);
        if (TextUtils.isEmpty(m14769a) || isEmpty) {
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }
        int loadEnglishEngine = EmbeddedSynthesizerEngine.loadEnglishEngine(ResourceTools.stringToByteArrayAddNull(m14769a), ResourceTools.stringToByteArrayAddNull(m14767b), this.f5739c[0]);
        LoggerProxy.m15091d("OfflineSynthesizer", "loadEnglishModel ret=" + loadEnglishEngine);
        return loadEnglishEngine;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15195a(C1743g c1743g) {
        int i = 0;
        String m14763b = c1743g.m14763b();
        String m14765a = c1743g.m14765a();
        boolean isEmpty = TextUtils.isEmpty(m14763b);
        boolean isEmpty2 = TextUtils.isEmpty(m14765a);
        if (!isEmpty || !isEmpty2) {
            int bdTTSReInitData = !isEmpty ? EmbeddedSynthesizerEngine.bdTTSReInitData(ResourceTools.stringToByteArrayAddNull(m14763b), this.f5739c[0]) : 0;
            if (!isEmpty2) {
                i = EmbeddedSynthesizerEngine.bdTTSReInitData(ResourceTools.stringToByteArrayAddNull(m14765a), this.f5739c[0]);
            }
            return i + bdTTSReInitData;
        }
        return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public TtsError mo15222a() {
        if (this.f5738b == null) {
            this.f5738b = new C1632a();
        }
        C1605b.C1606a m15328a = C1599a.m15330a().m15328a(this.f5738b);
        if (m15328a.mo14832g()) {
            String m15210e = this.f5738b.m15210e();
            String m15208f = this.f5738b.m15208f();
            byte[] stringToByteArrayAddNull = ResourceTools.stringToByteArrayAddNull(m15210e);
            byte[] stringToByteArrayAddNull2 = ResourceTools.stringToByteArrayAddNull(m15208f);
            LoggerProxy.m15091d("OfflineSynthesizer", "before bdTTSEngineInit");
            int bdTTSEngineInit = EmbeddedSynthesizerEngine.bdTTSEngineInit(stringToByteArrayAddNull, stringToByteArrayAddNull2, this.f5739c);
            LoggerProxy.m15091d("OfflineSynthesizer", "engine init ret = " + bdTTSEngineInit);
            if (bdTTSEngineInit != 0) {
                return C1717c.m14880a().m14877a(EnumC1711n.OFFLINE_ENGINE_INIT_FAILED, bdTTSEngineInit, "bdTTSEngineInit result not 0");
            }
            return null;
        }
        return m15328a.m15306b();
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public TtsError mo15194a(C1745i c1745i) {
        try {
            return new CallableC1633b(c1745i).call();
        } catch (InterruptedException e) {
            throw e;
        } catch (Exception e2) {
            return C1717c.m14880a().m14874a(EnumC1711n.OFFLINE_ENGINE_CALL_EXCEPTION, e2);
        }
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public <OfflineSynthesizerParams> void mo15193a(OfflineSynthesizerParams offlinesynthesizerparams) {
        this.f5738b = (C1632a) offlinesynthesizerparams;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: b */
    public int mo15192b(C1741e c1741e) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataUninit(this.f5739c[0]);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: b */
    public TtsError mo15220b() {
        EmbeddedSynthesizerEngine.bdTTSEngineUninit(this.f5739c[0]);
        return null;
    }
}
