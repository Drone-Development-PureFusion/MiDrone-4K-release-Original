package com.fimi.soul.module.p206a;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.view.horizontallistview.C3827a;
import com.fimi.soul.view.horizontallistview.HorizontalListView;
import com.fimi.soul.view.marknumberprogress.AbstractC3845b;
import com.fimi.soul.view.marknumberprogress.EvProgressBar;
import com.fimi.soul.view.marknumberprogress.SaturationContrastProgressBar;
import com.fimi.soul.view.wheelview.WheelView;
/* renamed from: com.fimi.soul.module.a.c */
/* loaded from: classes.dex */
public class View$OnClickListenerC3037c implements View.OnClickListener, AdapterView.OnItemClickListener, WheelView.AbstractC3884a {

    /* renamed from: A */
    private ImageView f11314A;

    /* renamed from: B */
    private AbstractC3045a f11315B;

    /* renamed from: C */
    private boolean f11316C;

    /* renamed from: D */
    private int f11317D;

    /* renamed from: E */
    private int f11318E;

    /* renamed from: F */
    private int[] f11319F;

    /* renamed from: H */
    private boolean f11321H;

    /* renamed from: a */
    private Resources f11324a;

    /* renamed from: b */
    private View f11325b;

    /* renamed from: c */
    private EvProgressBar f11326c;

    /* renamed from: d */
    private SaturationContrastProgressBar f11327d;

    /* renamed from: e */
    private SaturationContrastProgressBar f11328e;

    /* renamed from: f */
    private String[] f11329f;

    /* renamed from: g */
    private String[] f11330g;

    /* renamed from: h */
    private String[] f11331h;

    /* renamed from: i */
    private String[] f11332i;

    /* renamed from: j */
    private String[] f11333j;

    /* renamed from: m */
    private String[] f11336m;

    /* renamed from: n */
    private TextView f11337n;

    /* renamed from: p */
    private LinearLayout f11339p;

    /* renamed from: q */
    private TextView f11340q;

    /* renamed from: r */
    private RelativeLayout f11341r;

    /* renamed from: s */
    private TextView f11342s;

    /* renamed from: t */
    private LinearLayout f11343t;

    /* renamed from: u */
    private LinearLayout f11344u;

    /* renamed from: v */
    private TextView f11345v;

    /* renamed from: w */
    private RelativeLayout f11346w;

    /* renamed from: x */
    private HorizontalListView f11347x;

    /* renamed from: y */
    private C3827a f11348y;

    /* renamed from: z */
    private ImageView f11349z;

    /* renamed from: k */
    private View[] f11334k = new View[5];

    /* renamed from: l */
    private String[][] f11335l = new String[5];

    /* renamed from: o */
    private String f11338o = "";

    /* renamed from: G */
    private int[] f11320G = {6, 64, 64, 0, 0};

    /* renamed from: I */
    private int f11322I = -1;

