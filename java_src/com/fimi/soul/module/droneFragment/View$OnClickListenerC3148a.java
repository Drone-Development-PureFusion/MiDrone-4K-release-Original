package com.fimi.soul.module.droneFragment;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.amap.api.maps.model.Marker;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2479j;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.MyEditView;
import com.fimi.soul.view.myhorizontalseebar.SeekBar;
import java.math.BigDecimal;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.fimi.soul.module.droneFragment.a */
/* loaded from: classes.dex */
public class View$OnClickListenerC3148a implements View.OnClickListener {

    /* renamed from: s */
    private static final int f11953s = 1;

    /* renamed from: t */
    private static final int f11954t = 2;

    /* renamed from: a */
    private PercentRelativeLayout f11955a;

    /* renamed from: b */
    private SeekBar f11956b;

    /* renamed from: c */
    private SeekBar f11957c;

    /* renamed from: d */
    private C2657a f11958d;

    /* renamed from: e */
    private TextView f11959e;

    /* renamed from: f */
    private TextView f11960f;

    /* renamed from: g */
    private MyEditView f11961g;

    /* renamed from: h */
    private MyEditView f11962h;

    /* renamed from: o */
    private String f11969o;

    /* renamed from: p */
    private Button f11970p;

    /* renamed from: q */
    private String f11971q;

    /* renamed from: r */
    private String f11972r;

    /* renamed from: i */
    private int f11963i = 1;

    /* renamed from: j */
    private int f11964j = 8;

    /* renamed from: k */
    private int f11965k = 120;

    /* renamed from: l */
    private int f11966l = 5;

    /* renamed from: m */
    private String f11967m = C0413a.f922b;

    /* renamed from: n */
    private String f11968n = "m/s";

    /* renamed from: u */
    private int f11973u = 1500;

