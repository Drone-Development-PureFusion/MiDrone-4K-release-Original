package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TextAndMediaPath implements Parcelable {
    public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new Parcelable.Creator<TextAndMediaPath>() { // from class: com.tencent.qqconnect.dataprovider.datatype.TextAndMediaPath.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public TextAndMediaPath mo21860createFromParcel(Parcel parcel) {
            return new TextAndMediaPath(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public TextAndMediaPath[] mo21861newArray(int i) {
            return new TextAndMediaPath[i];
        }
    };

    /* renamed from: a */
    private String f18281a;

    /* renamed from: b */
    private String f18282b;

    private TextAndMediaPath(Parcel parcel) {
        this.f18281a = parcel.readString();
        this.f18282b = parcel.readString();
    }

    public TextAndMediaPath(String str, String str2) {
        this.f18281a = str;
        this.f18282b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMediaPath() {
        return this.f18282b;
    }

    public String getText() {
        return this.f18281a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18281a);
        parcel.writeString(this.f18282b);
    }
}
