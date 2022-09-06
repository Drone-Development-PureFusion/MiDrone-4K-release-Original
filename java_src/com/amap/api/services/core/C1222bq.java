package com.amap.api.services.core;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p261f.p264c.C5115g;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: com.amap.api.services.core.bq */
/* loaded from: classes.dex */
public class C1222bq {

    /* renamed from: a */
    private static AbstractC1223br f4135a;

    /* renamed from: g */
    private static TrustManager f4136g = new C1230bw();

    /* renamed from: b */
    private int f4137b;

    /* renamed from: c */
    private int f4138c;

    /* renamed from: d */
    private boolean f4139d;

    /* renamed from: e */
    private SSLContext f4140e;

    /* renamed from: f */
    private Proxy f4141f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1222bq(int i, int i2, Proxy proxy, boolean z) {
        this.f4137b = i;
        this.f4138c = i2;
        this.f4141f = proxy;
        this.f4139d = z;
        if (z) {
            try {
                SSLContext sSLContext = SSLContext.getInstance(C5115g.f21740a);
                sSLContext.init(null, new TrustManager[]{f4136g}, null);
                this.f4140e = sSLContext;
            } catch (KeyManagementException e) {
                C1190ay.m17177a(e, "HttpUrlUtil", "HttpUrlUtil");
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                C1190ay.m17177a(e2, "HttpUrlUtil", "HttpUrlUtil");
                e2.printStackTrace();
            } catch (Throwable th) {
                C1190ay.m17177a(th, "HttpUtil", "HttpUtil");
                th.printStackTrace();
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
    private C1229bv m17064a(HttpURLConnection httpURLConnection) {
        FilterInputStream filterInputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PushbackInputStream pushbackInputStream = null;
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new C1258v("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
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
                            if (f4135a != null) {
                                f4135a.mo17059a();
                            }
                            C1229bv c1229bv = new C1229bv();
                            c1229bv.f4151a = byteArrayOutputStream.toByteArray();
                            c1229bv.f4152b = headerFields;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e) {
                                    C1190ay.m17177a(e, "HttpUrlUtil", "parseResult");
                                    e.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                    C1190ay.m17177a(e2, "HttpUrlUtil", "parseResult");
                                    e2.printStackTrace();
                                }
                            }
                            if (pushbackInputStream2 != null) {
                                try {
                                    pushbackInputStream2.close();
                                } catch (Exception e3) {
                                    C1190ay.m17177a(e3, "HttpUrlUtil", "parseResult");
                                    e3.printStackTrace();
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Exception e4) {
                                    C1190ay.m17177a(e4, "HttpUrlUtil", "parseResult");
                                    e4.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    C1190ay.m17177a(th, "HttpUrlUtil", "parseResult");
                                    th.printStackTrace();
                                }
                            }
                            return c1229bv;
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
                                        C1190ay.m17177a(e6, "HttpUrlUtil", "parseResult");
                                        e6.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e7) {
                                        C1190ay.m17177a(e7, "HttpUrlUtil", "parseResult");
                                        e7.printStackTrace();
                                    }
                                }
                                if (pushbackInputStream != null) {
                                    try {
                                        pushbackInputStream.close();
                                    } catch (Exception e8) {
                                        C1190ay.m17177a(e8, "HttpUrlUtil", "parseResult");
                                        e8.printStackTrace();
                                    }
                                }
                                if (filterInputStream != null) {
                                    try {
                                        filterInputStream.close();
                                    } catch (Exception e9) {
                                        C1190ay.m17177a(e9, "HttpUrlUtil", "parseResult");
                                        e9.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th3) {
                                        C1190ay.m17177a(th3, "HttpUrlUtil", "parseResult");
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

    /* renamed from: a */
    private String m17062a(Map<String, String> map) {
        LinkedList linkedList = new LinkedList();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        if (linkedList.size() > 0) {
            return URLEncodedUtils.format(linkedList, "UTF-8");
        }
        return null;
    }

    /* renamed from: a */
    private HttpURLConnection m17063a(URL url) {
        HttpURLConnection httpURLConnection;
        URLConnection openConnection = this.f4141f != null ? url.openConnection(this.f4141f) : (HttpURLConnection) url.openConnection();
        if (this.f4139d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f4140e.getSocketFactory());
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty(C5083e.f21675j, "close");
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    public static void m17069a(AbstractC1223br abstractC1223br) {
        f4135a = abstractC1223br;
    }

    /* renamed from: a */
    private void m17061a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        httpURLConnection.setConnectTimeout(this.f4137b);
        httpURLConnection.setReadTimeout(this.f4138c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1229bv m17068a(String str, Map<String, String> map, Map<String, String> map2) {
        try {
            String m17062a = m17062a(map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (m17062a != null) {
                stringBuffer.append(C0228a.f351a).append(m17062a);
            }
            HttpURLConnection m17063a = m17063a(new URL(stringBuffer.toString()));
            m17061a(map, m17063a);
            m17063a.setRequestMethod("GET");
            m17063a.setDoInput(true);
            m17063a.connect();
            return m17064a(m17063a);
        } catch (MalformedURLException e) {
            C1190ay.m17177a(e, "HttpUrlUtil", "getRequest");
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            C1190ay.m17177a(e2, "HttpUrlUtil", "getRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "HttpUrlUtil", "getRequest");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1229bv m17067a(String str, Map<String, String> map, Map<String, String> map2, HttpEntity httpEntity) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        IllegalStateException e;
        IOException e2;
        C1229bv c1229bv = null;
        try {
            if (map2 != null) {
                try {
                    String m17062a = m17062a(map2);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str);
                    if (m17062a != null) {
                        stringBuffer.append(C0228a.f351a).append(m17062a);
                    }
                    str = stringBuffer.toString();
                } catch (IOException e3) {
                    e2 = e3;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    C1190ay.m17177a(e2, "HttpUrlUtil", "postRequest2");
                    e2.printStackTrace();
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return c1229bv;
                } catch (IllegalStateException e4) {
                    e = e4;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    C1190ay.m17177a(e, "HttpUrlUtil", "postRequest2");
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return c1229bv;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    C1190ay.m17177a(th, "HttpUrlUtil", "postRequest2");
                    th.printStackTrace();
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return c1229bv;
                }
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            inputStream2 = httpEntity.getContent();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                c1229bv = m17065a(str, map, byteArrayOutputStream.toByteArray());
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        C1190ay.m17177a(e5, "HttpUrlUtil", "postRequest2");
                        e5.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                        e = e6;
                        C1190ay.m17177a(e, "HttpUrlUtil", "postRequest2");
                        e.printStackTrace();
                        return c1229bv;
                    }
                }
            } catch (IOException e7) {
                e2 = e7;
                C1190ay.m17177a(e2, "HttpUrlUtil", "postRequest2");
                e2.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        C1190ay.m17177a(e8, "HttpUrlUtil", "postRequest2");
                        e8.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e9) {
                        e = e9;
                        C1190ay.m17177a(e, "HttpUrlUtil", "postRequest2");
                        e.printStackTrace();
                        return c1229bv;
                    }
                }
                return c1229bv;
            } catch (IllegalStateException e10) {
                e = e10;
                C1190ay.m17177a(e, "HttpUrlUtil", "postRequest2");
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e11) {
                        C1190ay.m17177a(e11, "HttpUrlUtil", "postRequest2");
                        e11.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e12) {
                        e = e12;
                        C1190ay.m17177a(e, "HttpUrlUtil", "postRequest2");
                        e.printStackTrace();
                        return c1229bv;
                    }
                }
                return c1229bv;
            } catch (Throwable th4) {
                th = th4;
                C1190ay.m17177a(th, "HttpUrlUtil", "postRequest2");
                th.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e13) {
                        C1190ay.m17177a(e13, "HttpUrlUtil", "postRequest2");
                        e13.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e14) {
                        e = e14;
                        C1190ay.m17177a(e, "HttpUrlUtil", "postRequest2");
                        e.printStackTrace();
                        return c1229bv;
                    }
                }
                return c1229bv;
            }
        } catch (IOException e15) {
            e2 = e15;
            inputStream2 = null;
        } catch (IllegalStateException e16) {
            e = e16;
            inputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream2 = null;
        }
        return c1229bv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1229bv m17066a(String str, Map<String, String> map, Map<String, String> map2, byte[] bArr) {
        if (map2 != null) {
            try {
                String m17062a = m17062a(map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (m17062a != null) {
                    stringBuffer.append(C0228a.f351a).append(m17062a);
                }
                str = stringBuffer.toString();
            } catch (Throwable th) {
                C1190ay.m17177a(th, "HttpUrlUtil", "PostReqeust3");
                th.printStackTrace();
                return null;
            }
        }
        return m17065a(str, map, bArr);
    }

    /* renamed from: a */
    C1229bv m17065a(String str, Map<String, String> map, byte[] bArr) {
        try {
            HttpURLConnection m17063a = m17063a(new URL(str));
            m17061a(map, m17063a);
            m17063a.setRequestMethod("POST");
            m17063a.setUseCaches(false);
            m17063a.setDoInput(true);
            m17063a.setDoOutput(true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(m17063a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            m17063a.connect();
            return m17064a(m17063a);
        } catch (MalformedURLException e) {
            C1190ay.m17177a(e, "HttpUrlUtil", "postRequest");
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            C1190ay.m17177a(e2, "HttpUrlUtil", "postRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "HttpUrlUtil", "postRequest");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public C1229bv m17060b(String str, Map<String, String> map, Map<String, String> map2) {
        String m17062a = m17062a(map2);
        if (m17062a == null) {
            return m17065a(str, map, new byte[0]);
        }
        try {
            return m17065a(str, map, m17062a.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C1190ay.m17177a(e, "HttpUrlUtil", "postRequest1");
            e.printStackTrace();
            return m17065a(str, map, m17062a.getBytes());
        }
    }
}
