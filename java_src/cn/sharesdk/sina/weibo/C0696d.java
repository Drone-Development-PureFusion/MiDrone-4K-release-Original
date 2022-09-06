package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.AbstractC0647b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AbstractC0639b;
import cn.sharesdk.framework.authorize.AbstractC0641d;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0640c;
import cn.sharesdk.framework.authorize.C0642e;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.p074a.C0635a;
import cn.sharesdk.framework.utils.C0683d;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.account.openauth.AuthorizeActivityBase;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* renamed from: cn.sharesdk.sina.weibo.d */
/* loaded from: classes.dex */
public class C0696d extends AbstractC0647b {

    /* renamed from: b */
    private static C0696d f1648b;

    /* renamed from: c */
    private String f1649c;

    /* renamed from: d */
    private String f1650d;

    /* renamed from: e */
    private String f1651e;

    /* renamed from: f */
    private String f1652f;

    /* renamed from: g */
    private String[] f1653g = {"follow_app_official_microblog"};

    /* renamed from: h */
    private C0635a f1654h = C0635a.m19742a();

    /* renamed from: i */
    private Context f1655i;

    private C0696d(Platform platform) {
        super(platform);
        this.f1655i = platform.getContext();
    }

    /* renamed from: a */
    public static synchronized C0696d m19455a(Platform platform) {
        C0696d c0696d;
        synchronized (C0696d.class) {
            if (f1648b == null) {
                f1648b = new C0696d(platform);
            }
            c0696d = f1648b;
        }
        return c0696d;
    }

    /* renamed from: a */
    private HashMap<String, Object> m19450a(String str, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        arrayList.add(new KVPair<>("access_token", this.f1652f));
        arrayList.add(new KVPair<>("status", str));
        arrayList.add(new KVPair<>("long", String.valueOf(f)));
        arrayList.add(new KVPair<>("lat", String.valueOf(f2)));
        String m19733b = this.f1654h.m19733b("https://api.weibo.com/2/statuses/update.json", arrayList, "/2/statuses/update.json", c());
        if (m19733b != null) {
            return new Hashon().fromJson(m19733b);
        }
        return null;
    }

    /* renamed from: a */
    private HashMap<String, Object> m19448a(String str, String str2, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        arrayList.add(new KVPair<>("access_token", this.f1652f));
        arrayList.add(new KVPair<>("status", str));
        arrayList.add(new KVPair<>("long", String.valueOf(f)));
        arrayList.add(new KVPair<>("lat", String.valueOf(f2)));
        arrayList.add(new KVPair<>("url", str2));
        String m19733b = this.f1654h.m19733b("https://api.weibo.com/2/statuses/upload_url_text.json", arrayList, "/2/statuses/upload_url_text.json", c());
        if (m19733b != null) {
            return new Hashon().fromJson(m19733b);
        }
        return null;
    }

    /* renamed from: b */
    private HashMap<String, Object> m19440b(String str, String str2, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        arrayList.add(new KVPair<>("access_token", this.f1652f));
        arrayList.add(new KVPair<>("status", str2));
        arrayList.add(new KVPair<>("long", String.valueOf(f)));
        arrayList.add(new KVPair<>("lat", String.valueOf(f2)));
        String m19739a = this.f1654h.m19739a("https://api.weibo.com/2/statuses/upload.json", arrayList, new KVPair<>("pic", str), "/2/statuses/upload.json", c());
        if (m19739a != null) {
            return new Hashon().fromJson(m19739a);
        }
        return null;
    }

    /* renamed from: e */
    private void m19434e(String str) {
        HashMap fromJson = new Hashon().fromJson(str);
        String valueOf = String.valueOf(fromJson.get(C3947a.f16896g));
        String valueOf2 = String.valueOf(fromJson.get("expires_in"));
        String valueOf3 = String.valueOf(fromJson.get("access_token"));
        String valueOf4 = String.valueOf(fromJson.get("refresh_token"));
        String valueOf5 = String.valueOf(fromJson.get("remind_in"));
        this.f1477a.getDb().putUserId(valueOf);
        this.f1477a.getDb().putExpiresIn(Long.valueOf(valueOf2).longValue());
        this.f1477a.getDb().putToken(valueOf3);
        this.f1477a.getDb().put("refresh_token", valueOf4);
        this.f1477a.getDb().put("remind_in", valueOf5);
    }

