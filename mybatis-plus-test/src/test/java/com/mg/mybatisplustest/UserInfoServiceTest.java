package com.mg.mybatisplustest;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mg.mybatisplustest.entity.UserInfo;
import com.mg.mybatisplustest.mapstruct.UserInfoMapatruct;
import com.mg.mybatisplustest.request.UserRequest;
import com.mg.mybatisplustest.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mg
 * @date 2023-08-19
 */
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void run(){
        /*List<UserInfo> userInfos = new ArrayList<>();
        UserInfo info1 = new UserInfo("mg",1,"13188888888");
        UserInfo info2 = new UserInfo("ml",1,"15088888888");
        UserInfo info3 = new UserInfo("mch",1,"15588888888");
        userInfos.add(info1);
        userInfos.add(info2);
        userInfos.add(info3);
        //boolean save = userInfoService.save(info1);
        //boolean b = userInfoService.saveBatch(userInfos);

        UserInfo info4 = new UserInfo(1L,null,null,"168");
        UserInfo info5 = new UserInfo(2L,"",2,"199");
        List<UserInfo> userInfos2 = new ArrayList<>();
        userInfos2.add(info4);
        userInfos2.add(info5);*/
        //userInfoService.updateBatchById(userInfos2);
        //UserRequest request = new UserRequest("maj", "2", "110", "/");
        UserRequest request = new UserRequest("maj", "2", "110", "null");
        UserInfo userInfo=UserInfoMapatruct.INSTANCT.getUserInfoByUserRequest(request);

        String s="/";
        LambdaUpdateWrapper<UserInfo> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(UserInfo::getId,1);
        wrapper.set("/".equals(s),UserInfo::getDeleted,null);
        userInfoService.update(wrapper);

        String s2="niu"+null;
    }

}
