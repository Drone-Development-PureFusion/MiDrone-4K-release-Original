package com.github.moduth.blockcanary;

import com.github.moduth.blockcanary.p215b.C3947a;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.p248a.p249a.p261f.p264c.C5122l;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.moduth.blockcanary.f */
/* loaded from: classes.dex */
public class C3960f extends AbstractC3970m {

    /* renamed from: d */
    private static final String f16961d = "CpuSampler";

    /* renamed from: f */
    private static final int f16962f = 10;

    /* renamed from: g */
    private final LinkedHashMap<Long, String> f16964g = new LinkedHashMap<>();

    /* renamed from: h */
    private int f16965h = 0;

    /* renamed from: i */
    private long f16966i = 0;

    /* renamed from: j */
    private long f16967j = 0;

    /* renamed from: k */
    private long f16968k = 0;

    /* renamed from: l */
    private long f16969l = 0;

    /* renamed from: m */
    private long f16970m = 0;

    /* renamed from: n */
    private long f16971n = 0;

    /* renamed from: e */
    private final int f16963e = (int) (((float) this.f16994c) * 1.2f);

    public C3960f(long j) {
        super(j);
    }

    /* renamed from: a */
    private void m6376a(String str, String str2) {
        String[] split = str.split(" ");
        if (split.length < 9) {
            return;
        }
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        long parseLong3 = Long.parseLong(split[4]);
        long parseLong4 = Long.parseLong(split[5]);
        long parseLong5 = Long.parseLong(split[6]);
        long parseLong6 = parseLong2 + parseLong + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
        String[] split2 = str2.split(" ");
        if (split2.length < 17) {
            return;
        }
        long parseLong7 = Long.parseLong(split2[13]) + Long.parseLong(split2[14]) + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
        if (this.f16970m != 0) {
            StringBuilder sb = new StringBuilder();
            long j = parseLong4 - this.f16968k;
            long j2 = parseLong6 - this.f16970m;
            sb.append("cpu:").append(((j2 - j) * 100) / j2).append("% ").append("app:").append(((parseLong7 - this.f16971n) * 100) / j2).append("% ").append("[").append("user:").append(((parseLong - this.f16966i) * 100) / j2).append("% ").append("system:").append(((parseLong3 - this.f16967j) * 100) / j2).append("% ").append("ioWait:").append(((parseLong5 - this.f16969l) * 100) / j2).append("% ]");
            synchronized (this.f16964g) {
                this.f16964g.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
                if (this.f16964g.size() > 10) {
                    Iterator<Map.Entry<Long, String>> it2 = this.f16964g.entrySet().iterator();
                    if (it2.hasNext()) {
                        this.f16964g.remove(it2.next().getKey());
                    }
                }
            }
        }
        this.f16966i = parseLong;
        this.f16967j = parseLong3;
        this.f16968k = parseLong4;
        this.f16969l = parseLong5;
        this.f16970m = parseLong6;
        this.f16971n = parseLong7;
    }

    /* renamed from: e */
    private void m6374e() {
        this.f16966i = 0L;
        this.f16967j = 0L;
        this.f16968k = 0L;
        this.f16969l = 0L;
        this.f16970m = 0L;
        this.f16971n = 0L;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3970m
    /* renamed from: a */
    public void mo6348a() {
        super.mo6348a();
        m6374e();
    }

    /* renamed from: a */
    public boolean m6377a(long j, long j2) {
        if (j2 - j > this.f16994c) {
            long j3 = j - this.f16994c;
            long j4 = j + this.f16994c;
            long j5 = 0;
            synchronized (this.f16964g) {
                for (Map.Entry<Long, String> entry : this.f16964g.entrySet()) {
                    long longValue = entry.getKey().longValue();
                    if (j3 >= longValue || longValue >= j4) {
                        longValue = j5;
                    } else if (j5 != 0 && longValue - j5 > this.f16963e) {
                        return true;
                    }
                    j5 = longValue;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public String m6375b() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        synchronized (this.f16964g) {
            for (Map.Entry<Long, String> entry : this.f16964g.entrySet()) {
                sb.append(simpleDateFormat.format(Long.valueOf(entry.getKey().longValue()))).append(C5122l.f21763c).append(entry.getValue()).append(C3947a.f16890a);
            }
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    @Override // com.github.moduth.blockcanary.AbstractC3970m
    /* renamed from: c */
    protected void mo6344c() {
        /*
            r8 = this;
            r1 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L72
            java.lang.String r4 = "/proc/stat"
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L72
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L72
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.<init>(r0, r2)     // Catch: java.lang.Throwable -> L72
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> Lad
            if (r0 != 0) goto Lb4
            java.lang.String r0 = ""
            r4 = r0
        L1d:
            int r0 = r8.f16965h     // Catch: java.lang.Throwable -> Lad
            if (r0 != 0) goto L27
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> Lad
            r8.f16965h = r0     // Catch: java.lang.Throwable -> Lad
        L27:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lad
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lad
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r6.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r7 = "/proc/"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lad
            int r7 = r8.f16965h     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r7 = "/stat"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lad
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lad
            r0.<init>(r5)     // Catch: java.lang.Throwable -> Lad
            r5 = 1000(0x3e8, float:1.401E-42)
            r2.<init>(r0, r5)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> Lb0
            if (r0 != 0) goto L5b
            java.lang.String r0 = ""
        L5b:
            r8.m6376a(r4, r0)     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.io.IOException -> L69
        L63:
            if (r2 == 0) goto L68
            r2.close()     // Catch: java.io.IOException -> L69
        L68:
            return
        L69:
            r0 = move-exception
            java.lang.String r1 = "CpuSampler"
            java.lang.String r2 = "doSample: "
            android.util.Log.e(r1, r2, r0)
            goto L68
        L72:
            r0 = move-exception
            r2 = r1
        L74:
            java.lang.String r3 = "CpuSampler"
            java.lang.String r4 = "doSample: "
            android.util.Log.e(r3, r4, r0)     // Catch: java.lang.Throwable -> Laa
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L86
        L80:
            if (r1 == 0) goto L68
            r1.close()     // Catch: java.io.IOException -> L86
            goto L68
        L86:
            r0 = move-exception
            java.lang.String r1 = "CpuSampler"
            java.lang.String r2 = "doSample: "
            android.util.Log.e(r1, r2, r0)
            goto L68
        L8f:
            r0 = move-exception
            r3 = r1
        L91:
            if (r3 == 0) goto L96
            r3.close()     // Catch: java.io.IOException -> L9c
        L96:
            if (r1 == 0) goto L9b
            r1.close()     // Catch: java.io.IOException -> L9c
        L9b:
            throw r0
        L9c:
            r1 = move-exception
            java.lang.String r2 = "CpuSampler"
            java.lang.String r3 = "doSample: "
            android.util.Log.e(r2, r3, r1)
            goto L9b
        La5:
            r0 = move-exception
            goto L91
        La7:
            r0 = move-exception
            r1 = r2
            goto L91
        Laa:
            r0 = move-exception
            r3 = r2
            goto L91
        Lad:
            r0 = move-exception
            r2 = r3
            goto L74
        Lb0:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L74
        Lb4:
            r4 = r0
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.moduth.blockcanary.C3960f.mo6344c():void");
    }
}
