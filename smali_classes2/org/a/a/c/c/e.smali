.class public abstract Lorg/a/a/c/c/e;
.super Lorg/a/a/c/c/m;

# interfaces
.implements Lorg/apache/http/HttpEntityEnclosingRequest;


# annotations
.annotation build Lorg/a/a/a/c;
.end annotation


# instance fields
.field private a:Lorg/apache/http/HttpEntity;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lorg/a/a/c/c/m;-><init>()V

    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 2

    invoke-super {p0}, Lorg/a/a/c/c/m;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/a/a/c/c/e;

    iget-object v1, p0, Lorg/a/a/c/c/e;->a:Lorg/apache/http/HttpEntity;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/a/a/c/c/e;->a:Lorg/apache/http/HttpEntity;

    invoke-static {v1}, Lorg/a/a/c/f/a;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/http/HttpEntity;

    iput-object v1, v0, Lorg/a/a/c/c/e;->a:Lorg/apache/http/HttpEntity;

    :cond_0
    return-object v0
.end method

.method public expectContinue()Z
    .locals 2

    const-string v0, "Expect"

    invoke-virtual {p0, v0}, Lorg/a/a/c/c/e;->getFirstHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v1, "100-continue"

    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEntity()Lorg/apache/http/HttpEntity;
    .locals 1

    iget-object v0, p0, Lorg/a/a/c/c/e;->a:Lorg/apache/http/HttpEntity;

    return-object v0
.end method

.method public setEntity(Lorg/apache/http/HttpEntity;)V
    .locals 0

    iput-object p1, p0, Lorg/a/a/c/c/e;->a:Lorg/apache/http/HttpEntity;

    return-void
.end method
