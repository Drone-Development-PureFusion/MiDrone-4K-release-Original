package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.tencent.open.GameAppOperation;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;
@AbstractC1017fv(m17950a = "update_item", m17949b = true)
/* renamed from: com.amap.api.mapcore.util.bh */
/* loaded from: classes.dex */
public class C0837bh extends C0840bk {

    /* renamed from: n */
    private String f2340n = "";

    /* renamed from: o */
    private Context f2341o;

    public C0837bh() {
    }

    public C0837bh(OfflineMapCity offlineMapCity, Context context) {
        this.f2341o = context;
        this.f2349a = offlineMapCity.getCity();
        this.f2351c = offlineMapCity.getAdcode();
        this.f2350b = offlineMapCity.getUrl();
        this.f2355g = offlineMapCity.getSize();
        this.f2353e = offlineMapCity.getVersion();
        this.f2359k = offlineMapCity.getCode();
        this.f2357i = 0;
        this.f2360l = offlineMapCity.getState();
        this.f2358j = offlineMapCity.getcompleteCode();
        this.f2361m = offlineMapCity.getPinyin();
        m18840a();
    }

    public C0837bh(OfflineMapProvince offlineMapProvince, Context context) {
        this.f2341o = context;
        this.f2349a = offlineMapProvince.getProvinceName();
        this.f2351c = offlineMapProvince.getProvinceCode();
        this.f2350b = offlineMapProvince.getUrl();
        this.f2355g = offlineMapProvince.getSize();
        this.f2353e = offlineMapProvince.getVersion();
        this.f2357i = 1;
        this.f2360l = offlineMapProvince.getState();
        this.f2358j = offlineMapProvince.getcompleteCode();
        this.f2361m = offlineMapProvince.getPinyin();
        m18840a();
    }

    /* renamed from: a */
    public static String m18838a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str).trim() : "";
    }

    /* renamed from: a */
    protected void m18840a() {
        this.f2352d = C0945eh.m18318b(this.f2341o) + this.f2361m + ".zip.tmp";
    }

    /* renamed from: a */
    public void m18839a(String str) {
        this.f2340n = str;
    }

    /* renamed from: b */
    public String m18837b() {
        return this.f2340n;
    }

    /* renamed from: b */
    public void m18836b(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if (str.equals("") || (jSONObject = new JSONObject(str).getJSONObject("file")) == null) {
                    return;
                }
                this.f2349a = jSONObject.optString("title");
                this.f2351c = jSONObject.optString(XiaomiOAuthConstants.EXTRA_CODE_2);
                this.f2350b = jSONObject.optString("url");
                this.f2352d = jSONObject.optString("fileName");
                this.f2354f = jSONObject.optLong("lLocalLength");
                this.f2355g = jSONObject.optLong("lRemoteLength");
                this.f2360l = jSONObject.optInt("mState");
                this.f2353e = jSONObject.optString(GameAppOperation.QQFAV_DATALINE_VERSION);
                this.f2356h = jSONObject.optString("localPath");
                this.f2340n = jSONObject.optString("vMapFileNames");
                this.f2357i = jSONObject.optInt("isSheng");
                this.f2358j = jSONObject.optInt("mCompleteCode");
                this.f2359k = jSONObject.optString("mCityCode");
                this.f2361m = m18838a(jSONObject, "pinyin");
                if (!this.f2361m.equals("")) {
                    return;
                }
                String substring = this.f2350b.substring(this.f2350b.lastIndexOf("/") + 1);
                this.f2361m = substring.substring(0, substring.lastIndexOf("."));
            } catch (JSONException e) {
                C1007fo.m18012b(e, "UpdateItem", "readFileToJSONObject");
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.OutputStreamWriter] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m18835c() {
        OutputStreamWriter outputStreamWriter;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f2349a);
            jSONObject2.put(XiaomiOAuthConstants.EXTRA_CODE_2, this.f2351c);
            jSONObject2.put("url", this.f2350b);
            jSONObject2.put("fileName", this.f2352d);
            jSONObject2.put("lLocalLength", this.f2354f);
            jSONObject2.put("lRemoteLength", this.f2355g);
            jSONObject2.put("mState", this.f2360l);
            jSONObject2.put(GameAppOperation.QQFAV_DATALINE_VERSION, this.f2353e);
            jSONObject2.put("localPath", this.f2356h);
            if (this.f2340n != null) {
                jSONObject2.put("vMapFileNames", this.f2340n);
            }
            jSONObject2.put("isSheng", this.f2357i);
            jSONObject2.put("mCompleteCode", this.f2358j);
            jSONObject2.put("mCityCode", this.f2359k);
            jSONObject2.put("pinyin", this.f2361m);
            jSONObject.put("file", jSONObject2);
            String str = this.f2352d + ".dt";
            File file = new File(str);
            file.delete();
            try {
                try {
                    outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                    try {
                        outputStreamWriter.write(jSONObject.toString());
                        str = outputStreamWriter;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                                str = outputStreamWriter;
                            } catch (IOException e) {
                                e.printStackTrace();
                                str = outputStreamWriter;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        C1007fo.m18012b(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        str = outputStreamWriter;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                                str = outputStreamWriter;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                str = outputStreamWriter;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                outputStreamWriter = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                if (str != 0) {
                }
                throw th;
            }
        } catch (JSONException e6) {
            C1007fo.m18012b(e6, "UpdateItem", "saveJSONObjectToFile parseJson");
            e6.printStackTrace();
        }
    }
}
