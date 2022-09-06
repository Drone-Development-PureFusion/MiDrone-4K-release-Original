package com.p080b;

import android.content.Context;
import android.os.Looper;
import com.p080b.C1411ai;
import com.p080b.C1549dv;
import com.tencent.p227mm.sdk.contact.RContact;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.h */
/* loaded from: classes.dex */
public abstract class AbstractC1561h {

    /* renamed from: a */
    private C1549dv f5559a;

    /* renamed from: b */
    private int f5560b;

    /* renamed from: c */
    private AbstractC1418aj f5561c;

    /* renamed from: d */
    private C1411ai f5562d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.h$a */
    /* loaded from: classes.dex */
    public class C1562a implements AbstractC1418aj {

        /* renamed from: b */
        private C1569o f5564b;

        C1562a(C1569o c1569o) {
            this.f5564b = c1569o;
        }

        @Override // com.p080b.AbstractC1418aj
        /* renamed from: a */
        public void mo15506a(String str) {
            try {
                this.f5564b.m15477b(str, AbstractC1561h.this.m15521b());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1561h(int i) {
        this.f5560b = i;
    }

    /* renamed from: a */
    private String m15537a(Context context, C1549dv c1549dv) {
        return C1535do.m15652a(context, c1549dv);
    }

    /* renamed from: a */
    private String m15536a(Context context, String str) {
        try {
            return C1535do.m15649a(context, str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m15527a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m15524a(List<C1571q> list, Context context) {
        boolean z;
        C1571q next;
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"").append(m15507g(context)).append("\",\"els\":[");
        boolean z2 = true;
        Iterator<C1571q> it2 = list.iterator();
        while (true) {
            z = z2;
            if (!it2.hasNext()) {
                break;
            }
            String m15510d = m15510d(it2.next().m15468b());
            if (m15510d != null && !"".equals(m15510d)) {
                String str = m15510d + "||" + next.m15464d();
                if (z) {
                    z = false;
                } else {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append("{\"log\":\"").append(str).append("\"}");
            }
            z2 = z;
        }
        if (z) {
            return null;
        }
        sb.append("]}");
        return sb.toString();
    }

    /* renamed from: a */
    private void m15530a(C1569o c1569o, int i) {
        try {
            m15523a(c1569o.m15483a(2, i), c1569o, i);
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogProcessor", "processDeleteFail");
        }
    }

    /* renamed from: a */
    private void m15529a(C1569o c1569o, String str, String str2, int i, boolean z) {
        C1571q c1571q = new C1571q();
        c1571q.m15470a(0);
        c1571q.m15466b(str);
        c1571q.m15469a(str2);
        c1569o.m15479b(c1571q, i);
    }

    /* renamed from: a */
    private void m15523a(List<C1571q> list, C1569o c1569o, int i) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (C1571q c1571q : list) {
            if (m15518b(c1571q.m15468b())) {
                c1569o.m15480a(c1571q.m15468b(), i);
            } else {
                c1571q.m15470a(2);
                c1569o.m15482a(c1571q, c1571q.m15471a());
            }
        }
    }

    /* renamed from: a */
    private boolean m15535a(Context context, String str, String str2, String str3, C1569o c1569o) {
        boolean z;
        OutputStream outputStream = null;
        C1411ai c1411ai = null;
        AutoCloseable autoCloseable = null;
        try {
            try {
                File file = new File(context.getFilesDir().getAbsolutePath() + C1557g.f5546a + str2);
                if (file.exists() || file.mkdirs()) {
                    c1411ai = C1411ai.m16394a(file, 1, 1, 20480L);
                    c1411ai.m16396a(m15531a(c1569o));
                    C1411ai.C1414b m16392a = c1411ai.m16392a(str);
                    if (m16392a != null) {
                        z = false;
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        if (m16392a != null) {
                            try {
                                m16392a.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        if (c1411ai == null || c1411ai.m16401a()) {
                            return false;
                        }
                        try {
                            c1411ai.close();
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        byte[] bytes = str3.getBytes("UTF-8");
                        C1411ai.C1412a m16388b = c1411ai.m16388b(str);
                        outputStream = m16388b.m16371a(0);
                        outputStream.write(bytes);
                        m16388b.m16372a();
                        c1411ai.m16390b();
                        z = true;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        if (m16392a != null) {
                            try {
                                m16392a.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        if (c1411ai == null || c1411ai.m16401a()) {
                            return true;
                        }
                        try {
                            c1411ai.close();
                            return true;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                } else {
                    z = false;
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            autoCloseable.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    if (0 == 0 || c1411ai.m16401a()) {
                        return false;
                    }
                    try {
                        c1411ai.close();
                        return false;
                    } catch (Throwable th9) {
                        th = th9;
                    }
                }
                th.printStackTrace();
                return z;
            } catch (Throwable th10) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                }
                if (0 != 0) {
                    try {
                        autoCloseable.close();
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                    }
                }
                if (c1411ai != null && !c1411ai.m16401a()) {
                    try {
                        c1411ai.close();
                    } catch (Throwable th13) {
                        th13.printStackTrace();
                    }
                }
                throw th10;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th14) {
                    th14.printStackTrace();
                }
            }
            if (0 != 0) {
                try {
                    autoCloseable.close();
                } catch (Throwable th15) {
                    th15.printStackTrace();
                }
            }
            if (c1411ai != null && !c1411ai.m16401a()) {
                try {
                    c1411ai.close();
                } catch (Throwable th16) {
                    th16.printStackTrace();
                }
            }
            return false;
        }
    }

    /* renamed from: b */
    private C1411ai m15519b(Context context, String str) {
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + C1557g.f5546a + str);
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            return C1411ai.m16394a(file, 1, 1, 20480L);
        } catch (IOException e) {
            C1450b.m16187a(e, "LogProcessor", "initDiskLru");
            return null;
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogProcessor", "initDiskLru");
            return null;
        }
    }

    /* renamed from: b */
    private boolean m15518b(String str) {
        if (this.f5562d == null) {
            return false;
        }
        try {
            return this.f5562d.m16385c(str);
        } catch (IOException e) {
            C1450b.m16187a(e, "LogUpdateProcessor", "deleteLogData");
            return false;
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogUpdateProcessor", "deleteLogData");
            return false;
        }
    }

    /* renamed from: c */
    private int m15514c(String str) {
        byte[] m15554b;
        int i;
        byte[] m16342b;
        String str2;
        JSONObject jSONObject;
        int i2 = 0;
        try {
            m15554b = C1552dw.m15554b(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            m15554b = C1552dw.m15554b(str.getBytes());
        }
        try {
            m16342b = C1422am.m16345a().m16342b(new C1563i(m15554b));
        } catch (C1532dl e2) {
            if (e2.m15672a() != 27) {
                i2 = 1;
            }
            C1450b.m16187a(e2, "LogProcessor", "processUpdate");
        }
        if (m16342b == null) {
            return 0;
        }
        try {
            str2 = new String(m16342b, "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            str2 = new String(m16342b);
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e4) {
            C1450b.m16187a(e4, "LogProcessor", "processUpdate");
            i = 1;
        }
        if (jSONObject.has(XiaomiOAuthConstants.EXTRA_CODE_2)) {
            i = jSONObject.getInt(XiaomiOAuthConstants.EXTRA_CODE_2);
            return i;
        }
        i = i2;
        return i;
    }

    /* renamed from: c */
    private String m15513c(Throwable th) {
        return th.toString();
    }

    /* renamed from: d */
    private String m15512d() {
        return C1552dw.m15562a(new Date().getTime());
    }

    /* renamed from: d */
    private String m15510d(String str) {
        InputStream inputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        String str3;
        String str4 = null;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                if (this.f5562d == null) {
                    if (0 != 0) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e) {
                            C1450b.m16187a(e, "LogProcessor", "readLog1");
                        }
                    }
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                            str2 = "LogProcessor";
                            str3 = "readLog2";
                            C1450b.m16187a(e, str2, str3);
                            return str4;
                        }
                    }
                } else {
                    C1411ai.C1414b m16392a = this.f5562d.m16392a(str);
                    if (m16392a == null) {
                        if (0 != 0) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                C1450b.m16187a(e3, "LogProcessor", "readLog1");
                            }
                        }
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (IOException e4) {
                                e = e4;
                                str2 = "LogProcessor";
                                str3 = "readLog2";
                                C1450b.m16187a(e, str2, str3);
                                return str4;
                            }
                        }
                    } else {
                        inputStream = m16392a.m16366a(0);
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                str4 = byteArrayOutputStream.toString("utf-8");
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e5) {
                                        C1450b.m16187a(e5, "LogProcessor", "readLog1");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                        e = e6;
                                        str2 = "LogProcessor";
                                        str3 = "readLog2";
                                        C1450b.m16187a(e, str2, str3);
                                        return str4;
                                    }
                                }
                            } catch (IOException e7) {
                                e = e7;
                                C1450b.m16187a(e, "LogProcessor", "readLog");
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e8) {
                                        C1450b.m16187a(e8, "LogProcessor", "readLog1");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e9) {
                                        e = e9;
                                        str2 = "LogProcessor";
                                        str3 = "readLog2";
                                        C1450b.m16187a(e, str2, str3);
                                        return str4;
                                    }
                                }
                                return str4;
                            } catch (Throwable th2) {
                                th = th2;
                                C1450b.m16187a(th, "LogProcessor", "readLog");
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e10) {
                                        C1450b.m16187a(e10, "LogProcessor", "readLog1");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e11) {
                                        e = e11;
                                        str2 = "LogProcessor";
                                        str3 = "readLog2";
                                        C1450b.m16187a(e, str2, str3);
                                        return str4;
                                    }
                                }
                                return str4;
                            }
                        } catch (IOException e12) {
                            e = e12;
                            byteArrayOutputStream = null;
                        } catch (Throwable th3) {
                            byteArrayOutputStream2 = null;
                            th = th3;
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (IOException e13) {
                                    C1450b.m16187a(e13, "LogProcessor", "readLog1");
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e14) {
                                    C1450b.m16187a(e14, "LogProcessor", "readLog2");
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e15) {
            e = e15;
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th5) {
            byteArrayOutputStream2 = null;
            inputStream = null;
            th = th5;
        }
        return str4;
    }

    /* renamed from: d */
    private void m15511d(Context context) {
        try {
            this.f5562d = m15519b(context, m15539a());
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogProcessor", "LogUpDateProcessor");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0012 -> B:14:0x0013). Please submit an issue!!! */
    /* renamed from: e */
    private List<C1549dv> m15509e(Context context) {
        List<C1549dv> list;
        Throwable th;
        List<C1549dv> list2 = null;
        try {
        } catch (Throwable th2) {
            list = null;
            th = th2;
        }
        synchronized (Looper.getMainLooper()) {
            try {
                list = new C1572r(context, false).m15463a();
                try {
                    return list;
                } catch (Throwable th3) {
                    list2 = list;
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        list = list2;
                        th = th4;
                        th.printStackTrace();
                        return list;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    /* renamed from: f */
    private String m15508f(Context context) {
        return C1533dm.m15670a(context);
    }

    /* renamed from: g */
    private String m15507g(Context context) {
        try {
            String m15653a = C1535do.m15653a(context);
            if (!"".equals(m15653a)) {
                return C1535do.m15645c(context, m15653a.getBytes("UTF-8"));
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            C1450b.m16187a(e, "LogProcessor", "getPublicInfo");
            return null;
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogProcessor", "getPublicInfo");
            return null;
        }
    }

    /* renamed from: a */
    protected AbstractC1418aj m15531a(C1569o c1569o) {
        try {
            if (this.f5561c == null) {
                this.f5561c = new C1562a(c1569o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f5561c;
    }

    /* renamed from: a */
    protected String m15539a() {
        return C1557g.m15541b(this.f5560b);
    }

    /* renamed from: a */
    protected String mo15528a(String str) {
        return C1545ds.m15594c(str);
    }

    /* renamed from: a */
    protected String m15526a(Throwable th) {
        try {
            return m15517b(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    protected abstract String mo15525a(List<C1549dv> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m15534a(Context context, Throwable th, String str, String str2) {
        String m15526a;
        List<C1549dv> m15509e = m15509e(context);
        if (m15509e == null || m15509e.size() == 0 || (m15526a = m15526a(th)) == null || "".equals(m15526a)) {
            return;
        }
        for (C1549dv c1549dv : m15509e) {
            if (m15522a(c1549dv.m15574f(), m15526a)) {
                m15532a(c1549dv, context, th, m15526a, str, str2);
                return;
            }
        }
        if (!m15526a.contains("com.amap.api.col")) {
            return;
        }
        try {
            m15532a(new C1549dv.C1550a("collection", "1.0", "AMap_collection_1.0").m15569a(new String[]{"com.amap.api.collection"}).m15573a(), context, th, m15526a, str, str2);
        } catch (C1532dl e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15533a(C1549dv c1549dv) {
        this.f5559a = c1549dv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m15532a(C1549dv c1549dv, Context context, Throwable th, String str, String str2, String str3) {
        m15533a(c1549dv);
        String m15512d = m15512d();
        String m15537a = m15537a(context, c1549dv);
        String m15508f = m15508f(context);
        String m15513c = m15513c(th);
        if (m15513c == null || "".equals(m15513c)) {
            return;
        }
        int m15521b = m15521b();
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append("class:").append(str2);
        }
        if (str3 != null) {
            sb.append(" method:").append(str3).append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR).append("<br/>");
        }
        sb.append(str);
        String mo15528a = mo15528a(str);
        String m15527a = m15527a(m15508f, m15537a, m15512d, m15521b, m15513c, sb.toString());
        if (m15527a == null || "".equals(m15527a)) {
            return;
        }
        String m15536a = m15536a(context, m15527a);
        String m15539a = m15539a();
        synchronized (Looper.getMainLooper()) {
            C1569o c1569o = new C1569o(context);
            m15529a(c1569o, c1549dv.m15580a(), mo15528a, m15521b, m15535a(context, mo15528a, m15539a, m15536a, c1569o));
        }
    }

    /* renamed from: a */
    protected abstract boolean mo15538a(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m15522a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String str2 : strArr) {
                if (str.indexOf(str2) != -1) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    protected int m15521b() {
        return this.f5560b;
    }

    /* renamed from: b */
    String m15517b(Throwable th) {
        String m15559a = C1552dw.m15559a(th);
        if (m15559a != null) {
            return m15559a.replaceAll("\n", "<br/>");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15520b(Context context) {
        String mo15525a;
        List<C1549dv> m15509e = m15509e(context);
        if (m15509e == null || m15509e.size() == 0 || (mo15525a = mo15525a(m15509e)) == null || "".equals(mo15525a)) {
            return;
        }
        String m15512d = m15512d();
        String m15537a = m15537a(context, this.f5559a);
        String m15508f = m15508f(context);
        int m15521b = m15521b();
        String m15527a = m15527a(m15508f, m15537a, m15512d, m15521b, "ANR", mo15525a);
        if (m15527a == null || "".equals(m15527a)) {
            return;
        }
        String mo15528a = mo15528a(mo15525a);
        String m15536a = m15536a(context, m15527a);
        String m15539a = m15539a();
        synchronized (Looper.getMainLooper()) {
            C1569o c1569o = new C1569o(context);
            m15529a(c1569o, this.f5559a.m15580a(), mo15528a, m15521b, m15535a(context, mo15528a, m15539a, m15536a, c1569o));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m15516c() {
        try {
            if (this.f5562d == null || this.f5562d.m16401a()) {
                return;
            }
            this.f5562d.close();
        } catch (IOException e) {
            C1450b.m16187a(e, "LogProcessor", "closeDiskLru");
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogProcessor", "closeDiskLru");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m15515c(Context context) {
        try {
            m15511d(context);
            if (!mo15538a(context)) {
                return;
            }
            synchronized (Looper.getMainLooper()) {
                C1569o c1569o = new C1569o(context);
                m15530a(c1569o, m15521b());
                List<C1571q> m15483a = c1569o.m15483a(0, m15521b());
                if (m15483a == null || m15483a.size() == 0) {
                    return;
                }
                String m15524a = m15524a(m15483a, context);
                if (m15524a == null) {
                    return;
                }
                if (m15514c(m15524a) == 1) {
                    m15523a(m15483a, c1569o, m15521b());
                }
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogProcessor", "processUpdateLog");
        }
    }
}
