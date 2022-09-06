package com.baidu.tts.p081a.p083b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.tts.TtsFactory;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.p092c.C1656a;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1706i;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.tools.ResourceTools;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: com.baidu.tts.a.b.a */
/* loaded from: classes.dex */
public class C1585a {

    /* renamed from: b */
    private SpeechSynthesizerListener f5640b;

    /* renamed from: c */
    private ThreadPoolExecutor f5641c;

    /* renamed from: d */
    private TtsListener f5642d = new TtsListener() { // from class: com.baidu.tts.a.b.a.1
        /* renamed from: a */
        private boolean m15374a(C1744h c1744h) {
            try {
                switch (C15872.f5644a[c1744h.m14743f().getTtsErrorFlyweight().a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        return true;
                    default:
                        return false;
                }
            } catch (Exception e) {
                LoggerProxy.m15091d("SpeechSynthesizerMachine", "isStopped exception=" + e.toString());
                return false;
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onError(C1744h c1744h) {
            if (C1585a.this.f5640b == null || m15374a(c1744h)) {
                return;
            }
            C1585a.this.f5640b.onError(C1585a.this.m15396a(c1744h), C1585a.this.m15385b(c1744h));
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayFinished(C1744h c1744h) {
            if (C1585a.this.f5640b != null) {
                C1585a.this.f5640b.onSpeechFinish(C1585a.this.m15396a(c1744h));
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayProgressUpdate(C1744h c1744h) {
            if (C1585a.this.f5640b != null) {
                C1585a.this.f5640b.onSpeechProgressChanged(C1585a.this.m15396a(c1744h), c1744h.m14748c());
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayStart(C1744h c1744h) {
            if (C1585a.this.f5640b != null) {
                C1585a.this.f5640b.onSpeechStart(C1585a.this.m15396a(c1744h));
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeDataArrived(C1744h c1744h) {
            if (C1585a.this.f5640b != null) {
                C1585a.this.f5640b.onSynthesizeDataArrived(C1585a.this.m15396a(c1744h), c1744h.m14746d(), c1744h.m14748c());
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeFinished(C1744h c1744h) {
            if (C1585a.this.f5640b != null) {
                C1585a.this.f5640b.onSynthesizeFinish(C1585a.this.m15396a(c1744h));
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeStart(C1744h c1744h) {
            if (C1585a.this.f5640b != null) {
                C1585a.this.f5640b.onSynthesizeStart(C1585a.this.m15396a(c1744h));
            }
        }
    };

    /* renamed from: a */
    private ITts f5639a = m15377g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tts.a.b.a$2 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C15872 {

        /* renamed from: a */
        static final /* synthetic */ int[] f5644a = new int[EnumC1711n.values().length];

        static {
            try {
                f5644a[EnumC1711n.MIX_AUTH_INTERRUPTED_EXCEPTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5644a[EnumC1711n.OFFLINE_AUTH_INTERRUPTED_EXCEPTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5644a[EnumC1711n.ONLINE_AUTH_INTERRUPTED_EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.a.b.a$a */
    /* loaded from: classes.dex */
    public class CallableC1588a implements Callable<Void> {

        /* renamed from: a */
        List<SpeechSynthesizeBag> f5645a;

        public CallableC1588a(List<SpeechSynthesizeBag> list) {
            this.f5645a = list;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            int size;
            if (this.f5645a != null && (size = this.f5645a.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    SpeechSynthesizeBag speechSynthesizeBag = this.f5645a.get(i);
                    if (speechSynthesizeBag != null) {
                        String text = speechSynthesizeBag.getText();
                        String utteranceId = speechSynthesizeBag.getUtteranceId();
                        if (TextUtils.isEmpty(utteranceId)) {
                            utteranceId = String.valueOf(i);
                            speechSynthesizeBag.setUtteranceId(utteranceId);
                        }
                        String str = utteranceId;
                        if (Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        C1745i c1745i = new C1745i(text, str);
                        c1745i.m14741a(EnumC1706i.SPEAK);
                        C1585a.this.f5639a.speak(c1745i);
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.a.b.a$b */
    /* loaded from: classes.dex */
    public class CallableC1589b implements Callable<Void> {

        /* renamed from: b */
        private String f5648b;

        /* renamed from: c */
        private String f5649c;

        public CallableC1589b(String str, String str2) {
            this.f5648b = str;
            this.f5649c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            C1745i c1745i = new C1745i(this.f5648b, this.f5649c);
            c1745i.m14741a(EnumC1706i.SPEAK);
            C1585a.this.f5639a.speak(c1745i);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.a.b.a$c */
    /* loaded from: classes.dex */
    public class CallableC1590c implements Callable<Void> {

        /* renamed from: b */
        private String f5651b;

        /* renamed from: c */
        private String f5652c;

        public CallableC1590c(String str, String str2) {
            this.f5651b = str;
            this.f5652c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            C1745i c1745i = new C1745i(this.f5651b, this.f5652c);
            c1745i.m14741a(EnumC1706i.SYNTHESIZE);
            C1585a.this.f5639a.synthesize(c1745i);
            return null;
        }
    }

    public C1585a() {
        this.f5639a.setTtsListener(this.f5642d);
    }

    /* renamed from: a */
    private int m15392a(String str, Callable<Void> callable) {
        EnumC1711n isTextValid = ResourceTools.isTextValid(str);
        return isTextValid == null ? m15390a(callable) : isTextValid.m14886b();
    }

    /* renamed from: a */
    private int m15390a(Callable<Void> callable) {
        try {
            m15376h().submit(callable);
            return 0;
        } catch (RejectedExecutionException e) {
            return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m15396a(C1744h c1744h) {
        C1745i m14744e;
        if (c1744h == null || (m14744e = c1744h.m14744e()) == null) {
            LoggerProxy.m15091d("SpeechSynthesizerMachine", "getUtteranceId null");
            return null;
        }
        return m14744e.m14732f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public SpeechError m15385b(C1744h c1744h) {
        if (c1744h != null) {
            TtsError m14743f = c1744h.m14743f();
            if (m14743f != null) {
                int detailCode = m14743f.getDetailCode();
                String detailMessage = m14743f.getDetailMessage();
                SpeechError speechError = new SpeechError();
                speechError.code = detailCode;
                speechError.description = detailMessage;
                return speechError;
            }
            LoggerProxy.m15091d("SpeechSynthesizerMachine", "ttsError is null");
        }
        SpeechError speechError2 = new SpeechError();
        speechError2.code = EnumC1711n.TTS_ERROR_UNKNOW.m14886b();
        speechError2.description = EnumC1711n.TTS_ERROR_UNKNOW.m14885c();
        return speechError2;
    }

    /* renamed from: g */
    private ITts m15377g() {
        return new TtsFactory().makeProxy();
    }

    /* renamed from: h */
    private synchronized ExecutorService m15376h() {
        if (this.f5641c == null) {
            this.f5641c = new C1656a(1000, "SpeechSynthesizerPoolThread", new ThreadPoolExecutor.AbortPolicy());
        }
        return this.f5641c;
    }

    /* renamed from: i */
    private void m15375i() {
        if (this.f5641c != null) {
            if (!this.f5641c.isShutdown()) {
                this.f5641c.shutdownNow();
            }
            try {
                LoggerProxy.m15091d("SpeechSynthesizerMachine", "isTerminated=" + this.f5641c.awaitTermination(EnumC1709l.DEFAULT.m14891a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                LoggerProxy.m15091d("SpeechSynthesizerMachine", "InterruptedException");
            }
            this.f5641c = null;
        }
    }

    /* renamed from: a */
    public int m15403a(float f, float f2) {
        return this.f5639a.setStereoVolume(f, f2);
    }

    /* renamed from: a */
    public int m15402a(int i) {
        return this.f5639a.setAudioStreamType(i);
    }

    /* renamed from: a */
    public int m15395a(String str) {
        C1741e c1741e = new C1741e();
        c1741e.m14770a(str);
        return this.f5639a.loadCustomResource(c1741e);
    }

    /* renamed from: a */
    public int m15394a(String str, String str2) {
        try {
            return this.f5639a.setParam(EnumC1704g.valueOf(str), str2);
        } catch (Exception e) {
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }
    }

    /* renamed from: a */
    public int m15393a(String str, String str2, Bundle bundle) {
        return m15392a(str, new CallableC1589b(str, str2));
    }

    /* renamed from: a */
    public int m15391a(List<SpeechSynthesizeBag> list) {
        return list.size() <= 100 ? m15390a(new CallableC1588a(list)) : SpeechSynthesizer.ERROR_LIST_IS_TOO_LONG;
    }

    /* renamed from: a */
    public TtsError m15397a(TtsMode ttsMode) {
        this.f5639a.setMode(ttsMode.getTtsEnum());
        return this.f5639a.b();
    }

    /* renamed from: a */
    public String m15404a() {
        return C1719b.m14869a().m14862j();
    }

    /* renamed from: a */
    public void m15401a(Context context) {
        this.f5639a.setContext(context);
    }

    /* renamed from: a */
    public void m15398a(SpeechSynthesizerListener speechSynthesizerListener) {
        if (this.f5640b != speechSynthesizerListener) {
            this.f5640b = speechSynthesizerListener;
        }
    }

    /* renamed from: b */
    public int m15389b() {
        if (this.f5639a != null) {
            this.f5639a.d();
            return 0;
        }
        return 0;
    }

    /* renamed from: b */
    public int m15384b(String str, String str2) {
        C1743g c1743g = new C1743g();
        c1743g.m14762b(str);
        c1743g.m14764a(str2);
        return this.f5639a.loadModel(c1743g);
    }

    /* renamed from: b */
    public int m15383b(String str, String str2, Bundle bundle) {
        return m15392a(str, new CallableC1590c(str, str2));
    }

    /* renamed from: b */
    public AuthInfo m15386b(TtsMode ttsMode) {
        return this.f5639a.auth(ttsMode.getTtsEnum());
    }

    /* renamed from: c */
    public int m15382c() {
        if (this.f5639a != null) {
            this.f5639a.c();
            return 0;
        }
        return 0;
    }

    /* renamed from: c */
    public int m15381c(String str, String str2) {
        C1742f c1742f = new C1742f();
        c1742f.m14768a(str);
        c1742f.m14766b(str2);
        return this.f5639a.loadEnglishModel(c1742f);
    }

    /* renamed from: d */
    public int m15380d() {
        m15375i();
        if (this.f5639a != null) {
            this.f5639a.e();
            return 0;
        }
        return 0;
    }

    /* renamed from: e */
    public int m15379e() {
        m15375i();
        if (this.f5639a != null) {
            this.f5639a.f();
            this.f5639a = null;
            return 0;
        }
        return 0;
    }

    /* renamed from: f */
    public int m15378f() {
        return this.f5639a.freeCustomResource(null);
    }
}
