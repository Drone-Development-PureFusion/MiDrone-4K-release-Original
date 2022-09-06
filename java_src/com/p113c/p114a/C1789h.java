package com.p113c.p114a;
/* renamed from: com.c.a.h */
/* loaded from: classes.dex */
public class C1789h implements AbstractC1818p<Integer> {
    @Override // com.p113c.p114a.AbstractC1818p
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Integer mo14531a(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (((num2.intValue() - intValue) * f) + intValue));
    }
}