    /* renamed from: v */
    private Handler f11974v = new Handler() { // from class: com.fimi.soul.module.droneFragment.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    View$OnClickListenerC3148a.this.m9462a(View$OnClickListenerC3148a.this.f11961g, View$OnClickListenerC3148a.this.f11965k, View$OnClickListenerC3148a.this.f11966l, View$OnClickListenerC3148a.this.f11956b, View$OnClickListenerC3148a.this.f11967m);
                    return;
                case 2:
                    View$OnClickListenerC3148a.this.m9462a(View$OnClickListenerC3148a.this.f11962h, View$OnClickListenerC3148a.this.f11964j, View$OnClickListenerC3148a.this.f11963i, View$OnClickListenerC3148a.this.f11957c, View$OnClickListenerC3148a.this.f11968n);
                    return;
                default:
                    return;
            }
        }
    };

    public View$OnClickListenerC3148a(C2657a c2657a, View view) {
        this.f11958d = c2657a;
        m9467a(view);
    }

    /* renamed from: a */
    private void m9467a(View view) {
        this.f11970p = (Button) view.findViewById(C2300R.C2302id.delete_operaActon);
        this.f11970p.setOnClickListener(this);
        this.f11955a = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.changgeHeight_view);
        this.f11956b = (SeekBar) view.findViewById(C2300R.C2302id.height_seebar);
        this.f11956b.setMax(this.f11965k);
        this.f11956b.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.a.2
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                if (i < View$OnClickListenerC3148a.this.f11966l) {
                    i = View$OnClickListenerC3148a.this.f11966l;
                }
                View$OnClickListenerC3148a.this.f11961g.setText(i + View$OnClickListenerC3148a.this.f11967m);
                View$OnClickListenerC3148a.this.m9459b(i);
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
            }
        });
        this.f11957c = (SeekBar) view.findViewById(C2300R.C2302id.speek_seebar);
        this.f11957c.setMax(this.f11964j);
        this.f11957c.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.a.3
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                if (i < View$OnClickListenerC3148a.this.f11963i) {
                    i = View$OnClickListenerC3148a.this.f11963i;
                }
                FlyActionBean m12037o = C2472d.m12036p().m12065a() == 2 ? C2472d.m12036p().m12037o() : C2472d.m12036p().m12038n();
                if (m12037o != null) {
                    m12037o.setSpeek(i);
                }
                if (C2472d.m12036p().m12065a() == 1) {
                    C2472d.m12036p().m12046f(i);
                } else {
                    C2472d.m12036p().m12048e(i);
                }
                View$OnClickListenerC3148a.this.f11962h.setText(i + View$OnClickListenerC3148a.this.f11968n);
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
            }
        });
        this.f11959e = (TextView) view.findViewById(C2300R.C2302id.pointheight);
        this.f11960f = (TextView) view.findViewById(C2300R.C2302id.pointsppek);
        this.f11961g = (MyEditView) view.findViewById(C2300R.C2302id.poi_height);
        this.f11961g.setInputType(2);
        this.f11961g.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.a.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3148a.this.f11961g.hasFocus() || View$OnClickListenerC3148a.this.f11971q.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3148a.this.f11974v.hasMessages(1)) {
                    View$OnClickListenerC3148a.this.f11974v.removeMessages(1);
                }
                View$OnClickListenerC3148a.this.f11974v.sendEmptyMessageDelayed(1, View$OnClickListenerC3148a.this.f11973u);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3148a.this.f11971q = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f11961g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.a.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3148a.this.m9462a(View$OnClickListenerC3148a.this.f11961g, View$OnClickListenerC3148a.this.f11965k, View$OnClickListenerC3148a.this.f11966l, View$OnClickListenerC3148a.this.f11956b, View$OnClickListenerC3148a.this.f11967m);
                    return;
                }
                View$OnClickListenerC3148a.this.f11969o = View$OnClickListenerC3148a.this.f11961g.getText().toString();
                if (View$OnClickListenerC3148a.this.f11969o.length() <= 0) {
                    return;
                }
                View$OnClickListenerC3148a.this.f11961g.setText(View$OnClickListenerC3148a.this.f11969o.substring(0, View$OnClickListenerC3148a.this.f11969o.length() - 1));
            }
        });
        this.f11962h = (MyEditView) view.findViewById(C2300R.C2302id.poi_speek);
        this.f11962h.setInputType(2);
        this.f11962h.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.a.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3148a.this.f11962h.hasFocus() || View$OnClickListenerC3148a.this.f11972r.equals(editable.toString())) {
                    View$OnClickListenerC3148a.this.f11962h.setSelection(editable.length());
                    return;
                }
                if (View$OnClickListenerC3148a.this.f11974v.hasMessages(2)) {
                    View$OnClickListenerC3148a.this.f11974v.removeMessages(2);
                }
                View$OnClickListenerC3148a.this.f11974v.sendEmptyMessageDelayed(2, View$OnClickListenerC3148a.this.f11973u);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3148a.this.f11972r = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f11962h.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.a.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3148a.this.m9462a(View$OnClickListenerC3148a.this.f11962h, View$OnClickListenerC3148a.this.f11964j, View$OnClickListenerC3148a.this.f11963i, View$OnClickListenerC3148a.this.f11957c, View$OnClickListenerC3148a.this.f11968n);
                    return;
                }
                View$OnClickListenerC3148a.this.f11969o = View$OnClickListenerC3148a.this.f11962h.getText().toString();
                if (View$OnClickListenerC3148a.this.f11969o.length() <= 3) {
                    return;
                }
                View$OnClickListenerC3148a.this.f11962h.setText(View$OnClickListenerC3148a.this.f11969o.substring(0, View$OnClickListenerC3148a.this.f11969o.length() - 3));
            }
        });
        C3658ar.m7612a(this.f11958d.f9270d.getAssets(), this.f11959e, this.f11960f, this.f11970p, this.f11961g, this.f11962h);
    }

    /* renamed from: a */
    private void m9466a(EditText editText) {
        if (editText.getText().toString().length() > 0) {
            if (this.f11961g == editText) {
                this.f11961g.setSelection(this.f11961g.length() - 1);
            } else if (this.f11962h != editText || this.f11962h.length() <= 3) {
            } else {
                this.f11962h.setSelection(this.f11962h.length() - 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9462a(MyEditView myEditView, int i, int i2, SeekBar seekBar, String str) {
        String str2;
        try {
            myEditView.setCursorVisible(false);
            String m9461a = m9461a(m9456b(myEditView.getText().toString()));
            int parseInt = Integer.parseInt(m9461a);
            if (parseInt > i) {
                str2 = i + str;
                myEditView.setText(str2);
            } else if (parseInt < i2) {
                str2 = i2 + str;
                myEditView.setText(str2);
                i = i2;
            } else {
                i = parseInt;
                str2 = m9461a;
            }
            seekBar.setProgress(i);
            if (!str2.contains(str)) {
                myEditView.setText(str2 + str);
            }
            m9466a((EditText) myEditView);
            FlyActionBean m12037o = C2472d.m12036p().m12065a() == 2 ? C2472d.m12036p().m12037o() : C2472d.m12036p().m12038n();
            if (seekBar == this.f11956b) {
                m12037o.setHeight(i);
                m9459b(i);
            } else if (seekBar == this.f11957c) {
                m12037o.setSpeek(i);
            }
            myEditView.setCursorVisible(true);
        } catch (Exception e) {
            myEditView.setText(this.f11969o + str);
            m9466a((EditText) myEditView);
            myEditView.setCursorVisible(true);
        }
    }

    /* renamed from: b */
    public static String m9456b(String str) {
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    /* renamed from: a */
    public String m9461a(String str) {
        return BigDecimal.valueOf(Integer.parseInt(str)).stripTrailingZeros().toPlainString();
    }

    /* renamed from: a */
    public void m9469a() {
        if (!this.f11955a.isShown()) {
            this.f11955a.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void m9468a(int i) {
        this.f11956b.setProgress(i);
    }

    /* renamed from: b */
    public void m9460b() {
        if (this.f11955a.isShown()) {
            this.f11955a.setVisibility(4);
        }
    }

    /* renamed from: b */
    public void m9459b(int i) {
        FlyActionBean m12037o = C2472d.m12036p().m12065a() == 2 ? C2472d.m12036p().m12037o() : C2472d.m12036p().m12038n();
        if (m12037o != null) {
            C2472d.m12036p().m12050d(i);
            m12037o.setHeight(i);
            for (Marker marker : C2472d.m12036p().m12043i()) {
                if (marker.getObject().equals(m12037o)) {
                    marker.setIcon(C2479j.m12013a(this.f11958d.f9270d, m12037o.getDrawableRes(), m12037o.getHeight(), true));
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public void m9455c(int i) {
        this.f11970p.setText(i);
    }

    /* renamed from: d */
    public void m9452d(int i) {
        this.f11957c.setProgress(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.delete_operaActon /* 2131492915 */:
                this.f11958d.mo11220a(C2678d.EnumC2679a.DELETE_WAYPOINT);
                return;
            default:
                return;
        }
    }
}
