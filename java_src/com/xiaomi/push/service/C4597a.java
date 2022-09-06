package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.C4731c;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.a */
/* loaded from: classes.dex */
public class C4597a extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    private XMPushService f18926b;

    /* renamed from: c */
    private C4731c[] f18927c;

    /* renamed from: d */
    private C4707b[] f18928d;

    public C4597a(XMPushService xMPushService, C4707b[] c4707bArr) {
        super(4);
        this.f18926b = null;
        this.f18926b = xMPushService;
        this.f18928d = c4707bArr;
    }

    public C4597a(XMPushService xMPushService, C4731c[] c4731cArr) {
        super(4);
        this.f18926b = null;
        this.f18926b = xMPushService;
        this.f18927c = c4731cArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            if (this.f18927c != null) {
                this.f18926b.m4474a(this.f18927c);
            } else {
                this.f18926b.m4475a(this.f18928d);
            }
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f18926b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "batch send message.";
    }
}
