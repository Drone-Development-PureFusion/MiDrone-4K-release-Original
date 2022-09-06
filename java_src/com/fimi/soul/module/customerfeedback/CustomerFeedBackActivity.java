package com.fimi.soul.module.customerfeedback;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fimi.kernel.utils.C2274s;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.biz.p183l.AbstractC2532e;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2562f;
import com.fimi.soul.biz.p185n.C2597t;
import com.fimi.soul.entity.FdsMsg;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.SuggestBean;
import com.fimi.soul.media.player.IMediaPlayer;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class CustomerFeedBackActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, AbstractC3867d {

    /* renamed from: a */
    private Button f11476a;

    /* renamed from: b */
    private TextView f11477b;

    /* renamed from: c */
    private TextView f11478c;

    /* renamed from: d */
    private TextView f11479d;

    /* renamed from: e */
    private TextView f11480e;

    /* renamed from: f */
    private TextView f11481f;

    /* renamed from: g */
    private TextView f11482g;

    /* renamed from: h */
    private TextView f11483h;

    /* renamed from: i */
    private TextView f11484i;

    /* renamed from: j */
    private Button f11485j;

    /* renamed from: k */
    private EditText f11486k;

    /* renamed from: l */
    private EditText f11487l;

    /* renamed from: m */
    private EditText f11488m;

    /* renamed from: n */
    private GridView f11489n;

    /* renamed from: o */
    private LinkedList<Object> f11490o;

    /* renamed from: q */
    private View$OnClickListenerC3087c f11492q;

    /* renamed from: s */
    private ShowDetailPictureGroupFragment f11494s;

    /* renamed from: t */
    private FragmentManager f11495t;

    /* renamed from: u */
    private int f11496u;

    /* renamed from: v */
    private ProgressBar f11497v;

    /* renamed from: z */
    private C2562f f11501z;

    /* renamed from: p */
    private int f11491p = 1001;

    /* renamed from: r */
    private int f11493r = 10;

    /* renamed from: w */
    private final int f11498w = 10;

    /* renamed from: x */
    private final int f11499x = 30000;

    /* renamed from: y */
    private List<String> f11500y = new ArrayList();

    /* renamed from: A */
    private Handler f11475A = new Handler() { // from class: com.fimi.soul.module.customerfeedback.CustomerFeedBackActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (10 == message.what) {
                CustomerFeedBackActivity.this.f11485j.setClickable(true);
                CustomerFeedBackActivity.this.m9750a(CustomerFeedBackActivity.this.f11485j, 255);
                CustomerFeedBackActivity.this.f11497v.setVisibility(8);
            }
        }
    };

    /* renamed from: a */
    private View m9751a(int i) {
        return findViewById(i);
    }

    /* renamed from: a */
    private void m9752a() {
        this.f11495t = getSupportFragmentManager();
        this.f11494s = (ShowDetailPictureGroupFragment) this.f11495t.findFragmentById(C2300R.C2302id.show_detail_pic_fragment);
        if (this.f11494s == null) {
            this.f11494s = new ShowDetailPictureGroupFragment();
            this.f11494s.m9702a(this);
            this.f11495t.beginTransaction().add(C2300R.C2302id.show_detail_pic_fragment, this.f11494s).hide(this.f11494s).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9750a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    /* renamed from: a */
    private boolean m9747a(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    /* renamed from: b */
    private void m9746b() {
        this.f11486k.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.customerfeedback.CustomerFeedBackActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() < CustomerFeedBackActivity.this.f11491p) {
                    CustomerFeedBackActivity.this.f11481f.setText((CustomerFeedBackActivity.this.f11491p - charSequence.length()) + "");
                } else {
                    C2284z.m12696a(CustomerFeedBackActivity.this, (int) C2300R.C2303string.error_suggestcontent_tip, 3000);
                }
            }
        });
    }

    /* renamed from: b */
    private void m9745b(int i) {
        if (i < this.f11490o.size() - 1) {
            Object obj = this.f11490o.get(i);
            if (!(obj instanceof Uri)) {
                return;
            }
            try {
                this.f11501z.m11682a(C2274s.m12829a(getApplicationContext(), (Uri) obj, (int) IMediaPlayer.MEDIA_INFO_BAD_INTERLEAVING), new AbstractC2532e() { // from class: com.fimi.soul.module.customerfeedback.CustomerFeedBackActivity.3
                    @Override // com.fimi.soul.biz.p183l.AbstractC2532e
                    /* renamed from: a */
                    public void mo9725a(long j, long j2, String str) {
                    }

                    @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                    /* renamed from: a */
                    public void mo6501a(PlaneMsg planeMsg, File file) {
                        if (planeMsg.isSuccess()) {
                            CustomerFeedBackActivity.this.f11500y.add(((FdsMsg) planeMsg.getData()).getUrl());
                            CustomerFeedBackActivity.this.m9732h();
                        } else if ((CustomerFeedBackActivity.this.f11490o.size() - 1) - CustomerFeedBackActivity.this.f11496u > 0) {
                            CustomerFeedBackActivity.this.m9732h();
                        } else {
                            C2284z.m12696a(CustomerFeedBackActivity.this.getApplicationContext(), (int) C2300R.C2303string.feedback_error, 3000);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.feedback_error, 3000);
                m9728j();
            }
        }
    }

    /* renamed from: b */
    private boolean m9743b(String str) {
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(str).matches();
    }

    /* renamed from: c */
    private void m9742c() {
        if (this.f11490o == null) {
            this.f11490o = new LinkedList<>();
        } else {
            this.f11490o.clear();
        }
        this.f11490o.add(Integer.valueOf((int) C2300R.C2301drawable.add_images_box));
    }

    /* renamed from: d */
    private void m9740d() {
        this.f11476a = (Button) m9751a(C2300R.C2302id.black_btn);
        this.f11477b = (TextView) m9751a(C2300R.C2302id.tv_settingTitle);
        this.f11477b.setText(C2300R.C2303string.user_feedback);
        this.f11478c = (TextView) m9751a(C2300R.C2302id.judge_faq);
        this.f11478c.setOnClickListener(this);
        this.f11479d = (TextView) m9751a(C2300R.C2302id.customer_service_telephone);
        this.f11480e = (TextView) m9751a(C2300R.C2302id.question_feedback_des);
        this.f11481f = (TextView) m9751a(C2300R.C2302id.limit_number);
        this.f11482g = (TextView) m9751a(C2300R.C2302id.feedback_picture);
        this.f11483h = (TextView) m9751a(C2300R.C2302id.email_des);
        this.f11484i = (TextView) m9751a(C2300R.C2302id.telephone_des);
        this.f11485j = (Button) m9751a(C2300R.C2302id.sendSuggest);
        this.f11486k = (EditText) m9751a(C2300R.C2302id.suggestEdit);
        this.f11486k.setOnTouchListener(this);
        this.f11487l = (EditText) m9751a(C2300R.C2302id.email_content);
        this.f11488m = (EditText) m9751a(C2300R.C2302id.telephone_content);
        this.f11489n = (GridView) m9751a(C2300R.C2302id.add_picture_gridview);
        this.f11489n.setSelector(new ColorDrawable(0));
        this.f11492q = new View$OnClickListenerC3087c(this.f11490o, getApplicationContext());
        this.f11489n.setAdapter((ListAdapter) this.f11492q);
        this.f11489n.setOnItemClickListener(this);
        this.f11497v = (ProgressBar) findViewById(C2300R.C2302id.loading);
    }

    /* renamed from: e */
    private void m9738e() {
        this.f11476a.setOnClickListener(this);
        this.f11485j.setOnClickListener(this);
    }

    /* renamed from: f */
    private void m9736f() {
        C3658ar.m7612a(getAssets(), this.f11478c, this.f11479d, this.f11480e, this.f11482g, this.f11483h, this.f11484i);
        C3658ar.m7598b(getAssets(), this.f11481f);
    }

    /* renamed from: g */
    private void m9734g() {
        if (!TextUtils.isEmpty(this.f11487l.getText()) && !m9747a(this.f11487l.getText().toString())) {
            C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.error_email_content, 3000);
        } else if (!TextUtils.isEmpty(this.f11488m.getText()) && !m9743b(this.f11488m.getText().toString())) {
            C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.error_telephone_content, 3000);
        } else if (TextUtils.isEmpty(this.f11486k.getText())) {
            C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.please_fill_feedcontent, 3000);
        } else if (this.f11486k.getText().length() < 5) {
            C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.feedsize, 3000);
        } else {
            this.f11496u = 0;
            this.f11485j.setClickable(false);
            m9750a(this.f11485j, 127);
            if (this.f11475A.hasMessages(10)) {
                this.f11475A.removeMessages(10);
            }
            this.f11475A.sendEmptyMessageDelayed(10, 30000L);
            this.f11497v.setVisibility(0);
            this.f11500y.clear();
            this.f11501z = new C2562f(getApplicationContext());
            m9745b(this.f11496u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m9732h() {
        this.f11496u++;
        if (this.f11496u < this.f11490o.size() - 1) {
            m9745b(this.f11496u);
        } else {
            m9730i();
        }
    }

    /* renamed from: i */
    private void m9730i() {
        SuggestBean suggestBean = new SuggestBean();
        suggestBean.setContact(this.f11488m.getText().toString());
        suggestBean.setContent(this.f11486k.getText().toString());
        suggestBean.setList(this.f11500y);
        suggestBean.setModel("4");
        suggestBean.setUserID(C2353b.m12507c(getApplicationContext()).getUserID());
        suggestBean.setEmail(this.f11487l.getText().toString());
        new C2597t(getApplicationContext()).m11575b(suggestBean, new AbstractC2538k() { // from class: com.fimi.soul.module.customerfeedback.CustomerFeedBackActivity.4
            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
            /* renamed from: a */
            public void mo6501a(PlaneMsg planeMsg, File file) {
                if (planeMsg == null) {
                    C2284z.m12696a(CustomerFeedBackActivity.this.getApplicationContext(), (int) C2300R.C2303string.feedback_error, 3000);
                } else if (planeMsg.isSuccess()) {
                    C2284z.m12696a(CustomerFeedBackActivity.this.getApplicationContext(), (int) C2300R.C2303string.feed_success, 3000);
                } else {
                    C2284z.m12696a(CustomerFeedBackActivity.this.getApplicationContext(), (int) C2300R.C2303string.feedback_error, 3000);
                }
                CustomerFeedBackActivity.this.m9728j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m9728j() {
        if (this.f11475A.hasMessages(10)) {
            this.f11475A.removeMessages(10);
        }
        this.f11475A.sendEmptyMessage(10);
    }

    /* renamed from: k */
    private void m9727k() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, this.f11493r);
    }

    /* renamed from: l */
    private boolean m9726l() {
        if (this.f11494s == null || !this.f11494s.isVisible()) {
            return false;
        }
        this.f11495t.beginTransaction().hide(this.f11494s).commitAllowingStateLoss();
        return true;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3867d
    /* renamed from: a */
    public void mo6741a(View view, float f, float f2) {
        m9726l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        super.onActivityResult(i, i2, intent);
        Uri data = intent.getData();
        if (data == null || this.f11490o.size() <= 0) {
            return;
        }
        this.f11490o.add(this.f11490o.size() - 1, data);
        if (this.f11492q == null) {
            return;
        }
        this.f11492q.m9691a(this.f11490o);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.sendSuggest /* 2131493163 */:
                if (!C3658ar.m7601b(getApplicationContext())) {
                    C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.no_available_network, 3000);
                    return;
                } else if (!this.drone.mo11217ab().mo10898a() || !C2441a.m12168a().m12165c()) {
                    m9734g();
                    return;
                } else {
                    C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.no_available_network, 3000);
                    return;
                }
            case C2300R.C2302id.judge_faq /* 2131493287 */:
            default:
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                finish();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.customer_feedback_activity);
        m9752a();
        m9742c();
        m9740d();
        m9738e();
        m9736f();
        m9746b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C3083a.m9700a().m9696b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == this.f11490o.size() - 1) {
            m9727k();
        } else if (this.f11494s == null) {
        } else {
            this.f11494s.m9701a(this.f11490o);
            this.f11494s.m9703a(i);
            if (this.f11494s.isVisible()) {
                return;
            }
            this.f11495t.beginTransaction().show(this.f11494s).commitAllowingStateLoss();
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m9726l()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.f11486k) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
        return false;
    }
}
