.class public Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;
.super Lcom/fimi/soul/module/setting/newhand/BaseNewHandFragment;


# instance fields
.field c:Landroid/widget/TextView;

.field d:Landroid/widget/TextView;

.field e:Landroid/widget/TextView;

.field f:Landroid/widget/TextView;

.field g:Landroid/widget/TextView;

.field h:Landroid/widget/TextView;

.field i:Landroid/widget/TextView;

.field j:Landroid/widget/TextView;

.field k:Landroid/widget/TextView;

.field l:Landroid/widget/TextView;

.field m:Landroid/widget/TextView;

.field n:Landroid/widget/Button;

.field o:Lcom/fimi/soul/module/setting/newhand/LoopWidget;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/fimi/soul/module/setting/newhand/BaseNewHandFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/view/LayoutInflater;)Landroid/view/View;
    .locals 2

    const v0, 0x7f040078

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected a()V
    .locals 3

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->c:Landroid/widget/TextView;

    const-string v1, "2"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->e:Landroid/widget/TextView;

    const v1, 0x7f0e0301

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->i:Landroid/widget/TextView;

    const v1, 0x7f0e0306

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->j:Landroid/widget/TextView;

    const v1, 0x7f0e0308

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->k:Landroid/widget/TextView;

    const v1, 0x7f0e0307

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->m:Landroid/widget/TextView;

    const v1, 0x7f0e0305

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->n:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iget-object v1, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->o:Lcom/fimi/soul/module/setting/newhand/LoopWidget;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/fimi/soul/module/setting/newhand/LoopWidget;->setVisibility(I)V

    iget-object v1, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->o:Lcom/fimi/soul/module/setting/newhand/LoopWidget;

    invoke-virtual {v1, v0}, Lcom/fimi/soul/module/setting/newhand/LoopWidget;->setImagesRes([I)V

    return-void

    :array_0
    .array-data 4
        0x7f020249
        0x7f02024b
        0x7f02024a
        0x7f020248
    .end array-data
.end method

.method protected a(Landroid/view/View;)V
    .locals 6

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    const v0, 0x7f0c02aa

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->c:Landroid/widget/TextView;

    const v0, 0x7f0c02ab

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->d:Landroid/widget/TextView;

    const v0, 0x7f0c0088

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->e:Landroid/widget/TextView;

    const v0, 0x7f0c02ae

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->f:Landroid/widget/TextView;

    const v0, 0x7f0c02af

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->i:Landroid/widget/TextView;

    const v0, 0x7f0c02b2

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->g:Landroid/widget/TextView;

    const v0, 0x7f0c02b3

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->j:Landroid/widget/TextView;

    const v0, 0x7f0c02ba

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->h:Landroid/widget/TextView;

    const v0, 0x7f0c02bb

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->k:Landroid/widget/TextView;

    const v0, 0x7f0c02b5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->n:Landroid/widget/Button;

    const v0, 0x7f0c02c0

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->l:Landroid/widget/TextView;

    const v0, 0x7f0c02c1

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->m:Landroid/widget/TextView;

    const v0, 0x7f0c02cc

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/fimi/soul/module/setting/newhand/LoopWidget;

    iput-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->o:Lcom/fimi/soul/module/setting/newhand/LoopWidget;

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    new-array v1, v5, [Landroid/view/View;

    iget-object v2, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->c:Landroid/widget/TextView;

    aput-object v2, v1, v3

    iget-object v2, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->d:Landroid/widget/TextView;

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Lcom/fimi/soul/utils/ar;->b(Landroid/content/res/AssetManager;[Landroid/view/View;)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const/16 v1, 0xa

    new-array v1, v1, [Landroid/view/View;

    iget-object v2, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->e:Landroid/widget/TextView;

    aput-object v2, v1, v3

    iget-object v2, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->f:Landroid/widget/TextView;

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->g:Landroid/widget/TextView;

    aput-object v2, v1, v5

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->h:Landroid/widget/TextView;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->i:Landroid/widget/TextView;

    aput-object v3, v1, v2

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->j:Landroid/widget/TextView;

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->k:Landroid/widget/TextView;

    aput-object v3, v1, v2

    const/4 v2, 0x7

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->l:Landroid/widget/TextView;

    aput-object v3, v1, v2

    const/16 v2, 0x8

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->m:Landroid/widget/TextView;

    aput-object v3, v1, v2

    const/16 v2, 0x9

    iget-object v3, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->n:Landroid/widget/Button;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/fimi/soul/utils/ar;->a(Landroid/content/res/AssetManager;[Landroid/view/View;)V

    return-void
.end method

.method protected b()Ljava/lang/String;
    .locals 1

    const-class v0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    invoke-super {p0, p1}, Lcom/fimi/soul/module/setting/newhand/BaseNewHandFragment;->onClick(Landroid/view/View;)V

    iget-object v0, p0, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->n:Landroid/widget/Button;

    if-ne p1, v0, :cond_0

    invoke-virtual {p0}, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/fimi/soul/module/setting/newhand/NewHandActivity;

    invoke-virtual {v0}, Lcom/fimi/soul/module/setting/newhand/NewHandActivity;->a()Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/fimi/soul/module/setting/newhand/NewHandTwoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/fimi/soul/module/setting/newhand/NewHandActivity;

    invoke-virtual {v0}, Lcom/fimi/soul/module/setting/newhand/NewHandActivity;->a()Landroid/support/v4/view/ViewPager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    :cond_0
    return-void
.end method
