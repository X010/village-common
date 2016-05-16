package com.dssmp.village.common.utils;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
public class RedisPoolUtil implements EnvironmentAware {
    private Logger LOG = LoggerFactory.getLogger(RedisPoolUtil.class);
    private static final int REDIS_POOL_MAXACTIVE = 1024;
    private static final int REDIS_POOL_MAXIDLE = 200;
    private static final int REDIS_POOL_MAXWAIT = 5000;
    private static final boolean REDIS_POOL_TESTONBORROW = true;
    private static final boolean REDIS_TEST_ON_RETURN = true;

    private RelaxedPropertyResolver propertyResolver;


    @Primary
    @Bean(name = "redisUtil")
    public RedisUtil redisUtil() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxActive(REDIS_POOL_MAXACTIVE);
        jedisPoolConfig.setMaxIdle(REDIS_POOL_MAXIDLE);
        jedisPoolConfig.setMaxWait(REDIS_POOL_MAXWAIT);
        jedisPoolConfig.setTestOnBorrow(REDIS_POOL_TESTONBORROW);
        jedisPoolConfig.setTestOnReturn(REDIS_TEST_ON_RETURN);

        int iPort = 6379;
        String port = propertyResolver.getProperty("port");
        if (!Strings.isNullOrEmpty(port)) {
            iPort = Integer.valueOf(port);
        }
        String host = propertyResolver.getProperty("host");
        String password = propertyResolver.getProperty("requirepass");
        return new RedisUtil(new JedisPool(jedisPoolConfig, host, iPort, 100000, password));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "application.redis.");
    }
}
