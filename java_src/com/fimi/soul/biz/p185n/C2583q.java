package com.fimi.soul.biz.p185n;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.entity.ShareInfo;
import com.fimi.soul.utils.C3658ar;
import com.tencent.p227mm.sdk.openapi.IWXAPI;
import com.tencent.p227mm.sdk.openapi.WXAPIFactory;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.q */
/* loaded from: classes.dex */
public class C2583q {

    /* renamed from: a */
    public static int f8928a = 0;

    /* renamed from: b */
    public static int f8929b = 1;

    /* renamed from: c */
    public static final int f8930c = 1;

    /* renamed from: d */
    public static final int f8931d = 2;

    /* renamed from: e */
    public static final int f8932e = 3;

    /* renamed from: g */
    private Context f8934g;

    /* renamed from: h */
    private IWXAPI f8935h;

    /* renamed from: i */
    private ShareInfo f8936i;

    /* renamed from: j */
    private AbstractC2592b f8937j;

    /* renamed from: k */
    private Handler f8938k = new Handler() { // from class: com.fimi.soul.biz.n.q.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Toast.makeText(C2583q.this.f8934g, (int) C2300R.C2303string.share_success, 1).show();
                    break;
                case 3:
                    Toast.makeText(C2583q.this.f8934g, (int) C2300R.C2303string.share_fail, 1).show();
                    break;
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: f */
    public IUiListener f8933f = new IUiListener() { // from class: com.fimi.soul.biz.n.q.3
        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Toast.makeText(C2583q.this.f8934g, "Complete", 1).show();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Toast.makeText(C2583q.this.f8934g, "Error", 1).show();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.n.q$a */
    /* loaded from: classes.dex */
    public class AlertDialogC2587a extends AlertDialog {

        /* renamed from: a */
        ImageView f8942a;

        /* renamed from: b */
        ImageView f8943b;

        /* renamed from: c */
        ImageView f8944c;

        /* renamed from: d */
        Button f8945d;

        /* renamed from: f */
        private Context f8947f;

        /* renamed from: g */
        private boolean f8948g;

        /* renamed from: h */
        private boolean f8949h;

        public AlertDialogC2587a(Context context, ShareInfo shareInfo) {
            super(context);
            this.f8947f = context;
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(C2300R.layout.dialog_share);
            TextView textView = (TextView) findViewById(C2300R.C2302id.share_tv);
            this.f8942a = (ImageView) findViewById(C2300R.C2302id.wechat_iv);
            this.f8942a.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.biz.n.q.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!AlertDialogC2587a.this.f8948g) {
                        C2284z.m12694a(AlertDialogC2587a.this.f8947f, AlertDialogC2587a.this.f8947f.getString(C2300R.C2303string.no_install_apk), 0);
                        return;
                    }
                    C2583q.this.m11597a(C2583q.this.f8936i, Wechat.NAME);
                    C2583q.this.f8937j.mo9998a(C2583q.f8928a);
                    AlertDialogC2587a.this.dismiss();
                }
            });
            this.f8943b = (ImageView) findViewById(C2300R.C2302id.wechat_friend_iv);
            this.f8943b.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.biz.n.q.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!AlertDialogC2587a.this.f8948g) {
                        C2284z.m12694a(AlertDialogC2587a.this.f8947f, AlertDialogC2587a.this.f8947f.getString(C2300R.C2303string.no_install_apk), 0);
                        return;
                    }
                    C2583q.this.m11597a(C2583q.this.f8936i, WechatMoments.NAME);
                    C2583q.this.f8937j.mo9998a(C2583q.f8929b);
                    AlertDialogC2587a.this.dismiss();
                }
            });
            this.f8944c = (ImageView) findViewById(C2300R.C2302id.sinaweibo_iv);
            this.f8944c.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.biz.n.q.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!AlertDialogC2587a.this.f8949h) {
                        C2284z.m12694a(AlertDialogC2587a.this.f8947f, AlertDialogC2587a.this.f8947f.getString(C2300R.C2303string.no_install_apk), 0);
                        return;
                    }
                    C2583q.this.m11597a(C2583q.this.f8936i, SinaWeibo.NAME);
                    AlertDialogC2587a.this.dismiss();
                }
            });
            this.f8945d = (Button) findViewById(C2300R.C2302id.cancle_btn);
            this.f8945d.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.biz.n.q.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlertDialogC2587a.this.dismiss();
                }
            });
            C3658ar.m7613a(C2238c.m13131a().getResources().getAssets(), (ViewGroup) getWindow().getDecorView());
        }

        @Override // android.app.Dialog
        protected void onStart() {
            super.onStart();
            if (C3658ar.m7588d(this.f8947f, MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN)) {
                this.f8948g = true;
                this.f8942a.setAlpha(1.0f);
                this.f8943b.setAlpha(1.0f);
            } else {
                this.f8948g = false;
                this.f8942a.setAlpha(0.3f);
                this.f8943b.setAlpha(0.3f);
            }
            if (C3658ar.m7588d(this.f8947f, "com.sina.weibo")) {
                this.f8949h = true;
                this.f8944c.setAlpha(1.0f);
                return;
            }
            this.f8949h = false;
            this.f8944c.setAlpha(0.3f);
        }
    }

    /* renamed from: com.fimi.soul.biz.n.q$b */
    /* loaded from: classes.dex */
    public interface AbstractC2592b {
        /* renamed from: a */
        void mo9998a(int i);
    }

    public C2583q(Context context) {
        this.f8934g = context;
        this.f8935h = WXAPIFactory.createWXAPI(context, C2353b.f7961s);
        this.f8935h.registerApp(C2353b.f7961s);
    }

    /* renamed from: a */
    public void m11600a(AbstractC2592b abstractC2592b) {
        this.f8937j = abstractC2592b;
    }

    /* renamed from: a */
    public void m11598a(ShareInfo shareInfo) {
        this.f8936i = shareInfo;
        new AlertDialogC2587a(this.f8934g, null).show();
    }

    /* renamed from: a */
    public void m11597a(ShareInfo shareInfo, String str) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImagePath(shareInfo.getUrl());
        shareParams.setShareType(2);
        Platform platform = ShareSDK.getPlatform(str);
        platform.setPlatformActionListener(new PlatformActionListener() { // from class: com.fimi.soul.biz.n.q.1
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i) {
                C2583q.this.f8938k.sendEmptyMessage(2);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i, HashMap<String, Object> hashMap) {
                C2583q.this.f8938k.sendEmptyMessage(1);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i, Throwable th) {
                C2583q.this.f8938k.sendEmptyMessage(3);
            }
        });
        platform.share(shareParams);
    }
}
