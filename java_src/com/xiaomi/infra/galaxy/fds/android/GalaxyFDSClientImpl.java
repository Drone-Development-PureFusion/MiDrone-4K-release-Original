package com.xiaomi.infra.galaxy.fds.android;

import android.util.Log;
import com.google.gson.Gson;
import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.android.model.FDSObject;
import com.xiaomi.infra.galaxy.fds.android.model.HttpMethod;
import com.xiaomi.infra.galaxy.fds.android.model.InitMultipartUploadResult;
import com.xiaomi.infra.galaxy.fds.android.model.ObjectMetadata;
import com.xiaomi.infra.galaxy.fds.android.model.ProgressListener;
import com.xiaomi.infra.galaxy.fds.android.model.PutObjectResult;
import com.xiaomi.infra.galaxy.fds.android.model.ThumbParam;
import com.xiaomi.infra.galaxy.fds.android.model.UploadPartResult;
import com.xiaomi.infra.galaxy.fds.android.model.UploadPartResultList;
import com.xiaomi.infra.galaxy.fds.android.model.UserParam;
import com.xiaomi.infra.galaxy.fds.android.util.Args;
import com.xiaomi.infra.galaxy.fds.android.util.Consts;
import com.xiaomi.infra.galaxy.fds.android.util.ObjectInputStream;
import com.xiaomi.infra.galaxy.fds.android.util.RequestFactory;
import com.xiaomi.infra.galaxy.fds.android.util.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public class GalaxyFDSClientImpl implements GalaxyFDSClient {
    private static final String HTTPS_SCHEME = "https";
    private static final String HTTP_SCHEME = "http";
    private static final String LOG_TAG = "GalaxyFDSClientImpl";
    private static final boolean TEST_MODE;
    private final FDSClientConfiguration config;
    private final HttpClient httpClient;

    static {
        String property = System.getProperty("java.runtime.name");
        if (property == null || !property.equals("android runtime")) {
            TEST_MODE = true;
        } else {
            TEST_MODE = false;
        }
    }

    public GalaxyFDSClientImpl(FDSClientConfiguration fDSClientConfiguration) {
        this.config = fDSClientConfiguration;
        this.httpClient = createHttpClient(this.config);
    }

    @Deprecated
    public GalaxyFDSClientImpl(String str, GalaxyFDSCredential galaxyFDSCredential, FDSClientConfiguration fDSClientConfiguration) {
        this.config = fDSClientConfiguration;
        this.config.setCredential(galaxyFDSCredential);
        this.httpClient = createHttpClient(this.config);
    }

    private void abortMultipartUpload(String str, String str2, String str3) {
        InputStream inputStream = null;
        String str4 = this.config.getUploadBaseUri() + "/" + str + "/" + str2 + "?uploadId=" + str3;
        try {
            try {
                HttpResponse execute = this.httpClient.execute(RequestFactory.createRequest(str4, this.config.getCredential(), HttpMethod.DELETE, null));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    private PutObjectResult completeMultipartUpload(String str, String str2, String str3, ObjectMetadata objectMetadata, UploadPartResultList uploadPartResultList, List<UserParam> list) {
        Map<String, String> allMetadata;
        ?? sb = new StringBuilder();
        sb.append(this.config.getUploadBaseUri() + "/" + str2 + "/" + str3 + "?uploadId=" + str);
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
            HttpPut createRequest = RequestFactory.createRequest(sb2, this.config.getCredential(), HttpMethod.PUT, allMetadata);
            createRequest.setEntity(new StringEntity(new Gson().toJson(uploadPartResultList)));
            HttpResponse execute = this.httpClient.execute(createRequest);
            InputStream content = execute.getEntity().getContent();
            try {
                if (execute.getStatusLine().getStatusCode() != 200) {
                    throw new GalaxyFDSClientException("Unable to upload object[" + str2 + "/" + str3 + "] to URI :" + sb2 + ". Fail to complete multipart upload: " + execute.getStatusLine().toString());
                }
                PutObjectResult putObjectResult = (PutObjectResult) new Gson().fromJson((Reader) new InputStreamReader(content), (Class<Object>) PutObjectResult.class);
                if (putObjectResult == null || putObjectResult.getAccessKeyId() == null || putObjectResult.getSignature() == null || putObjectResult.getExpires() == 0) {
                    throw new GalaxyFDSClientException("Fail to parse the result of completing multipart upload. bucket name:" + str2 + ", object name:" + str3 + ", upload ID:" + str);
                }
                putObjectResult.setFdsServiceBaseUri(this.config.getBaseUri());
                putObjectResult.setCdnServiceBaseUri(this.config.getCdnBaseUri());
                if (content != null) {
                    try {
                        content.close();
                    } catch (IOException e3) {
                    }
                }
                return putObjectResult;
            } catch (IOException e4) {
                e = e4;
                throw new GalaxyFDSClientException("Fail to complete multipart upload. URI:" + sb2, e);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private HttpClient createHttpClient(FDSClientConfiguration fDSClientConfiguration) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, fDSClientConfiguration.getConnectionTimeoutMs());
        HttpConnectionParams.setSoTimeout(basicHttpParams, fDSClientConfiguration.getSocketTimeoutMs());
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        int i = fDSClientConfiguration.getSocketBufferSizeHints()[0];
        int i2 = fDSClientConfiguration.getSocketBufferSizeHints()[1];
        if (i > 0 || i2 > 0) {
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, Math.max(i, i2));
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (fDSClientConfiguration.isHttpsEnabled()) {
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            schemeRegistry.register(new Scheme("https", socketFactory, 443));
        }
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private InitMultipartUploadResult initMultipartUpload(String str, String str2, long j) {
        String str3 = this.config.getUploadBaseUri() + "/" + str + "/" + (str2 == null ? "" : str2) + "?uploads";
        InputStream inputStream = null;
        try {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Consts.ESTIMATED_OBJECT_SIZE, Long.toString(j));
                HttpResponse execute = this.httpClient.execute(RequestFactory.createRequest(str3, this.config.getCredential(), str2 == null ? HttpMethod.POST : HttpMethod.PUT, hashMap));
                inputStream = execute.getEntity().getContent();
                if (execute.getStatusLine().getStatusCode() != 200) {
                    throw new GalaxyFDSClientException("Unable to upload object[" + str + "/" + str2 + "] to URI :" + str3 + ". Fail to initiate multipart upload: " + execute.getStatusLine().toString());
                }
                InitMultipartUploadResult initMultipartUploadResult = (InitMultipartUploadResult) new Gson().fromJson((Reader) new InputStreamReader(inputStream), (Class<Object>) InitMultipartUploadResult.class);
                if (initMultipartUploadResult != null && initMultipartUploadResult.getUploadId() != null && initMultipartUploadResult.getObjectName() != null && initMultipartUploadResult.getBucketName() != null) {
                    return initMultipartUploadResult;
                }
                throw new GalaxyFDSClientException("Fail to parse the result of init multipart upload. bucket name:" + str + ", object name:" + str2);
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

    private boolean isGetThumbnail(List<UserParam> list) {
        if (list != null) {
            for (UserParam userParam : list) {
                if (userParam instanceof ThumbParam) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
        if (r2.getStatusLine().getStatusCode() == 200) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e8, code lost:
        throw new com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException("Unable to upload object[" + r14 + "/" + r15 + "] to URI :" + r6 + ". Fail to upload part " + r16 + ": " + r2.getStatusLine().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x013a, code lost:
        r2 = (com.xiaomi.infra.galaxy.fds.android.model.UploadPartResult) new com.google.gson.Gson().fromJson((java.io.Reader) new java.io.InputStreamReader(r3), (java.lang.Class<java.lang.Object>) com.xiaomi.infra.galaxy.fds.android.model.UploadPartResult.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x014c, code lost:
        if (r2 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0152, code lost:
        if (r2.getEtag() == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x015c, code lost:
        if (r2.getPartSize() != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x018b, code lost:
        if (r3 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x018d, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x018a, code lost:
        throw new com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException("Fail to parse the result of uploading part. bucket name:" + r14 + ", object name:" + r15 + ", upload ID:" + r13);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0191 A[Catch: all -> 0x010f, TRY_ENTER, TryCatch #9 {all -> 0x010f, blocks: (B:21:0x0092, B:23:0x009e, B:24:0x00e8, B:26:0x013a, B:28:0x014e, B:30:0x0154, B:38:0x015e, B:39:0x018a, B:41:0x00ea, B:42:0x0102, B:49:0x0106, B:64:0x010e, B:51:0x0191, B:53:0x0195), top: B:48:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private UploadPartResult uploadPart(String str, String str2, String str3, int i, ObjectInputStream objectInputStream, long j) {
        int i2;
        UploadPartResult uploadPartResult;
        String str4 = "&partNumber=";
        String str5 = this.config.getUploadBaseUri() + "/" + str2 + "/" + str3 + "?uploadId=" + str + str4 + i;
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) j);
        long j2 = j;
        while (j2 != 0) {
            try {
                int read = objectInputStream.read(bArr, 0, Math.min(bArr.length, (int) j2));
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                j2 -= read;
            } catch (IOException e) {
                throw new GalaxyFDSClientException("Fail to read data from input stream, size:" + j, e);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
        }
        Object obj = null;
        int i3 = 0;
        ?? r3 = str4;
        while (true) {
            try {
                try {
                    HttpPut createRequest = RequestFactory.createRequest(str5, this.config.getCredential(), HttpMethod.PUT, null);
                    createRequest.setEntity(new ByteArrayEntity(byteArray));
                    try {
                        HttpResponse execute = this.httpClient.execute(createRequest);
                        InputStream content = execute.getEntity().getContent();
                        try {
                            break;
                        } catch (IOException e3) {
                            e = e3;
                            throw new GalaxyFDSClientException("Fail to put part. URI:" + str5, e);
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (GalaxyFDSClientException e5) {
                    e = e5;
                    i2 = i3 + 1;
                    try {
                        if (i2 < this.config.getMaxRetryTimes()) {
                            throw e;
                        }
                        if (!TEST_MODE) {
                            Log.i(LOG_TAG, "Retry the upload of object:" + str3 + " bucket:" + str2 + " upload id:" + str + " part number:" + i + " cause:" + Util.getStackTrace(e));
                        }
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (IOException e6) {
                            }
                        }
                        i3 = i2;
                        obj = r3;
                        r3 = r3;
                    } catch (Throwable th) {
                        th = th;
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (GalaxyFDSClientException e8) {
                e = e8;
                r3 = obj;
                i2 = i3 + 1;
                if (i2 < this.config.getMaxRetryTimes()) {
                }
            } catch (Throwable th2) {
                th = th2;
                r3 = obj;
                if (r3 != 0) {
                }
                throw th;
            }
            i3 = i2;
            obj = r3;
            r3 = r3;
        }
        return uploadPartResult;
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public boolean doesObjectExist(String str, String str2) {
        HttpResponse execute;
        Args.notNull(str, "bucket name");
        Args.notEmpty(str, "bucket name");
        Args.notNull(str2, "object name");
        Args.notEmpty(str2, "object name");
        String str3 = this.config.getBaseUri() + "/" + str + "/" + str2;
        try {
            int statusCode = this.httpClient.execute(RequestFactory.createRequest(str3, this.config.getCredential(), HttpMethod.HEAD, null)).getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return true;
            }
            if (statusCode == 404) {
                return false;
            }
            throw new GalaxyFDSClientException("Unable to head object[" + str + "/" + str2 + "] from URI :" + str3 + ". Cause:" + execute.getStatusLine().toString());
        } catch (IOException e) {
            throw new GalaxyFDSClientException("Unable to head object[" + str + "/" + str2 + "] from URI :" + str3 + " Exception:" + e.getMessage(), e);
        }
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public FDSObject getObject(String str, long j, List<UserParam> list, ProgressListener progressListener) {
        InputStream inputStream;
        InputStream inputStream2;
        GalaxyFDSClientException galaxyFDSClientException = null;
        Args.notNull(str, "URI");
        Args.notNegative(j, "offset in content");
        if (list != null) {
            StringBuilder sb = new StringBuilder(str);
            for (UserParam userParam : list) {
                if (sb.indexOf(C0228a.f351a) == -1) {
                    sb.append('?');
                } else {
                    sb.append('&');
                }
                sb.append(userParam.toString());
            }
            str = sb.toString();
        }
        try {
            String path = new URI(str).getPath();
            int indexOf = path.indexOf(47, 1);
            if (indexOf == -1) {
                throw new URISyntaxException(str, "not a valid object URI");
            }
            String substring = path.substring(0, indexOf);
            String substring2 = path.substring(indexOf + 1);
            try {
                HashMap hashMap = new HashMap();
                if (j > 0 && !isGetThumbnail(list)) {
                    hashMap.put("Range", "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                HttpResponse execute = this.httpClient.execute(RequestFactory.createRequest(str, this.config.getCredential(), HttpMethod.GET, hashMap));
                inputStream = execute.getEntity().getContent();
                try {
                    int statusCode = execute.getStatusLine().getStatusCode();
                    if (statusCode == 200 || statusCode == 206) {
                        FDSObject fDSObject = new FDSObject(substring, substring2);
                        ObjectMetadata parseObjectMetadata = ObjectMetadata.parseObjectMetadata(execute.getAllHeaders());
                        fDSObject.setObjectContent(new ObjectInputStream(inputStream, parseObjectMetadata, progressListener));
                        fDSObject.setObjectMetadata(parseObjectMetadata);
                        if (0 != 0 && inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        return fDSObject;
                    }
                    GalaxyFDSClientException galaxyFDSClientException2 = new GalaxyFDSClientException("Unable to get object[" + substring + "/" + substring2 + "] from URI :" + str + ". Cause:" + execute.getStatusLine().toString());
                    try {
                        throw galaxyFDSClientException2;
                    } catch (IOException e2) {
                        e = e2;
                        galaxyFDSClientException = galaxyFDSClientException2;
                        inputStream2 = inputStream;
                        try {
                            GalaxyFDSClientException galaxyFDSClientException3 = new GalaxyFDSClientException("Unable to get object[" + substring + "/" + substring2 + "] from URI :" + str + " Exception:" + e.getMessage(), e);
                            try {
                                throw galaxyFDSClientException3;
                            } catch (Throwable th) {
                                th = th;
                                galaxyFDSClientException = galaxyFDSClientException3;
                                inputStream = inputStream2;
                                if (galaxyFDSClientException != null && inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        galaxyFDSClientException = galaxyFDSClientException2;
                        if (galaxyFDSClientException != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e5) {
                e = e5;
                inputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
        } catch (URISyntaxException e6) {
            throw new GalaxyFDSClientException("Invalid URI, can't parse bucket nameand object name form it:" + str, e6);
        }
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public FDSObject getObject(String str, String str2) {
        return getObject(str, str2, 0L, (List<UserParam>) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public FDSObject getObject(String str, String str2, long j, List<UserParam> list) {
        return getObject(str, str2, j, list, (ProgressListener) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public FDSObject getObject(String str, String str2, long j, List<UserParam> list, ProgressListener progressListener) {
        Args.notNull(str, "bucket name");
        Args.notEmpty(str, "bucket name");
        Args.notNull(str2, "object name");
        Args.notEmpty(str2, "object name");
        StringBuilder sb = new StringBuilder();
        sb.append(this.config.getDownloadBaseUri());
        sb.append("/" + str + "/" + str2);
        return getObject(sb.toString(), j, list, progressListener);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    @Deprecated
    public FDSObject getObject(String str, String str2, long j, List<UserParam> list, ProgressListener progressListener, boolean z) {
        return getObject(str, str2, j, list, progressListener);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public ObjectMetadata getObject(String str, File file, List<UserParam> list, ProgressListener progressListener) {
        long length;
        Args.notNull(file, "Destination file");
        boolean isGetThumbnail = isGetThumbnail(list);
        int i = 0;
        while (true) {
            boolean z = i != 0 && !isGetThumbnail;
            if (z) {
                try {
                    length = file.length();
                } catch (GalaxyFDSClientException e) {
                    int i2 = i + 1;
                    if (i2 >= this.config.getMaxRetryTimes()) {
                        throw e;
                    }
                    if (!TEST_MODE) {
                        Log.i(LOG_TAG, "Retry the download of object:" + str + " to file: " + file.getAbsolutePath() + " cause:" + Util.getStackTrace(e));
                    }
                    i = i2;
                }
            } else {
                length = 0;
            }
            FDSObject object = getObject(str, length, list, progressListener);
            Util.downloadObjectToFile(object, file, z);
            return object.getObjectMetadata();
        }
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public ObjectMetadata getObject(String str, String str2, File file) {
        return getObject(str, str2, file, (List<UserParam>) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public ObjectMetadata getObject(String str, String str2, File file, List<UserParam> list) {
        return getObject(str, str2, file, list, (ProgressListener) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public ObjectMetadata getObject(String str, String str2, File file, List<UserParam> list, ProgressListener progressListener) {
        long length;
        Args.notNull(file, "Destination file");
        boolean isGetThumbnail = isGetThumbnail(list);
        int i = 0;
        while (true) {
            boolean z = i != 0 && !isGetThumbnail;
            if (z) {
                try {
                    length = file.length();
                } catch (GalaxyFDSClientException e) {
                    int i2 = i + 1;
                    if (i2 >= this.config.getMaxRetryTimes()) {
                        throw e;
                    }
                    if (!TEST_MODE) {
                        Log.i(LOG_TAG, "Retry the download of object:" + str2 + " bucket:" + str + " to file: " + file.getAbsolutePath() + " cause:" + Util.getStackTrace(e));
                    }
                    i = i2;
                }
            } else {
                length = 0;
            }
            FDSObject object = getObject(str, str2, length, list, progressListener);
            Util.downloadObjectToFile(object, file, z);
            return object.getObjectMetadata();
        }
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    @Deprecated
    public ObjectMetadata getObject(String str, String str2, File file, List<UserParam> list, ProgressListener progressListener, boolean z) {
        return getObject(str, str2, file, list, progressListener);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, File file) {
        return putObject(str, file, (List<UserParam>) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, File file, List<UserParam> list) {
        return putObject(str, file, list, (ProgressListener) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, File file, List<UserParam> list, ProgressListener progressListener) {
        return putObject(str, (String) null, file, list, progressListener);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, InputStream inputStream, ObjectMetadata objectMetadata) {
        return putObject(str, inputStream, objectMetadata, (List<UserParam>) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, InputStream inputStream, ObjectMetadata objectMetadata, List<UserParam> list) {
        return putObject(str, inputStream, objectMetadata, list, (ProgressListener) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, InputStream inputStream, ObjectMetadata objectMetadata, List<UserParam> list, ProgressListener progressListener) {
        return putObject(str, null, inputStream, objectMetadata, list, progressListener);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, String str2, File file) {
        return putObject(str, str2, file, (List<UserParam>) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, String str2, File file, List<UserParam> list) {
        return putObject(str, str2, file, list, (ProgressListener) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, String str2, File file, List<UserParam> list, ProgressListener progressListener) {
        Args.notNull(file, "file");
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.length());
            objectMetadata.setContentType(Util.getMimeType(file));
            objectMetadata.setLastModified(new Date(file.lastModified()));
            return putObject(str, str2, bufferedInputStream, objectMetadata, list, progressListener);
        } catch (FileNotFoundException e) {
            throw new GalaxyFDSClientException("Unable to find the file to be uploaded:" + file.getAbsolutePath(), e);
        }
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return putObject(str, str2, inputStream, objectMetadata, (List<UserParam>) null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata, List<UserParam> list) {
        return putObject(str, str2, inputStream, objectMetadata, list, null);
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient
    public PutObjectResult putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata, List<UserParam> list, ProgressListener progressListener) {
        String str3;
        Args.notNull(str, "bucket name");
        Args.notEmpty(str, "bucket name");
        Args.notNull(inputStream, "input stream");
        Args.notNull(objectMetadata, "metadata");
        long contentLength = objectMetadata.getContentLength();
        Args.notNegative(contentLength, "content length");
        if (objectMetadata.getContentType() == null) {
            objectMetadata.setContentType(Consts.APPLICATION_OCTET_STREAM);
        }
        String str4 = null;
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream, objectMetadata, progressListener);
        try {
            try {
                InitMultipartUploadResult initMultipartUpload = initMultipartUpload(str, str2, objectMetadata.getContentLength());
                str3 = initMultipartUpload.getObjectName();
                try {
                    str4 = initMultipartUpload.getUploadId();
                    int uploadPartSize = this.config.getUploadPartSize();
                    int i = ((int) ((uploadPartSize + contentLength) - 1)) / uploadPartSize;
                    ArrayList arrayList = new ArrayList(i);
                    int i2 = 1;
                    long j = contentLength;
                    while (i2 <= i) {
                        long min = Math.min(uploadPartSize, j);
                        arrayList.add(uploadPart(str4, str, str3, i2, objectInputStream, min));
                        i2++;
                        j -= min;
                    }
                    UploadPartResultList uploadPartResultList = new UploadPartResultList();
                    uploadPartResultList.setUploadPartResultList(arrayList);
                    return completeMultipartUpload(str4, str, str3, objectMetadata, uploadPartResultList, list);
                } catch (GalaxyFDSClientException e) {
                    e = e;
                    if (str4 != null) {
                        abortMultipartUpload(str, str3, str4);
                    }
                    throw e;
                }
            } catch (GalaxyFDSClientException e2) {
                e = e2;
                str3 = str2;
            }
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e3) {
            }
        }
    }
}
