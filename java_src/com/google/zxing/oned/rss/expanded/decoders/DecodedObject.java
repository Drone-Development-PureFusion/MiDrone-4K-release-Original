package com.google.zxing.oned.rss.expanded.decoders;
/* loaded from: classes.dex */
abstract class DecodedObject {
    protected final int newPosition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedObject(int i) {
        this.newPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNewPosition() {
        return this.newPosition;
    }
}
