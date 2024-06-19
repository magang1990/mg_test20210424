package com.mg.mybatisplustest.mapstruct;

import com.mg.mybatisplustest.entity.UserInfo;
import com.mg.mybatisplustest.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mg
 * @date 2023-08-20
 */
@Mapper
public interface UserInfoMapatruct {

    UserInfoMapatruct INSTANCT = Mappers.getMapper(UserInfoMapatruct.class);

    UserInfo getUserInfoByUserRequest(UserRequest request);
}
