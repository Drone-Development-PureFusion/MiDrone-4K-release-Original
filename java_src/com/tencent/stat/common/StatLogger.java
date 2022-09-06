package com.tencent.stat.common;

import android.util.Log;
import com.github.moduth.blockcanary.p215b.C3947a;
/* loaded from: classes2.dex */
public final class StatLogger {

    /* renamed from: a */
    private String f18410a;

    /* renamed from: b */
    private boolean f18411b;

    /* renamed from: c */
    private int f18412c;

    public StatLogger() {
        this.f18410a = "default";
        this.f18411b = true;
        this.f18412c = 2;
    }

    public StatLogger(String str) {
        this.f18410a = "default";
        this.f18411b = true;
        this.f18412c = 2;
        this.f18410a = str;
    }

    /* renamed from: a */
    private String m5239a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    /* renamed from: d */
    public void m5238d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public void debug(Object obj) {
        if (this.f18412c <= 3) {
            String m5239a = m5239a();
            Log.d(this.f18410a, m5239a == null ? obj.toString() : m5239a + " - " + obj);
        }
    }

    /* renamed from: e */
    public void m5237e(Exception exc) {
        if (isDebugEnable()) {
            error(exc);
        }
    }

    /* renamed from: e */
    public void m5236e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public void error(Exception exc) {
        if (this.f18412c <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String m5239a = m5239a();
            StackTraceElement[] stackTrace = exc.getStackTrace();
            if (m5239a != null) {
                stringBuffer.append(m5239a + " - " + exc + C3947a.f16890a);
            } else {
                stringBuffer.append(exc + C3947a.f16890a);
            }
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        stringBuffer.append("[ " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " ]\r\n");
                    }
                }
            }
            Log.e(this.f18410a, stringBuffer.toString());
        }
    }

    public void error(Object obj) {
        if (this.f18412c <= 6) {
            String m5239a = m5239a();
            Log.e(this.f18410a, m5239a == null ? obj.toString() : m5239a + " - " + obj);
        }
    }

    public int getLogLevel() {
        return this.f18412c;
    }

    /* renamed from: i */
    public void m5235i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void info(Object obj) {
        if (this.f18412c <= 4) {
            String m5239a = m5239a();
            Log.i(this.f18410a, m5239a == null ? obj.toString() : m5239a + " - " + obj);
        }
    }

    public boolean isDebugEnable() {
        return this.f18411b;
    }

    public void setDebugEnable(boolean z) {
        this.f18411b = z;
    }

    public void setLogLevel(int i) {
        this.f18412c = i;
    }

    public void setTag(String str) {
        this.f18410a = str;
    }

    /* renamed from: v */
    public void m5234v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void verbose(Object obj) {
        if (this.f18412c <= 2) {
            String m5239a = m5239a();
            Log.v(this.f18410a, m5239a == null ? obj.toString() : m5239a + " - " + obj);
        }
    }

    /* renamed from: w */
    public void m5233w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void warn(Object obj) {
        if (this.f18412c <= 5) {
            String m5239a = m5239a();
            Log.w(this.f18410a, m5239a == null ? obj.toString() : m5239a + " - " + obj);
        }
    }
}
