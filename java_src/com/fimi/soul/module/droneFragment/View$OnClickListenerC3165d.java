package com.fimi.soul.module.droneFragment;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2479j;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3678g;
import com.fimi.soul.view.MyEditView;
import com.fimi.soul.view.myhorizontalseebar.SeekBar;
import it.p235a.p236a.AbstractC4863e;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.fimi.soul.module.droneFragment.d */
/* loaded from: classes.dex */
public class View$OnClickListenerC3165d implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: ag */
    private static final String f12028ag = "PoiOperaView";

    /* renamed from: A */
    private Button f12029A;

    /* renamed from: B */
    private Button f12030B;

    /* renamed from: C */
    private PopupWindow f12031C;

    /* renamed from: D */
    private String[] f12032D;

    /* renamed from: E */
    private boolean f12033E;

    /* renamed from: F */
    private boolean f12034F;

    /* renamed from: G */
    private boolean f12035G;

    /* renamed from: H */
    private boolean f12036H;

    /* renamed from: I */
    private C2657a f12037I;

    /* renamed from: J */
    private int f12038J;

    /* renamed from: K */
    private Circle f12039K;

    /* renamed from: M */
    private Marker f12041M;

    /* renamed from: N */
    private Marker f12042N;

    /* renamed from: O */
    private AMap f12043O;

    /* renamed from: P */
    private Polyline f12044P;

    /* renamed from: Q */
    private int f12045Q;

    /* renamed from: Z */
    private String f12054Z;

    /* renamed from: a */
    EditText[] f12055a;

    /* renamed from: aa */
    private SeekBar[] f12056aa;

    /* renamed from: ah */
    private float f12062ah;

    /* renamed from: ai */
    private float f12063ai;

    /* renamed from: b */
    InputMethodManager f12064b;

    /* renamed from: c */
    String f12065c;

    /* renamed from: d */
    String f12066d;

    /* renamed from: e */
    String f12067e;

    /* renamed from: f */
    String f12068f;

    /* renamed from: h */
    private MyEditView f12070h;

    /* renamed from: i */
    private MyEditView f12071i;

    /* renamed from: j */
    private MyEditView f12072j;

    /* renamed from: k */
    private MyEditView f12073k;

    /* renamed from: l */
    private TextView f12074l;

    /* renamed from: m */
    private TextView f12075m;

    /* renamed from: n */
    private TextView f12076n;

    /* renamed from: o */
    private TextView f12077o;

    /* renamed from: p */
    private TextView f12078p;

    /* renamed from: q */
    private SeekBar f12079q;

    /* renamed from: r */
    private SeekBar f12080r;

    /* renamed from: s */
    private SeekBar f12081s;

    /* renamed from: t */
    private SeekBar f12082t;

    /* renamed from: u */
    private RadioGroup f12083u;

    /* renamed from: v */
    private Context f12084v;

    /* renamed from: w */
    private PercentRelativeLayout f12085w;

    /* renamed from: x */
    private RadioButton f12086x;

    /* renamed from: y */
    private RadioButton f12087y;

    /* renamed from: z */
    private Button f12088z;

    /* renamed from: R */
    private int f12046R = 5;

    /* renamed from: S */
    private int f12047S = 120;

    /* renamed from: T */
    private int f12048T = 10;

    /* renamed from: U */
    private int f12049U = 1;

    /* renamed from: V */
    private int f12050V = AbstractC4863e.f20805n;

    /* renamed from: W */
    private int f12051W = 5;

    /* renamed from: X */
    private int f12052X = 360;

    /* renamed from: Y */
    private int f12053Y = 0;

    /* renamed from: ab */
    private int f12057ab = 1500;

    /* renamed from: ac */
    private int f12058ac = 1;

    /* renamed from: ad */
    private int f12059ad = 2;

    /* renamed from: ae */
    private int f12060ae = 3;

    /* renamed from: af */
    private int f12061af = 4;

    /* renamed from: g */
    Handler f12069g = new Handler() { // from class: com.fimi.soul.module.droneFragment.d.6
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == View$OnClickListenerC3165d.this.f12059ad) {
                try {
                    int sqrt = (int) Math.sqrt(Integer.parseInt(View$OnClickListenerC3165d.m9363b(View$OnClickListenerC3165d.this.f12072j.getText().toString())) * 1.5d);
                    if (sqrt >= View$OnClickListenerC3165d.this.f12048T) {
                        sqrt = View$OnClickListenerC3165d.this.f12048T;
                    }
                    if (sqrt == 0) {
                        View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12071i, View$OnClickListenerC3165d.this.f12080r.getMax(), View$OnClickListenerC3165d.this.f12049U, View$OnClickListenerC3165d.this.f12080r, "m/s");
                    } else {
                        View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12071i, sqrt, View$OnClickListenerC3165d.this.f12049U, View$OnClickListenerC3165d.this.f12080r, "m/s");
                    }
                } catch (Exception e) {
                }
            } else if (message.what == View$OnClickListenerC3165d.this.f12058ac) {
                View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12070h, View$OnClickListenerC3165d.this.f12047S, View$OnClickListenerC3165d.this.f12046R, View$OnClickListenerC3165d.this.f12079q, C0413a.f922b);
            } else if (message.what == View$OnClickListenerC3165d.this.f12060ae) {
                View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12072j, View$OnClickListenerC3165d.this.f12081s.getMax(), View$OnClickListenerC3165d.this.f12051W, View$OnClickListenerC3165d.this.f12081s, C0413a.f922b);
            } else if (message.what != View$OnClickListenerC3165d.this.f12061af) {
            } else {
                View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12073k, View$OnClickListenerC3165d.this.f12052X, View$OnClickListenerC3165d.this.f12053Y, View$OnClickListenerC3165d.this.f12082t, "°");
            }
        }
    };

    /* renamed from: L */
    private C2472d f12040L = C2472d.m12036p();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.module.droneFragment.d$a */
    /* loaded from: classes.dex */
    public class C3182a extends BaseAdapter {

        /* renamed from: b */
        private Context f12106b;

        /* renamed from: c */
        private String[] f12107c;

        public C3182a(Context context, String[] strArr) {
            this.f12106b = context;
            this.f12107c = strArr;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f12107c == null) {
                return 0;
            }
            return this.f12107c.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f12107c == null) {
                return null;
            }
            return this.f12107c[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.f12106b).inflate(C2300R.layout.mysimple_spinner_dropdown_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.itemangle);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (View$OnClickListenerC3165d.this.f12031C != null) {
                layoutParams.width = View$OnClickListenerC3165d.this.f12031C.getWidth();
            }
            textView.setLayoutParams(layoutParams);
            textView.setText(this.f12107c[i]);
            C3658ar.m7612a(this.f12106b.getAssets(), textView);
            return inflate;
        }
    }

    public View$OnClickListenerC3165d(View view, C2657a c2657a) {
        EditText[] editTextArr;
        this.f12064b = (InputMethodManager) c2657a.f9270d.getSystemService("input_method");
        this.f12045Q = c2657a.f9270d.getResources().getDisplayMetrics().heightPixels / 3;
        this.f12037I = c2657a;
        this.f12043O = c2657a.m11323ai();
        this.f12084v = c2657a.f9270d;
        this.f12032D = this.f12084v.getResources().getStringArray(C2300R.array.drone_head);
        this.f12076n = (TextView) view.findViewById(C2300R.C2302id.pointheight);
        this.f12077o = (TextView) view.findViewById(C2300R.C2302id.pointsppek);
        this.f12078p = (TextView) view.findViewById(C2300R.C2302id.pointridus);
        this.f12073k = (MyEditView) view.findViewById(C2300R.C2302id.poianglevalue);
        this.f12075m = (TextView) view.findViewById(C2300R.C2302id.poiangle);
        this.f12082t = (SeekBar) view.findViewById(C2300R.C2302id.angle_seebar_value);
        this.f12082t.setMax(this.f12052X);
        this.f12082t.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.d.1
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12036H = true;
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                FlyActionBean m12047f;
                if (!View$OnClickListenerC3165d.this.f12036H || (m12047f = View$OnClickListenerC3165d.this.f12040L.m12047f()) == null) {
                    return;
                }
                View$OnClickListenerC3165d.this.f12073k.setText(i + "°");
                m12047f.setStart_point_agle((short) i);
                View$OnClickListenerC3165d.this.m9369a(false);
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12036H = false;
            }
        });
        this.f12030B = (Button) view.findViewById(C2300R.C2302id.setPoi);
        this.f12030B.setOnClickListener(this);
        this.f12074l = (TextView) view.findViewById(C2300R.C2302id.spend_time);
        this.f12029A = (Button) view.findViewById(C2300R.C2302id.delete_poi);
        this.f12029A.setOnClickListener(this);
        this.f12088z = (Button) view.findViewById(C2300R.C2302id.myspinner);
        this.f12088z.setText(this.f12032D[0]);
        this.f12088z.setOnClickListener(this);
        this.f12083u = (RadioGroup) view.findViewById(C2300R.C2302id.drone_direction);
        this.f12086x = (RadioButton) view.findViewById(C2300R.C2302id.clockwise);
        this.f12087y = (RadioButton) view.findViewById(C2300R.C2302id.anticlockwise);
        this.f12083u.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.fimi.soul.module.droneFragment.d.9
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FlyActionBean m12047f = View$OnClickListenerC3165d.this.f12040L.m12047f();
                if (m12047f != null) {
                    switch (i) {
                        case C2300R.C2302id.clockwise /* 2131493464 */:
                            m12047f.setPara1(3);
                            break;
                        case C2300R.C2302id.anticlockwise /* 2131493465 */:
                            m12047f.setPara1(1);
                            break;
                    }
                    View$OnClickListenerC3165d.this.m9354f();
                    View$OnClickListenerC3165d.this.m9369a(false);
                }
            }
        });
        this.f12083u.check(C2300R.C2302id.clockwise);
        this.f12085w = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.poi_operaRL);
        this.f12070h = (MyEditView) view.findViewById(C2300R.C2302id.poi_height_value);
        this.f12071i = (MyEditView) view.findViewById(C2300R.C2302id.poispeek);
        this.f12072j = (MyEditView) view.findViewById(C2300R.C2302id.poiridusvalue);
        this.f12079q = (SeekBar) view.findViewById(C2300R.C2302id.height_seebar_value);
        this.f12080r = (SeekBar) view.findViewById(C2300R.C2302id.speek_seebar_value);
        this.f12081s = (SeekBar) view.findViewById(C2300R.C2302id.ridus_seebar_value);
        this.f12081s.setMax(this.f12050V);
        this.f12080r.setMax(this.f12048T);
        this.f12079q.setMax(this.f12047S);
        this.f12079q.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.d.10
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12033E = true;
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                FlyActionBean m12047f;
                if (!View$OnClickListenerC3165d.this.f12033E || (m12047f = View$OnClickListenerC3165d.this.f12040L.m12047f()) == null) {
                    return;
                }
                if (i < View$OnClickListenerC3165d.this.f12046R) {
                    i = View$OnClickListenerC3165d.this.f12046R;
                }
                View$OnClickListenerC3165d.this.f12070h.setText(i + C0413a.f922b);
                m12047f.setHeight(i);
                for (Marker marker : C2472d.m12036p().m12043i()) {
                    if (marker.getObject().equals(m12047f)) {
                        marker.setIcon(C2479j.m12013a(View$OnClickListenerC3165d.this.f12084v, m12047f.getDrawableRes(), m12047f.getHeight(), true));
                        return;
                    }
                }
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12033E = false;
            }
        });
        this.f12080r.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.d.11
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12034F = true;
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                FlyActionBean m12047f;
                if (!View$OnClickListenerC3165d.this.f12034F || (m12047f = View$OnClickListenerC3165d.this.f12040L.m12047f()) == null) {
                    return;
                }
                if (i < View$OnClickListenerC3165d.this.f12049U) {
                    i = View$OnClickListenerC3165d.this.f12049U;
                }
                View$OnClickListenerC3165d.this.f12071i.setText(i + "m/s");
                m12047f.setSpeek(i);
                View$OnClickListenerC3165d.this.m9336o();
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12034F = false;
                if (View$OnClickListenerC3165d.this.f12081s.getProgress() * 1.5d < seekBar.getProgress() * seekBar.getProgress()) {
                    int progress = ((int) ((seekBar.getProgress() * seekBar.getProgress()) / 1.5d)) + 1;
                    if (progress < View$OnClickListenerC3165d.this.f12051W) {
                        progress = View$OnClickListenerC3165d.this.f12051W;
                    }
                    View$OnClickListenerC3165d.this.f12081s.setProgress(progress);
                    View$OnClickListenerC3165d.this.f12072j.setText(progress + C0413a.f922b);
                    FlyActionBean m12047f = View$OnClickListenerC3165d.this.f12040L.m12047f();
                    if (m12047f == null) {
                        return;
                    }
                    m12047f.setRidus(progress);
                    View$OnClickListenerC3165d.this.m9367b(m12047f);
                    View$OnClickListenerC3165d.this.m9369a(false);
                }
            }
        });
        this.f12081s.setOnSeekBarChangeListener(new SeekBar.AbstractC3854a() { // from class: com.fimi.soul.module.droneFragment.d.12
            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6786a(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12035G = true;
                View$OnClickListenerC3165d.this.f12038J = ((int) ((View$OnClickListenerC3165d.this.f12080r.getProgress() * View$OnClickListenerC3165d.this.f12080r.getProgress()) / 1.5d)) + 1;
                if (View$OnClickListenerC3165d.this.f12038J < View$OnClickListenerC3165d.this.f12049U) {
                    View$OnClickListenerC3165d.this.f12038J = View$OnClickListenerC3165d.this.f12049U;
                }
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: a */
            public void mo6785a(SeekBar seekBar, int i, boolean z) {
                FlyActionBean m12047f;
                if (!View$OnClickListenerC3165d.this.f12035G || (m12047f = View$OnClickListenerC3165d.this.f12040L.m12047f()) == null) {
                    return;
                }
                if (i <= View$OnClickListenerC3165d.this.f12038J) {
                    i = View$OnClickListenerC3165d.this.f12038J;
                }
                if (i < View$OnClickListenerC3165d.this.f12051W) {
                    i = View$OnClickListenerC3165d.this.f12051W;
                }
                View$OnClickListenerC3165d.this.f12072j.setText(i + C0413a.f922b);
                m12047f.setRidus(i);
                View$OnClickListenerC3165d.this.m9367b(m12047f);
                View$OnClickListenerC3165d.this.m9369a(false);
                View$OnClickListenerC3165d.this.m9336o();
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.SeekBar.AbstractC3854a
            /* renamed from: b */
            public void mo6784b(SeekBar seekBar) {
                View$OnClickListenerC3165d.this.f12035G = false;
                if (View$OnClickListenerC3165d.this.f12081s.getProgress() * 1.5d < seekBar.getProgress() * seekBar.getProgress()) {
                    int sqrt = (int) Math.sqrt(View$OnClickListenerC3165d.this.f12081s.getProgress() * 1.5d);
                    if (sqrt >= View$OnClickListenerC3165d.this.f12048T) {
                        sqrt = View$OnClickListenerC3165d.this.f12048T;
                    }
                    View$OnClickListenerC3165d.this.f12080r.setMax(sqrt);
                    if (View$OnClickListenerC3165d.this.f12080r.getProgress() < sqrt) {
                        return;
                    }
                    View$OnClickListenerC3165d.this.f12080r.setProgress(sqrt);
                    View$OnClickListenerC3165d.this.f12071i.setText(sqrt + "m/s");
                }
            }
        });
        C3658ar.m7598b(this.f12084v.getAssets(), this.f12073k, this.f12070h, this.f12071i, this.f12072j);
        C3658ar.m7612a(this.f12084v.getAssets(), this.f12077o, this.f12078p, this.f12076n, this.f12086x, this.f12087y, this.f12074l, this.f12075m);
        this.f12055a = new EditText[]{this.f12070h, this.f12071i, this.f12072j, this.f12073k};
        for (EditText editText : this.f12055a) {
            editText.setInputType(2);
            editText.clearFocus();
        }
        this.f12070h.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.d.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12070h, View$OnClickListenerC3165d.this.f12047S, View$OnClickListenerC3165d.this.f12046R, View$OnClickListenerC3165d.this.f12079q, C0413a.f922b);
                    return;
                }
                View$OnClickListenerC3165d.this.f12054Z = View$OnClickListenerC3165d.this.f12070h.getText().toString();
                if (View$OnClickListenerC3165d.this.f12054Z.length() <= 0) {
                    return;
                }
                View$OnClickListenerC3165d.this.f12070h.setText(View$OnClickListenerC3165d.this.f12054Z.substring(0, View$OnClickListenerC3165d.this.f12054Z.length() - 1));
            }
        });
        this.f12071i.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.d.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    View$OnClickListenerC3165d.this.f12054Z = View$OnClickListenerC3165d.this.f12071i.getText().toString();
                    if (View$OnClickListenerC3165d.this.f12054Z.length() <= 0) {
                        return;
                    }
                    View$OnClickListenerC3165d.this.f12071i.setText(View$OnClickListenerC3165d.this.f12054Z.substring(0, View$OnClickListenerC3165d.this.f12054Z.length() - 1));
                    return;
                }
                try {
                    int sqrt = (int) Math.sqrt(Integer.parseInt(View$OnClickListenerC3165d.m9363b(View$OnClickListenerC3165d.this.f12072j.getText().toString())) * 1.5d);
                    if (sqrt >= View$OnClickListenerC3165d.this.f12048T) {
                        sqrt = View$OnClickListenerC3165d.this.f12048T;
                    }
                    if (sqrt == 0) {
                        View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12071i, View$OnClickListenerC3165d.this.f12080r.getMax(), View$OnClickListenerC3165d.this.f12049U, View$OnClickListenerC3165d.this.f12080r, "m/s");
                    } else {
                        View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12071i, sqrt, View$OnClickListenerC3165d.this.f12049U, View$OnClickListenerC3165d.this.f12080r, "m/s");
                    }
                } catch (Exception e) {
                }
            }
        });
        this.f12072j.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.d.15
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12072j, View$OnClickListenerC3165d.this.f12081s.getMax(), View$OnClickListenerC3165d.this.f12051W, View$OnClickListenerC3165d.this.f12081s, C0413a.f922b);
                    return;
                }
                View$OnClickListenerC3165d.this.f12054Z = View$OnClickListenerC3165d.this.f12072j.getText().toString();
                if (View$OnClickListenerC3165d.this.f12054Z.length() <= 0) {
                    return;
                }
                View$OnClickListenerC3165d.this.f12072j.setText(View$OnClickListenerC3165d.this.f12054Z.substring(0, View$OnClickListenerC3165d.this.f12054Z.length() - 1));
            }
        });
        this.f12073k.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.module.droneFragment.d.16
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    View$OnClickListenerC3165d.this.m9371a(View$OnClickListenerC3165d.this.f12073k, View$OnClickListenerC3165d.this.f12052X, View$OnClickListenerC3165d.this.f12053Y, View$OnClickListenerC3165d.this.f12082t, "°");
                    return;
                }
                View$OnClickListenerC3165d.this.f12054Z = View$OnClickListenerC3165d.this.f12073k.getText().toString();
                if (View$OnClickListenerC3165d.this.f12054Z.length() <= 0) {
                    return;
                }
                View$OnClickListenerC3165d.this.f12073k.setText(View$OnClickListenerC3165d.this.f12054Z.substring(0, View$OnClickListenerC3165d.this.f12054Z.length() - 1));
            }
        });
        this.f12071i.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.d.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3165d.this.f12071i.hasFocus() || View$OnClickListenerC3165d.this.f12066d.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3165d.this.f12069g.hasMessages(View$OnClickListenerC3165d.this.f12059ad)) {
                    View$OnClickListenerC3165d.this.f12069g.removeMessages(View$OnClickListenerC3165d.this.f12059ad);
                }
                View$OnClickListenerC3165d.this.f12069g.sendEmptyMessageDelayed(View$OnClickListenerC3165d.this.f12059ad, View$OnClickListenerC3165d.this.f12057ab);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3165d.this.f12066d = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f12070h.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.d.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3165d.this.f12070h.hasFocus() || View$OnClickListenerC3165d.this.f12065c.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3165d.this.f12069g.hasMessages(View$OnClickListenerC3165d.this.f12058ac)) {
                    View$OnClickListenerC3165d.this.f12069g.removeMessages(View$OnClickListenerC3165d.this.f12058ac);
                }
                View$OnClickListenerC3165d.this.f12069g.sendEmptyMessageDelayed(View$OnClickListenerC3165d.this.f12058ac, View$OnClickListenerC3165d.this.f12057ab);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3165d.this.f12065c = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f12072j.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.d.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3165d.this.f12072j.hasFocus() || View$OnClickListenerC3165d.this.f12067e.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3165d.this.f12069g.hasMessages(View$OnClickListenerC3165d.this.f12060ae)) {
                    View$OnClickListenerC3165d.this.f12069g.removeMessages(View$OnClickListenerC3165d.this.f12060ae);
                }
                View$OnClickListenerC3165d.this.f12069g.sendEmptyMessageDelayed(View$OnClickListenerC3165d.this.f12060ae, View$OnClickListenerC3165d.this.f12057ab);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3165d.this.f12067e = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f12073k.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!View$OnClickListenerC3165d.this.f12073k.hasFocus() || View$OnClickListenerC3165d.this.f12068f.equals(editable.toString())) {
                    return;
                }
                if (View$OnClickListenerC3165d.this.f12069g.hasMessages(View$OnClickListenerC3165d.this.f12061af)) {
                    View$OnClickListenerC3165d.this.f12069g.removeMessages(View$OnClickListenerC3165d.this.f12061af);
                }
                View$OnClickListenerC3165d.this.f12069g.sendEmptyMessageDelayed(View$OnClickListenerC3165d.this.f12061af, View$OnClickListenerC3165d.this.f12057ab);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                View$OnClickListenerC3165d.this.f12068f = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f12056aa = new SeekBar[]{this.f12079q, this.f12080r, this.f12081s, this.f12082t};
        for (SeekBar seekBar : this.f12056aa) {
            seekBar.setOnTouchListener(this);
        }
    }

    /* renamed from: a */
    private Point m9381a(double d) {
        FlyActionBean m12047f = this.f12040L.m12047f();
        this.f12043O = this.f12037I.m11323ai();
        if (m12047f == null || this.f12043O == null) {
            return null;
        }
        float ridus = (this.f12084v.getResources().getDisplayMetrics().density * m12047f.getRidus()) / this.f12043O.getScalePerPixel();
        Point screenLocation = this.f12043O.getProjection().toScreenLocation(m12047f.getLatLng());
        return new Point(((int) (ridus * Math.sin(d))) + screenLocation.x, (-((int) (ridus * Math.cos(d)))) + screenLocation.y);
    }

    /* renamed from: a */
    private void m9380a(EditText editText) {
        if (editText.getText().toString().length() > 0) {
            if (this.f12070h == editText) {
                this.f12070h.setSelection(this.f12070h.length() - 1);
            } else if (this.f12071i == editText && this.f12071i.length() > 3) {
                this.f12071i.setSelection(this.f12071i.length() - 3);
            } else if (this.f12072j == editText) {
                this.f12072j.setSelection(this.f12072j.length() - 1);
            } else if (this.f12073k != editText) {
            } else {
                this.f12073k.setSelection(this.f12073k.length() - 1);
            }
        }
    }

    /* renamed from: a */
    private void m9377a(FlyActionBean flyActionBean, AMap aMap, boolean z) {
        LatLng m9378a = z ? m9378a(flyActionBean, flyActionBean.getStart_point_agle()) : m9378a(flyActionBean, -flyActionBean.getStart_point_agle());
        if (this.f12041M == null) {
            this.f12041M = aMap.addMarker(new MarkerOptions().position(m9378a).icon(C2479j.m12014a(C2300R.C2301drawable.icn_rotate_point)));
            this.f12041M.setZIndex(10000.0f);
            this.f12041M.setAnchor(0.5f, 0.5f);
            this.f12041M.setDraggable(false);
            this.f12041M.setRotateAngle(m9334p());
        } else {
            this.f12041M.setPosition(m9378a);
            this.f12041M.setRotateAngle(m9334p());
        }
        m9344k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9371a(MyEditView myEditView, int i, int i2, SeekBar seekBar, String str) {
        String str2;
        try {
            myEditView.setCursorVisible(false);
            String m9370a = m9370a(m9363b(myEditView.getText().toString()));
            int parseInt = Integer.parseInt(m9370a);
            if (parseInt > i) {
                str2 = i + str;
                myEditView.setText(str2);
            } else if (parseInt < i2) {
                str2 = i2 + str;
                myEditView.setText(str2);
                i = i2;
            } else {
                i = parseInt;
                str2 = m9370a;
            }
            seekBar.setProgress(Integer.valueOf(i).intValue());
            if (!str2.contains(str)) {
                myEditView.setText(str2 + str);
            }
            m9380a(myEditView);
            FlyActionBean m12047f = this.f12040L.m12047f();
            if (seekBar == this.f12082t) {
                m12047f.setStart_point_agle((short) i);
                m9369a(false);
            } else if (seekBar == this.f12080r) {
                m12047f.setSpeek(i);
                m9336o();
            } else if (seekBar == this.f12079q) {
                m12047f.setHeight(i);
                Iterator<Marker> it2 = C2472d.m12036p().m12043i().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Marker next = it2.next();
                    if (next.getObject().equals(m12047f)) {
                        next.setIcon(C2479j.m12013a(this.f12084v, m12047f.getDrawableRes(), m12047f.getHeight(), true));
                        break;
                    }
                }
            } else if (seekBar == this.f12081s) {
                m12047f.setRidus(i);
                m9367b(m12047f);
                m9369a(false);
                m9336o();
            }
            myEditView.setCursorVisible(true);
        } catch (Exception e) {
            myEditView.setText(this.f12054Z + str);
            m9380a(myEditView);
            myEditView.setCursorVisible(true);
        }
    }

    /* renamed from: b */
    public static String m9363b(String str) {
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    /* renamed from: b */
    private void m9366b(FlyActionBean flyActionBean, AMap aMap, boolean z) {
        LatLng m9378a = z ? m9378a(flyActionBean, flyActionBean.getStart_point_agle() + 90) : m9378a(flyActionBean, 270 - flyActionBean.getStart_point_agle());
        if (this.f12042N != null) {
            this.f12042N.setPosition(m9378a);
            if (z) {
                this.f12042N.setRotateAngle(((-flyActionBean.getStart_point_agle()) - 180) + m9334p());
                return;
            } else {
                this.f12042N.setRotateAngle((flyActionBean.getStart_point_agle() - 180) + m9334p());
                return;
            }
        }
        this.f12042N = aMap.addMarker(new MarkerOptions().position(m9378a).icon(C2479j.m12014a(C2300R.C2301drawable.icon_fly_direction)));
        this.f12042N.setZIndex(10000.0f);
        if (z) {
            this.f12042N.setRotateAngle(((-flyActionBean.getStart_point_agle()) - 180) + aMap.getCameraPosition().bearing);
        } else {
            this.f12042N.setRotateAngle((flyActionBean.getStart_point_agle() - 180) + aMap.getCameraPosition().bearing);
        }
        this.f12042N.setAnchor(0.5f, 0.5f);
    }

    /* renamed from: k */
    private void m9344k() {
        FlyActionBean m12047f = C2472d.m12036p().m12047f();
        if (this.f12041M == null || m12047f == null) {
            return;
        }
        if (this.f12044P == null) {
            this.f12044P = this.f12043O.addPolyline(new PolylineOptions().add(this.f12041M.getPosition(), m12047f.getLatLng()).color(this.f12037I.f9270d.getResources().getColor(C2300R.color.ridus_color)).width(4.0f));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(m12047f.getLatLng());
        arrayList.add(this.f12041M.getPosition());
        this.f12044P.setPoints(arrayList);
    }

    /* renamed from: l */
    private double m9342l() {
        C3639ai m7726a = C3633ac.m7726a(this.f12037I.mo11201x().m10612b(), this.f12037I.mo11201x().m10611c());
        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        C3639ai m7726a2 = C3633ac.m7726a(this.f12037I.mo11202w().m10499f(), this.f12037I.mo11202w().m10500e());
        return C3632ab.m7729c(latLng, new LatLng(m7726a2.m7702a(), m7726a2.m7700b())).m7698a();
    }

    /* renamed from: m */
    private void m9340m() {
        if (this.f12031C != null) {
            if (this.f12031C.isShowing()) {
                this.f12031C.dismiss();
                this.f12088z.setBackgroundResource(C2300R.C2301drawable.bg_fly_combobox_more_down);
                return;
            }
            this.f12088z.setBackgroundResource(C2300R.C2301drawable.bg_fly_combobox_more_up);
            this.f12031C.showAsDropDown(this.f12088z, 0, C3678g.m7486b(this.f12084v, -8.0f));
            return;
        }
        this.f12088z.setBackgroundResource(C2300R.C2301drawable.bg_fly_combobox_more_up);
        View inflate = LayoutInflater.from(this.f12084v).inflate(C2300R.layout.myspinner_item, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(C2300R.C2302id.list_head_angle);
        listView.setAdapter((ListAdapter) new C3182a(this.f12084v, this.f12032D));
        listView.setSelection(1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.fimi.soul.module.droneFragment.d.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                FlyActionBean m12047f = C2472d.m12036p().m12047f();
                View$OnClickListenerC3165d.this.f12088z.setText((String) adapterView.getItemAtPosition(i));
                if (m12047f != null) {
                    m12047f.setYaw_mode(i);
                }
                View$OnClickListenerC3165d.this.f12031C.dismiss();
                View$OnClickListenerC3165d.this.f12088z.setBackgroundResource(C2300R.C2301drawable.bg_fly_combobox_more_down);
            }
        });
        this.f12031C = new PopupWindow(listView, this.f12088z.getWidth(), this.f12088z.getHeight() * 4);
        this.f12031C.setContentView(inflate);
        this.f12031C.showAsDropDown(this.f12088z, 0, C3678g.m7486b(this.f12084v, -8.0f));
        this.f12031C.setOutsideTouchable(true);
        this.f12031C.setTouchable(true);
        this.f12031C.setFocusable(true);
        this.f12031C.setBackgroundDrawable(new BitmapDrawable());
        this.f12031C.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.fimi.soul.module.droneFragment.d.8
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                View$OnClickListenerC3165d.this.f12088z.setBackgroundResource(C2300R.C2301drawable.bg_fly_combobox_more_down);
            }
        });
    }

    /* renamed from: n */
    private void m9338n() {
        this.f12085w.getWidth();
        FlyActionBean m12047f = this.f12040L.m12047f();
        int i = this.f12084v.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.f12084v.getResources().getDisplayMetrics().heightPixels;
        AMap m11323ai = this.f12037I.m11323ai();
        if (m11323ai != null) {
            Point screenLocation = m11323ai.getProjection().toScreenLocation(m12047f.getLatLng());
            if (screenLocation.x > i / 2) {
                m11323ai.moveCamera(CameraUpdateFactory.changeLatLng(m11323ai.getProjection().fromScreenLocation(new Point((i / 2) + (screenLocation.x - (i / 3)), i2 / 2))));
            }
        }
        m9367b(m12047f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m9336o() {
        FlyActionBean m12047f = C2472d.m12036p().m12047f();
        if (this.f12039K == null || m12047f == null) {
            return;
        }
        this.f12074l.setText(String.format(this.f12084v.getString(C2300R.C2303string.spend_timereminder), Integer.valueOf((int) (((this.f12039K.getRadius() * 2.0d) * 3.141592653589793d) / m12047f.getSpeek()))));
    }

    /* renamed from: p */
    private synchronized float m9334p() {
        float f = 0.0f;
        synchronized (this) {
            try {
                CameraPosition cameraPosition = this.f12043O.getCameraPosition();
                if (cameraPosition != null) {
                    f = cameraPosition.bearing;
                }
            } catch (Exception e) {
            }
        }
        return f;
    }

    /* renamed from: a */
    public LatLng m9378a(FlyActionBean flyActionBean, double d) {
        if (flyActionBean == null || this.f12039K == null) {
            return null;
        }
        return C3632ab.m7733a(flyActionBean.getLatLng(), d, this.f12039K.getRadius());
    }

    /* renamed from: a */
    public String m9370a(String str) {
        return BigDecimal.valueOf(Integer.parseInt(str)).stripTrailingZeros().toPlainString();
    }

    /* renamed from: a */
    public void m9382a() {
        if (!this.f12030B.isShown()) {
            this.f12030B.setVisibility(0);
            C2284z.m12696a(this.f12084v, (int) C2300R.C2303string.set_poi_tip, 1500);
        }
    }

    /* renamed from: a */
    public void m9379a(FlyActionBean flyActionBean) {
        if (this.f12088z.getText().toString().equals(this.f12032D[0])) {
            flyActionBean.setYaw_mode(0);
        } else if (this.f12088z.getText().toString().equals(this.f12032D[1])) {
            flyActionBean.setYaw_mode(1);
        } else if (this.f12088z.getText().toString().equals(this.f12032D[2])) {
            flyActionBean.setYaw_mode(2);
        } else if (this.f12088z.getText().toString().equals(this.f12032D[3])) {
            flyActionBean.setYaw_mode(3);
        } else if (this.f12088z.getText().toString().equals(this.f12032D[4])) {
            flyActionBean.setYaw_mode(4);
        }
        switch (this.f12083u.getCheckedRadioButtonId()) {
            case C2300R.C2302id.clockwise /* 2131493464 */:
                flyActionBean.setPara1(3);
                break;
            case C2300R.C2302id.anticlockwise /* 2131493465 */:
                flyActionBean.setPara1(1);
                break;
        }
        m9354f();
        m9336o();
    }

    /* renamed from: a */
    public void m9369a(boolean z) {
        FlyActionBean m12047f = this.f12040L.m12047f();
        this.f12043O = this.f12037I.m11323ai();
        if (m12047f == null || this.f12043O == null) {
            return;
        }
        switch (this.f12083u.getCheckedRadioButtonId()) {
            case C2300R.C2302id.clockwise /* 2131493464 */:
                if (!z) {
                    m9377a(m12047f, this.f12043O, true);
                }
                m9366b(m12047f, this.f12043O, true);
                return;
            case C2300R.C2302id.anticlockwise /* 2131493465 */:
                if (!z) {
                    m9377a(m12047f, this.f12043O, false);
                }
                m9366b(m12047f, this.f12043O, false);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m9368b() {
        if (this.f12085w.isShown()) {
            this.f12085w.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void m9367b(FlyActionBean flyActionBean) {
        this.f12043O = this.f12037I.m11323ai();
        if (this.f12043O == null || flyActionBean == null) {
            return;
        }
        if (this.f12039K != null) {
            this.f12039K.setRadius(flyActionBean.getRidus());
            return;
        }
        this.f12039K = this.f12043O.addCircle(new CircleOptions().radius(flyActionBean.getRidus()).strokeWidth(4.0f).strokeColor(this.f12084v.getResources().getColor(C2300R.color.ridus_color)).center(this.f12040L.m12047f().getLatLng()));
        this.f12040L.m12063a(this.f12039K);
    }

    /* renamed from: c */
    public void m9362c() {
        if (!this.f12085w.isShown()) {
            this.f12085w.setVisibility(0);
        }
    }

    /* renamed from: d */
    public void m9359d() {
        m9368b();
        if (this.f12031C != null && this.f12031C.isShowing()) {
            this.f12031C.dismiss();
            this.f12088z.setBackgroundResource(C2300R.C2301drawable.bg_fly_combobox_more_down);
        }
        if (this.f12039K != null) {
            this.f12039K.remove();
            this.f12039K = null;
        }
        if (this.f12041M != null) {
            this.f12041M.destroy();
            this.f12041M = null;
        }
        if (this.f12042N != null) {
            this.f12042N.destroy();
            this.f12042N = null;
        }
        if (this.f12044P != null) {
            this.f12044P.remove();
            this.f12044P = null;
        }
    }

    /* renamed from: e */
    public void m9356e() {
        if (this.f12030B.isShown()) {
            this.f12030B.setVisibility(8);
        }
    }

    /* renamed from: f */
    public void m9354f() {
        if (this.f12086x.isChecked()) {
            this.f12086x.setTextColor(this.f12084v.getResources().getColor(C2300R.color.color_height));
            this.f12087y.setTextColor(this.f12084v.getResources().getColor(C2300R.color.black));
            return;
        }
        this.f12087y.setTextColor(this.f12084v.getResources().getColor(C2300R.color.color_height));
        this.f12086x.setTextColor(this.f12084v.getResources().getColor(C2300R.color.black));
    }

    /* renamed from: g */
    public void m9352g() {
        m9362c();
        m9338n();
        m9350h();
    }

    /* renamed from: h */
    public void m9350h() {
        FlyActionBean m12047f = C2472d.m12036p().m12047f();
        if (m12047f != null) {
            double m9342l = m9342l();
            if (this.f12050V - m9342l < this.f12051W) {
                C2284z.m12696a(this.f12084v, (int) C2300R.C2303string.cant_setPoi, 3000);
                return;
            }
            this.f12079q.setProgress(m12047f.getHeight());
            this.f12080r.setProgress(m12047f.getSpeek());
            this.f12081s.setProgress(m12047f.getRidus());
            this.f12082t.setProgress(m12047f.getStart_point_agle());
            this.f12081s.setMax((int) (this.f12050V - m9342l));
            this.f12070h.setText(m12047f.getHeight() + C0413a.f922b);
            this.f12071i.setText(m12047f.getSpeek() + "m/s");
            this.f12072j.setText(m12047f.getRidus() + C0413a.f922b);
            this.f12073k.setText(((int) m12047f.getStart_point_agle()) + "°");
            if (m12047f.getPara1() == 0 || m12047f.getPara1() == 1) {
                this.f12083u.check(this.f12087y.getId());
            } else if (m12047f.getPara1() == 2 || m12047f.getPara1() == 3) {
                this.f12083u.check(this.f12086x.getId());
            }
            m9379a(m12047f);
            m9369a(false);
            m9344k();
        }
    }

    /* renamed from: i */
    public synchronized void m9348i() {
        double d = 0.0d;
        synchronized (this) {
            FlyActionBean m12047f = C2472d.m12036p().m12047f();
            if (this.f12039K != null && this.f12041M != null && m12047f != null) {
                m12047f.setRidus((int) C3632ab.m7729c(m12047f.getLatLng(), this.f12041M.getPosition()).m7698a());
                m9367b(m12047f);
                LatLng m9378a = m9378a(m12047f, 0.0d);
                switch (this.f12083u.getCheckedRadioButtonId()) {
                    case C2300R.C2302id.clockwise /* 2131493464 */:
                        d = C3632ab.m7728d(m9378a, this.f12041M.getPosition());
                        break;
                    case C2300R.C2302id.anticlockwise /* 2131493465 */:
                        d = this.f12052X - C3632ab.m7728d(m9378a, this.f12041M.getPosition());
                        break;
                }
                m12047f.setStart_point_agle((short) d);
                this.f12073k.setText(((int) d) + "deg");
                m9369a(false);
            }
        }
    }

    /* renamed from: j */
    public void m9346j() {
        if (this.f12031C == null || !this.f12031C.isShowing()) {
            return;
        }
        this.f12031C.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.myspinner /* 2131493461 */:
                m9340m();
                return;
            case C2300R.C2302id.delete_poi /* 2131493467 */:
                m9359d();
                this.f12037I.mo11220a(C2678d.EnumC2679a.CLEARDATA);
                m9382a();
                return;
            case C2300R.C2302id.setPoi /* 2131493468 */:
                this.f12037I.mo11220a(C2678d.EnumC2679a.CREATEPOI);
                this.f12030B.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f12062ah = motionEvent.getX();
                this.f12063ai = motionEvent.getY();
                break;
            case 1:
                view.getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                if (Math.abs(view.getX() - this.f12062ah) >= Math.abs(view.getY() - this.f12063ai)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return false;
    }
}
