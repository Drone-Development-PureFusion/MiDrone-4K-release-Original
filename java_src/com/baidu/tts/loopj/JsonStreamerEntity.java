package com.baidu.tts.loopj;

import android.text.TextUtils;
import com.baidu.tts.loopj.RequestParams;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final String LOG_TAG = "JsonStreamerEntity";
    private final Header contentEncoding;
    private final byte[] elapsedField;
    private final ResponseHandlerInterface progressHandler;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final byte[] JSON_TRUE = "true".getBytes();
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = "null".getBytes();
    private static final byte[] STREAM_NAME = escape("name");
    private static final byte[] STREAM_TYPE = escape("type");
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", RequestParams.APPLICATION_JSON);
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
    private final byte[] buffer = new byte[4096];
    private final Map<String, Object> jsonParams = new HashMap();

    public JsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface, boolean z, String str) {
        byte[] bArr = null;
        this.progressHandler = responseHandlerInterface;
        this.contentEncoding = z ? HEADER_GZIP_ENCODING : null;
        this.elapsedField = !TextUtils.isEmpty(str) ? escape(str) : bArr;
    }

    private void endMetaData(OutputStream outputStream) {
        outputStream.write(34);
    }

    static byte[] escape(String str) {
        if (str == null) {
            return JSON_NULL;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append('\"');
        int length = str.length();
        int i = -1;
        while (true) {
            int i2 = i + 1;
            if (i2 >= length) {
                sb.append('\"');
                return sb.toString().getBytes();
            }
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("\\\"");
                    break;
                case Opcodes.DUP2 /* 92 */:
                    sb.append("\\\\");
                    break;
                default:
                    if (charAt <= 31 || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                        String hexString = Integer.toHexString(charAt);
                        sb.append("\\u");
                        int length2 = 4 - hexString.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            sb.append('0');
                        }
                        sb.append(hexString.toUpperCase(Locale.US));
                        break;
                    } else {
                        sb.append(charAt);
                        break;
                    }
                    break;
            }
            i = i2;
        }
    }

    private void writeMetaData(OutputStream outputStream, String str, String str2) {
        outputStream.write(STREAM_NAME);
        outputStream.write(58);
        outputStream.write(escape(str));
        outputStream.write(44);
        outputStream.write(STREAM_TYPE);
        outputStream.write(58);
        outputStream.write(escape(str2));
        outputStream.write(44);
        outputStream.write(STREAM_CONTENTS);
        outputStream.write(58);
        outputStream.write(34);
    }

    private void writeToFromFile(OutputStream outputStream, RequestParams.FileWrapper fileWrapper) {
        writeMetaData(outputStream, fileWrapper.file.getName(), fileWrapper.contentType);
        long j = 0;
        long length = fileWrapper.file.length();
        FileInputStream fileInputStream = new FileInputStream(fileWrapper.file);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        while (true) {
            int read = fileInputStream.read(this.buffer);
            if (read == -1) {
                AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
                endMetaData(outputStream);
                AsyncHttpClient.silentCloseInputStream(fileInputStream);
                return;
            }
            base64OutputStream.write(this.buffer, 0, read);
            j += read;
            this.progressHandler.sendProgressMessage(j, length);
        }
    }

    private void writeToFromStream(OutputStream outputStream, RequestParams.StreamWrapper streamWrapper) {
        writeMetaData(outputStream, streamWrapper.name, streamWrapper.contentType);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        while (true) {
            int read = streamWrapper.inputStream.read(this.buffer);
            if (read == -1) {
                break;
            }
            base64OutputStream.write(this.buffer, 0, read);
        }
        AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
        endMetaData(outputStream);
        if (streamWrapper.autoClose) {
            AsyncHttpClient.silentCloseInputStream(streamWrapper.inputStream);
        }
    }

    public void addPart(String str, Object obj) {
        this.jsonParams.put(str, obj);
    }

    public void consumeContent() {
    }

    public InputStream getContent() {
        throw ERR_UNSUPPORTED;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return -1L;
    }

    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.contentEncoding != null) {
            outputStream = new GZIPOutputStream(outputStream, 4096);
        }
        outputStream.write(Opcodes.LSHR);
        Set<String> keySet = this.jsonParams.keySet();
        int size = keySet.size();
        if (size > 0) {
            int i = 0;
            for (String str : keySet) {
                int i2 = i + 1;
                try {
                    Object obj = this.jsonParams.get(str);
                    outputStream.write(escape(str));
                    outputStream.write(58);
                    if (obj == null) {
                        outputStream.write(JSON_NULL);
                    } else {
                        boolean z = obj instanceof RequestParams.FileWrapper;
                        if (z || (obj instanceof RequestParams.StreamWrapper)) {
                            outputStream.write(Opcodes.LSHR);
                            if (z) {
                                writeToFromFile(outputStream, (RequestParams.FileWrapper) obj);
                            } else {
                                writeToFromStream(outputStream, (RequestParams.StreamWrapper) obj);
                            }
                            outputStream.write(125);
                        } else if (obj instanceof JsonValueInterface) {
                            outputStream.write(((JsonValueInterface) obj).getEscapedJsonValue());
                        } else if (obj instanceof JSONObject) {
                            outputStream.write(obj.toString().getBytes());
                        } else if (obj instanceof JSONArray) {
                            outputStream.write(obj.toString().getBytes());
                        } else if (obj instanceof Boolean) {
                            outputStream.write(((Boolean) obj).booleanValue() ? JSON_TRUE : JSON_FALSE);
                        } else if (obj instanceof Long) {
                            outputStream.write((((Number) obj).longValue() + "").getBytes());
                        } else if (obj instanceof Double) {
                            outputStream.write((((Number) obj).doubleValue() + "").getBytes());
                        } else if (obj instanceof Float) {
                            outputStream.write((((Number) obj).floatValue() + "").getBytes());
                        } else if (obj instanceof Integer) {
                            outputStream.write((((Number) obj).intValue() + "").getBytes());
                        } else {
                            outputStream.write(escape(obj.toString()));
                        }
                    }
                    i = i2;
                } finally {
                    if (this.elapsedField != null || i2 < size) {
                        outputStream.write(44);
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.elapsedField != null) {
                outputStream.write(this.elapsedField);
                outputStream.write(58);
                outputStream.write((currentTimeMillis2 + "").getBytes());
            }
            AsyncHttpClient.log.mo14719i(LOG_TAG, "Uploaded JSON in " + Math.floor(currentTimeMillis2 / 1000) + " seconds");
        }
        outputStream.write(125);
        outputStream.flush();
        AsyncHttpClient.silentCloseOutputStream(outputStream);
    }
}
