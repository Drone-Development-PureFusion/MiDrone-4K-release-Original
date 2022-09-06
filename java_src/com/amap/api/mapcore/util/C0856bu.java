package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.tencent.open.GameAppOperation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.bu */
/* loaded from: classes.dex */
public class C0856bu {
    /* renamed from: a */
    public static long m18757a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getFreeBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    /* renamed from: a */
    public static long m18755a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        long j = 0;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            j += file2.isDirectory() ? m18755a(file2) : file2.length();
        }
        return j;
    }

    /* renamed from: a */
    public static OfflineMapProvince m18752a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(m18750a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(m18750a(jSONObject, "name"));
        offlineMapProvince.setJianpin(m18750a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(m18750a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(m18744c(m18750a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(m18750a(jSONObject, GameAppOperation.QQFAV_DATALINE_VERSION));
        offlineMapProvince.setSize(Long.parseLong(m18750a(jSONObject, "size")));
        offlineMapProvince.setCityList(m18746b(jSONObject));
        return offlineMapProvince;
    }

    /* renamed from: a */
    public static String m18756a(Context context, String str) {
        try {
            return C0945eh.m18334a(C0943ef.m18372a(context).open(str));
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m18750a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str).trim() : "";
    }

    /* renamed from: a */
    public static List<OfflineMapProvince> m18753a(String str, Context context) {
        return (str == null || "".equals(str)) ? new ArrayList() : m18751a(new JSONObject(str), context);
    }

    /* renamed from: a */
    public static List<OfflineMapProvince> m18751a(JSONObject jSONObject, Context context) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                m18743c(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (JSONException e) {
                optJSONObject = jSONObject.optJSONObject("result");
                C1007fo.m18012b(e, "Utility", "parseJson");
                e.printStackTrace();
            }
        } else {
            optJSONObject = jSONObject.optJSONObject("result");
        }
        if (optJSONObject != null) {
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject3 == null) {
                return arrayList;
            }
            optJSONObject2 = optJSONObject3.optJSONObject("offlinemapinfo_with_province");
        } else {
            optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has(GameAppOperation.QQFAV_DATALINE_VERSION)) {
            C0794ax.f2157d = m18750a(optJSONObject2, GameAppOperation.QQFAV_DATALINE_VERSION);
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
            if (optJSONObject4 != null) {
                arrayList.add(m18752a(optJSONObject4));
            }
        }
        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
        JSONObject jSONObject3 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject3 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        arrayList.add(m18752a(jSONObject3));
        return arrayList;
    }

    /* renamed from: a */
    public static void m18754a(String str) {
    }

    /* renamed from: b */
    public static ArrayList<OfflineMapCity> m18746b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(m18742c(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m18742c(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m18748b(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.exists() && file2.isDirectory()) {
                String[] list = file2.list();
                if (list == null) {
                    file2.delete();
                } else if (list.length == 0) {
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: b */
    public static void m18747b(String str, Context context) {
        File[] listFiles = new File(C0945eh.m18318b(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                m18749b(file);
            }
        }
        m18748b(C0945eh.m18318b(context));
    }

    /* renamed from: b */
    public static boolean m18749b(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!m18749b(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: c */
    public static OfflineMapCity m18742c(JSONObject jSONObject) {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(m18744c(m18750a(jSONObject, "adcode")));
        offlineMapCity.setUrl(m18750a(jSONObject, "url"));
        offlineMapCity.setCity(m18750a(jSONObject, "name"));
        offlineMapCity.setCode(m18750a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(m18750a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(m18750a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(m18750a(jSONObject, GameAppOperation.QQFAV_DATALINE_VERSION));
        offlineMapCity.setSize(Long.parseLong(m18750a(jSONObject, "size")));
        return offlineMapCity;
    }

    /* renamed from: c */
    public static String m18745c(File file) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader2;
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e) {
            e = e;
            bufferedReader2 = null;
            fileInputStream = null;
        } catch (IOException e2) {
            e = e2;
            bufferedReader2 = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            fileInputStream = null;
            th = th3;
        }
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    C1007fo.m18012b(e, "MapDownloadManager", "readOfflineSD filenotfound");
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return str;
                } catch (IOException e6) {
                    e = e6;
                    C1007fo.m18012b(e, "MapDownloadManager", "readOfflineSD io");
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    return str;
                }
            }
            str = stringBuffer.toString();
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
        } catch (FileNotFoundException e11) {
            e = e11;
            bufferedReader2 = null;
        } catch (IOException e12) {
            e = e12;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            throw th;
        }
        return str;
    }

    /* renamed from: c */
    private static String m18744c(String str) {
        return str.equals("000001") ? "100000" : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m18743c(String str, Context context) {
        FileOutputStream fileOutputStream;
        if (C0945eh.m18318b(context).equals("")) {
            return;
        }
        File file = new File(C0945eh.m18318b(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                C1007fo.m18012b(e, "OfflineUpdateCityHandler", "writeSD dirCreate");
                e.printStackTrace();
            }
        }
        ?? r1 = (m18757a() > 1048576L ? 1 : (m18757a() == 1048576L ? 0 : -1));
        if (r1 <= 0) {
            return;
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str.getBytes("utf-8"));
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            r1 = fileOutputStream;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    C1007fo.m18012b(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                    e.printStackTrace();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            r1 = fileOutputStream;
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                    C1007fo.m18012b(e, "OfflineUpdateCityHandler", "writeSD io");
                    e.printStackTrace();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            r1 = fileOutputStream;
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            fileOutputStream = null;
        } catch (IOException e9) {
            e = e9;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            if (r1 != 0) {
            }
            throw th;
        }
    }
}
