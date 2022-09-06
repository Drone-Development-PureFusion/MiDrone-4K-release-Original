package com.tencent.open.weiyun;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.DataConvert;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p252c.p258f.C5078j;
/* loaded from: classes2.dex */
public class FileManager extends BaseApi {

    /* renamed from: a */
    private static final String[] f18242a = {"https://graph.qq.com/weiyun/get_photo_list", "https://graph.qq.com/weiyun/get_music_list", "https://graph.qq.com/weiyun/get_video_list"};

    /* renamed from: b */
    private static final String[] f18243b = {"https://graph.qq.com/weiyun/delete_photo", "https://graph.qq.com/weiyun/delete_music", "https://graph.qq.com/weiyun/delete_video"};

    /* loaded from: classes2.dex */
    private class DownLoadImp {
        private static final String DOWNLOAD_COOKIE_NAME = "dl_cookie_name";
        private static final String DOWNLOAD_COOKIE_VALUE = "dl_cookie_value";
        private static final String DOWNLOAD_ENCRYPT_URL = "dl_encrypt_url";
        private static final String DOWNLOAD_MUSIC_URL = "https://graph.qq.com/weiyun/download_music";
        private static final String DOWNLOAD_PIC_URL = "https://graph.qq.com/weiyun/download_photo";
        private static final int DOWNLOAD_PROGRESS = 1;
        private static final int DOWNLOAD_PROGRESS_DONE = 2;
        private static final String DOWNLOAD_SERVER_HOST = "dl_svr_host";
        private static final String DOWNLOAD_SERVER_PORT = "dl_svr_port";
        private static final String DOWNLOAD_THUMB_SIZE = "dl_thumb_size";
        private static final String DOWNLOAD_THUMB_URL = "https://graph.qq.com/weiyun/get_photo_thumb";
        private static final String DOWNLOAD_VIDEO_URL = "https://graph.qq.com/weiyun/download_video";
        private static final int GET_PERMISSON_DOWN = 0;
        private static final int MAX_ERROR_TIMES = 10;
        private IDownLoadFileCallBack mCallback;
        private Context mContext;
        private String mDownloadCookieName;
        private String mDownloadCookieValue;
        private String mDownloadEncryptUrl;
        private String mDownloadServerHost;
        private int mDownloadServerPort;
        private String mDownloadThumbSize;
        private File mFile;
        private WeiyunFileType mFileType;
        private Handler mHandler;
        private String mSavePath;
        private String mThumbSize;
        private WeiyunFile mWeiyunFile;

