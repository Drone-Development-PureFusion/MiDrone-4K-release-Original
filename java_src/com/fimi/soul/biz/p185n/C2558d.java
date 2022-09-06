package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Build;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.AbstractC2228e;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p162e.C2230b;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.NetUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* renamed from: com.fimi.soul.biz.n.d */
/* loaded from: classes.dex */
public class C2558d {

    /* renamed from: a */
    private static C2558d f8800a = null;

    /* renamed from: b */
    private Context f8801b;

    /* renamed from: c */
    private C2230b f8802c;

    public C2558d(Context context) {
        this.f8802c = null;
        this.f8801b = context;
        this.f8802c = (C2230b) C2238c.m13128a(EnumC2222d.Volley);
    }

    /* renamed from: a */
    public static C2558d m11697a(Context context) {
        if (f8800a == null) {
            f8800a = new C2558d(context);
        }
        return f8800a;
    }

    /* renamed from: a */
    public void m11695a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "commitCrashMsg"));
        arrayList.add(new BasicNameValuePair(C3947a.f16907r, C3658ar.m7585e(this.f8801b)));
        arrayList.add(new BasicNameValuePair(C3947a.f16906q, C3658ar.m7589d(this.f8801b)));
        arrayList.add(new BasicNameValuePair("packageName", this.f8801b.getPackageName()));
        arrayList.add(new BasicNameValuePair("crashTime", C3658ar.m7602b(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair("deviceName", C3658ar.m7623a()));
        arrayList.add(new BasicNameValuePair("systemVersion", C3658ar.m7604b()));
        arrayList.add(new BasicNameValuePair("sdkVersion", Build.VERSION.SDK_INT + ""));
        arrayList.add(new BasicNameValuePair("channel", "Android"));
        arrayList.add(new BasicNameValuePair("crashMsg", str));
        NetUtil.m7764a(arrayList, this.f8801b);
        this.f8802c.mo13150a(String.format("%s?%s", C2353b.f7951i, URLEncodedUtils.format(arrayList, "UTF-8")), new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.n.d.1
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str2) {
                if (str2 == null || str2.length() <= 0) {
                    return;
                }
                C2284z.m12697a(C2558d.this.f8801b, (int) C2300R.C2303string.commit_crash_msg);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str2) {
            }
        });
    }
}
