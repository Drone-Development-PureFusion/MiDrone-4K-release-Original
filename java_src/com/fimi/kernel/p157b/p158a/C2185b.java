package com.fimi.kernel.p157b.p158a;

import android.os.Message;
import android.util.Log;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.kernel.p157b.p158a.AbstractC2183a;
import com.fimi.kernel.p157b.p160c.AbstractC2219b;
import it.p235a.p236a.C4852b;
import java.io.File;
/* renamed from: com.fimi.kernel.b.a.b */
/* loaded from: classes.dex */
public class C2185b extends AbstractC2180b implements AbstractC2193d {

    /* renamed from: b */
    private static C2185b f7334b;

    /* renamed from: c */
    private C4852b f7336c;

    /* renamed from: d */
    private C2192c f7337d;

    /* renamed from: g */
    private String f7340g;

    /* renamed from: h */
    private String f7341h;

    /* renamed from: i */
    private File f7342i;

    /* renamed from: a */
    private final String f7335a = C2185b.class.getName();

    /* renamed from: e */
    private AbstractC2219b f7338e = null;

    /* renamed from: f */
    private AbstractC2183a f7339f = null;

    /* renamed from: com.fimi.kernel.b.a.b$a */
    /* loaded from: classes.dex */
    private enum EnumC2191a {
        ConnectServer,
        DownloadFile,
        UploadFile
    }

    private C2185b() {
        this.f7336c = null;
        this.f7337d = null;
        this.f7336c = new C4852b();
        this.f7337d = new C2192c();
    }

