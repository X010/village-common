package com.dssmp.village.common.api;

import com.dssmp.village.common.model.RM;
import com.dssmp.village.common.model.Step;
import com.dssmp.village.common.service.StepService;
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
@RequestMapping(value = "step")
public class StepRest extends BaseRest {

    @Autowired
    private StepService stepService;


    /**
     * 顶
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "top")
    public void top(HttpServletRequest request, HttpServletResponse response) {
        String res = null;
        RM<String> rm = new RM<String>();
        String vail = RequestUtil.vailParam(request, "pid");
        if (!Strings.isNullOrEmpty(vail)) {
            long pid = RequestUtil.getLong(request, "pid", 0);
            Step step = new Step(pid);
            this.stepService.step(step);
        } else {
            rm.setStatus(400);
            rm.setMessage(vail);
        }
        res = JsonParser.simpleJson(rm);
        this.response_write(request, response, res);
    }

    /**
     * 踩
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "step")
    public void step(HttpServletRequest request, HttpServletResponse response) {
        String res = null;
        RM<String> rm = new RM<String>();
        String vail = RequestUtil.vailParam(request, "pid");
        if (!Strings.isNullOrEmpty(vail)) {
            long pid = RequestUtil.getLong(request, "pid", 0);
            Step step = new Step(pid);
            this.stepService.peak(step);
        } else {
            rm.setStatus(400);
            rm.setMessage(vail);
        }
        res = JsonParser.simpleJson(rm);
        this.response_write(request, response, res);
    }
}
