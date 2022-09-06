package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@JacksonAnnotation
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonWriteNullProperties {
    boolean value() default true;
}
