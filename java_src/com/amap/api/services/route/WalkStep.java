package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new C1315u();

    /* renamed from: a */
    private String f4507a;

    /* renamed from: b */
    private String f4508b;

    /* renamed from: c */
    private String f4509c;

    /* renamed from: d */
    private float f4510d;

    /* renamed from: e */
    private float f4511e;

    /* renamed from: f */
    private List<LatLonPoint> f4512f;

    /* renamed from: g */
    private String f4513g;

    /* renamed from: h */
    private String f4514h;

    public WalkStep() {
        this.f4512f = new ArrayList();
    }

    public WalkStep(Parcel parcel) {
        this.f4512f = new ArrayList();
        this.f4507a = parcel.readString();
        this.f4508b = parcel.readString();
        this.f4509c = parcel.readString();
        this.f4510d = parcel.readFloat();
        this.f4511e = parcel.readFloat();
        this.f4512f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f4513g = parcel.readString();
        this.f4514h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f4513g;
    }

    public String getAssistantAction() {
        return this.f4514h;
    }

    public float getDistance() {
        return this.f4510d;
    }

    public float getDuration() {
        return this.f4511e;
    }

    public String getInstruction() {
        return this.f4507a;
    }

    public String getOrientation() {
        return this.f4508b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f4512f;
    }

    public String getRoad() {
        return this.f4509c;
    }

    public void setAction(String str) {
        this.f4513g = str;
    }

    public void setAssistantAction(String str) {
        this.f4514h = str;
    }

    public void setDistance(float f) {
        this.f4510d = f;
    }

    public void setDuration(float f) {
        this.f4511e = f;
    }

    public void setInstruction(String str) {
        this.f4507a = str;
    }

    public void setOrientation(String str) {
        this.f4508b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f4512f = list;
    }

    public void setRoad(String str) {
        this.f4509c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4507a);
        parcel.writeString(this.f4508b);
        parcel.writeString(this.f4509c);
        parcel.writeFloat(this.f4510d);
        parcel.writeFloat(this.f4511e);
        parcel.writeTypedList(this.f4512f);
        parcel.writeString(this.f4513g);
        parcel.writeString(this.f4514h);
    }
}
