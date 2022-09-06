package com.tencent.open.yyb;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class ShareModel implements Parcelable {
    public static final Parcelable.Creator<ShareModel> CREATOR = new Parcelable.Creator<ShareModel>() { // from class: com.tencent.open.yyb.ShareModel.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareModel createFromParcel(Parcel parcel) {
            ShareModel shareModel = new ShareModel();
            shareModel.f18274a = parcel.readString();
            shareModel.f18275b = parcel.readString();
            shareModel.f18276c = parcel.readString();
            shareModel.f18277d = parcel.readString();
            return shareModel;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareModel[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    public String f18274a;

    /* renamed from: b */
    public String f18275b;

    /* renamed from: c */
    public String f18276c;

    /* renamed from: d */
    public String f18277d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18274a);
        parcel.writeString(this.f18275b);
        parcel.writeString(this.f18276c);
        parcel.writeString(this.f18277d);
    }
}
