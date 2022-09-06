package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.android.common.logging.Log;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.amap.api.mapcore.util.dw */
/* loaded from: classes.dex */
public class C0929dw {

    /* renamed from: a */
    private static final Bitmap.CompressFormat f2851a = Bitmap.CompressFormat.PNG;

    /* renamed from: b */
    private C1046gt f2852b;

    /* renamed from: c */
    private C0939eb<String, Bitmap> f2853c;

    /* renamed from: d */
    private C0931a f2854d;

    /* renamed from: e */
    private final Object f2855e = new Object();

    /* renamed from: f */
    private boolean f2856f = true;

    /* renamed from: g */
    private HashMap<String, WeakReference<Bitmap>> f2857g;

    /* renamed from: com.amap.api.mapcore.util.dw$a */
    /* loaded from: classes.dex */
    public static class C0931a {

        /* renamed from: c */
        public File f2861c;

        /* renamed from: a */
        public int f2859a = 5242880;

        /* renamed from: b */
        public int f2860b = Log.FILE_LIMETE;

        /* renamed from: d */
        public Bitmap.CompressFormat f2862d = C0929dw.f2851a;

        /* renamed from: e */
        public int f2863e = 100;

        /* renamed from: f */
        public boolean f2864f = true;

        /* renamed from: g */
        public boolean f2865g = true;

        /* renamed from: h */
        public boolean f2866h = false;

        public C0931a(Context context, String str) {
            this.f2861c = C0929dw.m18455a(context, str);
        }

        /* renamed from: a */
        public void m18436a(int i) {
            this.f2859a = i;
        }

        /* renamed from: a */
        public void m18435a(String str) {
            this.f2861c = new File(str);
        }

        /* renamed from: a */
        public void m18434a(boolean z) {
            this.f2864f = z;
        }

        /* renamed from: b */
        public void m18433b(int i) {
            if (i <= 0) {
                this.f2865g = false;
            }
            this.f2860b = i;
        }

        /* renamed from: b */
        public void m18432b(boolean z) {
            this.f2865g = z;
        }
    }

    private C0929dw(C0931a c0931a) {
        m18446b(c0931a);
    }

