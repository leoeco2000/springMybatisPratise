package com.mybatis.restful.common.utils;

/**
 * 统一定义所有服务接口返回格式
 *
 * @author henry
 * @date 2017年2月28日 下午8:19:45
 * @version 1.0.0
 *
 */
public class Result {

    /**成功：{\"success\":true,\"error_code\":\"\",\"data\":%s}**/
    public static final String RESULT_SUCCEED ="{\"success\":true,\"error_code\":\"\",\"data\":%s}";

    /**失败：{\"success\":true,\"error_code\":\"\",\"data\":%s}**/
    public static final String RESULT_FAIL =  "{\"success\":false,\"error_code\":\"%s\",\"data\":[]}";


    /**失败,带错误信息：{\"success\":true,\"error_code\":\"\",\"data\":%s}**/
    public static final String RESULT_FAIL_MS =  "{\"success\":false,\"error_code\":\"%s\",\"data\":[{message:\"%s\"}]}";

}