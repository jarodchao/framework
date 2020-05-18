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
package org.eleven1028.framework.exception;

import org.eleven1028.framework.util.validate.FieldLengthComparator;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-18
 */
public class ExceptionChecker {

    public static <T extends Object> ErrorInfo check(final ErrorCode errorCode, Predicate<T> predicate, T t) {

        if (predicate.test(t)) {
            return ErrorInfo.of(errorCode);
        }

        return ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER);
    }

    public static <T extends Object> ErrorInfo check(final ErrorCode errorCode, Comparator<T> comparator, T t1, T t2) {

        if (comparator.compare(t1, t2) != 0) {
            return ErrorInfo.of(errorCode);
        }

        return ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER);

    }

    public static ErrorInfo check(final ErrorCode errorCode, FieldLengthComparator<String> comparator,
                                                                                           String str, Integer... lengths) {

        for (Integer length : lengths) {
            if (!comparator.compare(str, length)) {
                return ErrorInfo.of(errorCode);
            }
        }

        return ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER);

    }
}
