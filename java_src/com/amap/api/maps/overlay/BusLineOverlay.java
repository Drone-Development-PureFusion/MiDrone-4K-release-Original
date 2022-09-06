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
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BusLineOverlay {

    /* renamed from: a */
    private BusLineItem f3859a;

    /* renamed from: b */
    private AMap f3860b;

    /* renamed from: c */
    private ArrayList<Marker> f3861c = new ArrayList<>();

    /* renamed from: d */
    private Polyline f3862d;

    /* renamed from: e */
    private List<BusStationItem> f3863e;

    /* renamed from: f */
    private BitmapDescriptor f3864f;

    /* renamed from: g */
    private BitmapDescriptor f3865g;

    /* renamed from: h */
    private BitmapDescriptor f3866h;

    /* renamed from: i */
    private Context f3867i;

    public BusLineOverlay(Context context, AMap aMap, BusLineItem busLineItem) {
        this.f3867i = context;
        this.f3859a = busLineItem;
        this.f3860b = aMap;
        this.f3863e = this.f3859a.getBusStations();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BitmapDescriptor m17350a(String str) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap;
        IOException iOException;
        Bitmap decodeStream;
        try {
            try {
                inputStream = C0943ef.m18372a(this.f3867i).open(str);
                try {
                    decodeStream = BitmapFactory.decodeStream(inputStream);
                } catch (IOException e) {
                    bitmap = null;
                    iOException = e;
                } catch (Throwable th2) {
                    bitmap = null;
                    th = th2;
                }
                try {
                    bitmap = C0945eh.m18355a(decodeStream, C1022g.f3199a);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    bitmap = decodeStream;
                    iOException = e3;
                    iOException.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
                    bitmap.recycle();
                    return fromBitmap;
                } catch (Throwable th3) {
                    bitmap = decodeStream;
                    th = th3;
                    th.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    BitmapDescriptor fromBitmap2 = BitmapDescriptorFactory.fromBitmap(bitmap);
                    bitmap.recycle();
                    return fromBitmap2;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            inputStream = null;
            iOException = e7;
            bitmap = null;
        } catch (Throwable th5) {
            inputStream = null;
            th = th5;
            bitmap = null;
        }
        BitmapDescriptor fromBitmap22 = BitmapDescriptorFactory.fromBitmap(bitmap);
        bitmap.recycle();
        return fromBitmap22;
    }

    /* renamed from: a */
    private LatLngBounds m17349a(List<LatLonPoint> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                builder.include(new LatLng(list.get(i2).getLatitude(), list.get(i2).getLongitude()));
                i = i2 + 1;
            } else {
                return builder.build();
            }
        }
    }

    /* renamed from: a */
    private MarkerOptions m17351a(int i) {
        MarkerOptions snippet = new MarkerOptions().position(new LatLng(this.f3863e.get(i).getLatLonPoint().getLatitude(), this.f3863e.get(i).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i));
        if (i == 0) {
            snippet.icon(getStartBitmapDescriptor());
        } else if (i == this.f3863e.size() - 1) {
            snippet.icon(getEndBitmapDescriptor());
        } else {
            snippet.anchor(0.5f, 0.5f);
            snippet.icon(getBusBitmapDescriptor());
        }
        return snippet;
    }

    /* renamed from: a */
    private void m17352a() {
        if (this.f3864f != null) {
            this.f3864f.recycle();
            this.f3864f = null;
        }
        if (this.f3865g != null) {
            this.f3865g.recycle();
            this.f3865g = null;
        }
        if (this.f3866h != null) {
            this.f3866h.recycle();
            this.f3866h = null;
        }
    }

    public void addToMap() {
        try {
            this.f3862d = this.f3860b.addPolyline(new PolylineOptions().addAll(C1156a.m17311a(this.f3859a.getDirectionsCoordinates())).color(getBusColor()).width(getBuslineWidth()));
            if (this.f3863e.size() < 1) {
                return;
            }
            for (int i = 1; i < this.f3863e.size() - 1; i++) {
                this.f3861c.add(this.f3860b.addMarker(m17351a(i)));
            }
            this.f3861c.add(this.f3860b.addMarker(m17351a(0)));
            this.f3861c.add(this.f3860b.addMarker(m17351a(this.f3863e.size() - 1)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        this.f3866h = m17350a("amap_bus.png");
        return this.f3866h;
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    public int getBusStationIndex(Marker marker) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3861c.size()) {
                if (this.f3861c.get(i2).equals(marker)) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    public BusStationItem getBusStationItem(int i) {
        if (i < 0 || i >= this.f3863e.size()) {
            return null;
        }
        return this.f3863e.get(i);
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        this.f3865g = m17350a("amap_end.png");
        return this.f3865g;
    }

    protected String getSnippet(int i) {
        return "";
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        this.f3864f = m17350a("amap_start.png");
        return this.f3864f;
    }

    protected String getTitle(int i) {
        return this.f3863e.get(i).getBusStationName();
    }

    public void removeFromMap() {
        if (this.f3862d != null) {
            this.f3862d.remove();
        }
        try {
            Iterator<Marker> it2 = this.f3861c.iterator();
            while (it2.hasNext()) {
                it2.next().remove();
            }
            m17352a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomToSpan() {
        if (this.f3860b == null) {
            return;
        }
        try {
            List<LatLonPoint> directionsCoordinates = this.f3859a.getDirectionsCoordinates();
            if (directionsCoordinates == null || directionsCoordinates.size() <= 0) {
                return;
            }
            this.f3860b.moveCamera(CameraUpdateFactory.newLatLngBounds(m17349a(directionsCoordinates), 5));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
