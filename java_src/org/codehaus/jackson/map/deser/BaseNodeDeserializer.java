package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
/* loaded from: classes2.dex */
abstract class BaseNodeDeserializer<N extends JsonNode> extends StdDeserializer<N> {
    public BaseNodeDeserializer(Class<N> cls) {
        super((Class<?>) cls);
    }

    protected void _handleDuplicateField(String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) {
    }

    protected void _reportProblem(JsonParser jsonParser, String str) {
        throw new JsonMappingException(str, jsonParser.getTokenLocation());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonNode deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        switch (jsonParser.getCurrentToken()) {
            case START_OBJECT:
            case FIELD_NAME:
                return deserializeObject(jsonParser, deserializationContext);
            case START_ARRAY:
                return deserializeArray(jsonParser, deserializationContext);
            case VALUE_STRING:
                return nodeFactory.textNode(jsonParser.getText());
            case VALUE_NUMBER_INT:
                JsonParser.NumberType numberType = jsonParser.getNumberType();
                return (numberType == JsonParser.NumberType.BIG_INTEGER || deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) ? nodeFactory.numberNode(jsonParser.getBigIntegerValue()) : numberType == JsonParser.NumberType.INT ? nodeFactory.numberNode(jsonParser.getIntValue()) : nodeFactory.numberNode(jsonParser.getLongValue());
            case VALUE_NUMBER_FLOAT:
                return (jsonParser.getNumberType() == JsonParser.NumberType.BIG_DECIMAL || deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) ? nodeFactory.numberNode(jsonParser.getDecimalValue()) : nodeFactory.numberNode(jsonParser.getDoubleValue());
            case VALUE_TRUE:
                return nodeFactory.booleanNode(true);
            case VALUE_FALSE:
                return nodeFactory.booleanNode(false);
            case VALUE_NULL:
                return nodeFactory.nullNode();
            default:
                throw deserializationContext.mappingException(getValueClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayNode deserializeArray(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ArrayNode arrayNode = deserializationContext.getNodeFactory().arrayNode();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            arrayNode.add(deserializeAny(jsonParser, deserializationContext));
        }
        return arrayNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ObjectNode deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ObjectNode objectNode = deserializationContext.getNodeFactory().objectNode();
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            JsonNode deserializeAny = deserializeAny(jsonParser, deserializationContext);
            JsonNode put = objectNode.put(currentName, deserializeAny);
            if (put != null) {
                _handleDuplicateField(currentName, objectNode, put, deserializeAny);
            }
            currentToken = jsonParser.nextToken();
        }
        return objectNode;
    }

    @Override // org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserializeWithType */
    public Object mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }
}
