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

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.util.condition.Condition;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
@AllArgsConstructor
public class ConditionValidator {

    @Getter
    private Condition condition;

    private ErrorInfo errorInfo;

    public ConditionValidator(Condition condition) {
        this.condition = condition;
    }

    public ErrorInfo run() {

        return condition.run() ? errorInfo : null;
    }
}
