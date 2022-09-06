package org.codehaus.jackson.map;
/* loaded from: classes2.dex */
public abstract class DeserializationProblemHandler {
    public boolean handleUnknownProperty(DeserializationContext deserializationContext, JsonDeserializer<?> jsonDeserializer, Object obj, String str) {
        return false;
    }
}
