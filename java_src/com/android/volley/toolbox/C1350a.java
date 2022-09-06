package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.C1316a;
/* renamed from: com.android.volley.toolbox.a */
/* loaded from: classes.dex */
public class C1350a implements AbstractC1351b {

    /* renamed from: a */
    private final AccountManager f4631a;

    /* renamed from: b */
    private final Account f4632b;

    /* renamed from: c */
    private final String f4633c;

    /* renamed from: d */
    private final boolean f4634d;

    C1350a(AccountManager accountManager, Account account, String str, boolean z) {
        this.f4631a = accountManager;
        this.f4632b = account;
        this.f4633c = str;
        this.f4634d = z;
    }

    public C1350a(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public C1350a(Context context, Account account, String str, boolean z) {
        this(AccountManager.get(context), account, str, z);
    }

    /* renamed from: a */
    public Account m16675a() {
        return this.f4632b;
    }

    @Override // com.android.volley.toolbox.AbstractC1351b
    /* renamed from: a */
    public void mo16674a(String str) {
        this.f4631a.invalidateAuthToken(this.f4632b.type, str);
    }

    @Override // com.android.volley.toolbox.AbstractC1351b
    /* renamed from: b */
    public String mo16673b() {
        String str = null;
        AccountManagerFuture<Bundle> authToken = this.f4631a.getAuthToken(this.f4632b, this.f4633c, this.f4634d, null, null);
        try {
            Bundle result = authToken.getResult();
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (result.containsKey("intent")) {
                    throw new C1316a((Intent) result.getParcelable("intent"));
                }
                str = result.getString("authtoken");
            }
            if (str != null) {
                return str;
            }
            throw new C1316a("Got null auth token for type: " + this.f4633c);
        } catch (Exception e) {
            throw new C1316a("Error while retrieving auth token", e);
        }
    }
}
