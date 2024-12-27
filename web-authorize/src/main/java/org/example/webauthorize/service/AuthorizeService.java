package org.example.webauthorize.service;

import org.example.webpojo.admin.dto.AdminUserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthorizeService {
    String adminLogin(AdminUserDTO adminLoginInfo);
}
