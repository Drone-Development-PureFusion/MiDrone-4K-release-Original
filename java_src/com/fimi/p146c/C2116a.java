package com.fimi.p146c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.File;
/* renamed from: com.fimi.c.a */
/* loaded from: classes.dex */
public class C2116a extends Thread {

    /* renamed from: a */
    private Handler f7068a;

    /* renamed from: b */
    private File f7069b;

    /* renamed from: c */
    private String f7070c;

    /* renamed from: d */
    private File[] f7071d;

    /* renamed from: e */
    private boolean f7072e;

    /* renamed from: a */
    public Handler m13628a() {
        return this.f7068a;
    }

    /* renamed from: a */
    public void m13627a(Handler handler) {
        this.f7068a = handler;
    }

    /* renamed from: a */
    public void m13626a(File file) {
        this.f7069b = file;
    }

    /* renamed from: a */
    public void m13625a(String str) {
        this.f7070c = str;
    }

    /* renamed from: a */
    public void m13624a(boolean z) {
        this.f7072e = z;
    }

    /* renamed from: a */
    public void m13623a(File[] fileArr) {
        this.f7071d = fileArr;
    }

    /* renamed from: b */
    public File m13622b() {
        return this.f7069b;
    }

    /* renamed from: c */
    public File[] m13621c() {
        return this.f7071d;
    }

    /* renamed from: d */
    public boolean m13620d() {
        return this.f7072e;
    }

    /* renamed from: e */
    public String m13619e() {
        return this.f7070c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int m13615a = this.f7072e ? C2117b.m13615a(this.f7070c + ".zip", new File[]{this.f7069b}) : C2117b.m13616a(this.f7069b.getAbsolutePath(), this.f7070c);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("OPTION_STATUS", m13615a);
        message.setData(bundle);
        this.f7068a.sendMessage(message);
    }
}
