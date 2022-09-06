package com.baidu.tts.loopj;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    private static final String LOG_TAG = "JsonHttpRH";
    private boolean useRFC5179CompatibilityMode;

    public JsonHttpResponseHandler() {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = true;
    }

    public JsonHttpResponseHandler(String str) {
        super(str);
        this.useRFC5179CompatibilityMode = true;
    }

    public JsonHttpResponseHandler(String str, boolean z) {
        super(str);
        this.useRFC5179CompatibilityMode = true;
        this.useRFC5179CompatibilityMode = z;
    }

    public JsonHttpResponseHandler(boolean z) {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = true;
        this.useRFC5179CompatibilityMode = z;
    }

    public boolean isUseRFC5179CompatibilityMode() {
        return this.useRFC5179CompatibilityMode;
    }

    @Override // com.baidu.tts.loopj.TextHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, String str, Throwable th) {
        AsyncHttpClient.log.mo14714w(LOG_TAG, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", th);
    }

    public void onFailure(int i, Header[] headerArr, Throwable th, JSONArray jSONArray) {
        AsyncHttpClient.log.mo14714w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", th);
    }

    public void onFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        AsyncHttpClient.log.mo14714w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", th);
    }

    @Override // com.baidu.tts.loopj.TextHttpResponseHandler, com.baidu.tts.loopj.AsyncHttpResponseHandler
    public final void onFailure(final int i, final Header[] headerArr, final byte[] bArr, final Throwable th) {
        if (bArr == null) {
            AsyncHttpClient.log.mo14717v(LOG_TAG, "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(i, headerArr, th, (JSONObject) null);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.tts.loopj.JsonHttpResponseHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.baidu.tts.loopj.JsonHttpResponseHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode && parseResponse == null) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) null, th);
                            } else if (parseResponse instanceof JSONObject) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONObject) parseResponse);
                            } else if (parseResponse instanceof JSONArray) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONArray) parseResponse);
                            } else if (parseResponse instanceof String) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) parseResponse, th);
                            } else {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                            }
                        }
                    });
                } catch (JSONException e) {
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.baidu.tts.loopj.JsonHttpResponseHandler.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            JsonHttpResponseHandler.this.onFailure(i, headerArr, e, (JSONObject) null);
                        }
                    });
                }
            }
        };
        if (getUseSynchronousMode() || getUsePoolThread()) {
            runnable.run();
        } else {
            new Thread(runnable).start();
        }
    }

    @Override // com.baidu.tts.loopj.TextHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, String str) {
        AsyncHttpClient.log.mo14715w(LOG_TAG, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
        AsyncHttpClient.log.mo14715w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
        AsyncHttpClient.log.mo14715w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    @Override // com.baidu.tts.loopj.TextHttpResponseHandler, com.baidu.tts.loopj.AsyncHttpResponseHandler
    public final void onSuccess(final int i, final Header[] headerArr, final byte[] bArr) {
        if (i == 204) {
            onSuccess(i, headerArr, new JSONObject());
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.tts.loopj.JsonHttpResponseHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.baidu.tts.loopj.JsonHttpResponseHandler.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode && parseResponse == null) {
                                JsonHttpResponseHandler.this.onSuccess(i, headerArr, (String) null);
                            } else if (parseResponse instanceof JSONObject) {
                                JsonHttpResponseHandler.this.onSuccess(i, headerArr, (JSONObject) parseResponse);
                            } else if (parseResponse instanceof JSONArray) {
                                JsonHttpResponseHandler.this.onSuccess(i, headerArr, (JSONArray) parseResponse);
                            } else if (!(parseResponse instanceof String)) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                            } else if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) parseResponse, new JSONException("Response cannot be parsed as JSON data"));
                            } else {
                                JsonHttpResponseHandler.this.onSuccess(i, headerArr, (String) parseResponse);
                            }
                        }
                    });
                } catch (JSONException e) {
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.baidu.tts.loopj.JsonHttpResponseHandler.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            JsonHttpResponseHandler.this.onFailure(i, headerArr, e, (JSONObject) null);
                        }
                    });
                }
            }
        };
        if (getUseSynchronousMode() || getUsePoolThread()) {
            runnable.run();
        } else {
            new Thread(runnable).start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object parseResponse(byte[] bArr) {
        String str;
        String str2;
        if (bArr == null) {
            return null;
        }
        String responseString = getResponseString(bArr, getCharset());
        if (responseString != null) {
            responseString = responseString.trim();
            if (this.useRFC5179CompatibilityMode) {
                if (responseString.startsWith("{") || responseString.startsWith("[")) {
                    str = new JSONTokener(responseString).nextValue();
                    str2 = responseString;
                }
            } else if ((responseString.startsWith("{") && responseString.endsWith("}")) || (responseString.startsWith("[") && responseString.endsWith("]"))) {
                str = new JSONTokener(responseString).nextValue();
                str2 = responseString;
            } else if (responseString.startsWith("\"") && responseString.endsWith("\"")) {
                str = responseString.substring(1, responseString.length() - 1);
                str2 = responseString;
            }
            return str == null ? str : str2;
        }
        String str3 = responseString;
        str = null;
        str2 = str3;
        if (str == null) {
        }
    }

    public void setUseRFC5179CompatibilityMode(boolean z) {
        this.useRFC5179CompatibilityMode = z;
    }
}
