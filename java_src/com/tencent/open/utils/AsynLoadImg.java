package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.p228a.C4331f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class AsynLoadImg {

    /* renamed from: c */
    private static String f18183c;

    /* renamed from: a */
    private String f18184a;

    /* renamed from: b */
    private AsynLoadImgBack f18185b;

    /* renamed from: d */
    private long f18186d;

    /* renamed from: e */
    private Handler f18187e;

    /* renamed from: f */
    private Runnable f18188f = new Runnable() { // from class: com.tencent.open.utils.AsynLoadImg.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            C4331f.m5448a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + Util.encrypt(AsynLoadImg.this.f18184a) + ".jpg";
            String str2 = AsynLoadImg.f18183c + str;
            File file = new File(str2);
            Message obtainMessage = AsynLoadImg.this.f18187e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                C4331f.m5448a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - AsynLoadImg.this.f18186d));
            } else {
                Bitmap bitmap = AsynLoadImg.getbitmap(AsynLoadImg.this.f18184a);
                if (bitmap != null) {
                    z = AsynLoadImg.this.saveFile(bitmap, str);
                } else {
                    C4331f.m5448a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                C4331f.m5448a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - AsynLoadImg.this.f18186d));
            }
            AsynLoadImg.this.f18187e.sendMessage(obtainMessage);
        }
    };

    public AsynLoadImg(Activity activity) {
        this.f18187e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.AsynLoadImg.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                C4331f.m5448a("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    AsynLoadImg.this.f18185b.saved(message.arg1, (String) message.obj);
                } else {
                    AsynLoadImg.this.f18185b.saved(message.arg1, null);
                }
            }
        };
    }

    public static Bitmap getbitmap(String str) {
        C4331f.m5448a("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            C4331f.m5448a("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            C4331f.m5448a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }

    public void save(String str, AsynLoadImgBack asynLoadImgBack) {
        C4331f.m5448a("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            asynLoadImgBack.saved(1, null);
        } else if (!Util.hasSDCard()) {
            asynLoadImgBack.saved(2, null);
        } else {
            f18183c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.f18186d = System.currentTimeMillis();
            this.f18184a = str;
            this.f18185b = asynLoadImgBack;
            new Thread(this.f18188f).start();
        }
    }

    public boolean saveFile(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream;
        String str2 = f18183c;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                C4331f.m5448a("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            C4331f.m5448a("AsynLoadImg", "saveFile bmp fail---");
            if (bufferedOutputStream2 == null) {
                return false;
            }
            try {
                bufferedOutputStream2.close();
                return false;
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
