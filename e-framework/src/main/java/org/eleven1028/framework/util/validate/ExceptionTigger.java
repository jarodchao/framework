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


import org.eleven1028.framework.exception.ExtendedExceptionSupplier;
import org.eleven1028.framework.exception.ErrorCode;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkBaseException;

import java.util.function.Predicate;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
public class ExceptionTigger<T extends FrameworkBaseException> {

    private ExtendedExceptionSupplier<T> supplier;

    public static <T extends FrameworkBaseException> ExceptionTigger<T> of(ExtendedExceptionSupplier<T> supplier) {
        return new ExceptionTigger<>(supplier);
    }

    public ExceptionTigger(ExtendedExceptionSupplier<T> supplier) {
        this.supplier = supplier;
    }

    public <T extends Object> void tigger(ErrorInfo errorInfo, Predicate<T> predicate, T t) {

        if (predicate.test(t)) {
            throw supplier.get(errorInfo);
        }
    }

    public <T extends Object> void tigger(ErrorCode errorCode) {
        throw supplier.get(ErrorInfo.of(errorCode));
    }

}
