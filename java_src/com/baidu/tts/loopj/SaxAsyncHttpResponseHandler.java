package com.baidu.tts.loopj;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
/* loaded from: classes.dex */
public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "SaxAsyncHttpRH";
    private T handler;

    public SaxAsyncHttpResponseHandler(T t) {
        this.handler = null;
        if (t == null) {
            throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
        }
        this.handler = t;
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity httpEntity) {
        InputStreamReader inputStreamReader;
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            try {
                if (content != null) {
                    try {
                        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                        xMLReader.setContentHandler(this.handler);
                        inputStreamReader = new InputStreamReader(content, getCharset());
                        try {
                            xMLReader.parse(new InputSource(inputStreamReader));
                            AsyncHttpClient.silentCloseInputStream(content);
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (ParserConfigurationException e2) {
                            e = e2;
                            AsyncHttpClient.log.mo14720e(LOG_TAG, "getResponseData exception", e);
                            AsyncHttpClient.silentCloseInputStream(content);
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e3) {
                                }
                            }
                            return null;
                        } catch (SAXException e4) {
                            e = e4;
                            AsyncHttpClient.log.mo14720e(LOG_TAG, "getResponseData exception", e);
                            AsyncHttpClient.silentCloseInputStream(content);
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e5) {
                                }
                            }
                            return null;
                        }
                    } catch (ParserConfigurationException e6) {
                        e = e6;
                        inputStreamReader = null;
                    } catch (SAXException e7) {
                        e = e7;
                        inputStreamReader = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = null;
                        AsyncHttpClient.silentCloseInputStream(content);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public abstract void onFailure(int i, Header[] headerArr, T t);

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i, headerArr, this.handler);
    }

    public abstract void onSuccess(int i, Header[] headerArr, T t);

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, (Header[]) this.handler);
    }
}
