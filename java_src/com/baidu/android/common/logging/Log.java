package com.baidu.android.common.logging;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import p004b.p005a.p006a.p007a.p019j.C0189k;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public final class Log {
    public static final int FILE_LIMETE = 10485760;
    public static final int FILE_NUMBER = 2;
    private static Logger sFilelogger;
    private static boolean sLogEnabled = true;
    private static boolean sLog2File = false;

    private Log() {
    }

    /* renamed from: d */
    public static void m15421d(String str, String str2) {
        if (sLogEnabled) {
            if (!sLog2File || sFilelogger == null) {
                android.util.Log.d(str, str2);
            } else {
                sFilelogger.log(Level.INFO, str + ": " + str2);
            }
        }
    }

    /* renamed from: d */
    public static void m15420d(String str, String str2, Throwable th) {
        m15421d(str, str2 + '\n' + getStackTraceString(th));
    }

    /* renamed from: e */
    public static void m15419e(String str, String str2) {
        if (sLogEnabled) {
            if (!sLog2File || sFilelogger == null) {
                android.util.Log.e(str, str2);
            } else {
                sFilelogger.log(Level.SEVERE, str + ": " + str2);
            }
        }
    }

    /* renamed from: e */
    public static void m15418e(String str, String str2, Throwable th) {
        m15419e(str, str2 + '\n' + getStackTraceString(th));
    }

    /* renamed from: e */
    public static void m15417e(String str, Throwable th) {
        m15419e(str, getStackTraceString(th));
    }

    private static String getLogFileName() {
        String processNameForPid = getProcessNameForPid(Process.myPid());
        if (TextUtils.isEmpty(processNameForPid)) {
            processNameForPid = "BaiduFileLog";
        }
        return processNameForPid.replace(C0359h.f671A, '_');
    }

    private static String getProcessNameForPid(int i) {
        String str;
        Exception e;
        BufferedReader bufferedReader;
        String str2 = "/proc/" + i + "/status";
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/" + i + "/cmdline")));
            String readLine = bufferedReader2.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                str = readLine.substring(0, readLine.indexOf(0));
                bufferedReader = bufferedReader2;
            } else {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(new File(str2)));
                String readLine2 = bufferedReader3.readLine();
                while (true) {
                    if (readLine2 == null) {
                        break;
                    } else if (readLine2.startsWith("Name:")) {
                        int indexOf = readLine2.indexOf(C0189k.f315b);
                        if (indexOf >= 0) {
                            str = readLine2.substring(indexOf + 1);
                            bufferedReader = bufferedReader3;
                        }
                    } else {
                        readLine2 = bufferedReader3.readLine();
                    }
                }
                str = "";
                bufferedReader = bufferedReader3;
            }
            try {
                bufferedReader.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            str = "";
            e = e3;
        }
        return str;
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: i */
    public static void m15416i(String str, String str2) {
        if (sLogEnabled) {
            if (!sLog2File || sFilelogger == null) {
                android.util.Log.i(str, str2);
            } else {
                sFilelogger.log(Level.INFO, str + ": " + str2);
            }
        }
    }

    /* renamed from: i */
    public static void m15415i(String str, String str2, Throwable th) {
        m15416i(str, str2 + '\n' + getStackTraceString(th));
    }

    public static void setLog2File(boolean z) {
        sLog2File = z;
        if (!sLog2File || sFilelogger != null) {
            return;
        }
        String logFileName = getLogFileName();
        try {
            FileHandler fileHandler = new FileHandler(new File(Environment.getExternalStorageDirectory(), logFileName).getAbsolutePath() + "_%g.log", FILE_LIMETE, 2, true);
            fileHandler.setFormatter(new SimpleFormatter());
            sFilelogger = Logger.getLogger(logFileName);
            sFilelogger.setLevel(Level.ALL);
            sFilelogger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    public static void setLogEnabled(boolean z) {
        sLogEnabled = z;
    }

    /* renamed from: v */
    public static void m15414v(String str, String str2) {
        if (sLogEnabled) {
            if (!sLog2File || sFilelogger == null) {
                android.util.Log.v(str, str2);
            } else {
                sFilelogger.log(Level.INFO, str + ": " + str2);
            }
        }
    }

    /* renamed from: v */
    public static void m15413v(String str, String str2, Throwable th) {
        m15414v(str, str2 + '\n' + getStackTraceString(th));
    }

    /* renamed from: w */
    public static void m15412w(String str, String str2) {
        if (sLogEnabled) {
            if (!sLog2File || sFilelogger == null) {
                android.util.Log.w(str, str2);
            } else {
                sFilelogger.log(Level.WARNING, str + ": " + str2);
            }
        }
    }

    /* renamed from: w */
    public static void m15411w(String str, String str2, Throwable th) {
        m15412w(str, str2 + '\n' + getStackTraceString(th));
    }
}
