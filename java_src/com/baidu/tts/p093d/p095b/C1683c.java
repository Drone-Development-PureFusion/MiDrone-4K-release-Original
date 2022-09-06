package com.baidu.tts.p093d.p095b;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C1691a;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.baidu.tts.d.b.c */
/* loaded from: classes.dex */
public class C1683c {

    /* renamed from: a */
    private String f5907a;

    /* renamed from: b */
    private Map<String, String> f5908b = new HashMap();

    public C1683c(String str) {
        this.f5907a = str;
    }

    /* renamed from: a */
    public String m14982a() {
        return DataTool.getMapValue(this.f5908b, EnumC1704g.ABS_PATH.m14896b());
    }

    /* renamed from: a */
    public void m14981a(ModelFileBags modelFileBags, C1691a c1691a) {
        c1691a.m14920a(modelFileBags);
        m14980a(c1691a);
    }

    /* renamed from: a */
    public boolean m14980a(C1691a c1691a) {
        this.f5908b = c1691a.m14910d(this.f5907a);
        if (DataTool.isMapEmpty(this.f5908b)) {
            return false;
        }
        String str = this.f5908b.get(EnumC1704g.ABS_PATH.m14896b());
        if (StringTool.isEmpty(str)) {
            c1691a.m14913b(this.f5907a);
            return false;
        }
        C1685e.m14958a().m14952c(str).m14990c(this.f5907a);
        return true;
    }

    /* renamed from: b */
    public String m14979b() {
        return DataTool.getMapValue(this.f5908b, EnumC1704g.LENGTH.m14896b());
    }

    /* renamed from: c */
    public String m14978c() {
        return DataTool.getMapValue(this.f5908b, EnumC1704g.MD5.m14896b());
    }
}
