package org.codehaus.jackson.mrbean;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.VersionUtil;
/* loaded from: classes2.dex */
public class AbstractTypeMaterializer extends AbstractTypeResolver implements Versioned {
    protected static final int DEFAULT_FEATURE_FLAGS = Feature.collectDefaults();
    public static final String DEFAULT_PACKAGE_FOR_GENERATED = "org.codehaus.jackson.generated.";
    protected final MyClassLoader _classLoader;
    protected String _defaultPackage;
    protected int _featureFlags;

    /* loaded from: classes2.dex */
    public enum Feature {
        FAIL_ON_UNMATERIALIZED_METHOD(false);
        
        final boolean _defaultState;

        Feature(boolean z) {
            this._defaultState = z;
        }

        protected static int collectDefaults() {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class MyClassLoader extends ClassLoader {
        public MyClassLoader(ClassLoader classLoader) {
            super(classLoader);
        }

        public Class<?> loadAndResolve(String str, byte[] bArr, Class<?> cls) {
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null || !cls.isAssignableFrom(findLoadedClass)) {
                try {
                    findLoadedClass = defineClass(str, bArr, 0, bArr.length);
                    resolveClass(findLoadedClass);
                } catch (LinkageError e) {
                    throw new IllegalArgumentException("Failed to load class '" + str + "': " + e.getMessage(), e);
                }
            }
            return findLoadedClass;
        }
    }

    public AbstractTypeMaterializer() {
        this(null);
    }

    public AbstractTypeMaterializer(ClassLoader classLoader) {
        this._featureFlags = DEFAULT_FEATURE_FLAGS;
        this._defaultPackage = DEFAULT_PACKAGE_FOR_GENERATED;
        this._classLoader = new MyClassLoader(classLoader == null ? getClass().getClassLoader() : classLoader);
    }

    public void disable(Feature feature) {
        this._featureFlags &= feature.getMask() ^ (-1);
    }

    public void enable(Feature feature) {
        this._featureFlags |= feature.getMask();
    }

    public final boolean isEnabled(Feature feature) {
        return (this._featureFlags & feature.getMask()) != 0;
    }

    protected Class<?> materializeClass(DeserializationConfig deserializationConfig, Class<?> cls) {
        String str = this._defaultPackage + cls.getName();
        return this._classLoader.loadAndResolve(str, new BeanBuilder(deserializationConfig, cls).implement(isEnabled(Feature.FAIL_ON_UNMATERIALIZED_METHOD)).build(str), cls);
    }

    @Override // org.codehaus.jackson.map.AbstractTypeResolver
    public JavaType resolveAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) {
        if (javaType.isContainerType() || javaType.isPrimitive() || javaType.isEnumType() || javaType.isThrowable()) {
            return null;
        }
        return deserializationConfig.constructType(materializeClass(deserializationConfig, javaType.getRawClass()));
    }

    public void set(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
    }

    public void setDefaultPackage(String str) {
        if (!str.endsWith(".")) {
            str = str + ".";
        }
        this._defaultPackage = str;
    }

    @Override // org.codehaus.jackson.Versioned
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }
}
