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

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-19
 */
public class StringUtils {

    public static boolean isEqual(String left, String right) {
        return left.equals(right);
    }

    public static boolean lengthEqual(String left, String right) {
        return left.length() == right.length();
    }

    public static boolean lengthEqual(String left,int length) {
        return left.length() == length;
    }

    public static boolean lessLength(String left, int length) {
        return left.length() < length;
    }

    public static boolean lessLength( int length,String right) {
        return length < right.length();
    }

}
