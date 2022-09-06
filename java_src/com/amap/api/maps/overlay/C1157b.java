package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.mapcore.util.C0943ef;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C1022g;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.maps.overlay.b */
/* loaded from: classes.dex */
class C1157b {

    /* renamed from: a */
    private Context f3883a;

    /* renamed from: b */
    private Bitmap f3884b;

    /* renamed from: c */
    private Bitmap f3885c;

    /* renamed from: d */
    private Bitmap f3886d;

    /* renamed from: e */
    private Bitmap f3887e;
    protected Marker endMarker;
    protected LatLng endPoint;

    /* renamed from: f */
    private Bitmap f3888f;
    protected AMap mAMap;
    protected Marker startMarker;
    protected LatLng startPoint;
    protected List<Marker> stationMarkers = new ArrayList();
    protected List<Polyline> allPolyLines = new ArrayList();
    protected boolean nodeIconVisible = true;

    public C1157b(Context context) {
        this.f3883a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BitmapDescriptor m17309a(Bitmap bitmap, String str) {
        InputStream inputStream;
        IOException iOException;
        Bitmap bitmap2;
        InputStream open;
        InputStream inputStream2 = null;
        try {
            try {
                open = C0943ef.m18372a(this.f3883a).open(str);
            } catch (IOException e) {
                inputStream = null;
                iOException = e;
                bitmap2 = bitmap;
            }
            try {
                bitmap = BitmapFactory.decodeStream(open);
                bitmap2 = C0945eh.m18355a(bitmap, C1022g.f3199a);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                inputStream = open;
                iOException = e3;
                bitmap2 = bitmap;
                try {
                    iOException.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap2);
                    bitmap2.recycle();
                    return fromBitmap;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            BitmapDescriptor fromBitmap2 = BitmapDescriptorFactory.fromBitmap(bitmap2);
            bitmap2.recycle();
            return fromBitmap2;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m17310a() {
        if (this.f3884b != null) {
            this.f3884b.recycle();
            this.f3884b = null;
        }
        if (this.f3885c != null) {
            this.f3885c.recycle();
            this.f3885c = null;
        }
        if (this.f3886d != null) {
            this.f3886d.recycle();
            this.f3886d = null;
        }
        if (this.f3887e != null) {
            this.f3887e.recycle();
            this.f3887e = null;
        }
        if (this.f3888f != null) {
            this.f3888f.recycle();
            this.f3888f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addPolyLine(PolylineOptions polylineOptions) {
        Polyline addPolyline;
        if (polylineOptions == null || (addPolyline = this.mAMap.addPolyline(polylineOptions)) == null) {
            return;
        }
        this.allPolyLines.add(addPolyline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addStartAndEndMarker() {
        this.startMarker = this.mAMap.addMarker(new MarkerOptions().position(this.startPoint).icon(getStartBitmapDescriptor()).title("起点"));
        this.endMarker = this.mAMap.addMarker(new MarkerOptions().position(this.endPoint).icon(getEndBitmapDescriptor()).title("终点"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addStationMarker(MarkerOptions markerOptions) {
        Marker addMarker;
        if (markerOptions == null || (addMarker = this.mAMap.addMarker(markerOptions)) == null) {
            return;
        }
        this.stationMarkers.add(addMarker);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getBusBitmapDescriptor() {
        return m17309a(this.f3886d, "amap_bus.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getBusColor() {
        return Color.parseColor("#537edc");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getDriveBitmapDescriptor() {
        return m17309a(this.f3888f, "amap_car.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDriveColor() {
        return Color.parseColor("#537edc");
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        return m17309a(this.f3885c, "amap_end.png");
    }

    protected LatLngBounds getLatLngBounds() {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getRouteWidth() {
        return 18.0f;
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        return m17309a(this.f3884b, "amap_start.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getWalkBitmapDescriptor() {
        return m17309a(this.f3887e, "amap_man.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getWalkColor() {
        return Color.parseColor("#6db74d");
    }

    public void removeFromMap() {
        if (this.startMarker != null) {
            this.startMarker.remove();
        }
        if (this.endMarker != null) {
            this.endMarker.remove();
        }
        for (Marker marker : this.stationMarkers) {
            marker.remove();
        }
        for (Polyline polyline : this.allPolyLines) {
            polyline.remove();
        }
        m17310a();
    }

    public void setNodeIconVisibility(boolean z) {
        try {
            this.nodeIconVisible = z;
            if (this.stationMarkers == null || this.stationMarkers.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.stationMarkers.size()) {
                    return;
                }
                this.stationMarkers.get(i2).setVisible(z);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomToSpan() {
        if (this.startPoint == null || this.mAMap == null) {
            return;
        }
        try {
            this.mAMap.animateCamera(CameraUpdateFactory.newLatLngBounds(getLatLngBounds(), 50));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
