package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ClassIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public class BasicClassIntrospector extends ClassIntrospector<BasicBeanDescription> {
    public static final GetterMethodFilter DEFAULT_GETTER_FILTER = new GetterMethodFilter();
    public static final SetterMethodFilter DEFAULT_SETTER_FILTER = new SetterMethodFilter();
    public static final SetterAndGetterMethodFilter DEFAULT_SETTER_AND_GETTER_FILTER = new SetterAndGetterMethodFilter();
    public static final BasicClassIntrospector instance = new BasicClassIntrospector();

    /* loaded from: classes2.dex */
    public static class GetterMethodFilter implements MethodFilter {
        private GetterMethodFilter() {
        }

        @Override // org.codehaus.jackson.map.introspect.MethodFilter
        public boolean includeMethod(Method method) {
            return ClassUtil.hasGetterSignature(method);
        }
    }

    /* loaded from: classes2.dex */
    public static final class SetterAndGetterMethodFilter extends SetterMethodFilter {
        @Override // org.codehaus.jackson.map.introspect.BasicClassIntrospector.SetterMethodFilter, org.codehaus.jackson.map.introspect.MethodFilter
        public boolean includeMethod(Method method) {
            if (super.includeMethod(method)) {
                return true;
            }
            if (!ClassUtil.hasGetterSignature(method)) {
                return false;
            }
            Class<?> returnType = method.getReturnType();
            return Collection.class.isAssignableFrom(returnType) || Map.class.isAssignableFrom(returnType);
        }
    }

    /* loaded from: classes2.dex */
    public static class SetterMethodFilter implements MethodFilter {
        @Override // org.codehaus.jackson.map.introspect.MethodFilter
        public boolean includeMethod(Method method) {
            if (Modifier.isStatic(method.getModifiers())) {
                return false;
            }
            switch (method.getParameterTypes().length) {
                case 1:
                    return true;
                case 2:
                    return true;
                default:
                    return false;
            }
        }
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    public /* bridge */ /* synthetic */ BasicBeanDescription forClassAnnotations(MapperConfig mapperConfig, Class cls, ClassIntrospector.MixInResolver mixInResolver) {
        return forClassAnnotations2((MapperConfig<?>) mapperConfig, (Class<?>) cls, mixInResolver);
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    /* renamed from: forClassAnnotations  reason: avoid collision after fix types in other method */
    public BasicBeanDescription forClassAnnotations2(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = mapperConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        return new BasicBeanDescription(mapperConfig, mapperConfig.constructType(cls), AnnotatedClass.construct(cls, annotationIntrospector, mixInResolver));
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    public BasicBeanDescription forCreation(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = deserializationConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Class<?> rawClass = javaType.getRawClass();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        AnnotatedClass construct = AnnotatedClass.construct(rawClass, annotationIntrospector, mixInResolver);
        construct.resolveCreators(true);
        return new BasicBeanDescription(deserializationConfig, javaType, construct);
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    public BasicBeanDescription forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = deserializationConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Class<?> rawClass = javaType.getRawClass();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        AnnotatedClass construct = AnnotatedClass.construct(rawClass, annotationIntrospector, mixInResolver);
        construct.resolveMemberMethods(getDeserializationMethodFilter(deserializationConfig), true);
        construct.resolveCreators(true);
        construct.resolveFields(true);
        return new BasicBeanDescription(deserializationConfig, javaType, construct);
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    public /* bridge */ /* synthetic */ BasicBeanDescription forDirectClassAnnotations(MapperConfig mapperConfig, Class cls, ClassIntrospector.MixInResolver mixInResolver) {
        return forDirectClassAnnotations2((MapperConfig<?>) mapperConfig, (Class<?>) cls, mixInResolver);
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    /* renamed from: forDirectClassAnnotations  reason: avoid collision after fix types in other method */
    public BasicBeanDescription forDirectClassAnnotations2(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = mapperConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        return new BasicBeanDescription(mapperConfig, mapperConfig.constructType(cls), AnnotatedClass.constructWithoutSuperTypes(cls, annotationIntrospector, mixInResolver));
    }

    @Override // org.codehaus.jackson.map.ClassIntrospector
    public BasicBeanDescription forSerialization(SerializationConfig serializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        AnnotatedClass construct = AnnotatedClass.construct(javaType.getRawClass(), serializationConfig.getAnnotationIntrospector(), mixInResolver);
        construct.resolveMemberMethods(getSerializationMethodFilter(serializationConfig), false);
        construct.resolveCreators(true);
        construct.resolveFields(false);
        return new BasicBeanDescription(serializationConfig, javaType, construct);
    }

    protected MethodFilter getDeserializationMethodFilter(DeserializationConfig deserializationConfig) {
        return deserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS) ? DEFAULT_SETTER_AND_GETTER_FILTER : DEFAULT_SETTER_FILTER;
    }

    protected MethodFilter getSerializationMethodFilter(SerializationConfig serializationConfig) {
        return DEFAULT_GETTER_FILTER;
    }
}
