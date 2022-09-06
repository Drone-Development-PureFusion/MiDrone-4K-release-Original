package com.fimi.soul.biz.update;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.AbstractC2228e;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p158a.AbstractC2183a;
import com.fimi.kernel.p157b.p158a.C2185b;
import com.fimi.kernel.p157b.p158a.C2192c;
import com.fimi.kernel.p157b.p160c.AbstractC2219b;
import com.fimi.kernel.p157b.p162e.C2230b;
import com.fimi.soul.biz.p168a.C2355b;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.entity.APConfig;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.utils.C3681j;
import com.p118d.p119a.p136c.C1947c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* renamed from: com.fimi.soul.biz.update.a */
/* loaded from: classes.dex */
public class C2629a extends AbstractC2636b {

    /* renamed from: f */
    private static final String f9103f = "KEY_APUPDATEBIZ_LASTEST_VERSION";

    /* renamed from: g */
    private static final int f9104g = 1;

    /* renamed from: h */
    private static final String f9105h = "ar934x_US";

    /* renamed from: k */
    private static String f9106k = "192.168.42.100";

    /* renamed from: l */
    private static String f9107l = "192.168.42.150";

    /* renamed from: q */
    private static final int f9108q = 3;

    /* renamed from: j */
    private C2230b f9110j;

    /* renamed from: m */
    private String f9111m;

    /* renamed from: n */
    private long f9112n;

    /* renamed from: o */
    private long f9113o;

    /* renamed from: p */
    private int f9114p;

    /* renamed from: s */
    private C2355b f9116s;

    /* renamed from: t */
    private AbstractC2651g f9117t;

    /* renamed from: i */
    private C2185b f9109i = null;

    /* renamed from: r */
    private boolean f9115r = false;

    public C2629a() {
        this.f9110j = null;
        this.f9116s = null;
        this.f9110j = (C2230b) C2238c.m13128a(EnumC2222d.Volley);
        this.f9116s = new C2355b();
        if (C2441a.m12168a().m12166b() == 1) {
            return;
        }
        f9106k = "192.168.100.1";
        f9107l = "192.168.100.2";
    }

    /* renamed from: c */
    static /* synthetic */ int m11441c(C2629a c2629a) {
        int i = c2629a.f9114p;
        c2629a.f9114p = i + 1;
        return i;
    }

    /* renamed from: c */
    public static String m11442c() {
        return C3681j.m7457v();
    }

