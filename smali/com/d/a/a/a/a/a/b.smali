.class public Lcom/d/a/a/a/a/a/b;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/d/a/a/a/a;


# static fields
.field public static final a:I = 0x8000

.field public static final b:Landroid/graphics/Bitmap$CompressFormat;

.field public static final c:I = 0x64

.field private static final i:Ljava/lang/String; = " argument must be not null"

.field private static final j:Ljava/lang/String; = " argument must be positive number"


# instance fields
.field protected d:Lcom/d/a/a/a/a/a/a;

.field protected final e:Lcom/d/a/a/a/b/a;

.field protected f:I

.field protected g:Landroid/graphics/Bitmap$CompressFormat;

.field protected h:I

.field private k:Ljava/io/File;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    sput-object v0, Lcom/d/a/a/a/a/a/b;->b:Landroid/graphics/Bitmap$CompressFormat;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lcom/d/a/a/a/b/a;J)V
    .locals 7

    const/4 v2, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v6}, Lcom/d/a/a/a/a/a/b;-><init>(Ljava/io/File;Ljava/io/File;Lcom/d/a/a/a/b/a;JI)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/io/File;Lcom/d/a/a/a/b/a;JI)V
    .locals 8

    const-wide/16 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const v0, 0x8000

    iput v0, p0, Lcom/d/a/a/a/a/a/b;->f:I

    sget-object v0, Lcom/d/a/a/a/a/a/b;->b:Landroid/graphics/Bitmap$CompressFormat;

    iput-object v0, p0, Lcom/d/a/a/a/a/a/b;->g:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v0, 0x64

    iput v0, p0, Lcom/d/a/a/a/a/a/b;->h:I

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "cacheDir argument must be not null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    cmp-long v0, p4, v2

    if-gez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "cacheMaxSize argument must be positive number"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    if-gez p6, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "cacheMaxFileCount argument must be positive number"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    if-nez p3, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "fileNameGenerator argument must be not null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    cmp-long v0, p4, v2

    if-nez v0, :cond_5

    const-wide v4, 0x7fffffffffffffffL

    :goto_0
    if-nez p6, :cond_4

    const v6, 0x7fffffff

    :goto_1
    iput-object p2, p0, Lcom/d/a/a/a/a/a/b;->k:Ljava/io/File;

    iput-object p3, p0, Lcom/d/a/a/a/a/a/b;->e:Lcom/d/a/a/a/b/a;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/d/a/a/a/a/a/b;->a(Ljava/io/File;Ljava/io/File;JI)V

    return-void

    :cond_4
    move v6, p6

    goto :goto_1

    :cond_5
    move-wide v4, p4

    goto :goto_0
.end method

.method private a(Ljava/io/File;Ljava/io/File;JI)V
    .locals 7

    const/4 v2, 0x1

    const/4 v3, 0x1

    move-object v1, p1

    move-wide v4, p3

    move v6, p5

    :try_start_0
    invoke-static/range {v1 .. v6}, Lcom/d/a/a/a/a/a/a;->a(Ljava/io/File;IIJI)Lcom/d/a/a/a/a/a/a;

    move-result-object v0

    iput-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    return-void

    :catch_0
    move-exception v0

    invoke-static {v0}, Lcom/d/a/c/d;->a(Ljava/lang/Throwable;)V

    if-eqz p2, :cond_1

    const/4 v3, 0x0

    move-object v1, p0

    move-object v2, p2

    move-wide v4, p3

    move v6, p5

    invoke-direct/range {v1 .. v6}, Lcom/d/a/a/a/a/a/b;->a(Ljava/io/File;Ljava/io/File;JI)V

    :cond_1
    iget-object v1, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    if-nez v1, :cond_0

    throw v0
.end method

