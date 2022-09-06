package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MultiPart extends HTTPPart {
    private ArrayList<HTTPPart> parts = new ArrayList<>();

    public MultiPart append(HTTPPart hTTPPart) {
        this.parts.add(hTTPPart);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() {
        MultiPartInputStream multiPartInputStream = new MultiPartInputStream();
        Iterator<HTTPPart> it2 = this.parts.iterator();
        while (it2.hasNext()) {
            multiPartInputStream.addInputStream(it2.next().getInputStream());
        }
        return multiPartInputStream;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.network.HTTPPart
    public long length() {
        long j = 0;
        Iterator<HTTPPart> it2 = this.parts.iterator();
        while (true) {
            long j2 = j;
            if (it2.hasNext()) {
                j = it2.next().length() + j2;
            } else {
                return j2;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<HTTPPart> it2 = this.parts.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().toString());
        }
        return sb.toString();
    }
}
