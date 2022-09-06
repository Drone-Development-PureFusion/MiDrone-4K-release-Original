package com.baidu.tts.p093d.p095b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.database.C1691a;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* renamed from: com.baidu.tts.d.b.d */
/* loaded from: classes.dex */
public class C1684d {

    /* renamed from: a */
    private String f5909a;

    /* renamed from: b */
    private String f5910b;

    /* renamed from: c */
    private String f5911c;

    /* renamed from: d */
    private long f5912d = 0;

    /* renamed from: e */
    private C1681a f5913e = C1681a.m15012a();

    /* renamed from: f */
    private CopyOnWriteArraySet<DownloadHandler> f5914f = new CopyOnWriteArraySet<>();

    public C1684d(String str) {
        this.f5909a = str;
    }

    /* renamed from: j */
    private void m14959j() {
        this.f5913e.m15008a(this.f5910b, this.f5909a);
        this.f5913e.m15008a(this.f5911c, this.f5909a);
    }

    /* renamed from: a */
    public void m14977a() {
        this.f5914f.clear();
        m14959j();
    }

    /* renamed from: a */
    public void m14976a(DownloadHandler downloadHandler) {
        if (this.f5914f != null) {
            this.f5914f.add(downloadHandler);
        }
    }

    /* renamed from: a */
    public void m14975a(DownloadHandler downloadHandler, TtsError ttsError) {
        downloadHandler.updateFinish(this, ttsError);
        m14969b(downloadHandler);
    }

    /* renamed from: a */
    public void m14974a(ModelBags modelBags, C1691a c1691a) {
        c1691a.m14921a(modelBags);
        m14971a(c1691a);
    }

    /* renamed from: a */
    public void m14973a(C1682b c1682b) {
        if (this.f5914f != null) {
            Iterator<DownloadHandler> it2 = this.f5914f.iterator();
            while (it2.hasNext()) {
                it2.next().updateProgress(this);
            }
        }
    }

    /* renamed from: a */
    public void m14972a(C1682b c1682b, TtsError ttsError) {
        LoggerProxy.m15091d("ModelFlyweight", "onFileDownloadFailure");
        if (this.f5914f != null) {
            Iterator<DownloadHandler> it2 = this.f5914f.iterator();
            while (it2.hasNext()) {
                m14975a(it2.next(), ttsError);
            }
        }
    }

    /* renamed from: a */
    public boolean m14971a(C1691a c1691a) {
        Map<String, String> m14909e = c1691a.m14909e(this.f5909a);
        if (m14909e == null || m14909e.isEmpty()) {
            return false;
        }
        this.f5910b = DataTool.getMapValue(m14909e, EnumC1704g.TEXT_DATA_ID.m14896b());
        this.f5911c = DataTool.getMapValue(m14909e, EnumC1704g.SPEECH_DATA_ID.m14896b());
        boolean isEmpty = StringTool.isEmpty(this.f5910b);
        boolean isEmpty2 = StringTool.isEmpty(this.f5911c);
        if (!isEmpty && !isEmpty2) {
            return true;
        }
        c1691a.m14919a(this.f5909a);
        return false;
    }

    /* renamed from: b */
    public Set<String> m14970b() {
        HashSet hashSet = new HashSet();
        C1685e m14958a = C1685e.m14958a();
        C1683c m14953b = m14958a.m14953b(this.f5910b);
        C1683c m14953b2 = m14958a.m14953b(this.f5911c);
        String m14982a = m14953b.m14982a();
        String m14982a2 = m14953b2.m14982a();
        hashSet.add(m14982a);
        hashSet.add(m14982a2);
        return hashSet;
    }

    /* renamed from: b */
    public void m14969b(DownloadHandler downloadHandler) {
        boolean isSetEmpty = DataTool.isSetEmpty(this.f5914f);
        LoggerProxy.m15091d("ModelFlyweight", "unregisterListener 1isEmpty=" + isSetEmpty);
        if (!isSetEmpty) {
            this.f5914f.remove(downloadHandler);
            boolean isSetEmpty2 = DataTool.isSetEmpty(this.f5914f);
            LoggerProxy.m15091d("ModelFlyweight", "unregisterListener 2isEmpty=" + isSetEmpty2);
            if (isSetEmpty2) {
                m14959j();
                return;
            }
            Iterator<DownloadHandler> it2 = this.f5914f.iterator();
            while (it2.hasNext()) {
                LoggerProxy.m15091d("ModelFlyweight", "unregisterListener item=" + it2.next());
            }
        }
    }

    /* renamed from: b */
    public void m14968b(C1682b c1682b) {
        boolean m14960i = m14960i();
        LoggerProxy.m15091d("ModelFlyweight", "onFileDownloadSuccess isAllFileDownloadSuccess=" + m14960i);
        if (!m14960i || this.f5914f == null) {
            return;
        }
        Iterator<DownloadHandler> it2 = this.f5914f.iterator();
        while (it2.hasNext()) {
            m14975a(it2.next(), (TtsError) null);
        }
    }

    /* renamed from: c */
    public long m14967c() {
        m14965d();
        return this.f5912d;
    }

    /* renamed from: c */
    public void m14966c(DownloadHandler downloadHandler) {
        m14976a(downloadHandler);
        downloadHandler.updateStart(this);
    }

    /* renamed from: d */
    public void m14965d() {
        if (this.f5912d == 0) {
            m14964e();
        }
    }

    /* renamed from: e */
    public void m14964e() {
        C1685e m14958a = C1685e.m14958a();
        String m14979b = m14958a.m14953b(this.f5910b).m14979b();
        String m14979b2 = m14958a.m14953b(this.f5911c).m14979b();
        Long valueOf = Long.valueOf(Long.parseLong(m14979b));
        Long valueOf2 = Long.valueOf(Long.parseLong(m14979b2));
        this.f5912d = valueOf2.longValue() + valueOf.longValue();
    }

    /* renamed from: f */
    public Set<String> m14963f() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.f5910b);
        hashSet.add(this.f5911c);
        return hashSet;
    }

    /* renamed from: g */
    public String m14962g() {
        return this.f5909a;
    }

    /* renamed from: h */
    public long m14961h() {
        return this.f5913e.m15003d(this.f5910b) + this.f5913e.m15003d(this.f5911c);
    }

    /* renamed from: i */
    public boolean m14960i() {
        return this.f5913e.m15002e(this.f5910b) == 7 && this.f5913e.m15002e(this.f5911c) == 7;
    }
}
