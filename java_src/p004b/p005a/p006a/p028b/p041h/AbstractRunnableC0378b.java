package p004b.p005a.p006a.p028b.p041h;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g;
import p004b.p005a.p006a.p028b.p054o.AbstractC0536o;
import p004b.p005a.p006a.p028b.p057r.C0571e;
import p004b.p005a.p006a.p028b.p057r.C0576j;
/* renamed from: b.a.a.b.h.b */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC0378b<E> extends AbstractC0269b<E> implements AbstractCallableC0401g.AbstractC0402a, Runnable {

    /* renamed from: a */
    public static final int f766a = 4560;

    /* renamed from: b */
    public static final int f767b = 30000;

    /* renamed from: c */
    public static final int f768c = 128;

    /* renamed from: d */
    private static final int f769d = 5000;

    /* renamed from: e */
    private static final int f770e = 100;

    /* renamed from: i */
    private String f771i;

    /* renamed from: j */
    private int f772j;

    /* renamed from: k */
    private InetAddress f773k;

    /* renamed from: l */
    private C0576j f774l;

    /* renamed from: m */
    private int f775m;

    /* renamed from: n */
    private int f776n;

    /* renamed from: o */
    private C0576j f777o;

    /* renamed from: p */
    private BlockingQueue<E> f778p;

    /* renamed from: q */
    private String f779q;

    /* renamed from: r */
    private Future<?> f780r;

    /* renamed from: u */
    private Future<Socket> f781u;

    /* renamed from: v */
    private volatile Socket f782v;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractRunnableC0378b() {
        this.f772j = f766a;
        this.f774l = new C0576j(30000L);
        this.f775m = 128;
        this.f776n = 5000;
        this.f777o = new C0576j(100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public AbstractRunnableC0378b(String str, int i) {
        this.f772j = f766a;
        this.f774l = new C0576j(30000L);
        this.f775m = 128;
        this.f776n = 5000;
        this.f777o = new C0576j(100L);
        this.f771i = str;
        this.f772j = i;
    }

    /* renamed from: a */
    private AbstractCallableC0401g m20728a(InetAddress inetAddress, int i, int i2, long j) {
        AbstractCallableC0401g m20727a = m20727a(inetAddress, i, i2, j);
        m20727a.mo20583a(this);
        m20727a.mo20582a(mo20587b());
        return m20727a;
    }

    @Deprecated
    /* renamed from: a */
    protected static InetAddress m20729a(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private Future<Socket> m20731a(AbstractCallableC0401g abstractCallableC0401g) {
        try {
            return h_().mo20993s().submit(abstractCallableC0401g);
        } catch (RejectedExecutionException e) {
            return null;
        }
    }

    /* renamed from: p */
    private Socket m20714p() {
        try {
            Socket socket = this.f781u.get();
            this.f781u = null;
            return socket;
        } catch (ExecutionException e) {
            return null;
        }
    }

    /* renamed from: q */
    private void m20713q() {
        try {
            try {
                this.f782v.setSoTimeout(this.f776n);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f782v.getOutputStream());
                this.f782v.setSoTimeout(0);
                d(this.f779q + "connection established");
                int i = 0;
                while (true) {
                    E take = this.f778p.take();
                    mo20724b((AbstractRunnableC0378b<E>) take);
                    objectOutputStream.writeObject(mo20733a().mo20212a(take));
                    objectOutputStream.flush();
                    i++;
                    if (i >= 70) {
                        objectOutputStream.reset();
                        i = 0;
                    }
                }
            } catch (IOException e) {
                d(this.f779q + "connection failed: " + e);
                C0571e.m20115a(this.f782v);
                this.f782v = null;
                d(this.f779q + "connection closed");
            }
        } catch (Throwable th) {
            C0571e.m20115a(this.f782v);
            this.f782v = null;
            d(this.f779q + "connection closed");
            throw th;
        }
    }

    /* renamed from: a */
    protected AbstractCallableC0401g m20727a(InetAddress inetAddress, int i, long j, long j2) {
        return new C0394c(inetAddress, i, j, j2);
    }

    /* renamed from: a */
    protected abstract AbstractC0536o<E> mo20733a();

    /* renamed from: a */
    BlockingQueue<E> m20732a(int i) {
        return i <= 0 ? new SynchronousQueue<>() : new ArrayBlockingQueue<>(i);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g.AbstractC0402a
    /* renamed from: a */
    public void mo20578a(AbstractCallableC0401g abstractCallableC0401g, Exception exc) {
        if (exc instanceof InterruptedException) {
            d("connector interrupted");
        } else if (exc instanceof ConnectException) {
            d(this.f779q + "connection refused");
        } else {
            d(this.f779q + exc);
        }
    }

    /* renamed from: a */
    public void m20730a(C0576j c0576j) {
        this.f774l = c0576j;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (e == null || !g_()) {
            return;
        }
        try {
            if (this.f778p.offer(e, this.f777o.m20105b(), TimeUnit.MILLISECONDS)) {
                return;
            }
            d("Dropping event due to timeout limit of [" + this.f777o + "] milliseconds being exceeded");
        } catch (InterruptedException e2) {
            a("Interrupted while appending event to SocketAppender", e2);
        }
    }

    /* renamed from: b */
    protected SocketFactory mo20587b() {
        return SocketFactory.getDefault();
    }

    /* renamed from: b */
    public void m20726b(int i) {
        this.f772j = i;
    }

    /* renamed from: b */
    public void m20725b(C0576j c0576j) {
        this.f777o = c0576j;
    }

    /* renamed from: b */
    protected abstract void mo20724b(E e);

    /* renamed from: b */
    public void m20723b(String str) {
        this.f771i = str;
    }

    /* renamed from: c */
    public void m20722c(int i) {
        this.f775m = i;
    }

    /* renamed from: d */
    protected void m20721d() {
    }

    /* renamed from: d */
    void m20720d(int i) {
        this.f776n = i;
    }

    /* renamed from: e */
    public String m20719e() {
        return this.f771i;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (g_()) {
            return;
        }
        int i = 0;
        if (this.f772j <= 0) {
            i = 1;
            c("No port was configured for appender" + this.f476g + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_port");
        }
        if (this.f771i == null) {
            i++;
            c("No remote host was configured for appender" + this.f476g + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_host");
        }
        if (this.f775m < 0) {
            i++;
            c("Queue size must be non-negative");
        }
        if (i == 0) {
            try {
                this.f773k = InetAddress.getByName(this.f771i);
            } catch (UnknownHostException e) {
                c("unknown host: " + this.f771i);
                i++;
            }
        }
        if (i != 0) {
            return;
        }
        this.f778p = m20732a(this.f775m);
        this.f779q = "remote peer " + this.f771i + ":" + this.f772j + ": ";
        this.f780r = h_().mo20993s().submit(this);
        super.mo20156j();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        if (!g_()) {
            return;
        }
        C0571e.m20115a(this.f782v);
        this.f780r.cancel(true);
        if (this.f781u != null) {
            this.f781u.cancel(true);
        }
        super.mo20155k();
    }

    /* renamed from: l */
    public int m20718l() {
        return this.f772j;
    }

    /* renamed from: m */
    public C0576j m20717m() {
        return this.f774l;
    }

    /* renamed from: n */
    public int m20716n() {
        return this.f775m;
    }

    /* renamed from: o */
    public C0576j m20715o() {
        return this.f777o;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m20721d();
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.f781u = m20731a(m20728a(this.f773k, this.f772j, 0, this.f774l.m20105b()));
                if (this.f781u != null) {
                    this.f782v = m20714p();
                    if (this.f782v == null) {
                        break;
                    }
                    m20713q();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
            }
        }
        d("shutting down");
    }
}
