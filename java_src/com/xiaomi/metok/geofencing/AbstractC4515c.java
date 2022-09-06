package com.xiaomi.metok.geofencing;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
/* renamed from: com.xiaomi.metok.geofencing.c */
/* loaded from: classes2.dex */
public interface AbstractC4515c extends IInterface {

    /* renamed from: com.xiaomi.metok.geofencing.c$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC4516a extends Binder implements AbstractC4515c {

        /* renamed from: com.xiaomi.metok.geofencing.c$a$a */
        /* loaded from: classes2.dex */
        private static class C4517a implements AbstractC4515c {

            /* renamed from: a */
            private IBinder f18605a;

            C4517a(IBinder iBinder) {
                this.f18605a = iBinder;
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public String mo4933a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    this.f18605a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public void mo4932a(double d, double d2, float f, long j, PendingIntent pendingIntent, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeFloat(f);
                    obtain.writeLong(j);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f18605a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public void mo4931a(double d, double d2, float f, long j, String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeFloat(f);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f18605a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public void mo4930a(PendingIntent pendingIntent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f18605a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public void mo4929a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.f18605a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public void mo4928a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f18605a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: a */
            public void mo4927a(List<String> list, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    this.f18605a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f18605a;
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: b */
            public int mo4926b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    this.f18605a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaomi.metok.geofencing.AbstractC4515c
            /* renamed from: b */
            public List<String> mo4925b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.f18605a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static AbstractC4515c m4934a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.metok.geofencing.IGeoFencing");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC4515c)) ? new C4517a(iBinder) : (AbstractC4515c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.createStringArrayList(), parcel.readString());
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readString());
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    String a = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    List<String> b = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStringList(b);
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    int b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readLong(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readString(), parcel.readString());
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                    a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.xiaomi.metok.geofencing.IGeoFencing");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    String mo4933a();

    /* renamed from: a */
    void mo4932a(double d, double d2, float f, long j, PendingIntent pendingIntent, String str, String str2);

    /* renamed from: a */
    void mo4931a(double d, double d2, float f, long j, String str, String str2, String str3);

    /* renamed from: a */
    void mo4930a(PendingIntent pendingIntent);

    /* renamed from: a */
    void mo4929a(String str);

    /* renamed from: a */
    void mo4928a(String str, String str2);

    /* renamed from: a */
    void mo4927a(List<String> list, String str);

    /* renamed from: b */
    int mo4926b();

    /* renamed from: b */
    List<String> mo4925b(String str);
}
