package com.fimi.soul.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/* renamed from: com.fimi.soul.utils.ah */
/* loaded from: classes.dex */
public class C3638ah {

    /* renamed from: a */
    private static ObjectMapper f14795a = new ObjectMapper();

    static {
        f14795a.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        f14795a.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        f14795a.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        f14795a.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        f14795a.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        f14795a.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        f14795a.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, false);
        f14795a.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    /* renamed from: a */
    public static <T> T m7707a(Class<T> cls, File file) {
        return (T) f14795a.readValue(file, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> ArrayList<T> m7706a(Class<? extends T[]> cls, String str) {
        Object[] objArr = (Object[]) f14795a.readValue(str, cls);
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<LinkedHashMap<String, Object>> m7705a(String str) {
        return (List) f14795a.readValue(str, List.class);
    }

    /* renamed from: a */
    public static void m7704a(DeserializationProblemHandler deserializationProblemHandler) {
        f14795a.getDeserializationConfig().addHandler(deserializationProblemHandler);
    }

    /* renamed from: b */
    public static <T> T m7703b(Class<T> cls, String str) {
        return (T) f14795a.readValue(str, cls);
    }
}
