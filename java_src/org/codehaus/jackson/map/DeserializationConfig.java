package org.codehaus.jackson.map;

import java.text.DateFormat;
import java.util.HashMap;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.LinkedNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes.dex */
public class DeserializationConfig extends MapperConfig<DeserializationConfig> {
    protected static final int DEFAULT_FEATURE_FLAGS = Feature.collectDefaults();
    protected AbstractTypeResolver _abstractTypeResolver;
    protected int _featureFlags;
    protected JsonNodeFactory _nodeFactory;
    protected LinkedNode<DeserializationProblemHandler> _problemHandlers;

    /* loaded from: classes.dex */
    public enum Feature {
        USE_ANNOTATIONS(true),
        AUTO_DETECT_SETTERS(true),
        AUTO_DETECT_CREATORS(true),
        AUTO_DETECT_FIELDS(true),
        USE_GETTERS_AS_SETTERS(true),
        CAN_OVERRIDE_ACCESS_MODIFIERS(true),
        USE_BIG_DECIMAL_FOR_FLOATS(false),
        USE_BIG_INTEGER_FOR_INTS(false),
        READ_ENUMS_USING_TO_STRING(false),
        FAIL_ON_UNKNOWN_PROPERTIES(true),
        FAIL_ON_NULL_FOR_PRIMITIVES(false),
        FAIL_ON_NUMBERS_FOR_ENUMS(false),
        WRAP_EXCEPTIONS(true),
        WRAP_ROOT_VALUE(false),
        ACCEPT_EMPTY_STRING_AS_NULL_OBJECT(false),
        ACCEPT_SINGLE_VALUE_AS_ARRAY(false);
        
        final boolean _defaultState;

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            Feature[] values;
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public DeserializationConfig(ClassIntrospector<? extends BeanDescription> classIntrospector, AnnotationIntrospector annotationIntrospector, VisibilityChecker<?> visibilityChecker, SubtypeResolver subtypeResolver, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, HandlerInstantiator handlerInstantiator) {
        super(classIntrospector, annotationIntrospector, visibilityChecker, subtypeResolver, propertyNamingStrategy, typeFactory, handlerInstantiator);
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._nodeFactory = JsonNodeFactory.instance;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig) {
        this(deserializationConfig, deserializationConfig._base);
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, HashMap<ClassKey, Class<?>> hashMap, SubtypeResolver subtypeResolver) {
        this(deserializationConfig, deserializationConfig._base);
        this._mixInAnnotations = hashMap;
        this._subtypeResolver = subtypeResolver;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, MapperConfig.Base base) {
        super(deserializationConfig, base, deserializationConfig._subtypeResolver);
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._featureFlags = deserializationConfig._featureFlags;
        this._abstractTypeResolver = deserializationConfig._abstractTypeResolver;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, JsonNodeFactory jsonNodeFactory) {
        super(deserializationConfig);
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._featureFlags = deserializationConfig._featureFlags;
        this._abstractTypeResolver = deserializationConfig._abstractTypeResolver;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = jsonNodeFactory;
    }

