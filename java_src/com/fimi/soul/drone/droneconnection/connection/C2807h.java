package com.fimi.soul.drone.droneconnection.connection;

import android.content.Context;
import com.fimi.soul.drone.droneconnection.connection.p196a.C2778a;
import com.fimi.soul.drone.droneconnection.connection.p197b.C2783a;
import com.fimi.soul.drone.droneconnection.connection.p198c.C2793b;
import com.fimi.soul.drone.p202h.C2854c;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.h */
/* loaded from: classes.dex */
public class C2807h {

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.h$a */
    /* loaded from: classes.dex */
    public enum EnumC2809a {
        USB(1) { // from class: com.fimi.soul.drone.droneconnection.connection.h.a.1
            @Override // com.fimi.soul.drone.droneconnection.connection.C2807h.EnumC2809a
            /* renamed from: b */
            public C2793b mo10915a(Context context) {
                return new C2793b(context);
            }
        },
        TCP(3) { // from class: com.fimi.soul.drone.droneconnection.connection.h.a.2
            @Override // com.fimi.soul.drone.droneconnection.connection.C2807h.EnumC2809a
            /* renamed from: b */
            public C2783a mo10915a(Context context) {
                return new C2783a(context);
            }
        };
        

        /* renamed from: c */
        private final int f10401c;

        EnumC2809a(int i) {
            this.f10401c = i;
            if (i == 3) {
                C2778a.m11026a(C2854c.f10616d);
            } else if (i != 1) {
            } else {
                C2778a.m11026a(C2854c.f10615c);
            }
        }

        /* renamed from: a */
        public int m10917a() {
            return this.f10401c;
        }

        /* renamed from: a */
        public abstract AbstractC2777a mo10915a(Context context);
    }
}
