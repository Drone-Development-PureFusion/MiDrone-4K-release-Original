package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.ResizeLayout;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
/* renamed from: cn.sharesdk.framework.authorize.e */
/* loaded from: classes.dex */
public class C0642e extends C0638a implements Handler.Callback, ResizeLayout.OnResizeListener {

    /* renamed from: b */
    protected AuthorizeListener f1469b;

    /* renamed from: c */
    private AuthorizeAdapter f1470c;

    /* renamed from: d */
    private RegisterView f1471d;

    /* renamed from: e */
    private WebView f1472e;

    /* renamed from: cn.sharesdk.framework.authorize.e$a  reason: invalid class name */
    /* loaded from: classes.dex */
    private static class animationInterpolatorC0646a implements Interpolator {

        /* renamed from: a */
        private float[] f1476a;

        private animationInterpolatorC0646a() {
            this.f1476a = new float[]{0.0f, 0.02692683f, 0.053847015f, 0.080753915f, 0.10764089f, 0.13450131f, 0.16132854f, 0.18811597f, 0.21485697f, 0.24154496f, 0.26817337f, 0.2947356f, 0.3212251f, 0.34763536f, 0.37395984f, 0.40019205f, 0.42632553f, 0.4523538f, 0.47827047f, 0.50406915f, 0.52974343f, 0.555287f, 0.5806936f, 0.60595685f, 0.6310707f, 0.65602875f, 0.68082494f, 0.70545316f, 0.72990733f, 0.75418144f, 0.7782694f, 0.8021654f, 0.8258634f, 0.8493577f, 0.8726424f, 0.89571184f, 0.9185602f, 0.94118196f, 0.9635715f, 0.9857233f, 1.0076319f, 1.0292919f, 1.0506978f, 1.0718446f, 1.0927268f, 1.1133395f, 1.1336775f, 1.1537358f, 1.1735094f, 1.1929934f, 1.1893399f, 1.1728106f, 1.1565471f, 1.1405534f, 1.1248333f, 1.1093911f, 1.0942302f, 1.0793544f, 1.0647675f, 1.050473f, 1.0364745f, 1.0227754f, 1.0093791f, 0.99628896f, 0.9835081f, 0.9710398f, 0.958887f, 0.9470527f, 0.93553996f, 0.9243516f, 0.91349024f, 0.90295863f, 0.90482706f, 0.9114033f, 0.91775465f, 0.9238795f, 0.9297765f, 0.93544406f, 0.9408808f, 0.94608533f, 0.95105654f, 0.955793f, 0.9602937f, 0.9645574f, 0.96858317f, 0.9723699f, 0.97591674f, 0.97922283f, 0.9822872f, 0.9851093f, 0.98768836f, 0.9900237f, 0.9921147f, 0.993961f, 0.99556196f, 0.9969173f, 0.9980267f, 0.99888986f, 0.99950653f, 0.9998766f, 1.0f};
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = 100;
            int i2 = (int) (100.0f * f);
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 <= 100) {
                i = i2;
            }
            return this.f1476a[i];
        }
    }

    /* renamed from: c */
    private AuthorizeAdapter m19713c() {
        try {
            ActivityInfo activityInfo = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128);
            if (activityInfo.metaData == null || activityInfo.metaData.isEmpty()) {
                return null;
            }
            String string = activityInfo.metaData.getString("AuthorizeAdapter");
            if ((string == null || string.length() <= 0) && ((string = activityInfo.metaData.getString("Adapter")) == null || string.length() <= 0)) {
                return null;
            }
            Object newInstance = Class.forName(string).newInstance();
            if (newInstance instanceof AuthorizeAdapter) {
                return (AuthorizeAdapter) newInstance;
            }
            return null;
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.authorize.ResizeLayout.OnResizeListener
    public void OnResize(int i, int i2, int i3, int i4) {
        if (this.f1470c != null) {
            this.f1470c.onResize(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public void m19717a(AuthorizeListener authorizeListener) {
        this.f1469b = authorizeListener;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [cn.sharesdk.framework.authorize.e$2] */
    /* renamed from: b */
    protected RegisterView m19715b() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m19731a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.authorize.e.1
            /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.authorize.e$1$1] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.framework.authorize.e.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            C0683d.m19513a().m5959w(th);
                            AuthorizeListener authorizeListener = C0642e.this.f1460a.getAuthorizeListener();
                            if (authorizeListener != null) {
                                authorizeListener.onCancel();
                            }
                            C0642e.this.finish();
                        }
                    }
                }.start();
            }
        });
        this.f1472e = registerView.m19727b();
        WebSettings settings = this.f1472e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        this.f1472e.setVerticalScrollBarEnabled(false);
        this.f1472e.setHorizontalScrollBarEnabled(false);
        this.f1472e.setWebViewClient(this.f1460a.getAuthorizeWebviewClient(this));
        new Thread() { // from class: cn.sharesdk.framework.authorize.e.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Message message = new Message();
                    message.what = 2;
                    if ("none".equals(DeviceHelper.getInstance(C0642e.this.activity).getDetailNetworkTypeForStatic())) {
                        message.arg1 = 1;
                        UIHandler.sendMessage(message, C0642e.this);
                        return;
                    }
                    if (ShareSDK.isRemoveCookieOnAuthorize()) {
                        CookieSyncManager.createInstance(C0642e.this.activity);
                        CookieManager.getInstance().removeAllCookie();
                    }
                    message.obj = C0642e.this.f1460a.getAuthorizeUrl();
                    UIHandler.sendMessage(message, C0642e.this);
                } catch (Throwable th) {
                    C0683d.m19513a().m5959w(th);
                }
            }
        }.start();
        return registerView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2:
                if (message.arg1 == 1) {
                    AuthorizeListener authorizeListener = this.f1460a.getAuthorizeListener();
                    if (authorizeListener == null) {
                        return false;
                    }
                    authorizeListener.onError(new Throwable("Network error (platform: " + this.f1460a.getPlatform().getName() + ")"));
                    return false;
                }
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(str)) {
                    this.f1472e.loadUrl(str);
                    return false;
                }
                finish();
                AuthorizeListener authorizeListener2 = this.f1460a.getAuthorizeListener();
                if (authorizeListener2 == null) {
                    return false;
                }
                authorizeListener2.onError(new Throwable("Authorize URL is empty (platform: " + this.f1460a.getPlatform().getName() + ")"));
                return false;
            default:
                return false;
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        if (this.f1471d == null) {
            this.f1471d = m19715b();
            this.f1471d.a(this);
            this.f1471d.m19728a(this.f1470c.isNotitle());
            this.f1470c.setBodyView(this.f1471d.m19724d());
            this.f1470c.setWebView(this.f1471d.m19727b());
            TitleLayout m19725c = this.f1471d.m19725c();
            this.f1470c.setTitleView(m19725c);
            String name = this.f1460a.getPlatform().getName();
            this.f1470c.setPlatformName(this.f1460a.getPlatform().getName());
            try {
                m19725c.getTvTitle().setText(ResHelper.getStringRes(getContext(), "ssdk_" + name.toLowerCase()));
            } catch (Throwable th) {
                try {
                    m19725c.getTvTitle().setText(ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter"));
                } catch (Throwable th2) {
                    C0683d.m19513a().m5959w(th);
                }
            }
        }
        this.f1470c.onCreate();
        if (this.f1470c != null && !this.f1470c.isPopUpAnimationDisable()) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(550L);
            scaleAnimation.setInterpolator(new animationInterpolatorC0646a());
            this.f1471d.setAnimation(scaleAnimation);
        }
        disableScreenCapture();
        this.activity.setContentView(this.f1471d);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (this.f1470c != null) {
            this.f1470c.onDestroy();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.f1470c != null) {
            return this.f1470c.onFinish();
        }
        if (this.f1472e != null) {
            this.f1472e.destroy();
            this.f1472e.removeAllViews();
        }
        if (this.activity != null) {
            ((ViewGroup) this.activity.getWindow().getDecorView()).removeAllViews();
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        AuthorizeListener authorizeListener;
        boolean z = false;
        if (this.f1470c != null) {
            z = this.f1470c.onKeyEvent(i, keyEvent);
        }
        if (!z && i == 4 && keyEvent.getAction() == 0 && (authorizeListener = this.f1460a.getAuthorizeListener()) != null) {
            authorizeListener.onCancel();
        }
        if (z) {
            return true;
        }
        return super.onKeyEvent(i, keyEvent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        if (this.f1470c != null) {
            this.f1470c.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        if (this.f1470c != null) {
            this.f1470c.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        if (this.f1470c != null) {
            this.f1470c.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        if (this.f1470c != null) {
            this.f1470c.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        if (this.f1470c != null) {
            this.f1470c.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f1470c == null) {
            this.f1470c = m19713c();
            if (this.f1470c == null) {
                this.f1470c = new AuthorizeAdapter();
            }
        }
        this.f1470c.setActivity(activity);
    }
}
