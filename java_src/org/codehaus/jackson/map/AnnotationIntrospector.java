package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes.dex */
public abstract class AnnotationIntrospector {

    /* loaded from: classes2.dex */
    public static class Pair extends AnnotationIntrospector {
        protected final AnnotationIntrospector _primary;
        protected final AnnotationIntrospector _secondary;

        public Pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
            this._primary = annotationIntrospector;
            this._secondary = annotationIntrospector2;
        }

        public static AnnotationIntrospector create(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
            return annotationIntrospector == null ? annotationIntrospector2 : annotationIntrospector2 == null ? annotationIntrospector : new Pair(annotationIntrospector, annotationIntrospector2);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Collection<AnnotationIntrospector> allIntrospectors() {
            return allIntrospectors(new ArrayList());
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
            this._primary.allIntrospectors(collection);
            this._secondary.allIntrospectors(collection);
            return collection;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
            return this._primary.findAutoDetectVisibility(annotatedClass, this._secondary.findAutoDetectVisibility(annotatedClass, visibilityChecker));
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Boolean findCachability(AnnotatedClass annotatedClass) {
            Boolean findCachability = this._primary.findCachability(annotatedClass);
            return findCachability == null ? this._secondary.findCachability(annotatedClass) : findCachability;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated annotated) {
            Class<? extends JsonDeserializer<?>> findContentDeserializer = this._primary.findContentDeserializer(annotated);
            return (findContentDeserializer == null || findContentDeserializer == JsonDeserializer.None.class) ? this._secondary.findContentDeserializer(annotated) : findContentDeserializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated annotated) {
            Class<? extends JsonSerializer<?>> findContentSerializer = this._primary.findContentSerializer(annotated);
            return (findContentSerializer == null || findContentSerializer == JsonSerializer.None.class) ? this._secondary.findContentSerializer(annotated) : findContentSerializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findDeserializablePropertyName(AnnotatedField annotatedField) {
            String findDeserializablePropertyName;
            String findDeserializablePropertyName2 = this._primary.findDeserializablePropertyName(annotatedField);
            return findDeserializablePropertyName2 == null ? this._secondary.findDeserializablePropertyName(annotatedField) : (findDeserializablePropertyName2.length() != 0 || (findDeserializablePropertyName = this._secondary.findDeserializablePropertyName(annotatedField)) == null) ? findDeserializablePropertyName2 : findDeserializablePropertyName;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType, String str) {
            Class<?> findDeserializationContentType = this._primary.findDeserializationContentType(annotated, javaType, str);
            return findDeserializationContentType == null ? this._secondary.findDeserializationContentType(annotated, javaType, str) : findDeserializationContentType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType, String str) {
            Class<?> findDeserializationKeyType = this._primary.findDeserializationKeyType(annotated, javaType, str);
            return findDeserializationKeyType == null ? this._secondary.findDeserializationKeyType(annotated, javaType, str) : findDeserializationKeyType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?> findDeserializationType(Annotated annotated, JavaType javaType, String str) {
            Class<?> findDeserializationType = this._primary.findDeserializationType(annotated, javaType, str);
            return findDeserializationType == null ? this._secondary.findDeserializationType(annotated, javaType, str) : findDeserializationType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Object findDeserializer(Annotated annotated) {
            Object findDeserializer = this._primary.findDeserializer(annotated);
            return findDeserializer == null ? this._secondary.findDeserializer(annotated) : findDeserializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        /* renamed from: findDeserializer */
        public Object mo22016findDeserializer(Annotated annotated, BeanProperty beanProperty) {
            Object mo22016findDeserializer = this._primary.mo22016findDeserializer(annotated, beanProperty);
            return mo22016findDeserializer == null ? this._secondary.mo22016findDeserializer(annotated, beanProperty) : mo22016findDeserializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findEnumValue(Enum<?> r2) {
            String findEnumValue = this._primary.findEnumValue(r2);
            return findEnumValue == null ? this._secondary.findEnumValue(r2) : findEnumValue;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Object findFilterId(AnnotatedClass annotatedClass) {
            Object findFilterId = this._primary.findFilterId(annotatedClass);
            return findFilterId == null ? this._secondary.findFilterId(annotatedClass) : findFilterId;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findGettablePropertyName(AnnotatedMethod annotatedMethod) {
            String findGettablePropertyName;
            String findGettablePropertyName2 = this._primary.findGettablePropertyName(annotatedMethod);
            return findGettablePropertyName2 == null ? this._secondary.findGettablePropertyName(annotatedMethod) : (findGettablePropertyName2.length() != 0 || (findGettablePropertyName = this._secondary.findGettablePropertyName(annotatedMethod)) == null) ? findGettablePropertyName2 : findGettablePropertyName;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass) {
            Boolean findIgnoreUnknownProperties = this._primary.findIgnoreUnknownProperties(annotatedClass);
            return findIgnoreUnknownProperties == null ? this._secondary.findIgnoreUnknownProperties(annotatedClass) : findIgnoreUnknownProperties;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<? extends KeyDeserializer> findKeyDeserializer(Annotated annotated) {
            Class<? extends KeyDeserializer> findKeyDeserializer = this._primary.findKeyDeserializer(annotated);
            return (findKeyDeserializer == null || findKeyDeserializer == KeyDeserializer.None.class) ? this._secondary.findKeyDeserializer(annotated) : findKeyDeserializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated annotated) {
            Class<? extends JsonSerializer<?>> findKeySerializer = this._primary.findKeySerializer(annotated);
            return (findKeySerializer == null || findKeySerializer == JsonSerializer.None.class) ? this._secondary.findKeySerializer(annotated) : findKeySerializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String[] findPropertiesToIgnore(AnnotatedClass annotatedClass) {
            String[] findPropertiesToIgnore = this._primary.findPropertiesToIgnore(annotatedClass);
            return findPropertiesToIgnore == null ? this._secondary.findPropertiesToIgnore(annotatedClass) : findPropertiesToIgnore;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
            TypeResolverBuilder<?> findPropertyContentTypeResolver = this._primary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType);
            return findPropertyContentTypeResolver == null ? this._secondary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType) : findPropertyContentTypeResolver;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findPropertyNameForParam(AnnotatedParameter annotatedParameter) {
            String findPropertyNameForParam = this._primary.findPropertyNameForParam(annotatedParameter);
            return findPropertyNameForParam == null ? this._secondary.findPropertyNameForParam(annotatedParameter) : findPropertyNameForParam;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
            TypeResolverBuilder<?> findPropertyTypeResolver = this._primary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType);
            return findPropertyTypeResolver == null ? this._secondary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType) : findPropertyTypeResolver;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
            ReferenceProperty findReferenceType = this._primary.findReferenceType(annotatedMember);
            return findReferenceType == null ? this._secondary.findReferenceType(annotatedMember) : findReferenceType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findRootName(AnnotatedClass annotatedClass) {
            String findRootName;
            String findRootName2 = this._primary.findRootName(annotatedClass);
            return findRootName2 == null ? this._secondary.findRootName(annotatedClass) : (findRootName2.length() > 0 || (findRootName = this._secondary.findRootName(annotatedClass)) == null) ? findRootName2 : findRootName;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findSerializablePropertyName(AnnotatedField annotatedField) {
            String findSerializablePropertyName;
            String findSerializablePropertyName2 = this._primary.findSerializablePropertyName(annotatedField);
            return findSerializablePropertyName2 == null ? this._secondary.findSerializablePropertyName(annotatedField) : (findSerializablePropertyName2.length() != 0 || (findSerializablePropertyName = this._secondary.findSerializablePropertyName(annotatedField)) == null) ? findSerializablePropertyName2 : findSerializablePropertyName;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
            Class<?> findSerializationContentType = this._primary.findSerializationContentType(annotated, javaType);
            return findSerializationContentType == null ? this._secondary.findSerializationContentType(annotated, javaType) : findSerializationContentType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, JsonSerialize.Inclusion inclusion) {
            return this._primary.findSerializationInclusion(annotated, this._secondary.findSerializationInclusion(annotated, inclusion));
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
            Class<?> findSerializationKeyType = this._primary.findSerializationKeyType(annotated, javaType);
            return findSerializationKeyType == null ? this._secondary.findSerializationKeyType(annotated, javaType) : findSerializationKeyType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass) {
            String[] findSerializationPropertyOrder = this._primary.findSerializationPropertyOrder(annotatedClass);
            return findSerializationPropertyOrder == null ? this._secondary.findSerializationPropertyOrder(annotatedClass) : findSerializationPropertyOrder;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedClass) {
            Boolean findSerializationSortAlphabetically = this._primary.findSerializationSortAlphabetically(annotatedClass);
            return findSerializationSortAlphabetically == null ? this._secondary.findSerializationSortAlphabetically(annotatedClass) : findSerializationSortAlphabetically;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?> findSerializationType(Annotated annotated) {
            Class<?> findSerializationType = this._primary.findSerializationType(annotated);
            return findSerializationType == null ? this._secondary.findSerializationType(annotated) : findSerializationType;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public JsonSerialize.Typing findSerializationTyping(Annotated annotated) {
            JsonSerialize.Typing findSerializationTyping = this._primary.findSerializationTyping(annotated);
            return findSerializationTyping == null ? this._secondary.findSerializationTyping(annotated) : findSerializationTyping;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Class<?>[] findSerializationViews(Annotated annotated) {
            Class<?>[] findSerializationViews = this._primary.findSerializationViews(annotated);
            return findSerializationViews == null ? this._secondary.findSerializationViews(annotated) : findSerializationViews;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Object findSerializer(Annotated annotated) {
            Object findSerializer = this._primary.findSerializer(annotated);
            return findSerializer == null ? this._secondary.findSerializer(annotated) : findSerializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        /* renamed from: findSerializer */
        public Object mo22017findSerializer(Annotated annotated, BeanProperty beanProperty) {
            Object mo22017findSerializer = this._primary.mo22017findSerializer(annotated, beanProperty);
            return mo22017findSerializer == null ? this._secondary.mo22017findSerializer(annotated, beanProperty) : mo22017findSerializer;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findSettablePropertyName(AnnotatedMethod annotatedMethod) {
            String findSettablePropertyName;
            String findSettablePropertyName2 = this._primary.findSettablePropertyName(annotatedMethod);
            return findSettablePropertyName2 == null ? this._secondary.findSettablePropertyName(annotatedMethod) : (findSettablePropertyName2.length() != 0 || (findSettablePropertyName = this._secondary.findSettablePropertyName(annotatedMethod)) == null) ? findSettablePropertyName2 : findSettablePropertyName;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public List<NamedType> findSubtypes(Annotated annotated) {
            List<NamedType> findSubtypes = this._primary.findSubtypes(annotated);
            List<NamedType> findSubtypes2 = this._secondary.findSubtypes(annotated);
            if (findSubtypes == null || findSubtypes.isEmpty()) {
                return findSubtypes2;
            }
            if (findSubtypes2 == null || findSubtypes2.isEmpty()) {
                return findSubtypes;
            }
            ArrayList arrayList = new ArrayList(findSubtypes.size() + findSubtypes2.size());
            arrayList.addAll(findSubtypes);
            arrayList.addAll(findSubtypes2);
            return arrayList;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public String findTypeName(AnnotatedClass annotatedClass) {
            String findTypeName = this._primary.findTypeName(annotatedClass);
            return (findTypeName == null || findTypeName.length() == 0) ? this._secondary.findTypeName(annotatedClass) : findTypeName;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
            TypeResolverBuilder<?> findTypeResolver = this._primary.findTypeResolver(mapperConfig, annotatedClass, javaType);
            return findTypeResolver == null ? this._secondary.findTypeResolver(mapperConfig, annotatedClass, javaType) : findTypeResolver;
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
            return this._primary.hasAnyGetterAnnotation(annotatedMethod) || this._secondary.hasAnyGetterAnnotation(annotatedMethod);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
            return this._primary.hasAnySetterAnnotation(annotatedMethod) || this._secondary.hasAnySetterAnnotation(annotatedMethod);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
            return this._primary.hasAsValueAnnotation(annotatedMethod) || this._secondary.hasAsValueAnnotation(annotatedMethod);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean hasCreatorAnnotation(Annotated annotated) {
            return this._primary.hasCreatorAnnotation(annotated) || this._secondary.hasCreatorAnnotation(annotated);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean isHandled(Annotation annotation) {
            return this._primary.isHandled(annotation) || this._secondary.isHandled(annotation);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean isIgnorableConstructor(AnnotatedConstructor annotatedConstructor) {
            return this._primary.isIgnorableConstructor(annotatedConstructor) || this._secondary.isIgnorableConstructor(annotatedConstructor);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean isIgnorableField(AnnotatedField annotatedField) {
            return this._primary.isIgnorableField(annotatedField) || this._secondary.isIgnorableField(annotatedField);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public boolean isIgnorableMethod(AnnotatedMethod annotatedMethod) {
            return this._primary.isIgnorableMethod(annotatedMethod) || this._secondary.isIgnorableMethod(annotatedMethod);
        }

        @Override // org.codehaus.jackson.map.AnnotationIntrospector
        public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
            Boolean isIgnorableType = this._primary.isIgnorableType(annotatedClass);
            return isIgnorableType == null ? this._secondary.isIgnorableType(annotatedClass) : isIgnorableType;
        }
    }

    /* loaded from: classes2.dex */
    public static class ReferenceProperty {
        private final String _name;
        private final Type _type;

        /* loaded from: classes2.dex */
        public enum Type {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public ReferenceProperty(Type type, String str) {
            this._type = type;
            this._name = str;
        }

        public static ReferenceProperty back(String str) {
            return new ReferenceProperty(Type.BACK_REFERENCE, str);
        }

        public static ReferenceProperty managed(String str) {
            return new ReferenceProperty(Type.MANAGED_REFERENCE, str);
        }

        public String getName() {
            return this._name;
        }

        public Type getType() {
            return this._type;
        }

        public boolean isBackReference() {
            return this._type == Type.BACK_REFERENCE;
        }

        public boolean isManagedReference() {
            return this._type == Type.MANAGED_REFERENCE;
        }
    }

    public static AnnotationIntrospector nopInstance() {
        return NopAnnotationIntrospector.instance;
    }

    public static AnnotationIntrospector pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        return new Pair(annotationIntrospector, annotationIntrospector2);
    }

    public Collection<AnnotationIntrospector> allIntrospectors() {
        return Collections.singletonList(this);
    }

    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        collection.add(this);
        return collection;
    }

    public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public abstract Boolean findCachability(AnnotatedClass annotatedClass);

    public abstract Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated annotated);

    public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated annotated) {
        return null;
    }

    public abstract String findDeserializablePropertyName(AnnotatedField annotatedField);

    public abstract Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType, String str);

    public abstract Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType, String str);

    public abstract Class<?> findDeserializationType(Annotated annotated, JavaType javaType, String str);

    public Object findDeserializer(Annotated annotated) {
        return mo22016findDeserializer(annotated, null);
    }

    @Deprecated
    /* renamed from: findDeserializer */
    public Object mo22016findDeserializer(Annotated annotated, BeanProperty beanProperty) {
        if (beanProperty != null) {
            return findDeserializer(annotated);
        }
        return null;
    }

    public abstract String findEnumValue(Enum<?> r1);

    public Object findFilterId(AnnotatedClass annotatedClass) {
        return null;
    }

    public abstract String findGettablePropertyName(AnnotatedMethod annotatedMethod);

    public abstract Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass);

    public abstract Class<? extends KeyDeserializer> findKeyDeserializer(Annotated annotated);

    public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated annotated) {
        return null;
    }

    public abstract String[] findPropertiesToIgnore(AnnotatedClass annotatedClass);

    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public abstract String findPropertyNameForParam(AnnotatedParameter annotatedParameter);

    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        return null;
    }

    public abstract String findRootName(AnnotatedClass annotatedClass);

    public abstract String findSerializablePropertyName(AnnotatedField annotatedField);

    public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, JsonSerialize.Inclusion inclusion) {
        return inclusion;
    }

    public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public abstract String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass);

    public abstract Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedClass);

    public abstract Class<?> findSerializationType(Annotated annotated);

    public abstract JsonSerialize.Typing findSerializationTyping(Annotated annotated);

    public abstract Class<?>[] findSerializationViews(Annotated annotated);

    public Object findSerializer(Annotated annotated) {
        return mo22017findSerializer(annotated, null);
    }

    @Deprecated
    /* renamed from: findSerializer */
    public Object mo22017findSerializer(Annotated annotated, BeanProperty beanProperty) {
        if (beanProperty != null) {
            return findSerializer(annotated);
        }
        return null;
    }

    public abstract String findSettablePropertyName(AnnotatedMethod annotatedMethod);

    public List<NamedType> findSubtypes(Annotated annotated) {
        return null;
    }

    public String findTypeName(AnnotatedClass annotatedClass) {
        return null;
    }

    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public abstract boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod);

    public boolean hasCreatorAnnotation(Annotated annotated) {
        return false;
    }

    public abstract boolean isHandled(Annotation annotation);

    public abstract boolean isIgnorableConstructor(AnnotatedConstructor annotatedConstructor);

    public abstract boolean isIgnorableField(AnnotatedField annotatedField);

    public abstract boolean isIgnorableMethod(AnnotatedMethod annotatedMethod);

    public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
        return null;
    }
}
