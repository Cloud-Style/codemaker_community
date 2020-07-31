package com.codemaker.community.enumerate;

/**
 * @author 马洁
 * @date 2020/7/30 - 21:23
 */
public enum GithubAuthorizeConstEnum {
    CLIENT_ID("a5b6225737963e915d08"),
    CLIENT_SECRET("420806d89560dec8708504ba893a24acefbf4510"),
    HOME_PAGE_URL("http://localhost:8081"),
    CALL_BACK_URL("http://localhost:8081/login/callback");

    private final String value;

    GithubAuthorizeConstEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
