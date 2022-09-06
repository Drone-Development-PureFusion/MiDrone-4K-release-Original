package com.baidu.tts.loopj;

import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
/* loaded from: classes.dex */
public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "TextHttpRH";

    public TextHttpResponseHandler() {
        this("UTF-8");
    }

    public TextHttpResponseHandler(String str) {
        setCharset(str);
    }

    public static String getResponseString(byte[] bArr, String str) {
        String str2;
        String str3 = null;
        if (bArr == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                AsyncHttpClient.log.mo14720e(LOG_TAG, "Encoding response into string failed", e);
                return str3;
            }
        }
        if (str2 == null || !str2.startsWith(AsyncHttpResponseHandler.UTF8_BOM)) {
            return str2;
        }
        str3 = str2.substring(1);
        return str3;
    }

    public abstract void onFailure(int i, Header[] headerArr, String str, Throwable th);

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i, headerArr, getResponseString(bArr, getCharset()), th);
    }

    public abstract void onSuccess(int i, Header[] headerArr, String str);

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, getResponseString(bArr, getCharset()));
    }
}
