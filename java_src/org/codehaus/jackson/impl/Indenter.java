package org.codehaus.jackson.impl;

import org.codehaus.jackson.JsonGenerator;
/* loaded from: classes2.dex */
public interface Indenter {
    boolean isInline();

    void writeIndentation(JsonGenerator jsonGenerator, int i);
}
