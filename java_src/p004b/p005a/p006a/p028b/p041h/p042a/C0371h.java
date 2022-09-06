package p004b.p005a.p006a.p028b.p041h.p042a;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0571e;
/* renamed from: b.a.a.b.h.a.h */
/* loaded from: classes.dex */
class C0371h extends C0527f implements AbstractC0368e {

    /* renamed from: a */
    private final String f750a;

    /* renamed from: b */
    private final Socket f751b;

    /* renamed from: c */
    private final OutputStream f752c;

    /* renamed from: d */
    private BlockingQueue<Serializable> f753d;

    C0371h(String str, OutputStream outputStream) {
        this.f750a = "client " + str + ": ";
        this.f751b = null;
        this.f752c = outputStream;
    }

    public C0371h(String str, Socket socket) {
        this.f750a = "client " + str + ": ";
        this.f751b = socket;
        this.f752c = null;
    }

    /* renamed from: a */
    private ObjectOutputStream m20759a() {
        return this.f751b == null ? new ObjectOutputStream(this.f752c) : new ObjectOutputStream(this.f751b.getOutputStream());
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0368e
    /* renamed from: a */
    public void mo20757a(BlockingQueue<Serializable> blockingQueue) {
        this.f753d = blockingQueue;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0368e
    /* renamed from: a */
    public boolean mo20758a(Serializable serializable) {
        if (this.f753d == null) {
            throw new IllegalStateException("client has no event queue");
        }
        return this.f753d.offer(serializable);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0363b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f751b == null) {
            return;
        }
        C0571e.m20115a(this.f751b);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x011f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3;
        int i;
        d(this.f750a + "connected");
        try {
            try {
                objectOutputStream3 = m20759a();
                int i2 = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        try {
                            objectOutputStream3.writeObject(this.f753d.take());
                            objectOutputStream3.flush();
                            int i3 = i2 + 1;
                            if (i3 >= 70) {
                                try {
                                    objectOutputStream3.reset();
                                    i3 = 0;
                                } catch (InterruptedException e) {
                                    i = 0;
                                    Thread.currentThread().interrupt();
                                    i2 = i;
                                }
                            }
                            i2 = i3;
                        } catch (InterruptedException e2) {
                            i = i2;
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                        c(this.f750a + e);
                        if (objectOutputStream3 != null) {
                            C0571e.m20117a(objectOutputStream3);
                        }
                        close();
                        d(this.f750a + "connection closed");
                        return;
                    } catch (SocketException e4) {
                        e = e4;
                        objectOutputStream2 = objectOutputStream3;
                        try {
                            d(this.f750a + e);
                            if (objectOutputStream2 != null) {
                                C0571e.m20117a(objectOutputStream2);
                            }
                            close();
                            d(this.f750a + "connection closed");
                            return;
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                C0571e.m20117a(objectOutputStream);
                            }
                            close();
                            d(this.f750a + "connection closed");
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        c(this.f750a + e);
                        if (objectOutputStream3 != null) {
                            C0571e.m20117a(objectOutputStream3);
                        }
                        close();
                        d(this.f750a + "connection closed");
                        return;
                    }
                }
                if (objectOutputStream3 != null) {
                    C0571e.m20117a(objectOutputStream3);
                }
                close();
                d(this.f750a + "connection closed");
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                }
                close();
                d(this.f750a + "connection closed");
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            objectOutputStream3 = null;
        } catch (RuntimeException e7) {
            e = e7;
            objectOutputStream3 = null;
        } catch (SocketException e8) {
            e = e8;
            objectOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            close();
            d(this.f750a + "connection closed");
            throw th;
        }
    }
}
