package com.fimi.soul.module.dronemanage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.p001v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import com.amap.api.maps.AMap;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2281x;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p180i.C2468b;
import com.fimi.soul.biz.p180i.C2469c;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.biz.p180i.C2483n;
import com.fimi.soul.biz.p181j.C2488b;
import com.fimi.soul.biz.p181j.C2489c;
import com.fimi.soul.biz.p181j.C2494d;
import com.fimi.soul.biz.p181j.C2498f;
import com.fimi.soul.biz.p181j.C2499g;
import com.fimi.soul.biz.p181j.C2502i;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p184m.C2545a;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2754l;
import com.fimi.soul.drone.p193d.p194a.p195a.C2755m;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.drone.p203i.C2934r;
import com.fimi.soul.drone.p203i.p204a.C2864c;
import com.fimi.soul.entity.DynamicDYZ_Entity;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.module.droneFragment.FlyActionSettingFragment;
import com.fimi.soul.module.dronemanage.C3249j;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3684m;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class FlightMapFragment extends DroneMap implements AMap.InfoWindowAdapter, AMap.OnCameraChangeListener, AMap.OnInfoWindowClickListener, AMap.OnMapClickListener, AMap.OnMapLoadedListener, AMap.OnMapLongClickListener, AMap.OnMapTouchListener, AMap.OnMarkerClickListener, AMap.OnMarkerDragListener, C3249j.AbstractC3253a {

    /* renamed from: B */
    private static final int f12347B = 20;

    /* renamed from: C */
    private static final int f12348C = 30;

    /* renamed from: A */
    private C2489c f12349A;

    /* renamed from: D */
    private LatLng f12350D;

    /* renamed from: E */
    private LatLng f12351E;

    /* renamed from: F */
    private float f12352F;

    /* renamed from: G */
    private float f12353G;

    /* renamed from: H */
    private AbstractC3229a f12354H;

    /* renamed from: I */
    private SharedPreferences f12355I;

    /* renamed from: J */
    private C2477h f12356J;

    /* renamed from: K */
    private C2469c f12357K;

    /* renamed from: L */
    private double f12358L;

    /* renamed from: M */
    private List<Circle> f12359M;

    /* renamed from: N */
    private boolean f12360N;

    /* renamed from: O */
    private LatLng f12361O;

    /* renamed from: b */
    SharedPreferences.Editor f12369b;

    /* renamed from: e */
    Circle f12372e;

    /* renamed from: f */
    Circle f12373f;

    /* renamed from: s */
    private C2494d f12377s;

    /* renamed from: t */
    private C2483n f12378t;

    /* renamed from: u */
    private LatLng f12379u;

    /* renamed from: v */
    private Circle f12380v;

    /* renamed from: w */
    private boolean f12381w;

    /* renamed from: x */
    private FragmentManager f12382x;

    /* renamed from: z */
    private C2502i f12384z;

    /* renamed from: y */
    private boolean f12383y = false;

    /* renamed from: a */
    boolean f12368a = false;

    /* renamed from: c */
    boolean f12370c = true;

    /* renamed from: d */
    long f12371d = 0;

    /* renamed from: g */
    List<DynamicDYZ_Entity> f12374g = new ArrayList();

    /* renamed from: h */
    List<DynamicDYZ_Entity> f12375h = new ArrayList();

    /* renamed from: P */
    private final int f12362P = 16;

    /* renamed from: Q */
    private final int f12363Q = 1;

    /* renamed from: R */
    private final int f12364R = 2;

    /* renamed from: S */
    private EnumC3230b f12365S = EnumC3230b.no_check;

    /* renamed from: T */
    private boolean f12366T = false;

    /* renamed from: U */
    private int f12367U = 1;

    /* renamed from: i */
    protected Handler f12376i = new Handler() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.8
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            super.handleMessage(message);
            C2754l c2754l = new C2754l();
            switch (message.what) {
                case 1:
                    c2754l.m11128c(true);
                    if (FlightMapFragment.this.f12374g != null && FlightMapFragment.this.f12374g.size() > 0) {
                        for (DynamicDYZ_Entity dynamicDYZ_Entity : FlightMapFragment.this.f12374g) {
                            if (dynamicDYZ_Entity != null) {
                                double m7698a = C3632ab.m7729c(FlightMapFragment.this.f12361O, new LatLng(dynamicDYZ_Entity.getLatitude(), dynamicDYZ_Entity.getLogitude())).m7698a();
                                if (FlightMapFragment.this.f12366T) {
                                    if (dynamicDYZ_Entity.getDeviceType() == 1) {
                                        if (m7698a > 500000.0d) {
                                            FlightMapFragment.this.f12375h.add(dynamicDYZ_Entity);
                                        }
                                    }
                                } else if (dynamicDYZ_Entity.getDeviceType() == 0) {
                                    if (m7698a > 500000.0d) {
                                    }
                                }
                            }
                        }
                    }
                    if (FlightMapFragment.this.f12375h == null || FlightMapFragment.this.f12375h.size() <= 0) {
                        return;
                    }
                    String encryptKey = FlightMapFragment.this.f12375h.get(0).getEncryptKey();
                    c2754l.m11131b(C2275t.m12792a(encryptKey.substring(6, encryptKey.length() - 4)));
                    if (!C2367d.m12459a().m12438k()) {
                        c2754l.m11135a(false);
                    } else {
                        c2754l.m11137a((byte) 26);
                        c2754l.m11135a(true);
                        c2754l.m11132b(true);
                        c2754l.m11134a(FlightMapFragment.m9068a(FlightMapFragment.this.f12367U));
                    }
                    FlightMapFragment.this.f12621k.mo11217ab().mo10897a(c2754l.mo11073b());
                    FlightMapFragment.this.f12365S = EnumC3230b.sendKey;
                    return;
                case 16:
                    c2754l.m11128c(false);
                    FlightMapFragment.this.f12621k.mo11217ab().mo10897a(c2754l.mo11073b());
                    return;
                case 20:
                    if (FlightMapFragment.this.f12350D != null && FlightMapFragment.this.f12351E != null) {
                        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (C3632ab.m7729c(FlightMapFragment.this.f12350D, FlightMapFragment.this.f12351E).m7698a() < 5000.0d || FlightMapFragment.this.f12349A == null) {
                                    return;
                                }
                                FlightMapFragment.this.f12349A.m11970a();
                            }
                        });
                    }
                    FlightMapFragment.this.f12350D = FlightMapFragment.this.f12351E;
                    return;
                case 30:
                    FlightMapFragment.this.m9055a(true);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.fimi.soul.module.dronemanage.FlightMapFragment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3229a {
        /* renamed from: a */
        void mo8889a(List<C2907bk> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.dronemanage.FlightMapFragment$b */
    /* loaded from: classes.dex */
    public enum EnumC3230b {
        no_check,
        checkStatus,
        sendKey,
        sendData,
        finish
    }

    /* renamed from: a */
    public static int m9054a(byte[] bArr) {
        return ((bArr[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: a */
    private void m9065a(LatLng latLng) {
        if (this.f12380v == null) {
            this.f12380v = this.f12620j.addCircle(new CircleOptions().center(latLng).radius(500.0d).strokeWidth(5.0f).strokeColor(getResources().getColor(C2300R.color.errortextcl)));
            return;
        }
        this.f12380v.setCenter(latLng);
        this.f12380v.setVisible(true);
    }

    /* renamed from: a */
    private void m9064a(LatLng latLng, int i, int i2, C2864c c2864c) {
        this.f12355I.getInt(C2854c.f10631s, 1);
        boolean m12438k = C2367d.m12459a().m12438k();
        if (i2 == 3 || m12438k) {
            if (this.f12373f != null) {
                this.f12373f.setCenter(latLng);
                if (i != this.f12373f.getRadius()) {
                    if (m12438k) {
                        this.f12373f.setRadius(c2864c.m10710l() * 10);
                    } else {
                        this.f12373f.setRadius(i + 100);
                    }
                }
            } else {
                this.f12373f = this.f12620j.addCircle(new CircleOptions().center(latLng).radius(m12438k ? c2864c.m10710l() * 10 : i + 100).strokeColor(Color.argb(99, 255, 79, 0)).strokeWidth(2.0f).fillColor(Color.argb(26, 255, 36, 0)));
            }
        } else if (this.f12373f != null) {
            this.f12373f.remove();
            this.f12373f = null;
        }
        if (m12438k) {
            if ((c2864c.m10712j() & 3) == 1) {
                if (!this.f12360N) {
                    if (this.f12372e != null) {
                        this.f12372e.remove();
                        this.f12372e = null;
                    }
                    this.f12372e = this.f12620j.addCircle(C2498f.m11915a(i, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 2.0f, 100).center(latLng));
                    this.f12360N = true;
                } else if (this.f12372e == null) {
                    this.f12372e = this.f12620j.addCircle(C2498f.m11915a(i, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 2.0f, 100).center(latLng));
                } else {
                    this.f12372e.setCenter(latLng);
                    if (i != this.f12372e.getRadius()) {
                        this.f12372e.setRadius(i);
                    }
                }
            } else if (this.f12360N) {
                if (this.f12372e != null) {
                    this.f12372e.remove();
                    this.f12372e = null;
                }
                this.f12372e = this.f12620j.addCircle(C2498f.m11915a(i, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 2.0f, 100).center(latLng));
                this.f12360N = false;
            } else if (this.f12372e == null) {
                this.f12372e = this.f12620j.addCircle(C2498f.m11915a(i, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 2.0f, 100).center(latLng));
            } else {
                this.f12372e.setCenter(latLng);
                if (i != this.f12372e.getRadius()) {
                    this.f12372e.setRadius(i);
                }
            }
        } else if (this.f12372e == null || !this.f12359M.contains(this.f12372e)) {
            this.f12372e = this.f12620j.addCircle(new CircleOptions().center(latLng).radius(i).strokeColor(Color.argb(99, 255, 79, 0)).strokeWidth(2.0f).fillColor(Color.argb(26, 255, 36, 0)).zIndex(100.0f));
        } else {
            this.f12372e.setCenter(latLng);
            if (i != this.f12372e.getRadius()) {
                this.f12372e.setRadius(i);
            }
        }
        if (!this.f12359M.contains(this.f12372e)) {
            this.f12359M.add(this.f12372e);
        }
        C2488b.m11975a().m11974a(this.f12372e.getCenter());
    }

    /* renamed from: a */
    private void m9061a(C2907bk c2907bk) {
    }

    /* renamed from: a */
    private void m9056a(String str) {
        if (str != null) {
            this.f12621k.mo11217ab().mo10892a(C2275t.m12792a(str));
        }
    }

    /* renamed from: a */
    public static byte[] m9068a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: b */
    private String m9050b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        int i = 0;
        for (byte b : bArr) {
            i += b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        }
        return C2275t.m12791a(m9067a(i, false));
    }

    /* renamed from: c */
    private void m9049c() {
        if (this.f12620j == null) {
            this.f12620j = getMap();
        }
        if (this.f12620j != null) {
            this.f12620j.setOnMapClickListener(this);
            this.f12620j.setOnMarkerClickListener(this);
            this.f12620j.setOnMarkerDragListener(this);
            this.f12620j.setOnMapLongClickListener(this);
            this.f12620j.setMapType(this.f12355I.getInt(C2854c.f10631s, 1));
            this.f12620j.setTrafficEnabled(false);
            this.f12620j.setOnCameraChangeListener(this);
            this.f12620j.setOnMapLoadedListener(this);
            this.f12620j.setOnInfoWindowClickListener(this);
            this.f12620j.setInfoWindowAdapter(this);
            this.f12620j.setOnMapTouchListener(this);
            UiSettings uiSettings = this.f12620j.getUiSettings();
            uiSettings.setZoomControlsEnabled(false);
            uiSettings.setScaleControlsEnabled(false);
        }
    }

    /* renamed from: d */
    private void m9047d() {
        if (this.f12380v != null) {
            this.f12380v.setVisible(false);
        }
    }

    /* renamed from: e */
    private void m9045e() {
        this.f12374g.clear();
        C2613z.m11525a(getActivity()).m11515b(new AbstractC2538k() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.7
            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
            /* renamed from: a */
            public void mo6501a(PlaneMsg planeMsg, File file) {
                if (planeMsg.isSuccess()) {
                    try {
                        JSONArray jSONArray = new JSONArray(planeMsg.getData().toString());
                        long time = new Date().getTime();
                        if (jSONArray == null || jSONArray.length() <= 0) {
                            return;
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            DynamicDYZ_Entity dynamicDYZ_Entity = (DynamicDYZ_Entity) C3638ah.m7703b(DynamicDYZ_Entity.class, jSONArray.getJSONObject(i).toString());
                            if (dynamicDYZ_Entity.getStartDate() <= time && time <= dynamicDYZ_Entity.getEndDate()) {
                                if (FlightMapFragment.this.f12366T) {
                                    if (dynamicDYZ_Entity.getDeviceType() != 1) {
                                    }
                                    FlightMapFragment.this.f12374g.add(dynamicDYZ_Entity);
                                } else {
                                    if (dynamicDYZ_Entity.getDeviceType() != 0) {
                                    }
                                    FlightMapFragment.this.f12374g.add(dynamicDYZ_Entity);
                                }
                            }
                        }
                        FlightMapFragment.this.f12376i.sendEmptyMessage(2);
                        C3684m.m7449a(FlightMapFragment.this.getActivity()).m7447a(FlightMapFragment.this.f12374g);
                    } catch (JsonParseException e) {
                        e.printStackTrace();
                    } catch (JsonMappingException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: f */
    private void m9043f() {
        if (this.f12367U > this.f12375h.size() || this.f12367U < 0) {
            return;
        }
        DynamicDYZ_Entity dynamicDYZ_Entity = this.f12375h.get(this.f12367U - 1);
        if (!C2367d.m12459a().m12438k()) {
            C2755m c2755m = new C2755m();
            String encryptValue = dynamicDYZ_Entity.getEncryptValue();
            c2755m.m11105b(C2275t.m12792a(encryptValue.substring(6, encryptValue.length() - 4)));
            this.f12621k.mo11217ab().mo10897a(c2755m.mo11073b());
        } else {
            C2754l c2754l = new C2754l();
            c2754l.m11137a((byte) 36);
            c2754l.m11128c(true);
            String encryptValue2 = dynamicDYZ_Entity.getEncryptValue();
            byte[] m12792a = C2275t.m12792a(encryptValue2.substring(6, encryptValue2.length() - 4));
            if (!C2367d.m12459a().m12438k()) {
                c2754l.m11135a(false);
            } else {
                c2754l.m11135a(true);
                c2754l.m11132b(false);
                c2754l.m11134a(m9068a(this.f12367U));
            }
            c2754l.m11131b(m12792a);
            this.f12621k.mo11217ab().mo10897a(c2754l.mo11073b());
        }
        this.f12365S = EnumC3230b.sendData;
    }

    /* renamed from: g */
    private void m9041g() {
        C2754l c2754l = new C2754l();
        c2754l.m11128c(false);
        c2754l.m11120g((byte) 0);
        c2754l.m11124e((byte) 1);
        this.f12621k.mo11217ab().mo10897a(c2754l.mo11073b());
        this.f12365S = EnumC3230b.finish;
    }

    /* renamed from: a */
    public void m9070a() {
        this.f12620j.setMapType(this.f12355I.getInt(C2854c.f10631s, 1));
    }

    /* renamed from: a */
    public void m9069a(float f, boolean z, View... viewArr) {
        for (int i = 0; i < viewArr.length; i++) {
            View view = viewArr[i];
            if (view.getAlpha() != f) {
                view.setAlpha(f);
            }
            if (view.isEnabled() != z) {
                viewArr[i].setEnabled(z);
            }
        }
    }

    /* renamed from: a */
    public void m9066a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
        if (i == 255) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
    }

    /* renamed from: a */
    public void m9063a(final Marker marker) {
        Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        Projection projection = this.f12620j.getProjection();
        Point screenLocation = projection.toScreenLocation(marker.getPosition());
        screenLocation.offset(0, -100);
        final LatLng fromScreenLocation = projection.fromScreenLocation(screenLocation);
        final BounceInterpolator bounceInterpolator = new BounceInterpolator();
        handler.post(new Runnable() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.6
            @Override // java.lang.Runnable
            public void run() {
                float interpolation = bounceInterpolator.getInterpolation(((float) (SystemClock.uptimeMillis() - uptimeMillis)) / 1500.0f);
                double d = (interpolation * marker.getPosition().longitude) + ((1.0f - interpolation) * fromScreenLocation.longitude);
                marker.setPosition(new LatLng(((1.0f - interpolation) * fromScreenLocation.latitude) + (interpolation * marker.getPosition().latitude), d));
            }
        });
    }

    /* renamed from: a */
    public void m9062a(C2864c c2864c) {
        C3639ai m7726a = C3633ac.m7726a(c2864c.m10716f(), c2864c.m10715g());
        m9064a(new LatLng(m7726a.m7702a(), m7726a.m7700b()), c2864c.m10719c() * 10, c2864c.m10717e(), c2864c);
    }

    /* renamed from: a */
    public void m9060a(FlyActionBean flyActionBean) {
        this.f12357K.m12073b();
    }

    @Override // com.fimi.soul.module.dronemanage.C3249j.AbstractC3253a
    /* renamed from: a */
    public void mo8932a(List<C2907bk> list) {
        this.f12354H.mo8889a(list);
    }

    /* renamed from: a */
    public void m9055a(boolean z) {
        if (this.f12384z != null) {
            this.f12384z.m11886b(z);
        }
    }

    /* renamed from: a */
    public byte[] m9067a(int i, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                bArr[length] = (byte) (i & 255);
                i >>= 8;
            }
        } else {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (i & 255);
                i >>= 8;
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public void m9053b(Marker marker) {
        LatLng position = marker.getPosition();
        for (Circle circle : C2499g.m11911c().m11910d()) {
            if (circle.contains(position)) {
                this.f12381w = true;
                C2284z.m12696a(this.f12621k.f9270d, (int) C2300R.C2303string.flyzonwaypoint, 3000);
                return;
            }
        }
        this.f12381w = false;
        C3639ai m7726a = C3633ac.m7726a(this.f12621k.mo11201x().m10612b(), this.f12621k.mo11201x().m10611c());
        this.f12358L = C3632ab.m7729c(position, new LatLng(m7726a.m7702a(), m7726a.m7700b())).m7698a();
        if (this.f12356J.m12022a().get() == 1 || this.f12356J.m12022a().get() == 2) {
            marker.setTitle(getString(C2300R.C2303string.distancetag) + C2275t.m12793a(this.f12358L, 1) + getString(C2300R.C2303string.meter));
            marker.showInfoWindow();
        }
        if (this.f12358L >= 500.0d) {
            C2284z.m12696a(getActivity(), (int) C2300R.C2303string.waypoint_distan_home_Err, 1000);
            return;
        }
        this.f12379u = position;
        FlyActionBean flyActionBean = (FlyActionBean) marker.getObject();
        if (flyActionBean == null) {
            return;
        }
        flyActionBean.setLatLng(position);
        m9060a(flyActionBean);
    }

    /* renamed from: b */
    public void m9051b(List<C2907bk> list) {
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        Object object = marker.getObject();
        if (object instanceof FlyActionBean) {
            final FlyActionBean flyActionBean = (FlyActionBean) marker.getObject();
            if (flyActionBean != null) {
                if (flyActionBean.getStyleInfo() != 2) {
                    View inflate = LayoutInflater.from(getActivity()).inflate(C2300R.layout.mystyle_inforwindow, (ViewGroup) null);
                    final Button button = (Button) inflate.findViewById(C2300R.C2302id.reminder);
                    button.setText(marker.getTitle());
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (button.getText().toString().equals(FlightMapFragment.this.getString(C2300R.C2303string.delete_marker))) {
                                FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.DELETE_WAYPOINT);
                            }
                        }
                    });
                    C3658ar.m7612a(getActivity().getAssets(), button);
                    return inflate;
                }
                View inflate2 = LayoutInflater.from(getActivity()).inflate(C2300R.layout.mystyle_com_inforwindow, (ViewGroup) null);
                Button button2 = (Button) inflate2.findViewById(C2300R.C2302id.delete);
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2472d.m12036p().m12033s();
                        FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.CLEARDATA);
                    }
                });
                Button button3 = (Button) inflate2.findViewById(C2300R.C2302id.excute_again);
                if (!flyActionBean.isCanExcute()) {
                    m9066a(button3, 75);
                } else {
                    m9066a(button3, 255);
                }
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2477h m12020a = C2477h.m12020a(FlightMapFragment.this.getActivity());
                        switch (flyActionBean.getModelType()) {
                            case 1:
                                m12020a.m12021a(1);
                                FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.UPWAYPOINT);
                                return;
                            case 2:
                                m12020a.m12021a(2);
                                FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.ASSIGNWAYPOINT);
                                return;
                            case 3:
                                m12020a.m12021a(3);
                                FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.INTERESTWAYPOINT);
                                return;
                            default:
                                return;
                        }
                    }
                });
                C3658ar.m7612a(getActivity().getAssets(), button2, button3);
                return inflate2;
            }
        } else if (object instanceof C2468b) {
            View inflate3 = LayoutInflater.from(getActivity()).inflate(C2300R.layout.mystyle_com_inforwindow, (ViewGroup) null);
            Button button4 = (Button) inflate3.findViewById(C2300R.C2302id.delete);
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.CLEARMARKERTAKEPHOTO);
                }
            });
            Button button5 = (Button) inflate3.findViewById(C2300R.C2302id.excute_again);
            button5.setText(C2300R.C2303string.take_photo_fly_again);
            if (((C2468b) object).f8489a) {
                m9066a(button5, 75);
            } else {
                m9066a(button5, 255);
            }
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.dronemanage.FlightMapFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FlightMapFragment.this.f12356J.m12021a(4);
                    FlightMapFragment.this.f12621k.mo11220a(C2678d.EnumC2679a.WXCETAKEPHOTOAGAIN);
                }
            });
            C3658ar.m7612a(getActivity().getAssets(), button4, button5);
            return inflate3;
        }
        return null;
    }

    @Override // com.fimi.soul.module.droneui.DroneMap, com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12354H = (AbstractC3229a) getActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        if (this.f12356J.m12022a().get() != 3 || !this.f12621k.mo11216ac()) {
            return;
        }
        this.f12621k.mo11220a(C2678d.EnumC2679a.CHANGESTARTMARKER);
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        if (this.f12356J.m12022a().get() == 3 && this.f12621k.mo11216ac()) {
            this.f12621k.mo11220a(C2678d.EnumC2679a.CHANGESTARTMARKER);
        }
        if (cameraPosition != null && cameraPosition.zoom >= 3.0f) {
            this.f12377s.m11947a();
        }
        this.f12351E = cameraPosition.target;
        if (this.f12376i.hasMessages(20)) {
            this.f12376i.removeMessages(20);
        }
        this.f12376i.sendEmptyMessageDelayed(20, 1000L);
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12356J = C2477h.m12020a(getActivity().getApplicationContext());
        this.f12359M = C2499g.m11911c().m11910d();
        this.f12382x = getActivity().getSupportFragmentManager();
        this.f12621k = ((DroidPlannerApp) getActivity().getApplication()).f7895a;
        if (!this.f12621k.mo11216ac()) {
            this.f12366T = C2277v.m12784a(getActivity()).m12744q();
            return;
        }
        this.f12366T = C2367d.m12459a().m12438k();
        C2277v.m12784a(getActivity()).m12760f(this.f12366T);
    }

    @Override // com.fimi.soul.module.droneui.DroneMap, com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f12355I = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f12369b = this.f12355I.edit();
        return onCreateView;
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f12377s.m11941b();
        for (Circle circle : this.f12359M) {
            if (circle != null) {
                circle.remove();
            }
        }
        this.f12378t.m11997a();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.fimi.soul.module.droneui.DroneMap, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        C2934r m11300d;
        super.onDroneEvent(enumC2679a, c2657a);
        switch (enumC2679a) {
            case Remotecontrol:
                if (!c2657a.mo11216ac() && !this.f12383y && System.currentTimeMillis() - this.f12371d > 5000) {
                    this.f12371d = System.currentTimeMillis();
                    c2657a.m11327ad();
                    this.f12383y = true;
                }
                if (c2657a.mo11216ac()) {
                    this.f12383y = false;
                    return;
                } else {
                    this.f12365S = EnumC3230b.no_check;
                    return;
                }
            case NOFLYZONE:
                C2864c m11290j = c2657a.m11290j();
                if (m11290j.m10721b() == 4 || m11290j.m10721b() == 5 || m11290j.m10721b() == 6) {
                    return;
                }
                m9062a(m11290j);
                return;
            case DISPLAYLIMITCIRCLE:
                C3639ai m7726a = C3633ac.m7726a(c2657a.mo11201x().m10612b(), c2657a.mo11201x().m10611c());
                m9065a(new LatLng(m7726a.m7702a(), m7726a.m7700b()));
                return;
            case HIDEDISPLAYCIRCLE:
                m9047d();
                return;
            case HOMEPOINT:
            default:
                return;
            case DYNAMIC_RESULT:
                if (this.f12365S == EnumC3230b.finish || (m11300d = c2657a.m11300d()) == null) {
                    return;
                }
                byte m10180e = m11300d.m10180e();
                byte m10178f = m11300d.m10178f();
                byte m10176g = m11300d.m10176g();
                if (m10178f == 0) {
                    return;
                }
                switch (this.f12365S) {
                    case checkStatus:
                        this.f12375h.clear();
                        if (m10180e != 1 || m10178f != 1 || m10176g != 0) {
                            return;
                        }
                        this.f12361O = new LatLng(c2657a.mo11202w().m10499f(), c2657a.mo11202w().m10500e());
                        this.f12376i.sendEmptyMessage(1);
                        return;
                    case sendKey:
                        if (m10176g != 0) {
                            return;
                        }
                        try {
                            m9043f();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    case sendData:
                        if (m10176g != 0 || m10178f == 0) {
                            return;
                        }
                        if (this.f12367U == this.f12375h.size()) {
                            m9041g();
                            return;
                        }
                        try {
                            m9043f();
                        } catch (Exception e2) {
                        }
                        this.f12367U++;
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // com.amap.api.maps.AMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        if (f12609l == 6 || f12609l == 4 || f12609l == 5) {
            return;
        }
        this.f12621k.mo11220a(C2678d.EnumC2679a.HIDEINFORWINDOW);
        FlyActionSettingFragment flyActionSettingFragment = (FlyActionSettingFragment) this.f12382x.findFragmentById(C2300R.C2302id.flyaction);
        if ((flyActionSettingFragment != null && !flyActionSettingFragment.isVisible()) || !this.f12356J.m12019b()) {
            return;
        }
        if (this.f12356J.m12022a().get() == 1) {
            this.f12357K.m12077a(latLng, C2300R.C2301drawable.icon_fly_waypoint_red);
        } else if (this.f12356J.m12022a().get() == 2) {
            this.f12357K.m12077a(latLng, C2300R.C2301drawable.img_fly_flag_blue);
        } else if (this.f12356J.m12022a().get() != 3) {
        } else {
            this.f12357K.m12077a(latLng, C2300R.C2301drawable.img_fly_flag_blue);
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapLoadedListener
    public void onMapLoaded() {
        if (this.f12620j.getCameraPosition().zoom >= 3.0f) {
            this.f12377s.m11947a();
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapLongClickListener
    public void onMapLongClick(LatLng latLng) {
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (this.f12621k.m11312at().m10700g().judgeNoAction()) {
            this.f12357K.m12076a(marker);
            return true;
        }
        return true;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        m9053b(marker);
    }

    @Override // com.amap.api.maps.AMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        if ((this.f12358L >= 500.0d || this.f12381w) && this.f12379u != null) {
            marker.setPosition(this.f12379u);
        }
        if (marker.isInfoWindowShown()) {
            marker.hideInfoWindow();
            marker.setTitle("");
        }
        this.f12621k.mo11220a(C2678d.EnumC2679a.NOTIFICHANGECIECLERIDUS);
    }

    @Override // com.amap.api.maps.AMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        m9063a(marker);
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f12384z != null) {
            this.f12384z.m11890a(false);
        }
    }

    @Override // com.fimi.soul.module.droneui.DroneMap, com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.fimi.soul.module.droneui.DroneMap, android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        m9049c();
        this.f12621k.m11340a(this.f12620j);
        if (this.f12377s == null) {
            this.f12377s = new C2494d(getActivity().getApplicationContext(), this.f12620j);
        }
        if (this.f12357K == null) {
            this.f12357K = new C2469c(this.f12621k, this.f12620j, getActivity().getApplicationContext(), this.f12382x);
        } else {
            this.f12357K.m12070d();
        }
        if (this.f12378t == null) {
            this.f12378t = new C2483n(this.f12621k);
        }
        if (this.f12349A == null) {
            this.f12349A = new C2489c(this.f12620j, this.f12621k);
        }
        if (this.f12384z == null) {
            this.f12384z = new C2502i(this.f12621k);
        } else {
            this.f12384z.m11890a(true);
        }
        if (this.f12376i.hasMessages(30)) {
            this.f12376i.removeMessages(30);
        }
        this.f12376i.sendEmptyMessageDelayed(30, 2000L);
    }

    @Override // com.fimi.soul.module.droneui.DroneMap, android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.amap.api.maps.AMap.OnMapTouchListener
    public void onTouch(MotionEvent motionEvent) {
        C2545a m11735a = C2545a.m11735a();
        if (m11735a.m11729c() == C2545a.EnumC2548a.DRONEPRESS) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f12352F = motionEvent.getX();
                    this.f12353G = motionEvent.getY();
                    this.f12368a = true;
                    m11735a.m11731a(false);
                    return;
                case 1:
                    m11735a.m11731a(true);
                    if (!this.f12368a) {
                        return;
                    }
                    if (Math.abs(motionEvent.getX() - this.f12352F) <= 30.0f && Math.abs(motionEvent.getY() - this.f12353G) <= 30.0f) {
                        return;
                    }
                    m11735a.m11732a(C2545a.EnumC2548a.DRONE);
                    return;
                case 2:
                case 3:
                case 4:
                default:
                    return;
                case 5:
                    this.f12368a = false;
                    return;
            }
        }
    }
}
