package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import cn.sharesdk.framework.utils.C0683d;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class WebpageObject implements Parcelable {
    public String actionUrl;
    public String defaultText;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public static final Parcelable.Creator<WebpageObject> CREATOR = new Parcelable.Creator<WebpageObject>() { // from class: com.sina.weibo.sdk.api.WebpageObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public WebpageObject mo21854createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public WebpageObject[] mo21855newArray(int i) {
            return new WebpageObject[i];
        }
    };

    public WebpageObject() {
    }

    public WebpageObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    public boolean checkArgs() {
        if (this.actionUrl == null || this.actionUrl.length() > 512) {
            C0683d.m19513a().m5972d("checkArgs fail, actionUrl is invalid", new Object[0]);
            return false;
        } else if (this.identify == null || this.identify.length() > 512) {
            C0683d.m19513a().m5972d("checkArgs fail, identify is invalid", new Object[0]);
            return false;
        } else if (this.thumbData == null || this.thumbData.length > 32768) {
            new Throwable("checkArgs fail, thumbData is invalid,size is " + (this.thumbData != null ? this.thumbData.length : -1) + "! more then 32768.").printStackTrace();
            return false;
        } else if (this.title == null || this.title.length() > 512) {
            C0683d.m19513a().m5972d("checkArgs fail, title is invalid", new Object[0]);
            return false;
        } else if (this.description != null && this.description.length() <= 1024) {
            return true;
        } else {
            C0683d.m19513a().m5972d("checkArgs fail, description is invalid", new Object[0]);
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 5;
    }

    public final void setThumbImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.thumbData = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream == null) {
                    return;
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    C0683d.m19513a().m5971d(th);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0683d.m19513a().m5971d(th);
                    if (byteArrayOutputStream == null) {
                        return;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        C0683d.m19513a().m5971d(th3);
                    }
                } catch (Throwable th4) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th5) {
                            C0683d.m19513a().m5971d(th5);
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }
}
