package com.fimi.soul.module.update;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpgradeResultDetail;
import com.fimi.soul.module.forum.CameraCourseActivity;
import com.fimi.soul.p167b.C2344h;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.TranslationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class UpgradeResultActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    public static final String f14407a = "result_list";

    /* renamed from: b */
    StringBuffer f14408b;

    /* renamed from: c */
    StringBuffer f14409c;

    /* renamed from: d */
    TranslationView f14410d;

    /* renamed from: e */
    TextView f14411e;

    /* renamed from: f */
    C2344h f14412f;

    /* renamed from: g */
    private TextView f14413g;

    /* renamed from: h */
    private TextView f14414h;

    /* renamed from: i */
    private TextView f14415i;

    /* renamed from: j */
    private TextView f14416j;

    /* renamed from: k */
    private Button f14417k;

    /* renamed from: l */
    private Button f14418l;

    /* renamed from: m */
    private Button f14419m;

    /* renamed from: n */
    private ImageView f14420n;

    /* renamed from: o */
    private PercentRelativeLayout f14421o;

    /* renamed from: p */
    private PercentRelativeLayout f14422p;

    /* renamed from: q */
    private PercentRelativeLayout f14423q;

    /* renamed from: r */
    private Button f14424r;

    /* renamed from: s */
    private Button f14425s;

    /* renamed from: t */
    private TextView f14426t;

    /* renamed from: u */
    private TextView f14427u;

    /* renamed from: v */
    private ListView f14428v;

    /* renamed from: w */
    private List<UpgradeResultDetail> f14429w = new ArrayList();

    /* renamed from: x */
    private int f14430x = -1;

    /* renamed from: y */
    private int f14431y;

    /* renamed from: a */
    private String m8030a(StringBuffer stringBuffer, int i) {
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return String.format(getString(i), stringBuffer.toString());
    }

    /* renamed from: d */
    private void m8027d() {
        this.f14420n = (ImageView) findViewById(C2300R.C2302id.img_result);
        this.f14413g = (TextView) findViewById(C2300R.C2302id.tv_result);
        this.f14414h = (TextView) findViewById(C2300R.C2302id.tv_sucess_firmware);
        this.f14415i = (TextView) findViewById(C2300R.C2302id.tv_fail_firmwares);
        this.f14417k = (Button) findViewById(C2300R.C2302id.bt_ensure);
        this.f14417k.setOnClickListener(this);
        this.f14416j = (TextView) findViewById(C2300R.C2302id.warm_prompt);
        this.f14418l = (Button) findViewById(C2300R.C2302id.btn_exit);
        this.f14418l.setOnClickListener(this);
        this.f14419m = (Button) findViewById(C2300R.C2302id.btn_reconnect);
        this.f14419m.setOnClickListener(this);
        this.f14421o = (PercentRelativeLayout) findViewById(C2300R.C2302id.result_rl1);
        this.f14422p = (PercentRelativeLayout) findViewById(C2300R.C2302id.result_rl2);
        this.f14423q = (PercentRelativeLayout) findViewById(C2300R.C2302id.main_rl);
        C3658ar.m7612a(getAssets(), this.f14413g, this.f14414h, this.f14415i, this.f14416j);
    }

    /* renamed from: e */
    private void m8026e() {
        List<FirmwareInfo> list = (List) getIntent().getSerializableExtra(f14407a);
        this.f14408b = new StringBuffer();
        this.f14409c = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (FirmwareInfo firmwareInfo : list) {
                if (firmwareInfo.isUpgradeSuccess().booleanValue()) {
                    this.f14408b.append(firmwareInfo.getSysName() + getString(C2300R.C2303string.upgrade_symbol));
                } else {
                    this.f14409c.append(firmwareInfo.getSysName() + getString(C2300R.C2303string.upgrade_symbol));
                }
            }
        }
        if (this.f14408b.length() > 0 && this.f14409c.length() == 0) {
            this.f14415i.setVisibility(8);
            this.f14416j.setVisibility(8);
            this.f14414h.setText(m8030a(this.f14408b, C2300R.C2303string.upgrade_firmware_success));
        } else if (this.f14408b.length() <= 0 || this.f14409c.length() <= 0) {
            this.f14415i.setTextSize(2, 11.3f);
            this.f14415i.setVisibility(0);
            this.f14414h.setText(m8030a(this.f14409c, C2300R.C2303string.upgrade_firmware_failing));
            this.f14415i.setText(getString(C2300R.C2303string.warm_prompt));
            this.f14416j.setVisibility(4);
        } else {
            this.f14415i.setVisibility(0);
            this.f14414h.setText(m8030a(this.f14408b, C2300R.C2303string.upgrade_firmware_success));
            this.f14415i.setText(m8030a(this.f14409c, C2300R.C2303string.upgrade_firmware_failing));
            this.f14416j.setTextSize(2, 11.3f);
            this.f14416j.setVisibility(0);
            this.f14416j.setText(getString(C2300R.C2303string.warm_prompt));
        }
    }

    /* renamed from: f */
    private void m8025f() {
        List list = (List) getIntent().getSerializableExtra(f14407a);
        this.f14408b = new StringBuffer();
        this.f14409c = new StringBuffer();
        this.f14431y = getResources().getColor(C2300R.color.camera_course_txt);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                FirmwareInfo firmwareInfo = (FirmwareInfo) list.get(i);
                if (firmwareInfo.isUpgradeSuccess().booleanValue()) {
                    UpgradeResultDetail upgradeResultDetail = new UpgradeResultDetail();
                    upgradeResultDetail.setDetail(firmwareInfo.getSysName() + getString(C2300R.C2303string.upgrade_success1));
                    upgradeResultDetail.setImg(C2300R.C2301drawable.icon_upgrade_succeed);
                    this.f14429w.add(upgradeResultDetail);
                    this.f14408b.append(firmwareInfo.getSysName());
                    if (i != list.size() - 1) {
                        this.f14408b.append(getString(C2300R.C2303string.upgrade_symbol));
                    }
                } else {
                    UpgradeResultDetail upgradeResultDetail2 = new UpgradeResultDetail();
                    upgradeResultDetail2.setDetail(firmwareInfo.getSysName() + getString(C2300R.C2303string.upgrade_faile1));
                    upgradeResultDetail2.setImg(C2300R.C2301drawable.icon_upgrade_defeated);
                    this.f14429w.add(upgradeResultDetail2);
                    this.f14409c.append(firmwareInfo.getSysName());
                    if (i != list.size() - 1) {
                        this.f14409c.append(getString(C2300R.C2303string.upgrade_symbol));
                    }
                    if (firmwareInfo.getSysId() == 4) {
                        this.f14430x = 1;
                    } else if (firmwareInfo.getSysId() == 13) {
                        this.f14430x = 2;
                    }
                }
            }
        }
        if (this.f14408b.length() > 0 && this.f14409c.length() == 0) {
            this.f14415i.setVisibility(8);
            this.f14416j.setVisibility(8);
            this.f14418l.setVisibility(8);
            this.f14419m.setVisibility(8);
            this.f14408b.append(getString(C2300R.C2303string.upgrade_success1));
            this.f14414h.setText(this.f14408b.toString());
        } else if (this.f14408b.length() == 0 && this.f14409c.length() > 0) {
            this.f14409c.append(getString(C2300R.C2303string.upgrade_faile1));
            this.f14409c.append(getString(C2300R.C2303string.upgrade_faile_tip2));
            this.f14414h.setText(this.f14409c.toString());
            this.f14420n.setBackgroundResource(C2300R.C2301drawable.update_waining);
            this.f14417k.setVisibility(8);
            this.f14413g.setText(getString(C2300R.C2303string.upgrade_faile));
            if (this.f14430x > 0) {
                this.f14416j.setVisibility(0);
                String string = getString(C2300R.C2303string.camera_faile_tip);
                int length = string.length();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.f14431y);
                if (length - 35 >= 0) {
                    spannableStringBuilder.setSpan(foregroundColorSpan, length - 35, length, 33);
                    this.f14416j.setText(spannableStringBuilder);
                }
                C3658ar.m7612a(getAssets(), this.f14416j);
                this.f14416j.setOnClickListener(this);
            }
        } else if (this.f14408b.length() > 0 && this.f14409c.length() > 0) {
            this.f14421o.setVisibility(8);
            this.f14422p.setVisibility(0);
            this.f14423q.setBackgroundResource(C2300R.C2301drawable.upgradbg2);
            m8029b();
            m8028c();
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((FirmwareInfo) list.get(i2)).getSysId() == 4 || ((FirmwareInfo) list.get(i2)).getSysId() == 13 || C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
                ((C2423d) C2379b.m12410a().m12394d()).a(-1);
            }
        }
    }

    /* renamed from: a */
    public void m8031a() {
        Intent intent = new Intent(this, CameraCourseActivity.class);
        intent.putExtra("type", this.f14430x);
        startActivity(intent);
    }

    /* renamed from: b */
    public void m8029b() {
        this.f14424r = (Button) findViewById(C2300R.C2302id.btn_down_after);
        C3658ar.m7612a(getAssets(), this.f14424r);
        this.f14424r.setOnClickListener(this);
        this.f14425s = (Button) findViewById(C2300R.C2302id.btn_down);
        C3658ar.m7612a(getAssets(), this.f14425s);
        this.f14425s.setOnClickListener(this);
        this.f14410d = (TranslationView) findViewById(C2300R.C2302id.translationview);
        this.f14410d.setVisibility(0);
        this.f14410d.m7244a();
        this.f14411e = (TextView) findViewById(C2300R.C2302id.update_firmware_title);
        C3658ar.m7612a(getAssets(), this.f14411e);
        this.f14427u = (TextView) findViewById(C2300R.C2302id.camerafailed_tv);
        this.f14426t = (TextView) findViewById(C2300R.C2302id.confirm_tv);
        this.f14427u.setOnClickListener(this);
        if (this.f14430x == -1) {
            this.f14427u.setVisibility(8);
            this.f14426t.setVisibility(0);
            C3658ar.m7612a(getAssets(), this.f14426t);
        } else if (this.f14430x > 0) {
            this.f14426t.setVisibility(8);
            this.f14427u.setVisibility(0);
            String charSequence = this.f14427u.getText().toString();
            int length = charSequence.length();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.f14431y);
            if (length - 35 >= 0) {
                spannableStringBuilder.setSpan(foregroundColorSpan, length - 35, length, 33);
                this.f14427u.setText(spannableStringBuilder);
            }
            C3658ar.m7612a(getAssets(), this.f14427u);
        }
        new StringBuilder().append(getString(C2300R.C2303string.update_firmware_title));
        getString(C2300R.C2303string.down_firmwares_detail_ex);
        this.f14428v = (ListView) findViewById(C2300R.C2302id.testListView);
    }

    /* renamed from: c */
    public void m8028c() {
        this.f14412f = new C2344h(this, this.f14429w);
        this.f14428v.setAdapter((ListAdapter) this.f14412f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.btn_down_after /* 2131493108 */:
                finish();
                return;
            case C2300R.C2302id.btn_down /* 2131493109 */:
                finish();
                return;
            case C2300R.C2302id.warm_prompt /* 2131493134 */:
                m8031a();
                return;
            case C2300R.C2302id.bt_ensure /* 2131493135 */:
                finish();
                return;
            case C2300R.C2302id.btn_exit /* 2131493136 */:
                finish();
                return;
            case C2300R.C2302id.btn_reconnect /* 2131493137 */:
                finish();
                return;
            case C2300R.C2302id.camerafailed_tv /* 2131493139 */:
                m8031a();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_upgrade_result);
        m8027d();
        m8025f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DroidPlannerApp.f7891f = false;
        if (this.f14410d != null) {
            this.f14410d.m7236c();
        }
    }
}
