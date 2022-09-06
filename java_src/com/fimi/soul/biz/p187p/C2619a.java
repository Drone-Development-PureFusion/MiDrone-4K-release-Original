package com.fimi.soul.biz.p187p;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import java.util.HashMap;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.biz.p.a */
/* loaded from: classes.dex */
public class C2619a extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9080a = 194;

    /* renamed from: c */
    private static C2770c f9081c;

    /* renamed from: d */
    private byte f9082d;

    /* renamed from: e */
    private byte f9083e;

    /* renamed from: f */
    private byte f9084f;

    /* renamed from: g */
    private byte f9085g;

    /* renamed from: h */
    private byte f9086h;

    /* renamed from: i */
    private String f9087i;

    /* renamed from: j */
    private HashMap<Integer, String> f9088j = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.biz.p.a$a */
    /* loaded from: classes.dex */
    public static class C2620a {

        /* renamed from: a */
        private static final C2619a f9089a = new C2619a();

        private C2620a() {
        }
    }

    /* renamed from: a */
    public static C2619a m11493a() {
        return C2620a.f9089a;
    }

    /* renamed from: b */
    public static void m11486b(C2770c c2770c) {
        f9081c = c2770c;
    }

    /* renamed from: c */
    public static void m11482c(C2770c c2770c) {
        f9081c = c2770c;
    }

    /* renamed from: d */
    public static C2770c m11481d() {
        return f9081c;
    }

    /* renamed from: a */
    public String m11489a(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            int parseInt = Integer.parseInt(str.substring(i, i + 2), 16);
            sb.append((char) parseInt);
            sb2.append(parseInt);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m11492a(byte b) {
        this.f9086h = b;
    }

    /* renamed from: a */
    public void m11490a(C2770c c2770c) {
        this.f10260b = c2770c.f10263c;
        m11486b(c2770c);
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9082d = c2771d.m11050d();
        this.f9083e = c2771d.m11050d();
        this.f9084f = c2771d.m11050d();
        this.f9085g = c2771d.m11050d();
        this.f9086h = c2771d.m11050d();
        try {
            StringBuilder sb = new StringBuilder();
            byte[] m11066f = f9081c.m11066f();
            for (int i = 0; i < m11066f.length; i++) {
                sb.append(Character.forDigit((m11066f[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(m11066f[i] & 15, 16));
            }
            this.f9087i = m11489a(sb.toString().substring(16, sb.toString().length() - 4));
            this.f9088j.put(Integer.valueOf(this.f9083e), this.f9087i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean m11491a(int i) {
        return this.f9088j.containsKey(Integer.valueOf(i));
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        return null;
    }

    /* renamed from: b */
    public String m11487b(int i) {
        return this.f9088j.containsKey(Integer.valueOf(i)) ? this.f9088j.get(Integer.valueOf(i)) : " ";
    }

    /* renamed from: b */
    public void m11488b(byte b) {
        this.f9085g = b;
    }

    /* renamed from: b */
    public void m11485b(String str) {
        this.f9087i = str;
    }

    /* renamed from: c */
    public C2770c m11484c() {
        return f9081c;
    }

    /* renamed from: c */
    public void m11483c(byte b) {
        this.f9084f = b;
    }

    /* renamed from: d */
    public void m11480d(byte b) {
        this.f9083e = b;
    }

    /* renamed from: e */
    public String m11479e() {
        return this.f9087i;
    }

    /* renamed from: e */
    public void m11478e(byte b) {
        this.f9082d = b;
    }

    /* renamed from: f */
    public byte m11477f() {
        return this.f9086h;
    }

    /* renamed from: g */
    public byte m11476g() {
        return this.f9085g;
    }

    /* renamed from: h */
    public byte m11475h() {
        return this.f9084f;
    }

    /* renamed from: i */
    public byte m11474i() {
        return this.f9083e;
    }

    /* renamed from: j */
    public byte m11473j() {
        return this.f9082d;
    }

    /* renamed from: k */
    public HashMap<Integer, String> m11472k() {
        return this.f9088j;
    }

    /* renamed from: l */
    public void m11471l() {
        this.f9088j.clear();
    }

    public String toString() {
        return "ParseC2BackOrder{Packet_sequence=" + ((int) this.f9082d) + ", type=" + ((int) this.f9083e) + ", model=" + ((int) this.f9084f) + ", reserved=" + ((int) this.f9085g) + ", cmdId=" + ((int) this.f9086h) + ", versionDiscription='" + this.f9087i + C0359h.f729z + C0359h.f726w;
    }
}
