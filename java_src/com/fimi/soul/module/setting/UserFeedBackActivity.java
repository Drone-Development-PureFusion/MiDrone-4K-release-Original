package com.fimi.soul.module.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.utils.C2274s;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2597t;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.SuggestBean;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.titlebar.FmTitleBar;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class UserFeedBackActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: e */
    private Button f13696e;

    /* renamed from: f */
    private Button f13697f;

    /* renamed from: g */
    private FmTitleBar f13698g;

    /* renamed from: h */
    private InputMethodManager f13699h;

    /* renamed from: i */
    private CheckBox f13700i;

    /* renamed from: j */
    private CheckBox f13701j;

    /* renamed from: k */
    private CheckBox f13702k;

    /* renamed from: l */
    private CheckBox f13703l;

    /* renamed from: m */
    private TextView f13704m;

    /* renamed from: n */
    private TextView f13705n;

    /* renamed from: o */
    private TextView f13706o;

    /* renamed from: p */
    private TextView f13707p;

    /* renamed from: q */
    private EditText f13708q;

    /* renamed from: r */
    private EditText f13709r;

    /* renamed from: s */
    private TextView f13710s;

    /* renamed from: t */
    private TextView f13711t;

    /* renamed from: u */
    private TextView f13712u;

    /* renamed from: v */
    private TextView f13713v;

    /* renamed from: a */
    private ImageView f13692a = null;

    /* renamed from: b */
    private ImageView f13693b = null;

    /* renamed from: c */
    private Bitmap f13694c = null;

    /* renamed from: d */
    private Bitmap f13695d = null;

    /* renamed from: w */
    private ProgressDialog f13714w = null;

    /* renamed from: x */
    private SuggestBean f13715x = new SuggestBean();

    /* renamed from: y */
    private final String f13716y = "1";

    /* renamed from: z */
    private final String f13717z = "2";

    /* renamed from: A */
    private final String f13688A = "3";

    /* renamed from: B */
    private final String f13689B = "4";

    /* renamed from: C */
    private String f13690C = "1";

    /* renamed from: D */
    private CompoundButton.OnCheckedChangeListener f13691D = new CompoundButton.OnCheckedChangeListener() { // from class: com.fimi.soul.module.setting.UserFeedBackActivity.2
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                switch (compoundButton.getId()) {
                    case C2300R.C2302id.fimi_plane /* 2131493148 */:
                        UserFeedBackActivity.this.f13701j.setChecked(false);
                        UserFeedBackActivity.this.f13702k.setChecked(false);
                        UserFeedBackActivity.this.f13703l.setChecked(false);
                        compoundButton.setTag("1");
                        break;
                    case C2300R.C2302id.fimi_control /* 2131493150 */:
                        UserFeedBackActivity.this.f13700i.setChecked(false);
                        UserFeedBackActivity.this.f13702k.setChecked(false);
                        UserFeedBackActivity.this.f13703l.setChecked(false);
                        compoundButton.setTag("2");
                        break;
                    case C2300R.C2302id.fimi_camera /* 2131493152 */:
                        UserFeedBackActivity.this.f13700i.setChecked(false);
                        UserFeedBackActivity.this.f13701j.setChecked(false);
                        UserFeedBackActivity.this.f13703l.setChecked(false);
                        compoundButton.setTag("3");
                        break;
                    case C2300R.C2302id.fimi_app /* 2131493154 */:
                        UserFeedBackActivity.this.f13700i.setChecked(false);
                        UserFeedBackActivity.this.f13701j.setChecked(false);
                        UserFeedBackActivity.this.f13702k.setChecked(false);
                        compoundButton.setTag("4");
                        break;
                }
                UserFeedBackActivity.this.f13690C = compoundButton.getTag().toString();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8363a(int i, int i2) {
        C2284z.m12696a(this, i, i2);
    }

    /* renamed from: b */
    private void m8359b() {
        this.f13696e = (Button) findViewById(C2300R.C2302id.back_btn);
        this.f13696e.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.UserFeedBackActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserFeedBackActivity.this.finish();
            }
        });
    }

    /* renamed from: c */
    private void m8357c() {
        this.f13710s = (TextView) findViewById(C2300R.C2302id.textView1);
        this.f13711t = (TextView) findViewById(C2300R.C2302id.textView2);
        this.f13712u = (TextView) findViewById(C2300R.C2302id.textView3);
        this.f13713v = (TextView) findViewById(C2300R.C2302id.textView4);
        this.f13700i = (CheckBox) findViewById(C2300R.C2302id.fimi_plane);
        this.f13701j = (CheckBox) findViewById(C2300R.C2302id.fimi_control);
        this.f13702k = (CheckBox) findViewById(C2300R.C2302id.fimi_camera);
        this.f13703l = (CheckBox) findViewById(C2300R.C2302id.fimi_app);
        this.f13700i.setChecked(true);
        this.f13700i.setOnCheckedChangeListener(this.f13691D);
        this.f13701j.setOnCheckedChangeListener(this.f13691D);
        this.f13702k.setOnCheckedChangeListener(this.f13691D);
        this.f13703l.setOnCheckedChangeListener(this.f13691D);
        this.f13704m = (TextView) findViewById(C2300R.C2302id.plane_des);
        this.f13705n = (TextView) findViewById(C2300R.C2302id.control_des);
        this.f13707p = (TextView) findViewById(C2300R.C2302id.app_des);
        this.f13706o = (TextView) findViewById(C2300R.C2302id.camera_des);
        this.f13708q = (EditText) findViewById(C2300R.C2302id.suggestEdit);
        this.f13709r = (EditText) findViewById(C2300R.C2302id.contactEdit);
        this.f13692a = (ImageView) findViewById(C2300R.C2302id.image_add0);
        this.f13693b = (ImageView) findViewById(C2300R.C2302id.image_del);
        this.f13697f = (Button) findViewById(C2300R.C2302id.sendSuggest);
        this.f13693b.setVisibility(4);
        this.f13693b.setOnClickListener(this);
        this.f13692a.setOnClickListener(this);
        this.f13697f.setOnClickListener(this);
    }

    /* renamed from: d */
    private boolean m8355d() {
        if (!this.preferencesUtil.m12787a().contains("isfirstloading")) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("login", true);
            startActivity(intent);
            finish();
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m8364a() {
        Log.v("Method:", "doTrans");
        try {
            if (TextUtils.isEmpty(this.f13708q.getText())) {
                m8363a(C2300R.C2303string.please_fill_feedcontent, 1000);
            } else if (this.f13708q.getText().length() < 5) {
                m8363a(C2300R.C2303string.feedsize, 1000);
            } else if (this.f13708q.getText().length() >= 1000) {
                m8363a(C2300R.C2303string.feed_max_size, 1000);
            } else {
                this.f13715x.setModel(this.f13690C);
                this.f13714w = ProgressDialog.show(this, null, getString(C2300R.C2303string.commit_ing));
                this.f13714w.setCancelable(true);
                C2597t c2597t = new C2597t(this);
                if (this.f13694c != null && !this.f13694c.isRecycled()) {
                    c2597t.m11578a(this.f13694c);
                }
                this.f13715x.setUserID(C2353b.m12507c(this).getUserID());
                this.f13715x.setContact(this.f13709r.getText().toString());
                this.f13715x.setContent(this.f13708q.getText().toString());
                c2597t.m11577a(this.f13715x, new AbstractC2538k() { // from class: com.fimi.soul.module.setting.UserFeedBackActivity.3
                    @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                    /* renamed from: a */
                    public void mo6501a(PlaneMsg planeMsg, File file) {
                        if (planeMsg == null || !planeMsg.isSuccess()) {
                            UserFeedBackActivity.this.m8363a((int) C2300R.C2303string.feed_false, 1000);
                        } else {
                            UserFeedBackActivity.this.m8363a((int) C2300R.C2303string.feed_success, 1000);
                            UserFeedBackActivity.this.finish();
                        }
                        UserFeedBackActivity.this.f13714w.dismiss();
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            return;
        }
        if (this.f13695d != null && !this.f13695d.isRecycled()) {
            this.f13695d.recycle();
            this.f13695d = null;
        }
        getContentResolver();
        try {
            this.f13695d = C2274s.m12829a(this, intent.getData(), getResources().getInteger(C2300R.integer.image_lagar));
        } catch (IOException e) {
            e.getStackTrace();
        }
        if (this.f13695d == null) {
            return;
        }
        if (i == 0) {
            this.f13692a.setImageBitmap(this.f13695d);
            this.f13694c = this.f13695d;
            this.f13693b.setVisibility(0);
        }
        this.f13695d = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.image_add0 /* 2131493159 */:
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                startActivityForResult(intent, 0);
                return;
            case C2300R.C2302id.image_del /* 2131493160 */:
                this.f13692a.setImageBitmap(null);
                this.f13693b.setVisibility(4);
                return;
            case C2300R.C2302id.textView4 /* 2131493161 */:
            case C2300R.C2302id.contactEdit /* 2131493162 */:
            default:
                return;
            case C2300R.C2302id.sendSuggest /* 2131493163 */:
                if (!C3658ar.m7601b(this) || C3658ar.m7587d("192.168.100.1")) {
                    m8363a(C2300R.C2303string.login_result_net, 2000);
                    return;
                } else {
                    m8364a();
                    return;
                }
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_userfeedback);
        m8359b();
        m8357c();
        C3658ar.m7612a(getAssets(), this.f13700i, this.f13701j, this.f13702k, this.f13703l, this.f13704m, this.f13705n, this.f13706o, this.f13707p, this.f13708q, this.f13709r, this.f13697f, this.f13710s, this.f13711t, this.f13712u, this.f13713v);
    }
}
