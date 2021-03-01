package com.business.commerce.bo;

import com.business.commerce.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBo {

    private Integer id;

    private String name;

    private String password;

    private String permission;

    private String role;

    public UserBo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.permission = user.getPermission();
        this.role = user.getRole();
        this.password = user.getPassword();
    }
}
