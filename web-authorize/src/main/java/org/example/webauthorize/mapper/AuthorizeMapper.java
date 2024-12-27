package org.example.webauthorize.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.webpojo.admin.dto.AdminUserDTO;

@Mapper
public interface AuthorizeMapper {

    // 管理端登录
    String adminLogin(AdminUserDTO adminLoginInfo);
}
