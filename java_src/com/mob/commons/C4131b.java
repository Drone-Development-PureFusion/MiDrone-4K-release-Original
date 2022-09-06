package com.mob.commons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.fimi.soul.utils.p211a.C3628c;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import com.p219mi.live.openlivesdk.C4095b;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.mob.commons.b */
/* loaded from: classes.dex */
public class C4131b implements Handler.Callback {

    /* renamed from: a */
    private static C4131b f17273a;

    /* renamed from: b */
    private Context f17274b;

    /* renamed from: c */
    private Handler f17275c;

    /* renamed from: d */
    private SQLiteHelper.SingleTableDB f17276d;

    /* renamed from: e */
    private Hashon f17277e = new Hashon();

    /* renamed from: f */
    private Random f17278f = new Random();

    private C4131b(Context context) {
        this.f17274b = context.getApplicationContext();
        MobHandlerThread mobHandlerThread = new MobHandlerThread();
        mobHandlerThread.start();
        this.f17275c = new Handler(mobHandlerThread.getLooper(), this);
        File file = new File(ResHelper.getCacheRoot(context), "comm/dbs/.dh");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        this.f17276d = SQLiteHelper.getDatabase(file.getAbsolutePath(), "DataHeap_1");
        this.f17276d.addField(C3628c.C3629a.f14776i, "text", true);
        this.f17276d.addField("data", "text", true);
        this.f17275c.sendEmptyMessage(1);
    }

    /* renamed from: a */
    public static synchronized C4131b m6103a(Context context) {
        C4131b c4131b;
        synchronized (C4131b.class) {
            if (f17273a == null) {
                f17273a = new C4131b(context);
            }
            c4131b = f17273a;
        }
        return c4131b;
    }

    /* renamed from: a */
    private String m6100a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(this.f17278f.nextLong());
        dataOutputStream.writeLong(this.f17278f.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
        gZIPOutputStream.write(str.getBytes("utf-8"));
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] AES128Encode = Data.AES128Encode(byteArray, byteArrayOutputStream2.toByteArray());
        byte[] encode = new MobRSA(1024).encode(byteArray, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream3);
        dataOutputStream2.writeInt(encode.length);
        dataOutputStream2.write(encode);
        dataOutputStream2.writeInt(AES128Encode.length);
        dataOutputStream2.write(AES128Encode);
        dataOutputStream2.flush();
        dataOutputStream2.close();
        return Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
    }

    /* renamed from: a */
    private void m6105a() {
        String str;
        try {
            str = (String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17274b), "getNetworkType", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            str = null;
        }
        if (str == null || "none".equals(str)) {
            return;
        }
        C4145d.m6037a(new File(ResHelper.getCacheRoot(this.f17274b), "comm/locks/.dhlock"), new LockAction() { // from class: com.mob.commons.b.2
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                ArrayList m6098b = C4131b.this.m6098b();
                if (m6098b.size() <= 0 || !C4131b.this.m6099a(m6098b)) {
                    return false;
                }
                C4131b.this.m6093b(m6098b);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6099a(ArrayList<String[]> arrayList) {
        try {
            NetworkHelper networkHelper = new NetworkHelper();
            ArrayList<MobProduct> m6036a = C4146e.m6036a();
            if (m6036a.isEmpty()) {
                return false;
            }
            HashMap hashMap = new HashMap();
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17274b);
            hashMap.put("plat", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]));
            hashMap.put("device", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDeviceKey", new Object[0]));
            hashMap.put("mac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
            hashMap.put(C3947a.f16893d, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
            hashMap.put("duid", DeviceAuthorizer.authorize(this.f17274b, (MobProduct) null));
            hashMap.put(C3947a.f16895f, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
            hashMap.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
            hashMap.put("networktype", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]));
            ArrayList arrayList2 = new ArrayList();
            byte[] rawMD5 = Data.rawMD5(String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0])));
            Iterator<String[]> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(this.f17277e.fromJson(new String(Data.AES128Decode(rawMD5, Base64.decode(it2.next()[1], 2)), "utf-8").trim()));
            }
            hashMap.put("datas", arrayList2);
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(new KVPair<>(C4095b.f17105f, m6036a.get(0).getProductAppkey()));
            arrayList3.add(new KVPair<>(C0413a.f922b, m6100a(this.f17277e.fromHashMap(hashMap))));
            ArrayList<KVPair<String>> arrayList4 = new ArrayList<>();
            arrayList4.add(new KVPair<>("User-Identity", C4146e.m6035a(this.f17274b, m6036a)));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            boolean equals = "200".equals(String.valueOf(this.f17277e.fromJson(networkHelper.httpPost(m6096b(this.f17274b), arrayList3, null, arrayList4, networkTimeOut)).get("status")));
            if (equals) {
                return equals;
            }
            C4151f.m6015e(this.f17274b, null);
            return equals;
        } catch (Throwable th) {
            C4151f.m6015e(this.f17274b, null);
            MobLog.getInstance().m5959w(th);
            return false;
        }
    }

    /* renamed from: b */
    private static String m6096b(Context context) {
        String str = null;
        try {
            str = C4151f.m6014f(context);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        return TextUtils.isEmpty(str) ? "http://c.data.mob.com/v2/cdata" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public ArrayList<String[]> m6098b() {
        ArrayList<String[]> arrayList = new ArrayList<>();
        try {
            Cursor query = SQLiteHelper.query(this.f17276d, new String[]{C3628c.C3629a.f14776i, "data"}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    long m6143a = C4125a.m6143a(this.f17274b);
                    do {
                        String[] strArr = {query.getString(0), query.getString(1)};
                        long j = -1;
                        try {
                            j = Long.parseLong(strArr[0]);
                        } catch (Throwable th) {
                        }
                        if (j <= m6143a) {
                            arrayList.add(strArr);
                        }
                    } while (query.moveToNext());
                    query.close();
                } else {
                    query.close();
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().m5959w(th2);
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m6097b(final long j, final HashMap<String, Object> hashMap) {
        C4145d.m6037a(new File(ResHelper.getCacheRoot(this.f17274b), "comm/locks/.dhlock"), new LockAction() { // from class: com.mob.commons.b.1
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C3628c.C3629a.f14776i, String.valueOf(j));
                    contentValues.put("data", Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.valueOf(ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", C4131b.this.f17274b), "getManufacturer", new Object[0]))), C4131b.this.f17277e.fromHashMap(hashMap).getBytes("utf-8")), 2));
                    SQLiteHelper.insert(C4131b.this.f17276d, contentValues);
                } catch (Throwable th) {
                    MobLog.getInstance().m5959w(th);
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6093b(ArrayList<String[]> arrayList) {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String[]> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String[] next = it2.next();
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(C0359h.f729z).append(next[0]).append(C0359h.f729z);
            }
            SQLiteHelper.delete(this.f17276d, "time in (" + sb.toString() + ")", null);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }

    /* renamed from: a */
    public synchronized void m6104a(long j, HashMap<String, Object> hashMap) {
        Message message = new Message();
        message.what = 2;
        message.obj = new Object[]{Long.valueOf(j), hashMap};
        this.f17275c.sendMessage(message);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m6105a();
                this.f17275c.sendEmptyMessageDelayed(1, AbstractC0517a.f1169e);
                break;
            case 2:
                Object[] objArr = (Object[]) message.obj;
                long longValue = ((Long) ResHelper.forceCast(objArr[0], -1L)).longValue();
                if (longValue > 0) {
                    m6097b(longValue, (HashMap) objArr[1]);
                    break;
                }
                break;
        }
        return false;
    }
}
