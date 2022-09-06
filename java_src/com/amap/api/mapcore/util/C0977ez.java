package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.open.GameAppOperation;
import com.tencent.stat.DeviceInfo;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.amap.api.mapcore.util.ez */
/* loaded from: classes.dex */
public class C0977ez {

    /* renamed from: a */
    public static int f3050a = -1;

    /* renamed from: b */
    public static String f3051b = "";

    /* renamed from: com.amap.api.mapcore.util.ez$a */
    /* loaded from: classes.dex */
    public static class C0978a {

        /* renamed from: a */
        public String f3052a;

        /* renamed from: b */
        public int f3053b = -1;

        /* renamed from: c */
        public JSONObject f3054c;

        /* renamed from: d */
        public JSONObject f3055d;

        /* renamed from: e */
        public JSONObject f3056e;

        /* renamed from: f */
        public JSONObject f3057f;

        /* renamed from: g */
        public JSONObject f3058g;

        /* renamed from: h */
        public JSONObject f3059h;

        /* renamed from: i */
        public JSONObject f3060i;

        /* renamed from: j */
        public JSONObject f3061j;

        /* renamed from: k */
        public JSONObject f3062k;

        /* renamed from: l */
        public JSONObject f3063l;

        /* renamed from: m */
        public JSONObject f3064m;

        /* renamed from: n */
        public JSONObject f3065n;

        /* renamed from: o */
        public JSONObject f3066o;

        /* renamed from: p */
        public C0979a f3067p;

        /* renamed from: q */
        public C0982d f3068q;

        /* renamed from: r */
        public C0981c f3069r;

        /* renamed from: s */
        public C0980b f3070s;

        /* renamed from: t */
        public C0980b f3071t;

        /* renamed from: u */
        public C0980b f3072u;

        /* renamed from: v */
        public C0980b f3073v;

        /* renamed from: com.amap.api.mapcore.util.ez$a$a */
        /* loaded from: classes.dex */
        public static class C0979a {

            /* renamed from: a */
            public boolean f3074a;

            /* renamed from: b */
            public boolean f3075b;
        }

        /* renamed from: com.amap.api.mapcore.util.ez$a$b */
        /* loaded from: classes.dex */
        public static class C0980b {

            /* renamed from: a */
            public boolean f3076a;

            /* renamed from: b */
            public String f3077b;

            /* renamed from: c */
            public String f3078c;

            /* renamed from: d */
            public String f3079d;
        }

        /* renamed from: com.amap.api.mapcore.util.ez$a$c */
        /* loaded from: classes.dex */
        public static class C0981c {

            /* renamed from: a */
            public String f3080a;

            /* renamed from: b */
            public String f3081b;
        }

        /* renamed from: com.amap.api.mapcore.util.ez$a$d */
        /* loaded from: classes.dex */
        public static class C0982d {

            /* renamed from: a */
            public String f3082a;

            /* renamed from: b */
            public String f3083b;

            /* renamed from: c */
            public String f3084c;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ez$b */
    /* loaded from: classes.dex */
    static class C0983b extends AbstractC1059gy {

        /* renamed from: c */
        private String f3085c;

        /* renamed from: d */
        private Map<String, String> f3086d;

