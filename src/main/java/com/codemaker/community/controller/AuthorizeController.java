package com.codemaker.community.controller;

import com.codemaker.community.dto.github.AccessTokenDTO;
import com.codemaker.community.dto.github.GithubUser;
import com.codemaker.community.dto.github.ObtainAccessTokenDTO;
import com.codemaker.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @author 马洁
 * @date 2020/7/30 - 20:28
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider provider;

    @RequestMapping("/login/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) throws IOException {

        ObtainAccessTokenDTO tokenDTO = new ObtainAccessTokenDTO();
        tokenDTO.setCode(code);
        tokenDTO.setState(state);

        AccessTokenDTO accessTokenDTO = provider.getAccessTokenDTO(tokenDTO);

//        System.out.println(accessTokenDTO);
        GithubUser user = provider.getGithubUser(accessTokenDTO.getToken());

        System.out.println(user);
        return "index";
    }
}