    /* renamed from: J */
    private Handler f11323J = new Handler() { // from class: com.fimi.soul.module.a.c.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (View$OnClickListenerC3037c.this.f11341r != null) {
                View$OnClickListenerC3037c.this.f11341r.setVisibility(4);
                View$OnClickListenerC3037c.this.f11339p.setVisibility(4);
            }
            if (View$OnClickListenerC3037c.this.f11315B != null) {
                View$OnClickListenerC3037c.this.f11315B.mo9861a(0);
            }
            View$OnClickListenerC3037c.this.f11316C = false;
        }
    };

    /* renamed from: com.fimi.soul.module.a.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC3045a {
        /* renamed from: a */
        void mo9861a(int i);

        /* renamed from: a */
        void mo9860a(int i, String str);

        /* renamed from: a */
        void mo9859a(int i, String str, String str2);

        /* renamed from: a */
        void mo9858a(int i, boolean z);

        /* renamed from: a */
        void mo9856a(String[] strArr);
    }

    public View$OnClickListenerC3037c(View view, boolean z) {
        this.f11325b = view;
        this.f11321H = z;
        this.f11324a = view.getResources();
        this.f11317D = this.f11324a.getColor(C2300R.color.camera_menu_item_text_color_def);
        this.f11318E = this.f11324a.getColor(C2300R.color.white);
        m9902a();
        m9871l();
    }

    /* renamed from: l */
    private void m9871l() {
        this.f11326c.setOnProgressBarListener(new AbstractC3845b() { // from class: com.fimi.soul.module.a.c.4
            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: a */
            public void mo6857a(int i) {
                View$OnClickListenerC3037c.this.m9901a(i);
            }

            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: a */
            public void mo6856a(int i, int i2) {
                View$OnClickListenerC3037c.this.m9897a("" + View$OnClickListenerC3037c.this.f11335l[0][i]);
                if (View$OnClickListenerC3037c.this.f11315B != null) {
                    String str = View$OnClickListenerC3037c.this.f11335l[0][i];
                    View$OnClickListenerC3037c.this.f11315B.mo9859a(0, View$OnClickListenerC3037c.this.f11335l[0][i], str.equals("0.0") ? " " + str + " EV" : str + " EV");
                    View$OnClickListenerC3037c.this.m9874i();
                }
            }

            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: b */
            public void mo6855b(int i, int i2) {
                if (View$OnClickListenerC3037c.this.f11315B == null || View$OnClickListenerC3037c.this.f11315B == null) {
                    return;
                }
                String str = View$OnClickListenerC3037c.this.f11335l[0][i];
                View$OnClickListenerC3037c.this.f11315B.mo9860a(0, str.equals("0.0") ? " " + str + " EV" : str + " EV");
            }
        });
        this.f11328e.setOnProgressBarListener(new AbstractC3845b() { // from class: com.fimi.soul.module.a.c.5
            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: a */
            public void mo6857a(int i) {
                View$OnClickListenerC3037c.this.m9901a(i);
            }

            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: a */
            public void mo6856a(int i, int i2) {
                View$OnClickListenerC3037c.this.m9897a("" + (i - 64));
                if (View$OnClickListenerC3037c.this.f11315B != null) {
                    View$OnClickListenerC3037c.this.f11315B.mo9859a(1, "" + (i - 64), "" + i);
                    View$OnClickListenerC3037c.this.m9874i();
                }
            }

            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: b */
            public void mo6855b(int i, int i2) {
                if (View$OnClickListenerC3037c.this.f11315B != null) {
                    View$OnClickListenerC3037c.this.f11315B.mo9860a(1, "" + i);
                }
            }
        });
        this.f11327d.setOnProgressBarListener(new AbstractC3845b() { // from class: com.fimi.soul.module.a.c.6
            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: a */
            public void mo6857a(int i) {
                View$OnClickListenerC3037c.this.m9901a(i);
            }

            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: a */
            public void mo6856a(int i, int i2) {
                View$OnClickListenerC3037c.this.m9897a("" + (i - 64));
                if (View$OnClickListenerC3037c.this.f11315B != null) {
                    View$OnClickListenerC3037c.this.f11315B.mo9859a(2, "" + (i - 64), "" + i);
                    View$OnClickListenerC3037c.this.m9874i();
                }
            }

            @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
            /* renamed from: b */
            public void mo6855b(int i, int i2) {
                if (View$OnClickListenerC3037c.this.f11315B != null) {
                    View$OnClickListenerC3037c.this.f11315B.mo9860a(2, "" + i);
                }
            }
        });
        this.f11345v.setOnClickListener(this);
        this.f11342s.setOnClickListener(this);
    }

    /* renamed from: a */
    public void m9902a() {
        this.f11341r = (RelativeLayout) this.f11325b.findViewById(C2300R.C2302id.rl_items);
        this.f11339p = (LinearLayout) this.f11325b.findViewById(C2300R.C2302id.ll_info);
        this.f11337n = (TextView) this.f11325b.findViewById(C2300R.C2302id.tv_info);
        this.f11340q = (TextView) this.f11325b.findViewById(C2300R.C2302id.tv_info_value);
        View[] viewArr = this.f11334k;
        EvProgressBar evProgressBar = (EvProgressBar) this.f11325b.findViewById(C2300R.C2302id.mEvProgressBar);
        this.f11326c = evProgressBar;
        viewArr[0] = evProgressBar;
        if (this.f11321H) {
            this.f11341r.setVisibility(4);
            this.f11339p.setVisibility(4);
            this.f11326c.setVisibility(8);
        }
        View[] viewArr2 = this.f11334k;
        SaturationContrastProgressBar saturationContrastProgressBar = (SaturationContrastProgressBar) this.f11325b.findViewById(C2300R.C2302id.mStaturationBar);
        this.f11328e = saturationContrastProgressBar;
        viewArr2[1] = saturationContrastProgressBar;
        View[] viewArr3 = this.f11334k;
        SaturationContrastProgressBar saturationContrastProgressBar2 = (SaturationContrastProgressBar) this.f11325b.findViewById(C2300R.C2302id.mContrastBar);
        this.f11327d = saturationContrastProgressBar2;
        viewArr3[2] = saturationContrastProgressBar2;
        View[] viewArr4 = this.f11334k;
        LinearLayout linearLayout = (LinearLayout) this.f11325b.findViewById(C2300R.C2302id.sharpan_ly);
        this.f11344u = linearLayout;
        viewArr4[3] = linearLayout;
        this.f11345v = (TextView) this.f11325b.findViewById(C2300R.C2302id.sharpan_normal);
        this.f11342s = (TextView) this.f11325b.findViewById(C2300R.C2302id.sharpan_hight);
        this.f11347x = (HorizontalListView) this.f11325b.findViewById(C2300R.C2302id.whitebalance_horizon_listview);
        this.f11346w = (RelativeLayout) this.f11325b.findViewById(C2300R.C2302id.whitebalance_rl);
        this.f11334k[4] = this.f11346w;
        String[][] strArr = this.f11335l;
        String[] stringArray = this.f11324a.getStringArray(C2300R.array.ev);
        this.f11329f = stringArray;
        strArr[0] = stringArray;
        this.f11326c.setMax(this.f11329f.length - 1);
        String[][] strArr2 = this.f11335l;
        String[] stringArray2 = this.f11324a.getStringArray(C2300R.array.saturation);
        this.f11330g = stringArray2;
        strArr2[1] = stringArray2;
        String[][] strArr3 = this.f11335l;
        String[] stringArray3 = this.f11324a.getStringArray(C2300R.array.contrast);
        this.f11331h = stringArray3;
        strArr3[2] = stringArray3;
        String[][] strArr4 = this.f11335l;
        String[] stringArray4 = this.f11324a.getStringArray(C2300R.array.sharpan);
        this.f11332i = stringArray4;
        strArr4[3] = stringArray4;
        this.f11345v.setText(this.f11332i[0]);
        this.f11342s.setText(this.f11332i[1]);
        String[][] strArr5 = this.f11335l;
        String[] stringArray5 = this.f11324a.getStringArray(C2300R.array.whitebalance);
        this.f11333j = stringArray5;
        strArr5[4] = stringArray5;
        this.f11336m = this.f11324a.getStringArray(C2300R.array.cmd_whitebalance);
        m9894b();
        this.f11338o = this.f11324a.getString(C2300R.C2303string.camera_menu_ev);
    }

    /* renamed from: a */
    public void m9901a(int i) {
        if (this.f11315B != null) {
            if (i == 0) {
                this.f11315B.mo9861a(4);
            } else if (i != 1) {
            } else {
                this.f11315B.mo9861a(0);
            }
        }
    }

    @Override // com.fimi.soul.view.wheelview.WheelView.AbstractC3884a
    /* renamed from: a */
    public void mo6674a(int i, Object obj) {
        if (this.f11322I == i) {
            return;
        }
        this.f11322I = i;
        this.f11339p.setVisibility(0);
        this.f11338o = ((C3046d) obj).m9870a();
        m9889c(i - 1);
        if (this.f11315B != null) {
            if (i == this.f11320G.length) {
                this.f11315B.mo9858a(i - 1, true);
            } else {
                this.f11315B.mo9858a(i - 1, false);
            }
        }
        if (i != 4) {
            return;
        }
        this.f11347x.m6950a(this.f11348y.m6930a(), this.f11348y.getCount());
    }

    /* renamed from: a */
    public void m9900a(AbstractC3045a abstractC3045a) {
        this.f11315B = abstractC3045a;
    }

    /* renamed from: a */
    public void m9897a(String str) {
        this.f11337n.setText(this.f11338o + " : ");
        this.f11340q.setText(str);
    }

    /* renamed from: a */
    public void m9896a(int[] iArr) {
        this.f11319F = iArr;
        if (!this.f11321H) {
            this.f11326c.setProgress(iArr[0]);
        }
        m9897a(this.f11329f[iArr[0]]);
        this.f11328e.setProgress(iArr[1]);
        this.f11327d.setProgress(iArr[2]);
        switch (iArr[3]) {
            case 0:
                this.f11345v.setSelected(true);
                this.f11342s.setSelected(false);
                this.f11345v.setTextColor(this.f11318E);
                this.f11342s.setTextColor(this.f11317D);
                break;
            case 1:
                this.f11345v.setSelected(false);
                this.f11342s.setSelected(true);
                this.f11345v.setTextColor(this.f11317D);
                this.f11342s.setTextColor(this.f11318E);
                break;
        }
        this.f11348y.m6929a(iArr[4]);
        this.f11348y.notifyDataSetChanged();
    }

    /* renamed from: a */
    public int[] m9895a(String[] strArr) {
        int[] iArr = new int[5];
        for (int i = 0; i < strArr.length; i++) {
            switch (i) {
                case 0:
                    iArr[i] = m9891b(strArr[i]);
                    break;
                case 1:
                    iArr[i] = m9887c(strArr[i]);
                    break;
                case 2:
                    iArr[i] = m9884d(strArr[i]);
                    break;
                case 3:
                    iArr[i] = m9881e(strArr[i]);
                    break;
                case 4:
                    iArr[i] = m9878f(strArr[i]);
                    break;
            }
        }
        return iArr;
    }

    /* renamed from: b */
    public int m9893b(int i) {
        switch (i) {
            case 0:
                return this.f11326c.getProgress();
            case 1:
                return this.f11328e.getProgress();
            case 2:
                return this.f11327d.getProgress();
            case 3:
            default:
                return 0;
            case 4:
                return this.f11348y.m6930a();
        }
    }

    /* renamed from: b */
    public int m9891b(String str) {
        if (str == null) {
            return 6;
        }
        if (str != null && str.equals("unknown")) {
            return 6;
        }
        int i = 0;
        while (true) {
            if (i >= this.f11329f.length) {
                i = 6;
                break;
            } else if (str.contains(this.f11329f[i])) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public void m9894b() {
        this.f11349z = (ImageView) this.f11325b.findViewById(C2300R.C2302id.bt_sliding_left);
        this.f11349z.setVisibility(8);
        this.f11314A = (ImageView) this.f11325b.findViewById(C2300R.C2302id.bt_sliding_right);
        this.f11348y = new C3827a(this.f11325b.getContext(), this.f11333j);
        this.f11347x.setAdapter((ListAdapter) this.f11348y);
        this.f11347x.setOnChangeListener(new HorizontalListView.AbstractC3825a() { // from class: com.fimi.soul.module.a.c.1
            @Override // com.fimi.soul.view.horizontallistview.HorizontalListView.AbstractC3825a
            /* renamed from: a */
            public void mo6932a() {
                View$OnClickListenerC3037c.this.m9874i();
            }
        });
        this.f11347x.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.fimi.soul.module.a.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                View$OnClickListenerC3037c.this.f11348y.m6929a(i);
                View$OnClickListenerC3037c.this.f11348y.notifyDataSetChanged();
                String str = View$OnClickListenerC3037c.this.f11335l[4][i];
                View$OnClickListenerC3037c.this.m9897a("" + str);
                if (View$OnClickListenerC3037c.this.f11315B != null) {
                    View$OnClickListenerC3037c.this.f11315B.mo9859a(4, str, View$OnClickListenerC3037c.this.f11336m[i]);
                    View$OnClickListenerC3037c.this.f11315B.mo9860a(4, View$OnClickListenerC3037c.this.f11336m[i]);
                }
            }
        });
        this.f11347x.setOnListViewGuide(new HorizontalListView.AbstractC3826b() { // from class: com.fimi.soul.module.a.c.3
            @Override // com.fimi.soul.view.horizontallistview.HorizontalListView.AbstractC3826b
            /* renamed from: a */
            public void mo6931a(int i) {
                if (i == 0) {
                    View$OnClickListenerC3037c.this.f11314A.setVisibility(0);
                    View$OnClickListenerC3037c.this.f11349z.setVisibility(8);
                } else if (i == 1) {
                    View$OnClickListenerC3037c.this.f11314A.setVisibility(0);
                    View$OnClickListenerC3037c.this.f11349z.setVisibility(0);
                } else if (i != 2) {
                } else {
                    View$OnClickListenerC3037c.this.f11314A.setVisibility(8);
                    View$OnClickListenerC3037c.this.f11349z.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: c */
    public int m9887c(String str) {
        if (str == null || str == null || str.equals("unknown")) {
            return 64;
        }
        return Integer.parseInt(str);
    }

    /* renamed from: c */
    public void m9890c() {
        if (!this.f11321H) {
            this.f11326c.setProgress(this.f11320G[0]);
        }
        this.f11328e.setProgress(this.f11320G[1]);
        this.f11327d.setProgress(this.f11320G[2]);
        switch (this.f11320G[3]) {
            case 0:
                this.f11345v.setSelected(true);
                this.f11342s.setSelected(false);
                this.f11345v.setTextColor(this.f11318E);
                this.f11342s.setTextColor(this.f11317D);
                break;
            case 1:
                this.f11345v.setSelected(false);
                this.f11342s.setSelected(true);
                this.f11345v.setTextColor(this.f11317D);
                this.f11342s.setTextColor(this.f11318E);
                break;
        }
        this.f11348y.m6929a(this.f11320G[4]);
        this.f11348y.notifyDataSetChanged();
        m9889c(4);
    }

    /* renamed from: c */
    public void m9889c(int i) {
        if (this.f11341r.getVisibility() != 0) {
            this.f11341r.setVisibility(0);
        }
        for (int i2 = 0; i2 < this.f11334k.length; i2++) {
            if (i != i2) {
                this.f11334k[i2].setVisibility(4);
            } else if (i != 0 || !this.f11321H) {
                this.f11334k[i2].setVisibility(0);
                switch (i) {
                    case 0:
                        m9897a("" + this.f11335l[i2][m9893b(i2)]);
                        break;
                    case 1:
                        m9897a("" + (m9893b(i2) - 64));
                    case 2:
                        m9897a("" + (m9893b(i2) - 64));
                        break;
                    case 3:
                        m9897a("" + this.f11335l[i2][m9880f()]);
                        break;
                    case 4:
                        m9897a("" + this.f11335l[i2][m9893b(i2)]);
                        break;
                }
            } else {
                this.f11339p.setVisibility(4);
                this.f11341r.setVisibility(4);
            }
        }
    }

    /* renamed from: d */
    public int m9884d(String str) {
        if (str == null || str == null || str.equals("unknown")) {
            return 64;
        }
        return Integer.parseInt(str);
    }

    /* renamed from: d */
    public String[] m9886d() {
        String[] strArr = new String[this.f11320G.length];
        if (this.f11321H) {
            strArr[0] = this.f11329f[this.f11319F[0]];
        } else {
            strArr[0] = this.f11329f[this.f11320G[0]];
        }
        strArr[1] = "" + (this.f11320G[1] - 64);
        strArr[2] = "" + (this.f11320G[2] - 64);
        strArr[3] = this.f11332i[this.f11320G[3]];
        strArr[4] = this.f11333j[this.f11320G[4]];
        this.f11347x.setSelection(this.f11320G[4]);
        return strArr;
    }

    /* renamed from: e */
    public int m9881e(String str) {
        if (str == null) {
            return 0;
        }
        int parseInt = (str == null || str.equals("unknown")) ? 3 : Integer.parseInt(str);
        if (parseInt != 3 && parseInt != 4) {
            parseInt = 3;
        }
        return parseInt - 3;
    }

    /* renamed from: e */
    public String[] m9883e() {
        String[] strArr = new String[this.f11319F.length];
        strArr[0] = this.f11329f[this.f11319F[0]];
        strArr[1] = "" + (this.f11319F[1] - 64);
        strArr[2] = "" + (this.f11319F[2] - 64);
        strArr[3] = this.f11332i[this.f11319F[3]];
        strArr[4] = this.f11333j[this.f11319F[4]];
        this.f11347x.setSelection(this.f11319F[4]);
        return strArr;
    }

    /* renamed from: f */
    public int m9880f() {
        return (!this.f11345v.isSelected() && this.f11342s.isSelected()) ? 1 : 0;
    }

    /* renamed from: f */
    public int m9878f(String str) {
        if (str == null) {
            return 0;
        }
        if (str != null && str.equals("unknown")) {
            return 0;
        }
        int i = 0;
        while (true) {
            if (i >= this.f11336m.length) {
                i = 0;
                break;
            } else if (str.contains(this.f11336m[i])) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }

    /* renamed from: g */
    public void m9877g() {
        if (this.f11315B != null) {
            this.f11315B.mo9856a(m9886d());
        }
    }

    @Override // com.fimi.soul.view.wheelview.WheelView.AbstractC3884a
    /* renamed from: h */
    public void mo6673h() {
        m9877g();
    }

    /* renamed from: i */
    public void m9874i() {
        if (this.f11323J != null) {
            this.f11323J.removeMessages(0);
        }
    }

    /* renamed from: j */
    public String[] m9873j() {
        String[] strArr = new String[5];
        for (int i = 0; i < this.f11320G.length; i++) {
            switch (i) {
                case 0:
                    strArr[i] = this.f11329f[i];
                    break;
                case 1:
                    strArr[i] = "" + this.f11320G[i];
                    break;
                case 2:
                    strArr[i] = "" + this.f11320G[i];
                    break;
                case 3:
                    strArr[i] = "" + this.f11320G[i] + 3;
                    break;
                case 4:
                    strArr[i] = this.f11336m[i];
                    break;
            }
        }
        return strArr;
    }

    /* renamed from: k */
    public String m9872k() {
        return this.f11321H ? "on_ev" : C2427e.f8308cE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.sharpan_normal /* 2131493259 */:
                this.f11345v.setSelected(true);
                this.f11342s.setSelected(false);
                this.f11345v.setTextColor(this.f11318E);
                this.f11342s.setTextColor(this.f11317D);
                if (this.f11315B != null) {
                    String str = this.f11335l[3][0];
                    m9897a(str);
                    this.f11315B.mo9859a(3, str, "3");
                    this.f11315B.mo9860a(3, "3");
                    break;
                }
                break;
            case C2300R.C2302id.sharpan_hight /* 2131493260 */:
                this.f11345v.setSelected(false);
                this.f11342s.setSelected(true);
                this.f11345v.setTextColor(this.f11317D);
                this.f11342s.setTextColor(this.f11318E);
                if (this.f11315B != null) {
                    String str2 = this.f11335l[3][1];
                    m9897a(str2);
                    this.f11315B.mo9859a(3, str2, "4");
                    this.f11315B.mo9860a(3, "4");
                    break;
                }
                break;
        }
        if (this.f11323J == null || !this.f11316C) {
            return;
        }
        this.f11323J.removeMessages(0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 5) {
            this.f11339p.setVisibility(0);
            this.f11338o = ((TextView) view.findViewById(C2300R.C2302id.tv_lv_item_tag)).getText().toString();
            m9889c(i);
            if (this.f11315B != null) {
            }
            this.f11316C = true;
        } else {
            m9877g();
        }
        if (this.f11315B != null) {
            this.f11315B.mo9858a(i, false);
        }
    }
}
