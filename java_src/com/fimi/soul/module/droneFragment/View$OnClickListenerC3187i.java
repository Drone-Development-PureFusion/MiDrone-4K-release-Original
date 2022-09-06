package com.fimi.soul.module.droneFragment;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.p204a.C2861a;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.MyEditView;
import com.fimi.soul.view.SwitchButtonStoke;
import com.fimi.soul.view.myhorizontalseebar.SeekBar;
import java.math.BigDecimal;
import java.util.regex.Pattern;
/* renamed from: com.fimi.soul.module.droneFragment.i */
/* loaded from: classes.dex */
public class View$OnClickListenerC3187i implements View.OnClickListener, SwitchButtonStoke.AbstractC3731a {

    /* renamed from: W */
    private static final int f12129W = 1;

    /* renamed from: X */
    private static final int f12130X = 2;

    /* renamed from: Y */
    private static final int f12131Y = 1500;

    /* renamed from: B */
    private int f12133B;

    /* renamed from: C */
    private int f12134C;

    /* renamed from: D */
    private int f12135D;

    /* renamed from: E */
    private int f12136E;

    /* renamed from: H */
    private double f12139H;

    /* renamed from: I */
    private double f12140I;

    /* renamed from: J */
    private double f12141J;

    /* renamed from: K */
    private double f12142K;

    /* renamed from: L */
    private double f12143L;

    /* renamed from: O */
    private boolean f12146O;

    /* renamed from: R */
    private String f12149R;

    /* renamed from: U */
    private String f12152U;

    /* renamed from: V */
    private String f12153V;

    /* renamed from: a */
    private Button f12155a;

    /* renamed from: aa */
    private FlightActivity.AbstractC3281a f12156aa;

    /* renamed from: b */
    private Button f12157b;

    /* renamed from: c */
    private Button f12158c;

    /* renamed from: d */
    private MyEditView f12159d;

    /* renamed from: e */
    private MyEditView f12160e;

    /* renamed from: f */
    private TextView f12161f;

    /* renamed from: g */
    private TextView f12162g;

    /* renamed from: h */
    private TextView f12163h;

    /* renamed from: i */
    private TextView f12164i;

    /* renamed from: j */
    private TextView f12165j;

    /* renamed from: k */
    private TextView f12166k;

    /* renamed from: l */
    private TextView f12167l;

    /* renamed from: m */
    private TextView f12168m;

    /* renamed from: n */
    private SeekBar f12169n;

    /* renamed from: o */
    private SeekBar f12170o;

    /* renamed from: p */
    private SwitchButtonStoke f12171p;

    /* renamed from: q */
    private C2657a f12172q;

    /* renamed from: r */
    private PercentRelativeLayout f12173r;

    /* renamed from: s */
    private ImageView f12174s;

    /* renamed from: t */
    private int f12175t = 1;

    /* renamed from: u */
    private int f12176u = 30;

    /* renamed from: v */
    private int f12177v = 10;

    /* renamed from: w */
    private int f12178w = 10;

    /* renamed from: x */
    private int f12179x = 120;

    /* renamed from: y */
    private int f12180y = 500;

    /* renamed from: z */
    private int f12181z = 4;

    /* renamed from: A */
    private int f12132A = 8;

    /* renamed from: F */
    private int f12137F = 20;

    /* renamed from: G */
    private int f12138G = 1;

    /* renamed from: N */
    private int f12145N = 300;

    /* renamed from: P */
    private boolean f12147P = false;

    /* renamed from: Q */
    private int f12148Q = 0;

    /* renamed from: S */
    private String f12150S = "s";

    /* renamed from: T */
    private String f12151T = "m/s";

