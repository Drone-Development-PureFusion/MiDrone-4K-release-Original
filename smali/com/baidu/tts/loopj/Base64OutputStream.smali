.class public Lcom/baidu/tts/loopj/Base64OutputStream;
.super Ljava/io/FilterOutputStream;


# static fields
.field private static EMPTY:[B


# instance fields
.field private bpos:I

.field private buffer:[B

.field private final coder:Lcom/baidu/tts/loopj/Base64$Coder;

.field private final flags:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [B

    sput-object v0, Lcom/baidu/tts/loopj/Base64OutputStream;->EMPTY:[B

    return-void
.end method

.method public constructor <init>(Ljava/io/OutputStream;I)V
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/baidu/tts/loopj/Base64OutputStream;-><init>(Ljava/io/OutputStream;IZ)V

    return-void
.end method

.method public constructor <init>(Ljava/io/OutputStream;IZ)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0, p1}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    iput p2, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->flags:I

    if-eqz p3, :cond_0

    new-instance v0, Lcom/baidu/tts/loopj/Base64$Encoder;

    invoke-direct {v0, p2, v1}, Lcom/baidu/tts/loopj/Base64$Encoder;-><init>(I[B)V

    iput-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Lcom/baidu/tts/loopj/Base64$Decoder;

    invoke-direct {v0, p2, v1}, Lcom/baidu/tts/loopj/Base64$Decoder;-><init>(I[B)V

    iput-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    goto :goto_0
.end method

.method private embiggen([BI)[B
    .locals 1

    if-eqz p1, :cond_0

    array-length v0, p1

    if-ge v0, p2, :cond_1

    :cond_0
    new-array p1, p2, [B

    :cond_1
    return-object p1
.end method

.method private flushBuffer()V
    .locals 3

    const/4 v2, 0x0

    iget v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    iget v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    invoke-direct {p0, v0, v2, v1, v2}, Lcom/baidu/tts/loopj/Base64OutputStream;->internalWrite([BIIZ)V

    iput v2, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    :cond_0
    return-void
.end method

.method private internalWrite([BIIZ)V
    .locals 4

    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    iget-object v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    iget-object v1, v1, Lcom/baidu/tts/loopj/Base64$Coder;->output:[B

    iget-object v2, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    invoke-virtual {v2, p3}, Lcom/baidu/tts/loopj/Base64$Coder;->maxOutputSize(I)I

    move-result v2

    invoke-direct {p0, v1, v2}, Lcom/baidu/tts/loopj/Base64OutputStream;->embiggen([BI)[B

    move-result-object v1

    iput-object v1, v0, Lcom/baidu/tts/loopj/Base64$Coder;->output:[B

    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/baidu/tts/loopj/Base64$Coder;->process([BIIZ)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Lcom/baidu/tts/loopj/Base64DataException;

    const-string v1, "bad base-64"

    invoke-direct {v0, v1}, Lcom/baidu/tts/loopj/Base64DataException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->out:Ljava/io/OutputStream;

    iget-object v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    iget-object v1, v1, Lcom/baidu/tts/loopj/Base64$Coder;->output:[B

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->coder:Lcom/baidu/tts/loopj/Base64$Coder;

    iget v3, v3, Lcom/baidu/tts/loopj/Base64$Coder;->op:I

    invoke-virtual {v0, v1, v2, v3}, Ljava/io/OutputStream;->write([BII)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 5

    const/4 v1, 0x0

    :try_start_0
    invoke-direct {p0}, Lcom/baidu/tts/loopj/Base64OutputStream;->flushBuffer()V

    sget-object v0, Lcom/baidu/tts/loopj/Base64OutputStream;->EMPTY:[B

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-direct {p0, v0, v2, v3, v4}, Lcom/baidu/tts/loopj/Base64OutputStream;->internalWrite([BIIZ)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    :try_start_1
    iget v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->flags:I

    and-int/lit8 v0, v0, 0x10

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    move-object v0, v1

    :cond_0
    :goto_2
    if-eqz v0, :cond_2

    throw v0

    :catch_0
    move-exception v0

    move-object v1, v0

    goto :goto_0

    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    :catch_1
    move-exception v0

    if-nez v1, :cond_0

    move-object v0, v1

    goto :goto_2

    :cond_2
    return-void
.end method

.method public write(I)V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    if-nez v0, :cond_0

    const/16 v0, 0x400

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    :cond_0
    iget v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    iget-object v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    array-length v1, v1

    if-lt v0, v1, :cond_1

    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    iget v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    invoke-direct {p0, v0, v2, v1, v2}, Lcom/baidu/tts/loopj/Base64OutputStream;->internalWrite([BIIZ)V

    iput v2, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    :cond_1
    iget-object v0, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->buffer:[B

    iget v1, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/baidu/tts/loopj/Base64OutputStream;->bpos:I

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    return-void
.end method

.method public write([BII)V
    .locals 1

    if-gtz p3, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0}, Lcom/baidu/tts/loopj/Base64OutputStream;->flushBuffer()V

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/baidu/tts/loopj/Base64OutputStream;->internalWrite([BIIZ)V

    goto :goto_0
.end method
