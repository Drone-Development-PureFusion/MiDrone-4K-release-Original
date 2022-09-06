package com.amap.api.mapcore.util;

import android.os.Build;
import com.amap.api.mapcore.util.C1057gx;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
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
/* renamed from: com.amap.api.mapcore.util.ha */
/* loaded from: classes.dex */
public class C1069ha {

    /* renamed from: a */
    private static AbstractC1071hb f3348a;

    /* renamed from: b */
    private int f3349b;

    /* renamed from: c */
    private int f3350c;

    /* renamed from: d */
    private boolean f3351d;

    /* renamed from: e */
    private SSLContext f3352e;

    /* renamed from: f */
    private Proxy f3353f;

    /* renamed from: g */
    private volatile boolean f3354g;

    /* renamed from: h */
    private long f3355h;

    /* renamed from: i */
    private long f3356i;

    /* renamed from: j */
    private String f3357j;

    /* renamed from: k */
    private C1057gx.AbstractC1058a f3358k;

    /* renamed from: l */
    private HostnameVerifier f3359l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1069ha(int i, int i2, Proxy proxy) {
        this(i, i2, proxy, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1069ha(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, null);
    }

    C1069ha(int i, int i2, Proxy proxy, boolean z, C1057gx.AbstractC1058a abstractC1058a) {
        this.f3354g = false;
        this.f3355h = -1L;
        this.f3356i = 0L;
        this.f3359l = new HostnameVerifier() { // from class: com.amap.api.mapcore.util.ha.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                return defaultHostnameVerifier.verify("*.amap.com", sSLSession) || defaultHostnameVerifier.verify("*.apilocate.amap.com", sSLSession);
            }
        };
        this.f3349b = i;
        this.f3350c = i2;
        this.f3353f = proxy;
        this.f3351d = z;
        this.f3358k = abstractC1058a;
        m17714b();
        if (z) {
            try {
                SSLContext sSLContext = SSLContext.getInstance(C5115g.f21740a);
                sSLContext.init(null, null, null);
                this.f3352e = sSLContext;
            } catch (Throwable th) {
                C1002fl.m18028a(th, "HttpUtil", "HttpUtil");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C1077hf m17717a(HttpURLConnection httpURLConnection) {
        FilterInputStream filterInputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PushbackInputStream pushbackInputStream;
        FilterInputStream gZIPInputStream;
        List<String> list;
        PushbackInputStream pushbackInputStream2 = null;
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new C0975ex("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + ((headerFields == null || (list = headerFields.get("gsid")) == null || list.size() <= 0) ? "" : list.get(0)) + " " + this.f3357j);
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    pushbackInputStream = new PushbackInputStream(inputStream, 2);
                    try {
                        byte[] bArr = new byte[2];
                        pushbackInputStream.read(bArr);
                        pushbackInputStream.unread(bArr);
                        gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                    } catch (IOException e) {
                        e = e;
                        filterInputStream = null;
                        pushbackInputStream2 = pushbackInputStream;
                    } catch (Throwable th) {
                        th = th;
                        filterInputStream = null;
                        pushbackInputStream2 = pushbackInputStream;
                    }
                } catch (IOException e2) {
                    e = e2;
                    filterInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    filterInputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                filterInputStream = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                filterInputStream = null;
                inputStream = null;
            }
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                if (f3348a != null) {
                    f3348a.mo17712a();
                }
                C1077hf c1077hf = new C1077hf();
                c1077hf.f3370a = byteArrayOutputStream.toByteArray();
                c1077hf.f3371b = headerFields;
                c1077hf.f3372c = this.f3357j;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        C1002fl.m18028a(th4, "HttpUrlUtil", "parseResult");
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th5) {
                        C1002fl.m18028a(th5, "HttpUrlUtil", "parseResult");
                    }
                }
                if (pushbackInputStream != null) {
                    try {
                        pushbackInputStream.close();
                    } catch (Throwable th6) {
                        C1002fl.m18028a(th6, "HttpUrlUtil", "parseResult");
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable th7) {
                        C1002fl.m18028a(th7, "HttpUrlUtil", "parseResult");
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th8) {
                        C1002fl.m18028a(th8, "HttpUrlUtil", "parseResult");
                    }
                }
                return c1077hf;
            } catch (IOException e4) {
                e = e4;
                filterInputStream = gZIPInputStream;
                pushbackInputStream2 = pushbackInputStream;
                try {
                    throw e;
                } catch (Throwable th9) {
                    th = th9;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th10) {
                            C1002fl.m18028a(th10, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th11) {
                            C1002fl.m18028a(th11, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable th12) {
                            C1002fl.m18028a(th12, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (filterInputStream != null) {
                        try {
                            filterInputStream.close();
                        } catch (Throwable th13) {
                            C1002fl.m18028a(th13, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th14) {
                            C1002fl.m18028a(th14, "HttpUrlUtil", "parseResult");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th15) {
                th = th15;
                filterInputStream = gZIPInputStream;
                pushbackInputStream2 = pushbackInputStream;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (pushbackInputStream2 != null) {
                }
                if (filterInputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            filterInputStream = null;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th16) {
            th = th16;
            filterInputStream = null;
            inputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17716a(Map<String, String> map) {
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
    public static void m17722a(AbstractC1071hb abstractC1071hb) {
        f3348a = abstractC1071hb;
    }

    /* renamed from: a */
    private void m17715a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.f3357j);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "HttpUrlUtil", "addHeaders");
        }
        httpURLConnection.setConnectTimeout(this.f3349b);
        httpURLConnection.setReadTimeout(this.f3350c);
    }

    /* renamed from: b */
    private void m17714b() {
        try {
            this.f3357j = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase();
        } catch (Throwable th) {
            C1002fl.m18028a(th, "HttpUrlUtil", "initCSID");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1077hf m17721a(String str, Map<String, String> map, Map<String, String> map2) {
        try {
            String m17716a = m17716a(map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (m17716a != null) {
                stringBuffer.append(C0228a.f351a).append(m17716a);
            }
            HttpURLConnection m17719a = m17719a(stringBuffer.toString(), map, false);
            m17719a.connect();
            return m17717a(m17719a);
        } catch (C0975ex e) {
            throw e;
        } catch (InterruptedIOException e2) {
            throw new C0975ex("未知的错误");
        } catch (ConnectException e3) {
            throw new C0975ex("http连接失败 - ConnectionException");
        } catch (MalformedURLException e4) {
            throw new C0975ex("url异常 - MalformedURLException");
        } catch (SocketException e5) {
            throw new C0975ex("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e6) {
            throw new C0975ex("socket 连接超时 - SocketTimeoutException");
        } catch (UnknownHostException e7) {
            throw new C0975ex("未知主机 - UnKnowHostException");
        } catch (IOException e8) {
            throw new C0975ex("IO 操作异常 - IOException");
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C0975ex("未知的错误");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1077hf m17718a(String str, Map<String, String> map, byte[] bArr) {
        try {
            HttpURLConnection m17719a = m17719a(str, map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(m17719a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            m17719a.connect();
            return m17717a(m17719a);
        } catch (C0975ex e) {
            C1002fl.m18028a(e, "HttpUrlUtil", "makePostReqeust");
            throw e;
        } catch (ConnectException e2) {
            e2.printStackTrace();
            throw new C0975ex("http连接失败 - ConnectionException");
        } catch (SocketTimeoutException e3) {
            e3.printStackTrace();
            throw new C0975ex("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException e4) {
            throw new C0975ex("未知的错误");
        } catch (MalformedURLException e5) {
            e5.printStackTrace();
            throw new C0975ex("url异常 - MalformedURLException");
        } catch (SocketException e6) {
            e6.printStackTrace();
            throw new C0975ex("socket 连接异常 - SocketException");
        } catch (UnknownHostException e7) {
            e7.printStackTrace();
            throw new C0975ex("未知主机 - UnKnowHostException");
        } catch (IOException e8) {
            e8.printStackTrace();
            throw new C0975ex("IO 操作异常 - IOException");
        } catch (Throwable th) {
            C1002fl.m18028a(th, "HttpUrlUtil", "makePostReqeust");
            throw new C0975ex("未知的错误");
        }
    }

    /* renamed from: a */
    HttpURLConnection m17719a(String str, Map<String, String> map, boolean z) {
        HttpURLConnection httpURLConnection;
        C0989fc.m18135a();
        URLConnection uRLConnection = null;
        URL url = new URL(str);
        if (this.f3358k != null) {
            uRLConnection = this.f3358k.m17767a(this.f3353f, url);
        }
        if (uRLConnection == null) {
            uRLConnection = this.f3353f != null ? url.openConnection(this.f3353f) : url.openConnection();
        }
        if (this.f3351d) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f3352e.getSocketFactory());
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.f3359l);
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty(C5083e.f21675j, "close");
        }
        m17715a(map, httpURLConnection);
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
    public void m17724a() {
        this.f3354g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17723a(long j) {
        this.f3356i = j;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: a */
    void m17720a(java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, com.amap.api.mapcore.util.C1060gz.AbstractC1061a r14) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C1069ha.m17720a(java.lang.String, java.util.Map, java.util.Map, com.amap.api.mapcore.util.gz$a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m17713b(long j) {
        this.f3355h = j;
    }
}
