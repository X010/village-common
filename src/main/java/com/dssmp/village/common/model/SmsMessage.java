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
public class SmsMessage  extends ID {

    /**
     * Message ID
     */
    private long id;

    /**
     * 发送手机号码
     */
    private String phone;

    /**
     * 发送消息
     */
    private String message;

    /**
     * 发送时间
     */
    private Date createTime;

    /**
     * 发送状态
     */
    private int status;

    /**
     * 发送来源
     */
    private String sourceFrom;

    /**
     * 模板标识
     */
    private String tempcode;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 签名
     */
    private String freeSign;

    public SmsMessage() {

    }

    public String getFreeSign() {
        return freeSign;
    }

    public void setFreeSign(String freeSign) {
        this.freeSign = freeSign;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getTempcode() {
        return tempcode;
    }

    public void setTempcode(String tempcode) {
        this.tempcode = tempcode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }
}
