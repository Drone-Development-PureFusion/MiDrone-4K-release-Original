.class public Lcom/c/a/o;
.super Lcom/c/a/q;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/c/a/o$a;
    }
.end annotation


# instance fields
.field private p:Lcom/c/a/o$a;

.field private q:J


# direct methods
.method public constructor <init>()V
    .locals 2

    invoke-direct {p0}, Lcom/c/a/q;-><init>()V

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/c/a/o;->q:J

    return-void
.end method


# virtual methods
.method a(F)V
    .locals 0

    return-void
.end method

.method public a(Lcom/c/a/o$a;)V
    .locals 0

    iput-object p1, p0, Lcom/c/a/o;->p:Lcom/c/a/o$a;

    return-void
.end method

.method c(J)Z
    .locals 7

    const-wide/16 v4, 0x0

    iget v0, p0, Lcom/c/a/o;->i:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    iput v0, p0, Lcom/c/a/o;->i:I

    iget-wide v0, p0, Lcom/c/a/o;->h:J

    cmp-long v0, v0, v4

    if-gez v0, :cond_2

    iput-wide p1, p0, Lcom/c/a/o;->g:J

    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/c/a/o;->p:Lcom/c/a/o$a;

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/c/a/o;->g:J

    sub-long v2, p1, v0

    iget-wide v0, p0, Lcom/c/a/o;->q:J

    cmp-long v0, v0, v4

    if-gez v0, :cond_3

    :goto_1
    iput-wide p1, p0, Lcom/c/a/o;->q:J

    iget-object v0, p0, Lcom/c/a/o;->p:Lcom/c/a/o$a;

    move-object v1, p0

    invoke-interface/range {v0 .. v5}, Lcom/c/a/o$a;->a(Lcom/c/a/o;JJ)V

    :cond_1
    const/4 v0, 0x0

    return v0

    :cond_2
    iget-wide v0, p0, Lcom/c/a/o;->h:J

    sub-long v0, p1, v0

    iput-wide v0, p0, Lcom/c/a/o;->g:J

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/c/a/o;->h:J

    goto :goto_0

    :cond_3
    iget-wide v0, p0, Lcom/c/a/o;->q:J

    sub-long v4, p1, v0

    goto :goto_1
.end method

.method n()V
    .locals 0

    return-void
.end method
