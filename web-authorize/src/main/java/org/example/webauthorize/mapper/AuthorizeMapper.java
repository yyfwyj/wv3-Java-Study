package org.example.webauthorize.mapper;

import org.apache.ibatis.annotations.*;
import org.example.webpojo.admin.dto.AdminUserDTO;

@Mapper
public interface AuthorizeMapper {

    // 管理端登录
    AdminUserDTO adminLogin(AdminUserDTO adminLoginInfo);

    @Select("select count(username) from authorize.user WHERE username = #{username}")
    Integer adminInquire(@Param("username") String username);


    // 管理端注册
    @Insert("insert into authorize.user (username,password,create_at,update_at,enabled) VALUES (#{username},#{password},#{createAt},#{updateAt},#{enabled})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    AdminUserDTO adminRegister(AdminUserDTO registerUser);
}
