.class Lcom/fimi/soul/module/login/b$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/fimi/soul/module/login/b;->i()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/fimi/soul/module/login/b;


# direct methods
.method constructor <init>(Lcom/fimi/soul/module/login/b;)V
    .locals 0

    iput-object p1, p0, Lcom/fimi/soul/module/login/b$1;->a:Lcom/fimi/soul/module/login/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lcom/fimi/soul/module/login/b$1;->a:Lcom/fimi/soul/module/login/b;

    invoke-static {v0}, Lcom/fimi/soul/module/login/b;->a(Lcom/fimi/soul/module/login/b;)Lcom/fimi/soul/module/login/LoginActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fimi/soul/module/login/LoginActivity;->j()V

    return-void
.end method
