package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* renamed from: com.amap.api.mapcore.util.hh */
/* loaded from: classes.dex */
public class C1079hh {
    /* renamed from: a */
    private static String m17688a(String str) {
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        C1046gt c1046gt = null;
        try {
            try {
                c1046gt = C1046gt.m17821a(new File(str), 1, 1, 204800L);
                File file = new File(str);
                if (file != null && file.exists()) {
                    String[] list = file.list();
                    for (String str2 : list) {
                        if (str2.contains(".0")) {
                            String m18043a = C0999fi.m18043a(C1083hk.m17667a(c1046gt, str2.split("\\.")[0]));
                            if (z) {
                                z = false;
                            } else {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            sb.append("{\"log\":\"").append(m18043a).append("\"}");
                        }
                    }
                }
                if (c1046gt != null) {
                    try {
                        c1046gt.close();
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        return sb.toString();
                    }
                }
            } catch (Throwable th2) {
                if (c1046gt != null) {
                    try {
                        c1046gt.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (IOException e) {
            C1002fl.m18028a(e, "StatisticsManager", "getContent");
            if (c1046gt != null) {
                try {
                    c1046gt.close();
                } catch (Throwable th4) {
                    th = th4;
                    th.printStackTrace();
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m17690a(Context context) {
        try {
            if (!m17684e(context)) {
                return;
            }
            m17689a(context, System.currentTimeMillis());
            String m17687b = m17687b(context);
            if (TextUtils.isEmpty(m17687b)) {
                return;
            }
            C1057gx.m17771a().mo17705b(new C1006fn(C0999fi.m18039c(C0999fi.m18047a(m17687b)), "6"));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "OfflineLocManager", "updateOfflineLocData");
        }
    }

    /* renamed from: a */
    private static void m17689a(Context context, long j) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(C1003fm.m18024a(context, "f.log"));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(C0999fi.m18047a(String.valueOf(j)));
            if (fileOutputStream == null) {
                return;
            }
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            try {
                C1002fl.m18028a(th, "OfflineLocManager", "updateLogUpdateTime");
                if (fileOutputStream2 == null) {
                    return;
                }
                try {
                    fileOutputStream2.close();
                } catch (Throwable th4) {
                    th = th4;
                    th.printStackTrace();
                }
            } catch (Throwable th5) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }

    /* renamed from: b */
    private static String m17687b(Context context) {
        String m17688a = m17688a(C1003fm.m18024a(context, C1003fm.f3165f));
        if (TextUtils.isEmpty(m17688a)) {
            return null;
        }
        String m17683f = m17683f(context);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"").append(m17683f).append("\",\"els\":[");
        sb.append(m17688a);
        sb.append("]}");
        return sb.toString();
    }

    /* renamed from: c */
    private static int m17686c(Context context) {
        try {
            File file = new File(C1003fm.m18024a(context, C1003fm.f3165f));
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "OfflineLocManager", "getFileNum");
            return 0;
        }
    }

    /* renamed from: d */
    private static long m17685d(Context context) {
        File file = new File(C1003fm.m18024a(context, "f.log"));
        if (!file.exists()) {
            return 0L;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                long parseLong = Long.parseLong(C0999fi.m18043a(bArr));
                if (fileInputStream2 == null) {
                    return parseLong;
                }
                try {
                    fileInputStream2.close();
                    return parseLong;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return parseLong;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                try {
                    C1002fl.m18028a(th, "OfflineLocManager", "getUpdateTime");
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    return System.currentTimeMillis();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: e */
    private static boolean m17684e(Context context) {
        try {
            if (C0989fc.m18117m(context) == 1) {
                if (System.currentTimeMillis() - m17685d(context) > 604800000) {
                    return true;
                }
                return m17686c(context) >= 100;
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "StatisticsManager", "isUpdate");
        }
        return false;
    }

    /* renamed from: f */
    private static String m17683f(Context context) {
        return C0986fb.m18139b(context, C0999fi.m18047a(m17682g(context)));
    }

    /* renamed from: g */
    private static String m17682g(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"").append(C0976ey.m18166f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(C0989fc.m18113q(context)).append("\",\"mac\":\"").append(C0989fc.m18121i(context)).append("\",\"tid\":\"").append(C0989fc.m18124f(context)).append("\",\"manufacture\":\"").append(Build.MANUFACTURER).append("\",\"device\":\"").append(Build.DEVICE).append("\",\"sim\":\"").append(C0989fc.m18112r(context)).append("\",\"pkg\":\"").append(C0976ey.m18169c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appversion\":\"").append(C0976ey.m18168d(context)).append("\"");
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }
}
