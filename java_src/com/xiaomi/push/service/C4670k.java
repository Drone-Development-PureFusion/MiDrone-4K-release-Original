package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.C4469f;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.k */
/* loaded from: classes2.dex */
public class C4670k {

    /* renamed from: c */
    private static volatile C4670k f19117c;

    /* renamed from: a */
    private Context f19118a;

    /* renamed from: b */
    private AccountManager f19119b;

    /* renamed from: d */
    private ArrayList<AbstractC4671a> f19120d = new ArrayList<>();

    /* renamed from: e */
    private OnAccountsUpdateListener f19121e;

    /* renamed from: com.xiaomi.push.service.k$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4671a {
        /* renamed from: a */
        void mo4203a(String str, Context context);
    }

    private C4670k(Context context) {
        this.f19118a = context;
        this.f19119b = AccountManager.get(this.f19118a);
    }

    /* renamed from: a */
    public static C4670k m4213a(Context context) {
        if (f19117c == null) {
            synchronized (C4670k.class) {
                if (f19117c == null) {
                    f19117c = new C4670k(context);
                }
            }
        }
        return f19117c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4209a(String str) {
        if (this.f19120d == null || this.f19120d.size() < 1) {
            return;
        }
        Iterator<AbstractC4671a> it2 = this.f19120d.iterator();
        while (it2.hasNext()) {
            it2.next().mo4203a(str, this.f19118a);
        }
    }

    /* renamed from: d */
    private void m4205d() {
        if (this.f19121e != null) {
            return;
        }
        this.f19121e = new C4672l(this);
    }

    /* renamed from: e */
    private String m4204e() {
        Account m5076a = C4469f.m5076a(this.f19118a);
        return m5076a == null ? "" : m5076a.name;
    }

    /* renamed from: a */
    public void m4214a() {
        try {
            if (this.f19121e == null) {
                m4205d();
            }
            this.f19119b.addOnAccountsUpdatedListener(this.f19121e, null, true);
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
        }
    }

    /* renamed from: a */
    public void m4212a(AbstractC4671a abstractC4671a) {
        if (this.f19120d == null) {
            this.f19120d = new ArrayList<>();
        }
        if (abstractC4671a != null) {
            int size = this.f19120d.size();
            this.f19120d.add(abstractC4671a);
            if (size != 0) {
                return;
            }
            m4214a();
        }
    }

    /* renamed from: b */
    public void m4208b() {
        if (this.f19121e == null) {
            return;
        }
        this.f19119b.removeOnAccountsUpdatedListener(this.f19121e);
    }

    /* renamed from: b */
    public void m4207b(AbstractC4671a abstractC4671a) {
        if (this.f19120d == null || abstractC4671a == null) {
            return;
        }
        this.f19120d.remove(abstractC4671a);
        if (this.f19120d.size() != 0) {
            return;
        }
        m4208b();
    }

    /* renamed from: c */
    public String m4206c() {
        String m4204e = m4204e();
        if (!TextUtils.isEmpty(m4204e)) {
            C4673m.m4201a(this.f19118a).m4200a(m4204e);
            return m4204e;
        }
        C4673m.m4201a(this.f19118a).m4200a("0");
        return "0";
    }
}
