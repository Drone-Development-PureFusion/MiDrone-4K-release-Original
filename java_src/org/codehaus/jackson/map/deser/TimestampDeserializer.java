package org.codehaus.jackson.map.deser;

import java.sql.Timestamp;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
/* loaded from: classes2.dex */
public class TimestampDeserializer extends StdScalarDeserializer<Timestamp> {
    public TimestampDeserializer() {
        super(Timestamp.class);
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize  reason: collision with other method in class */
    public Timestamp mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return new Timestamp(_parseDate(jsonParser, deserializationContext).getTime());
    }
}