    /* renamed from: a */
    public String m19457a(Context context, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(Constants.PARAM_CLIENT_ID, this.f1649c));
        arrayList.add(new KVPair<>("client_secret", this.f1650d));
        arrayList.add(new KVPair<>(AuthorizeActivityBase.KEY_REDIRECT_URI, this.f1651e));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        arrayList.add(new KVPair<>(XiaomiOAuthConstants.EXTRA_CODE_2, str));
        String m19733b = this.f1654h.m19733b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", c());
        ShareSDK.logApiEvent("/oauth2/access_token", c());
        return m19733b;
    }

    /* renamed from: a */
    public HashMap<String, Object> m19458a(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(C3947a.f16896g, str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("page", String.valueOf(i2)));
        String m19736a = this.f1654h.m19736a("https://api.weibo.com/2/statuses/user_timeline.json", arrayList, "/2/statuses/user_timeline.json", c());
        if (m19736a != null) {
            return new Hashon().fromJson(m19736a);
        }
        return null;
    }

    /* renamed from: a */
    public HashMap<String, Object> m19447a(String str, String str2, String str3, float f, float f2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return !TextUtils.isEmpty(str3) ? m19440b(str3, str, f, f2) : !TextUtils.isEmpty(str2) ? m19448a(str, str2, f, f2) : m19450a(str, f, f2);
        }
        throw new Throwable("weibo content can not be null!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d1 -> B:29:0x009e). Please submit an issue!!! */
    /* renamed from: a */
    public HashMap<String, Object> m19446a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        KVPair kVPair;
        String str3;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        if (this.f1652f != null) {
            arrayList.add(new KVPair<>("access_token", this.f1652f));
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair kVPair2 = null;
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                kVPair2 = new KVPair(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        try {
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
        if ("GET".equals(str2.toUpperCase())) {
            str3 = new NetworkHelper().httpGet(str, arrayList, null, null);
        } else {
            if ("POST".equals(str2.toUpperCase())) {
                str3 = new NetworkHelper().httpPost(str, arrayList, kVPair, null, null);
            }
            str3 = null;
        }
        if (str3 != null && str3.length() > 0) {
            return new Hashon().fromJson(str3);
        }
        return null;
    }

    /* renamed from: a */
    public void m19456a(final Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) {
        if (shareParams.getImageData() == null && TextUtils.isEmpty(shareParams.getImagePath()) && !TextUtils.isEmpty(shareParams.getImageUrl())) {
            try {
                File file = new File(BitmapHelper.downloadBitmap(this.f1655i, shareParams.getImageUrl()));
                if (file.exists()) {
                    shareParams.setImagePath(file.getAbsolutePath());
                }
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
        }
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            shareParams.setText(getPlatform().getShortLintk(text, false));
        }
        AuthorizeListener authorizeListener = new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.d.2
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (platformActionListener != null) {
                    platformActionListener.onCancel(C0696d.this.f1477a, 9);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                if (platformActionListener != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("ShareParams", shareParams);
                    platformActionListener.onComplete(C0696d.this.f1477a, 9, hashMap);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th2) {
                if (platformActionListener != null) {
                    platformActionListener.onError(C0696d.this.f1477a, 9, th2);
                }
            }
        };
        C0691a c0691a = new C0691a();
        c0691a.m19481a(this.f1649c);
        c0691a.m19484a(shareParams);
        c0691a.m19483a(authorizeListener);
        c0691a.show(this.f1655i, null, true);
    }

    /* renamed from: a */
    public void m19454a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            b(authorizeListener);
        } else {
            a(new SSOListener() { // from class: cn.sharesdk.sina.weibo.d.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onCancel() {
                    authorizeListener.onCancel();
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    try {
                        ResHelper.parseLong(bundle.getString("expires_in"));
                        authorizeListener.onComplete(bundle);
                    } catch (Throwable th) {
                        onFailed(th);
                    }
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    C0683d.m19513a().m5971d(th);
                    C0696d.this.b(authorizeListener);
                }
            });
        }
    }

    /* renamed from: a */
    public void m19451a(String str) {
        this.f1651e = str;
    }

    /* renamed from: a */
    public void m19449a(String str, String str2) {
        this.f1649c = str;
        this.f1650d = str2;
    }

    /* renamed from: a */
    public void m19445a(String[] strArr) {
        this.f1653g = strArr;
    }

    /* renamed from: a */
    public boolean m19459a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(Constants.PARAM_CLIENT_ID, this.f1649c));
        arrayList.add(new KVPair<>("client_secret", this.f1650d));
        arrayList.add(new KVPair<>(AuthorizeActivityBase.KEY_REDIRECT_URI, this.f1651e));
        arrayList.add(new KVPair<>("grant_type", "refresh_token"));
        arrayList.add(new KVPair<>("refresh_token", this.f1477a.getDb().get("refresh_token")));
        try {
            String m19733b = this.f1654h.m19733b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", c());
            if (TextUtils.isEmpty(m19733b) || m19733b.contains(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2) || m19733b.contains("error_code")) {
                return false;
            }
            m19434e(m19733b);
            return true;
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return false;
        }
    }

    /* renamed from: b */
    public HashMap<String, Object> m19443b(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        if (this.f1652f != null) {
            arrayList.add(new KVPair<>("access_token", this.f1652f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(C3947a.f16896g, str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("cursor", String.valueOf(i2)));
        String m19736a = this.f1654h.m19736a("https://api.weibo.com/2/friendships/friends.json", arrayList, "/2/friendships/friends.json", c());
        if (m19736a != null) {
            return new Hashon().fromJson(m19736a);
        }
        return null;
    }

    /* renamed from: b */
    public void m19441b(String str) {
        this.f1652f = str;
    }

    /* renamed from: b */
    public boolean m19444b() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.sina.weibo");
        intent.setType("image/*");
        ResolveInfo resolveActivity = this.f1477a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setPackage("com.sina.weibog3");
            intent2.setType("image/*");
            resolveActivity = this.f1477a.getContext().getPackageManager().resolveActivity(intent2, 0);
        }
        return resolveActivity != null;
    }

    /* renamed from: c */
    public HashMap<String, Object> m19439c(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        if (this.f1652f != null) {
            arrayList.add(new KVPair<>("access_token", this.f1652f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(C3947a.f16896g, str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("page", String.valueOf(i2)));
        String m19736a = this.f1654h.m19736a("https://api.weibo.com/2/friendships/friends/bilateral.json", arrayList, "/2/friendships/friends/bilateral.json", c());
        if (m19736a != null) {
            return new Hashon().fromJson(m19736a);
        }
        return null;
    }

    /* renamed from: c */
    public HashMap<String, Object> m19437c(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        if (this.f1652f != null) {
            arrayList.add(new KVPair<>("access_token", this.f1652f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(C3947a.f16896g, str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        String m19736a = this.f1654h.m19736a("https://api.weibo.com/2/users/show.json", arrayList, "/2/users/show.json", c());
        if (m19736a != null) {
            return new Hashon().fromJson(m19736a);
        }
        return null;
    }

    /* renamed from: d */
    public HashMap<String, Object> m19436d(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        if (this.f1652f != null) {
            arrayList.add(new KVPair<>("access_token", this.f1652f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(C3947a.f16896g, str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("cursor", String.valueOf(i2)));
        String m19736a = this.f1654h.m19736a("https://api.weibo.com/2/friendships/followers.json", arrayList, "/2/friendships/followers.json", c());
        if (m19736a != null) {
            return new Hashon().fromJson(m19736a);
        }
        return null;
    }

    /* renamed from: d */
    public HashMap<String, Object> m19435d(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(SocialConstants.PARAM_SOURCE, this.f1649c));
        arrayList.add(new KVPair<>("access_token", this.f1652f));
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(C3947a.f16896g, str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        String m19733b = this.f1654h.m19733b("https://api.weibo.com/2/friendships/create.json", arrayList, "/2/friendships/create.json", c());
        if (m19733b != null) {
            return new Hashon().fromJson(m19733b);
        }
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(Constants.PARAM_CLIENT_ID, this.f1649c));
        arrayList.add(new KVPair("response_type", XiaomiOAuthConstants.EXTRA_CODE_2));
        arrayList.add(new KVPair(AuthorizeActivityBase.KEY_REDIRECT_URI, this.f1651e));
        if (this.f1653g != null && this.f1653g.length > 0) {
            arrayList.add(new KVPair("scope", TextUtils.join(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP, this.f1653g)));
        }
        arrayList.add(new KVPair("display", "mobile"));
        String str = "https://open.weibo.cn/oauth2/authorize?" + ResHelper.encodeUrl(arrayList);
        ShareSDK.logApiEvent("/oauth2/authorize", c());
        return str;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0639b getAuthorizeWebviewClient(C0642e c0642e) {
        return new C0693b(c0642e);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return TextUtils.isEmpty(this.f1651e) ? "https://api.weibo.com/oauth2/default.html" : this.f1651e;
    }

    @Override // cn.sharesdk.framework.AbstractC0647b, cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0641d getSSOProcessor(C0640c c0640c) {
        ServiceConnectionC0695c serviceConnectionC0695c = new ServiceConnectionC0695c(c0640c);
        serviceConnectionC0695c.a(32973);
        serviceConnectionC0695c.m19463a(this.f1649c, this.f1651e, this.f1653g);
        return serviceConnectionC0695c;
    }
}