.method private c(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->e:Lcom/d/a/a/a/b/a;

    invoke-interface {v0, p1}, Lcom/d/a/a/a/b/a;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Ljava/io/File;
    .locals 1

    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-virtual {v0}, Lcom/d/a/a/a/a/a/a;->a()Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/io/File;
    .locals 3

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-direct {p0, p1}, Lcom/d/a/a/a/a/a/b;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/d/a/a/a/a/a/a;->a(Ljava/lang/String;)Lcom/d/a/a/a/a/a/a$c;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    if-nez v2, :cond_1

    :goto_0
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/d/a/a/a/a/a/a$c;->close()V

    :cond_0
    :goto_1
    return-object v0

    :cond_1
    const/4 v1, 0x0

    :try_start_1
    invoke-virtual {v2, v1}, Lcom/d/a/a/a/a/a/a$c;->a(I)Ljava/io/File;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v1

    move-object v2, v0

    :goto_2
    :try_start_2
    invoke-static {v1}, Lcom/d/a/c/d;->a(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/d/a/a/a/a/a/a$c;->close()V

    goto :goto_1

    :catchall_0
    move-exception v1

    move-object v2, v0

    move-object v0, v1

    :goto_3
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lcom/d/a/a/a/a/a/a$c;->close()V

    :cond_2
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_3

    :catch_1
    move-exception v1

    goto :goto_2
.end method

.method public a(I)V
    .locals 0

    iput p1, p0, Lcom/d/a/a/a/a/a/b;->f:I

    return-void
.end method

.method public a(Landroid/graphics/Bitmap$CompressFormat;)V
    .locals 0

    iput-object p1, p0, Lcom/d/a/a/a/a/a/b;->g:Landroid/graphics/Bitmap$CompressFormat;

    return-void
.end method

.method public a(Ljava/lang/String;Landroid/graphics/Bitmap;)Z
    .locals 4

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-direct {p0, p1}, Lcom/d/a/a/a/a/a/b;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/d/a/a/a/a/a/a;->b(Ljava/lang/String;)Lcom/d/a/a/a/a/a/a$a;

    move-result-object v1

    if-nez v1, :cond_0

    :goto_0
    return v0

    :cond_0
    new-instance v2, Ljava/io/BufferedOutputStream;

    invoke-virtual {v1, v0}, Lcom/d/a/a/a/a/a/a$a;->c(I)Ljava/io/OutputStream;

    move-result-object v0

    iget v3, p0, Lcom/d/a/a/a/a/a/b;->f:I

    invoke-direct {v2, v0, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V

    :try_start_0
    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->g:Landroid/graphics/Bitmap$CompressFormat;

    iget v3, p0, Lcom/d/a/a/a/a/a/b;->h:I

    invoke-virtual {p2, v0, v3, v2}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    invoke-static {v2}, Lcom/d/a/c/c;->a(Ljava/io/Closeable;)V

    if-eqz v0, :cond_1

    invoke-virtual {v1}, Lcom/d/a/a/a/a/a/a$a;->a()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-static {v2}, Lcom/d/a/c/c;->a(Ljava/io/Closeable;)V

    throw v0

    :cond_1
    invoke-virtual {v1}, Lcom/d/a/a/a/a/a/a$a;->b()V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/io/InputStream;Lcom/d/a/c/c$a;)Z
    .locals 4

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-direct {p0, p1}, Lcom/d/a/a/a/a/a/b;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/d/a/a/a/a/a/a;->b(Ljava/lang/String;)Lcom/d/a/a/a/a/a/a$a;

    move-result-object v1

    if-nez v1, :cond_0

    :goto_0
    return v0

    :cond_0
    new-instance v2, Ljava/io/BufferedOutputStream;

    invoke-virtual {v1, v0}, Lcom/d/a/a/a/a/a/a$a;->c(I)Ljava/io/OutputStream;

    move-result-object v0

    iget v3, p0, Lcom/d/a/a/a/a/a/b;->f:I

    invoke-direct {v2, v0, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V

    :try_start_0
    iget v0, p0, Lcom/d/a/a/a/a/a/b;->f:I

    invoke-static {p2, v2, p3, v0}, Lcom/d/a/c/c;->a(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/d/a/c/c$a;I)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    invoke-static {v2}, Lcom/d/a/c/c;->a(Ljava/io/Closeable;)V

    if-eqz v0, :cond_1

    invoke-virtual {v1}, Lcom/d/a/a/a/a/a/a$a;->a()V

    goto :goto_0

    :cond_1
    invoke-virtual {v1}, Lcom/d/a/a/a/a/a/a$a;->b()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-static {v2}, Lcom/d/a/c/c;->a(Ljava/io/Closeable;)V

    invoke-virtual {v1}, Lcom/d/a/a/a/a/a/a$a;->b()V

    throw v0
.end method

.method public b()V
    .locals 1

    :try_start_0
    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-virtual {v0}, Lcom/d/a/a/a/a/a/a;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    return-void

    :catch_0
    move-exception v0

    invoke-static {v0}, Lcom/d/a/c/d;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public b(I)V
    .locals 0

    iput p1, p0, Lcom/d/a/a/a/a/a/b;->h:I

    return-void
.end method

.method public b(Ljava/lang/String;)Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-direct {p0, p1}, Lcom/d/a/a/a/a/a/b;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/d/a/a/a/a/a/a;->c(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    invoke-static {v0}, Lcom/d/a/c/d;->a(Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()V
    .locals 7

    :try_start_0
    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-virtual {v0}, Lcom/d/a/a/a/a/a/a;->h()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-virtual {v0}, Lcom/d/a/a/a/a/a/a;->a()Ljava/io/File;

    move-result-object v2

    iget-object v3, p0, Lcom/d/a/a/a/a/a/b;->k:Ljava/io/File;

    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-virtual {v0}, Lcom/d/a/a/a/a/a/a;->b()J

    move-result-wide v4

    iget-object v0, p0, Lcom/d/a/a/a/a/a/b;->d:Lcom/d/a/a/a/a/a/a;

    invoke-virtual {v0}, Lcom/d/a/a/a/a/a/a;->c()I

    move-result v6

    move-object v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/d/a/a/a/a/a/b;->a(Ljava/io/File;Ljava/io/File;JI)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    return-void

    :catch_0
    move-exception v0

    invoke-static {v0}, Lcom/d/a/c/d;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    :catch_1
    move-exception v0

    invoke-static {v0}, Lcom/d/a/c/d;->a(Ljava/lang/Throwable;)V

    goto :goto_1
.end method
