.class Lcom/baidu/tts/a/c/b$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/baidu/tts/b/a/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/baidu/tts/a/c/b;->g()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/baidu/tts/a/c/b;


# direct methods
.method constructor <init>(Lcom/baidu/tts/a/c/b;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/tts/a/c/b$3;->a:Lcom/baidu/tts/a/c/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/baidu/tts/l/h;)V
    .locals 0

    return-void
.end method

.method public b(Lcom/baidu/tts/l/h;)V
    .locals 0

    return-void
.end method

.method public c(Lcom/baidu/tts/l/h;)V
    .locals 1

    iget-object v0, p0, Lcom/baidu/tts/a/c/b$3;->a:Lcom/baidu/tts/a/c/b;

    invoke-static {v0, p1}, Lcom/baidu/tts/a/c/b;->a(Lcom/baidu/tts/a/c/b;Lcom/baidu/tts/l/h;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/baidu/tts/a/c/b$3;->a:Lcom/baidu/tts/a/c/b;

    invoke-static {v0}, Lcom/baidu/tts/a/c/b;->b(Lcom/baidu/tts/a/c/b;)Lcom/baidu/tts/b/b/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/baidu/tts/b/b/a/c;->a(Lcom/baidu/tts/l/h;)V

    :cond_0
    return-void
.end method

.method public d(Lcom/baidu/tts/l/h;)V
    .locals 0

    return-void
.end method

.method public e(Lcom/baidu/tts/l/h;)V
    .locals 0

    return-void
.end method
