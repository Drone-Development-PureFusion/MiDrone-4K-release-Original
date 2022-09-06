package org.p248a.p249a.p267h;

import com.fimi.soul.media.player.FimiMediaMeta;
import java.io.InputStream;
import java.io.OutputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.h.h */
/* loaded from: classes2.dex */
public class C5143h extends AbstractC5136a {

    /* renamed from: e */
    private final InputStream f21806e;

    /* renamed from: f */
    private final long f21807f;

    public C5143h(InputStream inputStream) {
        this(inputStream, -1L);
    }

    public C5143h(InputStream inputStream, long j) {
        this(inputStream, j, null);
    }

    public C5143h(InputStream inputStream, long j, C5140e c5140e) {
        this.f21806e = (InputStream) C5351a.m1321a(inputStream, "Source input stream");
        this.f21807f = j;
        if (c5140e != null) {
            a(c5140e.toString());
        }
    }

    public C5143h(InputStream inputStream, C5140e c5140e) {
        this(inputStream, -1L, c5140e);
    }

    public InputStream getContent() {
        return this.f21806e;
    }

    public long getContentLength() {
        return this.f21807f;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    public void writeTo(OutputStream outputStream) {
        int read;
        C5351a.m1321a(outputStream, "Output stream");
        InputStream inputStream = this.f21806e;
        try {
            byte[] bArr = new byte[4096];
            if (this.f21807f < 0) {
                while (true) {
                    int read2 = inputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read2);
                }
            } else {
                long j = this.f21807f;
                while (j > 0 && (read = inputStream.read(bArr, 0, (int) Math.min((long) FimiMediaMeta.AV_CH_TOP_FRONT_LEFT, j))) != -1) {
                    outputStream.write(bArr, 0, read);
                    j -= read;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
