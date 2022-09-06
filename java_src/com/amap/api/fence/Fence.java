package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.p080b.C1477bs;
/* loaded from: classes.dex */
public class Fence implements Parcelable {
    public static final Parcelable.Creator<Fence> CREATOR = new C0757a();

    /* renamed from: a */
    public PendingIntent f1953a;

    /* renamed from: b */
    public String f1954b;

    /* renamed from: c */
    public double f1955c;

    /* renamed from: d */
    public double f1956d;

    /* renamed from: e */
    public float f1957e;

    /* renamed from: f */
    public long f1958f;

    /* renamed from: g */
    public int f1959g;

    /* renamed from: h */
    public long f1960h;

    /* renamed from: i */
    private long f1961i;

    /* renamed from: j */
    private int f1962j;

    public Fence() {
        this.f1953a = null;
        this.f1954b = null;
        this.f1955c = 0.0d;
        this.f1956d = 0.0d;
        this.f1957e = 0.0f;
        this.f1958f = -1L;
        this.f1961i = -1L;
        this.f1962j = 3;
        this.f1959g = -1;
        this.f1960h = -1L;
    }

    private Fence(Parcel parcel) {
        this.f1953a = null;
        this.f1954b = null;
        this.f1955c = 0.0d;
        this.f1956d = 0.0d;
        this.f1957e = 0.0f;
        this.f1958f = -1L;
        this.f1961i = -1L;
        this.f1962j = 3;
        this.f1959g = -1;
        this.f1960h = -1L;
        if (parcel != null) {
            this.f1954b = parcel.readString();
            this.f1955c = parcel.readDouble();
            this.f1956d = parcel.readDouble();
            this.f1957e = parcel.readFloat();
            this.f1958f = parcel.readLong();
            this.f1961i = parcel.readLong();
            this.f1962j = parcel.readInt();
            this.f1959g = parcel.readInt();
            this.f1960h = parcel.readLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Fence(Parcel parcel, C0757a c0757a) {
        this(parcel);
    }

    /* renamed from: a */
    public int m19125a() {
        return this.f1962j;
    }

    /* renamed from: a */
    public void m19124a(long j) {
        if (j < 0) {
            this.f1958f = -1L;
        } else {
            this.f1958f = C1477bs.m15997b() + j;
        }
    }

    /* renamed from: b */
    public long m19123b() {
        return this.f1958f;
    }

    /* renamed from: c */
    public long m19122c() {
        return this.f1961i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1954b);
        parcel.writeDouble(this.f1955c);
        parcel.writeDouble(this.f1956d);
        parcel.writeFloat(this.f1957e);
        parcel.writeLong(this.f1958f);
        parcel.writeLong(this.f1961i);
        parcel.writeInt(this.f1962j);
        parcel.writeInt(this.f1959g);
        parcel.writeLong(this.f1960h);
    }
}
