package com.xiaomi.account.openauth;

import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class XiaomiOAuthResults {
    private final Bundle contentBundle;
    private final Error errorResult;
    private final Success successResult;

    /* loaded from: classes2.dex */
    public static class Error {
        public final int errorCode;
        public final String errorMessage;

        public Error(int i, String str) {
            this.errorCode = i;
            this.errorMessage = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Error parseBundle(Bundle bundle) {
            return new Error(XiaomiOAuthResults.getIntCompatibly(bundle, "extra_error_code", XiaomiOAuthConstants.EXTRA_ERROR_CODE_2), XiaomiOAuthResults.getStringCompatibly(bundle, "extra_error_description", XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2));
        }

        public String toString() {
            return "errorCode=" + this.errorCode + ",errorMessage=" + this.errorMessage;
        }
    }

    /* loaded from: classes2.dex */
    private static class Success {
        public final String accessToken;
        public final String code;
        public final String expiresIn;
        public final String macAlgorithm;
        public final String macKey;
        public final String scopes;
        public final String state;
        public final String tokenType;

        public Success(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.accessToken = str;
            this.expiresIn = str2;
            this.scopes = str3;
            this.state = str4;
            this.tokenType = str5;
            this.macKey = str6;
            this.macAlgorithm = str7;
            this.code = str8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Success parseBundle(Bundle bundle) {
            return new Success(XiaomiOAuthResults.getStringCompatibly(bundle, "access_token", "extra_access_token"), XiaomiOAuthResults.getIntOrStringCompatibly(bundle, "expires_in", "extra_expires_in"), XiaomiOAuthResults.getStringCompatibly(bundle, "scope", "extra_scope"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_STATE_2, "extra_state"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_TOKEN_TYPE_2, "extra_token_type"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_MAC_KEY_2, "extra_mac_key"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_MAC_ALGORITHM_2, "extra_mac_algorithm"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_CODE_2, XiaomiOAuthConstants.EXTRA_CODE));
        }

        public String toString() {
            return "accessToken=" + this.accessToken + ",expiresIn=" + this.expiresIn + ",scope=" + this.scopes + ",state=" + this.state + ",tokenType=" + this.tokenType + ",macKey=" + this.macKey + ",macAlogorithm=" + this.macAlgorithm + ",code=" + this.code;
        }
    }

    private XiaomiOAuthResults(Bundle bundle, Error error) {
        this.contentBundle = bundle;
        this.successResult = null;
        this.errorResult = error;
    }

    private XiaomiOAuthResults(Bundle bundle, Success success) {
        this.contentBundle = bundle;
        this.successResult = success;
        this.errorResult = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntCompatibly(Bundle bundle, String str, String str2) {
        return bundle.containsKey(str) ? bundle.getInt(str) : bundle.getInt(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getIntOrStringCompatibly(Bundle bundle, String str, String str2) {
        String[] strArr;
        Object obj;
        for (String str3 : new String[]{str, str2}) {
            if (!TextUtils.isEmpty(str3) && bundle.containsKey(str3) && (obj = bundle.get(str3)) != null) {
                return obj instanceof Integer ? ((Integer) obj).toString() : obj.toString();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringCompatibly(Bundle bundle, String str, String str2) {
        return bundle.containsKey(str) ? bundle.getString(str) : bundle.getString(str2);
    }

    public static XiaomiOAuthResults parseBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return getIntCompatibly(bundle, "extra_error_code", XiaomiOAuthConstants.EXTRA_ERROR_CODE_2) != 0 ? new XiaomiOAuthResults(bundle, Error.parseBundle(bundle)) : new XiaomiOAuthResults(bundle, Success.parseBundle(bundle));
    }

    public String getAccessToken() {
        if (this.successResult != null) {
            return this.successResult.accessToken;
        }
        return null;
    }

    public String getCode() {
        if (this.successResult != null) {
            return this.successResult.code;
        }
        return null;
    }

    public Bundle getContentBundle() {
        return this.contentBundle;
    }

    public int getErrorCode() {
        if (this.errorResult != null) {
            return this.errorResult.errorCode;
        }
        return 0;
    }

    public String getErrorMessage() {
        if (this.errorResult != null) {
            return this.errorResult.errorMessage;
        }
        return null;
    }

    public String getExpiresIn() {
        if (this.successResult != null) {
            return this.successResult.expiresIn;
        }
        return null;
    }

    public String getMacAlgorithm() {
        if (this.successResult != null) {
            return this.successResult.macAlgorithm;
        }
        return null;
    }

    public String getMacKey() {
        if (this.successResult != null) {
            return this.successResult.macKey;
        }
        return null;
    }

    public String getScopes() {
        if (this.successResult != null) {
            return this.successResult.scopes;
        }
        return null;
    }

    public String getState() {
        if (this.successResult != null) {
            return this.successResult.state;
        }
        return null;
    }

    public String getTokenType() {
        if (this.successResult != null) {
            return this.successResult.tokenType;
        }
        return null;
    }

    public boolean hasError() {
        return this.errorResult != null;
    }

    public String toString() {
        if (this.successResult != null) {
            return this.successResult.toString();
        }
        if (this.errorResult == null) {
            throw new IllegalStateException("should not be here.");
        }
        return this.errorResult.toString();
    }
}
