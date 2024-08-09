package com.mg.springboot_project.interceptor;

import com.mg.springboot_project.config.UserInfoHolder;
import com.mg.springboot_project.entity.UserInfo;
import com.mg.springboot_project.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息校验拦截器
 *
 * @author mg
 * @date 2024-08-08
 */
@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userAccount = request.getHeader("user-account");
        // 加载当前用户基础数据信息
        /*String jsonStr = redisCache.get(SystemConstants.PC_SYS_USER_BASE_INFO_KEY_PREFIX + userAccount);
        ValidatorUtils.notBlank(jsonStr, CustomResponseCode.SystemMangeResponseCode.USER_LOGIN_INFO_EXPIRED);
        UserInfoExtDto userInfoExtDto = GsonUtils.gsonToBean(jsonStr, UserInfoExtDto.class);
        String cacheToken = userInfoExtDto.getToken();
        ValidatorUtils.isTrue(StringUtils.isNotBlank(cacheToken) && cacheToken.equals(token),
            CustomResponseCode.SystemMangeResponseCode.USER_LOGIN_INFO_EXPIRED);*/

        //此处暂时直接查数据库
        UserInfo userInfo=userInfoService.getUserInfoByAccount(userAccount);
        if (userInfo == null) {
            log.error("用户不存在");
            return false;
        }

        UserInfoHolder.addUserInfo(userInfo);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        try {
            HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        } finally {
            UserInfoHolder.remove();
        }
    }

}
