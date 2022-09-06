package p004b.p005a.p006a.p007a.p019j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.net.ServerSocketFactory;
import org.p318d.AbstractC5744c;
import org.p318d.C5748d;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p015g.C0157a;
/* renamed from: b.a.a.a.j.g */
/* loaded from: classes.dex */
public class C0185g extends Thread {

    /* renamed from: b */
    private final int f290b;

    /* renamed from: c */
    private final C0151f f291c;

    /* renamed from: e */
    private ServerSocket f293e;

    /* renamed from: g */
    private CountDownLatch f295g;

    /* renamed from: a */
    AbstractC5744c f289a = C5748d.m50a(C0185g.class);

    /* renamed from: d */
    private boolean f292d = false;

    /* renamed from: f */
    private List<RunnableC0187i> f294f = new ArrayList();

    public C0185g(C0151f c0151f, int i) {
        this.f291c = c0151f;
        this.f290b = i;
    }

    /* renamed from: a */
    public static void m21353a(C0151f c0151f, String str) {
        C0157a c0157a = new C0157a();
        c0151f.mo20999f();
        c0157a.a(c0151f);
        c0157a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m21351a(Class<? extends C0185g> cls, String[] strArr) {
        int i;
        if (strArr.length == 2) {
            i = m21346b(strArr[0]);
        } else {
            m21350a("Wrong number of arguments.");
            i = -1;
        }
        String str = strArr[1];
        C0151f c0151f = (C0151f) C5748d.m40c();
        m21353a(c0151f, str);
        new C0185g(c0151f, i).start();
    }

    /* renamed from: a */
    static void m21350a(String str) {
        System.err.println(str);
        System.err.println("Usage: java " + C0185g.class.getName() + " port configFile");
        System.exit(1);
    }

    /* renamed from: b */
    static int m21346b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            m21350a("Could not interpret port number [" + str + "].");
            return -1;
        }
    }

    /* renamed from: b */
    public static void m21345b(String[] strArr) {
        m21351a(C0185g.class, strArr);
    }

    /* renamed from: a */
    protected String m21349a(Socket socket) {
        return String.format("Logback SocketNode (client: %s)", socket.getRemoteSocketAddress());
    }

    /* renamed from: a */
    protected ServerSocketFactory mo21354a() {
        return ServerSocketFactory.getDefault();
    }

    /* renamed from: a */
    public void m21352a(RunnableC0187i runnableC0187i) {
        this.f289a.mo108b("Removing {}", runnableC0187i);
        synchronized (this.f294f) {
            this.f294f.remove(runnableC0187i);
        }
    }

    /* renamed from: a */
    void m21348a(CountDownLatch countDownLatch) {
        this.f295g = countDownLatch;
    }

    /* renamed from: b */
    protected String m21347b() {
        return String.format("Logback %s (port %d)", getClass().getSimpleName(), Integer.valueOf(this.f290b));
    }

    /* renamed from: c */
    void m21344c() {
        if (this.f295g == null || this.f295g.getCount() == 0) {
            return;
        }
        this.f295g.countDown();
    }

    /* renamed from: d */
    public CountDownLatch m21343d() {
        return this.f295g;
    }

    /* renamed from: e */
    public boolean m21342e() {
        return this.f292d;
    }

    /* renamed from: f */
    public void m21341f() {
        this.f292d = true;
        if (this.f293e != null) {
            try {
                this.f293e.close();
            } catch (IOException e) {
                this.f289a.mo96c("Failed to close serverSocket", (Throwable) e);
            } finally {
                this.f293e = null;
            }
        }
        this.f289a.mo62i("closing this server");
        synchronized (this.f294f) {
            for (RunnableC0187i runnableC0187i : this.f294f) {
                runnableC0187i.m21338a();
            }
        }
        if (this.f294f.size() != 0) {
            this.f289a.mo60j("Was expecting a 0-sized socketNodeList after server shutdown");
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.currentThread().setName(m21347b());
            this.f289a.mo62i("Listening on port " + this.f290b);
            this.f293e = mo21354a().createServerSocket(this.f290b);
            while (!this.f292d) {
                this.f289a.mo62i("Waiting to accept a new client.");
                m21344c();
                Socket accept = this.f293e.accept();
                this.f289a.mo62i("Connected to client at " + accept.getInetAddress());
                this.f289a.mo62i("Starting new socket node.");
                RunnableC0187i runnableC0187i = new RunnableC0187i(this, accept, this.f291c);
                synchronized (this.f294f) {
                    this.f294f.add(runnableC0187i);
                }
                new Thread(runnableC0187i, m21349a(accept)).start();
            }
        } catch (Exception e) {
            if (this.f292d) {
                this.f289a.mo62i("Exception in run method for a closed server. This is normal.");
            } else {
                this.f289a.mo96c("Unexpected failure in run method", (Throwable) e);
            }
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
