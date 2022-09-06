package org.p248a.p249a.p267h;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.h.f */
/* loaded from: classes.dex */
public class C5141f extends AbstractC5136a implements Cloneable {

    /* renamed from: e */
    protected final File f21804e;

    public C5141f(File file) {
        this.f21804e = (File) C5351a.m1321a(file, "File");
    }

    @Deprecated
    public C5141f(File file, String str) {
        this.f21804e = (File) C5351a.m1321a(file, "File");
        a(str);
    }

    public C5141f(File file, C5140e c5140e) {
        this.f21804e = (File) C5351a.m1321a(file, "File");
        if (c5140e != null) {
            a(c5140e.toString());
        }
    }

    public Object clone() {
        return super.clone();
    }

    public InputStream getContent() {
        return new FileInputStream(this.f21804e);
    }

    public long getContentLength() {
        return this.f21804e.length();
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        FileInputStream fileInputStream = new FileInputStream(this.f21804e);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            fileInputStream.close();
        }
    }
}