    /* renamed from: a */
    private boolean m13323a(String str, int i, String str2, String str3, boolean z) {
        try {
            this.f7336c.m3082a(z);
            if (this.f7336c.m3046l()) {
                return true;
            }
            this.f7336c.m3094a(str, i);
            this.f7336c.m3086a(str2, str3);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static synchronized C2185b m13318b() {
        C2185b c2185b;
        synchronized (C2185b.class) {
            f7334b = new C2185b();
            c2185b = f7334b;
        }
        return c2185b;
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
        boolean z = true;
        if (message.what == EnumC2191a.ConnectServer.ordinal()) {
            if (message.arg1 != 1) {
                z = false;
            }
            if (this.f7338e != null) {
                this.f7338e.mo11428a(z, "SUCCESS");
            }
        }
        if ((message.what == EnumC2191a.DownloadFile.ordinal() || message.what == EnumC2191a.UploadFile.ordinal()) && this.f7339f != null) {
            this.f7339f.mo11427a(AbstractC2183a.EnumC2184a.values()[message.arg1], message.arg2);
        }
    }

    /* renamed from: a */
    public void m13329a(C2192c c2192c) {
        this.f7337d = c2192c;
    }

    /* renamed from: a */
    public void m13328a(AbstractC2219b abstractC2219b) {
        this.f7338e = abstractC2219b;
        a(new Runnable() { // from class: com.fimi.kernel.b.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = EnumC2191a.ConnectServer.ordinal();
                if (C2185b.this.m13308e()) {
                    message.arg1 = 1;
                } else {
                    message.arg1 = 0;
                }
                C2185b.this.a().sendMessage(message);
            }
        });
    }

    /* renamed from: a */
    public void m13327a(File file, AbstractC2183a abstractC2183a) {
        try {
            this.f7336c.m3096a(file, abstractC2183a);
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
        }
    }

    /* renamed from: a */
    public void m13324a(String str, int i, AbstractC2219b abstractC2219b) {
        this.f7337d.a(str);
        this.f7337d.a(i);
        m13328a(abstractC2219b);
    }

    /* renamed from: a */
    public void m13322a(String str, AbstractC2183a abstractC2183a) {
        File file = new File(str);
        try {
            if (abstractC2183a != null) {
                this.f7336c.m3096a(file, abstractC2183a);
            } else {
                this.f7336c.m3099a(file);
            }
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
        }
    }

    /* renamed from: a */
    public void m13321a(String str, AbstractC2219b abstractC2219b) {
        this.f7337d.a(str);
        m13328a(abstractC2219b);
    }

    /* renamed from: a */
    public void m13319a(String str, String str2, AbstractC2183a abstractC2183a) {
        try {
            this.f7336c.m3090a(str, new File(str2), abstractC2183a);
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
        }
    }

    /* renamed from: a */
    public boolean m13326a(String str) {
        return m13323a(str, this.f7337d.b(), this.f7337d.m13298c(), this.f7337d.m13296d(), this.f7337d.m13295e());
    }

    /* renamed from: a */
    public boolean m13325a(String str, int i) {
        return m13323a(str, i, this.f7337d.m13298c(), this.f7337d.m13296d(), this.f7337d.m13295e());
    }

    /* renamed from: a */
    public boolean m13320a(String str, String str2) {
        try {
            this.f7336c.m3073b(str, str2);
            return true;
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
            return false;
        }
    }

    /* renamed from: b */
    public void m13316b(File file, AbstractC2183a abstractC2183a) {
        this.f7342i = file;
        this.f7339f = abstractC2183a;
        a(new Runnable() { // from class: com.fimi.kernel.b.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!C2185b.this.f7342i.isFile()) {
                        return;
                    }
                    C2185b.this.f7336c.m3096a(C2185b.this.f7342i, new AbstractC2183a() { // from class: com.fimi.kernel.b.a.b.3.1
                        @Override // com.fimi.kernel.p157b.p158a.AbstractC2183a
                        /* renamed from: a */
                        public void mo11427a(AbstractC2183a.EnumC2184a enumC2184a, int i) {
                            Message message = new Message();
                            message.what = EnumC2191a.UploadFile.ordinal();
                            message.arg1 = enumC2184a.ordinal();
                            message.arg2 = i;
                            C2185b.this.a().sendMessage(message);
                        }
                    });
                } catch (Exception e) {
                    Log.d(C2185b.this.f7335a, e.toString());
                }
            }
        });
    }

    /* renamed from: b */
    public void m13314b(String str, AbstractC2183a abstractC2183a) {
        this.f7339f = abstractC2183a;
        if (new File(str).isFile()) {
            m13316b(this.f7342i, abstractC2183a);
        }
    }

    /* renamed from: b */
    public void m13313b(String str, String str2, AbstractC2183a abstractC2183a) {
        this.f7339f = abstractC2183a;
        this.f7340g = str;
        this.f7341h = str2;
        a(new Runnable() { // from class: com.fimi.kernel.b.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C2185b.this.f7336c.m3090a(C2185b.this.f7340g, new File(C2185b.this.f7341h), new AbstractC2183a() { // from class: com.fimi.kernel.b.a.b.2.1
                        @Override // com.fimi.kernel.p157b.p158a.AbstractC2183a
                        /* renamed from: a */
                        public void mo11427a(AbstractC2183a.EnumC2184a enumC2184a, int i) {
                            Message message = new Message();
                            message.what = EnumC2191a.DownloadFile.ordinal();
                            message.arg1 = enumC2184a.ordinal();
                            message.arg2 = i;
                            C2185b.this.a().sendMessage(message);
                        }
                    });
                } catch (Exception e) {
                }
            }
        });
    }

    /* renamed from: b */
    public boolean m13315b(String str) {
        try {
            this.f7336c.m3060e(str);
            return true;
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
            return false;
        }
    }

    /* renamed from: c */
    public C2192c m13312c() {
        return this.f7337d;
    }

    /* renamed from: d */
    public boolean m13310d() {
        return this.f7336c.m3046l();
    }

    /* renamed from: e */
    public boolean m13308e() {
        return m13323a(this.f7337d.a(), this.f7337d.b(), this.f7337d.m13298c(), this.f7337d.m13296d(), this.f7337d.m13295e());
    }

    /* renamed from: f */
    public String m13306f() {
        try {
            return this.f7336c.m3031y();
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
            return null;
        }
    }

    /* renamed from: g */
    public String[] m13304g() {
        try {
            return this.f7336c.m3121D();
        } catch (Exception e) {
            Log.d(this.f7335a, e.toString());
            return null;
        }
    }

    /* renamed from: h */
    public void m13302h() {
        try {
            this.f7336c.m3067c(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
