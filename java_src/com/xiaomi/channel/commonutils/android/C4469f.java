package com.xiaomi.channel.commonutils.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
/* renamed from: com.xiaomi.channel.commonutils.android.f */
/* loaded from: classes2.dex */
public class C4469f {
    /* renamed from: a */
    public static Account m5076a(Context context) {
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.xiaomi");
            if (accountsByType != null && accountsByType.length > 0) {
                return accountsByType[0];
            }
            return null;
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            return null;
        }
    }
}
