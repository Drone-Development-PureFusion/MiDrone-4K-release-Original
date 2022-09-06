package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ImmutableList<E> extends ArrayList<E> {
    private ImmutableList(List<E> list) {
        super(list);
    }

    public static <E> ImmutableList<E> copyOf(List<E> list) {
        return new ImmutableList<>(list);
    }
}
