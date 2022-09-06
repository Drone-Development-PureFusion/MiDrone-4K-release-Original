package com.fimi.soul.biz.camera;

import android.os.AsyncTask;
import android.os.Message;
import android.util.Log;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.AbstractC2228e;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.kernel.p157b.p160c.AbstractC2218a;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.p157b.p162e.C2230b;
import com.fimi.kernel.utils.C2259g;
import com.fimi.kernel.utils.C2276u;
import com.fimi.kernel.utils.C2281x;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.entity.X11ApWifiConfig;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11FileSystem;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.entity.X11SystemConfig;
import com.fimi.soul.biz.camera.p171a.C2377b;
import com.fimi.soul.biz.camera.p172b.AbstractC2385c;
import com.fimi.soul.biz.camera.p172b.AbstractC2386d;
import com.fimi.soul.biz.camera.p172b.AbstractC2387e;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.camera.p172b.AbstractC2389g;
import com.fimi.soul.biz.camera.p173c.AbstractC2404a;
import com.fimi.soul.biz.p168a.C2355b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.CameraMountState;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.module.droneFragment.ShowDroneUiFragment;
import com.fimi.soul.utils.C3637ag;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3676e;
import com.fimi.soul.utils.C3681j;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.fimi.soul.biz.camera.c */
/* loaded from: classes.dex */
public abstract class AbstractC2390c extends AbstractC2375a implements AbstractC2389g {

    /* renamed from: d */
    private static final int f8058d = 1024;

    /* renamed from: e */
    private static final int f8059e = 1025;

    /* renamed from: f */
    private static final int f8060f = 2048;

    /* renamed from: g */
    private static final int f8061g = 2049;

    /* renamed from: h */
    private static final int f8062h = 4096;

    /* renamed from: i */
    private static int f8063i = -1;

    /* renamed from: x */
    private static final long f8064x = 1500;

    /* renamed from: E */
    private AbstractC2221d f8069E;

    /* renamed from: I */
    private AbstractC2386d f8073I;

    /* renamed from: a */
    C2423d f8074a;

    /* renamed from: o */
    private AbstractC2388f<X11RespCmd> f8082o;

    /* renamed from: p */
    private AbstractC2221d f8083p;

    /* renamed from: q */
    private AbstractC2218a f8084q;

    /* renamed from: r */
    private DataOutputStream f8085r;

    /* renamed from: s */
    private AbstractC2387e f8086s;

    /* renamed from: u */
    private AbstractC2402c f8088u;

    /* renamed from: v */
    private AbstractC2403d f8089v;

    /* renamed from: w */
    private C2205c f8090w;

    /* renamed from: k */
    private EnumC2400a f8078k = EnumC2400a.Normal;

    /* renamed from: t */
    private StringBuilder f8087t = new StringBuilder();

    /* renamed from: y */
    private long f8091y = System.currentTimeMillis();

    /* renamed from: z */
    private boolean f8092z = false;

    /* renamed from: A */
    private boolean f8065A = true;

    /* renamed from: B */
    private boolean f8066B = false;

    /* renamed from: C */
    private boolean f8067C = true;

    /* renamed from: c */
    ExecutorService f8076c = Executors.newSingleThreadExecutor();

    /* renamed from: F */
    private long f8070F = 0;

    /* renamed from: G */
    private String f8071G = null;

    /* renamed from: H */
    private CameraMountState f8072H = CameraMountState.IDLE;

    /* renamed from: D */
    private C2657a f8068D = DroidPlannerApp.m12519h().f7895a;

    /* renamed from: l */
    private X11SystemConfig f8079l = new X11SystemConfig();

    /* renamed from: j */
    private X11ApWifiConfig f8077j = new X11ApWifiConfig();

    /* renamed from: m */
    private X11FileSystem f8080m = new X11FileSystem();

    /* renamed from: b */
    C2367d f8075b = C2367d.m12459a();

    /* renamed from: n */
    private List<AbstractC2388f<X11RespCmd>> f8081n = new ArrayList();

