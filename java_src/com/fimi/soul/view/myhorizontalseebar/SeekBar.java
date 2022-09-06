package com.fimi.soul.view.myhorizontalseebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public class SeekBar extends AbsSeekBar {

    /* renamed from: n */
    private AbstractC3854a f16370n;

    /* renamed from: com.fimi.soul.view.myhorizontalseebar.SeekBar$a */
    /* loaded from: classes.dex */
    public interface AbstractC3854a {
        /* renamed from: a */
        void mo6786a(SeekBar seekBar);

        /* renamed from: a */
        void mo6785a(SeekBar seekBar, int i, boolean z);

        /* renamed from: b */
        void mo6784b(SeekBar seekBar);
    }

    public SeekBar(Context context) {
        this(context, null);
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842875);
    }

    public SeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.fimi.soul.view.myhorizontalseebar.AbsSeekBar
    /* renamed from: a */
    public void mo6789a() {
        super.mo6789a();
        if (this.f16370n != null) {
            this.f16370n.mo6786a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.fimi.soul.view.myhorizontalseebar.AbsSeekBar, com.fimi.soul.view.myhorizontalseebar.ProgressBar
    /* renamed from: a */
    public void mo6788a(float f, boolean z) {
        super.mo6788a(f, z);
        if (this.f16370n != null) {
            this.f16370n.mo6785a(this, getProgress(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.fimi.soul.view.myhorizontalseebar.AbsSeekBar
    /* renamed from: b */
    public void mo6787b() {
        super.mo6787b();
        if (this.f16370n != null) {
            this.f16370n.mo6784b(this);
        }
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.AbsSeekBar, com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SeekBar.class.getName());
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.AbsSeekBar, com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SeekBar.class.getName());
    }

    public void setOnSeekBarChangeListener(AbstractC3854a abstractC3854a) {
        this.f16370n = abstractC3854a;
    }
}
