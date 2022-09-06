package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.amap.api.mapcore.util.C0996fh;
import com.amap.api.mapcore.util.C1046gt;
import com.tencent.p227mm.sdk.contact.RContact;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.fs */
/* loaded from: classes.dex */
public abstract class AbstractC1013fs {

    /* renamed from: a */
    private C0996fh f3188a;

    /* renamed from: b */
    private int f3189b;

    /* renamed from: c */
    private AbstractC1053gu f3190c;

    /* renamed from: d */
    private C1046gt f3191d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.fs$a */
    /* loaded from: classes.dex */
    public class C1014a implements AbstractC1053gu {

        /* renamed from: b */
        private C1025gc f3193b;

        C1014a(C1025gc c1025gc) {
            this.f3193b = c1025gc;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1053gu
        /* renamed from: a */
        public void mo17777a(String str) {
            try {
                this.f3193b.m17942b(str, C1003fm.m18027a(AbstractC1013fs.this.m17987b()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1013fs(int i) {
        this.f3189b = i;
    }

    /* renamed from: a */
    public static String m18004a(Context context, C0996fh c0996fh) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sim\":\"").append(C0989fc.m18125e(context)).append("\",\"sdkversion\":\"").append(c0996fh.m18068c()).append("\",\"product\":\"").append(c0996fh.m18074a()).append("\",\"ed\":\"").append(c0996fh.m18066e()).append("\",\"nt\":\"").append(C0989fc.m18127c(context)).append("\",\"np\":\"").append(C0989fc.m18134a(context)).append("\",\"mnc\":\"").append(C0989fc.m18128b(context)).append("\",\"ant\":\"").append(C0989fc.m18126d(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m18003a(Context context, String str) {
        try {
            return C0986fb.m18136e(context, C0999fi.m18047a(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m17993a(String str, String str2, String str3, int i, String str4, String str5) {
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
    private String m17990a(List<? extends AbstractC1026gd> list, Context context) {
        boolean z;
        AbstractC1026gd next;
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"").append(m17972g(context)).append("\",\"els\":[");
        boolean z2 = true;
        Iterator<? extends AbstractC1026gd> it2 = list.iterator();
        while (true) {
            z = z2;
            if (!it2.hasNext()) {
                break;
            }
            String m17975d = m17975d(it2.next().m17937b());
            if (m17975d != null && !"".equals(m17975d)) {
                String str = m17975d + "||" + next.m17934c();
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
    private void m17996a(C1025gc c1025gc, int i) {
        try {
            m17989a(c1025gc.m17946a(2, C1003fm.m18027a(i)), c1025gc, i);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogProcessor", "processDeleteFail");
        }
    }

    /* renamed from: a */
    private void m17995a(C1025gc c1025gc, String str, String str2, int i, boolean z) {
        AbstractC1026gd m18022b = C1003fm.m18022b(i);
        m18022b.m17939a(0);
        m18022b.m17935b(str);
        m18022b.m17938a(str2);
        c1025gc.m17945a(m18022b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m17989a(List<? extends AbstractC1026gd> list, C1025gc c1025gc, int i) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AbstractC1026gd abstractC1026gd : list) {
            if (m17984b(abstractC1026gd.m17937b())) {
                c1025gc.m17944a(abstractC1026gd.m17937b(), (Class<? extends AbstractC1026gd>) abstractC1026gd.getClass());
            } else {
                abstractC1026gd.m17939a(2);
                c1025gc.m17943b(abstractC1026gd);
            }
        }
    }

    /* renamed from: a */
    private boolean m18002a(Context context, String str, String str2, String str3, C1025gc c1025gc) {
        boolean z;
        OutputStream outputStream = null;
        C1046gt c1046gt = null;
        AutoCloseable autoCloseable = null;
        try {
            try {
                File file = new File(C1003fm.m18024a(context, str2));
                if (file.exists() || file.mkdirs()) {
                    c1046gt = C1046gt.m17821a(file, 1, 1, 20480L);
                    c1046gt.m17823a(m17997a(c1025gc));
                    C1046gt.C1051b m17819a = c1046gt.m17819a(str);
                    if (m17819a != null) {
                        z = false;
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        if (m17819a != null) {
                            try {
                                m17819a.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        if (c1046gt == null || c1046gt.m17828a()) {
                            return false;
                        }
                        try {
                            c1046gt.close();
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        byte[] m18047a = C0999fi.m18047a(str3);
                        C1046gt.C1049a m17815b = c1046gt.m17815b(str);
                        outputStream = m17815b.m17797a(0);
                        outputStream.write(m18047a);
                        m17815b.m17798a();
                        c1046gt.m17817b();
                        z = true;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        if (m17819a != null) {
                            try {
                                m17819a.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        if (c1046gt == null || c1046gt.m17828a()) {
                            return true;
                        }
                        try {
                            c1046gt.close();
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
                    if (0 == 0 || c1046gt.m17828a()) {
                        return false;
                    }
                    try {
                        c1046gt.close();
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
                if (c1046gt != null && !c1046gt.m17828a()) {
                    try {
                        c1046gt.close();
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
            if (c1046gt != null && !c1046gt.m17828a()) {
                try {
                    c1046gt.close();
                } catch (Throwable th16) {
                    th16.printStackTrace();
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m17988a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String str2 : str.split("\n")) {
                if (m17982b(strArr, str2.trim())) {
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
    private C1046gt m17985b(Context context, String str) {
        try {
            File file = new File(C1003fm.m18024a(context, str));
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            return C1046gt.m17821a(file, 1, 1, 20480L);
        } catch (IOException e) {
            C1002fl.m18028a(e, "LogProcessor", "initDiskLru");
            return null;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogProcessor", "initDiskLru");
            return null;
        }
    }

    /* renamed from: b */
    public static String m17983b(Throwable th) {
        return C0999fi.m18046a(th);
    }

    /* renamed from: b */
    private boolean m17984b(String str) {
        if (this.f3191d == null) {
            return false;
        }
        try {
            return this.f3191d.m17812c(str);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogUpdateProcessor", "deleteLogData");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m17982b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String str2 : strArr) {
                str = str.trim();
                if (str.startsWith("at ") && str.contains(str2 + ".") && str.endsWith(")")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private int m17979c(String str) {
        int i = 0;
        try {
            byte[] mo17705b = C1057gx.m17771a().mo17705b(new C1006fn(C0999fi.m18039c(C0999fi.m18047a(str))));
            if (mo17705b != null) {
                try {
                    JSONObject jSONObject = new JSONObject(C0999fi.m18043a(mo17705b));
                    if (jSONObject.has(XiaomiOAuthConstants.EXTRA_CODE_2)) {
                        i = jSONObject.getInt(XiaomiOAuthConstants.EXTRA_CODE_2);
                    }
                } catch (JSONException e) {
                    C1002fl.m18028a(e, "LogProcessor", "processUpdate");
                    i = 1;
                }
            }
        } catch (C0975ex e2) {
            if (e2.m18173b() != 27) {
                i = 1;
            }
            C1002fl.m18028a(e2, "LogProcessor", "processUpdate");
        }
        return i;
    }

    /* renamed from: c */
    private String m17978c(Throwable th) {
        return th.toString();
    }

    /* renamed from: d */
    private String m17977d() {
        return C0999fi.m18052a(new Date().getTime());
    }

    /* renamed from: d */
    public static String m17976d(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"").append(C0976ey.m18166f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(C0989fc.m18113q(context)).append("\",\"pkg\":\"").append(C0976ey.m18169c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appname\":\"").append(C0976ey.m18170b(context)).append("\",\"appversion\":\"").append(C0976ey.m18168d(context)).append("\",\"sysversion\":\"").append(Build.VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            C1002fl.m18028a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: d */
    private java.lang.String m17975d(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.AbstractC1013fs.m17975d(java.lang.String):java.lang.String");
    }

    /* renamed from: e */
    private void m17974e(Context context) {
        try {
            this.f3191d = m17985b(context, m18006a());
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogProcessor", "LogUpDateProcessor");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0012 -> B:14:0x0013). Please submit an issue!!! */
    /* renamed from: f */
    private List<C0996fh> m17973f(Context context) {
        List<C0996fh> list;
        Throwable th;
        List<C0996fh> list2 = null;
        try {
        } catch (Throwable th2) {
            list = null;
            th = th2;
        }
        synchronized (Looper.getMainLooper()) {
            try {
                list = new C1027ge(context, false).m17931a();
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

    /* renamed from: g */
    private String m17972g(Context context) {
        try {
            String m17976d = m17976d(context);
            if (!"".equals(m17976d)) {
                return C0986fb.m18139b(context, C0999fi.m18047a(m17976d));
            }
            return null;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogProcessor", "getPublicInfo");
            return null;
        }
    }

    /* renamed from: a */
    protected AbstractC1053gu m17997a(C1025gc c1025gc) {
        try {
            if (this.f3190c == null) {
                this.f3190c = new C1014a(c1025gc);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f3190c;
    }

    /* renamed from: a */
    protected String m18006a() {
        return C1003fm.m18020c(this.f3189b);
    }

    /* renamed from: a */
    protected String mo17994a(String str) {
        return C0992fe.m18090c(str);
    }

    /* renamed from: a */
    protected String m17992a(Throwable th) {
        try {
            return m17983b(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    protected abstract String mo17991a(List<C0996fh> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m18001a(Context context, Throwable th, String str, String str2) {
        String m17992a;
        List<C0996fh> m17973f = m17973f(context);
        if (m17973f == null || m17973f.size() == 0 || (m17992a = m17992a(th)) == null || "".equals(m17992a)) {
            return;
        }
        for (C0996fh c0996fh : m17973f) {
            if (m17988a(c0996fh.m18065f(), m17992a)) {
                m17998a(c0996fh, context, th, m17992a.replaceAll("\n", "<br/>"), str, str2);
                return;
            }
        }
        if (!m17992a.contains("com.amap.api.col")) {
            return;
        }
        try {
            m17998a(new C0996fh.C0998a("collection", "1.0", "AMap_collection_1.0").m18060a(new String[]{"com.amap.api.collection"}).m18063a(), context, th, m17992a, str, str2);
        } catch (C0975ex e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m18000a(C0996fh c0996fh) {
        this.f3188a = c0996fh;
    }

    /* renamed from: a */
    void m17999a(C0996fh c0996fh, Context context, String str, String str2, String str3, String str4) {
        m18000a(c0996fh);
        String m17977d = m17977d();
        String m18004a = m18004a(context, c0996fh);
        String m18172a = C0976ey.m18172a(context);
        if (str == null || "".equals(str)) {
            return;
        }
        int m17987b = m17987b();
        StringBuilder sb = new StringBuilder();
        if (str3 != null) {
            sb.append("class:").append(str3);
        }
        if (str4 != null) {
            sb.append(" method:").append(str4).append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR).append("<br/>");
        }
        sb.append(str2);
        String mo17994a = mo17994a(str2);
        String m17993a = m17993a(m18172a, m18004a, m17977d, m17987b, str, sb.toString());
        if (m17993a == null || "".equals(m17993a)) {
            return;
        }
        String m18003a = m18003a(context, m17993a);
        String m18006a = m18006a();
        synchronized (Looper.getMainLooper()) {
            C1025gc c1025gc = new C1025gc(context);
            m17995a(c1025gc, c0996fh.m18074a(), mo17994a, m17987b, m18002a(context, mo17994a, m18006a, m18003a, c1025gc));
        }
    }

    /* renamed from: a */
    void m17998a(C0996fh c0996fh, Context context, Throwable th, String str, String str2, String str3) {
        m17999a(c0996fh, context, m17978c(th), str, str2, str3);
    }

    /* renamed from: a */
    protected abstract boolean mo18005a(Context context);

    /* renamed from: b */
    protected int m17987b() {
        return this.f3189b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m17986b(Context context) {
        String mo17991a;
        List<C0996fh> m17973f = m17973f(context);
        if (m17973f == null || m17973f.size() == 0 || (mo17991a = mo17991a(m17973f)) == null || "".equals(mo17991a)) {
            return;
        }
        String m17977d = m17977d();
        String m18004a = m18004a(context, this.f3188a);
        String m18172a = C0976ey.m18172a(context);
        int m17987b = m17987b();
        String m17993a = m17993a(m18172a, m18004a, m17977d, m17987b, "ANR", mo17991a);
        if (m17993a == null || "".equals(m17993a)) {
            return;
        }
        String mo17994a = mo17994a(mo17991a);
        String m18003a = m18003a(context, m17993a);
        String m18006a = m18006a();
        synchronized (Looper.getMainLooper()) {
            C1025gc c1025gc = new C1025gc(context);
            m17995a(c1025gc, this.f3188a.m18074a(), mo17994a, m17987b, m18002a(context, mo17994a, m18006a, m18003a, c1025gc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m17981c() {
        try {
            if (this.f3191d == null || this.f3191d.m17828a()) {
                return;
            }
            this.f3191d.close();
        } catch (IOException e) {
            C1002fl.m18028a(e, "LogProcessor", "closeDiskLru");
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogProcessor", "closeDiskLru");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m17980c(Context context) {
        try {
            m17974e(context);
            if (!mo18005a(context)) {
                return;
            }
            synchronized (Looper.getMainLooper()) {
                C1025gc c1025gc = new C1025gc(context);
                m17996a(c1025gc, m17987b());
                List<? extends AbstractC1026gd> m17946a = c1025gc.m17946a(0, C1003fm.m18027a(m17987b()));
                if (m17946a == null || m17946a.size() == 0) {
                    return;
                }
                String m17990a = m17990a(m17946a, context);
                if (m17990a == null) {
                    return;
                }
                if (m17979c(m17990a) == 1) {
                    m17989a(m17946a, c1025gc, m17987b());
                }
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogProcessor", "processUpdateLog");
        }
    }
}
