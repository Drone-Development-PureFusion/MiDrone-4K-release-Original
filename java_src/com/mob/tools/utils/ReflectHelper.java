package com.mob.tools.utils;

import com.mob.tools.gui.CachePool;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.p318d.AbstractC5756f;
/* loaded from: classes.dex */
public class ReflectHelper {
    private static CachePool<String, Constructor<?>> cachedConstr;
    private static CachePool<String, Method> cachedMethod;
    private static HashSet<String> packageSet = new HashSet<>();
    private static HashMap<String, Class<?>> classMap = new HashMap<>();
    private static HashMap<Class<?>, String> nameMap = new HashMap<>();

    /* loaded from: classes.dex */
    public interface ReflectRunnable {
        Object run(Object obj);
    }

    static {
        packageSet.add("java.lang");
        packageSet.add("java.io");
        packageSet.add("java.nio");
        packageSet.add("java.net");
        packageSet.add("java.util");
        packageSet.add("com.mob.tools");
        packageSet.add("com.mob.tools.gui");
        packageSet.add("com.mob.tools.log");
        packageSet.add("com.mob.tools.network");
        packageSet.add("com.mob.tools.utils");
        classMap.put("double", Double.TYPE);
        classMap.put("float", Float.TYPE);
        classMap.put("long", Long.TYPE);
        classMap.put("int", Integer.TYPE);
        classMap.put("short", Short.TYPE);
        classMap.put("byte", Byte.TYPE);
        classMap.put("char", Character.TYPE);
        classMap.put("boolean", Boolean.TYPE);
        classMap.put("Object", Object.class);
        classMap.put("String", String.class);
        classMap.put("Thread", Thread.class);
        classMap.put("Runnable", Runnable.class);
        classMap.put("System", System.class);
        classMap.put("double", Double.class);
        classMap.put("Float", Float.class);
        classMap.put("Long", Long.class);
        classMap.put("Integer", Integer.class);
        classMap.put("Short", Short.class);
        classMap.put("Byte", Byte.class);
        classMap.put("Character", Character.class);
        classMap.put("Boolean", Boolean.class);
        for (Map.Entry<String, Class<?>> entry : classMap.entrySet()) {
            nameMap.put(entry.getValue(), entry.getKey());
        }
        cachedMethod = new CachePool<>(25);
        cachedConstr = new CachePool<>(5);
    }

