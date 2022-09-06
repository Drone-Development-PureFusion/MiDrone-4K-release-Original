package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.C4480b;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;
/* renamed from: com.xiaomi.push.service.ah */
/* loaded from: classes.dex */
public class C4609ah {

    /* renamed from: b */
    private static volatile C4609ah f18947b;

    /* renamed from: a */
    protected SharedPreferences f18948a;

    private C4609ah(Context context) {
        this.f18948a = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    /* renamed from: a */
    public static C4609ah m4394a(Context context) {
        if (f18947b == null) {
            synchronized (C4609ah.class) {
                if (f18947b == null) {
                    f18947b = new C4609ah(context);
                }
            }
        }
        return f18947b;
    }

    /* renamed from: a */
    private String m4398a(int i) {
        return "normal_oc_" + i;
    }

    /* renamed from: a */
    private void m4393a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            editor.putString(str, (String) pair.second);
        } else if (!(pair.second instanceof Boolean)) {
        } else {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    /* renamed from: b */
    private String m4391b(int i) {
        return "custom_oc_" + i;
    }

    /* renamed from: a */
    public int m4397a(int i, int i2) {
        String m4391b = m4391b(i);
        if (this.f18948a.contains(m4391b)) {
            return this.f18948a.getInt(m4391b, 0);
        }
        String m4398a = m4398a(i);
        return this.f18948a.contains(m4398a) ? this.f18948a.getInt(m4398a, 0) : i2;
    }

    /* renamed from: a */
    public String m4396a(int i, String str) {
        String m4391b = m4391b(i);
        if (this.f18948a.contains(m4391b)) {
            return this.f18948a.getString(m4391b, null);
        }
        String m4398a = m4398a(i);
        return this.f18948a.contains(m4398a) ? this.f18948a.getString(m4398a, null) : str;
    }

    /* renamed from: a */
    public void m4392a(List<Pair<Integer, Object>> list) {
        if (C4480b.m5030a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f18948a.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null && pair.second != null) {
                m4393a(edit, pair, m4398a(((Integer) pair.first).intValue()));
            }
        }
        edit.commit();
    }

    /* renamed from: a */
    public boolean m4395a(int i, boolean z) {
        String m4391b = m4391b(i);
        if (this.f18948a.contains(m4391b)) {
            return this.f18948a.getBoolean(m4391b, false);
        }
        String m4398a = m4398a(i);
        return this.f18948a.contains(m4398a) ? this.f18948a.getBoolean(m4398a, false) : z;
    }

    /* renamed from: b */
    public void m4390b(List<Pair<Integer, Object>> list) {
        if (C4480b.m5030a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f18948a.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null) {
                String m4391b = m4391b(((Integer) pair.first).intValue());
                if (pair.second == null) {
                    edit.remove(m4391b);
                } else {
                    m4393a(edit, pair, m4391b);
                }
            }
        }
        edit.commit();
    }
}
