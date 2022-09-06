package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2532e;
import com.fimi.soul.drone.p200f.C2844a;
import com.fimi.soul.entity.DeviceVersion;
import com.fimi.soul.entity.FdsMsg;
import com.fimi.soul.entity.HistoryFileInfo;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.module.setting.C3495f;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.NetUtil;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.biz.n.v */
/* loaded from: classes.dex */
public class C2602v {

    /* renamed from: d */
    private static C2602v f8990d;

    /* renamed from: a */
    AbstractC2564g f8991a;

    /* renamed from: b */
    AbstractC2606b f8992b;

    /* renamed from: c */
    private Context f8993c;

    /* renamed from: f */
    private C2844a f8995f;

    /* renamed from: h */
    private String f8997h;

    /* renamed from: i */
    private String f8998i;

    /* renamed from: e */
    private LinkedList<File> f8994e = new LinkedList<>();

    /* renamed from: g */
    private C2241c f8996g = C2241c.m13122a();

    /* renamed from: j */
    private Handler f8999j = new Handler() { // from class: com.fimi.soul.biz.n.v.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    PlaneMsg planeMsg = new PlaneMsg();
                    planeMsg.setSuccess(false);
                    C2602v.this.f8992b.mo8296a(planeMsg, (String) message.obj);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.fimi.soul.biz.n.v$a */
    /* loaded from: classes.dex */
    class C2605a implements AbstractC2532e {

        /* renamed from: a */
        boolean f9004a = true;

        C2605a() {
        }

        @Override // com.fimi.soul.biz.p183l.AbstractC2532e
        /* renamed from: a */
        public void mo9725a(long j, long j2, String str) {
            if (!this.f9004a || C2602v.this.f8991a == null || j2 / 100 == 0) {
                return;
            }
            C2602v.this.f8991a.mo8297a((int) (j / (j2 / 100)), str);
        }

        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
        /* renamed from: a */
        public void mo6501a(PlaneMsg planeMsg, File file) {
            this.f9004a = planeMsg.isSuccess();
            FdsMsg fdsMsg = (FdsMsg) planeMsg.getData();
            if (C2602v.this.f8995f == null) {
                C2602v.this.f8995f = (C2844a) C2238c.m13125c().mo13118a("0", C2844a.class);
            }
            if (C2353b.m12507c(C2602v.this.f8993c).getUserID() == null) {
                return;
            }
            if (planeMsg.isSuccess()) {
                C2602v.this.m11560a(fdsMsg, file, C2602v.this.f8995f);
            }
            if (C2602v.this.f8992b == null) {
                return;
            }
            C2602v.this.f8992b.mo8296a(planeMsg, file.getPath());
        }
    }

    /* renamed from: com.fimi.soul.biz.n.v$b */
    /* loaded from: classes.dex */
    public interface AbstractC2606b {
        /* renamed from: a */
        void mo8296a(PlaneMsg planeMsg, String str);
    }

    public C2602v(Context context) {
        this.f8993c = context;
    }

    /* renamed from: a */
    public static C2602v m11566a(Context context) {
        if (f8990d == null) {
            f8990d = new C2602v(context);
        }
        return f8990d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11560a(FdsMsg fdsMsg, final File file, C2844a c2844a) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "uploadFlyLog"));
        arrayList.add(new BasicNameValuePair("userID", C2353b.m12507c(this.f8993c).getUserID() != null ? C2353b.m12507c(this.f8993c).getUserID() : "000"));
        arrayList.add(new BasicNameValuePair("planeSsid", C3579a.m7971a().m7970a(0).m7905i()));
        arrayList.add(new BasicNameValuePair("binVersion", C3579a.m7971a().m7970a(0).m7921b() + ""));
        arrayList.add(new BasicNameValuePair("fileFdsUrl", fdsMsg.getUrl()));
        arrayList.add(new BasicNameValuePair("currentTime", C3658ar.m7602b(System.currentTimeMillis())));
        String name = file.getParentFile().getName();
        if (name.equals("NoFly")) {
            arrayList.add(new BasicNameValuePair("isInSky", "1"));
        } else if (name.equals("AirFly")) {
            arrayList.add(new BasicNameValuePair("isInSky", "0"));
        } else {
            arrayList.add(new BasicNameValuePair("isInSky", "0"));
        }
        arrayList.add(new BasicNameValuePair("appType", "0"));
        if (file.getName().endsWith(".sf") || file.getName().endsWith(".fc")) {
            arrayList.add(new BasicNameValuePair("flyLogType", "2"));
            HistoryFileInfo historyFileInfo = (HistoryFileInfo) this.f8996g.mo13118a(file.getName(), HistoryFileInfo.class);
            if (historyFileInfo != null) {
                this.f8997h = historyFileInfo.getFcId();
                this.f8998i = historyFileInfo.getDeviceType();
            }
        } else if (m11558a(file.getName())) {
            int m11554b = m11554b(file.getAbsolutePath());
            if (m11554b == -1) {
                return;
            }
            arrayList.add(new BasicNameValuePair("flyLogType", "" + m11554b));
        } else {
            arrayList.add(new BasicNameValuePair("flyLogType", "0"));
            HistoryFileInfo historyFileInfo2 = (HistoryFileInfo) this.f8996g.mo13118a(file.getName(), HistoryFileInfo.class);
            if (historyFileInfo2 != null) {
                this.f8997h = historyFileInfo2.getFcId();
                this.f8998i = historyFileInfo2.getDeviceType();
            }
        }
        String[] split = file.getName().substring(0, file.getName().lastIndexOf(".")).split(" ");
        if (split != null && split.length > 0) {
            arrayList.add(new BasicNameValuePair("createFlieTime", split[0] + " " + split[1].replace('-', C0359h.f671A)));
        }
        DeviceVersion deviceVersion = new DeviceVersion();
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        try {
            deviceVersion.setAppVer(this.f8993c.getPackageManager().getPackageInfo(this.f8993c.getPackageName(), 16384).versionName);
            deviceVersion.setBatteryVer(c3580b.m7937l() + "");
            deviceVersion.setCamVer(c3580b.m7933n() + "");
            deviceVersion.setFcVer(c3580b.m7959a() + "");
            deviceVersion.setGcVer(c3580b.m7955c() + "");
            deviceVersion.setNoflyVer(c3580b.m7947g() + "");
            deviceVersion.setRcVer(c3580b.m7957b() + "");
            deviceVersion.setServVer(c3580b.m7945h() + "");
            deviceVersion.setX2Ver(c3580b.m7949f() + "");
            deviceVersion.setX6D4kVer(c3580b.m7939k() + "");
            deviceVersion.setX6RVer(c3580b.m7951e() + "");
            arrayList.add(new BasicNameValuePair("fwsVersion", new Gson().toJson(deviceVersion)));
        } catch (Exception e) {
        }
        if (this.f8997h == null || this.f8998i == null) {
            arrayList.add(new BasicNameValuePair("fcId", " "));
            arrayList.add(new BasicNameValuePair("deviceType", " "));
        } else {
            arrayList.add(new BasicNameValuePair("fcId", this.f8997h));
            arrayList.add(new BasicNameValuePair("deviceType", this.f8998i));
        }
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.n.v.1
            @Override // java.lang.Runnable
            public void run() {
                String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, C2602v.this.f8993c);
                PlaneMsg planeMsg = new PlaneMsg();
                planeMsg.setFile(file);
                try {
                    if ("true".equals(new JSONObject(m7762b).getString("success"))) {
                        if (C2602v.this.f8992b != null) {
                            planeMsg.setSuccess(true);
                            C2602v.this.f8992b.mo8296a(planeMsg, file.getPath());
                            C2602v.this.f8996g.m13107e(file.getName());
                        } else {
                            planeMsg.setSuccess(false);
                            C2602v.this.f8992b.mo8296a(planeMsg, file.getPath());
                        }
                    }
                } catch (Exception e2) {
                    Log.e("good", e2.toString());
                    C2602v.this.f8999j.obtainMessage(0, file.getPath()).sendToTarget();
                }
            }
        });
    }

    /* renamed from: a */
    public void m11567a() {
        File[] listFiles;
        File[] listFiles2;
        File file;
        File[] listFiles3;
        File file2;
        try {
            File file3 = new File(C3681j.m7482a() + "/fw_upgrade/FMLink_Up_Log/");
            file3.mkdirs();
            if (file3.exists()) {
                for (File file4 : file3.listFiles()) {
                    if (file4 != null && (file2 = new File(file3, file4.getName())) != null && file2.exists()) {
                        file2.delete();
                    }
                }
                file3.delete();
            }
            File file5 = new File(C3681j.m7482a() + "/fw_upgrade/FMLink_Down_Log/");
            file5.mkdirs();
            if (file5.exists()) {
                for (File file6 : file5.listFiles()) {
                    if (file6 != null && (file = new File(file5, file6.getName())) != null && file.exists()) {
                        file.delete();
                    }
                }
                file5.delete();
            }
            File file7 = new File(C3658ar.m7568n(this.f8993c));
            if (file7.exists()) {
                file7.delete();
            }
            File file8 = new File(C3681j.m7482a() + "/SAVEDRONEINFO/");
            file8.mkdirs();
            if (!file8.exists()) {
                return;
            }
            for (File file9 : file8.listFiles()) {
                if (file9 != null && file9.exists()) {
                    file9.delete();
                }
            }
            file8.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m11565a(AbstractC2564g abstractC2564g) {
        this.f8991a = abstractC2564g;
    }

    /* renamed from: a */
    public void m11564a(AbstractC2606b abstractC2606b) {
        this.f8992b = abstractC2606b;
    }

    /* renamed from: a */
    public void m11559a(File file) {
        C2562f.m11683a(this.f8993c).m11676a(file, (AbstractC2532e) new C2605a());
    }

    /* renamed from: a */
    public boolean m11558a(String str) {
        return str.endsWith(C3495f.f13782a);
    }

    /* renamed from: b */
    public int m11554b(String str) {
        if (str.contains(C3681j.m7462q())) {
            return 5;
        }
        if (str.contains(C3681j.m7461r())) {
            return 4;
        }
        return str.contains(C3681j.m7460s()) ? 6 : -1;
    }

    /* renamed from: b */
    public void m11557b() {
        File[] listFiles;
        File file;
        this.f8994e.clear();
        this.f8995f = (C2844a) C2238c.m13125c().mo13118a("0", C2844a.class);
        if (this.f8995f != null) {
            String str = this.f8995f.m10823d() + "" + this.f8995f.m10821e() + "" + this.f8995f.m10819g();
        }
        File file2 = new File(C3681j.m7482a() + "/SAVEDRONEINFO/");
        file2.mkdirs();
        if (!file2.exists() || !C3658ar.m7593c(this.f8993c)) {
            return;
        }
        for (File file3 : file2.listFiles()) {
            if (file3 != null && (file = new File(file2, file3.getName())) != null && file.exists()) {
                file.delete();
            }
        }
        file2.delete();
    }

    /* renamed from: b */
    public void m11555b(File file) {
        C2562f.m11683a(this.f8993c).m11677a(file);
    }

    /* renamed from: c */
    public void m11553c() {
        C2562f.m11683a(this.f8993c).m11684a();
    }

    /* renamed from: c */
    public void m11551c(File file) {
        C2562f.m11683a(this.f8993c).m11670b(file, new C2605a());
    }

    /* renamed from: d */
    public AbstractC2606b m11550d() {
        return this.f8992b;
    }

    /* renamed from: d */
    public void m11548d(File file) {
        C2562f.m11683a(this.f8993c).m11671b(file);
    }
}
