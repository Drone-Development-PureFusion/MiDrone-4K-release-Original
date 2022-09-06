package com.p080b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
/* renamed from: com.b.dc */
/* loaded from: classes.dex */
public final class C1520dc {

    /* renamed from: a */
    private RandomAccessFile f5441a;

    /* renamed from: b */
    private C1496cf f5442b;

    /* renamed from: c */
    private File f5443c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1520dc(C1496cf c1496cf) {
        this.f5442b = c1496cf;
    }

    /* renamed from: a */
    private static byte m15712a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, bArr3.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
        }
        return bArr2[0];
    }

    /* renamed from: a */
    private static int m15715a(int i, int i2, int i3) {
        int i4 = ((i3 - 1) * 1500) + i;
        while (i4 >= i2) {
            i4 -= 1500;
        }
        return i4;
    }

    /* renamed from: a */
    private int m15713a(BitSet bitSet) {
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                return this.f5442b.m15863a() + (i * 1500) + 4;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private ArrayList m15716a(int i, int i2) {
        int readInt;
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            try {
                this.f5441a.seek(i);
                readInt = this.f5441a.readInt();
                this.f5441a.readLong();
            } catch (IOException e) {
            }
            if (readInt <= 0 || readInt > 1500) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f5441a.read(bArr);
            byte m15712a = m15712a(bArr);
            if (m15712a != 3 && m15712a != 4 && m15712a != 41) {
                return null;
            }
            arrayList.add(bArr);
            i += 1500;
        }
        return arrayList;
    }

    /* renamed from: b */
    private BitSet m15711b() {
        byte[] bArr = new byte[this.f5442b.m15863a()];
        try {
            this.f5441a.read(bArr);
            return C1496cf.m15848b(bArr);
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final int m15718a() {
        int i = 0;
        synchronized (this) {
            try {
                this.f5443c = this.f5442b.m15852b();
                try {
                    try {
                        try {
                            if (this.f5443c != null) {
                                this.f5441a = new RandomAccessFile(this.f5442b.m15852b(), "rw");
                                byte[] bArr = new byte[this.f5442b.m15863a()];
                                if (C1499ci.f5340c && this.f5441a != null) {
                                    try {
                                        this.f5441a.close();
                                        if (this.f5441a != null) {
                                            try {
                                                this.f5441a.close();
                                            } catch (IOException e) {
                                            }
                                        }
                                    } catch (IOException e2) {
                                    }
                                }
                                this.f5441a.read(bArr);
                                BitSet m15848b = C1496cf.m15848b(bArr);
                                for (int i2 = 0; i2 < m15848b.size(); i2++) {
                                    if (m15848b.get(i2)) {
                                        i++;
                                    }
                                }
                            }
                        } catch (IOException e3) {
                            if (this.f5441a != null) {
                                this.f5441a.close();
                            }
                        }
                    } catch (NullPointerException e4) {
                        if (this.f5441a != null) {
                            this.f5441a.close();
                        }
                    }
                } catch (FileNotFoundException e5) {
                    if (this.f5441a != null) {
                        this.f5441a.close();
                    }
                }
                if (this.f5441a != null) {
                    this.f5441a.close();
                }
            } catch (IOException e6) {
            }
            this.f5443c = null;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized C1495ce m15717a(int i) {
        C1495ce c1495ce;
        BitSet m15711b;
        int m15715a;
        C1495ce c1495ce2 = null;
        synchronized (this) {
            if (this.f5442b != null) {
                synchronized (this) {
                    this.f5443c = this.f5442b.m15852b();
                    if (this.f5443c != null) {
                        try {
                            try {
                                this.f5441a = new RandomAccessFile(this.f5443c, "rw");
                                if (C1499ci.f5340c && this.f5441a != null) {
                                    try {
                                        this.f5441a.close();
                                        if (this.f5441a != null) {
                                            try {
                                                this.f5441a.close();
                                            } catch (Exception e) {
                                            }
                                        }
                                    } catch (IOException e2) {
                                    }
                                }
                                m15711b = m15711b();
                            } catch (FileNotFoundException e3) {
                                if (this.f5441a != null) {
                                    try {
                                        this.f5441a.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                c1495ce = null;
                            }
                        } catch (Exception e5) {
                            if (this.f5441a != null) {
                                try {
                                    this.f5441a.close();
                                } catch (Exception e6) {
                                }
                            }
                            c1495ce = null;
                        } catch (Throwable th) {
                            if (this.f5441a != null) {
                                try {
                                    this.f5441a.close();
                                } catch (Exception e7) {
                                }
                            }
                            throw th;
                        }
                        if (m15711b == null) {
                            this.f5443c.delete();
                            if (this.f5441a != null) {
                                try {
                                    this.f5441a.close();
                                } catch (Exception e8) {
                                }
                            }
                        } else {
                            int m15713a = m15713a(m15711b);
                            ArrayList m15716a = m15716a(m15713a, m15715a(m15713a, (int) this.f5443c.length(), i));
                            if (m15716a == null) {
                                this.f5443c.delete();
                                if (this.f5441a != null) {
                                    try {
                                        this.f5441a.close();
                                    } catch (Exception e9) {
                                    }
                                }
                            } else {
                                c1495ce = new C1495ce(this.f5443c, m15716a, new int[]{((m15713a - this.f5442b.m15863a()) - 4) / 1500, ((m15715a - this.f5442b.m15863a()) - 4) / 1500});
                                if (this.f5441a != null) {
                                    try {
                                        this.f5441a.close();
                                    } catch (Exception e10) {
                                    }
                                }
                                if (c1495ce == null || c1495ce.m15864c() <= 100 || c1495ce.m15864c() >= 5242880) {
                                    this.f5443c.delete();
                                    this.f5443c = null;
                                } else {
                                    c1495ce2 = c1495ce;
                                }
                            }
                        }
                    }
                }
            }
        }
        return c1495ce2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void m15714a(C1495ce c1495ce) {
        BitSet bitSet = null;
        synchronized (this) {
            synchronized (this) {
                this.f5443c = c1495ce.f5315a;
                if (this.f5443c != null) {
                    try {
                        this.f5441a = new RandomAccessFile(this.f5443c, "rw");
                        byte[] bArr = new byte[this.f5442b.m15863a()];
                        if (C1499ci.f5340c && this.f5441a != null) {
                            try {
                                this.f5441a.close();
                                if (this.f5441a != null) {
                                    try {
                                        this.f5441a.close();
                                    } catch (IOException e) {
                                    }
                                }
                            } catch (IOException e2) {
                            }
                        }
                        this.f5441a.read(bArr);
                        bitSet = C1496cf.m15848b(bArr);
                        if (c1495ce.m15865b()) {
                            for (int i = c1495ce.f5316b[0]; i <= c1495ce.f5316b[1]; i++) {
                                bitSet.set(i, false);
                            }
                            this.f5441a.seek(0L);
                            this.f5441a.write(C1496cf.m15856a(bitSet));
                        }
                    } catch (FileNotFoundException e3) {
                        if (this.f5441a != null) {
                            this.f5441a.close();
                        }
                    } catch (IOException e4) {
                        if (this.f5441a != null) {
                            this.f5441a.close();
                        }
                    }
                    if (this.f5441a != null) {
                        this.f5441a.close();
                    }
                    if (bitSet.isEmpty()) {
                        this.f5443c.delete();
                    }
                    this.f5443c = null;
                }
            }
        }
    }
}
