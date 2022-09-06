package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.fimi.kernel.C2172a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* renamed from: com.tencent.connect.share.a */
/* loaded from: classes.dex */
public class C4220a {
    /* renamed from: a */
    public static final int m5829a(BitmapFactory.Options options, int i, int i2) {
        int m5826b = m5826b(options, i, i2);
        if (m5826b <= 8) {
            int i3 = 1;
            while (i3 < m5826b) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((m5826b + 7) / 8) * 8;
    }

    /* renamed from: a */
    private static Bitmap m5831a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i / width;
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: a */
    public static final Bitmap m5828a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = m5829a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile == null) {
            return null;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 <= i5) {
            i4 = i5;
        }
        return i4 > i ? m5831a(decodeFile, i) : decodeFile;
    }

    /* renamed from: a */
    protected static final String m5830a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String stringBuffer = new StringBuffer(str).append(str2).toString();
        File file2 = new File(stringBuffer);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return stringBuffer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static final void m5833a(Context context, final String str, final AsynLoadImgBack asynLoadImgBack) {
        C4331f.m5445b("AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            asynLoadImgBack.saved(1, null);
        } else if (!Util.hasSDCard()) {
            asynLoadImgBack.saved(2, null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 101:
                            asynLoadImgBack.saved(0, (String) message.obj);
                            return;
                        case 102:
                            asynLoadImgBack.saved(message.arg1, null);
                            return;
                        default:
                            super.handleMessage(message);
                            return;
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                @Override // java.lang.Runnable
                public void run() {
                    String m5830a;
                    Bitmap m5828a = C4220a.m5828a(str, 140);
                    if (m5828a != null) {
                        String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                        String str3 = "share2qq_temp" + Util.encrypt(str) + ".jpg";
                        if (!C4220a.m5825b(str, 140, 140)) {
                            C4331f.m5445b("AsynScaleCompressImage", "not out of bound,not compress!");
                            m5830a = str;
                        } else {
                            C4331f.m5445b("AsynScaleCompressImage", "out of bound,compress!");
                            m5830a = C4220a.m5830a(m5828a, str2, str3);
                        }
                        C4331f.m5445b("AsynScaleCompressImage", "-->destFilePath: " + m5830a);
                        if (m5830a != null) {
                            Message obtainMessage = handler.obtainMessage(101);
                            obtainMessage.obj = m5830a;
                            handler.sendMessage(obtainMessage);
                            return;
                        }
                    }
                    Message obtainMessage2 = handler.obtainMessage(102);
                    obtainMessage2.arg1 = 3;
                    handler.sendMessage(obtainMessage2);
                }
            }).start();
        }
    }

    /* renamed from: a */
    public static final void m5832a(Context context, final ArrayList<String> arrayList, final AsynLoadImgBack asynLoadImgBack) {
        C4331f.m5445b("AsynScaleCompressImage", "batchScaleCompressImage");
        if (arrayList == null) {
            asynLoadImgBack.saved(1, null);
            return;
        }
        final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 101:
                        asynLoadImgBack.batchSaved(0, message.getData().getStringArrayList(C2172a.f7286b));
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
        new Thread(new Runnable() { // from class: com.tencent.connect.share.a.4
            @Override // java.lang.Runnable
            public void run() {
                Bitmap m5828a;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        Message obtainMessage = handler.obtainMessage(101);
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList(C2172a.f7286b, arrayList);
                        obtainMessage.setData(bundle);
                        handler.sendMessage(obtainMessage);
                        return;
                    }
                    String str = (String) arrayList.get(i2);
                    if (!Util.isValidUrl(str) && Util.fileExists(str) && (m5828a = C4220a.m5828a(str, 10000)) != null) {
                        String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                        String str3 = "share2qzone_temp" + Util.encrypt(str) + ".jpg";
                        if (!C4220a.m5825b(str, 640, 10000)) {
                            C4331f.m5445b("AsynScaleCompressImage", "not out of bound,not compress!");
                        } else {
                            C4331f.m5445b("AsynScaleCompressImage", "out of bound, compress!");
                            str = C4220a.m5830a(m5828a, str2, str3);
                        }
                        if (str != null) {
                            arrayList.set(i2, str);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }).start();
    }

    /* renamed from: b */
    private static int m5826b(BitmapFactory.Options options, int i, int i2) {
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / i), Math.floor(d2 / i));
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i != -1 ? min : ceil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final boolean m5825b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        C4331f.m5445b("AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i5 > i2 || i3 > i;
    }
}
