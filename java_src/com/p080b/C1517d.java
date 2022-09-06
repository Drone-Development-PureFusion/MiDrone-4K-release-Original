package com.p080b;

import android.content.Context;
import android.os.Looper;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* renamed from: com.b.d */
/* loaded from: classes.dex */
public class C1517d extends AbstractC1561h {

    /* renamed from: a */
    private static boolean f5433a = true;

    /* renamed from: b */
    private String[] f5434b = new String[10];

    /* renamed from: c */
    private int f5435c = 0;

    /* renamed from: d */
    private boolean f5436d = false;

    /* renamed from: e */
    private int f5437e = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1517d(int i) {
        super(i);
    }

    /* renamed from: b */
    private void m15720b(String str) {
        try {
            if (this.f5435c > 9) {
                this.f5435c = 0;
            }
            this.f5434b[this.f5435c] = str;
            this.f5435c++;
        } catch (Throwable th) {
            C1450b.m16187a(th, "ANRWriter", "addData");
        }
    }

    /* renamed from: d */
    private String m15719d() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = this.f5435c; i < 10 && i <= 9; i++) {
                sb.append(this.f5434b[i]);
            }
            for (int i2 = 0; i2 < this.f5435c; i2++) {
                sb.append(this.f5434b[i2]);
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "ANRWriter", "getLogInfo");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db  */
    @Override // com.p080b.AbstractC1561h
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String mo15525a(List<C1549dv> list) {
        FileInputStream fileInputStream;
        C1419ak c1419ak;
        C1419ak c1419ak2;
        FileInputStream fileInputStream2;
        String str;
        String str2;
        String str3;
        String str4;
        File file;
        String str5;
        boolean z;
        InputStream inputStream = null;
        AutoCloseable autoCloseable = null;
        try {
            try {
                file = new File("/data/anr/traces.txt");
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            c1419ak2 = null;
            fileInputStream2 = null;
        } catch (IOException e2) {
            e = e2;
            c1419ak = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            autoCloseable = null;
            fileInputStream = null;
        }
        if (!file.exists()) {
            if (0 != 0) {
                try {
                    autoCloseable.close();
                } catch (IOException e3) {
                    C1450b.m16187a(e3, "ANRWriter", "initLog1");
                } catch (Throwable th3) {
                    C1450b.m16187a(th3, "ANRWriter", "initLog2");
                }
            }
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    C1450b.m16187a(e4, "ANRWriter", "initLog3");
                } catch (Throwable th4) {
                    C1450b.m16187a(th4, "ANRWriter", "initLog4");
                }
            }
            return null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            c1419ak = new C1419ak(fileInputStream, C1421al.f4887a);
            boolean z2 = false;
            while (true) {
                try {
                    String m16350a = c1419ak.m16350a();
                    if (m16350a.contains("pid")) {
                        while (!m16350a.contains("\"main\"")) {
                            m16350a = c1419ak.m16350a();
                        }
                        str5 = m16350a;
                        z = true;
                    } else {
                        str5 = m16350a;
                        z = z2;
                    }
                    z2 = str5.equals("") ? false : z;
                    if (z2) {
                        m15720b(str5);
                        if (this.f5437e == 5) {
                            break;
                        } else if (!this.f5436d) {
                            for (C1549dv c1549dv : list) {
                                this.f5436d = a(c1549dv.m15574f(), str5);
                                if (this.f5436d) {
                                    a(c1549dv);
                                }
                            }
                        } else {
                            this.f5437e++;
                        }
                    }
                } catch (EOFException e5) {
                } catch (FileNotFoundException e6) {
                    c1419ak2 = c1419ak;
                    fileInputStream2 = fileInputStream;
                    if (c1419ak2 != null) {
                        try {
                            c1419ak2.close();
                        } catch (IOException e7) {
                            C1450b.m16187a(e7, "ANRWriter", "initLog1");
                        } catch (Throwable th5) {
                            C1450b.m16187a(th5, "ANRWriter", "initLog2");
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            e = e8;
                            str3 = "ANRWriter";
                            str4 = "initLog3";
                            C1450b.m16187a(e, str3, str4);
                            if (!this.f5436d) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            str = "ANRWriter";
                            str2 = "initLog4";
                            C1450b.m16187a(th, str, str2);
                            if (!this.f5436d) {
                            }
                        }
                    }
                    if (!this.f5436d) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    C1450b.m16187a(e, "ANRWriter", "initLog");
                    if (c1419ak != null) {
                        try {
                            c1419ak.close();
                        } catch (IOException e10) {
                            C1450b.m16187a(e10, "ANRWriter", "initLog1");
                        } catch (Throwable th7) {
                            C1450b.m16187a(th7, "ANRWriter", "initLog2");
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            e = e11;
                            str3 = "ANRWriter";
                            str4 = "initLog3";
                            C1450b.m16187a(e, str3, str4);
                            if (!this.f5436d) {
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str = "ANRWriter";
                            str2 = "initLog4";
                            C1450b.m16187a(th, str, str2);
                            if (!this.f5436d) {
                            }
                        }
                    }
                    if (!this.f5436d) {
                    }
                }
            }
            if (c1419ak != null) {
                try {
                    c1419ak.close();
                } catch (IOException e12) {
                    C1450b.m16187a(e12, "ANRWriter", "initLog1");
                } catch (Throwable th9) {
                    C1450b.m16187a(th9, "ANRWriter", "initLog2");
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e13) {
                    e = e13;
                    str3 = "ANRWriter";
                    str4 = "initLog3";
                    C1450b.m16187a(e, str3, str4);
                    if (!this.f5436d) {
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str = "ANRWriter";
                    str2 = "initLog4";
                    C1450b.m16187a(th, str, str2);
                    if (!this.f5436d) {
                    }
                }
            }
        } catch (FileNotFoundException e14) {
            c1419ak2 = null;
            fileInputStream2 = fileInputStream;
        } catch (IOException e15) {
            e = e15;
            c1419ak = null;
        } catch (Throwable th11) {
            th = th11;
            autoCloseable = null;
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (IOException e16) {
                    C1450b.m16187a(e16, "ANRWriter", "initLog1");
                } catch (Throwable th12) {
                    C1450b.m16187a(th12, "ANRWriter", "initLog2");
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    C1450b.m16187a(e17, "ANRWriter", "initLog3");
                } catch (Throwable th13) {
                    C1450b.m16187a(th13, "ANRWriter", "initLog4");
                }
            }
            throw th;
        }
        if (!this.f5436d) {
            return null;
        }
        return m15719d();
    }

    @Override // com.p080b.AbstractC1561h
    /* renamed from: a */
    protected boolean mo15538a(Context context) {
        boolean z = true;
        if (C1542dq.m15619m(context) != 1 || !f5433a) {
            return false;
        }
        f5433a = false;
        synchronized (Looper.getMainLooper()) {
            C1574t c1574t = new C1574t(context);
            C1576v m15454a = c1574t.m15454a();
            if (m15454a != null) {
                if (m15454a.m15441c()) {
                    m15454a.m15440c(false);
                    c1574t.m15452a(m15454a);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
