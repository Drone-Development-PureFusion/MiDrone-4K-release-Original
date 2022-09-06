package p004b.p005a.p006a.p007a.p019j.p020a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p057r.C0571e;
/* renamed from: b.a.a.a.j.a.d */
/* loaded from: classes.dex */
class C0175d implements AbstractC0172a {

    /* renamed from: a */
    private final String f264a;

    /* renamed from: b */
    private final Socket f265b;

    /* renamed from: c */
    private final InputStream f266c;

    /* renamed from: d */
    private C0151f f267d;

    /* renamed from: e */
    private C0148e f268e;

    public C0175d(String str, InputStream inputStream) {
        this.f264a = str;
        this.f265b = null;
        this.f266c = inputStream;
    }

    public C0175d(String str, Socket socket) {
        this.f264a = str;
        this.f265b = socket;
        this.f266c = null;
    }

    /* renamed from: a */
    private ObjectInputStream m21380a() {
        return this.f266c != null ? new ObjectInputStream(this.f266c) : new ObjectInputStream(this.f265b.getInputStream());
    }

    @Override // p004b.p005a.p006a.p007a.p019j.p020a.AbstractC0172a
    /* renamed from: a */
    public void mo21379a(C0151f c0151f) {
        this.f267d = c0151f;
        this.f268e = c0151f.mo126e(getClass().getPackage().getName());
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0363b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f265b == null) {
            return;
        }
        C0571e.m20115a(this.f265b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Type inference failed for: r0v0, types: [b.a.a.a.e] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ObjectInputStream objectInputStream;
        RuntimeException e;
        IOException e2;
        ?? r1 = this + ": connected";
        this.f268e.mo62i(r1);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = m21380a();
                while (true) {
                    try {
                        AbstractC0231d abstractC0231d = (AbstractC0231d) objectInputStream.readObject();
                        C0148e mo126e = this.f267d.mo126e(abstractC0231d.mo21216f());
                        if (mo126e.m21465b(abstractC0231d.mo21220b())) {
                            mo126e.m21473a(abstractC0231d);
                        }
                    } catch (EOFException e3) {
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            C0571e.m20117a(objectInputStream2);
                        }
                        close();
                        this.f268e.mo62i(this + ": connection closed");
                        return;
                    } catch (IOException e4) {
                        e2 = e4;
                        this.f268e.mo62i(this + ": " + e2);
                        if (objectInputStream != null) {
                            C0571e.m20117a(objectInputStream);
                        }
                        close();
                        this.f268e.mo62i(this + ": connection closed");
                        return;
                    } catch (ClassNotFoundException e5) {
                        this.f268e.mo64h(this + ": unknown event class");
                        if (objectInputStream != null) {
                            C0571e.m20117a(objectInputStream);
                        }
                        close();
                        this.f268e.mo62i(this + ": connection closed");
                        return;
                    } catch (RuntimeException e6) {
                        e = e6;
                        this.f268e.mo64h(this + ": " + e);
                        if (objectInputStream != null) {
                            C0571e.m20117a(objectInputStream);
                        }
                        close();
                        this.f268e.mo62i(this + ": connection closed");
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    C0571e.m20117a((Closeable) r1);
                }
                close();
                this.f268e.mo62i(this + ": connection closed");
                throw th;
            }
        } catch (EOFException e7) {
        } catch (IOException e8) {
            objectInputStream = null;
            e2 = e8;
        } catch (ClassNotFoundException e9) {
            objectInputStream = null;
        } catch (RuntimeException e10) {
            objectInputStream = null;
            e = e10;
        } catch (Throwable th3) {
            r1 = 0;
            th = th3;
            if (r1 != 0) {
            }
            close();
            this.f268e.mo62i(this + ": connection closed");
            throw th;
        }
    }

    public String toString() {
        return "client " + this.f264a;
    }
}
