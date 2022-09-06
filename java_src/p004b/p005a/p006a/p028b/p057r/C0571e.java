package p004b.p005a.p006a.p028b.p057r;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/* renamed from: b.a.a.b.r.e */
/* loaded from: classes.dex */
public class C0571e {
    /* renamed from: a */
    public static void m20117a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    /* renamed from: a */
    public static void m20116a(ServerSocket serverSocket) {
        if (serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
        }
    }

    /* renamed from: a */
    public static void m20115a(Socket socket) {
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException e) {
        }
    }
}
