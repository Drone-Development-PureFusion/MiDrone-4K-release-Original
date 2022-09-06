package com.amap.api.services.core;

import android.os.HandlerThread;
import android.os.Message;
import com.amap.api.services.core.C1241l;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.m */
/* loaded from: classes.dex */
public class HandlerThreadC1243m extends HandlerThread {

    /* renamed from: a */
    final /* synthetic */ C1241l f4165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC1243m(C1241l c1241l, String str) {
        super(str);
        this.f4165a = c1241l;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        C1241l.HandlerC1242a handlerC1242a;
        C1241l.HandlerC1242a handlerC1242a2;
        C1241l.HandlerC1242a handlerC1242a3;
        C1241l.HandlerC1242a handlerC1242a4;
        Thread.currentThread().setName("ManifestConfigThread");
        Message message = new Message();
        try {
            message.obj = new C1244n(C1241l.f4160c).m16958a();
        } catch (Throwable th) {
            try {
                C1233d.m17031a(th, "ManifestConfig", "run");
                message.what = 3;
                handlerC1242a3 = this.f4165a.f4161d;
                if (handlerC1242a3 != null) {
                    handlerC1242a4 = this.f4165a.f4161d;
                    handlerC1242a4.sendMessage(message);
                }
            } finally {
                message.what = 3;
                handlerC1242a = this.f4165a.f4161d;
                if (handlerC1242a != null) {
                    handlerC1242a2 = this.f4165a.f4161d;
                    handlerC1242a2.sendMessage(message);
                }
            }
        }
        try {
            sleep(AbstractC0517a.f1169e);
        } catch (InterruptedException e) {
            C1233d.m17031a(e, "ManifestConfig", "mVerfy");
        }
    }
}
