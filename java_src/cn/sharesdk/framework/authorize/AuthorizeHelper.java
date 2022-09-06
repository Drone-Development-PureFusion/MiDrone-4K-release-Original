package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;
/* loaded from: classes.dex */
public interface AuthorizeHelper {
    AuthorizeListener getAuthorizeListener();

    String getAuthorizeUrl();

    AbstractC0639b getAuthorizeWebviewClient(C0642e c0642e);

    Platform getPlatform();

    String getRedirectUri();

    SSOListener getSSOListener();

    AbstractC0641d getSSOProcessor(C0640c c0640c);
}
