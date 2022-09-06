package com.p080b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.BitSet;
/* renamed from: com.b.dd */
/* loaded from: classes.dex */
public final class C1521dd {

    /* renamed from: a */
    private RandomAccessFile f5444a;

    /* renamed from: b */
    private C1496cf f5445b;

    /* renamed from: c */
    private String f5446c = "";

    /* renamed from: d */
    private File f5447d = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1521dd(C1496cf c1496cf) {
        this.f5445b = c1496cf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void m15710a(long j, byte[] bArr) {
        int readInt;
        BitSet m15848b;
        int m15863a;
        int i = 0;
        synchronized (this) {
            this.f5447d = this.f5445b.m15860a(j);
            if (this.f5447d != null) {
                try {
                    try {
                        this.f5444a = new RandomAccessFile(this.f5447d, "rw");
                        byte[] bArr2 = new byte[this.f5445b.m15863a()];
                        readInt = this.f5444a.read(bArr2) == -1 ? 0 : this.f5444a.readInt();
                        m15848b = C1496cf.m15848b(bArr2);
                        m15863a = this.f5445b.m15863a() + 4 + (readInt * 1500);
                    } catch (FileNotFoundException e) {
                        if (this.f5444a != null) {
                            this.f5444a.close();
                        }
                    }
                } catch (IOException e2) {
                    if (this.f5444a != null) {
                        this.f5444a.close();
                    }
                } catch (Throwable th) {
                    if (this.f5444a != null) {
                        try {
                            this.f5444a.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
                if (readInt < 0 || readInt > (this.f5445b.m15863a() << 3)) {
                    this.f5444a.close();
                    this.f5447d.delete();
                    if (this.f5444a != null) {
                        try {
                            this.f5444a.close();
                        } catch (IOException e4) {
                        }
                    }
                } else {
                    this.f5444a.seek(m15863a);
                    byte[] m15855a = C1496cf.m15855a(bArr);
                    this.f5444a.writeInt(m15855a.length);
                    this.f5444a.writeLong(j);
                    this.f5444a.write(m15855a);
                    m15848b.set(readInt, true);
                    this.f5444a.seek(0L);
                    this.f5444a.write(C1496cf.m15856a(m15848b));
                    int i2 = readInt + 1;
                    if (i2 != (this.f5445b.m15863a() << 3)) {
                        i = i2;
                    }
                    this.f5444a.writeInt(i);
                    if (!this.f5446c.equalsIgnoreCase(this.f5447d.getName())) {
                        this.f5446c = this.f5447d.getName();
                    }
                    this.f5447d.length();
                    if (this.f5444a != null) {
                        this.f5444a.close();
                    }
                    this.f5447d = null;
                }
            }
        }
    }
}