        public DownLoadImp(Context context, WeiyunFileType weiyunFileType, WeiyunFile weiyunFile, String str, IDownLoadFileCallBack iDownLoadFileCallBack) {
            this.mContext = context;
            this.mFileType = weiyunFileType;
            this.mWeiyunFile = weiyunFile;
            this.mSavePath = str;
            this.mCallback = iDownLoadFileCallBack;
            this.mHandler = new Handler(this.mContext.getMainLooper()) { // from class: com.tencent.open.weiyun.FileManager.DownLoadImp.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            JSONObject jSONObject = (JSONObject) message.obj;
                            try {
                                int i = jSONObject.getInt("ret");
                                if (i != 0) {
                                    DownLoadImp.this.mCallback.onError(new UiError(i, jSONObject.toString(), null));
                                    return;
                                }
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                DownLoadImp.this.mDownloadEncryptUrl = jSONObject2.getString(DownLoadImp.DOWNLOAD_ENCRYPT_URL);
                                DownLoadImp.this.mDownloadCookieName = jSONObject2.getString(DownLoadImp.DOWNLOAD_COOKIE_NAME);
                                DownLoadImp.this.mDownloadCookieValue = jSONObject2.getString(DownLoadImp.DOWNLOAD_COOKIE_VALUE);
                                DownLoadImp.this.mDownloadServerPort = jSONObject2.getInt(DownLoadImp.DOWNLOAD_SERVER_PORT);
                                DownLoadImp.this.mDownloadServerHost = jSONObject2.getString(DownLoadImp.DOWNLOAD_SERVER_HOST);
                                if (jSONObject2.has(DownLoadImp.DOWNLOAD_THUMB_SIZE)) {
                                    DownLoadImp.this.mDownloadThumbSize = jSONObject2.getString(DownLoadImp.DOWNLOAD_THUMB_SIZE);
                                }
                                DownLoadImp.this.mCallback.onDownloadStart();
                                DownLoadImp.this.doDownload();
                                return;
                            } catch (JSONException e) {
                                DownLoadImp.this.mCallback.onError(new UiError(-4, e.getMessage(), null));
                                return;
                            }
                        case 1:
                            DownLoadImp.this.mCallback.onDownloadProgress(Integer.parseInt((String) message.obj));
                            return;
                        case 2:
                            DownLoadImp.this.mCallback.onDownloadSuccess(DownLoadImp.this.mSavePath);
                            return;
                        default:
                            DownLoadImp.this.mCallback.onError(new UiError(message.what, (String) message.obj, null));
                            return;
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.open.weiyun.FileManager$DownLoadImp$3] */
        public void doDownload() {
            new Thread() { // from class: com.tencent.open.weiyun.FileManager.DownLoadImp.3
                /* JADX WARN: Removed duplicated region for block: B:31:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:78:0x03fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:83:0x03f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Thread, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    InputStream inputStream;
                    FileOutputStream fileOutputStream;
                    InputStream content;
                    InputStream inputStream2;
                    long j;
                    int i;
                    HttpResponse execute;
                    int statusCode;
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                    HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
                    HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
                    HttpProtocolParams.setUserAgent(basicHttpParams, "TX_QQF_ANDROID");
                    String str = "http://" + DownLoadImp.this.mDownloadServerHost + ":" + DownLoadImp.this.mDownloadServerPort + "/ftn_handler/" + DownLoadImp.this.mDownloadEncryptUrl + "/";
                    if (!TextUtils.isEmpty(DownLoadImp.this.mDownloadThumbSize)) {
                        str = str + "?size=" + DownLoadImp.this.mDownloadThumbSize;
                    }
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                    InputStream inputStream3 = null;
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        try {
                            FileOutputStream fileOutputStream3 = new FileOutputStream(new File(DownLoadImp.this.mSavePath));
                            try {
                                byte[] bArr = new byte[AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START];
                                try {
                                    if (TextUtils.isEmpty(DownLoadImp.this.mThumbSize)) {
                                        long fileSize = (DownLoadImp.this.mWeiyunFile.getFileSize() > 262144 ? 262144L : DownLoadImp.this.mWeiyunFile.getFileSize()) + 0;
                                        long j2 = 0;
                                        int i2 = 0;
                                        inputStream = null;
                                        while (true) {
                                            try {
                                                if (fileSize > DownLoadImp.this.mWeiyunFile.getFileSize()) {
                                                    inputStream2 = inputStream;
                                                    break;
                                                }
                                                HttpGet httpGet = new HttpGet(str);
                                                httpGet.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                                                httpGet.addHeader(C5083e.f21691z, DownLoadImp.this.mDownloadServerHost);
                                                httpGet.addHeader(C5083e.f21675j, "Keep-Alive");
                                                httpGet.addHeader("Cookie", DownLoadImp.this.mDownloadCookieName + "=" + DownLoadImp.this.mDownloadCookieValue);
                                                httpGet.addHeader(C5083e.f21648L, "no-cache");
                                                httpGet.addHeader("RANGE", "bytes=" + j2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + fileSize + "");
                                                try {
                                                    execute = defaultHttpClient.execute(httpGet);
                                                    C4331f.m5442c("weiyun_test", "uploadFileToWeiyun doDownloadPic response:" + execute.toString());
                                                    statusCode = execute.getStatusLine().getStatusCode();
                                                } catch (Exception e) {
                                                    int i3 = i2 + 1;
                                                    if (i3 > 10) {
                                                        e.printStackTrace();
                                                        C4331f.m5439e("weiyun_test", "uploadFileToWeiyun doDownloadPic error:" + e.getMessage() + "");
                                                        Message obtainMessage = DownLoadImp.this.mHandler.obtainMessage();
                                                        obtainMessage.what = -2;
                                                        obtainMessage.obj = e.getMessage();
                                                        DownLoadImp.this.mHandler.sendMessage(obtainMessage);
                                                        inputStream2 = inputStream;
                                                        break;
                                                    }
                                                    j = j2;
                                                    inputStream2 = inputStream;
                                                    i = i3;
                                                }
                                                if (statusCode != 200 && statusCode != 206) {
                                                    inputStream2 = inputStream;
                                                    break;
                                                }
                                                InputStream content2 = execute.getEntity().getContent();
                                                while (true) {
                                                    int read = content2.read(bArr);
                                                    if (read <= 0) {
                                                        break;
                                                    }
                                                    fileOutputStream3.write(bArr, 0, read);
                                                    j2 += read;
                                                }
                                                j = j2;
                                                inputStream2 = content2;
                                                i = i2;
                                                if (DownLoadImp.this.mWeiyunFile.getFileSize() - fileSize <= 0) {
                                                    break;
                                                }
                                                long fileSize2 = (DownLoadImp.this.mWeiyunFile.getFileSize() - j > 262144 ? 262144L : DownLoadImp.this.mWeiyunFile.getFileSize() - j) + j;
                                                Message obtainMessage2 = DownLoadImp.this.mHandler.obtainMessage();
                                                obtainMessage2.what = 1;
                                                obtainMessage2.obj = ((100 * fileSize2) / DownLoadImp.this.mWeiyunFile.getFileSize()) + "";
                                                DownLoadImp.this.mHandler.sendMessage(obtainMessage2);
                                                fileSize = fileSize2;
                                                inputStream = inputStream2;
                                                i2 = i;
                                                j2 = j;
                                            } catch (Throwable th) {
                                                th = th;
                                                fileOutputStream = fileOutputStream3;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e3) {
                                                        e3.printStackTrace();
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                        Message obtainMessage3 = DownLoadImp.this.mHandler.obtainMessage();
                                        obtainMessage3.what = 2;
                                        DownLoadImp.this.mHandler.sendMessage(obtainMessage3);
                                        if (fileOutputStream3 != null) {
                                            try {
                                                fileOutputStream3.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            return;
                                        }
                                        try {
                                            inputStream2.close();
                                            return;
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                            return;
                                        }
                                    }
                                    HttpGet httpGet2 = new HttpGet(str);
                                    httpGet2.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                                    httpGet2.addHeader(C5083e.f21691z, DownLoadImp.this.mDownloadServerHost);
                                    httpGet2.addHeader(C5083e.f21675j, "Keep-Alive");
                                    httpGet2.addHeader("Cookie", DownLoadImp.this.mDownloadCookieName + "=" + DownLoadImp.this.mDownloadCookieValue + "");
                                    httpGet2.addHeader(C5083e.f21648L, "no-cache");
                                    try {
                                        HttpResponse execute2 = defaultHttpClient.execute(httpGet2);
                                        C4331f.m5442c("weiyun_test", "uploadFileToWeiyun doDownloadPic response:" + execute2.toString());
                                        int statusCode2 = execute2.getStatusLine().getStatusCode();
                                        if (statusCode2 == 200 || statusCode2 == 206) {
                                            content = execute2.getEntity().getContent();
                                            while (true) {
                                                try {
                                                    int read2 = content.read(bArr);
                                                    if (read2 <= 0) {
                                                        break;
                                                    }
                                                    fileOutputStream3.write(bArr, 0, read2);
                                                } catch (Exception e6) {
                                                    inputStream3 = content;
                                                    e = e6;
                                                    e.printStackTrace();
                                                    C4331f.m5439e("weiyun_test", "uploadFileToWeiyun doDownloadPic error:" + e.getMessage() + "");
                                                    Message obtainMessage4 = DownLoadImp.this.mHandler.obtainMessage();
                                                    obtainMessage4.what = -2;
                                                    obtainMessage4.obj = e.getMessage();
                                                    DownLoadImp.this.mHandler.sendMessage(obtainMessage4);
                                                    if (fileOutputStream3 != null) {
                                                        try {
                                                            fileOutputStream3.close();
                                                        } catch (IOException e7) {
                                                            e7.printStackTrace();
                                                        }
                                                    }
                                                    if (inputStream3 == null) {
                                                        return;
                                                    }
                                                    try {
                                                        inputStream3.close();
                                                        return;
                                                    } catch (IOException e8) {
                                                        e8.printStackTrace();
                                                        return;
                                                    }
                                                } catch (Throwable th2) {
                                                    inputStream = content;
                                                    th = th2;
                                                    fileOutputStream = fileOutputStream3;
                                                    if (fileOutputStream != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } else {
                                            content = null;
                                        }
                                        inputStream2 = content;
                                        Message obtainMessage32 = DownLoadImp.this.mHandler.obtainMessage();
                                        obtainMessage32.what = 2;
                                        DownLoadImp.this.mHandler.sendMessage(obtainMessage32);
                                        if (fileOutputStream3 != null) {
                                        }
                                        if (inputStream2 != null) {
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = null;
                                    fileOutputStream = fileOutputStream3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                                fileOutputStream = fileOutputStream3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                            fileOutputStream = null;
                        }
                    } catch (FileNotFoundException e10) {
                        Message obtainMessage5 = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage5.what = -2;
                        obtainMessage5.obj = e10.getMessage();
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage5);
                        if (0 != 0) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (0 == 0) {
                            return;
                        }
                        try {
                            inputStream3.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.open.weiyun.FileManager$DownLoadImp$2] */
        private void getDownloadPermission() {
            new Thread() { // from class: com.tencent.open.weiyun.FileManager.DownLoadImp.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Bundle composeCGIParams = FileManager.this.composeCGIParams();
                    composeCGIParams.putString("file_id", DownLoadImp.this.mWeiyunFile.getFileId());
                    if (!TextUtils.isEmpty(DownLoadImp.this.mThumbSize)) {
                        composeCGIParams.putString("thumb", DownLoadImp.this.mThumbSize);
                    }
                    try {
                        JSONObject request = HttpUtils.request(FileManager.this.mToken, DownLoadImp.this.mContext, DownLoadImp.this.getDownloadUrl(DownLoadImp.this.mFileType), composeCGIParams, "GET");
                        Message obtainMessage = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage.what = 0;
                        obtainMessage.obj = request;
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage);
                    } catch (HttpUtils.HttpStatusException e) {
                        Message obtainMessage2 = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage2.obj = e.getMessage();
                        obtainMessage2.what = -9;
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage2);
                    } catch (HttpUtils.NetworkUnavailableException e2) {
                        Message obtainMessage3 = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage3.obj = e2.getMessage();
                        obtainMessage3.what = -10;
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage3);
                    } catch (MalformedURLException e3) {
                        Message obtainMessage4 = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage4.what = -3;
                        obtainMessage4.obj = e3.getMessage();
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage4);
                    } catch (IOException e4) {
                        Message obtainMessage5 = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage5.obj = e4.getMessage();
                        obtainMessage5.what = -2;
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage5);
                    } catch (JSONException e5) {
                        Message obtainMessage6 = DownLoadImp.this.mHandler.obtainMessage();
                        obtainMessage6.obj = e5.getMessage();
                        obtainMessage6.what = -4;
                        DownLoadImp.this.mHandler.sendMessage(obtainMessage6);
                    }
                }
            }.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getDownloadUrl(WeiyunFileType weiyunFileType) {
            return weiyunFileType == WeiyunFileType.ImageFile ? this.mThumbSize != null ? DOWNLOAD_THUMB_URL : DOWNLOAD_PIC_URL : weiyunFileType == WeiyunFileType.MusicFile ? DOWNLOAD_MUSIC_URL : weiyunFileType == WeiyunFileType.VideoFile ? DOWNLOAD_VIDEO_URL : DOWNLOAD_PIC_URL;
        }

        public void setThumbSize(String str) {
            this.mThumbSize = str;
        }

        public void start() {
            if (this.mSavePath == null || this.mFileType == null || this.mWeiyunFile == null || this.mWeiyunFile.getFileId() == null) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = -5;
                obtainMessage.obj = new String("");
                this.mHandler.sendMessage(obtainMessage);
                return;
            }
            this.mFile = new File(this.mSavePath);
            if (!this.mFile.exists()) {
                this.mCallback.onPrepareStart();
                getDownloadPermission();
                return;
            }
            Message obtainMessage2 = this.mHandler.obtainMessage();
            obtainMessage2.what = -11;
            obtainMessage2.obj = new String("");
            this.mHandler.sendMessage(obtainMessage2);
        }
    }

    /* loaded from: classes2.dex */
    private class GetFileListListener implements IUiListener {
        private IGetFileListListener mListener;

        public GetFileListListener(IGetFileListListener iGetFileListListener) {
            this.mListener = iGetFileListListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!jSONObject2.isNull("content")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("content");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        arrayList.add(new WeiyunFile(jSONObject3.getString("file_id"), jSONObject3.getString("file_name"), jSONObject3.getString("file_ctime"), jSONObject3.getInt("file_size")));
                    }
                }
                this.mListener.onComplete(arrayList);
            } catch (JSONException e) {
                this.mListener.onError(new UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, jSONObject.toString()));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            this.mListener.onError(uiError);
        }
    }

    /* loaded from: classes2.dex */
    private class UploadFileImp {
        private static final int GET_PERMISSON_DONE = 0;
        private static final String UPLOAD_IMAGE_URL = "https://graph.qq.com/weiyun/upload_photo";
        private static final String UPLOAD_MUSIC_URL = "https://graph.qq.com/weiyun/upload_music";
        private static final int UPLOAD_PROGRESS = 1;
        private static final int UPLOAD_PROGRESS_DONE = 2;
        private static final String UPLOAD_VIDEO_URL = "https://graph.qq.com/weiyun/upload_video";
        private final IUploadFileCallBack mCallback;
        private final Context mContext;
        private String mFileKey;
        private final String mFilePath;
        private long mFileSize;
        private final WeiyunFileType mFileType;
        private final Handler mHandler;
        private String mHost;
        private String mMD5Hash;
        private byte[] mUKey;

        public UploadFileImp(Context context, WeiyunFileType weiyunFileType, String str, IUploadFileCallBack iUploadFileCallBack) {
            this.mContext = context;
            this.mFileType = weiyunFileType;
            this.mFilePath = str;
            this.mCallback = iUploadFileCallBack;
            this.mHandler = new Handler(this.mContext.getMainLooper()) { // from class: com.tencent.open.weiyun.FileManager.UploadFileImp.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            JSONObject jSONObject = (JSONObject) message.obj;
                            try {
                                int i = jSONObject.getInt("ret");
                                if (i != 0) {
                                    UploadFileImp.this.mCallback.onError(new UiError(i, jSONObject.toString(), null));
                                } else {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                    String string = jSONObject2.getString("csum");
                                    UploadFileImp.this.mUKey = DataConvert.string2bytes(string);
                                    UploadFileImp.this.mHost = jSONObject2.getString("host");
                                    UploadFileImp.this.mCallback.onUploadStart();
                                    UploadFileImp.this.doUpload();
                                }
                                return;
                            } catch (Exception e) {
                                UploadFileImp.this.mCallback.onError(new UiError(-4, e.getMessage(), null));
                                return;
                            }
                        case 1:
                            UploadFileImp.this.mCallback.onUploadProgress(Integer.parseInt((String) message.obj));
                            return;
                        case 2:
                            UploadFileImp.this.mCallback.onUploadSuccess();
                            return;
                        default:
                            UploadFileImp.this.mCallback.onError(new UiError(message.what, (String) message.obj, null));
                            return;
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.open.weiyun.FileManager$UploadFileImp$3] */
        public void doUpload() {
            new Thread() { // from class: com.tencent.open.weiyun.FileManager.UploadFileImp.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    int i;
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                    HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
                    HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
                    HttpProtocolParams.setUserAgent(basicHttpParams, "TX_QQF_ANDROID");
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                    byte[] bArr = new byte[131072];
                    try {
                        FileInputStream fileInputStream = new FileInputStream(UploadFileImp.this.mFilePath);
                        int i2 = 0;
                        while (i2 < UploadFileImp.this.mFileSize) {
                            try {
                                int read = fileInputStream.read(bArr);
                                byte[] packPostBody = UploadFileImp.this.packPostBody(bArr, read, i2);
                                i2 += read;
                                if (packPostBody != null) {
                                    HttpPost httpPost = new HttpPost("http://" + UploadFileImp.this.mHost + "/ftn_handler/?bmd5=" + UploadFileImp.this.mMD5Hash);
                                    httpPost.addHeader("Accept-Encoding", "*/*");
                                    httpPost.setHeader(C5083e.f21675j, "Keep-Alive");
                                    httpPost.setHeader(C5083e.f21648L, "no-cache");
                                    httpPost.setHeader("Content-Type", C5078j.f21618a);
                                    httpPost.setEntity(new ByteArrayEntity(packPostBody));
                                    try {
                                        i = defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode();
                                    } catch (IOException e) {
                                        Message obtainMessage = UploadFileImp.this.mHandler.obtainMessage();
                                        obtainMessage.what = -2;
                                        obtainMessage.obj = "";
                                        UploadFileImp.this.mHandler.sendMessage(obtainMessage);
                                        i = 0;
                                    }
                                    if (i != 200) {
                                        Message obtainMessage2 = UploadFileImp.this.mHandler.obtainMessage();
                                        obtainMessage2.what = -9;
                                        obtainMessage2.obj = "";
                                        UploadFileImp.this.mHandler.sendMessage(obtainMessage2);
                                        break;
                                    } else if (i2 < UploadFileImp.this.mFileSize) {
                                        int i3 = (int) ((i2 * 100) / UploadFileImp.this.mFileSize);
                                        Message obtainMessage3 = UploadFileImp.this.mHandler.obtainMessage();
                                        obtainMessage3.what = 1;
                                        obtainMessage3.obj = i3 + "";
                                        UploadFileImp.this.mHandler.sendMessage(obtainMessage3);
                                    } else {
                                        Message obtainMessage4 = UploadFileImp.this.mHandler.obtainMessage();
                                        obtainMessage4.what = 2;
                                        obtainMessage4.obj = "";
                                        UploadFileImp.this.mHandler.sendMessage(obtainMessage4);
                                    }
                                }
                            } catch (IOException e2) {
                                Message obtainMessage5 = UploadFileImp.this.mHandler.obtainMessage();
                                obtainMessage5.what = -2;
                                obtainMessage5.obj = "";
                                UploadFileImp.this.mHandler.sendMessage(obtainMessage5);
                            }
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            Message obtainMessage6 = UploadFileImp.this.mHandler.obtainMessage();
                            obtainMessage6.what = -2;
                            obtainMessage6.obj = e3.getMessage();
                            UploadFileImp.this.mHandler.sendMessage(obtainMessage6);
                        }
                    } catch (FileNotFoundException e4) {
                        Message obtainMessage7 = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage7.what = -2;
                        obtainMessage7.obj = "";
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage7);
                    }
                }
            }.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRequestUrl(WeiyunFileType weiyunFileType) {
            return weiyunFileType == WeiyunFileType.ImageFile ? UPLOAD_IMAGE_URL : weiyunFileType == WeiyunFileType.MusicFile ? UPLOAD_MUSIC_URL : UPLOAD_VIDEO_URL;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.open.weiyun.FileManager$UploadFileImp$2] */
        private void getUploadPermission() {
            new Thread() { // from class: com.tencent.open.weiyun.FileManager.UploadFileImp.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Bundle composeCGIParams = FileManager.this.composeCGIParams();
                    composeCGIParams.putString("sha", UploadFileImp.this.mFileKey);
                    composeCGIParams.putString("md5", UploadFileImp.this.mMD5Hash);
                    composeCGIParams.putString("size", UploadFileImp.this.mFileSize + "");
                    composeCGIParams.putString("name", SystemClock.elapsedRealtime() + "__" + Uri.parse(UploadFileImp.this.mFilePath).getLastPathSegment());
                    composeCGIParams.putString("upload_type", "control");
                    try {
                        JSONObject request = HttpUtils.request(FileManager.this.mToken, UploadFileImp.this.mContext, UploadFileImp.this.getRequestUrl(UploadFileImp.this.mFileType), composeCGIParams, "GET");
                        Message obtainMessage = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage.what = 0;
                        obtainMessage.obj = request;
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage);
                    } catch (HttpUtils.HttpStatusException e) {
                        Message obtainMessage2 = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage2.obj = e.getMessage();
                        obtainMessage2.what = -9;
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage2);
                    } catch (HttpUtils.NetworkUnavailableException e2) {
                        Message obtainMessage3 = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage3.obj = e2.getMessage();
                        obtainMessage3.what = -10;
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage3);
                    } catch (MalformedURLException e3) {
                        Message obtainMessage4 = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage4.what = -3;
                        obtainMessage4.obj = e3.getMessage();
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage4);
                    } catch (IOException e4) {
                        Message obtainMessage5 = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage5.obj = e4.getMessage();
                        obtainMessage5.what = -2;
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage5);
                    } catch (JSONException e5) {
                        Message obtainMessage6 = UploadFileImp.this.mHandler.obtainMessage();
                        obtainMessage6.obj = e5.getMessage();
                        obtainMessage6.what = -4;
                        UploadFileImp.this.mHandler.sendMessage(obtainMessage6);
                    }
                }
            }.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] packPostBody(byte[] bArr, int i, int i2) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr, 0, i);
                this.mMD5Hash = DataConvert.toHexString(messageDigest.digest());
                messageDigest.reset();
                int i3 = i + 340;
                byte[] bArr2 = new byte[i3 + 4 + 4 + 4 + 4];
                int putInt2Bytes = DataConvert.putInt2Bytes(-1412589450, bArr2, 0) + 0;
                int putInt2Bytes2 = putInt2Bytes + DataConvert.putInt2Bytes(1000, bArr2, putInt2Bytes);
                int putInt2Bytes3 = putInt2Bytes2 + DataConvert.putInt2Bytes(0, bArr2, putInt2Bytes2);
                int putInt2Bytes4 = DataConvert.putInt2Bytes(i3, bArr2, putInt2Bytes3) + putInt2Bytes3;
                int putShort2Bytes = putInt2Bytes4 + DataConvert.putShort2Bytes(304, bArr2, putInt2Bytes4);
                int putBytes2Bytes = putShort2Bytes + DataConvert.putBytes2Bytes(this.mUKey, bArr2, putShort2Bytes);
                int putShort2Bytes2 = putBytes2Bytes + DataConvert.putShort2Bytes(20, bArr2, putBytes2Bytes);
                int putString2Bytes = putShort2Bytes2 + DataConvert.putString2Bytes(this.mFileKey, bArr2, putShort2Bytes2);
                int putInt2Bytes5 = putString2Bytes + DataConvert.putInt2Bytes((int) this.mFileSize, bArr2, putString2Bytes);
                int putInt2Bytes6 = putInt2Bytes5 + DataConvert.putInt2Bytes(i2, bArr2, putInt2Bytes5);
                int putInt2Bytes7 = putInt2Bytes6 + DataConvert.putInt2Bytes(i, bArr2, putInt2Bytes6);
                int putBytes2Bytes2 = putInt2Bytes7 + DataConvert.putBytes2Bytes(bArr, i, bArr2, putInt2Bytes7);
                return bArr2;
            } catch (NoSuchAlgorithmException e) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = -2;
                obtainMessage.obj = e.getMessage();
                this.mHandler.sendMessage(obtainMessage);
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:127:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:132:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void start() {
            FileInputStream fileInputStream;
            DigestInputStream digestInputStream;
            FileInputStream fileInputStream2;
            FileInputStream fileInputStream3;
            DigestInputStream digestInputStream2 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            DigestInputStream digestInputStream3 = null;
            digestInputStream2 = null;
            FileInputStream fileInputStream4 = null;
            if (this.mFilePath == null || !new File(this.mFilePath).exists()) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = -5;
                obtainMessage.obj = new String("");
                this.mHandler.sendMessage(obtainMessage);
                return;
            }
            this.mCallback.onPrepareStart();
            File file = new File(this.mFilePath);
            this.mFileSize = file.length();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                fileInputStream = new FileInputStream(file);
                try {
                    digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
                } catch (Exception e) {
                    digestInputStream = null;
                    fileInputStream4 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    do {
                    } while (digestInputStream.read(new byte[AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END]) > 0);
                    MessageDigest messageDigest2 = digestInputStream.getMessageDigest();
                    this.mFileKey = DataConvert.toHexString(messageDigest2.digest());
                    messageDigest2.reset();
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        MessageDigest messageDigest3 = MessageDigest.getInstance("MD5");
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            DigestInputStream digestInputStream4 = new DigestInputStream(fileInputStream2, messageDigest3);
                            try {
                                do {
                                } while (digestInputStream4.read(new byte[AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END]) > 0);
                                MessageDigest messageDigest4 = digestInputStream4.getMessageDigest();
                                this.mMD5Hash = DataConvert.toHexString(messageDigest4.digest());
                                messageDigest4.reset();
                                fileInputStream2.close();
                                digestInputStream4.close();
                                if (digestInputStream4 != null) {
                                    try {
                                        digestInputStream4.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                getUploadPermission();
                            } catch (Exception e6) {
                                digestInputStream3 = digestInputStream4;
                                fileInputStream3 = fileInputStream2;
                                try {
                                    Message obtainMessage2 = this.mHandler.obtainMessage();
                                    obtainMessage2.what = -2;
                                    obtainMessage2.obj = new String("");
                                    this.mHandler.sendMessage(obtainMessage2);
                                    if (digestInputStream3 != null) {
                                        try {
                                            digestInputStream3.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream3 == null) {
                                        return;
                                    }
                                    try {
                                        fileInputStream3.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                } catch (Throwable th2) {
                                    fileInputStream2 = fileInputStream3;
                                    th = th2;
                                    if (digestInputStream3 != null) {
                                        try {
                                            digestInputStream3.close();
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                digestInputStream3 = digestInputStream4;
                                th = th3;
                                if (digestInputStream3 != null) {
                                }
                                if (fileInputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e11) {
                            fileInputStream3 = fileInputStream2;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Exception e12) {
                        fileInputStream3 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = null;
                    }
                } catch (Exception e13) {
                    fileInputStream4 = fileInputStream;
                    try {
                        Message obtainMessage3 = this.mHandler.obtainMessage();
                        obtainMessage3.what = -2;
                        obtainMessage3.obj = new String("");
                        this.mHandler.sendMessage(obtainMessage3);
                        if (digestInputStream != null) {
                            try {
                                digestInputStream.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        if (fileInputStream4 == null) {
                            return;
                        }
                        try {
                            fileInputStream4.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    } catch (Throwable th6) {
                        fileInputStream = fileInputStream4;
                        digestInputStream2 = digestInputStream;
                        th = th6;
                        if (digestInputStream2 != null) {
                            try {
                                digestInputStream2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    digestInputStream2 = digestInputStream;
                    th = th7;
                    if (digestInputStream2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e18) {
                digestInputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileInputStream = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum WeiyunFileType {
        ImageFile(0),
        MusicFile(1),
        VideoFile(2);
        
        private final int mType;

        WeiyunFileType(int i) {
            this.mType = i;
        }

        public int value() {
            return this.mType;
        }
    }

    public FileManager(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public FileManager(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void deleteFile(WeiyunFileType weiyunFileType, String str, IUiListener iUiListener) {
        String str2 = f18243b[weiyunFileType.value()];
        Bundle composeCGIParams = composeCGIParams();
        composeCGIParams.putString("file_id", str);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), str2, composeCGIParams, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void downLoadFile(WeiyunFileType weiyunFileType, WeiyunFile weiyunFile, String str, IDownLoadFileCallBack iDownLoadFileCallBack) {
        new DownLoadImp(Global.getContext(), weiyunFileType, weiyunFile, str, iDownLoadFileCallBack).start();
    }

    public void downLoadThumb(WeiyunFile weiyunFile, String str, String str2, IDownLoadFileCallBack iDownLoadFileCallBack) {
        DownLoadImp downLoadImp = new DownLoadImp(Global.getContext(), WeiyunFileType.ImageFile, weiyunFile, str, iDownLoadFileCallBack);
        downLoadImp.setThumbSize(str2);
        downLoadImp.start();
    }

    public void getFileList(WeiyunFileType weiyunFileType, IGetFileListListener iGetFileListListener) {
        String str = f18242a[weiyunFileType.value()];
        Bundle composeCGIParams = composeCGIParams();
        composeCGIParams.putString("offset", "0");
        composeCGIParams.putString("number", "100");
        HttpUtils.requestAsync(this.mToken, Global.getContext(), str, composeCGIParams, "GET", new BaseApi.TempRequestListener(new GetFileListListener(iGetFileListListener)));
    }

    public void uploadFile(WeiyunFileType weiyunFileType, String str, IUploadFileCallBack iUploadFileCallBack) {
        new UploadFileImp(Global.getContext(), weiyunFileType, str, iUploadFileCallBack).start();
    }
}
