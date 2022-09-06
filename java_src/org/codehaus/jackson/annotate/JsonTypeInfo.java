package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonTypeInfo {

    /* renamed from: org.codehaus.jackson.annotate.JsonTypeInfo$As */
    /* loaded from: classes.dex */
    public enum EnumC5695As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY
    }

    /* renamed from: org.codehaus.jackson.annotate.JsonTypeInfo$Id */
    /* loaded from: classes.dex */
    public enum EnumC5696Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        CUSTOM(null);
        
        private final String _defaultPropertyName;

        EnumC5696Id(String str) {
            this._defaultPropertyName = str;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }

    EnumC5695As include() default EnumC5695As.PROPERTY;

    String property() default "";

    EnumC5696Id use();
}
