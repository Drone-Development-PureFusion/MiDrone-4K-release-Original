package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.tencent.p227mm.sdk.message.RMsgInfoDB;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.C4624aq;
import com.xiaomi.push.service.C4657c;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.packet.C4728a;
import com.xiaomi.smack.packet.C4729b;
import com.xiaomi.smack.packet.C4731c;
import com.xiaomi.smack.packet.C4734f;
import com.xiaomi.smack.packet.C4737g;
import com.xiaomi.smack.packet.C4738h;
import com.xiaomi.smack.provider.C4742c;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* renamed from: com.xiaomi.smack.util.a */
/* loaded from: classes2.dex */
public class C4743a {

    /* renamed from: a */
    private static XmlPullParser f19506a = null;

    /* renamed from: a */
    public static C4728a m3850a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m3855a = C4742c.m3856a().m3855a("all", "xm:chat");
        if (m3855a == null || !(m3855a instanceof C4657c)) {
            return null;
        }
        return ((C4657c) m3855a).m4277b(xmlPullParser);
    }

    /* renamed from: a */
    public static C4729b m3848a(XmlPullParser xmlPullParser, AbstractC4713a abstractC4713a) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        C4729b.C4730a m3911a = C4729b.C4730a.m3911a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        boolean z = false;
        C4738h c4738h = null;
        C4729b c4729b = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    c4738h = m3844d(xmlPullParser);
                } else {
                    c4729b = new C4729b();
                    c4729b.a(m3850a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
            c4738h = c4738h;
            c4729b = c4729b;
            z = z;
        }
        if (c4729b == null) {
            if (C4729b.C4730a.f19419a == m3911a || C4729b.C4730a.f19420b == m3911a) {
                C4744b c4744b = new C4744b();
                c4744b.k(attributeValue);
                c4744b.m(attributeValue3);
                c4744b.n(attributeValue2);
                c4744b.m3913a(C4729b.C4730a.f19422d);
                c4744b.l(attributeValue4);
                c4744b.a(new C4738h(C4738h.C4739a.f19482e));
                abstractC4713a.mo3986a(c4744b);
                AbstractC4478b.m5036d("iq usage error. send packet in packet parser.");
                return null;
            }
            c4729b = new C4745c();
        }
        c4729b.k(attributeValue);
        c4729b.m(attributeValue2);
        c4729b.l(attributeValue4);
        c4729b.n(attributeValue3);
        c4729b.m3913a(m3911a);
        c4729b.a(c4738h);
        c4729b.m3912a(hashMap);
        return c4729b;
    }

    /* renamed from: a */
    public static AbstractC4732d m3849a(XmlPullParser xmlPullParser) {
        String str;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(attributeValue, attributeValue4);
            C4612ak.C4614b m4374b2 = m4374b == null ? C4612ak.m4383a().m4374b(attributeValue, attributeValue3) : m4374b;
            if (m4374b2 == null) {
                throw new C4727l("the channel id is wrong while receiving a encrypted message");
            }
            boolean z = false;
            AbstractC4732d abstractC4732d = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new C4727l("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new C4727l("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        C4731c c4731c = new C4731c();
                        c4731c.l(attributeValue);
                        c4731c.m3905b(true);
                        c4731c.n(attributeValue3);
                        c4731c.m(attributeValue4);
                        c4731c.k(attributeValue2);
                        c4731c.m3898f(attributeValue5);
                        C4728a c4728a = new C4728a("s", null, null, null);
                        c4728a.m3918b(text);
                        c4731c.a(c4728a);
                        return c4731c;
                    }
                    m3847a(C4624aq.m4344b(C4624aq.m4350a(m4374b2.f18962i, attributeValue2), text));
                    f19506a.next();
                    abstractC4732d = m3849a(f19506a);
                } else if (next == 3 && xmlPullParser.getName().equals(RMsgInfoDB.TABLE)) {
                    z = true;
                }
            }
            if (abstractC4732d != null) {
                return abstractC4732d;
            }
            throw new C4727l("error while receiving a encrypted message with wrong format");
        }
        C4731c c4731c2 = new C4731c();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        c4731c2.k(attributeValue6);
        c4731c2.m(xmlPullParser.getAttributeValue("", "to"));
        c4731c2.n(xmlPullParser.getAttributeValue("", "from"));
        c4731c2.l(xmlPullParser.getAttributeValue("", "chid"));
        c4731c2.m3909a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception e) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                c4731c2.m3906b(attributeValue7);
            }
        } catch (Exception e2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                c4731c2.m3904c(attributeValue8);
            }
        } catch (Exception e3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                c4731c2.m3902d(attributeValue9);
            }
        } catch (Exception e4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                c4731c2.m3900e(attributeValue10);
            }
        } catch (Exception e5) {
        }
        c4731c2.m3907a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        c4731c2.m3898f(xmlPullParser.getAttributeValue("", "type"));
        String m3842f = m3842f(xmlPullParser);
        if (m3842f == null || "".equals(m3842f.trim())) {
            AbstractC4732d.m3869u();
        } else {
            c4731c2.m3891j(m3842f);
        }
        String str2 = null;
        boolean z2 = false;
        while (!z2) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    if (m3842f(xmlPullParser) == null) {
                    }
                    c4731c2.m3896g(m3843e(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m3843e = m3843e(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        c4731c2.m3908a(m3843e, attributeValue11);
                    } else {
                        c4731c2.m3894h(m3843e);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    c4731c2.a(m3844d(xmlPullParser));
                } else {
                    c4731c2.a(m3850a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals(RMsgInfoDB.TABLE)) {
                z2 = true;
            }
        }
        c4731c2.m3892i(str2);
        return c4731c2;
    }

    /* renamed from: a */
    private static void m3847a(byte[] bArr) {
        if (f19506a == null) {
            try {
                f19506a = XmlPullParserFactory.newInstance().newPullParser();
                f19506a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f19506a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: b */
    public static C4734f m3846b(XmlPullParser xmlPullParser) {
        C4734f.EnumC4736b enumC4736b = C4734f.EnumC4736b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                enumC4736b = C4734f.EnumC4736b.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        C4734f c4734f = new C4734f(enumC4736b);
        c4734f.m(xmlPullParser.getAttributeValue("", "to"));
        c4734f.n(xmlPullParser.getAttributeValue("", "from"));
        c4734f.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        c4734f.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    c4734f.m3864a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        c4734f.m3867a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        c4734f.m3867a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        c4734f.m3866a(C4734f.EnumC4735a.valueOf(nextText));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    c4734f.a(m3844d(xmlPullParser));
                } else {
                    c4734f.a(m3850a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return c4734f;
    }

    /* renamed from: c */
    public static C4737g m3845c(XmlPullParser xmlPullParser) {
        C4737g c4737g = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                c4737g = new C4737g(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                z = true;
            }
        }
        return c4737g;
    }

    /* renamed from: d */
    public static C4738h m3844d(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = "-1";
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeValue = xmlPullParser.getAttributeName(i).equals(XiaomiOAuthConstants.EXTRA_CODE_2) ? xmlPullParser.getAttributeValue("", XiaomiOAuthConstants.EXTRA_CODE_2) : str3;
            String attributeValue2 = xmlPullParser.getAttributeName(i).equals("type") ? xmlPullParser.getAttributeValue("", "type") : str2;
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str = xmlPullParser.getAttributeValue("", "reason");
            }
            i++;
            str2 = attributeValue2;
            str3 = attributeValue;
        }
        boolean z = false;
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(m3850a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new C4738h(Integer.parseInt(str3), str2 == null ? "cancel" : str2, str, str4, str5, arrayList);
    }

    /* renamed from: e */
    private static String m3843e(XmlPullParser xmlPullParser) {
        String str = "";
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: f */
    private static String m3842f(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
