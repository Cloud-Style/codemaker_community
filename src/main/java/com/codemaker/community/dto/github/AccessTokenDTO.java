package com.codemaker.community.dto.github;

/**
 * @author 马洁
 * @date 2020/7/30 - 22:04
 */
public class AccessTokenDTO {
    private String token;
    private String tokenType;

    public static AccessTokenDTO initByStr(String str) {

        String[] data = str.split("&");
        if (data.length == 0) {
            return null;
        }

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setToken(data[0].split("=")[1]);
        accessTokenDTO.setTokenType(data[1].split("=")[1]);

        return accessTokenDTO;
    }


    public void setToken(String token) {
        this.token = token;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "token='" + token + '\'' +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
