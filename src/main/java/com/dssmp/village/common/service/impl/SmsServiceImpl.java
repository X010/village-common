package com.dssmp.village.common.service.impl;

import com.dssmp.village.common.model.SmsMessage;
import com.dssmp.village.common.service.SmsService;
import com.google.common.base.Preconditions;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SmsServiceImpl implements SmsService {
    private final static Logger LOG = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Autowired
    private TaobaoServiceImpl taobaoService;

    /**
     * 发送短信
     *
     * @param smsMessage
     * @return
     */
    public boolean postMessage(SmsMessage smsMessage) {
        Preconditions.checkNotNull(smsMessage);
        boolean res = false;
        TaobaoClient taobaoClient = taobaoService.getTaobaoClient();
        try {
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setSmsType("normal");
            req.setSmsFreeSignName(smsMessage.getFreeSign());
            req.setSmsParamString("{\"code\":\"" + smsMessage.getMessage() + "\",\"product\":\"" + smsMessage.getSystemName() + "\"}");
            req.setRecNum(smsMessage.getPhone());
            req.setSmsTemplateCode(smsMessage.getTempcode());
            AlibabaAliqinFcSmsNumSendResponse rsp = taobaoClient.execute(req);
            LOG.info(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return res;
    }
}
