.class public Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;
.super Ljava/lang/Object;


# instance fields
.field private expireTime:J

.field private token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;->token:Ljava/lang/String;

    iput-wide p2, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;->expireTime:J

    return-void
.end method


# virtual methods
.method public getExpireTime()J
    .locals 2

    iget-wide v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;->expireTime:J

    return-wide v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;->token:Ljava/lang/String;

    return-object v0
.end method

.method public setExpireTime(J)V
    .locals 1

    iput-wide p1, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;->expireTime:J

    return-void
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/fds/android/model/StorageAccessToken;->token:Ljava/lang/String;

    return-void
.end method
