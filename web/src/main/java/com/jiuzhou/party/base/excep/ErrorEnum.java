package com.jiuzhou.party.base.excep;


/**
 * @author wangjiuzhou (jiuzhou@shanshu.ai)
 * @date 2018/03/28
 */
public enum ErrorEnum implements Error {

    PASSWORD_ERROR("10000000", "密码不正确"),
    DAO_NOT_EXIST_ERROR("10000001", "查询数据异常"),
    DAO_UPDATE_ERROR("10000002", "更新数据异常"),
    DAO_PARAM_ERROR("10000003", "DAO层传入参数错误"),
    DAO_DELETE_ERROR("10000004", "DAO层删除数据错误"),

//    信息维护调用相关的异常提示：
    USERNAME_HAS_ALREADY_EXISTED("10010001", "用户名已经存在"),
    USER_MOBILE_HAS_ALREADY_EXISTED("10010002", "手机号码已经存在"),
    USER_IS_EMPTY( "10010003", "用户参数为空"),
    USER_MOBILE_IS_EMPTY( "10010004", "手机参数为空"),
    USER_USERNAME_IS_EMPTY( "10010005", "用户名参数为空"),
    USER_PASSWORD_IS_EMPTY( "10010006", "密码参数为空"),
    USERNAME_QUERY_MANY_RESULTS( "10010007", "用户名参数查询到多条数据结果"),
    QUOTA_QUERY_KEY_RESOURCECODE_NOT_EMPTY( "10010008", "额度精准查询key,资源code不得为空"),
    KEY_NAME_IS_REPEAT( "10010009", "key名字在当前公司已重复"),
    COMPANY_CODE_KEY_NAME_QUERY_MANY_RESULTS("10010010", "公司code、keyName查询到多条数据结果"),

    COMPANY_BUSINESSLICENSE_IS_EMPTY("10010011", "公司营业执照编号为空"),
    USER_IS_NOT_AVAILABLE( "10010012", "用户存在，但是无效用户"),
    QUOTA_TYPE_IS_NOT_SUPPORT("10010013", "额度计费不支持"),
    QUOTA_KEY_RESOURCECODE_QUERY_MANY_RESULTS( "10010014", "额度查询key,资源code查询到多条数据结果"),
    PARAM_NOT_RIGHT( "10010015", "参数不正确请核实参数"),
    ACCESSKEY_IS_EMPTY( "10010016", "Accesskey参数为空"),
    KEY_QUERY_MANY_RESULTS("10010017", "key参数查询到多条accessKey数据结果"),
    COMPANY_NAME_IS_EMPTY("10010018", "公司名称为空"),
    QUOTA_IS_NOT_EXIST( "10010019", "额度信息不存在或者额度已到期，请购买"),
    APP_UPDATE_FAILED( "10010020", "APP更新失败"),

    //10010020-10010030
    ACCESSKEY_NAME_IS_EMPTY( "10010021", "accessKey name 不得为空"),
    ACCESSKEY_COMPANY_CODE_IS_EMPTY( "10010022", "accessKey company code 不得为空"),
    RESOURCE_CODE_IS_EMPTY( "10010023", "resource code 不得为空"),
    KEY_RESOURCE_CODE_IS_NOT_EXIT( "10010024", "key resource code 组合不存在"),
    SERVER_EXCEPTION( "10010025", "服务异常！请联系服务相关管理员"),
//    10010026/10010027保留字段

    USER_CODE_IS_NOT_EXISTED("10010031", "用户code查询不存在"),
    USER_EMAIL_IS_EMPTY( "10010032", "用户邮箱为空"),
    USER_EMAIL_QUERY_MANY_RESULTS("10010033", "用户邮箱查询到多条数据结果"),
    USER_EMAIL_HAS_ALREADY_EXISTED("10010034", "用户邮箱已经存在"),
    USER_REGISTER_TYPE_IS_ERROR("10010035", "用户注册方式错误"),
    USER_MOBILE_QUERY_MANY_RESULTS("10010036", "用户手机查询到多条数据结果"),
    USER_CODE_QUERY_MANY_RESULTS("10010038", "用户code查询到多条数据结果"),
    SYS_ERROR( "10010039", "系统错误"),
    USER_MOBILE_EMAIL_IS_EMPTY( "10010040", "用户手机号、邮箱均为空"),

    USER_LOGIN_IS_EMPTY( "10010041", "用户登录信息为空"),
    USER_LOGIN_IS_ERROR( "10010042", "用户登录认证失败，请重新登录"),
    COMPANY_CODE_QUERY_MANY_RESULTS("10010043", "公司code查询到多条数据结果"),
    COMPANY_CODE_IS_NOT_EXISTED("10010044", "公司code无效"),
    COMPANY_CODE_IS_EMPTY("10010045", "公司code为空"),
    ACCESSKEY_NAME_EMPTY( "10010046", "AccesskeyDTO中的name参数为空"),
    ACCESSKEY_USERCODE_EMPTY( "10010047", "AccesskeyDTO中的userCode参数为空"),
    USER_COMPANY_IS_NOT_EXISTED("10010048", "用户公司映射关系不存在"),
    COMPANY_BUSINESS_CODE_IS_EMPTY("10010049", "公司业务编码/英文名称不能为空"),


    //    api调用相关的异常提示
    SIGN_NO_RIGHT( "10011000", "签名不合法"),
    COMPANY_IS_NOT_AVAILABLE( "10011001", "用户公司信息失效"),
    API_PATH_NOT_EXIST( "10011002", "api资源路径不存在"),
    KEY_TOKEN_IS_EMPTY( "10011003", "key令牌参数为空"),
    KEY_TOKEN_IS_NOT_RIGHT("10011004", "key 令牌不合法"),
    KEY_TOKEN_IS_EXPIRED("10011005", "key 令牌过期，请重新获取"),
    KEY_RESOURCECODE_QUOTA_IS_EXPIRED("10011006", "时间额度已过期，请重新购买"),
    KEY_RESOURCECODE_TIMES_QUOTA_IS_NULL("10011007", "调用次数额度已无，请重新购买"),
    TIMESTAMP_NO_RIGHT( "10011008", "时间戳不合法"),
    KEY_IS_NOT_AVAILABLE( "10011009", "key是无效的"),
    KEY_RESOURCE_FREQUENCY_IS_NULL( "110011010", "请求超频！"),
    COMPANY_PATH_NOT_EXIST( "110011011", "company路径不存在"),
    API_PATH_NOT_PERMISSION( "110011012", "没有当前路径的访问权限"),
    BLACK_IP("10011013", "IP为黑名单"),
    //    api调用相关的异常提示：

    ;

    private String code;
    private String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{'code':" + this.code + ",'message':" + this.message + "}";
    }


    /*public static HttpError getError(String code){
        for (ErrorEnum httpErrorEnum:ErrorEnum.values()){
            if (httpErrorEnum.getCode().equals(code)){
                return httpErrorEnum;
            }
        }
        return null;
    }*/
}
