package org.codehaus.jackson.map.deser;

import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
/* loaded from: classes2.dex */
public class DateDeserializer extends StdScalarDeserializer<Date> {
    public DateDeserializer() {
        super(Date.class);
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize  reason: collision with other method in class */
    public Date mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return _parseDate(jsonParser, deserializationContext);
    }
}
