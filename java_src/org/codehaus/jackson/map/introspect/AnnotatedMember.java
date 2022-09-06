package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Member;
import org.codehaus.jackson.map.util.ClassUtil;
/* loaded from: classes2.dex */
public abstract class AnnotatedMember extends Annotated {
    public final void fixAccess() {
        ClassUtil.checkAndFixAccess(getMember());
    }

    public abstract Class<?> getDeclaringClass();

    public abstract Member getMember();
}
