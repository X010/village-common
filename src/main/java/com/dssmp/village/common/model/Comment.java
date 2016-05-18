package com.dssmp.village.common.model;

import java.util.Date;

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
public class Comment extends ID {

    /**
     * 商品ID
     */
    private long pid;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 消息
     */
    private String message;


    /**
     * 用户ID
     */
    private long passport_id;


    /**
     * 票据
     */
    private String ticket;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String photo;

    /**
     * 状态
     */
    private int status;

    public Comment() {

    }

    public Comment(long pid, Date create_time, String message) {
        this.pid = pid;
        this.create_time = create_time;
        this.message = message;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(long passport_id) {
        this.passport_id = passport_id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
