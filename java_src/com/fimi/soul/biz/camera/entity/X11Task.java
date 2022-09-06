package com.fimi.soul.biz.camera.entity;

import com.fimi.soul.biz.camera.C2423d;
/* loaded from: classes.dex */
public abstract class X11Task {
    private C2423d context;
    private String currentKey;
    private int index = 0;
    private String[] optionKeys;

    public X11Task(C2423d c2423d) {
        this.context = c2423d;
    }

    protected abstract void doNext();

    /* JADX INFO: Access modifiers changed from: protected */
    public C2423d getContext() {
        return this.context;
    }

    public String getCurrentKey() {
        return this.currentKey;
    }

    public int getIndex() {
        return this.index;
    }

    public String[] getOptionKeys() {
        return this.optionKeys;
    }

    public boolean isNext() {
        return this.optionKeys != null && this.index < this.optionKeys.length;
    }

    public boolean next() {
        if (isNext()) {
            this.currentKey = this.optionKeys[this.index];
            this.index++;
            doNext();
            return true;
        }
        return false;
    }

    public void setCurrentKey(String str) {
        this.currentKey = str;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setOptionKeys(String[] strArr) {
        this.optionKeys = strArr;
    }
}
