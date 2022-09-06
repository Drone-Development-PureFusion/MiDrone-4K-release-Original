package com.baidu.tts.p093d.p094a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.RangeFileAsyncHttpResponseHandler;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import java.io.File;
import org.apache.http.Header;
/* renamed from: com.baidu.tts.d.a.g */
/* loaded from: classes.dex */
public class C1677g extends RangeFileAsyncHttpResponseHandler {

    /* renamed from: a */
    private C1673c f5893a;

    public C1677g(File file, C1673c c1673c) {
        super(file);
        this.f5893a = c1673c;
    }

    @Override // com.baidu.tts.loopj.FileAsyncHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, Throwable th, File file) {
        String str = null;
        if (th != null) {
            Throwable cause = th.getCause();
            str = cause == null ? th.getMessage() : cause.getMessage();
        }
        LoggerProxy.m15091d("ModelFileResponseHandler", "onFailure statuscode=" + i + "--msg=" + str);
        this.f5893a.m15028a(C1717c.m14880a().m14876a(EnumC1711n.MODEL_REQUEST_ERROR, i, "download failure", th));
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onProgress(long j, long j2) {
        this.f5893a.m15029a(j, j2);
    }

    @Override // com.baidu.tts.loopj.FileAsyncHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, File file) {
        LoggerProxy.m15091d("ModelFileResponseHandler", "onSuccess");
        this.f5893a.m15023e();
    }
}
