package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.AbstractC4717d;
import com.xiaomi.smack.AbstractC4720f;
import com.xiaomi.smack.debugger.AbstractC4718a;
import com.xiaomi.smack.filter.AbstractC4721a;
import com.xiaomi.smack.packet.AbstractC4732d;
import java.text.SimpleDateFormat;
import java.util.Date;
/* renamed from: com.xiaomi.measite.smack.a */
/* loaded from: classes2.dex */
public class C4510a implements AbstractC4718a {

    /* renamed from: a */
    public static boolean f18590a;

    /* renamed from: c */
    private AbstractC4713a f18592c;

    /* renamed from: b */
    private SimpleDateFormat f18591b = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: d */
    private C4511a f18593d = null;

    /* renamed from: e */
    private C4511a f18594e = null;

    /* renamed from: f */
    private AbstractC4717d f18595f = null;

    /* renamed from: g */
    private final String f18596g = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.measite.smack.a$a */
    /* loaded from: classes2.dex */
    public class C4511a implements AbstractC4720f, AbstractC4721a {

        /* renamed from: a */
        String f18597a;

        C4511a(boolean z) {
            this.f18597a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.smack.AbstractC4720f
        /* renamed from: a */
        public void mo3953a(C4707b c4707b) {
            if (C4510a.f18590a) {
                AbstractC4478b.m5037c("[Slim] " + C4510a.this.f18591b.format(new Date()) + this.f18597a + c4707b.toString());
            } else {
                AbstractC4478b.m5037c("[Slim] " + C4510a.this.f18591b.format(new Date()) + this.f18597a + " Blob [" + c4707b.m4035a() + Constants.ACCEPT_TIME_SEPARATOR_SP + c4707b.m4023c() + Constants.ACCEPT_TIME_SEPARATOR_SP + c4707b.m4015h() + "]");
            }
        }

        @Override // com.xiaomi.smack.filter.AbstractC4721a
        /* renamed from: a */
        public boolean mo3951a(AbstractC4732d abstractC4732d) {
            return true;
        }

        @Override // com.xiaomi.smack.AbstractC4720f
        /* renamed from: b */
        public void mo3952b(AbstractC4732d abstractC4732d) {
            if (C4510a.f18590a) {
                AbstractC4478b.m5037c("[Slim] " + C4510a.this.f18591b.format(new Date()) + this.f18597a + " PKT " + abstractC4732d.mo3862c());
            } else {
                AbstractC4478b.m5037c("[Slim] " + C4510a.this.f18591b.format(new Date()) + this.f18597a + " PKT [" + abstractC4732d.m3884l() + Constants.ACCEPT_TIME_SEPARATOR_SP + abstractC4732d.m3886k() + "]");
            }
        }
    }

    static {
        boolean z = true;
        if (C4473j.m5063c() != 1) {
            z = false;
        }
        f18590a = z;
    }

    public C4510a(AbstractC4713a abstractC4713a) {
        this.f18592c = null;
        this.f18592c = abstractC4713a;
        m4941a();
    }

    /* renamed from: a */
    private void m4941a() {
        this.f18593d = new C4511a(true);
        this.f18594e = new C4511a(false);
        this.f18592c.m3987a(this.f18593d, this.f18593d);
        this.f18592c.m3980b(this.f18594e, this.f18594e);
        this.f18595f = new C4512b(this);
    }
}
