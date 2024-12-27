package org.example.webauthorize.service.impl;

import org.example.webauthorize.mapper.AuthorizeMapper;
import org.example.webauthorize.service.AuthorizeService;
import org.example.webpojo.admin.dto.AdminUserDTO;
import org.example.webpojo.admin.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthorizeImpl implements AuthorizeService {
    @Autowired
    private AuthorizeMapper authorizeMapper;

    public String adminLogin(AdminUserDTO adminLoginInfo) {
        AdminUserDTO userInfo =  authorizeMapper.adminLogin(adminLoginInfo);
        if (userInfo == null) {
            throw new RuntimeException("用户名或密码错误");
        }


        return "admin login";
    }

    @Override
    public Result<AdminUserDTO> adminRegister(AdminUserDTO adminRegisterInfo) {
        if(adminRegisterInfo.getUsername().isEmpty() || adminRegisterInfo.getPassword().isEmpty()) {
            return Result.error("注册用户名或密码不能为空", 500);
        }

        if(authorizeMapper.adminInquire(adminRegisterInfo.getUsername()) > 0) {
            System.out.println(authorizeMapper.adminInquire(adminRegisterInfo.getUsername()));
            return Result.error("用户名已存在", 500);
        }

        AdminUserDTO registerUser = AdminUserDTO
               .builder()
                .username(adminRegisterInfo.getUsername())
                .password(adminRegisterInfo.getPassword())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        AdminUserDTO user = authorizeMapper.adminRegister(registerUser);
        return Result.success(user);
    }
}
