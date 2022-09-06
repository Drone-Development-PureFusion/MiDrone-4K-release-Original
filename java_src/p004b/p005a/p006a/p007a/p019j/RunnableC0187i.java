package p004b.p005a.p006a.p007a.p019j;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
/* renamed from: b.a.a.a.j.i */
/* loaded from: classes.dex */
public class RunnableC0187i implements Runnable {

    /* renamed from: a */
    Socket f298a;

    /* renamed from: b */
    C0151f f299b;

    /* renamed from: c */
    ObjectInputStream f300c;

    /* renamed from: d */
    SocketAddress f301d;

    /* renamed from: e */
    C0148e f302e;

    /* renamed from: f */
    boolean f303f = false;

    /* renamed from: g */
    C0185g f304g;

    public RunnableC0187i(C0185g c0185g, Socket socket, C0151f c0151f) {
        this.f304g = c0185g;
        this.f298a = socket;
        this.f301d = socket.getRemoteSocketAddress();
        this.f299b = c0151f;
        this.f302e = c0151f.m21441a(RunnableC0187i.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m21338a() {
        if (this.f303f) {
            return;
        }
        this.f303f = true;
        try {
        } catch (IOException e) {
            this.f302e.mo75e("Could not close connection.", (Throwable) e);
        } finally {
            this.f300c = null;
        }
        if (this.f300c == null) {
            return;
        }
        this.f300c.close();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f300c = new ObjectInputStream(new BufferedInputStream(this.f298a.getInputStream()));
        } catch (Exception e) {
            this.f302e.mo96c("Could not open ObjectInputStream to " + this.f298a, (Throwable) e);
            this.f303f = true;
        }
        while (!this.f303f) {
            try {
                AbstractC0231d abstractC0231d = (AbstractC0231d) this.f300c.readObject();
                C0148e mo126e = this.f299b.mo126e(abstractC0231d.mo21216f());
                if (mo126e.m21465b(abstractC0231d.mo21220b())) {
                    mo126e.m21473a(abstractC0231d);
                }
            } catch (EOFException e2) {
                this.f302e.mo62i("Caught java.io.EOFException closing connection.");
            } catch (SocketException e3) {
                this.f302e.mo62i("Caught java.net.SocketException closing connection.");
            } catch (IOException e4) {
                this.f302e.mo62i("Caught java.io.IOException: " + e4);
                this.f302e.mo62i("Closing connection.");
            } catch (Exception e5) {
                this.f302e.mo96c("Unexpected exception. Closing connection.", (Throwable) e5);
            }
        }
        this.f304g.m21352a(this);
        m21338a();
    }

    public String toString() {
        return getClass().getName() + this.f301d.toString();
    }
}
