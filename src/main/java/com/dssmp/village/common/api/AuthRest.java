package com.dssmp.village.common.api;

import com.dssmp.village.common.model.Passport;
import com.dssmp.village.common.model.RM;
import com.dssmp.village.common.service.AuthService;
import com.dssmp.village.common.utils.JsonParser;
import com.dssmp.village.common.utils.RequestUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@RestController
@RequestMapping(value = "auth2")
public class AuthRest extends BaseRest {

    @Autowired
    private AuthService authService;

    /**
     * 获取验证
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "auth")
    public void auth(HttpServletRequest request, HttpServletResponse response) {
        RM<Passport> passport = new RM<Passport>();
        String res = null;
        String username = RequestUtil.getString(request, "username", null);
        String password = RequestUtil.getString(request, "password", null);
        String vail = RequestUtil.vailParam(request, "username", "password");
        if (Strings.isNullOrEmpty(vail)) {
            Passport user = new Passport(username, "", "", password);
            user = this.authService.auth(user);
            if (!Strings.isNullOrEmpty(user.getTicket())) {
                passport.setData(user);
            } else {
                passport.setStatus(403);
                passport.setMessage("用户或密码错误");
            }
        } else {
            passport.setStatus(400);
            passport.setMessage(vail);
        }
        res = JsonParser.simpleJson(passport);
        this.response_write(request, response, res);
    }

    /**
     * 根据Token获取用户信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "token")
    public void token(HttpServletRequest request, HttpServletResponse response) {
        RM<Passport> passport = new RM<Passport>();
        String res = null;
        String token = RequestUtil.getString(request, "token", null);
        String vail = RequestUtil.vailParam(request, "token");
        if (Strings.isNullOrEmpty(vail)) {
            Passport user = this.authService.token(token);
            if (user!=null&&!Strings.isNullOrEmpty(user.getTicket())) {
                passport.setData(user);
            } else {
                passport.setStatus(403);
                passport.setMessage("用户没有登陆");
            }
        } else {
            passport.setStatus(400);
            passport.setMessage(vail);
        }
        res = JsonParser.simpleJson(passport);
        this.response_write(request, response, res);
    }

    /**
     * 退出
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        RM<String> rm = new RM<String>();
        String res = null;
        String token = RequestUtil.getString(request, "token", null);
        String vail = RequestUtil.vailParam(request, "token");
        if (!Strings.isNullOrEmpty(token)) {
            this.authService.logout(token);
        } else {
            rm.setStatus(400);
            rm.setMessage(vail);
        }
        res = JsonParser.simpleJson(rm);
        this.response_write(request, response, res);
    }


    /**
     * 注册用户
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "register")
    public void register(HttpServletRequest request, HttpServletResponse response) {
        RM<Passport> passport = new RM<Passport>();
        String res = null;
        String username = RequestUtil.getString(request, "username", null);
        String nickname = RequestUtil.getString(request, "nickname", null);
        String phone = RequestUtil.getString(request, "phone", null);
        String password = RequestUtil.getString(request, "password", null);
        String vail = RequestUtil.vailParam(request, "username", "nickname", "phone", "password");
        if (Strings.isNullOrEmpty(vail)) {
            Passport user = new Passport(username, nickname, phone, password);
            user = this.authService.register(user);
            if (!Strings.isNullOrEmpty(user.getTicket())) {
                passport.setData(user);
            } else {
                passport.setStatus(403);
                passport.setMessage("用户已经存在");
            }
        } else {
            passport.setStatus(400);
            passport.setMessage(vail);
        }
        res = JsonParser.simpleJson(passport);
        this.response_write(request, response, res);
    }
}
