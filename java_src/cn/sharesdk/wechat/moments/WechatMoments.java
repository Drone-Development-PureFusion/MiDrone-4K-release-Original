package cn.sharesdk.wechat.moments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p075b.p077b.C0660f;
import cn.sharesdk.framework.utils.C0683d;
import cn.sharesdk.wechat.utils.C0711g;
import cn.sharesdk.wechat.utils.C0715i;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.WechatHelper;
import cn.sharesdk.wechat.utils.WechatTimelineNotSupportedException;
import java.util.HashMap;
/* loaded from: classes.dex */
public class WechatMoments extends Platform {
    public static final String NAME = WechatMoments.class.getSimpleName();

    /* renamed from: a */
    private String f1671a;

    /* renamed from: b */
    private String f1672b;

    /* renamed from: c */
    private boolean f1673c;

    /* loaded from: classes.dex */
    public static class ShareParams extends WechatHelper.ShareParams {
        public ShareParams() {
            this.scene = 1;
        }
    }

    public WechatMoments(Context context) {
        super(context);
    }

    /* renamed from: c */
    private boolean m19410c() {
        if (!TextUtils.isEmpty(getDb().get("refresh_token"))) {
            C0711g c0711g = new C0711g(this, 23);
            c0711g.m19365a(this.f1671a, this.f1672b);
            return c0711g.m19372a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        WechatHelper m19405a = WechatHelper.m19405a();
        m19405a.m19402a(this.context, this.f1671a);
        if (!m19405a.m19379c()) {
            if (this.listener == null) {
                return false;
            }
            this.listener.onError(this, i, new WechatClientNotExistException());
            return false;
        } else if (!m19405a.m19376d()) {
            if (this.listener == null) {
                return false;
            }
            this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
            return false;
        } else if (i == 9 || isAuthValid() || m19410c()) {
            return true;
        } else {
            innerAuthorize(i, obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (TextUtils.isEmpty(this.f1671a) || TextUtils.isEmpty(this.f1672b)) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
            return;
        }
        WechatHelper m19405a = WechatHelper.m19405a();
        m19405a.m19402a(this.context, this.f1671a);
        if (!m19405a.m19379c()) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 1, new WechatClientNotExistException());
        } else if (!m19405a.m19376d()) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
        } else {
            C0711g c0711g = new C0711g(this, 23);
            c0711g.m19365a(this.f1671a, this.f1672b);
            C0715i c0715i = new C0715i(this);
            c0715i.m19346a(c0711g);
            c0715i.m19348a(new AuthorizeListener() { // from class: cn.sharesdk.wechat.moments.WechatMoments.1
                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onCancel() {
                    if (WechatMoments.this.listener != null) {
                        WechatMoments.this.listener.onCancel(WechatMoments.this, 1);
                    }
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onComplete(Bundle bundle) {
                    WechatMoments.this.afterRegister(1, null);
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onError(Throwable th) {
                    if (WechatMoments.this.listener != null) {
                        WechatMoments.this.listener.onError(WechatMoments.this, 1, th);
                    }
                }
            });
            try {
                m19405a.m19392a(c0715i);
            } catch (Throwable th) {
                if (this.listener == null) {
                    return;
                }
                this.listener.onError(this, 1, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        if (this.listener != null) {
            this.listener.onCancel(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        shareParams.set("scene", 1);
        WechatHelper m19405a = WechatHelper.m19405a();
        m19405a.m19402a(this.context, this.f1671a);
        C0715i c0715i = new C0715i(this);
        if (this.f1673c) {
            try {
                m19405a.m19391a(c0715i, shareParams, this.listener);
                return;
            } catch (Throwable th) {
                if (this.listener == null) {
                    return;
                }
                this.listener.onError(this, 9, th);
                return;
            }
        }
        c0715i.m19349a(shareParams, this.listener);
        try {
            m19405a.m19380b(c0715i);
            if (this.listener == null || !m19405a.m19388b()) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("ShareParams", shareParams);
            if (this.listener == null) {
                return;
            }
            this.listener.onComplete(this, 9, hashMap);
        } catch (Throwable th2) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 9, th2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0660f.C0661a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0660f.C0661a c0661a = new C0660f.C0661a();
        String text = shareParams.getText();
        c0661a.f1532b = text;
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        Bitmap imageData = shareParams.getImageData();
        if (!TextUtils.isEmpty(imageUrl)) {
            c0661a.f1534d.add(imageUrl);
        } else if (imagePath != null) {
            c0661a.f1535e.add(imagePath);
        } else if (imageData != null) {
            c0661a.f1536f.add(imageData);
        }
        String url = shareParams.getUrl();
        if (url != null) {
            c0661a.f1533c.add(url);
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("title", shareParams.getTitle());
        hashMap2.put("url", url);
        hashMap2.put("extInfo", null);
        hashMap2.put("content", text);
        hashMap2.put("image", c0661a.f1534d);
        hashMap2.put("musicFileUrl", url);
        c0661a.f1537g = hashMap2;
        return c0661a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 6);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowers(int i, int i2, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i, int i2, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 23;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return !this.f1673c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f1671a = getDevinfo("AppId");
        this.f1672b = getDevinfo("AppSecret");
        this.f1673c = "true".equals(getDevinfo("BypassApproval"));
        if (this.f1671a == null || this.f1671a.length() <= 0) {
            this.f1671a = getDevinfo("Wechat", "AppId");
            this.f1673c = "true".equals(getDevinfo("Wechat", "BypassApproval"));
            if (this.f1671a != null && this.f1671a.length() > 0) {
                copyDevinfo("Wechat", NAME);
                this.f1671a = getDevinfo("AppId");
                this.f1673c = "true".equals(getDevinfo("BypassApproval"));
                C0683d.m19513a().m5972d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            this.f1671a = getDevinfo("WechatFavorite", "AppId");
            if (this.f1671a == null || this.f1671a.length() <= 0) {
                return;
            }
            copyDevinfo("WechatFavorite", NAME);
            this.f1671a = getDevinfo("AppId");
            C0683d.m19513a().m5972d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        WechatHelper m19405a = WechatHelper.m19405a();
        m19405a.m19402a(this.context, this.f1671a);
        return m19405a.m19379c() && m19405a.m19376d();
    }

    @Override // cn.sharesdk.framework.Platform
    @Deprecated
    public boolean isValid() {
        WechatHelper m19405a = WechatHelper.m19405a();
        m19405a.m19402a(this.context, this.f1671a);
        return m19405a.m19379c() && m19405a.m19376d() && super.isValid();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f1671a = getNetworkDevinfo("app_id", "AppId");
        this.f1672b = getNetworkDevinfo("app_secret", "AppSecret");
        if (this.f1671a == null || this.f1671a.length() <= 0) {
            this.f1671a = getNetworkDevinfo(22, "app_id", "AppId");
            if (this.f1671a == null || this.f1671a.length() <= 0) {
                this.f1671a = getNetworkDevinfo(37, "app_id", "AppId");
                if (this.f1671a != null && this.f1671a.length() > 0) {
                    copyNetworkDevinfo(23, 23);
                    this.f1671a = getNetworkDevinfo("app_id", "AppId");
                    C0683d.m19513a().m5972d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            } else {
                copyNetworkDevinfo(22, 23);
                this.f1671a = getNetworkDevinfo("app_id", "AppId");
                C0683d.m19513a().m5972d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
        if (this.f1672b == null || this.f1672b.length() <= 0) {
            this.f1672b = getNetworkDevinfo(22, "app_secret", "AppSecret");
            if (this.f1672b != null && this.f1672b.length() > 0) {
                copyNetworkDevinfo(22, 23);
                this.f1672b = getNetworkDevinfo("app_secret", "AppSecret");
                C0683d.m19513a().m5972d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            this.f1672b = getNetworkDevinfo(37, "app_secret", "AppSecret");
            if (this.f1672b == null || this.f1672b.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(23, 23);
            this.f1672b = getNetworkDevinfo("app_secret", "AppSecret");
            C0683d.m19513a().m5972d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        if (TextUtils.isEmpty(this.f1671a) || TextUtils.isEmpty(this.f1672b)) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
            return;
        }
        C0711g c0711g = new C0711g(this, 23);
        c0711g.m19365a(this.f1671a, this.f1672b);
        try {
            c0711g.m19370a(this.listener);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 8, th);
        }
    }
}
