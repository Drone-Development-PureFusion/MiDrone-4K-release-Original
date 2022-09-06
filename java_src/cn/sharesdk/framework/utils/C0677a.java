package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.mob.tools.network.KVPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p252c.p255c.C5045l;
import org.p248a.p249a.p252c.p258f.C5078j;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: cn.sharesdk.framework.utils.a */
/* loaded from: classes.dex */
public class C0677a {

    /* renamed from: a */
    private C0680b f1605a = new C0680b();

    /* renamed from: b */
    private C0681b f1606b = new C0681b("-._~", false);

    /* renamed from: cn.sharesdk.framework.utils.a$a */
    /* loaded from: classes.dex */
    public enum EnumC0679a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* renamed from: cn.sharesdk.framework.utils.a$b */
    /* loaded from: classes.dex */
    public static class C0680b {

        /* renamed from: a */
        public String f1611a;

        /* renamed from: b */
        public String f1612b;

        /* renamed from: c */
        public String f1613c;

        /* renamed from: d */
        public String f1614d;

        /* renamed from: e */
        public String f1615e;
    }

    /* renamed from: a */
    private ArrayList<KVPair<String>> m19528a(long j, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f1605a.f1611a));
        arrayList.add(new KVPair<>("oauth_signature_method", str));
        arrayList.add(new KVPair<>("oauth_timestamp", String.valueOf(j / 1000)));
        arrayList.add(new KVPair<>("oauth_nonce", String.valueOf(j)));
        arrayList.add(new KVPair<>("oauth_version", "1.0"));
        String str2 = this.f1605a.f1613c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair<>("oauth_token", str2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<KVPair<String>> m19527a(long j, ArrayList<KVPair<String>> arrayList, String str) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                hashMap.put(m19526a(next.name), m19526a(next.value));
            }
        }
        ArrayList<KVPair<String>> m19528a = m19528a(j, str);
        if (m19528a != null) {
            Iterator<KVPair<String>> it3 = m19528a.iterator();
            while (it3.hasNext()) {
                KVPair<String> next2 = it3.next();
                hashMap.put(m19526a(next2.name), m19526a(next2.value));
            }
        }
        String[] strArr = new String[hashMap.size()];
        int i = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            strArr[i] = (String) entry.getKey();
            i++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        for (String str2 : strArr) {
            arrayList2.add(new KVPair<>(str2, hashMap.get(str2)));
        }
        return arrayList2;
    }

    /* renamed from: a */
    private ArrayList<KVPair<String>> m19523a(String str, String str2, ArrayList<KVPair<String>> arrayList, EnumC0679a enumC0679a) {
        String str3;
        String str4 = null;
        long currentTimeMillis = System.currentTimeMillis();
        switch (enumC0679a) {
            case HMAC_SHA1:
                str4 = "HMAC-SHA1";
                SecretKeySpec secretKeySpec = new SecretKeySpec((m19526a(this.f1605a.f1612b) + '&' + m19526a(this.f1605a.f1614d)).getBytes("utf-8"), "HMAC-SHA1");
                Mac mac = Mac.getInstance("HMAC-SHA1");
                mac.init(secretKeySpec);
                str3 = new String(Base64.encode(mac.doFinal((str2 + '&' + m19526a(str) + '&' + m19526a(m19517b(m19527a(currentTimeMillis, arrayList, str4)))).getBytes("utf-8")), 0)).trim();
                break;
            case PLAINTEXT:
                str4 = "PLAINTEXT";
                str3 = m19526a(this.f1605a.f1612b) + '&' + m19526a(this.f1605a.f1614d);
                break;
            default:
                str3 = null;
                break;
        }
        ArrayList<KVPair<String>> m19528a = m19528a(currentTimeMillis, str4);
        m19528a.add(new KVPair<>("oauth_signature", str3));
        return m19528a;
    }

    /* renamed from: b */
    private String m19517b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it2.hasNext()) {
                return sb.toString();
            }
            KVPair<String> next = it2.next();
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(next.name).append(SignatureVisitor.INSTANCEOF).append(next.value);
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public C0680b m19529a() {
        return this.f1605a;
    }

    /* renamed from: a */
    public String m19526a(String str) {
        return str == null ? "" : this.f1606b.escape(str);
    }

    /* renamed from: a */
    public ArrayList<KVPair<String>> m19522a(String str, ArrayList<KVPair<String>> arrayList) {
        return m19521a(str, arrayList, EnumC0679a.HMAC_SHA1);
    }

    /* renamed from: a */
    public ArrayList<KVPair<String>> m19521a(String str, ArrayList<KVPair<String>> arrayList, EnumC0679a enumC0679a) {
        return m19523a(str, "POST", arrayList, enumC0679a);
    }

    /* renamed from: a */
    public ArrayList<KVPair<String>> m19520a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb = new StringBuilder("OAuth ");
        int i = 0;
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it2.hasNext()) {
                ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                arrayList2.add(new KVPair<>("Authorization", sb.toString()));
                arrayList2.add(new KVPair<>("Content-Type", C5078j.f21618a));
                return arrayList2;
            }
            KVPair<String> next = it2.next();
            if (i2 > 0) {
                sb.append(C0359h.f727x);
            }
            sb.append(next.name).append("=\"").append(m19526a(next.value)).append("\"");
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public void m19525a(String str, String str2) {
        this.f1605a.f1613c = str;
        this.f1605a.f1614d = str2;
    }

    /* renamed from: a */
    public void m19524a(String str, String str2, String str3) {
        this.f1605a.f1611a = str;
        this.f1605a.f1612b = str2;
        this.f1605a.f1615e = str3;
    }

    /* renamed from: b */
    public ArrayList<KVPair<String>> m19519b(String str, ArrayList<KVPair<String>> arrayList) {
        return m19518b(str, arrayList, EnumC0679a.HMAC_SHA1);
    }

    /* renamed from: b */
    public ArrayList<KVPair<String>> m19518b(String str, ArrayList<KVPair<String>> arrayList, EnumC0679a enumC0679a) {
        return m19523a(str, "GET", arrayList, enumC0679a);
    }

    /* renamed from: c */
    public ArrayList<KVPair<String>> m19516c(String str, ArrayList<KVPair<String>> arrayList, EnumC0679a enumC0679a) {
        return m19523a(str, C5045l.f21547a, arrayList, enumC0679a);
    }
}
