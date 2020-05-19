/*
 * Copyright 2019 The  Project
 *
 * The   Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.eleven1028.framework.util.condition;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
public class ConditionalExecutionRules {

    private ConditionGroup[] conditionGroups = new ConditionGroup[]{};

    private String[] logicalOperators = new String[]{};


    public ConditionalExecutionRules condition(ConditionGroup conditionGroup) {

        int insertIndex = conditionGroups.length == 0 ? 0 : conditionGroups.length;
        conditionGroups = ArrayUtils.insert(insertIndex, conditionGroups, conditionGroup);
        return this;
    }

    public ConditionalExecutionRules and() {

        int insertIndex = logicalOperators.length == 0 ? 0 : logicalOperators.length;
        logicalOperators = ArrayUtils.insert(insertIndex, logicalOperators, "&&");
        return this;
    }

    public ConditionalExecutionRules or() {

        int insertIndex = logicalOperators.length == 0 ? 0 : logicalOperators.length;
        logicalOperators = ArrayUtils.insert(insertIndex, logicalOperators, "||");
        return this;
    }

    public Iterator<ConditionGroup> groups () {
        return Arrays.asList(conditionGroups).iterator();
    }

    public Iterator<String> operators() {
        return Arrays.asList(logicalOperators).iterator();
    }


}
