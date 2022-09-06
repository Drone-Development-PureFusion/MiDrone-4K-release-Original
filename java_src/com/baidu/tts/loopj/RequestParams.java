package com.baidu.tts.loopj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class RequestParams implements Serializable {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    protected boolean autoCloseInputStreams;
    protected String contentEncoding;
    protected String elapsedFieldInJsonStreamer;
    protected final ConcurrentHashMap<String, List<FileWrapper>> fileArrayParams;
    protected final ConcurrentHashMap<String, FileWrapper> fileParams;
    protected boolean forceMultipartEntity;
    protected boolean isRepeatable;
    protected final ConcurrentHashMap<String, StreamWrapper> streamParams;
    protected final ConcurrentHashMap<String, String> urlParams;
    protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;
    protected boolean useJsonStreamer;

    /* loaded from: classes.dex */
    public static class FileWrapper implements Serializable {
        public final String contentType;
        public final String customFileName;
        public final File file;

        public FileWrapper(File file, String str, String str2) {
            this.file = file;
            this.contentType = str;
            this.customFileName = str2;
        }
    }

    /* loaded from: classes.dex */
    public static class StreamWrapper {
        public final boolean autoClose;
        public final String contentType;
        public final InputStream inputStream;
        public final String name;

        public StreamWrapper(InputStream inputStream, String str, String str2, boolean z) {
            this.inputStream = inputStream;
            this.name = str;
            this.contentType = str2;
            this.autoClose = z;
        }

        static StreamWrapper newInstance(InputStream inputStream, String str, String str2, boolean z) {
            if (str2 == null) {
                str2 = RequestParams.APPLICATION_OCTET_STREAM;
            }
            return new StreamWrapper(inputStream, str, str2, z);
        }
    }

    public RequestParams() {
        this((Map<String, String>) null);
    }

    public RequestParams(final String str, final String str2) {
        this(new HashMap<String, String>() { // from class: com.baidu.tts.loopj.RequestParams.1
            {
                put(str, str2);
            }
        });
    }

    public RequestParams(Map<String, String> map) {
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.urlParams = new ConcurrentHashMap<>();
        this.streamParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.fileArrayParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        this.contentEncoding = "UTF-8";
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public RequestParams(Object... objArr) {
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.urlParams = new ConcurrentHashMap<>();
        this.streamParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.fileArrayParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        this.contentEncoding = "UTF-8";
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < length; i += 2) {
            put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
        }
    }

    private HttpEntity createFormEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
        } catch (UnsupportedEncodingException e) {
            AsyncHttpClient.log.mo14720e(LOG_TAG, "createFormEntity failed", e);
            return null;
        }
    }

    private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface) {
        JsonStreamerEntity jsonStreamerEntity = new JsonStreamerEntity(responseHandlerInterface, !this.fileParams.isEmpty() || !this.streamParams.isEmpty(), this.elapsedFieldInJsonStreamer);
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            jsonStreamerEntity.addPart(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry2 : this.urlParamsWithObjects.entrySet()) {
            jsonStreamerEntity.addPart(entry2.getKey(), entry2.getValue());
        }
        for (Map.Entry<String, FileWrapper> entry3 : this.fileParams.entrySet()) {
            jsonStreamerEntity.addPart(entry3.getKey(), entry3.getValue());
        }
        for (Map.Entry<String, StreamWrapper> entry4 : this.streamParams.entrySet()) {
            StreamWrapper value = entry4.getValue();
            if (value.inputStream != null) {
                jsonStreamerEntity.addPart(entry4.getKey(), StreamWrapper.newInstance(value.inputStream, value.name, value.contentType, value.autoClose));
            }
        }
        return jsonStreamerEntity;
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface responseHandlerInterface) {
        SimpleMultipartEntity simpleMultipartEntity = new SimpleMultipartEntity(responseHandlerInterface);
        simpleMultipartEntity.setIsRepeatable(this.isRepeatable);
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            simpleMultipartEntity.addPartWithCharset(entry.getKey(), entry.getValue(), this.contentEncoding);
        }
        for (BasicNameValuePair basicNameValuePair : getParamsList(null, this.urlParamsWithObjects)) {
            simpleMultipartEntity.addPartWithCharset(basicNameValuePair.getName(), basicNameValuePair.getValue(), this.contentEncoding);
        }
        for (Map.Entry<String, StreamWrapper> entry2 : this.streamParams.entrySet()) {
            StreamWrapper value = entry2.getValue();
            if (value.inputStream != null) {
                simpleMultipartEntity.addPart(entry2.getKey(), value.name, value.inputStream, value.contentType);
            }
        }
        for (Map.Entry<String, FileWrapper> entry3 : this.fileParams.entrySet()) {
            FileWrapper value2 = entry3.getValue();
            simpleMultipartEntity.addPart(entry3.getKey(), value2.file, value2.contentType, value2.customFileName);
        }
        for (Map.Entry<String, List<FileWrapper>> entry4 : this.fileArrayParams.entrySet()) {
            for (FileWrapper fileWrapper : entry4.getValue()) {
                simpleMultipartEntity.addPart(entry4.getKey(), fileWrapper.file, fileWrapper.contentType, fileWrapper.customFileName);
            }
        }
        return simpleMultipartEntity;
    }

    private List<BasicNameValuePair> getParamsList(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(getParamsList(str == null ? (String) obj3 : String.format(Locale.US, "%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.addAll(getParamsList(String.format(Locale.US, "%s[%d]", str, Integer.valueOf(i)), list.get(i)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.addAll(getParamsList(String.format(Locale.US, "%s[%d]", str, Integer.valueOf(i2)), objArr[i2]));
            }
        } else if (obj instanceof Set) {
            for (Object obj4 : (Set) obj) {
                linkedList.addAll(getParamsList(str, obj4));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    public void add(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Object obj = this.urlParamsWithObjects.get(str);
        if (obj == null) {
            obj = new HashSet();
            put(str, obj);
        }
        if (obj instanceof List) {
            ((List) obj).add(str2);
        } else if (!(obj instanceof Set)) {
        } else {
            ((Set) obj).add(str2);
        }
    }

    public HttpEntity getEntity(ResponseHandlerInterface responseHandlerInterface) {
        return this.useJsonStreamer ? createJsonStreamerEntity(responseHandlerInterface) : (this.forceMultipartEntity || !this.streamParams.isEmpty() || !this.fileParams.isEmpty() || !this.fileArrayParams.isEmpty()) ? createMultipartEntity(responseHandlerInterface) : createFormEntity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }

    protected List<BasicNameValuePair> getParamsList() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(getParamsList(null, this.urlParamsWithObjects));
        return linkedList;
    }

    public boolean has(String str) {
        return (this.urlParams.get(str) == null && this.streamParams.get(str) == null && this.fileParams.get(str) == null && this.urlParamsWithObjects.get(str) == null && this.fileArrayParams.get(str) == null) ? false : true;
    }

    public void put(String str, int i) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(i));
        }
    }

    public void put(String str, long j) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(j));
        }
    }

    public void put(String str, File file) {
        put(str, file, (String) null, (String) null);
    }

    public void put(String str, File file, String str2) {
        put(str, file, str2, (String) null);
    }

    public void put(String str, File file, String str2, String str3) {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }
        if (str == null) {
            return;
        }
        this.fileParams.put(str, new FileWrapper(file, str2, str3));
    }

    public void put(String str, InputStream inputStream) {
        put(str, inputStream, (String) null);
    }

    public void put(String str, InputStream inputStream, String str2) {
        put(str, inputStream, str2, (String) null);
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        put(str, inputStream, str2, str3, this.autoCloseInputStreams);
    }

    public void put(String str, InputStream inputStream, String str2, String str3, boolean z) {
        if (str == null || inputStream == null) {
            return;
        }
        this.streamParams.put(str, StreamWrapper.newInstance(inputStream, str2, str3, z));
    }

    public void put(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.urlParamsWithObjects.put(str, obj);
    }

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.urlParams.put(str, str2);
    }

    public void put(String str, String str2, File file) {
        put(str, file, (String) null, str2);
    }

    public void put(String str, File[] fileArr) {
        put(str, fileArr, (String) null, (String) null);
    }

    public void put(String str, File[] fileArr, String str2, String str3) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : fileArr) {
                if (file == null || !file.exists()) {
                    throw new FileNotFoundException();
                }
                arrayList.add(new FileWrapper(file, str2, str3));
            }
            this.fileArrayParams.put(str, arrayList);
        }
    }

    public void remove(String str) {
        this.urlParams.remove(str);
        this.streamParams.remove(str);
        this.fileParams.remove(str);
        this.urlParamsWithObjects.remove(str);
        this.fileArrayParams.remove(str);
    }

    public void setAutoCloseInputStreams(boolean z) {
        this.autoCloseInputStreams = z;
    }

    public void setContentEncoding(String str) {
        if (str != null) {
            this.contentEncoding = str;
        } else {
            AsyncHttpClient.log.mo14723d(LOG_TAG, "setContentEncoding called with null attribute");
        }
    }

    public void setElapsedFieldInJsonStreamer(String str) {
        this.elapsedFieldInJsonStreamer = str;
    }

    public void setForceMultipartEntityContentType(boolean z) {
        this.forceMultipartEntity = z;
    }

    public void setHttpEntityIsRepeatable(boolean z) {
        this.isRepeatable = z;
    }

    public void setUseJsonStreamer(boolean z) {
        this.useJsonStreamer = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, StreamWrapper> entry2 : this.streamParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("STREAM");
        }
        for (Map.Entry<String, FileWrapper> entry3 : this.fileParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry3.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry<String, List<FileWrapper>> entry4 : this.fileArrayParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry4.getKey());
            sb.append("=");
            sb.append("FILES(SIZE=").append(entry4.getValue().size()).append(")");
        }
        for (BasicNameValuePair basicNameValuePair : getParamsList(null, this.urlParamsWithObjects)) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(basicNameValuePair.getName());
            sb.append("=");
            sb.append(basicNameValuePair.getValue());
        }
        return sb.toString();
    }
}
