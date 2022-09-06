package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.IXiaomiAuthService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.p248a.p249a.p261f.p264c.C5122l;
import p233d.p234a.AbstractC4840a;
/* loaded from: classes.dex */
public class XiaomiOAuthorize {
    private static final String ACCOUNT_TYPE = "com.xiaomi";
    private static final Class<? extends AuthorizeActivityBase> DEFAULT_AUTHORIZE_ACTIVITY_CLASS = AuthorizeActivity.class;
    private static final String TAG = "XiaomiOAuthorize";
    private static final String TYPE_CODE = "code";
    private static final String TYPE_TOKEN = "token";
    private boolean mNotUseMiui = false;
    private int[] mScopes = null;
    private Long mAppId = null;
    private String mRedirectUrl = null;
    private Boolean mSkipConfirm = null;
    private String mState = null;
    private boolean mKeepCookies = false;
    private Class<? extends AuthorizeActivityBase> mAuthorizeActivityClazz = DEFAULT_AUTHORIZE_ACTIVITY_CLASS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.account.openauth.XiaomiOAuthorize$8 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C44608 {

        /* renamed from: $SwitchMap$com$xiaomi$account$openauth$XiaomiOAuthorize$OAuthStage */
        static final /* synthetic */ int[] f18518x6d96e761 = new int[OAuthStage.values().length];

        static {
            try {
                f18518x6d96e761[OAuthStage.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18518x6d96e761[OAuthStage.ADD_SYSTEM_ACCOUNT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18518x6d96e761[OAuthStage.OAUTH_FROM_MIUI.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18518x6d96e761[OAuthStage.OAUTH_FROM_MIUI_WITH_RESPONSE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18518x6d96e761[OAuthStage.OAUTH_FROM_3RD_PARTY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum OAuthStage {
        INIT,
        ADD_SYSTEM_ACCOUNT,
        OAUTH_FROM_MIUI,
        OAUTH_FROM_MIUI_WITH_RESPONSE,
        OAUTH_FROM_3RD_PARTY
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class XiaomiTokenFuture extends FutureTask<Bundle> {
        private final Activity mActivity;
        private final Class<? extends AuthorizeActivityBase> mAuthorizeActivityClazz;
        private final XiaomiOAuthFutureImpl<XiaomiOAuthResults> mRealFuture;

        public XiaomiTokenFuture(Activity activity, XiaomiOAuthFutureImpl<XiaomiOAuthResults> xiaomiOAuthFutureImpl, Class<? extends AuthorizeActivityBase> cls) {
            super(new Callable<Bundle>() { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.XiaomiTokenFuture.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                /* renamed from: call */
                public Bundle mo21878call() {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mActivity = activity;
            this.mRealFuture = xiaomiOAuthFutureImpl;
            this.mAuthorizeActivityClazz = cls;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public IXiaomiAuthResponse wrapWithinResponse() {
            return new IXiaomiAuthResponse.Stub() { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.XiaomiTokenFuture.2
                @Override // com.xiaomi.account.IXiaomiAuthResponse
                public void onCancel() {
                    XiaomiTokenFuture.this.setException(new OperationCanceledException());
                }

                @Override // com.xiaomi.account.IXiaomiAuthResponse
                public void onResult(Bundle bundle) {
                    XiaomiTokenFuture.this.set(bundle);
                }
            };
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        /* renamed from: get */
        public Bundle mo21876get() {
            throw new IllegalStateException("this should never be called");
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        /* renamed from: get */
        public Bundle mo21877get(long j, TimeUnit timeUnit) {
            throw new IllegalStateException("this should never be called");
        }

        public boolean handleIntentResult(Intent intent) {
            if (intent == null) {
                return false;
            }
            Bundle extras = intent.getExtras();
            extras.setClassLoader(getClass().getClassLoader());
            if (!extras.containsKey(XiaomiOAuthConstants.EXTRA_RESPONSE)) {
                intent = AuthorizeActivityBase.asMiddleActivity(this.mActivity, intent, wrapWithinResponse(), this.mAuthorizeActivityClazz);
            }
            this.mActivity.startActivity(intent);
            return true;
        }

        @Override // java.util.concurrent.FutureTask
        public void set(Bundle bundle) {
            if (bundle != null && bundle.containsKey("extra_intent")) {
                handleIntentResult((Intent) bundle.getParcelable("extra_intent"));
                return;
            }
            this.mRealFuture.set(XiaomiOAuthResults.parseBundle(bundle));
        }

        @Override // java.util.concurrent.FutureTask
        protected void setException(Throwable th) {
            this.mRealFuture.setException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle getAccessTokenFromMiui(Context context, Account account, Bundle bundle) {
        return new MiuiAuthServiceRunnable<Bundle>(context, account, bundle) { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
            /* renamed from: talkWithMiuiV5 */
            public Bundle mo21874talkWithMiuiV5(AbstractC4840a abstractC4840a) {
                abstractC4840a.mo3147d(this.account, this.options);
                return abstractC4840a.mo3149b(this.account, this.options);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
            /* renamed from: talkWithMiuiV6 */
            public Bundle mo21875talkWithMiuiV6(IXiaomiAuthService iXiaomiAuthService) {
                return iXiaomiAuthService.getMiCloudAccessToken(this.account, this.options);
            }
        }.start().get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle getAccessTokenFromMiuiInResponseWay(Context context, Bundle bundle, final IXiaomiAuthResponse iXiaomiAuthResponse) {
        return new MiuiAuthServiceRunnable<Bundle>(context, null, bundle) { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
            /* renamed from: talkWithMiuiV5 */
            public Bundle mo21874talkWithMiuiV5(AbstractC4840a abstractC4840a) {
                throw new IllegalStateException("should not be here");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
            /* renamed from: talkWithMiuiV6 */
            public Bundle mo21875talkWithMiuiV6(IXiaomiAuthService iXiaomiAuthService) {
                iXiaomiAuthService.getAccessTokenInResponse(iXiaomiAuthResponse, this.options, 1, 4);
                return null;
            }
        }.start().get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Account getXiaomiAccount(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType(ACCOUNT_TYPE);
        if (accountsByType.length == 0) {
            return null;
        }
        return accountsByType[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMiui(Context context) {
        try {
            return new MiuiAuthServiceRunnable<Boolean>(context, null, null) { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.5
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
                /* renamed from: talkWithMiuiV5 */
                public Boolean mo21874talkWithMiuiV5(AbstractC4840a abstractC4840a) {
                    return true;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
                /* renamed from: talkWithMiuiV6 */
                public Boolean mo21875talkWithMiuiV6(IXiaomiAuthService iXiaomiAuthService) {
                    return true;
                }
            }.start().get().booleanValue();
        } catch (InterruptedException e) {
            return false;
        } catch (ExecutionException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String makeScopeString(int[] iArr) {
        int i = 0;
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (i2 > 0) {
                sb.append(C5122l.f21763c);
            }
            sb.append(i3);
            i++;
            i2 = i4;
        }
        return sb.toString();
    }

    private XiaomiOAuthFutureImpl<XiaomiOAuthResults> oauth(final Activity activity, final String str) {
        if (activity == null || activity.isFinishing()) {
            throw new IllegalArgumentException("activity should not be null and should be running");
        }
        if (this.mAppId == null || this.mAppId.longValue() <= 0) {
            throw new IllegalArgumentException("client id is error!!!");
        }
        if (TextUtils.isEmpty(this.mRedirectUrl)) {
            throw new IllegalArgumentException("redirect url is empty!!!");
        }
        if (!TextUtils.isEmpty(str)) {
            return new XiaomiOAuthRunnable<XiaomiOAuthResults>() { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.2
                private Bundle makeOptions() {
                    Bundle bundle = new Bundle();
                    bundle.putString("extra_client_id", String.valueOf(XiaomiOAuthorize.this.mAppId));
                    bundle.putString("extra_redirect_uri", XiaomiOAuthorize.this.mRedirectUrl);
                    bundle.putString("extra_response_type", str);
                    if (XiaomiOAuthorize.this.mSkipConfirm != null) {
                        bundle.putBoolean("extra_skip_confirm", XiaomiOAuthorize.this.mSkipConfirm.booleanValue());
                    }
                    if (!TextUtils.isEmpty(XiaomiOAuthorize.this.mState)) {
                        bundle.putString("extra_state", XiaomiOAuthorize.this.mState);
                    }
                    String makeScopeString = XiaomiOAuthorize.makeScopeString(XiaomiOAuthorize.this.mScopes);
                    if (!TextUtils.isEmpty(makeScopeString)) {
                        bundle.putString("extra_scope", makeScopeString);
                    }
                    return bundle;
                }

                private void run(XiaomiTokenFuture xiaomiTokenFuture) {
                    OAuthStage oAuthStage = OAuthStage.INIT;
                    while (true) {
                        switch (C44608.f18518x6d96e761[oAuthStage.ordinal()]) {
                            case 1:
                                if (!XiaomiOAuthorize.this.mNotUseMiui && XiaomiOAuthorize.isMiui(activity)) {
                                    if (!XiaomiOAuthorize.this.supportResponseWayWithMiui(activity)) {
                                        if (XiaomiOAuthorize.this.getXiaomiAccount(activity) == null) {
                                            oAuthStage = OAuthStage.ADD_SYSTEM_ACCOUNT;
                                            break;
                                        } else {
                                            oAuthStage = OAuthStage.OAUTH_FROM_MIUI;
                                            break;
                                        }
                                    } else {
                                        oAuthStage = OAuthStage.OAUTH_FROM_MIUI_WITH_RESPONSE;
                                        break;
                                    }
                                } else {
                                    oAuthStage = OAuthStage.OAUTH_FROM_3RD_PARTY;
                                    break;
                                }
                            case 2:
                                try {
                                    Bundle result = AccountManager.get(activity).addAccount(XiaomiOAuthorize.ACCOUNT_TYPE, null, null, null, activity, null, null).getResult();
                                    if (result != null && result.containsKey("authAccount")) {
                                        oAuthStage = OAuthStage.OAUTH_FROM_MIUI;
                                        break;
                                    } else {
                                        xiaomiTokenFuture.setException(new Exception("fail to add account"));
                                        return;
                                    }
                                } catch (AuthenticatorException e) {
                                    oAuthStage = OAuthStage.OAUTH_FROM_3RD_PARTY;
                                    break;
                                } catch (SecurityException e2) {
                                    oAuthStage = OAuthStage.OAUTH_FROM_3RD_PARTY;
                                    break;
                                }
                            case 3:
                                xiaomiTokenFuture.set(XiaomiOAuthorize.getAccessTokenFromMiui(activity, XiaomiOAuthorize.this.getXiaomiAccount(activity), makeOptions()));
                                return;
                            case 4:
                                XiaomiOAuthorize.getAccessTokenFromMiuiInResponseWay(activity, makeOptions(), xiaomiTokenFuture.wrapWithinResponse());
                                return;
                            case 5:
                                xiaomiTokenFuture.handleIntentResult(AuthorizeActivityBase.getIntent(activity, String.valueOf(XiaomiOAuthorize.this.mAppId), XiaomiOAuthorize.this.mRedirectUrl, str, XiaomiOAuthorize.makeScopeString(XiaomiOAuthorize.this.mScopes), XiaomiOAuthorize.this.mState, XiaomiOAuthorize.this.mSkipConfirm, XiaomiOAuthorize.this.mKeepCookies, xiaomiTokenFuture.wrapWithinResponse(), XiaomiOAuthorize.this.mAuthorizeActivityClazz));
                                return;
                        }
                    }
                }

                @Override // com.xiaomi.account.openauth.XiaomiOAuthRunnable
                public void doRun() {
                    try {
                        run(new XiaomiTokenFuture(activity, this.mFuture, XiaomiOAuthorize.this.mAuthorizeActivityClazz));
                    } catch (OperationCanceledException e) {
                        this.mFuture.setException(e);
                    } catch (IOException e2) {
                        this.mFuture.setException(e2);
                    } catch (InterruptedException e3) {
                        this.mFuture.setException(e3);
                    } catch (ExecutionException e4) {
                        this.mFuture.setException(e4.getCause());
                    }
                }
            }.start();
        }
        throw new IllegalArgumentException("responseType is empty!!!");
    }

    @Deprecated
    private static int[] scopeStringToIntArray(String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            for (String str2 : str.split(" ")) {
                try {
                    arrayList.add(Integer.valueOf(str2));
                } catch (NumberFormatException e) {
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 < iArr.length) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                return iArr;
            }
        }
    }

    @Deprecated
    public static void startGetAccessToken(Activity activity, long j, String str, Bundle bundle, int i) {
        Log.w(TAG, "you are calling startGetAccessToken(). Is still works but it is deprecated. Instead please use \n                XiaomiOAuthFuture<XiaomiOAuthResults> future = new XiaomiOAuthorize()\n                        .setAppId(appId)\n                        .setRedirectUrl(redirectUri)\n                        .setScope(scope)\n                        .setAllowSwitchAccount(true)\n                        .startGetAccessToken(acitivity);\n                XiaomiOAuthResults results = future.getResult();//call on background thread.\nIt provides better user experience! Checkout the Demo codes!");
        startGetOAuthorize(activity, j, str, "token", bundle, i);
    }

    @Deprecated
    public static void startGetOAuthCode(Activity activity, long j, String str, Bundle bundle, int i) {
        Log.w(TAG, "you are calling startGetOAuthCode(). Is still works but it is deprecated. Instead please use \n                XiaomiOAuthFuture<XiaomiOAuthResults> future = new XiaomiOAuthorize()\n                        .setAppId(appId)\n                        .setRedirectUrl(redirectUri)\n                        .setScope(scope)\n                        .setAllowSwitchAccount(true)\n                        .startGetOAuthCode(acitivity);\n                XiaomiOAuthResults results = future.getResult();//call on background thread.\nIt provides better user experience! Checkout the Demo codes!");
        startGetOAuthorize(activity, j, str, "code", bundle, i);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.xiaomi.account.openauth.XiaomiOAuthorize$7] */
    @Deprecated
    private static void startGetOAuthorize(final Activity activity, long j, String str, final String str2, Bundle bundle, final int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        XiaomiOAuthorize state = new XiaomiOAuthorize().setAppId(j).setRedirectUrl(str).setScope(scopeStringToIntArray(bundle.getString("extra_scope"))).setState(bundle.getString("extra_state"));
        if (bundle.containsKey("extra_skip_confirm")) {
            state.setSkipConfirm(bundle.getBoolean("extra_skip_confirm"));
        }
        final XiaomiOAuthFuture<XiaomiOAuthResults> startGetOAuthCode = "code".equalsIgnoreCase(str2) ? state.startGetOAuthCode(activity) : state.startGetAccessToken(activity);
        new AsyncTask<Void, Void, XiaomiOAuthResults>() { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.7

            /* renamed from: e */
            Exception f18517e;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public XiaomiOAuthResults doInBackground(Void... voidArr) {
                try {
                    return (XiaomiOAuthResults) XiaomiOAuthFuture.this.getResult();
                } catch (OperationCanceledException e) {
                    e.printStackTrace();
                    return null;
                } catch (XMAuthericationException e2) {
                    this.f18517e = e2;
                    return null;
                } catch (IOException e3) {
                    this.f18517e = e3;
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(XiaomiOAuthResults xiaomiOAuthResults) {
                int i2;
                Bundle bundle2 = new Bundle();
                if (xiaomiOAuthResults == null) {
                    if (this.f18517e == null) {
                        i2 = AuthorizeActivityBase.RESULT_CANCEL;
                        bundle2.putInt(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, AuthorizeActivityBase.RESULT_CANCEL);
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2, "canceled");
                    } else {
                        i2 = AuthorizeActivityBase.RESULT_FAIL;
                        bundle2.putInt(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, AuthorizeActivityBase.RESULT_FAIL);
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2, this.f18517e.getMessage());
                    }
                } else if (xiaomiOAuthResults.hasError()) {
                    i2 = AuthorizeActivityBase.RESULT_FAIL;
                    bundle2.putInt(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, xiaomiOAuthResults.getErrorCode());
                    bundle2.putString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2, xiaomiOAuthResults.getErrorMessage());
                } else {
                    i2 = AuthorizeActivityBase.RESULT_SUCCESS;
                    if ("code".equalsIgnoreCase(str2)) {
                        bundle2.putString("code", xiaomiOAuthResults.getCode());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_STATE_2, xiaomiOAuthResults.getState());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_TOKEN_TYPE_2, xiaomiOAuthResults.getTokenType());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_MAC_KEY_2, xiaomiOAuthResults.getMacKey());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_MAC_ALGORITHM_2, xiaomiOAuthResults.getMacAlgorithm());
                    } else {
                        bundle2.putString("access_token", xiaomiOAuthResults.getAccessToken());
                        bundle2.putString("expires_in", xiaomiOAuthResults.getExpiresIn());
                        bundle2.putString("scope", xiaomiOAuthResults.getScopes());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_STATE_2, xiaomiOAuthResults.getState());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_TOKEN_TYPE_2, xiaomiOAuthResults.getTokenType());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_MAC_KEY_2, xiaomiOAuthResults.getMacKey());
                        bundle2.putString(XiaomiOAuthConstants.EXTRA_MAC_ALGORITHM_2, xiaomiOAuthResults.getMacAlgorithm());
                    }
                }
                activity.startActivityForResult(AuthorizeActivityBase.asMiddleActivity(activity, i2, bundle2, XiaomiOAuthorize.DEFAULT_AUTHORIZE_ACTIVITY_CLASS), i);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean supportResponseWayWithMiui(Context context) {
        try {
            return new MiuiAuthServiceRunnable<Boolean>(context, null, null) { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.6
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
                /* renamed from: talkWithMiuiV5 */
                public Boolean mo21874talkWithMiuiV5(AbstractC4840a abstractC4840a) {
                    return false;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.xiaomi.account.openauth.MiuiAuthServiceRunnable
                /* renamed from: talkWithMiuiV6 */
                public Boolean mo21875talkWithMiuiV6(IXiaomiAuthService iXiaomiAuthService) {
                    return Boolean.valueOf(iXiaomiAuthService.supportResponseWay());
                }
            }.start().get().booleanValue();
        } catch (InterruptedException e) {
            return false;
        } catch (ExecutionException e2) {
            return false;
        }
    }

    public XiaomiOAuthFuture<String> callOpenApi(final Context context, final long j, final String str, final String str2, final String str3, final String str4) {
        return new XiaomiOAuthRunnable<String>() { // from class: com.xiaomi.account.openauth.XiaomiOAuthorize.1
            @Override // com.xiaomi.account.openauth.XiaomiOAuthRunnable
            public void doRun() {
                try {
                    this.mFuture.set(AuthorizeApi.doHttpGet(context, str, j, str2, str3, str4));
                } catch (XMAuthericationException e) {
                    this.mFuture.setException(e);
                }
            }
        }.start();
    }

    public XiaomiOAuthorize setAppId(long j) {
        this.mAppId = Long.valueOf(j);
        return this;
    }

    public XiaomiOAuthorize setCustomizedAuthorizeActivityClass(Class<? extends AuthorizeActivityBase> cls) {
        this.mAuthorizeActivityClazz = cls;
        return this;
    }

    public XiaomiOAuthorize setKeepCookies(boolean z) {
        this.mKeepCookies = z;
        return this;
    }

    public XiaomiOAuthorize setNoMiui(boolean z) {
        this.mNotUseMiui = z;
        return this;
    }

    public XiaomiOAuthorize setRedirectUrl(String str) {
        this.mRedirectUrl = str;
        return this;
    }

    public XiaomiOAuthorize setScope(int[] iArr) {
        this.mScopes = iArr;
        return this;
    }

    public XiaomiOAuthorize setSkipConfirm(boolean z) {
        this.mSkipConfirm = Boolean.valueOf(z);
        return this;
    }

    public XiaomiOAuthorize setState(String str) {
        this.mState = str;
        return this;
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> startGetAccessToken(Activity activity) {
        return oauth(activity, "token");
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> startGetOAuthCode(Activity activity) {
        return oauth(activity, "code");
    }
}
