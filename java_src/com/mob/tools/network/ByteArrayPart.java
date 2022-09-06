package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class ByteArrayPart extends HTTPPart {
    private BufferedByteArrayOutputStream buffer;

    public ByteArrayPart append(byte[] bArr) {
        if (this.buffer == null) {
            this.buffer = new BufferedByteArrayOutputStream(bArr.length);
        }
        this.buffer.write(bArr);
        this.buffer.flush();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() {
        if (this.buffer == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        byte[] buffer = this.buffer.getBuffer();
        return (buffer == null || this.buffer.size() <= 0) ? new ByteArrayInputStream(new byte[0]) : new ByteArrayInputStream(buffer, 0, this.buffer.size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.network.HTTPPart
    public long length() {
        if (this.buffer == null) {
            return 0L;
        }
        return this.buffer.size();
    }

    public String toString() {
        byte[] buffer;
        if (this.buffer == null || (buffer = this.buffer.getBuffer()) == null) {
            return null;
        }
        return Data.byteToHex(buffer, 0, this.buffer.size());
    }
}