    /* renamed from: d */
    public static String m11440d() {
        return String.format("%s%s", C3681j.m7457v(), C3587b.f14543L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.biz.update.AbstractC2636b, com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    public void mo9399a(Message message) {
        super.mo9399a(message);
        if (message.what == 1) {
            if (message.arg1 == 1) {
                this.f9117t.mo6430a(false, message.arg2, 100L, 0);
            } else {
                this.f9117t.mo6430a(true, 0L, 0L, 0);
            }
        }
    }

    /* renamed from: a */
    public void m11450a(AbstractC2651g abstractC2651g) {
        if (i() == null) {
            abstractC2651g.mo6430a(true, 0L, 0L, 0);
            return;
        }
        i().getUrl();
        this.f9111m = m11440d();
        a(i(), this.f9111m, abstractC2651g);
    }

    /* renamed from: a */
    public void m11449a(final AbstractC2651g abstractC2651g, Context context, FirmwareInfo firmwareInfo) {
        if (firmwareInfo.getSysId() == 15) {
            this.f9111m = String.format("%s/%s/%s", C3681j.m7482a(), "firmware", C2654j.m11366a(firmwareInfo.getFileEncode(), firmwareInfo.getVersion()));
        } else if (firmwareInfo.getSysId() == 26) {
            this.f9111m = String.format("%s/%s/%s", C3681j.m7482a(), "firmware", C2654j.m11361b(firmwareInfo.getFileEncode(), firmwareInfo.getVersion()));
        } else if (firmwareInfo.getSysId() == 14) {
            this.f9111m = String.format("%s/%s/%s", C3681j.m7482a(), "firmware", C2654j.m11356c(firmwareInfo.getFileEncode(), firmwareInfo.getVersion()));
        } else if (firmwareInfo.getSysId() == 25) {
            this.f9111m = String.format("%s/%s/%s", C3681j.m7482a(), "firmware", C2654j.m11352d(firmwareInfo.getFileEncode(), firmwareInfo.getVersion()));
        } else {
            this.f9111m = String.format("%s/%s/%s", C3681j.m7482a(), "firmware", C2654j.m11367a(firmwareInfo.getFileEncode()));
        }
        File file = new File(String.format("%s/%s", C3681j.m7482a(), "firmware"));
        if (!file.exists()) {
            file.mkdir();
        }
        new File(this.f9111m);
        if (!new File(this.f9111m).isFile()) {
            abstractC2651g.mo6430a(true, 0L, 0L, 0);
            return;
        }
        if (this.f9109i != null) {
            this.f9109i.m13302h();
            this.f9109i = null;
        }
        this.f9109i = (C2185b) C2238c.m13128a(EnumC2222d.Ftp);
        C2192c m13312c = this.f9109i.m13312c();
        if (firmwareInfo.getSysId() == 14 || firmwareInfo.getSysId() == 25) {
            m13312c.m13300a(true);
            m13312c.a(f9107l);
        } else {
            m13312c.a(f9106k);
        }
        m13312c.a(21);
        this.f9109i.m13328a(new AbstractC2219b() { // from class: com.fimi.soul.biz.update.a.3
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2219b
            /* renamed from: a */
            public void mo11428a(boolean z, String str) {
                if (!z) {
                    abstractC2651g.mo6430a(true, 0L, 0L, 0);
                    return;
                }
                File file2 = new File(C2629a.this.f9111m);
                C2629a.this.f9112n = file2.length();
                C2629a.this.f9113o = 0L;
                C2629a.this.f9109i.m13316b(file2, new AbstractC2183a() { // from class: com.fimi.soul.biz.update.a.3.1
                    @Override // com.fimi.kernel.p157b.p158a.AbstractC2183a
                    /* renamed from: a */
                    public void mo11427a(AbstractC2183a.EnumC2184a enumC2184a, int i) {
                        C2629a.this.f9113o += i;
                        abstractC2651g.mo6430a(enumC2184a == AbstractC2183a.EnumC2184a.Completed || enumC2184a == AbstractC2183a.EnumC2184a.Aborted, C2629a.this.f9113o, C2629a.this.f9112n, 0);
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void m11448a(final AbstractC2653i<UpdateVersonBean> abstractC2653i) {
        this.f9116s.m12496b(new AbstractC2228e<APConfig>() { // from class: com.fimi.soul.biz.update.a.1
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(APConfig aPConfig) {
                UpdateVersonBean updateVersonBean = new UpdateVersonBean();
                if (aPConfig != null && aPConfig.getVersion() != null) {
                    String[] split = aPConfig.getVersion().split("_");
                    updateVersonBean.setNewVersion(split[split.length - 1]);
                    C2629a.this.a(updateVersonBean);
                }
                abstractC2653i.m11374a(updateVersonBean);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(APConfig aPConfig) {
                abstractC2653i.m11374a(new UpdateVersonBean());
            }
        });
    }

    /* renamed from: a */
    public void m11447a(InputStream inputStream, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str, true);
            byte[] bArr = new byte[C1947c.f6940b];
            while (true) {
                int read = inputStream.read(bArr, 0, C1947c.f6940b);
                if (read == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m11443b(AbstractC2651g abstractC2651g) {
        if (this.f9109i != null) {
            this.f9109i.m13302h();
        }
        this.f9117t = abstractC2651g;
        a(new Runnable() { // from class: com.fimi.soul.biz.update.a.2
            @Override // java.lang.Runnable
            public void run() {
                C2629a.this.f9114p = 0;
                C2629a.this.f9115r = true;
                String format = String.format("http://%s:8080/upgrade", C2629a.f9106k);
                while (C2629a.this.f9115r) {
                    try {
                        C2629a.this.f9110j.mo13150a(format, new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.update.a.2.1
                            @Override // com.fimi.kernel.p157b.AbstractC2228e
                            /* renamed from: a  reason: avoid collision after fix types in other method */
                            public void mo8307a(String str) {
                                Log.d("Good", str);
                                try {
                                    int parseInt = Integer.parseInt(str.trim().replace("\n", ""));
                                    Message message = new Message();
                                    message.what = 1;
                                    if (parseInt < 100) {
                                        message.arg1 = 1;
                                        message.arg2 = parseInt;
                                    } else {
                                        message.arg1 = 0;
                                        message.arg2 = 0;
                                        C2629a.this.f9115r = false;
                                    }
                                    C2629a.this.a().sendMessage(message);
                                } catch (Exception e) {
                                    Log.d("Good", "Error");
                                    C2629a.m11441c(C2629a.this);
                                }
                            }

                            @Override // com.fimi.kernel.p157b.AbstractC2228e
                            /* renamed from: b  reason: avoid collision after fix types in other method */
                            public void mo8305b(String str) {
                                C2629a.m11441c(C2629a.this);
                            }
                        });
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public boolean m11446b() {
        if (i() != null && h() != null) {
            try {
                if (Integer.parseInt(i().getNewVersion()) > Integer.parseInt(h().getNewVersion())) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m11438e() {
        try {
            if (this.f9109i == null) {
                return;
            }
            this.f9109i.m13302h();
        } catch (Exception e) {
            C2654j.m11362b("e:" + e.getMessage().toString());
        }
    }
}
