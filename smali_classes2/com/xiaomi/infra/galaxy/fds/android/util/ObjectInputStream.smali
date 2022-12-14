.class public Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;
.super Ljava/io/FilterInputStream;


# instance fields
.field private lastNotifyTime:J

.field private final listener:Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;

.field private final metadata:Lcom/xiaomi/infra/galaxy/fds/android/model/ObjectMetadata;

.field private totalBytesRead:J


# direct methods
.method public constructor <init>(Ljava/io/InputStream;Lcom/xiaomi/infra/galaxy/fds/android/model/ObjectMetadata;Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;)V
    .locals 0

    invoke-direct {p0, p1}, Ljava/io/FilterInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->metadata:Lcom/xiaomi/infra/galaxy/fds/android/model/ObjectMetadata;

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->listener:Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;

    return-void
.end method

.method private notifyListener(Z)V
    .locals 6

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->listener:Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;

    if-eqz v0, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    if-eqz p1, :cond_0

    iget-wide v2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->lastNotifyTime:J

    sub-long v2, v0, v2

    iget-object v4, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->listener:Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;

    invoke-virtual {v4}, Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;->progressInterval()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    :cond_0
    iput-wide v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->lastNotifyTime:J

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->listener:Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;

    iget-wide v2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->totalBytesRead:J

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->metadata:Lcom/xiaomi/infra/galaxy/fds/android/model/ObjectMetadata;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/fds/android/model/ObjectMetadata;->getContentLength()J

    move-result-wide v4

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/xiaomi/infra/galaxy/fds/android/model/ProgressListener;->onProgress(JJ)V

    :cond_1
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    invoke-super {p0}, Ljava/io/FilterInputStream;->close()V

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->notifyListener(Z)V

    return-void
.end method

.method public read()I
    .locals 6

    invoke-super {p0}, Ljava/io/FilterInputStream;->read()I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget-wide v2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->totalBytesRead:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->totalBytesRead:J

    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->notifyListener(Z)V

    :cond_0
    return v0
.end method

.method public read([BII)I
    .locals 6

    invoke-super {p0, p1, p2, p3}, Ljava/io/FilterInputStream;->read([BII)I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget-wide v2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->totalBytesRead:J

    int-to-long v4, v0

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->totalBytesRead:J

    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->notifyListener(Z)V

    :cond_0
    return v0
.end method

.method public declared-synchronized reset()V
    .locals 2

    monitor-enter p0

    :try_start_0
    invoke-super {p0}, Ljava/io/FilterInputStream;->reset()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->totalBytesRead:J

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/xiaomi/infra/galaxy/fds/android/util/ObjectInputStream;->notifyListener(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
