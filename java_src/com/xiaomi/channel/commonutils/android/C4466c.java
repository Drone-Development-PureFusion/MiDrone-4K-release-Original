package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.string.C4507d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* renamed from: com.xiaomi.channel.commonutils.android.c */
/* loaded from: classes2.dex */
public class C4466c {
    /* renamed from: a */
    public static boolean m5089a(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                byte[] m5053b = C4474a.m5053b(inputStream);
                File file = new File(str2);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String m4945a = C4507d.m4945a(C4474a.m5053b(fileInputStream));
                        String m4945a2 = C4507d.m4945a(m5053b);
                        if (!TextUtils.isEmpty(m4945a)) {
                            if (m4945a.equals(m4945a2)) {
                                C4474a.m5059a(inputStream);
                                C4474a.m5059a(fileInputStream);
                                C4474a.m5058a((OutputStream) null);
                                return false;
                            }
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        inputStream2 = inputStream;
                        try {
                            e.printStackTrace();
                            C4474a.m5059a(inputStream2);
                            C4474a.m5059a(fileInputStream);
                            C4474a.m5058a(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            C4474a.m5059a(inputStream);
                            C4474a.m5059a(fileInputStream);
                            C4474a.m5058a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C4474a.m5059a(inputStream);
                        C4474a.m5059a(fileInputStream);
                        C4474a.m5058a(fileOutputStream);
                        throw th;
                    }
                } else {
                    fileInputStream2 = null;
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(m5053b);
                        fileOutputStream2.flush();
                        C4474a.m5059a(inputStream);
                        C4474a.m5059a(fileInputStream2);
                        C4474a.m5058a(fileOutputStream2);
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        inputStream2 = inputStream;
                        e.printStackTrace();
                        C4474a.m5059a(inputStream2);
                        C4474a.m5059a(fileInputStream);
                        C4474a.m5058a(fileOutputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        C4474a.m5059a(inputStream);
                        C4474a.m5059a(fileInputStream);
                        C4474a.m5058a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = fileInputStream2;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                inputStream2 = inputStream;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            inputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            inputStream = null;
        }
    }
}
