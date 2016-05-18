package com.dssmp.village.common.service.impl;

import com.dssmp.village.common.model.Step;
import com.dssmp.village.common.mybatis.mapper.StepMapper;
import com.dssmp.village.common.service.StepService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
public class StepServiceImpl implements StepService {
    @Autowired
    private StepMapper stepMapper;

    @Override
    public Step step(Step step) {
        Preconditions.checkNotNull(step);
        Step old = this.stepMapper.findStepByPid(step);
        if (old != null && old.getId() > 0) {
            old.setStep(old.getStep() + 1);
            old.setLast_update_time(new Date());
            this.stepMapper.updateById(old);
            step = old;
        } else {
            step.setStep(1);
            step.setLast_update_time(new Date());
            this.stepMapper.insertStep(step);
        }
        return step;
    }

    @Override
    public Step peak(Step step) {
        Preconditions.checkNotNull(step);
        Step old = this.stepMapper.findStepByPid(step);
        if (old != null && old.getId() > 0) {
            old.setPeak(old.getPeak() + 1);
            old.setLast_update_time(new Date());
            this.stepMapper.updateById(old);
            step = old;
        } else {
            step.setPeak(1);
            step.setLast_update_time(new Date());
            this.stepMapper.insertStep(step);
        }
        return step;
    }

    @Override
    public Step info(Step step) {
        return this.stepMapper.findStepByPid(step);
    }
}
