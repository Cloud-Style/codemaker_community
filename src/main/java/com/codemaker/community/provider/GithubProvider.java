package com.codemaker.community.provider;

import com.alibaba.fastjson.JSON;
import com.codemaker.community.dto.github.AccessTokenDTO;
import com.codemaker.community.dto.github.GithubUser;
import com.codemaker.community.dto.github.ObtainAccessTokenDTO;
import com.codemaker.community.util.HttpUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 马洁
 * @date 2020/7/30 - 20:34
 */
@Component
public class GithubProvider {
    public AccessTokenDTO getAccessTokenDTO(ObtainAccessTokenDTO tokenDTO) throws IOException {
        String jsonToken = JSON.toJSONString(tokenDTO);
//        System.out.println("jsonToken = " + jsonToken);
        String res = HttpUtil.post(ConstEnum.POST_TOKEN_URL.value, jsonToken);

        System.out.println(res);
        return AccessTokenDTO.initByStr(res);
    }

    public GithubUser getGithubUser(String accessToken) throws IOException {
        String finalUrl = ConstEnum.GET_USER_URL.value + "?access_token=" + accessToken;
        System.out.println("finalUrl = " + finalUrl);

        String reqRes = HttpUtil.get(finalUrl);

        System.out.println("reqRes" + reqRes);

        return JSON.parseObject(reqRes, GithubUser.class);
    }

    enum ConstEnum {
        GET_USER_URL("https://api.github.com/user"),
        POST_TOKEN_URL("https://github.com/login/oauth/access_token");

        private String value;

        ConstEnum(String url) {
            this.value = url;
        }

        public String getValue() {
            return value;
        }
    }
}
