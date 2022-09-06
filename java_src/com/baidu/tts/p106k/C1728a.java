package com.baidu.tts.p106k;

import android.content.Context;
import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C1691a;
import com.baidu.tts.p093d.C1680b;
import com.baidu.tts.p093d.C1688d;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p106k.p107a.C1736h;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* renamed from: com.baidu.tts.k.a */
/* loaded from: classes.dex */
public class C1728a {

    /* renamed from: a */
    private Context f6219a;

    /* renamed from: b */
    private C1691a f6220b;

    /* renamed from: c */
    private C1736h f6221c;

    /* renamed from: d */
    private C1688d f6222d;

    public C1728a(Context context) {
        this.f6219a = context;
        m14815f();
    }

    /* renamed from: f */
    private void m14815f() {
        this.f6220b = new C1691a(this);
        this.f6221c = new C1736h(this);
        this.f6222d = new C1688d();
        this.f6222d.m14937a(this);
        this.f6222d.m14939a();
    }

    /* renamed from: a */
    public BasicHandler<ModelBags> m14827a(Conditions conditions) {
        return this.f6221c.m14803a(conditions);
    }

    /* renamed from: a */
    public BasicHandler<ModelFileBags> m14823a(Set<String> set) {
        return this.f6221c.m14802a(set);
    }

    /* renamed from: a */
    public DownloadHandler m14826a(C1680b c1680b) {
        return this.f6222d.m14938a(c1680b);
    }

    /* renamed from: a */
    public LibEngineParams m14828a() {
        return this.f6221c.m14804a();
    }

    /* renamed from: a */
    public String m14824a(String str, String str2) {
        return this.f6220b.m14917a(str, str2);
    }

    /* renamed from: a */
    public boolean m14825a(String str) {
        Map<String, String> m14910d = this.f6220b.m14910d(str);
        if (DataTool.isMapEmpty(m14910d)) {
            return false;
        }
        String str2 = m14910d.get(EnumC1704g.LENGTH.m14896b());
        String str3 = m14910d.get(EnumC1704g.MD5.m14896b());
        File file = new File(m14910d.get(EnumC1704g.ABS_PATH.m14896b()));
        return file.exists() && file.length() == Long.parseLong(str2) && MD5.getInstance().getBigFileMd5(file).equalsIgnoreCase(str3);
    }

    /* renamed from: b */
    public BasicHandler<ModelBags> m14822b() {
        return this.f6221c.m14801b();
    }

    /* renamed from: b */
    public BasicHandler<ModelBags> m14821b(Conditions conditions) {
        return this.f6221c.m14800b(conditions);
    }

    /* renamed from: b */
    public BasicHandler<ModelFileBags> m14819b(Set<String> set) {
        return this.f6221c.m14799b(set);
    }

    /* renamed from: b */
    public boolean m14820b(String str) {
        Map<String, String> m14909e = this.f6220b.m14909e(str);
        if (DataTool.isMapEmpty(m14909e)) {
            return false;
        }
        return m14825a(m14909e.get(EnumC1704g.TEXT_DATA_ID.m14896b())) && m14825a(m14909e.get(EnumC1704g.SPEECH_DATA_ID.m14896b()));
    }

    /* renamed from: c */
    public void m14818c() {
        this.f6222d.m14935b();
    }

    /* renamed from: d */
    public Context m14817d() {
        return this.f6219a;
    }

    /* renamed from: e */
    public C1691a m14816e() {
        return this.f6220b;
    }
}
