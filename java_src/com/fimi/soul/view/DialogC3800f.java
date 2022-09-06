package com.fimi.soul.view;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fimi.kernel.utils.C2271p;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.view.f */
/* loaded from: classes.dex */
public class DialogC3800f extends Dialog {

    /* renamed from: com.fimi.soul.view.f$a */
    /* loaded from: classes.dex */
    public static class C3801a {

        /* renamed from: a */
        private Context f15905a;

        /* renamed from: b */
        private String f15906b;

        /* renamed from: c */
        private String f15907c;

        /* renamed from: d */
        private String f15908d;

        /* renamed from: e */
        private String f15909e;

        /* renamed from: f */
        private int f15910f;

        /* renamed from: g */
        private int f15911g;

        /* renamed from: j */
        private DialogInterface.OnClickListener f15914j;

        /* renamed from: k */
        private DialogInterface.OnClickListener f15915k;

        /* renamed from: l */
        private DialogC3800f f15916l;

        /* renamed from: h */
        private int f15912h = -1;

        /* renamed from: i */
        private int f15913i = -1;

        /* renamed from: m */
        private boolean f15917m = false;

        public C3801a(Context context) {
            this.f15905a = context;
            this.f15916l = new DialogC3800f(this.f15905a, C2300R.style.DropDialog1);
        }

        /* renamed from: a */
        private void m7033a(TextView textView) {
            textView.getPaint().setFakeBoldText(true);
        }

        /* renamed from: a */
        public C3801a m7034a(int i) {
            this.f15910f = i;
            return this;
        }

        /* renamed from: a */
        public C3801a m7031a(String str) {
            this.f15906b = str;
            return this;
        }

        /* renamed from: a */
        public C3801a m7030a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15915k = onClickListener;
            this.f15908d = str;
            return this;
        }

