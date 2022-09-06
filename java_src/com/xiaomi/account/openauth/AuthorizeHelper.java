package com.xiaomi.account.openauth;

import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.account.openauth.utils.Base64Coder;
import java.io.File;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes.dex */
public class AuthorizeHelper {
    private static final String HMAC_SHA1 = "HmacSHA1";
    public static final String OAUTH2_HOST;
    public static final boolean USE_PREVIEW = new File("/data/system/oauth_staging_preview").exists();
    private static final String UTF8 = "UTF-8";
    private static Random random;

    static {
        OAUTH2_HOST = USE_PREVIEW ? "http://account.preview.n.xiaomi.net" : "https://account.xiaomi.com";
        random = new Random();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<String, String> buildMacRequestHead(String str, String str2, String str3) {
        String format = String.format("MAC access_token=\"%s\", nonce=\"%s\",mac=\"%s\"", URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Authorization", format);
        return hashMap;
    }

    protected static String encodeSign(byte[] bArr) {
        return new String(Base64Coder.encode(bArr));
    }

    protected static byte[] encryptHMACSha1(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKeySpec);
        mac.update(bArr);
        return mac.doFinal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String generateNonce() {
        return random.nextLong() + ":" + ((int) (System.currentTimeMillis() / 60000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String generateUrl(String str, List<NameValuePair> list) {
        if (list == null || list.size() <= 0) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (NameValuePair nameValuePair : list) {
            buildUpon.appendQueryParameter(nameValuePair.getName(), nameValuePair.getValue());
        }
        return buildUpon.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getMacAccessTokenSignatureString(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if ("HmacSHA1".equalsIgnoreCase(str7)) {
            StringBuilder sb = new StringBuilder("");
            sb.append(str + "\n");
            sb.append(str2.toUpperCase() + "\n");
            sb.append(str3 + "\n");
            sb.append(str4 + "\n");
            if (!TextUtils.isEmpty(str5)) {
                StringBuffer stringBuffer = new StringBuffer();
                ArrayList arrayList = new ArrayList();
                URLEncodedUtils.parse(arrayList, new Scanner(str5), "UTF-8");
                Collections.sort(arrayList, new Comparator<NameValuePair>() { // from class: com.xiaomi.account.openauth.AuthorizeHelper.1
                    @Override // java.util.Comparator
                    public int compare(NameValuePair nameValuePair, NameValuePair nameValuePair2) {
                        return nameValuePair.getName().compareTo(nameValuePair2.getName());
                    }
                });
                stringBuffer.append(URLEncodedUtils.format(arrayList, "UTF-8"));
                sb.append(stringBuffer.toString() + "\n");
            }
            return encodeSign(encryptHMACSha1(sb.toString().getBytes("UTF-8"), str6.getBytes("UTF-8")));
        }
        throw new NoSuchAlgorithmException("error mac algorithm : " + str7);
    }
}
