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

import org.apache.commons.lang3.ArrayUtils;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.ExceptionSupplier;
import org.eleven1028.framework.exception.FrameworkBaseException;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
public class FieldValidateExecutor<T extends FrameworkBaseException> {

    private ExceptionSupplier<T> supplier;

    public static <T extends FrameworkBaseException> FieldValidateExecutor of(ExceptionSupplier<T> supplier) {
        return new FieldValidateExecutor<>(supplier);
    }

    public FieldValidateExecutor(ExceptionSupplier<T> supplier) {
        this.supplier = supplier;
    }

    public void execute(FieldValidator... fieldValidators) {

        if (fieldValidators.length == 0) {
            return;
        }

        ErrorInfo[] errorInfos = new ErrorInfo[]{};
        for (FieldValidator fieldValidator : fieldValidators) {
            ArrayUtils.add(errorInfos, fieldValidator.validate());
        }

        if (errorInfos.length > 0) {

            throw supplier.get(errorInfos);
        }

    }

}
