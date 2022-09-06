package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.AbstractC4732d;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.as */
/* loaded from: classes.dex */
public class C4626as extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    private XMPushService f19026b;

    /* renamed from: c */
    private AbstractC4732d f19027c;

    /* renamed from: d */
    private C4707b f19028d;

    public C4626as(XMPushService xMPushService, C4707b c4707b) {
        super(4);
        this.f19026b = null;
        this.f19026b = xMPushService;
        this.f19028d = c4707b;
    }

    public C4626as(XMPushService xMPushService, AbstractC4732d abstractC4732d) {
        super(4);
        this.f19026b = null;
        this.f19026b = xMPushService;
        this.f19027c = abstractC4732d;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            if (this.f19027c != null) {
                this.f19026b.m4484a(this.f19027c);
            } else {
                this.f19026b.m4486a(this.f19028d);
            }
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19026b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send a message.";
    }
}
