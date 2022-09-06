package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class DataType {
    public static final int CONTENT_AND_IMAGE_PATH = 1;
    public static final int CONTENT_AND_VIDEO_PATH = 2;
    public static final int CONTENT_ONLY = 4;

    /* loaded from: classes.dex */
    public static class TextAndMediaPath implements Parcelable {
        public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new Parcelable.Creator<TextAndMediaPath>() { // from class: com.tencent.connect.dataprovider.DataType.TextAndMediaPath.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            /* renamed from: createFromParcel */
            public TextAndMediaPath mo21856createFromParcel(Parcel parcel) {
                return new TextAndMediaPath(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            /* renamed from: newArray */
            public TextAndMediaPath[] mo21857newArray(int i) {
                return new TextAndMediaPath[i];
            }
        };

        /* renamed from: a */
        private String f17488a;

        /* renamed from: b */
        private String f17489b;

        private TextAndMediaPath(Parcel parcel) {
            this.f17488a = parcel.readString();
            this.f17489b = parcel.readString();
        }

        public TextAndMediaPath(String str, String str2) {
            this.f17488a = str;
            this.f17489b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getMediaPath() {
            return this.f17489b;
        }

        public String getText() {
            return this.f17488a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f17488a);
            parcel.writeString(this.f17489b);
        }
    }

    /* loaded from: classes.dex */
    public static class TextOnly implements Parcelable {
        public static final Parcelable.Creator<TextOnly> CREATOR = new Parcelable.Creator<TextOnly>() { // from class: com.tencent.connect.dataprovider.DataType.TextOnly.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            /* renamed from: createFromParcel */
            public TextOnly mo21858createFromParcel(Parcel parcel) {
                return new TextOnly(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            /* renamed from: newArray */
            public TextOnly[] mo21859newArray(int i) {
                return new TextOnly[i];
            }
        };

        /* renamed from: a */
        private String f17490a;

        private TextOnly(Parcel parcel) {
            this.f17490a = parcel.readString();
        }

        public TextOnly(String str) {
            this.f17490a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getText() {
            return this.f17490a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f17490a);
        }
    }
}
