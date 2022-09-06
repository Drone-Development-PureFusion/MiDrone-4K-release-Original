package org.codehaus.jackson.map;
/* loaded from: classes2.dex */
public class RuntimeJsonMappingException extends RuntimeException {
    public RuntimeJsonMappingException(String str) {
        super(str);
    }

    public RuntimeJsonMappingException(String str, JsonMappingException jsonMappingException) {
        super(str, jsonMappingException);
    }

    public RuntimeJsonMappingException(JsonMappingException jsonMappingException) {
        super(jsonMappingException);
    }
}
