package org.codehaus.jackson.p317xc;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.annotate.JsonCachable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.VersionUtil;
/* renamed from: org.codehaus.jackson.xc.JaxbAnnotationIntrospector */
/* loaded from: classes2.dex */
public class JaxbAnnotationIntrospector extends AnnotationIntrospector implements Versioned {
    protected static final String MARKER_FOR_DEFAULT = "##default";
    private static final ThreadLocal<SoftReference<PropertyDescriptors>> _propertyDescriptors = new ThreadLocal<>();
    protected final JsonDeserializer<?> _dataHandlerDeserializer;
    protected final JsonSerializer<?> _dataHandlerSerializer;
    protected final String _jaxbPackageName = XmlElement.class.getPackage().getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.codehaus.jackson.xc.JaxbAnnotationIntrospector$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C57201 {
        static final /* synthetic */ int[] $SwitchMap$javax$xml$bind$annotation$XmlAccessType = new int[XmlAccessType.values().length];

        static {
            try {
                $SwitchMap$javax$xml$bind$annotation$XmlAccessType[XmlAccessType.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$xml$bind$annotation$XmlAccessType[XmlAccessType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$xml$bind$annotation$XmlAccessType[XmlAccessType.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$xml$bind$annotation$XmlAccessType[XmlAccessType.PUBLIC_MEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.codehaus.jackson.xc.JaxbAnnotationIntrospector$AnnotatedProperty */
    /* loaded from: classes2.dex */
    public static class AnnotatedProperty implements AnnotatedElement {

        /* renamed from: pd */
        private final PropertyDescriptor f22962pd;

        private AnnotatedProperty(PropertyDescriptor propertyDescriptor) {
            this.f22962pd = propertyDescriptor;
        }

        /* synthetic */ AnnotatedProperty(PropertyDescriptor propertyDescriptor, C57201 c57201) {
            this(propertyDescriptor);
        }

        @Override // java.lang.reflect.AnnotatedElement
        public <T extends Annotation> T getAnnotation(Class<T> cls) {
            T t;
            Method readMethod = this.f22962pd.getReadMethod();
            if (readMethod == null || (t = (T) readMethod.getAnnotation(cls)) == null) {
                Method writeMethod = this.f22962pd.getWriteMethod();
                if (writeMethod == null) {
                    return null;
                }
                return (T) writeMethod.getAnnotation(cls);
            }
            return t;
        }

        @Override // java.lang.reflect.AnnotatedElement
        public Annotation[] getAnnotations() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.reflect.AnnotatedElement
        public Annotation[] getDeclaredAnnotations() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.reflect.AnnotatedElement
        public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
            Method readMethod = this.f22962pd.getReadMethod();
            if (readMethod == null || !readMethod.isAnnotationPresent(cls)) {
                Method writeMethod = this.f22962pd.getWriteMethod();
                return writeMethod != null && writeMethod.isAnnotationPresent(cls);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: org.codehaus.jackson.xc.JaxbAnnotationIntrospector$PropertyDescriptors */
    /* loaded from: classes2.dex */
    public static final class PropertyDescriptors {
        private Map<String, PropertyDescriptor> _byMethodName;
        private Map<String, PropertyDescriptor> _byPropertyName;
        private final Class<?> _forClass;
        private final List<PropertyDescriptor> _properties;

        public PropertyDescriptors(Class<?> cls, List<PropertyDescriptor> list) {
            this._forClass = cls;
            this._properties = list;
        }

        private static Map<String, PropertyDescriptor> _processReadMethod(Map<String, PropertyDescriptor> map, Method method, String str, List<PropertyDescriptor> list) {
            if (map == null) {
                map = new HashMap<>();
            } else {
                PropertyDescriptor propertyDescriptor = map.get(str);
                if (propertyDescriptor != null) {
                    propertyDescriptor.setReadMethod(method);
                    if (propertyDescriptor.getWriteMethod() != null) {
                        list.add(propertyDescriptor);
                        map.remove(str);
                        return map;
                    }
                }
            }
            map.put(str, new PropertyDescriptor(str, method, (Method) null));
            return map;
        }

        private static Map<String, PropertyDescriptor> _processWriteMethod(Map<String, PropertyDescriptor> map, Method method, String str, List<PropertyDescriptor> list) {
            if (map == null) {
                map = new HashMap<>();
            } else {
                PropertyDescriptor propertyDescriptor = map.get(str);
                if (propertyDescriptor != null) {
                    propertyDescriptor.setWriteMethod(method);
                    if (propertyDescriptor.getReadMethod() != null) {
                        list.add(propertyDescriptor);
                        map.remove(str);
                        return map;
                    }
                }
            }
            map.put(str, new PropertyDescriptor(str, (Method) null, method));
            return map;
        }

        public static PropertyDescriptors find(Class<?> cls) {
            List list;
            BeanInfo beanInfo = Introspector.getBeanInfo(cls);
            if (beanInfo.getPropertyDescriptors().length == 0) {
                list = Collections.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                Map<String, PropertyDescriptor> map = null;
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method method = (readMethod == null || readMethod.getAnnotation(XmlTransient.class) == null) ? readMethod : null;
                    String findJaxbPropertyName = method == null ? null : JaxbAnnotationIntrospector.findJaxbPropertyName(method, propertyDescriptor.getPropertyType(), null);
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    Method method2 = (writeMethod == null || writeMethod.getAnnotation(XmlTransient.class) == null) ? writeMethod : null;
                    if (method != null || method2 != null) {
                        String findJaxbPropertyName2 = method2 == null ? null : JaxbAnnotationIntrospector.findJaxbPropertyName(method2, propertyDescriptor.getPropertyType(), null);
                        if (method2 == null) {
                            if (findJaxbPropertyName == 0) {
                                findJaxbPropertyName = propertyDescriptor.getName();
                            }
                            map = _processReadMethod(map, method, findJaxbPropertyName, arrayList);
                        } else if (method == null) {
                            map = _processWriteMethod(map, method2, findJaxbPropertyName2 == null ? propertyDescriptor.getName() : findJaxbPropertyName2, arrayList);
                        } else if (findJaxbPropertyName == null || findJaxbPropertyName2 == null || findJaxbPropertyName.equals(findJaxbPropertyName2)) {
                            if (findJaxbPropertyName == null) {
                                findJaxbPropertyName = findJaxbPropertyName2 != null ? findJaxbPropertyName2 : propertyDescriptor.getName();
                            }
                            arrayList.add(new PropertyDescriptor(findJaxbPropertyName, method, method2));
                        } else {
                            map = _processWriteMethod(_processReadMethod(map, method, findJaxbPropertyName, arrayList), method2, findJaxbPropertyName2, arrayList);
                        }
                    }
                }
                list = arrayList;
            }
            return new PropertyDescriptors(cls, list);
        }

        public PropertyDescriptor findByMethodName(String str) {
            if (this._byMethodName == null) {
                this._byMethodName = new HashMap(this._properties.size());
                for (PropertyDescriptor propertyDescriptor : this._properties) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if (readMethod != null) {
                        this._byMethodName.put(readMethod.getName(), propertyDescriptor);
                    }
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (writeMethod != null) {
                        this._byMethodName.put(writeMethod.getName(), propertyDescriptor);
                    }
                }
            }
            return this._byMethodName.get(str);
        }

        public PropertyDescriptor findByPropertyName(String str) {
            if (this._byPropertyName == null) {
                this._byPropertyName = new HashMap(this._properties.size());
                for (PropertyDescriptor propertyDescriptor : this._properties) {
                    this._byPropertyName.put(propertyDescriptor.getName(), propertyDescriptor);
                }
            }
            return this._byPropertyName.get(str);
        }

        public Class<?> getBeanClass() {
            return this._forClass;
        }
    }

    public JaxbAnnotationIntrospector() {
        JsonSerializer<?> jsonSerializer;
        JsonDeserializer<?> jsonDeserializer;
        try {
            jsonSerializer = (JsonSerializer) Class.forName("org.codehaus.jackson.xc.DataHandlerJsonSerializer").newInstance();
        } catch (Throwable th) {
            jsonSerializer = null;
        }
        try {
            jsonDeserializer = (JsonDeserializer) Class.forName("org.codehaus.jackson.xc.DataHandlerJsonDeserializer").newInstance();
        } catch (Throwable th2) {
            jsonDeserializer = null;
            this._dataHandlerSerializer = jsonSerializer;
            this._dataHandlerDeserializer = jsonDeserializer;
        }
        this._dataHandlerSerializer = jsonSerializer;
        this._dataHandlerDeserializer = jsonDeserializer;
    }

    private final XmlAdapter<Object, Object> checkAdapter(XmlJavaTypeAdapter xmlJavaTypeAdapter, Class<?> cls) {
        Class type = xmlJavaTypeAdapter.type();
        if (type == XmlJavaTypeAdapter.DEFAULT.class || type.isAssignableFrom(cls)) {
            return (XmlAdapter) ClassUtil.createInstance(xmlJavaTypeAdapter.value(), false);
        }
        return null;
    }

    protected static String findJaxbPropertyName(AnnotatedElement annotatedElement, Class<?> cls, String str) {
        XmlRootElement annotation;
        XmlElementWrapper annotation2 = annotatedElement.getAnnotation(XmlElementWrapper.class);
        if (annotation2 != null) {
            String name = annotation2.name();
            return !MARKER_FOR_DEFAULT.equals(name) ? name : str;
        }
        XmlAttribute annotation3 = annotatedElement.getAnnotation(XmlAttribute.class);
        if (annotation3 != null) {
            String name2 = annotation3.name();
            return !MARKER_FOR_DEFAULT.equals(name2) ? name2 : str;
        }
        XmlElement annotation4 = annotatedElement.getAnnotation(XmlElement.class);
        if (annotation4 != null) {
            String name3 = annotation4.name();
            return !MARKER_FOR_DEFAULT.equals(name3) ? name3 : str;
        }
        XmlElementRef annotation5 = annotatedElement.getAnnotation(XmlElementRef.class);
        if (annotation5 != null) {
            String name4 = annotation5.name();
            if (!MARKER_FOR_DEFAULT.equals(name4)) {
                return name4;
            }
            if (cls != null && (annotation = cls.getAnnotation(XmlRootElement.class)) != null) {
                String name5 = annotation.name();
                return MARKER_FOR_DEFAULT.equals(name5) ? Introspector.decapitalize(cls.getSimpleName()) : name5;
            }
        }
        if (annotatedElement.getAnnotation(XmlValue.class) == null) {
            return null;
        }
        return "value";
    }

    private XmlRootElement findRootElementAnnotation(AnnotatedClass annotatedClass) {
        return findAnnotation(XmlRootElement.class, annotatedClass, true, false, true);
    }

    private boolean isDataHandler(Class<?> cls) {
        return (cls == null || Object.class == cls || (!"javax.activation.DataHandler".equals(cls.getName()) && !isDataHandler(cls.getSuperclass()))) ? false : true;
    }

    protected Class<?> _doFindDeserializationType(Annotated annotated, JavaType javaType, String str) {
        XmlElement findFieldAnnotation;
        Class<?> type;
        if (annotated.hasAnnotation(XmlJavaTypeAdapter.class)) {
            return null;
        }
        XmlElement findAnnotation = findAnnotation(XmlElement.class, annotated, false, false, false);
        if (findAnnotation != null && (type = findAnnotation.type()) != XmlElement.DEFAULT.class) {
            return type;
        }
        if ((annotated instanceof AnnotatedMethod) && str != null && (findFieldAnnotation = findFieldAnnotation(XmlElement.class, ((AnnotatedMethod) annotated).getDeclaringClass(), str)) != null && findFieldAnnotation.type() != XmlElement.DEFAULT.class) {
            return findFieldAnnotation.type();
        }
        return null;
    }

    protected TypeResolverBuilder<?> _typeResolverFromXmlElements(AnnotatedMember annotatedMember) {
        XmlElements findAnnotation = findAnnotation(XmlElements.class, annotatedMember, false, false, false);
        XmlElementRefs findAnnotation2 = findAnnotation(XmlElementRefs.class, annotatedMember, false, false, false);
        if (findAnnotation == null && findAnnotation2 == null) {
            return null;
        }
        return new StdTypeResolverBuilder().init(JsonTypeInfo.EnumC5696Id.NAME, (TypeIdResolver) null).inclusion(JsonTypeInfo.EnumC5695As.WRAPPER_OBJECT);
    }

    protected XmlAccessType findAccessType(Annotated annotated) {
        XmlAccessorType findAnnotation = findAnnotation(XmlAccessorType.class, annotated, true, true, true);
        if (findAnnotation == null) {
            return null;
        }
        return findAnnotation.value();
    }

    protected XmlAdapter<Object, Object> findAdapter(Annotated annotated, boolean z) {
        XmlAdapter<Object, Object> checkAdapter;
        Class<?> declaringClass;
        XmlJavaTypeAdapter xmlJavaTypeAdapter;
        XmlAdapter<Object, Object> checkAdapter2;
        if (annotated instanceof AnnotatedClass) {
            return findAdapterForClass((AnnotatedClass) annotated, z);
        }
        Class<?> rawType = annotated.getRawType();
        Class<?> parameterClass = (rawType != Void.TYPE || !(annotated instanceof AnnotatedMethod)) ? rawType : ((AnnotatedMethod) annotated).getParameterClass(0);
        Member member = (Member) annotated.mo21976getAnnotated();
        if (member != null && (declaringClass = member.getDeclaringClass()) != null && (xmlJavaTypeAdapter = (XmlJavaTypeAdapter) declaringClass.getAnnotation(XmlJavaTypeAdapter.class)) != null && (checkAdapter2 = checkAdapter(xmlJavaTypeAdapter, parameterClass)) != null) {
            return checkAdapter2;
        }
        XmlJavaTypeAdapter xmlJavaTypeAdapter2 = (XmlJavaTypeAdapter) findAnnotation(XmlJavaTypeAdapter.class, annotated, true, false, false);
        if (xmlJavaTypeAdapter2 != null && (checkAdapter = checkAdapter(xmlJavaTypeAdapter2, parameterClass)) != null) {
            return checkAdapter;
        }
        XmlJavaTypeAdapters findAnnotation = findAnnotation(XmlJavaTypeAdapters.class, annotated, true, false, false);
        if (findAnnotation != null) {
            for (XmlJavaTypeAdapter xmlJavaTypeAdapter3 : findAnnotation.value()) {
                XmlAdapter<Object, Object> checkAdapter3 = checkAdapter(xmlJavaTypeAdapter3, parameterClass);
                if (checkAdapter3 != null) {
                    return checkAdapter3;
                }
            }
        }
        return null;
    }

    protected XmlAdapter<Object, Object> findAdapterForClass(AnnotatedClass annotatedClass, boolean z) {
        XmlJavaTypeAdapter annotation = annotatedClass.mo21976getAnnotated().getAnnotation(XmlJavaTypeAdapter.class);
        if (annotation != null) {
            return (XmlAdapter) ClassUtil.createInstance(annotation.value(), false);
        }
        return null;
    }

    protected <A extends Annotation> A findAnnotation(Class<A> cls, Annotated annotated, boolean z, boolean z2, boolean z3) {
        Class<?> cls2;
        A a;
        PropertyDescriptor findPropertyDescriptor;
        A a2;
        if (!(annotated instanceof AnnotatedMethod) || (findPropertyDescriptor = findPropertyDescriptor((AnnotatedMethod) annotated)) == null || (a2 = (A) new AnnotatedProperty(findPropertyDescriptor, null).getAnnotation(cls)) == null) {
            AnnotatedElement mo21976getAnnotated = annotated.mo21976getAnnotated();
            if (annotated instanceof AnnotatedParameter) {
                AnnotatedParameter annotatedParameter = (AnnotatedParameter) annotated;
                A a3 = (A) annotatedParameter.getAnnotation(cls);
                if (a3 != null) {
                    return a3;
                }
                cls2 = annotatedParameter.getMember().getDeclaringClass();
            } else {
                A a4 = (A) mo21976getAnnotated.getAnnotation(cls);
                if (a4 != null) {
                    return a4;
                }
                if (mo21976getAnnotated instanceof Member) {
                    Class<?> declaringClass = ((Member) mo21976getAnnotated).getDeclaringClass();
                    if (z2 && (a = (A) declaringClass.getAnnotation(cls)) != null) {
                        return a;
                    }
                    cls2 = declaringClass;
                } else if (!(mo21976getAnnotated instanceof Class)) {
                    throw new IllegalStateException("Unsupported annotated member: " + annotated.getClass().getName());
                } else {
                    cls2 = (Class) mo21976getAnnotated;
                }
            }
            if (cls2 != null) {
                if (z3) {
                    for (Class<? super Object> superclass = cls2.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                        A a5 = (A) superclass.getAnnotation(cls);
                        if (a5 != null) {
                            return a5;
                        }
                    }
                }
                if (z) {
                    return (A) cls2.getPackage().getAnnotation(cls);
                }
            }
            return null;
        }
        return a2;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [org.codehaus.jackson.map.introspect.VisibilityChecker] */
    /* JADX WARN: Type inference failed for: r0v16, types: [org.codehaus.jackson.map.introspect.VisibilityChecker] */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.codehaus.jackson.map.introspect.VisibilityChecker] */
    /* JADX WARN: Type inference failed for: r0v8, types: [org.codehaus.jackson.map.introspect.VisibilityChecker] */
    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        XmlAccessType findAccessType = findAccessType(annotatedClass);
        if (findAccessType == null) {
            return visibilityChecker;
        }
        switch (C57201.$SwitchMap$javax$xml$bind$annotation$XmlAccessType[findAccessType.ordinal()]) {
            case 1:
                return visibilityChecker.mo21980withFieldVisibility(JsonAutoDetect.Visibility.ANY).mo21983withSetterVisibility(JsonAutoDetect.Visibility.NONE).mo21981withGetterVisibility(JsonAutoDetect.Visibility.NONE).mo21982withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
            case 2:
                return visibilityChecker.mo21980withFieldVisibility(JsonAutoDetect.Visibility.NONE).mo21983withSetterVisibility(JsonAutoDetect.Visibility.NONE).mo21981withGetterVisibility(JsonAutoDetect.Visibility.NONE).mo21982withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
            case 3:
                return visibilityChecker.mo21980withFieldVisibility(JsonAutoDetect.Visibility.NONE).mo21983withSetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).mo21981withGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).mo21982withIsGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY);
            case 4:
                return visibilityChecker.mo21980withFieldVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).mo21983withSetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).mo21981withGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).mo21982withIsGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY);
            default:
                return visibilityChecker;
        }
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Boolean findCachability(AnnotatedClass annotatedClass) {
        JsonCachable jsonCachable = (JsonCachable) annotatedClass.getAnnotation(JsonCachable.class);
        if (jsonCachable != null) {
            return jsonCachable.value() ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<JsonDeserializer<?>> findContentDeserializer(Annotated annotated) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findDeserializablePropertyName(AnnotatedField annotatedField) {
        if (isInvisible(annotatedField)) {
            return null;
        }
        Field mo21976getAnnotated = annotatedField.mo21976getAnnotated();
        String findJaxbPropertyName = findJaxbPropertyName(mo21976getAnnotated, mo21976getAnnotated.getType(), "");
        return findJaxbPropertyName == null ? mo21976getAnnotated.getName() : findJaxbPropertyName;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType, String str) {
        return _doFindDeserializationType(annotated, javaType, str);
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType, String str) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<?> findDeserializationType(Annotated annotated, JavaType javaType, String str) {
        if (!javaType.isContainerType()) {
            return _doFindDeserializationType(annotated, javaType, str);
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    /* renamed from: findDeserializer  reason: collision with other method in class */
    public JsonDeserializer<?> mo22016findDeserializer(Annotated annotated, BeanProperty beanProperty) {
        XmlAdapter<Object, Object> findAdapter = findAdapter(annotated, false);
        if (findAdapter != null) {
            return new XmlAdapterJsonDeserializer(findAdapter, beanProperty);
        }
        Class<?> rawType = annotated.getRawType();
        if (rawType != null && this._dataHandlerDeserializer != null && isDataHandler(rawType)) {
            return this._dataHandlerDeserializer;
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findEnumValue(Enum<?> r7) {
        Class<?> declaringClass = r7.getDeclaringClass();
        String name = r7.name();
        try {
            XmlEnumValue annotation = declaringClass.getDeclaredField(name).getAnnotation(XmlEnumValue.class);
            return annotation != null ? annotation.value() : name;
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException("Could not locate Enum entry '" + name + "' (Enum class " + declaringClass.getName() + ")", e);
        }
    }

    protected <A extends Annotation> A findFieldAnnotation(Class<A> cls, Class<?> cls2, String str) {
        Field[] declaredFields;
        do {
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return (A) field.getAnnotation(cls);
                }
            }
            if (cls2.isInterface() || cls2 == Object.class) {
                break;
            }
            cls2 = cls2.getSuperclass();
        } while (cls2 != null);
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findGettablePropertyName(AnnotatedMethod annotatedMethod) {
        PropertyDescriptor findPropertyDescriptor = findPropertyDescriptor(annotatedMethod);
        if (findPropertyDescriptor != null) {
            return findJaxbSpecifiedPropertyName(findPropertyDescriptor);
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass) {
        return null;
    }

    protected String findJaxbSpecifiedPropertyName(PropertyDescriptor propertyDescriptor) {
        return findJaxbPropertyName(new AnnotatedProperty(propertyDescriptor, null), propertyDescriptor.getPropertyType(), propertyDescriptor.getName());
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<KeyDeserializer> findKeyDeserializer(Annotated annotated) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String[] findPropertiesToIgnore(AnnotatedClass annotatedClass) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (!javaType.isContainerType()) {
            throw new IllegalArgumentException("Must call method with a container type (got " + javaType + ")");
        }
        return _typeResolverFromXmlElements(annotatedMember);
    }

    protected PropertyDescriptor findPropertyDescriptor(AnnotatedMethod annotatedMethod) {
        return getDescriptors(annotatedMethod.getDeclaringClass()).findByMethodName(annotatedMethod.getName());
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findPropertyNameForParam(AnnotatedParameter annotatedParameter) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType()) {
            return null;
        }
        return _typeResolverFromXmlElements(annotatedMember);
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findRootName(AnnotatedClass annotatedClass) {
        XmlRootElement findRootElementAnnotation = findRootElementAnnotation(annotatedClass);
        if (findRootElementAnnotation != null) {
            String name = findRootElementAnnotation.name();
            return MARKER_FOR_DEFAULT.equals(name) ? "" : name;
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findSerializablePropertyName(AnnotatedField annotatedField) {
        if (isInvisible(annotatedField)) {
            return null;
        }
        Field mo21976getAnnotated = annotatedField.mo21976getAnnotated();
        String findJaxbPropertyName = findJaxbPropertyName(mo21976getAnnotated, mo21976getAnnotated.getType(), "");
        return findJaxbPropertyName == null ? mo21976getAnnotated.getName() : findJaxbPropertyName;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, JsonSerialize.Inclusion inclusion) {
        XmlElementWrapper annotation = annotated.getAnnotation(XmlElementWrapper.class);
        if (annotation != null) {
            return annotation.nillable() ? JsonSerialize.Inclusion.ALWAYS : JsonSerialize.Inclusion.NON_NULL;
        }
        XmlElement annotation2 = annotated.getAnnotation(XmlElement.class);
        return annotation2 != null ? annotation2.nillable() ? JsonSerialize.Inclusion.ALWAYS : JsonSerialize.Inclusion.NON_NULL : inclusion;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass) {
        XmlType findAnnotation = findAnnotation(XmlType.class, annotatedClass, true, true, true);
        if (findAnnotation == null) {
            return null;
        }
        String[] propOrder = findAnnotation.propOrder();
        if (propOrder == null || propOrder.length == 0) {
            return null;
        }
        PropertyDescriptors descriptors = getDescriptors(annotatedClass.getRawType());
        int length = propOrder.length;
        for (int i = 0; i < length; i++) {
            String str = propOrder[i];
            if (descriptors.findByPropertyName(str) == null && str.length() != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("get");
                sb.append(Character.toUpperCase(str.charAt(0)));
                if (str.length() > 1) {
                    sb.append(str.substring(1));
                }
                PropertyDescriptor findByMethodName = descriptors.findByMethodName(sb.toString());
                if (findByMethodName != null) {
                    propOrder[i] = findByMethodName.getName();
                }
            }
        }
        return propOrder;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedClass) {
        boolean z = true;
        XmlAccessorOrder findAnnotation = findAnnotation(XmlAccessorOrder.class, annotatedClass, true, true, true);
        if (findAnnotation == null) {
            return null;
        }
        if (findAnnotation.value() != XmlAccessOrder.ALPHABETICAL) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<?> findSerializationType(Annotated annotated) {
        XmlElement findAnnotation = findAnnotation(XmlElement.class, annotated, false, false, false);
        if (findAnnotation == null || findAnnotation.type() == XmlElement.DEFAULT.class) {
            return null;
        }
        if (!isIndexedType(annotated.getRawType())) {
            return findAnnotation.type();
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public JsonSerialize.Typing findSerializationTyping(Annotated annotated) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Class<?>[] findSerializationViews(Annotated annotated) {
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    /* renamed from: findSerializer  reason: collision with other method in class */
    public JsonSerializer<?> mo22017findSerializer(Annotated annotated, BeanProperty beanProperty) {
        XmlAdapter<Object, Object> findAdapter = findAdapter(annotated, true);
        if (findAdapter != null) {
            return new XmlAdapterJsonSerializer(findAdapter, beanProperty);
        }
        Class<?> rawType = annotated.getRawType();
        if (rawType != null && this._dataHandlerSerializer != null && isDataHandler(rawType)) {
            return this._dataHandlerSerializer;
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findSettablePropertyName(AnnotatedMethod annotatedMethod) {
        PropertyDescriptor findPropertyDescriptor = findPropertyDescriptor(annotatedMethod);
        if (findPropertyDescriptor != null) {
            return findJaxbSpecifiedPropertyName(findPropertyDescriptor);
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public List<NamedType> findSubtypes(Annotated annotated) {
        XmlRootElement annotation;
        int i = 0;
        XmlElements findAnnotation = findAnnotation(XmlElements.class, annotated, false, false, false);
        if (findAnnotation != null) {
            ArrayList arrayList = new ArrayList();
            XmlElement[] value = findAnnotation.value();
            int length = value.length;
            while (i < length) {
                XmlElement xmlElement = value[i];
                String name = xmlElement.name();
                if (MARKER_FOR_DEFAULT.equals(name)) {
                    name = null;
                }
                arrayList.add(new NamedType(xmlElement.type(), name));
                i++;
            }
            return arrayList;
        }
        XmlElementRefs findAnnotation2 = findAnnotation(XmlElementRefs.class, annotated, false, false, false);
        if (findAnnotation2 == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        XmlElementRef[] value2 = findAnnotation2.value();
        int length2 = value2.length;
        while (i < length2) {
            XmlElementRef xmlElementRef = value2[i];
            Class type = xmlElementRef.type();
            if (!JAXBElement.class.isAssignableFrom(type)) {
                String name2 = xmlElementRef.name();
                String name3 = ((name2 == null || MARKER_FOR_DEFAULT.equals(name2)) && (annotation = type.getAnnotation(XmlRootElement.class)) != null) ? annotation.name() : name2;
                if (name3 == null || MARKER_FOR_DEFAULT.equals(name3)) {
                    name3 = Introspector.decapitalize(type.getSimpleName());
                }
                arrayList2.add(new NamedType(type, name3));
            }
            i++;
        }
        return arrayList2;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public String findTypeName(AnnotatedClass annotatedClass) {
        XmlType findAnnotation = findAnnotation(XmlType.class, annotatedClass, false, false, false);
        if (findAnnotation != null) {
            String name = findAnnotation.name();
            if (!MARKER_FOR_DEFAULT.equals(name)) {
                return name;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    protected PropertyDescriptors getDescriptors(Class<?> cls) {
        SoftReference<PropertyDescriptors> softReference = _propertyDescriptors.get();
        PropertyDescriptors propertyDescriptors = softReference == null ? null : softReference.get();
        if (propertyDescriptors == null || propertyDescriptors.getBeanClass() != cls) {
            try {
                propertyDescriptors = PropertyDescriptors.find(cls);
                _propertyDescriptors.set(new SoftReference<>(propertyDescriptors));
            } catch (IntrospectionException e) {
                throw new IllegalArgumentException("Problem introspecting bean properties: " + e.getMessage(), e);
            }
        }
        return propertyDescriptors;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean hasCreatorAnnotation(Annotated annotated) {
        return false;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean isHandled(Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Package r0 = annotationType.getPackage();
        return (r0 != null ? r0.getName() : annotationType.getName()).startsWith(this._jaxbPackageName) || annotationType == JsonCachable.class;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean isIgnorableConstructor(AnnotatedConstructor annotatedConstructor) {
        return false;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean isIgnorableField(AnnotatedField annotatedField) {
        return annotatedField.getAnnotation(XmlTransient.class) != null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public boolean isIgnorableMethod(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.getAnnotation(XmlTransient.class) != null;
    }

    @Override // org.codehaus.jackson.map.AnnotationIntrospector
    public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
        return null;
    }

    protected boolean isIndexedType(Class<?> cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    protected boolean isInvisible(AnnotatedField annotatedField) {
        boolean z = true;
        for (Annotation annotation : annotatedField.mo21976getAnnotated().getDeclaredAnnotations()) {
            if (isHandled(annotation)) {
                z = false;
            }
        }
        if (z) {
            XmlAccessType xmlAccessType = XmlAccessType.PUBLIC_MEMBER;
            XmlAccessorType findAnnotation = findAnnotation(XmlAccessorType.class, annotatedField, true, true, true);
            XmlAccessType value = findAnnotation != null ? findAnnotation.value() : xmlAccessType;
            return value != XmlAccessType.FIELD && (value != XmlAccessType.PUBLIC_MEMBER || !Modifier.isPublic(annotatedField.mo21976getAnnotated().getModifiers()));
        }
        return z;
    }

    @Override // org.codehaus.jackson.Versioned
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }
}
