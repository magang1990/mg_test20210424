package com.mg.springboot_project;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.mg.mgdemospringbootstarter.service.MgDemoService;
import com.mg.springboot_project.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ①@Value也可以支持复杂数据结构，但是必须使用spEl表达式。
 * spEL表达式使用yml的配置，配置值必须加""括起来。properties则正常。
 *
 * ②@ConfigurationProperties支持复杂数据结构，包括对象，集合（List，Map），数组等
 *
 * @author mg
 * @date 2023-06-19
 */
@SpringBootTest
public class ConfigAutowiredTest {

    @Autowired
    MgDemoService mgDemoService;

    @Value("${mg.demo.name}")
    private String name;

    @Value("武汉市")
    private String address;

    @Test
    public void run(){
        String message = mgDemoService.getAllMessage();
    }

    @Test
    public void run2(){
        System.out.println(name);
    }

    @Test
    public void run3(){
        System.out.println(address);
    }

    @Value("#{'${sso.oauth2.client.white-list1:}'.split(',')}")//配置为空的时候分割成含有一个空串元素的集合
    //private List<String> ssoOauth2ClientWhiteList1;
    private Set<String> ssoOauth2ClientWhiteList1;

    //没有配置时设置为空集合
    //方法一,但是配置有，没设值的时候，相当于配置了一个字符串，字符串切割后就是一个含有空串元素的集合
    //@Value("#{'${sso.oauth2.client.white-list4:,}'.split(',')}")
    @Value("#{'${sso.oauth2.client.white-list4:A,B,C}'.split(',')}")
    //方法二,没配置，就默认值空串，EL表达式判断后取空集合或者null。配置为空串也是EL表达式取空集合或者null
    //@Value("#{'${sso.oauth2.client.white-list4:}'.empty ? null : '${sso.oauth2.client.white-list4:}'.split(',')}")
    //@Value("#{'${sso.oauth2.client.white-list4:}'.empty ? new java.util.ArrayList() : '${sso.oauth2.client.white-list4:}'.split(',')}")
    private List<String> ssoOauth2ClientWhiteList4;

    //@Value("${sso.oauth2.client.white-list3:}")
    @Value("${sso.oauth2.client.white-list2:}")
    private String ssoOauth2ClientWhiteList2;

    //数组默认英文逗号切割成数组
    @Value("${sso.oauth2.client.white-list1:}")
    private String[] ssoOauth2ClientWhiteList1Array;

    public static String appid;

    @Value("${wx.applet.appid}")
    private void setAppid(String appid) {
        ConfigAutowiredTest.appid = appid;
    }

    /**
     * 预立项评估结论更新飞书通知开关
     */
    @Value("${send.pigeon.update.report.enable:false}")
    private Boolean sendPigeonUpdateReportEnable;

    @Value("${http.client.max-connections:88}")
    private int maxConnections = 100;

    @Value("#{${test.great2}}")
    private Map<String,String> great2;

    @Value("#{${test.great4}}")
    private Map<String,String> great4;

    @Test
    public void run5(){
        //List<String> list1 = this.ssoOauth2ClientWhiteList1;
        Set<String> set1 = this.ssoOauth2ClientWhiteList1;
        List<String> ssoOauth2ClientWhiteList4 = this.ssoOauth2ClientWhiteList4;
        String[] ssoOauth2ClientWhiteList1Array = this.ssoOauth2ClientWhiteList1Array;
        String appid2 = ConfigAutowiredTest.appid;
        Boolean sendPigeonUpdateReportEnable = this.sendPigeonUpdateReportEnable;
        String ssoOauth2ClientWhiteList2 = this.ssoOauth2ClientWhiteList2;
        List<String> list = JSONUtil.toBean(ssoOauth2ClientWhiteList2, new TypeReference<List<String>>(){},false);

}

    @Autowired
    TestConfig testConfig;

    @Test
    public void run6(){
        String username = testConfig.getUsername();
        List<String> hobby = testConfig.getHobby();
        Map<String, String> great = testConfig.getGreat();
    }

    @Test
    public void run7(){
        String[] split = ",".split(",");

    }

    /**
     * :后面没有或者properties配了key，没配value，相当于配了空字符串，则flag为null。
     * 用基本数据类型时，配置默认值为空串或者只配key，则会报错。
     */
    @Value("${we.niu.flag:false}")
    private Boolean flag;

    @Test
    public void run8(){


    }

}
