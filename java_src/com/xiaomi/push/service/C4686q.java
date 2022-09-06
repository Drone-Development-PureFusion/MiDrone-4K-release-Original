package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* renamed from: com.xiaomi.push.service.q */
/* loaded from: classes.dex */
public class C4686q extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    private XMPushService f19178b;

    /* renamed from: c */
    private byte[] f19179c;

    /* renamed from: d */
    private String f19180d;

    /* renamed from: e */
    private String f19181e;

    /* renamed from: f */
    private String f19182f;

    public C4686q(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f19178b = xMPushService;
        this.f19180d = str;
        this.f19179c = bArr;
        this.f19181e = str2;
        this.f19182f = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3811a() {
        C4682n c4682n;
        C4612ak.C4614b next;
        C4682n m4137a = C4683o.m4137a(this.f19178b);
        if (m4137a == null) {
            try {
                c4682n = C4683o.m4135a(this.f19178b, this.f19180d, this.f19181e, this.f19182f);
            } catch (IOException e) {
                AbstractC4478b.m5039a(e);
                c4682n = m4137a;
            } catch (JSONException e2) {
                AbstractC4478b.m5039a(e2);
            }
            if (c4682n != null) {
                AbstractC4478b.m5036d("no account for mipush");
                C4687r.m4120a(this.f19178b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<C4612ak.C4614b> m4372c = C4612ak.m4383a().m4372c("5");
            if (m4372c.isEmpty()) {
                next = c4682n.m4141a(this.f19178b);
                C4598aa.m4441a(this.f19178b, next);
                C4612ak.m4383a().m4379a(next);
            } else {
                next = m4372c.iterator().next();
            }
            if (!this.f19178b.m4457f()) {
                this.f19178b.m4477a(true);
                return;
            }
            try {
                if (next.f18966m == C4612ak.EnumC4616c.binded) {
                    C4598aa.m4439a(this.f19178b, this.f19180d, this.f19179c);
                } else if (next.f18966m == C4612ak.EnumC4616c.unbind) {
                    XMPushService xMPushService = this.f19178b;
                    XMPushService xMPushService2 = this.f19178b;
                    xMPushService2.getClass();
                    xMPushService.m4494a(new XMPushService.C4582a(next));
                }
                return;
            } catch (C4727l e3) {
                AbstractC4478b.m5039a(e3);
                this.f19178b.m4499a(10, e3);
                return;
            }
        }
        c4682n = m4137a;
        if (c4682n != null) {
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "register app";
    }
}
