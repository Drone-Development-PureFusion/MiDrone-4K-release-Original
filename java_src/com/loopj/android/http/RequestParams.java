package com.loopj.android.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class RequestParams {
    private static String ENCODING = "UTF-8";
    protected ConcurrentHashMap<String, FileWrapper> fileParams;
    protected ConcurrentHashMap<String, String> urlParams;
    protected ConcurrentHashMap<String, ArrayList<String>> urlParamsWithArray;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FileWrapper {
        public String contentType;
        public String fileName;
        public InputStream inputStream;

        public FileWrapper(InputStream inputStream, String str, String str2) {
            this.inputStream = inputStream;
            this.fileName = str;
            this.contentType = str2;
        }

        public String getFileName() {
            return this.fileName != null ? this.fileName : "nofilename";
        }
    }

    public RequestParams() {
        init();
    }

    public RequestParams(String str, String str2) {
        init();
        put(str, str2);
    }

    public RequestParams(Map<String, String> map) {
        init();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public RequestParams(Object... objArr) {
        init();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < length; i += 2) {
            put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
        }
    }

    private void init() {
        this.urlParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.urlParamsWithArray = new ConcurrentHashMap<>();
    }

    public HttpEntity getEntity() {
        if (this.fileParams.isEmpty()) {
            try {
                return new UrlEncodedFormEntity(getParamsList(), ENCODING);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleMultipartEntity simpleMultipartEntity = new SimpleMultipartEntity();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            simpleMultipartEntity.addPart(entry.getKey(), entry.getValue());
        }
        int size = this.fileParams.entrySet().size() - 1;
        int i = 0;
        for (Map.Entry<String, FileWrapper> entry2 : this.fileParams.entrySet()) {
            FileWrapper value = entry2.getValue();
            if (value.inputStream != null) {
                boolean z = i == size;
                if (value.contentType != null) {
                    simpleMultipartEntity.addPart(entry2.getKey(), value.getFileName(), value.inputStream, value.contentType, z);
                } else {
                    simpleMultipartEntity.addPart(entry2.getKey(), value.getFileName(), value.inputStream, z);
                }
            }
            i++;
        }
        for (Map.Entry<String, ArrayList<String>> entry3 : this.urlParamsWithArray.entrySet()) {
            Iterator<String> it2 = entry3.getValue().iterator();
            while (it2.hasNext()) {
                simpleMultipartEntity.addPart(entry3.getKey(), it2.next());
            }
        }
        return simpleMultipartEntity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getParamString() {
        return URLEncodedUtils.format(getParamsList(), ENCODING);
    }

    protected List<BasicNameValuePair> getParamsList() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, ArrayList<String>> entry2 : this.urlParamsWithArray.entrySet()) {
            Iterator<String> it2 = entry2.getValue().iterator();
            while (it2.hasNext()) {
                linkedList.add(new BasicNameValuePair(entry2.getKey(), it2.next()));
            }
        }
        return linkedList;
    }

    public void put(String str, File file) {
        put(str, new FileInputStream(file), file.getName());
    }

    public void put(String str, InputStream inputStream) {
        put(str, inputStream, null);
    }

    public void put(String str, InputStream inputStream, String str2) {
        put(str, inputStream, str2, null);
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        if (str == null || inputStream == null) {
            return;
        }
        this.fileParams.put(str, new FileWrapper(inputStream, str2, str3));
    }

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.urlParams.put(str, str2);
    }

    public void put(String str, ArrayList<String> arrayList) {
        if (str == null || arrayList == null) {
            return;
        }
        this.urlParamsWithArray.put(str, arrayList);
    }

    public void remove(String str) {
        this.urlParams.remove(str);
        this.fileParams.remove(str);
        this.urlParamsWithArray.remove(str);
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
        for (Map.Entry<String, FileWrapper> entry2 : this.fileParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry<String, ArrayList<String>> entry3 : this.urlParamsWithArray.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            ArrayList<String> value = entry3.getValue();
            Iterator<String> it2 = value.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (value.indexOf(next) != 0) {
                    sb.append("&");
                }
                sb.append(entry3.getKey());
                sb.append("=");
                sb.append(next);
            }
        }
        return sb.toString();
    }
}
