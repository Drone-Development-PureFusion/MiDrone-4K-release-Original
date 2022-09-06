package p004b.p005a.p006a.p028b.p051m.p052a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p055p.C0541a;
import p004b.p005a.p006a.p028b.p055p.C0553m;
import p004b.p005a.p006a.p028b.p057r.C0581o;
/* renamed from: b.a.a.b.m.a.e */
/* loaded from: classes.dex */
public class C0475e extends C0527f {

    /* renamed from: b */
    static final int f1051b = 8192;

    /* renamed from: a */
    final EnumC0473c f1052a;

    public C0475e(EnumC0473c enumC0473c) {
        this.f1052a = enumC0473c;
    }

    /* renamed from: a */
    public static String m20415a(String str, EnumC0473c enumC0473c) {
        int length = str.length();
        switch (enumC0473c) {
            case GZ:
                return str.endsWith(".gz") ? str.substring(0, length - 3) : str;
            case ZIP:
                return str.endsWith(".zip") ? str.substring(0, length - 4) : str;
            case NONE:
                return str;
            default:
                throw new IllegalStateException("Execution should not reach this point");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m20414a(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        GZIPOutputStream gZIPOutputStream;
        BufferedInputStream bufferedInputStream2;
        GZIPOutputStream gZIPOutputStream2 = null;
        r2 = null;
        gZIPOutputStream2 = null;
        BufferedInputStream bufferedInputStream3 = null;
        File file = new File(str);
        if (!file.exists()) {
            a(new C0553m("The file to compress named [" + str + "] does not exist.", this));
            return;
        }
        if (!str2.endsWith(".gz")) {
            str2 = str2 + ".gz";
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            e("The target compressed file named [" + str2 + "] exist already. Aborting file compression.");
            return;
        }
        d("GZ compressing [" + file + "] as [" + file2 + "]");
        m20412b(file2);
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(str2));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        gZIPOutputStream.write(bArr, 0, read);
                    }
                    bufferedInputStream.close();
                    bufferedInputStream2 = null;
                } catch (Exception e) {
                    e = e;
                    bufferedInputStream3 = bufferedInputStream;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream2 = gZIPOutputStream;
                }
            } catch (Exception e2) {
                e = e2;
                gZIPOutputStream = null;
                bufferedInputStream3 = bufferedInputStream;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                gZIPOutputStream.close();
                GZIPOutputStream gZIPOutputStream3 = null;
                if (!file.delete()) {
                    a(new C0553m("Could not delete [" + str + "].", this));
                }
                if (0 != 0) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                if (0 == 0) {
                    return;
                }
                try {
                    gZIPOutputStream3.close();
                } catch (IOException e4) {
                }
            } catch (Exception e5) {
                e = e5;
                try {
                    a(new C0541a("Error occurred while compressing [" + str + "] into [" + str2 + "].", this, e));
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (gZIPOutputStream == null) {
                        return;
                    }
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e7) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream3;
                    gZIPOutputStream2 = gZIPOutputStream;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (gZIPOutputStream2 != null) {
                        try {
                            gZIPOutputStream2.close();
                        } catch (IOException e9) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                gZIPOutputStream2 = gZIPOutputStream;
                if (bufferedInputStream != null) {
                }
                if (gZIPOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            gZIPOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m20411b(String str, String str2, String str3) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        File file = new File(str);
        if (!file.exists()) {
            a(new C0553m("The file to compress named [" + str + "] does not exist.", this));
        } else if (str3 == null) {
            a(new C0553m("The innerEntryName parameter cannot be null", this));
        } else {
            if (!str2.endsWith(".zip")) {
                str2 = str2 + ".zip";
            }
            File file2 = new File(str2);
            if (file2.exists()) {
                a(new C0553m("The target compressed file named [" + str2 + "] exist already.", this));
                return;
            }
            d("ZIP compressing [" + file + "] as [" + file2 + "]");
            m20412b(file2);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                } catch (Exception e) {
                    e = e;
                    zipOutputStream = null;
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = null;
                    bufferedInputStream2 = bufferedInputStream;
                }
            } catch (Exception e2) {
                e = e2;
                zipOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
            }
            try {
                zipOutputStream.putNextEntry(m20416a(str3));
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
                BufferedInputStream bufferedInputStream3 = null;
                try {
                    try {
                        zipOutputStream.close();
                        ZipOutputStream zipOutputStream2 = null;
                        if (!file.delete()) {
                            a(new C0553m("Could not delete [" + str + "].", this));
                        }
                        if (0 != 0) {
                            try {
                                bufferedInputStream3.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (0 == 0) {
                            return;
                        }
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    } catch (Exception e5) {
                        e = e5;
                        a(new C0541a("Error occurred while compressing [" + str + "] into [" + str2 + "].", this, e));
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (zipOutputStream == null) {
                            return;
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                bufferedInputStream2 = bufferedInputStream;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (zipOutputStream != null) {
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    ZipEntry m20417a(File file) {
        return m20416a(file.getName());
    }

    /* renamed from: a */
    ZipEntry m20416a(String str) {
        return new ZipEntry(m20415a(str, this.f1052a));
    }

    /* renamed from: a */
    public void m20413a(String str, String str2, String str3) {
        switch (this.f1052a) {
            case GZ:
                m20414a(str, str2);
                return;
            case ZIP:
                m20411b(str, str2, str3);
                return;
            case NONE:
                throw new UnsupportedOperationException("compress method called in NONE compression mode");
            default:
                return;
        }
    }

    /* renamed from: b */
    void m20412b(File file) {
        if (C0581o.m20088b(file)) {
            if (!C0581o.m20086c(file)) {
                c("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            } else {
                d("Created missing parent directories for [" + file.getAbsolutePath() + "]");
            }
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
