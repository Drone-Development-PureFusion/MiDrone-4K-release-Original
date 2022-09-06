package com.baidu.tts.auth;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p105j.AbstractC1725a;
import com.baidu.tts.p105j.AbstractCallableC1726b;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.Arrays;
/* renamed from: com.baidu.tts.auth.b */
/* loaded from: classes.dex */
public class C1605b implements AbstractCallableC1726b<C1605b, C1606a> {

    /* renamed from: a */
    private String f5693a;

    /* renamed from: b */
    private String f5694b;

    /* renamed from: com.baidu.tts.auth.b$a */
    /* loaded from: classes.dex */
    public static class C1606a implements AbstractC1725a {

        /* renamed from: a */
        private int f5695a;

        /* renamed from: b */
        private int f5696b = -1;

        /* renamed from: c */
        private String f5697c;

        /* renamed from: d */
        private String f5698d;

        /* renamed from: e */
        private TtsError f5699e;

        /* renamed from: a */
        public int m15310a() {
            if (this.f5695a >= 1000) {
                return this.f5695a - 1000;
            }
            return 0;
        }

        /* renamed from: a */
        public void m15309a(int i) {
            this.f5696b = i;
        }

        /* renamed from: a */
        public void m15308a(TtsError ttsError) {
            if (ttsError != null) {
                LoggerProxy.m15091d("OfflineAuth", "this=" + this + "--error=" + ttsError.getDetailMessage());
            }
            this.f5699e = ttsError;
        }

        /* renamed from: a */
        public void m15307a(String str) {
            this.f5697c = str;
        }

        /* renamed from: b */
        public TtsError m15306b() {
            return this.f5699e;
        }

        /* renamed from: b */
        public void m15305b(String str) {
            this.f5698d = str;
        }

        /* renamed from: c */
        public String m15304c() {
            if (m15302e()) {
                return "valid official";
            }
            if (m15303d()) {
                return "valid temp";
            }
            switch (this.f5695a) {
                case -10:
                    return "temp license expired";
                case -9:
                default:
                    return "not a valid result";
                case -8:
                    return "license not exist or invalid license";
                case -7:
                    return "platform unmatched";
                case -6:
                    return "will expire after a month";
                case -5:
                    return "official license expired";
                case -4:
                    return "cuid unmatched";
                case -3:
                    return "sign or appcode unmatched";
                case -2:
                    return "package name unmatched";
            }
        }

        /* renamed from: d */
        public boolean m15303d() {
            return this.f5695a >= 1000;
        }

        /* renamed from: e */
        public boolean m15302e() {
            return this.f5695a >= 0 && this.f5695a < 1000;
        }

        /* renamed from: f */
        public boolean m15301f() {
            return this.f5695a == -5 || this.f5695a == -6;
        }

        @Override // com.baidu.tts.p105j.AbstractC1725a
        /* renamed from: g */
        public boolean mo14832g() {
            if (StringTool.isEmpty(this.f5697c)) {
                return false;
            }
            File file = new File(this.f5697c);
            if (!file.exists()) {
                return false;
            }
            C1719b m14869a = C1719b.m14869a();
            byte[] bArr = new byte[32];
            this.f5695a = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(m14869a.m14864h(), this.f5698d, m14869a.m14863i(), this.f5697c, bArr);
            LoggerProxy.m15091d("OfflineAuth", "verify result=" + this.f5695a);
            if (bArr != null) {
                LoggerProxy.m15091d("OfflineAuth", "get appIdStr=" + Arrays.toString(bArr));
            }
            if (this.f5695a >= 0) {
                return true;
            }
            LoggerProxy.m15091d("OfflineAuth", "isDelete=" + file.delete());
            return false;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C1605b c1605b) {
        return (!StringTool.isEqual(this.f5693a, c1605b.m15316a()) || !StringTool.isEqual(this.f5694b, c1605b.m15313b())) ? 1 : 0;
    }

    /* renamed from: a */
    public String m15316a() {
        return this.f5693a;
    }

    /* renamed from: a */
    public void m15314a(String str) {
        this.f5693a = str;
    }

    /* renamed from: b */
    public String m15313b() {
        return this.f5694b;
    }

    /* renamed from: b */
    public void m15312b(String str) {
        this.f5694b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: c */
    public C1606a call() {
        C1606a c1606a = new C1606a();
        c1606a.m15307a(this.f5694b);
        c1606a.m15305b(this.f5693a);
        if (!c1606a.mo14832g()) {
            C1719b m14869a = C1719b.m14869a();
            Context m14864h = m14869a.m14864h();
            String m14863i = m14869a.m14863i();
            LoggerProxy.m15091d("OfflineAuth", "+ downloadLicense");
            int bdTTSGetLicense = EmbeddedSynthesizerEngine.bdTTSGetLicense(m14864h, this.f5693a, m14863i, "0", "", this.f5694b);
            LoggerProxy.m15091d("OfflineAuth", "- downloadLicense ret = " + bdTTSGetLicense);
            c1606a.m15309a(bdTTSGetLicense);
            if (bdTTSGetLicense < 0) {
                c1606a.m15308a(C1717c.m14880a().m14877a(EnumC1711n.OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED, bdTTSGetLicense, "appCode=" + this.f5693a + "--licensePath=" + this.f5694b));
            } else {
                c1606a.mo14832g();
            }
        }
        return c1606a;
    }
}
