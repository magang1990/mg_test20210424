package com.mg.springboot_project.constant;

/**
 * @author hejiazhou
 */
public class PublicConstants {

    /**
     * 权限redis 缓存的特有标记符
     */
    public static final String USERTOKEN = "usertoken";
    public static final String ORDERUNUMBER= "orderNumber";

    public static final String REGISTRATION_VERIFICATION_CODE = "registrationVerificationCode";

    public static final String PAYPASSWORD_VERIFICATION_CODE = "payPasswordVerificationCode";

    public static final String MESSAGETIME = "messagetime";

    /**
     * 微信公众号
     */
    public static final String ACCESS_TOKEN = "access_token";
    public static final String JSAPI_TICKET = "jsapi_ticket";

    /**
     * 技术服务基础配置
     */
    public static final String TECHNICAL = "technical";

    /**
     * 佣金基础配置
     */
    public static final String COMMISSION = "commission";


    /**
     * 商家类型账号
     */
    public static final Integer MERCHANT_ACCOUNT_MARK = 0;

    /**
     * 物流类型账号
     */

    public static final Integer COMPANY_ACCOUNT_MARK = 1;
    /**
     * 后台管理员类型账号
     */

    public static final Integer ADMIN_ACCOUNT_MARK = 2;

    /**
     * 接单员账号类型
     */
    public static final Integer ORDER_TAKER_MARK = 3;
    /**
     * 配送员账号类型
     */
    public static final Integer DELIVERY_PERSON_MARK = 4;
    /**
     * 物流管理员类型
     */
    public static final Integer LOGISTICS_MANAGER = 5;


    /**
     * 商家类型账号角色
     */
    public static final String ROLE_MERCHANT = "ROLE_MERCHANT";

    /**
     * 物流类型账号角色
     */

    public static final String ROLE_COMPANY = "ROLE_COMPANY";
    /**
     * 后台管理员类型账号角色
     */

    public static final String ROLE_ADMIN = "ROLE_ADMIN";


    public static final String EXCHANGE_RATE_CONVERSION_MARK  = "EXCHANGE_RATE_CONVERSION_MARK";
    /**
     * 51tracking 秘钥
     */
    public static final String APIKEY="7cf43ce5-0585-4697-9a92-7985b023ea8f";


    /**
     * 用户操作日志操作标识
     */
    public static final String ACCOUNT_LOG_OPERATING_LOGO =  "ACCOUNT_LOG_OPERATING_LOGO";
    /**
     * 用户浏览日志标识
     */
    public static final String ACCOUNT_LOG_BROWSE_THE_LOGO =  "ACCOUNT_LOG_BROWSE_THE_LOGO";


    public static final String ROLE_GENERAL_ADMIN = "ROLE_GENERAL_ADMIN";
    public static final String ROLE_HEADMAN = "ROLE_HEADMAN";
    public static final String ROLE_SALE = "ROLE_SALE";

    /**
     * 万能验证码
     */
    public static final String NSSB = "NSSB";

    /*
    *
    * */
    public static final String JINGZHUN_TOKEN="JINGZHUN_TOKEN";
}
