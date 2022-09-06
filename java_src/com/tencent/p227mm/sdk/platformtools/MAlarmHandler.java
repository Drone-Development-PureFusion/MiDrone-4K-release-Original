package com.tencent.p227mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import p069c.p071b.C0609a;
/* renamed from: com.tencent.mm.sdk.platformtools.MAlarmHandler */
/* loaded from: classes.dex */
public class MAlarmHandler {
    public static final long NEXT_FIRE_INTERVAL = Long.MAX_VALUE;

    /* renamed from: aC */
    private static IBumper f17824aC;

    /* renamed from: av */
    private static int f17826av;

    /* renamed from: aB */
    private final CallBack f17827aB;

    /* renamed from: aw */
    private final int f17828aw;

    /* renamed from: ax */
    private final boolean f17829ax;

    /* renamed from: ay */
    private long f17830ay = 0;

    /* renamed from: az */
    private long f17831az = 0;

    /* renamed from: aA */
    private static Map<Integer, MAlarmHandler> f17823aA = new HashMap();

    /* renamed from: aD */
    private static boolean f17825aD = false;

    /* renamed from: com.tencent.mm.sdk.platformtools.MAlarmHandler$CallBack */
    /* loaded from: classes.dex */
    public interface CallBack {
        boolean onTimerExpired();
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.MAlarmHandler$IBumper */
    /* loaded from: classes.dex */
    public interface IBumper {
        void cancel();

        void prepare();
    }

    public MAlarmHandler(CallBack callBack, boolean z) {
        C0609a.m19953a("bumper not initialized", f17825aD);
        this.f17827aB = callBack;
        this.f17829ax = z;
        if (f17826av >= 8192) {
            f17826av = 0;
        }
        int i = f17826av + 1;
        f17826av = i;
        this.f17828aw = i;
    }

    public static long fire() {
        LinkedList linkedList = new LinkedList();
        HashSet<Integer> hashSet = new HashSet();
        hashSet.addAll(f17823aA.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            MAlarmHandler mAlarmHandler = f17823aA.get(num);
            if (mAlarmHandler != null) {
                long ticksToNow = Util.ticksToNow(mAlarmHandler.f17830ay);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                if (ticksToNow > mAlarmHandler.f17831az) {
                    if (!mAlarmHandler.f17827aB.onTimerExpired() || !mAlarmHandler.f17829ax) {
                        linkedList.add(num);
                    } else {
                        j = mAlarmHandler.f17831az;
                    }
                    mAlarmHandler.f17830ay = Util.currentTicks();
                } else if (mAlarmHandler.f17831az - ticksToNow < j) {
                    j = mAlarmHandler.f17831az - ticksToNow;
                }
            }
            j = j;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            f17823aA.remove(linkedList.get(i));
        }
        if (j == Long.MAX_VALUE && f17824aC != null) {
            f17824aC.cancel();
            Log.m5641v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public static void initAlarmBumper(IBumper iBumper) {
        f17825aD = true;
        f17824aC = iBumper;
    }

    protected void finalize() {
        stopTimer();
        super.finalize();
    }

    public void startTimer(long j) {
        long j2;
        this.f17831az = j;
        this.f17830ay = Util.currentTicks();
        long j3 = this.f17831az;
        Log.m5649d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j3);
        long j4 = Long.MAX_VALUE;
        Iterator<Map.Entry<Integer, MAlarmHandler>> it2 = f17823aA.entrySet().iterator();
        while (true) {
            j2 = j4;
            if (!it2.hasNext()) {
                break;
            }
            MAlarmHandler value = it2.next().getValue();
            if (value != null) {
                long ticksToNow = Util.ticksToNow(value.f17830ay);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                if (ticksToNow > value.f17831az) {
                    j4 = value.f17831az;
                } else if (value.f17831az - ticksToNow < j2) {
                    j2 = value.f17831az - ticksToNow;
                }
            }
            j4 = j2;
        }
        boolean z = j2 > j3;
        stopTimer();
        f17823aA.put(Integer.valueOf(this.f17828aw), this);
        if (f17824aC == null || !z) {
            return;
        }
        Log.m5641v("MicroMsg.MAlarmHandler", "prepare bumper");
        f17824aC.prepare();
    }

    public void stopTimer() {
        f17823aA.remove(Integer.valueOf(this.f17828aw));
    }

    public boolean stopped() {
        return !f17823aA.containsKey(Integer.valueOf(this.f17828aw));
    }
}
