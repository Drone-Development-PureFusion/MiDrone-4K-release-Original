package p004b.p005a.p006a.p007a.p019j;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import javax.net.SocketFactory;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g;
import p004b.p005a.p006a.p028b.p041h.C0394c;
import p004b.p005a.p006a.p028b.p057r.C0571e;
/* renamed from: b.a.a.a.j.j */
/* loaded from: classes.dex */
public class RunnableC0188j extends AbstractC0180b implements AbstractCallableC0401g.AbstractC0402a, Runnable {

    /* renamed from: a */
    private static final int f305a = 5000;

    /* renamed from: b */
    private String f306b;

    /* renamed from: c */
    private InetAddress f307c;

    /* renamed from: d */
    private int f308d;

    /* renamed from: e */
    private int f309e;

    /* renamed from: f */
    private int f310f = 5000;

    /* renamed from: g */
    private String f311g;

    /* renamed from: h */
    private volatile Socket f312h;

    /* renamed from: i */
    private Future<Socket> f313i;

    /* renamed from: a */
    private Future<Socket> m21334a(AbstractCallableC0401g abstractCallableC0401g) {
        try {
            return h_().mo20993s().submit(abstractCallableC0401g);
        } catch (RejectedExecutionException e) {
            return null;
        }
    }

    /* renamed from: a */
    private void m21335a(C0151f c0151f) {
        try {
            try {
                try {
                    try {
                        this.f312h.setSoTimeout(this.f310f);
                        ObjectInputStream objectInputStream = new ObjectInputStream(this.f312h.getInputStream());
                        this.f312h.setSoTimeout(0);
                        d(this.f311g + "connection established");
                        while (true) {
                            AbstractC0231d abstractC0231d = (AbstractC0231d) objectInputStream.readObject();
                            C0148e mo126e = c0151f.mo126e(abstractC0231d.mo21216f());
                            if (mo126e.m21465b(abstractC0231d.mo21220b())) {
                                mo126e.m21473a(abstractC0231d);
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        d(this.f311g + "unknown event class: " + e);
                        C0571e.m20115a(this.f312h);
                        this.f312h = null;
                        d(this.f311g + "connection closed");
                    }
                } catch (IOException e2) {
                    d(this.f311g + "connection failed: " + e2);
                    C0571e.m20115a(this.f312h);
                    this.f312h = null;
                    d(this.f311g + "connection closed");
                }
            } catch (EOFException e3) {
                d(this.f311g + "end-of-stream detected");
                C0571e.m20115a(this.f312h);
                this.f312h = null;
                d(this.f311g + "connection closed");
            }
        } catch (Throwable th) {
            C0571e.m20115a(this.f312h);
            this.f312h = null;
            d(this.f311g + "connection closed");
            throw th;
        }
    }

    /* renamed from: b */
    private AbstractCallableC0401g m21329b(InetAddress inetAddress, int i, int i2, int i3) {
        AbstractCallableC0401g m21332a = m21332a(inetAddress, i, i2, i3);
        m21332a.mo20583a(this);
        m21332a.mo20582a(mo21326e());
        return m21332a;
    }

    /* renamed from: f */
    private Socket m21325f() {
        try {
            Socket socket = this.f313i.get();
            this.f313i = null;
            return socket;
        } catch (ExecutionException e) {
            return null;
        }
    }

    /* renamed from: a */
    protected AbstractCallableC0401g m21332a(InetAddress inetAddress, int i, int i2, int i3) {
        return new C0394c(inetAddress, i, i2, i3);
    }

    /* renamed from: a */
    public void m21336a(int i) {
        this.f308d = i;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g.AbstractC0402a
    /* renamed from: a */
    public void mo20578a(AbstractCallableC0401g abstractCallableC0401g, Exception exc) {
        if (exc instanceof InterruptedException) {
            d("connector interrupted");
        } else if (exc instanceof ConnectException) {
            d(this.f311g + "connection refused");
        } else {
            d(this.f311g + exc);
        }
    }

    /* renamed from: a */
    public void m21333a(String str) {
        this.f306b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: a */
    public boolean mo21337a() {
        int i;
        if (this.f308d == 0) {
            c("No port was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_port");
            i = 1;
        } else {
            i = 0;
        }
        if (this.f306b == null) {
            i++;
            c("No host name or address was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_host");
        }
        if (this.f309e == 0) {
            this.f309e = 30000;
        }
        if (i == 0) {
            try {
                this.f307c = InetAddress.getByName(this.f306b);
            } catch (UnknownHostException e) {
                c("unknown host: " + this.f306b);
                i++;
            }
        }
        if (i == 0) {
            this.f311g = "receiver " + this.f306b + ":" + this.f308d + ": ";
        }
        return i == 0;
    }

    @Override // p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: b */
    protected void mo21331b() {
        if (this.f312h != null) {
            C0571e.m20115a(this.f312h);
        }
    }

    /* renamed from: b */
    public void m21330b(int i) {
        this.f309e = i;
    }

    /* renamed from: c */
    public void m21328c(int i) {
        this.f310f = i;
    }

    @Override // p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: d */
    protected Runnable mo21327d() {
        return this;
    }

    /* renamed from: e */
    protected SocketFactory mo21326e() {
        return SocketFactory.getDefault();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C0151f c0151f = (C0151f) h_();
            while (!Thread.currentThread().isInterrupted()) {
                this.f313i = m21334a(m21329b(this.f307c, this.f308d, 0, this.f309e));
                if (this.f313i != null) {
                    this.f312h = m21325f();
                    if (this.f312h == null) {
                        break;
                    }
                    m21335a(c0151f);
                } else {
                    break;
                }
            }
        } catch (InterruptedException e) {
        }
        d("shutting down");
    }
}
