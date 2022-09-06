package org.codehaus.jackson.p317xc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import javax.activation.DataHandler;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.node.ObjectNode;
/* renamed from: org.codehaus.jackson.xc.DataHandlerJsonSerializer */
/* loaded from: classes2.dex */
public class DataHandlerJsonSerializer extends SerializerBase<DataHandler> {
    public DataHandlerJsonSerializer() {
        super(DataHandler.class);
    }

    @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        ObjectNode createSchemaNode = createSchemaNode("array", true);
        createSchemaNode.put("items", createSchemaNode("string"));
        return createSchemaNode;
    }

    @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
    public void serialize(DataHandler dataHandler, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        InputStream inputStream = dataHandler.getInputStream();
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            byteArrayOutputStream.write(bArr, 0, read);
        }
        jsonGenerator.writeBinary(byteArrayOutputStream.toByteArray());
    }
}
