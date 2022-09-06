package com.baidu.tts.p093d;

import com.baidu.tts.client.model.OnDownloadListener;
import com.baidu.tts.tools.StringTool;
/* renamed from: com.baidu.tts.d.b */
/* loaded from: classes.dex */
public class C1680b {

    /* renamed from: a */
    private String f5894a;

    /* renamed from: b */
    private OnDownloadListener f5895b;

    /* renamed from: a */
    public String m15017a() {
        return this.f5894a;
    }

    /* renamed from: a */
    public void m15016a(OnDownloadListener onDownloadListener) {
        this.f5895b = onDownloadListener;
    }

    /* renamed from: a */
    public void m15015a(String str) {
        this.f5894a = str;
    }

    /* renamed from: b */
    public boolean m15014b() {
        return !StringTool.isEmpty(this.f5894a);
    }

    /* renamed from: c */
    public OnDownloadListener m15013c() {
        return this.f5895b;
    }
}
