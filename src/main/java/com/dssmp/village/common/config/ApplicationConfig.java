package com.dssmp.village.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
@Configuration
@ConfigurationProperties(locations = "classpath:application.properties", prefix = "application")
public class ApplicationConfig {
    /**
     * SMS地址
     */
    private String smsurl;

    /**
     * SMS APP KEY
     */
    private String appkey;

    /**
     * SMS APP SECRET
     */
    private String appsecret;

    /**
     * 百度的AK值
     */
    private String baiduak;

    /**
     * 将经度等信息转成具体位置信息
     */
    private String geocoder;

    public String getBaiduak() {
        return baiduak;
    }

    public void setBaiduak(String baiduak) {
        this.baiduak = baiduak;
    }

    public String getGeocoder() {
        return geocoder;
    }

    public void setGeocoder(String geocoder) {
        this.geocoder = geocoder;
    }

    public String getSmsurl() {
        return smsurl;
    }

    public void setSmsurl(String smsurl) {
        this.smsurl = smsurl;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}
