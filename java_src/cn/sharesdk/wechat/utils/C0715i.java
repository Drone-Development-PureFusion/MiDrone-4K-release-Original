package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
/* renamed from: cn.sharesdk.wechat.utils.i */
/* loaded from: classes.dex */
public class C0715i {

    /* renamed from: a */
    private Platform f1711a;

    /* renamed from: b */
    private Platform.ShareParams f1712b;

    /* renamed from: c */
    private PlatformActionListener f1713c;

    /* renamed from: d */
    private AuthorizeListener f1714d;

    /* renamed from: e */
    private C0711g f1715e;

    public C0715i(Platform platform) {
        this.f1711a = platform;
    }

    /* renamed from: a */
    public Platform.ShareParams m19350a() {
        return this.f1712b;
    }

    /* renamed from: a */
    public void m19349a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.f1712b = shareParams;
        this.f1713c = platformActionListener;
    }

    /* renamed from: a */
    public void m19348a(AuthorizeListener authorizeListener) {
        this.f1714d = authorizeListener;
    }

    /* renamed from: a */
    public void m19347a(WechatResp wechatResp) {
        switch (wechatResp.f1685f) {
            case -4:
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(wechatResp.f1685f));
                hashMap.put("errStr", wechatResp.f1686g);
                hashMap.put("transaction", wechatResp.f1687h);
                Throwable th = new Throwable(new Hashon().fromHashMap(hashMap));
                switch (wechatResp.mo19375a()) {
                    case 1:
                        if (this.f1714d == null) {
                            return;
                        }
                        this.f1714d.onError(th);
                        return;
                    default:
                        return;
                }
            case -3:
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errCode", Integer.valueOf(wechatResp.f1685f));
                hashMap2.put("errStr", wechatResp.f1686g);
                hashMap2.put("transaction", wechatResp.f1687h);
                Throwable th2 = new Throwable(new Hashon().fromHashMap(hashMap2));
                switch (wechatResp.mo19375a()) {
                    case 1:
                        if (this.f1714d == null) {
                            return;
                        }
                        this.f1714d.onError(th2);
                        return;
                    case 2:
                        if (this.f1713c == null) {
                            return;
                        }
                        this.f1713c.onError(this.f1711a, 9, th2);
                        return;
                    default:
                        return;
                }
            case -2:
                switch (wechatResp.mo19375a()) {
                    case 1:
                        if (this.f1714d == null) {
                            return;
                        }
                        this.f1714d.onCancel();
                        return;
                    case 2:
                        if (this.f1713c == null) {
                            return;
                        }
                        this.f1713c.onCancel(this.f1711a, 9);
                        return;
                    default:
                        return;
                }
            case -1:
            default:
                HashMap hashMap3 = new HashMap();
                hashMap3.put("req", wechatResp.getClass().getSimpleName());
                hashMap3.put("errCode", Integer.valueOf(wechatResp.f1685f));
                hashMap3.put("errStr", wechatResp.f1686g);
                hashMap3.put("transaction", wechatResp.f1687h);
                new Throwable(new Hashon().fromHashMap(hashMap3)).printStackTrace();
                return;
            case 0:
                switch (wechatResp.mo19375a()) {
                    case 1:
                        if (this.f1714d == null) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        wechatResp.mo19373b(bundle);
                        this.f1715e.m19371a(bundle, this.f1714d);
                        return;
                    case 2:
                        if (this.f1713c == null) {
                            return;
                        }
                        HashMap<String, Object> hashMap4 = new HashMap<>();
                        hashMap4.put("ShareParams", this.f1712b);
                        this.f1713c.onComplete(this.f1711a, 9, hashMap4);
                        return;
                    default:
                        return;
                }
        }
    }

    /* renamed from: a */
    public void m19346a(C0711g c0711g) {
        this.f1715e = c0711g;
    }

    /* renamed from: b */
    public Platform m19345b() {
        return this.f1711a;
    }

    /* renamed from: c */
    public PlatformActionListener m19344c() {
        return this.f1713c;
    }
}
