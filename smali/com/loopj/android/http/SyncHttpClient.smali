.class public abstract Lcom/loopj/android/http/SyncHttpClient;
.super Lcom/loopj/android/http/AsyncHttpClient;


# instance fields
.field private responseCode:I

.field responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

.field private result:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/loopj/android/http/AsyncHttpClient;-><init>()V

    new-instance v0, Lcom/loopj/android/http/SyncHttpClient$1;

    invoke-direct {v0, p0}, Lcom/loopj/android/http/SyncHttpClient$1;-><init>(Lcom/loopj/android/http/SyncHttpClient;)V

    iput-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    return-void
.end method

.method static synthetic access$002(Lcom/loopj/android/http/SyncHttpClient;I)I
    .locals 0

    iput p1, p0, Lcom/loopj/android/http/SyncHttpClient;->responseCode:I

    return p1
.end method

.method static synthetic access$102(Lcom/loopj/android/http/SyncHttpClient;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    iput-object p1, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object p1
.end method


# virtual methods
.method public delete(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, v0, v1}, Lcom/loopj/android/http/SyncHttpClient;->delete(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public delete(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, p2, v0}, Lcom/loopj/android/http/SyncHttpClient;->delete(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public delete(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V
    .locals 0

    invoke-virtual {p0, p1, p3}, Lcom/loopj/android/http/SyncHttpClient;->delete(Ljava/lang/String;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    return-void
.end method

.method public get(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, v0, v1}, Lcom/loopj/android/http/SyncHttpClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, p2, v0}, Lcom/loopj/android/http/SyncHttpClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public getResponseCode()I
    .locals 1

    iget v0, p0, Lcom/loopj/android/http/SyncHttpClient;->responseCode:I

    return v0
.end method

.method public abstract onRequestFailed(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public post(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, v0, v1}, Lcom/loopj/android/http/SyncHttpClient;->post(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public post(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, p2, v0}, Lcom/loopj/android/http/SyncHttpClient;->post(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public put(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, v0, v1}, Lcom/loopj/android/http/SyncHttpClient;->put(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method public put(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->responseHandler:Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-virtual {p0, p1, p2, v0}, Lcom/loopj/android/http/SyncHttpClient;->put(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    iget-object v0, p0, Lcom/loopj/android/http/SyncHttpClient;->result:Ljava/lang/String;

    return-object v0
.end method

.method protected sendRequest(Lorg/apache/http/impl/client/DefaultHttpClient;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/client/methods/HttpUriRequest;Ljava/lang/String;Lcom/loopj/android/http/AsyncHttpResponseHandler;Landroid/content/Context;)V
    .locals 1

    if-eqz p4, :cond_0

    const-string v0, "Content-Type"

    invoke-interface {p3, v0, p4}, Lorg/apache/http/client/methods/HttpUriRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    new-instance v0, Lcom/loopj/android/http/AsyncHttpRequest;

    invoke-direct {v0, p1, p2, p3, p5}, Lcom/loopj/android/http/AsyncHttpRequest;-><init>(Lorg/apache/http/impl/client/AbstractHttpClient;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/client/methods/HttpUriRequest;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    invoke-virtual {v0}, Lcom/loopj/android/http/AsyncHttpRequest;->run()V

    return-void
.end method
