package com.xiaomi.smack;

import com.xiaomi.smack.packet.C4737g;
import com.xiaomi.smack.packet.C4738h;
import java.io.PrintStream;
import java.io.PrintWriter;
/* renamed from: com.xiaomi.smack.l */
/* loaded from: classes.dex */
public class C4727l extends Exception {

    /* renamed from: a */
    private C4737g f19408a;

    /* renamed from: b */
    private C4738h f19409b;

    /* renamed from: c */
    private Throwable f19410c;

    public C4727l() {
        this.f19408a = null;
        this.f19409b = null;
        this.f19410c = null;
    }

    public C4727l(C4737g c4737g) {
        this.f19408a = null;
        this.f19409b = null;
        this.f19410c = null;
        this.f19408a = c4737g;
    }

    public C4727l(String str) {
        super(str);
        this.f19408a = null;
        this.f19409b = null;
        this.f19410c = null;
    }

    public C4727l(String str, Throwable th) {
        super(str);
        this.f19408a = null;
        this.f19409b = null;
        this.f19410c = null;
        this.f19410c = th;
    }

    public C4727l(Throwable th) {
        this.f19408a = null;
        this.f19409b = null;
        this.f19410c = null;
        this.f19410c = th;
    }

    /* renamed from: a */
    public Throwable m3925a() {
        return this.f19410c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f19409b == null) ? (message != null || this.f19408a == null) ? message : this.f19408a.toString() : this.f19409b.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f19410c != null) {
            printStream.println("Nested Exception: ");
            this.f19410c.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f19410c != null) {
            printWriter.println("Nested Exception: ");
            this.f19410c.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f19409b != null) {
            sb.append(this.f19409b);
        }
        if (this.f19408a != null) {
            sb.append(this.f19408a);
        }
        if (this.f19410c != null) {
            sb.append("\n  -- caused by: ").append(this.f19410c);
        }
        return sb.toString();
    }
}
