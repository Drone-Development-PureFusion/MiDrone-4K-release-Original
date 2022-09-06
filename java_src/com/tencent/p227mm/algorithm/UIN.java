package com.tencent.p227mm.algorithm;
/* renamed from: com.tencent.mm.algorithm.UIN */
/* loaded from: classes.dex */
public class UIN extends Number {

    /* renamed from: h */
    private int f17749h;

    public UIN(int i) {
        this.f17749h = 0;
        this.f17749h = i;
    }

    public UIN(long j) {
        this.f17749h = 0;
        this.f17749h = (int) ((-1) & j);
    }

    public static int valueOf(String str) {
        try {
            return new UIN(Long.valueOf(str).longValue()).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (this.f17749h | 0) + 0.0d;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) ((this.f17749h | 0) + 0.0d);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f17749h;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f17749h & 4294967295L;
    }

    public String toString() {
        return String.valueOf(this.f17749h & 4294967295L);
    }

    public int value() {
        return this.f17749h;
    }
}