    /* renamed from: Z */
    private Handler f12154Z = new Handler() { // from class: com.fimi.soul.module.droneFragment.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    View$OnClickListenerC3187i.this.m9286a(View$OnClickListenerC3187i.this.f12159d, View$OnClickListenerC3187i.this.f12136E, 0, View$OnClickListenerC3187i.this.f12169n, View$OnClickListenerC3187i.this.f12150S);
                    return;
                case 2:
                    View$OnClickListenerC3187i.this.m9286a(View$OnClickListenerC3187i.this.f12160e, View$OnClickListenerC3187i.this.f12133B, View$OnClickListenerC3187i.this.f12175t, View$OnClickListenerC3187i.this.f12170o, View$OnClickListenerC3187i.this.f12151T);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: M */
    private C2423d f12144M = (C2423d) C2379b.m12410a().m12394d();

    public View$OnClickListenerC3187i(View view, C2657a c2657a) {
        this.f12172q = c2657a;
        m9296a(view);
    }

    /* renamed from: a */
    private int m9299a(double d) {
        this.f12139H = d;
        double sin = (int) (this.f12181z / Math.sin(Math.toRadians(d)));
        double cos = (int) (this.f12132A / Math.cos(Math.toRadians(d)));
        if (Math.cos(Math.toRadians(d)) * sin <= this.f12132A && Math.sin(Math.toRadians(d)) * cos > this.f12181z) {
            this.f12133B = (int) sin;
        }
        if (Math.cos(Math.toRadians(d)) * sin > this.f12132A && Math.sin(Math.toRadians(d)) * cos <= this.f12181z) {
            this.f12133B = (int) cos;
        }
        if (Math.sin(Math.toRadians(d)) * cos <= this.f12181z && Math.cos(Math.toRadians(d)) * sin <= this.f12132A) {
            if (sin >= cos) {
                this.f12133B = (int) sin;
            } else {
                this.f12133B = (int) cos;
            }
        }
        this.f12170o.setMax(this.f12133B);
        this.f12168m.setText(String.format(this.f12172q.f9270d.getString(C2300R.C2303string.fly_angle), Integer.valueOf((int) d)));
        int progress = this.f12170o.getProgress();
        if (progress < this.f12175t) {
            progress = this.f12175t;
        }
        m9297a(m9261l(), d, (int) (this.f12180y - m9263k()), progress);
        return this.f12133B;
    }

    /* renamed from: a */
    private int m9297a(int i, double d, int i2, int i3) {
        double sin = i / Math.sin(Math.toRadians(d));
        double d2 = this.f12145N;
        int i4 = this.f12145N;
        if ((Math.cos(Math.toRadians(d)) * sin) - m9263k() <= i4 && (Math.sin(Math.toRadians(d)) * d2) - ((this.f12172q.mo11202w().m10498g() - 677216.0d) / 10.0d) <= i) {
            if (sin <= d2) {
                this.f12136E = (int) (d2 / i3);
                this.f12134C = (int) d2;
            } else {
                this.f12136E = (int) (sin / i3);
                this.f12134C = (int) sin;
            }
        }
        if ((Math.cos(Math.toRadians(d)) * sin) - m9263k() <= i4 && (Math.sin(Math.toRadians(d)) * d2) - ((this.f12172q.mo11202w().m10498g() - 677216.0d) / 10.0d) > i) {
            this.f12136E = (int) (sin / i3);
            this.f12134C = (int) sin;
        }
        if ((sin * Math.cos(Math.toRadians(d))) - m9263k() > i4 && (Math.sin(Math.toRadians(d)) * d2) - ((this.f12172q.mo11202w().m10498g() - 677216.0d) / 10.0d) <= i) {
            this.f12136E = (int) (d2 / i3);
            this.f12134C = (int) d2;
        }
        m9259m();
        this.f12169n.setMax(this.f12136E);
        return this.f12136E;
    }

    /* renamed from: a */
    private void m9296a(View view) {
        View[] viewArr;
        MyEditView[] myEditViewArr;
        this.f12165j = (TextView) view.findViewById(C2300R.C2302id.guestDestinceDes);
        this.f12166k = (TextView) view.findViewById(C2300R.C2302id.height_diatance_guest);
        this.f12167l = (TextView) view.findViewById(C2300R.C2302id.drone_fly_direction);
        this.f12168m = (TextView) view.findViewById(C2300R.C2302id.drone_fly_angle);
        this.f12174s = (ImageView) view.findViewById(C2300R.C2302id.targeImage);
        this.f12173r = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.takephoto_operaRL);
        this.f12155a = (Button) view.findViewById(C2300R.C2302id.fly_action_cancal_btn);
        this.f12157b = (Button) view.findViewById(C2300R.C2302id.fly_action_execute_btn);
        this.f12161f = (TextView) view.findViewById(C2300R.C2302id.show_camera_angle);
        this.f12162g = (TextView) view.findViewById(C2300R.C2302id.heighdes);
        this.f12163h = (TextView) view.findViewById(C2300R.C2302id.speekdes);
        this.f12169n = (SeekBar) view.findViewById(C2300R.C2302id.heightseebar_value);
        this.f12169n.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.i.2
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    View$OnClickListenerC3187i.this.f12159d.setText(i + "s");
                    View$OnClickListenerC3187i.this.m9259m();
                    C2472d.m12036p().m12056b(i);
                }
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
            }
        });
        this.f12170o = (SeekBar) view.findViewById(C2300R.C2302id.speek_seebar_value);
        this.f12170o.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.i.3
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                if (i < 1) {
                    i = 1;
                }
                View$OnClickListenerC3187i.this.m9259m();
                View$OnClickListenerC3187i.this.f12160e.setText(i + "m/s");
                C2472d.m12036p().m12053c(i);
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
                View$OnClickListenerC3187i.this.m9269h();
            }
        });
        this.f12171p = (SwitchButtonStoke) view.findViewById(C2300R.C2302id.is_auto_back);
        this.f12171p.setOnSwitchListener(new SwitchButtonStoke.AbstractC3731a() { // from class: com.fimi.soul.module.droneFragment.i.4
            @Override // com.fimi.soul.view.SwitchButtonStoke.AbstractC3731a
            /* renamed from: a */
            public void mo7246a(View view2, boolean z) {
                if (z) {
                    View$OnClickListenerC3187i.this.f12148Q = 1;
                } else {
                    View$OnClickListenerC3187i.this.f12148Q = 0;
                }
            }
        });
        this.f12164i = (TextView) view.findViewById(C2300R.C2302id.sbbuttondes);
        this.f12158c = (Button) view.findViewById(C2300R.C2302id.setflyphoto);
        this.f12159d = (MyEditView) view.findViewById(C2300R.C2302id.height_value);
        this.f12159d.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.i.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3187i.this.f12159d.hasFocus() || View$OnClickListenerC3187i.this.f12152U.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3187i.this.f12154Z.hasMessages(1)) {
                    View$OnClickListenerC3187i.this.f12154Z.removeMessages(1);
                }
                View$OnClickListenerC3187i.this.f12154Z.sendEmptyMessageDelayed(1, 1500L);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3187i.this.f12152U = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f12159d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.i.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3187i.this.m9286a(View$OnClickListenerC3187i.this.f12159d, View$OnClickListenerC3187i.this.f12136E, 0, View$OnClickListenerC3187i.this.f12169n, View$OnClickListenerC3187i.this.f12150S);
                    return;
                }
                View$OnClickListenerC3187i.this.f12149R = View$OnClickListenerC3187i.this.f12159d.getText().toString();
                if (View$OnClickListenerC3187i.this.f12149R.length() <= 0) {
                    return;
                }
                View$OnClickListenerC3187i.this.f12159d.setText(View$OnClickListenerC3187i.this.f12149R.substring(0, View$OnClickListenerC3187i.this.f12149R.length() - 1));
            }
        });
        this.f12160e = (MyEditView) view.findViewById(C2300R.C2302id.speek_value);
        this.f12160e.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.i.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3187i.this.f12160e.hasFocus() || View$OnClickListenerC3187i.this.f12153V.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3187i.this.f12154Z.hasMessages(2)) {
                    View$OnClickListenerC3187i.this.f12154Z.removeMessages(2);
                }
                View$OnClickListenerC3187i.this.f12154Z.sendEmptyMessageDelayed(2, 1500L);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3187i.this.f12153V = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f12160e.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.i.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3187i.this.m9286a(View$OnClickListenerC3187i.this.f12160e, View$OnClickListenerC3187i.this.f12133B, View$OnClickListenerC3187i.this.f12175t, View$OnClickListenerC3187i.this.f12170o, View$OnClickListenerC3187i.this.f12151T);
                    return;
                }
                View$OnClickListenerC3187i.this.f12149R = View$OnClickListenerC3187i.this.f12159d.getText().toString();
                if (View$OnClickListenerC3187i.this.f12149R.length() <= 3) {
                    return;
                }
                View$OnClickListenerC3187i.this.f12160e.setText(View$OnClickListenerC3187i.this.f12149R.substring(0, View$OnClickListenerC3187i.this.f12149R.length() - 3));
            }
        });
        C3658ar.m7612a(this.f12172q.f9270d.getAssets(), this.f12155a, this.f12157b, this.f12161f, this.f12162g, this.f12163h, this.f12164i, this.f12158c, this.f12165j, this.f12166k, this.f12167l, this.f12168m);
        C3658ar.m7598b(this.f12172q.f9270d.getAssets(), this.f12159d, this.f12160e);
        for (View view2 : new View[]{this.f12155a, this.f12157b, this.f12158c}) {
            if (view2 instanceof SwitchButtonStoke) {
                ((SwitchButtonStoke) view2).setOnSwitchListener(this);
            } else {
                view2.setOnClickListener(this);
            }
        }
        for (MyEditView myEditView : new MyEditView[]{this.f12159d, this.f12160e}) {
            myEditView.clearFocus();
            myEditView.setInputType(2);
        }
    }

    /* renamed from: a */
    private void m9295a(EditText editText) {
        if (editText.getText().toString().length() > 0) {
            if (this.f12159d == editText) {
                this.f12159d.setSelection(this.f12159d.length() - 1);
            } else if (this.f12160e != editText || this.f12160e.length() <= 3) {
            } else {
                this.f12160e.setSelection(this.f12160e.length() - 3);
            }
        }
    }

    /* renamed from: a */
    private void m9294a(TextView textView, int i, double d) {
        if (!textView.getText().toString().equals(String.format(this.f12172q.f9270d.getString(i), Double.valueOf(d)))) {
            textView.setText(String.format(this.f12172q.f9270d.getString(i), Double.valueOf(d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9286a(MyEditView myEditView, int i, int i2, SeekBar seekBar, String str) {
        String str2;
        try {
            myEditView.setCursorVisible(false);
            String m9285a = m9285a(m9281b(myEditView.getText().toString()));
            int parseInt = Integer.parseInt(m9285a);
            if (parseInt > i) {
                str2 = i + str;
                myEditView.setText(str2);
            } else if (parseInt < i2) {
                str2 = i2 + str;
                myEditView.setText(str2);
                i = i2;
            } else {
                i = parseInt;
                str2 = m9285a;
            }
            seekBar.setProgress(Integer.valueOf(i).intValue());
            if (str == this.f12150S) {
                C2472d.m12036p().m12056b(Integer.valueOf(i).intValue());
            } else {
                C2472d.m12036p().m12053c(Integer.valueOf(i).intValue());
            }
            if (!str2.contains(str)) {
                myEditView.setText(str2 + str);
            }
            m9295a((EditText) myEditView);
            myEditView.setCursorVisible(true);
        } catch (Exception e) {
            myEditView.setText(i2 + str);
            m9295a((EditText) myEditView);
            myEditView.setCursorVisible(true);
        }
    }

    /* renamed from: b */
    public static String m9281b(String str) {
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    /* renamed from: k */
    private double m9263k() {
        C3639ai m7726a = C3633ac.m7726a(this.f12172q.mo11201x().m10612b(), this.f12172q.mo11201x().m10611c());
        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        C3639ai m7726a2 = C3633ac.m7726a(this.f12172q.mo11202w().m10499f(), this.f12172q.mo11202w().m10500e());
        return C3632ab.m7729c(latLng, new LatLng(m7726a2.m7702a(), m7726a2.m7700b())).m7698a();
    }

    /* renamed from: l */
    private int m9261l() {
        return (int) (this.f12179x - ((this.f12172q.mo11202w().m10498g() - 677216.0d) / 10.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m9259m() {
        int progress = this.f12170o.getProgress();
        if (progress < this.f12175t) {
            progress = this.f12175t;
        }
        int progress2 = progress * this.f12169n.getProgress();
        double m12793a = C2275t.m12793a((progress2 * Math.sin(Math.toRadians(this.f12139H))) + ((this.f12172q.mo11202w().m10498g() - 677216.0d) / 10.0d), 1);
        double m12793a2 = C2275t.m12793a(progress2 * Math.cos(Math.toRadians(this.f12139H)), 1);
        m9294a(this.f12166k, C2300R.C2303string.take_phone_fly_time, m12793a);
        m9294a(this.f12165j, C2300R.C2303string.guest_distance_value, m12793a2);
    }

    /* renamed from: a */
    public LatLng m9293a(LatLng latLng, double d, double d2) {
        return C3632ab.m7733a(latLng, d, d2);
    }

    /* renamed from: a */
    public String m9285a(String str) {
        return BigDecimal.valueOf(Double.parseDouble(str)).stripTrailingZeros().toPlainString();
    }

    /* renamed from: a */
    public void m9300a() {
        if (this.f12172q.m11312at().m10700g().isEnforcementAtti()) {
            C2284z.m12696a(this.f12172q.f9270d, (int) C2300R.C2303string.cant_fly_takePhoto_atti, 3000);
        } else if (this.f12172q.m11312at().m10700g().isLightStream()) {
            C2284z.m12696a(this.f12172q.f9270d, (int) C2300R.C2303string.cant_fly_takePhoto_VPU, 3000);
        } else if (this.f12136E > 0 && this.f12169n.getProgress() == 0) {
            C2284z.m12696a(this.f12172q.f9270d, (int) C2300R.C2303string.set_flyTime, 3000);
        } else {
            if (this.f12144M == null || this.f12144M.g() != AbstractC2390c.EnumC2400a.Recoding) {
                this.f12144M.m12230x().mo12248f();
            } else {
                m9284b();
            }
            this.f12172q.mo11220a(C2678d.EnumC2679a.SHOWOUTTIMEPROBAR);
        }
    }

    /* renamed from: a */
    public void m9298a(int i) {
        this.f12135D = i;
        this.f12161f.setText(this.f12135D + "度");
        m9299a(Math.abs(i));
    }

    @Override // com.fimi.soul.view.SwitchButtonStoke.AbstractC3731a
    /* renamed from: a */
    public void mo7246a(View view, boolean z) {
    }

    /* renamed from: a */
    public void m9292a(C2861a c2861a) {
        if (c2861a != null) {
            try {
                if (this.f12141J == 0.0d) {
                    this.f12141J = c2861a.m10739d();
                }
                if (this.f12142K == 0.0d) {
                    this.f12142K = c2861a.m10738e();
                }
                if (this.f12143L == 0.0d) {
                    this.f12143L = c2861a.m10740c();
                }
                if (this.f12140I == 0.0d) {
                    this.f12140I = c2861a.m10737f() / 10;
                }
                this.f12170o.setProgress(c2861a.m10736g() / 10);
                this.f12169n.setProgress(c2861a.m10735h() / c2861a.m10736g());
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void m9287a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f12156aa = abstractC3281a;
    }

    /* renamed from: b */
    public void m9284b() {
        if (this.f12147P) {
            if (this.f12141J == 0.0d) {
                this.f12141J = this.f12172q.mo11202w().m10498g() - 677216.0d;
            }
            if (this.f12142K == 0.0d) {
                this.f12142K = this.f12172q.mo11202w().m10500e();
            }
            if (this.f12143L == 0.0d) {
                this.f12143L = this.f12172q.mo11202w().m10499f();
            }
            if (this.f12140I == 0.0d) {
                this.f12140I = this.f12139H;
            }
            m9280c();
        }
    }

    /* renamed from: c */
    public void m9280c() {
        int progress = this.f12170o.getProgress();
        int i = progress < this.f12175t ? this.f12175t : progress;
        C3057d.m9823a(this.f12172q).m9832a((byte) 18, (byte) this.f12148Q, (short) (this.f12169n.getProgress() * i * 10), (short) (this.f12140I * 100.0d), (byte) (i * 10), (short) this.f12141J, (float) this.f12142K, (float) this.f12143L);
    }

    /* renamed from: d */
    public void m9277d() {
        C2284z.m12696a(this.f12172q.f9270d, (int) C2300R.C2303string.take_photo_tip, 2000);
    }

    /* renamed from: e */
    public void m9275e() {
        this.f12158c.setVisibility(0);
        this.f12174s.setVisibility(0);
    }

    /* renamed from: f */
    public void m9273f() {
        this.f12158c.setVisibility(8);
        this.f12158c.setVisibility(8);
        if (this.f12173r.isShown()) {
            this.f12173r.setVisibility(8);
        }
    }

    /* renamed from: g */
    public void m9271g() {
        this.f12161f.setText(C2300R.C2303string.no_use);
    }

    /* renamed from: h */
    public void m9269h() {
        if (this.f12136E >= 20) {
            this.f12169n.setProgress(this.f12137F);
            this.f12159d.setText(this.f12137F + "s");
            return;
        }
        if (this.f12136E == 0 && this.f12173r.isShown() && m9261l() < 2) {
            C2284z.m12694a(this.f12172q.f9270d, "飞机将达到最大高度，请调节云台角度", 3000);
        }
        this.f12169n.setProgress(this.f12136E);
        this.f12159d.setText(this.f12136E + "s");
    }

    /* renamed from: i */
    public void m9267i() {
        int m12049e = C2472d.m12036p().m12049e();
        this.f12170o.setProgress(m12049e);
        this.f12160e.setText(m12049e + "m/s");
        int m12051d = C2472d.m12036p().m12051d();
        this.f12169n.setProgress(m12051d);
        this.f12159d.setText(m12051d + "s");
        this.f12173r.setVisibility(8);
        this.f12171p.setSwitchState(false);
        this.f12148Q = 0;
        this.f12143L = 0.0d;
        this.f12141J = 0.0d;
        this.f12142K = 0.0d;
        this.f12140I = 0.0d;
        this.f12146O = false;
        this.f12147P = false;
        m9259m();
    }

    /* renamed from: j */
    public void m9265j() {
        this.f12156aa.mo8856b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.fly_action_cancal_btn /* 2131493379 */:
                this.f12147P = false;
                m9273f();
                C2477h.m12020a(this.f12172q.f9270d).m12021a(0);
                this.f12172q.mo11220a(C2678d.EnumC2679a.CANCALFLYACTION);
                this.f12156aa.mo8856b();
                return;
            case C2300R.C2302id.fly_action_execute_btn /* 2131493380 */:
                if (!this.f12146O) {
                    C2284z.m12696a(this.f12172q.f9270d, (int) C2300R.C2303string.on_next, 3000);
                    return;
                }
                this.f12147P = true;
                m9300a();
                return;
            case C2300R.C2302id.setflyphoto /* 2131493400 */:
                this.f12146O = true;
                if (!this.f12173r.isShown()) {
                    this.f12173r.setVisibility(0);
                }
                if (this.f12174s.isShown()) {
                    this.f12174s.setVisibility(8);
                }
                if (!this.f12158c.isShown()) {
                    return;
                }
                this.f12158c.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
