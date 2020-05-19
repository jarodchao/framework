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
package org.eleven1028.framework.util.validate;

import com.googlecode.aviator.AviatorEvaluator;
import org.eleven1028.framework.util.condition.ConditionGroup;
import org.eleven1028.framework.util.condition.ConditionalExecutionRules;

import java.util.Iterator;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
public class ConditionExecutor {

    private ConditionExecutor(ConditionalExecutionRules rules) {
        this.rules = rules;
    }

    private ConditionalExecutionRules rules;

    public static ConditionExecutor of(ConditionalExecutionRules rules) {

        return new ConditionExecutor(rules);
    }

    public void execute() {

        StringBuilder expression = new StringBuilder();

        Iterator<ConditionGroup> groupIterator = rules.groups();
        Iterator<String> operators = rules.operators();

        while (groupIterator.hasNext()) {
            ConditionGroup group = groupIterator.next();

            expression.append(group.run());

            if (operators.hasNext()) {
                expression.append(" " + operators.next());
            }
        }

        AviatorEvaluator.execute(expression.toString());
    }
}
