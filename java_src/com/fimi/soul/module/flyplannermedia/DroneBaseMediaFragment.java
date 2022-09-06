package com.fimi.soul.module.flyplannermedia;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.fimi.kernel.utils.C2271p;
import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2387e;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.fimi.soul.p167b.C2331f;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.MyGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class DroneBaseMediaFragment extends Fragment implements AdapterView.OnItemLongClickListener, AbstractC2387e, AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    protected C2331f f12837a;

    /* renamed from: f */
    private C2423d f12842f;

    /* renamed from: i */
    private C2657a f12845i;

    /* renamed from: d */
    private MyGridView f12840d = null;

    /* renamed from: e */
    private TextView f12841e = null;

    /* renamed from: g */
    private boolean f12843g = false;

    /* renamed from: h */
    private boolean f12844h = false;

    /* renamed from: j */
    private boolean f12846j = false;

    /* renamed from: k */
    private boolean f12847k = false;

    /* renamed from: l */
    private boolean f12848l = false;

    /* renamed from: b */
    float f12838b = 0.0f;

    /* renamed from: c */
    List<X11FileInfo> f12839c = null;

    /* renamed from: o */
    private DroneMediaTabActivity m8749o() {
        return (DroneMediaTabActivity) getActivity();
    }

    /* renamed from: a */
    abstract void mo8726a(GridView gridView);

    /* renamed from: a */
    public void m8781a(WifiDistanceFile wifiDistanceFile) {
        if ((wifiDistanceFile == null || this.f12839c == null || this.f12839c.size() == 0) && !this.f12848l) {
            this.f12839c = m8751m().l().getCurDirFileList();
        }
        this.f12848l = true;
        if (this.f12839c == null || this.f12839c.size() <= 0) {
            return;
        }
        X11FileInfo x11FileInfo = null;
        for (X11FileInfo x11FileInfo2 : this.f12839c) {
            if (!x11FileInfo2.getAbsolutePath().equals(wifiDistanceFile.getAbsolutePath())) {
                x11FileInfo2 = x11FileInfo;
            }
            x11FileInfo = x11FileInfo2;
        }
        if (x11FileInfo == null) {
            return;
        }
        this.f12839c.remove(x11FileInfo);
    }

    /* renamed from: a */
    public void m8778a(List<WifiDistanceFile> list) {
        if (list == null || list.size() == 0 || this.f12839c == null || this.f12839c.size() == 0) {
            return;
        }
        Log.d("moweiru", "toDeleteFiles=" + list.get(0).getName());
        ArrayList<X11FileInfo> arrayList = new ArrayList();
        for (WifiDistanceFile wifiDistanceFile : list) {
            for (X11FileInfo x11FileInfo : this.f12839c) {
                if (x11FileInfo.getName().equals(wifiDistanceFile.getName())) {
                    arrayList.add(x11FileInfo);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (X11FileInfo x11FileInfo2 : arrayList) {
            this.f12839c.remove(x11FileInfo2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8777a(boolean z) {
        this.f12844h = z;
    }

    /* renamed from: a */
    protected boolean m8782a() {
        return this.f12844h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public C2331f m8776b() {
        return this.f12837a;
    }

    /* renamed from: b */
    protected void m8773b(boolean z) {
        m8749o().m8733b().setVisibility(z ? 0 : 8);
    }

    /* renamed from: c */
    protected Button m8772c() {
        return (Button) m8749o().m8733b().findViewById(C2300R.C2302id.btn_topLeft);
    }

    /* renamed from: c */
    protected void m8769c(boolean z) {
        m8749o().m8736a().setVisibility(z ? 0 : 8);
    }

    /* renamed from: d */
    protected TextView m8768d() {
        return this.f12841e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void m8766d(boolean z) {
        if (m8749o() != null) {
            m8749o().m8734a(z);
        }
    }

    /* renamed from: e */
    public List<X11FileInfo> m8765e() {
        return this.f12839c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void m8763e(boolean z) {
        m8749o().m8736a().findViewById(C2300R.C2302id.ll_bottomDownload).setVisibility(z ? 0 : 8);
    }

    /* renamed from: f */
    protected Button m8762f() {
        return (Button) m8749o().m8733b().findViewById(C2300R.C2302id.btn_topRight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void m8760f(boolean z) {
        View findViewById = m8749o().m8736a().findViewById(C2300R.C2302id.ll_bottomShare);
        if (z) {
        }
        findViewById.setVisibility(8);
    }

    /* renamed from: g */
    protected TextView m8759g() {
        return (TextView) m8749o().m8733b().findViewById(C2300R.C2302id.tv_topCenter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void m8758g(boolean z) {
        if (m8749o() == null || m8749o().findViewById(C2300R.C2302id.load_pb) == null) {
            return;
        }
        m8749o().findViewById(C2300R.C2302id.load_pb).setVisibility(z ? 0 : 8);
    }

    /* renamed from: h */
    public String m8757h() {
        int i;
        int i2;
        File file = new File(C3681j.m7458u());
        if (file == null || !file.exists()) {
            i = 0;
            i2 = 0;
        } else {
            File[] listFiles = file.listFiles();
            i = 0;
            i2 = 0;
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (name.endsWith(X11FileInfo.FILE_TYPE_MP4)) {
                    i++;
                }
                if (name.endsWith(".jpg")) {
                    i2++;
                }
            }
        }
        return String.format(getActivity().getResources().getString(C2300R.C2303string.local_media_detail), i2 + "", i + "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m8756h(boolean z) {
        m8773b(z);
        m8769c(z);
        if (!z) {
            this.f12840d.setPadding(0, 0, 0, 0);
            m8776b().m12564a(C2331f.EnumC2335a.Normal);
            m8776b().m12539g();
            return;
        }
        this.f12840d.setPadding(0, 0, 0, (int) C2271p.m12870a((Context) getActivity(), 60.0f));
        m8776b().m12564a(C2331f.EnumC2335a.Choose);
        m8762f().setText(getString(C2300R.C2303string.select_all));
        this.f12843g = false;
    }

    /* renamed from: i */
    public String m8755i() {
        if (!this.f12848l) {
            this.f12839c = m8751m().l().getCurDirFileList();
        }
        if (this.f12839c == null || this.f12839c.size() != 0) {
            long j = 0;
            int i = 0;
            int i2 = 0;
            for (X11FileInfo x11FileInfo : this.f12839c) {
                int i3 = x11FileInfo.getName().endsWith(X11FileInfo.FILE_TYPE_MP4) ? i2 + 1 : i2;
                if (x11FileInfo.getName().endsWith(".jpg")) {
                    i++;
                }
                j = (x11FileInfo.getSize() / FimiMediaMeta.AV_CH_SIDE_RIGHT) + j;
                i2 = i3;
            }
            return String.format(getActivity().getResources().getString(C2300R.C2303string.online_media_detail), i + "", i2 + "", C2275t.m12793a(((float) m8751m().j().getFreeKBSpace()) / 1048576.0f, 2) + "", C2275t.m12793a(((float) m8751m().j().getTotalKBSpace()) / 1048576.0f, 2) + "");
        }
        return "";
    }

    /* renamed from: j */
    protected ImageButton m8754j() {
        return (ImageButton) m8749o().m8736a().findViewById(C2300R.C2302id.btn_bottomShare);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public ImageButton m8753k() {
        return (ImageButton) m8749o().m8736a().findViewById(C2300R.C2302id.btn_bottomDelete);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public ImageButton m8752l() {
        return (ImageButton) m8749o().m8736a().findViewById(C2300R.C2302id.btn_bottomDownload);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public C2423d m8751m() {
        if (this.f12842f == null) {
            this.f12842f = (C2423d) C2379b.m12410a().m12394d();
        }
        return this.f12842f;
    }

    /* renamed from: n */
    public void m8750n() {
        this.f12840d.setAdapter(this.f12837a);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12845i = ((DroidPlannerApp) activity.getApplication()).f7895a;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_gridview, (ViewGroup) null);
        this.f12840d = (MyGridView) inflate.findViewById(C2300R.C2302id.gv_content);
        if (this.f12837a == null) {
            this.f12837a = new C2331f(getActivity(), this.f12840d);
            this.f12837a.m12552a(m8782a());
            this.f12837a.m12558a(this.f12845i);
        }
        this.f12841e = (TextView) inflate.findViewById(C2300R.C2302id.media_detail);
        C3658ar.m7612a(m8749o().getAssets(), this.f12841e);
        this.f12840d.setAdapter(this.f12837a);
        this.f12840d.setOnItemLongClickListener(this);
        this.f12840d.setOnItemClickListener(this.f12837a);
        this.f12840d.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment.1

            /* renamed from: b */
            private int f12850b;

            /* renamed from: c */
            private int f12851c;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.f12850b = i;
                this.f12851c = i2;
                DroneBaseMediaFragment.this.f12837a.m12567a(absListView, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                DroneBaseMediaFragment.this.f12837a.m12568a(absListView, i);
                if (i != 1 || this.f12850b != 0 || !DroneBaseMediaFragment.this.f12846j || DroneBaseMediaFragment.this.f12837a.m12542e() == C2331f.EnumC2335a.Choose) {
                    DroneBaseMediaFragment.this.f12841e.setVisibility(8);
                } else {
                    if (!DroneBaseMediaFragment.this.f12847k) {
                        if (!DroneBaseMediaFragment.this.f12844h) {
                            DroneBaseMediaFragment.this.f12841e.setText(DroneBaseMediaFragment.this.m8757h());
                        } else {
                            DroneBaseMediaFragment.this.f12841e.setText(DroneBaseMediaFragment.this.m8755i());
                        }
                        DroneBaseMediaFragment.this.f12847k = true;
                    }
                    DroneBaseMediaFragment.this.f12841e.setVisibility(0);
                }
                if (DroneBaseMediaFragment.this.m8751m().l().getCurDirFileList().size() <= DroneBaseMediaFragment.this.f12840d.getCount() || this.f12850b + this.f12851c < DroneBaseMediaFragment.this.f12840d.getCount() || i != 0) {
                    return;
                }
                DroneBaseMediaFragment.this.mo8726a(DroneBaseMediaFragment.this.f12840d);
            }
        });
        this.f12840d.setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float y = motionEvent.getY();
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                if (actionMasked == 2) {
                    if (DroneBaseMediaFragment.this.f12838b - y < 0.0f) {
                        DroneBaseMediaFragment.this.f12846j = true;
                    } else {
                        DroneBaseMediaFragment.this.f12846j = false;
                    }
                }
                if (actionMasked == 0) {
                    DroneBaseMediaFragment.this.f12838b = y;
                    DroneBaseMediaFragment.this.f12847k = false;
                }
                if (actionMasked == 1) {
                    DroneBaseMediaFragment.this.f12838b = 0.0f;
                }
                return false;
            }
        });
        this.f12837a.m12563a(new C2331f.AbstractC2336b() { // from class: com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment.3
            @Override // com.fimi.soul.p167b.C2331f.AbstractC2336b
            /* renamed from: a */
            public void mo8748a(int i) {
                DroneBaseMediaFragment.this.m8759g().setText(String.format(DroneBaseMediaFragment.this.getActivity().getString(C2300R.C2303string.media_you_select_size), Integer.valueOf(i)));
            }
        });
        m8772c().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneBaseMediaFragment.this.m8756h(false);
            }
        });
        m8762f().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DroneBaseMediaFragment.this.f12843g) {
                    DroneBaseMediaFragment.this.m8776b().m12539g();
                    DroneBaseMediaFragment.this.m8762f().setText(C2300R.C2303string.select_all);
                } else {
                    DroneBaseMediaFragment.this.m8762f().setText(C2300R.C2303string.undo_select_all);
                    DroneBaseMediaFragment.this.m8776b().m12540f();
                }
                DroneBaseMediaFragment.this.f12843g = !DroneBaseMediaFragment.this.f12843g;
            }
        });
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        m8756h(true);
        return false;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!m8751m().e()) {
            m8751m().m12231w().m12240b();
        }
        m8751m().a((AbstractC2387e) this);
        m8751m().a((AbstractC2388f<X11RespCmd>) this);
    }
}
