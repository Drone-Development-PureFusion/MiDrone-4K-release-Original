package com.mob.commons.authorize;

import android.content.Context;
import android.util.Base64;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.commons.C4145d;
import com.mob.commons.LockAction;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.p219mi.live.openlivesdk.C4095b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.mob.commons.authorize.a */
/* loaded from: classes.dex */
public final class C4128a {
    /* renamed from: a */
    private final String m6114a(Context context, com.mob.commons.MobProduct mobProduct, HashMap<String, Object> hashMap, boolean z) {
        int i;
        ObjectOutputStream objectOutputStream;
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            try {
                i = ResHelper.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
            } catch (Throwable th) {
                i = -1;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("adsid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]));
            hashMap2.put(C3947a.f16895f, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
            hashMap2.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
            hashMap2.put("androidid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]));
            hashMap2.put("mac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
            hashMap2.put(C3947a.f16893d, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
            hashMap2.put("factory", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]));
            hashMap2.put("carrier", Integer.valueOf(i));
            hashMap2.put("screensize", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getScreenSize", new Object[0]));
            hashMap2.put("sysver", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]));
            hashMap2.put("plat", 1);
            Hashon hashon = new Hashon();
            String encodeToString = Base64.encodeToString(Data.AES128Encode("sdk.commonap.sdk", hashon.fromHashMap(hashMap2)), 2);
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>(C0413a.f922b, encodeToString));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            HashMap fromJson = hashon.fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dinfo", arrayList, null, null, networkTimeOut));
            if (fromJson == null) {
                return null;
            }
            String str = (String) fromJson.get("duid");
            if (str == null || str.length() <= 0) {
                return null;
            }
            hashMap.put("duid", str);
            hashMap2.put("carrier", String.valueOf(i));
            hashMap.put("deviceInfo", hashMap2);
            if (!z) {
                return str;
            }
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(m6110b(context)));
                try {
                    objectOutputStream.writeObject(hashMap);
                    if (objectOutputStream == null) {
                        return str;
                    }
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                        return str;
                    } catch (Throwable th2) {
                        return str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    MobLog.getInstance().m5959w(th);
                    if (objectOutputStream == null) {
                        return str;
                    }
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                        return str;
                    } catch (Throwable th4) {
                        return str;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
            }
        } catch (Throwable th6) {
            MobLog.getInstance().m5959w(th6);
            return null;
        }
    }

