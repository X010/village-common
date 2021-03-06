package com.dssmp.village.common.api;

import com.dssmp.village.common.model.Letter;
import com.dssmp.village.common.model.RM;
import com.dssmp.village.common.service.LetterService;
import com.dssmp.village.common.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RestController
@RequestMapping(value = "letter")
public class LetterRest extends BaseRest {

    @Autowired
    private LetterService letterService;


    /**
     * 发送私信
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "smtp")
    public void smtp(HttpServletRequest request, HttpServletResponse response) {
        String res = null;
        RM<Letter> rm = new RM<Letter>();

        res = JsonParser.simpleJson(rm);
        this.response_write(request, response, res);
    }

    /**
     * 接收私信
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "pop")
    public void pop(HttpServletRequest request, HttpServletResponse response) {
        String res = null;
        RM<List<Letter>> rms = new RM<List<Letter>>();


        res = JsonParser.simpleJson(rms);
        this.response_write(request, response, res);
    }
}
