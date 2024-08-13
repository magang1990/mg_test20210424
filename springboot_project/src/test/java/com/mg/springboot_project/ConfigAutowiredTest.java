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

    @Value("#{'${sso.oauth2.client.white-list1:}'.split(',')}")
    //private List<String> ssoOauth2ClientWhiteList1;
    private Set<String> ssoOauth2ClientWhiteList1;

    //@Value("${sso.oauth2.client.white-list3:}")
    @Value("${sso.oauth2.client.white-list2:}")
    private String ssoOauth2ClientWhiteList2;

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

}
