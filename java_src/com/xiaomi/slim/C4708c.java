package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4482d;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4612ak;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.slim.c */
/* loaded from: classes2.dex */
public class C4708c {

    /* renamed from: a */
    private ByteBuffer f19337a = ByteBuffer.allocate(2048);

    /* renamed from: b */
    private ByteBuffer f19338b = ByteBuffer.allocate(4);

    /* renamed from: c */
    private Adler32 f19339c = new Adler32();

    /* renamed from: d */
    private C4710e f19340d = new C4710e();

    /* renamed from: e */
    private InputStream f19341e;

    /* renamed from: f */
    private C4711f f19342f;

    /* renamed from: g */
    private volatile boolean f19343g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4708c(InputStream inputStream, C4711f c4711f) {
        this.f19341e = new BufferedInputStream(inputStream);
        this.f19342f = c4711f;
    }

    /* renamed from: a */
    private void m4007a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f19341e.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    /* renamed from: d */
    private void m4004d() {
        boolean z = false;
        this.f19343g = false;
        C4707b m4005c = m4005c();
        if ("CONN".equals(m4005c.m4035a())) {
            C4567b.C4573f m4572b = C4567b.C4573f.m4572b(m4005c.m4012k());
            if (m4572b.m4570e()) {
                this.f19342f.a(m4572b.m4571d());
                z = true;
            }
            if (m4572b.m4567h()) {
                C4567b.C4569b m4566i = m4572b.m4566i();
                C4707b c4707b = new C4707b();
                c4707b.m4030a("SYNC", "CONF");
                c4707b.m4027a(m4566i.c(), (String) null);
                this.f19342f.m3998a(c4707b);
            }
            AbstractC4478b.m5041a("[Slim] CONN: host = " + m4572b.m4569f());
        }
        if (!z) {
            AbstractC4478b.m5041a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        while (!this.f19343g) {
            C4707b m4005c2 = m4005c();
            this.f19342f.n();
            switch (m4005c2.m4010m()) {
                case 1:
                    this.f19342f.m3998a(m4005c2);
                    break;
                case 2:
                    if ("SECMSG".equals(m4005c2.m4035a()) && TextUtils.isEmpty(m4005c2.m4026b())) {
                        try {
                            this.f19342f.m3996b(this.f19340d.m3999a(m4005c2.m4019d(C4612ak.m4383a().m4374b(Integer.valueOf(m4005c2.m4023c()).toString(), m4005c2.m4013j()).f18962i), this.f19342f));
                            break;
                        } catch (Exception e) {
                            AbstractC4478b.m5041a("[Slim] Parse packet from Blob " + m4005c2.toString() + " failure:" + e.getMessage());
                            break;
                        }
                    } else {
                        this.f19342f.m3998a(m4005c2);
                        break;
                    }
                    break;
                case 3:
                    try {
                        this.f19342f.m3996b(this.f19340d.m3999a(m4005c2.m4012k(), this.f19342f));
                        break;
                    } catch (Exception e2) {
                        AbstractC4478b.m5041a("[Slim] Parse packet from Blob " + m4005c2.toString() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    AbstractC4478b.m5041a("[Slim] unknow blob type " + ((int) m4005c2.m4010m()));
                    break;
            }
        }
    }

    /* renamed from: e */
    private ByteBuffer m4003e() {
        if (this.f19337a.capacity() > 4096) {
            this.f19337a = ByteBuffer.allocate(2048);
        }
        this.f19337a.clear();
        m4007a(this.f19337a, C4707b.m4009n());
        int m4021c = C4707b.m4021c(this.f19337a.asReadOnlyBuffer());
        if (m4021c > 32768) {
            throw new IOException("Blob size too large");
        }
        if (m4021c + 4 > this.f19337a.remaining()) {
            ByteBuffer allocate = ByteBuffer.allocate(C4707b.m4009n() + m4021c);
            allocate.put(this.f19337a.array(), 0, this.f19337a.arrayOffset() + this.f19337a.position());
            this.f19337a = allocate;
        }
        m4007a(this.f19337a, m4021c);
        this.f19338b.clear();
        m4007a(this.f19338b, 4);
        this.f19338b.position(0);
        int i = this.f19338b.getInt();
        this.f19339c.reset();
        this.f19339c.update(this.f19337a.array(), 0, this.f19337a.position());
        if (i == ((int) this.f19339c.getValue())) {
            return this.f19337a;
        }
        AbstractC4478b.m5041a("CRC = " + ((int) this.f19339c.getValue()) + " and " + i);
        throw new IOException("Corrupted Blob bad CRC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4008a() {
        try {
            m4004d();
        } catch (IOException e) {
            if (this.f19343g) {
                return;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m4006b() {
        this.f19343g = true;
    }

    /* renamed from: c */
    C4707b m4005c() {
        IOException iOException;
        int i;
        ByteBuffer m4003e;
        int position;
        try {
            m4003e = m4003e();
            position = m4003e.position();
        } catch (IOException e) {
            iOException = e;
            i = 0;
        }
        try {
            m4003e.flip();
            C4707b m4024b = C4707b.m4024b(m4003e);
            AbstractC4478b.m5037c("[Slim] Read {cmd=" + m4024b.m4035a() + ";chid=" + m4024b.m4023c() + ";len=" + position + "}");
            return m4024b;
        } catch (IOException e2) {
            i = position;
            iOException = e2;
            if (i == 0) {
                i = this.f19337a.position();
            }
            StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
            byte[] array = this.f19337a.array();
            if (i > C4707b.m4009n()) {
                i = C4707b.m4009n();
            }
            AbstractC4478b.m5041a(append.append(C4482d.m5029a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
            throw iOException;
        }
    }
}