    public static Object createProxy(final HashMap<String, ReflectRunnable> hashMap, Class<?>... clsArr) {
        return Proxy.newProxyInstance(hashMap.getClass().getClassLoader(), clsArr, new InvocationHandler() { // from class: com.mob.tools.utils.ReflectHelper.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                ReflectRunnable reflectRunnable = (ReflectRunnable) hashMap.get(method.getName());
                if (reflectRunnable != null) {
                    return reflectRunnable.run(objArr);
                }
                throw new NoSuchMethodException();
            }
        });
    }

    public static Class<?> getClass(String str) {
        Class<?> importedClass = getImportedClass(str);
        if (importedClass == null) {
            try {
                importedClass = Class.forName(str);
                if (importedClass != null) {
                    classMap.put(str, importedClass);
                }
            } catch (Throwable th) {
            }
        }
        return importedClass;
    }

    private static synchronized Class<?> getImportedClass(String str) {
        Class<?> cls;
        synchronized (ReflectHelper.class) {
            cls = classMap.get(str);
            if (cls == null) {
                Iterator<String> it2 = packageSet.iterator();
                while (it2.hasNext()) {
                    try {
                        importClass(it2.next() + "." + str);
                    } catch (Throwable th) {
                    }
                    cls = classMap.get(str);
                    if (cls != null) {
                        break;
                    }
                }
            }
        }
        return cls;
    }

    public static <T> T getInstanceField(Object obj, String str) {
        try {
            return (T) onGetInstanceField(obj, str);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchFieldException)) {
                throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
            }
            throw th;
        }
    }

    public static String getName(Class<?> cls) {
        String str = nameMap.get(cls);
        if (str == null) {
            String simpleName = cls.getSimpleName();
            if (classMap.containsKey(simpleName)) {
                return null;
            }
            classMap.put(simpleName, cls);
            nameMap.put(cls, simpleName);
            return simpleName;
        }
        return str;
    }

    public static <T> T getStaticField(String str, String str2) {
        try {
            return (T) onGetStaticField(str, str2);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchFieldException)) {
                throw new Throwable("className: " + str + ", fieldName: " + str2, th);
            }
            throw th;
        }
    }

    private static Class<?>[] getTypes(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    public static String importClass(String str) {
        return importClass(null, str);
    }

    public static synchronized String importClass(String str, String str2) {
        String simpleName;
        synchronized (ReflectHelper.class) {
            if (str2.endsWith(".*")) {
                packageSet.add(str2.substring(0, str2.length() - 2));
                simpleName = AbstractC5756f.f23062a;
            } else {
                Class<?> cls = Class.forName(str2);
                simpleName = str == null ? cls.getSimpleName() : str;
                classMap.put(simpleName, cls);
                nameMap.put(cls, simpleName);
            }
        }
        return simpleName;
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) invokeMethod(null, obj, str, objArr);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchMethodException)) {
                throw new Throwable("className: " + obj.getClass() + ", methodName: " + str, th);
            }
            throw th;
        }
    }

    private static <T> T invokeMethod(String str, Object obj, String str2, Object... objArr) {
        boolean z;
        Method[] declaredMethods;
        Class<?> importedClass = obj == null ? getImportedClass(str) : obj.getClass();
        String str3 = importedClass.getName() + "#" + str2 + "#" + objArr.length;
        Method method = cachedMethod.get(str3);
        Class<?>[] types = getTypes(objArr);
        if (method != null) {
            boolean isStatic = Modifier.isStatic(method.getModifiers());
            if (obj != null) {
                isStatic = !isStatic;
            }
            if (isStatic && matchParams(method.getParameterTypes(), types)) {
                method.setAccessible(true);
                if (method.getReturnType() != Void.TYPE) {
                    return (T) method.invoke(obj, objArr);
                }
                method.invoke(obj, objArr);
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        while (importedClass != null) {
            arrayList.add(importedClass);
            importedClass = importedClass.getSuperclass();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            for (Method method2 : ((Class) it2.next()).getDeclaredMethods()) {
                boolean isStatic2 = Modifier.isStatic(method2.getModifiers());
                if (obj != null) {
                    isStatic2 = !isStatic2;
                }
                if (method2.getName().equals(str2) && isStatic2) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (matchParams(parameterTypes, types)) {
                        cachedMethod.put(str3, method2);
                        method2.setAccessible(true);
                        if (method2.getReturnType() != Void.TYPE) {
                            return (T) method2.invoke(obj, objArr);
                        }
                        method2.invoke(obj, objArr);
                        return null;
                    } else if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && types.length >= parameterTypes.length - 1) {
                        arrayList2.add(method2);
                        arrayList3.add(parameterTypes);
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList3.size()) {
                Class[] clsArr = (Class[]) arrayList3.get(i2);
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                if (tryMatchParams(clsArr, types)) {
                    Object[] objArr2 = new Object[objArr.length + 1];
                    System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                    objArr2[objArr.length] = Array.newInstance(componentType, 0);
                    Method method3 = (Method) arrayList2.get(i2);
                    method3.setAccessible(true);
                    if (method3.getReturnType() != Void.TYPE) {
                        return (T) method3.invoke(obj, objArr2);
                    }
                    method3.invoke(obj, objArr2);
                    return null;
                }
                int length = clsArr.length - 1;
                while (true) {
                    if (length >= types.length) {
                        z = true;
                        break;
                    } else if (!types[length].equals(componentType)) {
                        z = false;
                        break;
                    } else {
                        length++;
                    }
                }
                if (z) {
                    int length2 = (types.length - clsArr.length) + 1;
                    Object newInstance = Array.newInstance(componentType, length2);
                    for (int i3 = 0; i3 < length2; i3++) {
                        Array.set(newInstance, i3, objArr[(clsArr.length - 1) + i3]);
                    }
                    Object[] objArr3 = new Object[clsArr.length];
                    System.arraycopy(objArr, 0, objArr3, 0, clsArr.length - 1);
                    objArr3[clsArr.length - 1] = newInstance;
                    Method method4 = (Method) arrayList2.get(i2);
                    method4.setAccessible(true);
                    if (method4.getReturnType() != Void.TYPE) {
                        return (T) method4.invoke(obj, objArr3);
                    }
                    method4.invoke(obj, objArr3);
                    return null;
                }
                i = i2 + 1;
            } else {
                throw new NoSuchMethodException("className: " + obj.getClass() + ", methodName: " + str2);
            }
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) {
        try {
            return (T) invokeMethod(str, null, str2, objArr);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchMethodException)) {
                throw new Throwable("className: " + str + ", methodName: " + str2, th);
            }
            throw th;
        }
    }

    private static boolean matchParams(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != null && !primitiveEquals(clsArr[i], clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Object newArray(String str, Object... objArr) {
        int[] iArr;
        int i = 0;
        String str2 = str;
        while (str2.startsWith("[")) {
            i++;
            str2 = str2.substring(1);
        }
        if (i == objArr.length) {
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    iArr2[i2] = Integer.parseInt(String.valueOf(objArr[i2]));
                } catch (Throwable th) {
                    iArr = null;
                }
            }
            iArr = iArr2;
        } else {
            iArr = null;
        }
        if (iArr != null) {
            Class<?> importedClass = "B".equals(str2) ? Byte.TYPE : "S".equals(str2) ? Short.TYPE : "I".equals(str2) ? Integer.TYPE : "J".equals(str2) ? Long.TYPE : "F".equals(str2) ? Float.TYPE : "D".equals(str2) ? Double.TYPE : "Z".equals(str2) ? Boolean.TYPE : "C".equals(str2) ? Character.TYPE : getImportedClass(str2);
            if (importedClass != null) {
                return Array.newInstance(importedClass, iArr);
            }
        }
        throw new NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return onNewInstance(str, objArr);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchMethodException)) {
                throw new Throwable("className: " + str + ", methodName: <init>", th);
            }
            throw th;
        }
    }

    private static Object onGetElement(Object obj, String str) {
        int i;
        if ("length".equals(str)) {
            return Integer.valueOf(Array.getLength(obj));
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable th) {
                i = -1;
            }
            if (i != -1) {
                return Array.get(obj, i);
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static <T> T onGetInstanceField(Object obj, String str) {
        Field field;
        if (obj.getClass().isArray()) {
            return (T) onGetElement(obj, str);
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                field = ((Class) it2.next()).getDeclaredField(str);
            } catch (Throwable th) {
                field = null;
            }
            if (field != null && !Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return (T) field.get(obj);
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static <T> T onGetStaticField(String str, String str2) {
        Field field;
        ArrayList arrayList = new ArrayList();
        for (Class<?> importedClass = getImportedClass(str); importedClass != null; importedClass = importedClass.getSuperclass()) {
            arrayList.add(importedClass);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                field = ((Class) it2.next()).getDeclaredField(str2);
            } catch (Throwable th) {
                field = null;
            }
            if (field != null && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return (T) field.get(null);
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }

    private static Object onNewInstance(String str, Object... objArr) {
        boolean z;
        if (str.startsWith("[")) {
            return newArray(str, objArr);
        }
        String str2 = str + "#" + objArr.length;
        Constructor<?> constructor = cachedConstr.get(str2);
        Class<?>[] types = getTypes(objArr);
        if (constructor != null && matchParams(constructor.getParameterTypes(), types)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        Constructor<?>[] declaredConstructors = getImportedClass(str).getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (matchParams(parameterTypes, types)) {
                cachedConstr.put(str2, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && types.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            Class[] clsArr = (Class[]) arrayList2.get(i);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (tryMatchParams(clsArr, types)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Constructor constructor3 = (Constructor) arrayList.get(i);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length >= types.length) {
                    z = true;
                    break;
                } else if (!types[length].equals(componentType)) {
                    z = false;
                    break;
                } else {
                    length++;
                }
            }
            if (z) {
                int length2 = (types.length - clsArr.length) + 1;
                Object newInstance = Array.newInstance(componentType, length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    Array.set(newInstance, i2, objArr[(clsArr.length - 1) + i2]);
                }
                Object[] objArr3 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                objArr3[objArr.length] = newInstance;
                Constructor constructor4 = (Constructor) arrayList.get(i);
                constructor4.setAccessible(true);
                return constructor4.newInstance(objArr);
            }
        }
        throw new NoSuchMethodException("className: " + str + ", methodName: <init>");
    }

    private static void onSetElement(Object obj, String str, Object obj2) {
        int i;
        Object obj3 = null;
        if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable th) {
                i = -1;
            }
            if (i != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls = obj2.getClass();
                if ("B".equals(name)) {
                    if (cls == Byte.class) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if ("S".equals(name)) {
                    if (cls == Short.class) {
                        obj3 = obj2;
                    } else if (cls == Byte.class) {
                        obj3 = Short.valueOf(((Byte) obj2).byteValue());
                    }
                    if (obj3 != null) {
                        Array.set(obj, i, obj3);
                        return;
                    }
                } else if ("I".equals(name)) {
                    if (cls == Integer.class) {
                        obj3 = obj2;
                    } else if (cls == Short.class) {
                        obj3 = Integer.valueOf(((Short) obj2).shortValue());
                    } else if (cls == Byte.class) {
                        obj3 = Integer.valueOf(((Byte) obj2).byteValue());
                    }
                    if (obj3 != null) {
                        Array.set(obj, i, obj3);
                        return;
                    }
                } else if ("J".equals(name)) {
                    if (cls == Long.class) {
                        obj3 = obj2;
                    } else if (cls == Integer.class) {
                        obj3 = Long.valueOf(((Integer) obj2).intValue());
                    } else if (cls == Short.class) {
                        obj3 = Long.valueOf(((Short) obj2).shortValue());
                    } else if (cls == Byte.class) {
                        obj3 = Long.valueOf(((Byte) obj2).byteValue());
                    }
                    if (obj3 != null) {
                        Array.set(obj, i, obj3);
                        return;
                    }
                } else if ("F".equals(name)) {
                    if (cls == Float.class) {
                        obj3 = obj2;
                    } else if (cls == Long.class) {
                        obj3 = Float.valueOf((float) ((Long) obj2).longValue());
                    } else if (cls == Integer.class) {
                        obj3 = Float.valueOf(((Integer) obj2).intValue());
                    } else if (cls == Short.class) {
                        obj3 = Float.valueOf(((Short) obj2).shortValue());
                    } else if (cls == Byte.class) {
                        obj3 = Float.valueOf(((Byte) obj2).byteValue());
                    }
                    if (obj3 != null) {
                        Array.set(obj, i, obj3);
                        return;
                    }
                } else if ("D".equals(name)) {
                    Object valueOf = cls == Double.class ? obj2 : cls == Float.class ? Double.valueOf(((Float) obj2).floatValue()) : cls == Long.class ? Double.valueOf(((Long) obj2).longValue()) : cls == Integer.class ? Double.valueOf(((Integer) obj2).intValue()) : cls == Short.class ? Double.valueOf(((Short) obj2).shortValue()) : cls == Byte.class ? Double.valueOf(((Byte) obj2).byteValue()) : null;
                    if (valueOf != null) {
                        Array.set(obj, i, valueOf);
                        return;
                    }
                } else if ("Z".equals(name)) {
                    if (cls == Boolean.class) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if ("C".equals(name)) {
                    if (cls == Character.class) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if (name.equals(cls.getName())) {
                    Array.set(obj, i, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static void onSetInstanceField(Object obj, String str, Object obj2) {
        Field field;
        if (obj.getClass().isArray()) {
            onSetElement(obj, str, obj2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                field = ((Class) it2.next()).getDeclaredField(str);
            } catch (Throwable th) {
                field = null;
            }
            if (field != null && !Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set(obj, obj2);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static void onSetStaticField(String str, String str2, Object obj) {
        Field field;
        ArrayList arrayList = new ArrayList();
        for (Class<?> importedClass = getImportedClass(str); importedClass != null; importedClass = importedClass.getSuperclass()) {
            arrayList.add(importedClass);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                field = ((Class) it2.next()).getDeclaredField(str2);
            } catch (Throwable th) {
                field = null;
            }
            if (field != null && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set(null, obj);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj));
    }

    private static boolean primitiveEquals(Class<?> cls, Class<?> cls2) {
        return (cls == Byte.TYPE && cls2 == Byte.class) || (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) || ((cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    public static void setInstanceField(Object obj, String str, Object obj2) {
        try {
            onSetInstanceField(obj, str, obj2);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchFieldException)) {
                throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th);
            }
            throw th;
        }
    }

    public static void setStaticField(String str, String str2, Object obj) {
        try {
            onSetStaticField(str, str2, obj);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchFieldException)) {
                throw new Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj), th);
            }
            throw th;
        }
    }

    private static boolean tryMatchParams(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length - clsArr2.length == 1) {
            int i = 0;
            while (true) {
                if (i >= clsArr2.length) {
                    z = true;
                    break;
                } else if (clsArr2[i] != null && !primitiveEquals(clsArr[i], clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            return z && clsArr[clsArr.length + (-1)].isArray();
        }
        return false;
    }
}
