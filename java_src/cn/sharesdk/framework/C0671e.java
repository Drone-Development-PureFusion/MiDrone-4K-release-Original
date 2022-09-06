package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import cn.sharesdk.framework.p075b.C0648a;
import cn.sharesdk.framework.p075b.C0664d;
import cn.sharesdk.framework.p075b.p077b.C0655a;
import cn.sharesdk.framework.p075b.p077b.C0658d;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: cn.sharesdk.framework.e */
/* loaded from: classes.dex */
public class C0671e {

    /* renamed from: a */
    private Context f1581a;

    /* renamed from: b */
    private String f1582b;

    public C0671e(Context context, String str) {
        this.f1581a = context;
        this.f1582b = str;
    }

    /* renamed from: d */
    private ArrayList<Platform> m19567d() {
        ArrayList<Platform> arrayList = new ArrayList<>();
        for (String str : new String[]{"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.alipay.friends.Alipay", "cn.sharesdk.alipay.moments.AlipayMoments", "cn.sharesdk.dingding.friends.Dingding", "cn.sharesdk.youtube.Youtube", "cn.sharesdk.meipai.Meipai"}) {
            try {
                Constructor<?> constructor = Class.forName(str).getConstructor(Context.class);
                constructor.setAccessible(true);
                arrayList.add((Platform) constructor.newInstance(this.f1581a));
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public String m19578a(int i, String str, HashMap<Integer, HashMap<String, Object>> hashMap) {
        HashMap<String, Object> hashMap2 = hashMap.get(Integer.valueOf(i));
        if (hashMap2 == null) {
            return null;
        }
        Object obj = hashMap2.get(str);
        return obj == null ? null : String.valueOf(obj);
    }

    /* renamed from: a */
    public String m19577a(Bitmap bitmap) {
        return C0648a.m19708a(this.f1581a, this.f1582b).m19707a(bitmap);
    }

    /* renamed from: a */
    public String m19574a(String str) {
        return C0648a.m19708a(this.f1581a, this.f1582b).m19702a(str);
    }

    /* renamed from: a */
    public String m19572a(String str, boolean z, int i, String str2) {
        return C0648a.m19708a(this.f1581a, this.f1582b).m19701a(str, i, z, str2);
    }

    /* renamed from: a */
    public ArrayList<Platform> m19581a() {
        ArrayList<Platform> m19567d = m19567d();
        m19571a(m19567d);
        return m19567d;
    }

    /* renamed from: a */
    public void m19580a(int i, int i2, HashMap<Integer, HashMap<String, Object>> hashMap) {
        hashMap.put(Integer.valueOf(i2), hashMap.get(Integer.valueOf(i)));
    }

    /* renamed from: a */
    public void m19579a(int i, Platform platform) {
        C0658d c0658d = new C0658d();
        switch (i) {
            case 1:
                c0658d.f1517a = "SHARESDK_ENTER_SHAREMENU";
                break;
            case 2:
                c0658d.f1517a = "SHARESDK_CANCEL_SHAREMENU";
                break;
            case 3:
                c0658d.f1517a = "SHARESDK_EDIT_SHARE";
                break;
            case 4:
                c0658d.f1517a = "SHARESDK_FAILED_SHARE";
                break;
            case 5:
                c0658d.f1517a = "SHARESDK_CANCEL_SHARE";
                break;
        }
        if (platform != null) {
            c0658d.f1518b = platform.getPlatformId();
        }
        C0664d m19618a = C0664d.m19618a(this.f1581a, this.f1582b);
        if (m19618a != null) {
            m19618a.m19616a(c0658d);
        }
    }

    /* renamed from: a */
    public void m19576a(Handler handler, boolean z, int i) {
        C0664d m19618a = C0664d.m19618a(this.f1581a, this.f1582b);
        if (m19618a != null) {
            m19618a.m19617a(handler);
            m19618a.m19615a(z);
            m19618a.m19619a(i);
            m19618a.startThread();
        }
    }

    /* renamed from: a */
    public void m19575a(C0673f c0673f) {
    }

    /* renamed from: a */
    public void m19573a(String str, int i) {
        C0664d m19618a = C0664d.m19618a(this.f1581a, this.f1582b);
        if (m19618a == null) {
            return;
        }
        C0655a c0655a = new C0655a();
        c0655a.f1499b = str;
        c0655a.f1498a = i;
        m19618a.m19616a(c0655a);
    }

    /* renamed from: a */
    public void m19571a(ArrayList<Platform> arrayList) {
        if (arrayList == null) {
            return;
        }
        Collections.sort(arrayList, new Comparator<Platform>() { // from class: cn.sharesdk.framework.e.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Platform platform, Platform platform2) {
                return platform.getSortId() != platform2.getSortId() ? platform.getSortId() - platform2.getSortId() : platform.getPlatformId() - platform2.getPlatformId();
            }
        });
    }

    /* renamed from: a */
    public boolean m19570a(HashMap<String, Object> hashMap, HashMap<Integer, HashMap<String, Object>> hashMap2) {
        int i;
        if (hashMap == null || hashMap.size() <= 0) {
            return false;
        }
        ArrayList arrayList = (ArrayList) hashMap.get("fakelist");
        if (arrayList == null) {
            return false;
        }
        EventRecorder.addBegin("ShareSDK", "parseDevInfo");
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HashMap<String, Object> hashMap3 = (HashMap) it2.next();
            if (hashMap3 != null) {
                try {
                    i = ResHelper.parseInt(String.valueOf(hashMap3.get("snsplat")));
                } catch (Throwable th) {
                    C0683d.m19513a().m5959w(th);
                    i = -1;
                }
                if (i != -1) {
                    hashMap2.put(Integer.valueOf(i), hashMap3);
                }
            }
        }
        EventRecorder.addEnd("ShareSDK", "parseDevInfo");
        return true;
    }

    /* renamed from: b */
    public void m19569b() {
        C0664d m19618a = C0664d.m19618a(this.f1581a, this.f1582b);
        if (m19618a != null) {
            m19618a.stopThread();
        }
    }

    /* renamed from: c */
    public String m19568c() {
        return "2.8.1";
    }
}
