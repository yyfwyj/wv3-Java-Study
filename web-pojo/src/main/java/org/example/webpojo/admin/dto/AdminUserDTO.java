package org.example.webpojo.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDTO {
    // 用户ID
    private int id;

    // 用户名
    private String username;

    // 用户密码
    private String password;

    // 用户创建时间
    private LocalDateTime createAt;

    // 用户更新时间
    private LocalDateTime updateAt;

    // 用户是否启用 0 禁用 1 启用
    private boolean enabled;
}
