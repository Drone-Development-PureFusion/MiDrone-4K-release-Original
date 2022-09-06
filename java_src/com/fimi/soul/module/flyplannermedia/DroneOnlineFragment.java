package com.fimi.soul.module.flyplannermedia;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.fimi.kernel.p157b.p159b.C2196b;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.utils.C2284z;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11DeviceInfo;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p173c.C2416d;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.media.player.FermiPlayerUtils;
import com.fimi.soul.module.flyplannermedia.C3327a;
import com.fimi.soul.module.login.C3384c;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class DroneOnlineFragment extends DroneBaseMediaFragment implements C2205c.AbstractC2208a, C2205c.AbstractC2209b {

    /* renamed from: e */
    private static final String f12893e = "media";

    /* renamed from: l */
    private static final int f12894l = 153;

    /* renamed from: m */
    private static final int f12895m = 152;

    /* renamed from: n */
    private static final int f12896n = 1000;

    /* renamed from: o */
    private static final int f12897o = 3;

    /* renamed from: g */
    private int f12900g;

    /* renamed from: h */
    private C3327a<X11FileInfo> f12901h;

    /* renamed from: i */
    private List<WifiDistanceFile> f12902i;

    /* renamed from: k */
    private X11DeviceInfo f12904k;

    /* renamed from: q */
    private X11FileInfo f12906q;

    /* renamed from: v */
    private boolean f12911v;

    /* renamed from: f */
    private int f12899f = 0;

    /* renamed from: j */
    private List<X11FileInfo> f12903j = new ArrayList();

    /* renamed from: p */
    private boolean f12905p = true;

    /* renamed from: r */
    private int f12907r = 0;

    /* renamed from: s */
    private int f12908s = 1;

    /* renamed from: t */
    private boolean f12909t = false;

    /* renamed from: u */
    private boolean f12910u = false;

    /* renamed from: w */
    private boolean f12912w = false;

    /* renamed from: d */
    Handler f12898d = new Handler() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.5
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (153 == message.what) {
                if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
                    DroneOnlineFragment.this.m().m12232v().m12268b(1);
                } else if (!C2367d.m12459a().m12438k()) {
                    DroneOnlineFragment.this.m().m12232v().m12268b(0);
                } else if (CameraValue.version < 1058) {
                    DroneOnlineFragment.this.m().m12232v().m12268b(0);
                } else {
                    DroneOnlineFragment.this.m().m12232v().m12268b(1);
                }
            }
            if (152 == message.what) {
                if (!DroneOnlineFragment.this.f12905p) {
                    if (DroneOnlineFragment.this.f12907r >= 3 && DroneOnlineFragment.this.f12908s == 1) {
                        DroneOnlineFragment.m8703j(DroneOnlineFragment.this);
                        DroneOnlineFragment.this.m8724a(DroneOnlineFragment.this.f12906q);
                    } else if (DroneOnlineFragment.this.f12908s >= 2 && DroneOnlineFragment.this.f12907r >= 3) {
                        DroneOnlineFragment.this.m8696s();
                    }
                }
                DroneOnlineFragment.m8701l(DroneOnlineFragment.this);
                DroneOnlineFragment.this.f12898d.sendEmptyMessageDelayed(152, 1000L);
            }
        }
    };

    public DroneOnlineFragment() {
        this.f12911v = false;
        a(true);
        this.f12911v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8724a(X11FileInfo x11FileInfo) {
        int fileType = WifiDistanceFile.getFileType(x11FileInfo.getName());
        if (fileType == 1) {
            this.f12907r = 0;
            String m12408a = C2379b.m12408a(x11FileInfo);
            if (C2379b.m12399b(m12408a)) {
                this.f12905p = true;
                m8723a(x11FileInfo, String.format("file://%s", C3681j.m7481a(m12408a)));
                this.f12901h.m8691b();
            } else {
                this.f12905p = false;
                m().m12232v().m12271a(x11FileInfo.getName(), x11FileInfo.getAbsolutePath(), x11FileInfo.getCreateDate(), C2416d.EnumC2419a.Thumb);
            }
        }
        if (fileType == 2) {
            this.f12905p = false;
            this.f12907r = 0;
            this.f12910u = true;
            m().m12232v().m12256g(x11FileInfo.getAbsolutePath());
        }
    }

    /* renamed from: a */
    private void m8723a(X11FileInfo x11FileInfo, String str) {
        WifiDistanceFile wifiDistanceFile = new WifiDistanceFile(x11FileInfo.getName());
        wifiDistanceFile.setLocalThumbnailPath(str);
        wifiDistanceFile.setDateString(x11FileInfo.getCreateDate());
        wifiDistanceFile.setSize(x11FileInfo.getSize());
        wifiDistanceFile.setRealPath(x11FileInfo.getRemotePath());
        wifiDistanceFile.setAbsolutePath(x11FileInfo.getAbsolutePath());
        wifiDistanceFile.setRemoteUrl(x11FileInfo.getHttpUrl());
        if (wifiDistanceFile.getType() == 2) {
            wifiDistanceFile.setRemoteThmUrl(x11FileInfo.getHttpThmUrl());
        }
        b().m12557a(wifiDistanceFile);
        g(false);
    }

    /* renamed from: b */
    private void m8711b(List<X11FileInfo> list) {
        if (list == null || list.size() <= b().getCount()) {
            d(true);
            m().a(true);
        } else if (list == null || list.size() <= 0) {
            d(true);
        } else {
            this.f12901h = new C3327a<>(list);
            this.f12901h.m8693a(new C3327a.AbstractC3328a<X11FileInfo>() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.4
                @Override // com.fimi.soul.module.flyplannermedia.C3327a.AbstractC3328a
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public boolean mo8687a(X11FileInfo x11FileInfo) {
                    DroneOnlineFragment.this.f12906q = x11FileInfo;
                    DroneOnlineFragment.m8708e(DroneOnlineFragment.this);
                    DroneOnlineFragment.this.f12908s = 1;
                    DroneOnlineFragment.this.m8724a(DroneOnlineFragment.this.f12906q);
                    return true;
                }
            });
            this.f12901h.m8691b();
            d(false);
            g(false);
        }
    }

    /* renamed from: e */
    static /* synthetic */ int m8708e(DroneOnlineFragment droneOnlineFragment) {
        int i = droneOnlineFragment.f12899f;
        droneOnlineFragment.f12899f = i + 1;
        return i;
    }

    /* renamed from: j */
    static /* synthetic */ int m8703j(DroneOnlineFragment droneOnlineFragment) {
        int i = droneOnlineFragment.f12908s;
        droneOnlineFragment.f12908s = i + 1;
        return i;
    }

    /* renamed from: l */
    static /* synthetic */ int m8701l(DroneOnlineFragment droneOnlineFragment) {
        int i = droneOnlineFragment.f12907r;
        droneOnlineFragment.f12907r = i + 1;
        return i;
    }

    /* renamed from: q */
    private void m8698q() {
        l().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneOnlineFragment.this.m8697r();
            }
        });
        k().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneOnlineFragment.this.f12902i = DroneOnlineFragment.this.b().m12547c();
                new DialogC3800f.C3801a(DroneOnlineFragment.this.getActivity()).m7031a(String.format(DroneOnlineFragment.this.getString(C2300R.C2303string.ensure_delete_image), DroneOnlineFragment.this.f12902i.size() + "")).m7034a(DroneOnlineFragment.this.getActivity().getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(DroneOnlineFragment.this.getString(C2300R.C2303string.delete), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DroneOnlineFragment.this.f12900g = 0;
                        DroneOnlineFragment.this.f12910u = false;
                        if (DroneOnlineFragment.this.f12902i.size() == 0) {
                            return;
                        }
                        DroneOnlineFragment.this.f12903j.clear();
                        for (int i2 = 0; i2 < DroneOnlineFragment.this.f12902i.size(); i2++) {
                            Iterator<X11FileInfo> it2 = DroneOnlineFragment.this.m().l().getCurDirFileList().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    X11FileInfo next = it2.next();
                                    if (((WifiDistanceFile) DroneOnlineFragment.this.f12902i.get(i2)).getName().equals(next.getName())) {
                                        DroneOnlineFragment.this.f12903j.add(next);
                                        break;
                                    }
                                }
                            }
                        }
                        DroneOnlineFragment.this.m().m12232v().m12264c(((WifiDistanceFile) DroneOnlineFragment.this.f12902i.get(DroneOnlineFragment.this.f12900g)).getAbsolutePath());
                        DroneOnlineFragment.this.h(false);
                        DroneOnlineFragment.this.g(true);
                    }
                }).m7030a(DroneOnlineFragment.this.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).m7035a().show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m8697r() {
        List<WifiDistanceFile> m12547c = b().m12547c();
        C2205c m13235a = C2205c.m13235a(getActivity());
        m13235a.m13231a((C2205c.AbstractC2209b) this);
        m13235a.m13232a((C2205c.AbstractC2208a) this);
        if (m12547c != null && m12547c.size() > 0) {
            h(false);
            for (WifiDistanceFile wifiDistanceFile : m12547c) {
                String m12403a = C2379b.m12403a(wifiDistanceFile.getName(), wifiDistanceFile.getDateString());
                String str = "";
                if (wifiDistanceFile.getType() == 2) {
                    str = wifiDistanceFile.getDurationString();
                }
                m13235a.m13229a(wifiDistanceFile.getRemoteUrl(), str, wifiDistanceFile.getSize(), false, C3681j.m7478b(m12403a).replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o));
            }
        }
        C2284z.m12694a(getActivity(), getActivity().getString(C2300R.C2303string.media_success_add, new Object[]{Integer.valueOf(m12547c.size())}), 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m8696s() {
        if (this.f12899f > 0) {
            this.f12899f--;
            if (b().getCount() + 1 >= m().l().getCurDirFileList().size()) {
                return;
            }
            m().l().getCurDirFileList().remove(b().getCount() + 1);
            if (this.f12901h.m8691b() || this.f12901h.m8690c() != 12 || b().getCount() + 1 >= 12) {
                return;
            }
            this.f12901h.m8688e();
            this.f12901h.m8691b();
        }
    }

    /* renamed from: a */
    public void m8727a(Intent intent) {
        if (intent != null) {
            WifiDistanceFile wifiDistanceFile = (WifiDistanceFile) intent.getSerializableExtra(C2353b.f7923N);
            if (wifiDistanceFile != null && b() != null) {
                b().m12545c(wifiDistanceFile);
                if (b().getCount() == 0) {
                    d(true);
                }
            }
            if (this.f12899f > 0) {
                this.f12899f--;
            }
            a(wifiDistanceFile);
        }
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment
    /* renamed from: a */
    void mo8726a(GridView gridView) {
        if (b().m12544d().size() == this.f12899f && this.f12901h != null && this.f12905p && this.f12901h.m8688e()) {
            this.f12901h.m8691b();
            b().notifyDataSetChanged();
        }
    }

    @Override // com.fimi.kernel.p157b.p159b.C2205c.AbstractC2208a
    /* renamed from: a */
    public void mo8725a(C2196b c2196b, int i) {
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2387e
    /* renamed from: a */
    public void mo8717a(String str, String str2) {
        if (this.f12912w) {
            return;
        }
        this.f12905p = true;
        try {
            if (C2379b.m12389f(str2) != C2379b.EnumC2381a.Thumbnail) {
                return;
            }
            List<X11FileInfo> curDirFileList = m().l().getCurDirFileList();
            if (b().getCount() >= curDirFileList.size()) {
                return;
            }
            m8723a(curDirFileList.get(b().getCount()), String.format("file://%s%s", str, str2));
            if (this.f12901h.m8691b()) {
            }
        } catch (Exception e) {
            Log.d("Good", e + "");
        }
    }

    @Override // com.fimi.kernel.p157b.p159b.C2205c.AbstractC2209b
    /* renamed from: a */
    public void mo8716a(List<C2196b> list, boolean z, C2196b c2196b) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        String timelineString;
        int indexOf;
        if (!"".equalsIgnoreCase(x11RespCmd.getErrorMsg())) {
        }
        if (getActivity() != null) {
            if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.CardRemoved) {
                d(true);
                C2284z.m12695a(getActivity(), getActivity().getString(C2300R.C2303string.tf_removed));
                return;
            } else if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.FmLsEnd) {
                this.f12911v = true;
                if (z) {
                    m8711b(m().l().getCurDirFileList());
                } else {
                    d(true);
                    g(false);
                }
            }
        }
        switch (x11RespCmd.getMsg_id()) {
            case 257:
                m().m12232v().m12263d();
                return;
            case C2427e.f8178H /* 261 */:
                if (!C2367d.m12459a().m12438k()) {
                    m().m12232v().m12268b(0);
                    return;
                } else if (CameraValue.version < 1058) {
                    m().m12232v().m12268b(0);
                    return;
                } else {
                    m().m12232v().m12268b(1);
                    return;
                }
            case C2427e.f8186P /* 1026 */:
                break;
            case C2427e.f8188R /* 1281 */:
                if (!z && x11RespCmd.getRval() != -26) {
                    g(false);
                    C2284z.m12694a(getActivity(), getString(C2300R.C2303string.del_fail), 2000);
                    return;
                } else if (this.f12900g < this.f12903j.size() && this.f12900g < this.f12902i.size()) {
                    m().a(true);
                    b().m12549b(this.f12902i.get(this.f12900g));
                    if (this.f12899f > 0) {
                        this.f12899f--;
                    }
                    m().l().getCurDirFileList().remove(this.f12903j.get(this.f12900g));
                    if (this.f12902i.get(this.f12900g).getLocalThumbnailPath() != null) {
                        File file = new File(this.f12902i.get(this.f12900g).getLocalThumbnailPath().replace("file://", ""));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    this.f12900g++;
                    if (this.f12900g >= this.f12902i.size()) {
                        g(false);
                        C2284z.m12694a(getActivity(), getString(C2300R.C2303string.del_success), C2284z.f7606b);
                        a(this.f12902i);
                        m().m12233u().m12290d(C2427e.f8324cU);
                        if (b().getCount() + 1 < 12 && this.f12901h != null && this.f12901h.m8688e() && !this.f12901h.m8691b() && b().getCount() == 0) {
                            d(true);
                        }
                        b().notifyDataSetChanged();
                        break;
                    } else {
                        m().m12232v().m12264c(this.f12902i.get(this.f12900g).getAbsolutePath());
                        break;
                    }
                } else {
                    g(false);
                    return;
                }
                break;
            case C2427e.f8189S /* 1282 */:
                g(false);
                this.f12899f = 0;
                m8711b(m().l().getCurDirFileList());
                return;
            case C2427e.f8190T /* 1283 */:
                m().m12232v().m12259f();
                return;
            case C2427e.f8236am /* 10066328 */:
                X11FileInfo curDownloadFile = m().l().getCurDownloadFile();
                if (curDownloadFile == null) {
                    return;
                }
                m().m12232v().m12271a(curDownloadFile.getName(), curDownloadFile.getAbsolutePath(), curDownloadFile.getCreateDate(), C2416d.EnumC2419a.Thumb);
                return;
            default:
                return;
        }
        if (!this.f12910u || this.f12912w) {
            return;
        }
        this.f12905p = true;
        if (!z) {
            m8696s();
            return;
        }
        List<X11FileInfo> curDirFileList = m().l().getCurDirFileList();
        if (b().getCount() < 0 || b().getCount() >= curDirFileList.size()) {
            return;
        }
        X11FileInfo x11FileInfo = curDirFileList.get(b().getCount());
        String name = x11FileInfo.getName();
        WifiDistanceFile wifiDistanceFile = new WifiDistanceFile(name);
        if (z) {
            try {
                timelineString = FermiPlayerUtils.getTimelineString(Long.parseLong(x11RespCmd.getDuration()) * 1000, "mm:ss");
            } catch (Exception e) {
            }
        } else {
            timelineString = "00:00";
        }
        wifiDistanceFile.setDurationString(timelineString);
        wifiDistanceFile.setDateString(x11FileInfo.getCreateDate());
        wifiDistanceFile.setRemoteUrl(C2379b.m12404a(x11FileInfo.getRemotePath()));
        wifiDistanceFile.setSize(x11FileInfo.getSize());
        wifiDistanceFile.setRealPath(x11FileInfo.getRemotePath());
        wifiDistanceFile.setAbsolutePath(x11FileInfo.getAbsolutePath());
        if (x11FileInfo.getRemotePath().indexOf(".") > 0 && wifiDistanceFile.getType() == 2) {
            wifiDistanceFile.setRemoteThmUrl(C2379b.m12404a(!name.contains("_THM.MP4") ? x11FileInfo.getRemotePath().substring(0, indexOf) + "_THM.MP4" : x11FileInfo.getRemotePath()));
        }
        b().m12557a(wifiDistanceFile);
        this.f12901h.m8691b();
        b().notifyDataSetChanged();
    }

    /* renamed from: o */
    public void m8700o() {
        h(false);
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m().c(new AbstractC2221d() { // from class: com.fimi.soul.module.flyplannermedia.DroneOnlineFragment.1
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
            /* renamed from: a */
            public void mo6431a(String str) {
            }
        });
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment, android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m8698q();
        return onCreateView;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f12912w = false;
        if (!this.f12909t && m().e() && b().getCount() > 0 && b().getCount() < 12 && m().l().getCurDirFileList().size() > b().getCount()) {
            b().m12538h();
            this.f12899f = 0;
            m8711b(m().l().getCurDirFileList());
        }
        b().notifyDataSetChanged();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(true);
        f(false);
        this.f12898d.sendEmptyMessage(152);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f12909t = false;
        this.f12912w = true;
        this.f12898d.removeCallbacksAndMessages(152);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d(false);
        if (!m().i()) {
            C2284z.m12696a(getActivity(), (int) C2300R.C2303string.tf_remove_error, 3000);
            d(true);
            return;
        }
        if (m().e() && b().getCount() <= 0) {
            this.f12909t = true;
            g(true);
            d(false);
            if (!this.f12911v) {
                this.f12898d.sendEmptyMessageDelayed(153, 300L);
                m().m12233u().m12290d(C2427e.f8325cV);
            } else {
                g(false);
                d(true);
            }
        } else if (!m().e()) {
            this.f12909t = true;
            d(true);
        } else {
            this.f12909t = false;
        }
        this.f12904k = m().j().getX11DeviceInfo();
    }

    /* renamed from: p */
    public Handler m8699p() {
        return this.f12898d;
    }
}
