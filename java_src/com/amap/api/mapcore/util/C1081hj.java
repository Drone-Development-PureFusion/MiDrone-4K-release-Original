package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import com.amap.api.mapcore.util.C1046gt;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
/* renamed from: com.amap.api.mapcore.util.hj */
/* loaded from: classes.dex */
public class C1081hj {

    /* renamed from: a */
    private static boolean f3380a = true;

    /* renamed from: a */
    public static void m17677a(Context context) {
        try {
            if (!m17668g(context)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(UUID.randomUUID().toString());
            stringBuffer.append(" ");
            if (stringBuffer.length() != 53) {
                return;
            }
            byte[] m18047a = C0999fi.m18047a(stringBuffer.toString());
            byte[] m17673b = m17673b(context);
            byte[] bArr = new byte[m18047a.length + m17673b.length];
            System.arraycopy(m18047a, 0, bArr, 0, m18047a.length);
            System.arraycopy(m17673b, 0, bArr, m18047a.length, m17673b.length);
            C1057gx.m17771a().mo17705b(new C1006fn(C0999fi.m18039c(bArr), "2"));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "StatisticsManager", "updateStaticsData");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m17676a(Context context, long j) {
        FileOutputStream fileOutputStream;
        File file = new File(C1003fm.m18024a(context, "c.log"));
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(C0999fi.m18047a(String.valueOf(j)));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            th.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static synchronized void m17674a(final C1080hi c1080hi, final Context context) {
        synchronized (C1081hj.class) {
            C1007fo.m18011c().submit(new Runnable() { // from class: com.amap.api.mapcore.util.hj.1
                @Override // java.lang.Runnable
                public void run() {
                    C1046gt c1046gt;
                    OutputStream outputStream = null;
                    synchronized (C1081hj.class) {
                        Random random = new Random();
                        try {
                            byte[] m17681a = C1080hi.this.m17681a();
                            c1046gt = C1046gt.m17821a(new File(C1003fm.m18024a(context, C1003fm.f3164e)), 1, 1, 102400L);
                            try {
                                C1046gt.C1049a m17815b = c1046gt.m17815b(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()));
                                outputStream = m17815b.m17797a(0);
                                outputStream.write(m17681a);
                                m17815b.m17798a();
                                c1046gt.m17817b();
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (c1046gt != null) {
                                    c1046gt.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                C1002fl.m18028a(th, "StatisticsManager", "applyStatics");
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (c1046gt != null) {
                                    c1046gt.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            c1046gt = null;
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private static byte[] m17675a(Context context, byte[] bArr) {
        try {
            return C0986fb.m18144a(context, bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m17673b(Context context) {
        byte[] m17672c = m17672c(context);
        byte[] m17670e = m17670e(context);
        byte[] bArr = new byte[m17672c.length + m17670e.length];
        System.arraycopy(m17672c, 0, bArr, 0, m17672c.length);
        System.arraycopy(m17670e, 0, bArr, m17672c.length, m17670e.length);
        return m17675a(context, bArr);
    }

    /* renamed from: c */
    private static byte[] m17672c(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            C0999fi.m18048a(byteArrayOutputStream, "1.2.13.6");
            C0999fi.m18048a(byteArrayOutputStream, "Android");
            C0999fi.m18048a(byteArrayOutputStream, C0989fc.m18113q(context));
            C0999fi.m18048a(byteArrayOutputStream, C0989fc.m18121i(context));
            C0999fi.m18048a(byteArrayOutputStream, C0989fc.m18124f(context));
            C0999fi.m18048a(byteArrayOutputStream, Build.MANUFACTURER);
            C0999fi.m18048a(byteArrayOutputStream, Build.MODEL);
            C0999fi.m18048a(byteArrayOutputStream, Build.DEVICE);
            C0999fi.m18048a(byteArrayOutputStream, C0989fc.m18112r(context));
            C0999fi.m18048a(byteArrayOutputStream, C0976ey.m18169c(context));
            C0999fi.m18048a(byteArrayOutputStream, C0976ey.m18168d(context));
            C0999fi.m18048a(byteArrayOutputStream, C0976ey.m18166f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            try {
            } catch (Throwable th) {
                return bArr;
            }
        } catch (Throwable th2) {
            try {
                C1002fl.m18028a(th2, "StatisticsManager", "getHeader");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    return bArr;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        }
        return bArr;
    }

    /* renamed from: d */
    private static int m17671d(Context context) {
        try {
            File file = new File(C1003fm.m18024a(context, C1003fm.f3164e));
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "StatisticsManager", "getFileNum");
            return 0;
        }
    }

    /* renamed from: e */
    private static byte[] m17670e(Context context) {
        String[] list;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        String m18024a = C1003fm.m18024a(context, C1003fm.f3164e);
        C1046gt c1046gt = null;
        try {
            try {
                c1046gt = C1046gt.m17821a(new File(m18024a), 1, 1, 102400L);
                File file = new File(m18024a);
                if (file != null && file.exists()) {
                    for (String str : file.list()) {
                        if (str.contains(".0")) {
                            byteArrayOutputStream.write(C1083hk.m17667a(c1046gt, str.split("\\.")[0]));
                        }
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (c1046gt != null) {
                    try {
                        c1046gt.close();
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        return bArr;
                    }
                }
            } catch (Throwable th2) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (c1046gt != null) {
                    try {
                        c1046gt.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (IOException e3) {
            C1002fl.m18028a(e3, "StatisticsManager", "getContent");
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (c1046gt != null) {
                try {
                    c1046gt.close();
                } catch (Throwable th4) {
                    th = th4;
                    th.printStackTrace();
                    return bArr;
                }
            }
        } catch (Throwable th5) {
            C1002fl.m18028a(th5, "StatisticsManager", "getContent");
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (c1046gt != null) {
                try {
                    c1046gt.close();
                } catch (Throwable th6) {
                    th = th6;
                    th.printStackTrace();
                    return bArr;
                }
            }
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long m17669f(Context context) {
        FileInputStream fileInputStream;
        long j = 0;
        File file = new File(C1003fm.m18024a(context, "c.log"));
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        j = Long.parseLong(C0999fi.m18043a(bArr));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                                return j;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        C1002fl.m18028a(e, "StatisticsManager", "getUpdateTime");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                                return j;
                            }
                        }
                        return j;
                    } catch (IOException e2) {
                        e = e2;
                        C1002fl.m18028a(e, "StatisticsManager", "getUpdateTime");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                th = th3;
                                th.printStackTrace();
                                return j;
                            }
                        }
                        return j;
                    } catch (Throwable th4) {
                        th = th4;
                        C1002fl.m18028a(th, "StatisticsManager", "getUpdateTime");
                        if (file != null && file.exists()) {
                            file.delete();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                th.printStackTrace();
                                return j;
                            }
                        }
                        return j;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (0 != 0) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = null;
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileInputStream = null;
            }
        }
        return j;
    }

    /* renamed from: g */
    private static boolean m17668g(Context context) {
        try {
            if (C0989fc.m18117m(context) != 1 || !f3380a || m17671d(context) < 100) {
                return false;
            }
            long m17669f = m17669f(context);
            long time = new Date().getTime();
            if (time - m17669f < Util.MILLSECONDS_OF_HOUR) {
                return false;
            }
            m17676a(context, time);
            f3380a = false;
            return true;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "StatisticsManager", "isUpdate");
            return false;
        }
    }
}
