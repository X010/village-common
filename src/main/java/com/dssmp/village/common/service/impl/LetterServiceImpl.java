package com.dssmp.village.common.service.impl;

import com.dssmp.village.common.model.Letter;
import com.dssmp.village.common.service.LetterService;
import org.springframework.stereotype.Service;

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
@Service
public class LetterServiceImpl implements LetterService {


    @Override
    public Letter smtp(Letter letter) {
        return null;
    }

    @Override
    public List<Letter> pop(Letter letter) {
        return null;
    }
}
