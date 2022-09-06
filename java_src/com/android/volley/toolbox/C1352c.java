package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AbstractC1317b;
import com.android.volley.AbstractC1326g;
import com.android.volley.AbstractC1333n;
import com.android.volley.AbstractC1345r;
import com.android.volley.C1316a;
import com.android.volley.C1328i;
import com.android.volley.C1329j;
import com.android.volley.C1330k;
import com.android.volley.C1332m;
import com.android.volley.C1346s;
import com.android.volley.C1347t;
import com.android.volley.C1384u;
import com.android.volley.C1385v;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;
import org.p248a.p249a.C5083e;
/* renamed from: com.android.volley.toolbox.c */
/* loaded from: classes.dex */
public class C1352c implements AbstractC1326g {

    /* renamed from: a */
    protected static final boolean f4635a = C1385v.f4718b;

    /* renamed from: d */
    private static int f4636d = 3000;

    /* renamed from: e */
    private static int f4637e = 4096;

    /* renamed from: b */
    protected final AbstractC1363i f4638b;

    /* renamed from: c */
    protected final C1353d f4639c;

    public C1352c(AbstractC1363i abstractC1363i) {
        this(abstractC1363i, new C1353d(f4637e));
    }

    public C1352c(AbstractC1363i abstractC1363i, C1353d c1353d) {
        this.f4638b = abstractC1363i;
        this.f4639c = c1353d;
    }

    /* renamed from: a */
    protected static Map<String, String> m16666a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    /* renamed from: a */
    private void m16672a(long j, AbstractC1333n<?> abstractC1333n, byte[] bArr, StatusLine statusLine) {
        if (f4635a || j > f4636d) {
            Object[] objArr = new Object[5];
            objArr[0] = abstractC1333n;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(abstractC1333n.m16702z().mo16681b());
            C1385v.m16565b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: a */
    private static void m16670a(String str, AbstractC1333n<?> abstractC1333n, C1384u c1384u) {
        AbstractC1345r m16702z = abstractC1333n.m16702z();
        int m16703y = abstractC1333n.m16703y();
        try {
            m16702z.mo16682a(c1384u);
            abstractC1333n.m16726a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(m16703y)));
        } catch (C1384u e) {
            abstractC1333n.m16726a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(m16703y)));
            throw e;
        }
    }

    /* renamed from: a */
    private void m16668a(Map<String, String> map, AbstractC1317b.C1318a c1318a) {
        if (c1318a == null) {
            return;
        }
        if (c1318a.f4531b != null) {
            map.put(C5083e.f21640D, c1318a.f4531b);
        }
        if (c1318a.f4533d <= 0) {
            return;
        }
        map.put(C5083e.f21639C, DateUtils.formatDate(new Date(c1318a.f4533d)));
    }

    /* renamed from: a */
    private byte[] m16667a(HttpEntity httpEntity) {
        C1380q c1380q = new C1380q(this.f4639c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new C1346s();
            }
            byte[] m16664a = this.f4639c.m16664a(1024);
            while (true) {
                int read = content.read(m16664a);
                if (read == -1) {
                    break;
                }
                c1380q.write(m16664a, 0, read);
            }
            byte[] byteArray = c1380q.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C1385v.m16567a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f4639c.m16663a(m16664a);
            c1380q.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                C1385v.m16567a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f4639c.m16663a((byte[]) null);
            c1380q.close();
            throw th;
        }
    }

    @Override // com.android.volley.AbstractC1326g
    /* renamed from: a */
    public C1329j mo16671a(AbstractC1333n<?> abstractC1333n) {
        byte[] bArr;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> emptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap hashMap = new HashMap();
                    m16668a(hashMap, abstractC1333n.m16710k());
                    HttpResponse mo16631a = this.f4638b.mo16631a(abstractC1333n, hashMap);
                    try {
                        StatusLine statusLine = mo16631a.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        emptyMap = m16666a(mo16631a.getAllHeaders());
                        if (statusCode == 304) {
                            AbstractC1317b.C1318a m16710k = abstractC1333n.m16710k();
                            if (m16710k == null) {
                                return new C1329j(304, null, emptyMap, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                            m16710k.f4536g.putAll(emptyMap);
                            return new C1329j(304, m16710k.f4530a, m16710k.f4536g, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                        }
                        if (statusCode == 301 || statusCode == 302) {
                            abstractC1333n.m16718c(emptyMap.get(C5083e.f21644H));
                        }
                        byte[] m16667a = mo16631a.getEntity() != null ? m16667a(mo16631a.getEntity()) : new byte[0];
                        try {
                            m16672a(SystemClock.elapsedRealtime() - elapsedRealtime, abstractC1333n, m16667a, statusLine);
                            if (statusCode >= 200 && statusCode <= 299) {
                                return new C1329j(statusCode, m16667a, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                            throw new IOException();
                        } catch (IOException e) {
                            e = e;
                            bArr = m16667a;
                            httpResponse = mo16631a;
                            if (httpResponse == null) {
                                throw new C1330k(e);
                            }
                            int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                            if (statusCode2 == 301 || statusCode2 == 302) {
                                C1385v.m16563c("Request at %s has been redirected to %s", abstractC1333n.m16713h(), abstractC1333n.m16714g());
                            } else {
                                C1385v.m16563c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), abstractC1333n.m16714g());
                            }
                            if (bArr == null) {
                                throw new C1328i(e);
                            }
                            C1329j c1329j = new C1329j(statusCode2, bArr, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (statusCode2 == 401 || statusCode2 == 403) {
                                m16670a("auth", abstractC1333n, new C1316a(c1329j));
                            } else if (statusCode2 != 301 && statusCode2 != 302) {
                                throw new C1346s(c1329j);
                            } else {
                                m16670a("redirect", abstractC1333n, new C1332m(c1329j));
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bArr = null;
                        httpResponse = mo16631a;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                }
            } catch (MalformedURLException e4) {
                throw new RuntimeException("Bad URL " + abstractC1333n.m16714g(), e4);
            } catch (SocketTimeoutException e5) {
                m16670a("socket", abstractC1333n, new C1347t());
            } catch (ConnectTimeoutException e6) {
                m16670a("connection", abstractC1333n, new C1347t());
            }
        }
    }

    /* renamed from: a */
    protected void m16669a(String str, String str2, long j) {
        C1385v.m16567a("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }
}
