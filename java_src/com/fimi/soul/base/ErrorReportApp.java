package com.fimi.soul.base;

import com.fimi.kernel.BaseApplication;
import com.fimi.soul.biz.p185n.C2558d;
import com.fimi.soul.utils.C3704u;
import java.io.PrintStream;
import java.lang.Thread;
/* loaded from: classes.dex */
public class ErrorReportApp extends BaseApplication {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f7905a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f7906b = new Thread.UncaughtExceptionHandler() { // from class: com.fimi.soul.base.ErrorReportApp.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            new C2351a(th).m12514a();
            ErrorReportApp.this.f7905a.uncaughtException(thread, th);
        }
    };

    /* renamed from: com.fimi.soul.base.ErrorReportApp$a */
    /* loaded from: classes.dex */
    class C2351a {

        /* renamed from: b */
        private Throwable f7909b;

        public C2351a(Throwable th) {
            this.f7909b = th;
        }

        /* renamed from: a */
        public void m12514a() {
            StackTraceElement[] stackTrace;
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.f7909b.toString());
                for (StackTraceElement stackTraceElement : this.f7909b.getStackTrace()) {
                    stringBuffer.append(", Class Name:");
                    stringBuffer.append(stackTraceElement.getClassName());
                    stringBuffer.append(" , Method Name:");
                    stringBuffer.append(stackTraceElement.getMethodName());
                    stringBuffer.append(" , LineNumber:");
                    stringBuffer.append(stackTraceElement.getLineNumber());
                }
                C2558d.m11697a(ErrorReportApp.this.getApplicationContext()).m11695a(stringBuffer.toString());
                PrintStream printStream = new PrintStream(C3704u.m7419b());
                this.f7909b.printStackTrace(printStream);
                printStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.fimi.kernel.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        this.f7905a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this.f7906b);
    }
}
