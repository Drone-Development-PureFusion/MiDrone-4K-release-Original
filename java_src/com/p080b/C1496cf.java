package com.p080b;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;
/* renamed from: com.b.cf */
/* loaded from: classes.dex */
public class C1496cf {

    /* renamed from: a */
    private Context f5319a;

    /* renamed from: b */
    private int f5320b = 0;

    /* renamed from: c */
    private int f5321c = 0;

    /* renamed from: d */
    private int f5322d = 0;

    /* renamed from: e */
    private int f5323e = 0;

    /* renamed from: f */
    private int f5324f = 0;

    /* renamed from: g */
    private int f5325g = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1496cf(Context context) {
        this.f5319a = context;
        m15862a(768);
        m15851b(768);
    }

    /* renamed from: a */
    private static int m15861a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C1485bx m15858a(Location location, C1499ci c1499ci, int i, byte b, long j, boolean z) {
        int i2;
        C1485bx c1485bx = new C1485bx();
        if (i <= 0 || i > 3 || c1499ci == null) {
            return null;
        }
        boolean z2 = i == 1 || i == 3;
        boolean z3 = i == 2 || i == 3;
        byte[] bytes = c1499ci.m15770o().getBytes();
        System.arraycopy(bytes, 0, c1485bx.f5230c, 0, m15861a(bytes.length, c1485bx.f5230c.length));
        byte[] bytes2 = c1499ci.m15787f().getBytes();
        System.arraycopy(bytes2, 0, c1485bx.f5234g, 0, m15861a(bytes2.length, c1485bx.f5234g.length));
        byte[] bytes3 = c1499ci.m15784g().getBytes();
        System.arraycopy(bytes3, 0, c1485bx.f5228a, 0, m15861a(bytes3.length, c1485bx.f5228a.length));
        byte[] bytes4 = c1499ci.m15781h().getBytes();
        System.arraycopy(bytes4, 0, c1485bx.f5229b, 0, m15861a(bytes4.length, c1485bx.f5229b.length));
        c1485bx.f5231d = (short) c1499ci.m15769p();
        c1485bx.f5232e = (short) c1499ci.m15768q();
        c1485bx.f5233f = (byte) c1499ci.m15767r();
        byte[] bytes5 = c1499ci.m15766s().getBytes();
        System.arraycopy(bytes5, 0, c1485bx.f5235h, 0, m15861a(bytes5.length, c1485bx.f5235h.length));
        long j2 = j / 1000;
        if (location != null && c1499ci.m15790e()) {
            C1479bu c1479bu = new C1479bu();
            c1479bu.f5175b = (int) j2;
            C1480bv c1480bv = new C1480bv();
            c1480bv.f5181a = (int) (location.getLongitude() * 1000000.0d);
            c1480bv.f5182b = (int) (location.getLatitude() * 1000000.0d);
            c1480bv.f5183c = (int) location.getAltitude();
            c1480bv.f5184d = (int) location.getAccuracy();
            c1480bv.f5185e = (int) location.getSpeed();
            c1480bv.f5186f = (short) location.getBearing();
            if (Build.MODEL.equals("sdk") || (C1499ci.m15808b(c1499ci.m15761x()) && C1486by.f5252b)) {
                c1480bv.f5187g = (byte) 1;
            } else {
                c1480bv.f5187g = (byte) 0;
            }
            c1480bv.f5188h = b;
            if (c1480bv.f5184d > 25) {
                c1480bv.f5188h = (byte) 5;
            }
            c1480bv.f5189i = System.currentTimeMillis();
            c1480bv.f5190j = c1499ci.m15771n();
            c1479bu.f5176c = c1480bv;
            i2 = 1;
            c1485bx.f5237j.add(c1479bu);
        } else if (!z) {
            return null;
        } else {
            C1479bu c1479bu2 = new C1479bu();
            c1479bu2.f5175b = (int) j2;
            C1491ca c1491ca = new C1491ca();
            c1491ca.f5296a = c1499ci.m15762w();
            for (int i3 = 0; i3 < c1491ca.f5296a; i3++) {
                C1492cb c1492cb = new C1492cb();
                c1492cb.f5299a = (byte) c1499ci.m15810b(i3).length();
                System.arraycopy(c1499ci.m15810b(i3).getBytes(), 0, c1492cb.f5300b, 0, c1492cb.f5299a);
                c1492cb.f5301c = c1499ci.m15798c(i3);
                c1492cb.f5302d = c1499ci.m15792d(i3);
                c1492cb.f5303e = c1499ci.m15789e(i3);
                c1492cb.f5304f = c1499ci.m15786f(i3);
                c1492cb.f5305g = c1499ci.m15783g(i3);
                c1492cb.f5306h = (byte) c1499ci.m15780h(i3).length();
                System.arraycopy(c1499ci.m15780h(i3).getBytes(), 0, c1492cb.f5307i, 0, c1492cb.f5306h);
                c1492cb.f5308j = c1499ci.m15777i(i3);
                c1491ca.f5297b.add(c1492cb);
            }
            c1479bu2.f5180g = c1491ca;
            i2 = 1;
            c1485bx.f5237j.add(c1479bu2);
        }
        if (c1499ci.m15799c() && !c1499ci.m15778i() && z2 && !z) {
            C1479bu c1479bu3 = new C1479bu();
            c1479bu3.f5175b = (int) j2;
            C1522de c1522de = new C1522de();
            List m15838a = c1499ci.m15838a(location.getSpeed());
            if (m15838a != null && m15838a.size() >= 3) {
                c1522de.f5448a = (short) ((Integer) m15838a.get(0)).intValue();
                c1522de.f5449b = ((Integer) m15838a.get(1)).intValue();
            }
            c1522de.f5450c = c1499ci.m15774k();
            List m15773l = c1499ci.m15773l();
            c1522de.f5451d = (byte) m15773l.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= m15773l.size()) {
                    break;
                }
                C1498ch c1498ch = new C1498ch();
                c1498ch.f5333a = (short) ((NeighboringCellInfo) m15773l.get(i5)).getLac();
                c1498ch.f5334b = ((NeighboringCellInfo) m15773l.get(i5)).getCid();
                c1498ch.f5335c = (byte) ((NeighboringCellInfo) m15773l.get(i5)).getRssi();
                c1522de.f5452e.add(c1498ch);
                i4 = i5 + 1;
            }
            c1479bu3.f5177d = c1522de;
            i2 = 2;
            c1485bx.f5237j.add(c1479bu3);
        }
        int i6 = i2;
        if (c1499ci.m15799c() && c1499ci.m15778i() && z2 && !z) {
            C1479bu c1479bu4 = new C1479bu();
            c1479bu4.f5175b = (int) j2;
            C1497cg c1497cg = new C1497cg();
            List m15811b = c1499ci.m15811b(location.getSpeed());
            if (m15811b != null && m15811b.size() >= 6) {
                c1497cg.f5326a = ((Integer) m15811b.get(3)).intValue();
                c1497cg.f5327b = ((Integer) m15811b.get(4)).intValue();
                c1497cg.f5328c = (short) ((Integer) m15811b.get(0)).intValue();
                c1497cg.f5329d = (short) ((Integer) m15811b.get(1)).intValue();
                c1497cg.f5330e = ((Integer) m15811b.get(2)).intValue();
                c1497cg.f5331f = c1499ci.m15774k();
            }
            c1479bu4.f5178e = c1497cg;
            i6++;
            c1485bx.f5237j.add(c1479bu4);
        }
        if (c1499ci.m15793d() && z3 && !z) {
            C1479bu c1479bu5 = new C1479bu();
            C1493cc c1493cc = new C1493cc();
            List m15765t = c1499ci.m15765t();
            c1479bu5.f5175b = (int) (((Long) m15765t.get(0)).longValue() / 1000);
            c1493cc.f5309a = (byte) (m15765t.size() - 1);
            int i7 = 1;
            while (true) {
                int i8 = i7;
                if (i8 >= m15765t.size()) {
                    break;
                }
                List list = (List) m15765t.get(i8);
                if (list != null && list.size() >= 3) {
                    C1494cd c1494cd = new C1494cd();
                    byte[] bytes6 = ((String) list.get(0)).getBytes();
                    System.arraycopy(bytes6, 0, c1494cd.f5312a, 0, m15861a(bytes6.length, c1494cd.f5312a.length));
                    c1494cd.f5313b = (short) ((Integer) list.get(1)).intValue();
                    byte[] bytes7 = ((String) list.get(2)).getBytes();
                    System.arraycopy(bytes7, 0, c1494cd.f5314c, 0, m15861a(bytes7.length, c1494cd.f5314c.length));
                    c1493cc.f5310b.add(c1494cd);
                }
                i7 = i8 + 1;
            }
            c1479bu5.f5179f = c1493cc;
            i6++;
            c1485bx.f5237j.add(c1479bu5);
        }
        c1485bx.f5236i = (short) i6;
        if (i6 < 2 && !z) {
            return null;
        }
        return c1485bx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static File m15859a(Context context) {
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files/"));
    }

    /* renamed from: a */
    public static Object m15857a(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    /* renamed from: a */
    private static ArrayList m15853a(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fileArr.length; i++) {
            if (fileArr[i].isFile() && fileArr[i].getName().length() == 10 && TextUtils.isDigitsOnly(fileArr[i].getName())) {
                arrayList.add(fileArr[i]);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static byte[] m15856a(BitSet bitSet) {
        byte[] bArr = new byte[bitSet.size() / 8];
        for (int i = 0; i < bitSet.size(); i++) {
            int i2 = i / 8;
            bArr[i2] = (byte) (((bitSet.get(i) ? 1 : 0) << (7 - (i % 8))) | bArr[i2]);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static byte[] m15855a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            return bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static byte[] m15854a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int indexOf = new String(bArr).indexOf(0);
        if (indexOf <= 0) {
            i = 1;
        } else if (indexOf + 1 <= i) {
            i = indexOf + 1;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        bArr2[i - 1] = 0;
        return bArr2;
    }

    /* renamed from: b */
    public static int m15849b(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static BitSet m15848b(byte[] bArr) {
        BitSet bitSet = new BitSet(bArr.length << 3);
        int i = 0;
        for (byte b : bArr) {
            int i2 = 7;
            while (i2 >= 0) {
                int i3 = i + 1;
                bitSet.set(i, ((b & (1 << i2)) >> i2) == 1);
                i2--;
                i = i3;
            }
        }
        return bitSet;
    }

    /* renamed from: c */
    private File m15846c(long j) {
        boolean z;
        File file;
        boolean z2 = false;
        if (Process.myUid() == 1000) {
            return null;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            z = false;
        }
        if (m15847c() && !z) {
            file = null;
        } else if (m15845d() <= this.f5322d / 2) {
            return null;
        } else {
            File file2 = new File(m15859a(this.f5319a).getPath() + File.separator + "carrierdata");
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdirs();
            }
            file = new File(file2.getPath() + File.separator + j);
            try {
                z2 = file.createNewFile();
            } catch (IOException e2) {
            }
        }
        if (z2) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public static boolean m15847c() {
        if (Build.VERSION.SDK_INT >= 9) {
            try {
                return ((Boolean) Environment.class.getMethod("isExternalStorageRemovable", null).invoke(null, null)).booleanValue();
            } catch (Exception e) {
            }
        }
        return true;
    }

    /* renamed from: d */
    protected static long m15845d() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    /* renamed from: e */
    private File m15844e() {
        boolean z;
        File[] listFiles;
        File file;
        if (Process.myUid() == 1000) {
            return null;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            z = false;
        }
        if (!m15847c() || z) {
            File file2 = new File(m15859a(this.f5319a).getPath() + File.separator + "carrierdata");
            if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                ArrayList m15853a = m15853a(listFiles);
                if (m15853a.size() == 1) {
                    if (((File) m15853a.get(0)).length() < this.f5324f) {
                        file = (File) m15853a.get(0);
                        return file;
                    }
                } else if (m15853a.size() >= 2) {
                    file = (File) m15853a.get(0);
                    File file3 = (File) m15853a.get(1);
                    if (file.getName().compareTo(file3.getName()) <= 0) {
                        file = file3;
                    }
                    return file;
                }
            }
        }
        file = null;
        return file;
    }

    /* renamed from: f */
    private int m15843f() {
        boolean z;
        File[] listFiles;
        if (Process.myUid() == 1000) {
            return 0;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            z = false;
        }
        if (m15847c() && !z) {
            return 0;
        }
        File file = new File(m15859a(this.f5319a).getPath() + File.separator + "carrierdata");
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return 0;
        }
        ArrayList m15853a = m15853a(listFiles);
        return m15853a.size() == 1 ? ((File) m15853a.get(0)).length() <= 0 ? 10 : 1 : m15853a.size() >= 2 ? 2 : 0;
    }

    /* renamed from: g */
    private File m15842g() {
        boolean z;
        File m15859a;
        File[] listFiles;
        File file;
        if (Process.myUid() == 1000) {
            return null;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            z = false;
        }
        if ((!m15847c() || z) && (m15859a = m15859a(this.f5319a)) != null) {
            File file2 = new File(m15859a.getPath() + File.separator + "carrierdata");
            if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                ArrayList m15853a = m15853a(listFiles);
                if (m15853a.size() >= 2) {
                    File file3 = (File) m15853a.get(0);
                    file = (File) m15853a.get(1);
                    if (file3.getName().compareTo(file.getName()) <= 0) {
                        file = file3;
                    }
                    return file;
                }
            }
        }
        file = null;
        return file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public int m15863a() {
        return this.f5320b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized File m15860a(long j) {
        File m15844e;
        m15844e = m15844e();
        if (m15844e == null) {
            m15844e = m15846c(j);
        }
        return m15844e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15862a(int i) {
        this.f5320b = i;
        this.f5322d = ((this.f5320b << 3) * 1500) + this.f5320b + 4;
        if (this.f5320b == 256 || this.f5320b == 768) {
            this.f5324f = this.f5322d / 100;
        } else if (this.f5320b != 8736) {
        } else {
            this.f5324f = this.f5322d - 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public File m15852b() {
        return m15842g();
    }

    /* renamed from: b */
    protected void m15851b(int i) {
        this.f5321c = i;
        this.f5323e = ((this.f5321c << 3) * 1000) + this.f5321c + 4;
        this.f5325g = this.f5323e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized boolean m15850b(long j) {
        boolean z = false;
        synchronized (this) {
            int m15843f = m15843f();
            if (m15843f != 0) {
                if (m15843f == 1) {
                    if (m15846c(j) != null) {
                        z = true;
                    }
                } else if (m15843f == 2) {
                    z = true;
                }
            }
        }
        return z;
    }
}
