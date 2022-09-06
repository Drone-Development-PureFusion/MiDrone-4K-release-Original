package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TextOnly implements Parcelable {
    public static final Parcelable.Creator<TextOnly> CREATOR = new Parcelable.Creator<TextOnly>() { // from class: com.tencent.qqconnect.dataprovider.datatype.TextOnly.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public TextOnly mo21862createFromParcel(Parcel parcel) {
            return new TextOnly(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public TextOnly[] mo21863newArray(int i) {
            return new TextOnly[i];
        }
    };

    /* renamed from: a */
    private String f18283a;

    private TextOnly(Parcel parcel) {
        this.f18283a = parcel.readString();
    }

    public TextOnly(String str) {
        this.f18283a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getText() {
        return this.f18283a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18283a);
    }
}
