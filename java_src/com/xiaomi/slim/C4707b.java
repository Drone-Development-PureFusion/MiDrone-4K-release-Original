package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4624aq;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.util.C4746d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* renamed from: com.xiaomi.slim.b */
/* loaded from: classes.dex */
public class C4707b {

    /* renamed from: b */
    private static String f19330b = C4746d.m3839a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: c */
    private static long f19331c = 0;

    /* renamed from: f */
    private static final byte[] f19332f = new byte[0];

    /* renamed from: a */
    String f19333a;

    /* renamed from: d */
    private C4567b.C4568a f19334d;

    /* renamed from: e */
    private short f19335e;

    /* renamed from: g */
    private byte[] f19336g;

    public C4707b() {
        this.f19335e = (short) 2;
        this.f19336g = f19332f;
        this.f19333a = null;
        this.f19334d = new C4567b.C4568a();
    }

    C4707b(C4567b.C4568a c4568a, short s, byte[] bArr) {
        this.f19335e = (short) 2;
        this.f19336g = f19332f;
        this.f19333a = null;
        this.f19334d = c4568a;
        this.f19335e = s;
        this.f19336g = bArr;
    }

    @Deprecated
    /* renamed from: a */
    public static C4707b m4032a(AbstractC4732d abstractC4732d, String str) {
        C4707b c4707b = new C4707b();
        int i = 1;
        try {
            i = Integer.parseInt(abstractC4732d.m3884l());
        } catch (Exception e) {
            AbstractC4478b.m5041a("Blob parse chid err " + e.getMessage());
        }
        c4707b.m4034a(i);
        c4707b.m4031a(abstractC4732d.m3886k());
        c4707b.m4022c(abstractC4732d.m3880n());
        c4707b.m4025b(abstractC4732d.m3878o());
        c4707b.m4030a("XMLMSG", (String) null);
        try {
            c4707b.m4027a(abstractC4732d.mo3862c().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                c4707b.m4028a((short) 3);
            } else {
                c4707b.m4028a((short) 2);
                c4707b.m4030a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            AbstractC4478b.m5041a("Blob setPayload err： " + e2.getMessage());
        }
        return c4707b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static C4707b m4024b(ByteBuffer byteBuffer) {
        try {
            if (byteBuffer.getShort(0) != -15618 || byteBuffer.getShort(2) != 4) {
                throw new IOException("Malformed Input");
            }
            short s = byteBuffer.getShort(6);
            short s2 = byteBuffer.getShort(8);
            int i = byteBuffer.getInt(10);
            C4567b.C4568a c4568a = new C4567b.C4568a();
            c4568a.b(byteBuffer.array(), 14, s2);
            byte[] bArr = new byte[i];
            byteBuffer.position(s2 + 14);
            byteBuffer.get(bArr, 0, i);
            return new C4707b(c4568a, s, bArr);
        } catch (Exception e) {
            AbstractC4478b.m5041a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static int m4021c(ByteBuffer byteBuffer) {
        return byteBuffer.getShort(8) + byteBuffer.getInt(10);
    }

    /* renamed from: g */
    public static synchronized String m4016g() {
        String sb;
        synchronized (C4707b.class) {
            StringBuilder append = new StringBuilder().append(f19330b);
            long j = f19331c;
            f19331c = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static int m4009n() {
        return 14;
    }

    /* renamed from: a */
    public String m4035a() {
        return this.f19334d.m4669l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ByteBuffer m4029a(ByteBuffer byteBuffer) {
        int m4011l = m4011l();
        if (byteBuffer == null || byteBuffer.remaining() < m4011l) {
            if (byteBuffer != null) {
                m4011l += byteBuffer.capacity();
            }
            ByteBuffer allocate = ByteBuffer.allocate(m4011l);
            if (byteBuffer != null) {
                allocate.put(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.position());
            }
            byteBuffer = allocate;
        }
        ByteBuffer slice = byteBuffer.slice();
        slice.putShort((short) -15618);
        slice.putShort((short) 4);
        slice.putShort((short) 1);
        slice.putShort(this.f19335e);
        slice.putShort((short) this.f19334d.mo4533a());
        slice.putInt(this.f19336g.length);
        int position = slice.position();
        this.f19334d.a(slice.array(), slice.arrayOffset() + position, this.f19334d.mo4533a());
        slice.position(position + this.f19334d.mo4533a());
        slice.put(this.f19336g);
        byteBuffer.position(slice.position() + byteBuffer.position());
        return byteBuffer;
    }

    /* renamed from: a */
    public void m4034a(int i) {
        this.f19334d.m4689a(i);
    }

    /* renamed from: a */
    public void m4033a(long j, String str, String str2) {
        if (j != 0) {
            this.f19334d.m4688a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f19334d.m4687a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f19334d.m4684b(str2);
        }
    }

    /* renamed from: a */
    public void m4031a(String str) {
        this.f19334d.m4677e(str);
    }

    /* renamed from: a */
    public void m4030a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f19334d.m4682c(str);
        this.f19334d.m4665p();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f19334d.m4679d(str2);
    }

    /* renamed from: a */
    public void m4028a(short s) {
        this.f19335e = s;
    }

    /* renamed from: a */
    public void m4027a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19334d.m4683c(1);
            this.f19336g = C4624aq.m4346a(C4624aq.m4350a(str, m4015h()), bArr);
            return;
        }
        this.f19334d.m4683c(0);
        this.f19336g = bArr;
    }

    /* renamed from: b */
    public String m4026b() {
        return this.f19334d.m4667n();
    }

    /* renamed from: b */
    public void m4025b(String str) {
        this.f19333a = str;
    }

    /* renamed from: c */
    public int m4023c() {
        return this.f19334d.m4681d();
    }

    /* renamed from: c */
    public void m4022c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f19334d.m4688a(parseLong);
                this.f19334d.m4687a(substring);
                this.f19334d.m4684b(substring2);
            } catch (Exception e) {
                AbstractC4478b.m5041a("Blob parse user err " + e.getMessage());
            }
        }
    }

    /* renamed from: d */
    public boolean m4020d() {
        return this.f19334d.m4657x();
    }

    /* renamed from: d */
    public byte[] m4019d(String str) {
        if (this.f19334d.m4660u() == 1) {
            return C4624aq.m4346a(C4624aq.m4350a(str, m4015h()), this.f19336g);
        }
        if (this.f19334d.m4660u() == 0) {
            return this.f19336g;
        }
        AbstractC4478b.m5041a("unknow cipher = " + this.f19334d.m4660u());
        return this.f19336g;
    }

    /* renamed from: e */
    public int m4018e() {
        return this.f19334d.m4658w();
    }

    /* renamed from: f */
    public String m4017f() {
        return this.f19334d.m4656y();
    }

    /* renamed from: h */
    public String m4015h() {
        String m4664q = this.f19334d.m4664q();
        if ("ID_NOT_AVAILABLE".equals(m4664q)) {
            return null;
        }
        if (this.f19334d.m4663r()) {
            return m4664q;
        }
        String m4016g = m4016g();
        this.f19334d.m4677e(m4016g);
        return m4016g;
    }

    /* renamed from: i */
    public String m4014i() {
        return this.f19333a;
    }

    /* renamed from: j */
    public String m4013j() {
        if (this.f19334d.m4674g()) {
            return Long.toString(this.f19334d.m4676f()) + "@" + this.f19334d.m4673h() + "/" + this.f19334d.m4671j();
        }
        return null;
    }

    /* renamed from: k */
    public byte[] m4012k() {
        return this.f19336g;
    }

    /* renamed from: l */
    public int m4011l() {
        return m4009n() + this.f19334d.mo4526b() + this.f19336g.length;
    }

    /* renamed from: m */
    public short m4010m() {
        return this.f19335e;
    }

    public String toString() {
        return "Blob [chid=" + m4023c() + "; Id=" + m4015h() + "; cmd=" + m4035a() + "; type=" + ((int) m4010m()) + "; from=" + m4013j() + " ]";
    }
}
