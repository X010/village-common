package com.dssmp.village.common.model;

import com.alibaba.fastjson.annotation.JSONField;

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
public class Passport extends ID {


    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 当前小区ID
     */
    private long current_village;

    /**
     * 当前小区名称
     */
    private String current_village_name;

    /**
     * 图片地址
     */
    private String photo;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private int sex;

    /**
     * 状态
     */
    private int status;

    /**
     * 票据
     */
    private String ticket;

    public Passport() {

    }

    public Passport(String username, String nickname, String phone, String password) {
        this.username = username;
        this.nickname = nickname;
        this.phone = phone;
        this.password = password;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCurrent_village() {
        return current_village;
    }

    public void setCurrent_village(long current_village) {
        this.current_village = current_village;
    }

    public String getCurrent_village_name() {
        return current_village_name;
    }

    public void setCurrent_village_name(String current_village_name) {
        this.current_village_name = current_village_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
