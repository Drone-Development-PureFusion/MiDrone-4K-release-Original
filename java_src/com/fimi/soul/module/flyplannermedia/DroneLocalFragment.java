package com.fimi.soul.module.flyplannermedia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.p159b.C2196b;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.module.login.C3384c;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class DroneLocalFragment extends DroneBaseMediaFragment {

    /* renamed from: d */
    private C2205c f12856d;

    /* renamed from: e */
    private List<WifiDistanceFile> f12857e;

    /* renamed from: f */
    private HandlerC3314a f12858f = new HandlerC3314a();

    /* renamed from: g */
    private Handler f12859g = new Handler();

    /* renamed from: h */
    private boolean f12860h = false;

    /* renamed from: com.fimi.soul.module.flyplannermedia.DroneLocalFragment$a */
    /* loaded from: classes.dex */
    class HandlerC3314a extends Handler {
        HandlerC3314a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 100) {
                if (message.what != 99) {
                    return;
                }
                DroneLocalFragment.this.b().notifyDataSetChanged();
                return;
            }
            DroneLocalFragment.this.f12860h = false;
            if (DroneLocalFragment.this.f12857e == null) {
                DroneLocalFragment.this.g(false);
                DroneLocalFragment.this.d(true);
                return;
            }
            DroneLocalFragment.this.b().m12553a(DroneLocalFragment.this.f12857e);
            DroneLocalFragment.this.g(false);
            if (DroneLocalFragment.this.f12857e.size() > 0) {
                DroneLocalFragment.this.d(false);
            } else {
                DroneLocalFragment.this.d(true);
            }
            DroneLocalFragment.this.b().notifyDataSetChanged();
        }
    }

    public DroneLocalFragment() {
        a(false);
    }

    /* renamed from: p */
    private void m8738p() {
        if (!this.f12860h) {
            this.f12860h = true;
            new Thread(new Runnable() { // from class: com.fimi.soul.module.flyplannermedia.DroneLocalFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    DroneLocalFragment.this.f12857e = DroneLocalFragment.this.m8737q();
                    DroneLocalFragment.this.f12858f.sendEmptyMessage(100);
                    DroneLocalFragment.this.f12860h = false;
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public List<WifiDistanceFile> m8737q() {
        File[] listFiles;
        File file = new File(C3681j.m7458u());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (file == null || !file.exists()) {
            return null;
        }
        File[] listFiles2 = file.listFiles();
        for (int i = 0; i < listFiles2.length; i++) {
            if (listFiles2[i].getName().endsWith(".jpg") || listFiles2[i].getName().endsWith(".JPG") || listFiles2[i].getName().endsWith(C3384c.f13187o) || listFiles2[i].getName().endsWith(X11FileInfo.FILE_TYPE_MP4)) {
                arrayList.add(listFiles2[i]);
            }
        }
        File file2 = new File(C3681j.m7465n());
        if (file2 != null && (listFiles = file2.listFiles()) != null) {
            for (File file3 : listFiles) {
                arrayList2.add(file3);
            }
        }
        Collections.sort(arrayList, new C3329b());
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            File file4 = (File) it2.next();
            String name = file4.getName();
            WifiDistanceFile wifiDistanceFile = new WifiDistanceFile(name);
            String format = String.format("file://%s%s", C3681j.m7458u(), name);
            wifiDistanceFile.setLocalThumbnailPath(format);
            wifiDistanceFile.setPath(format);
            C2196b m13234a = this.f12856d.m13234a(getActivity(), name.replace(C3384c.f13187o, X11FileInfo.FILE_TYPE_MP4));
            if (m13234a != null) {
                m13234a.m13290a(this.f12859g);
                this.f12856d.m13226c();
                wifiDistanceFile.setDownloadTaskInfo(m13234a);
                wifiDistanceFile.setRemoteUrl(m13234a.m13250m());
                String replace = name.replace(C3384c.f13187o, X11FileInfo.FILE_TYPE_MP4);
                if (replace.contains(X11FileInfo.FILE_TYPE_MP4)) {
                    replace = replace.replace(X11FileInfo.FILE_TYPE_MP4, ".jpg");
                    if (m13234a.m13294a() != null) {
                        wifiDistanceFile.setDurationString(m13234a.m13294a());
                    }
                }
                String str = replace;
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    File file5 = (File) it3.next();
                    if (file5.getName().contains(str)) {
                        wifiDistanceFile.setLocalDownloadCachePath(file5.getPath());
                        break;
                    }
                }
            }
            if (file4.length() > 0) {
                arrayList3.add(wifiDistanceFile);
            }
        }
        return arrayList3;
    }

    /* renamed from: a */
    public void m8747a(Intent intent) {
        String stringExtra = intent.getStringExtra("del_file");
        if (intent == null || "".equals(stringExtra) || stringExtra == null) {
            return;
        }
        b().m12548b(stringExtra);
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment
    /* renamed from: a */
    void mo8726a(GridView gridView) {
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2387e
    /* renamed from: a */
    public void mo8717a(String str, String str2) {
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (getActivity() != null) {
            if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.StartingVideoRecord) {
                b().notifyDataSetChanged();
            }
            if (x11RespCmd.getNotificationType() != X11RespCmd.NotificationType.VideoRecordComplete) {
                return;
            }
            b().notifyDataSetChanged();
        }
    }

    /* renamed from: o */
    public void m8739o() {
        h(false);
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment, android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f12856d = C2205c.m13235a(getActivity());
        k().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneLocalFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final List<WifiDistanceFile> m12544d = DroneLocalFragment.this.b().m12544d();
                DialogC3800f.C3801a c3801a = new DialogC3800f.C3801a(DroneLocalFragment.this.getActivity());
                if (DroneLocalFragment.this.b().m12547c() == null || DroneLocalFragment.this.b().m12547c().size() <= 0) {
                    return;
                }
                c3801a.m7031a(String.format(DroneLocalFragment.this.getString(C2300R.C2303string.ensure_delete_image), DroneLocalFragment.this.b().m12547c().size() + "")).m7034a(DroneLocalFragment.this.getActivity().getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(DroneLocalFragment.this.getString(C2300R.C2303string.delete), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneLocalFragment.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C2238c.m13127b().mo12687a();
                        for (WifiDistanceFile wifiDistanceFile : DroneLocalFragment.this.b().m12547c()) {
                            if (m12544d.contains(wifiDistanceFile)) {
                                File file = new File(wifiDistanceFile.getPath().replace("file://", ""));
                                if (file.exists()) {
                                    file.delete();
                                }
                                m12544d.remove(wifiDistanceFile);
                            }
                            C2196b m13234a = DroneLocalFragment.this.f12856d.m13234a(DroneLocalFragment.this.getActivity(), wifiDistanceFile.getRemoteUrl());
                            if (m13234a != null) {
                                DroneLocalFragment.this.f12856d.m13233a(m13234a);
                            }
                        }
                        DroneLocalFragment.this.b().m12553a(m12544d);
                        DroneLocalFragment.this.b().m12539g();
                        DroneLocalFragment.this.f12858f.sendEmptyMessageDelayed(99, 200L);
                        DroneLocalFragment.this.h(false);
                        C2238c.m13127b().mo12676c();
                        if (m12544d.size() == 0) {
                            DroneLocalFragment.this.d(true);
                        }
                    }
                }).m7030a(DroneLocalFragment.this.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneLocalFragment.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).m7035a().show();
            }
        });
        return onCreateView;
    }

    @Override // com.fimi.soul.module.flyplannermedia.DroneBaseMediaFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(false);
        f(true);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g(true);
        d(false);
        m8738p();
    }
}
