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

import com.googlecode.aviator.AviatorEvaluator;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
public class ConditionGroup {

    private Condition[] conditions = new Condition[]{};

    private String[] logicalOperators = new String[]{};

    public static ConditionGroup of(Condition condition) {

        ConditionGroup group = new ConditionGroup();

        if (condition != null) {
            group.condition(condition);
        }

        return group;
    }

    public ConditionGroup condition(Condition condition) {

        int insertIndex = conditions.length == 0 ? 0 : conditions.length;
        conditions = ArrayUtils.insert(insertIndex, conditions, condition);
        return this;
    }

    public ConditionGroup and() {

        int insertIndex = logicalOperators.length == 0 ? 0 : logicalOperators.length;
        logicalOperators = ArrayUtils.insert(insertIndex, logicalOperators, "&&");
        return this;
    }

    public ConditionGroup or() {

        int insertIndex = logicalOperators.length == 0 ? 0 : logicalOperators.length;
        logicalOperators = ArrayUtils.insert(insertIndex, logicalOperators, "||");
        return this;
    }

    public boolean run() {

        StringBuilder expression = new StringBuilder("( ");

        Iterator<Condition> conditionIterator = Arrays.asList(conditions).iterator();
        Iterator<String> operators = Arrays.asList(logicalOperators).iterator();

        while (conditionIterator.hasNext()) {
            Condition condition = conditionIterator.next();

            expression.append(condition.run());

            if (operators.hasNext()) {
                expression.append(" " + operators.next() + " ");
            }
        }

        expression.append(" )");

        String executeExpression = expression.toString();
        System.out.println("ConditionGroup Expression: " + executeExpression);
        return (boolean) AviatorEvaluator.execute(executeExpression);
    }

}
