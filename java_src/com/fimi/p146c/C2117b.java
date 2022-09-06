package com.fimi.p146c;

import com.p078a.p079a.C0718aa;
import com.p078a.p079a.C0748w;
import com.p078a.p079a.C0750y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
/* renamed from: com.fimi.c.b */
/* loaded from: classes.dex */
public class C2117b {

    /* renamed from: a */
    public static final int f7073a = 0;

    /* renamed from: b */
    public static final int f7074b = 1;

    /* renamed from: c */
    public static final int f7075c = 2;

    /* renamed from: d */
    public static final int f7076d = 3;

    /* renamed from: e */
    public static final int f7077e = 4;

    /* renamed from: f */
    public static final int f7078f = 5;

    /* renamed from: a */
    public static int m13616a(String str, String str2) {
        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            return 1;
        }
        try {
            C0750y c0750y = new C0750y(file2, "GBK");
            Enumeration<C0748w> m19147c = c0750y.m19147c();
            String absolutePath = file.getAbsolutePath();
            while (m19147c.hasMoreElements()) {
                m13617a(c0750y, m19147c.nextElement(), absolutePath);
            }
            return 3;
        } catch (IOException e) {
            e.printStackTrace();
            return 5;
        }
    }

    /* renamed from: a */
    public static int m13615a(String str, File[] fileArr) {
        C0718aa c0718aa;
        Throwable th;
        File file = new File(str);
        if (file.exists()) {
            return 4;
        }
        String absolutePath = file.getAbsolutePath();
        File file2 = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator)));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        C0718aa c0718aa2 = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            c0718aa = new C0718aa(new FileOutputStream(file));
        } catch (IOException e) {
        } catch (Throwable th2) {
            c0718aa = null;
            th = th2;
        }
        try {
            for (File file3 : fileArr) {
                if (file3.exists()) {
                    m13618a(c0718aa, file3, "");
                }
            }
            try {
                c0718aa.close();
                return 3;
            } catch (IOException e2) {
                file.delete();
                e2.printStackTrace();
                return 5;
            }
        } catch (IOException e3) {
            c0718aa2 = c0718aa;
            try {
                file.delete();
                try {
                    c0718aa2.close();
                    return 5;
                } catch (IOException e4) {
                    file.delete();
                    e4.printStackTrace();
                    return 5;
                }
            } catch (Throwable th3) {
                c0718aa = c0718aa2;
                th = th3;
                try {
                    c0718aa.close();
                    throw th;
                } catch (IOException e5) {
                    file.delete();
                    e5.printStackTrace();
                    return 5;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            c0718aa.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m13618a(C0718aa c0718aa, File file, String str) {
        FileInputStream fileInputStream;
        if (file.isDirectory()) {
            String str2 = str + file.getName() + File.separator;
            for (File file2 : file.listFiles()) {
                m13618a(c0718aa, file2, str2);
            }
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            c0718aa.m19328a(new C0748w(str + file.getName()));
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            try {
                                fileInputStream.close();
                                c0718aa.m19304d();
                                return;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        c0718aa.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                        c0718aa.m19304d();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                try {
                    fileInputStream2.close();
                    c0718aa.m19304d();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2.close();
            c0718aa.m19304d();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m13617a(C0750y c0750y, C0748w c0748w, String str) {
        String str2;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        byte[] bArr = new byte[5120];
        String name = c0748w.getName();
        String str3 = "";
        if (c0748w.isDirectory()) {
            File file = new File(str + File.separator + name);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        int lastIndexOf = name.lastIndexOf(File.separator);
        if (lastIndexOf != -1) {
            str2 = name.substring(lastIndexOf, name.length());
            str3 = name.substring(0, lastIndexOf);
            File file2 = new File(str + File.separator + str3);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } else {
            str2 = name;
        }
        File file3 = new File(str + File.separator + str3 + str2);
        try {
            inputStream = c0750y.m19150b(c0748w);
            try {
                if (!file3.exists()) {
                    file3.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file3);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            try {
                                inputStream.close();
                                fileOutputStream.close();
                                return;
                            } catch (IOException e) {
                                new File(str).delete();
                                e.printStackTrace();
                                return;
                            }
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        inputStream2 = inputStream;
                        try {
                            new File(str).delete();
                            e.printStackTrace();
                            try {
                                inputStream2.close();
                                fileOutputStream.close();
                                return;
                            } catch (IOException e3) {
                                new File(str).delete();
                                e3.printStackTrace();
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            try {
                                inputStream.close();
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                new File(str).delete();
                                e4.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream.close();
                        fileOutputStream.close();
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                inputStream2 = inputStream;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            inputStream = null;
        }
    }
}