        C0983b(Context context, C0996fh c0996fh, String str, Map<String, String> map) {
            super(context, c0996fh);
            this.f3085c = str;
            this.f3086d = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00aa  */
        /* renamed from: m */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Map<String, String> m18158m() {
            String str;
            String m18113q = C0989fc.m18113q(this.f3310a);
            if (!TextUtils.isEmpty(m18113q)) {
                m18113q = C0992fe.m18092b(new StringBuilder(m18113q).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.f3085c);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.f3311b.m18074a());
            hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, this.f3311b.m18070b());
            hashMap.put("output", "json");
            hashMap.put("androidversion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceId", m18113q);
            if (this.f3086d != null && !this.f3086d.isEmpty()) {
                hashMap.putAll(this.f3086d);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    ApplicationInfo applicationInfo = this.f3310a.getApplicationInfo();
                    Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                    declaredField.setAccessible(true);
                    str = (String) declaredField.get(applicationInfo);
                } catch (Throwable th) {
                    C1002fl.m18028a(th, "ConfigManager", "getcpu");
                }
                if (TextUtils.isEmpty(str)) {
                    str = Build.CPU_ABI;
                }
                hashMap.put("abitype", str);
                hashMap.put("ext", this.f3311b.m18066e());
                return hashMap;
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
            hashMap.put("abitype", str);
            hashMap.put("ext", this.f3311b.m18066e());
            return hashMap;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: a */
        public Map<String, String> mo17702a() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: c */
        public String mo17697c() {
            return "https://restapi.amap.com/v3/iasdkauth";
        }

        @Override // com.amap.api.mapcore.util.AbstractC1059gy
        /* renamed from: d */
        public byte[] mo17765d() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1059gy
        /* renamed from: e */
        public byte[] mo17764e() {
            return C0999fi.m18047a(C0999fi.m18045a(m18158m()));
        }

        @Override // com.amap.api.mapcore.util.AbstractC1059gy
        /* renamed from: f */
        protected String mo17763f() {
            return "3.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0978a m18164a(Context context, C0996fh c0996fh, String str, Map<String, String> map) {
        C1077hf c1077hf;
        byte[] bArr;
        String str2;
        C1077hf c1077hf2;
        byte[] bArr2;
        String str3;
        String str4;
        List<String> list;
        C0978a c0978a = new C0978a();
        try {
            try {
                try {
                    c1077hf = new C1057gx().m17769a(new C0983b(context, c0996fh, str, map), true);
                    if (c1077hf != null) {
                        try {
                            bArr = c1077hf.f3370a;
                        } catch (C0975ex e) {
                            e = e;
                            bArr = null;
                            c0978a.f3052a = e.m18175a();
                            str2 = null;
                            byte[] bArr3 = bArr;
                            c1077hf2 = c1077hf;
                            bArr2 = bArr3;
                            if (bArr2 == null) {
                            }
                        } catch (IllegalBlockSizeException e2) {
                            bArr = null;
                            str2 = null;
                            byte[] bArr4 = bArr;
                            c1077hf2 = c1077hf;
                            bArr2 = bArr4;
                            if (bArr2 == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            bArr = null;
                            C1002fl.m18028a(th, "ConfigManager", "loadConfig");
                            str2 = null;
                            byte[] bArr5 = bArr;
                            c1077hf2 = c1077hf;
                            bArr2 = bArr5;
                            if (bArr2 == null) {
                            }
                        }
                    } else {
                        bArr = null;
                    }
                } catch (C0975ex e3) {
                    throw e3;
                } catch (Throwable th2) {
                    throw new C0975ex("未知的错误");
                }
            } catch (C0975ex e4) {
                e = e4;
                c1077hf = null;
                bArr = null;
            } catch (Throwable th3) {
                th = th3;
                c1077hf = null;
                bArr = null;
            }
        } catch (IllegalBlockSizeException e5) {
            c1077hf = null;
            bArr = null;
        }
        try {
            byte[] bArr6 = new byte[16];
            byte[] bArr7 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr6, 0, 16);
            System.arraycopy(bArr, 16, bArr7, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr6, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(C0999fi.m18053a()));
            str2 = C0999fi.m18043a(cipher.doFinal(bArr7));
            byte[] bArr8 = bArr;
            c1077hf2 = c1077hf;
            bArr2 = bArr8;
        } catch (C0975ex e6) {
            e = e6;
            c0978a.f3052a = e.m18175a();
            str2 = null;
            byte[] bArr32 = bArr;
            c1077hf2 = c1077hf;
            bArr2 = bArr32;
            if (bArr2 == null) {
            }
        } catch (IllegalBlockSizeException e7) {
            str2 = null;
            byte[] bArr42 = bArr;
            c1077hf2 = c1077hf;
            bArr2 = bArr42;
            if (bArr2 == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            C1002fl.m18028a(th, "ConfigManager", "loadConfig");
            str2 = null;
            byte[] bArr52 = bArr;
            c1077hf2 = c1077hf;
            bArr2 = bArr52;
            if (bArr2 == null) {
            }
        }
        if (bArr2 == null) {
            return c0978a;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = C0999fi.m18043a(bArr2);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f3050a = 1;
                } else if (i == 0) {
                    if (c1077hf2 != null) {
                        String str5 = c1077hf2.f3372c;
                        if (c1077hf2.f3371b == null || (list = c1077hf2.f3371b.get("gsid")) == null || list.size() <= 0) {
                            str4 = "authgsid";
                            str3 = str5;
                        } else {
                            str4 = list.get(0);
                            str3 = str5;
                        }
                    } else {
                        str3 = "authcsid";
                        str4 = "authgsid";
                    }
                    C0999fi.m18050a(context, str3, str4, jSONObject.toString());
                    f3050a = 0;
                    if (jSONObject.has("info")) {
                        f3051b = jSONObject.getString("info");
                    }
                    if (f3050a == 0) {
                        c0978a.f3052a = f3051b;
                        return c0978a;
                    }
                }
                if (jSONObject.has(DeviceInfo.TAG_VERSION)) {
                    c0978a.f3053b = jSONObject.getInt(DeviceInfo.TAG_VERSION);
                }
                if (C0999fi.m18044a(jSONObject, "result")) {
                    C0978a.C0979a c0979a = new C0978a.C0979a();
                    c0979a.f3074a = false;
                    c0979a.f3075b = false;
                    c0978a.f3067p = c0979a;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                    if (C0999fi.m18044a(jSONObject2, "11K")) {
                        c0979a.f3074a = m18163a(jSONObject2.getJSONObject("11K").getString("able"), false);
                    }
                    if (C0999fi.m18044a(jSONObject2, "11B")) {
                        c0978a.f3055d = jSONObject2.getJSONObject("11B");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11C")) {
                        c0978a.f3058g = jSONObject2.getJSONObject("11C");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11I")) {
                        c0978a.f3059h = jSONObject2.getJSONObject("11I");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11H")) {
                        c0978a.f3060i = jSONObject2.getJSONObject("11H");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11E")) {
                        c0978a.f3061j = jSONObject2.getJSONObject("11E");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11F")) {
                        c0978a.f3062k = jSONObject2.getJSONObject("11F");
                    }
                    if (C0999fi.m18044a(jSONObject2, "13A")) {
                        c0978a.f3064m = jSONObject2.getJSONObject("13A");
                    }
                    if (C0999fi.m18044a(jSONObject2, "13J")) {
                        c0978a.f3056e = jSONObject2.getJSONObject("13J");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11G")) {
                        c0978a.f3063l = jSONObject2.getJSONObject("11G");
                    }
                    if (C0999fi.m18044a(jSONObject2, "001")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("001");
                        C0978a.C0982d c0982d = new C0978a.C0982d();
                        m18160a(jSONObject3, c0982d);
                        c0978a.f3068q = c0982d;
                    }
                    if (C0999fi.m18044a(jSONObject2, "002")) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("002");
                        C0978a.C0981c c0981c = new C0978a.C0981c();
                        m18161a(jSONObject4, c0981c);
                        c0978a.f3069r = c0981c;
                    }
                    if (C0999fi.m18044a(jSONObject2, "006")) {
                        c0978a.f3065n = jSONObject2.getJSONObject("006");
                    }
                    if (C0999fi.m18044a(jSONObject2, "010")) {
                        c0978a.f3066o = jSONObject2.getJSONObject("010");
                    }
                    if (C0999fi.m18044a(jSONObject2, "11Z")) {
                        JSONObject jSONObject5 = jSONObject2.getJSONObject("11Z");
                        C0978a.C0980b c0980b = new C0978a.C0980b();
                        m18162a(jSONObject5, c0980b);
                        c0978a.f3070s = c0980b;
                    }
                    if (C0999fi.m18044a(jSONObject2, "135")) {
                        c0978a.f3057f = jSONObject2.getJSONObject("135");
                    }
                    if (C0999fi.m18044a(jSONObject2, "13S")) {
                        c0978a.f3054c = jSONObject2.getJSONObject("13S");
                    }
                    if (C0999fi.m18044a(jSONObject2, "121")) {
                        JSONObject jSONObject6 = jSONObject2.getJSONObject("121");
                        C0978a.C0980b c0980b2 = new C0978a.C0980b();
                        m18162a(jSONObject6, c0980b2);
                        c0978a.f3071t = c0980b2;
                    }
                    if (C0999fi.m18044a(jSONObject2, "122")) {
                        JSONObject jSONObject7 = jSONObject2.getJSONObject("122");
                        C0978a.C0980b c0980b3 = new C0978a.C0980b();
                        m18162a(jSONObject7, c0980b3);
                        c0978a.f3072u = c0980b3;
                    }
                    if (C0999fi.m18044a(jSONObject2, "123")) {
                        JSONObject jSONObject8 = jSONObject2.getJSONObject("123");
                        C0978a.C0980b c0980b4 = new C0978a.C0980b();
                        m18162a(jSONObject8, c0980b4);
                        c0978a.f3073v = c0980b4;
                    }
                }
                return c0978a;
            }
        } catch (Throwable th5) {
            C1002fl.m18028a(th5, "AuthConfigManager", "loadConfig");
        }
        return c0978a;
    }

