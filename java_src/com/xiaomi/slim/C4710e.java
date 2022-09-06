package com.xiaomi.slim;

import com.tencent.p227mm.sdk.message.RMsgInfoDB;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.util.C4743a;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* renamed from: com.xiaomi.slim.e */
/* loaded from: classes2.dex */
public class C4710e {

    /* renamed from: a */
    private XmlPullParser f19351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4710e() {
        try {
            this.f19351a = XmlPullParserFactory.newInstance().newPullParser();
            this.f19351a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC4732d m3999a(byte[] bArr, AbstractC4713a abstractC4713a) {
        this.f19351a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f19351a.next();
        int eventType = this.f19351a.getEventType();
        String name = this.f19351a.getName();
        if (eventType == 2) {
            if (name.equals(RMsgInfoDB.TABLE)) {
                return C4743a.m3849a(this.f19351a);
            }
            if (name.equals("iq")) {
                return C4743a.m3848a(this.f19351a, abstractC4713a);
            }
            if (name.equals("presence")) {
                return C4743a.m3846b(this.f19351a);
            }
            if (!this.f19351a.getName().equals("stream")) {
                if (this.f19351a.getName().equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    throw new C4727l(C4743a.m3845c(this.f19351a));
                }
                if (this.f19351a.getName().equals("warning")) {
                    this.f19351a.next();
                    if (this.f19351a.getName().equals("multi-login")) {
                    }
                } else if (this.f19351a.getName().equals("bind")) {
                }
            }
        }
        return null;
    }
}
