package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p074a.C0635a;
import cn.sharesdk.framework.utils.C0683d;
import com.amap.api.services.district.DistrictSearchQuery;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.contact.RContact;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.util.ArrayList;
import java.util.HashMap;
/* renamed from: cn.sharesdk.wechat.utils.g */
/* loaded from: classes.dex */
public class C0711g {

    /* renamed from: a */
    private String f1699a;

    /* renamed from: b */
    private String f1700b;

    /* renamed from: c */
    private C0635a f1701c = C0635a.m19742a();

    /* renamed from: d */
    private Platform f1702d;

    /* renamed from: e */
    private int f1703e;

    public C0711g(Platform platform, int i) {
        this.f1702d = platform;
        this.f1703e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19367a(String str) {
        C0683d.m19513a().m5972d("wechat getAuthorizeToken ==>>" + str, new Object[0]);
        HashMap fromJson = new Hashon().fromJson(str);
        String valueOf = String.valueOf(fromJson.get("access_token"));
        String valueOf2 = String.valueOf(fromJson.get("refresh_token"));
        String valueOf3 = String.valueOf(fromJson.get("expires_in"));
        this.f1702d.getDb().put("openid", String.valueOf(fromJson.get("openid")));
        this.f1702d.getDb().putExpiresIn(Long.valueOf(valueOf3).longValue());
        this.f1702d.getDb().putToken(valueOf);
        this.f1702d.getDb().put("refresh_token", valueOf2);
    }

    /* renamed from: a */
    public void m19371a(Bundle bundle, AuthorizeListener authorizeListener) {
        String string = bundle.getString("_wxapi_sendauth_resp_url");
        if (TextUtils.isEmpty(string)) {
            if (authorizeListener == null) {
                return;
            }
            authorizeListener.onError(null);
            return;
        }
        int indexOf = string.indexOf("://oauth?");
        if (indexOf >= 0) {
            string = string.substring(indexOf + 1);
        }
        try {
            m19366a(ResHelper.urlToBundle(string).getString(XiaomiOAuthConstants.EXTRA_CODE_2), authorizeListener);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            if (authorizeListener == null) {
                return;
            }
            authorizeListener.onError(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.wechat.utils.g$2] */
    /* renamed from: a */
    public void m19370a(final PlatformActionListener platformActionListener) {
        new Thread() { // from class: cn.sharesdk.wechat.utils.g.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("access_token", C0711g.this.f1702d.getDb().getToken()));
                    arrayList.add(new KVPair<>("openid", C0711g.this.f1702d.getDb().get("openid")));
                    String m19736a = C0711g.this.f1701c.m19736a("https://api.weixin.qq.com/sns/userinfo", arrayList, "/sns/userinfo", C0711g.this.f1703e);
                    if (TextUtils.isEmpty(m19736a)) {
                        if (platformActionListener == null) {
                            return;
                        }
                        platformActionListener.onError(C0711g.this.f1702d, 8, new Throwable());
                        return;
                    }
                    C0683d.m19513a().m5972d("getUserInfo ==>>" + m19736a, new Object[0]);
                    HashMap<String, Object> fromJson = new Hashon().fromJson(m19736a);
                    if (fromJson.containsKey("errcode") && ((Integer) fromJson.get("errcode")).intValue() != 0) {
                        if (platformActionListener == null) {
                            return;
                        }
                        platformActionListener.onError(C0711g.this.f1702d, 8, new Throwable(new Hashon().fromHashMap(fromJson)));
                        return;
                    }
                    String valueOf = String.valueOf(fromJson.get("openid"));
                    String valueOf2 = String.valueOf(fromJson.get(RContact.COL_NICKNAME));
                    int parseInt = ResHelper.parseInt(String.valueOf(fromJson.get("sex")));
                    String valueOf3 = String.valueOf(fromJson.get(DistrictSearchQuery.KEYWORDS_PROVINCE));
                    String valueOf4 = String.valueOf(fromJson.get(DistrictSearchQuery.KEYWORDS_CITY));
                    String valueOf5 = String.valueOf(fromJson.get(DistrictSearchQuery.KEYWORDS_COUNTRY));
                    String valueOf6 = String.valueOf(fromJson.get("headimgurl"));
                    String valueOf7 = String.valueOf(fromJson.get(GameAppOperation.GAME_UNION_ID));
                    C0711g.this.f1702d.getDb().put(RContact.COL_NICKNAME, valueOf2);
                    if (parseInt == 1) {
                        C0711g.this.f1702d.getDb().put("gender", "0");
                    } else if (parseInt == 2) {
                        C0711g.this.f1702d.getDb().put("gender", "1");
                    } else {
                        C0711g.this.f1702d.getDb().put("gender", "2");
                    }
                    C0711g.this.f1702d.getDb().putUserId(valueOf);
                    C0711g.this.f1702d.getDb().put("icon", valueOf6);
                    C0711g.this.f1702d.getDb().put(DistrictSearchQuery.KEYWORDS_PROVINCE, valueOf3);
                    C0711g.this.f1702d.getDb().put(DistrictSearchQuery.KEYWORDS_CITY, valueOf4);
                    C0711g.this.f1702d.getDb().put(DistrictSearchQuery.KEYWORDS_COUNTRY, valueOf5);
                    C0711g.this.f1702d.getDb().put("openid", valueOf);
                    C0711g.this.f1702d.getDb().put(GameAppOperation.GAME_UNION_ID, valueOf7);
                    platformActionListener.onComplete(C0711g.this.f1702d, 8, fromJson);
                } catch (Throwable th) {
                    C0683d.m19513a().m5971d(th);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [cn.sharesdk.wechat.utils.g$1] */
    /* renamed from: a */
    public void m19366a(final String str, final AuthorizeListener authorizeListener) {
        C0683d.m19513a().m5972d("getAuthorizeToken ==>> " + str, new Object[0]);
        new Thread() { // from class: cn.sharesdk.wechat.utils.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("appid", C0711g.this.f1699a));
                    arrayList.add(new KVPair<>(MMPluginProviderConstants.OAuth.SECRET, C0711g.this.f1700b));
                    arrayList.add(new KVPair<>(XiaomiOAuthConstants.EXTRA_CODE_2, str));
                    arrayList.add(new KVPair<>("grant_type", "authorization_code"));
                    String m19736a = C0711g.this.f1701c.m19736a("https://api.weixin.qq.com/sns/oauth2/access_token", arrayList, "/sns/oauth2/access_token", C0711g.this.f1703e);
                    if (TextUtils.isEmpty(m19736a)) {
                        authorizeListener.onError(new Throwable("Authorize token is empty"));
                    } else if (!m19736a.contains("errcode")) {
                        C0711g.this.m19367a(m19736a);
                        authorizeListener.onComplete(null);
                    } else if (authorizeListener != null) {
                        authorizeListener.onError(new Throwable(m19736a));
                    }
                } catch (Throwable th) {
                    C0683d.m19513a().m5971d(th);
                }
            }
        }.start();
    }

    /* renamed from: a */
    public void m19365a(String str, String str2) {
        this.f1699a = str;
        this.f1700b = str2;
    }

    /* renamed from: a */
    public boolean m19372a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appid", this.f1699a));
        arrayList.add(new KVPair<>("refresh_token", this.f1702d.getDb().get("refresh_token")));
        arrayList.add(new KVPair<>("grant_type", "refresh_token"));
        try {
            String m19736a = this.f1701c.m19736a("https://api.weixin.qq.com/sns/oauth2/refresh_token", arrayList, "/sns/oauth2/refresh_token", this.f1703e);
            if (TextUtils.isEmpty(m19736a) || m19736a.contains("errcode")) {
                return false;
            }
            m19367a(m19736a);
            return true;
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return false;
        }
    }
}
