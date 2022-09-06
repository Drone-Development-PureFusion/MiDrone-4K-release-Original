package com.baidu.tts.p085b.p089b.p091b;

import android.media.AudioTrack;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p089b.AbstractC1640a;
import com.baidu.tts.p096e.EnumC1708k;
import com.baidu.tts.p102h.p103a.C1720a;
import com.baidu.tts.p102h.p103a.C1721b;
import com.baidu.tts.p108l.C1739c;
import com.baidu.tts.p108l.C1744h;
/* renamed from: com.baidu.tts.b.b.b.b */
/* loaded from: classes.dex */
public class C1653b extends AbstractC1652a {

    /* renamed from: b */
    private volatile AudioTrack f5797b;

    /* renamed from: c */
    private C1654a f5798c;

    /* renamed from: d */
    private C1721b f5799d = new C1721b();

    /* renamed from: e */
    private int f5800e;

    /* renamed from: com.baidu.tts.b.b.b.b$a */
    /* loaded from: classes.dex */
    public static class C1654a extends C1739c<C1654a> {

        /* renamed from: a */
        private EnumC1708k f5801a = EnumC1708k.HZ16K;

        /* renamed from: b */
        private int f5802b = 4;

        /* renamed from: c */
        private int f5803c = 2;

        /* renamed from: d */
        private int f5804d = 1;

        /* renamed from: e */
        private float f5805e = 1.0f;

        /* renamed from: f */
        private float f5806f = 1.0f;

        /* renamed from: a */
        public int m15109a() {
            return this.f5801a.m14892a();
        }

        /* renamed from: a */
        public void m15108a(float f) {
            this.f5805e = f;
        }

        /* renamed from: b */
        public int m15107b() {
            return this.f5802b;
        }

        /* renamed from: b */
        public void m15106b(float f) {
            this.f5806f = f;
        }

        /* renamed from: c */
        public int m15105c() {
            return this.f5803c;
        }

        /* renamed from: d */
        public int m15104d() {
            return this.f5804d;
        }

        /* renamed from: e */
        public float m15103e() {
            return this.f5805e;
        }

        /* renamed from: f */
        public float m15102f() {
            return this.f5806f;
        }
    }

