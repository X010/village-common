package com.dssmp.village.common.api;

import com.dssmp.village.common.model.Comment;
import com.dssmp.village.common.model.RM;
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
@RequestMapping(value = "comments")
public class CommentsRest extends BaseRest {

    @Autowired
    private CommentsRest commentsRest;

    /**
     * 评论
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "discuss")
    public void discuss(HttpServletRequest request, HttpServletResponse response) {
        String res = null;
        RM<String> rm = new RM<String>();


        res = JsonParser.simpleJson(rm);
        this.response_write(request, response, res);
    }

    /**
     * 获取评论
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "message")
    public void message(HttpServletRequest request, HttpServletResponse response) {
        String res = null;
        RM<List<Comment>> rms = new RM<List<Comment>>();


        res = JsonParser.simpleJson(rms);
        this.response_write(request, response, res);
    }
}
