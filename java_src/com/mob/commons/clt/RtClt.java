package com.mob.commons.clt;

import android.content.Context;
import android.os.Build;
import com.mob.commons.C4125a;
import com.mob.commons.C4131b;
import com.mob.commons.C4134c;
import com.mob.commons.C4145d;
import com.mob.commons.LockAction;
import com.mob.tools.MobLog;
import com.mob.tools.MobLooper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class RtClt {

    /* renamed from: a */
    private static final String f17302a;

    /* renamed from: b */
    private static RtClt f17303b;

    /* renamed from: c */
    private Context f17304c;

    static {
        f17302a = Build.VERSION.SDK_INT >= 16 ? "^u\\d+_a\\d+" : "^app_\\d+";
    }

    private RtClt(Context context) {
        this.f17304c = context.getApplicationContext();
    }

    /* renamed from: a */
    private ArrayList<HashMap<String, Object>> m6045a(HashMap<String, String>[][] hashMapArr, ArrayList<long[]> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>(hashMapArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < hashMapArr.length) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("runtimes", 0L);
                hashMap.put("fg", 0);
                hashMap.put("bg", 0);
                hashMap.put("empty", 0);
                arrayList2.add(hashMap);
                HashMap<String, String>[] hashMapArr2 = hashMapArr[i2];
                int length = hashMapArr2.length - 1;
                while (length >= 0) {
                    if (hashMapArr2[length] != null) {
                        hashMap.put("runtimes", Long.valueOf((length == 0 ? 0L : arrayList.get(length)[1]) + ((Long) ResHelper.forceCast(hashMap.get("runtimes"), 0L)).longValue()));
                        if ("fg".equals(hashMapArr2[length].get("pcy"))) {
                            hashMap.put("fg", Integer.valueOf(((Integer) ResHelper.forceCast(hashMap.get("fg"), 0)).intValue() + 1));
                        } else if ("bg".equals(hashMapArr2[length].get("pcy"))) {
                            hashMap.put("bg", Integer.valueOf(((Integer) ResHelper.forceCast(hashMap.get("bg"), 0)).intValue() + 1));
                        } else {
                            hashMap.put("empty", Integer.valueOf(((Integer) ResHelper.forceCast(hashMap.get("empty"), 0)).intValue() + 1));
                        }
                        hashMap.put("pkg", hashMapArr2[length].get("pkg"));
                        hashMap.put("name", hashMapArr2[length].get("name"));
                        hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, hashMapArr2[length].get(GameAppOperation.QQFAV_DATALINE_VERSION));
                    }
                    length--;
                }
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, Integer> m6048a(ArrayList<ArrayList<HashMap<String, String>>> arrayList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator<ArrayList<HashMap<String, String>>> it2 = arrayList.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Iterator<HashMap<String, String>> it3 = it2.next().iterator();
            int i2 = i;
            while (it3.hasNext()) {
                HashMap<String, String> next = it3.next();
                String str = next.get("pkg") + ":" + next.get(GameAppOperation.QQFAV_DATALINE_VERSION);
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, Integer.valueOf(i2));
                    i2++;
                }
            }
            i = i2;
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m6054a() {
        Thread thread = new Thread() { // from class: com.mob.commons.clt.RtClt.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                C4145d.m6037a(new File(ResHelper.getCacheRoot(RtClt.this.f17304c), "comm/locks/.rc_lock"), new LockAction() { // from class: com.mob.commons.clt.RtClt.1.1
                    @Override // com.mob.commons.LockAction
                    public boolean run(FileLocker fileLocker) {
                        if (C4134c.m6090a(RtClt.this.f17304c, "comm/tags/.rcTag")) {
                            return false;
                        }
                        RtClt.this.m6044b();
                        return true;
                    }
                });
            }
        };
        thread.setPriority(1);
        thread.start();
    }

    /* renamed from: a */
    private void m6050a(String str, ArrayList<ArrayList<HashMap<String, String>>> arrayList, ArrayList<long[]> arrayList2) {
        try {
            HashMap<String, String[]> m6038e = m6038e();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "utf-8"));
            String readLine = bufferedReader.readLine();
            for (int i = 0; i < 7; i++) {
                readLine = bufferedReader.readLine();
            }
            ArrayList<HashMap<String, String>> arrayList3 = new ArrayList<>();
            while (readLine != null) {
                if ("======================".equals(readLine)) {
                    try {
                        String[] split = bufferedReader.readLine().split("_");
                        long[] jArr = {Long.valueOf(split[0]).longValue(), Long.valueOf(split[1]).longValue()};
                        arrayList.add(arrayList3);
                        arrayList2.add(jArr);
                    } catch (Throwable th) {
                    }
                    arrayList3 = new ArrayList<>();
                    for (int i2 = 0; i2 < 7; i2++) {
                        bufferedReader.readLine();
                    }
                } else if (readLine.length() > 0) {
                    m6049a(readLine, m6038e, arrayList3);
                }
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Throwable th2) {
            MobLog.getInstance().m5971d(th2);
        }
    }

    /* renamed from: a */
    private void m6049a(String str, HashMap<String, String[]> hashMap, ArrayList<HashMap<String, String>> arrayList) {
        String[] strArr;
        String[] split = str.replaceAll(" +", " ").split(" ");
        if (split == null || split.length < 10) {
            return;
        }
        String str2 = split[split.length - 1];
        if (!split[split.length - 2].matches(f17302a) || "top".equals(str2) || (strArr = hashMap.get(str2)) == null) {
            return;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("pkg", str2);
        hashMap2.put("name", strArr[0]);
        hashMap2.put(GameAppOperation.QQFAV_DATALINE_VERSION, strArr[1]);
        hashMap2.put("pcy", split[split.length - 3]);
        arrayList.add(hashMap2);
    }

    /* renamed from: a */
    private void m6047a(ArrayList<HashMap<String, Object>> arrayList, ArrayList<long[]> arrayList2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", "APP_RUNTIMES");
        hashMap.put("list", arrayList);
        hashMap.put("datatime", Long.valueOf(C4125a.m6143a(this.f17304c)));
        hashMap.put("recordat", Long.valueOf(arrayList2.get(0)[0]));
        long j = 0;
        for (int i = 1; i < arrayList2.size(); i++) {
            j += arrayList2.get(i)[1];
        }
        hashMap.put("sdk_runtime_len", Long.valueOf(j));
        hashMap.put("top_count", Integer.valueOf(arrayList2.size()));
        C4131b.m6103a(this.f17304c).m6104a(C4125a.m6143a(this.f17304c), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6051a(String str) {
        ArrayList<ArrayList<HashMap<String, String>>> arrayList = new ArrayList<>();
        ArrayList<long[]> arrayList2 = new ArrayList<>();
        m6050a(str, arrayList, arrayList2);
        m6047a(m6045a(m6046a(m6048a(arrayList), arrayList), arrayList2), arrayList2);
        return m6042b(str);
    }

    /* renamed from: a */
    private HashMap<String, String>[][] m6046a(HashMap<String, Integer> hashMap, ArrayList<ArrayList<HashMap<String, String>>> arrayList) {
        HashMap<String, String> hashMap2;
        HashMap<String, String>[][] hashMapArr = (HashMap[][]) Array.newInstance(HashMap.class, hashMap.size(), arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArrayList<HashMap<String, String>> arrayList2 = arrayList.get(i);
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                hashMapArr[hashMap.get(hashMap2.get("pkg") + ":" + hashMap2.get(GameAppOperation.QQFAV_DATALINE_VERSION)).intValue()][i] = arrayList2.get(i2);
            }
        }
        return hashMapArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6044b() {
        Process process;
        OutputStream outputStream = null;
        try {
            final File file = new File(ResHelper.getCacheRoot(this.f17304c), "comm/dbs/.plst");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            final String absolutePath = file.getAbsolutePath();
            long m6041c = m6041c();
            C4134c.m6089b(this.f17304c, "comm/tags/.rcTag");
            try {
                process = Runtime.getRuntime().exec("sh");
                try {
                    outputStream = process.getOutputStream();
                } catch (Throwable th) {
                    th = th;
                    MobLog.getInstance().m5959w(th);
                    C4134c.m6088c(this.f17304c, "comm/tags/.rcTag");
                    final HashMap hashMap = new HashMap();
                    hashMap.put("nextUploadTime", Long.valueOf(m6041c));
                    hashMap.put("p", process);
                    hashMap.put("os", outputStream);
                    hashMap.put("firstLog", true);
                    new MobLooper(this.f17304c).start(new Runnable() { // from class: com.mob.commons.clt.RtClt.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            long j;
                            try {
                                if (!C4125a.m6139b(RtClt.this.f17304c)) {
                                    return;
                                }
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                long m6143a = C4125a.m6143a(RtClt.this.f17304c);
                                OutputStream outputStream2 = (OutputStream) hashMap.get("os");
                                outputStream2.write(("top -d 0 -n 1 | grep -E -v 'root|shell|system' >> " + absolutePath + " && echo \"======================\" >> " + absolutePath + "\n").getBytes("ascii"));
                                if (String.valueOf(hashMap.get("firstLog")).equals("true")) {
                                    str = "echo \"" + m6143a + "_0\" >> " + absolutePath + "\n";
                                    hashMap.put("firstLog", false);
                                } else {
                                    str = "echo \"" + m6143a + "_" + C4125a.m6137c(RtClt.this.f17304c) + "\" >> " + absolutePath + "\n";
                                }
                                outputStream2.write(str.getBytes("ascii"));
                                outputStream2.flush();
                                try {
                                    j = Long.parseLong(String.valueOf(hashMap.get("nextUploadTime")));
                                } catch (Throwable th2) {
                                    j = 0;
                                }
                                if (m6143a < j) {
                                    return;
                                }
                                outputStream2.write("exit\n".getBytes("ascii"));
                                outputStream2.flush();
                                outputStream2.close();
                                Process process2 = (Process) hashMap.get("p");
                                process2.waitFor();
                                process2.destroy();
                                if (RtClt.this.m6051a(absolutePath)) {
                                    long m6039d = RtClt.this.m6039d();
                                    if (m6039d > 0) {
                                        hashMap.put("nextUploadTime", Long.valueOf(m6039d));
                                    }
                                    hashMap.put("firstLog", true);
                                }
                                C4134c.m6089b(RtClt.this.f17304c, "comm/tags/.rcTag");
                                Process exec = Runtime.getRuntime().exec("sh");
                                hashMap.put("p", exec);
                                hashMap.put("os", exec.getOutputStream());
                                C4134c.m6088c(RtClt.this.f17304c, "comm/tags/.rcTag");
                            } catch (Throwable th3) {
                                MobLog.getInstance().m5971d(th3);
                            }
                        }
                    }, C4125a.m6137c(this.f17304c) * 1000);
                }
            } catch (Throwable th2) {
                th = th2;
                process = null;
            }
            C4134c.m6088c(this.f17304c, "comm/tags/.rcTag");
            final HashMap hashMap2 = new HashMap();
            hashMap2.put("nextUploadTime", Long.valueOf(m6041c));
            hashMap2.put("p", process);
            hashMap2.put("os", outputStream);
            hashMap2.put("firstLog", true);
            new MobLooper(this.f17304c).start(new Runnable() { // from class: com.mob.commons.clt.RtClt.2
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    long j;
                    try {
                        if (!C4125a.m6139b(RtClt.this.f17304c)) {
                            return;
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        long m6143a = C4125a.m6143a(RtClt.this.f17304c);
                        OutputStream outputStream2 = (OutputStream) hashMap2.get("os");
                        outputStream2.write(("top -d 0 -n 1 | grep -E -v 'root|shell|system' >> " + absolutePath + " && echo \"======================\" >> " + absolutePath + "\n").getBytes("ascii"));
                        if (String.valueOf(hashMap2.get("firstLog")).equals("true")) {
                            str = "echo \"" + m6143a + "_0\" >> " + absolutePath + "\n";
                            hashMap2.put("firstLog", false);
                        } else {
                            str = "echo \"" + m6143a + "_" + C4125a.m6137c(RtClt.this.f17304c) + "\" >> " + absolutePath + "\n";
                        }
                        outputStream2.write(str.getBytes("ascii"));
                        outputStream2.flush();
                        try {
                            j = Long.parseLong(String.valueOf(hashMap2.get("nextUploadTime")));
                        } catch (Throwable th22) {
                            j = 0;
                        }
                        if (m6143a < j) {
                            return;
                        }
                        outputStream2.write("exit\n".getBytes("ascii"));
                        outputStream2.flush();
                        outputStream2.close();
                        Process process2 = (Process) hashMap2.get("p");
                        process2.waitFor();
                        process2.destroy();
                        if (RtClt.this.m6051a(absolutePath)) {
                            long m6039d = RtClt.this.m6039d();
                            if (m6039d > 0) {
                                hashMap2.put("nextUploadTime", Long.valueOf(m6039d));
                            }
                            hashMap2.put("firstLog", true);
                        }
                        C4134c.m6089b(RtClt.this.f17304c, "comm/tags/.rcTag");
                        Process exec = Runtime.getRuntime().exec("sh");
                        hashMap2.put("p", exec);
                        hashMap2.put("os", exec.getOutputStream());
                        C4134c.m6088c(RtClt.this.f17304c, "comm/tags/.rcTag");
                    } catch (Throwable th3) {
                        MobLog.getInstance().m5971d(th3);
                    }
                }
            }, C4125a.m6137c(this.f17304c) * 1000);
        } catch (Throwable th3) {
        }
    }

    /* renamed from: b */
    private boolean m6042b(String str) {
        try {
            File file = new File(str);
            file.delete();
            file.createNewFile();
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return false;
        }
    }

    /* renamed from: c */
    private long m6041c() {
        long m6143a = C4125a.m6143a(this.f17304c);
        try {
            File file = new File(ResHelper.getCacheRoot(this.f17304c), "comm/dbs/.nulplt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
                m6039d();
                return m6143a + Util.MILLSECONDS_OF_DAY;
            }
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            long readLong = dataInputStream.readLong();
            dataInputStream.close();
            return readLong;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return m6143a + Util.MILLSECONDS_OF_DAY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public long m6039d() {
        long m6143a = C4125a.m6143a(this.f17304c) + Util.MILLSECONDS_OF_DAY;
        try {
            File file = new File(ResHelper.getCacheRoot(this.f17304c), "comm/dbs/.nulplt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(m6143a);
            dataOutputStream.flush();
            dataOutputStream.close();
            return m6143a;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return 0L;
        }
    }

    /* renamed from: e */
    private HashMap<String, String[]> m6038e() {
        ArrayList arrayList;
        try {
            arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17304c), "getInstalledApp", false);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            arrayList = new ArrayList();
        }
        HashMap<String, String[]> hashMap = new HashMap<>();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HashMap hashMap2 = (HashMap) it2.next();
            hashMap.put((String) hashMap2.get("pkg"), new String[]{(String) hashMap2.get("name"), (String) hashMap2.get(GameAppOperation.QQFAV_DATALINE_VERSION)});
        }
        return hashMap;
    }

    public static synchronized void startCollector(Context context) {
        synchronized (RtClt.class) {
            if (f17303b == null) {
                f17303b = new RtClt(context);
                f17303b.m6054a();
            }
        }
    }

    public static synchronized void startCollector(Context context, String str) {
        synchronized (RtClt.class) {
            startCollector(context);
        }
    }
}
