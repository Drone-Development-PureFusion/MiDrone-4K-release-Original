.class Lcom/fimi/kernel/b/a/b$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/fimi/kernel/b/a/b;->b(Ljava/io/File;Lcom/fimi/kernel/b/a/a;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/fimi/kernel/b/a/b;


# direct methods
.method constructor <init>(Lcom/fimi/kernel/b/a/b;)V
    .locals 0

    iput-object p1, p0, Lcom/fimi/kernel/b/a/b$3;->a:Lcom/fimi/kernel/b/a/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/fimi/kernel/b/a/b$3;->a:Lcom/fimi/kernel/b/a/b;

    invoke-static {v0}, Lcom/fimi/kernel/b/a/b;->f(Lcom/fimi/kernel/b/a/b;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->isFile()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/fimi/kernel/b/a/b$3;->a:Lcom/fimi/kernel/b/a/b;

    invoke-static {v0}, Lcom/fimi/kernel/b/a/b;->e(Lcom/fimi/kernel/b/a/b;)Lit/a/a/b;

    move-result-object v0

    iget-object v1, p0, Lcom/fimi/kernel/b/a/b$3;->a:Lcom/fimi/kernel/b/a/b;

    invoke-static {v1}, Lcom/fimi/kernel/b/a/b;->f(Lcom/fimi/kernel/b/a/b;)Ljava/io/File;

    move-result-object v1

    new-instance v2, Lcom/fimi/kernel/b/a/b$3$1;

    invoke-direct {v2, p0}, Lcom/fimi/kernel/b/a/b$3$1;-><init>(Lcom/fimi/kernel/b/a/b$3;)V

    invoke-virtual {v0, v1, v2}, Lit/a/a/b;->a(Ljava/io/File;Lit/a/a/k;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/fimi/kernel/b/a/b$3;->a:Lcom/fimi/kernel/b/a/b;

    invoke-static {v1}, Lcom/fimi/kernel/b/a/b;->h(Lcom/fimi/kernel/b/a/b;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
