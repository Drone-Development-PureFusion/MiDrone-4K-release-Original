package com.fimi.soul.biz.p181j;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p178g.C2444a;
import com.fimi.soul.biz.p181j.C2496e;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2871ab;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2935s;
import com.fimi.soul.drone.p203i.C2936t;
import com.fimi.soul.entity.DynamicDYZ_Entity;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.service.QueryDynamicFlyZoneSetvice;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3684m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.soul.biz.j.i */
/* loaded from: classes.dex */
public class C2502i implements C2678d.AbstractC2680b {

    /* renamed from: a */
    public static final String f8641a = "FCDEVICEID";

    /* renamed from: j */
    private static final int f8642j = 1;

    /* renamed from: k */
    private static final int f8643k = 15000;

    /* renamed from: o */
    private static final int f8644o = 20;

    /* renamed from: p */
    private static final int f8645p = 30;

    /* renamed from: b */
    private int f8646b;

    /* renamed from: c */
    private C2657a f8647c;

    /* renamed from: d */
    private C3057d f8648d;

    /* renamed from: h */
    private double f8652h;

    /* renamed from: l */
    private HandlerC2506b f8654l;

    /* renamed from: e */
    private double f8649e = 1000000.0d;

    /* renamed from: f */
    private int f8650f = 0;

    /* renamed from: i */
    private int f8653i = 20;

    /* renamed from: m */
    private boolean f8655m = true;

    /* renamed from: n */
    private Object f8656n = new Object();

    /* renamed from: q */
    private C2496e f8657q = C2496e.m11922a();

    /* renamed from: r */
    private double f8658r = 0.0d;

    /* renamed from: g */
    private C2501h f8651g = C2501h.m11907a();

    /* renamed from: com.fimi.soul.biz.j.i$a */
    /* loaded from: classes.dex */
    class C2505a implements Comparator<DynamicDYZ_Entity> {
        C2505a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(DynamicDYZ_Entity dynamicDYZ_Entity, DynamicDYZ_Entity dynamicDYZ_Entity2) {
            return (int) (dynamicDYZ_Entity.getDistance() - dynamicDYZ_Entity2.getDistance());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.j.i$b */
    /* loaded from: classes.dex */
    public static class HandlerC2506b extends Handler {

        /* renamed from: a */
        private C2657a f8662a;

        /* renamed from: b */
        private C2502i f8663b;

        public HandlerC2506b(C2657a c2657a, C2502i c2502i, Looper looper) {
            this.f8662a = c2657a;
            this.f8663b = c2502i;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f8663b != null) {
                if (message.what != 1) {
                    if (20 == message.what) {
                        this.f8663b.m11891a((String) message.obj);
                        return;
                    } else if (30 != message.what) {
                        return;
                    } else {
                        this.f8663b.m11889b();
                        return;
                    }
                }
                if (!this.f8662a.m11320al() && this.f8662a.mo11216ac() && !this.f8662a.m11318an().m10097ao()) {
                    this.f8663b.m11886b(false);
                }
                if (C2496e.m11922a().m11919b() != C2496e.EnumC2497a.WAIT) {
                    return;
                }
                sendEmptyMessageDelayed(1, 15000L);
            }
        }
    }

    public C2502i(C2657a c2657a) {
        this.f8647c = c2657a;
        this.f8648d = C3057d.m9823a(c2657a);
        c2657a.mo11219a(this);
        if (this.f8654l != null) {
            this.f8654l.getLooper().quit();
        }
        HandlerThread handlerThread = new HandlerThread("Update");
        handlerThread.start();
        this.f8654l = new HandlerC2506b(c2657a, this, handlerThread.getLooper());
        C2277v.m12784a(c2657a.f9270d).m12761f(f8641a);
    }

    /* renamed from: a */
    private static byte m11895a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: a */
    private void m11896a() {
        byte m10726f = this.f8647c.m11328aG().m10726f();
        C3057d.m9823a(this.f8647c).m9815d(m10726f);
        if (m10726f == 1) {
            this.f8647c.mo11220a(C2678d.EnumC2679a.DRAWSYNCFLYZONE);
        }
    }

