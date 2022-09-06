package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
import com.amap.api.services.core.C1211bk;
import com.tencent.p227mm.sdk.contact.RContact;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.bi */
/* loaded from: classes.dex */
public abstract class AbstractC1209bi {

    /* renamed from: a */
    private C1166ad f4091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AbstractC1209bi m17147a(int i) {
        switch (i) {
            case 0:
                return new C1199bc();
            case 1:
                return new C1202be();
            case 2:
                return new C1195ba();
            default:
                return null;
        }
    }

    /* renamed from: a */
    private String m17145a(Context context, C1166ad c1166ad) {
        return C1261y.m16915a(context, c1166ad);
    }

    /* renamed from: a */
    private String m17144a(Context context, String str) {
        try {
            return C1261y.m16912a(context, str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m17137a(String str, String str2, String str3, int i, String str4, String str5) {
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
    private void m17139a(C1175ak c1175ak, String str, String str2, int i, boolean z) {
        C1177am c1177am = new C1177am();
        c1177am.m17220a(0);
        c1177am.m17216b(str);
        c1177am.m17219a(str2);
        c1175ak.m17229b(c1177am, i);
    }

    /* renamed from: a */
    private boolean m17143a(Context context, String str, String str2, String str3, C1175ak c1175ak) {
        boolean z;
        OutputStream outputStream = null;
        C1211bk c1211bk = null;
        try {
            try {
                File file = new File(context.getFilesDir().getAbsolutePath() + C1204bf.f4079a + str2);
                if (file.exists() || file.mkdirs()) {
                    c1211bk = C1211bk.m17119a(file, 1, 1, 20480L);
                    c1211bk.m17121a(mo17140a(c1175ak));
                    if (c1211bk.m17117a(str) != null) {
                        z = false;
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        if (c1211bk == null || c1211bk.m17126a()) {
                            return false;
                        }
                        try {
                            c1211bk.close();
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        byte[] bytes = str3.getBytes("UTF-8");
                        C1211bk.C1212a m17113b = c1211bk.m17113b(str);
                        outputStream = m17113b.m17096a(0);
                        outputStream.write(bytes);
                        m17113b.m17097a();
                        c1211bk.m17115b();
                        z = true;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (c1211bk == null || c1211bk.m17126a()) {
                            return true;
                        }
                        try {
                            c1211bk.close();
                            return true;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } else {
                    z = false;
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    if (0 == 0 || c1211bk.m17126a()) {
                        return false;
                    }
                    try {
                        c1211bk.close();
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                th.printStackTrace();
                return z;
            } catch (Throwable th7) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                if (c1211bk != null && !c1211bk.m17126a()) {
                    try {
                        c1211bk.close();
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                    }
                }
                throw th7;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            if (c1211bk != null && !c1211bk.m17126a()) {
                try {
                    c1211bk.close();
                } catch (Throwable th11) {
                    th = th11;
                    th.printStackTrace();
                    return false;
                }
            }
            return false;
        } catch (Throwable th12) {
            th12.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th13) {
                    th13.printStackTrace();
                }
            }
            if (c1211bk != null && !c1211bk.m17126a()) {
                try {
                    c1211bk.close();
                } catch (Throwable th14) {
                    th = th14;
                    th.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    /* renamed from: b */
    private String m17131b(Throwable th) {
        return th.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0011 -> B:14:0x0012). Please submit an issue!!! */
    /* renamed from: b */
    private List<C1166ad> m17132b(Context context) {
        List<C1166ad> list;
        Throwable th;
        List<C1166ad> list2 = null;
        try {
        } catch (Throwable th2) {
            list = null;
            th = th2;
        }
        synchronized (Looper.getMainLooper()) {
            try {
                list = new C1178an(context).m17213a();
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

    /* renamed from: c */
    private String m17130c() {
        return C1210bj.m17128a(new Date().getTime());
    }

    /* renamed from: c */
    private String m17129c(Context context) {
        return C1259w.m16921e(context);
    }

    /* renamed from: a */
    protected abstract int mo17148a();

    /* renamed from: a */
    protected abstract AbstractC1218bn mo17140a(C1175ak c1175ak);

    /* renamed from: a */
    protected abstract String mo17138a(String str);

    /* renamed from: a */
    protected String m17136a(Throwable th) {
        try {
            return C1210bj.m17127a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    protected abstract String mo17135a(List<C1166ad> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17146a(Context context) {
        String mo17135a;
        List<C1166ad> m17132b = m17132b(context);
        if (m17132b == null || m17132b.size() == 0 || (mo17135a = mo17135a(m17132b)) == null || "".equals(mo17135a)) {
            return;
        }
        String m17130c = m17130c();
        String m17145a = m17145a(context, this.f4091a);
        String m17129c = m17129c(context);
        int mo17148a = mo17148a();
        String m17137a = m17137a(m17129c, m17145a, m17130c, mo17148a, "ANR", mo17135a);
        if (m17137a == null || "".equals(m17137a)) {
            return;
        }
        String mo17138a = mo17138a(mo17135a);
        String m17144a = m17144a(context, m17137a);
        String mo17133b = mo17133b();
        synchronized (Looper.getMainLooper()) {
            C1175ak c1175ak = new C1175ak(context);
            m17139a(c1175ak, this.f4091a.m17264a(), mo17138a, mo17148a, m17143a(context, mo17138a, mo17133b, m17144a, c1175ak));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17142a(Context context, Throwable th, String str, String str2) {
        String m17136a;
        List<C1166ad> m17132b = m17132b(context);
        if (m17132b == null || m17132b.size() == 0 || (m17136a = m17136a(th)) == null || "".equals(m17136a)) {
            return;
        }
        for (C1166ad c1166ad : m17132b) {
            if (m17134a(c1166ad.m17259f(), m17136a)) {
                m17141a(c1166ad);
                String m17130c = m17130c();
                String m17145a = m17145a(context, c1166ad);
                String m17129c = m17129c(context);
                String m17131b = m17131b(th);
                if (m17131b == null || "".equals(m17131b)) {
                    return;
                }
                int mo17148a = mo17148a();
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:").append(str);
                }
                if (str2 != null) {
                    sb.append(" method:").append(str2).append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR).append("<br/>");
                }
                sb.append(m17136a);
                String mo17138a = mo17138a(m17136a);
                String m17137a = m17137a(m17129c, m17145a, m17130c, mo17148a, m17131b, sb.toString());
                if (m17137a == null || "".equals(m17137a)) {
                    return;
                }
                String m17144a = m17144a(context, m17137a);
                String mo17133b = mo17133b();
                synchronized (Looper.getMainLooper()) {
                    C1175ak c1175ak = new C1175ak(context);
                    m17139a(c1175ak, c1166ad.m17264a(), mo17138a, mo17148a, m17143a(context, mo17138a, mo17133b, m17144a, c1175ak));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m17141a(C1166ad c1166ad) {
        this.f4091a = c1166ad;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m17134a(String[] strArr, String str) {
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
    protected abstract String mo17133b();
}
