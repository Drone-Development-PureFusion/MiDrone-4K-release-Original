package com.tencent.map.p226b;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.tencent.map.b.d */
/* loaded from: classes.dex */
public final class C4237d {

    /* renamed from: a */
    private Context f17581a = null;

    /* renamed from: b */
    private TelephonyManager f17582b = null;

    /* renamed from: c */
    private C4239a f17583c = null;

    /* renamed from: d */
    private AbstractC4241c f17584d = null;

    /* renamed from: e */
    private C4240b f17585e = null;

    /* renamed from: f */
    private boolean f17586f = false;

    /* renamed from: g */
    private List<NeighboringCellInfo> f17587g = new LinkedList();

    /* renamed from: h */
    private byte[] f17588h = new byte[0];

    /* renamed from: i */
    private byte[] f17589i = new byte[0];

    /* renamed from: j */
    private boolean f17590j = false;

    /* renamed from: com.tencent.map.b.d$a */
    /* loaded from: classes.dex */
    public class C4239a extends PhoneStateListener {

        /* renamed from: a */
        private int f17592a;

        /* renamed from: b */
        private int f17593b;

        /* renamed from: c */
        private int f17594c = 0;

        /* renamed from: d */
        private int f17595d = 0;

        /* renamed from: e */
        private int f17596e = 0;

        /* renamed from: f */
        private int f17597f = -1;

        /* renamed from: g */
        private int f17598g = Integer.MAX_VALUE;

        /* renamed from: h */
        private int f17599h = Integer.MAX_VALUE;

        /* renamed from: i */
        private Method f17600i = null;

        /* renamed from: j */
        private Method f17601j = null;

        /* renamed from: k */
        private Method f17602k = null;

        /* renamed from: l */
        private Method f17603l = null;

        /* renamed from: m */
        private Method f17604m = null;

        public C4239a(int i, int i2) {
            this.f17592a = 0;
            this.f17593b = 0;
            this.f17593b = i;
            this.f17592a = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        @Override // android.telephony.PhoneStateListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onCellLocationChanged(CellLocation cellLocation) {
            GsmCellLocation gsmCellLocation;
            boolean z;
            String networkOperator;
            this.f17597f = -1;
            this.f17596e = -1;
            this.f17595d = -1;
            this.f17594c = -1;
            if (cellLocation != null) {
                switch (this.f17592a) {
                    case 1:
                        try {
                            gsmCellLocation = (GsmCellLocation) cellLocation;
                        } catch (Exception e) {
                            gsmCellLocation = null;
                        }
                        try {
                            if (gsmCellLocation.getLac() <= 0 && gsmCellLocation.getCid() <= 0) {
                                gsmCellLocation = (GsmCellLocation) C4237d.this.f17582b.getCellLocation();
                            }
                            z = true;
                        } catch (Exception e2) {
                            z = false;
                            if (z) {
                                networkOperator = C4237d.this.f17582b.getNetworkOperator();
                                if (networkOperator != null) {
                                }
                                this.f17595d = gsmCellLocation.getLac();
                                this.f17596e = gsmCellLocation.getCid();
                                C4237d.m5789c(C4237d.this);
                            }
                            C4237d.this.f17585e = new C4240b(C4237d.this, this.f17592a, this.f17593b, this.f17594c, this.f17595d, this.f17596e, this.f17597f, this.f17598g, this.f17599h);
                            if (C4237d.this.f17584d == null) {
                            }
                        }
                        if (z && gsmCellLocation != null) {
                            networkOperator = C4237d.this.f17582b.getNetworkOperator();
                            if (networkOperator != null) {
                                try {
                                    if (networkOperator.length() > 3) {
                                        this.f17594c = Integer.valueOf(networkOperator.substring(3)).intValue();
                                    }
                                } catch (Exception e3) {
                                    this.f17596e = -1;
                                    this.f17595d = -1;
                                    this.f17594c = -1;
                                }
                            }
                            this.f17595d = gsmCellLocation.getLac();
                            this.f17596e = gsmCellLocation.getCid();
                            C4237d.m5789c(C4237d.this);
                        }
                        break;
                    case 2:
                        if (cellLocation != null) {
                            try {
                                if (this.f17600i == null) {
                                    this.f17600i = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationId", new Class[0]);
                                    this.f17601j = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getSystemId", new Class[0]);
                                    this.f17602k = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getNetworkId", new Class[0]);
                                    this.f17603l = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationLatitude", new Class[0]);
                                    this.f17604m = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationLongitude", new Class[0]);
                                }
                                this.f17594c = ((Integer) this.f17601j.invoke(cellLocation, new Object[0])).intValue();
                                this.f17595d = ((Integer) this.f17602k.invoke(cellLocation, new Object[0])).intValue();
                                this.f17596e = ((Integer) this.f17600i.invoke(cellLocation, new Object[0])).intValue();
                                this.f17598g = ((Integer) this.f17603l.invoke(cellLocation, new Object[0])).intValue();
                                this.f17599h = ((Integer) this.f17604m.invoke(cellLocation, new Object[0])).intValue();
                                break;
                            } catch (Exception e4) {
                                this.f17596e = -1;
                                this.f17595d = -1;
                                this.f17594c = -1;
                                this.f17598g = Integer.MAX_VALUE;
                                this.f17599h = Integer.MAX_VALUE;
                                break;
                            }
                        }
                        break;
                }
            }
            C4237d.this.f17585e = new C4240b(C4237d.this, this.f17592a, this.f17593b, this.f17594c, this.f17595d, this.f17596e, this.f17597f, this.f17598g, this.f17599h);
            if (C4237d.this.f17584d == null) {
                C4237d.this.f17584d.mo5763a(C4237d.this.f17585e);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            if (this.f17592a == 1) {
                C4237d.m5789c(C4237d.this);
            }
            if (Math.abs(i - ((this.f17597f + 113) / 2)) > 3) {
                if (this.f17597f == -1) {
                    this.f17597f = (i << 1) - 113;
                    return;
                }
                this.f17597f = (i << 1) - 113;
                C4237d.this.f17585e = new C4240b(C4237d.this, this.f17592a, this.f17593b, this.f17594c, this.f17595d, this.f17596e, this.f17597f, this.f17598g, this.f17599h);
                if (C4237d.this.f17584d == null) {
                    return;
                }
                C4237d.this.f17584d.mo5763a(C4237d.this.f17585e);
            }
        }
    }

