package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.file.C4476c;
import com.xiaomi.push.log.C4556b;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.log.c */
/* loaded from: classes2.dex */
public class C4560c extends C4556b.C4558b {

    /* renamed from: a */
    File f18734a;

    /* renamed from: b */
    final /* synthetic */ int f18735b;

    /* renamed from: c */
    final /* synthetic */ Date f18736c;

    /* renamed from: d */
    final /* synthetic */ Date f18737d;

    /* renamed from: e */
    final /* synthetic */ String f18738e;

    /* renamed from: f */
    final /* synthetic */ String f18739f;

    /* renamed from: g */
    final /* synthetic */ boolean f18740g;

    /* renamed from: h */
    final /* synthetic */ C4556b f18741h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4560c(C4556b c4556b, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f18741h = c4556b;
        this.f18735b = i;
        this.f18736c = date;
        this.f18737d = date2;
        this.f18738e = str;
        this.f18739f = str2;
        this.f18740g = z;
    }

    @Override // com.xiaomi.push.log.C4556b.C4558b, com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: b */
    public void mo3817b() {
        if (!C4476c.m5049d()) {
            return;
        }
        try {
            File file = new File(this.f18741h.f18723b.getExternalFilesDir(null) + "/.logcache");
            file.mkdirs();
            if (!file.isDirectory()) {
                return;
            }
            C4555a c4555a = new C4555a();
            c4555a.m4731a(this.f18735b);
            this.f18734a = c4555a.m4730a(this.f18741h.f18723b, this.f18736c, this.f18737d, file);
        } catch (NullPointerException e) {
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: c */
    public void mo4323c() {
        if (this.f18734a != null && this.f18734a.exists()) {
            this.f18741h.f18722a.add(new C4556b.C4559c(this.f18738e, this.f18739f, this.f18734a, this.f18740g));
        }
        this.f18741h.m4724a(0L);
    }
}
