package com.mob.commons.eventrecoder;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.C4145d;
import com.mob.commons.LockAction;
import com.mob.tools.MobLog;
import com.mob.tools.utils.FileLocker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class EventRecorder {

    /* renamed from: a */
    private static Context f17313a;

    /* renamed from: b */
    private static File f17314b;

    /* renamed from: c */
    private static FileOutputStream f17315c;

    /* renamed from: a */
    private static final void m6032a(LockAction lockAction) {
        C4145d.m6037a(new File(f17313a.getFilesDir(), "comm/locks/.mrlock"), lockAction);
    }

    /* renamed from: a */
    private static final void m6029a(final String str) {
        m6032a(new LockAction() { // from class: com.mob.commons.eventrecoder.EventRecorder.2
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                try {
                    EventRecorder.f17315c.write(str.getBytes("utf-8"));
                    EventRecorder.f17315c.flush();
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().m5959w(th);
                    return false;
                }
            }
        });
    }

    public static final synchronized void addBegin(String str, String str2) {
        synchronized (EventRecorder.class) {
            m6029a(str + " " + str2 + " 0\n");
        }
    }

    public static final synchronized void addEnd(String str, String str2) {
        synchronized (EventRecorder.class) {
            m6029a(str + " " + str2 + " 1\n");
        }
    }

    public static final synchronized String checkRecord(final String str) {
        String str2;
        synchronized (EventRecorder.class) {
            final LinkedList linkedList = new LinkedList();
            m6032a(new LockAction() { // from class: com.mob.commons.eventrecoder.EventRecorder.3
                @Override // com.mob.commons.LockAction
                public boolean run(FileLocker fileLocker) {
                    int indexOf;
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(EventRecorder.f17314b), "utf-8"));
                        for (String readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
                            String[] split = readLine.split(" ");
                            if (str.equals(split[0])) {
                                if ("0".equals(split[2])) {
                                    linkedList.add(split[1]);
                                } else if ("1".equals(split[2]) && (indexOf = linkedList.indexOf(split[1])) != -1) {
                                    linkedList.remove(indexOf);
                                }
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th) {
                        MobLog.getInstance().m5971d(th);
                    }
                    return false;
                }
            });
            str2 = linkedList.size() > 0 ? (String) linkedList.get(0) : null;
        }
        return str2;
    }

    public static final synchronized void clear() {
        synchronized (EventRecorder.class) {
            m6032a(new LockAction() { // from class: com.mob.commons.eventrecoder.EventRecorder.4
                @Override // com.mob.commons.LockAction
                public boolean run(FileLocker fileLocker) {
                    try {
                        EventRecorder.f17315c.close();
                        EventRecorder.f17314b.delete();
                        File unused = EventRecorder.f17314b = new File(EventRecorder.f17313a.getFilesDir(), ".mrecord");
                        EventRecorder.f17314b.createNewFile();
                        FileOutputStream unused2 = EventRecorder.f17315c = new FileOutputStream(EventRecorder.f17314b, true);
                        return false;
                    } catch (Throwable th) {
                        MobLog.getInstance().m5959w(th);
                        return false;
                    }
                }
            });
        }
    }

    public static final synchronized void prepare(Context context) {
        synchronized (EventRecorder.class) {
            f17313a = context.getApplicationContext();
            m6032a(new LockAction() { // from class: com.mob.commons.eventrecoder.EventRecorder.1
                @Override // com.mob.commons.LockAction
                public boolean run(FileLocker fileLocker) {
                    try {
                        File unused = EventRecorder.f17314b = new File(EventRecorder.f17313a.getFilesDir(), ".mrecord");
                        if (!EventRecorder.f17314b.exists()) {
                            EventRecorder.f17314b.createNewFile();
                        }
                        FileOutputStream unused2 = EventRecorder.f17315c = new FileOutputStream(EventRecorder.f17314b, true);
                        return false;
                    } catch (Throwable th) {
                        MobLog.getInstance().m5959w(th);
                        return false;
                    }
                }
            });
        }
    }
}
