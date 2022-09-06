package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
/* loaded from: classes2.dex */
public interface VisibilityChecker<T extends VisibilityChecker<T>> {

    @JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility = JsonAutoDetect.Visibility.ANY)
    /* loaded from: classes.dex */
    public static class Std implements VisibilityChecker<Std> {
        protected static final Std DEFAULT = new Std((JsonAutoDetect) Std.class.getAnnotation(JsonAutoDetect.class));
        protected final JsonAutoDetect.Visibility _creatorMinLevel;
        protected final JsonAutoDetect.Visibility _fieldMinLevel;
        protected final JsonAutoDetect.Visibility _getterMinLevel;
        protected final JsonAutoDetect.Visibility _isGetterMinLevel;
        protected final JsonAutoDetect.Visibility _setterMinLevel;

        public Std(JsonAutoDetect.Visibility visibility, JsonAutoDetect.Visibility visibility2, JsonAutoDetect.Visibility visibility3, JsonAutoDetect.Visibility visibility4, JsonAutoDetect.Visibility visibility5) {
            this._getterMinLevel = visibility;
            this._isGetterMinLevel = visibility2;
            this._setterMinLevel = visibility3;
            this._creatorMinLevel = visibility4;
            this._fieldMinLevel = visibility5;
        }

        public Std(JsonAutoDetect jsonAutoDetect) {
            JsonMethod[] value = jsonAutoDetect.value();
            this._getterMinLevel = hasMethod(value, JsonMethod.GETTER) ? jsonAutoDetect.getterVisibility() : JsonAutoDetect.Visibility.NONE;
            this._isGetterMinLevel = hasMethod(value, JsonMethod.IS_GETTER) ? jsonAutoDetect.isGetterVisibility() : JsonAutoDetect.Visibility.NONE;
            this._setterMinLevel = hasMethod(value, JsonMethod.SETTER) ? jsonAutoDetect.setterVisibility() : JsonAutoDetect.Visibility.NONE;
            this._creatorMinLevel = hasMethod(value, JsonMethod.CREATOR) ? jsonAutoDetect.creatorVisibility() : JsonAutoDetect.Visibility.NONE;
            this._fieldMinLevel = hasMethod(value, JsonMethod.FIELD) ? jsonAutoDetect.fieldVisibility() : JsonAutoDetect.Visibility.NONE;
        }

        public static Std defaultInstance() {
            return DEFAULT;
        }

        private static boolean hasMethod(JsonMethod[] jsonMethodArr, JsonMethod jsonMethod) {
            for (JsonMethod jsonMethod2 : jsonMethodArr) {
                if (jsonMethod2 == jsonMethod || jsonMethod2 == JsonMethod.ALL) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isCreatorVisible(Member member) {
            return this._creatorMinLevel.isVisible(member);
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isCreatorVisible(AnnotatedMember annotatedMember) {
            return isCreatorVisible(annotatedMember.getMember());
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isFieldVisible(Field field) {
            return this._fieldMinLevel.isVisible(field);
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isFieldVisible(AnnotatedField annotatedField) {
            return isFieldVisible(annotatedField.mo21976getAnnotated());
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isGetterVisible(Method method) {
            return this._getterMinLevel.isVisible(method);
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isGetterVisible(AnnotatedMethod annotatedMethod) {
            return isGetterVisible(annotatedMethod.mo21976getAnnotated());
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isIsGetterVisible(Method method) {
            return this._isGetterMinLevel.isVisible(method);
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isIsGetterVisible(AnnotatedMethod annotatedMethod) {
            return isIsGetterVisible(annotatedMethod.mo21976getAnnotated());
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isSetterVisible(Method method) {
            return this._setterMinLevel.isVisible(method);
        }

        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        public boolean isSetterVisible(AnnotatedMethod annotatedMethod) {
            return isSetterVisible(annotatedMethod.mo21976getAnnotated());
        }

        public String toString() {
            return "[Visibility: getter: " + this._getterMinLevel + ", isGetter: " + this._isGetterMinLevel + ", setter: " + this._setterMinLevel + ", creator: " + this._creatorMinLevel + ", field: " + this._fieldMinLevel + "]";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        /* renamed from: with */
        public Std mo21978with(JsonAutoDetect jsonAutoDetect) {
            if (jsonAutoDetect == null) {
                return this;
            }
            JsonMethod[] value = jsonAutoDetect.value();
            return mo21981withGetterVisibility(hasMethod(value, JsonMethod.GETTER) ? jsonAutoDetect.getterVisibility() : JsonAutoDetect.Visibility.NONE).mo21982withIsGetterVisibility(hasMethod(value, JsonMethod.IS_GETTER) ? jsonAutoDetect.isGetterVisibility() : JsonAutoDetect.Visibility.NONE).mo21983withSetterVisibility(hasMethod(value, JsonMethod.SETTER) ? jsonAutoDetect.setterVisibility() : JsonAutoDetect.Visibility.NONE).mo21979withCreatorVisibility(hasMethod(value, JsonMethod.CREATOR) ? jsonAutoDetect.creatorVisibility() : JsonAutoDetect.Visibility.NONE).mo21980withFieldVisibility(hasMethod(value, JsonMethod.FIELD) ? jsonAutoDetect.fieldVisibility() : JsonAutoDetect.Visibility.NONE);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        /* renamed from: withCreatorVisibility */
        public Std mo21979withCreatorVisibility(JsonAutoDetect.Visibility visibility) {
            JsonAutoDetect.Visibility visibility2 = visibility == JsonAutoDetect.Visibility.DEFAULT ? DEFAULT._creatorMinLevel : visibility;
            return this._creatorMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, visibility2, this._fieldMinLevel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        /* renamed from: withFieldVisibility */
        public Std mo21980withFieldVisibility(JsonAutoDetect.Visibility visibility) {
            JsonAutoDetect.Visibility visibility2 = visibility == JsonAutoDetect.Visibility.DEFAULT ? DEFAULT._fieldMinLevel : visibility;
            return this._fieldMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, visibility2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        /* renamed from: withGetterVisibility */
        public Std mo21981withGetterVisibility(JsonAutoDetect.Visibility visibility) {
            JsonAutoDetect.Visibility visibility2 = visibility == JsonAutoDetect.Visibility.DEFAULT ? DEFAULT._getterMinLevel : visibility;
            return this._getterMinLevel == visibility2 ? this : new Std(visibility2, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        /* renamed from: withIsGetterVisibility */
        public Std mo21982withIsGetterVisibility(JsonAutoDetect.Visibility visibility) {
            JsonAutoDetect.Visibility visibility2 = visibility == JsonAutoDetect.Visibility.DEFAULT ? DEFAULT._isGetterMinLevel : visibility;
            return this._isGetterMinLevel == visibility2 ? this : new Std(this._getterMinLevel, visibility2, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.codehaus.jackson.map.introspect.VisibilityChecker
        /* renamed from: withSetterVisibility */
        public Std mo21983withSetterVisibility(JsonAutoDetect.Visibility visibility) {
            JsonAutoDetect.Visibility visibility2 = visibility == JsonAutoDetect.Visibility.DEFAULT ? DEFAULT._setterMinLevel : visibility;
            return this._setterMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, visibility2, this._creatorMinLevel, this._fieldMinLevel);
        }
    }

    boolean isCreatorVisible(Member member);

    boolean isCreatorVisible(AnnotatedMember annotatedMember);

    boolean isFieldVisible(Field field);

    boolean isFieldVisible(AnnotatedField annotatedField);

    boolean isGetterVisible(Method method);

    boolean isGetterVisible(AnnotatedMethod annotatedMethod);

    boolean isIsGetterVisible(Method method);

    boolean isIsGetterVisible(AnnotatedMethod annotatedMethod);

    boolean isSetterVisible(Method method);

    boolean isSetterVisible(AnnotatedMethod annotatedMethod);

    /* renamed from: with */
    T mo21978with(JsonAutoDetect jsonAutoDetect);

    /* renamed from: withCreatorVisibility */
    T mo21979withCreatorVisibility(JsonAutoDetect.Visibility visibility);

    /* renamed from: withFieldVisibility */
    T mo21980withFieldVisibility(JsonAutoDetect.Visibility visibility);

    /* renamed from: withGetterVisibility */
    T mo21981withGetterVisibility(JsonAutoDetect.Visibility visibility);

    /* renamed from: withIsGetterVisibility */
    T mo21982withIsGetterVisibility(JsonAutoDetect.Visibility visibility);

    /* renamed from: withSetterVisibility */
    T mo21983withSetterVisibility(JsonAutoDetect.Visibility visibility);
}
