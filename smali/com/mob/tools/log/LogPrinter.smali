.class public Lcom/mob/tools/log/LogPrinter;
.super Ljava/lang/Object;


# instance fields
.field private collectors:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/mob/tools/log/LogCollector;",
            ">;"
        }
    .end annotation
.end field

.field private packageName:Ljava/lang/String;

.field private scope:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/mob/tools/log/LogPrinter;->collectors:Ljava/util/HashMap;

    const-string v0, ""

    iput-object v0, p0, Lcom/mob/tools/log/LogPrinter;->packageName:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/mob/tools/log/LogPrinter;->scope:Ljava/lang/String;

    return-void
.end method

.method private getScope(Ljava/lang/Thread;)Ljava/lang/String;
    .locals 4

    invoke-virtual {p1}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    if-eqz v0, :cond_4

    array-length v1, v0

    if-lez v1, :cond_4

    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aget-object v2, v0, v1

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-gtz v1, :cond_3

    :cond_0
    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    if-gez v3, :cond_2

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-gtz v2, :cond_2

    :cond_1
    const-string v1, "Unknown Source"

    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "("

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0

    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mob/tools/log/LogPrinter;->scope:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "/"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_4
    iget-object v0, p0, Lcom/mob/tools/log/LogPrinter;->scope:Ljava/lang/String;

    goto :goto_1
.end method

.method private processMessage(Ljava/lang/Thread;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    const-string v0, "%s %s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public nativeCrashLog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    iget-object v0, p0, Lcom/mob/tools/log/LogPrinter;->collectors:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mob/tools/log/LogCollector;

    if-eqz v0, :cond_0

    const/4 v2, 0x6

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/mob/tools/log/LogPrinter;->scope:Ljava/lang/String;

    move-object v1, p1

    move-object v5, p2

    invoke-interface/range {v0 .. v5}, Lcom/mob/tools/log/LogCollector;->log(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public println(Ljava/lang/String;IILjava/lang/String;)I
    .locals 6

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-direct {p0, v0, p4}, Lcom/mob/tools/log/LogPrinter;->processMessage(Ljava/lang/Thread;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v0}, Lcom/mob/tools/log/LogPrinter;->getScope(Ljava/lang/Thread;)Ljava/lang/String;

    move-result-object v4

    iget-object v0, p0, Lcom/mob/tools/log/LogPrinter;->collectors:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mob/tools/log/LogCollector;

    if-eqz v0, :cond_0

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/mob/tools/log/LogCollector;->log(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public setCollector(Ljava/lang/String;Lcom/mob/tools/log/LogCollector;)V
    .locals 1

    iget-object v0, p0, Lcom/mob/tools/log/LogPrinter;->collectors:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 1

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mob/tools/log/LogPrinter;->packageName:Ljava/lang/String;

    iget-object v0, p0, Lcom/mob/tools/log/LogPrinter;->packageName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, ""

    iput-object v0, p0, Lcom/mob/tools/log/LogPrinter;->packageName:Ljava/lang/String;

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/mob/tools/log/LogPrinter;->packageName:Ljava/lang/String;

    iput-object v0, p0, Lcom/mob/tools/log/LogPrinter;->scope:Ljava/lang/String;

    goto :goto_0
.end method
