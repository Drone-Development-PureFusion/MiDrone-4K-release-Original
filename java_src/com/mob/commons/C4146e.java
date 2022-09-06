package com.mob.commons;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* renamed from: com.mob.commons.e */
/* loaded from: classes.dex */
public class C4146e {

    /* renamed from: a */
    private static final String[] f17311a = {ShareSDK.SDK_TAG, "SMSSDK", "SHAREREC", "MOBAPI", "MOBLINK"};

    /* renamed from: b */
    private static final HashMap<String, MobProduct> f17312b = new HashMap<>();

    /* renamed from: a */
    public static final synchronized String m6035a(Context context, ArrayList<MobProduct> arrayList) {
        String str;
        synchronized (C4146e.class) {
            try {
                Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
                String str2 = ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]) + "/" + ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersionName", new Object[0]);
                int size = arrayList.size();
                String str3 = "";
                for (int i = 0; i < size; i++) {
                    try {
                        String str4 = str3.length() > 0 ? str3 + " " : str3;
                        try {
                            MobProduct mobProduct = arrayList.get(i);
                            str3 = str4 + mobProduct.getProductTag() + "/" + mobProduct.getSdkver();
                        } catch (Throwable th) {
                            str3 = str4;
                        }
                    } catch (Throwable th2) {
                    }
                }
                str = str2 + " " + str3 + (str3.length() > 0 ? " " : "") + ("Android/" + ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionInt", new Object[0])) + " " + TimeZone.getDefault().getID() + " " + ("Lang/" + Locale.getDefault().toString().replace("-r", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
            } catch (Throwable th3) {
                MobLog.getInstance().m5959w(th3);
                str = "";
            }
        }
        return str;
    }

    /* renamed from: a */
    public static final synchronized ArrayList<MobProduct> m6036a() {
        ArrayList<MobProduct> arrayList;
        synchronized (C4146e.class) {
            try {
                ReflectHelper.importClass("com.mob.commons.*");
                for (String str : f17311a) {
                    try {
                        MobProduct mobProduct = (MobProduct) ReflectHelper.newInstance(str, new Object[0]);
                        if (mobProduct != null) {
                            f17312b.put(mobProduct.getProductTag(), mobProduct);
                        }
                    } catch (Throwable th) {
                    }
                }
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 > 128) {
                        break;
                    }
                    try {
                        MobProduct mobProduct2 = (MobProduct) ReflectHelper.newInstance("MobProduct" + i2, new Object[0]);
                        if (mobProduct2 != null) {
                            f17312b.put(mobProduct2.getProductTag(), mobProduct2);
                        }
                    } catch (Throwable th2) {
                    }
                    i = i2 + 1;
                }
                arrayList = new ArrayList<>();
                for (Map.Entry<String, MobProduct> entry : f17312b.entrySet()) {
                    arrayList.add(entry.getValue());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static final synchronized void m6034a(MobProduct mobProduct) {
        synchronized (C4146e.class) {
            if (mobProduct != null) {
                if (!f17312b.containsKey(mobProduct.getProductTag())) {
                    f17312b.put(mobProduct.getProductTag(), mobProduct);
                }
            }
        }
    }
}