    /* renamed from: com.fimi.soul.biz.camera.c$a */
    /* loaded from: classes.dex */
    public enum EnumC2400a {
        IDLE,
        Normal,
        Recoding,
        ContinueCapturing,
        PhotoShoting
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.camera.c$b */
    /* loaded from: classes.dex */
    public class AsyncTaskC2401b extends AsyncTask<String, Void, X11RespCmd> {
        AsyncTaskC2401b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public X11RespCmd doInBackground(String... strArr) {
            X11RespCmd m12355b = AbstractC2390c.this.m12355b(strArr[0]);
            if (m12355b != null && m12355b.getMsg_id() == 1282) {
                Map<String, List<X11FileInfo>> fileList = AbstractC2390c.this.f8080m.getFileList();
                if (m12355b.getListing() != null) {
                    try {
                        HashMap hashMap = new HashMap();
                        for (LinkedTreeMap linkedTreeMap : (List) m12355b.getListing()) {
                            for (String str : linkedTreeMap.keySet()) {
                                hashMap.put(str, linkedTreeMap.get(str));
                            }
                        }
                        List<X11FileInfo> m12364a = AbstractC2390c.this.m12364a(hashMap);
                        if (m12364a != null) {
                            fileList.put(AbstractC2390c.this.f8080m.getCurPath(), m12364a);
                        }
                    } catch (Exception e) {
                    }
                    AbstractC2390c.this.m12363a(false);
                }
            }
            return m12355b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(X11RespCmd x11RespCmd) {
            AbstractC2390c.this.m12368a(x11RespCmd);
        }
    }

    /* renamed from: com.fimi.soul.biz.camera.c$c */
    /* loaded from: classes.dex */
    public interface AbstractC2402c {
        /* renamed from: a */
        void m12299a(String str, long j, long j2);
    }

    /* renamed from: com.fimi.soul.biz.camera.c$d */
    /* loaded from: classes.dex */
    public interface AbstractC2403d {
        /* renamed from: a */
        void mo9548a(EnumC2400a enumC2400a, EnumC2400a enumC2400a2);
    }

