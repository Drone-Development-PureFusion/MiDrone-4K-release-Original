package com.tencent.open.yyb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.connect.common.Constants;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.AuthActivity;
import java.io.IOException;
import java.io.InputStream;
/* renamed from: com.tencent.open.yyb.a */
/* loaded from: classes2.dex */
public class C4390a {

    /* renamed from: com.tencent.open.yyb.a$a */
    /* loaded from: classes2.dex */
    public static class C4392a {

        /* renamed from: a */
        public String f18278a;

        /* renamed from: b */
        public String f18279b;

        /* renamed from: c */
        public long f18280c;
    }

    /* renamed from: com.tencent.open.yyb.a$b */
    /* loaded from: classes2.dex */
    private static class AsyncTaskC4393b extends AsyncTask<Bundle, Void, Void> {
        private AsyncTaskC4393b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L9;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Bundle... bundleArr) {
            String str;
            if (bundleArr != null) {
                if (bundleArr.length == 2) {
                    str = bundleArr[1].getString("uri");
                }
                str = "http://analy.qq.com/cgi-bin/mapp_apptrace";
                try {
                    C4331f.m5445b(C4331f.f18119d, "-->(ViaAsyncTask)doInBackground : ret = " + Util.parseJson(HttpUtils.openUrl2(null, str, "GET", bundleArr[0]).response).getInt("ret"));
                } catch (Exception e) {
                    C4331f.m5445b(C4331f.f18119d, "-->(ViaAsyncTask)doInBackground : Exception = " + e.toString());
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static Drawable m5317a(String str, Context context) {
        return m5316a(str, context, new Rect(0, 0, 0, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable m5316a(String str, Context context, Rect rect) {
        InputStream inputStream;
        InputStream inputStream2;
        Drawable drawable;
        Context applicationContext = context.getApplicationContext();
        try {
            inputStream = applicationContext.getAssets().open(str);
        } catch (IOException e) {
            e = e;
            inputStream2 = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        if (inputStream == null) {
            if (inputStream == null) {
                return null;
            }
            try {
                inputStream.close();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        try {
            if (str.endsWith(".9.png")) {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (decodeStream == null) {
                    if (inputStream == null) {
                        return null;
                    }
                    try {
                        inputStream.close();
                        return null;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                drawable = new NinePatchDrawable(applicationContext.getResources(), decodeStream, decodeStream.getNinePatchChunk(), rect, null);
            } else {
                drawable = Drawable.createFromStream(inputStream, str);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStream2 = inputStream;
            try {
                e.printStackTrace();
                C4331f.m5445b(C4331f.f18119d, "-->(AppbarUtil)getDrawable : IOException");
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        drawable = null;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        drawable = null;
                    }
                } else {
                    drawable = null;
                }
                return drawable;
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
            }
            throw th;
        }
        return drawable;
    }

    /* renamed from: a */
    public static void m5318a(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String str5 = null;
        if (Uri.parse(str).getHost().toLowerCase().endsWith(".qq.com")) {
            str5 = ".qq.com";
        }
        cookieManager.setCookie(str, m5314b("logintype", "MOBILEQ", str5));
        cookieManager.setCookie(str, m5314b("qopenid", str2, str5));
        cookieManager.setCookie(str, m5314b("qaccesstoken", str3, str5));
        cookieManager.setCookie(str, m5314b("openappid", str4, str5));
        CookieSyncManager.getInstance().sync();
    }

    /* renamed from: a */
    public static void m5315a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", Constants.DEFAULT_UIN);
        bundle.putString(AuthActivity.ACTION_KEY, str2);
        bundle.putString("appid", str);
        bundle.putString("via", str3);
        new AsyncTaskC4393b().execute(bundle);
    }

    /* renamed from: b */
    private static String m5314b(String str, String str2, String str3) {
        String str4 = str + "=" + str2;
        if (str3 != null) {
            return (str4 + "; path=/") + "; domain=" + str3;
        }
        return str4;
    }
}
