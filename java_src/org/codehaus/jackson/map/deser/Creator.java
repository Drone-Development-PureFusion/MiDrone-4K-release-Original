package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
abstract class Creator {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Delegating {
        protected final AnnotatedMember _creator;
        protected final Constructor<?> _ctor;
        protected JsonDeserializer<Object> _deserializer;
        protected final Method _factoryMethod;
        protected final JavaType _valueType;

        public Delegating(BasicBeanDescription basicBeanDescription, AnnotatedConstructor annotatedConstructor, AnnotatedMethod annotatedMethod) {
            TypeBindings bindingsForBeanType = basicBeanDescription.bindingsForBeanType();
            if (annotatedConstructor != null) {
                this._creator = annotatedConstructor;
                this._ctor = annotatedConstructor.mo21976getAnnotated();
                this._factoryMethod = null;
                this._valueType = bindingsForBeanType.resolveType(annotatedConstructor.getParameterType(0));
            } else if (annotatedMethod == null) {
                throw new IllegalArgumentException("Internal error: neither delegating constructor nor factory method passed");
            } else {
                this._creator = annotatedMethod;
                this._ctor = null;
                this._factoryMethod = annotatedMethod.mo21976getAnnotated();
                this._valueType = bindingsForBeanType.resolveType(annotatedMethod.getParameterType(0));
            }
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Object obj = null;
            Object mo22015deserialize = this._deserializer.mo22015deserialize(jsonParser, deserializationContext);
            try {
                obj = this._ctor != null ? this._ctor.newInstance(mo22015deserialize) : this._factoryMethod.invoke(null, mo22015deserialize);
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
            }
            return obj;
        }

        public AnnotatedMember getCreator() {
            return this._creator;
        }

        public JavaType getValueType() {
            return this._valueType;
        }

        public void setDeserializer(JsonDeserializer<Object> jsonDeserializer) {
            this._deserializer = jsonDeserializer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class NumberBased {
        protected final Constructor<?> _intCtor;
        protected final Method _intFactoryMethod;
        protected final Constructor<?> _longCtor;
        protected final Method _longFactoryMethod;
        protected final Class<?> _valueClass;

        public NumberBased(Class<?> cls, AnnotatedConstructor annotatedConstructor, AnnotatedMethod annotatedMethod, AnnotatedConstructor annotatedConstructor2, AnnotatedMethod annotatedMethod2) {
            Method method = null;
            this._valueClass = cls;
            this._intCtor = annotatedConstructor == null ? null : annotatedConstructor.mo21976getAnnotated();
            this._longCtor = annotatedConstructor2 == null ? null : annotatedConstructor2.mo21976getAnnotated();
            this._intFactoryMethod = annotatedMethod == null ? null : annotatedMethod.mo21976getAnnotated();
            this._longFactoryMethod = annotatedMethod2 != null ? annotatedMethod2.mo21976getAnnotated() : method;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0030 -> B:5:0x0014). Please submit an issue!!! */
        public Object construct(int i) {
            try {
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
            }
            if (this._intCtor != null) {
                return this._intCtor.newInstance(Integer.valueOf(i));
            }
            if (this._intFactoryMethod != null) {
                return this._intFactoryMethod.invoke(this._valueClass, Integer.valueOf(i));
            }
            return construct(i);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0030 -> B:5:0x0014). Please submit an issue!!! */
        public Object construct(long j) {
            try {
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
            }
            if (this._longCtor != null) {
                return this._longCtor.newInstance(Long.valueOf(j));
            }
            if (this._longFactoryMethod != null) {
                return this._longFactoryMethod.invoke(this._valueClass, Long.valueOf(j));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class PropertyBased {
        protected final Constructor<?> _ctor;
        protected final Object[] _defaultValues;
        protected final Method _factoryMethod;
        protected final HashMap<String, SettableBeanProperty> _properties;

        public PropertyBased(AnnotatedConstructor annotatedConstructor, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedMethod annotatedMethod, SettableBeanProperty[] settableBeanPropertyArr2) {
            if (annotatedConstructor != null) {
                this._ctor = annotatedConstructor.mo21976getAnnotated();
                this._factoryMethod = null;
            } else if (annotatedMethod == null) {
                throw new IllegalArgumentException("Internal error: neither delegating constructor nor factory method passed");
            } else {
                this._ctor = null;
                this._factoryMethod = annotatedMethod.mo21976getAnnotated();
                settableBeanPropertyArr = settableBeanPropertyArr2;
            }
            this._properties = new HashMap<>();
            int length = settableBeanPropertyArr.length;
            Object[] objArr = null;
            for (int i = 0; i < length; i++) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                this._properties.put(settableBeanProperty.getName(), settableBeanProperty);
                if (settableBeanProperty.getType().isPrimitive()) {
                    objArr = objArr == null ? new Object[length] : objArr;
                    objArr[i] = ClassUtil.defaultValue(settableBeanProperty.getType().getRawClass());
                }
            }
            this._defaultValues = objArr;
        }

        public Object build(PropertyValueBuffer propertyValueBuffer) {
            Object obj = null;
            try {
                obj = this._ctor != null ? this._ctor.newInstance(propertyValueBuffer.getParameters(this._defaultValues)) : this._factoryMethod.invoke(null, propertyValueBuffer.getParameters(this._defaultValues));
                for (PropertyValue buffered = propertyValueBuffer.buffered(); buffered != null; buffered = buffered.next) {
                    buffered.assign(obj);
                }
            } catch (Exception e) {
                ClassUtil.throwRootCause(e);
            }
            return obj;
        }

        public SettableBeanProperty findCreatorProperty(String str) {
            return this._properties.get(str);
        }

        public Collection<SettableBeanProperty> properties() {
            return this._properties.values();
        }

        public PropertyValueBuffer startBuilding(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new PropertyValueBuffer(jsonParser, deserializationContext, this._properties.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class StringBased {
        protected final Constructor<?> _ctor;
        protected final Method _factoryMethod;
        protected final Class<?> _valueClass;

        public StringBased(Class<?> cls, AnnotatedConstructor annotatedConstructor, AnnotatedMethod annotatedMethod) {
            Method method = null;
            this._valueClass = cls;
            this._ctor = annotatedConstructor == null ? null : annotatedConstructor.mo21976getAnnotated();
            this._factoryMethod = annotatedMethod != null ? annotatedMethod.mo21976getAnnotated() : method;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0028 -> B:5:0x0010). Please submit an issue!!! */
        public Object construct(String str) {
            try {
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
            }
            if (this._ctor != null) {
                return this._ctor.newInstance(str);
            }
            if (this._factoryMethod != null) {
                return this._factoryMethod.invoke(this._valueClass, str);
            }
            return null;
        }
    }

    private Creator() {
    }
}
