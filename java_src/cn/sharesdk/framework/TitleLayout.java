package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mob.tools.utils.ResHelper;
/* loaded from: classes.dex */
public class TitleLayout extends LinearLayout {
    private ImageView btnBack;
    private TextView btnRight;
    private TextView tvTitle;

    public TitleLayout(Context context) {
        super(context);
        init(context);
    }

    public TitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.btnBack = new ImageView(context);
        this.btnBack.setBackgroundDrawable(null);
        int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_back_arr");
        if (bitmapRes > 0) {
            this.btnBack.setImageResource(bitmapRes);
        }
        this.btnBack.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.btnBack.setLayoutParams(new LinearLayout.LayoutParams(ResHelper.dipToPx(context, 48), -1));
        addView(this.btnBack);
        ImageView imageView = new ImageView(context);
        int dipToPx = ResHelper.dipToPx(context, 2);
        int bitmapRes2 = ResHelper.getBitmapRes(context, "ssdk_title_div");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        imageView.setLayoutParams(new LinearLayout.LayoutParams(dipToPx, -1));
        addView(imageView);
        this.tvTitle = new TextView(context);
        int dipToPx2 = ResHelper.dipToPx(context, 23);
        this.tvTitle.setPadding(dipToPx2, 0, dipToPx2, 0);
        this.tvTitle.setSingleLine();
        this.tvTitle.setTextColor(-1);
        this.tvTitle.setTextSize(1, 18.0f);
        this.tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
        this.tvTitle.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.tvTitle.setLayoutParams(layoutParams);
        addView(this.tvTitle);
        final ImageView imageView2 = new ImageView(context);
        int bitmapRes3 = ResHelper.getBitmapRes(context, "ssdk_title_div");
        if (bitmapRes3 > 0) {
            imageView2.setImageResource(bitmapRes3);
        }
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(dipToPx, -1));
        addView(imageView2);
        this.btnRight = new TextView(context) { // from class: cn.sharesdk.framework.TitleLayout.1
            @Override // android.view.View
            public void setVisibility(int i) {
                super.setVisibility(i);
                imageView2.setVisibility(i);
            }
        };
        this.btnRight.setVisibility(4);
        this.btnRight.setBackgroundDrawable(null);
        this.btnRight.setMinWidth(ResHelper.dipToPx(context, 50));
        this.btnRight.setTextColor(-1);
        this.btnRight.setTextSize(1, 12.0f);
        this.btnRight.setGravity(17);
        this.btnRight.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(this.btnRight);
    }

    public ImageView getBtnBack() {
        return this.btnBack;
    }

    public TextView getBtnRight() {
        return this.btnRight;
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }
}
