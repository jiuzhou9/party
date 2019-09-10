package com.jiuzhou.party.base.excep;

/**
 * @author wangjiuzhou (jiuzhou@shanshu.ai)
 * @date 2018/11/01
 *
 * 灵活的异常，可以设置一个动态的异常
 *
 * 比如result接口：api调用backend的时候，需要将backend返回的某个字段（失败）原因，写在message中，构造一个result
 * 然后把result返回出去。
 */
public class FlexError implements Error {

    private String code;

    private String message;

    public FlexError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "{'code':" + this.code + ",'message':" + this.message + "}";
    }
}
