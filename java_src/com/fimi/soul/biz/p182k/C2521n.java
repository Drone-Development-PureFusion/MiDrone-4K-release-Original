package com.fimi.soul.biz.p182k;

import android.content.Context;
import android.text.TextUtils;
import com.fimi.soul.biz.p183l.AbstractC2539l;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.NetUtil;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* renamed from: com.fimi.soul.biz.k.n */
/* loaded from: classes.dex */
public class C2521n implements AbstractC2539l {

    /* renamed from: a */
    private Context f8721a;

    /* renamed from: b */
    private String f8722b;

    public C2521n(Context context) {
        this.f8721a = context;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2539l
    /* renamed from: a */
    public PlaneMsg mo11771a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("ssid", str + ",pwd=" + str2));
        String m7766a = NetUtil.m7766a(this.f8722b + "action/setWifi", arrayList, this.f8721a, true);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            if (!TextUtils.isEmpty(m7766a) && m7766a.contains("ok")) {
                planeMsg.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    /* renamed from: a */
    public String m11803a() {
        return this.f8722b;
    }

    /* renamed from: a */
    public void m11802a(String str) {
        this.f8722b = str;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2539l
    /* renamed from: b */
    public PlaneMsg mo11770b() {
        String m7766a = NetUtil.m7766a(this.f8722b + "dir.log", new ArrayList(), this.f8721a, true);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            if (!TextUtils.isEmpty(m7766a)) {
                planeMsg.setData(C3658ar.m7591c(m7766a));
                planeMsg.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2539l
    /* renamed from: c */
    public PlaneMsg mo11769c() {
        String m7766a = NetUtil.m7766a(this.f8722b + "action/getDir", new ArrayList(), this.f8721a, true);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            if (!TextUtils.isEmpty(m7766a)) {
                planeMsg.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2539l
    /* renamed from: d */
    public PlaneMsg mo11768d() {
        String m7766a = NetUtil.m7766a(this.f8722b + "action/reboot", new ArrayList(), this.f8721a, true);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            if (!TextUtils.isEmpty(m7766a) && m7766a.contains("ok")) {
                planeMsg.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }
}
