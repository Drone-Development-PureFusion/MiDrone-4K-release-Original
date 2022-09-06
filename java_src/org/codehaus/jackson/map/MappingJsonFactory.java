package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.format.InputAccessor;
import org.codehaus.jackson.format.MatchStrength;
/* loaded from: classes2.dex */
public class MappingJsonFactory extends JsonFactory {
    public MappingJsonFactory() {
        this(null);
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super(objectMapper);
        if (objectMapper == null) {
            setCodec(new ObjectMapper(this));
        }
    }

    @Override // org.codehaus.jackson.JsonFactory
    /* renamed from: getCodec  reason: collision with other method in class */
    public final ObjectMapper mo21898getCodec() {
        return (ObjectMapper) this._objectCodec;
    }

    @Override // org.codehaus.jackson.JsonFactory
    public String getFormatName() {
        return JsonFactory.FORMAT_NAME_JSON;
    }

    @Override // org.codehaus.jackson.JsonFactory
    public MatchStrength hasFormat(InputAccessor inputAccessor) {
        return hasJSONFormat(inputAccessor);
    }
}
