.class public Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;
.super Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$a;
    }
.end annotation


# instance fields
.field f:Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$a;

.field private g:Landroid/widget/TextView;

.field private h:Z

.field private i:Z

.field private j:Landroid/os/Handler;

.field private k:Z

.field private l:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;-><init>()V

    new-instance v0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$1;

    invoke-direct {v0, p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$1;-><init>(Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;)V

    iput-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->j:Landroid/os/Handler;

    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 4

    const v0, 0x7f0c0153

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->g:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->g:Landroid/widget/TextView;

    invoke-direct {p0, v0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->a(Landroid/widget/TextView;)V

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Landroid/view/View;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->g:Landroid/widget/TextView;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/fimi/soul/utils/ar;->a(Landroid/content/res/AssetManager;[Landroid/view/View;)V

    return-void
.end method

.method private a(Landroid/widget/TextView;)V
    .locals 6

    const v3, 0x7f0b0132

    const/16 v5, 0x21

    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    new-instance v1, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {v1, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    const/16 v3, 0x13

    const/16 v4, 0x15

    invoke-virtual {v2, v0, v3, v4, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    const/16 v0, 0x1b

    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->length()I

    move-result v3

    invoke-virtual {v2, v1, v0, v3, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/16 v0, 0x80

    invoke-virtual {p0, p1, v0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->a(Landroid/widget/TextView;I)V

    return-void
.end method

.method static synthetic a(Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->i:Z

    return p1
.end method


# virtual methods
.method public a(Landroid/widget/TextView;I)V
    .locals 1

    invoke-virtual {p1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/ColorStateList;->withAlpha(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public a(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->k:Z

    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    invoke-super {p0, p1}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;->onAttach(Landroid/app/Activity;)V

    check-cast p1, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$a;

    iput-object p1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->f:Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$a;

    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    invoke-super {p0, p1}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;->onClick(Landroid/view/View;)V

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->e:Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment$a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->e:Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment$a;

    invoke-interface {v0}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment$a;->a()V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x7f0c03b9
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    const v0, 0x7f04003a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->a(Landroid/view/View;)V

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    invoke-super {p0}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;->onDestroy()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->f:Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$a;

    return-void
.end method

.method public onDroneEvent(Lcom/fimi/soul/drone/d$a;Lcom/fimi/soul/drone/a;)V
    .locals 5

    const/4 v4, 0x2

    const/4 v3, 0x0

    const/4 v2, 0x1

    invoke-super {p0, p1, p2}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;->onDroneEvent(Lcom/fimi/soul/drone/d$a;Lcom/fimi/soul/drone/a;)V

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment$2;->a:[I

    invoke-virtual {p1}, Lcom/fimi/soul/drone/d$a;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    invoke-virtual {p2}, Lcom/fimi/soul/drone/a;->k()Lcom/fimi/soul/drone/i/k;

    move-result-object v0

    iget-boolean v1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->k:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->i:Z

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->d()B

    move-result v1

    if-ne v1, v2, :cond_1

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->e()B

    move-result v1

    if-ne v1, v2, :cond_1

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->b()B

    move-result v1

    if-ne v1, v2, :cond_1

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->c()B

    move-result v1

    if-ne v1, v4, :cond_1

    iput-boolean v3, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->i:Z

    iput-boolean v2, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->l:Z

    invoke-static {p2}, Lcom/fimi/soul/module/b/d;->a(Lcom/fimi/soul/drone/a;)Lcom/fimi/soul/module/b/d;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v2, v2, v1}, Lcom/fimi/soul/module/b/d;->b(BBB)V

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->d()B

    move-result v1

    if-ne v1, v2, :cond_2

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->e()B

    move-result v1

    if-ne v1, v2, :cond_2

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->b()B

    move-result v1

    if-nez v1, :cond_2

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->c()B

    move-result v1

    if-ne v1, v2, :cond_2

    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->c:Landroid/support/v4/app/FragmentManager;

    const-string v1, "error"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    if-eqz v1, :cond_0

    instance-of v0, v1, Lcom/fimi/soul/module/calibcompass/CaliCompassErrorFragment;

    if-eqz v0, :cond_0

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->isHidden()Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, v1

    check-cast v0, Lcom/fimi/soul/module/calibcompass/CaliCompassErrorFragment;

    const v2, 0x7f0e03a3

    invoke-virtual {p0, v2}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v3, v3}, Lcom/fimi/soul/module/calibcompass/CaliCompassErrorFragment;->a(Ljava/lang/String;ZZ)V

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/fimi/soul/module/calibcompass/CaliCompassActivity;

    const v2, 0x7f0e0081

    invoke-virtual {p0, v2}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/fimi/soul/module/calibcompass/CaliCompassActivity;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->c:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->show(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    goto/16 :goto_0

    :cond_2
    iget-boolean v1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->l:Z

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->d()B

    move-result v1

    if-ne v1, v4, :cond_3

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->e()B

    move-result v1

    if-ne v1, v2, :cond_3

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->b()B

    move-result v1

    if-ne v1, v2, :cond_3

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->c()B

    move-result v1

    if-ne v1, v2, :cond_3

    iput-boolean v3, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->l:Z

    iput-boolean v3, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->h:Z

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/fimi/soul/module/calibcompass/CaliCompassActivity;

    const v1, 0x7f0e00fa

    invoke-virtual {p0, v1}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/fimi/soul/module/calibcompass/CaliCompassActivity;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->c:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iget-object v1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->c:Landroid/support/v4/app/FragmentManager;

    const-string v2, "thrid"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->show(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x10a0002

    const v2, 0x10a0003

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->setCustomAnimations(II)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    goto/16 :goto_0

    :cond_3
    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->d()B

    move-result v1

    if-ne v1, v2, :cond_0

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->e()B

    move-result v1

    if-ne v1, v2, :cond_0

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->b()B

    move-result v1

    if-ne v1, v2, :cond_0

    invoke-virtual {v0}, Lcom/fimi/soul/drone/i/k;->c()B

    move-result v0

    if-ne v0, v2, :cond_0

    iget-boolean v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->h:Z

    if-nez v0, :cond_0

    iput-boolean v2, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->h:Z

    iput-boolean v2, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->l:Z

    invoke-virtual {p0}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/fimi/kernel/d/b;->b(Landroid/content/Context;)Lcom/fimi/kernel/d/b;

    move-result-object v0

    const v1, 0x7f0e00f6

    invoke-virtual {p0, v1}, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/fimi/kernel/d/b;->a(Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onHiddenChanged(Z)V
    .locals 4

    const/4 v1, 0x0

    invoke-super {p0, p1}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;->onHiddenChanged(Z)V

    if-nez p1, :cond_0

    iput-boolean v1, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->h:Z

    iget-object v0, p0, Lcom/fimi/soul/module/calibcompass/CaliComPassFirstFragment;->j:Landroid/os/Handler;

    const-wide/16 v2, 0x7d0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 0

    invoke-super {p0}, Lcom/fimi/soul/module/calibcompass/BaseCaliCompassFragment;->onStart()V

    return-void
.end method