    /* renamed from: a */
    private void m11894a(int i) {
        byte[] m11887b;
        List<DynamicDYZ_Entity> m11899d = this.f8651g.m11899d();
        if (i < m11899d.size() && (m11887b = m11887b(m11899d.get(i).getEncryptValue())) != null) {
            this.f8648d.m9824a(i + 1, m11887b);
            this.f8650f++;
            this.f8657q.m11920a(C2496e.EnumC2497a.SENDPAGE);
        }
        if (i + 1 >= m11899d.size()) {
            this.f8657q.m11920a(C2496e.EnumC2497a.COMPLETE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11889b() {
        LatLng latLng;
        if (this.f8657q.m11919b() == C2496e.EnumC2497a.SENDDATA) {
            List<DynamicDYZ_Entity> m11901c = this.f8651g.m11901c();
            if (m11901c == null || m11901c.size() <= 0) {
                this.f8647c.mo11220a(C2678d.EnumC2679a.CLEARSYNEFLYZONE);
                return;
            }
            if (m11901c.size() > this.f8653i) {
                if (this.f8646b == 1) {
                    C2886aq mo11202w = this.f8647c.mo11202w();
                    latLng = new LatLng(mo11202w.m10499f(), mo11202w.m10500e());
                } else {
                    Location m11305b = this.f8647c.m11305b();
                    latLng = m11305b != null ? new LatLng(m11305b.getLatitude(), m11305b.getLongitude()) : null;
                }
                if (latLng != null) {
                    for (DynamicDYZ_Entity dynamicDYZ_Entity : m11901c) {
                        double m7698a = C3632ab.m7729c(latLng, new LatLng(dynamicDYZ_Entity.getLatitude(), dynamicDYZ_Entity.getLogitude())).m7698a();
                        dynamicDYZ_Entity.setDistance(m7698a);
                        if (m7698a <= this.f8649e) {
                            this.f8651g.m11900c(dynamicDYZ_Entity);
                        }
                    }
                }
            } else {
                this.f8651g.m11905a(m11901c);
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fimi.soul.biz.j.i.1
                @Override // java.lang.Runnable
                public void run() {
                    List<DynamicDYZ_Entity> m11899d = C2502i.this.f8651g.m11899d();
                    if (m11899d.size() > 0) {
                        C2502i.this.f8648d.m9825a((int) C2502i.this.f8652h, m11899d.size(), C2502i.m11887b(m11899d.get(0).getEncryptKey()));
                        C2502i.this.f8657q.m11920a(C2496e.EnumC2497a.HANDSHAKE);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static byte[] m11887b(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (m11895a(charArray[i2 + 1]) | (m11895a(charArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: a */
    public void m11893a(int i, int i2, int i3, int i4) {
        this.f8652h = i;
        try {
            this.f8648d.m9826a(i, i2, i3, i4, Long.parseLong(C2353b.m12507c(this.f8647c.f9270d).getUserID()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m11891a(String str) {
        synchronized (this.f8656n) {
            List<DynamicDYZ_Entity> m7450a = C3684m.m7449a(this.f8647c.f9270d).m7450a(1, new Date().getTime());
            if (m7450a == null || m7450a.size() == 0) {
                return;
            }
            if (this.f8647c.mo11216ac() && !this.f8647c.m11318an().m10097ao() && (this.f8657q.m11919b() == C2496e.EnumC2497a.ERROR || this.f8657q.m11919b() == C2496e.EnumC2497a.QUERY || this.f8657q.m11919b() == C2496e.EnumC2497a.WAIT || this.f8657q.m11919b() == C2496e.EnumC2497a.IDEL)) {
                this.f8658r = 0.0d;
                double currentVersion = this.f8657q.m11917c() == 0.0d ? m7450a.get(0).getCurrentVersion() : this.f8657q.m11917c();
                ArrayList arrayList = new ArrayList();
                Iterator<DynamicDYZ_Entity> it2 = m7450a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    DynamicDYZ_Entity next = it2.next();
                    String fcIds = next.getFcIds();
                    String whileRange = next.getWhileRange();
                    if (!TextUtils.isEmpty(fcIds)) {
                        String[] split = fcIds.split(";");
                        if (next.getPushType() == 1.0d) {
                            int i = 1;
                            if (!TextUtils.isEmpty(whileRange)) {
                                try {
                                    i = Integer.parseInt(whileRange);
                                } catch (Exception e) {
                                }
                                if (i == 1) {
                                    int length = split.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length) {
                                            break;
                                        } else if (split[i2].equals(str)) {
                                            this.f8658r = 1.0d;
                                            break;
                                        } else {
                                            arrayList.add(next);
                                            i2++;
                                        }
                                    }
                                } else if (i == 0) {
                                    this.f8658r = 1.0d;
                                    break;
                                }
                            } else {
                                int length2 = split.length;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= length2) {
                                        break;
                                    } else if (split[i3].equals(str)) {
                                        this.f8658r = 1.0d;
                                        break;
                                    } else {
                                        arrayList.add(next);
                                        i3++;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    } else if (next.getPushType() == 1.0d) {
                        int i4 = 1;
                        if (!TextUtils.isEmpty(whileRange)) {
                            try {
                                i4 = Integer.parseInt(whileRange);
                            } catch (Exception e2) {
                            }
                            if (i4 == 0) {
                                this.f8658r = 1.0d;
                            }
                        }
                    }
                }
                if (this.f8658r == 0.0d) {
                    m7450a.removeAll(arrayList);
                }
                C2501h.m11907a().m11902b(m7450a);
                int size = C2501h.m11907a().m11901c().size();
                if (this.f8647c.mo11202w().m10499f() > 0.5d && this.f8647c.mo11202w().m10500e() > 0.5d) {
                    this.f8657q.m11920a(C2496e.EnumC2497a.SENDDATA);
                    m11893a((int) currentVersion, size, 1, (int) this.f8658r);
                    this.f8646b = 1;
                } else if (this.f8647c.m11305b() != null) {
                    this.f8657q.m11920a(C2496e.EnumC2497a.SENDDATA);
                    m11893a((int) currentVersion, size, 2, (int) this.f8658r);
                    this.f8646b = 2;
                }
            }
        }
    }

    /* renamed from: a */
    public void m11890a(boolean z) {
        this.f8655m = z;
    }

    /* renamed from: b */
    public void m11886b(boolean z) {
        if (!this.f8655m) {
            return;
        }
        List<DynamicDYZ_Entity> m7450a = C3684m.m7449a(this.f8647c.f9270d).m7450a(1, new Date().getTime());
        C2496e m11922a = C2496e.m11922a();
        if (m7450a == null && z) {
            m11922a.m11920a(C2496e.EnumC2497a.IDEL);
            QueryDynamicFlyZoneSetvice.m7809a(this.f8647c.f9270d);
        } else if (m7450a != null) {
            if (!this.f8647c.mo11216ac() || this.f8647c.m11318an().m10097ao()) {
                return;
            }
            String m12161b = C2444a.m12164a().m12161b();
            if (TextUtils.isEmpty(m12161b)) {
                C3057d.m9823a(this.f8647c).m9813e(0);
                return;
            }
            C2277v.m12784a(this.f8647c.f9270d).m12781a(f8641a, m12161b);
            if (this.f8654l.hasMessages(20)) {
                this.f8654l.removeMessages(20);
            }
            Message obtain = Message.obtain();
            obtain.obj = m12161b;
            obtain.what = 20;
            this.f8654l.sendMessage(obtain);
        } else {
            C2501h.m11907a().m11897f();
            if (!this.f8647c.mo11216ac() || this.f8647c.m11318an().m10097ao()) {
                return;
            }
            if (this.f8647c.mo11202w().m10499f() > 0.5d && this.f8647c.mo11202w().m10500e() > 0.5d) {
                m11893a((int) m11922a.m11917c(), 0, 1, 0);
                this.f8646b = 1;
                m11922a.m11920a(C2496e.EnumC2497a.SENDDATA);
                this.f8647c.mo11220a(C2678d.EnumC2679a.CLEARSYNEFLYZONE);
            } else if (this.f8647c.m11305b() == null) {
            } else {
                m11893a((int) m11922a.m11917c(), 0, 2, 0);
                this.f8646b = 2;
                m11922a.m11920a(C2496e.EnumC2497a.SENDDATA);
                this.f8647c.mo11220a(C2678d.EnumC2679a.CLEARSYNEFLYZONE);
            }
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case FCVERSION2:
                if (!this.f8655m) {
                    return;
                }
                C2871ab mo11213l = c2657a.mo11213l();
                if (mo11213l.m10692a() == 0) {
                    C2444a.m12164a().m12163a(mo11213l);
                }
                m11886b(false);
                return;
            case UPDTECOMPLETECHECK:
                m11896a();
                return;
            case QUERYDYNAMICDATAGPS:
                m11886b(true);
                return;
            case QUERYDYNAMICDATA:
                m11886b(false);
                return;
            case DYNC4KCHECKHANDLE:
                C2936t m11331aD = c2657a.m11331aD();
                if (m11331aD.m10164f() == 1 && m11331aD.m10163g() == 1) {
                    if (this.f8654l.hasMessages(30)) {
                        this.f8654l.removeMessages(30);
                    }
                    this.f8654l.sendEmptyMessage(30);
                    return;
                } else if (m11331aD.m10165e() == this.f8652h) {
                    this.f8657q.m11920a(C2496e.EnumC2497a.SAMEVERSION);
                    c2657a.mo11220a(C2678d.EnumC2679a.DRAWSYNCFLYZONEBYDB);
                    return;
                } else {
                    this.f8657q.m11920a(C2496e.EnumC2497a.ERROR);
                    c2657a.mo11220a(C2678d.EnumC2679a.CLEARSYNEFLYZONE);
                    return;
                }
            case DYNC4KCHECKSENDHANDLE:
                if (this.f8657q.m11919b() != C2496e.EnumC2497a.HANDSHAKE) {
                    return;
                }
                this.f8650f = 0;
                if (c2657a.m11330aE().m10157e() == 0) {
                    m11894a(this.f8650f);
                    return;
                } else {
                    this.f8657q.m11920a(C2496e.EnumC2497a.ERROR);
                    return;
                }
            case DYNC4KBACKDATA:
                C2935s m11329aF = c2657a.m11329aF();
                if (m11329aF.m10171d() != 0) {
                    this.f8657q.m11920a(C2496e.EnumC2497a.ERROR);
                    return;
                } else if (this.f8650f != m11329aF.m10172c()) {
                    return;
                } else {
                    m11894a(this.f8650f);
                    return;
                }
            default:
                return;
        }
    }
}