    public void addHandler(DeserializationProblemHandler deserializationProblemHandler) {
        if (!LinkedNode.contains(this._problemHandlers, deserializationProblemHandler)) {
            this._problemHandlers = new LinkedNode<>(deserializationProblemHandler, this._problemHandlers);
        }
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    public boolean canOverrideAccessModifiers() {
        return isEnabled(Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public void clearHandlers() {
        this._problemHandlers = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: createUnshared */
    public DeserializationConfig mo21901createUnshared(SubtypeResolver subtypeResolver) {
        HashMap<ClassKey, Class<?>> hashMap = this._mixInAnnotations;
        this._mixInAnnotationsShared = true;
        return new DeserializationConfig(this, hashMap, subtypeResolver);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    @Deprecated
    /* renamed from: createUnshared */
    public DeserializationConfig mo21902createUnshared(TypeResolverBuilder<?> typeResolverBuilder, VisibilityChecker<?> visibilityChecker, SubtypeResolver subtypeResolver) {
        return mo21901createUnshared(subtypeResolver).mo21910withTypeResolverBuilder(typeResolverBuilder).mo21911withVisibilityChecker(visibilityChecker);
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: createUnshared  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ DeserializationConfig mo21902createUnshared(TypeResolverBuilder typeResolverBuilder, VisibilityChecker visibilityChecker, SubtypeResolver subtypeResolver) {
        return mo21902createUnshared((TypeResolverBuilder<?>) typeResolverBuilder, (VisibilityChecker<?>) visibilityChecker, subtypeResolver);
    }

    public JsonDeserializer<Object> deserializerInstance(Annotated annotated, Class<? extends JsonDeserializer<?>> cls) {
        JsonDeserializer<?> deserializerInstance;
        HandlerInstantiator handlerInstantiator = getHandlerInstantiator();
        return (handlerInstantiator == null || (deserializerInstance = handlerInstantiator.deserializerInstance(this, annotated, cls)) == null) ? (JsonDeserializer) ClassUtil.createInstance(cls, canOverrideAccessModifiers()) : deserializerInstance;
    }

    public void disable(Feature feature) {
        this._featureFlags &= feature.getMask() ^ (-1);
    }

    public void enable(Feature feature) {
        this._featureFlags |= feature.getMask();
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    public void fromAnnotations(Class<?> cls) {
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        this._base = this._base.withVisibilityChecker(annotationIntrospector.findAutoDetectVisibility(AnnotatedClass.construct(cls, annotationIntrospector, null), getDefaultVisibilityChecker()));
    }

    @Deprecated
    public AbstractTypeResolver getAbstractTypeResolver() {
        return this._abstractTypeResolver;
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    public AnnotationIntrospector getAnnotationIntrospector() {
        return isEnabled(Feature.USE_ANNOTATIONS) ? super.getAnnotationIntrospector() : NopAnnotationIntrospector.instance;
    }

    public Base64Variant getBase64Variant() {
        return Base64Variants.getDefaultVariant();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._nodeFactory;
    }

    public LinkedNode<DeserializationProblemHandler> getProblemHandlers() {
        return this._problemHandlers;
    }

    public <T extends BeanDescription> T introspect(JavaType javaType) {
        return (T) getClassIntrospector().forDeserialization(this, javaType, this);
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    public <T extends BeanDescription> T introspectClassAnnotations(Class<?> cls) {
        return (T) getClassIntrospector().forClassAnnotations(this, cls, this);
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    public <T extends BeanDescription> T introspectDirectClassAnnotations(Class<?> cls) {
        return (T) getClassIntrospector().forDirectClassAnnotations(this, cls, this);
    }

    public <T extends BeanDescription> T introspectForCreation(JavaType javaType) {
        return (T) getClassIntrospector().forCreation(this, javaType, this);
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    public boolean isAnnotationProcessingEnabled() {
        return isEnabled(Feature.USE_ANNOTATIONS);
    }

    public final boolean isEnabled(Feature feature) {
        return (this._featureFlags & feature.getMask()) != 0;
    }

    public KeyDeserializer keyDeserializerInstance(Annotated annotated, Class<? extends KeyDeserializer> cls) {
        KeyDeserializer keyDeserializerInstance;
        HandlerInstantiator handlerInstantiator = getHandlerInstantiator();
        return (handlerInstantiator == null || (keyDeserializerInstance = handlerInstantiator.keyDeserializerInstance(this, annotated, cls)) == null) ? (KeyDeserializer) ClassUtil.createInstance(cls, canOverrideAccessModifiers()) : keyDeserializerInstance;
    }

    public void set(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
    }

    @Deprecated
    public void setAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        this._abstractTypeResolver = abstractTypeResolver;
    }

    @Deprecated
    public void setNodeFactory(JsonNodeFactory jsonNodeFactory) {
        this._nodeFactory = jsonNodeFactory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withAnnotationIntrospector */
    public DeserializationConfig mo21903withAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return new DeserializationConfig(this, this._base.withAnnotationIntrospector(annotationIntrospector));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withClassIntrospector */
    public DeserializationConfig mo21904withClassIntrospector(ClassIntrospector<? extends BeanDescription> classIntrospector) {
        return new DeserializationConfig(this, this._base.withClassIntrospector(classIntrospector));
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withClassIntrospector  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ DeserializationConfig mo21904withClassIntrospector(ClassIntrospector classIntrospector) {
        return mo21904withClassIntrospector((ClassIntrospector<? extends BeanDescription>) classIntrospector);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withDateFormat */
    public DeserializationConfig mo21905withDateFormat(DateFormat dateFormat) {
        return dateFormat == this._base.getDateFormat() ? this : new DeserializationConfig(this, this._base.withDateFormat(dateFormat));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withHandlerInstantiator */
    public DeserializationConfig mo21906withHandlerInstantiator(HandlerInstantiator handlerInstantiator) {
        return handlerInstantiator == this._base.getHandlerInstantiator() ? this : new DeserializationConfig(this, this._base.withHandlerInstantiator(handlerInstantiator));
    }

    public DeserializationConfig withNodeFactory(JsonNodeFactory jsonNodeFactory) {
        return new DeserializationConfig(this, jsonNodeFactory);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withPropertyNamingStrategy */
    public DeserializationConfig mo21907withPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        return new DeserializationConfig(this, this._base.withPropertyNamingStrategy(propertyNamingStrategy));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withSubtypeResolver */
    public DeserializationConfig mo21908withSubtypeResolver(SubtypeResolver subtypeResolver) {
        DeserializationConfig deserializationConfig = new DeserializationConfig(this);
        deserializationConfig._subtypeResolver = subtypeResolver;
        return deserializationConfig;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withTypeFactory */
    public DeserializationConfig mo21909withTypeFactory(TypeFactory typeFactory) {
        return typeFactory == this._base.getTypeFactory() ? this : new DeserializationConfig(this, this._base.withTypeFactory(typeFactory));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withTypeResolverBuilder */
    public DeserializationConfig mo21910withTypeResolverBuilder(TypeResolverBuilder<?> typeResolverBuilder) {
        return new DeserializationConfig(this, this._base.withTypeResolverBuilder(typeResolverBuilder));
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withTypeResolverBuilder  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ DeserializationConfig mo21910withTypeResolverBuilder(TypeResolverBuilder typeResolverBuilder) {
        return mo21910withTypeResolverBuilder((TypeResolverBuilder<?>) typeResolverBuilder);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withVisibilityChecker */
    public DeserializationConfig mo21911withVisibilityChecker(VisibilityChecker<?> visibilityChecker) {
        return new DeserializationConfig(this, this._base.withVisibilityChecker(visibilityChecker));
    }

    @Override // org.codehaus.jackson.map.MapperConfig
    /* renamed from: withVisibilityChecker  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ DeserializationConfig mo21911withVisibilityChecker(VisibilityChecker visibilityChecker) {
        return mo21911withVisibilityChecker((VisibilityChecker<?>) visibilityChecker);
    }
}
