package com.baidu.tts.p099g.p101b;

import android.content.Context;
import com.baidu.android.common.util.CommonParam;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.ResourceTools;
import java.lang.ref.WeakReference;
/* renamed from: com.baidu.tts.g.b.a */
/* loaded from: classes.dex */
public class C1718a {

    /* renamed from: a */
    private WeakReference<Context> f6199a;

    /* renamed from: b */
    private String f6200b;

    /* renamed from: c */
    private String f6201c;

    public C1718a(WeakReference<Context> weakReference) {
        this.f6199a = weakReference;
    }

    /* renamed from: c */
    private Context m14870c() {
        if (this.f6199a == null) {
            return null;
        }
        return this.f6199a.get();
    }

    /* renamed from: a */
    public String m14872a() {
        if (this.f6200b == null) {
            this.f6200b = CommonParam.getCUID(m14870c());
        }
        return this.f6200b;
    }

    /* renamed from: b */
    public String m14871b() {
        if (this.f6201c == null) {
            this.f6201c = FileTools.jointPathAndName(ResourceTools.getAppFilesDirPath(m14870c()), "baidu_tts_license");
        }
        return this.f6201c;
    }
}
