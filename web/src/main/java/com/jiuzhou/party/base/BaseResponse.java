/*
 * Copyright (c) 2017-2018, Cardinal Operations and/or its affiliates. All rights reserved.
 * CARDINAL OPERATIONS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiuzhou.party.base;

/**
 * @author code-generator
 * @date 2019-03-18
 */
public class BaseResponse<T> {
    /**
    * 返回的Code
    */
    protected String code;
    /**
    * 返回信息的详细描述
    */
    protected String message;
    /**
    * 返回的数据域
    */
    private T data;

    /**
    * Default constructor
    */
    public BaseResponse() {
        this.code = String.valueOf(0);
        this.message = "操作成功";
    }
    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
    return this.code;
    }

    public String getMessage() {
    return this.message;
    }

    public T getData() {
    return data;
    }

    public void setData(T data) {
    this.data = data;
    }
}
