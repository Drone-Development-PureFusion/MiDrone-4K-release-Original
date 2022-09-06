package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.open.GameAppOperation;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.AbstractC4401e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.tencent.stat.n */
/* loaded from: classes2.dex */
public class C4436n {

    /* renamed from: e */
    private static StatLogger f18489e = C4420k.m5197b();

    /* renamed from: f */
    private static C4436n f18490f = null;

    /* renamed from: a */
    Handler f18491a;

    /* renamed from: d */
    private C4445w f18494d;

    /* renamed from: b */
    volatile int f18492b = 0;

    /* renamed from: c */
    DeviceInfo f18493c = null;

    /* renamed from: g */
    private HashMap<String, String> f18495g = new HashMap<>();

    private C4436n(Context context) {
        this.f18491a = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            f18489e.m5233w("Launch store thread:" + handlerThread);
            this.f18491a = new Handler(handlerThread.getLooper());
            Context applicationContext = context.getApplicationContext();
            this.f18494d = new C4445w(applicationContext);
            this.f18494d.getWritableDatabase();
            this.f18494d.getReadableDatabase();
            m5121b(applicationContext);
            m5115c();
            m5111f();
            this.f18491a.post(new RunnableC4437o(this));
        } catch (Throwable th) {
            f18489e.m5236e(th);
        }
    }

    /* renamed from: a */
    public static synchronized C4436n m5134a(Context context) {
        C4436n c4436n;
        synchronized (C4436n.class) {
            if (f18490f == null) {
                f18490f = new C4436n(context);
            }
            c4436n = f18490f;
        }
        return c4436n;
    }

    /* renamed from: b */
    public static C4436n m5123b() {
        return f18490f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m5122b(int i) {
        try {
            if (this.f18492b > 0 && i > 0) {
                f18489e.m5235i("Load " + Integer.toString(this.f18492b) + " unsent events");
                ArrayList arrayList = new ArrayList();
                ArrayList<C4446x> arrayList2 = new ArrayList();
                if (i == -1 || i > StatConfig.m5300a()) {
                    i = StatConfig.m5300a();
                }
                this.f18492b -= i;
                m5114c(arrayList2, i);
                f18489e.m5235i("Peek " + Integer.toString(arrayList2.size()) + " unsent events.");
                if (!arrayList2.isEmpty()) {
                    m5116b(arrayList2, 2);
                    for (C4446x c4446x : arrayList2) {
                        arrayList.add(c4446x.f18514b);
                    }
                    C4426d.m5144b().m5143b(arrayList, new C4443u(this, arrayList2, i));
                }
            }
        } catch (Throwable th) {
            f18489e.m5236e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m5120b(AbstractC4401e abstractC4401e, AbstractC4409c abstractC4409c) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            this.f18494d.getWritableDatabase().beginTransaction();
            if (this.f18492b > StatConfig.getMaxStoreEventCount()) {
                f18489e.warn("Too many events stored in db.");
                this.f18492b -= this.f18494d.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String m5191c = C4420k.m5191c(abstractC4401e.m5245d());
            contentValues.put("content", m5191c);
            contentValues.put("send_count", "0");
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(abstractC4401e.m5248b()));
            if (this.f18494d.getWritableDatabase().insert("events", null, contentValues) == -1) {
                f18489e.error("Failed to store event:" + m5191c);
            } else {
                this.f18492b++;
                this.f18494d.getWritableDatabase().setTransactionSuccessful();
                if (abstractC4409c != null) {
                    abstractC4409c.mo5110a();
                }
            }
            try {
                this.f18494d.getWritableDatabase().endTransaction();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m5119b(C4408b c4408b) {
        Cursor cursor;
        boolean z;
        long insert;
        try {
            String m5240a = c4408b.m5240a();
            String m5201a = C4420k.m5201a(m5240a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", c4408b.f18406b.toString());
            contentValues.put("md5sum", m5201a);
            c4408b.f18407c = m5201a;
            contentValues.put(GameAppOperation.QQFAV_DATALINE_VERSION, Integer.valueOf(c4408b.f18408d));
            cursor = this.f18494d.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (true) {
                try {
                    if (!cursor.moveToNext()) {
                        z = false;
                        break;
                    } else if (cursor.getInt(0) == c4408b.f18405a) {
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    f18489e.m5236e(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (true == z) {
                insert = this.f18494d.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(c4408b.f18405a)});
            } else {
                contentValues.put("type", Integer.valueOf(c4408b.f18405a));
                insert = this.f18494d.getWritableDatabase().insert("config", null, contentValues);
            }
            if (insert == -1) {
                f18489e.m5236e("Failed to store cfg:" + m5240a);
            } else {
                f18489e.m5238d("Sucessed to store cfg:" + m5240a);
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m5117b(List<C4446x> list) {
        f18489e.m5235i("Delete " + list.size() + " sent events in thread:" + Thread.currentThread());
        this.f18494d.getWritableDatabase().beginTransaction();
        Iterator<C4446x> it2 = list.iterator();
        while (it2.hasNext()) {
            this.f18492b -= this.f18494d.getWritableDatabase().delete("events", "event_id = ?", new String[]{Long.toString(it2.next().f18513a)});
        }
        this.f18494d.getWritableDatabase().setTransactionSuccessful();
        this.f18492b = (int) DatabaseUtils.queryNumEntries(this.f18494d.getReadableDatabase(), "events");
        try {
            this.f18494d.getWritableDatabase().endTransaction();
        } catch (SQLiteException e) {
            f18489e.m5237e((Exception) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m5116b(List<C4446x> list, int i) {
        int update;
        f18489e.m5235i("Update " + list.size() + " sending events to status:" + i + " in thread:" + Thread.currentThread());
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.toString(i));
        this.f18494d.getWritableDatabase().beginTransaction();
        for (C4446x c4446x : list) {
            if (c4446x.f18516d + 1 > StatConfig.getMaxSendRetryCount()) {
                this.f18492b -= this.f18494d.getWritableDatabase().delete("events", "event_id=?", new String[]{Long.toString(c4446x.f18513a)});
            } else {
                contentValues.put("send_count", Integer.valueOf(c4446x.f18516d + 1));
                f18489e.m5235i("Update event:" + c4446x.f18513a + " for content:" + contentValues);
                if (this.f18494d.getWritableDatabase().update("events", contentValues, "event_id=?", new String[]{Long.toString(c4446x.f18513a)}) <= 0) {
                    f18489e.m5236e("Failed to update db, error code:" + Integer.toString(update));
                }
            }
        }
        this.f18494d.getWritableDatabase().setTransactionSuccessful();
        this.f18492b = (int) DatabaseUtils.queryNumEntries(this.f18494d.getReadableDatabase(), "events");
        try {
            this.f18494d.getWritableDatabase().endTransaction();
        } catch (SQLiteException e) {
            f18489e.m5237e((Exception) e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: c */
    private void m5114c(java.util.List<com.tencent.stat.C4446x> r11, int r12) {
        /*
            r10 = this;
            r9 = 0
            com.tencent.stat.w r0 = r10.f18494d     // Catch: java.lang.Throwable -> L6a
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = "events"
            r2 = 0
            java.lang.String r3 = "status=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L6a
            r5 = 0
            r6 = 1
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch: java.lang.Throwable -> L6a
            r4[r5] = r6     // Catch: java.lang.Throwable -> L6a
            r5 = 0
            r6 = 0
            java.lang.String r7 = "event_id"
            java.lang.String r8 = java.lang.Integer.toString(r12)     // Catch: java.lang.Throwable -> L6a
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6a
        L23:
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L57
            r0 = 0
            long r2 = r7.getLong(r0)     // Catch: java.lang.Throwable -> L4a
            r0 = 1
            java.lang.String r0 = r7.getString(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = com.tencent.stat.common.C4420k.m5188d(r0)     // Catch: java.lang.Throwable -> L4a
            r0 = 2
            int r5 = r7.getInt(r0)     // Catch: java.lang.Throwable -> L4a
            r0 = 3
            int r6 = r7.getInt(r0)     // Catch: java.lang.Throwable -> L4a
            com.tencent.stat.x r1 = new com.tencent.stat.x     // Catch: java.lang.Throwable -> L4a
            r1.<init>(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L4a
            r11.add(r1)     // Catch: java.lang.Throwable -> L4a
            goto L23
        L4a:
            r0 = move-exception
            r1 = r7
        L4c:
            com.tencent.stat.common.StatLogger r2 = com.tencent.stat.C4436n.f18489e     // Catch: java.lang.Throwable -> L67
            r2.m5236e(r0)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L56
            r1.close()
        L56:
            return
        L57:
            if (r7 == 0) goto L56
            r7.close()
            goto L56
        L5d:
            r0 = move-exception
        L5e:
            if (r9 == 0) goto L63
            r9.close()
        L63:
            throw r0
        L64:
            r0 = move-exception
            r9 = r7
            goto L5e
        L67:
            r0 = move-exception
            r9 = r1
            goto L5e
        L6a:
            r0 = move-exception
            r1 = r9
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C4436n.m5114c(java.util.List, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5112e() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 1);
            this.f18494d.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2L)});
            this.f18492b = (int) DatabaseUtils.queryNumEntries(this.f18494d.getReadableDatabase(), "events");
            f18489e.m5235i("Total " + this.f18492b + " unsent events.");
        } catch (Throwable th) {
            f18489e.m5236e(th);
        }
    }

    /* renamed from: f */
    private void m5111f() {
        Cursor cursor;
        try {
            cursor = this.f18494d.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                try {
                    this.f18495g.put(cursor.getString(0), cursor.getString(1));
                } catch (Throwable th) {
                    th = th;
                    try {
                        f18489e.m5236e(th);
                        if (cursor == null) {
                            return;
                        }
                        return;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (cursor == null) {
                return;
            }
            cursor.close();
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    public int m5136a() {
        return this.f18492b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5135a(int i) {
        this.f18491a.post(new RunnableC4444v(this, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5133a(AbstractC4401e abstractC4401e, AbstractC4409c abstractC4409c) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        try {
            if (Thread.currentThread().getId() == this.f18491a.getLooper().getThread().getId()) {
                m5120b(abstractC4401e, abstractC4409c);
            } else {
                this.f18491a.post(new RunnableC4440r(this, abstractC4401e, abstractC4409c));
            }
        } catch (Throwable th) {
            f18489e.m5236e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5132a(C4408b c4408b) {
        if (c4408b == null) {
            return;
        }
        this.f18491a.post(new RunnableC4441s(this, c4408b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5125a(List<C4446x> list) {
        try {
            if (Thread.currentThread().getId() == this.f18491a.getLooper().getThread().getId()) {
                m5117b(list);
            } else {
                this.f18491a.post(new RunnableC4439q(this, list));
            }
        } catch (SQLiteException e) {
            f18489e.m5237e((Exception) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5124a(List<C4446x> list, int i) {
        try {
            if (Thread.currentThread().getId() == this.f18491a.getLooper().getThread().getId()) {
                m5116b(list, i);
            } else {
                this.f18491a.post(new RunnableC4438p(this, list, i));
            }
        } catch (Throwable th) {
            f18489e.m5236e(th);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    public synchronized com.tencent.stat.DeviceInfo m5121b(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C4436n.m5121b(android.content.Context):com.tencent.stat.DeviceInfo");
    }

    /* renamed from: c */
    void m5115c() {
        this.f18491a.post(new RunnableC4442t(this));
    }
}
