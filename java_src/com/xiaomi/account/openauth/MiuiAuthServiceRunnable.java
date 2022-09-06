package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.account.IXiaomiAuthService;
import p233d.p234a.AbstractC4840a;
/* loaded from: classes2.dex */
abstract class MiuiAuthServiceRunnable<V> extends XiaomiOAuthRunnable<V> implements ServiceConnection {
    private static final String ACTION_FOR_AUTH_SERVICE = "android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE";
    private static final String PACKAGE_NAME_FOR_AUTH_SERVICE = "com.xiaomi.account";
    protected final Account account;
    private final Context context;
    protected final Bundle options;

    /* loaded from: classes2.dex */
    static class NoMiuiAuthServiceException extends Exception {
        NoMiuiAuthServiceException() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiuiAuthServiceRunnable(Context context, Account account, Bundle bundle) {
        this.context = context;
        this.account = account;
        this.options = bundle;
    }

    private static Intent getAuthServiceIntent() {
        Intent intent = new Intent(ACTION_FOR_AUTH_SERVICE);
        if (Build.VERSION.SDK_INT >= 21) {
            intent.setPackage(PACKAGE_NAME_FOR_AUTH_SERVICE);
        }
        return intent;
    }

    @Override // com.xiaomi.account.openauth.XiaomiOAuthRunnable
    public final void doRun() {
        if (!this.context.bindService(getAuthServiceIntent(), this, 1)) {
            this.context.unbindService(this);
            this.mFuture.setException(new NoMiuiAuthServiceException());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            try {
                this.mFuture.set(mo21875talkWithMiuiV6(IXiaomiAuthService.Stub.asInterface(iBinder)));
                this.context.unbindService(this);
            } catch (SecurityException e) {
                try {
                    this.mFuture.set(mo21874talkWithMiuiV5(AbstractC4840a.AbstractBinderC4841a.m3152a(iBinder)));
                } catch (SecurityException e2) {
                    this.mFuture.setException(new NoMiuiAuthServiceException());
                }
            }
        } catch (RemoteException e3) {
            this.mFuture.setException(e3);
        } finally {
            this.context.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }

    /* renamed from: talkWithMiuiV5 */
    protected abstract V mo21874talkWithMiuiV5(AbstractC4840a abstractC4840a);

    /* renamed from: talkWithMiuiV6 */
    protected abstract V mo21875talkWithMiuiV6(IXiaomiAuthService iXiaomiAuthService);
}
