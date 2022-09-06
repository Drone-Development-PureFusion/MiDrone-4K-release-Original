package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.p228a.C4331f;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class OpenConfig {

    /* renamed from: a */
    private static HashMap<String, OpenConfig> f18201a = null;

    /* renamed from: b */
    private static String f18202b = null;

    /* renamed from: c */
    private Context f18203c;

    /* renamed from: d */
    private String f18204d;

    /* renamed from: e */
    private JSONObject f18205e = null;

    /* renamed from: f */
    private long f18206f = 0;

    /* renamed from: g */
    private int f18207g = 0;

    /* renamed from: h */
    private boolean f18208h = true;

    private OpenConfig(Context context, String str) {
        this.f18203c = null;
        this.f18204d = null;
        this.f18203c = context.getApplicationContext();
        this.f18204d = str;
        m5360a();
        m5353b();
    }

    /* renamed from: a */
    private String m5356a(String str) {
        InputStream open;
        try {
            open = this.f18203c.openFileInput(this.f18204d != null ? str + "." + this.f18204d : str);
        } catch (FileNotFoundException e) {
            try {
                open = this.f18203c.getAssets().open(str);
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            return stringBuffer2;
                        } catch (IOException e3) {
                            return stringBuffer2;
                        }
                    }
                    stringBuffer.append(readLine);
                } catch (IOException e4) {
                    e4.printStackTrace();
                    try {
                        open.close();
                        bufferedReader.close();
                        return "";
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return "";
                    }
                }
            } finally {
                try {
                    open.close();
                    bufferedReader.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private void m5360a() {
        try {
            this.f18205e = new JSONObject(m5356a("com.tencent.open.config.json"));
        } catch (JSONException e) {
            this.f18205e = new JSONObject();
        }
    }

    /* renamed from: a */
    private void m5355a(String str, String str2) {
        try {
            if (this.f18204d != null) {
                str = str + "." + this.f18204d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f18203c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5354a(JSONObject jSONObject) {
        m5352b("cgi back, do update");
        this.f18205e = jSONObject;
        m5355a("com.tencent.open.config.json", jSONObject.toString());
        this.f18206f = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.tencent.open.utils.OpenConfig$1] */
    /* renamed from: b */
    private void m5353b() {
        if (this.f18207g != 0) {
            m5352b("update thread is running, return");
            return;
        }
        this.f18207g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.f18204d);
        bundle.putString("appid_for_getting_config", this.f18204d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.OpenConfig.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    OpenConfig.this.m5354a(Util.parseJson(HttpUtils.openUrl2(OpenConfig.this.f18203c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).response));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                OpenConfig.this.f18207g = 0;
            }
        }.start();
    }

    /* renamed from: b */
    private void m5352b(String str) {
        if (this.f18208h) {
            C4331f.m5445b("OpenConfig", str + "; appid: " + this.f18204d);
        }
    }

    /* renamed from: c */
    private void m5351c() {
        int optInt = this.f18205e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f18206f >= optInt * C0359h.f695Y) {
            m5353b();
        }
    }

    public static OpenConfig getInstance(Context context, String str) {
        if (f18201a == null) {
            f18201a = new HashMap<>();
        }
        if (str != null) {
            f18202b = str;
        }
        if (str == null) {
            str = f18202b != null ? f18202b : "0";
        }
        OpenConfig openConfig = f18201a.get(str);
        if (openConfig == null) {
            OpenConfig openConfig2 = new OpenConfig(context, str);
            f18201a.put(str, openConfig2);
            return openConfig2;
        }
        return openConfig;
    }

    public boolean getBoolean(String str) {
        m5352b("get " + str);
        m5351c();
        Object opt = this.f18205e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        } else if (!(opt instanceof Boolean)) {
            return false;
        } else {
            return ((Boolean) opt).booleanValue();
        }
    }

    public int getInt(String str) {
        m5352b("get " + str);
        m5351c();
        return this.f18205e.optInt(str);
    }

    public long getLong(String str) {
        m5352b("get " + str);
        m5351c();
        return this.f18205e.optLong(str);
    }
}
