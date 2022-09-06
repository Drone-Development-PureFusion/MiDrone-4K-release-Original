package com.p080b;

import android.location.GpsStatus;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cj */
/* loaded from: classes.dex */
public final class C1500cj extends Thread {

    /* renamed from: a */
    private /* synthetic */ C1499ci f5372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1500cj(C1499ci c1499ci, String str) {
        super(str);
        this.f5372a = c1499ci;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C1501ck c1501ck;
        C1502cl c1502cl;
        Looper looper;
        Looper looper2;
        C1502cl c1502cl2;
        C1501ck c1501ck2;
        C1501ck c1501ck3;
        C1502cl c1502cl3;
        Looper looper3;
        Looper looper4;
        C1499ci c1499ci;
        C1502cl c1502cl4;
        C1501ck c1501ck4;
        C1501ck c1501ck5;
        C1501ck c1501ck6;
        C1502cl c1502cl5;
        Looper looper5;
        Looper looper6;
        C1502cl c1502cl6;
        C1501ck c1501ck7;
        C1502cl c1502cl7;
        try {
            synchronized (this.f5372a.f5350d) {
                Looper.prepare();
                this.f5372a.f5349H = Looper.myLooper();
                this.f5372a.f5347F = new Timer();
                this.f5372a.f5342A = new C1501ck(this.f5372a, (byte) 0);
                C1499ci c1499ci2 = this.f5372a;
                c1501ck5 = this.f5372a.f5342A;
                C1499ci.m15821a(c1499ci2, (PhoneStateListener) c1501ck5);
                this.f5372a.f5343B = new C1502cl(this.f5372a, (byte) 0);
                try {
                    C1499ci c1499ci3 = this.f5372a;
                    c1502cl7 = this.f5372a.f5343B;
                    C1499ci.m15825a(c1499ci3, (GpsStatus.NmeaListener) c1502cl7);
                } catch (Exception e) {
                }
            }
            if (this.f5372a.f5351e) {
                Looper.loop();
            }
            c1501ck6 = this.f5372a.f5342A;
            if (c1501ck6 != null) {
                C1499ci c1499ci4 = this.f5372a;
                c1501ck7 = this.f5372a.f5342A;
                c1499ci4.m15830a((PhoneStateListener) c1501ck7);
                this.f5372a.f5342A = null;
            }
            c1502cl5 = this.f5372a.f5343B;
            if (c1502cl5 != null) {
                C1499ci c1499ci5 = this.f5372a;
                c1502cl6 = this.f5372a.f5343B;
                c1499ci5.m15834a((GpsStatus.NmeaListener) c1502cl6);
                this.f5372a.f5343B = null;
            }
            looper5 = this.f5372a.f5349H;
        } catch (Exception e2) {
            c1501ck3 = this.f5372a.f5342A;
            if (c1501ck3 != null) {
                C1499ci c1499ci6 = this.f5372a;
                c1501ck4 = this.f5372a.f5342A;
                c1499ci6.m15830a((PhoneStateListener) c1501ck4);
                this.f5372a.f5342A = null;
            }
            c1502cl3 = this.f5372a.f5343B;
            if (c1502cl3 != null) {
                C1499ci c1499ci7 = this.f5372a;
                c1502cl4 = this.f5372a.f5343B;
                c1499ci7.m15834a((GpsStatus.NmeaListener) c1502cl4);
                this.f5372a.f5343B = null;
            }
            looper3 = this.f5372a.f5349H;
            if (looper3 == null) {
                return;
            }
            looper4 = this.f5372a.f5349H;
            looper4.quit();
            c1499ci = this.f5372a;
        } catch (Throwable th) {
            c1501ck = this.f5372a.f5342A;
            if (c1501ck != null) {
                C1499ci c1499ci8 = this.f5372a;
                c1501ck2 = this.f5372a.f5342A;
                c1499ci8.m15830a((PhoneStateListener) c1501ck2);
                this.f5372a.f5342A = null;
            }
            c1502cl = this.f5372a.f5343B;
            if (c1502cl != null) {
                C1499ci c1499ci9 = this.f5372a;
                c1502cl2 = this.f5372a.f5343B;
                c1499ci9.m15834a((GpsStatus.NmeaListener) c1502cl2);
                this.f5372a.f5343B = null;
            }
            looper = this.f5372a.f5349H;
            if (looper != null) {
                looper2 = this.f5372a.f5349H;
                looper2.quit();
                this.f5372a.f5349H = null;
            }
            throw th;
        }
        if (looper5 != null) {
            looper6 = this.f5372a.f5349H;
            looper6.quit();
            c1499ci = this.f5372a;
            c1499ci.f5349H = null;
        }
    }
}
