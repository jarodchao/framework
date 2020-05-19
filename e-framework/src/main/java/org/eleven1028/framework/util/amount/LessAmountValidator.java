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
package org.eleven1028.framework.util.amount;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.util.condition.Condition;
import org.eleven1028.framework.util.condition.ConditionalOperations;
import org.eleven1028.framework.util.validate.ConditionValidator;

import java.math.BigDecimal;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
public class LessAmountValidator extends ConditionValidator {

    public LessAmountValidator(Condition condition) {
        super(condition);
    }

    public static LessAmountValidator of(ErrorInfo errorInfo, BigDecimal left, BigDecimal right) {

        ConditionalOperations operations =
                objects -> AmountUtils.lessOther(AmountUtils.toAmount(objects[0]),AmountUtils.toAmount(objects[1]));

        return new LessAmountValidator(Condition.of(operations, left, right));

    }

    public static LessAmountValidator of(ErrorInfo errorInfo, BigDecimal left) {

        ConditionalOperations operations =
                objects -> AmountUtils.lessZero(AmountUtils.toAmount(objects[0]));

        return new LessAmountValidator(Condition.of(operations, left));

    }
}
