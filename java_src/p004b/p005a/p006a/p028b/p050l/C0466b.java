package p004b.p005a.p006a.p028b.p050l;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
/* renamed from: b.a.a.b.l.b */
/* loaded from: classes.dex */
public class C0466b extends AbstractC0467c {

    /* renamed from: d */
    private File f1031d;

    /* renamed from: e */
    private FileOutputStream f1032e;

    public C0466b(File file, boolean z) {
        this.f1031d = file;
        this.f1032e = new FileOutputStream(file, z);
        this.f1034b = new BufferedOutputStream(this.f1032e);
        this.f1035c = true;
    }

    /* renamed from: a */
    public FileChannel m20430a() {
        if (this.f1034b == null) {
            return null;
        }
        return this.f1032e.getChannel();
    }

    /* renamed from: b */
    public File m20429b() {
        return this.f1031d;
    }

    @Override // p004b.p005a.p006a.p028b.p050l.AbstractC0467c
    /* renamed from: c */
    String mo20420c() {
        return "file [" + this.f1031d + "]";
    }

    @Override // p004b.p005a.p006a.p028b.p050l.AbstractC0467c
    /* renamed from: d */
    OutputStream mo20419d() {
        this.f1032e = new FileOutputStream(this.f1031d, true);
        return new BufferedOutputStream(this.f1032e);
    }

    public String toString() {
        return "c.q.l.c.recovery.ResilientFileOutputStream@" + System.identityHashCode(this);
    }
}
