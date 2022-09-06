package com.p080b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Process;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.b.cv */
/* loaded from: classes.dex */
public final class C1512cv {

    /* renamed from: a */
    private Context f5389a;

    /* renamed from: b */
    private boolean f5390b = true;

    /* renamed from: c */
    private int f5391c = 1270;

    /* renamed from: d */
    private int f5392d = 310;

    /* renamed from: e */
    private int f5393e = 4;

    /* renamed from: f */
    private int f5394f = 200;

    /* renamed from: g */
    private int f5395g = 1;

    /* renamed from: h */
    private int f5396h = 0;

    /* renamed from: i */
    private int f5397i = 0;

    /* renamed from: j */
    private long f5398j = 0;

    /* renamed from: k */
    private C1511cu f5399k = null;

    private C1512cv(Context context) {
        this.f5389a = null;
        this.f5389a = context;
    }

    /* renamed from: a */
    private static int m15749a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 += (bArr[i3 + i] & 255) << (i3 << 3);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C1512cv m15752a(Context context) {
        FileInputStream fileInputStream;
        C1512cv c1512cv = new C1512cv(context);
        c1512cv.f5396h = 0;
        c1512cv.f5397i = 0;
        c1512cv.f5398j = ((System.currentTimeMillis() + 28800000) / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(m15746b(context) + File.separator + "data_carrier_status"));
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[32];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray != null && byteArray.length >= 22) {
                c1512cv.f5390b = byteArray[0] != 0;
                c1512cv.f5391c = (byteArray[1] * 10) << 10;
                c1512cv.f5392d = (byteArray[2] * 10) << 10;
                c1512cv.f5393e = byteArray[3];
                c1512cv.f5394f = byteArray[4] * 10;
                c1512cv.f5395g = byteArray[5];
                long m15745b = m15745b(byteArray, 14);
                if (c1512cv.f5398j - m15745b < Util.MILLSECONDS_OF_DAY) {
                    c1512cv.f5398j = m15745b;
                    c1512cv.f5396h = m15749a(byteArray, 6);
                    c1512cv.f5397i = m15749a(byteArray, 10);
                }
            }
            byteArrayOutputStream.close();
        } catch (Exception e3) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return c1512cv;
        } catch (Throwable th2) {
            fileInputStream2 = fileInputStream;
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        return c1512cv;
    }

    /* renamed from: a */
    private static byte[] m15753a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> (i << 3)) & 255);
        }
        return bArr;
    }

    /* renamed from: b */
    private static long m15745b(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            i2 += (bArr[i3 + 14] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << (i3 << 3);
        }
        return i2;
    }

    /* renamed from: b */
    private static String m15746b(Context context) {
        boolean z = false;
        File file = null;
        if (Process.myUid() != 1000) {
            file = C1496cf.m15859a(context);
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
        }
        return ((z || !C1496cf.m15847c()) && file != null) ? file.getPath() : context.getFilesDir().getPath();
    }

    /* renamed from: c */
    private static byte[] m15743c(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (i2 << 3));
        }
        return bArr;
    }

    /* renamed from: g */
    private void m15739g() {
        long currentTimeMillis = System.currentTimeMillis() + 28800000;
        if (currentTimeMillis - this.f5398j > Util.MILLSECONDS_OF_DAY) {
            this.f5398j = (currentTimeMillis / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY;
            this.f5396h = 0;
            this.f5397i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m15754a(int i) {
        m15739g();
        if (i < 0) {
            i = 0;
        }
        this.f5396h = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m15751a(C1511cu c1511cu) {
        this.f5399k = c1511cu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m15755a() {
        m15739g();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f5389a.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? this.f5390b : activeNetworkInfo.getType() == 1 ? this.f5390b && this.f5396h < this.f5391c : this.f5390b && this.f5397i < this.f5392d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m15750a(String str) {
        boolean z;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        int i = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("e")) {
                this.f5390b = jSONObject.getInt("e") != 0;
            }
            if (jSONObject.has(C0477f.f1054a)) {
                int i2 = jSONObject.getInt(C0477f.f1054a);
                this.f5391c = ((i2 & 127) * 10) << 10;
                this.f5392d = (((i2 & 3968) >> 7) * 10) << 10;
                this.f5393e = (520192 & i2) >> 12;
                this.f5394f = ((66584576 & i2) >> 19) * 10;
                this.f5395g = (i2 & 2080374784) >> 26;
                if (this.f5395g == 31) {
                    this.f5395g = 1500;
                }
                if (this.f5399k != null) {
                    this.f5399k.m15756a();
                }
            }
            z = jSONObject.has("u") ? jSONObject.getInt("u") != 0 : false;
        } catch (Exception e) {
            z = false;
        }
        try {
            try {
                m15739g();
                fileOutputStream = new FileOutputStream(new File(m15746b(this.f5389a) + File.separator + "data_carrier_status"));
            } catch (Exception e2) {
            }
            try {
                byte[] m15743c = m15743c(this.f5396h);
                byte[] m15743c2 = m15743c(this.f5397i);
                byte[] m15753a = m15753a(this.f5398j);
                byte[] bArr = new byte[22];
                if (!this.f5390b) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                bArr[1] = (byte) (this.f5391c / C2227d.f7442b);
                bArr[2] = (byte) (this.f5392d / C2227d.f7442b);
                bArr[3] = (byte) this.f5393e;
                bArr[4] = (byte) (this.f5394f / 10);
                bArr[5] = (byte) this.f5395g;
                bArr[6] = m15743c[0];
                bArr[7] = m15743c[1];
                bArr[8] = m15743c[2];
                bArr[9] = m15743c[3];
                bArr[10] = m15743c2[0];
                bArr[11] = m15743c2[1];
                bArr[12] = m15743c2[2];
                bArr[13] = m15743c2[3];
                bArr[14] = m15753a[0];
                bArr[15] = m15753a[1];
                bArr[16] = m15753a[2];
                bArr[17] = m15753a[3];
                bArr[18] = m15753a[4];
                bArr[19] = m15753a[5];
                bArr[20] = m15753a[6];
                bArr[21] = m15753a[7];
                fileOutputStream.write(bArr);
            } catch (Exception e3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z;
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final int m15748b() {
        return this.f5393e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m15747b(int i) {
        m15739g();
        if (i < 0) {
            i = 0;
        }
        this.f5397i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final int m15744c() {
        return this.f5394f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final int m15742d() {
        return this.f5395g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final int m15741e() {
        m15739g();
        return this.f5396h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final int m15740f() {
        m15739g();
        return this.f5397i;
    }
}
