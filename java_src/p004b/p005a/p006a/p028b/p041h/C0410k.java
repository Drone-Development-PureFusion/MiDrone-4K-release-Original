package p004b.p005a.p006a.p028b.p041h;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/* renamed from: b.a.a.b.h.k */
/* loaded from: classes.dex */
public class C0410k extends OutputStream {

    /* renamed from: a */
    private static final int f910a = 1024;

    /* renamed from: b */
    private InetAddress f911b;

    /* renamed from: e */
    private final int f914e;

    /* renamed from: d */
    private ByteArrayOutputStream f913d = new ByteArrayOutputStream();

    /* renamed from: c */
    private DatagramSocket f912c = new DatagramSocket();

    public C0410k(String str, int i) {
        this.f911b = InetAddress.getByName(str);
        this.f914e = i;
    }

    /* renamed from: a */
    public int m20557a() {
        return this.f914e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m20556b() {
        return this.f912c.getSendBufferSize();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f911b = null;
        this.f912c = null;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        byte[] byteArray = this.f913d.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, this.f911b, this.f914e);
        if (this.f913d.size() > 1024) {
            this.f913d = new ByteArrayOutputStream();
        } else {
            this.f913d.reset();
        }
        if (byteArray.length == 0 || this.f912c == null) {
            return;
        }
        this.f912c.send(datagramPacket);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f913d.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f913d.write(bArr, i, i2);
    }
}
