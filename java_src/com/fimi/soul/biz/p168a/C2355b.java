package com.fimi.soul.biz.p168a;

import android.os.Message;
import android.util.Log;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.AbstractC2182a;
import com.fimi.kernel.p157b.AbstractC2228e;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p162e.C2230b;
import com.fimi.soul.entity.APConfig;
import com.fimi.soul.entity.APStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: com.fimi.soul.biz.a.b */
/* loaded from: classes.dex */
public class C2355b extends AbstractC2180b {

    /* renamed from: a */
    public static final String f7975a = "PSK_KEY";

    /* renamed from: b */
    public static final String f7976b = "AP_SSID";

    /* renamed from: c */
    public static final String f7977c = "AP_PRIMARY_CH";

    /* renamed from: d */
    public static final String f7978d = "DEF_ATH_countrycode";

    /* renamed from: e */
    public static final String f7979e = "VERSION";

    /* renamed from: f */
    public static final String f7980f = "AP_IPADDR";

    /* renamed from: g */
    public static final String f7981g = "ATH_txpower";

    /* renamed from: h */
    public static final String f7982h = "ERROR_INFO";

    /* renamed from: i */
    public static final String f7983i = "SIGNAL_INFO";

    /* renamed from: k */
    public static final String f7985k = "SP_KEY_CACHE_APCONFIG";

    /* renamed from: n */
    private C2230b f7988n;

    /* renamed from: l */
    private static String f7986l = "http://192.168.42.100/cgi-bin";

    /* renamed from: j */
    public static String f7984j = "UNCONNECT_CAMERA";

    /* renamed from: m */
    private static String f7987m = "\".*\"";

    /* renamed from: q */
    private AbstractC2182a f7991q = (AbstractC2182a) C2238c.m13128a(EnumC2222d.Http);

    /* renamed from: p */
    private Pattern f7990p = Pattern.compile(f7987m);

    /* renamed from: o */
    private Map<String, String> f7989o = new HashMap();

    /* renamed from: com.fimi.soul.biz.a.b$a */
    /* loaded from: classes.dex */
    private class C2363a {

        /* renamed from: b */
        private StringBuilder f8006b = new StringBuilder();

        public C2363a(String str) {
            this.f8006b.append(str);
            this.f8006b.append(C0228a.f351a);
        }

        /* renamed from: a */
        public String m12471a() {
            return this.f8006b.toString();
        }

        /* renamed from: a */
        public void m12470a(String str, String str2) {
            if (str == null || str2 == null || str2.trim().length() <= 0) {
                return;
            }
            this.f8006b.append(String.format("%s=%s&", str, str2));
        }
    }

    public C2355b() {
        this.f7988n = null;
        this.f7988n = (C2230b) C2238c.m13128a(EnumC2222d.Volley);
    }

