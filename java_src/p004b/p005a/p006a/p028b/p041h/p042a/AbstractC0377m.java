package p004b.p005a.p006a.p028b.p041h.p042a;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0363b;
import p004b.p005a.p006a.p028b.p057r.C0571e;
/* renamed from: b.a.a.b.h.a.m */
/* loaded from: classes.dex */
public abstract class AbstractC0377m<T extends AbstractRunnableC0363b> implements AbstractC0373j<T> {

    /* renamed from: a */
    private final ServerSocket f765a;

    public AbstractC0377m(ServerSocket serverSocket) {
        this.f765a = serverSocket;
    }

    /* renamed from: a */
    private String m20735a(SocketAddress socketAddress) {
        String obj = socketAddress.toString();
        int indexOf = obj.indexOf("/");
        return indexOf >= 0 ? obj.substring(indexOf + 1) : obj;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0373j
    /* renamed from: a */
    public T mo20736a() {
        Socket accept = this.f765a.accept();
        return mo20734b(m20735a(accept.getRemoteSocketAddress()), accept);
    }

    /* renamed from: b */
    protected abstract T mo20734b(String str, Socket socket);

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0373j, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C0571e.m20116a(this.f765a);
    }

    public String toString() {
        return m20735a(this.f765a.getLocalSocketAddress());
    }
}
