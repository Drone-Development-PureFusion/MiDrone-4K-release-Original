package p004b.p005a.p006a.p028b.p041h;

import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.SocketFactory;
import p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g;
/* renamed from: b.a.a.b.h.h */
/* loaded from: classes.dex */
public class C0403h implements AbstractCallableC0401g {

    /* renamed from: a */
    private final Lock f856a;

    /* renamed from: b */
    private final Condition f857b;

    /* renamed from: c */
    private final InetAddress f858c;

    /* renamed from: d */
    private final int f859d;

    /* renamed from: e */
    private AbstractCallableC0401g.AbstractC0402a f860e;

    /* renamed from: f */
    private SocketFactory f861f;

    /* renamed from: g */
    private AbstractC0406b f862g;

    /* renamed from: h */
    private Socket f863h;

    /* renamed from: b.a.a.b.h.h$a */
    /* loaded from: classes.dex */
    private static class C0405a implements AbstractCallableC0401g.AbstractC0402a {
        private C0405a() {
        }

        @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g.AbstractC0402a
        /* renamed from: a */
        public void mo20578a(AbstractCallableC0401g abstractCallableC0401g, Exception exc) {
            System.out.println(exc);
        }
    }

    /* renamed from: b.a.a.b.h.h$b */
    /* loaded from: classes.dex */
    public interface AbstractC0406b {
        /* renamed from: a */
        int mo20577a();
    }

    /* renamed from: b.a.a.b.h.h$c */
    /* loaded from: classes.dex */
    private static class C0407c implements AbstractC0406b {

        /* renamed from: a */
        private final int f864a;

        /* renamed from: b */
        private int f865b;

        public C0407c(int i, int i2) {
            this.f865b = i;
            this.f864a = i2;
        }

        @Override // p004b.p005a.p006a.p028b.p041h.C0403h.AbstractC0406b
        /* renamed from: a */
        public int mo20577a() {
            int i = this.f865b;
            this.f865b = this.f864a;
            return i;
        }
    }

    public C0403h(InetAddress inetAddress, int i, int i2, int i3) {
        this(inetAddress, i, new C0407c(i2, i3));
    }

    public C0403h(InetAddress inetAddress, int i, AbstractC0406b abstractC0406b) {
        this.f856a = new ReentrantLock();
        this.f857b = this.f856a.newCondition();
        this.f858c = inetAddress;
        this.f859d = i;
        this.f862g = abstractC0406b;
    }

    /* renamed from: d */
    private void m20579d() {
        this.f856a.lock();
        try {
            this.f857b.signalAll();
        } finally {
            this.f856a.unlock();
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Socket call() {
        return null;
    }

    /* renamed from: a */
    public Socket m20584a(long j) {
        this.f856a.lock();
        boolean z = false;
        while (this.f863h == null && !z) {
            try {
                z = !this.f857b.await(j, TimeUnit.MILLISECONDS);
            } finally {
                this.f856a.unlock();
            }
        }
        return this.f863h;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g
    /* renamed from: a */
    public void mo20583a(AbstractCallableC0401g.AbstractC0402a abstractC0402a) {
        this.f860e = abstractC0402a;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g
    /* renamed from: a */
    public void mo20582a(SocketFactory socketFactory) {
        this.f861f = socketFactory;
    }

    /* renamed from: b */
    public void m20581b() {
        if (this.f863h != null) {
            throw new IllegalStateException("connector cannot be reused");
        }
        if (this.f860e == null) {
            this.f860e = new C0405a();
        }
        if (this.f861f == null) {
            this.f861f = SocketFactory.getDefault();
        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(this.f862g.mo20577a());
                try {
                    this.f863h = this.f861f.createSocket(this.f858c, this.f859d);
                    m20579d();
                    return;
                } catch (Exception e) {
                    this.f860e.mo20578a(this, e);
                }
            } catch (InterruptedException e2) {
                this.f860e.mo20578a(this, e2);
                return;
            }
        }
    }

    /* renamed from: c */
    public Socket m20580c() {
        return m20584a(Long.MAX_VALUE);
    }
}