    /* renamed from: a */
    private final void m6115a(Context context, com.mob.commons.MobProduct mobProduct, HashMap<String, Object> hashMap) {
        ObjectOutputStream objectOutputStream;
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("product", mobProduct.getProductTag()));
            arrayList.add(new KVPair<>(C4095b.f17105f, mobProduct.getProductAppkey()));
            arrayList.add(new KVPair<>("duid", (String) hashMap.get("duid")));
            arrayList.add(new KVPair<>("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))));
            arrayList.add(new KVPair<>("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersion", new Object[0]))));
            arrayList.add(new KVPair<>("sdkver", String.valueOf(mobProduct.getSdkver())));
            arrayList.add(new KVPair<>(C3947a.f16908s, String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]))));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            HashMap fromJson = new Hashon().fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dsign", arrayList, null, null, networkTimeOut));
            if (!"true".equals(String.valueOf(fromJson.get("reup"))) || m6114a(context, mobProduct, hashMap, false) != null) {
            }
            if (!"200".equals(String.valueOf(fromJson.get("status")))) {
                return;
            }
            ((HashMap) ((HashMap) hashMap.get("appInfo")).get((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))).put(mobProduct.getProductTag(), mobProduct.getProductAppkey());
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(m6110b(context)));
                try {
                    objectOutputStream.writeObject(hashMap);
                    if (objectOutputStream == null) {
                        return;
                    }
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    MobLog.getInstance().m5959w(th);
                    if (objectOutputStream == null) {
                        return;
                    }
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = null;
            }
        } catch (Throwable th5) {
            MobLog.getInstance().m5959w(th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m6113a(Context context, HashMap<String, String> hashMap) {
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = null;
        if (hashMap == null) {
            return true;
        }
        try {
            obj = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            obj = null;
        }
        String str10 = hashMap.get("adsid");
        if (obj != null) {
            try {
                str = (String) ReflectHelper.invokeInstanceMethod(obj, "getAdvertisingID", new Object[0]);
            } catch (Throwable th2) {
                MobLog.getInstance().m5959w(th2);
            }
            if (str == null && ((str10 == null && str != null) || (str10 != null && !str10.equals(str)))) {
                return true;
            }
            str2 = hashMap.get(C3947a.f16895f);
            if (obj != null) {
                try {
                    str3 = (String) ReflectHelper.invokeInstanceMethod(obj, "getIMEI", new Object[0]);
                } catch (Throwable th3) {
                    MobLog.getInstance().m5959w(th3);
                }
                if (str2 != null || !str2.equals(str3)) {
                    return true;
                }
                String str11 = hashMap.get("serialno");
                if (obj != null) {
                    try {
                        str4 = (String) ReflectHelper.invokeInstanceMethod(obj, "getSerialno", new Object[0]);
                    } catch (Throwable th4) {
                        MobLog.getInstance().m5959w(th4);
                    }
                    if (str11 != null || !str11.equals(str4)) {
                        return true;
                    }
                    String str12 = hashMap.get("mac");
                    if (obj != null) {
                        try {
                            str5 = (String) ReflectHelper.invokeInstanceMethod(obj, "getMacAddress", new Object[0]);
                        } catch (Throwable th5) {
                            MobLog.getInstance().m5959w(th5);
                        }
                        if (str12 != null || !str12.equals(str5)) {
                            return true;
                        }
                        String str13 = hashMap.get(C3947a.f16893d);
                        if (obj != null) {
                            try {
                                str6 = (String) ReflectHelper.invokeInstanceMethod(obj, "getModel", new Object[0]);
                            } catch (Throwable th6) {
                                MobLog.getInstance().m5959w(th6);
                            }
                            if (str13 != null || !str13.equals(str6)) {
                                return true;
                            }
                            String str14 = hashMap.get("factory");
                            if (obj != null) {
                                try {
                                    str7 = (String) ReflectHelper.invokeInstanceMethod(obj, "getManufacturer", new Object[0]);
                                } catch (Throwable th7) {
                                    MobLog.getInstance().m5959w(th7);
                                }
                                if (str14 != null || !str14.equals(str7)) {
                                    return true;
                                }
                                String str15 = hashMap.get("androidid");
                                if (obj != null) {
                                    try {
                                        str8 = (String) ReflectHelper.invokeInstanceMethod(obj, "getAndroidID", new Object[0]);
                                    } catch (Throwable th8) {
                                        MobLog.getInstance().m5959w(th8);
                                    }
                                    if (str15 != null || !str15.equals(str8)) {
                                        return true;
                                    }
                                    String str16 = hashMap.get("sysver");
                                    if (obj != null) {
                                        try {
                                            str9 = (String) ReflectHelper.invokeInstanceMethod(obj, "getOSVersionName", new Object[0]);
                                        } catch (Throwable th9) {
                                            MobLog.getInstance().m5959w(th9);
                                        }
                                    }
                                    return str16 == null || !str16.equals(str9);
                                }
                                str8 = null;
                                if (str15 != null) {
                                }
                                return true;
                            }
                            str7 = null;
                            if (str14 != null) {
                            }
                            return true;
                        }
                        str6 = null;
                        if (str13 != null) {
                        }
                        return true;
                    }
                    str5 = null;
                    if (str12 != null) {
                    }
                    return true;
                }
                str4 = null;
                if (str11 != null) {
                }
                return true;
            }
            str3 = null;
            if (str2 != null) {
            }
            return true;
        }
        str = null;
        if (str == null) {
        }
        str2 = hashMap.get(C3947a.f16895f);
        if (obj != null) {
        }
        str3 = null;
        if (str2 != null) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public final File m6110b(Context context) {
        File file = new File(ResHelper.getCacheRoot(context), "comm/dbs/.duid");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        if (r3 != null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m6109b(Context context, com.mob.commons.MobProduct mobProduct) {
        HashMap<String, Object> hashMap;
        HashMap<String, Object> m6106c;
        String str;
        HashMap hashMap2;
        File m6110b;
        ObjectInputStream objectInputStream;
        try {
            m6110b = m6110b(context);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        if (m6110b.exists() && m6110b.isFile()) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(m6110b));
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
            }
            try {
                hashMap = (HashMap) objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                MobLog.getInstance().m5959w(th);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                        hashMap = null;
                    } catch (Throwable th5) {
                        hashMap = null;
                    }
                    if (hashMap != null) {
                    }
                    if (m6106c != null) {
                    }
                }
                hashMap = null;
                if (hashMap != null) {
                }
                if (m6106c != null) {
                }
            }
            m6106c = hashMap != null ? m6106c(context, mobProduct) : hashMap;
            if (m6106c != null) {
                return null;
            }
            String str2 = (String) m6106c.get("duid");
            if (str2 == null) {
                return str2;
            }
            try {
                if (m6113a(context, (HashMap) m6106c.get("deviceInfo"))) {
                    str = m6114a(context, mobProduct, m6106c, true);
                }
                str = str2;
                try {
                    HashMap hashMap3 = (HashMap) m6106c.get("appInfo");
                    if (hashMap3 == null) {
                        HashMap hashMap4 = new HashMap();
                        m6106c.put("appInfo", hashMap4);
                        hashMap2 = hashMap4;
                    } else {
                        hashMap2 = hashMap3;
                    }
                    String str3 = (String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context), "getPackageName", new Object[0]);
                    HashMap hashMap5 = (HashMap) hashMap2.get(str3);
                    if (hashMap5 == null) {
                        hashMap5 = new HashMap();
                        hashMap2.put(str3, hashMap5);
                    }
                    String str4 = (String) hashMap5.get(mobProduct.getProductTag());
                    if (str4 == null || !str4.equals(mobProduct.getProductAppkey())) {
                        m6115a(context, mobProduct, m6106c);
                    }
                    return str;
                } catch (Throwable th6) {
                    th = th6;
                    str2 = str;
                    MobLog.getInstance().m5959w(th);
                    return str2;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
        hashMap = null;
        if (hashMap != null) {
        }
        if (m6106c != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public HashMap<String, Object> m6107c(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ObjectOutputStream objectOutputStream = null;
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            String str = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]);
            String str2 = str == null ? "" : str;
            String str3 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]);
            String str4 = str3 == null ? "" : str3;
            String str5 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]);
            String str6 = str5 == null ? "" : str5;
            String str7 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]);
            if (str7 == null) {
                str7 = "";
            }
            hashMap.put("duid", Data.byteToHex(Data.SHA1(str2 + ":" + str4 + ":" + str6 + ":" + str7)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("adsid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]));
            hashMap2.put(C3947a.f16895f, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
            hashMap2.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
            hashMap2.put("androidid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]));
            hashMap2.put("mac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
            hashMap2.put(C3947a.f16893d, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
            hashMap2.put("factory", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]));
            hashMap2.put("carrier", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
            hashMap2.put("screensize", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getScreenSize", new Object[0]));
            hashMap2.put("sysver", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]));
            hashMap2.put("plat", 1);
            hashMap.put("deviceInfo", hashMap2);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(m6110b(context)));
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(hashMap);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = objectOutputStream;
            try {
                MobLog.getInstance().m5959w(th);
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Throwable th3) {
                    }
                }
                return hashMap;
            } finally {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Throwable th4) {
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    private final HashMap<String, Object> m6106c(Context context, com.mob.commons.MobProduct mobProduct) {
        int i;
        ObjectOutputStream objectOutputStream;
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            try {
                i = ResHelper.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
            } catch (Throwable th) {
                i = -1;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("adsid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]));
            hashMap.put(C3947a.f16895f, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
            hashMap.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
            hashMap.put("androidid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]));
            hashMap.put("mac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
            hashMap.put(C3947a.f16893d, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
            hashMap.put("factory", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]));
            hashMap.put("carrier", Integer.valueOf(i));
            hashMap.put("screensize", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getScreenSize", new Object[0]));
            hashMap.put("sysver", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]));
            hashMap.put("plat", 1);
            Hashon hashon = new Hashon();
            String encodeToString = Base64.encodeToString(Data.AES128Encode("sdk.commonap.sdk", hashon.fromHashMap(hashMap)), 2);
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>(C0413a.f922b, encodeToString));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            HashMap fromJson = hashon.fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dinfo", arrayList, null, null, networkTimeOut));
            if (fromJson == null) {
                return null;
            }
            String str = (String) fromJson.get("duid");
            if (str == null || str.length() <= 0) {
                return null;
            }
            HashMap<String, Object> hashMap2 = new HashMap<>();
            try {
                hashMap2.put("duid", str);
                hashMap.put("carrier", String.valueOf(i));
                hashMap2.put("deviceInfo", hashMap);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(m6110b(context)));
                try {
                    objectOutputStream.writeObject(hashMap2);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        } catch (Throwable th2) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    MobLog.getInstance().m5959w(th);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                    return hashMap2;
                }
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
            }
            return hashMap2;
        } catch (Throwable th6) {
            MobLog.getInstance().m5959w(th6);
            return null;
        }
    }

    /* renamed from: a */
    public final String m6117a(final Context context) {
        final String[] strArr = new String[1];
        C4145d.m6037a(new File(ResHelper.getCacheRoot(context), "comm/locks/.globalLock"), new LockAction() { // from class: com.mob.commons.authorize.a.2
            /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
            @Override // com.mob.commons.LockAction
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean run(FileLocker fileLocker) {
                HashMap hashMap;
                File m6110b;
                ObjectInputStream objectInputStream;
                try {
                    m6110b = C4128a.this.m6110b(context);
                } catch (Throwable th) {
                    MobLog.getInstance().m5959w(th);
                }
                if (m6110b.exists() && m6110b.isFile()) {
                    try {
                        objectInputStream = new ObjectInputStream(new FileInputStream(m6110b));
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = null;
                    }
                    try {
                        hashMap = (HashMap) objectInputStream.readObject();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Throwable th3) {
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        MobLog.getInstance().m5959w(th);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                                hashMap = null;
                            } catch (Throwable th5) {
                                hashMap = null;
                            }
                            if (hashMap == null) {
                            }
                            strArr[0] = (String) hashMap.get("duid");
                            return false;
                        }
                        hashMap = null;
                        if (hashMap == null) {
                        }
                        strArr[0] = (String) hashMap.get("duid");
                        return false;
                    }
                    if (hashMap == null) {
                        hashMap = C4128a.this.m6107c(context);
                    }
                    strArr[0] = (String) hashMap.get("duid");
                    return false;
                }
                hashMap = null;
                if (hashMap == null) {
                }
                strArr[0] = (String) hashMap.get("duid");
                return false;
            }
        });
        return strArr[0];
    }

    /* renamed from: a */
    public final String m6116a(final Context context, final com.mob.commons.MobProduct mobProduct) {
        final String[] strArr = new String[1];
        C4145d.m6037a(new File(ResHelper.getCacheRoot(context), "comm/locks/.globalLock"), new LockAction() { // from class: com.mob.commons.authorize.a.1
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                strArr[0] = C4128a.this.m6109b(context, mobProduct);
                return false;
            }
        });
        return strArr[0];
    }
}
