package com.fimi.p138a;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* renamed from: com.fimi.a.b */
/* loaded from: classes.dex */
public class C2082b extends Thread {

    /* renamed from: a */
    public static final int f6961a = 0;

    /* renamed from: b */
    private static int f6962b = -1;

    /* renamed from: c */
    private static int f6963c = 0;

    /* renamed from: d */
    private Handler f6964d = new Handler() { // from class: com.fimi.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Log.i("moweiru", "=========================");
            C2082b.m13743a();
            C2082b.f6963c %= Integer.MAX_VALUE;
        }
    };

    /* renamed from: a */
    static /* synthetic */ int m13743a() {
        int i = f6963c;
        f6963c = i + 1;
        return i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        while (true) {
            this.f6964d.sendEmptyMessage(0);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (f6963c == f6962b) {
                throw new C2081a();
            }
            f6962b = f6963c;
        }
    }
}
