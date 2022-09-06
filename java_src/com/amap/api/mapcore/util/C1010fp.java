package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.fp */
/* loaded from: classes.dex */
public class C1010fp extends AbstractC1013fs {

    /* renamed from: a */
    private static boolean f3181a = true;

    /* renamed from: b */
    private String[] f3182b = new String[10];

    /* renamed from: c */
    private int f3183c = 0;

    /* renamed from: d */
    private boolean f3184d = false;

    /* renamed from: e */
    private int f3185e = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1010fp(int i) {
        super(i);
    }

    /* renamed from: b */
    private void m18008b(String str) {
        try {
            if (this.f3183c > 9) {
                this.f3183c = 0;
            }
            this.f3182b[this.f3183c] = str;
            this.f3183c++;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "ANRWriter", "addData");
        }
    }

    /* renamed from: d */
    private String m18007d() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = this.f3183c; i < 10 && i <= 9; i++) {
                sb.append(this.f3182b[i]);
            }
            for (int i2 = 0; i2 < this.f3183c; i2++) {
                sb.append(this.f3182b[i2]);
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "ANRWriter", "getLogInfo");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db  */
    @Override // com.amap.api.mapcore.util.AbstractC1013fs
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String mo17991a(List<C0996fh> list) {
        FileInputStream fileInputStream;
        C1054gv c1054gv;
        C1054gv c1054gv2;
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
            c1054gv2 = null;
            fileInputStream2 = null;
        } catch (IOException e2) {
            e = e2;
            c1054gv = null;
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
                    C1002fl.m18028a(e3, "ANRWriter", "initLog1");
                } catch (Throwable th3) {
                    C1002fl.m18028a(th3, "ANRWriter", "initLog2");
                }
            }
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    C1002fl.m18028a(e4, "ANRWriter", "initLog3");
                } catch (Throwable th4) {
                    C1002fl.m18028a(th4, "ANRWriter", "initLog4");
                }
            }
            return null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            c1054gv = new C1054gv(fileInputStream, C1056gw.f3307a);
            boolean z2 = false;
            while (true) {
                try {
                    String m17776a = c1054gv.m17776a();
                    if (m17776a.contains("pid")) {
                        while (!m17776a.contains("\"main\"")) {
                            m17776a = c1054gv.m17776a();
                        }
                        str5 = m17776a;
                        z = true;
                    } else {
                        str5 = m17776a;
                        z = z2;
                    }
                    z2 = str5.equals("") ? false : z;
                    if (z2) {
                        m18008b(str5);
                        if (this.f3185e == 5) {
                            break;
                        } else if (!this.f3184d) {
                            for (C0996fh c0996fh : list) {
                                this.f3184d = b(c0996fh.m18065f(), str5);
                                if (this.f3184d) {
                                    a(c0996fh);
                                }
                            }
                        } else {
                            this.f3185e++;
                        }
                    }
                } catch (EOFException e5) {
                } catch (FileNotFoundException e6) {
                    c1054gv2 = c1054gv;
                    fileInputStream2 = fileInputStream;
                    if (c1054gv2 != null) {
                        try {
                            c1054gv2.close();
                        } catch (IOException e7) {
                            C1002fl.m18028a(e7, "ANRWriter", "initLog1");
                        } catch (Throwable th5) {
                            C1002fl.m18028a(th5, "ANRWriter", "initLog2");
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            e = e8;
                            str3 = "ANRWriter";
                            str4 = "initLog3";
                            C1002fl.m18028a(e, str3, str4);
                            if (!this.f3184d) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            str = "ANRWriter";
                            str2 = "initLog4";
                            C1002fl.m18028a(th, str, str2);
                            if (!this.f3184d) {
                            }
                        }
                    }
                    if (!this.f3184d) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    C1002fl.m18028a(e, "ANRWriter", "initLog");
                    if (c1054gv != null) {
                        try {
                            c1054gv.close();
                        } catch (IOException e10) {
                            C1002fl.m18028a(e10, "ANRWriter", "initLog1");
                        } catch (Throwable th7) {
                            C1002fl.m18028a(th7, "ANRWriter", "initLog2");
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            e = e11;
                            str3 = "ANRWriter";
                            str4 = "initLog3";
                            C1002fl.m18028a(e, str3, str4);
                            if (!this.f3184d) {
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str = "ANRWriter";
                            str2 = "initLog4";
                            C1002fl.m18028a(th, str, str2);
                            if (!this.f3184d) {
                            }
                        }
                    }
                    if (!this.f3184d) {
                    }
                }
            }
            if (c1054gv != null) {
                try {
                    c1054gv.close();
                } catch (IOException e12) {
                    C1002fl.m18028a(e12, "ANRWriter", "initLog1");
                } catch (Throwable th9) {
                    C1002fl.m18028a(th9, "ANRWriter", "initLog2");
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e13) {
                    e = e13;
                    str3 = "ANRWriter";
                    str4 = "initLog3";
                    C1002fl.m18028a(e, str3, str4);
                    if (!this.f3184d) {
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str = "ANRWriter";
                    str2 = "initLog4";
                    C1002fl.m18028a(th, str, str2);
                    if (!this.f3184d) {
                    }
                }
            }
        } catch (FileNotFoundException e14) {
            c1054gv2 = null;
            fileInputStream2 = fileInputStream;
        } catch (IOException e15) {
            e = e15;
            c1054gv = null;
        } catch (Throwable th11) {
            th = th11;
            autoCloseable = null;
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (IOException e16) {
                    C1002fl.m18028a(e16, "ANRWriter", "initLog1");
                } catch (Throwable th12) {
                    C1002fl.m18028a(th12, "ANRWriter", "initLog2");
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    C1002fl.m18028a(e17, "ANRWriter", "initLog3");
                } catch (Throwable th13) {
                    C1002fl.m18028a(th13, "ANRWriter", "initLog4");
                }
            }
            throw th;
        }
        if (!this.f3184d) {
            return null;
        }
        return m18007d();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1013fs
    /* renamed from: a */
    protected boolean mo18005a(Context context) {
        boolean z = true;
        if (C0989fc.m18117m(context) != 1 || !f3181a) {
            return false;
        }
        f3181a = false;
        synchronized (Looper.getMainLooper()) {
            C1028gf c1028gf = new C1028gf(context);
            C1029gg m17928a = c1028gf.m17928a();
            if (m17928a != null) {
                if (m17928a.m17921c()) {
                    m17928a.m17920c(false);
                    c1028gf.m17926a(m17928a);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