    /* renamed from: com.tencent.map.b.d$b */
    /* loaded from: classes.dex */
    public class C4240b implements Cloneable {

        /* renamed from: a */
        public int f17606a;

        /* renamed from: b */
        public int f17607b;

        /* renamed from: c */
        public int f17608c;

        /* renamed from: d */
        public int f17609d;

        /* renamed from: e */
        public int f17610e;

        /* renamed from: f */
        public int f17611f;

        /* renamed from: g */
        public int f17612g;

        /* renamed from: h */
        public int f17613h;

        public C4240b(C4237d c4237d, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f17606a = 0;
            this.f17607b = 0;
            this.f17608c = 0;
            this.f17609d = 0;
            this.f17610e = 0;
            this.f17611f = 0;
            this.f17612g = Integer.MAX_VALUE;
            this.f17613h = Integer.MAX_VALUE;
            this.f17606a = i;
            this.f17607b = i2;
            this.f17608c = i3;
            this.f17609d = i4;
            this.f17610e = i5;
            this.f17611f = i6;
            this.f17612g = i7;
            this.f17613h = i8;
        }

        public final Object clone() {
            try {
                return (C4240b) super.clone();
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* renamed from: com.tencent.map.b.d$c */
    /* loaded from: classes.dex */
    public interface AbstractC4241c {
        /* renamed from: a */
        void mo5763a(C4240b c4240b);
    }

    /* renamed from: a */
    private int m5796a(int i) {
        int i2;
        String networkOperator = this.f17582b.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() >= 3) {
            try {
                i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
            } catch (Exception e) {
            }
            if (i != 2 && i2 == -1) {
                return 0;
            }
            return i2;
        }
        i2 = -1;
        if (i != 2) {
        }
        return i2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.map.b.d$1] */
    /* renamed from: c */
    static /* synthetic */ void m5789c(C4237d c4237d) {
        if (!c4237d.f17590j) {
            c4237d.f17590j = true;
            new Thread() { // from class: com.tencent.map.b.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    if (C4237d.this.f17582b != null) {
                        List neighboringCellInfo = C4237d.this.f17582b.getNeighboringCellInfo();
                        synchronized (C4237d.this.f17589i) {
                            if (neighboringCellInfo != null) {
                                C4237d.this.f17587g.clear();
                                C4237d.this.f17587g.addAll(neighboringCellInfo);
                            }
                        }
                    }
                    C4237d.this.f17590j = false;
                }
            }.start();
        }
    }

    /* renamed from: a */
    public final void m5797a() {
        synchronized (this.f17588h) {
            if (!this.f17586f) {
                return;
            }
            if (this.f17582b != null && this.f17583c != null) {
                try {
                    this.f17582b.listen(this.f17583c, 0);
                } catch (Exception e) {
                    this.f17586f = false;
                }
            }
            this.f17586f = false;
        }
    }

    /* renamed from: a */
    public final boolean m5795a(Context context, AbstractC4241c abstractC4241c) {
        synchronized (this.f17588h) {
            if (this.f17586f) {
                return true;
            }
            if (context == null || abstractC4241c == null) {
                return false;
            }
            this.f17581a = context;
            this.f17584d = abstractC4241c;
            try {
                this.f17582b = (TelephonyManager) this.f17581a.getSystemService("phone");
                if (this.f17582b == null) {
                    return false;
                }
                int phoneType = this.f17582b.getPhoneType();
                this.f17583c = new C4239a(m5796a(phoneType), phoneType);
                if (this.f17583c == null) {
                    return false;
                }
                this.f17582b.listen(this.f17583c, 18);
                this.f17586f = true;
                return this.f17586f;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /* renamed from: b */
    public final List<NeighboringCellInfo> m5791b() {
        LinkedList linkedList = null;
        synchronized (this.f17589i) {
            if (this.f17587g != null) {
                linkedList = new LinkedList();
                linkedList.addAll(this.f17587g);
            }
        }
        return linkedList;
    }
}
