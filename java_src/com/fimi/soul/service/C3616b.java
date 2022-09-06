package com.fimi.soul.service;

import com.fimi.kernel.C2238c;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p200f.C2844a;
import com.fimi.soul.utils.C3681j;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
/* renamed from: com.fimi.soul.service.b */
/* loaded from: classes.dex */
public class C3616b {

    /* renamed from: a */
    BufferedWriter f14733a;

    /* renamed from: b */
    BufferedWriter f14734b;

    /* renamed from: c */
    SimpleDateFormat f14735c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.service.b$a */
    /* loaded from: classes.dex */
    public static class C3617a {

        /* renamed from: a */
        private static C3616b f14736a = new C3616b();

        private C3617a() {
        }
    }

    /* renamed from: a */
    public static C3616b m7782a() {
        return C3617a.f14736a;
    }

    /* renamed from: a */
    private void m7781a(C2770c c2770c) {
        if (c2770c == null) {
            return;
        }
        byte[] m11066f = c2770c.m11066f();
        try {
            if (this.f14734b == null) {
                this.f14734b = m7779b();
            }
            this.f14734b.write(m7778c());
            this.f14734b.write("    ");
            StringBuffer stringBuffer = new StringBuffer(m11066f.length * 2);
            for (int i = 0; i < m11066f.length; i++) {
                stringBuffer.append(Character.forDigit((m11066f[i] & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(m11066f[i] & 15, 16));
                stringBuffer.append(" ");
            }
            this.f14734b.write(stringBuffer.toString());
            this.f14734b.write("\n");
            this.f14734b.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private String m7778c() {
        if (this.f14735c == null) {
            this.f14735c = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.US);
        }
        return this.f14735c.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: a */
    public void m7780a(ConcurrentHashMap<String, C2770c> concurrentHashMap) {
        if (concurrentHashMap != null) {
            synchronized (this) {
                for (String str : concurrentHashMap.keySet()) {
                    m7781a(concurrentHashMap.get(str));
                }
            }
        }
    }

    /* renamed from: b */
    public BufferedWriter m7779b() {
        C2844a c2844a = (C2844a) C2238c.m13125c().mo13118a("0", C2844a.class);
        String str = c2844a != null ? c2844a.m10823d() + "" + c2844a.m10821e() + "" + c2844a.m10819g() : null;
        try {
            File file = new File(C3681j.m7482a() + "/SAVEDRONEINFO/");
            file.mkdirs();
            if (str == null) {
                str = "savedrone.txt";
            }
            File file2 = new File(file, str);
            if (!file2.exists() && this.f14733a != null) {
                this.f14733a.close();
                file2.createNewFile();
                this.f14733a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
            } else if (!file2.exists() && this.f14733a == null) {
                file2.createNewFile();
                this.f14733a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
            } else if (file2.exists() && this.f14733a == null) {
                this.f14733a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f14733a;
    }
}
