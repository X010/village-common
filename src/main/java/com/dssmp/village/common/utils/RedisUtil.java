package com.dssmp.village.common.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class RedisUtil {

    private JedisPool jedisPool;


    public RedisUtil(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    /**
     * 累加数据
     *
     * @param key
     * @param hashKey
     * @param number
     */
    public void mSetIncr(String key, String hashKey, int number) {
        Jedis jedis = jedisPool.getResource();
        jedis.hincrBy(key, hashKey, number);
        jedisPool.returnResource(jedis);
    }

    /**
     * 累加数据
     *
     * @param key
     * @param hashKey
     * @param number
     */
    public void mSet(String key, String hashKey, int number) {
        Jedis jedis = jedisPool.getResource();
        jedis.hset(key, hashKey, String.valueOf(number));
        jedisPool.returnResource(jedis);
    }

    /**
     * 删除KEY
     *
     * @param key
     */
    public void delete(String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.del(key);
        jedisPool.returnResource(jedis);
    }

    /**
     * 累加数据
     *
     * @param key
     * @param hashKey
     * @param number
     */
    public void mSet(String key, String hashKey, String number) {
        Jedis jedis = jedisPool.getResource();
        jedis.hset(key, hashKey, number);
        jedisPool.returnResource(jedis);
    }

    /**
     * 设置
     *
     * @param key
     * @param value
     */
    public void setKey(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedisPool.returnResource(jedis);
    }


    /**
     * 缓存数据并设置过期时间
     *
     * @param key
     * @param value
     * @param tt
     */
    public void setKey(String key, String value, int tt) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedis.expire(key, tt);
        jedisPool.returnResource(jedis);
    }

    /**
     * 获取Hash Field的数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public String getKey(String key, String hashKey) {
        String value = null;
        Jedis jedis = jedisPool.getResource();
        value = jedis.hget(key, hashKey);
        jedisPool.returnResource(jedis);
        return value;
    }


    /**
     * 获取多个KEY值
     *
     * @param keys
     * @return
     */
    public List<String> mget(String... keys) {
        Jedis jedis = jedisPool.getResource();
        List<String> result = jedis.mget(keys);
        jedisPool.returnResource(jedis);
        return result;
    }

    /**
     * 获取缓存数据
     *
     * @param key
     * @return
     */
    public String getKey(String key) {
        String value = null;
        Jedis jedis = jedisPool.getResource();
        value = jedis.get(key);
        jedisPool.returnResource(jedis);
        return value;
    }

    /**
     * 获取多个
     *
     * @param key
     * @return
     */
    public Set<String> getKeys(String key) {
        Set<String> value = null;
        Jedis jedis = jedisPool.getResource();
        value = jedis.keys(key);
        jedisPool.returnResource(jedis);
        return value;
    }

    public void usePipelineWriteRedis(Map<String, String> values) {
        Jedis jedis = jedisPool.getResource();
        Pipeline pl = jedis.pipelined();
        try {
            Set<String> keys = values.keySet();
            for (String key : keys) {
                pl.set(key, values.get(key));
            }
            pl.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        jedisPool.returnResource(jedis);
    }
}
