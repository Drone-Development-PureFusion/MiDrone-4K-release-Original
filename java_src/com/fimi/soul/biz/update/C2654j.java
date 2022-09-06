package com.fimi.soul.biz.update;

import android.content.Context;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2258f;
import com.fimi.kernel.utils.C2269n;
import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.p200f.C2844a;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.entity.UpgradeDetInfo;
import com.fimi.soul.entity.UpgradeResultInfo;
import com.fimi.soul.entity.User;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3583e;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.C3695s;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.fimi.soul.biz.update.j */
/* loaded from: classes.dex */
public class C2654j {

    /* renamed from: a */
    public static final String f9192a = "/fw_upgrade/Camera_Log/";

    /* renamed from: b */
    public static final String f9193b = "/fw_upgrade/X6_Log/";

    /* renamed from: c */
    public static final String f9194c = "10010";

    /* renamed from: d */
    public static final long f9195d = 524288;

    /* renamed from: e */
    public static final String f9196e = "sp_update_camara_version";

    /* renamed from: f */
    public static final String f9197f = "sp_update_x6_version";

    /* renamed from: g */
    private static HashMap<Integer, Integer> f9198g = null;

    /* renamed from: com.fimi.soul.biz.update.j$a */
    /* loaded from: classes.dex */
    public enum EnumC2655a {
        Camera,
        Ap
    }

    /* renamed from: a */
    public static long m11365a(List<UpdateVersonBean> list) {
        long j = 0;
        Iterator<UpdateVersonBean> it2 = list.iterator();
        while (true) {
            long j2 = j;
            if (it2.hasNext()) {
                j = Long.valueOf(it2.next().getSize()).longValue() + j2;
            } else {
                return j2;
            }
        }
    }

    /* renamed from: a */
    public static UpgradeResultInfo m11371a(Context context) {
        UpgradeResultInfo upgradeResultInfo = new UpgradeResultInfo();
        User m12507c = C2353b.m12507c(context);
        if (m12507c != null) {
            upgradeResultInfo.setUserID(m12507c.getUserID());
        }
        Gson gson = new Gson();
        m11357c(gson.toJson(m11351e()));
        upgradeResultInfo.setJsonStr(gson.toJson(m11351e()));
        return upgradeResultInfo;
    }

