package com.xiaomi.push.log;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.misc.C4488h;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/* renamed from: com.xiaomi.push.log.f */
/* loaded from: classes2.dex */
public class C4563f implements LoggerInterface {

    /* renamed from: a */
    private static final SimpleDateFormat f18746a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: b */
    private static C4488h f18747b = new C4488h(true);

    /* renamed from: c */
    private static String f18748c = "/MiPushLog";

    /* renamed from: f */
    private static List<Pair<String, Throwable>> f18749f = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private String f18750d;

    /* renamed from: e */
    private Context f18751e;

    public C4563f(Context context) {
        this.f18751e = context;
        if (context.getApplicationContext() != null) {
            this.f18751e = context.getApplicationContext();
        }
        this.f18750d = this.f18751e.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m4709b() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedWriter bufferedWriter;
        RandomAccessFile randomAccessFile2;
        String str;
        String str2;
        BufferedWriter bufferedWriter2 = 0;
        bufferedWriter2 = 0;
        r2 = null;
        bufferedWriter2 = 0;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile3 = null;
        FileLock fileLock3 = null;
        BufferedWriter bufferedWriter3 = null;
        try {
            File file = new File(this.f18751e.getExternalFilesDir(null) + f18748c);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.f18750d, "Create mipushlog directory fail.");
                if (0 != 0) {
                    try {
                        bufferedWriter3.close();
                    } catch (IOException e) {
                        Log.e(this.f18750d, "", e);
                    }
                }
                if (0 != 0 && bufferedWriter2.isValid()) {
                    try {
                        fileLock3.release();
                    } catch (IOException e2) {
                        Log.e(this.f18750d, "", e2);
                    }
                }
                if (0 == 0) {
                    return;
                }
                try {
                    randomAccessFile3.close();
                    return;
                } catch (IOException e3) {
                    e = e3;
                    str = this.f18750d;
                    str2 = "";
                }
            } else {
                File file2 = new File(file, "log.lock");
                if (!file2.exists() || file2.isDirectory()) {
                    file2.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        BufferedWriter bufferedWriter4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                        while (!f18749f.isEmpty()) {
                            try {
                                Pair<String, Throwable> remove = f18749f.remove(0);
                                String str3 = (String) remove.first;
                                if (remove.second != null) {
                                    str3 = (str3 + "\n") + Log.getStackTraceString((Throwable) remove.second);
                                }
                                bufferedWriter4.write(str3 + "\n");
                            } catch (Exception e4) {
                                e = e4;
                                bufferedWriter = bufferedWriter4;
                                fileLock2 = fileLock;
                                randomAccessFile2 = randomAccessFile;
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter2 = bufferedWriter4;
                            }
                        }
                        bufferedWriter4.flush();
                        if (bufferedWriter4 != null) {
                            bufferedWriter4.close();
                            bufferedWriter = null;
                        } else {
                            bufferedWriter = bufferedWriter4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedWriter = null;
                        randomAccessFile2 = randomAccessFile;
                        fileLock2 = fileLock;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        File file3 = new File(file, "log1.txt");
                        if (file3.length() >= 1048576) {
                            File file4 = new File(file, "log0.txt");
                            if (file4.exists() && file4.isFile()) {
                                file4.delete();
                            }
                            file3.renameTo(file4);
                        }
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e6) {
                                Log.e(this.f18750d, "", e6);
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e7) {
                                Log.e(this.f18750d, "", e7);
                            }
                        }
                        if (randomAccessFile == null) {
                            return;
                        }
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (IOException e8) {
                            e = e8;
                            str = this.f18750d;
                            str2 = "";
                        }
                    } catch (Exception e9) {
                        e = e9;
                        fileLock2 = fileLock;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            Log.e(this.f18750d, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e10) {
                                    Log.e(this.f18750d, "", e10);
                                }
                            }
                            if (fileLock2 != null && fileLock2.isValid()) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e11) {
                                    Log.e(this.f18750d, "", e11);
                                }
                            }
                            if (randomAccessFile2 == null) {
                                return;
                            }
                            try {
                                randomAccessFile2.close();
                                return;
                            } catch (IOException e12) {
                                e = e12;
                                str = this.f18750d;
                                str2 = "";
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile2;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != 0) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e13) {
                                    Log.e(this.f18750d, "", e13);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e14) {
                                    Log.e(this.f18750d, "", e14);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e15) {
                                    Log.e(this.f18750d, "", e15);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != 0) {
                        }
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    bufferedWriter = null;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock = null;
                }
            }
            Log.e(str, str2, e);
        } catch (Exception e17) {
            e = e17;
            bufferedWriter = null;
            randomAccessFile2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileLock = null;
            randomAccessFile = null;
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        f18749f.add(new Pair<>(String.format("%1$s %2$s %3$s ", f18746a.format(new Date()), this.f18750d, str), th));
        f18747b.m5015a(new C4564g(this));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f18750d = str;
    }
}
