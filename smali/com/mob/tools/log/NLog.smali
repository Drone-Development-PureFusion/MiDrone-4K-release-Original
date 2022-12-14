.class public abstract Lcom/mob/tools/log/NLog;
.super Ljava/lang/Object;


# static fields
.field private static disable:Z

.field private static loggers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/mob/tools/log/NLog;",
            ">;"
        }
    .end annotation
.end field

.field private static printer:Lcom/mob/tools/log/LogPrinter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/mob/tools/log/NLog;->loggers:Ljava/util/HashMap;

    new-instance v0, Lcom/mob/tools/log/LogPrinter;

    invoke-direct {v0}, Lcom/mob/tools/log/LogPrinter;-><init>()V

    sput-object v0, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-static {}, Lcom/mob/tools/log/MobUncaughtExceptionHandler;->register()V

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/mob/tools/log/NLog;->loggers:Ljava/util/HashMap;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/mob/tools/log/NLog;->loggers:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    sget-object v0, Lcom/mob/tools/log/NLog;->loggers:Ljava/util/HashMap;

    const-string v1, "__FIRST__"

    invoke-virtual {v0, v1, p0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void
.end method

.method public static disable()V
    .locals 1

    const/4 v0, 0x1

    sput-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    return-void
.end method

.method protected static final getInstanceForSDK(Ljava/lang/String;Z)Lcom/mob/tools/log/NLog;
    .locals 2

    sget-object v0, Lcom/mob/tools/log/NLog;->loggers:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mob/tools/log/NLog;

    if-nez v0, :cond_0

    sget-object v0, Lcom/mob/tools/log/NLog;->loggers:Ljava/util/HashMap;

    const-string v1, "__FIRST__"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mob/tools/log/NLog;

    :cond_0
    if-nez v0, :cond_1

    if-eqz p1, :cond_1

    new-instance v0, Lcom/mob/tools/log/NLog$1;

    invoke-direct {v0, p0}, Lcom/mob/tools/log/NLog$1;-><init>(Ljava/lang/String;)V

    :cond_1
    return-object v0
.end method

.method private final getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 2

    if-nez p1, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    move-object v0, p1

    :goto_1
    if-eqz v0, :cond_2

    instance-of v1, v0, Ljava/net/UnknownHostException;

    if-eqz v1, :cond_1

    const-string v0, ""

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    goto :goto_1

    :cond_2
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    new-instance v1, Ljava/io/PrintWriter;

    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {p1, v1}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static setCollector(Ljava/lang/String;Lcom/mob/tools/log/LogCollector;)V
    .locals 1

    sget-object v0, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {v0, p0, p1}, Lcom/mob/tools/log/LogPrinter;->setCollector(Ljava/lang/String;Lcom/mob/tools/log/LogCollector;)V

    return-void
.end method

.method public static setContext(Landroid/content/Context;)V
    .locals 1

    if-eqz p0, :cond_0

    sget-object v0, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {v0, p0}, Lcom/mob/tools/log/LogPrinter;->setContext(Landroid/content/Context;)V

    invoke-static {p0}, Lcom/mob/tools/log/NativeErrorHandler;->prepare(Landroid/content/Context;)Z

    :cond_0
    return-void
.end method


# virtual methods
.method public final crash(Ljava/lang/Throwable;)I
    .locals 5

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    sget-object v0, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x6

    const/4 v3, 0x1

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs d(Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    array-length v2, p2

    if-lez v2, :cond_1

    invoke-static {v0, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final d(Ljava/lang/Throwable;)I
    .locals 5

    const/4 v0, 0x0

    sget-boolean v1, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    sget-object v1, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs d(Ljava/lang/Throwable;Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    array-length v3, p3

    if-lez v3, :cond_1

    invoke-static {v0, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs e(Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    array-length v2, p2

    if-lez v2, :cond_1

    invoke-static {v0, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final e(Ljava/lang/Throwable;)I
    .locals 5

    const/4 v0, 0x0

    sget-boolean v1, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    sget-object v1, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x6

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs e(Ljava/lang/Throwable;Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    array-length v3, p3

    if-lez v3, :cond_1

    invoke-static {v0, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method protected abstract getSDKTag()Ljava/lang/String;
.end method

.method public final varargs i(Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    array-length v2, p2

    if-lez v2, :cond_1

    invoke-static {v0, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final i(Ljava/lang/Throwable;)I
    .locals 5

    const/4 v0, 0x0

    sget-boolean v1, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    sget-object v1, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x4

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs i(Ljava/lang/Throwable;Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    array-length v3, p3

    if-lez v3, :cond_1

    invoke-static {v0, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final nativeCrashLog(Ljava/lang/String;)V
    .locals 2

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    sget-object v0, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/mob/tools/log/LogPrinter;->nativeCrashLog(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public final varargs v(Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    array-length v2, p2

    if-lez v2, :cond_1

    invoke-static {v0, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final v(Ljava/lang/Throwable;)I
    .locals 5

    const/4 v0, 0x0

    sget-boolean v1, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    sget-object v1, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs v(Ljava/lang/Throwable;Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    array-length v3, p3

    if-lez v3, :cond_1

    invoke-static {v0, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs w(Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    array-length v2, p2

    if-lez v2, :cond_1

    invoke-static {v0, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x5

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final w(Ljava/lang/Throwable;)I
    .locals 5

    const/4 v0, 0x0

    sget-boolean v1, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    sget-object v1, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x5

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public final varargs w(Ljava/lang/Throwable;Ljava/lang/Object;[Ljava/lang/Object;)I
    .locals 5

    const/4 v1, 0x0

    sget-boolean v0, Lcom/mob/tools/log/NLog;->disable:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    array-length v3, p3

    if-lez v3, :cond_1

    invoke-static {v0, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p1}, Lcom/mob/tools/log/NLog;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/mob/tools/log/NLog;->printer:Lcom/mob/tools/log/LogPrinter;

    invoke-virtual {p0}, Lcom/mob/tools/log/NLog;->getSDKTag()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x5

    invoke-virtual {v2, v3, v4, v1, v0}, Lcom/mob/tools/log/LogPrinter;->println(Ljava/lang/String;IILjava/lang/String;)I

    move-result v0

    goto :goto_0
.end method
