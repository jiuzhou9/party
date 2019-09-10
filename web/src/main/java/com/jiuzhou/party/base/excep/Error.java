/*
 * Copyright (c) 2017-2018, Cardinal Operations and/or its affiliates. All rights reserved.
 * CARDINAL OPERATIONS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.jiuzhou.party.base.excep;

/**
 * @author code-generator
 * @date 2019-04-01
 */
public interface Error {
    /**
     * 返回内部错误的状态码
     *
     * @return 内部错误状态码
     */
    String getCode();

    /**
     * 返回详细的错误说明
     *
     * @return 错误说明
     */
    String getMessage();

    String toString();
}
