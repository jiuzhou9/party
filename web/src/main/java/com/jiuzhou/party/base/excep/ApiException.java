/*
 * Copyright (c) 2017-2018, Cardinal Operations and/or its affiliates. All rights reserved.
 * CARDINAL OPERATIONS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.jiuzhou.party.base.excep;

/**
 * @author wangjiuzhou (jiuzhou@shanshu.ai)
 * @date 2018/03/28
 */
public class ApiException extends Exception {

    private String code;
    private String message;


    public ApiException(Error httpError) {
        this.code = httpError.getCode();
        this.message = httpError.getMessage();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Error getHttpError(){
        return new FlexError(code, message);
    }
}