    /* renamed from: a */
    public static String m18159a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    /* renamed from: a */
    private static void m18162a(JSONObject jSONObject, C0978a.C0980b c0980b) {
        if (c0980b != null) {
            try {
                String m18159a = m18159a(jSONObject, C0413a.f922b);
                String m18159a2 = m18159a(jSONObject, "u");
                String m18159a3 = m18159a(jSONObject, "v");
                String m18159a4 = m18159a(jSONObject, "able");
                c0980b.f3078c = m18159a;
                c0980b.f3077b = m18159a2;
                c0980b.f3079d = m18159a3;
                c0980b.f3076a = m18163a(m18159a4, false);
            } catch (Throwable th) {
                C1002fl.m18028a(th, "ConfigManager", "parsePluginEntity");
            }
        }
    }

    /* renamed from: a */
    private static void m18161a(JSONObject jSONObject, C0978a.C0981c c0981c) {
        if (jSONObject != null) {
            try {
                String m18159a = m18159a(jSONObject, "md5");
                String m18159a2 = m18159a(jSONObject, "url");
                c0981c.f3081b = m18159a;
                c0981c.f3080a = m18159a2;
            } catch (Throwable th) {
                C1002fl.m18028a(th, "ConfigManager", "parseSDKCoordinate");
            }
        }
    }

    /* renamed from: a */
    private static void m18160a(JSONObject jSONObject, C0978a.C0982d c0982d) {
        if (jSONObject != null) {
            try {
                String m18159a = m18159a(jSONObject, "md5");
                String m18159a2 = m18159a(jSONObject, "url");
                String m18159a3 = m18159a(jSONObject, "sdkversion");
                if (TextUtils.isEmpty(m18159a) || TextUtils.isEmpty(m18159a2) || TextUtils.isEmpty(m18159a3)) {
                    return;
                }
                c0982d.f3082a = m18159a2;
                c0982d.f3083b = m18159a;
                c0982d.f3084c = m18159a3;
            } catch (Throwable th) {
                C1002fl.m18028a(th, "ConfigManager", "parseSDKUpdate");
            }
        }
    }

    /* renamed from: a */
    public static boolean m18163a(String str, boolean z) {
        try {
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length + (-1)].charAt(4) % 2 == 1;
        } catch (Throwable th) {
            return z;
        }
    }
}
