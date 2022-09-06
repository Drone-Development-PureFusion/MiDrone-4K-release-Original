package com.xiaomi.account.openauth;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class AuthorizeApi {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String HOST = "open.account.xiaomi.com";
    private static final String METHOD_GET = "GET";
    private static final String OAUTH_URL_BASE = "https://open.account.xiaomi.com";
    private static final int READ_TIMEOUT = 15000;
    private static final String UTF8 = "UTF-8";

    private static void closeQuietly(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
    }

    @Deprecated
    public static String doHttpGet(Context context, String str, long j, String str2) {
        return doHttpGet(str, j, str2, null, null);
    }

    @Deprecated
    public static String doHttpGet(Context context, String str, long j, String str2, String str3, String str4) {
        return doHttpGet(str, j, str2, str3, str4);
    }

    public static String doHttpGet(String str, long j, String str2) {
        return doHttpGet(str, j, str2, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public static String doHttpGet(String str, long j, String str2, String str3, String str4) {
        InputStream errorStream;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientId", String.valueOf(j)));
        arrayList.add(new BasicNameValuePair(Constants.EXTRA_KEY_TOKEN, str2));
        ?? r3 = 0;
        try {
            try {
                try {
                    try {
                        URL url = new URL(AuthorizeHelper.generateUrl(OAUTH_URL_BASE + str, arrayList));
                        HttpURLConnection.setFollowRedirects(true);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(READ_TIMEOUT);
                        HashMap<String, String> makeHeaders = makeHeaders(str, str2, str3, str4, arrayList);
                        if (makeHeaders != null) {
                            for (String str5 : makeHeaders.keySet()) {
                                httpURLConnection.setRequestProperty(str5, makeHeaders.get(str5));
                            }
                        }
                        httpURLConnection.connect();
                        try {
                            errorStream = httpURLConnection.getInputStream();
                        } catch (IOException e) {
                            errorStream = httpURLConnection.getErrorStream();
                        }
                        if (errorStream == null) {
                            throw new XMAuthericationException(new IOException());
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream), 1024);
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    String sb2 = sb.toString();
                                    closeQuietly(bufferedReader);
                                    return sb2;
                                }
                                sb.append(readLine);
                            }
                        } catch (UnsupportedEncodingException e2) {
                            e = e2;
                            throw new XMAuthericationException(e);
                        } catch (IOException e3) {
                            e = e3;
                            throw new XMAuthericationException(e);
                        } catch (InvalidKeyException e4) {
                            e = e4;
                            throw new XMAuthericationException(e);
                        } catch (NoSuchAlgorithmException e5) {
                            e = e5;
                            throw new XMAuthericationException(e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        r3 = arrayList;
                        closeQuietly(r3);
                        throw th;
                    }
                } catch (InvalidKeyException e6) {
                    e = e6;
                } catch (NoSuchAlgorithmException e7) {
                    e = e7;
                }
            } catch (UnsupportedEncodingException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static HashMap<String, String> makeHeaders(String str, String str2, String str3, String str4, List<NameValuePair> list) {
        if (str3 == null && str4 == null) {
            return null;
        }
        String generateNonce = AuthorizeHelper.generateNonce();
        return AuthorizeHelper.buildMacRequestHead(str2, generateNonce, AuthorizeHelper.getMacAccessTokenSignatureString(generateNonce, "GET", HOST, str, URLEncodedUtils.format(list, "UTF-8"), str3, str4));
    }
}
