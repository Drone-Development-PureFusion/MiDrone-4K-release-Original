package com.fimi.soul.module.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.fimi.soul.module.setting.a */
/* loaded from: classes.dex */
public abstract class AbstractC3477a implements AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    private View f13721a;

    /* renamed from: b */
    private ViewGroup f13722b;

    /* renamed from: c */
    private Context f13723c;

    /* renamed from: d */
    private Map<String, View> f13724d = new HashMap();

    /* renamed from: e */
    private LayoutInflater f13725e;

    /* renamed from: f */
    private C2423d f13726f;

    /* renamed from: com.fimi.soul.module.setting.a$a */
    /* loaded from: classes.dex */
    public class C3478a {

        /* renamed from: b */
        private Button f13728b;

        /* renamed from: c */
        private Button f13729c;

        public C3478a() {
        }

        /* renamed from: a */
        public Button m8332a() {
            return this.f13728b;
        }

        /* renamed from: a */
        public void m8331a(Button button) {
            this.f13728b = button;
        }

        /* renamed from: b */
        public Button m8330b() {
            return this.f13729c;
        }

        /* renamed from: b */
        public void m8329b(Button button) {
            this.f13729c = button;
        }
    }

    public AbstractC3477a(Context context) {
        m8350a(context);
        this.f13725e = LayoutInflater.from(context);
        this.f13721a = this.f13725e.inflate(C2300R.layout.layout_camera_setting_main, (ViewGroup) null);
        this.f13722b = (ViewGroup) this.f13721a.findViewById(C2300R.C2302id.lv_viewContent);
    }

    /* renamed from: a */
    private Button m8347a(View view, String str, String str2, View.OnClickListener onClickListener) {
        ((TextView) view.findViewById(C2300R.C2302id.tv_settingTitle)).setText(str);
        Button button = (Button) view.findViewById(C2300R.C2302id.btn_settingAction);
        button.setOnClickListener(onClickListener);
        button.setText(str2);
        m8334e().addView(view);
        return button;
    }

    /* renamed from: a */
    private void m8348a(View view, String str) {
        ((TextView) view.findViewById(C2300R.C2302id.tv_settingTitle)).setText(str);
    }

    /* renamed from: a */
    protected LayoutInflater m8352a() {
        return this.f13725e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Button m8351a(int i, String str, View.OnClickListener onClickListener) {
        return m8341a(m8333f().getText(i).toString(), str, onClickListener);
    }

    /* renamed from: a */
    protected Button m8344a(String str) {
        return m8343a(str, (View.OnClickListener) null);
    }

    /* renamed from: a */
    protected Button m8343a(String str, View.OnClickListener onClickListener) {
        View inflate = this.f13725e.inflate(C2300R.layout.item_setting_center_button, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(C2300R.C2302id.btn_settingAction);
        button.setText(str);
        button.setOnClickListener(onClickListener);
        m8334e().addView(inflate);
        return button;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Button m8341a(String str, String str2, View.OnClickListener onClickListener) {
        return m8347a(m8352a().inflate(C2300R.layout.item_setting_short_button, (ViewGroup) null), str, str2, onClickListener);
    }

    /* renamed from: a */
    protected SwitchButton m8340a(String str, boolean z, SwitchButton.AbstractC2291a abstractC2291a) {
        View inflate = m8352a().inflate(C2300R.layout.item_setting_switch_button, (ViewGroup) null);
        ((TextView) inflate.findViewById(C2300R.C2302id.tv_settingTitle)).setText(str);
        SwitchButton switchButton = (SwitchButton) inflate.findViewById(C2300R.C2302id.sb_settingAction);
        switchButton.setSwitchState(z);
        switchButton.setOnSwitchListener(abstractC2291a);
        m8334e().addView(inflate);
        return switchButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C3478a m8342a(String str, String str2) {
        View inflate = this.f13725e.inflate(C2300R.layout.item_setting_double_button, (ViewGroup) null);
        C3478a c3478a = new C3478a();
        Button button = (Button) inflate.findViewById(C2300R.C2302id.btn_settingActionFirst);
        button.setText(str);
        Button button2 = (Button) inflate.findViewById(C2300R.C2302id.btn_settingActionSecond);
        button2.setText(str2);
        c3478a.m8331a(button);
        c3478a.m8329b(button2);
        m8334e().addView(inflate);
        return c3478a;
    }

    /* renamed from: a */
    protected void m8350a(Context context) {
        this.f13723c = context;
    }

    /* renamed from: a */
    protected void m8349a(LayoutInflater layoutInflater) {
        this.f13725e = layoutInflater;
    }

    /* renamed from: a */
    protected void m8346a(ViewGroup viewGroup) {
        this.f13722b = viewGroup;
    }

    /* renamed from: a */
    public void m8345a(C2423d c2423d) {
        this.f13726f = c2423d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public View m8339b() {
        return this.f13721a;
    }

    /* renamed from: b */
    protected Button m8337b(String str, String str2, View.OnClickListener onClickListener) {
        return m8347a(m8352a().inflate(C2300R.layout.item_setting_long_button, (ViewGroup) null), str, str2, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public EditText m8338b(String str, String str2) {
        View inflate = m8352a().inflate(C2300R.layout.item_setting_edit, (ViewGroup) null);
        m8348a(inflate, str);
        EditText editText = (EditText) inflate.findViewById(C2300R.C2302id.et_settingAction);
        editText.setText(str2);
        m8334e().addView(inflate);
        return editText;
    }

    /* renamed from: c */
    public abstract View mo8322c();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public TextView m8336c(String str, String str2) {
        View inflate = m8352a().inflate(C2300R.layout.item_setting_text, (ViewGroup) null);
        m8348a(inflate, str);
        TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.tv_settingAction);
        textView.setText(str2);
        m8334e().addView(inflate);
        return textView;
    }

    /* renamed from: d */
    public C2423d m8335d() {
        return this.f13726f;
    }

    /* renamed from: e */
    public ViewGroup m8334e() {
        return this.f13722b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public Context m8333f() {
        return this.f13723c;
    }
}
