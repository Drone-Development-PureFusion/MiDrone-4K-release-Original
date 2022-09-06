package com.fimi.soul.module.forum;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.module.social.SystemBarTintManager;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class CameraCourseActivity extends Activity {

    /* renamed from: b */
    public static final String f12925b = "type";

    /* renamed from: a */
    WebView f12926a;

    /* renamed from: c */
    private ImageView f12927c;

    /* renamed from: d */
    private TextView f12928d;

    /* renamed from: e */
    private Button f12929e;

    /* renamed from: g */
    private String f12931g;

    /* renamed from: h */
    private String f12932h;

    /* renamed from: k */
    private int f12935k;

    /* renamed from: f */
    private String f12930f = "https://api.jr.mi.com/insurance/insurance_asset.html?source=p0&from=local#/index";

    /* renamed from: i */
    private String f12933i = "http://bbs.xiaomi.cn/t-13389839";

    /* renamed from: j */
    private String f12934j = "http://bbs.xiaomi.cn/t-13265510";

    /* renamed from: a */
    public void m8684a() {
        if (!this.f12926a.canGoBack()) {
            finish();
        } else if (this.f12932h.equals(this.f12931g)) {
            finish();
        } else {
            this.f12929e.setVisibility(0);
            this.f12926a.loadUrl(this.f12931g);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(67108864, 67108864);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintResource(C2300R.color.list_press);
        }
        setContentView(C2300R.layout.activity_camera_course);
        this.f12927c = (ImageView) findViewById(C2300R.C2302id.back_btn);
        this.f12929e = (Button) findViewById(C2300R.C2302id.right_bt);
        this.f12928d = (TextView) findViewById(C2300R.C2302id.title);
        this.f12928d.setText(getString(C2300R.C2303string.camera_course));
        C3658ar.m7612a(getAssets(), this.f12928d, this.f12929e);
        this.f12929e.setVisibility(8);
        this.f12927c.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.forum.CameraCourseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraCourseActivity.this.m8684a();
            }
        });
        this.f12929e.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.forum.CameraCourseActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebBackForwardList copyBackForwardList = CameraCourseActivity.this.f12926a.copyBackForwardList();
                CameraCourseActivity.this.f12935k = copyBackForwardList.getCurrentIndex();
                CameraCourseActivity.this.f12929e.setVisibility(8);
                CameraCourseActivity.this.f12926a.loadUrl(CameraCourseActivity.this.f12930f);
            }
        });
        this.f12926a = (WebView) findViewById(C2300R.C2302id.web_view);
        this.f12926a.getSettings().setJavaScriptEnabled(true);
        this.f12926a.getSettings().setDomStorageEnabled(true);
        this.f12926a.getSettings().setAllowFileAccess(true);
        this.f12926a.getSettings().setBuiltInZoomControls(true);
        this.f12926a.getSettings().setDefaultTextEncodingName("UTF-8");
        int intExtra = getIntent().getIntExtra("type", 1);
        String str = null;
        if (intExtra == 1) {
            str = this.f12934j;
        } else if (intExtra == 2) {
            str = this.f12933i;
        }
        setTitle(getString(C2300R.C2303string.camera_course));
        if (str == null) {
            finish();
            return;
        }
        this.f12931g = str;
        this.f12926a.loadUrl(str);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12932h == null) {
                finish();
            } else if (this.f12932h.equals(this.f12931g)) {
                finish();
            } else {
                if (this.f12935k == this.f12926a.copyBackForwardList().getCurrentIndex() - 1) {
                    this.f12929e.setVisibility(8);
                }
                this.f12926a.goBack();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
