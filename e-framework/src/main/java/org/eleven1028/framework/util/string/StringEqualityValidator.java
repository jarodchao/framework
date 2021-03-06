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
package org.eleven1028.framework.util.string;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.util.condition.Condition;
import org.eleven1028.framework.util.condition.ConditionalOperations;
import org.eleven1028.framework.util.validate.ConditionValidator;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
public class StringEqualityValidator extends ConditionValidator {

    public StringEqualityValidator(Condition condition, ErrorInfo errorInfo) {
        super(condition, errorInfo);
    }

    public static StringEqualityValidator of(ErrorInfo errorInfo, String left, String right) {
        ConditionalOperations operations =
                objects -> StringUtils.isEqual((String) objects[0], (String) objects[1]);

        return new StringEqualityValidator(Condition.of(operations, left, right), errorInfo);
    }

    public static StringEqualityValidator of(ErrorInfo errorInfo, String left) {
        ConditionalOperations operations =
                objects -> StringUtils.isEqual((String) objects[0], null);

        return new StringEqualityValidator(Condition.of(operations, left), errorInfo);
    }
}
