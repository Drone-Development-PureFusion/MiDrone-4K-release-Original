package org.codehaus.jackson.org.objectweb.asm;

import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.ViewCompat;
import com.hoho.android.usbserial.driver.UsbId;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final int BYTE = 3;
    public static final int CHAR = 2;
    public static final int DOUBLE = 8;
    public static final int FLOAT = 6;
    public static final int INT = 5;
    public static final int LONG = 7;
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final int VOID = 0;

    /* renamed from: a */
    private final int f22953a;

    /* renamed from: b */
    private final char[] f22954b;

    /* renamed from: c */
    private final int f22955c;

    /* renamed from: d */
    private final int f22956d;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i, char[] cArr, int i2, int i3) {
        this.f22953a = i;
        this.f22954b = cArr;
        this.f22955c = i2;
        this.f22956d = i3;
    }

    /* renamed from: a */
    private static Type m191a(char[] cArr, int i) {
        int i2 = 1;
        switch (cArr[i]) {
            case 'B':
                return BYTE_TYPE;
            case UsbId.ARDUINO_UNO_R3 /* 67 */:
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            case 'F':
                return FLOAT_TYPE;
            case 'I':
                return INT_TYPE;
            case 'J':
                return LONG_TYPE;
            case 'S':
                return SHORT_TYPE;
            case 'V':
                return VOID_TYPE;
            case 'Z':
                return BOOLEAN_TYPE;
            case '[':
                while (cArr[i + i2] == '[') {
                    i2++;
                }
                if (cArr[i + i2] == 'L') {
                    while (true) {
                        i2++;
                        if (cArr[i + i2] != ';') {
                        }
                    }
                }
                return new Type(9, cArr, i, i2 + 1);
            default:
                while (cArr[i + i2] != ';') {
                    i2++;
                }
                return new Type(10, cArr, i + 1, i2 - 1);
        }
    }

    /* renamed from: a */
    private void m193a(StringBuffer stringBuffer) {
        if (this.f22954b == null) {
            stringBuffer.append((char) ((this.f22955c & ViewCompat.MEASURED_STATE_MASK) >>> 24));
        } else if (this.f22953a == 9) {
            stringBuffer.append(this.f22954b, this.f22955c, this.f22956d);
        } else {
            stringBuffer.append('L');
            stringBuffer.append(this.f22954b, this.f22955c, this.f22956d);
            stringBuffer.append(';');
        }
    }

    /* renamed from: a */
    private static void m192a(StringBuffer stringBuffer, Class cls) {
        while (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                stringBuffer.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(';');
                return;
            }
            stringBuffer.append('[');
            cls = cls.getComponentType();
        }
        stringBuffer.append(cls == Integer.TYPE ? 'I' : cls == Void.TYPE ? 'V' : cls == Boolean.TYPE ? 'Z' : cls == Byte.TYPE ? 'B' : cls == Character.TYPE ? 'C' : cls == Short.TYPE ? 'S' : cls == Double.TYPE ? 'D' : cls == Float.TYPE ? 'F' : 'J');
    }

    public static Type[] getArgumentTypes(String str) {
        int i = 1;
        char[] charArray = str.toCharArray();
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char c = charArray[i3];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                while (true) {
                    int i5 = i4;
                    i4 = i5 + 1;
                    if (charArray[i5] == ';') {
                        break;
                    }
                }
                i2++;
                i3 = i4;
            } else if (c != '[') {
                i2++;
                i3 = i4;
            } else {
                i3 = i4;
            }
        }
        Type[] typeArr = new Type[i2];
        int i6 = 0;
        while (charArray[i] != ')') {
            typeArr[i6] = m191a(charArray, i);
            i += (typeArr[i6].f22953a == 10 ? 2 : 0) + typeArr[i6].f22956d;
            i6++;
        }
        return typeArr;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType(parameterTypes[length]);
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        char charAt;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                while (true) {
                    int i5 = i;
                    i = i5 + 1;
                    if (str.charAt(i5) == ';') {
                        break;
                    }
                }
                i4++;
                i3 = i;
            } else if (charAt2 == '[') {
                while (true) {
                    charAt = str.charAt(i);
                    if (charAt != '[') {
                        break;
                    }
                    i++;
                }
                if (charAt == 'D' || charAt == 'J') {
                    i4--;
                    i3 = i;
                } else {
                    i3 = i;
                }
            } else if (charAt2 == 'D' || charAt2 == 'J') {
                i4 += 2;
                i3 = i;
            } else {
                i4++;
                i3 = i;
            }
        }
        char charAt3 = str.charAt(i);
        int i6 = i4 << 2;
        if (charAt3 == 'V') {
            i2 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i2 = 2;
        }
        return i6 | i2;
    }

    public static String getConstructorDescriptor(Constructor constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C0359h.f722s);
        for (Class<?> cls : parameterTypes) {
            m192a(stringBuffer, cls);
        }
        return stringBuffer.append(")V").toString();
    }

    public static String getDescriptor(Class cls) {
        StringBuffer stringBuffer = new StringBuffer();
        m192a(stringBuffer, cls);
        return stringBuffer.toString();
    }

    public static String getInternalName(Class cls) {
        return cls.getName().replace(C0359h.f677G, '/');
    }

    public static String getMethodDescriptor(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C0359h.f722s);
        for (Class<?> cls : parameterTypes) {
            m192a(stringBuffer, cls);
        }
        stringBuffer.append(C0359h.f723t);
        m192a(stringBuffer, method.getReturnType());
        return stringBuffer.toString();
    }

    public static String getMethodDescriptor(Type type, Type[] typeArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C0359h.f722s);
        for (Type type2 : typeArr) {
            type2.m193a(stringBuffer);
        }
        stringBuffer.append(C0359h.f723t);
        type.m193a(stringBuffer);
        return stringBuffer.toString();
    }

    public static Type getObjectType(String str) {
        char[] charArray = str.toCharArray();
        return new Type(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
    }

    public static Type getReturnType(String str) {
        return m191a(str.toCharArray(), str.indexOf(41) + 1);
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static Type getType(Class cls) {
        return cls.isPrimitive() ? cls == Integer.TYPE ? INT_TYPE : cls == Void.TYPE ? VOID_TYPE : cls == Boolean.TYPE ? BOOLEAN_TYPE : cls == Byte.TYPE ? BYTE_TYPE : cls == Character.TYPE ? CHAR_TYPE : cls == Short.TYPE ? SHORT_TYPE : cls == Double.TYPE ? DOUBLE_TYPE : cls == Float.TYPE ? FLOAT_TYPE : LONG_TYPE : getType(getDescriptor(cls));
    }

    public static Type getType(String str) {
        return m191a(str.toCharArray(), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        if (this.f22953a != type.f22953a) {
            return false;
        }
        if (this.f22953a != 10 && this.f22953a != 9) {
            return true;
        }
        if (this.f22956d != type.f22956d) {
            return false;
        }
        int i = this.f22955c;
        int i2 = type.f22955c;
        int i3 = this.f22956d + i;
        while (i < i3) {
            if (this.f22954b[i] != type.f22954b[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public String getClassName() {
        switch (this.f22953a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuffer stringBuffer = new StringBuffer(getElementType().getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    stringBuffer.append("[]");
                }
                return stringBuffer.toString();
            default:
                return new String(this.f22954b, this.f22955c, this.f22956d).replace('/', C0359h.f677G);
        }
    }

    public String getDescriptor() {
        StringBuffer stringBuffer = new StringBuffer();
        m193a(stringBuffer);
        return stringBuffer.toString();
    }

    public int getDimensions() {
        int i = 1;
        while (this.f22954b[this.f22955c + i] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return m191a(this.f22954b, this.f22955c + getDimensions());
    }

    public String getInternalName() {
        return new String(this.f22954b, this.f22955c, this.f22956d);
    }

    public int getOpcode(int i) {
        int i2 = 4;
        if (i == 46 || i == 79) {
            if (this.f22954b == null) {
                i2 = (this.f22955c & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            }
            return i2 + i;
        }
        if (this.f22954b == null) {
            i2 = (this.f22955c & 16711680) >> 16;
        }
        return i2 + i;
    }

    public int getSize() {
        if (this.f22954b == null) {
            return this.f22955c & 255;
        }
        return 1;
    }

    public int getSort() {
        return this.f22953a;
    }

    public int hashCode() {
        int i = this.f22953a * 13;
        if (this.f22953a == 10 || this.f22953a == 9) {
            int i2 = this.f22955c;
            int i3 = i2 + this.f22956d;
            while (i2 < i3) {
                int i4 = (i + this.f22954b[i2]) * 17;
                i2++;
                i = i4;
            }
        }
        return i;
    }

    public String toString() {
        return getDescriptor();
    }
}
