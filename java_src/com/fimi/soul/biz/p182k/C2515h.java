package com.fimi.soul.biz.p182k;

import com.facebook.common.util.UriUtil;
import com.google.gson.Gson;
import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.android.model.HttpMethod;
import com.xiaomi.infra.galaxy.fds.android.model.InitMultipartUploadResult;
import com.xiaomi.infra.galaxy.fds.android.model.ObjectMetadata;
import com.xiaomi.infra.galaxy.fds.android.model.ProgressListener;
import com.xiaomi.infra.galaxy.fds.android.model.PutObjectResult;
import com.xiaomi.infra.galaxy.fds.android.model.UploadPartResult;
import com.xiaomi.infra.galaxy.fds.android.model.UploadPartResultList;
import com.xiaomi.infra.galaxy.fds.android.model.UserParam;
import com.xiaomi.infra.galaxy.fds.android.util.Args;
import com.xiaomi.infra.galaxy.fds.android.util.Consts;
import com.xiaomi.infra.galaxy.fds.android.util.RequestFactory;
import com.xiaomi.infra.galaxy.fds.android.util.Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
/* renamed from: com.fimi.soul.biz.k.h */
/* loaded from: classes.dex */
public class C2515h {

    /* renamed from: b */
    String f8703b;

    /* renamed from: c */
    String f8704c;

    /* renamed from: d */
    List<UserParam> f8705d;

    /* renamed from: e */
    BufferedInputStream f8706e;

    /* renamed from: f */
    ByteArrayOutputStream f8707f;

    /* renamed from: g */
    ObjectMetadata f8708g;

    /* renamed from: h */
    ProgressListener f8709h;

    /* renamed from: i */
    C2512f f8710i;

    /* renamed from: j */
    public File f8711j;

    /* renamed from: l */
    ArrayList f8713l;

    /* renamed from: m */
    private final C2510d f8714m;

    /* renamed from: n */
    private final HttpClient f8715n;

    /* renamed from: o */
    private long f8716o;

    /* renamed from: s */
    private long f8720s;

    /* renamed from: a */
    String f8702a = null;

    /* renamed from: p */
    private boolean f8717p = false;

    /* renamed from: q */
    private int f8718q = 1;

    /* renamed from: r */
    private int f8719r = 0;

    /* renamed from: k */
    int f8712k = 0;

    public C2515h(C2510d c2510d) {
        this.f8710i = null;
        this.f8714m = c2510d;
        this.f8715n = m11813a(this.f8714m);
        this.f8710i = new C2512f();
    }

    @Deprecated
    public C2515h(String str, GalaxyFDSCredential galaxyFDSCredential, C2510d c2510d) {
        this.f8710i = null;
        this.f8714m = c2510d;
        this.f8714m.m11878a(galaxyFDSCredential);
        this.f8715n = m11813a(this.f8714m);
        this.f8710i = new C2512f();
    }

