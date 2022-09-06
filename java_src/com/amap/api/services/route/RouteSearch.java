package com.amap.api.services.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C1162a;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1235f;
import com.amap.api.services.core.C1241l;
import com.amap.api.services.core.C1257u;
import com.amap.api.services.core.HandlerC1246p;
import com.amap.api.services.core.LatLonPoint;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RouteSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;

    /* renamed from: a */
    private OnRouteSearchListener f4476a;

    /* renamed from: b */
    private Context f4477b;

    /* renamed from: c */
    private Handler f4478c = HandlerC1246p.m16952a();

    /* loaded from: classes.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new C1307m();

        /* renamed from: a */
        private FromAndTo f4485a;

        /* renamed from: b */
        private int f4486b;

        /* renamed from: c */
        private String f4487c;

        /* renamed from: d */
        private int f4488d;

        public BusRouteQuery() {
        }

        public BusRouteQuery(Parcel parcel) {
            this.f4485a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f4486b = parcel.readInt();
            this.f4487c = parcel.readString();
            this.f4488d = parcel.readInt();
        }

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.f4485a = fromAndTo;
            this.f4486b = i;
            this.f4487c = str;
            this.f4488d = i2;
        }

        /* renamed from: clone */
        public BusRouteQuery m21745clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C1233d.m17031a(e, "RouteSearch", "BusRouteQueryclone");
            }
            return new BusRouteQuery(this.f4485a, this.f4486b, this.f4487c, this.f4488d);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
                if (this.f4487c == null) {
                    if (busRouteQuery.f4487c != null) {
                        return false;
                    }
                } else if (!this.f4487c.equals(busRouteQuery.f4487c)) {
                    return false;
                }
                if (this.f4485a == null) {
                    if (busRouteQuery.f4485a != null) {
                        return false;
                    }
                } else if (!this.f4485a.equals(busRouteQuery.f4485a)) {
                    return false;
                }
                return this.f4486b == busRouteQuery.f4486b && this.f4488d == busRouteQuery.f4488d;
            }
            return false;
        }

        public String getCity() {
            return this.f4487c;
        }

        public FromAndTo getFromAndTo() {
            return this.f4485a;
        }

        public int getMode() {
            return this.f4486b;
        }

        public int getNightFlag() {
            return this.f4488d;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4487c == null ? 0 : this.f4487c.hashCode()) + 31) * 31;
            if (this.f4485a != null) {
                i = this.f4485a.hashCode();
            }
            return ((((hashCode + i) * 31) + this.f4486b) * 31) + this.f4488d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f4485a, i);
            parcel.writeInt(this.f4486b);
            parcel.writeString(this.f4487c);
            parcel.writeInt(this.f4488d);
        }
    }

    /* loaded from: classes.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new C1308n();

        /* renamed from: a */
        private FromAndTo f4489a;

        /* renamed from: b */
        private int f4490b;

        /* renamed from: c */
        private List<LatLonPoint> f4491c;

        /* renamed from: d */
        private List<List<LatLonPoint>> f4492d;

        /* renamed from: e */
        private String f4493e;

        public DriveRouteQuery() {
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f4489a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f4490b = parcel.readInt();
            this.f4491c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f4492d = null;
            } else {
                this.f4492d = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.f4492d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f4493e = parcel.readString();
        }

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f4489a = fromAndTo;
            this.f4490b = i;
            this.f4491c = list;
            this.f4492d = list2;
            this.f4493e = str;
        }

        /* renamed from: clone */
        public DriveRouteQuery m21746clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C1233d.m17031a(e, "RouteSearch", "DriveRouteQueryclone");
            }
            return new DriveRouteQuery(this.f4489a, this.f4490b, this.f4491c, this.f4492d, this.f4493e);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
                if (this.f4493e == null) {
                    if (driveRouteQuery.f4493e != null) {
                        return false;
                    }
                } else if (!this.f4493e.equals(driveRouteQuery.f4493e)) {
                    return false;
                }
                if (this.f4492d == null) {
                    if (driveRouteQuery.f4492d != null) {
                        return false;
                    }
                } else if (!this.f4492d.equals(driveRouteQuery.f4492d)) {
                    return false;
                }
                if (this.f4489a == null) {
                    if (driveRouteQuery.f4489a != null) {
                        return false;
                    }
                } else if (!this.f4489a.equals(driveRouteQuery.f4489a)) {
                    return false;
                }
                if (this.f4490b != driveRouteQuery.f4490b) {
                    return false;
                }
                return this.f4491c == null ? driveRouteQuery.f4491c == null : this.f4491c.equals(driveRouteQuery.f4491c);
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f4493e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f4492d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f4492d == null || this.f4492d.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f4492d.size(); i++) {
                List<LatLonPoint> list = this.f4492d.get(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LatLonPoint latLonPoint = list.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.f4492d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public FromAndTo getFromAndTo() {
            return this.f4489a;
        }

        public int getMode() {
            return this.f4490b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f4491c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f4491c == null || this.f4491c.size() == 0) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f4491c.size()) {
                    return stringBuffer.toString();
                }
                LatLonPoint latLonPoint = this.f4491c.get(i2);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i2 < this.f4491c.size() - 1) {
                    stringBuffer.append(";");
                }
                i = i2 + 1;
            }
        }

        public boolean hasAvoidRoad() {
            return !C1233d.m17032a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !C1233d.m17032a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !C1233d.m17032a(getPassedPointStr());
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f4489a == null ? 0 : this.f4489a.hashCode()) + (((this.f4492d == null ? 0 : this.f4492d.hashCode()) + (((this.f4493e == null ? 0 : this.f4493e.hashCode()) + 31) * 31)) * 31)) * 31) + this.f4490b) * 31;
            if (this.f4491c != null) {
                i = this.f4491c.hashCode();
            }
            return hashCode + i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f4489a, i);
            parcel.writeInt(this.f4490b);
            parcel.writeTypedList(this.f4491c);
            if (this.f4492d == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(this.f4492d.size());
                for (List<LatLonPoint> list : this.f4492d) {
                    parcel.writeTypedList(list);
                }
            }
            parcel.writeString(this.f4493e);
        }
    }

    /* loaded from: classes.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new C1309o();

        /* renamed from: a */
        private LatLonPoint f4494a;

        /* renamed from: b */
        private LatLonPoint f4495b;

        /* renamed from: c */
        private String f4496c;

        /* renamed from: d */
        private String f4497d;

        public FromAndTo() {
        }

        public FromAndTo(Parcel parcel) {
            this.f4494a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f4495b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f4496c = parcel.readString();
            this.f4497d = parcel.readString();
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f4494a = latLonPoint;
            this.f4495b = latLonPoint2;
        }

        /* renamed from: clone */
        public FromAndTo m21747clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C1233d.m17031a(e, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f4494a, this.f4495b);
            fromAndTo.setStartPoiID(this.f4496c);
            fromAndTo.setDestinationPoiID(this.f4497d);
            return fromAndTo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                FromAndTo fromAndTo = (FromAndTo) obj;
                if (this.f4497d == null) {
                    if (fromAndTo.f4497d != null) {
                        return false;
                    }
                } else if (!this.f4497d.equals(fromAndTo.f4497d)) {
                    return false;
                }
                if (this.f4494a == null) {
                    if (fromAndTo.f4494a != null) {
                        return false;
                    }
                } else if (!this.f4494a.equals(fromAndTo.f4494a)) {
                    return false;
                }
                if (this.f4496c == null) {
                    if (fromAndTo.f4496c != null) {
                        return false;
                    }
                } else if (!this.f4496c.equals(fromAndTo.f4496c)) {
                    return false;
                }
                return this.f4495b == null ? fromAndTo.f4495b == null : this.f4495b.equals(fromAndTo.f4495b);
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.f4497d;
        }

        public LatLonPoint getFrom() {
            return this.f4494a;
        }

        public String getStartPoiID() {
            return this.f4496c;
        }

        public LatLonPoint getTo() {
            return this.f4495b;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4496c == null ? 0 : this.f4496c.hashCode()) + (((this.f4494a == null ? 0 : this.f4494a.hashCode()) + (((this.f4497d == null ? 0 : this.f4497d.hashCode()) + 31) * 31)) * 31)) * 31;
            if (this.f4495b != null) {
                i = this.f4495b.hashCode();
            }
            return hashCode + i;
        }

        public void setDestinationPoiID(String str) {
            this.f4497d = str;
        }

        public void setStartPoiID(String str) {
            this.f4496c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f4494a, i);
            parcel.writeParcelable(this.f4495b, i);
            parcel.writeString(this.f4496c);
            parcel.writeString(this.f4497d);
        }
    }

    /* loaded from: classes.dex */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    /* loaded from: classes.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new C1310p();

        /* renamed from: a */
        private FromAndTo f4498a;

        /* renamed from: b */
        private int f4499b;

        public WalkRouteQuery() {
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f4498a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f4499b = parcel.readInt();
        }

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.f4498a = fromAndTo;
            this.f4499b = i;
        }

        /* renamed from: clone */
        public WalkRouteQuery m21748clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C1233d.m17031a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            return new WalkRouteQuery(this.f4498a, this.f4499b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
                if (this.f4498a == null) {
                    if (walkRouteQuery.f4498a != null) {
                        return false;
                    }
                } else if (!this.f4498a.equals(walkRouteQuery.f4498a)) {
                    return false;
                }
                return this.f4499b == walkRouteQuery.f4499b;
            }
            return false;
        }

        public FromAndTo getFromAndTo() {
            return this.f4498a;
        }

        public int getMode() {
            return this.f4499b;
        }

        public int hashCode() {
            return (((this.f4498a == null ? 0 : this.f4498a.hashCode()) + 31) * 31) + this.f4499b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f4498a, i);
            parcel.writeInt(this.f4499b);
        }
    }

    public RouteSearch(Context context) {
        this.f4477b = context.getApplicationContext();
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) {
        C1241l.m16960a(this.f4477b);
        BusRouteQuery m21745clone = busRouteQuery.m21745clone();
        BusRouteResult g = new C1162a(this.f4477b, m21745clone).g();
        if (g != null) {
            g.setBusQuery(m21745clone);
        }
        return g;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.route.RouteSearch$2] */
    public void calculateBusRouteAsyn(final BusRouteQuery busRouteQuery) {
        new Thread() { // from class: com.amap.api.services.route.RouteSearch.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.arg1 = 1;
                Bundle bundle = new Bundle();
                BusRouteResult busRouteResult = null;
                try {
                    try {
                        busRouteResult = RouteSearch.this.calculateBusRoute(busRouteQuery);
                        bundle.putInt("errorCode", 0);
                        obtainMessage.obj = RouteSearch.this.f4476a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "RouteSearch", "calculateBusRouteAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        obtainMessage.obj = RouteSearch.this.f4476a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    obtainMessage.obj = RouteSearch.this.f4476a;
                    bundle.putParcelable("result", busRouteResult);
                    obtainMessage.setData(bundle);
                    RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }.start();
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) {
        C1241l.m16960a(this.f4477b);
        DriveRouteQuery m21746clone = driveRouteQuery.m21746clone();
        DriveRouteResult g = new C1235f(this.f4477b, m21746clone).g();
        if (g != null) {
            g.setDriveQuery(m21746clone);
        }
        return g;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.route.RouteSearch$3] */
    public void calculateDriveRouteAsyn(final DriveRouteQuery driveRouteQuery) {
        new Thread() { // from class: com.amap.api.services.route.RouteSearch.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                obtainMessage.what = 11;
                obtainMessage.arg1 = 1;
                Bundle bundle = new Bundle();
                DriveRouteResult driveRouteResult = null;
                try {
                    try {
                        driveRouteResult = RouteSearch.this.calculateDriveRoute(driveRouteQuery);
                        bundle.putInt("errorCode", 0);
                        obtainMessage.obj = RouteSearch.this.f4476a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "RouteSearch", "calculateDriveRouteAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        obtainMessage.obj = RouteSearch.this.f4476a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    obtainMessage.obj = RouteSearch.this.f4476a;
                    bundle.putParcelable("result", driveRouteResult);
                    obtainMessage.setData(bundle);
                    RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }.start();
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) {
        C1241l.m16960a(this.f4477b);
        WalkRouteQuery m21748clone = walkRouteQuery.m21748clone();
        WalkRouteResult g = new C1257u(this.f4477b, m21748clone).g();
        if (g != null) {
            g.setWalkQuery(m21748clone);
        }
        return g;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.route.RouteSearch$1] */
    public void calculateWalkRouteAsyn(final WalkRouteQuery walkRouteQuery) {
        new Thread() { // from class: com.amap.api.services.route.RouteSearch.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                obtainMessage.what = 12;
                obtainMessage.arg1 = 1;
                Bundle bundle = new Bundle();
                WalkRouteResult walkRouteResult = null;
                try {
                    try {
                        walkRouteResult = RouteSearch.this.calculateWalkRoute(walkRouteQuery);
                        bundle.putInt("errorCode", 0);
                        obtainMessage.obj = RouteSearch.this.f4476a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "RouteSearch", "calculateWalkRouteAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        obtainMessage.obj = RouteSearch.this.f4476a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    obtainMessage.obj = RouteSearch.this.f4476a;
                    bundle.putParcelable("result", walkRouteResult);
                    obtainMessage.setData(bundle);
                    RouteSearch.this.f4478c.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }.start();
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        this.f4476a = onRouteSearchListener;
    }
}
