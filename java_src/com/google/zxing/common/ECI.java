package com.google.zxing.common;
/* loaded from: classes.dex */
public abstract class ECI {
    private final int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECI(int i) {
        this.value = i;
    }

    public static ECI getECIByValue(int i) {
        if (i < 0 || i > 999999) {
            throw new IllegalArgumentException(new StringBuffer().append("Bad ECI value: ").append(i).toString());
        }
        if (i >= 900) {
            return null;
        }
        return CharacterSetECI.getCharacterSetECIByValue(i);
    }

    public int getValue() {
        return this.value;
    }
}
