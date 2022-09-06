package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.p228a.C4331f;
/* renamed from: com.tencent.open.b */
/* loaded from: classes2.dex */
public abstract class AbstractDialogC4335b extends Dialog {
    protected C4315a jsBridge;
    @SuppressLint({"NewApi"})
    protected final WebChromeClient mChromeClient = new WebChromeClient() { // from class: com.tencent.open.b.1
        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            C4331f.m5442c("WebConsole", str + " -- From 222 line " + i + " of " + str2);
            if (Build.VERSION.SDK_INT == 7) {
                AbstractDialogC4335b.this.onConsoleMessage(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            C4331f.m5442c("WebConsole", consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            if (Build.VERSION.SDK_INT > 7) {
                AbstractDialogC4335b.this.onConsoleMessage(consoleMessage == null ? "" : consoleMessage.message());
            }
            return true;
        }
    };

    public AbstractDialogC4335b(Context context) {
        super(context);
    }

    public AbstractDialogC4335b(Context context, int i) {
        super(context, i);
    }

    protected abstract void onConsoleMessage(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jsBridge = new C4315a();
    }
}
