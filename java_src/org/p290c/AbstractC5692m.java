package org.p290c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: org.c.m */
/* loaded from: classes.dex */
public @interface AbstractC5692m {

    /* renamed from: org.c.m$a */
    /* loaded from: classes.dex */
    public static class C5693a extends Throwable {
        private static final long serialVersionUID = 1;

        private C5693a() {
        }
    }

    /* renamed from: a */
    Class<? extends Throwable> m279a() default C5693a.class;

    /* renamed from: b */
    long m278b() default 0;
}
