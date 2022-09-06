package com.fimi.soul.module.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.FragmentActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2729br;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2911f;
import com.fimi.soul.module.droneFragment.ShowDroneStatusFragment;
import java.util.ArrayList;
import org.p318d.AbstractC5756f;
/* loaded from: classes.dex */
public class RightRollerSetActivity extends FragmentActivity implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    C3499g f13658a;

    /* renamed from: b */
    C2657a f13659b;

    /* renamed from: c */
    ListView f13660c;

    /* renamed from: d */
    Button f13661d;

    /* renamed from: e */
    Intent f13662e;

    /* renamed from: f */
    boolean f13663f = true;

    /* renamed from: g */
    String f13664g = "";

    /* renamed from: h */
    int f13665h = -1;

    /* renamed from: j */
    private C2423d f13667j = (C2423d) C2379b.m12410a().m12394d();

    /* renamed from: i */
    boolean f13666i = false;

    /* renamed from: com.fimi.soul.module.setting.RightRollerSetActivity$a */
    /* loaded from: classes.dex */
    public enum EnumC3470a {
        ev,
        light,
        ATTI_GPS
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8368b(EnumC3470a enumC3470a) {
        if (enumC3470a != EnumC3470a.ATTI_GPS) {
            C2729br c2729br = new C2729br();
            c2729br.f9966d = C2760r.f10172a;
            c2729br.f9967e = (byte) 1;
            if (enumC3470a == EnumC3470a.ev) {
                c2729br.f9968f = (byte) 1;
                this.f13662e.putExtra("content", getString(C2300R.C2303string.ev_control));
            } else if (enumC3470a == EnumC3470a.light) {
                c2729br.f9968f = (byte) 2;
                this.f13662e.putExtra("content", getString(C2300R.C2303string.light_control));
            }
            this.f13659b.mo11217ab().mo10897a(c2729br.mo11073b());
            m8371a(enumC3470a);
            this.f13666i = true;
        }
        setResult(-1, this.f13662e);
    }

    /* renamed from: a */
    public void m8372a() {
        if (this.f13667j.e()) {
            this.f13667j.m12233u().m12298a("ae_bias", ShowDroneStatusFragment.f11701b > 0.0f ? AbstractC5756f.f23063b + ShowDroneStatusFragment.f11701b + " EV" : ShowDroneStatusFragment.f11701b < 0.0f ? ShowDroneStatusFragment.f11701b + " EV" : " 0.0 EV");
        }
    }

    /* renamed from: a */
    public void m8371a(EnumC3470a enumC3470a) {
        int i = 0;
        C2911f m11294g = this.f13659b.m11294g();
        if (enumC3470a != EnumC3470a.ev && enumC3470a == EnumC3470a.light) {
            i = 1;
        }
        this.f13659b.mo11217ab().mo10897a(m11294g.m10313b(i, m11294g));
    }

    /* renamed from: b */
    public void m8369b() {
        this.f13659b.mo11217ab().mo10897a(new C2911f().m10307f());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.black_btn /* 2131493817 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.right_roller_layout);
        this.f13661d = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f13661d.setOnClickListener(this);
        this.f13660c = (ListView) findViewById(C2300R.C2302id.right_listview);
        getWindow().addFlags(128);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (!c2657a.mo11217ab().mo10898a() || !c2657a.mo11216ac()) {
            return;
        }
        switch (enumC2679a) {
            case backControl:
                C2908c mo11229R = c2657a.mo11229R();
                if (mo11229R == null || mo11229R.m10343b() != 115 || !this.f13666i) {
                    return;
                }
                if (mo11229R.m10342c() == 2) {
                    switch (mo11229R.f10926d) {
                        case 1:
                            this.f13658a.m8236a(1);
                            this.f13665h = 1;
                            m8372a();
                            break;
                        case 2:
                            this.f13658a.m8236a(0);
                            this.f13665h = 0;
                            break;
                    }
                    C2284z.m12695a(this, getString(C2300R.C2303string.set_success));
                } else if (mo11229R.m10342c() == 4 || mo11229R.m10342c() == 6) {
                    C2284z.m12695a(this, getString(C2300R.C2303string.setting_false));
                    this.f13665h = -1;
                }
                this.f13666i = false;
                return;
            case BRIGHTNESS:
                Log.i("istep", " 飞机发过来的灯光值 " + ((int) c2657a.m11294g().m10312c()));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13662e = getIntent();
        if (!this.f13659b.mo11217ab().mo10898a() || !this.f13659b.mo11216ac()) {
            this.f13660c.setClickable(false);
            this.f13658a.m8235a(true);
            return;
        }
        this.f13663f = this.f13662e.getBooleanExtra("GPS_ATTI", false);
        this.f13664g = this.f13662e.getStringExtra("curModel") != null ? this.f13662e.getStringExtra("curModel") : "";
        if (this.f13658a != null && this.f13663f) {
            this.f13658a.m8234b(true);
            this.f13658a.m8236a(2);
            this.f13660c.setClickable(false);
        } else if (this.f13663f || this.f13658a == null) {
        } else {
            this.f13660c.setClickable(true);
            this.f13658a.m8234b(false);
            if (this.f13664g.equals(getString(C2300R.C2303string.ev_control))) {
                this.f13658a.m8236a(1);
            } else if (!this.f13664g.equals(getString(C2300R.C2303string.light_control))) {
            } else {
                this.f13658a.m8236a(0);
            }
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f13659b = ((DroidPlannerApp) getApplication()).f7895a;
        this.f13659b.mo11219a(this);
        String[] stringArray = getResources().getStringArray(C2300R.array.right_set);
        ArrayList arrayList = new ArrayList();
        if (stringArray != null && stringArray.length > 0) {
            for (String str : stringArray) {
                C3508h c3508h = new C3508h();
                c3508h.m8194a(false);
                c3508h.m8195a(str);
                arrayList.add(c3508h);
            }
        }
        this.f13658a = new C3499g(this, arrayList);
        this.f13660c.setAdapter((ListAdapter) this.f13658a);
        this.f13660c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.fimi.soul.module.setting.RightRollerSetActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (!RightRollerSetActivity.this.f13659b.mo11217ab().mo10898a() || !RightRollerSetActivity.this.f13659b.mo11216ac()) {
                    C2284z.m12695a(RightRollerSetActivity.this, RightRollerSetActivity.this.getString(C2300R.C2303string.right_scroll_mode_des));
                    return;
                }
                switch (i) {
                    case 0:
                        RightRollerSetActivity.this.m8368b(EnumC3470a.light);
                        break;
                    case 1:
                        RightRollerSetActivity.this.m8368b(EnumC3470a.ev);
                        break;
                }
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.module.setting.RightRollerSetActivity.1.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        return i == RightRollerSetActivity.this.f13665h || i == 2;
                    }
                });
            }
        });
        this.f13660c.setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.module.setting.RightRollerSetActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return RightRollerSetActivity.this.f13663f || !RightRollerSetActivity.this.f13659b.mo11216ac() || !RightRollerSetActivity.this.f13659b.mo11217ab().mo10898a();
            }
        });
        m8369b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f13659b != null) {
            this.f13659b.mo11214b(this);
        }
    }
}