        /* renamed from: a */
        public C3801a m7029a(boolean z) {
            this.f15917m = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3800f m7035a() {
            LayoutInflater layoutInflater = (LayoutInflater) this.f15905a.getSystemService("layout_inflater");
            View inflate = this.f15909e != null ? layoutInflater.inflate(C2300R.layout.vertical_screen_dialog_content_double_button, (ViewGroup) null) : layoutInflater.inflate(C2300R.layout.vertical_screen_dialog_double_button, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            if (this.f15909e != null) {
                TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.content_tv);
                textView2.setText(this.f15909e);
                textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
                C3658ar.m7612a(this.f15905a.getAssets(), textView2);
                if (this.f15913i != -1) {
                    textView2.setGravity(this.f15913i);
                }
            }
            if (this.f15910f != 0) {
                button.setTextColor(this.f15910f);
            }
            if (this.f15911g > 0) {
                button2.setTextColor(this.f15911g);
            }
            if (this.f15907c != null) {
                button.setText(this.f15907c);
            }
            if (this.f15914j != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3801a.this.f15916l.dismiss();
                        C3801a.this.f15914j.onClick(C3801a.this.f15916l, -2);
                    }
                });
            }
            if (this.f15908d != null) {
                button2.setText(this.f15908d);
            }
            if (this.f15915k != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3801a.this.f15916l.dismiss();
                        C3801a.this.f15915k.onClick(C3801a.this.f15916l, -2);
                    }
                });
            }
            if (this.f15906b != null) {
                textView.setText(this.f15906b);
            }
            if (this.f15912h != -1) {
                textView.setGravity(this.f15912h);
            }
            C3658ar.m7612a(this.f15905a.getAssets(), textView, button, button2);
            if (this.f15909e != null) {
                textView.getPaint().setFakeBoldText(true);
            }
            this.f15916l.setCanceledOnTouchOutside(this.f15917m);
            this.f15916l.setContentView(inflate);
            Window window = this.f15916l.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15905a) > ((float) C2271p.m12871a(this.f15905a)) ? C2271p.m12860b(this.f15905a) : C2271p.m12871a(this.f15905a)) * 1048.0f) / 1920.0f);
            window.setAttributes(attributes);
            this.f15916l.getWindow().getDecorView().setBackgroundColor(0);
            return this.f15916l;
        }

        /* renamed from: b */
        public C3801a m7027b(int i) {
            this.f15911g = i;
            return this;
        }

        /* renamed from: b */
        public C3801a m7025b(String str) {
            this.f15909e = str;
            return this;
        }

        /* renamed from: b */
        public C3801a m7024b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15914j = onClickListener;
            this.f15907c = str;
            return this;
        }

        /* renamed from: b */
        public DialogC3800f m7028b() {
            return this.f15916l;
        }

        /* renamed from: c */
        public C3801a m7023c(int i) {
            this.f15912h = i;
            return this;
        }

        /* renamed from: c */
        public C3801a m7021c(String str) {
            this.f15907c = str;
            return this;
        }

        /* renamed from: d */
        public C3801a m7020d(int i) {
            this.f15913i = i;
            return this;
        }

        /* renamed from: d */
        public C3801a m7019d(String str) {
            this.f15908d = str;
            return this;
        }
    }

    /* renamed from: com.fimi.soul.view.f$b */
    /* loaded from: classes.dex */
    public static class C3804b {

        /* renamed from: o */
        private static final int f15920o = 0;

        /* renamed from: p */
        private static final int f15921p = 115;

        /* renamed from: a */
        private Context f15922a;

        /* renamed from: b */
        private String f15923b;

        /* renamed from: c */
        private String f15924c;

        /* renamed from: d */
        private int f15925d;

        /* renamed from: e */
        private String f15926e;

        /* renamed from: i */
        private String f15930i;

        /* renamed from: j */
        private String f15931j;

        /* renamed from: l */
        private DialogInterface.OnClickListener f15933l;

        /* renamed from: m */
        private DialogInterface.OnClickListener f15934m;

        /* renamed from: n */
        private SeekBar.OnSeekBarChangeListener f15935n;

        /* renamed from: f */
        private int f15927f = 500;

        /* renamed from: g */
        private int f15928g = 0;

        /* renamed from: h */
        private int f15929h = 0;

        /* renamed from: k */
        private boolean f15932k = false;

        /* renamed from: q */
        private boolean f15936q = false;

        public C3804b(Context context) {
            this.f15922a = context;
        }

        /* renamed from: a */
        private void m7015a(TextView textView) {
            textView.getPaint().setFakeBoldText(true);
        }

        /* renamed from: a */
        public C3804b m7017a(int i) {
            this.f15929h = i;
            return this;
        }

        /* renamed from: a */
        public C3804b m7016a(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
            this.f15935n = onSeekBarChangeListener;
            return this;
        }

        /* renamed from: a */
        public C3804b m7013a(String str) {
            this.f15930i = str;
            return this;
        }

        /* renamed from: a */
        public C3804b m7012a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15934m = onClickListener;
            this.f15924c = str;
            return this;
        }

        /* renamed from: a */
        public C3804b m7011a(boolean z) {
            this.f15932k = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3800f m7018a() {
            final DialogC3800f dialogC3800f = new DialogC3800f(this.f15922a, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15922a.getSystemService("layout_inflater")).inflate(C2300R.layout.vertical_screen_dialog_double_button_progress, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            final SeekBar seekBar = (SeekBar) inflate.findViewById(C2300R.C2302id.seekbar);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.min_progress_tv);
            TextView textView3 = (TextView) inflate.findViewById(C2300R.C2302id.max_progress_tv);
            final TextView textView4 = (TextView) inflate.findViewById(C2300R.C2302id.progress_tv);
            TextView textView5 = (TextView) inflate.findViewById(C2300R.C2302id.dialog_unit_tv);
            if (this.f15931j != null) {
                textView5.setText(this.f15931j);
            }
            ((RelativeLayout) inflate.findViewById(C2300R.C2302id.seekbar_ll)).setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.view.f.b.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    float f = 0.0f;
                    Rect rect = new Rect();
                    seekBar.getHitRect(rect);
                    if (motionEvent.getY() < rect.top - 50 || motionEvent.getY() > rect.bottom + 50) {
                        return false;
                    }
                    float height = rect.top + (rect.height() / 2);
                    float x = motionEvent.getX() - rect.left;
                    if (x >= 0.0f) {
                        f = x > ((float) rect.width()) ? rect.width() : x;
                    }
                    return seekBar.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), f, height, motionEvent.getMetaState()));
                }
            });
            seekBar.setMax(this.f15928g - this.f15929h);
            textView2.setText(this.f15929h + this.f15930i);
            textView3.setText(this.f15928g + this.f15930i);
            seekBar.setProgress(this.f15927f - this.f15929h);
            if (!this.f15932k) {
                textView4.setText(this.f15927f + this.f15930i);
            } else if (this.f15927f <= 6) {
                textView4.setText(this.f15927f + this.f15922a.getString(C2300R.C2303string.speed_unit_m) + this.f15922a.getString(C2300R.C2303string.setting_speed_low));
            } else if (this.f15927f <= 6 || this.f15927f > 10) {
                textView4.setText(this.f15927f + this.f15922a.getString(C2300R.C2303string.speed_unit_m) + this.f15922a.getString(C2300R.C2303string.setting_speed_hight));
            } else {
                textView4.setText(this.f15927f + this.f15922a.getString(C2300R.C2303string.speed_unit_m) + this.f15922a.getString(C2300R.C2303string.setting_speed_standard));
            }
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.view.f.b.2
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
                    if (C3804b.this.f15932k) {
                        int i2 = C3804b.this.f15929h + i;
                        if (i2 <= 6) {
                            textView4.setText(i2 + C3804b.this.f15922a.getString(C2300R.C2303string.speed_unit_m) + C3804b.this.f15922a.getString(C2300R.C2303string.setting_speed_low));
                        } else if (i2 <= 6 || i2 > 10) {
                            textView4.setText(i2 + C3804b.this.f15922a.getString(C2300R.C2303string.speed_unit_m) + C3804b.this.f15922a.getString(C2300R.C2303string.setting_speed_hight));
                        } else {
                            textView4.setText(i2 + C3804b.this.f15922a.getString(C2300R.C2303string.speed_unit_m) + C3804b.this.f15922a.getString(C2300R.C2303string.setting_speed_standard));
                        }
                    } else {
                        textView4.setText((C3804b.this.f15929h + i) + C3804b.this.f15930i);
                    }
                    C3804b.this.f15935n.onProgressChanged(seekBar2, i, z);
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                    C3804b.this.f15935n.onStartTrackingTouch(seekBar2);
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                    C3804b.this.f15935n.onStopTrackingTouch(seekBar2);
                }
            });
            if (this.f15924c != null) {
                button.setText(this.f15924c);
            }
            if (this.f15933l != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3800f.dismiss();
                        C3804b.this.f15933l.onClick(dialogC3800f, -2);
                    }
                });
            }
            if (this.f15925d != -1) {
                button.setTextColor(this.f15925d);
            }
            if (this.f15926e != null) {
                button2.setText(this.f15924c);
            }
            if (this.f15934m != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3800f.dismiss();
                        C3804b.this.f15934m.onClick(dialogC3800f, -2);
                    }
                });
            }
            if (this.f15923b != null) {
                textView.setText(this.f15923b);
            }
            C3658ar.m7612a(this.f15922a.getAssets(), textView, button, button2, textView5);
            C3658ar.m7598b(this.f15922a.getAssets(), textView2, textView3, textView4);
            m7015a(textView);
            m7015a(textView5);
            m7015a(textView4);
            m7015a(textView2);
            m7015a(textView3);
            dialogC3800f.setCanceledOnTouchOutside(this.f15936q);
            dialogC3800f.setContentView(inflate);
            Window window = dialogC3800f.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15922a) > ((float) C2271p.m12871a(this.f15922a)) ? C2271p.m12860b(this.f15922a) : C2271p.m12871a(this.f15922a)) * 1048.0f) / 1920.0f);
            window.setAttributes(attributes);
            dialogC3800f.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3800f;
        }

        /* renamed from: b */
        public C3804b m7010b(int i) {
            this.f15928g = i;
            return this;
        }

        /* renamed from: b */
        public C3804b m7008b(String str) {
            this.f15931j = str;
            return this;
        }

        /* renamed from: b */
        public C3804b m7007b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15933l = onClickListener;
            this.f15924c = str;
            return this;
        }

        /* renamed from: b */
        public C3804b m7006b(boolean z) {
            this.f15936q = z;
            return this;
        }

        /* renamed from: c */
        public C3804b m7005c(int i) {
            this.f15927f = i;
            return this;
        }

        /* renamed from: c */
        public C3804b m7003c(String str) {
            this.f15923b = str;
            return this;
        }

        /* renamed from: d */
        public C3804b m7002d(int i) {
            this.f15925d = i;
            return this;
        }

        /* renamed from: d */
        public C3804b m7000d(String str) {
            this.f15924c = str;
            return this;
        }

        /* renamed from: e */
        public C3804b m6998e(String str) {
            this.f15926e = str;
            return this;
        }
    }

    /* renamed from: com.fimi.soul.view.f$c */
    /* loaded from: classes.dex */
    public static class C3809c {

        /* renamed from: a */
        private Context f15945a;

        /* renamed from: b */
        private String f15946b;

        /* renamed from: c */
        private int f15947c;

        /* renamed from: d */
        private String f15948d;

        /* renamed from: e */
        private String f15949e;

        /* renamed from: f */
        private DialogInterface.OnClickListener f15950f;

        /* renamed from: g */
        private DialogInterface.OnClickListener f15951g;

        /* renamed from: h */
        private DialogInterface.OnClickListener f15952h;

        /* renamed from: j */
        private SeekBar.OnSeekBarChangeListener f15954j;

        /* renamed from: l */
        private int f15956l;

        /* renamed from: m */
        private int f15957m;

        /* renamed from: i */
        private int f15953i = -1;

        /* renamed from: k */
        private boolean f15955k = false;

        public C3809c(Context context) {
            this.f15945a = context;
        }

        /* renamed from: a */
        private void m6991a(TextView textView) {
            textView.getPaint().setFakeBoldText(true);
        }

        /* renamed from: a */
        public C3809c m6994a(int i) {
            this.f15947c = i;
            return this;
        }

        /* renamed from: a */
        public C3809c m6993a(DialogInterface.OnClickListener onClickListener) {
            this.f15950f = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3809c m6992a(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
            this.f15954j = onSeekBarChangeListener;
            return this;
        }

        /* renamed from: a */
        public C3809c m6989a(String str) {
            this.f15946b = str;
            return this;
        }

        /* renamed from: a */
        public C3809c m6988a(boolean z) {
            this.f15955k = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3800f m6995a() {
            final DialogC3800f dialogC3800f = new DialogC3800f(this.f15945a, C2300R.style.DropDialog1);
            final View inflate = ((LayoutInflater) this.f15945a.getSystemService("layout_inflater")).inflate(C2300R.layout.horizontal_screen_dialog_double_button_progress, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            final SeekBar seekBar = (SeekBar) inflate.findViewById(C2300R.C2302id.seekbar);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.min_progress_tv);
            TextView textView3 = (TextView) inflate.findViewById(C2300R.C2302id.max_progress_tv);
            TextView textView4 = (TextView) inflate.findViewById(C2300R.C2302id.height_lable_tv);
            TextView textView5 = (TextView) inflate.findViewById(C2300R.C2302id.height_unit_tv);
            final Button button3 = (Button) inflate.findViewById(C2300R.C2302id.height_value_btn);
            inflate.findViewById(C2300R.C2302id.seekbar_ll).setVisibility(8);
            ((RelativeLayout) inflate.findViewById(C2300R.C2302id.seekbar_ll)).setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.view.f.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    float f = 0.0f;
                    Rect rect = new Rect();
                    seekBar.getHitRect(rect);
                    if (motionEvent.getY() < rect.top - 50 || motionEvent.getY() > rect.bottom + 50) {
                        return false;
                    }
                    float height = rect.top + (rect.height() / 2);
                    float x = motionEvent.getX() - rect.left;
                    if (x >= 0.0f) {
                        f = x > ((float) rect.width()) ? rect.width() : x;
                    }
                    return seekBar.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), f, height, motionEvent.getMetaState()));
                }
            });
            textView2.setText(String.valueOf(this.f15957m));
            textView3.setText(String.valueOf(this.f15956l));
            seekBar.setMax(this.f15956l - this.f15957m);
            seekBar.setProgress(this.f15947c - this.f15957m);
            button3.setText(String.valueOf(this.f15947c));
            if (this.f15952h != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        inflate.findViewById(C2300R.C2302id.seekbar_ll).setVisibility(0);
                    }
                });
            }
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.view.f.c.3
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
                    button3.setText(String.valueOf(C3809c.this.f15957m + i));
                    C3809c.this.f15954j.onProgressChanged(seekBar2, C3809c.this.f15957m + i, z);
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                    C3809c.this.f15954j.onStartTrackingTouch(seekBar2);
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                    C3809c.this.f15954j.onStopTrackingTouch(seekBar2);
                }
            });
            if (this.f15948d != null) {
                button.setText(this.f15948d);
            }
            if (this.f15950f != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3800f.dismiss();
                        C3809c.this.f15950f.onClick(dialogC3800f, -2);
                    }
                });
            }
            if (this.f15953i != -1) {
                button.setTextColor(this.f15953i);
            }
            if (this.f15949e != null) {
                button2.setText(this.f15948d);
            }
            if (this.f15951g != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3800f.dismiss();
                        C3809c.this.f15951g.onClick(dialogC3800f, -2);
                    }
                });
            }
            if (this.f15946b != null) {
                textView.setText(this.f15946b);
            }
            C3658ar.m7612a(this.f15945a.getAssets(), textView, button, button2, textView4, textView5, button3);
            C3658ar.m7598b(this.f15945a.getAssets(), textView2, textView3);
            m6991a(textView);
            dialogC3800f.setCanceledOnTouchOutside(this.f15955k);
            dialogC3800f.setContentView(inflate);
            Window window = dialogC3800f.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15945a) < ((float) C2271p.m12871a(this.f15945a)) ? C2271p.m12860b(this.f15945a) : C2271p.m12871a(this.f15945a)) * 1034.0f) / 1080.0f);
            window.setAttributes(attributes);
            dialogC3800f.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3800f;
        }

        /* renamed from: b */
        public C3809c m6987b(int i) {
            this.f15953i = i;
            return this;
        }

        /* renamed from: b */
        public C3809c m6986b(DialogInterface.OnClickListener onClickListener) {
            this.f15951g = onClickListener;
            return this;
        }

        /* renamed from: b */
        public C3809c m6984b(String str) {
            this.f15948d = str;
            return this;
        }

        /* renamed from: c */
        public C3809c m6983c(int i) {
            this.f15956l = i;
            return this;
        }

        /* renamed from: c */
        public C3809c m6982c(DialogInterface.OnClickListener onClickListener) {
            this.f15952h = onClickListener;
            return this;
        }

        /* renamed from: c */
        public C3809c m6980c(String str) {
            this.f15949e = str;
            return this;
        }

        /* renamed from: d */
        public C3809c m6979d(int i) {
            this.f15957m = i;
            return this;
        }
    }

    /* renamed from: com.fimi.soul.view.f$d */
    /* loaded from: classes.dex */
    public static class C3815d {

        /* renamed from: a */
        private DialogC3800f f15968a;

        /* renamed from: b */
        private Context f15969b;

        /* renamed from: c */
        private String f15970c;

        /* renamed from: d */
        private String f15971d;

        /* renamed from: e */
        private DialogInterface.OnClickListener f15972e;

        /* renamed from: f */
        private boolean f15973f = false;

        public C3815d(Context context) {
            this.f15969b = context;
            this.f15968a = new DialogC3800f(this.f15969b, C2300R.style.DropDialog1);
        }

        /* renamed from: a */
        public C3815d m6976a(DialogInterface.OnClickListener onClickListener) {
            this.f15972e = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3815d m6974a(String str) {
            this.f15970c = str;
            return this;
        }

        /* renamed from: a */
        public C3815d m6973a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15972e = onClickListener;
            this.f15971d = str;
            return this;
        }

        /* renamed from: a */
        public C3815d m6972a(boolean z) {
            this.f15973f = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3800f m6977a() {
            View inflate = ((LayoutInflater) this.f15969b.getSystemService("layout_inflater")).inflate(C2300R.layout.horizon_single_button_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.single_btn);
            if (this.f15971d != null) {
                button.setText(this.f15971d);
            }
            if (this.f15970c != null) {
                textView.setText(this.f15970c);
            }
            if (this.f15972e != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3815d.this.f15968a.dismiss();
                        C3815d.this.f15972e.onClick(C3815d.this.f15968a, -2);
                    }
                });
            }
            C3658ar.m7612a(this.f15969b.getAssets(), textView, button);
            this.f15968a.setCanceledOnTouchOutside(this.f15973f);
            this.f15968a.setContentView(inflate);
            Window window = this.f15968a.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15969b) > ((float) C2271p.m12871a(this.f15969b)) ? C2271p.m12860b(this.f15969b) : C2271p.m12871a(this.f15969b)) * 1032.0f) / 1920.0f);
            window.setAttributes(attributes);
            this.f15968a.getWindow().getDecorView().setBackgroundColor(0);
            return this.f15968a;
        }

        /* renamed from: b */
        public C3815d m6969b(String str) {
            this.f15971d = str;
            return this;
        }

        /* renamed from: b */
        public DialogC3800f m6971b() {
            return this.f15968a;
        }
    }

    /* renamed from: com.fimi.soul.view.f$e */
    /* loaded from: classes.dex */
    public static class C3817e {

        /* renamed from: a */
        private Context f15975a;

        /* renamed from: b */
        private String f15976b;

        /* renamed from: c */
        private String f15977c;

        /* renamed from: e */
        private String f15979e;

        /* renamed from: f */
        private int f15980f;

        /* renamed from: g */
        private CharSequence f15981g;

        /* renamed from: h */
        private CharSequence f15982h;

        /* renamed from: i */
        private DialogInterface.OnClickListener f15983i;

        /* renamed from: d */
        private int f15978d = 0;

        /* renamed from: j */
        private boolean f15984j = false;

        /* renamed from: k */
        private boolean f15985k = false;

        public C3817e(Context context) {
            this.f15975a = context;
        }

        /* renamed from: a */
        private void m6966a(TextView textView) {
            textView.getPaint().setFakeBoldText(true);
        }

        /* renamed from: a */
        public C3817e m6967a(int i) {
            this.f15978d = i;
            return this;
        }

        /* renamed from: a */
        public C3817e m6964a(CharSequence charSequence) {
            this.f15981g = charSequence;
            return this;
        }

        /* renamed from: a */
        public C3817e m6963a(String str) {
            this.f15976b = str;
            return this;
        }

        /* renamed from: a */
        public C3817e m6962a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15983i = onClickListener;
            this.f15977c = str;
            return this;
        }

        /* renamed from: a */
        public C3817e m6961a(boolean z) {
            this.f15984j = z;
            return this;
        }

        @TargetApi(16)
        /* renamed from: a */
        public DialogC3800f m6968a() {
            LayoutInflater layoutInflater = (LayoutInflater) this.f15975a.getSystemService("layout_inflater");
            final DialogC3800f dialogC3800f = new DialogC3800f(this.f15975a, C2300R.style.DropDialog1);
            View inflate = (this.f15979e == null && this.f15982h == null) ? layoutInflater.inflate(C2300R.layout.usb_share_dialog, (ViewGroup) null) : layoutInflater.inflate(C2300R.layout.dialog_content_image, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            ImageView imageView = (ImageView) inflate.findViewById(C2300R.C2302id.imageview);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.single_btn);
            if (this.f15978d != 0) {
                imageView.setBackground(this.f15975a.getResources().getDrawable(this.f15978d));
            }
            if (this.f15976b != null) {
                textView.setText(this.f15976b);
            }
            if (this.f15981g != null) {
                textView.setText(this.f15981g);
            }
            if (this.f15977c != null) {
                button.setText(this.f15977c);
            }
            if (this.f15983i != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.f.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3800f.dismiss();
                        C3817e.this.f15983i.onClick(dialogC3800f, -2);
                    }
                });
            }
            if (this.f15979e != null) {
                TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.content_tv);
                textView2.setText(this.f15979e);
                C3658ar.m7612a(this.f15975a.getAssets(), textView2);
            }
            if (this.f15982h != null) {
                TextView textView3 = (TextView) inflate.findViewById(C2300R.C2302id.content_tv);
                textView3.setText(this.f15982h);
                C3658ar.m7612a(this.f15975a.getAssets(), textView3);
            }
            if (this.f15984j) {
                m6966a(textView);
            }
            if (this.f15980f != 0) {
                textView.setTextColor(this.f15980f);
            }
            C3658ar.m7612a(this.f15975a.getAssets(), textView, button);
            dialogC3800f.setCanceledOnTouchOutside(this.f15985k);
            dialogC3800f.setContentView(inflate);
            Window window = dialogC3800f.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15975a) > ((float) C2271p.m12871a(this.f15975a)) ? C2271p.m12860b(this.f15975a) : C2271p.m12871a(this.f15975a)) * 1032.0f) / 1920.0f);
            window.setAttributes(attributes);
            dialogC3800f.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3800f;
        }

        /* renamed from: b */
        public C3817e m6960b(int i) {
            this.f15980f = i;
            return this;
        }

        /* renamed from: b */
        public C3817e m6959b(CharSequence charSequence) {
            this.f15982h = charSequence;
            return this;
        }

        /* renamed from: b */
        public C3817e m6958b(String str) {
            this.f15977c = str;
            return this;
        }

        /* renamed from: c */
        public C3817e m6957c(String str) {
            this.f15979e = str;
            return this;
        }
    }

    public DialogC3800f(Context context) {
        super(context);
    }

    public DialogC3800f(Context context, int i) {
        super(context, i);
    }

    public DialogC3800f(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
