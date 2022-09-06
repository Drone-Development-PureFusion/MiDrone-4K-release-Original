package com.fimi.soul.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
/* loaded from: classes.dex */
public class MyEditView extends EditText {

    /* renamed from: a */
    private AbstractC3726b f15411a;

    /* renamed from: com.fimi.soul.view.MyEditView$a */
    /* loaded from: classes.dex */
    public class C3725a extends InputConnectionWrapper {
        public C3725a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean finishComposingText() {
            boolean finishComposingText = super.finishComposingText();
            if (MyEditView.this.f15411a != null && MyEditView.this.isFocusable()) {
                MyEditView.this.f15411a.m7264a();
            }
            return finishComposingText;
        }
    }

    /* renamed from: com.fimi.soul.view.MyEditView$b */
    /* loaded from: classes.dex */
    public interface AbstractC3726b {
        /* renamed from: a */
        void m7264a();
    }

    public MyEditView(Context context) {
        super(context);
    }

    public MyEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new C3725a(super.onCreateInputConnection(editorInfo), false);
    }

    public void setOnFinishComposingListener(AbstractC3726b abstractC3726b) {
        this.f15411a = abstractC3726b;
    }
}
