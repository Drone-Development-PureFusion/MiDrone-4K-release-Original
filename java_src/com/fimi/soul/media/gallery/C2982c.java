package com.fimi.soul.media.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.util.LruCache;
import com.fimi.kernel.utils.C2274s;
import com.fimi.soul.utils.C3710y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.fimi.soul.media.gallery.c */
/* loaded from: classes.dex */
public class C2982c {

    /* renamed from: b */
    private static C2982c f11284b = null;

    /* renamed from: d */
    private Context f11287d;

    /* renamed from: c */
    private ExecutorService f11286c = Executors.newFixedThreadPool(4);

    /* renamed from: e */
    private ArrayList<Bitmap> f11288e = new ArrayList<>();

    /* renamed from: a */
    public LruCache<String, Bitmap> f11285a = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.fimi.soul.media.gallery.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.p001v4.util.LruCache
        @SuppressLint({"NewApi"})
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    };

    /* renamed from: com.fimi.soul.media.gallery.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC2986a {
        /* renamed from: a */
        void m9919a(Bitmap bitmap, String str);
    }

    private C2982c(Context context) {
        this.f11287d = context;
    }

    /* renamed from: a */
    private int m9929a(BitmapFactory.Options options, int i, int i2) {
        if (i == 0 || i == 0) {
            return 1;
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i && i4 <= i) {
            return 1;
        }
        int round = Math.round(i3 / i);
        int round2 = Math.round(i4 / i);
        return round >= round2 ? round2 : round;
    }

    /* renamed from: a */
    private Bitmap m9925a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = m9929a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* renamed from: a */
    public static C2982c m9930a(Context context) {
        if (f11284b == null) {
            f11284b = new C2982c(context);
        }
        return f11284b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9924a(String str, Bitmap bitmap) {
        if (m9921b(str) != null || bitmap == null) {
            return;
        }
        this.f11288e.add(bitmap);
        this.f11285a.put(str, bitmap);
    }

    /* renamed from: b */
    private Bitmap m9921b(String str) {
        return this.f11285a.get(str);
    }

    /* renamed from: a */
    public Bitmap m9923a(final String str, Point point, final AbstractC2986a abstractC2986a) {
        Bitmap m9921b = m9921b(str);
        final Handler handler = new Handler() { // from class: com.fimi.soul.media.gallery.c.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                abstractC2986a.m9919a((Bitmap) message.obj, str);
            }
        };
        if (m9921b == null) {
            this.f11286c.execute(new Runnable() { // from class: com.fimi.soul.media.gallery.c.3
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap = null;
                    if (C3710y.m7386c(str, C2982c.this.f11287d)) {
                        bitmap = ThumbnailUtils.createVideoThumbnail(str, 1);
                    } else {
                        try {
                            bitmap = C2274s.m12827a(C2982c.this.f11287d, str, 250);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.obj = bitmap;
                    handler.sendMessage(obtainMessage);
                    C2982c.this.m9924a(str, bitmap);
                }
            });
        }
        return m9921b;
    }

    /* renamed from: a */
    public Bitmap m9922a(String str, AbstractC2986a abstractC2986a) {
        return m9923a(str, (Point) null, abstractC2986a);
    }

    /* renamed from: a */
    public void m9931a() {
        if (this.f11285a == null || this.f11285a.size() <= 0) {
            return;
        }
        this.f11285a.evictAll();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f11288e.size()) {
                this.f11288e.clear();
                return;
            }
            Bitmap bitmap = this.f11288e.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public synchronized void m9926a(String str) {
        Bitmap remove;
        if (str != null) {
            if (this.f11285a != null && (remove = this.f11285a.remove(str)) != null) {
                remove.recycle();
            }
        }
    }
}
