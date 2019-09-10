package com.jiuzhou.party.controller;

import com.alibaba.fastjson.JSON;
import com.jiuzhou.party.base.BaseResponse;
import com.jiuzhou.party.base.excep.ApiException;
import com.jiuzhou.party.base.excep.ErrorEnum;
import com.jiuzhou.party.constants.SessionConstants;
import com.jiuzhou.party.constants.UserConstants;
import com.jiuzhou.party.utils.IPUtils;
import com.jiuzhou.party.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangjiuzhou (jiuzhou@shanshu.ai)
 * @date 2019/06/29
 */
@RestController
@RequestMapping(value = "/api/v1/user")
@Slf4j
public class UserController{

    @GetMapping(value = "/name")
    public BaseResponse<String> name(HttpServletRequest request){
        BaseResponse<String> response = new BaseResponse<>();
        String username = String.valueOf(request.getSession().getAttribute(SessionConstants.USER_NAME));
        log.info("当前用户名：{}", username);
        response.setData(username);
        return response;
    }

    @PostMapping(value = "/login")
    public BaseResponse<String> login(@RequestBody User user, HttpServletRequest request) throws ApiException {
        BaseResponse<String> response = new BaseResponse<>();
        log.info("登录信息：{}。登陆者IP：{}", JSON.toJSONString(user), IPUtils.getIpAddr(request));
        boolean login = UserConstants.login(user.getUserName(), user.getPassword());
        if (login){
            response.setData(user.getUserName());
            request.getSession().setAttribute(SessionConstants.USER_NAME, user.getUserName());
            return response;
        }else {
            throw new ApiException(ErrorEnum.PASSWORD_ERROR);
        }
    }
}
