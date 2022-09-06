package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.mapcore.util.C0943ef;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C1022g;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveStep;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DrivingRouteOverlay extends C1157b {

    /* renamed from: a */
    private DrivePath f3870a;

    /* renamed from: b */
    private List<LatLonPoint> f3871b;

    /* renamed from: c */
    private List<Marker> f3872c;

    /* renamed from: d */
    private boolean f3873d;

    /* renamed from: e */
    private Context f3874e;

    /* renamed from: f */
    private PolylineOptions f3875f;

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        this(context, aMap, drivePath, latLonPoint, latLonPoint2, null);
        this.f3874e = context;
    }

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, List<LatLonPoint> list) {
        super(context);
        this.f3872c = new ArrayList();
        this.f3873d = true;
        this.mAMap = aMap;
        this.f3870a = drivePath;
        this.startPoint = C1156a.m17312a(latLonPoint);
        this.endPoint = C1156a.m17312a(latLonPoint2);
        this.f3871b = list;
        this.f3874e = context;
    }

    /* renamed from: a */
    private LatLonPoint m17327a(DriveStep driveStep) {
        return driveStep.getPolyline().get(0);
    }

    /* renamed from: a */
    private void m17330a() {
        this.f3875f = null;
        this.f3875f = new PolylineOptions();
        this.f3875f.color(getDriveColor()).width(getRouteWidth());
    }

    /* renamed from: a */
    private void m17329a(LatLng latLng, LatLng latLng2) {
        this.f3875f.add(latLng, latLng2);
    }

    /* renamed from: a */
    private void m17328a(LatLonPoint latLonPoint, LatLng latLng) {
        m17329a(C1156a.m17312a(latLonPoint), latLng);
    }

    /* renamed from: a */
    private void m17326a(DriveStep driveStep, LatLng latLng) {
        addStationMarker(new MarkerOptions().position(latLng).title("方向:" + driveStep.getAction() + "\n道路:" + driveStep.getRoad()).snippet(driveStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(getDriveBitmapDescriptor()));
    }

    /* renamed from: b */
    private LatLonPoint m17324b(DriveStep driveStep) {
        return driveStep.getPolyline().get(driveStep.getPolyline().size() - 1);
    }

    /* renamed from: b */
    private void m17325b() {
        addPolyLine(this.f3875f);
    }

    /* renamed from: c */
    private void m17323c() {
        if (this.f3871b == null || this.f3871b.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3871b.size()) {
                return;
            }
            LatLonPoint latLonPoint = this.f3871b.get(i2);
            if (latLonPoint != null) {
                this.f3872c.add(this.mAMap.addMarker(new MarkerOptions().position(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude())).visible(this.f3873d).icon(m17321d()).title("途经点")));
            }
            i = i2 + 1;
        }
    }

    /* renamed from: c */
    private void m17322c(DriveStep driveStep) {
        this.f3875f.addAll(C1156a.m17311a(driveStep.getPolyline()));
    }

    /* renamed from: d */
    private BitmapDescriptor m17321d() {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap;
        Bitmap decodeStream;
        try {
            inputStream = C0943ef.m18372a(this.f3874e).open("amap_throughpoint.png");
            try {
                decodeStream = BitmapFactory.decodeStream(inputStream);
            } catch (Throwable th2) {
                bitmap = null;
                th = th2;
            }
            try {
                bitmap = C0945eh.m18355a(decodeStream, C1022g.f3199a);
            } catch (Throwable th3) {
                bitmap = decodeStream;
                th = th3;
                try {
                    th.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
                    bitmap.recycle();
                    return fromBitmap;
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            inputStream = null;
            th = th6;
            bitmap = null;
        }
        BitmapDescriptor fromBitmap2 = BitmapDescriptorFactory.fromBitmap(bitmap);
        bitmap.recycle();
        return fromBitmap2;
    }

    public void addToMap() {
        m17330a();
        try {
            List<DriveStep> steps = this.f3870a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                DriveStep driveStep = steps.get(i);
                LatLng m17312a = C1156a.m17312a(m17327a(driveStep));
                if (i < steps.size() - 1 && i == 0) {
                    m17329a(this.startPoint, m17312a);
                }
                m17326a(driveStep, m17312a);
                m17322c(driveStep);
                if (i == steps.size() - 1) {
                    m17328a(m17324b(driveStep), this.endPoint);
                }
            }
            addStartAndEndMarker();
            m17323c();
            m17325b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.overlay.C1157b
    protected LatLngBounds getLatLngBounds() {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        if (this.f3871b != null && this.f3871b.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f3871b.size()) {
                    break;
                }
                builder.include(new LatLng(this.f3871b.get(i2).getLatitude(), this.f3871b.get(i2).getLongitude()));
                i = i2 + 1;
            }
        }
        return builder.build();
    }

    @Override // com.amap.api.maps.overlay.C1157b
    public void removeFromMap() {
        try {
            super.removeFromMap();
            if (this.f3872c == null || this.f3872c.size() <= 0) {
                return;
            }
            for (int i = 0; i < this.f3872c.size(); i++) {
                this.f3872c.get(i).remove();
            }
            this.f3872c.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.overlay.C1157b
    public /* bridge */ /* synthetic */ void setNodeIconVisibility(boolean z) {
        super.setNodeIconVisibility(z);
    }

    public void setThroughPointIconVisibility(boolean z) {
        try {
            this.f3873d = z;
            if (this.f3872c == null || this.f3872c.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f3872c.size()) {
                    return;
                }
                this.f3872c.get(i2).setVisible(z);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.overlay.C1157b
    public /* bridge */ /* synthetic */ void zoomToSpan() {
        super.zoomToSpan();
    }
}
