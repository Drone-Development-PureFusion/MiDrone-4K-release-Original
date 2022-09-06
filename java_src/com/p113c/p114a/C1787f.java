package com.p113c.p114a;
/* renamed from: com.c.a.f */
/* loaded from: classes.dex */
public class C1787f implements AbstractC1818p<Number> {
    @Override // com.p113c.p114a.AbstractC1818p
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Float mo14531a(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + ((number2.floatValue() - floatValue) * f));
    }
}
