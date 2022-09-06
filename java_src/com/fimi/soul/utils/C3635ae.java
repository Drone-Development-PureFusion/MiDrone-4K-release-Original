package com.fimi.soul.utils;

import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/* renamed from: com.fimi.soul.utils.ae */
/* loaded from: classes.dex */
public class C3635ae {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0178 A[Catch: MalformedURLException -> 0x00b9, TRY_LEAVE, TryCatch #11 {MalformedURLException -> 0x00b9, blocks: (B:6:0x0051, B:22:0x00a5, B:32:0x00d0, B:37:0x00b5, B:55:0x0128, B:64:0x014e, B:69:0x0149, B:98:0x0178, B:101:0x0185, B:106:0x018c, B:111:0x0187, B:78:0x0159, B:86:0x0169, B:93:0x016f, B:34:0x00aa, B:29:0x00af, B:61:0x0132, B:90:0x015e, B:103:0x0182, B:82:0x0163, B:66:0x012d, B:108:0x017d), top: B:5:0x0051, inners: #2, #5, #6, #7, #8, #12, #13, #15 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m7714a(String str, String str2, String str3, int i, Handler handler) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        int read;
        FileOutputStream fileOutputStream2 = null;
        InputStream inputStream2 = null;
        HttpURLConnection httpURLConnection = null;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str3 + "/" + str2);
        System.out.println("test.apk==" + file2.getName());
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    System.out.println("conn.getContentLength()==" + httpURLConnection2.getContentLength());
                    long contentLength = httpURLConnection2.getContentLength();
                    inputStream = httpURLConnection2.getInputStream();
                    long j = 0;
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[3072];
                            httpURLConnection2.connect();
                            if (httpURLConnection2.getResponseCode() >= 400) {
                                System.out.println("nono");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return 0;
                            }
                            long j2 = 0;
                            while (0.0d <= 100.0d && inputStream != null && (read = inputStream.read(bArr)) > 0) {
                                fileOutputStream.write(bArr, 0, read);
                                j += read;
                                long j3 = (100 * j) / contentLength;
                                if (System.currentTimeMillis() - j2 > 1000) {
                                    j2 = System.currentTimeMillis();
                                    Message obtain = Message.obtain();
                                    obtain.what = 2;
                                    obtain.obj = Long.valueOf(j3);
                                    obtain.arg1 = i;
                                    handler.sendMessage(obtain);
                                }
                            }
                            httpURLConnection2.disconnect();
                            fileOutputStream.close();
                            inputStream.close();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            Message obtain2 = Message.obtain();
                            obtain2.what = 1;
                            obtain2.arg1 = i;
                            handler.sendMessage(obtain2);
                            return 1;
                        } catch (IOException e5) {
                            inputStream2 = inputStream;
                            fileOutputStream2 = fileOutputStream;
                            httpURLConnection = httpURLConnection2;
                            e = e5;
                            try {
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (inputStream2 == null) {
                                    return 0;
                                }
                                try {
                                    inputStream2.close();
                                    return 0;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    return 0;
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            if (httpURLConnection != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e10) {
                        inputStream2 = inputStream;
                        e = e10;
                        httpURLConnection = httpURLConnection2;
                    } catch (Throwable th3) {
                        fileOutputStream = null;
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                    }
                } catch (IOException e11) {
                    httpURLConnection = httpURLConnection2;
                    e = e11;
                } catch (Throwable th4) {
                    inputStream = null;
                    fileOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                }
            } catch (IOException e12) {
                e = e12;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                fileOutputStream = null;
            }
        } catch (MalformedURLException e13) {
            e13.printStackTrace();
            Message obtain3 = Message.obtain();
            obtain3.what = 0;
            obtain3.arg1 = i;
            handler.sendMessage(obtain3);
            return 0;
        }
        e13.printStackTrace();
        Message obtain32 = Message.obtain();
        obtain32.what = 0;
        obtain32.arg1 = i;
        handler.sendMessage(obtain32);
        return 0;
    }

    /* renamed from: a */
    public static int m7713a(String str, String str2, String str3, Handler handler) {
        return m7714a(str, str2, str3, 0, handler);
    }
}
