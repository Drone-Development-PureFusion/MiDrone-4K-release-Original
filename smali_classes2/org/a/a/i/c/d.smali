.class Lorg/a/a/i/c/d;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/a/a/f/h;
.implements Lorg/apache/http/protocol/HttpContext;


# annotations
.annotation build Lorg/a/a/a/c;
.end annotation


# instance fields
.field private volatile a:Lorg/a/a/i/c/c;


# direct methods
.method constructor <init>(Lorg/a/a/i/c/c;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    return-void
.end method

.method public static a(Lorg/apache/http/HttpClientConnection;)Lorg/a/a/i/c/c;
    .locals 1

    invoke-static {p0}, Lorg/a/a/i/c/d;->c(Lorg/apache/http/HttpClientConnection;)Lorg/a/a/i/c/d;

    move-result-object v0

    invoke-virtual {v0}, Lorg/a/a/i/c/d;->d()Lorg/a/a/i/c/c;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Lorg/a/a/i/c/e;

    invoke-direct {v0}, Lorg/a/a/i/c/e;-><init>()V

    throw v0

    :cond_0
    return-object v0
.end method

.method public static a(Lorg/a/a/i/c/c;)Lorg/apache/http/HttpClientConnection;
    .locals 1

    new-instance v0, Lorg/a/a/i/c/d;

    invoke-direct {v0, p0}, Lorg/a/a/i/c/d;-><init>(Lorg/a/a/i/c/c;)V

    return-object v0
.end method

.method public static b(Lorg/apache/http/HttpClientConnection;)Lorg/a/a/i/c/c;
    .locals 1

    invoke-static {p0}, Lorg/a/a/i/c/d;->c(Lorg/apache/http/HttpClientConnection;)Lorg/a/a/i/c/d;

    move-result-object v0

    invoke-virtual {v0}, Lorg/a/a/i/c/d;->e()Lorg/a/a/i/c/c;

    move-result-object v0

    return-object v0
.end method

.method private static c(Lorg/apache/http/HttpClientConnection;)Lorg/a/a/i/c/d;
    .locals 3

    const-class v0, Lorg/a/a/i/c/d;

    invoke-virtual {v0, p0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected connection proxy class: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const-class v0, Lorg/a/a/i/c/d;

    invoke-virtual {v0, p0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/a/a/i/c/d;

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/net/Socket;)V
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/a/a/f/h;->a(Ljava/net/Socket;)V

    return-void
.end method

.method public b()Ljava/net/Socket;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->b()Ljava/net/Socket;

    move-result-object v0

    return-object v0
.end method

.method public c()Ljavax/net/ssl/SSLSession;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->c()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    return-object v0
.end method

.method public close()V
    .locals 1

    iget-object v0, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lorg/a/a/i/c/c;->c()V

    :cond_0
    return-void
.end method

.method d()Lorg/a/a/i/c/c;
    .locals 1

    iget-object v0, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    return-object v0
.end method

.method e()Lorg/a/a/i/c/c;
    .locals 2

    iget-object v0, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    const/4 v1, 0x0

    iput-object v1, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    return-object v0
.end method

.method f()Lorg/a/a/f/h;
    .locals 1

    iget-object v0, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {v0}, Lorg/a/a/i/c/c;->i()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/a/a/f/h;

    goto :goto_0
.end method

.method public flush()V
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->flush()V

    return-void
.end method

.method g()Lorg/a/a/f/h;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->f()Lorg/a/a/f/h;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Lorg/a/a/i/c/e;

    invoke-direct {v0}, Lorg/a/a/i/c/e;-><init>()V

    throw v0

    :cond_0
    return-object v0
.end method

.method public getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    instance-of v1, v0, Lorg/apache/http/protocol/HttpContext;

    if-eqz v1, :cond_0

    check-cast v0, Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v0, p1}, Lorg/apache/http/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLocalAddress()Ljava/net/InetAddress;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->getLocalAddress()Ljava/net/InetAddress;

    move-result-object v0

    return-object v0
.end method

.method public getLocalPort()I
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->getLocalPort()I

    move-result v0

    return v0
.end method

.method public getMetrics()Lorg/apache/http/HttpConnectionMetrics;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->getMetrics()Lorg/apache/http/HttpConnectionMetrics;

    move-result-object v0

    return-object v0
.end method

.method public getRemoteAddress()Ljava/net/InetAddress;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->getRemoteAddress()Ljava/net/InetAddress;

    move-result-object v0

    return-object v0
.end method

.method public getRemotePort()I
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->getRemotePort()I

    move-result v0

    return v0
.end method

.method public getSocketTimeout()I
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->getSocketTimeout()I

    move-result v0

    return v0
.end method

.method public isOpen()Z
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lorg/a/a/i/c/c;->e()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public isResponseAvailable(I)Z
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/a/a/f/h;->isResponseAvailable(I)Z

    move-result v0

    return v0
.end method

.method public isStale()Z
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->f()Lorg/a/a/f/h;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Lorg/apache/http/HttpClientConnection;->isStale()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public receiveResponseEntity(Lorg/apache/http/HttpResponse;)V
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/a/a/f/h;->receiveResponseEntity(Lorg/apache/http/HttpResponse;)V

    return-void
.end method

.method public receiveResponseHeader()Lorg/apache/http/HttpResponse;
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0}, Lorg/a/a/f/h;->receiveResponseHeader()Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public removeAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    instance-of v1, v0, Lorg/apache/http/protocol/HttpContext;

    if-eqz v1, :cond_0

    check-cast v0, Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v0, p1}, Lorg/apache/http/protocol/HttpContext;->removeAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public sendRequestEntity(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/a/a/f/h;->sendRequestEntity(Lorg/apache/http/HttpEntityEnclosingRequest;)V

    return-void
.end method

.method public sendRequestHeader(Lorg/apache/http/HttpRequest;)V
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/a/a/f/h;->sendRequestHeader(Lorg/apache/http/HttpRequest;)V

    return-void
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    instance-of v1, v0, Lorg/apache/http/protocol/HttpContext;

    if-eqz v1, :cond_0

    check-cast v0, Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v0, p1, p2}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_0
    return-void
.end method

.method public setSocketTimeout(I)V
    .locals 1

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->g()Lorg/a/a/f/h;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/a/a/f/h;->setSocketTimeout(I)V

    return-void
.end method

.method public shutdown()V
    .locals 1

    iget-object v0, p0, Lorg/a/a/i/c/d;->a:Lorg/a/a/i/c/c;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lorg/a/a/i/c/c;->d()V

    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "CPoolProxy{"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lorg/a/a/i/c/d;->f()Lorg/a/a/f/h;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    :goto_0
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v1, "detached"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
