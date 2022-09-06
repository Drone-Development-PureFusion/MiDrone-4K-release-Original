package org.codehaus.jackson.map.deser;

import com.tencent.p227mm.sdk.message.RMsgInfoDB;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes.dex */
public class BeanDeserializerFactory extends BasicDeserializerFactory {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(null);
    protected final DeserializerFactory.Config _factoryConfig;

    /* loaded from: classes2.dex */
    public static class ConfigImpl extends DeserializerFactory.Config {
        protected final AbstractTypeResolver[] _abstractTypeResolvers;
        protected final Deserializers[] _additionalDeserializers;
        protected final KeyDeserializers[] _additionalKeyDeserializers;
        protected final BeanDeserializerModifier[] _modifiers;
        protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
        protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
        protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];

        public ConfigImpl() {
            this(null, null, null, null);
        }

        protected ConfigImpl(Deserializers[] deserializersArr, KeyDeserializers[] keyDeserializersArr, BeanDeserializerModifier[] beanDeserializerModifierArr, AbstractTypeResolver[] abstractTypeResolverArr) {
            this._additionalDeserializers = deserializersArr == null ? BeanDeserializerFactory.NO_DESERIALIZERS : deserializersArr;
            this._additionalKeyDeserializers = keyDeserializersArr == null ? NO_KEY_DESERIALIZERS : keyDeserializersArr;
            this._modifiers = beanDeserializerModifierArr == null ? NO_MODIFIERS : beanDeserializerModifierArr;
            this._abstractTypeResolvers = abstractTypeResolverArr == null ? NO_ABSTRACT_TYPE_RESOLVERS : abstractTypeResolverArr;
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public Iterable<AbstractTypeResolver> abstractTypeResolvers() {
            return ArrayBuilders.arrayAsIterable(this._abstractTypeResolvers);
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public Iterable<BeanDeserializerModifier> deserializerModifiers() {
            return ArrayBuilders.arrayAsIterable(this._modifiers);
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public Iterable<Deserializers> deserializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalDeserializers);
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public boolean hasAbstractTypeResolvers() {
            return this._abstractTypeResolvers.length > 0;
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public boolean hasDeserializerModifiers() {
            return this._modifiers.length > 0;
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public boolean hasDeserializers() {
            return this._additionalDeserializers.length > 0;
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public boolean hasKeyDeserializers() {
            return this._additionalKeyDeserializers.length > 0;
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public Iterable<KeyDeserializers> keyDeserializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalKeyDeserializers);
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
            if (abstractTypeResolver == null) {
                throw new IllegalArgumentException("Can not pass null resolver");
            }
            return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, (AbstractTypeResolver[]) ArrayBuilders.insertInListNoDup(this._abstractTypeResolvers, abstractTypeResolver));
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public DeserializerFactory.Config withAdditionalDeserializers(Deserializers deserializers) {
            if (deserializers == null) {
                throw new IllegalArgumentException("Can not pass null Deserializers");
            }
            return new ConfigImpl((Deserializers[]) ArrayBuilders.insertInListNoDup(this._additionalDeserializers, deserializers), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers);
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
            if (keyDeserializers == null) {
                throw new IllegalArgumentException("Can not pass null KeyDeserializers");
            }
            return new ConfigImpl(this._additionalDeserializers, (KeyDeserializers[]) ArrayBuilders.insertInListNoDup(this._additionalKeyDeserializers, keyDeserializers), this._modifiers, this._abstractTypeResolvers);
        }

        @Override // org.codehaus.jackson.map.DeserializerFactory.Config
        public DeserializerFactory.Config withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
            if (beanDeserializerModifier == null) {
                throw new IllegalArgumentException("Can not pass null modifier");
            }
            return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, (BeanDeserializerModifier[]) ArrayBuilders.insertInListNoDup(this._modifiers, beanDeserializerModifier), this._abstractTypeResolvers);
        }
    }

    @Deprecated
    public BeanDeserializerFactory() {
        this(null);
    }

    public BeanDeserializerFactory(DeserializerFactory.Config config) {
        this._factoryConfig = config == null ? new ConfigImpl() : config;
    }

    protected void _addDeserializerConstructors(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorContainer creatorContainer) {
        for (AnnotatedConstructor annotatedConstructor : basicBeanDescription.getConstructors()) {
            int parameterCount = annotatedConstructor.getParameterCount();
            if (parameterCount >= 1) {
                boolean hasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedConstructor);
                boolean isCreatorVisible = visibilityChecker.isCreatorVisible(annotatedConstructor);
                if (parameterCount == 1) {
                    AnnotatedParameter parameter = annotatedConstructor.getParameter(0);
                    String findPropertyNameForParam = annotationIntrospector.findPropertyNameForParam(parameter);
                    if (findPropertyNameForParam == null || findPropertyNameForParam.length() == 0) {
                        Class<?> parameterClass = annotatedConstructor.getParameterClass(0);
                        if (parameterClass == String.class) {
                            if (hasCreatorAnnotation || isCreatorVisible) {
                                creatorContainer.addStringConstructor(annotatedConstructor);
                            }
                        } else if (parameterClass == Integer.TYPE || parameterClass == Integer.class) {
                            if (hasCreatorAnnotation || isCreatorVisible) {
                                creatorContainer.addIntConstructor(annotatedConstructor);
                            }
                        } else if (parameterClass == Long.TYPE || parameterClass == Long.class) {
                            if (hasCreatorAnnotation || isCreatorVisible) {
                                creatorContainer.addLongConstructor(annotatedConstructor);
                            }
                        } else if (hasCreatorAnnotation) {
                            creatorContainer.addDelegatingConstructor(annotatedConstructor);
                        }
                    } else {
                        creatorContainer.addPropertyConstructor(annotatedConstructor, new SettableBeanProperty[]{constructCreatorProperty(deserializationConfig, basicBeanDescription, findPropertyNameForParam, 0, parameter)});
                    }
                } else if (hasCreatorAnnotation || isCreatorVisible) {
                    SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                    int i = 0;
                    boolean z = false;
                    boolean z2 = false;
                    while (i < parameterCount) {
                        AnnotatedParameter parameter2 = annotatedConstructor.getParameter(i);
                        String findPropertyNameForParam2 = parameter2 == null ? null : annotationIntrospector.findPropertyNameForParam(parameter2);
                        boolean z3 = z2 | (findPropertyNameForParam2 == null || findPropertyNameForParam2.length() == 0);
                        boolean z4 = z | (!z3);
                        if (z3 && (z4 || hasCreatorAnnotation)) {
                            throw new IllegalArgumentException("Argument #" + i + " of constructor " + annotatedConstructor + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                        }
                        settableBeanPropertyArr[i] = constructCreatorProperty(deserializationConfig, basicBeanDescription, findPropertyNameForParam2, i, parameter2);
                        i++;
                        z2 = z3;
                        z = z4;
                    }
                    if (z) {
                        creatorContainer.addPropertyConstructor(annotatedConstructor, settableBeanPropertyArr);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void _addDeserializerFactoryMethods(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorContainer creatorContainer) {
        int i;
        for (AnnotatedMethod annotatedMethod : basicBeanDescription.getFactoryMethods()) {
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount >= 1) {
                boolean hasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedMethod);
                if (parameterCount == 1) {
                    String findPropertyNameForParam = annotationIntrospector.findPropertyNameForParam(annotatedMethod.getParameter(0));
                    if (findPropertyNameForParam == null || findPropertyNameForParam.length() == 0) {
                        Class<?> parameterClass = annotatedMethod.getParameterClass(0);
                        if (parameterClass == String.class) {
                            if (hasCreatorAnnotation || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                                creatorContainer.addStringFactory(annotatedMethod);
                            }
                        } else if (parameterClass == Integer.TYPE || parameterClass == Integer.class) {
                            if (hasCreatorAnnotation || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                                creatorContainer.addIntFactory(annotatedMethod);
                            }
                        } else if (parameterClass == Long.TYPE || parameterClass == Long.class) {
                            if (hasCreatorAnnotation || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                                creatorContainer.addLongFactory(annotatedMethod);
                            }
                        } else if (annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
                            creatorContainer.addDelegatingFactory(annotatedMethod);
                        }
                    } else {
                        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                        for (i = 0; i < parameterCount; i++) {
                            AnnotatedParameter parameter = annotatedMethod.getParameter(i);
                            String findPropertyNameForParam2 = annotationIntrospector.findPropertyNameForParam(parameter);
                            if (findPropertyNameForParam2 == null || findPropertyNameForParam2.length() == 0) {
                                throw new IllegalArgumentException("Argument #" + i + " of factory method " + annotatedMethod + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
                            }
                            settableBeanPropertyArr[i] = constructCreatorProperty(deserializationConfig, basicBeanDescription, findPropertyNameForParam2, i, parameter);
                        }
                        creatorContainer.addPropertyFactory(annotatedMethod, settableBeanPropertyArr);
                    }
                } else if (annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
                    SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                    while (i < parameterCount) {
                    }
                    creatorContainer.addPropertyFactory(annotatedMethod, settableBeanPropertyArr2);
                } else {
                    continue;
                }
            }
        }
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findArrayDeserializer = deserializers.findArrayDeserializer(arrayType, deserializationConfig, deserializerProvider, beanProperty, typeDeserializer, jsonDeserializer);
            if (findArrayDeserializer != null) {
                return findArrayDeserializer;
            }
        }
        return null;
    }

    protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findBeanDeserializer = deserializers.findBeanDeserializer(javaType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty);
            if (findBeanDeserializer != null) {
                return findBeanDeserializer;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionDeserializer = deserializers.findCollectionDeserializer(collectionType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, typeDeserializer, jsonDeserializer);
            if (findCollectionDeserializer != null) {
                return findCollectionDeserializer;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionLikeDeserializer = deserializers.findCollectionLikeDeserializer(collectionLikeType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, typeDeserializer, jsonDeserializer);
            if (findCollectionLikeDeserializer != null) {
                return findCollectionLikeDeserializer;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findEnumDeserializer = deserializers.findEnumDeserializer(cls, deserializationConfig, basicBeanDescription, beanProperty);
            if (findEnumDeserializer != null) {
                return findEnumDeserializer;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapDeserializer = deserializers.findMapDeserializer(mapType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapDeserializer != null) {
                return findMapDeserializer;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapLikeDeserializer = deserializers.findMapLikeDeserializer(mapLikeType, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapLikeDeserializer != null) {
                return findMapLikeDeserializer;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanProperty beanProperty) {
        for (Deserializers deserializers : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findTreeNodeDeserializer = deserializers.findTreeNodeDeserializer(cls, deserializationConfig, beanProperty);
            if (findTreeNodeDeserializer != null) {
                return findTreeNodeDeserializer;
            }
        }
        return null;
    }

    protected JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) {
        JavaType findTypeMapping;
        Class<?> rawClass = javaType.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver abstractTypeResolver : this._factoryConfig.abstractTypeResolvers()) {
                JavaType findTypeMapping2 = abstractTypeResolver.findTypeMapping(deserializationConfig, javaType);
                if (findTypeMapping2 != null && findTypeMapping2.getRawClass() != rawClass) {
                    return findTypeMapping2;
                }
            }
        }
        AbstractTypeResolver abstractTypeResolver2 = deserializationConfig.getAbstractTypeResolver();
        if (abstractTypeResolver2 == null || (findTypeMapping = abstractTypeResolver2.findTypeMapping(deserializationConfig, javaType)) == null || findTypeMapping.getRawClass() == rawClass) {
            return null;
        }
        return findTypeMapping;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void addBeanProps(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        VisibilityChecker<?> defaultVisibilityChecker = deserializationConfig.getDefaultVisibilityChecker();
        VisibilityChecker<?> visibilityChecker = defaultVisibilityChecker;
        if (!deserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_SETTERS)) {
            visibilityChecker = defaultVisibilityChecker.mo21983withSetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        VisibilityChecker<?> visibilityChecker2 = visibilityChecker;
        if (!deserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_FIELDS)) {
            visibilityChecker2 = visibilityChecker.mo21980withFieldVisibility(JsonAutoDetect.Visibility.NONE);
        }
        VisibilityChecker<?> findAutoDetectVisibility = deserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(basicBeanDescription.getClassInfo(), visibilityChecker2);
        LinkedHashMap<String, AnnotatedMethod> findSetters = basicBeanDescription.findSetters(findAutoDetectVisibility);
        AnnotatedMethod findAnySetter = basicBeanDescription.findAnySetter();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Boolean findIgnoreUnknownProperties = annotationIntrospector.findIgnoreUnknownProperties(basicBeanDescription.getClassInfo());
        if (findIgnoreUnknownProperties != null) {
            beanDeserializerBuilder.setIgnoreUnknownProperties(findIgnoreUnknownProperties.booleanValue());
        }
        HashSet arrayToSet = ArrayBuilders.arrayToSet(annotationIntrospector.findPropertiesToIgnore(basicBeanDescription.getClassInfo()));
        Iterator it2 = arrayToSet.iterator();
        while (it2.hasNext()) {
            beanDeserializerBuilder.addIgnorable((String) it2.next());
        }
        AnnotatedClass classInfo = basicBeanDescription.getClassInfo();
        for (AnnotatedMethod annotatedMethod : classInfo.ignoredMemberMethods()) {
            String okNameForSetter = basicBeanDescription.okNameForSetter(annotatedMethod);
            if (okNameForSetter != null) {
                beanDeserializerBuilder.addIgnorable(okNameForSetter);
            }
        }
        for (AnnotatedField annotatedField : classInfo.ignoredFields()) {
            beanDeserializerBuilder.addIgnorable(annotatedField.getName());
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, AnnotatedMethod> entry : findSetters.entrySet()) {
            String key = entry.getKey();
            if (!arrayToSet.contains(key)) {
                AnnotatedMethod value = entry.getValue();
                if (isIgnorableType(deserializationConfig, basicBeanDescription, value.getParameterClass(0), hashMap)) {
                    beanDeserializerBuilder.addIgnorable(key);
                } else {
                    SettableBeanProperty constructSettableProperty = constructSettableProperty(deserializationConfig, basicBeanDescription, key, value);
                    if (constructSettableProperty != null) {
                        beanDeserializerBuilder.addProperty(constructSettableProperty);
                    }
                }
            }
        }
        if (findAnySetter != null) {
            beanDeserializerBuilder.setAnySetter(constructAnySetter(deserializationConfig, basicBeanDescription, findAnySetter));
        }
        HashSet hashSet = new HashSet(findSetters.keySet());
        for (Map.Entry<String, AnnotatedField> entry2 : basicBeanDescription.findDeserializableFields(findAutoDetectVisibility, hashSet).entrySet()) {
            String key2 = entry2.getKey();
            if (!arrayToSet.contains(key2) && !beanDeserializerBuilder.hasProperty(key2)) {
                AnnotatedField value2 = entry2.getValue();
                if (isIgnorableType(deserializationConfig, basicBeanDescription, value2.getRawType(), hashMap)) {
                    beanDeserializerBuilder.addIgnorable(key2);
                } else {
                    SettableBeanProperty constructSettableProperty2 = constructSettableProperty(deserializationConfig, basicBeanDescription, key2, value2);
                    if (constructSettableProperty2 != null) {
                        beanDeserializerBuilder.addProperty(constructSettableProperty2);
                        hashSet.add(key2);
                    }
                }
            }
        }
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS)) {
            for (Map.Entry<String, AnnotatedMethod> entry3 : basicBeanDescription.findGetters(findAutoDetectVisibility, hashSet).entrySet()) {
                AnnotatedMethod value3 = entry3.getValue();
                Class<?> rawType = value3.getRawType();
                if (Collection.class.isAssignableFrom(rawType) || Map.class.isAssignableFrom(rawType)) {
                    String key3 = entry3.getKey();
                    if (!arrayToSet.contains(key3) && !beanDeserializerBuilder.hasProperty(key3)) {
                        beanDeserializerBuilder.addProperty(constructSetterlessProperty(deserializationConfig, basicBeanDescription, key3, value3));
                        hashSet.add(key3);
                    }
                }
            }
        }
    }

    protected void addReferenceProperties(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        Map<String, AnnotatedMember> findBackReferenceProperties = basicBeanDescription.findBackReferenceProperties();
        if (findBackReferenceProperties != null) {
            for (Map.Entry<String, AnnotatedMember> entry : findBackReferenceProperties.entrySet()) {
                String key = entry.getKey();
                AnnotatedMember value = entry.getValue();
                if (value instanceof AnnotatedMethod) {
                    beanDeserializerBuilder.addBackReferenceProperty(key, constructSettableProperty(deserializationConfig, basicBeanDescription, value.getName(), (AnnotatedMethod) value));
                } else {
                    beanDeserializerBuilder.addBackReferenceProperty(key, constructSettableProperty(deserializationConfig, basicBeanDescription, value.getName(), (AnnotatedField) value));
                }
            }
        }
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) {
        BeanDeserializerBuilder beanDeserializerBuilder;
        if (javaType.isAbstract()) {
            return new AbstractDeserializer(javaType);
        }
        BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(basicBeanDescription);
        constructBeanDeserializerBuilder.setCreators(findDeserializerCreators(deserializationConfig, basicBeanDescription));
        addBeanProps(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
        addReferenceProperties(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (true) {
                beanDeserializerBuilder = constructBeanDeserializerBuilder;
                if (!it2.hasNext()) {
                    break;
                }
                constructBeanDeserializerBuilder = it2.next().updateBuilder(deserializationConfig, basicBeanDescription, beanDeserializerBuilder);
            }
        } else {
            beanDeserializerBuilder = constructBeanDeserializerBuilder;
        }
        JsonDeserializer<?> build = beanDeserializerBuilder.build(beanProperty);
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return build;
        }
        Iterator<BeanDeserializerModifier> it3 = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            JsonDeserializer<?> jsonDeserializer = build;
            if (!it3.hasNext()) {
                return jsonDeserializer;
            }
            build = it3.next().modifyDeserializer(deserializationConfig, basicBeanDescription, jsonDeserializer);
        }
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) {
        BeanDeserializerBuilder beanDeserializerBuilder;
        SettableBeanProperty constructSettableProperty;
        BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(basicBeanDescription);
        constructBeanDeserializerBuilder.setCreators(findDeserializerCreators(deserializationConfig, basicBeanDescription));
        addBeanProps(deserializationConfig, basicBeanDescription, constructBeanDeserializerBuilder);
        AnnotatedMethod findMethod = basicBeanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (findMethod != null && (constructSettableProperty = constructSettableProperty(deserializationConfig, basicBeanDescription, "cause", findMethod)) != null) {
            constructBeanDeserializerBuilder.addProperty(constructSettableProperty);
        }
        constructBeanDeserializerBuilder.addIgnorable("localizedMessage");
        constructBeanDeserializerBuilder.addIgnorable(RMsgInfoDB.TABLE);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (true) {
                beanDeserializerBuilder = constructBeanDeserializerBuilder;
                if (!it2.hasNext()) {
                    break;
                }
                constructBeanDeserializerBuilder = it2.next().updateBuilder(deserializationConfig, basicBeanDescription, beanDeserializerBuilder);
            }
        } else {
            beanDeserializerBuilder = constructBeanDeserializerBuilder;
        }
        JsonDeserializer<?> build = beanDeserializerBuilder.build(beanProperty);
        if (build instanceof BeanDeserializer) {
            build = new ThrowableDeserializer((BeanDeserializer) build);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it3 = this._factoryConfig.deserializerModifiers().iterator();
            while (true) {
                JsonDeserializer<?> jsonDeserializer = build;
                if (!it3.hasNext()) {
                    return jsonDeserializer;
                }
                build = it3.next().modifyDeserializer(deserializationConfig, basicBeanDescription, jsonDeserializer);
            }
        } else {
            return build;
        }
    }

    protected SettableAnyProperty constructAnySetter(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, AnnotatedMethod annotatedMethod) {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMethod.fixAccess();
        }
        JavaType resolveType = basicBeanDescription.bindingsForBeanType().resolveType(annotatedMethod.getParameterType(1));
        BeanProperty.Std std = new BeanProperty.Std(annotatedMethod.getName(), resolveType, basicBeanDescription.getClassAnnotations(), annotatedMethod);
        JavaType resolveType2 = resolveType(deserializationConfig, basicBeanDescription, resolveType, annotatedMethod, std);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedMethod, std);
        if (findDeserializerFromAnnotation != null) {
            SettableAnyProperty settableAnyProperty = new SettableAnyProperty(std, annotatedMethod, resolveType2);
            settableAnyProperty.setValueDeserializer(findDeserializerFromAnnotation);
            return settableAnyProperty;
        }
        return new SettableAnyProperty(std, annotatedMethod, modifyTypeByAnnotation(deserializationConfig, annotatedMethod, resolveType2, std.getName()));
    }

