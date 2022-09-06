package com.xiaomi.smack;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.xiaomi.smack.c */
/* loaded from: classes2.dex */
public class C4716c {
    /* renamed from: a */
    public static int m3954a(Throwable th) {
        Throwable m3925a = (!(th instanceof C4727l) || ((C4727l) th).m3925a() == null) ? th : ((C4727l) th).m3925a();
        String message = m3925a.getMessage();
        if (m3925a.getCause() != null) {
            message = m3925a.getCause().getMessage();
        }
        if (m3925a instanceof SocketTimeoutException) {
            return 105;
        }
        if (!(m3925a instanceof SocketException)) {
            return m3925a instanceof UnknownHostException ? Opcodes.DMUL : th instanceof C4727l ? 399 : 0;
        } else if (message.indexOf("Network is unreachable") != -1) {
            return 102;
        } else {
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return Opcodes.LDIV;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
        }
    }
}
