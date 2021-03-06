package com.dssmp.village.common.service.impl;

import com.dssmp.village.common.config.ApplicationConfiguration;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TaobaoServiceImpl {

    @Autowired
    private ApplicationConfiguration applicationConfig;


    private static TaobaoClient client = null;

    /**
     * 获取实例
     *
     * @return
     */
    public TaobaoClient getTaobaoClient() {
        if (client == null) {
            //新建实例
            client = new DefaultTaobaoClient(applicationConfig.getSmsurl(), applicationConfig.getAppkey(), applicationConfig.getAppsecret());
        }
        return client;
    }
}
