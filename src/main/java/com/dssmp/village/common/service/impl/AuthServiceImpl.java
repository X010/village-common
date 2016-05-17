package com.dssmp.village.common.service.impl;

import com.dssmp.village.common.model.Passport;
import com.dssmp.village.common.mybatis.mapper.AuthMapper;
import com.dssmp.village.common.service.AuthService;
import com.dssmp.village.common.utils.*;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AuthMapper authMapper;

    @Override
    public Passport register(Passport passport) {
        Preconditions.checkNotNull(passport);
        //添加数据
        List<Passport> passports = this.authMapper.findPassportByUsernameAndPhone(passport);
        if (passports == null || passports.size() <= 0) {
            passport.setPassword(MD5Util.MD5(passport.getPassword()));
            this.authMapper.insertPassport(passport);
            String ticket = IDUtil.uuid();
            passport.setTicket(ticket);
            //添加缓存
            this.redisUtil.setKey(ticket, JsonParser.simpleJson(passport), ConstUtil.TIME);
        }
        return passport;
    }

    @Override
    public Passport token(String token) {
        Preconditions.checkNotNull(token);
        String data = this.redisUtil.getKey(token);
        Passport passport = null;
        if (!Strings.isNullOrEmpty(data)) {
            try {
                passport = (Passport) JsonParser.StringToJsonVideo(data, Passport.class);
                this.redisUtil.setKey(passport.getTicket(), data, ConstUtil.TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return passport;
    }

    @Override
    public Passport auth(Passport passport) {
        Preconditions.checkNotNull(passport);
        passport.setPassword(MD5Util.MD5(passport.getPassword()));
        passport = this.authMapper.findPassportByAuth(passport);
        if (passport.getId() > 0) {
            passport.setTicket(IDUtil.uuid());
            this.redisUtil.setKey(passport.getTicket(), JsonParser.simpleJson(passport), ConstUtil.TIME);
        }
        return passport;
    }

    @Override
    public void logout(String token) {
        Preconditions.checkNotNull(token);
        String data = this.redisUtil.getKey(token);
        if (!Strings.isNullOrEmpty(data)) {
            this.redisUtil.delete(token);
        }
    }
}
