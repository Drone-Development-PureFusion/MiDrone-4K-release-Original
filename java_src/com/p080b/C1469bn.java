package com.p080b;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.open.SocialConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/* renamed from: com.b.bn */
/* loaded from: classes.dex */
public class C1469bn {

    /* renamed from: com.b.bn$a */
    /* loaded from: classes.dex */
    private class C1470a extends DefaultHandler {

        /* renamed from: a */
        public AmapLoc f5102a;

        /* renamed from: c */
        private String f5104c;

        private C1470a() {
            this.f5102a = new AmapLoc();
            this.f5104c = "";
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            this.f5104c = String.valueOf(cArr, i, i2);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            if (str2.equals("retype")) {
                this.f5102a.m16523g(this.f5104c);
            } else if (str2.equals("rdesc")) {
                this.f5102a.m16521h(this.f5104c);
            } else if (str2.equals("adcode")) {
                this.f5102a.m16515k(this.f5104c);
            } else if (str2.equals("citycode")) {
                this.f5102a.m16519i(this.f5104c);
            } else if (str2.equals("radius")) {
                try {
                    this.f5102a.m16547a(Float.parseFloat(this.f5104c));
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "parser", "endElement3");
                    this.f5102a.m16547a(3891.0f);
                }
            } else if (str2.equals("cenx")) {
                try {
                    this.f5102a.m16548a(Double.parseDouble(this.f5104c));
                } catch (Throwable th2) {
                    C1514cx.m15728a(th2, "parser", "endElement2");
                    this.f5102a.m16548a(0.0d);
                }
            } else if (str2.equals("ceny")) {
                try {
                    this.f5102a.m16540b(Double.parseDouble(this.f5104c));
                } catch (Throwable th3) {
                    C1514cx.m15728a(th3, "parser", "endElement1");
                    this.f5102a.m16540b(0.0d);
                }
            } else if (str2.equals(SocialConstants.PARAM_APP_DESC)) {
                this.f5102a.m16517j(this.f5104c);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_COUNTRY)) {
                this.f5102a.m16513l(this.f5104c);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
                this.f5102a.m16511m(this.f5104c);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_CITY)) {
                this.f5102a.m16509n(this.f5104c);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_DISTRICT)) {
                this.f5102a.m16507o(this.f5104c);
            } else if (str2.equals("road")) {
                this.f5102a.m16505p(this.f5104c);
            } else if (str2.equals("street")) {
                this.f5102a.m16503q(this.f5104c);
            } else if (str2.equals("number")) {
                this.f5102a.m16501r(this.f5104c);
            } else if (str2.equals("poiname")) {
                this.f5102a.m16499s(this.f5104c);
            } else if (str2.equals("BIZ")) {
                if (this.f5102a.m16551E() == null) {
                    this.f5102a.m16543a(new JSONObject());
                }
                try {
                    this.f5102a.m16551E().put("BIZ", this.f5104c);
                } catch (Throwable th4) {
                    C1514cx.m15728a(th4, "parser", "endElement");
                }
            } else if (str2.equals("cens")) {
                this.f5102a.m16495u(this.f5104c);
            } else if (str2.equals("pid")) {
                this.f5102a.m16493v(this.f5104c);
            } else if (str2.equals("flr")) {
                this.f5102a.m16491w(this.f5104c);
            } else if (str2.equals("coord")) {
                if (TextUtils.isEmpty(C1514cx.f5412g)) {
                    C1514cx.f5412g = this.f5104c;
                }
                this.f5102a.m16489x(this.f5104c);
            } else if (str2.equals("mcell")) {
                this.f5102a.m16487y(this.f5104c);
            } else if (str2.equals("gkeyloc") || str2.equals("gkeygeo")) {
            } else {
                if (str2.equals("apiTime")) {
                    this.f5102a.m16545a(Long.parseLong(this.f5104c));
                } else if (!str2.equals("aoiname")) {
                } else {
                    this.f5102a.m16497t(this.f5104c);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            this.f5104c = "";
        }
    }

    /* renamed from: a */
    public AmapLoc m16063a(String str) {
        ByteArrayInputStream byteArrayInputStream;
        if (!str.contains("SuccessCode")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();
            try {
                str = new String(C1544dr.m15603b(sb.toString()), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C1514cx.m15728a(e, "parser", "ParserApsResp1");
            }
            sb.delete(0, sb.length());
        }
        if (str.contains("SuccessCode=\"0\"")) {
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            C1514cx.m15728a(e2, "parser", "ParserApsResp");
            byteArrayInputStream = null;
        }
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        C1470a c1470a = new C1470a();
        try {
            SAXParser newSAXParser = newInstance.newSAXParser();
            if (byteArrayInputStream != null) {
                newSAXParser.parse(byteArrayInputStream, c1470a);
            }
            c1470a.f5102a.m16531c(C3947a.f16908s);
            return c1470a.f5102a;
        } catch (Throwable th) {
            try {
                C1514cx.m15728a(th, "parser", "endElement4");
                AmapLoc amapLoc = new AmapLoc();
                amapLoc.m16538b(5);
                C1430as.f4909c.append("parser error:" + th.getMessage());
                amapLoc.m16537b(C1430as.f4909c.toString());
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return amapLoc;
            } finally {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public AmapLoc m16062b(String str) {
        AmapLoc amapLoc = new AmapLoc();
        amapLoc.m16538b(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                C1430as.f4909c.append("json is error " + str);
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("1")) {
                C1430as.f4909c.append("json is error " + str);
            }
            if (string.equals("0")) {
                C1430as.f4909c.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            C1430as.f4909c.append("json exception error:" + th.getMessage());
            C1514cx.m15728a(th, "parser", "paseAuthFailurJson");
        }
        amapLoc.m16537b(C1430as.f4909c.toString());
        return amapLoc;
    }
}