    /* renamed from: a */
    private InitMultipartUploadResult m11811a(String str, String str2, long j) {
        String str3 = this.f8714m.m11833r() + "/" + str + "/" + (str2 == null ? "" : str2) + "?uploads";
        InputStream inputStream = null;
        try {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Consts.ESTIMATED_OBJECT_SIZE, Long.toString(j));
                HttpResponse execute = this.f8715n.execute(RequestFactory.createRequest(str3, this.f8714m.m11855f(), str2 == null ? HttpMethod.POST : HttpMethod.PUT, hashMap));
                inputStream = execute.getEntity().getContent();
                if (execute.getStatusLine().getStatusCode() != 200) {
                    throw new GalaxyFDSClientException("Unable to upload object[" + str + "/" + str2 + "] to URI :" + str3 + ". Fail to initiate multipart upload: " + execute.getStatusLine().toString());
                }
                InitMultipartUploadResult initMultipartUploadResult = (InitMultipartUploadResult) new Gson().fromJson((Reader) new InputStreamReader(inputStream), (Class<Object>) InitMultipartUploadResult.class);
                this.f8704c = initMultipartUploadResult.getObjectName();
                if (initMultipartUploadResult == null || initMultipartUploadResult.getUploadId() == null || initMultipartUploadResult.getObjectName() == null || initMultipartUploadResult.getBucketName() == null) {
                    throw new GalaxyFDSClientException("Fail to parse the result of init multipart upload. bucket name:" + str + ", object name:" + str2);
                }
                this.f8702a = initMultipartUploadResult.getUploadId();
                return initMultipartUploadResult;
            } catch (IOException e) {
                throw new GalaxyFDSClientException("Fail to initiate multipart upload. URI:" + str3, e);
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* renamed from: a */
    private PutObjectResult m11808a(String str, String str2, String str3, ObjectMetadata objectMetadata, UploadPartResultList uploadPartResultList, List<UserParam> list) {
        Map<String, String> allMetadata;
        ?? sb = new StringBuilder();
        sb.append(this.f8714m.m11833r() + "/" + str2 + "/" + str3 + "?uploadId=" + str);
        if (list != null) {
            for (UserParam userParam : list) {
                sb.append('&');
                sb.append(userParam.toString());
            }
        }
        String sb2 = sb.toString();
        try {
            if (objectMetadata != null) {
                try {
                    allMetadata = objectMetadata.getAllMetadata();
                } catch (IOException e) {
                    e = e;
                    this.f8710i.m11830a(false);
                    throw new GalaxyFDSClientException("Fail to complete multipart upload. URI:" + sb2, e);
                } catch (Throwable th) {
                    th = th;
                    sb = 0;
                    if (sb != 0) {
                        try {
                            sb.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } else {
                allMetadata = null;
            }
            HttpPut createRequest = RequestFactory.createRequest(sb2, this.f8714m.m11855f(), HttpMethod.PUT, allMetadata);
            createRequest.setEntity(new StringEntity(new Gson().toJson(uploadPartResultList)));
            HttpResponse execute = this.f8715n.execute(createRequest);
            InputStream content = execute.getEntity().getContent();
            try {
                if (execute.getStatusLine().getStatusCode() != 200) {
                    throw new GalaxyFDSClientException("Unable to upload object[" + str2 + "/" + str3 + "] to URI :" + sb2 + ". Fail to complete multipart upload: " + execute.getStatusLine().toString());
                }
                PutObjectResult putObjectResult = (PutObjectResult) new Gson().fromJson((Reader) new InputStreamReader(content), (Class<Object>) PutObjectResult.class);
                if (putObjectResult == null || putObjectResult.getAccessKeyId() == null || putObjectResult.getSignature() == null || putObjectResult.getExpires() == 0) {
                    throw new GalaxyFDSClientException("Fail to parse the result of completing multipart upload. bucket name:" + str2 + ", object name:" + str3 + ", upload ID:" + str);
                }
                putObjectResult.setFdsServiceBaseUri(this.f8714m.m11836o());
                putObjectResult.setCdnServiceBaseUri(this.f8714m.m11835p());
                this.f8710i.m11828b(putObjectResult.getObjectName());
                this.f8710i.m11826c(putObjectResult.getAbsolutePresignedUri());
                if (content != null) {
                    try {
                        content.close();
                    } catch (IOException e3) {
                    }
                }
                return putObjectResult;
            } catch (IOException e4) {
                e = e4;
                this.f8710i.m11830a(false);
                throw new GalaxyFDSClientException("Fail to complete multipart upload. URI:" + sb2, e);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private UploadPartResult m11809a(String str, String str2, String str3, int i, byte[] bArr) {
        HttpResponse execute;
        InputStream content;
        String str4 = this.f8714m.m11833r() + "/" + str2 + "/" + str3 + "?uploadId=" + str + "&partNumber=" + i;
        InputStream inputStream = null;
        while (true) {
            try {
                if (!this.f8717p) {
                    try {
                        HttpPut createRequest = RequestFactory.createRequest(str4, this.f8714m.m11855f(), HttpMethod.PUT, null);
                        createRequest.setEntity(new ByteArrayEntity(bArr));
                        execute = this.f8715n.execute(createRequest);
                        content = execute.getEntity().getContent();
                        break;
                    } catch (GalaxyFDSClientException e) {
                        InputStream inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        inputStream = inputStream2;
                    } catch (IOException e3) {
                        throw new GalaxyFDSClientException("Fail to put part. URI:" + str4, e3);
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        }
        if (execute.getStatusLine().getStatusCode() != 200) {
            throw new GalaxyFDSClientException("Unable to upload object[" + str2 + "/" + str3 + "] to URI :" + str4 + ". Fail to upload part " + i + ": " + execute.getStatusLine().toString());
        }
        UploadPartResult uploadPartResult = (UploadPartResult) new Gson().fromJson((Reader) new InputStreamReader(content), (Class<Object>) UploadPartResult.class);
        if (uploadPartResult == null || uploadPartResult.getEtag() == null || uploadPartResult.getPartSize() == 0) {
            throw new GalaxyFDSClientException("Fail to parse the result of uploading part. bucket name:" + str2 + ", object name:" + str3 + ", upload ID:" + str);
        }
        if (content != null) {
            try {
                content.close();
            } catch (IOException e5) {
            }
        }
        return uploadPartResult;
    }

    /* renamed from: a */
    private HttpClient m11813a(C2510d c2510d) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, c2510d.m11867c());
        HttpConnectionParams.setSoTimeout(basicHttpParams, c2510d.m11873b());
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        int i = c2510d.m11863d()[0];
        int i2 = c2510d.m11863d()[1];
        if (i > 0 || i2 > 0) {
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, Math.max(i, i2));
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(UriUtil.HTTP_SCHEME, PlainSocketFactory.getSocketFactory(), 80));
        if (c2510d.m11841j()) {
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, socketFactory, 443));
        }
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    /* renamed from: a */
    private void m11810a(String str, String str2, String str3) {
        InputStream inputStream = null;
        String str4 = this.f8714m.m11833r() + "/" + str + "/" + str2 + "?uploadId=" + str3;
        try {
            try {
                HttpResponse execute = this.f8715n.execute(RequestFactory.createRequest(str4, this.f8714m.m11855f(), HttpMethod.DELETE, null));
                inputStream = execute.getEntity().getContent();
                if (execute.getStatusLine().getStatusCode() != 200) {
                    throw new GalaxyFDSClientException("Unable to upload object[" + str + "/" + str2 + "] to URI :" + str4 + ". Fail to abort multipart upload: " + execute.getStatusLine().toString());
                } else if (inputStream == null) {
                } else {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                this.f8710i.m11830a(false);
                throw new GalaxyFDSClientException("Fail to abort multipart upload. URI:" + str4, e2);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public int m11815a() {
        return this.f8718q;
    }

    /* renamed from: a */
    public void m11814a(int i) {
        this.f8718q = i;
    }

    /* renamed from: a */
    public void m11812a(String str, File file, List<UserParam> list, ProgressListener progressListener) {
        Args.notNull(file, "file");
        this.f8703b = str;
        this.f8711j = file;
        this.f8709h = progressListener;
        this.f8705d = list;
        try {
            this.f8706e = new BufferedInputStream(new FileInputStream(file));
            this.f8716o = file.length();
            this.f8708g = new ObjectMetadata();
            this.f8708g.setContentLength(file.length());
            this.f8708g.setContentType(Util.getMimeType(file));
            this.f8708g.setLastModified(new Date(file.lastModified()));
            this.f8704c = UUID.randomUUID().toString() + file.getName().substring(file.getName().lastIndexOf("."));
            m11811a(str, this.f8704c, this.f8708g.getContentLength());
        } catch (FileNotFoundException e) {
            throw new GalaxyFDSClientException("Unable to find the file to be uploaded:" + file.getAbsolutePath(), e);
        }
    }

    /* renamed from: b */
    public C2512f m11807b() {
        int read;
        int m11859e = this.f8714m.m11859e();
        UploadPartResultList uploadPartResultList = new UploadPartResultList();
        try {
            this.f8706e = new BufferedInputStream(new FileInputStream(this.f8711j));
            if (this.f8720s > 0) {
                this.f8706e.skip(this.f8716o - this.f8720s);
            } else {
                this.f8720s = this.f8716o;
                this.f8719r = (int) (this.f8720s % ((long) m11859e) == 0 ? this.f8720s / m11859e : (this.f8720s / m11859e) + 1);
                this.f8713l = new ArrayList(this.f8719r);
            }
            int i = (int) (this.f8720s % ((long) m11859e) == 0 ? this.f8720s / m11859e : (this.f8720s / m11859e) + 1);
            for (int i2 = this.f8718q; i2 <= this.f8719r; i2++) {
                long min = Math.min(m11859e, this.f8720s);
                this.f8707f = new ByteArrayOutputStream((int) min);
                byte[] bArr = new byte[1048576];
                while (!this.f8717p) {
                    int min2 = Math.min(bArr.length, (int) min);
                    if (min <= 0 || (read = this.f8706e.read(bArr, 0, min2)) == -1) {
                        break;
                    }
                    this.f8707f.write(bArr, 0, read);
                    min -= read;
                    this.f8720s -= read;
                    this.f8712k = read + this.f8712k;
                    this.f8709h.onProgress(this.f8712k, this.f8716o);
                }
                UploadPartResult m11809a = m11809a(this.f8702a, this.f8703b, this.f8704c, i2, this.f8707f.toByteArray());
                if (m11809a != null) {
                    this.f8713l.add(m11809a);
                }
                this.f8718q = i2 + 1;
            }
            uploadPartResultList.setUploadPartResultList(this.f8713l);
            m11808a(this.f8702a, this.f8703b, this.f8704c, this.f8708g, uploadPartResultList, this.f8705d);
            this.f8710i.m11830a(true);
        } catch (GalaxyFDSClientException e) {
            try {
                m11810a(this.f8703b, this.f8704c, this.f8702a);
            } catch (GalaxyFDSClientException e2) {
                e2.printStackTrace();
                this.f8710i.m11830a(false);
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            this.f8710i.m11830a(false);
        } catch (IOException e4) {
            e4.printStackTrace();
            this.f8710i.m11830a(false);
        }
        return this.f8710i;
    }

    /* renamed from: c */
    public void m11806c() {
        this.f8717p = true;
    }

    /* renamed from: d */
    public void m11805d() {
        Thread.interrupted();
        this.f8718q = 0;
        this.f8720s = 0L;
    }

    /* renamed from: e */
    public C2512f m11804e() {
        this.f8717p = false;
        return m11807b();
    }
}
