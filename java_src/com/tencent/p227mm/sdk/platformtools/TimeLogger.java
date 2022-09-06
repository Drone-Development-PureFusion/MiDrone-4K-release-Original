package com.tencent.p227mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;
/* renamed from: com.tencent.mm.sdk.platformtools.TimeLogger */
/* loaded from: classes.dex */
public class TimeLogger {

    /* renamed from: bg */
    private String f17867bg;

    /* renamed from: bh */
    private String f17868bh;

    /* renamed from: bi */
    private boolean f17869bi;

    /* renamed from: bj */
    ArrayList<Long> f17870bj;

    /* renamed from: bk */
    ArrayList<String> f17871bk;

    public TimeLogger(String str, String str2) {
        reset(str, str2);
    }

    public void addSplit(String str) {
        if (this.f17869bi) {
            return;
        }
        this.f17870bj.add(Long.valueOf(SystemClock.elapsedRealtime()));
        this.f17871bk.add(str);
    }

    public void dumpToLog() {
        long longValue;
        if (this.f17869bi) {
            return;
        }
        Log.m5649d(this.f17867bg, this.f17868bh + ": begin");
        int i = 1;
        long longValue2 = this.f17870bj.get(0).longValue();
        while (i < this.f17870bj.size()) {
            long longValue3 = this.f17870bj.get(i).longValue();
            long longValue4 = this.f17870bj.get(i - 1).longValue();
            Log.m5649d(this.f17867bg, this.f17868bh + ":      " + (longValue3 - longValue4) + " ms, " + this.f17871bk.get(i));
            i++;
            longValue2 = longValue3;
        }
        Log.m5649d(this.f17867bg, this.f17868bh + ": end, " + (longValue2 - longValue) + " ms");
    }

    public void reset() {
        this.f17869bi = false;
        if (this.f17869bi) {
            return;
        }
        if (this.f17870bj == null) {
            this.f17870bj = new ArrayList<>();
            this.f17871bk = new ArrayList<>();
        } else {
            this.f17870bj.clear();
            this.f17871bk.clear();
        }
        addSplit(null);
    }

    public void reset(String str, String str2) {
        this.f17867bg = str;
        this.f17868bh = str2;
        reset();
    }
}
