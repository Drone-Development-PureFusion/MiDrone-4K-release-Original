.class public Lcom/xiaomi/xmpush/thrift/aq;
.super Ljava/lang/Object;


# direct methods
.method public static a(Landroid/content/Context;Lcom/xiaomi/xmpush/thrift/ab;)S
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p1, Lcom/xiaomi/xmpush/thrift/ab;->f:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/xiaomi/channel/commonutils/android/b;->d(Landroid/content/Context;Ljava/lang/String;)Lcom/xiaomi/channel/commonutils/android/b$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xiaomi/channel/commonutils/android/b$a;->a()I

    move-result v0

    add-int v2, v1, v0

    invoke-static {p0}, Lcom/xiaomi/channel/commonutils/misc/e;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x4

    :goto_0
    add-int/2addr v2, v0

    invoke-static {p0}, Lcom/xiaomi/channel/commonutils/misc/e;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/16 v0, 0x8

    :goto_1
    add-int/2addr v0, v2

    invoke-static {p0, p1}, Lcom/xiaomi/push/service/ay;->a(Landroid/content/Context;Lcom/xiaomi/xmpush/thrift/ab;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/16 v1, 0x10

    :cond_0
    add-int/2addr v0, v1

    int-to-short v0, v0

    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1
.end method

.method public static a(ZZZ)S
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_1

    const/4 v1, 0x4

    :goto_0
    add-int v2, v0, v1

    if-eqz p1, :cond_2

    const/4 v1, 0x2

    :goto_1
    add-int/2addr v1, v2

    if-eqz p2, :cond_0

    const/4 v0, 0x1

    :cond_0
    add-int/2addr v0, v1

    int-to-short v0, v0

    return v0

    :cond_1
    move v1, v0

    goto :goto_0

    :cond_2
    move v1, v0

    goto :goto_1
.end method

.method public static a(Lorg/a/b/a;[B)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lorg/a/b/a",
            "<TT;*>;>(TT;[B)V"
        }
    .end annotation

    const/4 v3, 0x1

    if-nez p1, :cond_0

    new-instance v0, Lorg/a/b/f;

    const-string v1, "the message byte is empty."

    invoke-direct {v0, v1}, Lorg/a/b/f;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v0, Lorg/a/b/e;

    new-instance v1, Lorg/a/b/b/k$a;

    array-length v2, p1

    invoke-direct {v1, v3, v3, v2}, Lorg/a/b/b/k$a;-><init>(ZZI)V

    invoke-direct {v0, v1}, Lorg/a/b/e;-><init>(Lorg/a/b/b/g;)V

    invoke-virtual {v0, p0, p1}, Lorg/a/b/e;->a(Lorg/a/b/a;[B)V

    return-void
.end method

.method public static a(Lorg/a/b/a;)[B
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lorg/a/b/a",
            "<TT;*>;>(TT;)[B"
        }
    .end annotation

    const/4 v0, 0x0

    if-nez p0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    new-instance v1, Lorg/a/b/g;

    new-instance v2, Lorg/a/b/b/a$a;

    invoke-direct {v2}, Lorg/a/b/b/a$a;-><init>()V

    invoke-direct {v1, v2}, Lorg/a/b/g;-><init>(Lorg/a/b/b/g;)V

    invoke-virtual {v1, p0}, Lorg/a/b/g;->a(Lorg/a/b/a;)[B
    :try_end_0
    .catch Lorg/a/b/f; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v1

    const-string v2, "convertThriftObjectToBytes catch TException."

    invoke-static {v2, v1}, Lcom/xiaomi/channel/commonutils/logger/b;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
