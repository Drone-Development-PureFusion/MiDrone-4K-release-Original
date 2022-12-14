.class public Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/fds/android/auth/GalaxyFDSCredential;


# instance fields
.field private final APP_ID:Ljava/lang/String;

.field private final HEADER_VALUE:Ljava/lang/String;

.field private final SERVICE_TOKEN_PARAM:Ljava/lang/String;

.field private final appId:Ljava/lang/String;

.field private final serviceToken:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "SSO"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->HEADER_VALUE:Ljava/lang/String;

    const-string v0, "serviceToken"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->SERVICE_TOKEN_PARAM:Ljava/lang/String;

    const-string v0, "appId"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->APP_ID:Ljava/lang/String;

    const-string v0, "Service token"

    invoke-static {p1, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    const-string v0, "Service token"

    invoke-static {p1, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/Args;->notEmpty(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/CharSequence;

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->serviceToken:Ljava/lang/String;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->appId:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "SSO"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->HEADER_VALUE:Ljava/lang/String;

    const-string v0, "serviceToken"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->SERVICE_TOKEN_PARAM:Ljava/lang/String;

    const-string v0, "appId"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->APP_ID:Ljava/lang/String;

    const-string v0, "Service token"

    invoke-static {p1, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    const-string v0, "Service token"

    invoke-static {p1, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/Args;->notEmpty(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/CharSequence;

    const-string v0, "App id"

    invoke-static {p2, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    const-string v0, "App id"

    invoke-static {p2, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/Args;->notEmpty(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/CharSequence;

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->serviceToken:Ljava/lang/String;

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->appId:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public addHeader(Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 2

    const-string v0, "Authorization"

    const-string v1, "SSO"

    invoke-virtual {p1, v0, v1}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public addParam(Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    const/16 v5, 0x3f

    const/16 v4, 0x3d

    const/16 v3, 0x26

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_0
    const-string v1, "serviceToken"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->serviceToken:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->appId:Ljava/lang/String;

    if-eqz v1, :cond_0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const-string v1, "appId"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/fds/android/auth/SSOCredential;->appId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_1
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
