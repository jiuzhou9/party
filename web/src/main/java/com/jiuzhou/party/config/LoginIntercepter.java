/*
 * Copyright (c) 2017-2018, Cardinal Operations and/or its affiliates. All rights reserved.
 * CARDINAL OPERATIONS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.jiuzhou.party.config;

import com.jiuzhou.party.constants.SessionConstants;
import com.jiuzhou.party.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author wangjiuzhou (jiuzhou@shanshu.ai)
 * @date 2018/05/18
 */
@Slf4j
@Component
public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
                    throws Exception {

        Enumeration<String> headers = httpServletRequest.getHeaderNames();

        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            String value = httpServletRequest.getHeader(name);
//            log.info("REQUEST:: >>>>>>> " + name + ":" + value);
        }
        String requestURI = httpServletRequest.getRequestURI();
//        log.info("请求地址：{}", requestURI);
        String clientIP = IPUtils.getIpAddr(httpServletRequest);
        log.info("客户端真实IP：{}", clientIP);

        if (!requestURI.equals("/api/v1/user/login")){
            HttpSession session = httpServletRequest.getSession();
            String userName = String.valueOf(session.getAttribute(SessionConstants.USER_NAME));
            if (StringUtils.isEmpty(userName) || userName.equals("null")){
//                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/login.html");
//                dealError(httpServletResponse, "请登录！");

                //获取当前请求的路径
                String basePath = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":"  + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
                //告诉ajax我是重定向
                httpServletResponse.setHeader("REDIRECT", "REDIRECT");
                //告诉ajax我重定向的路径
                httpServletResponse.setHeader("redirect-url", basePath+"/user/login.html");
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            }else {
                return true;
            }
        }
        return true;
    }

    /**
     * 封装异常信息
     * @param httpServletResponse
     * @param errorMessage
     * @throws IOException
     */
    private void dealError(HttpServletResponse httpServletResponse, String errorMessage) throws IOException {
        log.error(errorMessage);

        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write("{\"code\":10060000,\"message\":\"" + errorMessage + "\"}");
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}