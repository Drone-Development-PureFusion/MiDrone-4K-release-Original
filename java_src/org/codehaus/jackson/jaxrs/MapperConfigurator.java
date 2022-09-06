package org.codehaus.jackson.jaxrs;

import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.p317xc.JaxbAnnotationIntrospector;
/* loaded from: classes2.dex */
public class MapperConfigurator {
    protected Annotations[] _defaultAnnotationsToUse;
    protected ObjectMapper _defaultMapper;
    protected Class<? extends AnnotationIntrospector> _jaxbIntrospectorClass;
    protected ObjectMapper _mapper;

    public MapperConfigurator(ObjectMapper objectMapper, Annotations[] annotationsArr) {
        this._mapper = objectMapper;
        this._defaultAnnotationsToUse = annotationsArr;
    }

    protected AnnotationIntrospector _resolveIntrospector(Annotations annotations) {
        switch (annotations) {
            case JACKSON:
                return new JacksonAnnotationIntrospector();
            case JAXB:
                try {
                    if (this._jaxbIntrospectorClass == null) {
                        this._jaxbIntrospectorClass = JaxbAnnotationIntrospector.class;
                    }
                    return this._jaxbIntrospectorClass.newInstance();
                } catch (Exception e) {
                    throw new IllegalStateException("Failed to instantiate JaxbAnnotationIntrospector: " + e.getMessage(), e);
                }
            default:
                throw new IllegalStateException();
        }
    }

    protected AnnotationIntrospector _resolveIntrospectors(Annotations[] annotationsArr) {
        ArrayList arrayList = new ArrayList();
        for (Annotations annotations : annotationsArr) {
            if (annotations != null) {
                arrayList.add(_resolveIntrospector(annotations));
            }
        }
        if (arrayList.size() == 0) {
            return AnnotationIntrospector.nopInstance();
        }
        int size = arrayList.size();
        AnnotationIntrospector annotationIntrospector = (AnnotationIntrospector) arrayList.get(0);
        for (int i = 1; i < size; i++) {
            annotationIntrospector = AnnotationIntrospector.pair(annotationIntrospector, (AnnotationIntrospector) arrayList.get(i));
        }
        return annotationIntrospector;
    }

    protected void _setAnnotations(ObjectMapper objectMapper, Annotations[] annotationsArr) {
        AnnotationIntrospector nopInstance = (annotationsArr == null || annotationsArr.length == 0) ? AnnotationIntrospector.nopInstance() : _resolveIntrospectors(annotationsArr);
        objectMapper.getDeserializationConfig().setAnnotationIntrospector(nopInstance);
        objectMapper.getSerializationConfig().setAnnotationIntrospector(nopInstance);
    }

    public synchronized void configure(JsonGenerator.Feature feature, boolean z) {
        mapper().configure(feature, z);
    }

    public synchronized void configure(JsonParser.Feature feature, boolean z) {
        mapper().configure(feature, z);
    }

    public synchronized void configure(DeserializationConfig.Feature feature, boolean z) {
        mapper().configure(feature, z);
    }

    public synchronized void configure(SerializationConfig.Feature feature, boolean z) {
        mapper().configure(feature, z);
    }

    public synchronized ObjectMapper getConfiguredMapper() {
        return this._mapper;
    }

    public synchronized ObjectMapper getDefaultMapper() {
        if (this._defaultMapper == null) {
            this._defaultMapper = new ObjectMapper();
            _setAnnotations(this._defaultMapper, this._defaultAnnotationsToUse);
        }
        return this._defaultMapper;
    }

    protected ObjectMapper mapper() {
        if (this._mapper == null) {
            this._mapper = new ObjectMapper();
            _setAnnotations(this._mapper, this._defaultAnnotationsToUse);
        }
        return this._mapper;
    }

    public synchronized void setAnnotationsToUse(Annotations[] annotationsArr) {
        _setAnnotations(mapper(), annotationsArr);
    }

    public synchronized void setMapper(ObjectMapper objectMapper) {
        this._mapper = objectMapper;
    }
}