    /* renamed from: a */
    public static int m18454a(Bitmap bitmap) {
        return C0945eh.m18311d() ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* renamed from: a */
    public static long m18451a(File file) {
        if (C0945eh.m18321b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: a */
    public static C0929dw m18453a(C0931a c0931a) {
        return new C0929dw(c0931a);
    }

    /* renamed from: a */
    public static File m18456a(Context context) {
        File file;
        try {
            if (C0945eh.m18365a()) {
                file = context.getExternalCacheDir();
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
            }
            return file;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static File m18455a(Context context, String str) {
        File m18456a = m18456a(context);
        return new File(((("mounted".equals(Environment.getExternalStorageState()) || !m18440e()) && m18456a != null) ? m18456a.getPath() : context.getCacheDir().getPath()) + File.separator + str);
    }

    /* renamed from: a */
    private static String m18448a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m18446b(C0931a c0931a) {
        this.f2854d = c0931a;
        if (this.f2854d.f2864f) {
            if (C0945eh.m18313c()) {
                this.f2857g = new HashMap<>();
            }
            this.f2853c = new C0939eb<String, Bitmap>(this.f2854d.f2859a) { // from class: com.amap.api.mapcore.util.dw.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.amap.api.mapcore.util.C0939eb
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public int mo18388a(String str, Bitmap bitmap) {
                    int m18454a = C0929dw.m18454a(bitmap);
                    if (m18454a == 0) {
                        return 1;
                    }
                    return m18454a;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.amap.api.mapcore.util.C0939eb
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public void mo18387a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (!C0945eh.m18313c() || C0929dw.this.f2857g == null || bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    C0929dw.this.f2857g.put(str, new WeakReference(bitmap));
                }
            };
        }
        if (c0931a.f2866h) {
            m18457a();
        }
    }

    /* renamed from: b */
    private void m18445b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                m18445b(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* renamed from: c */
    public static String m18442c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("utf-8"));
            return m18448a(messageDigest.digest());
        } catch (Throwable th) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: e */
    public static boolean m18440e() {
        if (C0945eh.m18321b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    /* renamed from: a */
    public Bitmap m18450a(String str) {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference;
        if (!C0945eh.m18313c() || this.f2857g == null || (weakReference = this.f2857g.get(str)) == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = null;
            }
            this.f2857g.remove(str);
        }
        if (bitmap == null && this.f2853c != null) {
            bitmap = this.f2853c.m18389a((C0939eb<String, Bitmap>) str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    /* renamed from: a */
    public void m18457a() {
        synchronized (this.f2855e) {
            if (this.f2852b == null || this.f2852b.m17828a()) {
                File file = this.f2854d.f2861c;
                if (this.f2854d.f2865g && file != null) {
                    try {
                        if (file.exists()) {
                            m18445b(file);
                        }
                        file.mkdir();
                    } catch (Throwable th) {
                    }
                    if (m18451a(file) > this.f2854d.f2860b) {
                        this.f2852b = C1046gt.m17821a(file, 1, 1, this.f2854d.f2860b);
                    }
                }
            }
            this.f2856f = false;
            this.f2855e.notifyAll();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: a */
    public void m18449a(java.lang.String r7, android.graphics.Bitmap r8) {
        /*
            r6 = this;
            if (r7 == 0) goto La
            if (r8 == 0) goto La
            boolean r0 = r8.isRecycled()
            if (r0 == 0) goto Lb
        La:
            return
        Lb:
            com.amap.api.mapcore.util.eb<java.lang.String, android.graphics.Bitmap> r0 = r6.f2853c
            if (r0 == 0) goto L14
            com.amap.api.mapcore.util.eb<java.lang.String, android.graphics.Bitmap> r0 = r6.f2853c
            r0.m18385b(r7, r8)
        L14:
            java.lang.Object r2 = r6.f2855e
            monitor-enter(r2)
            com.amap.api.mapcore.util.gt r0 = r6.f2852b     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
            java.lang.String r1 = m18442c(r7)     // Catch: java.lang.Throwable -> L4d
            r0 = 0
            com.amap.api.mapcore.util.gt r3 = r6.f2852b     // Catch: java.lang.Throwable -> L59
            com.amap.api.mapcore.util.gt$b r3 = r3.m17819a(r1)     // Catch: java.lang.Throwable -> L59
            if (r3 != 0) goto L50
            com.amap.api.mapcore.util.gt r3 = r6.f2852b     // Catch: java.lang.Throwable -> L59
            com.amap.api.mapcore.util.gt$a r1 = r3.m17815b(r1)     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto L46
            r3 = 0
            java.io.OutputStream r0 = r1.m17797a(r3)     // Catch: java.lang.Throwable -> L59
            com.amap.api.mapcore.util.dw$a r3 = r6.f2854d     // Catch: java.lang.Throwable -> L59
            android.graphics.Bitmap$CompressFormat r3 = r3.f2862d     // Catch: java.lang.Throwable -> L59
            com.amap.api.mapcore.util.dw$a r4 = r6.f2854d     // Catch: java.lang.Throwable -> L59
            int r4 = r4.f2863e     // Catch: java.lang.Throwable -> L59
            r8.compress(r3, r4, r0)     // Catch: java.lang.Throwable -> L59
            r1.m17798a()     // Catch: java.lang.Throwable -> L59
            r0.close()     // Catch: java.lang.Throwable -> L59
        L46:
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.lang.Throwable -> L6c
        L4b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4d
            goto La
        L4d:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4d
            throw r0
        L50:
            r1 = 0
            java.io.InputStream r1 = r3.m17792a(r1)     // Catch: java.lang.Throwable -> L59
            r1.close()     // Catch: java.lang.Throwable -> L59
            goto L46
        L59:
            r1 = move-exception
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.lang.Throwable -> L60
            goto L4b
        L60:
            r0 = move-exception
            goto L4b
        L62:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L66:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r0     // Catch: java.lang.Throwable -> L4d
        L6c:
            r0 = move-exception
            goto L4b
        L6e:
            r1 = move-exception
            goto L6b
        L70:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C0929dw.m18449a(java.lang.String, android.graphics.Bitmap):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    public android.graphics.Bitmap m18444b(java.lang.String r8) {
        /*
            r7 = this;
            r3 = 0
            java.lang.String r1 = m18442c(r8)
            java.lang.Object r4 = r7.f2855e
            monitor-enter(r4)
        L8:
            boolean r2 = r7.f2856f     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto L14
            java.lang.Object r2 = r7.f2855e     // Catch: java.lang.Throwable -> L12
            r2.wait()     // Catch: java.lang.Throwable -> L12
            goto L8
        L12:
            r2 = move-exception
            goto L8
        L14:
            com.amap.api.mapcore.util.gt r2 = r7.f2852b     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto L3e
            com.amap.api.mapcore.util.gt r2 = r7.f2852b     // Catch: java.lang.Throwable -> L40
            com.amap.api.mapcore.util.gt$b r1 = r2.m17819a(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L5d
            r2 = 0
            java.io.InputStream r2 = r1.m17792a(r2)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L39
            r0 = r2
            java.io.FileInputStream r0 = (java.io.FileInputStream) r0     // Catch: java.lang.Throwable -> L5b
            r1 = r0
            java.io.FileDescriptor r1 = r1.getFD()     // Catch: java.lang.Throwable -> L5b
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 2147483647(0x7fffffff, float:NaN)
            android.graphics.Bitmap r3 = com.amap.api.mapcore.util.C0933dy.m18423a(r1, r5, r6, r7)     // Catch: java.lang.Throwable -> L5b
        L39:
            if (r2 == 0) goto L3e
            r2.close()     // Catch: java.lang.Throwable -> L55
        L3e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L52
            return r3
        L40:
            r1 = move-exception
            r2 = r3
        L42:
            if (r2 == 0) goto L3e
            r2.close()     // Catch: java.lang.Throwable -> L48
            goto L3e
        L48:
            r1 = move-exception
            goto L3e
        L4a:
            r1 = move-exception
            r2 = r3
        L4c:
            if (r2 == 0) goto L51
            r2.close()     // Catch: java.lang.Throwable -> L57
        L51:
            throw r1     // Catch: java.lang.Throwable -> L52
        L52:
            r1 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L52
            throw r1
        L55:
            r1 = move-exception
            goto L3e
        L57:
            r2 = move-exception
            goto L51
        L59:
            r1 = move-exception
            goto L4c
        L5b:
            r1 = move-exception
            goto L42
        L5d:
            r2 = r3
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C0929dw.m18444b(java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: b */
    public void m18447b() {
        if (C0945eh.m18313c() && this.f2857g != null) {
            this.f2857g.clear();
        }
        if (this.f2853c != null) {
            this.f2853c.m18391a();
        }
        synchronized (this.f2855e) {
            this.f2856f = true;
            if (this.f2852b != null && !this.f2852b.m17828a()) {
                try {
                    this.f2852b.m17814c();
                } catch (Throwable th) {
                }
                this.f2852b = null;
                m18457a();
            }
        }
    }

    /* renamed from: c */
    public void m18443c() {
        synchronized (this.f2855e) {
            if (this.f2852b != null) {
                try {
                    this.f2852b.m17817b();
                } catch (Throwable th) {
                }
            }
        }
    }

    /* renamed from: d */
    public void m18441d() {
        if (C0945eh.m18313c() && this.f2857g != null) {
            this.f2857g.clear();
        }
        if (this.f2853c != null) {
            this.f2853c.m18391a();
        }
        synchronized (this.f2855e) {
            if (this.f2852b != null) {
                try {
                    if (!this.f2852b.m17828a()) {
                        this.f2852b.m17814c();
                        this.f2852b = null;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }
}
