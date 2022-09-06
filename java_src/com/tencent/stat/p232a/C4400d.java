package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.C4420k;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.d */
/* loaded from: classes2.dex */
public class C4400d extends AbstractC4401e {

    /* renamed from: a */
    private String f18369a;

    /* renamed from: l */
    private int f18370l;

    /* renamed from: m */
    private int f18371m = 100;

    public C4400d(Context context, int i, int i2, Throwable th) {
        super(context, i);
        if (th != null) {
            Throwable th2 = new Throwable(th);
            try {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                if (stackTrace != null && stackTrace.length > this.f18371m) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[this.f18371m];
                    for (int i3 = 0; i3 < this.f18371m; i3++) {
                        stackTraceElementArr[i3] = stackTrace[i3];
                    }
                    th2.setStackTrace(stackTraceElementArr);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            this.f18369a = stringWriter.toString();
            this.f18370l = i2;
            printWriter.close();
        }
    }

    public C4400d(Context context, int i, String str, int i2, int i3) {
        super(context, i);
        if (str != null) {
            i3 = i3 <= 0 ? StatConfig.getMaxReportEventLength() : i3;
            if (str.length() <= i3) {
                this.f18369a = str;
            } else {
                this.f18369a = str.substring(0, i3);
            }
        }
        this.f18370l = i2;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.ERROR;
    }

    /* renamed from: a */
    public void m5249a(long j) {
        this.f18374c = j;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        C4420k.m5199a(jSONObject, "er", this.f18369a);
        jSONObject.put("ea", this.f18370l);
        return true;
    }
}
