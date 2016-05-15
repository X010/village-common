package com.dssmp.village.common.service.impl;

import com.dssmp.village.common.config.ApplicationConfiguration;
import com.dssmp.village.common.model.GeoBaidu;
import com.dssmp.village.common.service.GeoService;
import com.dssmp.village.common.utils.HttpClientUtil;
import com.dssmp.village.common.utils.JsonParser;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
public class GeoServiceImpl implements GeoService {

    @Autowired
    private ApplicationConfiguration applicationConfig;

    @Override
    public GeoBaidu geoBaidu(double x, double y) throws IOException {
        GeoBaidu geoBaidu = null;
        String location = this.applicationConfig.getGeocoder().replace("${1}", (x + "," + y));
        HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
        String response = httpClientUtil.getGetResponseAsString(location);
        if (!Strings.isNullOrEmpty(response)) {
            geoBaidu = (GeoBaidu) JsonParser.StringToJsonVideo(response, GeoBaidu.class);
        }
        return geoBaidu;
    }
}
