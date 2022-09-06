package com.p080b;

import android.os.Build;
import com.p080b.C1423an;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p261f.p264c.C5115g;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: com.b.ao */
/* loaded from: classes.dex */
public class C1425ao {

    /* renamed from: a */
    private static AbstractC1427ap f4892a;

    /* renamed from: b */
    private int f4893b;

    /* renamed from: c */
    private int f4894c;

    /* renamed from: d */
    private boolean f4895d;

    /* renamed from: e */
    private SSLContext f4896e;

    /* renamed from: f */
    private Proxy f4897f;

    /* renamed from: g */
    private volatile boolean f4898g;

    /* renamed from: h */
    private long f4899h;

    /* renamed from: i */
    private long f4900i;

    /* renamed from: j */
    private HostnameVerifier f4901j;

    /* renamed from: com.b.ao$a */
    /* loaded from: classes.dex */
    class C1426a implements HostnameVerifier {
        C1426a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("*.amap.com", sSLSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1425ao(int i, int i2, Proxy proxy) {
        this(i, i2, proxy, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1425ao(int i, int i2, Proxy proxy, boolean z) {
        this.f4898g = false;
        this.f4899h = -1L;
        this.f4900i = 0L;
        this.f4901j = new C1426a();
        this.f4893b = i;
        this.f4894c = i2;
        this.f4897f = proxy;
        this.f4895d = z;
        if (z) {
            try {
                SSLContext sSLContext = SSLContext.getInstance(C5115g.f21740a);
                sSLContext.init(null, null, null);
                this.f4896e = sSLContext;
            } catch (NoSuchAlgorithmException e) {
                C1450b.m16187a(e, "HttpUrlUtil", "HttpUrlUtil");
            } catch (Throwable th) {
                C1450b.m16187a(th, "HttpUtil", "HttpUtil");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C1429ar m16333a(HttpURLConnection httpURLConnection) {
        FilterInputStream filterInputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PushbackInputStream pushbackInputStream = null;
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new C1532dl("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    PushbackInputStream pushbackInputStream2 = new PushbackInputStream(inputStream, 2);
                    try {
                        byte[] bArr = new byte[2];
                        pushbackInputStream2.read(bArr);
                        pushbackInputStream2.unread(bArr);
                        FilterInputStream gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream2) : pushbackInputStream2;
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            if (f4892a != null) {
                                f4892a.mo15870a();
                            }
                            C1429ar c1429ar = new C1429ar();
                            c1429ar.f4906a = byteArrayOutputStream.toByteArray();
                            c1429ar.f4907b = headerFields;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e) {
                                    C1450b.m16187a(e, "HttpUrlUtil", "parseResult");
                                    e.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                    C1450b.m16187a(e2, "HttpUrlUtil", "parseResult");
                                    e2.printStackTrace();
                                }
                            }
                            if (pushbackInputStream2 != null) {
                                try {
                                    pushbackInputStream2.close();
                                } catch (Exception e3) {
                                    C1450b.m16187a(e3, "HttpUrlUtil", "parseResult");
                                    e3.printStackTrace();
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Exception e4) {
                                    C1450b.m16187a(e4, "HttpUrlUtil", "parseResult");
                                    e4.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    C1450b.m16187a(th, "HttpUrlUtil", "parseResult");
                                    th.printStackTrace();
                                }
                            }
                            return c1429ar;
                        } catch (IOException e5) {
                            e = e5;
                            filterInputStream = gZIPInputStream;
                            pushbackInputStream = pushbackInputStream2;
                            try {
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e6) {
                                        C1450b.m16187a(e6, "HttpUrlUtil", "parseResult");
                                        e6.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e7) {
                                        C1450b.m16187a(e7, "HttpUrlUtil", "parseResult");
                                        e7.printStackTrace();
                                    }
                                }
                                if (pushbackInputStream != null) {
                                    try {
                                        pushbackInputStream.close();
                                    } catch (Exception e8) {
                                        C1450b.m16187a(e8, "HttpUrlUtil", "parseResult");
                                        e8.printStackTrace();
                                    }
                                }
                                if (filterInputStream != null) {
                                    try {
                                        filterInputStream.close();
                                    } catch (Exception e9) {
                                        C1450b.m16187a(e9, "HttpUrlUtil", "parseResult");
                                        e9.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th3) {
                                        C1450b.m16187a(th3, "HttpUrlUtil", "parseResult");
                                        th3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            filterInputStream = gZIPInputStream;
                            pushbackInputStream = pushbackInputStream2;
                            if (byteArrayOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (pushbackInputStream != null) {
                            }
                            if (filterInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        filterInputStream = null;
                        pushbackInputStream = pushbackInputStream2;
                    } catch (Throwable th5) {
                        th = th5;
                        filterInputStream = null;
                        pushbackInputStream = pushbackInputStream2;
                    }
                } catch (IOException e11) {
                    e = e11;
                    filterInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    filterInputStream = null;
                }
            } catch (IOException e12) {
                e = e12;
                filterInputStream = null;
                inputStream = null;
            } catch (Throwable th7) {
                th = th7;
                filterInputStream = null;
                inputStream = null;
            }
        } catch (IOException e13) {
            e = e13;
            filterInputStream = null;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            filterInputStream = null;
            inputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m16332a(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(key));
                sb.append("=");
                sb.append(URLEncoder.encode(value));
            }
            return sb.toString();
        }
        return null;
    }

    /* renamed from: a */
    public static void m16337a(AbstractC1427ap abstractC1427ap) {
        f4892a = abstractC1427ap;
    }

    /* renamed from: a */
    private void m16331a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase());
        } catch (Throwable th) {
            C1450b.m16187a(th, "HttpUrlUtil", "addHeaders");
        }
        httpURLConnection.setConnectTimeout(this.f4893b);
        httpURLConnection.setReadTimeout(this.f4894c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1429ar m16334a(String str, Map<String, String> map, byte[] bArr) {
        try {
            HttpURLConnection m16335a = m16335a(str, map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(m16335a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            m16335a.connect();
            return m16333a(m16335a);
        } catch (ConnectException e) {
            e.printStackTrace();
            throw new C1532dl("http连接失败 - ConnectionException");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            throw new C1532dl("url异常 - MalformedURLException");
        } catch (SocketException e3) {
            e3.printStackTrace();
            throw new C1532dl("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e4) {
            e4.printStackTrace();
            throw new C1532dl("socket 连接超时 - SocketTimeoutException");
        } catch (UnknownHostException e5) {
            e5.printStackTrace();
            throw new C1532dl("未知主机 - UnKnowHostException");
        } catch (IOException e6) {
            e6.printStackTrace();
            throw new C1532dl("IO 操作异常 - IOException");
        } catch (Throwable th) {
            C1450b.m16187a(th, "HttpUrlUtil", "makePostReqeust");
            throw new C1532dl("未知的错误");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection m16335a(String str, Map<String, String> map, boolean z) {
        HttpURLConnection httpURLConnection;
        C1542dq.m15636a();
        URL url = new URL(str);
        URLConnection openConnection = this.f4897f != null ? url.openConnection(this.f4897f) : (HttpURLConnection) url.openConnection();
        if (this.f4895d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f4896e.getSocketFactory());
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.f4901j);
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty(C5083e.f21675j, "close");
        }
        m16331a(map, httpURLConnection);
        if (z) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m16338a(long j) {
        this.f4900i = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m16336a(String str, Map<String, String> map, Map<String, String> map2, C1423an.AbstractC1424a abstractC1424a) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        int read;
        InputStream inputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        inputStream2 = null;
        boolean z = true;
        ?? r2 = 0;
        HttpURLConnection httpURLConnection3 = null;
        try {
            if (abstractC1424a == null) {
                if (0 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        C1450b.m16187a(e, "HttpUrlUtil", "makeDownloadGetRequest");
                    } catch (Throwable th) {
                        th.printStackTrace();
                        C1450b.m16187a(th, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                }
                if (0 == 0) {
                    return;
                }
                try {
                    httpURLConnection3.disconnect();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C1450b.m16187a(th2, "HttpUrlUtil", "makeDownloadGetRequest");
                    return;
                }
            }
            try {
                String m16332a = m16332a(map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (m16332a != null) {
                    stringBuffer.append(C0228a.f351a).append(m16332a);
                }
                httpURLConnection = m16335a(stringBuffer.toString(), map, false);
                try {
                    try {
                        httpURLConnection.setRequestProperty("RANGE", "bytes=" + this.f4900i + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        boolean z2 = responseCode != 200;
                        if (responseCode == 206) {
                            z = false;
                        }
                        if (z & z2) {
                            abstractC1424a.mo15431a(new C1532dl("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode));
                        }
                        InputStream inputStream3 = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (!Thread.interrupted() && !this.f4898g && (read = inputStream3.read(bArr, 0, 1024)) > 0 && (this.f4899h == -1 || this.f4900i < this.f4899h)) {
                                if (read == 1024) {
                                    abstractC1424a.mo15430a(bArr, this.f4900i);
                                } else {
                                    byte[] bArr2 = new byte[read];
                                    System.arraycopy(bArr, 0, bArr2, 0, read);
                                    abstractC1424a.mo15430a(bArr2, this.f4900i);
                                }
                                this.f4900i += read;
                            }
                            if (this.f4898g) {
                                abstractC1424a.mo15428c();
                            } else {
                                abstractC1424a.mo15429b();
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    C1450b.m16187a(e2, "HttpUrlUtil", "makeDownloadGetRequest");
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                    C1450b.m16187a(th3, "HttpUrlUtil", "makeDownloadGetRequest");
                                }
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                                C1450b.m16187a(th4, "HttpUrlUtil", "makeDownloadGetRequest");
                            }
                        } catch (ConnectException e3) {
                            e = e3;
                            inputStream = inputStream3;
                            httpURLConnection2 = httpURLConnection;
                            try {
                                abstractC1424a.mo15431a(e);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        C1450b.m16187a(e4, "HttpUrlUtil", "makeDownloadGetRequest");
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                        C1450b.m16187a(th5, "HttpUrlUtil", "makeDownloadGetRequest");
                                    }
                                }
                                if (httpURLConnection2 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection2.disconnect();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                    C1450b.m16187a(th6, "HttpUrlUtil", "makeDownloadGetRequest");
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                HttpURLConnection httpURLConnection4 = httpURLConnection2;
                                inputStream2 = inputStream;
                                r2 = httpURLConnection4;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        C1450b.m16187a(e5, "HttpUrlUtil", "makeDownloadGetRequest");
                                    } catch (Throwable th8) {
                                        th8.printStackTrace();
                                        C1450b.m16187a(th8, "HttpUrlUtil", "makeDownloadGetRequest");
                                    }
                                }
                                if (r2 != 0) {
                                    try {
                                        r2.disconnect();
                                    } catch (Throwable th9) {
                                        th9.printStackTrace();
                                        C1450b.m16187a(th9, "HttpUrlUtil", "makeDownloadGetRequest");
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (ConnectException e6) {
                        e = e6;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    abstractC1424a.mo15431a(e);
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            C1450b.m16187a(e8, "HttpUrlUtil", "makeDownloadGetRequest");
                        } catch (Throwable th10) {
                            th10.printStackTrace();
                            C1450b.m16187a(th10, "HttpUrlUtil", "makeDownloadGetRequest");
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                        C1450b.m16187a(th11, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                } catch (SocketException e9) {
                    e = e9;
                    abstractC1424a.mo15431a(e);
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                            C1450b.m16187a(e10, "HttpUrlUtil", "makeDownloadGetRequest");
                        } catch (Throwable th12) {
                            th12.printStackTrace();
                            C1450b.m16187a(th12, "HttpUrlUtil", "makeDownloadGetRequest");
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th13) {
                        th13.printStackTrace();
                        C1450b.m16187a(th13, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                } catch (SocketTimeoutException e11) {
                    e = e11;
                    abstractC1424a.mo15431a(e);
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            C1450b.m16187a(e12, "HttpUrlUtil", "makeDownloadGetRequest");
                        } catch (Throwable th14) {
                            th14.printStackTrace();
                            C1450b.m16187a(th14, "HttpUrlUtil", "makeDownloadGetRequest");
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th15) {
                        th15.printStackTrace();
                        C1450b.m16187a(th15, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                } catch (UnknownHostException e13) {
                    e = e13;
                    abstractC1424a.mo15431a(e);
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                            C1450b.m16187a(e14, "HttpUrlUtil", "makeDownloadGetRequest");
                        } catch (Throwable th16) {
                            th16.printStackTrace();
                            C1450b.m16187a(th16, "HttpUrlUtil", "makeDownloadGetRequest");
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th17) {
                        th17.printStackTrace();
                        C1450b.m16187a(th17, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                } catch (IOException e15) {
                    e = e15;
                    abstractC1424a.mo15431a(e);
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            C1450b.m16187a(e16, "HttpUrlUtil", "makeDownloadGetRequest");
                        } catch (Throwable th18) {
                            th18.printStackTrace();
                            C1450b.m16187a(th18, "HttpUrlUtil", "makeDownloadGetRequest");
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th19) {
                        th19.printStackTrace();
                        C1450b.m16187a(th19, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                } catch (Throwable th20) {
                    th = th20;
                    abstractC1424a.mo15431a(th);
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            C1450b.m16187a(e17, "HttpUrlUtil", "makeDownloadGetRequest");
                        } catch (Throwable th21) {
                            th21.printStackTrace();
                            C1450b.m16187a(th21, "HttpUrlUtil", "makeDownloadGetRequest");
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th22) {
                        th22.printStackTrace();
                        C1450b.m16187a(th22, "HttpUrlUtil", "makeDownloadGetRequest");
                    }
                }
            } catch (ConnectException e18) {
                e = e18;
                inputStream = null;
            } catch (MalformedURLException e19) {
                e = e19;
                httpURLConnection = null;
            } catch (SocketException e20) {
                e = e20;
                httpURLConnection = null;
            } catch (SocketTimeoutException e21) {
                e = e21;
                httpURLConnection = null;
            } catch (UnknownHostException e22) {
                e = e22;
                httpURLConnection = null;
            } catch (IOException e23) {
                e = e23;
                httpURLConnection = null;
            } catch (Throwable th23) {
                th = th23;
                httpURLConnection = null;
            }
        } catch (Throwable th24) {
            th = th24;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m16330b(long j) {
        this.f4899h = j;
    }
}
