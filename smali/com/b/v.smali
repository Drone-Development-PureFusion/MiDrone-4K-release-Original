.class public Lcom/b/v;
.super Ljava/lang/Object;


# instance fields
.field private a:Z

.field private b:Z

.field private c:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/b/v;->a:Z

    return-void
.end method

.method public a()Z
    .locals 1

    iget-boolean v0, p0, Lcom/b/v;->a:Z

    return v0
.end method

.method public b(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/b/v;->b:Z

    return-void
.end method

.method public b()Z
    .locals 1

    iget-boolean v0, p0, Lcom/b/v;->b:Z

    return v0
.end method

.method public c(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/b/v;->c:Z

    return-void
.end method

.method public c()Z
    .locals 1

    iget-boolean v0, p0, Lcom/b/v;->c:Z

    return v0
.end method
