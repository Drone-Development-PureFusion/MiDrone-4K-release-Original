.class public Lcom/xiaomi/infra/galaxy/fds/android/model/ResponseExpiresParam;
.super Lcom/xiaomi/infra/galaxy/fds/android/model/UserParam;


# static fields
.field private static final RESPONSE_EXPIRES:Ljava/lang/String; = "response-expires"


# direct methods
.method public constructor <init>()V
    .locals 3

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/fds/android/model/UserParam;-><init>()V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/ResponseExpiresParam;->params:Ljava/util/Map;

    const-string v1, "response-expires"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
