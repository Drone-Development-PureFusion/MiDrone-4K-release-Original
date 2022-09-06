package com.baidu.tts.loopj;

import android.os.Message;
import com.fimi.soul.media.player.FimiMediaMeta;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;
/* loaded from: classes.dex */
public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "DataAsyncHttpRH";
    protected static final int PROGRESS_DATA_MESSAGE = 7;

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, min);
        return bArr2;
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    byte[] getResponseData(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength > 2147483647L) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (contentLength < 0) {
            contentLength = FimiMediaMeta.AV_CH_TOP_FRONT_LEFT;
        }
        try {
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) contentLength);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read == -1 || Thread.currentThread().isInterrupted()) {
                    break;
                }
                byteArrayBuffer.append(bArr, 0, read);
                sendProgressDataMessage(copyOfRange(bArr, 0, read));
                sendProgressMessage(0, contentLength);
            }
            AsyncHttpClient.silentCloseInputStream(content);
            return byteArrayBuffer.toByteArray();
        } catch (OutOfMemoryError e) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 7:
                Object[] objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 1) {
                    AsyncHttpClient.log.mo14721e(LOG_TAG, "PROGRESS_DATA_MESSAGE didn't got enough params");
                    return;
                }
                try {
                    onProgressData((byte[]) objArr[0]);
                    return;
                } catch (Throwable th) {
                    AsyncHttpClient.log.mo14720e(LOG_TAG, "custom onProgressData contains an error", th);
                    return;
                }
            default:
                return;
        }
    }

    public void onProgressData(byte[] bArr) {
        AsyncHttpClient.log.mo14723d(LOG_TAG, "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte[] bArr) {
        sendMessage(obtainMessage(7, new Object[]{bArr}));
    }
}
