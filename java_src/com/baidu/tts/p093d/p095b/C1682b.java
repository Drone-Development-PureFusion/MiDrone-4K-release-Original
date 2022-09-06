package com.baidu.tts.p093d.p095b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.database.C1691a;
import com.baidu.tts.p093d.p094a.C1675e;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* renamed from: com.baidu.tts.d.b.b */
/* loaded from: classes.dex */
public class C1682b {

    /* renamed from: a */
    private String f5899a;

    /* renamed from: b */
    private long f5900b;

    /* renamed from: c */
    private String f5901c;

    /* renamed from: f */
    private String f5904f;

    /* renamed from: g */
    private C1675e f5905g;

    /* renamed from: d */
    private volatile int f5902d = 0;

    /* renamed from: e */
    private volatile int f5903e = 9;

    /* renamed from: h */
    private CopyOnWriteArraySet<String> f5906h = new CopyOnWriteArraySet<>();

    public C1682b(String str) {
        this.f5899a = str;
    }

    /* renamed from: j */
    private void m14983j() {
        if (this.f5905g != null) {
            LoggerProxy.m15091d("FsFileInfoFlyweight", "unregisterObserver stop");
            this.f5905g.m15022a();
            this.f5905g = null;
            if (this.f5902d != 4 && this.f5902d != 5) {
                return;
            }
            this.f5902d = 8;
            this.f5903e = 8;
            C1681a.m15012a().m15007b().m14918a(this.f5899a, this.f5903e);
        }
    }

    /* renamed from: a */
    public int m14997a(C1683c c1683c) {
        File file = new File(this.f5899a);
        if (file.exists()) {
            this.f5900b = file.length();
            if (this.f5900b == Long.parseLong(c1683c.m14979b())) {
                this.f5901c = MD5.getInstance().getBigFileMd5(file);
                if (c1683c.m14978c().equalsIgnoreCase(this.f5901c)) {
                    this.f5902d = 7;
                } else {
                    this.f5902d = 3;
                }
            } else {
                this.f5902d = 2;
            }
        } else {
            this.f5902d = 1;
        }
        return this.f5902d;
    }

    /* renamed from: a */
    public long m15001a() {
        return this.f5900b;
    }

    /* renamed from: a */
    public void m15000a(long j, long j2) {
        C1681a m15012a = C1681a.m15012a();
        this.f5900b = j;
        if (this.f5906h != null) {
            Iterator<String> it2 = this.f5906h.iterator();
            while (it2.hasNext()) {
                m15012a.m15006b(it2.next()).m14973a(this);
            }
        }
    }

    /* renamed from: a */
    public void m14999a(TtsError ttsError) {
        LoggerProxy.m15091d("FsFileInfoFlyweight", "onDownloadFailure");
        this.f5902d = 8;
        this.f5903e = 8;
        C1681a m15012a = C1681a.m15012a();
        m15012a.m15007b().m14918a(this.f5899a, this.f5903e);
        if (this.f5906h != null) {
            Iterator<String> it2 = this.f5906h.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                m15012a.m15006b(next).m14972a(this, ttsError);
                this.f5906h.remove(next);
            }
        }
    }

    /* renamed from: a */
    public void m14998a(C1675e c1675e) {
        this.f5905g = c1675e;
    }

    /* renamed from: a */
    public void m14995a(String str) {
        if (this.f5906h != null) {
            this.f5906h.add(str);
        }
    }

    /* renamed from: a */
    public boolean m14996a(C1691a c1691a) {
        C1683c m14953b = C1685e.m14958a().m14953b(this.f5904f);
        if (this.f5902d == 0) {
            m14997a(m14953b);
            m14993b(c1691a);
        } else if (this.f5902d == 8 || this.f5902d == 7) {
            m14997a(m14953b);
        }
        if (this.f5902d == 7 && this.f5903e != 7) {
            this.f5903e = 7;
            c1691a.m14918a(this.f5899a, this.f5903e);
        }
        LoggerProxy.m15091d("FsFileInfoFlyweight", "fileId=" + this.f5904f + "--filestate=" + this.f5902d + "--dbstate=" + this.f5903e);
        return (this.f5902d == 4 || this.f5902d == 5 || this.f5902d == 7) ? false : true;
    }

    /* renamed from: b */
    public int m14993b(C1691a c1691a) {
        String mapValue = DataTool.getMapValue(c1691a.m14911c(this.f5899a), EnumC1704g.STATE.m14896b());
        if (StringTool.isEmpty(mapValue)) {
            this.f5903e = 9;
        } else {
            this.f5903e = Integer.parseInt(mapValue);
        }
        return this.f5903e;
    }

    /* renamed from: b */
    public String m14994b() {
        return this.f5899a;
    }

    /* renamed from: b */
    public void m14992b(String str) {
        boolean isSetEmpty = DataTool.isSetEmpty(this.f5906h);
        LoggerProxy.m15091d("FsFileInfoFlyweight", "unregisterObserver 1isEmpty=" + isSetEmpty);
        if (!isSetEmpty) {
            this.f5906h.remove(str);
            boolean isSetEmpty2 = DataTool.isSetEmpty(this.f5906h);
            LoggerProxy.m15091d("FsFileInfoFlyweight", "unregisterObserver 2isEmpty=" + isSetEmpty2);
            if (!isSetEmpty2) {
                return;
            }
            m14983j();
        }
    }

    /* renamed from: c */
    public String m14991c() {
        return this.f5904f;
    }

    /* renamed from: c */
    public void m14990c(String str) {
        this.f5904f = str;
    }

    /* renamed from: d */
    public int m14989d() {
        return this.f5902d;
    }

    /* renamed from: e */
    public boolean m14988e() {
        if (this.f5902d == 7 || this.f5902d == 4 || this.f5902d == 5) {
            return false;
        }
        return this.f5900b >= Long.parseLong(C1685e.m14958a().m14953b(this.f5904f).m14979b());
    }

    /* renamed from: f */
    public boolean m14987f() {
        return new File(this.f5899a).delete();
    }

    /* renamed from: g */
    public void m14986g() {
        LoggerProxy.m15091d("FsFileInfoFlyweight", "queueForDownload fileId=" + this.f5904f + "--filestate=" + this.f5902d);
        this.f5902d = 4;
    }

    /* renamed from: h */
    public void m14985h() {
        this.f5902d = 5;
        this.f5903e = 6;
        C1681a.m15012a().m15007b().m14918a(this.f5899a, this.f5903e);
    }

    /* renamed from: i */
    public void m14984i() {
        LoggerProxy.m15091d("FsFileInfoFlyweight", "onDownloadSuccess");
        this.f5902d = 7;
        this.f5903e = 7;
        C1681a m15012a = C1681a.m15012a();
        m15012a.m15007b().m14918a(this.f5899a, this.f5903e);
        if (this.f5906h != null) {
            Iterator<String> it2 = this.f5906h.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                m15012a.m15006b(next).m14968b(this);
                this.f5906h.remove(next);
            }
        }
    }
}
