package com.fimi.soul.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
/* renamed from: com.fimi.soul.utils.i */
/* loaded from: classes.dex */
public class C3680i extends Thread {

    /* renamed from: a */
    private InetAddress f14931a;

    /* renamed from: b */
    private String f14932b;

    public C3680i(String str) {
        this.f14932b = str;
    }

    /* renamed from: a */
    private synchronized void m7483a(InetAddress inetAddress) {
        this.f14931a = inetAddress;
    }

    /* renamed from: a */
    public synchronized String m7484a() {
        return this.f14931a != null ? this.f14931a.getHostAddress() : null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            m7483a(InetAddress.getByName(this.f14932b));
        } catch (UnknownHostException e) {
        }
    }
}
