package com.dssmp.village.common.utils;

import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;

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
public class RequestUtil {


    /**
     * 获取默认值
     *
     * @param request
     * @param paraName
     * @param def
     * @return
     */
    public static int getInt(HttpServletRequest request, String paraName, int def) {
        int res = def;
        String value = request.getParameter(paraName);
        if (!Strings.isNullOrEmpty(value)) res = Integer.valueOf(value);
        return res;
    }

    /**
     * 请求参数获取String类型
     *
     * @param request
     * @param parameter
     * @param defau
     * @return
     */
    public static String getString(HttpServletRequest request, String parameter, String defau) {
        String defaultValue = request.getParameter(parameter);
        if (Strings.isNullOrEmpty(defaultValue)) return defau;
        return defaultValue;
    }

    /**
     * 获取Double公司
     *
     * @param request
     * @param parameter
     * @param defau
     * @return
     */
    public static double getDouble(HttpServletRequest request, String parameter, double defau) {
        String defaultValue = request.getParameter(parameter);
        if (!Strings.isNullOrEmpty(defaultValue)) return Double.valueOf(defaultValue);
        return defau;
    }


    /**
     * 获取默认值
     *
     * @param request
     * @param paraName
     * @param def
     * @return
     */
    public static long getLong(HttpServletRequest request, String paraName, long def) {
        long res = def;
        String value = request.getParameter(paraName);
        if (!Strings.isNullOrEmpty(value)) res = Long.valueOf(value);
        return res;
    }

    /**
     * 验证参数
     *
     * @param request
     * @param parms
     * @return
     */
    public static String vailParam(HttpServletRequest request, String... parms) {
        String result = null;
        for (String para : parms) {
            String def = request.getParameter(para);
            if (Strings.isNullOrEmpty(def)) {
                result = String.format("parameter [%s] is null", para);
                break;
            }
        }
        return result;
    }
}
