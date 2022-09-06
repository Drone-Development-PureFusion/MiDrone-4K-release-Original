package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* renamed from: com.xiaomi.push.service.ag */
/* loaded from: classes2.dex */
public class C4606ag {

    /* renamed from: com.xiaomi.push.service.ag$a */
    /* loaded from: classes2.dex */
    public static class C4607a {

        /* renamed from: a */
        byte[] f18943a;

        /* renamed from: b */
        int f18944b;

        public C4607a(byte[] bArr, int i) {
            this.f18943a = bArr;
            this.f18944b = i;
        }
    }

    /* renamed from: com.xiaomi.push.service.ag$b */
    /* loaded from: classes2.dex */
    public static class C4608b {

        /* renamed from: a */
        public Bitmap f18945a;

        /* renamed from: b */
        public long f18946b;

        public C4608b(Bitmap bitmap, long j) {
            this.f18945a = bitmap;
            this.f18946b = j;
        }
    }

    /* renamed from: a */
    private static int m4402a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            AbstractC4478b.m5041a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth > round && options.outHeight > round) {
            return Math.min(options.outWidth / round, options.outHeight / round);
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static C4607a m4400a(String str) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        C4607a c4607a;
        int i = 102400;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setConnectTimeout(8000);
                httpURLConnection3.setReadTimeout(20000);
                httpURLConnection3.connect();
                int contentLength = httpURLConnection3.getContentLength();
                if (contentLength > 102400) {
                    AbstractC4478b.m5041a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    C4474a.m5059a((InputStream) null);
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    c4607a = null;
                } else {
                    int responseCode = httpURLConnection3.getResponseCode();
                    if (responseCode != 200) {
                        AbstractC4478b.m5041a("Invalid Http Response Code " + responseCode + " received");
                        C4474a.m5059a((InputStream) null);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        c4607a = null;
                    } else {
                        inputStream = httpURLConnection3.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (i > 0) {
                                int read = inputStream.read(bArr, 0, 1024);
                                if (read == -1) {
                                    break;
                                }
                                i -= read;
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (i <= 0) {
                                AbstractC4478b.m5041a("length 102400 exhausted.");
                                C4607a c4607a2 = new C4607a(null, 102400);
                                C4474a.m5059a(inputStream);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                c4607a = c4607a2;
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                C4607a c4607a3 = new C4607a(byteArray, byteArray.length);
                                C4474a.m5059a(inputStream);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                c4607a = c4607a3;
                            }
                        } catch (IOException e) {
                            httpURLConnection = httpURLConnection3;
                            e = e;
                            try {
                                AbstractC4478b.m5039a(e);
                                C4474a.m5059a(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                httpURLConnection2 = httpURLConnection;
                                C4474a.m5059a(inputStream);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            httpURLConnection2 = httpURLConnection3;
                            th = th2;
                            C4474a.m5059a(inputStream);
                            if (httpURLConnection2 != null) {
                            }
                            throw th;
                        }
                    }
                }
                return c4607a;
            } catch (IOException e2) {
                inputStream = null;
                C4607a c4607a4 = c4607a;
                e = e2;
                httpURLConnection = c4607a4;
            } catch (Throwable th3) {
                inputStream = null;
                httpURLConnection2 = c4607a;
                th = th3;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* renamed from: a */
    public static C4608b m4401a(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        C4607a m4400a;
        C4608b c4608b = new C4608b(null, 0L);
        try {
            m4400a = m4400a(str);
        } catch (Exception e) {
            e = e;
            byteArrayInputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayInputStream = null;
            C4474a.m5059a(byteArrayInputStream);
            throw th;
        }
        if (m4400a == null) {
            C4474a.m5059a((InputStream) null);
            return c4608b;
        }
        c4608b.f18946b = m4400a.f18944b;
        byte[] bArr = m4400a.f18943a;
        if (bArr != null) {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    int m4402a = m4402a(context, byteArrayInputStream);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = m4402a;
                    c4608b.f18945a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } catch (Exception e2) {
                    e = e2;
                    AbstractC4478b.m5039a(e);
                    C4474a.m5059a(byteArrayInputStream);
                    return c4608b;
                }
            } catch (Throwable th2) {
                th = th2;
                C4474a.m5059a(byteArrayInputStream);
                throw th;
            }
        } else {
            byteArrayInputStream = null;
        }
        C4474a.m5059a(byteArrayInputStream);
        return c4608b;
    }

    /* renamed from: b */
    public static Bitmap m4399b(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        Bitmap bitmap = null;
        Uri parse = Uri.parse(str);
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                int m4402a = m4402a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
                try {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = m4402a;
                        bitmap = BitmapFactory.decodeStream(inputStream2, null, options);
                        C4474a.m5059a(inputStream2);
                    } catch (IOException e) {
                        e = e;
                        AbstractC4478b.m5039a(e);
                        C4474a.m5059a(inputStream2);
                        C4474a.m5059a(inputStream);
                        return bitmap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C4474a.m5059a(inputStream2);
                    C4474a.m5059a(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
            } catch (Throwable th3) {
                inputStream2 = null;
                th = th3;
                C4474a.m5059a(inputStream2);
                C4474a.m5059a(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            inputStream2 = null;
        } catch (Throwable th4) {
            inputStream = null;
            inputStream2 = null;
            th = th4;
        }
        C4474a.m5059a(inputStream);
        return bitmap;
    }
}
