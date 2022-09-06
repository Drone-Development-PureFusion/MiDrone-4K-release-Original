package org.p290c.p291a.p296e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: org.c.a.e.b */
/* loaded from: classes.dex */
public @interface AbstractC5474b {
    /* renamed from: a */
    String[] m964a() default {};

    /* renamed from: b */
    Class<? extends Throwable>[] m963b() default {};
}
