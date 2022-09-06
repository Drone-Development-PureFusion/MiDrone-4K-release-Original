package com.fimi.p151f;

import android.os.SystemClock;
import android.util.Log;
import com.fimi.p139b.p140a.C2085a;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2107f;
import com.fimi.p139b.p145f.C2112b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.f.c */
/* loaded from: classes.dex */
public class C2141c extends C2138a {

    /* renamed from: c */
    private Socket f7178c;

    /* renamed from: d */
    private C2142a f7179d;

    /* renamed from: e */
    private C2143b f7180e;

    /* renamed from: h */
    private boolean f7183h;

    /* renamed from: k */
    private byte[] f7186k;

    /* renamed from: l */
    private C2144c f7187l;

    /* renamed from: f */
    private long f7181f = SystemClock.uptimeMillis();

    /* renamed from: g */
    private long f7182g = SystemClock.uptimeMillis();

    /* renamed from: i */
    private List<C2085a> f7184i = new ArrayList();

    /* renamed from: j */
    private boolean f7185j = false;

    /* renamed from: a */
    int[] f7176a = {193, 199, 201, 202, 203, 204};

    /* renamed from: b */
    boolean f7177b = false;

    /* renamed from: com.fimi.f.c$a */
    /* loaded from: classes.dex */
    public class C2142a extends Thread {

        /* renamed from: b */
        private InputStream f7189b;

        /* renamed from: c */
        private boolean f7190c;

        public C2142a() {
        }

        /* renamed from: a */
        public void m13455a() {
            this.f7190c = true;
            interrupt();
            if (this.f7189b != null) {
                try {
                    this.f7189b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f7189b = C2141c.this.f7178c.getInputStream();
                if (this.f7189b == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.f7189b != null) {
                byte[] bArr = new byte[1024];
                C2107f c2107f = new C2107f();
                while (!this.f7190c) {
                    try {
                        int read = this.f7189b.read(bArr);
                        if (read > 0) {
                            byte[] bArr2 = new byte[read];
                            System.arraycopy(bArr, 0, bArr2, 0, read);
                            String m13657a = C2112b.m13657a(bArr2);
                            for (int i = 0; i < read; i++) {
                                C2104c m13671a = c2107f.m13671a(bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                                if (m13671a != null && m13671a.m13707c() != 48) {
                                    if (m13671a.m13707c() == 95) {
                                    }
                                    if (m13671a.m13707c() == 201) {
                                        Log.d("zhej", " return hex:" + m13657a);
                                    }
                                    C2139b.m13466b().mo6481a(m13671a.m13707c(), m13671a);
                                }
                            }
                        } else {
                            try {
                                Thread.sleep(50L);
                                C2141c.this.b(" sessionhandler read error len=" + read + " closeSession ");
                                C2141c.this.mo13460b();
                            } catch (InterruptedException e2) {
                                return;
                            }
                        }
                    } catch (IOException e3) {
                        C2141c.this.mo13460b();
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.fimi.f.c$b */
    /* loaded from: classes.dex */
    public class C2143b extends Thread {

        /* renamed from: a */
        OutputStream f7191a;

        /* renamed from: c */
        private boolean f7193c;

        /* renamed from: d */
        private int f7194d;

        public C2143b() {
        }

        /* renamed from: a */
        public void m13454a() {
            this.f7193c = true;
            interrupt();
            if (this.f7191a != null) {
                try {
                    this.f7191a.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f7191a = C2141c.this.f7178c.getOutputStream();
                if (this.f7191a == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!this.f7193c) {
                try {
                    synchronized (C2141c.this.f7184i) {
                        if (C2141c.this.f7184i.size() > 0) {
                            for (C2085a c2085a : C2141c.this.f7184i) {
                                try {
                                    C2112b.m13657a(c2085a.f6970a);
                                    if (c2085a.f6971b != 8 || c2085a.f6970a[5] == 48) {
                                        this.f7191a.write(c2085a.f6970a, 0, c2085a.f6971b);
                                    } else {
                                        this.f7191a.write(c2085a.f6970a, 0, c2085a.f6971b);
                                    }
                                } catch (IOException e2) {
                                }
                            }
                            this.f7194d = 0;
                            C2141c.this.f7184i.clear();
                        } else {
                            C2141c.this.m13456e();
                        }
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e3) {
                        return;
                    }
                } catch (Exception e4) {
                    C2141c.this.b(" sessionhandler writethread error " + e4.toString());
                    return;
                }
            }
        }
    }

    /* renamed from: com.fimi.f.c$c */
    /* loaded from: classes.dex */
    public class C2144c extends Thread {

        /* renamed from: b */
        private boolean f7196b = true;

        public C2144c() {
        }

        /* renamed from: a */
        public void m13453a() {
            this.f7196b = false;
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f7196b) {
                try {
                    sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.f7196b) {
                    C2141c.this.m13457d();
                }
            }
        }
    }

    public C2141c(Socket socket) {
        super(socket);
        m13458c();
        this.f7178c = socket;
        a("create a session");
    }

    @Override // com.fimi.p151f.C2138a
    /* renamed from: a */
    public void mo13464a() {
        this.f7179d = new C2142a();
        this.f7179d.start();
        this.f7180e = new C2143b();
        this.f7180e.start();
        this.f7187l = new C2144c();
        this.f7187l.start();
    }

    @Override // com.fimi.p151f.C2138a
    /* renamed from: a */
    public void mo13461a(byte[] bArr, int i) {
        synchronized (this.f7184i) {
            C2085a c2085a = new C2085a();
            c2085a.f6970a = bArr;
            c2085a.f6971b = i;
            this.f7184i.add(c2085a);
            this.f7182g = SystemClock.uptimeMillis();
        }
        m13456e();
    }

    /* renamed from: a */
    public boolean m13463a(int i) {
        for (int i2 = 0; i2 < this.f7176a.length; i2++) {
            if (i == this.f7176a[i2]) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fimi.p151f.C2138a
    /* renamed from: b */
    public void mo13460b() {
        if (this.f7179d != null) {
            this.f7179d.m13455a();
        }
        if (this.f7180e != null) {
            this.f7180e.m13454a();
        }
        if (this.f7187l != null) {
            this.f7187l.m13453a();
        }
        if (this.f7178c != null) {
            try {
                this.f7178c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        C2145d.m13447b().m13445c();
    }

    /* renamed from: c */
    public void m13458c() {
        C2104c c2104c = new C2104c();
        c2104c.m13711a(0, 4, 1, 0, 48);
        this.f7186k = c2104c.m13703f();
    }

    /* renamed from: d */
    public void m13457d() {
        mo13461a(this.f7186k, this.f7186k.length);
    }

    /* renamed from: e */
    public void m13456e() {
        synchronized (this.f7184i) {
            if (this.f7177b) {
                this.f7177b = false;
                this.f7184i.notify();
            } else {
                this.f7177b = true;
                try {
                    this.f7184i.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