    /* renamed from: a */
    private boolean m12498a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m12493b(String str, String str2, final AbstractC2228e<Boolean> abstractC2228e) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        this.f7988n.mo13148a(m12489c("VAPcfg"), hashMap, new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.a.b.6
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str3) {
                if (str3 != null) {
                    abstractC2228e.mo8307a(true);
                } else {
                    abstractC2228e.mo8307a(false);
                }
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str3) {
                if (str3 == null) {
                    abstractC2228e.mo8307a(true);
                } else {
                    abstractC2228e.mo8307a(false);
                }
            }
        });
    }

    /* renamed from: c */
    private String m12489c(String str) {
        return String.format("%s/%s", f7986l, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public APConfig m12488d() {
        APConfig aPConfig = new APConfig();
        if (this.f7989o != null && this.f7989o.size() > 0) {
            aPConfig.setApPwd(this.f7989o.get(f7975a));
            aPConfig.setSsid(this.f7989o.get(f7976b));
            aPConfig.setPrimaryChannel(this.f7989o.get(f7977c));
            aPConfig.setCountryCode(this.f7989o.get(f7978d));
            aPConfig.setVersion(this.f7989o.get(f7979e));
            aPConfig.setIpAddr(this.f7989o.get(f7980f));
            aPConfig.setPower(this.f7989o.get(f7981g));
            aPConfig.setConCameraStatus(this.f7989o.get(f7982h));
            if (this.f7989o.get(f7983i) != null) {
                aPConfig.setSignalInfo(Integer.parseInt(this.f7989o.get(f7983i)));
            }
        }
        return aPConfig;
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
    }

    /* renamed from: a */
    public void m12504a(final AbstractC2228e<APStatus> abstractC2228e) {
        this.f7988n.mo13145b(m12489c("status.cgi"), new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.a.b.1
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str) {
                Log.d("Good", str + "SUCCESS");
                APStatus aPStatus = new APStatus();
                Matcher matcher = C2355b.this.f7990p.matcher(str);
                if (matcher.find()) {
                    aPStatus.setSsid(matcher.group().replace("\"", ""));
                }
                abstractC2228e.mo8307a(aPStatus);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str) {
                abstractC2228e.mo8305b(null);
            }
        });
    }

    /* renamed from: a */
    public void m12502a(APConfig aPConfig, final AbstractC2228e<Boolean> abstractC2228e) {
        if (aPConfig != null) {
            C2363a c2363a = new C2363a(String.format("%s/setting.cgi", f7986l));
            c2363a.m12470a(f7975a, aPConfig.getApPwd());
            c2363a.m12470a(f7978d, aPConfig.getCountryCode());
            c2363a.m12470a(f7981g, aPConfig.getPower());
            c2363a.m12470a(f7976b, aPConfig.getSsid());
            c2363a.m12470a(f7979e, aPConfig.getVersion());
            String m12471a = c2363a.m12471a();
            Log.d("Good", m12471a);
            this.f7991q.mo13150a(m12471a, new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.a.b.3
                @Override // com.fimi.kernel.p157b.AbstractC2228e
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public void mo8307a(String str) {
                    C2355b.this.m12491c(new AbstractC2228e<Boolean>() { // from class: com.fimi.soul.biz.a.b.3.1
                        @Override // com.fimi.kernel.p157b.AbstractC2228e
                        /* renamed from: a  reason: avoid collision after fix types in other method */
                        public void mo8307a(Boolean bool) {
                            abstractC2228e.mo8307a(bool);
                        }

                        @Override // com.fimi.kernel.p157b.AbstractC2228e
                        /* renamed from: b  reason: avoid collision after fix types in other method */
                        public void mo8305b(Boolean bool) {
                            abstractC2228e.mo8305b(bool);
                        }
                    });
                }

                @Override // com.fimi.kernel.p157b.AbstractC2228e
                /* renamed from: b  reason: avoid collision after fix types in other method */
                public void mo8305b(String str) {
                    abstractC2228e.mo8307a(false);
                }
            });
        }
    }

    /* renamed from: a */
    public void m12499a(String str, String str2, final AbstractC2228e<Boolean> abstractC2228e) {
        C2363a c2363a = new C2363a(String.format("%s/setting.cgi", f7986l));
        c2363a.m12470a(str, str2);
        this.f7991q.mo13150a(c2363a.m12471a(), new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.a.b.4
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str3) {
                Log.d("Good", str3);
                abstractC2228e.mo8307a(true);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str3) {
                abstractC2228e.mo8307a(false);
            }
        });
    }

    /* renamed from: a */
    public boolean m12501a(String str) {
        return m12498a(m12492c(), str);
    }

    /* renamed from: a */
    public boolean m12500a(String str, String str2) {
        return m12498a(m12494b(str), str2);
    }

    /* renamed from: b */
    public APConfig m12497b() {
        APConfig aPConfig = (APConfig) C2238c.m13125c().mo13118a(f7985k, APConfig.class);
        return aPConfig == null ? new APConfig() : aPConfig;
    }

    /* renamed from: b */
    public void m12496b(final AbstractC2228e<APConfig> abstractC2228e) {
        this.f7989o.clear();
        this.f7988n.mo13145b(m12489c("config.cgi"), new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.a.b.2
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str) {
                if (str != null && str.length() > 3) {
                    Scanner scanner = new Scanner(str.substring(4));
                    while (scanner.hasNextLine()) {
                        String[] split = scanner.nextLine().split("=");
                        if (split != null && split.length == 2) {
                            C2355b.this.f7989o.put(split[0], split[1]);
                        }
                    }
                }
                APConfig m12488d = C2355b.this.m12488d();
                C2238c.m13125c().mo13117a(C2355b.f7985k, m12488d);
                abstractC2228e.mo8307a(m12488d);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str) {
                abstractC2228e.mo8305b(new APConfig());
            }
        });
    }

    /* renamed from: b */
    public String[] m12494b(String str) {
        if (m12498a(C2354a.f7969a, str)) {
            return C2354a.f7972d;
        }
        if (m12498a(C2354a.f7971c, str)) {
            return C2354a.f7974f;
        }
        if (!m12498a(C2354a.f7970b, str)) {
            return null;
        }
        return C2354a.f7970b;
    }

    /* renamed from: c */
    public void m12491c(final AbstractC2228e<Boolean> abstractC2228e) {
        HashMap hashMap = new HashMap();
        hashMap.put("INDEX", "1");
        hashMap.put("COMMIT", "Save");
        this.f7988n.mo13148a(m12489c("VAPcfg"), hashMap, new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.a.b.5
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str) {
                abstractC2228e.mo8307a(true);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str) {
                abstractC2228e.mo8305b(false);
            }
        });
    }

    /* renamed from: c */
    public String[] m12492c() {
        return m12494b(m12497b().getCountryCode());
    }

    /* renamed from: d */
    public void m12487d(AbstractC2228e<Boolean> abstractC2228e) {
        m12493b("RebootButton", "Reboot", abstractC2228e);
    }

    /* renamed from: e */
    public void m12486e(AbstractC2228e<Boolean> abstractC2228e) {
        m12493b("", "FactoryReset", abstractC2228e);
    }
}
