package com.xiaomi.slim;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.slim.g */
/* loaded from: classes2.dex */
public class C4712g extends Thread {

    /* renamed from: a */
    final /* synthetic */ C4711f f19355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4712g(C4711f c4711f, String str) {
        super(str);
        this.f19355a = c4711f;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        C4708c c4708c;
        try {
            c4708c = this.f19355a.f19353w;
            c4708c.m4008a();
        } catch (Exception e) {
            this.f19355a.c(9, e);
        }
    }
}
