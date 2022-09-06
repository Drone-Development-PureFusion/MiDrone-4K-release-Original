package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.p228a.C4331f;
/* renamed from: com.tencent.open.web.security.a */
/* loaded from: classes2.dex */
public class C4365a extends InputConnectionWrapper {

    /* renamed from: a */
    public static String f18236a;

    /* renamed from: b */
    public static boolean f18237b = false;

    /* renamed from: c */
    public static boolean f18238c = false;

    public C4365a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        f18238c = true;
        f18236a = charSequence.toString();
        C4331f.m5445b("CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            C4331f.m5442c("CaptureInputConnection", "sendKeyEvent");
            f18236a = String.valueOf((char) keyEvent.getUnicodeChar());
            f18238c = true;
            C4331f.m5442c("CaptureInputConnection", "s: " + f18236a);
        }
        C4331f.m5445b("CaptureInputConnection", "-->sendKeyEvent: " + f18236a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        f18238c = true;
        f18236a = charSequence.toString();
        C4331f.m5445b("CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
