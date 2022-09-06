package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class RegisterView extends ResizeLayout {

    /* renamed from: a */
    private TitleLayout f1452a;

    /* renamed from: b */
    private RelativeLayout f1453b;

    /* renamed from: c */
    private WebView f1454c;

    /* renamed from: d */
    private TextView f1455d;

    public RegisterView(Context context) {
        super(context);
        m19730a(context);
    }

    public RegisterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19730a(context);
    }

    /* renamed from: a */
    private void m19730a(Context context) {
        setBackgroundColor(-1);
        setOrientation(1);
        final int m19726b = m19726b(context);
        this.f1452a = new TitleLayout(context);
        try {
            int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_auth_title_back");
            if (bitmapRes > 0) {
                this.f1452a.setBackgroundResource(bitmapRes);
            }
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
        this.f1452a.getBtnRight().setVisibility(8);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
        if (stringRes > 0) {
            this.f1452a.getTvTitle().setText(stringRes);
        }
        addView(this.f1452a);
        ImageView imageView = new ImageView(context);
        int bitmapRes2 = ResHelper.getBitmapRes(context, "ssdk_logo");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(0, 0, ResHelper.dipToPx(context, 10), 0);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.authorize.RegisterView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    int stringRes2 = ResHelper.getStringRes(view.getContext(), "ssdk_website");
                    String str = null;
                    if (stringRes2 > 0) {
                        str = view.getResources().getString(stringRes2);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Throwable th2) {
                    C0683d.m19513a().m5971d(th2);
                }
            }
        });
        this.f1452a.addView(imageView);
        this.f1453b = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.f1453b.setLayoutParams(layoutParams);
        addView(this.f1453b);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f1453b.addView(linearLayout);
        this.f1455d = new TextView(context);
        this.f1455d.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
        this.f1455d.setBackgroundColor(-12929302);
        linearLayout.addView(this.f1455d);
        this.f1455d.setVisibility(8);
        this.f1454c = new WebView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.f1454c.setLayoutParams(layoutParams2);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.sharesdk.framework.authorize.RegisterView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) RegisterView.this.f1455d.getLayoutParams();
                layoutParams3.width = (m19726b * i) / 100;
                RegisterView.this.f1455d.setLayoutParams(layoutParams3);
                if (i <= 0 || i >= 100) {
                    RegisterView.this.f1455d.setVisibility(8);
                } else {
                    RegisterView.this.f1455d.setVisibility(0);
                }
            }
        };
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
            try {
                Method method = this.f1454c.getClass().getMethod("removeJavascriptInterface", String.class);
                method.setAccessible(true);
                method.invoke(this.f1454c, "searchBoxJavaBridge_");
            } catch (Throwable th2) {
                C0683d.m19513a().m5971d(th2);
            }
        }
        this.f1454c.setWebChromeClient(webChromeClient);
        linearLayout.addView(this.f1454c);
        this.f1454c.requestFocus();
    }

    /* renamed from: b */
    private int m19726b(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if ((context instanceof Activity) && (windowManager = ((Activity) context).getWindowManager()) != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    /* renamed from: a */
    public View m19731a() {
        return this.f1452a.getBtnBack();
    }

    /* renamed from: a */
    public void m19728a(boolean z) {
        this.f1452a.setVisibility(z ? 8 : 0);
    }

    /* renamed from: b */
    public WebView m19727b() {
        return this.f1454c;
    }

    /* renamed from: c */
    public TitleLayout m19725c() {
        return this.f1452a;
    }

    /* renamed from: d */
    public RelativeLayout m19724d() {
        return this.f1453b;
    }
}
