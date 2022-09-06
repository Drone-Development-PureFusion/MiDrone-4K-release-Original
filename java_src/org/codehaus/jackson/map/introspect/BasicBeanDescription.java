package org.codehaus.jackson.map.introspect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class BasicBeanDescription extends BeanDescription {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected TypeBindings _bindings;
    protected final AnnotatedClass _classInfo;
    protected final MapperConfig<?> _config;

    public BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        super(javaType);
        this._config = mapperConfig;
        this._annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        this._classInfo = annotatedClass;
    }

    public static String descFor(AnnotatedElement annotatedElement) {
        if (annotatedElement instanceof Class) {
            return "class " + ((Class) annotatedElement).getName();
        }
        if (!(annotatedElement instanceof Method)) {
            return annotatedElement instanceof Constructor ? "constructor() (from class " + ((Constructor) annotatedElement).getDeclaringClass().getName() + ")" : "unknown type [" + annotatedElement.getClass() + "]";
        }
        Method method = (Method) annotatedElement;
        return "method " + method.getName() + " (from class " + method.getDeclaringClass().getName() + ")";
    }

    public static String manglePropertyName(String str) {
        StringBuilder sb = null;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            char lowerCase = Character.toLowerCase(charAt);
            if (charAt == lowerCase) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder(str);
            }
            sb.setCharAt(i, lowerCase);
        }
        return sb != null ? sb.toString() : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0015 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedHashMap<String, AnnotatedField> _findPropertyFields(VisibilityChecker<?> visibilityChecker, Collection<String> collection, boolean z) {
        String nameForField;
        AnnotatedField put;
        LinkedHashMap<String, AnnotatedField> linkedHashMap = new LinkedHashMap<>();
        PropertyNamingStrategy propertyNamingStrategy = this._config.getPropertyNamingStrategy();
        for (AnnotatedField annotatedField : this._classInfo.fields()) {
            String findSerializablePropertyName = z ? this._annotationIntrospector.findSerializablePropertyName(annotatedField) : this._annotationIntrospector.findDeserializablePropertyName(annotatedField);
            if (findSerializablePropertyName != null) {
                if (findSerializablePropertyName.length() == 0) {
                    findSerializablePropertyName = annotatedField.getName();
                    if (propertyNamingStrategy != null) {
                        nameForField = propertyNamingStrategy.nameForField(this._config, annotatedField, findSerializablePropertyName);
                        if (collection != null || !collection.contains(nameForField)) {
                            put = linkedHashMap.put(nameForField, annotatedField);
                            if (put != null && put.getDeclaringClass() == annotatedField.getDeclaringClass()) {
                                throw new IllegalArgumentException("Multiple fields representing property \"" + nameForField + "\": " + put.getFullName() + " vs " + annotatedField.getFullName());
                            }
                        }
                    }
                }
                nameForField = findSerializablePropertyName;
                if (collection != null) {
                }
                put = linkedHashMap.put(nameForField, annotatedField);
                if (put != null) {
                    throw new IllegalArgumentException("Multiple fields representing property \"" + nameForField + "\": " + put.getFullName() + " vs " + annotatedField.getFullName());
                }
                continue;
            } else if (visibilityChecker.isFieldVisible(annotatedField)) {
                findSerializablePropertyName = annotatedField.getName();
                if (propertyNamingStrategy != null) {
                    nameForField = propertyNamingStrategy.nameForField(this._config, annotatedField, findSerializablePropertyName);
                    if (collection != null) {
                    }
                    put = linkedHashMap.put(nameForField, annotatedField);
                    if (put != null) {
                    }
                }
                nameForField = findSerializablePropertyName;
                if (collection != null) {
                }
                put = linkedHashMap.put(nameForField, annotatedField);
                if (put != null) {
                }
            } else {
                continue;
            }
        }
        return linkedHashMap;
    }

    @Override // org.codehaus.jackson.map.BeanDescription
    public TypeBindings bindingsForBeanType() {
        if (this._bindings == null) {
            this._bindings = new TypeBindings(this._config.getTypeFactory(), this._type);
        }
        return this._bindings;
    }

    public AnnotatedMethod findAnyGetter() {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedMethod annotatedMethod2 : this._classInfo.memberMethods()) {
            if (this._annotationIntrospector.hasAnyGetterAnnotation(annotatedMethod2)) {
                if (annotatedMethod != null) {
                    throw new IllegalArgumentException("Multiple methods with 'any-getter' annotation (" + annotatedMethod.getName() + "(), " + annotatedMethod2.getName() + ")");
                }
                if (!Map.class.isAssignableFrom(annotatedMethod2.getRawType())) {
                    throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + annotatedMethod2.getName() + "(): return type is not instance of java.util.Map");
                }
                annotatedMethod = annotatedMethod2;
            }
        }
        return annotatedMethod;
    }

    public AnnotatedMethod findAnySetter() {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedMethod annotatedMethod2 : this._classInfo.memberMethods()) {
            if (this._annotationIntrospector.hasAnySetterAnnotation(annotatedMethod2)) {
                if (annotatedMethod != null) {
                    throw new IllegalArgumentException("Multiple methods with 'any-setter' annotation (" + annotatedMethod.getName() + "(), " + annotatedMethod2.getName() + ")");
                }
                int parameterCount = annotatedMethod2.getParameterCount();
                if (parameterCount != 2) {
                    throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + annotatedMethod2.getName() + "(): takes " + parameterCount + " parameters, should take 2");
                }
                Class<?> parameterClass = annotatedMethod2.getParameterClass(0);
                if (parameterClass != String.class && parameterClass != Object.class) {
                    throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + annotatedMethod2.getName() + "(): first argument not of type String or Object, but " + parameterClass.getName());
                }
                annotatedMethod = annotatedMethod2;
            }
        }
        return annotatedMethod;
    }

    public Map<String, AnnotatedMember> findBackReferenceProperties() {
        AnnotationIntrospector.ReferenceProperty findReferenceType;
        HashMap hashMap = null;
        for (AnnotatedMethod annotatedMethod : this._classInfo.memberMethods()) {
            if (annotatedMethod.getParameterCount() == 1 && (findReferenceType = this._annotationIntrospector.findReferenceType(annotatedMethod)) != null && findReferenceType.isBackReference()) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (hashMap.put(findReferenceType.getName(), annotatedMethod) != null) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name '" + findReferenceType.getName() + "'");
                }
            }
        }
        for (AnnotatedField annotatedField : this._classInfo.fields()) {
            AnnotationIntrospector.ReferenceProperty findReferenceType2 = this._annotationIntrospector.findReferenceType(annotatedField);
            if (findReferenceType2 != null && findReferenceType2.isBackReference()) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (hashMap.put(findReferenceType2.getName(), annotatedField) != null) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name '" + findReferenceType2.getName() + "'");
                }
            }
        }
        return hashMap;
    }

    public List<String> findCreatorPropertyNames() {
        String findPropertyNameForParam;
        ArrayList arrayList = null;
        int i = 0;
        while (i < 2) {
            for (AnnotatedWithParams annotatedWithParams : i == 0 ? getConstructors() : getFactoryMethods()) {
                int parameterCount = annotatedWithParams.getParameterCount();
                if (parameterCount >= 1 && (findPropertyNameForParam = this._annotationIntrospector.findPropertyNameForParam(annotatedWithParams.getParameter(0))) != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(findPropertyNameForParam);
                    for (int i2 = 1; i2 < parameterCount; i2++) {
                        arrayList.add(this._annotationIntrospector.findPropertyNameForParam(annotatedWithParams.getParameter(i2)));
                    }
                }
            }
            i++;
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public Constructor<?> findDefaultConstructor() {
        AnnotatedConstructor defaultConstructor = this._classInfo.getDefaultConstructor();
        if (defaultConstructor == null) {
            return null;
        }
        return defaultConstructor.mo21976getAnnotated();
    }

    public LinkedHashMap<String, AnnotatedField> findDeserializableFields(VisibilityChecker<?> visibilityChecker, Collection<String> collection) {
        return _findPropertyFields(visibilityChecker, collection, false);
    }

    public Method findFactoryMethod(Class<?>... clsArr) {
        for (AnnotatedMethod annotatedMethod : this._classInfo.getStaticMethods()) {
            if (isFactoryMethod(annotatedMethod)) {
                Class<?> parameterClass = annotatedMethod.getParameterClass(0);
                for (Class<?> cls : clsArr) {
                    if (parameterClass.isAssignableFrom(cls)) {
                        return annotatedMethod.mo21976getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0054 A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // org.codehaus.jackson.map.BeanDescription
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedHashMap<String, AnnotatedMethod> findGetters(VisibilityChecker<?> visibilityChecker, Collection<String> collection) {
        String nameForGetterMethod;
        AnnotatedMethod put;
        LinkedHashMap<String, AnnotatedMethod> linkedHashMap = new LinkedHashMap<>();
        PropertyNamingStrategy propertyNamingStrategy = this._config.getPropertyNamingStrategy();
        for (AnnotatedMethod annotatedMethod : this._classInfo.memberMethods()) {
            if (annotatedMethod.getParameterCount() == 0) {
                String findGettablePropertyName = this._annotationIntrospector.findGettablePropertyName(annotatedMethod);
                if (findGettablePropertyName != null) {
                    if (findGettablePropertyName.length() == 0) {
                        findGettablePropertyName = okNameForAnyGetter(annotatedMethod, annotatedMethod.getName());
                        if (findGettablePropertyName == null) {
                            findGettablePropertyName = annotatedMethod.getName();
                        }
                        if (propertyNamingStrategy != null) {
                            nameForGetterMethod = propertyNamingStrategy.nameForGetterMethod(this._config, annotatedMethod, findGettablePropertyName);
                            if (collection == null || !collection.contains(nameForGetterMethod)) {
                                put = linkedHashMap.put(nameForGetterMethod, annotatedMethod);
                                if (put != null) {
                                    String fullName = put.getFullName();
                                    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + nameForGetterMethod + "\": " + fullName + " vs " + annotatedMethod.getFullName());
                                }
                            }
                        }
                    }
                    nameForGetterMethod = findGettablePropertyName;
                    if (collection == null) {
                    }
                    put = linkedHashMap.put(nameForGetterMethod, annotatedMethod);
                    if (put != null) {
                    }
                } else {
                    String name = annotatedMethod.getName();
                    if (name.startsWith("get")) {
                        if (visibilityChecker.isGetterVisible(annotatedMethod)) {
                            findGettablePropertyName = okNameForGetter(annotatedMethod, name);
                            if (findGettablePropertyName == null && !this._annotationIntrospector.hasAnyGetterAnnotation(annotatedMethod)) {
                                if (propertyNamingStrategy != null) {
                                    nameForGetterMethod = propertyNamingStrategy.nameForGetterMethod(this._config, annotatedMethod, findGettablePropertyName);
                                    if (collection == null) {
                                    }
                                    put = linkedHashMap.put(nameForGetterMethod, annotatedMethod);
                                    if (put != null) {
                                    }
                                }
                                nameForGetterMethod = findGettablePropertyName;
                                if (collection == null) {
                                }
                                put = linkedHashMap.put(nameForGetterMethod, annotatedMethod);
                                if (put != null) {
                                }
                            }
                        } else {
                            continue;
                        }
                    } else if (visibilityChecker.isIsGetterVisible(annotatedMethod)) {
                        findGettablePropertyName = okNameForIsGetter(annotatedMethod, name);
                        if (findGettablePropertyName == null) {
                            continue;
                        } else {
                            if (propertyNamingStrategy != null) {
                            }
                            nameForGetterMethod = findGettablePropertyName;
                            if (collection == null) {
                            }
                            put = linkedHashMap.put(nameForGetterMethod, annotatedMethod);
                            if (put != null) {
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public AnnotatedMethod findJsonValueMethod() {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedMethod annotatedMethod2 : this._classInfo.memberMethods()) {
            if (this._annotationIntrospector.hasAsValueAnnotation(annotatedMethod2)) {
                if (annotatedMethod != null) {
                    throw new IllegalArgumentException("Multiple methods with active 'as-value' annotation (" + annotatedMethod.getName() + "(), " + annotatedMethod2.getName() + ")");
                }
                if (!ClassUtil.hasGetterSignature(annotatedMethod2.mo21976getAnnotated())) {
                    throw new IllegalArgumentException("Method " + annotatedMethod2.getName() + "() marked with an 'as-value' annotation, but does not have valid getter signature (non-static, takes no args, returns a value)");
                }
                annotatedMethod = annotatedMethod2;
            }
        }
        return annotatedMethod;
    }

    public AnnotatedMethod findMethod(String str, Class<?>[] clsArr) {
        return this._classInfo.findMethod(str, clsArr);
    }

    public LinkedHashMap<String, AnnotatedField> findSerializableFields(VisibilityChecker<?> visibilityChecker, Collection<String> collection) {
        return _findPropertyFields(visibilityChecker, collection, true);
    }

    public JsonSerialize.Inclusion findSerializationInclusion(JsonSerialize.Inclusion inclusion) {
        return this._annotationIntrospector.findSerializationInclusion(this._classInfo, inclusion);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0015 A[SYNTHETIC] */
    @Override // org.codehaus.jackson.map.BeanDescription
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedHashMap<String, AnnotatedMethod> findSetters(VisibilityChecker<?> visibilityChecker) {
        String nameForSetterMethod;
        AnnotatedMethod put;
        LinkedHashMap<String, AnnotatedMethod> linkedHashMap = new LinkedHashMap<>();
        PropertyNamingStrategy propertyNamingStrategy = this._config.getPropertyNamingStrategy();
        for (AnnotatedMethod annotatedMethod : this._classInfo.memberMethods()) {
            if (annotatedMethod.getParameterCount() == 1) {
                String findSettablePropertyName = this._annotationIntrospector.findSettablePropertyName(annotatedMethod);
                if (findSettablePropertyName != null) {
                    if (findSettablePropertyName.length() == 0) {
                        findSettablePropertyName = okNameForSetter(annotatedMethod);
                        if (findSettablePropertyName == null) {
                            findSettablePropertyName = annotatedMethod.getName();
                        }
                        if (propertyNamingStrategy != null) {
                            nameForSetterMethod = propertyNamingStrategy.nameForSetterMethod(this._config, annotatedMethod, findSettablePropertyName);
                            put = linkedHashMap.put(nameForSetterMethod, annotatedMethod);
                            if (put == null) {
                                continue;
                            } else if (put.getDeclaringClass() == annotatedMethod.getDeclaringClass()) {
                                throw new IllegalArgumentException("Conflicting setter definitions for property \"" + nameForSetterMethod + "\": " + put.getFullName() + " vs " + annotatedMethod.getFullName());
                            } else {
                                linkedHashMap.put(nameForSetterMethod, put);
                            }
                        }
                    }
                    nameForSetterMethod = findSettablePropertyName;
                    put = linkedHashMap.put(nameForSetterMethod, annotatedMethod);
                    if (put == null) {
                    }
                } else if (visibilityChecker.isSetterVisible(annotatedMethod) && (findSettablePropertyName = okNameForSetter(annotatedMethod)) != null) {
                    if (propertyNamingStrategy != null) {
                        nameForSetterMethod = propertyNamingStrategy.nameForSetterMethod(this._config, annotatedMethod, findSettablePropertyName);
                        put = linkedHashMap.put(nameForSetterMethod, annotatedMethod);
                        if (put == null) {
                        }
                    }
                    nameForSetterMethod = findSettablePropertyName;
                    put = linkedHashMap.put(nameForSetterMethod, annotatedMethod);
                    if (put == null) {
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public Constructor<?> findSingleArgConstructor(Class<?>... clsArr) {
        for (AnnotatedConstructor annotatedConstructor : this._classInfo.getConstructors()) {
            if (annotatedConstructor.getParameterCount() == 1) {
                Class<?> parameterClass = annotatedConstructor.getParameterClass(0);
                for (Class<?> cls : clsArr) {
                    if (cls == parameterClass) {
                        return annotatedConstructor.mo21976getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.map.BeanDescription
    public Annotations getClassAnnotations() {
        return this._classInfo.getAnnotations();
    }

    public AnnotatedClass getClassInfo() {
        return this._classInfo;
    }

    public List<AnnotatedConstructor> getConstructors() {
        return this._classInfo.getConstructors();
    }

    public List<AnnotatedMethod> getFactoryMethods() {
        List<AnnotatedMethod> staticMethods = this._classInfo.getStaticMethods();
        if (staticMethods.isEmpty()) {
            return staticMethods;
        }
        ArrayList arrayList = new ArrayList();
        for (AnnotatedMethod annotatedMethod : staticMethods) {
            if (isFactoryMethod(annotatedMethod)) {
                arrayList.add(annotatedMethod);
            }
        }
        return arrayList;
    }

    @Override // org.codehaus.jackson.map.BeanDescription
    public boolean hasKnownClassAnnotations() {
        return this._classInfo.hasAnnotations();
    }

    public Object instantiateBean(boolean z) {
        AnnotatedConstructor defaultConstructor = this._classInfo.getDefaultConstructor();
        if (defaultConstructor == null) {
            return null;
        }
        if (z) {
            defaultConstructor.fixAccess();
        }
        try {
            return defaultConstructor.mo21976getAnnotated().newInstance(new Object[0]);
        } catch (Exception e) {
            e = e;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            if (e instanceof Error) {
                throw ((Error) e);
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalArgumentException("Failed to instantiate bean of type " + this._classInfo.mo21976getAnnotated().getName() + ": (" + e.getClass().getName() + ") " + e.getMessage(), e);
            }
            throw ((RuntimeException) e);
        }
    }

    protected boolean isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Package r1;
        Class<?> rawType = annotatedMethod.getRawType();
        if (rawType == null || !rawType.isArray() || (r1 = rawType.getComponentType().getPackage()) == null) {
            return false;
        }
        String name = r1.getName();
        return name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib");
    }

    protected boolean isFactoryMethod(AnnotatedMethod annotatedMethod) {
        if (!getBeanClass().isAssignableFrom(annotatedMethod.getRawType())) {
            return false;
        }
        return this._annotationIntrospector.hasCreatorAnnotation(annotatedMethod) || C0359h.f716m.equals(annotatedMethod.getName());
    }

    protected boolean isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        Package r1;
        Class<?> rawType = annotatedMethod.getRawType();
        return rawType != null && !rawType.isArray() && (r1 = rawType.getPackage()) != null && r1.getName().startsWith("groovy.lang");
    }

    protected boolean isGroovyMetaClassSetter(AnnotatedMethod annotatedMethod) {
        Package r1 = annotatedMethod.getParameterClass(0).getPackage();
        return r1 != null && r1.getName().startsWith("groovy.lang");
    }

    protected String mangleGetterName(Annotated annotated, String str) {
        return manglePropertyName(str);
    }

    protected String mangleSetterName(Annotated annotated, String str) {
        return manglePropertyName(str);
    }

    public String okNameForAnyGetter(AnnotatedMethod annotatedMethod, String str) {
        String okNameForIsGetter = okNameForIsGetter(annotatedMethod, str);
        return okNameForIsGetter == null ? okNameForGetter(annotatedMethod, str) : okNameForIsGetter;
    }

    public String okNameForGetter(AnnotatedMethod annotatedMethod, String str) {
        if (str.startsWith("get")) {
            if ("getCallbacks".equals(str)) {
                if (isCglibGetCallbacks(annotatedMethod)) {
                    return null;
                }
            } else if ("getMetaClass".equals(str) && isGroovyMetaClassGetter(annotatedMethod)) {
                return null;
            }
            return mangleGetterName(annotatedMethod, str.substring(3));
        }
        return null;
    }

    public String okNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
        if (str.startsWith("is")) {
            Class<?> rawType = annotatedMethod.getRawType();
            if (rawType != Boolean.class && rawType != Boolean.TYPE) {
                return null;
            }
            return mangleGetterName(annotatedMethod, str.substring(2));
        }
        return null;
    }

    public String okNameForSetter(AnnotatedMethod annotatedMethod) {
        String mangleSetterName;
        String name = annotatedMethod.getName();
        if (!name.startsWith("set") || (mangleSetterName = mangleSetterName(annotatedMethod, name.substring(3))) == null) {
            return null;
        }
        if ("metaClass".equals(mangleSetterName) && isGroovyMetaClassSetter(annotatedMethod)) {
            return null;
        }
        return mangleSetterName;
    }
}
