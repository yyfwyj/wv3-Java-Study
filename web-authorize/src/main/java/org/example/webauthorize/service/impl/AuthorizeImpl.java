package org.example.webauthorize.service.impl;

import org.example.webauthorize.mapper.AuthorizeMapper;
import org.example.webauthorize.service.AuthorizeService;
import org.example.webpojo.admin.dto.AdminUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeImpl implements AuthorizeService {
    @Autowired
    private AuthorizeMapper authorizeMapper;

    public String adminLogin(AdminUserDTO adminLoginInfo) {
        authorizeMapper.adminLogin(adminLoginInfo);
        return "admin login";
    }
}
