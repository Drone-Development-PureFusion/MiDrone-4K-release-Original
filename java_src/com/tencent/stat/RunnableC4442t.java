package com.tencent.stat;

import android.database.Cursor;
import com.tencent.stat.common.StatLogger;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.t */
/* loaded from: classes2.dex */
public class RunnableC4442t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4436n f18507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4442t(C4436n c4436n) {
        this.f18507a = c4436n;
    }

    @Override // java.lang.Runnable
    public void run() {
        Cursor cursor;
        StatLogger statLogger;
        C4445w c4445w;
        try {
            c4445w = this.f18507a.f18494d;
            cursor = c4445w.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                try {
                    int i = cursor.getInt(0);
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(2);
                    int i2 = cursor.getInt(3);
                    C4408b c4408b = new C4408b(i);
                    c4408b.f18405a = i;
                    c4408b.f18406b = new JSONObject(string);
                    c4408b.f18407c = string2;
                    c4408b.f18408d = i2;
                    StatConfig.m5295a(c4408b);
                } catch (Throwable th) {
                    th = th;
                    try {
                        statLogger = C4436n.f18489e;
                        statLogger.m5236e(th);
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
}
