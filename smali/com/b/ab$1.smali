.class final Lcom/b/ab$1;
.super Ljava/lang/Thread;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/b/ab;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/b/ab$1;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/b/ab$1;->b:Ljava/lang/String;

    iput-object p3, p0, Lcom/b/ab$1;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    :try_start_0
    new-instance v1, Lcom/b/k;

    iget-object v0, p0, Lcom/b/ab$1;->a:Landroid/content/Context;

    invoke-static {}, Lcom/b/ae;->c()Lcom/b/ae;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/b/k;-><init>(Landroid/content/Context;Lcom/b/j;)V

    iget-object v0, p0, Lcom/b/ab$1;->b:Ljava/lang/String;

    invoke-static {v0}, Lcom/b/af;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/b/af;

    invoke-direct {v2}, Lcom/b/af;-><init>()V

    invoke-virtual {v1, v0, v2}, Lcom/b/k;->c(Ljava/lang/String;Lcom/b/l;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/b/ag;

    invoke-virtual {v0}, Lcom/b/ag;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/b/ab$1;->c:Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v0}, Lcom/b/ag;->a()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/b/ab$1;->a:Landroid/content/Context;

    invoke-static {v3, v1, v0}, Lcom/b/ab;->a(Landroid/content/Context;Lcom/b/k;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "DexFileManager"

    const-string v2, "clearUnSuitableVersion"

    invoke-static {v0, v1, v2}, Lcom/b/b;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    return-void
.end method
