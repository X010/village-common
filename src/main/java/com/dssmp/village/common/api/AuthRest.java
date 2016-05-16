package com.dssmp.village.common.api;

import com.dssmp.village.common.model.Passport;
import com.dssmp.village.common.model.RM;
import com.dssmp.village.common.service.AuthService;
import com.dssmp.village.common.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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


        res = JsonParser.simpleJson(passport);
        this.response_write(request, response, res);
    }
}
