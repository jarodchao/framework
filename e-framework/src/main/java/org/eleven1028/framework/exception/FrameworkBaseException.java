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


import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-18
 */
public class FrameworkBaseException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "异常信息 CODE:[%s],MESSAGE:[%S]";
    private static final String MULTIPLE_MESSAGE_FORMAT = "异常信息 MESSAGE:[%S]";

    public FrameworkBaseException(Throwable throwable, ErrorCode errorCode, Object... fields) {
        super(String.format(MESSAGE_FORMAT, errorCode.getCode(),
                MessageFormatter.arrayFormat(errorCode.getDesc(), fields).getMessage()), throwable);
    }

    public FrameworkBaseException(Throwable throwable, ErrorInfo... errorInfos) {

        super(String.format(MULTIPLE_MESSAGE_FORMAT, StringUtils.join(ErrorInfo.combinedMessage(errorInfos), "\n")));
    }

    public FrameworkBaseException(ErrorCode errorCode, Object... fields) {
        super(String.format(MESSAGE_FORMAT, errorCode.getCode(),
                MessageFormatter.arrayFormat(errorCode.getDesc(), fields).getMessage()));
    }

    public FrameworkBaseException(ErrorInfo errorInfo) {
        super(errorInfo.errorMessage());
    }

    public FrameworkBaseException(ErrorInfo... errorInfos) {

        super(String.format(MULTIPLE_MESSAGE_FORMAT, StringUtils.join(ErrorInfo.combinedMessage(errorInfos), "\n")));
    }
}
