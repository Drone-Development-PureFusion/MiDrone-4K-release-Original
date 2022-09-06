package org.codehaus.jackson.mrbean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.org.objectweb.asm.ClassWriter;
import org.codehaus.jackson.org.objectweb.asm.MethodVisitor;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.org.objectweb.asm.Type;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public class BeanBuilder {
    protected final Class<?> _implementedType;
    protected final TypeFactory _typeFactory;
    protected Map<String, Property> _beanProperties = new LinkedHashMap();
    protected LinkedHashMap<String, Method> _unsupportedMethods = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Property {
        protected final String _fieldName;
        protected Method _getter;
        protected final String _name;
        protected Method _setter;

        public Property(String str) {
            this._name = str;
            this._fieldName = "_" + str;
        }

        private TypeDescription getterType(TypeFactory typeFactory) {
            return new TypeDescription(typeFactory.constructType(this._getter.getGenericReturnType(), this._getter.getDeclaringClass()));
        }

        private TypeDescription setterType(TypeFactory typeFactory) {
            return new TypeDescription(typeFactory.constructType(this._setter.getGenericParameterTypes()[0], this._setter.getDeclaringClass()));
        }

        public String getFieldName() {
            return this._fieldName;
        }

        public Method getGetter() {
            return this._getter;
        }

        public String getName() {
            return this._name;
        }

        public Method getSetter() {
            return this._setter;
        }

        public boolean hasConcreteGetter() {
            return this._getter != null && BeanUtil.isConcrete(this._getter);
        }

        public boolean hasConcreteSetter() {
            return this._setter != null && BeanUtil.isConcrete(this._setter);
        }

        public TypeDescription selectType(TypeFactory typeFactory) {
            if (this._getter == null) {
                return setterType(typeFactory);
            }
            if (this._setter == null) {
                return getterType(typeFactory);
            }
            TypeDescription typeDescription = setterType(typeFactory);
            TypeDescription typeDescription2 = getterType(typeFactory);
            TypeDescription moreSpecificType = TypeDescription.moreSpecificType(typeDescription, typeDescription2);
            if (moreSpecificType != null) {
                return moreSpecificType;
            }
            throw new IllegalArgumentException("Invalid property '" + getName() + "': incompatible types for getter/setter (" + typeDescription2 + " vs " + typeDescription + ")");
        }

        public void setGetter(Method method) {
            this._getter = method;
        }

        public void setSetter(Method method) {
            this._setter = method;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class TypeDescription {
        private final Type _asmType;
        private JavaType _jacksonType;

        public TypeDescription(JavaType javaType) {
            this._jacksonType = javaType;
            this._asmType = Type.getType(javaType.getRawClass());
        }

        public static TypeDescription moreSpecificType(TypeDescription typeDescription, TypeDescription typeDescription2) {
            Class<?> rawClass = typeDescription.getRawClass();
            Class<?> rawClass2 = typeDescription2.getRawClass();
            if (rawClass.isAssignableFrom(rawClass2)) {
                return typeDescription2;
            }
            if (!rawClass2.isAssignableFrom(rawClass)) {
                return null;
            }
            return typeDescription;
        }

        public String erasedSignature() {
            return this._jacksonType.getErasedSignature();
        }

        public String genericSignature() {
            return this._jacksonType.getGenericSignature();
        }

        public int getLoadOpcode() {
            return this._asmType.getOpcode(21);
        }

        public Class<?> getRawClass() {
            return this._jacksonType.getRawClass();
        }

        public int getReturnOpcode() {
            return this._asmType.getOpcode(Opcodes.IRETURN);
        }

        public boolean hasGenerics() {
            return this._jacksonType.hasGenericTypes();
        }

        public String toString() {
            return this._jacksonType.toString();
        }
    }

    public BeanBuilder(DeserializationConfig deserializationConfig, Class<?> cls) {
        this._implementedType = cls;
        this._typeFactory = deserializationConfig.getTypeFactory();
    }

    private void addGetter(Method method) {
        Property findProperty = findProperty(getPropertyName(method.getName()));
        if (findProperty.getGetter() == null) {
            findProperty.setGetter(method);
        }
    }

    private void addSetter(Method method) {
        Property findProperty = findProperty(getPropertyName(method.getName()));
        if (findProperty.getSetter() == null) {
            findProperty.setSetter(method);
        }
    }

    private static String buildGetterName(String str) {
        return "get" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String buildSetterName(String str) {
        return "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static void createField(ClassWriter classWriter, Property property, TypeDescription typeDescription) {
        classWriter.visitField(1, property.getFieldName(), typeDescription.erasedSignature(), typeDescription.hasGenerics() ? typeDescription.genericSignature() : null, null).visitEnd();
    }

    private static void createGetter(ClassWriter classWriter, String str, Property property, TypeDescription typeDescription) {
        String str2;
        String buildGetterName;
        Method getter = property.getGetter();
        if (getter != null) {
            str2 = Type.getMethodDescriptor(getter);
            buildGetterName = getter.getName();
        } else {
            str2 = "()" + typeDescription.erasedSignature();
            buildGetterName = buildGetterName(property.getName());
        }
        MethodVisitor visitMethod = classWriter.visitMethod(1, buildGetterName, str2, typeDescription.hasGenerics() ? "()" + typeDescription.genericSignature() : null, null);
        visitMethod.visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitFieldInsn(Opcodes.GETFIELD, str, property.getFieldName(), typeDescription.erasedSignature());
        visitMethod.visitInsn(typeDescription.getReturnOpcode());
        visitMethod.visitMaxs(0, 0);
        visitMethod.visitEnd();
    }

    private static void createSetter(ClassWriter classWriter, String str, Property property, TypeDescription typeDescription) {
        String str2;
        String buildSetterName;
        Method setter = property.getSetter();
        if (setter != null) {
            str2 = Type.getMethodDescriptor(setter);
            buildSetterName = setter.getName();
        } else {
            str2 = "(" + typeDescription.erasedSignature() + ")V";
            buildSetterName = buildSetterName(property.getName());
        }
        MethodVisitor visitMethod = classWriter.visitMethod(1, buildSetterName, str2, typeDescription.hasGenerics() ? "(" + typeDescription.genericSignature() + ")V" : null, null);
        visitMethod.visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitVarInsn(typeDescription.getLoadOpcode(), 1);
        visitMethod.visitFieldInsn(Opcodes.PUTFIELD, str, property.getFieldName(), typeDescription.erasedSignature());
        visitMethod.visitInsn(Opcodes.RETURN);
        visitMethod.visitMaxs(0, 0);
        visitMethod.visitEnd();
    }

    private static void createUnimplementedMethod(ClassWriter classWriter, String str, Method method) {
        String internalClassName = getInternalClassName(UnsupportedOperationException.class.getName());
        String methodDescriptor = Type.getMethodDescriptor(method);
        String name = method.getName();
        MethodVisitor visitMethod = classWriter.visitMethod(1, name, methodDescriptor, null, null);
        visitMethod.visitTypeInsn(Opcodes.NEW, internalClassName);
        visitMethod.visitInsn(89);
        visitMethod.visitLdcInsn("Unimplemented method '" + name + "' (not a setter/getter, could not materialize)");
        visitMethod.visitMethodInsn(Opcodes.INVOKESPECIAL, internalClassName, "<init>", "(Ljava/lang/String;)V");
        visitMethod.visitInsn(Opcodes.ATHROW);
        visitMethod.visitMaxs(0, 0);
        visitMethod.visitEnd();
    }

    private Property findProperty(String str) {
        Property property = this._beanProperties.get(str);
        if (property == null) {
            Property property2 = new Property(str);
            this._beanProperties.put(str, property2);
            return property2;
        }
        return property;
    }

    private static void generateDefaultConstructor(ClassWriter classWriter, String str) {
        MethodVisitor visitMethod = classWriter.visitMethod(1, "<init>", "()V", null, null);
        visitMethod.visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitMethodInsn(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
        visitMethod.visitInsn(Opcodes.RETURN);
        visitMethod.visitMaxs(0, 0);
        visitMethod.visitEnd();
    }

    private static String getInternalClassName(String str) {
        return str.replace(".", "/");
    }

    private static String getPropertyName(String str) {
        String substring = str.substring(str.startsWith("is") ? 2 : 3);
        StringBuilder sb = new StringBuilder(substring);
        sb.setCharAt(0, Character.toLowerCase(substring.charAt(0)));
        return sb.toString();
    }

    private static final boolean returnsBoolean(Method method) {
        Class<?> returnType = method.getReturnType();
        return returnType == Boolean.class || returnType == Boolean.TYPE;
    }

    public byte[] build(String str) {
        String str2;
        ClassWriter classWriter = new ClassWriter(1);
        String internalClassName = getInternalClassName(str);
        String internalClassName2 = getInternalClassName(this._implementedType.getName());
        if (this._implementedType.isInterface()) {
            str2 = "java/lang/Object";
            classWriter.visit(49, 33, internalClassName, null, str2, new String[]{internalClassName2});
        } else {
            classWriter.visit(49, 33, internalClassName, null, internalClassName2, null);
            str2 = internalClassName2;
        }
        classWriter.visitSource(str + ".java", null);
        generateDefaultConstructor(classWriter, str2);
        for (Property property : this._beanProperties.values()) {
            TypeDescription selectType = property.selectType(this._typeFactory);
            createField(classWriter, property, selectType);
            if (!property.hasConcreteGetter()) {
                createGetter(classWriter, internalClassName, property, selectType);
            }
            if (!property.hasConcreteSetter()) {
                createSetter(classWriter, internalClassName, property, selectType);
            }
        }
        for (Method method : this._unsupportedMethods.values()) {
            createUnimplementedMethod(classWriter, internalClassName, method);
        }
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BeanBuilder implement(boolean z) {
        Method[] declaredMethods;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this._implementedType);
        BeanUtil.findSuperTypes(this._implementedType, Object.class, arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            for (Method method : ((Class) it2.next()).getDeclaredMethods()) {
                String name = method.getName();
                int length = method.getParameterTypes().length;
                if (length == 0) {
                    if (name.startsWith("get") || (name.startsWith("is") && returnsBoolean(method))) {
                        addGetter(method);
                    }
                    if (!BeanUtil.isConcrete(method) && !this._unsupportedMethods.containsKey(name)) {
                        if (!z) {
                            throw new IllegalArgumentException("Unrecognized abstract method '" + name + "' (not a getter or setter) -- to avoid exception, disable AbstractTypeMaterializer.Feature.FAIL_ON_UNMATERIALIZED_METHOD");
                        }
                        this._unsupportedMethods.put(name, method);
                    }
                } else {
                    if (length == 1 && name.startsWith("set")) {
                        addSetter(method);
                    }
                    if (!BeanUtil.isConcrete(method)) {
                        if (!z) {
                        }
                    }
                }
            }
        }
        return this;
    }
}
