package com.tencent.p227mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.tencent.mm.sdk.storage.CursorFieldHelper */
/* loaded from: classes2.dex */
class CursorFieldHelper {

    /* renamed from: bI */
    private static final Map<Class<?>, Method> f17901bI = new HashMap();

    /* renamed from: bJ */
    private static final Map<Class<?>, Method> f17902bJ = new HashMap();

    /* renamed from: bK */
    private static final Map<Class<?>, String> f17903bK = new HashMap();

    static {
        try {
            f17901bI.put(byte[].class, CursorFieldHelper.class.getMethod("keep_setBlob", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Short.TYPE, CursorFieldHelper.class.getMethod("keep_setShort", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Short.class, CursorFieldHelper.class.getMethod("keep_setShort", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Boolean.TYPE, CursorFieldHelper.class.getMethod("keep_setBoolean", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Boolean.class, CursorFieldHelper.class.getMethod("keep_setBoolean", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Integer.TYPE, CursorFieldHelper.class.getMethod("keep_setInt", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Integer.class, CursorFieldHelper.class.getMethod("keep_setInt", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Float.TYPE, CursorFieldHelper.class.getMethod("keep_setFloat", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Float.class, CursorFieldHelper.class.getMethod("keep_setFloat", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Double.TYPE, CursorFieldHelper.class.getMethod("keep_setDouble", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Double.class, CursorFieldHelper.class.getMethod("keep_setDouble", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Long.TYPE, CursorFieldHelper.class.getMethod("keep_setLong", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(Long.class, CursorFieldHelper.class.getMethod("keep_setLong", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17901bI.put(String.class, CursorFieldHelper.class.getMethod("keep_setString", Field.class, Object.class, Cursor.class, Integer.TYPE));
            f17902bJ.put(byte[].class, CursorFieldHelper.class.getMethod("keep_getBlob", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Short.TYPE, CursorFieldHelper.class.getMethod("keep_getShort", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Short.class, CursorFieldHelper.class.getMethod("keep_getShort", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Boolean.TYPE, CursorFieldHelper.class.getMethod("keep_getBoolean", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Boolean.class, CursorFieldHelper.class.getMethod("keep_getBoolean", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Integer.TYPE, CursorFieldHelper.class.getMethod("keep_getInt", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Integer.class, CursorFieldHelper.class.getMethod("keep_getInt", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Float.TYPE, CursorFieldHelper.class.getMethod("keep_getFloat", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Float.class, CursorFieldHelper.class.getMethod("keep_getFloat", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Double.TYPE, CursorFieldHelper.class.getMethod("keep_getDouble", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Double.class, CursorFieldHelper.class.getMethod("keep_getDouble", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Long.TYPE, CursorFieldHelper.class.getMethod("keep_getLong", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(Long.class, CursorFieldHelper.class.getMethod("keep_getLong", Field.class, Object.class, ContentValues.class));
            f17902bJ.put(String.class, CursorFieldHelper.class.getMethod("keep_getString", Field.class, Object.class, ContentValues.class));
            f17903bK.put(byte[].class, "BLOB");
            f17903bK.put(Short.TYPE, "SHORT");
            f17903bK.put(Short.class, "SHORT");
            f17903bK.put(Boolean.TYPE, "INTEGER");
            f17903bK.put(Boolean.class, "INTEGER");
            f17903bK.put(Integer.TYPE, "INTEGER");
            f17903bK.put(Integer.class, "INTEGER");
            f17903bK.put(Float.TYPE, "FLOAT");
            f17903bK.put(Float.class, "FLOAT");
            f17903bK.put(Double.TYPE, "DOUBLE");
            f17903bK.put(Double.class, "DOUBLE");
            f17903bK.put(Long.TYPE, "LONG");
            f17903bK.put(Long.class, "LONG");
            f17903bK.put(String.class, "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CursorFieldHelper() {
    }

    public static Method get(Class<?> cls, boolean z) {
        return z ? f17902bJ.get(cls) : f17901bI.get(cls);
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(field.getName().substring(6), (byte[]) field.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(field.getName().substring(6), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        try {
            if (!field.getType().equals(Double.TYPE)) {
                contentValues.put(field.getName().substring(6), (Double) field.get(obj));
            } else {
                contentValues.put(field.getName().substring(6), Double.valueOf(field.getDouble(obj)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        try {
            if (!field.getType().equals(Float.TYPE)) {
                contentValues.put(field.getName().substring(6), (Float) field.get(obj));
            } else {
                contentValues.put(field.getName().substring(6), Float.valueOf(field.getFloat(obj)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        try {
            if (!field.getType().equals(Integer.TYPE)) {
                contentValues.put(field.getName().substring(6), (Integer) field.get(obj));
            } else {
                contentValues.put(field.getName().substring(6), Integer.valueOf(field.getInt(obj)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        try {
            if (!field.getType().equals(Long.TYPE)) {
                contentValues.put(field.getName().substring(6), (Long) field.get(obj));
            } else {
                contentValues.put(field.getName().substring(6), Long.valueOf(field.getLong(obj)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(field.getName().substring(6), Short.valueOf(field.getShort(obj)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(field.getName().substring(6), (String) field.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getBlob(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
            } else {
                field.set(obj, Double.valueOf(cursor.getDouble(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
            } else {
                field.set(obj, Float.valueOf(cursor.getFloat(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
            } else {
                field.set(obj, Long.valueOf(cursor.getLong(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
            } else {
                field.set(obj, Short.valueOf(cursor.getShort(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getString(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String type(Class<?> cls) {
        return f17903bK.get(cls);
    }
}
