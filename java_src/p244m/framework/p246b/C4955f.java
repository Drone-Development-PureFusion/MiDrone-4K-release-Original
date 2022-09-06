package p244m.framework.p246b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.tts.loopj.RequestParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Locale;
/* renamed from: m.framework.b.f */
/* loaded from: classes2.dex */
public class C4955f {

    /* renamed from: a */
    private static float f21294a;

    /* renamed from: a */
    public static int m2488a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: a */
    public static int m2487a(Context context, int i) {
        if (f21294a <= 0.0f) {
            f21294a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i * f21294a) + 0.5f);
    }

    /* renamed from: a */
    public static Bitmap m2485a(File file, int i) {
        FileInputStream fileInputStream = new FileInputStream(file);
        Bitmap m2483a = m2483a(fileInputStream, i);
        fileInputStream.close();
        return m2483a;
    }

    /* renamed from: a */
    public static Bitmap m2484a(InputStream inputStream) {
        return m2483a(inputStream, 1);
    }

    /* renamed from: a */
    private static Bitmap m2483a(InputStream inputStream, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    /* renamed from: a */
    public static Bitmap m2481a(String str, int i) {
        return m2485a(new File(str), i);
    }

    /* renamed from: a */
    public static String m2486a(Context context, String str) {
        C4950b c4950b;
        String str2 = String.valueOf(context.getFilesDir().getAbsolutePath()) + "/mFramework/cache/";
        if (new C4950b(context).m2525u()) {
            str2 = String.valueOf(c4950b.m2524v()) + "/mFramework/" + c4950b.m2531o() + "/cache/";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf(str2) + str + "/";
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        return str2;
    }

    /* renamed from: a */
    public static boolean m2482a(String str) {
        return str == null || str.trim().length() <= 0 || "null".equals(str.trim().toLowerCase(Locale.getDefault()));
    }

    /* renamed from: b */
    public static int m2480b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: b */
    public static Bitmap m2479b(String str) {
        return m2481a(str, 1);
    }

    /* renamed from: c */
    public static String m2478c(String str) {
        String str2;
        Throwable th;
        String str3;
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        if (contentTypeFor == null || contentTypeFor.length() <= 0) {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            if (lowerCase.endsWith("jpg") || lowerCase.endsWith("jepg")) {
                return "image/jpeg";
            }
            if (lowerCase.endsWith("png")) {
                return "image/png";
            }
            if (lowerCase.endsWith("gif")) {
                return "image/gif";
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                str2 = URLConnection.guessContentTypeFromStream(fileInputStream);
                try {
                    fileInputStream.close();
                    str3 = str2;
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    str3 = str2;
                    if (str3 != null) {
                    }
                }
            } catch (Throwable th3) {
                str2 = contentTypeFor;
                th = th3;
            }
            return (str3 != null || str3.length() <= 0) ? RequestParams.APPLICATION_OCTET_STREAM : str3;
        }
        return contentTypeFor;
    }
}
