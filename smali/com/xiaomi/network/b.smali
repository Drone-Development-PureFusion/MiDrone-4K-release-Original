.class Lcom/xiaomi/network/b;
.super Lcom/xiaomi/network/Fallback;


# instance fields
.field i:Lcom/xiaomi/network/Fallback;

.field final synthetic j:Lcom/xiaomi/network/Fallback;

.field final synthetic k:Lcom/xiaomi/network/HostManager;


# direct methods
.method constructor <init>(Lcom/xiaomi/network/HostManager;Ljava/lang/String;Lcom/xiaomi/network/Fallback;)V
    .locals 1

    iput-object p1, p0, Lcom/xiaomi/network/b;->k:Lcom/xiaomi/network/HostManager;

    iput-object p3, p0, Lcom/xiaomi/network/b;->j:Lcom/xiaomi/network/Fallback;

    invoke-direct {p0, p2}, Lcom/xiaomi/network/Fallback;-><init>(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/xiaomi/network/b;->j:Lcom/xiaomi/network/Fallback;

    iput-object v0, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    iget-object v0, p0, Lcom/xiaomi/network/b;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/network/b;->b:Ljava/lang/String;

    iget-object v0, p0, Lcom/xiaomi/network/b;->j:Lcom/xiaomi/network/Fallback;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/network/b;->j:Lcom/xiaomi/network/Fallback;

    iget-object v0, v0, Lcom/xiaomi/network/Fallback;->f:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/network/b;->f:Ljava/lang/String;

    :cond_0
    return-void
.end method


# virtual methods
.method public declared-synchronized a(Z)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xiaomi/network/Fallback;->a(Z)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    :cond_0
    sget-object v3, Lcom/xiaomi/network/HostManager;->mReservedHosts:Ljava/util/Map;

    monitor-enter v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    sget-object v0, Lcom/xiaomi/network/HostManager;->mReservedHosts:Ljava/util/Map;

    iget-object v1, p0, Lcom/xiaomi/network/b;->b:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v1, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Lcom/xiaomi/network/Fallback;->a(Z)Ljava/util/ArrayList;

    move-result-object v1

    :goto_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_1
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v5

    const/4 v6, -0x1

    if-ne v5, v6, :cond_1

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_2
    move-object v1, v2

    goto :goto_0

    :cond_3
    :try_start_3
    iget-object v0, p0, Lcom/xiaomi/network/b;->b:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/xiaomi/network/b;->b:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_4
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    monitor-exit p0

    return-object v2
.end method

.method public declared-synchronized a(Ljava/lang/String;Lcom/xiaomi/network/AccessHistory;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/network/b;->i:Lcom/xiaomi/network/Fallback;

    invoke-virtual {v0, p1, p2}, Lcom/xiaomi/network/Fallback;->a(Ljava/lang/String;Lcom/xiaomi/network/AccessHistory;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public b()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method
