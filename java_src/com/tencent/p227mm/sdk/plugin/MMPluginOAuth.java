package com.tencent.p227mm.sdk.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import com.tencent.p227mm.sdk.platformtools.Log;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.tencent.mm.sdk.plugin.MMPluginOAuth */
/* loaded from: classes2.dex */
public class MMPluginOAuth {

    /* renamed from: R */
    private final Context f17889R;

    /* renamed from: bA */
    private final IResult f17890bA;

    /* renamed from: bB */
    private String f17891bB;

    /* renamed from: bC */
    private String f17892bC;
    private Handler handler;

    /* renamed from: com.tencent.mm.sdk.plugin.MMPluginOAuth$IResult */
    /* loaded from: classes2.dex */
    public interface IResult {
        void onResult(MMPluginOAuth mMPluginOAuth);

        void onSessionTimeOut();
    }

    /* renamed from: com.tencent.mm.sdk.plugin.MMPluginOAuth$Receiver */
    /* loaded from: classes2.dex */
    public static class Receiver extends BroadcastReceiver {

        /* renamed from: aA */
        private static final Map<String, MMPluginOAuth> f17894aA = new HashMap();

        /* renamed from: bE */
        private final MMPluginOAuth f17895bE;

        public Receiver() {
            this(null);
        }

        public Receiver(MMPluginOAuth mMPluginOAuth) {
            this.f17895bE = mMPluginOAuth;
        }

        public static void register(String str, MMPluginOAuth mMPluginOAuth) {
            f17894aA.put(str, mMPluginOAuth);
        }

        public static void unregister(String str) {
            f17894aA.remove(str);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final MMPluginOAuth mMPluginOAuth;
            Log.m5649d("MicroMsg.SDK.MMPluginOAuth", "receive oauth result");
            String stringExtra = intent.getStringExtra(MMPluginProviderConstants.PluginIntent.REQUEST_TOKEN);
            final String stringExtra2 = intent.getStringExtra(MMPluginProviderConstants.PluginIntent.ACCESS_TOKEN);
            if (this.f17895bE != null) {
                mMPluginOAuth = this.f17895bE;
            } else {
                mMPluginOAuth = f17894aA.get(stringExtra);
                if (mMPluginOAuth == null) {
                    Log.m5647e("MicroMsg.SDK.MMPluginOAuth", "oauth unregistered, request token = " + stringExtra);
                    return;
                }
                unregister(mMPluginOAuth.f17892bC);
            }
            new Handler().post(new Runnable() { // from class: com.tencent.mm.sdk.plugin.MMPluginOAuth.Receiver.1
                @Override // java.lang.Runnable
                public void run() {
                    MMPluginOAuth.m5621a(mMPluginOAuth, stringExtra2);
                }
            });
        }
    }

    public MMPluginOAuth(Context context, IResult iResult) {
        this.f17889R = context;
        this.f17890bA = iResult;
    }

    /* renamed from: a */
    static /* synthetic */ void m5621a(MMPluginOAuth mMPluginOAuth, String str) {
        Receiver.unregister(mMPluginOAuth.f17892bC);
        mMPluginOAuth.f17891bB = str;
        Log.m5643i("MicroMsg.SDK.MMPluginOAuth", "access token: " + str);
        if (mMPluginOAuth.f17890bA != null) {
            mMPluginOAuth.f17890bA.onResult(mMPluginOAuth);
        }
    }

    public String getAccessToken() {
        return this.f17891bB;
    }

    public String getRequestToken() {
        return this.f17892bC;
    }

    public void start() {
        start(null);
    }

    public boolean start(Handler handler) {
        boolean z;
        if (handler == null) {
            handler = new Handler();
        }
        this.handler = handler;
        Cursor query = this.f17889R.getContentResolver().query(MMPluginProviderConstants.OAuth.CONTENT_URI, null, null, new String[]{this.f17889R.getPackageName(), MMPluginProviderConstants.OAuth.ACTION_REQUEST_TOKEN}, null);
        if (query != null) {
            if (query.moveToFirst() && query.getColumnCount() >= 2) {
                this.f17892bC = query.getString(0);
                this.f17891bB = query.getString(1);
            }
            query.close();
        }
        Log.m5643i("MicroMsg.SDK.MMPluginOAuth", "request token = " + this.f17892bC);
        if (this.f17892bC == null) {
            Log.m5647e("MicroMsg.SDK.MMPluginOAuth", "request token failed");
            return false;
        } else if (this.f17891bB != null) {
            this.handler.post(new Runnable() { // from class: com.tencent.mm.sdk.plugin.MMPluginOAuth.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MMPluginOAuth.this.f17890bA != null) {
                        MMPluginOAuth.this.f17890bA.onResult(MMPluginOAuth.this);
                    }
                }
            });
            return true;
        } else {
            Log.m5649d("MicroMsg.SDK.MMPluginOAuth", "begin to show user oauth page");
            Intent intent = new Intent();
            intent.setClassName(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, "com.tencent.mm.plugin.PluginOAuthUI");
            intent.putExtra(MMPluginProviderConstants.PluginIntent.REQUEST_TOKEN, this.f17892bC);
            intent.putExtra(MMPluginProviderConstants.PluginIntent.PACKAGE, this.f17889R.getPackageName());
            if (this.f17889R.getPackageManager().resolveActivity(intent, 65536) == null) {
                Log.m5647e("MicroMsg.SDK.MMPluginOAuth", "show oauth page failed, activity not found");
                z = false;
            } else {
                if (!(this.f17889R instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                this.f17889R.startActivity(intent);
                z = true;
            }
            if (!z) {
                return false;
            }
            Receiver.register(this.f17892bC, this);
            return true;
        }
    }
}
