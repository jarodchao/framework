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
package org.eleven2018.framework.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.helpers.MessageFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-18
 */
@AllArgsConstructor
public class ErrorInfo {

    @Setter
    @Getter
    private ErrorCode errorCode;

    @Setter
    @Getter
    private Object[] fields;

    public static ErrorInfo of(ErrorCode errorCode, Object... fields) {
        return new ErrorInfo(errorCode, fields);
    }

    public String errorMessage() {
        return MessageFormatter.arrayFormat(errorCode.getDesc(), fields).getMessage();
    }

    public static List<String> combinedMessage(ErrorInfo... errorInfos) {
        List<String> message = new ArrayList<>(errorInfos.length);

        for (ErrorInfo errorInfo : errorInfos) {
            message.add(errorInfo.errorMessage());
        }

        return message;
    }
}
