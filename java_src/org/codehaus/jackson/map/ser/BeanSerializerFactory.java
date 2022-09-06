package org.codehaus.jackson.map.ser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes.dex */
public class BeanSerializerFactory extends BasicSerializerFactory {
    public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
    protected final SerializerFactory.Config _factoryConfig;

    /* loaded from: classes2.dex */
    public static class ConfigImpl extends SerializerFactory.Config {
        protected final Serializers[] _additionalKeySerializers;
        protected final Serializers[] _additionalSerializers;
        protected final BeanSerializerModifier[] _modifiers;
        protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
        protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];

        public ConfigImpl() {
            this(null, null, null);
        }

        protected ConfigImpl(Serializers[] serializersArr, Serializers[] serializersArr2, BeanSerializerModifier[] beanSerializerModifierArr) {
            this._additionalSerializers = serializersArr == null ? NO_SERIALIZERS : serializersArr;
            this._additionalKeySerializers = serializersArr2 == null ? NO_SERIALIZERS : serializersArr2;
            this._modifiers = beanSerializerModifierArr == null ? NO_MODIFIERS : beanSerializerModifierArr;
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public boolean hasKeySerializers() {
            return this._additionalKeySerializers.length > 0;
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public boolean hasSerializerModifiers() {
            return this._modifiers.length > 0;
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public boolean hasSerializers() {
            return this._additionalSerializers.length > 0;
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public Iterable<Serializers> keySerializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalKeySerializers);
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public Iterable<BeanSerializerModifier> serializerModifiers() {
            return ArrayBuilders.arrayAsIterable(this._modifiers);
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public Iterable<Serializers> serializers() {
            return ArrayBuilders.arrayAsIterable(this._additionalSerializers);
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public SerializerFactory.Config withAdditionalKeySerializers(Serializers serializers) {
            if (serializers == null) {
                throw new IllegalArgumentException("Can not pass null Serializers");
            }
            return new ConfigImpl(this._additionalSerializers, (Serializers[]) ArrayBuilders.insertInListNoDup(this._additionalKeySerializers, serializers), this._modifiers);
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public SerializerFactory.Config withAdditionalSerializers(Serializers serializers) {
            if (serializers == null) {
                throw new IllegalArgumentException("Can not pass null Serializers");
            }
            return new ConfigImpl((Serializers[]) ArrayBuilders.insertInListNoDup(this._additionalSerializers, serializers), this._additionalKeySerializers, this._modifiers);
        }

        @Override // org.codehaus.jackson.map.SerializerFactory.Config
        public SerializerFactory.Config withSerializerModifier(BeanSerializerModifier beanSerializerModifier) {
            if (beanSerializerModifier == null) {
                throw new IllegalArgumentException("Can not pass null modifier");
            }
            return new ConfigImpl(this._additionalSerializers, this._additionalKeySerializers, (BeanSerializerModifier[]) ArrayBuilders.insertInListNoDup(this._modifiers, beanSerializerModifier));
        }
    }

    @Deprecated
    protected BeanSerializerFactory() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BeanSerializerFactory(SerializerFactory.Config config) {
        this._factoryConfig = config == null ? new ConfigImpl() : config;
    }

    protected BeanPropertyWriter _constructWriter(SerializationConfig serializationConfig, TypeBindings typeBindings, PropertyBuilder propertyBuilder, boolean z, String str, AnnotatedMember annotatedMember) {
        if (serializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            annotatedMember.fixAccess();
        }
        JavaType type = annotatedMember.getType(typeBindings);
        BeanProperty.Std std = new BeanProperty.Std(str, type, propertyBuilder.getClassAnnotations(), annotatedMember);
        JsonSerializer<Object> findSerializerFromAnnotation = findSerializerFromAnnotation(serializationConfig, annotatedMember, std);
        TypeSerializer typeSerializer = null;
        if (ClassUtil.isCollectionMapOrArray(type.getRawClass())) {
            typeSerializer = findPropertyContentTypeSerializer(type, serializationConfig, annotatedMember, std);
        }
        BeanPropertyWriter buildWriter = propertyBuilder.buildWriter(str, type, findSerializerFromAnnotation, findPropertyTypeSerializer(type, serializationConfig, annotatedMember, std), typeSerializer, annotatedMember, z);
        buildWriter.setViews(serializationConfig.getAnnotationIntrospector().findSerializationViews(annotatedMember));
        return buildWriter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.TreeMap] */
    protected List<BeanPropertyWriter> _sortBeanProperties(List<BeanPropertyWriter> list, List<String> list2, String[] strArr, boolean z) {
        int size = list.size();
        LinkedHashMap treeMap = z ? new TreeMap() : new LinkedHashMap(size * 2);
        for (BeanPropertyWriter beanPropertyWriter : list) {
            treeMap.put(beanPropertyWriter.getName(), beanPropertyWriter);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(size * 2);
        if (strArr != null) {
            for (String str : strArr) {
                BeanPropertyWriter beanPropertyWriter2 = (BeanPropertyWriter) treeMap.get(str);
                if (beanPropertyWriter2 != null) {
                    linkedHashMap.put(str, beanPropertyWriter2);
                }
            }
        }
        for (String str2 : list2) {
            BeanPropertyWriter beanPropertyWriter3 = (BeanPropertyWriter) treeMap.get(str2);
            if (beanPropertyWriter3 != null) {
                linkedHashMap.put(str2, beanPropertyWriter3);
            }
        }
        linkedHashMap.putAll(treeMap);
        return new ArrayList(linkedHashMap.values());
    }

    protected JsonSerializer<Object> constructBeanSerializer(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) {
        List<BeanPropertyWriter> list;
        List<BeanPropertyWriter> emptyList;
        List<BeanPropertyWriter> list2;
        BeanSerializerBuilder beanSerializerBuilder;
        if (basicBeanDescription.getBeanClass() == Object.class) {
            throw new IllegalArgumentException("Can not create bean serializer for Object.class");
        }
        BeanSerializerBuilder constructBeanSerializerBuilder = constructBeanSerializerBuilder(basicBeanDescription);
        List<BeanPropertyWriter> findBeanProperties = findBeanProperties(serializationConfig, basicBeanDescription);
        AnnotatedMethod findAnyGetter = basicBeanDescription.findAnyGetter();
        if (this._factoryConfig.hasSerializerModifiers()) {
            if (findBeanProperties == null) {
                findBeanProperties = new ArrayList<>();
            }
            Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
            while (true) {
                list = findBeanProperties;
                if (!it2.hasNext()) {
                    break;
                }
                findBeanProperties = it2.next().changeProperties(serializationConfig, basicBeanDescription, list);
            }
        } else {
            list = findBeanProperties;
        }
        if (list != null && list.size() != 0) {
            emptyList = sortBeanProperties(serializationConfig, basicBeanDescription, filterBeanProperties(serializationConfig, basicBeanDescription, list));
        } else if (findAnyGetter == null) {
            if (!basicBeanDescription.hasKnownClassAnnotations()) {
                return null;
            }
            return constructBeanSerializerBuilder.createDummy();
        } else {
            emptyList = Collections.emptyList();
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<BeanSerializerModifier> it3 = this._factoryConfig.serializerModifiers().iterator();
            while (true) {
                list2 = emptyList;
                if (!it3.hasNext()) {
                    break;
                }
                emptyList = it3.next().orderProperties(serializationConfig, basicBeanDescription, list2);
            }
        } else {
            list2 = emptyList;
        }
        constructBeanSerializerBuilder.setProperties(list2);
        constructBeanSerializerBuilder.setFilterId(findFilterId(serializationConfig, basicBeanDescription));
        if (findAnyGetter != null) {
            JavaType type = findAnyGetter.getType(basicBeanDescription.bindingsForBeanType());
            constructBeanSerializerBuilder.setAnyGetter(new AnyGetterWriter(findAnyGetter, MapSerializer.construct(null, type, serializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING), createTypeSerializer(serializationConfig, type.getContentType(), beanProperty), beanProperty, null, null)));
        }
        processViews(serializationConfig, constructBeanSerializerBuilder);
        if (this._factoryConfig.hasSerializerModifiers()) {
            beanSerializerBuilder = constructBeanSerializerBuilder;
            for (BeanSerializerModifier beanSerializerModifier : this._factoryConfig.serializerModifiers()) {
                beanSerializerBuilder = beanSerializerModifier.updateBuilder(serializationConfig, basicBeanDescription, beanSerializerBuilder);
            }
        } else {
            beanSerializerBuilder = constructBeanSerializerBuilder;
        }
        return beanSerializerBuilder.build();
    }

    protected BeanSerializerBuilder constructBeanSerializerBuilder(BasicBeanDescription basicBeanDescription) {
        return new BeanSerializerBuilder(basicBeanDescription);
    }

    protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        return FilteredBeanPropertyWriter.constructViewBased(beanPropertyWriter, clsArr);
    }

    protected PropertyBuilder constructPropertyBuilder(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        return new PropertyBuilder(serializationConfig, basicBeanDescription);
    }

    @Override // org.codehaus.jackson.map.SerializerFactory
    public JsonSerializer<Object> createKeySerializer(SerializationConfig serializationConfig, JavaType javaType, BeanProperty beanProperty) {
        JsonSerializer<?> jsonSerializer = null;
        if (this._factoryConfig.hasKeySerializers()) {
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) serializationConfig.introspectClassAnnotations(javaType.getRawClass());
            Iterator<Serializers> it2 = this._factoryConfig.keySerializers().iterator();
            while (it2.hasNext() && (jsonSerializer = it2.next().findSerializer(serializationConfig, javaType, basicBeanDescription, beanProperty)) == null) {
            }
        }
        return jsonSerializer;
    }

    @Override // org.codehaus.jackson.map.ser.BasicSerializerFactory, org.codehaus.jackson.map.SerializerFactory
    public JsonSerializer<Object> createSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanProperty beanProperty) {
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) serializationConfig.introspect(javaType);
        JsonSerializer<Object> findSerializerFromAnnotation = findSerializerFromAnnotation(serializationConfig, basicBeanDescription.getClassInfo(), beanProperty);
        if (findSerializerFromAnnotation != null) {
            return findSerializerFromAnnotation;
        }
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(serializationConfig, basicBeanDescription.getClassInfo(), javaType);
        boolean z = modifyTypeByAnnotation != javaType;
        if (javaType.isContainerType()) {
            return buildContainerSerializer(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty, z);
        }
        for (Serializers serializers : this._factoryConfig.serializers()) {
            JsonSerializer<?> findSerializer = serializers.findSerializer(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty);
            if (findSerializer != null) {
                return findSerializer;
            }
        }
        JsonSerializer<?> findSerializerByLookup = findSerializerByLookup(modifyTypeByAnnotation, serializationConfig, basicBeanDescription, beanProperty, z);
        if (findSerializerByLookup != null) {
            return findSerializerByLookup;
        }
        JsonSerializer<?> findSerializerByPrimaryType = findSerializerByPrimaryType(modifyTypeByAnnotation, serializationConfig, basicBeanDescription, beanProperty, z);
        if (findSerializerByPrimaryType != null) {
            return findSerializerByPrimaryType;
        }
        JsonSerializer<Object> findBeanSerializer = findBeanSerializer(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty);
        return findBeanSerializer == null ? super.findSerializerByAddonType(serializationConfig, modifyTypeByAnnotation, basicBeanDescription, beanProperty, z) : findBeanSerializer;
    }

    @Override // org.codehaus.jackson.map.ser.BasicSerializerFactory
    protected Iterable<Serializers> customSerializers() {
        return this._factoryConfig.serializers();
    }

    protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, List<BeanPropertyWriter> list) {
        String[] findPropertiesToIgnore = serializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(basicBeanDescription.getClassInfo());
        if (findPropertiesToIgnore != null && findPropertiesToIgnore.length > 0) {
            HashSet arrayToSet = ArrayBuilders.arrayToSet(findPropertiesToIgnore);
            Iterator<BeanPropertyWriter> it2 = list.iterator();
            while (it2.hasNext()) {
                if (arrayToSet.contains(it2.next().getName())) {
                    it2.remove();
                }
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected List<BeanPropertyWriter> findBeanProperties(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        VisibilityChecker<?> defaultVisibilityChecker = serializationConfig.getDefaultVisibilityChecker();
        VisibilityChecker<?> visibilityChecker = defaultVisibilityChecker;
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_GETTERS)) {
            visibilityChecker = defaultVisibilityChecker.mo21981withGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        VisibilityChecker<?> visibilityChecker2 = visibilityChecker;
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS)) {
            visibilityChecker2 = visibilityChecker.mo21982withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        VisibilityChecker<?> visibilityChecker3 = visibilityChecker2;
        if (!serializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_FIELDS)) {
            visibilityChecker3 = visibilityChecker2.mo21980withFieldVisibility(JsonAutoDetect.Visibility.NONE);
        }
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        VisibilityChecker<?> findAutoDetectVisibility = annotationIntrospector.findAutoDetectVisibility(basicBeanDescription.getClassInfo(), visibilityChecker3);
        LinkedHashMap<String, AnnotatedMethod> findGetters = basicBeanDescription.findGetters(findAutoDetectVisibility, null);
        LinkedHashMap<String, AnnotatedField> findSerializableFields = basicBeanDescription.findSerializableFields(findAutoDetectVisibility, findGetters.keySet());
        removeIgnorableTypes(serializationConfig, basicBeanDescription, findGetters);
        removeIgnorableTypes(serializationConfig, basicBeanDescription, findSerializableFields);
        if (!findGetters.isEmpty() || !findSerializableFields.isEmpty()) {
            boolean usesStaticTyping = usesStaticTyping(serializationConfig, basicBeanDescription, null, null);
            PropertyBuilder constructPropertyBuilder = constructPropertyBuilder(serializationConfig, basicBeanDescription);
            ArrayList arrayList = new ArrayList(findGetters.size());
            TypeBindings bindingsForBeanType = basicBeanDescription.bindingsForBeanType();
            for (Map.Entry<String, AnnotatedField> entry : findSerializableFields.entrySet()) {
                AnnotationIntrospector.ReferenceProperty findReferenceType = annotationIntrospector.findReferenceType(entry.getValue());
                if (findReferenceType == null || !findReferenceType.isBackReference()) {
                    arrayList.add(_constructWriter(serializationConfig, bindingsForBeanType, constructPropertyBuilder, usesStaticTyping, entry.getKey(), entry.getValue()));
                }
            }
            for (Map.Entry<String, AnnotatedMethod> entry2 : findGetters.entrySet()) {
                AnnotationIntrospector.ReferenceProperty findReferenceType2 = annotationIntrospector.findReferenceType(entry2.getValue());
                if (findReferenceType2 == null || !findReferenceType2.isBackReference()) {
                    arrayList.add(_constructWriter(serializationConfig, bindingsForBeanType, constructPropertyBuilder, usesStaticTyping, entry2.getKey(), entry2.getValue()));
                }
            }
            return arrayList;
        }
        return null;
    }