    /* renamed from: a */
    public static File m11370a(EnumC2655a enumC2655a) {
        File file = null;
        if (enumC2655a == EnumC2655a.Camera) {
            file = new File(C3681j.m7482a() + f9192a);
        }
        if (enumC2655a == EnumC2655a.Ap) {
            file = new File(C3681j.m7482a() + f9193b);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, C2258f.m13020a(new Date(), "yyyy-MM-dd") + ".txt");
        try {
            if (file2.exists() && file2.length() > f9195d) {
                file2.delete();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file2;
    }

    /* renamed from: a */
    public static String m11372a(int i) {
        return String.valueOf(i <= 60 ? 1 : (int) Math.ceil(i / 60.0d));
    }

    /* renamed from: a */
    private static String m11369a(C2844a c2844a) {
        return "" + c2844a.m10823d() + c2844a.m10821e() + c2844a.m10819g() + c2844a.m10820f();
    }

    /* renamed from: a */
    public static String m11367a(String str) {
        return C3587b.f14543L + str + ".bin";
    }

    /* renamed from: a */
    public static String m11366a(String str, String str2) {
        return "X6E-RC-5G-" + str2 + "_" + str + ".bin";
    }

    /* renamed from: a */
    public static HashMap<Integer, Integer> m11373a() {
        if (f9198g == null || f9198g.isEmpty()) {
            f9198g = new HashMap<>();
            f9198g.put(0, 210);
            f9198g.put(1, 20);
            f9198g.put(9, 120);
            f9198g.put(10, 40);
            f9198g.put(3, Integer.valueOf((int) Opcodes.GETFIELD));
            f9198g.put(6, 50);
            f9198g.put(4, 150);
            f9198g.put(11, 60);
            f9198g.put(15, 60);
            f9198g.put(26, 60);
            f9198g.put(14, 60);
            f9198g.put(25, 60);
            f9198g.put(13, 600);
            f9198g.put(253, 600);
            f9198g.put(5, 60);
            f9198g.put(8, 60);
        }
        return f9198g;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m11368a(File file, String str) {
        RandomAccessFile randomAccessFile;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file.getAbsoluteFile(), "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.writeBytes("\n" + C3695s.m7432a() + "    " + new String(str.getBytes("ISO-8859-1"), "UTF-8"));
                    if (randomAccessFile == null) {
                        return;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static int m11363b(int i) {
        switch (i) {
            case 0:
                return 8;
            case 1:
                return 11;
            case 3:
                return 3;
            case 4:
            case 13:
                return 1;
            case 5:
                return 9;
            case 6:
                return 4;
            case 8:
                return 5;
            case 9:
                return 5;
            case 10:
                return 6;
            case 11:
                return 12;
            case 14:
                return 10;
            case 15:
                return 13;
            case 25:
                return 10;
            case 26:
                return 13;
            case 253:
                return 7;
            default:
                return -1;
        }
    }

    /* renamed from: b */
    public static long m11360b(List<FirmwareInfo> list) {
        long j = 0;
        Iterator<FirmwareInfo> it2 = list.iterator();
        while (true) {
            long j2 = j;
            if (it2.hasNext()) {
                j = it2.next().getFileSize() + j2;
            } else {
                return j2;
            }
        }
    }

    /* renamed from: b */
    public static String m11364b() {
        return C3587b.f14553V;
    }

    /* renamed from: b */
    public static String m11361b(String str, String str2) {
        return "X6E-RC-5G-" + str2 + "_" + str + ".bin";
    }

    /* renamed from: b */
    public static void m11362b(String str) {
        m11368a(m11370a(EnumC2655a.Ap), str);
    }

    /* renamed from: c */
    public static int m11358c(int i) {
        if (i == 17) {
            return 0;
        }
        if (i == 16) {
            return 1;
        }
        if (i == 12) {
            return 3;
        }
        if (i == 18) {
            return 10;
        }
        if (i == 19) {
            return 9;
        }
        if (i == 20) {
            return 6;
        }
        if (i == 23) {
            return 5;
        }
        if (i != 27) {
            return i;
        }
        return 8;
    }

    /* renamed from: c */
    public static String m11359c() {
        List<UpdateVersonBean> m7962e = C3579a.m7971a().m7962e();
        if (m7962e == null || m7962e.size() <= 0) {
            return null;
        }
        return String.valueOf(C2275t.m12793a((m11365a(m7962e) / 1024.0d) / 1024.0d, 2));
    }

    /* renamed from: c */
    public static String m11356c(String str, String str2) {
        return "X6E-DR-5G-" + str2 + "_" + str + ".bin";
    }

    /* renamed from: c */
    public static void m11357c(String str) {
        m11368a(m11370a(EnumC2655a.Camera), str);
    }

    /* renamed from: d */
    public static String m11355d() {
        List<FirmwareInfo> m7963d = C3579a.m7971a().m7963d();
        if (m7963d == null || m7963d.size() <= 0) {
            return null;
        }
        return String.valueOf(C2275t.m12793a((m11360b(m7963d) / 1024.0d) / 1024.0d, 2));
    }

    /* renamed from: d */
    public static String m11352d(String str, String str2) {
        return "X6E-DR-5G-" + str2 + "_" + str + ".bin";
    }

    /* renamed from: d */
    public static void m11353d(String str) {
        C2238c.m13125c().mo13116a(f9197f, str);
    }

    /* renamed from: d */
    public static boolean m11354d(int i) {
        return i == 199 || i == 201 || i == 202 || i == 203 || i == 204 || i == 106 || i == 193;
    }

    /* renamed from: e */
    public static UpgradeDetInfo m11351e() {
        UpgradeDetInfo upgradeDetInfo = new UpgradeDetInfo();
        C3579a m7971a = C3579a.m7971a();
        if (m7971a != null) {
            C3583e m7970a = m7971a.m7970a(0);
            upgradeDetInfo.setFcHwVersion(m7970a.m7916c());
            upgradeDetInfo.setFcID(m7970a.m7905i());
            upgradeDetInfo.setFcSwVersion(m7970a.m7921b() + "");
            C3583e m7970a2 = m7971a.m7970a(1);
            upgradeDetInfo.setRcHwVersion(m7970a2.m7916c());
            upgradeDetInfo.setRcSwVersion(m7970a2.m7921b() + "");
            upgradeDetInfo.setRcID(m7970a2.m7905i());
            C3583e m7970a3 = m7971a.m7970a(10);
            upgradeDetInfo.setNoFlyHwVersion(m7970a3.m7916c());
            upgradeDetInfo.setNoFlySwVersion(m7970a3.m7921b() + "");
            upgradeDetInfo.setNoFlyID(m7970a3.m7905i());
            C3583e m7970a4 = m7971a.m7970a(3);
            upgradeDetInfo.setGcHwVersion(m7970a4.m7916c());
            upgradeDetInfo.setGcSwVersion(m7970a4.m7921b() + "");
            upgradeDetInfo.setGcID(m7970a4.m7905i());
            C3583e m7970a5 = m7971a.m7970a(9);
            upgradeDetInfo.setX2HwVersion(m7970a5.m7916c());
            upgradeDetInfo.setX2SwVersion(m7970a5.m7921b() + "");
            upgradeDetInfo.setX2ID(m7970a5.m7905i());
            C3583e m7970a6 = m7971a.m7970a(6);
            upgradeDetInfo.setServoHwVersion(m7970a6.m7916c());
            upgradeDetInfo.setServoSwVersion(m7970a6.m7921b() + "");
            upgradeDetInfo.setServoID(m7970a6.m7905i());
            C3583e m7970a7 = m7971a.m7970a(4);
            upgradeDetInfo.setX1HwVersion(m7970a7.m7916c());
            upgradeDetInfo.setX1SwVersion(m7970a7.m7921b() + "");
            upgradeDetInfo.setX1ID(m7970a7.m7905i());
            C3583e m7970a8 = m7971a.m7970a(4);
            upgradeDetInfo.setX6HwVersion(m7970a8.m7916c());
            upgradeDetInfo.setX6SwVersion(m7970a8.m7921b() + "");
            upgradeDetInfo.setX6ID(m7970a8.m7905i());
        }
        return upgradeDetInfo;
    }

    /* renamed from: e */
    public static void m11350e(String str) {
        C2238c.m13125c().mo13116a(f9196e, str);
    }

    /* renamed from: f */
    public static void m11349f() {
        m11353d((String) null);
        m11350e(null);
    }

    /* renamed from: g */
    public static String m11348g() {
        String mo13121a = C2238c.m13125c().mo13121a(UpdateVersonBean.SP_CAMERA_VERSION);
        return mo13121a != null ? String.valueOf(C2269n.m12875n(mo13121a)) : "";
    }

    /* renamed from: h */
    public static String m11347h() {
        String m12448d = C2367d.m12459a().m12448d();
        int i = -1;
        if (m12448d != null) {
            i = Integer.valueOf(C2269n.m12875n(m12448d)).intValue();
        }
        return String.valueOf(i);
    }
}
