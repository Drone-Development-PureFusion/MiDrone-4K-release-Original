package com.xiaomi.infra.galaxy.fds.android.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
/* loaded from: classes2.dex */
public class UserParam {
    protected final Map<String, String> params = new HashMap();

    public Map<String, String> getParams() {
        return Collections.unmodifiableMap(this.params);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator<Map.Entry<String, String>> it2 = this.params.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it2.hasNext()) {
                Map.Entry<String, String> next = it2.next();
                if (i2 != 0) {
                    sb.append('&');
                }
                sb.append(next.getKey());
                String value = next.getValue();
                if (value != null) {
                    sb.append(SignatureVisitor.INSTANCEOF);
                    sb.append(value);
                }
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }
}
