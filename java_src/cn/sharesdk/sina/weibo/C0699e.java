package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;
/* renamed from: cn.sharesdk.sina.weibo.e */
/* loaded from: classes.dex */
public class C0699e {

    /* renamed from: b */
    private static C0699e f1662b;

    /* renamed from: d */
    private Context f1664d;

    /* renamed from: a */
    private static final Uri f1661a = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");

    /* renamed from: c */
    private static C0700a f1663c = null;

    /* renamed from: cn.sharesdk.sina.weibo.e$a */
    /* loaded from: classes.dex */
    public static class C0700a {

        /* renamed from: a */
        private String f1665a;

        /* renamed from: b */
        private int f1666b;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m19424a(int i) {
            this.f1666b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m19421a(String str) {
            this.f1665a = str;
        }

        /* renamed from: a */
        public String m19425a() {
            return this.f1665a;
        }

        /* renamed from: b */
        public int m19420b() {
            return this.f1666b;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.f1665a + ", supportApi = " + this.f1666b;
        }
    }

    private C0699e(Context context) {
        this.f1664d = context.getApplicationContext();
    }

    /* renamed from: a */
    public static synchronized C0699e m19432a(Context context) {
        C0699e c0699e;
        synchronized (C0699e.class) {
            if (f1662b == null) {
                f1662b = new C0699e(context);
            }
            c0699e = f1662b;
        }
        return c0699e;
    }

    /* renamed from: a */
    public static boolean m19431a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m19429a(context.getPackageManager().getPackageInfo(str, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m19429a(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (str.equals(Data.MD5(signature.toByteArray()))) {
                C0683d.m19513a().m5972d("check pass", new Object[0]);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private C0700a m19428b(Context context) {
        boolean z = true;
        C0700a m19427c = m19427c(context);
        C0700a m19426d = m19426d(context);
        boolean z2 = m19427c != null;
        if (m19426d == null) {
            z = false;
        }
        if (z2 && z) {
            return m19427c.m19420b() >= m19426d.m19420b() ? m19427c : m19426d;
        } else if (z2) {
            return m19427c;
        } else {
            if (!z) {
                return null;
            }
            return m19426d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C0700a m19427c(Context context) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        try {
            try {
                cursor = context.getContentResolver().query(f1661a, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        if (cursor == null) {
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        try {
            int columnIndex = cursor.getColumnIndex("support_api");
            int columnIndex2 = cursor.getColumnIndex("package");
            if (cursor.moveToFirst()) {
                try {
                    i = Integer.parseInt(cursor.getString(columnIndex));
                } catch (NumberFormatException e2) {
                    C0683d.m19513a().m5971d(e2);
                    i = -1;
                }
                String string = cursor.getString(columnIndex2);
                if (!TextUtils.isEmpty(string) && m19431a(context, string)) {
                    C0700a c0700a = new C0700a();
                    c0700a.m19421a(string);
                    c0700a.m19424a(i);
                    if (cursor == null) {
                        return c0700a;
                    }
                    cursor.close();
                    return c0700a;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e3) {
            e = e3;
            C0683d.m19513a().m5969e(e.getMessage(), new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        return null;
    }

    /* renamed from: d */
    private C0700a m19426d(Context context) {
        C0700a c0700a;
        C0700a c0700a2 = null;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName) || (c0700a = m19430a(resolveInfo.serviceInfo.applicationInfo.packageName)) == null || (c0700a2 != null && c0700a2.m19420b() >= c0700a.m19420b())) {
                    c0700a = c0700a2;
                }
                c0700a2 = c0700a;
            }
        }
        return c0700a2;
    }

    /* renamed from: a */
    public C0700a m19430a(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] bArr = new byte[4096];
                inputStream = this.f1664d.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (TextUtils.isEmpty(sb.toString()) || !m19431a(this.f1664d, str)) {
                        if (inputStream == null) {
                            return null;
                        }
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e) {
                            C0683d.m19513a().m5969e(e.getMessage(), new Object[0]);
                            return null;
                        }
                    }
                    int optInt = new JSONObject(sb.toString()).optInt("support_api", -1);
                    C0700a c0700a = new C0700a();
                    c0700a.m19421a(str);
                    c0700a.m19424a(optInt);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            C0683d.m19513a().m5969e(e2.getMessage(), new Object[0]);
                        }
                    }
                    return c0700a;
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    C0683d.m19513a().m5969e(e.getMessage(), new Object[0]);
                    if (inputStream == null) {
                        return null;
                    }
                    try {
                        inputStream.close();
                        return null;
                    } catch (IOException e4) {
                        C0683d.m19513a().m5969e(e4.getMessage(), new Object[0]);
                        return null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    C0683d.m19513a().m5969e(e.getMessage(), new Object[0]);
                    if (inputStream == null) {
                        return null;
                    }
                    try {
                        inputStream.close();
                        return null;
                    } catch (IOException e6) {
                        C0683d.m19513a().m5969e(e6.getMessage(), new Object[0]);
                        return null;
                    }
                }
            } catch (PackageManager.NameNotFoundException e7) {
                e = e7;
                inputStream = null;
            } catch (Exception e8) {
                e = e8;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (IOException e9) {
                        C0683d.m19513a().m5969e(e9.getMessage(), new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public synchronized String m19433a() {
        if (f1663c == null) {
            f1663c = m19428b(this.f1664d);
        }
        return f1663c.m19425a();
    }
}