    public AbstractC2390c(AbstractC2385c abstractC2385c) {
        a(abstractC2385c);
        new C2355b();
        m12348d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<X11FileInfo> m12364a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            X11FileInfo x11FileInfo = new X11FileInfo();
            x11FileInfo.setName(str);
            if (!str.toUpperCase().contains("THM")) {
                x11FileInfo.setLocalPath(C3681j.m7482a() + "X1/");
                String curPath = m12337l().getCurPath();
                x11FileInfo.setAbsolutePath(curPath + "/" + str);
                x11FileInfo.setRemotePath(curPath.substring(curPath.indexOf("DCIM"), curPath.length()) + "/" + str);
                String[] split = map.get(str).split("\\|");
                x11FileInfo.setSize(Long.parseLong(split[0].replace(" bytes", "").trim()));
                x11FileInfo.setCreateDate(split[1]);
                arrayList.add(x11FileInfo);
            }
        }
        Collections.sort(arrayList, new Comparator<X11FileInfo>() { // from class: com.fimi.soul.biz.camera.c.5
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(X11FileInfo x11FileInfo2, X11FileInfo x11FileInfo3) {
                return x11FileInfo2.getCreateDate().replaceAll("[-\\s:]", "").compareTo(x11FileInfo3.getCreateDate().replaceAll("[-\\s:]", ""));
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m12387a(int i, byte[] bArr) {
        X11FileInfo curDownloadFile = m12337l().getCurDownloadFile();
        Log.d("Good", "len:" + i + "  path" + curDownloadFile.getLocalPath() + " name:" + curDownloadFile.getName() + "downloading:" + i);
        if (curDownloadFile != null) {
            try {
                String str = curDownloadFile.getLocalPath() + curDownloadFile.getName();
                if (i != -1) {
                    if (this.f8085r == null) {
                        this.f8070F = 0L;
                        File file = new File(curDownloadFile.getLocalPath());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(str);
                        if (file2.exists()) {
                            C3658ar.m7608a(file2);
                        }
                        file2.createNewFile();
                        this.f8085r = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
                    }
                    this.f8070F += i;
                    this.f8085r.write(bArr, 0, i);
                    if (this.f8088u != null) {
                        this.f8088u.m12299a(curDownloadFile.getName(), this.f8070F, curDownloadFile.getSize());
                    }
                    m12369a(curDownloadFile);
                    this.f8071G = str;
                }
            } catch (Exception e) {
                Log.d("Good", "ERROR" + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12368a(X11RespCmd x11RespCmd) {
        boolean z;
        if (x11RespCmd == null) {
            X11RespCmd x11RespCmd2 = new X11RespCmd();
            x11RespCmd2.setMsg_id(C2427e.f8234ak);
            Log.d("Good", "UNkown");
            if (this.f8082o == null) {
                return;
            }
            this.f8082o.mo6450a(false, x11RespCmd2);
            return;
        }
        this.f8087t.delete(0, this.f8087t.length());
        if (x11RespCmd.getRval() >= 0) {
            z = true;
        } else {
            m12350c(x11RespCmd);
            z = false;
        }
        if (x11RespCmd.isNotification()) {
            m12356b(x11RespCmd);
        } else {
            for (AbstractC2388f<X11RespCmd> abstractC2388f : this.f8081n) {
                abstractC2388f.mo6450a(z, x11RespCmd);
            }
        }
        if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.PhotoTaken) {
            m12363a(true);
            if (C2238c.m13123e().m12779b().booleanValue()) {
                String obj = x11RespCmd.getParam().toString();
                if (!"".equalsIgnoreCase(obj)) {
                    this.f8090w = C2205c.m13235a(C2238c.m13131a());
                    this.f8090w.m13229a(String.format("http://%s//%s", C2427e.f8197a, obj.substring(obj.indexOf("DCIM"), obj.length())), "", 0L, true, C3681j.m7478b(obj.substring(obj.lastIndexOf("/") + 1, obj.length())));
                }
            }
        } else if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.CardInsert) {
            C2259g.m12987b(new File(C3681j.m7465n()));
            m12354b(true);
        } else if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.CardRemoved) {
            C2259g.m12987b(new File(C3681j.m7465n()));
            m12354b(false);
        } else if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.FmLsEnd) {
            x11RespCmd.setNotificationType(X11RespCmd.NotificationType.FmLsEnd);
            m12366a(Boolean.valueOf(z), x11RespCmd);
            m12363a(false);
        } else if (x11RespCmd.getMsg_id() != 4 || !z) {
            if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.StartingVideoRecord) {
                if (this.f8090w == null) {
                    this.f8090w = C2205c.m13235a(C2238c.m13131a());
                }
                this.f8090w.m13225d();
            } else if (x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.VideoRecordComplete) {
                if (this.f8090w == null) {
                    this.f8090w = C2205c.m13235a(C2238c.m13131a());
                }
                this.f8090w.m13224e();
            }
        } else if (m12337l().getInfos() != null) {
            m12337l().getInfos().clear();
        }
        if (this.f8082o == null || x11RespCmd.getNotificationType() == X11RespCmd.NotificationType.FmLsEnd) {
            return;
        }
        this.f8082o.mo6450a(z, x11RespCmd);
    }

    /* renamed from: a */
    private void m12366a(final Boolean bool, final X11RespCmd x11RespCmd) {
        ((C2230b) C2238c.m13128a(EnumC2222d.Volley)).mo13145b(C2427e.m12217e(), new AbstractC2228e<String>() { // from class: com.fimi.soul.biz.camera.c.6
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(String str) {
                if (str == null || "".equals(str)) {
                    if (AbstractC2390c.this.f8082o == null) {
                        return;
                    }
                    AbstractC2390c.this.f8082o.mo6450a(false, x11RespCmd);
                    return;
                }
                String[] split = str.split("\n");
                ArrayList arrayList = new ArrayList();
                for (String str2 : split) {
                    String[] split2 = str2.split("\\|");
                    if (split2.length > 3) {
                        X11FileInfo x11FileInfo = new X11FileInfo();
                        String trim = split2[0].trim();
                        String trim2 = split2[1].trim();
                        String trim3 = split2[2].trim();
                        String trim4 = split2[3].trim();
                        x11FileInfo.setSize(Long.parseLong(trim));
                        x11FileInfo.setName(trim3);
                        String m7580f = C3658ar.m7580f(trim2);
                        if (m7580f != null) {
                            x11FileInfo.setCreateDate(m7580f);
                        }
                        x11FileInfo.setLocalPath(C3681j.m7482a() + "X1/");
                        x11FileInfo.setAbsolutePath(C2427e.f8322cS + trim4 + trim3);
                        x11FileInfo.setRemotePath(trim4 + trim3);
                        arrayList.add(x11FileInfo);
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    AbstractC2390c.this.m12337l().setInfos(arrayList);
                }
                if (AbstractC2390c.this.f8082o == null) {
                    return;
                }
                AbstractC2390c.this.f8082o.mo6450a(bool.booleanValue(), x11RespCmd);
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(String str) {
                if (AbstractC2390c.this.f8082o != null) {
                    AbstractC2390c.this.f8082o.mo6450a(false, x11RespCmd);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12365a(String str) {
        if (str.contains("\"msg_id\":1282")) {
            new AsyncTaskC2401b().executeOnExecutor(this.f8076c, str);
            return;
        }
        X11RespCmd m12355b = m12355b(str);
        if (m12355b == null) {
            this.f8087t.append(str);
            m12355b = m12355b(this.f8087t.toString());
        }
        Log.i("progresss", "moweiru return:  " + str);
        m12368a(m12355b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public X11RespCmd m12355b(String str) {
        try {
            return (X11RespCmd) C3637ag.m7708a(str, new TypeToken<X11RespCmd<String>>() { // from class: com.fimi.soul.biz.camera.c.7
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return (X11RespCmd) C3637ag.m7708a(str, new TypeToken<X11RespCmd<List<String>>>() { // from class: com.fimi.soul.biz.camera.c.8
                }.getType());
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return (X11RespCmd) C3637ag.m7708a(str, new TypeToken<X11RespCmd<Object>>() { // from class: com.fimi.soul.biz.camera.c.9
                    }.getType());
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
        }
    }

    /* renamed from: b */
    private void m12356b(X11RespCmd x11RespCmd) {
        Log.d("Good", "Notification:" + x11RespCmd.getType());
        if (x11RespCmd.getMsg_id() == 7) {
            if (C2427e.f8237an.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.DisconnectHDMI);
            }
            if (C2427e.f8238ao.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.DisconnectShutDown);
            }
            if (C2427e.f8239ap.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.StartingVideoRecord);
            }
            if (C2427e.f8240aq.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.VideoRecordComplete);
            }
            if (C2427e.f8241ar.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.PhotoTaken);
                m12329t();
            }
            if (C2427e.f8242as.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.ContinueCaputureStarted);
                this.f8078k = EnumC2400a.ContinueCapturing;
            }
            if (C2427e.f8243at.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.ContinueCaptureStoped);
                m12329t();
            }
            if (C2427e.f8244au.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.ContinueCaputureStarted);
                m12329t();
            }
            if (C2427e.f8245av.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.ContiuneBurstCompleted);
                m12329t();
            }
            if (C2427e.f8247ax.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.LowBatteryWarning);
            }
            if (C2427e.f8246aw.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.LowStorageWarning);
            }
            if (C2427e.f8248ay.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.TimeLapseVideoStatus);
            }
            if (C2427e.f8249az.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.TimeLapsePhotoStatus);
            }
            if (C2427e.f8198aA.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CameraConnectToPc);
            }
            if (C2427e.f8199aB.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.LogUpdated);
            }
            if (C2427e.f8200aC.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.PowerModeChange);
            }
            if (C2427e.f8201aD.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.VFStarted);
            }
            if (C2427e.f8202aE.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.VFStoped);
            }
            if (C2427e.f8203aF.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.AutoFileDelete);
            }
            if (C2427e.f8204aG.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.StorageRunOut);
            }
            if (C2427e.f8205aH.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.StorageIOError);
            }
            if (C2427e.f8206aI.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.LowSpeedCard);
            }
            if (C2427e.f8207aJ.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.MuxerIndexLimit);
            }
            if (C2427e.f8208aK.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.MuxerFileSizeLimit);
            }
            if (C2427e.f8209aL.equals(x11RespCmd.getType())) {
                C2238c.m13123e().m12772c(true);
                C2238c.m13123e().m12768d(true);
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CardRemoved);
            }
            if (C2427e.f8210aM.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CardInsert);
            }
            if (C2427e.f8212aO.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.PhotoFinish);
            }
            if (C2427e.f8211aN.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CannotIssuePIV);
            }
            if (C2427e.f8223aZ.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.PutFileComplete);
            }
            if (C2427e.f8282bf.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.FmLsEnd);
            }
            if (C2427e.f8213aP.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_FILE_SYS_ERROR);
            }
            if (C2427e.f8214aQ.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_PARAM_ERR);
            }
            if (C2427e.f8215aR.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_NO_PROPOSE);
            }
            if (C2427e.f8216aS.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_NO_PROPOSE_AND_PARAM_ERR);
            }
            if (C2427e.f8217aT.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_WRITE_LOW);
            }
            if (C2427e.f8218aU.equals(x11RespCmd.getType())) {
                x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_WRITE_LOW_AND_PARAM_ERR);
            }
            if (!C2427e.f8219aV.equals(x11RespCmd.getType())) {
                return;
            }
            x11RespCmd.setNotificationType(X11RespCmd.NotificationType.CARD_SETROOT_ERROR);
        }
    }

    /* renamed from: c */
    private void m12350c(X11RespCmd x11RespCmd) {
        switch (x11RespCmd.getRval()) {
            case C2427e.f8294br /* -17 */:
                m12339j().setFreeKBSpace(0L);
                return;
            case -4:
            case -3:
                f8063i = -1;
                return;
            case -1:
                if (x11RespCmd.getMsg_id() != 5) {
                    return;
                }
                m12339j().setFreeKBSpace(0L);
                return;
            default:
                return;
        }
    }

    /* renamed from: t */
    private void m12329t() {
        this.f8078k = EnumC2400a.Normal;
    }

    /* renamed from: a */
    public void m12388a(int i) {
        f8063i = i;
        if (i > 0) {
            CameraValue.hasSession = true;
        } else {
            CameraValue.hasSession = false;
        }
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
        if (message.what == 1024) {
            X11FileInfo x11FileInfo = (X11FileInfo) message.obj;
            if (this.f8086s == null) {
                return;
            }
            this.f8086s.mo8717a(x11FileInfo.getLocalPath(), x11FileInfo.getName());
        } else if (message.what == 1025) {
            X11RespCmd x11RespCmd = new X11RespCmd();
            x11RespCmd.setMsg_id(C2427e.f8236am);
            Log.d("Good", "下载失败");
            if (this.f8082o == null) {
                return;
            }
            this.f8082o.mo6450a(false, x11RespCmd);
        } else if (message.what == 2048) {
            X11RespCmd x11RespCmd2 = new X11RespCmd();
            x11RespCmd2.setMsg_id(C2427e.f8232ai);
            Log.d("Good", "相机连接超时");
            if (this.f8067C && this.f8080m.getCurDirFileList() != null) {
                this.f8080m.getCurDirFileList().clear();
            }
            if (this.f8082o == null) {
                return;
            }
            this.f8082o.mo6450a(false, x11RespCmd2);
        } else if (message.what == 4096) {
            X11RespCmd x11RespCmd3 = new X11RespCmd();
            x11RespCmd3.setMsg_id(C2427e.f8235al);
            if (this.f8082o == null) {
                return;
            }
            this.f8082o.mo6450a(false, x11RespCmd3);
            boolean z = this.f8082o instanceof ShowDroneUiFragment;
            synchronized (this) {
                if (!z) {
                    if (this.f8073I != null) {
                        C3676e.m7493a().m7492a("onMount " + z);
                        this.f8073I.mo6637b(false, x11RespCmd3);
                    }
                }
            }
        } else if (message.what != f8061g) {
        } else {
            X11RespCmd x11RespCmd4 = new X11RespCmd();
            x11RespCmd4.setMsg_id(C2427e.f8233aj);
            if (this.f8082o == null) {
                return;
            }
            this.f8082o.mo6450a(false, x11RespCmd4);
            boolean z2 = this.f8082o instanceof ShowDroneUiFragment;
            synchronized (this) {
                if (!z2) {
                    if (this.f8073I != null) {
                        this.f8073I.mo6635c(false, x11RespCmd4);
                        C3676e.m7493a().m7492a(" onDisMount " + z2);
                    }
                }
            }
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: a */
    public void mo12386a(AbstractC2218a abstractC2218a) {
        ((AbstractC2389g) b()).mo12386a(abstractC2218a);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    @Deprecated
    /* renamed from: a */
    public void mo12385a(AbstractC2221d abstractC2221d) {
        ((AbstractC2389g) b()).mo12385a(abstractC2221d);
    }

    /* renamed from: a */
    public synchronized void m12384a(AbstractC2386d abstractC2386d) {
        this.f8073I = abstractC2386d;
    }

    /* renamed from: a */
    public void m12383a(AbstractC2387e abstractC2387e) {
        this.f8086s = abstractC2387e;
    }

    /* renamed from: a */
    public void m12382a(AbstractC2388f<X11RespCmd> abstractC2388f) {
        this.f8082o = abstractC2388f;
    }

    /* renamed from: a */
    public void m12381a(EnumC2400a enumC2400a) {
        this.f8078k = enumC2400a;
    }

    /* renamed from: a */
    public void m12380a(AbstractC2402c abstractC2402c) {
        this.f8088u = abstractC2402c;
    }

    /* renamed from: a */
    public void m12379a(AbstractC2403d abstractC2403d) {
        this.f8089v = abstractC2403d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12378a(AbstractC2404a abstractC2404a) {
        if (abstractC2404a != null) {
            this.f8081n.add(abstractC2404a);
        }
    }

    /* renamed from: a */
    public void m12370a(X11ApWifiConfig x11ApWifiConfig) {
        this.f8077j = x11ApWifiConfig;
    }

    /* renamed from: a */
    public void m12369a(X11FileInfo x11FileInfo) {
        if (x11FileInfo.getSize() == 0 || this.f8070F < x11FileInfo.getSize() || this.f8085r == null) {
            return;
        }
        Log.d("Good", "下载完毕:" + this.f8070F);
        try {
            this.f8085r.close();
            this.f8085r = null;
            String md5 = x11FileInfo.getMd5();
            File file = new File(x11FileInfo.getLocalPath() + x11FileInfo.getName());
            String m12789a = (file == null || !file.isFile() || !file.exists()) ? "" : C2276u.m12789a(file);
            Message message = new Message();
            if (md5 == null || m12789a.equals(md5)) {
                message.what = 1024;
                message.obj = x11FileInfo;
                m12337l().setCurDownloadFile(null);
            } else {
                file.delete();
                message.what = 1025;
            }
            a().sendMessageDelayed(message, 200L);
            this.f8070F = 0L;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public synchronized void m12367a(CameraMountState cameraMountState) {
        if (this.f8073I != null && cameraMountState != this.f8072H && (this.f8072H != CameraMountState.IDLE || cameraMountState != CameraMountState.DISMOUNT)) {
            boolean mo11216ac = this.f8068D.mo11216ac();
            if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
                mo11216ac = true;
            }
            if (mo11216ac && cameraMountState == CameraMountState.MOUNT) {
                C3676e.m7493a().m7492a("CameraMountState changeMountState 11 " + this.f8072H + " --->" + cameraMountState);
                this.f8072H = cameraMountState;
                a().sendEmptyMessage(4096);
            } else if (cameraMountState == CameraMountState.DISMOUNT) {
                C3676e.m7493a().m7492a(" CameraMountState changeMountState 22 " + this.f8072H + " --->" + cameraMountState);
                this.f8072H = cameraMountState;
                a().sendEmptyMessage(f8061g);
            }
        }
    }

    /* renamed from: a */
    public void m12363a(boolean z) {
        this.f8067C = z;
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2385c
    /* renamed from: a */
    public void mo12362a(byte[] bArr) {
        b().mo12362a(bArr);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: a */
    public void mo12361a(byte[] bArr, int i, int i2) {
        ((AbstractC2389g) b()).mo12361a(bArr, i, i2);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    /* renamed from: b */
    public void mo12360b(AbstractC2218a abstractC2218a) {
        ((AbstractC2389g) b()).mo12360b(abstractC2218a);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2389g
    @Deprecated
    /* renamed from: b */
    public void mo12359b(AbstractC2221d abstractC2221d) {
        ((AbstractC2389g) b()).mo12359b(abstractC2221d);
    }

    /* renamed from: b */
    public void m12354b(boolean z) {
        this.f8065A = z;
    }

    /* renamed from: c */
    public void m12352c(AbstractC2221d abstractC2221d) {
        ((AbstractC2389g) b()).mo12385a(this.f8069E);
        this.f8069E = abstractC2221d;
        ((AbstractC2389g) b()).mo12359b(this.f8069E);
    }

    /* renamed from: c */
    public void m12349c(boolean z) {
        this.f8066B = z;
    }

    /* renamed from: c */
    public boolean m12353c() {
        return this.f8067C;
    }

    /* renamed from: d */
    public void m12348d() {
        if (this.f8083p == null) {
            this.f8083p = new AbstractC2221d() { // from class: com.fimi.soul.biz.camera.c.1
                @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
                /* renamed from: a */
                public void mo6431a(String str) {
                    AbstractC2390c.this.m12365a(str);
                }
            };
            mo12359b(this.f8083p);
            a(new Runnable() { // from class: com.fimi.soul.biz.camera.c.2
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        try {
                            Thread.sleep(AbstractC2390c.f8064x);
                        } catch (InterruptedException e) {
                            e = e;
                        }
                        if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
                            if (!AbstractC2390c.this.f8066B) {
                                if (!AbstractC2390c.this.m12346e()) {
                                    AbstractC2390c.this.m12367a(CameraMountState.DISMOUNT);
                                }
                            } else if (AbstractC2390c.this.f8075b.m12435n()) {
                                AbstractC2390c.this.f8092z = AbstractC2390c.this.f8075b.m12436m();
                                if (!C2367d.m12459a().m12438k()) {
                                    AbstractC2390c.this.f8092z = C3658ar.m7587d(C2427e.f8197a);
                                }
                            } else {
                                AbstractC2390c.this.f8092z = C3658ar.m7587d(C2427e.f8197a);
                                AbstractC2390c.this.f8075b.m12455a(AbstractC2390c.this.f8092z);
                            }
                        } else if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
                            AbstractC2390c.this.f8092z = C3658ar.m7587d(C2427e.f8197a);
                        }
                        if (AbstractC2390c.this.f8092z) {
                            int i3 = i2 + 1;
                            try {
                                if (AbstractC2390c.this.m12346e()) {
                                    AbstractC2390c.this.m12367a(CameraMountState.MOUNT);
                                    i2 = i3;
                                    i = 0;
                                } else if (((C2423d) C2379b.m12410a().m12394d()) != null) {
                                    ((C2423d) C2379b.m12410a().m12394d()).m12231w().m12240b();
                                    i2 = i3;
                                    i = 0;
                                } else {
                                    i2 = i3;
                                    i = 0;
                                }
                            } catch (InterruptedException e2) {
                                e = e2;
                                i2 = i3;
                                i = 0;
                                e.printStackTrace();
                            }
                        } else {
                            i++;
                            i2 = 0;
                        }
                        if (i > 1) {
                            if (AbstractC2390c.this.m12346e()) {
                                AbstractC2390c.this.m12388a(-1);
                            }
                            AbstractC2390c.this.m12367a(CameraMountState.DISMOUNT);
                        } else if (!AbstractC2390c.this.m12346e() && i2 > 1) {
                            if (System.currentTimeMillis() - AbstractC2390c.this.f8091y > 7500) {
                                AbstractC2390c.this.f8091y = System.currentTimeMillis();
                                AbstractC2390c.this.m12332q();
                            }
                            AbstractC2390c.this.a().sendEmptyMessageDelayed(2048, 500L);
                        } else if (AbstractC2390c.this.m12346e() && "".equalsIgnoreCase(AbstractC2390c.this.m12339j().getDvVersion())) {
                            AbstractC2390c.this.f8074a = (C2423d) C2379b.m12410a().m12394d();
                            AbstractC2390c.this.f8074a.m12233u().m12281k();
                        }
                    }
                }
            });
        }
        if (this.f8084q == null) {
            this.f8084q = new AbstractC2218a() { // from class: com.fimi.soul.biz.camera.c.3
                @Override // com.fimi.kernel.p157b.p160c.AbstractC2218a
                /* renamed from: a */
                public void mo12328a(int i, byte[] bArr) {
                    AbstractC2390c.this.m12387a(i, bArr);
                }
            };
            mo12386a(this.f8084q);
        }
    }

    /* renamed from: e */
    public boolean m12346e() {
        return f8063i > 0;
    }

    /* renamed from: f */
    public int m12344f() {
        return f8063i;
    }

    /* renamed from: g */
    public EnumC2400a m12342g() {
        return this.f8078k;
    }

    /* renamed from: h */
    public boolean m12341h() {
        return m12342g() != EnumC2400a.Normal;
    }

    /* renamed from: i */
    public boolean m12340i() {
        return this.f8065A;
    }

    /* renamed from: j */
    public X11SystemConfig m12339j() {
        return this.f8079l;
    }

    /* renamed from: k */
    public X11ApWifiConfig m12338k() {
        return this.f8077j;
    }

    /* renamed from: l */
    public X11FileSystem m12337l() {
        return this.f8080m;
    }

    /* renamed from: m */
    public AbstractC2403d m12336m() {
        return this.f8089v;
    }

    /* renamed from: n */
    public void m12335n() {
        if (b() != null && (b() instanceof C2377b)) {
            ((C2377b) b()).m12416b();
            Log.v("Good", "disConnect");
        }
    }

    /* renamed from: o */
    public boolean m12334o() {
        if (b() != null && (b() instanceof C2377b)) {
            return ((C2377b) b()).m12415c();
        }
        return false;
    }

    /* renamed from: p */
    public void m12333p() {
        C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.biz.camera.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC2390c.this.b() instanceof C2377b) {
                    ((C2377b) AbstractC2390c.this.b()).m12413e();
                }
            }
        });
    }

    /* renamed from: q */
    public void m12332q() {
        if (b() != null && (b() instanceof C2377b)) {
            ((C2377b) b()).m12414d();
            Log.v("Good", "disConnect");
        }
    }

    /* renamed from: r */
    public synchronized void m12331r() {
        this.f8072H = CameraMountState.IDLE;
    }

    /* renamed from: s */
    public boolean m12330s() {
        return this.f8072H == CameraMountState.MOUNT;
    }
}
