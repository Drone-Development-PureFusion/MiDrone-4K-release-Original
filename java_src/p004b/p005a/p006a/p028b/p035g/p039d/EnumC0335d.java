package p004b.p005a.p006a.p028b.p035g.p039d;

import java.io.OutputStream;
@Deprecated
/* renamed from: b.a.a.b.g.d.d */
/* loaded from: classes.dex */
public enum EnumC0335d {
    SystemOut("System.out", new OutputStream() { // from class: b.a.a.b.g.d.d.1
        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            System.out.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            System.out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            System.out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            System.out.write(bArr, i, i2);
        }
    }),
    SystemErr("System.err", new OutputStream() { // from class: b.a.a.b.g.d.d.2
        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            System.err.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            System.err.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            System.err.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            System.err.write(bArr, i, i2);
        }
    });
    

    /* renamed from: c */
    private final String f631c;

    /* renamed from: d */
    private final OutputStream f632d;

    EnumC0335d(String str, OutputStream outputStream) {
        this.f631c = str;
        this.f632d = outputStream;
    }

    /* renamed from: a */
    public static EnumC0335d m20910a(String str) {
        EnumC0335d[] values;
        for (EnumC0335d enumC0335d : values()) {
            if (enumC0335d.f631c.equalsIgnoreCase(str)) {
                return enumC0335d;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m20911a() {
        return this.f631c;
    }

    /* renamed from: b */
    public OutputStream m20909b() {
        return this.f632d;
    }
}
