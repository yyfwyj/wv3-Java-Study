package org.example.webauthorize.controller;

import org.example.webauthorize.service.AuthorizeService;
import org.example.webpojo.admin.dto.AdminUserDTO;
import org.example.webpojo.admin.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin/auth")
public class AuthorizeController {

    @Autowired
    private AuthorizeService authorizeService;

    /**
     * 后台系统-管理员登录
     * @param adminLoginInfo
     * @return String
     */
    @PostMapping("/login")
    public Result adminLogin(@RequestBody AdminUserDTO adminLoginInfo) {
        String loginInfo = authorizeService.adminLogin(adminLoginInfo);
        return Result.success(loginInfo);
    }

    @PostMapping("/register")
    public Result<AdminUserDTO> adminRegister(@RequestBody AdminUserDTO registerInfo) {
        return authorizeService.adminRegister(registerInfo);
    }
}
