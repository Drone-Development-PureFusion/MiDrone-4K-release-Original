package com.fimi.soul.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* renamed from: com.fimi.soul.utils.f */
/* loaded from: classes.dex */
public class C3677f {

    /* renamed from: d */
    private static C3677f f14923d = new C3677f();

    /* renamed from: a */
    private BufferedWriter f14924a;

    /* renamed from: b */
    private File f14925b;

    /* renamed from: c */
    private StringBuffer f14926c = new StringBuffer();

    private C3677f() {
        if (!m7488c()) {
            m7489b();
        }
    }

    /* renamed from: a */
    public static C3677f m7491a() {
        if (f14923d == null) {
            f14923d = new C3677f();
        }
        return f14923d;
    }

    /* renamed from: a */
    public void m7490a(String str) {
        this.f14926c.append(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSSS", Locale.US).format(new Date())).append("   ");
        this.f14926c.append(str);
        this.f14926c.append("\n");
        try {
            this.f14924a.write(this.f14926c.toString());
            this.f14924a.flush();
            this.f14926c = this.f14926c.delete(0, this.f14926c.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m7489b() {
        this.f14925b = new File(C3681j.m7456w());
        if (!this.f14925b.exists()) {
            this.f14925b.getParentFile().mkdirs();
            try {
                this.f14925b.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f14924a == null) {
            try {
                this.f14924a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14925b, true)));
                this.f14924a.flush();
                this.f14926c = this.f14926c.delete(0, this.f14926c.length());
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public boolean m7488c() {
        if (this.f14925b != null && !this.f14925b.exists()) {
            try {
                this.f14924a.close();
                this.f14924a = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (this.f14924a == null || this.f14925b == null || !this.f14925b.exists()) ? false : true;
    }
}