    /* renamed from: a */
    private int m15117a(int i, int i2, int i3) {
        int i4;
        int i5 = 2;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3) * 2;
        switch (i2) {
            case 1:
            case 2:
            case 4:
                i4 = 1;
                break;
            case 3:
            case 12:
                i4 = 2;
                break;
            default:
                i4 = Integer.bitCount(i2);
                break;
        }
        if (i3 == 3) {
            i5 = 1;
        }
        if (minBufferSize % (i5 * i4) != 0 || minBufferSize < 1) {
            return 5120;
        }
        return minBufferSize;
    }

    /* renamed from: b */
    private int m15116b(int i) {
        if (i > this.f5800e) {
            this.f5800e = i;
        }
        return this.f5800e;
    }

    /* renamed from: b */
    private void m15115b(C1744h c1744h) {
        this.f5799d.m14852a(m15112e());
        this.f5799d.m14853a();
        this.f5800e = 0;
        m15113d(c1744h);
    }

    /* renamed from: c */
    private void m15114c(C1744h c1744h) {
        this.f5799d.m14851b();
        m15110f(c1744h);
    }

    /* renamed from: d */
    private void m15113d(C1744h c1744h) {
        if (this.f5796a != null) {
            this.f5796a.mo15125a(c1744h);
        }
    }

    /* renamed from: e */
    private int m15112e() {
        return (this.f5798c.m15109a() * 2) / this.f5798c.h();
    }

    /* renamed from: e */
    private void m15111e(C1744h c1744h) {
        if (this.f5796a != null) {
            this.f5796a.mo15124b(c1744h);
        }
    }

    /* renamed from: f */
    private void m15110f(C1744h c1744h) {
        if (this.f5796a != null) {
            this.f5796a.mo15123c(c1744h);
        }
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: a */
    public int mo15100a(float f, float f2) {
        int stereoVolume = this.f5797b.setStereoVolume(f, f2);
        this.f5798c.m15108a(f);
        this.f5798c.m15106b(f2);
        return stereoVolume;
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: a */
    public int mo15099a(int i) {
        if (i != this.f5798c.g()) {
            int m15109a = this.f5798c.m15109a();
            int m15107b = this.f5798c.m15107b();
            int m15105c = this.f5798c.m15105c();
            this.f5797b = new AudioTrack(i, m15109a, m15107b, m15105c, m15117a(m15109a, m15107b, m15105c), this.f5798c.m15104d());
            this.f5798c.a(i);
            this.f5797b.setStereoVolume(this.f5798c.m15103e(), this.f5798c.m15102f());
            this.f5797b.play();
            return 0;
        }
        return 0;
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: a */
    public TtsError mo15101a() {
        int m15109a = this.f5798c.m15109a();
        int m15107b = this.f5798c.m15107b();
        int m15105c = this.f5798c.m15105c();
        this.f5797b = new AudioTrack(this.f5798c.g(), m15109a, m15107b, m15105c, m15117a(m15109a, m15107b, m15105c), this.f5798c.m15104d());
        this.f5797b.setStereoVolume(this.f5798c.m15103e(), this.f5798c.m15102f());
        return null;
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: a */
    public TtsError mo15097a(C1744h c1744h) {
        LoggerProxy.m15091d("AudioTrackPlayer", "enter put");
        if (c1744h != null) {
            int m14752b = c1744h.m14752b();
            if (m14752b == 1 || m14752b == -1) {
                m15115b(c1744h);
            }
            byte[] m14746d = c1744h.m14746d();
            if (m14746d != null) {
                this.f5799d.m14850b(m14746d.length);
            }
            while (this.f5799d.hasNext()) {
                C1720a next = this.f5799d.next();
                int i = 0;
                int m14861a = next.m14861a();
                int m14857b = next.m14857b();
                while (i < m14857b && this.f5797b.getPlayState() != 1) {
                    LoggerProxy.m15091d("AudioTrackPlayer", "before write");
                    AudioTrack audioTrack = this.f5797b;
                    int write = audioTrack.write(m14746d, i + m14861a, m14857b - i);
                    LoggerProxy.m15091d("AudioTrackPlayer", "writtenbytes=" + write + "--offset=" + i + "--dataLength=" + m14857b);
                    i += write;
                }
                if (this.f5797b.getPlayState() == 1) {
                    break;
                } else if (next.m14855c()) {
                    int m14748c = c1744h.m14748c();
                    float m14854d = next.m14854d();
                    int round = Math.round(m14748c * m14854d);
                    int m15116b = m15116b(round);
                    LoggerProxy.m15091d("AudioTrackPlayer", "percent=" + m14854d + "--currentProgress=" + round + "--progress=" + m15116b);
                    C1744h y = c1744h.y();
                    y.m14747c(m15116b);
                    m15111e(y);
                }
            }
            if (m14752b < 0) {
                int m14748c2 = c1744h.m14748c();
                C1744h y2 = c1744h.y();
                y2.m14747c(m14748c2);
                m15111e(y2);
                m15114c(c1744h);
            }
        } else {
            LoggerProxy.m15091d("AudioTrackPlayer", "put responseBag=null");
        }
        LoggerProxy.m15091d("AudioTrackPlayer", "end put");
        return null;
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: a */
    public void mo15098a(AbstractC1640a abstractC1640a) {
        this.f5796a = abstractC1640a;
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: a */
    public <AudioTrackPlayerParams> void mo15096a(AudioTrackPlayerParams audiotrackplayerparams) {
        this.f5798c = (C1654a) audiotrackplayerparams;
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: b */
    public void mo15095b() {
        this.f5797b.play();
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: c */
    public void mo15094c() {
        this.f5797b.pause();
        this.f5797b.flush();
        this.f5797b.stop();
    }

    @Override // com.baidu.tts.p085b.p089b.p091b.AbstractC1652a, com.baidu.tts.p085b.p089b.p091b.AbstractC1655c
    /* renamed from: d */
    public TtsError mo15093d() {
        this.f5797b.release();
        this.f5797b = null;
        return null;
    }
}
