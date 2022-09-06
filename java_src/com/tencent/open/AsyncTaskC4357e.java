package com.tencent.open;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.p228a.C4331f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
/* renamed from: com.tencent.open.e */
/* loaded from: classes2.dex */
public class AsyncTaskC4357e extends AsyncTask<Bitmap, Void, HashMap<String, Object>> {

    /* renamed from: a */
    private static final SimpleDateFormat f18175a = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.CHINA);

    /* renamed from: b */
    private AbstractC4358a f18176b;

    /* renamed from: com.tencent.open.e$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4358a {
        /* renamed from: a */
        void mo5374a(String str);

        /* renamed from: b */
        void mo5373b(String str);
    }

    public AsyncTaskC4357e(AbstractC4358a abstractC4358a) {
        this.f18176b = abstractC4358a;
    }

    /* renamed from: a */
    private int m5380a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            int round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            return round < round2 ? round : round2;
        }
        return 1;
    }

    /* renamed from: a */
    private Bitmap m5381a(Bitmap bitmap) {
        int i = 1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.toByteArray().length / 1024 > 1024) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        options.inJustDecodeBounds = false;
        int m5380a = m5380a(options, 320, 320);
        if (m5380a > 0) {
            i = m5380a;
        }
        C4331f.m5442c("comp", "comp be=" + i);
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options);
    }

    /* renamed from: a */
    private String m5382a(long j) {
        return f18175a.format(new Date(j));
    }

    /* renamed from: a */
    public static void m5379a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return;
                }
                file.delete();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m5383a() {
        return Environment.getExternalStorageState().equals("mounted") || new File("/mnt/sdcard-ext").isDirectory();
    }

    /* renamed from: b */
    private String m5376b() {
        return Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory().getAbsolutePath() : new File("/mnt/sdcard-ext").isDirectory() ? "/mnt/sdcard-ext" : ".";
    }

    /* renamed from: b */
    private String m5375b(Bitmap bitmap) {
        String str;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            String str2 = m5376b() + File.separator + ".AppCenterWebBuffer";
            str = str2 + File.separator + (m5382a(System.currentTimeMillis()) + ".png");
            File file = new File(str2);
            if (file.exists() || !file.mkdirs()) {
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(file2);
        } catch (Exception e) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            fileOutputStream2 = fileOutputStream;
            str = "";
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public HashMap<String, Object> doInBackground(Bitmap... bitmapArr) {
        String m5375b;
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            Bitmap bitmap = bitmapArr[0];
            if (bitmap != null) {
                if (bitmap.getWidth() > 320 || bitmap.getHeight() > 320) {
                    Bitmap m5381a = m5381a(bitmap);
                    m5375b = m5375b(m5381a);
                    m5381a.recycle();
                } else {
                    m5375b = m5375b(bitmap);
                }
                bitmap.recycle();
                hashMap.put("ResultType", 1);
                hashMap.put("ResultValue", m5375b);
            }
        } catch (Exception e) {
            hashMap.put("ResultType", 0);
            hashMap.put("ResultValue", e.getMessage());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(HashMap<String, Object> hashMap) {
        if (((Integer) hashMap.get("ResultType")).intValue() == 1) {
            this.f18176b.mo5374a((String) hashMap.get("ResultValue"));
        } else {
            this.f18176b.mo5373b((String) hashMap.get("ResultValue"));
        }
        super.onPostExecute(hashMap);
    }
}
