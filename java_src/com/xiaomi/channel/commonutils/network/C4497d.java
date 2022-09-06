package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.xiaomi.channel.commonutils.string.C4506c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.p248a.p249a.C5083e;
import p004b.p005a.p006a.p007a.p025n.C0228a;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.xiaomi.channel.commonutils.network.d */
/* loaded from: classes.dex */
public class C4497d {

    /* renamed from: a */
    public static final Pattern f18573a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b */
    public static final Pattern f18574b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c */
    public static final Pattern f18575c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: com.xiaomi.channel.commonutils.network.d$a */
    /* loaded from: classes2.dex */
    public static final class C4498a extends FilterInputStream {

        /* renamed from: a */
        private boolean f18576a;

        public C4498a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.f18576a || (read = super.read(bArr, i, i2)) == -1) {
                this.f18576a = true;
                return -1;
            }
            return read;
        }
    }

    /* renamed from: com.xiaomi.channel.commonutils.network.d$b */
    /* loaded from: classes2.dex */
    public static class C4499b {

        /* renamed from: a */
        public int f18577a;

        /* renamed from: b */
        public Map<String, String> f18578b;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f18577a), this.f18578b.toString());
        }
    }

    /* renamed from: a */
    public static int m5000a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getType();
                }
                return -1;
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004e A[Catch: IOException -> 0x0118, TRY_LEAVE, TryCatch #3 {IOException -> 0x0118, blocks: (B:59:0x0049, B:53:0x004e), top: B:58:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C4495b m4999a(Context context, String str, String str2, Map<String, String> map, String str3) {
        ?? r1;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        BufferedReader bufferedReader2 = null;
        C4495b c4495b = new C4495b();
        try {
            try {
                try {
                    HttpURLConnection m4988b = m4988b(context, m4987b(str));
                    m4988b.setConnectTimeout(10000);
                    m4988b.setReadTimeout(15000);
                    if (str2 == null) {
                        str2 = "GET";
                    }
                    m4988b.setRequestMethod(str2);
                    if (map != null) {
                        for (String str4 : map.keySet()) {
                            m4988b.setRequestProperty(str4, map.get(str4));
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m4988b.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        OutputStream outputStream2 = m4988b.getOutputStream();
                        try {
                            outputStream2.write(bytes, 0, bytes.length);
                            outputStream2.flush();
                            outputStream2.close();
                            outputStream = null;
                        } catch (IOException e) {
                            e = e;
                            bufferedReader2 = outputStream2;
                            bufferedReader = null;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                BufferedReader bufferedReader3 = bufferedReader;
                                r1 = bufferedReader2;
                                bufferedReader2 = bufferedReader3;
                                if (r1 != 0) {
                                    try {
                                        r1.close();
                                    } catch (IOException e2) {
                                        Log.e("com.xiaomi.common.Network", "error while closing strean", e2);
                                        throw th;
                                    }
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw new IOException(th.getMessage());
                        }
                    } else {
                        outputStream = null;
                    }
                    c4495b.f18570a = m4988b.getResponseCode();
                    Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + c4495b.f18570a);
                    int i = 0;
                    while (true) {
                        String headerFieldKey = m4988b.getHeaderFieldKey(i);
                        String headerField = m4988b.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException e3) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new C4498a(m4988b.getErrorStream())));
                            }
                        } else {
                            c4495b.f18571b.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new C4498a(m4988b.getInputStream())));
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String property = System.getProperty("line.separator");
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuffer.append(readLine);
                stringBuffer.append(property);
            }
            c4495b.f18572c = stringBuffer.toString();
            bufferedReader.close();
            BufferedReader bufferedReader4 = null;
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.e("com.xiaomi.common.Network", "error while closing strean", e5);
                }
            }
            if (0 != 0) {
                bufferedReader4.close();
            }
            return c4495b;
        } catch (IOException e6) {
            e = e6;
            throw e;
        } catch (Throwable th5) {
            th = th5;
            BufferedReader bufferedReader5 = bufferedReader;
            r1 = 0;
            bufferedReader2 = bufferedReader5;
            if (r1 != 0) {
            }
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static C4495b m4998a(Context context, String str, Map<String, String> map) {
        return m4999a(context, str, "POST", (Map<String, String>) null, m4990a(map));
    }

    /* renamed from: a */
    public static InputStream m4996a(Context context, URL url, boolean z, String str, String str2) {
        return m4994a(context, url, z, str, str2, null, null);
    }

    /* renamed from: a */
    public static InputStream m4994a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, C4499b c4499b) {
        if (context == null) {
            throw new IllegalArgumentException(C0359h.f700ac);
        }
        if (url == null) {
            throw new IllegalArgumentException("url");
        }
        URL url2 = !z ? new URL(m4993a(url.toString())) : url;
        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection m4988b = m4988b(context, url2);
            m4988b.setConnectTimeout(10000);
            m4988b.setReadTimeout(15000);
            if (!TextUtils.isEmpty(str)) {
                m4988b.setRequestProperty(C5083e.f21661Y, str);
            }
            if (str2 != null) {
                m4988b.setRequestProperty("Cookie", str2);
            }
            if (map != null) {
                for (String str3 : map.keySet()) {
                    m4988b.setRequestProperty(str3, map.get(str3));
                }
            }
            if (c4499b != null && (url.getProtocol().equals(UriUtil.HTTP_SCHEME) || url.getProtocol().equals(UriUtil.HTTPS_SCHEME))) {
                c4499b.f18577a = m4988b.getResponseCode();
                if (c4499b.f18578b == null) {
                    c4499b.f18578b = new HashMap();
                }
                int i = 0;
                while (true) {
                    String headerFieldKey = m4988b.getHeaderFieldKey(i);
                    String headerField = m4988b.getHeaderField(i);
                    if (headerFieldKey == null && headerField == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                        c4499b.f18578b.put(headerFieldKey, headerField);
                    }
                    i++;
                }
            }
            return new C4498a(m4988b.getInputStream());
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    /* renamed from: a */
    public static String m4997a(Context context, URL url) {
        return m4995a(context, url, false, null, "UTF-8", null);
    }

    /* renamed from: a */
    public static String m4995a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream = null;
        try {
            inputStream = m4996a(context, url, z, str, str3);
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            return sb.toString();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static String m4993a(String str) {
        if (!TextUtils.isEmpty(str)) {
            new String();
            return String.format("%s&key=%s", str, C4506c.m4951a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007b A[Catch: IOException -> 0x016b, TryCatch #9 {IOException -> 0x016b, blocks: (B:65:0x0076, B:57:0x007b, B:59:0x0080), top: B:64:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0080 A[Catch: IOException -> 0x016b, TRY_LEAVE, TryCatch #9 {IOException -> 0x016b, blocks: (B:65:0x0076, B:57:0x007b, B:59:0x0080), top: B:64:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m4992a(String str, Map<String, String> map, File file, String str2) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Object obj;
        BufferedReader bufferedReader = null;
        if (!file.exists()) {
            return null;
        }
        ?? name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(C5083e.f21675j, "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes("--*****\r\n");
                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"" + C3947a.f16890a);
                    dataOutputStream.writeBytes(C3947a.f16890a);
                    name = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = name.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            dataOutputStream.write(bArr, 0, read);
                            dataOutputStream.flush();
                        }
                        dataOutputStream.writeBytes(C3947a.f16890a);
                        dataOutputStream.writeBytes("--");
                        dataOutputStream.writeBytes("*****");
                        dataOutputStream.writeBytes("--");
                        dataOutputStream.writeBytes(C3947a.f16890a);
                        dataOutputStream.flush();
                        StringBuffer stringBuffer = new StringBuffer();
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new C4498a(httpURLConnection.getInputStream())));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (IOException e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                dataOutputStream2 = dataOutputStream;
                                obj = name;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    name = obj;
                                    dataOutputStream = dataOutputStream2;
                                    if (name != 0) {
                                        try {
                                            name.close();
                                        } catch (IOException e2) {
                                            Log.e("com.xiaomi.common.Network", "error while closing strean", e2);
                                            throw th;
                                        }
                                    }
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw new IOException(th.getMessage());
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        if (name != 0) {
                            try {
                                name.close();
                            } catch (IOException e3) {
                                Log.e("com.xiaomi.common.Network", "error while closing strean", e3);
                                return stringBuffer2;
                            }
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (bufferedReader2 == null) {
                            return stringBuffer2;
                        }
                        bufferedReader2.close();
                        return stringBuffer2;
                    } catch (IOException e4) {
                        e = e4;
                        dataOutputStream2 = dataOutputStream;
                        obj = name;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e5) {
                    e = e5;
                    dataOutputStream2 = dataOutputStream;
                    obj = null;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e6) {
            e = e6;
            dataOutputStream2 = null;
            obj = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* renamed from: a */
    public static String m4991a(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol()).append("://").append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            sb.append(C0228a.f351a).append(url.getQuery());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m4990a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        return (stringBuffer.length() > 0 ? stringBuffer.deleteCharAt(stringBuffer.length() - 1) : stringBuffer).toString();
    }

    /* renamed from: b */
    public static HttpURLConnection m4988b(Context context, URL url) {
        if (!UriUtil.HTTP_SCHEME.equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (m4986c(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!m4989b(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        String host = url.getHost();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(m4991a(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", host);
        return httpURLConnection;
    }

    /* renamed from: b */
    private static URL m4987b(String str) {
        return new URL(str);
    }

    /* renamed from: b */
    public static boolean m4989b(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (!TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && !extraInfo.contains("ctwap")) {
                    return extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m4986c(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3) {
                    return false;
                }
                return extraInfo.contains("ctwap");
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m4985d(Context context) {
        return m5000a(context) >= 0;
    }

    /* renamed from: e */
    public static boolean m4984e(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    /* renamed from: f */
    public static boolean m4983f(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return 1 == activeNetworkInfo.getType();
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: g */
    public static boolean m4982g(Context context) {
        NetworkInfo m4979j = m4979j(context);
        return m4979j != null && m4979j.getType() == 0 && 13 == m4979j.getSubtype();
    }

    /* renamed from: h */
    public static boolean m4981h(Context context) {
        NetworkInfo m4979j = m4979j(context);
        if (m4979j != null && m4979j.getType() == 0) {
            String subtypeName = m4979j.getSubtypeName();
            if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName)) {
                return true;
            }
            switch (m4979j.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return true;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m4980i(Context context) {
        NetworkInfo m4979j = m4979j(context);
        if (m4979j != null && m4979j.getType() == 0) {
            switch (m4979j.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return true;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                default:
                    return false;
            }
        }
        return false;
    }

    /* renamed from: j */
    public static NetworkInfo m4979j(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: k */
    public static String m4978k(Context context) {
        if (m4983f(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? "" : (activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception e) {
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }
}
