.class Lcom/c/a/n$a;
.super Lcom/c/a/n;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/c/a/n;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation


# instance fields
.field h:Lcom/c/a/g;

.field i:F

.field private j:Lcom/c/b/a;


# direct methods
.method public constructor <init>(Lcom/c/b/d;Lcom/c/a/g;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/c/a/n;-><init>(Lcom/c/b/d;Lcom/c/a/n$1;)V

    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    iput-object v0, p0, Lcom/c/a/n$a;->d:Ljava/lang/Class;

    iput-object p2, p0, Lcom/c/a/n$a;->e:Lcom/c/a/k;

    iget-object v0, p0, Lcom/c/a/n$a;->e:Lcom/c/a/k;

    check-cast v0, Lcom/c/a/g;

    iput-object v0, p0, Lcom/c/a/n$a;->h:Lcom/c/a/g;

    instance-of v0, p1, Lcom/c/b/a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/c/a/n$a;->b:Lcom/c/b/d;

    check-cast v0, Lcom/c/b/a;

    iput-object v0, p0, Lcom/c/a/n$a;->j:Lcom/c/b/a;

    :cond_0
    return-void
.end method

.method public varargs constructor <init>(Lcom/c/b/d;[F)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/c/a/n;-><init>(Lcom/c/b/d;Lcom/c/a/n$1;)V

    invoke-virtual {p0, p2}, Lcom/c/a/n$a;->a([F)V

    instance-of v0, p1, Lcom/c/b/a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/c/a/n$a;->b:Lcom/c/b/d;

    check-cast v0, Lcom/c/b/a;

    iput-object v0, p0, Lcom/c/a/n$a;->j:Lcom/c/b/a;

    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/c/a/g;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/c/a/n;-><init>(Ljava/lang/String;Lcom/c/a/n$1;)V

    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    iput-object v0, p0, Lcom/c/a/n$a;->d:Ljava/lang/Class;

    iput-object p2, p0, Lcom/c/a/n$a;->e:Lcom/c/a/k;

    iget-object v0, p0, Lcom/c/a/n$a;->e:Lcom/c/a/k;

    check-cast v0, Lcom/c/a/g;

    iput-object v0, p0, Lcom/c/a/n$a;->h:Lcom/c/a/g;

    return-void
.end method

.method public varargs constructor <init>(Ljava/lang/String;[F)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/c/a/n;-><init>(Ljava/lang/String;Lcom/c/a/n$1;)V

    invoke-virtual {p0, p2}, Lcom/c/a/n$a;->a([F)V

    return-void
.end method


# virtual methods
.method public synthetic a()Lcom/c/a/n;
    .locals 1

    invoke-virtual {p0}, Lcom/c/a/n$a;->e()Lcom/c/a/n$a;

    move-result-object v0

    return-object v0
.end method

.method a(F)V
    .locals 1

    iget-object v0, p0, Lcom/c/a/n$a;->h:Lcom/c/a/g;

    invoke-virtual {v0, p1}, Lcom/c/a/g;->b(F)F

    move-result v0

    iput v0, p0, Lcom/c/a/n$a;->i:F

    return-void
.end method

.method a(Ljava/lang/Class;)V
    .locals 1

    iget-object v0, p0, Lcom/c/a/n$a;->b:Lcom/c/b/d;

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-super {p0, p1}, Lcom/c/a/n;->a(Ljava/lang/Class;)V

    goto :goto_0
.end method

.method public varargs a([F)V
    .locals 1

    invoke-super {p0, p1}, Lcom/c/a/n;->a([F)V

    iget-object v0, p0, Lcom/c/a/n$a;->e:Lcom/c/a/k;

    check-cast v0, Lcom/c/a/g;

    iput-object v0, p0, Lcom/c/a/n$a;->h:Lcom/c/a/g;

    return-void
.end method

.method public synthetic clone()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/c/a/n$a;->e()Lcom/c/a/n$a;

    move-result-object v0

    return-object v0
.end method

.method d()Ljava/lang/Object;
    .locals 1

    iget v0, p0, Lcom/c/a/n$a;->i:F

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method

.method d(Ljava/lang/Object;)V
    .locals 3

    iget-object v0, p0, Lcom/c/a/n$a;->j:Lcom/c/b/a;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/c/a/n$a;->j:Lcom/c/b/a;

    iget v1, p0, Lcom/c/a/n$a;->i:F

    invoke-virtual {v0, p1, v1}, Lcom/c/b/a;->a(Ljava/lang/Object;F)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/c/a/n$a;->b:Lcom/c/b/d;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/c/a/n$a;->b:Lcom/c/b/d;

    iget v1, p0, Lcom/c/a/n$a;->i:F

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/c/b/d;->a(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/c/a/n$a;->c:Ljava/lang/reflect/Method;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/c/a/n$a;->g:[Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Lcom/c/a/n$a;->i:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    aput-object v2, v0, v1

    iget-object v0, p0, Lcom/c/a/n$a;->c:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/c/a/n$a;->g:[Ljava/lang/Object;

    invoke-virtual {v0, p1, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "PropertyValuesHolder"

    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :catch_1
    move-exception v0

    const-string v1, "PropertyValuesHolder"

    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public e()Lcom/c/a/n$a;
    .locals 2

    invoke-super {p0}, Lcom/c/a/n;->a()Lcom/c/a/n;

    move-result-object v0

    check-cast v0, Lcom/c/a/n$a;

    iget-object v1, v0, Lcom/c/a/n$a;->e:Lcom/c/a/k;

    check-cast v1, Lcom/c/a/g;

    iput-object v1, v0, Lcom/c/a/n$a;->h:Lcom/c/a/g;

    return-object v0
.end method
