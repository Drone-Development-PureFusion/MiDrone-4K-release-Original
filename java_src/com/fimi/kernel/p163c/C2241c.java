package com.fimi.kernel.p163c;

import android.content.SharedPreferences;
import com.fimi.kernel.C2238c;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
/* renamed from: com.fimi.kernel.c.c */
/* loaded from: classes.dex */
public class C2241c implements AbstractC2239a {

    /* renamed from: e */
    private static final String f7471e = "BeautifulKernel_SPStoreManager";

    /* renamed from: b */
    private static C2241c f7470b = null;

    /* renamed from: a */
    public static final ObjectMapper f7469a = new ObjectMapper();

    /* renamed from: d */
    private SharedPreferences f7473d = C2238c.m13131a().getSharedPreferences(f7471e, 0);

    /* renamed from: c */
    private Gson f7472c = new Gson();

    private C2241c() {
    }

    /* renamed from: a */
    public static synchronized C2241c m13122a() {
        C2241c c2241c;
        synchronized (C2241c.class) {
            if (f7470b == null) {
                f7470b = new C2241c();
            }
            c2241c = f7470b;
        }
        return c2241c;
    }

    /* renamed from: b */
    public static boolean m13113b() {
        return m13122a().mo13108d("USER_PROTOCOL");
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public <T> T mo13118a(String str, Class<?> cls) {
        try {
            String string = this.f7473d.getString(str, null);
            if (string == null) {
                return null;
            }
            return (T) this.f7472c.fromJson(string, (Class<Object>) cls);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public String mo13121a(String str) {
        return this.f7473d.getString(str, null);
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public void mo13120a(String str, int i) {
        SharedPreferences.Editor edit = this.f7473d.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public void mo13119a(String str, long j) {
        SharedPreferences.Editor edit = this.f7473d.edit();
        edit.putLong(str, j);
        edit.commit();
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public void mo13117a(String str, Object obj) {
        SharedPreferences.Editor edit = this.f7473d.edit();
        edit.putString(str, this.f7472c.toJson(obj, obj.getClass()));
        edit.commit();
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public void mo13116a(String str, String str2) {
        SharedPreferences.Editor edit = this.f7473d.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public <T> void mo13115a(String str, List<T> list) {
        SharedPreferences.Editor edit = this.f7473d.edit();
        edit.putString(str, this.f7472c.toJson(list));
        edit.commit();
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: a */
    public void mo13114a(String str, boolean z) {
        SharedPreferences.Editor edit = this.f7473d.edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: b */
    public int mo13112b(String str) {
        return this.f7473d.getInt(str, 0);
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: b */
    public List mo13111b(String str, Class<?> cls) {
        CollectionType constructCollectionType = f7469a.getTypeFactory().constructCollectionType(ArrayList.class, cls);
        try {
            String string = this.f7473d.getString(str, null);
            if (string != null) {
                return (List) f7469a.readValue(string, constructCollectionType);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: b */
    public boolean m13110b(String str, boolean z) {
        return this.f7473d.getBoolean(str, z);
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: c */
    public long mo13109c(String str) {
        return this.f7473d.getLong(str, 0L);
    }

    @Override // com.fimi.kernel.p163c.AbstractC2239a
    /* renamed from: d */
    public boolean mo13108d(String str) {
        return this.f7473d.getBoolean(str, false);
    }

    /* renamed from: e */
    public void m13107e(String str) {
        try {
            this.f7473d.edit().remove(str).commit();
        } catch (Exception e) {
        }
    }
}
