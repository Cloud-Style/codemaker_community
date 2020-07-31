package com.codemaker.community.dto.github;

import com.codemaker.community.enumerate.GithubAuthorizeConstEnum;

/**
 * @author 马洁
 * @date 2020/7/30 - 20:35
 */
public class ObtainAccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

    public ObtainAccessTokenDTO() {
        client_id = GithubAuthorizeConstEnum.CLIENT_ID.getValue();
        client_secret = GithubAuthorizeConstEnum.CLIENT_SECRET.getValue();
        redirect_uri = GithubAuthorizeConstEnum.CALL_BACK_URL.getValue();
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
