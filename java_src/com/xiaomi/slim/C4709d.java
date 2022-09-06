package com.xiaomi.slim;

import android.os.Build;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4627at;
import com.xiaomi.smack.AbstractC4713a;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.xiaomi.slim.d */
/* loaded from: classes2.dex */
public class C4709d {

    /* renamed from: a */
    ByteBuffer f19344a = ByteBuffer.allocate(2048);

    /* renamed from: b */
    private ByteBuffer f19345b = ByteBuffer.allocate(4);

    /* renamed from: c */
    private Adler32 f19346c = new Adler32();

    /* renamed from: d */
    private AbstractC4713a f19347d;

    /* renamed from: e */
    private OutputStream f19348e;

    /* renamed from: f */
    private int f19349f;

    /* renamed from: g */
    private int f19350g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4709d(OutputStream outputStream, AbstractC4713a abstractC4713a) {
        this.f19348e = new BufferedOutputStream(outputStream);
        this.f19347d = abstractC4713a;
        TimeZone timeZone = TimeZone.getDefault();
        this.f19349f = timeZone.getRawOffset() / C0359h.f695Y;
        this.f19350g = timeZone.useDaylightTime() ? 1 : 0;
    }

    /* renamed from: a */
    public int m4001a(C4707b c4707b) {
        int m4011l = c4707b.m4011l();
        if (m4011l > 32768) {
            AbstractC4478b.m5041a("Blob size=" + m4011l + " should be less than 32768 Drop blob chid=" + c4707b.m4023c() + " id=" + c4707b.m4015h());
            return 0;
        }
        if (this.f19344a.capacity() > 4096) {
            this.f19344a = ByteBuffer.allocate(2048);
        }
        this.f19344a.clear();
        this.f19344a = c4707b.m4029a(this.f19344a);
        this.f19346c.reset();
        this.f19346c.update(this.f19344a.array(), 0, this.f19344a.position());
        this.f19345b.putInt(0, (int) this.f19346c.getValue());
        this.f19348e.write(this.f19344a.array(), 0, this.f19344a.position());
        this.f19348e.write(this.f19345b.array(), 0, 4);
        this.f19348e.flush();
        int position = this.f19344a.position() + 4;
        AbstractC4478b.m5037c("[Slim] Wrote {cmd=" + c4707b.m4035a() + ";chid=" + c4707b.m4023c() + ";len=" + position + "}");
        return position;
    }

    /* renamed from: a */
    public void m4002a() {
        C4567b.C4572e c4572e = new C4567b.C4572e();
        c4572e.m4607a(106);
        c4572e.m4605a(Build.MODEL);
        c4572e.m4602b(Build.VERSION.INCREMENTAL);
        c4572e.m4600c(C4627at.m4329e());
        c4572e.m4604b(26);
        c4572e.m4598d(this.f19347d.m3978e());
        c4572e.m4596e(this.f19347d.mo3931d());
        c4572e.m4594f(Locale.getDefault().toString());
        c4572e.m4601c(Build.VERSION.SDK_INT);
        byte[] mo3964a = this.f19347d.m3979c().mo3964a();
        if (mo3964a != null) {
            c4572e.m4606a(C4567b.C4569b.m4650b(mo3964a));
        }
        C4707b c4707b = new C4707b();
        c4707b.m4034a(0);
        c4707b.m4030a("CONN", (String) null);
        c4707b.m4033a(0L, "xiaomi.com", null);
        c4707b.m4027a(c4572e.c(), (String) null);
        m4001a(c4707b);
        AbstractC4478b.m5041a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=26 hash=" + C4627at.m4329e() + " tz=" + this.f19349f + ":" + this.f19350g + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    /* renamed from: b */
    public void m4000b() {
        C4707b c4707b = new C4707b();
        c4707b.m4030a("CLOSE", (String) null);
        m4001a(c4707b);
        this.f19348e.close();
    }
}
