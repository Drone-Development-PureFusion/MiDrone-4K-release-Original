package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.tencent.stat.common.C4414e;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.AbstractC4401e;
import com.tencent.stat.p232a.EnumC4402f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.d */
/* loaded from: classes2.dex */
public class C4426d {

    /* renamed from: c */
    private static StatLogger f18469c = C4420k.m5197b();

    /* renamed from: d */
    private static long f18470d = -1;

    /* renamed from: e */
    private static C4426d f18471e = null;

    /* renamed from: f */
    private static Context f18472f = null;

    /* renamed from: a */
    DefaultHttpClient f18473a;

    /* renamed from: b */
    Handler f18474b;

    private C4426d() {
        this.f18473a = null;
        this.f18474b = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            f18470d = handlerThread.getId();
            this.f18474b = new Handler(handlerThread.getLooper());
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f18473a = new DefaultHttpClient(basicHttpParams);
            this.f18473a.setKeepAliveStrategy(new C4427e(this));
            if (StatConfig.m5289b() == null) {
                return;
            }
            this.f18473a.getParams().setParameter("http.route.default-proxy", StatConfig.m5289b());
        } catch (Throwable th) {
            f18469c.m5236e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Context m5148a() {
        return f18472f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5147a(Context context) {
        f18472f = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static synchronized C4426d m5144b() {
        C4426d c4426d;
        synchronized (C4426d.class) {
            if (f18471e == null) {
                f18471e = new C4426d();
            }
            c4426d = f18471e;
        }
        return c4426d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5146a(AbstractC4401e abstractC4401e, AbstractC4409c abstractC4409c) {
        m5143b(Arrays.asList(abstractC4401e.m5245d()), abstractC4409c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5145a(List<String> list, AbstractC4409c abstractC4409c) {
        boolean z = false;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb.append("]");
            String statReportUrl = StatConfig.getStatReportUrl();
            f18469c.m5235i("[" + statReportUrl + "]Send request(" + sb.toString().length() + "bytes):" + sb.toString());
            HttpPost httpPost = new HttpPost(statReportUrl);
            httpPost.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpPost.setHeader(C5083e.f21675j, "Keep-Alive");
            httpPost.removeHeaders("Cache-Control");
            HttpHost m5203a = C4420k.m5203a(f18472f);
            if (m5203a != null) {
                this.f18473a.getParams().setParameter("http.route.default-proxy", C4420k.m5203a(f18472f));
                httpPost.addHeader("X-Online-Host", StatConstants.MTA_SERVER);
                httpPost.addHeader(C5083e.f21663a, "*/*");
                httpPost.addHeader("Content-Type", "json");
                z = true;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = sb.toString().getBytes("UTF-8");
            int length = bytes.length;
            if (sb.length() >= 256) {
                if (m5203a == null) {
                    httpPost.addHeader("Content-Encoding", "rc4,gzip");
                } else {
                    httpPost.addHeader("X-Content-Encoding", "rc4,gzip");
                }
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                f18469c.m5238d("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
            } else if (m5203a == null) {
                httpPost.addHeader("Content-Encoding", "rc4");
            } else {
                httpPost.addHeader("X-Content-Encoding", "rc4");
            }
            httpPost.setEntity(new ByteArrayEntity(C4414e.m5226a(bytes)));
            HttpResponse execute = this.f18473a.execute(httpPost);
            if (z) {
                this.f18473a.getParams().removeParameter("http.route.default-proxy");
            }
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            f18469c.m5235i("recv response status code:" + statusCode + ", content length:" + contentLength);
            if (contentLength == 0) {
                EntityUtils.toString(entity);
                if (statusCode != 200) {
                    f18469c.error("Server response error code:" + statusCode);
                } else if (abstractC4409c != null) {
                    abstractC4409c.mo5110a();
                }
            } else if (contentLength > 0) {
                InputStream content = entity.getContent();
                DataInputStream dataInputStream = new DataInputStream(content);
                byte[] bArr = new byte[(int) entity.getContentLength()];
                dataInputStream.readFully(bArr);
                content.close();
                dataInputStream.close();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader != null) {
                    if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                        bArr = C4414e.m5224b(C4420k.m5198a(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                        bArr = C4420k.m5198a(C4414e.m5224b(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase(AsyncHttpClient.ENCODING_GZIP)) {
                        bArr = C4420k.m5198a(bArr);
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                        bArr = C4414e.m5224b(bArr);
                    }
                }
                if (statusCode == 200) {
                    String str = new String(bArr, "UTF-8");
                    f18469c.m5238d(str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.isNull("cfg")) {
                        StatConfig.m5291a(jSONObject.getJSONObject("cfg"));
                    }
                    if (!jSONObject.isNull("et") && !jSONObject.isNull("st")) {
                        f18469c.m5238d("get mid respone:" + str);
                        if (jSONObject.getInt("et") == EnumC4402f.SESSION_ENV.m5244a()) {
                            int i2 = jSONObject.getInt("st");
                            switch (i2) {
                                case -1:
                                case 0:
                                    if (!jSONObject.isNull(DeviceInfo.TAG_MID)) {
                                        StatMid.updateDeviceInfo(f18472f, jSONObject.getString(DeviceInfo.TAG_MID));
                                        break;
                                    }
                                    break;
                                default:
                                    f18469c.m5236e("error type for st:" + i2);
                                    break;
                            }
                        }
                    }
                    if (abstractC4409c != null) {
                        abstractC4409c.mo5110a();
                    }
                } else {
                    f18469c.error("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                }
                content.close();
            } else {
                EntityUtils.toString(entity);
            }
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            f18469c.m5236e(th);
            if (abstractC4409c == null) {
                return;
            }
            abstractC4409c.mo5109b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5143b(List<String> list, AbstractC4409c abstractC4409c) {
        if (list.isEmpty() || this.f18474b == null) {
            return;
        }
        this.f18474b.post(new RunnableC4428f(this, list, abstractC4409c));
    }
}
