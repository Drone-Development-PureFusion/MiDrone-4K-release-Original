package p004b.p005a.p006a.p028b;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import p004b.p005a.p006a.p028b.p050l.C0466b;
import p004b.p005a.p006a.p028b.p057r.C0578l;
import p004b.p005a.p006a.p028b.p057r.C0581o;
/* renamed from: b.a.a.b.i */
/* loaded from: classes.dex */
public class C0411i<E> extends C0516o<E> {

    /* renamed from: a */
    protected boolean f915a = true;

    /* renamed from: b */
    protected String f916b = null;

    /* renamed from: e */
    private boolean f917e = false;

    /* renamed from: f */
    private boolean f918f = false;

    /* renamed from: g */
    private boolean f919g = false;

    /* renamed from: f */
    private String m20546f(String str) {
        return C0578l.m20100a() ? C0581o.m20089a(this.f1190s.mo20211a(C0359h.f687Q), str) : str;
    }

    /* renamed from: f */
    private void m20547f(E e) {
        FileChannel m20430a = ((C0466b) l()).m20430a();
        if (m20430a == null) {
            return;
        }
        FileLock fileLock = null;
        try {
            fileLock = m20430a.lock();
            long position = m20430a.position();
            long size = m20430a.size();
            if (size != position) {
                m20430a.position(size);
            }
            super.mo20274b((C0411i<E>) e);
        } finally {
            if (fileLock != null) {
                fileLock.release();
            }
        }
    }

    /* renamed from: a */
    public void mo20347a(String str) {
        if (str == null) {
            this.f916b = null;
        } else {
            this.f916b = str.trim();
        }
    }

    /* renamed from: a */
    public void m20554a(boolean z) {
        this.f917e = z;
    }

    /* renamed from: a */
    public boolean m20555a() {
        return this.f915a;
    }

    /* renamed from: b */
    public final String m20553b() {
        return this.f916b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.C0516o
    /* renamed from: b */
    public void mo20274b(E e) {
        if (this.f917e) {
            m20547f((C0411i<E>) e);
        } else {
            super.mo20274b((C0411i<E>) e);
        }
    }

    /* renamed from: b */
    public void m20551b(boolean z) {
        this.f915a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public boolean m20552b(String str) {
        String m20546f = m20546f(str);
        synchronized (this.f1167d) {
            File file = new File(m20546f);
            if (C0581o.m20088b(file) && !C0581o.m20086c(file)) {
                c("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            }
            C0466b c0466b = new C0466b(file, this.f915a);
            c0466b.a(this.f1190s);
            a((OutputStream) c0466b);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.C0516o
    /* renamed from: c */
    public void mo20273c(E e) {
        if (!this.f918f && this.f919g) {
            this.f918f = true;
            try {
                m20552b(mo20346d());
            } catch (IOException e2) {
                this.f1224j = false;
                a("openFile(" + this.f916b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f915a + ") failed", e2);
            }
        }
        super.mo20273c((C0411i<E>) e);
    }

    /* renamed from: c */
    public void m20550c(boolean z) {
        this.f919g = z;
    }

    /* renamed from: d */
    public String mo20346d() {
        return this.f916b;
    }

    /* renamed from: e */
    public boolean m20549e() {
        return this.f917e;
    }

    /* renamed from: f */
    public boolean m20548f() {
        return this.f919g;
    }

    @Override // p004b.p005a.p006a.p028b.C0516o, p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        boolean z = false;
        String mo20346d = mo20346d();
        if (mo20346d != null) {
            String m20546f = m20546f(mo20346d);
            d("File property is set to [" + m20546f + "]");
            if (this.f917e && !m20555a()) {
                m20551b(true);
                e("Setting \"Append\" property to true on account of \"Prudent\" mode");
            }
            if (!this.f919g) {
                try {
                    m20552b(m20546f);
                } catch (IOException e) {
                    a("openFile(" + m20546f + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f915a + ") failed", e);
                    z = true;
                }
            } else {
                a((OutputStream) new C0507n());
            }
        } else {
            c("\"File\" property not set for appender named [" + this.f1225k + "]");
            z = true;
        }
        if (!z) {
            super.mo20156j();
        }
    }
}
