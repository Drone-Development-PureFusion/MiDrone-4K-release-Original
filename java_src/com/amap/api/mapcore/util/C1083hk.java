package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.C1046gt;
import java.io.InputStream;
/* renamed from: com.amap.api.mapcore.util.hk */
/* loaded from: classes.dex */
public class C1083hk {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.InputStream] */
    /* renamed from: a */
    public static byte[] m17667a(C1046gt c1046gt, String str) {
        C1046gt.C1051b c1051b;
        InputStream inputStream = 0;
        inputStream = null;
        byte[] bArr = new byte[0];
        try {
            c1051b = c1046gt.m17819a(str);
            if (c1051b != null) {
                try {
                    InputStream m17792a = c1051b.m17792a(0);
                    if (m17792a == null) {
                        if (m17792a != null) {
                            try {
                                m17792a.close();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        if (c1051b != null) {
                            try {
                                c1051b.close();
                            } catch (Throwable th2) {
                                th = th2;
                                return bArr;
                            }
                        }
                    } else {
                        bArr = new byte[m17792a.available()];
                        m17792a.read(bArr);
                        c1046gt.m17812c(str);
                        if (m17792a != null) {
                            try {
                                m17792a.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (c1051b != null) {
                            try {
                                c1051b.close();
                            } catch (Throwable th4) {
                                th = th4;
                                return bArr;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        C1002fl.m18028a(th, "Utils", "readSingleLog");
                        if (inputStream != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        if (c1051b != null) {
                            try {
                                c1051b.close();
                            } catch (Throwable th7) {
                                th = th7;
                                return bArr;
                            }
                        }
                        return bArr;
                    } finally {
                        if (inputStream != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        }
                        if (c1051b != null) {
                            try {
                                c1051b.close();
                            } catch (Throwable th9) {
                                th9.printStackTrace();
                            }
                        }
                    }
                }
            } else if (c1051b != null) {
                try {
                } catch (Throwable th10) {
                    return bArr;
                }
            }
        } catch (Throwable th11) {
            th = th11;
            c1051b = inputStream;
        }
        return bArr;
    }
}
