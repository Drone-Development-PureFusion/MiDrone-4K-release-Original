.class public Lb/a/a/a/a/c;
.super Ljava/lang/Object;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()V
    .locals 1

    invoke-static {}, Lorg/d/d;->c()Lorg/d/a;

    move-result-object v0

    check-cast v0, Lb/a/a/a/f;

    invoke-static {v0}, Lb/a/a/a/a/c;->a(Lb/a/a/a/f;)V

    return-void
.end method

.method public static a(Lb/a/a/a/f;)V
    .locals 3

    invoke-virtual {p0}, Lb/a/a/a/f;->n()Lb/a/a/b/p/k;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v1, Lb/a/a/b/p/b;

    const-string v2, "Setting up default configuration."

    invoke-direct {v1, v2, p0}, Lb/a/a/b/p/b;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Lb/a/a/b/p/k;->a(Lb/a/a/b/p/g;)V

    :cond_0
    new-instance v0, Lb/a/a/a/a/d;

    invoke-direct {v0}, Lb/a/a/a/a/d;-><init>()V

    invoke-virtual {v0, p0}, Lb/a/a/a/a/d;->a(Lb/a/a/b/f;)V

    const-string v1, "logcat"

    invoke-virtual {v0, v1}, Lb/a/a/a/a/d;->b_(Ljava/lang/String;)V

    new-instance v1, Lb/a/a/a/d/a;

    invoke-direct {v1}, Lb/a/a/a/d/a;-><init>()V

    invoke-virtual {v1, p0}, Lb/a/a/a/d/a;->a(Lb/a/a/b/f;)V

    const-string v2, "%msg"

    invoke-virtual {v1, v2}, Lb/a/a/a/d/a;->a(Ljava/lang/String;)V

    invoke-virtual {v1}, Lb/a/a/a/d/a;->j()V

    invoke-virtual {v0, v1}, Lb/a/a/a/a/d;->a(Lb/a/a/a/d/a;)V

    invoke-virtual {v0}, Lb/a/a/a/a/d;->j()V

    const-string v1, "ROOT"

    invoke-virtual {p0, v1}, Lb/a/a/a/f;->c(Ljava/lang/String;)Lb/a/a/a/e;

    move-result-object v1

    invoke-virtual {v1, v0}, Lb/a/a/a/e;->a(Lb/a/a/b/a;)V

    return-void
.end method