    public JsonSerializer<Object> findBeanSerializer(SerializationConfig serializationConfig, JavaType javaType, BasicBeanDescription basicBeanDescription, BeanProperty beanProperty) {
        if (!isPotentialBeanType(javaType.getRawClass())) {
            return null;
        }
        JsonSerializer<?> constructBeanSerializer = constructBeanSerializer(serializationConfig, basicBeanDescription, beanProperty);
        if (!this._factoryConfig.hasSerializerModifiers()) {
            return constructBeanSerializer;
        }
        Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
        while (true) {
            JsonSerializer<?> jsonSerializer = constructBeanSerializer;
            if (!it2.hasNext()) {
                return jsonSerializer;
            }
            constructBeanSerializer = it2.next().modifySerializer(serializationConfig, basicBeanDescription, jsonSerializer);
        }
    }

    protected Object findFilterId(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        return serializationConfig.getAnnotationIntrospector().findFilterId(basicBeanDescription.getClassInfo());
    }

    public TypeSerializer findPropertyContentTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember, BeanProperty beanProperty) {
        JavaType contentType = javaType.getContentType();
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findPropertyContentTypeResolver = annotationIntrospector.findPropertyContentTypeResolver(serializationConfig, annotatedMember, javaType);
        return findPropertyContentTypeResolver == null ? createTypeSerializer(serializationConfig, contentType, beanProperty) : findPropertyContentTypeResolver.buildTypeSerializer(serializationConfig, contentType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, serializationConfig, annotationIntrospector), beanProperty);
    }

    public TypeSerializer findPropertyTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember, BeanProperty beanProperty) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> findPropertyTypeResolver = annotationIntrospector.findPropertyTypeResolver(serializationConfig, annotatedMember, javaType);
        return findPropertyTypeResolver == null ? createTypeSerializer(serializationConfig, javaType, beanProperty) : findPropertyTypeResolver.buildTypeSerializer(serializationConfig, javaType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, serializationConfig, annotationIntrospector), beanProperty);
    }

    @Override // org.codehaus.jackson.map.SerializerFactory
    public SerializerFactory.Config getConfig() {
        return this._factoryConfig;
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        return ClassUtil.canBeABeanType(cls) == null && !ClassUtil.isProxyType(cls);
    }

    protected void processViews(SerializationConfig serializationConfig, BeanSerializerBuilder beanSerializerBuilder) {
        List<BeanPropertyWriter> properties = beanSerializerBuilder.getProperties();
        boolean isEnabled = serializationConfig.isEnabled(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION);
        int size = properties.size();
        BeanPropertyWriter[] beanPropertyWriterArr = new BeanPropertyWriter[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            BeanPropertyWriter beanPropertyWriter = properties.get(i);
            Class<?>[] views = beanPropertyWriter.getViews();
            if (views != null) {
                i2++;
                beanPropertyWriterArr[i] = constructFilteredBeanWriter(beanPropertyWriter, views);
            } else if (isEnabled) {
                beanPropertyWriterArr[i] = beanPropertyWriter;
            }
            i++;
            i2 = i2;
        }
        if (!isEnabled || i2 != 0) {
            beanSerializerBuilder.setFilteredProperties(beanPropertyWriterArr);
        }
    }

    protected <T extends AnnotatedMember> void removeIgnorableTypes(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, Map<String, T> map) {
        if (map.isEmpty()) {
            return;
        }
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        Iterator<Map.Entry<String, T>> it2 = map.entrySet().iterator();
        HashMap hashMap = new HashMap();
        while (it2.hasNext()) {
            Class<?> rawType = it2.next().getValue().getRawType();
            Boolean bool = (Boolean) hashMap.get(rawType);
            if (bool == null) {
                bool = annotationIntrospector.isIgnorableType(((BasicBeanDescription) serializationConfig.introspectClassAnnotations(rawType)).getClassInfo());
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                hashMap.put(rawType, bool);
            }
            if (bool.booleanValue()) {
                it2.remove();
            }
        }
    }

    protected List<BeanPropertyWriter> sortBeanProperties(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription, List<BeanPropertyWriter> list) {
        List<String> findCreatorPropertyNames = basicBeanDescription.findCreatorPropertyNames();
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        AnnotatedClass classInfo = basicBeanDescription.getClassInfo();
        String[] findSerializationPropertyOrder = annotationIntrospector.findSerializationPropertyOrder(classInfo);
        Boolean findSerializationSortAlphabetically = annotationIntrospector.findSerializationSortAlphabetically(classInfo);
        boolean isEnabled = findSerializationSortAlphabetically == null ? serializationConfig.isEnabled(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY) : findSerializationSortAlphabetically.booleanValue();
        return (isEnabled || !findCreatorPropertyNames.isEmpty() || findSerializationPropertyOrder != null) ? _sortBeanProperties(list, findCreatorPropertyNames, findSerializationPropertyOrder, isEnabled) : list;
    }

    @Override // org.codehaus.jackson.map.SerializerFactory
    public SerializerFactory withConfig(SerializerFactory.Config config) {
        if (this._factoryConfig == config) {
            return this;
        }
        if (getClass() == BeanSerializerFactory.class) {
            return new BeanSerializerFactory(config);
        }
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with additional serializer definitions");
    }
}
