package com.tencent.map.p226b;

import android.net.Proxy;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import org.p248a.p249a.C5083e;
/* renamed from: com.tencent.map.b.q */
/* loaded from: classes.dex */
public final class C4267q {

    /* renamed from: a */
    private static int f17738a = 0;

    /* renamed from: b */
    private static boolean f17739b;

    /* JADX WARN: Removed duplicated region for block: B:37:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static C4264n m5666a(HttpURLConnection httpURLConnection, boolean z) {
        int read;
        boolean z2 = true;
        int i = 0;
        InputStream inputStream = null;
        try {
            C4264n c4264n = new C4264n();
            String contentType = httpURLConnection.getContentType();
            String str = "GBK";
            if (contentType != null) {
                String[] split = contentType.split(";");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str2 = split[i2];
                    if (str2.contains("charset")) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                        }
                    } else {
                        i2++;
                    }
                }
            }
            c4264n.f17737b = str;
            if (z) {
                if (contentType == null || !contentType.contains("vnd.wap.wml")) {
                    z2 = false;
                }
                if (z2) {
                    httpURLConnection.disconnect();
                    httpURLConnection.connect();
                }
            }
            inputStream = httpURLConnection.getInputStream();
            if (inputStream == null) {
                return c4264n;
            }
            c4264n.f17736a = new byte[0];
            byte[] bArr = new byte[1024];
            do {
                read = inputStream.read(bArr);
                if (read > 0) {
                    i += read;
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(c4264n.f17736a, 0, bArr2, 0, c4264n.f17736a.length);
                    System.arraycopy(bArr, 0, bArr2, c4264n.f17736a.length, read);
                    c4264n.f17736a = bArr2;
                    continue;
                }
            } while (read > 0);
            return c4264n;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.net.HttpURLConnection] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C4264n m5664a(boolean z, String str, String str2, String str3, byte[] bArr, boolean z2, boolean z3) {
        Object obj;
        boolean z4 = true;
        int i = 0;
        DataOutputStream dataOutputStream = null;
        ?? m5671d = C4262l.m5671d();
        try {
            if (m5671d == 0) {
                throw new C4268r();
            }
            try {
                m5671d = m5668a(str, z3);
                try {
                    if (!C4231b.m5806a((String) null)) {
                        m5671d.setRequestProperty(C5083e.f21691z, null);
                    } else if (C4231b.m5806a(m5671d.getURL().getHost())) {
                    }
                    if (z) {
                        m5671d.setRequestMethod("GET");
                    } else {
                        m5671d.setRequestMethod("POST");
                    }
                    m5671d.setConnectTimeout(C4260k.m5685a());
                    m5671d.setReadTimeout(C4260k.m5680b());
                    m5671d.setRequestProperty(C5083e.f21661Y, str2);
                    m5671d.setDoInput(true);
                    if (z) {
                        z4 = false;
                    }
                    m5671d.setDoOutput(z4);
                    m5671d.setUseCaches(false);
                    if (z2) {
                        m5671d.setRequestProperty(C5083e.f21675j, "Keep-Alive");
                    }
                    C4260k.m5682a((HttpURLConnection) m5671d);
                    m5671d.connect();
                    C4260k.m5678c();
                    if (!z && bArr != null && bArr.length != 0) {
                        DataOutputStream dataOutputStream2 = new DataOutputStream(m5671d.getOutputStream());
                        try {
                            dataOutputStream2.write(bArr);
                            dataOutputStream2.flush();
                            dataOutputStream2.close();
                        } catch (C4266p e) {
                            e = e;
                            dataOutputStream = dataOutputStream2;
                            obj = m5671d;
                            try {
                                C4260k.m5681a(true);
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                m5671d = obj;
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (m5671d != 0) {
                                    m5671d.disconnect();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            C4260k.m5681a(false);
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = dataOutputStream2;
                            if (dataOutputStream != null) {
                            }
                            if (m5671d != 0) {
                            }
                            throw th;
                        }
                    }
                    int responseCode = m5671d.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        C4260k.m5676d();
                        C4264n m5666a = m5666a((HttpURLConnection) m5671d, z);
                        if (m5666a != null && m5666a.f17736a != null) {
                            i = m5666a.f17736a.length;
                        }
                        C4260k.m5684a(i);
                        if (m5671d != 0) {
                            m5671d.disconnect();
                        }
                        return m5666a;
                    } else if (responseCode != 202 && responseCode != 201 && responseCode != 204 && responseCode != 205 && responseCode != 304 && responseCode != 305 && responseCode != 408 && responseCode != 502 && responseCode != 504 && responseCode != 503) {
                        throw new C4266p("response code is " + responseCode);
                    } else {
                        throw new IOException("doGetOrPost retry");
                    }
                } catch (C4266p e3) {
                    e = e3;
                    obj = m5671d;
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (C4266p e5) {
                e = e5;
                obj = null;
            } catch (Exception e6) {
                e = e6;
            } catch (Throwable th3) {
                th = th3;
                m5671d = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009f A[Catch: IOException -> 0x00e6, TryCatch #2 {IOException -> 0x00e6, blocks: (B:52:0x009a, B:53:0x009c, B:54:0x009f, B:57:0x00ab, B:61:0x00e0), top: B:51:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0 A[Catch: IOException -> 0x00e6, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x00e6, blocks: (B:52:0x009a, B:53:0x009c, B:54:0x009f, B:57:0x00ab, B:61:0x00e0), top: B:51:0x009a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00e7 -> B:58:0x0018). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpURLConnection m5668a(String str, boolean z) {
        boolean z2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3 = null;
        try {
            URL url = new URL(str);
            if (C4262l.m5672c()) {
                z2 = false;
            } else {
                C4263m.m5670a();
                z2 = !C4231b.m5806a(Proxy.getDefaultHost());
            }
            if (!z2) {
                try {
                    return (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (f17738a == 0 && !f17739b) {
                f17739b = true;
                try {
                    URL url2 = new URL("http://ls.map.soso.com/monitor/monitor.html");
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultPort == -1) {
                        defaultPort = 80;
                    }
                    try {
                        HttpURLConnection httpURLConnection4 = (HttpURLConnection) url2.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost, defaultPort)));
                        try {
                            httpURLConnection4.setRequestMethod("GET");
                            httpURLConnection4.setConnectTimeout(15000);
                            httpURLConnection4.setReadTimeout(45000);
                            httpURLConnection4.setRequestProperty(C5083e.f21661Y, "QQ Map Mobile");
                            httpURLConnection4.setDoInput(true);
                            httpURLConnection4.setDoOutput(false);
                            httpURLConnection4.setUseCaches(false);
                            boolean m5667a = m5667a(httpURLConnection4);
                            httpURLConnection4.connect();
                            if (m5667a) {
                                m5669a(1);
                            } else {
                                m5669a(2);
                            }
                            if (httpURLConnection4 != null) {
                                httpURLConnection4.disconnect();
                            }
                        } catch (Exception e2) {
                            httpURLConnection2 = httpURLConnection4;
                            e = e2;
                            try {
                                e.printStackTrace();
                                m5669a(2);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                switch (f17738a) {
                                }
                                return httpURLConnection;
                            } catch (Throwable th) {
                                th = th;
                                httpURLConnection3 = httpURLConnection2;
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            httpURLConnection3 = httpURLConnection4;
                            th = th2;
                            if (httpURLConnection3 != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        httpURLConnection2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (MalformedURLException e4) {
                    f17739b = false;
                }
            }
            try {
                switch (f17738a) {
                    case 2:
                        httpURLConnection = m5665a(url, str);
                        break;
                    default:
                        String defaultHost2 = android.net.Proxy.getDefaultHost();
                        int defaultPort2 = android.net.Proxy.getDefaultPort();
                        if (defaultPort2 == -1) {
                            defaultPort2 = 80;
                        }
                        httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost2, defaultPort2)));
                        break;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
                httpURLConnection = null;
            }
            return httpURLConnection;
        } catch (MalformedURLException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m5665a(URL url, String str) {
        int i = 80;
        String defaultHost = android.net.Proxy.getDefaultHost();
        int defaultPort = android.net.Proxy.getDefaultPort();
        if (defaultPort == -1) {
            defaultPort = 80;
        }
        String host = url.getHost();
        int port = url.getPort();
        if (port != -1) {
            i = port;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.indexOf(new StringBuilder(String.valueOf(host)).append(":").append(i).toString()) != -1 ? str.replaceFirst(String.valueOf(host) + ":" + i, String.valueOf(defaultHost) + ":" + defaultPort) : str.replaceFirst(host, String.valueOf(defaultHost) + ":" + defaultPort)).openConnection();
            httpURLConnection.setRequestProperty("X-Online-Host", String.valueOf(host) + ":" + i);
            return httpURLConnection;
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m5669a(int i) {
        if (f17738a == i) {
            return;
        }
        f17738a = i;
    }

    /* renamed from: a */
    private static boolean m5667a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            if (!httpURLConnection.getContentType().equals("text/html")) {
                if (inputStream != null) {
                    inputStream.close();
                }
                return false;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (inputStream.available() > 0) {
                byteArrayOutputStream.write(inputStream.read());
            }
            boolean equals = new String(byteArrayOutputStream.toByteArray()).trim().equals("1");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