    protected BeanDeserializerBuilder constructBeanDeserializerBuilder(BasicBeanDescription basicBeanDescription) {
        return new BeanDeserializerBuilder(basicBeanDescription);
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, AnnotatedField annotatedField) {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedField.fixAccess();
        }
        JavaType resolveType = basicBeanDescription.bindingsForBeanType().resolveType(annotatedField.getGenericType());
        BeanProperty.Std std = new BeanProperty.Std(str, resolveType, basicBeanDescription.getClassAnnotations(), annotatedField);
        JavaType resolveType2 = resolveType(deserializationConfig, basicBeanDescription, resolveType, annotatedField, std);
        if (resolveType2 != resolveType) {
            std = std.withType(resolveType2);
        }
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedField, std);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedField, resolveType2, str);
        SettableBeanProperty.FieldProperty fieldProperty = new SettableBeanProperty.FieldProperty(str, modifyTypeByAnnotation, (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler(), basicBeanDescription.getClassAnnotations(), annotatedField);
        if (findDeserializerFromAnnotation != null) {
            fieldProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        AnnotationIntrospector.ReferenceProperty findReferenceType = deserializationConfig.getAnnotationIntrospector().findReferenceType(annotatedField);
        if (findReferenceType != null && findReferenceType.isManagedReference()) {
            fieldProperty.setManagedReferenceName(findReferenceType.getName());
        }
        return fieldProperty;
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, AnnotatedMethod annotatedMethod) {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMethod.fixAccess();
        }
        JavaType resolveType = basicBeanDescription.bindingsForBeanType().resolveType(annotatedMethod.getParameterType(0));
        BeanProperty.Std std = new BeanProperty.Std(str, resolveType, basicBeanDescription.getClassAnnotations(), annotatedMethod);
        JavaType resolveType2 = resolveType(deserializationConfig, basicBeanDescription, resolveType, annotatedMethod, std);
        if (resolveType2 != resolveType) {
            std = std.withType(resolveType2);
        }
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedMethod, std);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedMethod, resolveType2, str);
        SettableBeanProperty.MethodProperty methodProperty = new SettableBeanProperty.MethodProperty(str, modifyTypeByAnnotation, (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler(), basicBeanDescription.getClassAnnotations(), annotatedMethod);
        if (findDeserializerFromAnnotation != null) {
            methodProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        AnnotationIntrospector.ReferenceProperty findReferenceType = deserializationConfig.getAnnotationIntrospector().findReferenceType(annotatedMethod);
        if (findReferenceType != null && findReferenceType.isManagedReference()) {
            methodProperty.setManagedReferenceName(findReferenceType.getName());
        }
        return methodProperty;
    }

    protected SettableBeanProperty constructSetterlessProperty(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, String str, AnnotatedMethod annotatedMethod) {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMethod.fixAccess();
        }
        JavaType type = annotatedMethod.getType(basicBeanDescription.bindingsForBeanType());
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, annotatedMethod, new BeanProperty.Std(str, type, basicBeanDescription.getClassAnnotations(), annotatedMethod));
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, annotatedMethod, type, str);
        SettableBeanProperty.SetterlessProperty setterlessProperty = new SettableBeanProperty.SetterlessProperty(str, modifyTypeByAnnotation, (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler(), basicBeanDescription.getClassAnnotations(), annotatedMethod);
        if (findDeserializerFromAnnotation != null) {
            setterlessProperty.setValueDeserializer(findDeserializerFromAnnotation);
        }
        return setterlessProperty;
    }

    @Override // org.codehaus.jackson.map.DeserializerFactory
    public JsonDeserializer<Object> createBeanDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty) {
        BasicBeanDescription basicBeanDescription;
        JavaType materializeAbstractType;
        if (javaType.isAbstract()) {
            javaType = mapAbstractType(deserializationConfig, javaType);
        }
        BasicBeanDescription basicBeanDescription2 = (BasicBeanDescription) deserializationConfig.introspect(javaType);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationConfig, basicBeanDescription2.getClassInfo(), beanProperty);
        if (findDeserializerFromAnnotation != null) {
            return findDeserializerFromAnnotation;
        }
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationConfig, basicBeanDescription2.getClassInfo(), javaType, null);
        if (modifyTypeByAnnotation.getRawClass() != javaType.getRawClass()) {
            basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspect(modifyTypeByAnnotation);
        } else {
            basicBeanDescription = basicBeanDescription2;
            modifyTypeByAnnotation = javaType;
        }
        JsonDeserializer<Object> _findCustomBeanDeserializer = _findCustomBeanDeserializer(modifyTypeByAnnotation, deserializationConfig, deserializerProvider, basicBeanDescription, beanProperty);
        if (_findCustomBeanDeserializer != null) {
            return _findCustomBeanDeserializer;
        }
        if (modifyTypeByAnnotation.isThrowable()) {
            return buildThrowableDeserializer(deserializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty);
        }
        if (modifyTypeByAnnotation.isAbstract() && (materializeAbstractType = materializeAbstractType(deserializationConfig, basicBeanDescription)) != null) {
            return buildBeanDeserializer(deserializationConfig, materializeAbstractType, (BasicBeanDescription) deserializationConfig.introspect(materializeAbstractType), beanProperty);
        }
        JsonDeserializer<Object> findStdBeanDeserializer = findStdBeanDeserializer(deserializationConfig, deserializerProvider, modifyTypeByAnnotation, beanProperty);
        if (findStdBeanDeserializer != null) {
            return findStdBeanDeserializer;
        }
        if (isPotentialBeanType(modifyTypeByAnnotation.getRawClass())) {
            return buildBeanDeserializer(deserializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty);
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.DeserializerFactory
    public KeyDeserializer createKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) {
        if (this._factoryConfig.hasKeyDeserializers()) {
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspectClassAnnotations(javaType.getRawClass());
            for (KeyDeserializers keyDeserializers : this._factoryConfig.keyDeserializers()) {
                KeyDeserializer findKeyDeserializer = keyDeserializers.findKeyDeserializer(javaType, deserializationConfig, basicBeanDescription, beanProperty);
                if (findKeyDeserializer != null) {
                    return findKeyDeserializer;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected CreatorContainer findDeserializerCreators(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription) {
        Constructor<?> findDefaultConstructor;
        boolean isEnabled = deserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
        CreatorContainer creatorContainer = new CreatorContainer(basicBeanDescription, isEnabled);
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        if (basicBeanDescription.getType().isConcrete() && (findDefaultConstructor = basicBeanDescription.findDefaultConstructor()) != null) {
            if (isEnabled) {
                ClassUtil.checkAndFixAccess(findDefaultConstructor);
            }
            creatorContainer.setDefaultConstructor(findDefaultConstructor);
        }
        VisibilityChecker<?> defaultVisibilityChecker = deserializationConfig.getDefaultVisibilityChecker();
        VisibilityChecker<?> visibilityChecker = defaultVisibilityChecker;
        if (!deserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_CREATORS)) {
            visibilityChecker = defaultVisibilityChecker.mo21979withCreatorVisibility(JsonAutoDetect.Visibility.NONE);
        }
        VisibilityChecker<?> findAutoDetectVisibility = deserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(basicBeanDescription.getClassInfo(), visibilityChecker);
        _addDeserializerConstructors(deserializationConfig, basicBeanDescription, findAutoDetectVisibility, annotationIntrospector, creatorContainer);
        _addDeserializerFactoryMethods(deserializationConfig, basicBeanDescription, findAutoDetectVisibility, annotationIntrospector, creatorContainer);
        return creatorContainer;
    }

    @Override // org.codehaus.jackson.map.DeserializerFactory
    public final DeserializerFactory.Config getConfig() {
        return this._factoryConfig;
    }

    protected boolean isIgnorableType(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean bool = map.get(cls);
        if (bool == null && (bool = deserializationConfig.getAnnotationIntrospector().isIgnorableType(((BasicBeanDescription) deserializationConfig.introspectClassAnnotations(cls)).getClassInfo())) == null) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        String canBeABeanType = ClassUtil.canBeABeanType(cls);
        if (canBeABeanType != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + canBeABeanType + ") as a Bean");
        }
        if (ClassUtil.isProxyType(cls)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        }
        String isLocalType = ClassUtil.isLocalType(cls);
        if (isLocalType == null) {
            return true;
        }
        throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + isLocalType + ") as a Bean");
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory
    protected JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) {
        JavaType _mapAbstractType2;
        while (true) {
            _mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (_mapAbstractType2 == null) {
                return javaType;
            }
            Class<?> rawClass = javaType.getRawClass();
            Class<?> rawClass2 = _mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
                break;
            }
            javaType = _mapAbstractType2;
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + _mapAbstractType2 + ": latter is not a subtype of former");
    }

    protected JavaType materializeAbstractType(DeserializationConfig deserializationConfig, BasicBeanDescription basicBeanDescription) {
        JavaType resolveAbstractType;
        AbstractTypeResolver abstractTypeResolver = deserializationConfig.getAbstractTypeResolver();
        if (abstractTypeResolver != null || this._factoryConfig.hasAbstractTypeResolvers()) {
            JavaType type = basicBeanDescription.getType();
            if (deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, basicBeanDescription.getClassInfo(), type) != null) {
                return null;
            }
            if (abstractTypeResolver != null && (resolveAbstractType = abstractTypeResolver.resolveAbstractType(deserializationConfig, type)) != null) {
                return resolveAbstractType;
            }
            for (AbstractTypeResolver abstractTypeResolver2 : this._factoryConfig.abstractTypeResolvers()) {
                JavaType resolveAbstractType2 = abstractTypeResolver2.resolveAbstractType(deserializationConfig, type);
                if (resolveAbstractType2 != null) {
                    return resolveAbstractType2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.deser.BasicDeserializerFactory, org.codehaus.jackson.map.DeserializerFactory
    public DeserializerFactory withConfig(DeserializerFactory.Config config) {
        if (this._factoryConfig == config) {
            return this;
        }
        if (getClass() == BeanDeserializerFactory.class) {
            return new BeanDeserializerFactory(config);
        }
        throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with additional deserializer definitions");
    }
}
