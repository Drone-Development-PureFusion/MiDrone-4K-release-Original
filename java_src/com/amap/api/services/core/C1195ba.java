package com.amap.api.services.core;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.ba */
/* loaded from: classes.dex */
public class C1195ba extends AbstractC1209bi {

    /* renamed from: a */
    private String[] f4064a = new String[10];

    /* renamed from: b */
    private int f4065b = 0;

    /* renamed from: c */
    private boolean f4066c = false;

    /* renamed from: d */
    private int f4067d = 0;

    /* renamed from: e */
    private C1197a f4068e;

    /* renamed from: com.amap.api.services.core.ba$a */
    /* loaded from: classes.dex */
    private class C1197a implements AbstractC1218bn {

        /* renamed from: b */
        private C1175ak f4070b;

        private C1197a(C1175ak c1175ak) {
            this.f4070b = c1175ak;
        }

        @Override // com.amap.api.services.core.AbstractC1218bn
        /* renamed from: a */
        public void mo17075a(String str) {
            try {
                this.f4070b.m17227b(str, C1195ba.this.mo17148a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m17168b(String str) {
        try {
            if (this.f4065b > 9) {
                this.f4065b = 0;
            }
            this.f4064a[this.f4065b] = str;
            this.f4065b++;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "ANRWriter", "addData");
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private String m17167c() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = this.f4065b; i < 10 && i <= 9; i++) {
                sb.append(this.f4064a[i]);
            }
            for (int i2 = 0; i2 < this.f4065b; i2++) {
                sb.append(this.f4064a[i2]);
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "ANRWriter", "getLogInfo");
            th.printStackTrace();
        }
        return sb.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected int mo17148a() {
        return 2;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected AbstractC1218bn mo17140a(C1175ak c1175ak) {
        try {
            if (this.f4068e == null) {
                this.f4068e = new C1197a(c1175ak);
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "ANRWriter", "getListener");
            th.printStackTrace();
        }
        return this.f4068e;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected String mo17138a(String str) {
        return C1164ab.m17275b(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e4  */
    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String mo17135a(List<C1166ad> list) {
        FileInputStream fileInputStream;
        C1219bo c1219bo;
        C1219bo c1219bo2;
        FileInputStream fileInputStream2;
        File file;
        String str;
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
            c1219bo2 = null;
            fileInputStream2 = null;
        } catch (IOException e2) {
            e = e2;
            c1219bo = null;
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
                    C1190ay.m17177a(e3, "ANRWriter", "initLog1");
                    e3.printStackTrace();
                } catch (Throwable th3) {
                    C1190ay.m17177a(th3, "ANRWriter", "initLog2");
                    th3.printStackTrace();
                }
            }
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    C1190ay.m17177a(e4, "ANRWriter", "initLog3");
                    e4.printStackTrace();
                } catch (Throwable th4) {
                    C1190ay.m17177a(th4, "ANRWriter", "initLog4");
                    th4.printStackTrace();
                }
            }
            return null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            c1219bo = new C1219bo(fileInputStream, C1221bp.f4133a);
            boolean z2 = false;
            while (true) {
                try {
                    String m17074a = c1219bo.m17074a();
                    if (m17074a.contains("pid")) {
                        while (!m17074a.contains("\"main\"")) {
                            m17074a = c1219bo.m17074a();
                        }
                        str = m17074a;
                        z = true;
                    } else {
                        str = m17074a;
                        z = z2;
                    }
                    z2 = str.equals("") ? false : z;
                    if (z2) {
                        m17168b(str);
                        if (this.f4067d == 5) {
                            break;
                        } else if (!this.f4066c) {
                            for (C1166ad c1166ad : list) {
                                this.f4066c = a(c1166ad.m17259f(), str);
                                if (this.f4066c) {
                                    a(c1166ad);
                                }
                            }
                        } else {
                            this.f4067d++;
                        }
                    }
                } catch (EOFException e5) {
                } catch (FileNotFoundException e6) {
                    c1219bo2 = c1219bo;
                    fileInputStream2 = fileInputStream;
                    if (c1219bo2 != null) {
                        try {
                            c1219bo2.close();
                        } catch (IOException e7) {
                            C1190ay.m17177a(e7, "ANRWriter", "initLog1");
                            e7.printStackTrace();
                        } catch (Throwable th5) {
                            C1190ay.m17177a(th5, "ANRWriter", "initLog2");
                            th5.printStackTrace();
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            e = e8;
                            C1190ay.m17177a(e, "ANRWriter", "initLog3");
                            e.printStackTrace();
                            if (!this.f4066c) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            C1190ay.m17177a(th, "ANRWriter", "initLog4");
                            th.printStackTrace();
                            if (!this.f4066c) {
                            }
                        }
                    }
                    if (!this.f4066c) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    C1190ay.m17177a(e, "ANRWriter", "initLog");
                    e.printStackTrace();
                    if (c1219bo != null) {
                        try {
                            c1219bo.close();
                        } catch (IOException e10) {
                            C1190ay.m17177a(e10, "ANRWriter", "initLog1");
                            e10.printStackTrace();
                        } catch (Throwable th7) {
                            C1190ay.m17177a(th7, "ANRWriter", "initLog2");
                            th7.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            e = e11;
                            C1190ay.m17177a(e, "ANRWriter", "initLog3");
                            e.printStackTrace();
                            if (!this.f4066c) {
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            C1190ay.m17177a(th, "ANRWriter", "initLog4");
                            th.printStackTrace();
                            if (!this.f4066c) {
                            }
                        }
                    }
                    if (!this.f4066c) {
                    }
                }
            }
            if (c1219bo != null) {
                try {
                    c1219bo.close();
                } catch (IOException e12) {
                    C1190ay.m17177a(e12, "ANRWriter", "initLog1");
                    e12.printStackTrace();
                } catch (Throwable th9) {
                    C1190ay.m17177a(th9, "ANRWriter", "initLog2");
                    th9.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e13) {
                    e = e13;
                    C1190ay.m17177a(e, "ANRWriter", "initLog3");
                    e.printStackTrace();
                    if (!this.f4066c) {
                    }
                } catch (Throwable th10) {
                    th = th10;
                    C1190ay.m17177a(th, "ANRWriter", "initLog4");
                    th.printStackTrace();
                    if (!this.f4066c) {
                    }
                }
            }
        } catch (FileNotFoundException e14) {
            c1219bo2 = null;
            fileInputStream2 = fileInputStream;
        } catch (IOException e15) {
            e = e15;
            c1219bo = null;
        } catch (Throwable th11) {
            th = th11;
            autoCloseable = null;
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (IOException e16) {
                    C1190ay.m17177a(e16, "ANRWriter", "initLog1");
                    e16.printStackTrace();
                } catch (Throwable th12) {
                    C1190ay.m17177a(th12, "ANRWriter", "initLog2");
                    th12.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    C1190ay.m17177a(e17, "ANRWriter", "initLog3");
                    e17.printStackTrace();
                } catch (Throwable th13) {
                    C1190ay.m17177a(th13, "ANRWriter", "initLog4");
                    th13.printStackTrace();
                }
            }
            throw th;
        }
        if (!this.f4066c) {
            return null;
        }
        return m17167c();
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: b */
    protected String mo17133b() {
        return C1204bf.f4082d;
    }
}
