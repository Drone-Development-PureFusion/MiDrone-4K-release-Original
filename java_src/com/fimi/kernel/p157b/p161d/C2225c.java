package com.fimi.kernel.p157b.p161d;

import android.os.Message;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.kernel.p157b.p160c.AbstractC2218a;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.kernel.b.d.c */
/* loaded from: classes.dex */
public class C2225c extends AbstractC2180b implements AbstractC2223a {

    /* renamed from: f */
    private static C2225c f7429f = null;

    /* renamed from: j */
    private static final String f7430j = "SocketNetworkManager";

    /* renamed from: d */
    private DataOutputStream f7434d;

    /* renamed from: e */
    private DataInputStream f7435e;

    /* renamed from: c */
    private Socket f7433c = null;

    /* renamed from: g */
    private List<AbstractC2221d> f7436g = new ArrayList();

    /* renamed from: h */
    private List<AbstractC2218a> f7437h = new ArrayList();

    /* renamed from: i */
    private boolean f7438i = true;

    /* renamed from: a */
    boolean f7431a = true;

    /* renamed from: k */
    private StringBuffer f7439k = new StringBuffer();

    /* renamed from: b */
    private C2227d f7432b = new C2227d();

    /* renamed from: c */
    public static synchronized C2225c m13174c() {
        C2225c c2225c;
        synchronized (C2225c.class) {
            if (f7429f == null) {
                f7429f = new C2225c();
            }
            c2225c = f7429f;
        }
        return c2225c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13172c(String str) {
        this.f7431a = false;
        Message message = new Message();
        message.obj = str;
        a().sendMessage(message);
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        for (AbstractC2221d abstractC2221d : this.f7436g) {
            abstractC2221d.mo6431a(message.obj.toString());
        }
    }

    /* renamed from: a */
    public void m13189a(AbstractC2218a abstractC2218a) {
        if (this.f7437h.contains(abstractC2218a)) {
            this.f7437h.remove(abstractC2218a);
        }
    }

    /* renamed from: a */
    public void m13188a(AbstractC2221d abstractC2221d) {
        if (this.f7436g.contains(abstractC2221d)) {
            this.f7436g.remove(abstractC2221d);
        }
    }

    /* renamed from: a */
    public void m13184a(C2227d c2227d) {
        this.f7432b = c2227d;
    }

    /* renamed from: a */
    public void m13181a(byte[] bArr) {
        try {
            if (this.f7438i && this.f7432b.m13159c()) {
                m13164h();
            }
            if (this.f7434d == null) {
                return;
            }
            this.f7434d.write(bArr);
            this.f7434d.flush();
        } catch (IOException e) {
            this.f7438i = true;
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m13180a(byte[] bArr, int i, int i2) {
        try {
            if (this.f7438i && this.f7432b.m13159c()) {
                m13164h();
            }
            this.f7434d.write(bArr, i, i2);
            this.f7434d.flush();
        } catch (IOException e) {
            this.f7438i = true;
        }
    }

    /* renamed from: a */
    public boolean m13183a(String str) {
        this.f7432b.a(str);
        return m13171d();
    }

    /* renamed from: a */
    public boolean m13182a(String str, int i) {
        this.f7432b.a(str);
        this.f7432b.a(i);
        return m13171d();
    }

    /* renamed from: b */
    public void m13178b(AbstractC2218a abstractC2218a) {
        if (abstractC2218a != null) {
            this.f7437h.add(abstractC2218a);
        }
    }

    /* renamed from: b */
    public void m13177b(AbstractC2221d abstractC2221d) {
        if (abstractC2221d != null) {
            this.f7436g.add(abstractC2221d);
        }
    }

    /* renamed from: b */
    public void m13175b(String str) {
        m13181a(str.getBytes());
    }

    /* renamed from: b */
    public boolean m13179b() {
        if (this.f7433c == null) {
            return false;
        }
        return this.f7433c.isConnected();
    }

    /* renamed from: d */
    public boolean m13171d() {
        try {
            this.f7433c = new Socket(this.f7432b.a(), this.f7432b.b());
            this.f7433c.setSoLinger(true, 0);
            this.f7434d = new DataOutputStream(this.f7433c.getOutputStream());
            this.f7435e = new DataInputStream(this.f7433c.getInputStream());
            a(new Runnable() { // from class: com.fimi.kernel.b.d.c.1
                @Override // java.lang.Runnable
                public void run() {
                    byte[] bArr = new byte[C2225c.this.f7432b.m13157e()];
                    do {
                        if (C2225c.this.f7433c.isConnected()) {
                            while (true) {
                                try {
                                    C2225c.this.f7438i = false;
                                    int read = C2225c.this.f7435e.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else if (C2225c.this.f7437h.size() > 0) {
                                        for (AbstractC2218a abstractC2218a : C2225c.this.f7437h) {
                                            abstractC2218a.mo12328a(read, bArr);
                                        }
                                    } else {
                                        String str = new String(bArr, 0, read, C2225c.this.f7432b.m13156f());
                                        if (C2225c.this.f7432b.m13158d()) {
                                            C2225c.this.m13172c(str);
                                        } else {
                                            String replace = str.replace(" ", "");
                                            if (replace.startsWith("{\"rval\":") || replace.startsWith("{\"msg_id\"") || replace.startsWith("{\"token\"")) {
                                                C2225c.this.f7439k.delete(0, C2225c.this.f7439k.length());
                                                C2225c.this.f7431a = true;
                                            }
                                            if (C2225c.this.f7431a) {
                                                C2225c.this.f7439k.append(str);
                                                if (C2225c.this.f7439k.toString().contains(":1282") && (C2225c.this.f7439k.length() > 50000 || str.endsWith("]}"))) {
                                                    String stringBuffer = C2225c.this.f7439k.toString();
                                                    if (stringBuffer.length() > 50000) {
                                                        String substring = stringBuffer.substring(0, 50000);
                                                        stringBuffer = substring.substring(0, substring.lastIndexOf("}") + 1) + "]}";
                                                    }
                                                    C2225c.this.m13172c(stringBuffer);
                                                    C2225c.this.f7439k.delete(0, C2225c.this.f7439k.length());
                                                } else if (!C2225c.this.f7439k.toString().contains(":1282") && str.endsWith("}")) {
                                                    C2225c.this.m13172c(C2225c.this.f7439k.toString());
                                                    C2225c.this.f7439k.delete(0, C2225c.this.f7439k.length());
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    C2225c.this.f7438i = true;
                                    e.printStackTrace();
                                    return;
                                }
                            }
                        }
                    } while (!C2225c.this.f7438i);
                }
            });
            return true;
        } catch (Exception e) {
            this.f7438i = true;
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: e */
    public boolean m13169e() {
        return this.f7438i;
    }

    /* renamed from: f */
    public C2227d m13167f() {
        return this.f7432b;
    }

    /* renamed from: g */
    public void m13165g() {
        try {
            this.f7434d.close();
            this.f7434d = null;
        } catch (Exception e) {
        }
        try {
            this.f7435e.close();
            this.f7435e = null;
        } catch (Exception e2) {
        }
        try {
            this.f7433c.close();
        } catch (Exception e3) {
        }
        this.f7438i = true;
    }

    /* renamed from: h */
    protected boolean m13164h() {
        m13165g();
        m13171d();
        return false;
    }
}
