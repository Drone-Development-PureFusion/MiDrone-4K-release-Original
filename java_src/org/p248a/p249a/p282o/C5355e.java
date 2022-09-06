package org.p248a.p249a.p282o;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: org.a.a.o.e */
/* loaded from: classes2.dex */
public final class C5355e {
    /* renamed from: a */
    public static void m1298a(StringBuilder sb, SocketAddress socketAddress) {
        C5351a.m1321a(sb, "Buffer");
        C5351a.m1321a(socketAddress, "Socket address");
        if (!(socketAddress instanceof InetSocketAddress)) {
            sb.append(socketAddress);
            return;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        InetAddress address = inetSocketAddress.getAddress();
        String str = address;
        if (address != null) {
            str = address.getHostAddress();
        }
        sb.append((Object) str).append(C0359h.f671A).append(inetSocketAddress.getPort());
    }
}
