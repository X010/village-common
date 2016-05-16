package com.dssmp.village.common.api;

import com.dssmp.village.common.utils.ConstUtil;
import com.dssmp.village.common.utils.RequestUtil;
import com.dssmp.village.common.utils.ResponseUtil;
import com.google.common.base.Charsets;

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
public abstract class BaseRest {

    /**
     * 将数据写至Response
     *
     * @param request
     * @param response
     * @param message
     */
    public void response_write(HttpServletRequest request, HttpServletResponse response, String message) {
        String callback = RequestUtil.getString(request, "callback", ConstUtil.CALLBACK);
        ResponseUtil.writeResult(response, ResponseUtil.CallBackResultJsonP(message, callback), Charsets.UTF_8.toString());
    }
}