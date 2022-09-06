package com.tencent.open.p230c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.hoho.android.usbserial.driver.UsbId;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.web.security.C4365a;
import com.tencent.open.web.security.SecureJsInterface;
/* renamed from: com.tencent.open.c.c */
/* loaded from: classes2.dex */
public class C4355c extends C4354b {

    /* renamed from: a */
    public static boolean f18171a;

    /* renamed from: b */
    private KeyEvent f18172b;

    /* renamed from: c */
    private C4365a f18173c;

    public C4355c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        C4331f.m5445b("SecureWebView", "-->dispatchKeyEvent, is device support: " + f18171a);
        if (f18171a && keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 4:
                    return super.dispatchKeyEvent(keyEvent);
                case 66:
                    return super.dispatchKeyEvent(keyEvent);
                case UsbId.ARDUINO_UNO_R3 /* 67 */:
                    C4365a.f18237b = true;
                    return super.dispatchKeyEvent(keyEvent);
                default:
                    if (keyEvent.getUnicodeChar() == 0) {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    this.f18172b = new KeyEvent(0, 17);
                    return super.dispatchKeyEvent(this.f18172b);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        C4331f.m5442c("SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C4331f.m5445b("SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            f18171a = false;
            return onCreateInputConnection;
        }
        f18171a = true;
        this.f18173c = new C4365a(super.onCreateInputConnection(editorInfo), false);
        return this.f18173c;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        C4331f.m5445b("SecureWebView", "-->onKeyDown, is device support: " + f18171a);
        if (f18171a && keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 4:
                    return super.onKeyDown(i, keyEvent);
                case 66:
                    return super.onKeyDown(i, keyEvent);
                case UsbId.ARDUINO_UNO_R3 /* 67 */:
                    C4365a.f18237b = true;
                    return super.onKeyDown(i, keyEvent);
                default:
                    if (keyEvent.getUnicodeChar() == 0) {
                        return super.onKeyDown(i, keyEvent);
                    }
                    if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                        return super.onKeyDown(i, keyEvent);
                    }
                    this.f18172b = new KeyEvent(0, 17);
                    return super.onKeyDown(this.f18172b.getKeyCode(), this.f18172b);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
