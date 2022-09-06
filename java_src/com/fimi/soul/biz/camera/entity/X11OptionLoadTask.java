package com.fimi.soul.biz.camera.entity;

import com.fimi.soul.biz.camera.C2423d;
/* loaded from: classes.dex */
public class X11OptionLoadTask extends X11Task {
    public X11OptionLoadTask(C2423d c2423d) {
        super(c2423d);
    }

    @Override // com.fimi.soul.biz.camera.entity.X11Task
    protected void doNext() {
        getContext().m12233u().m12294b(getCurrentKey());
    }
}
