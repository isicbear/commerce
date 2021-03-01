package com.business.commerce.controller;


import com.business.commerce.bo.UserBo;
import com.business.commerce.common.AjaxResult;
import com.business.commerce.common.BaseController;
import com.business.commerce.common.SearchDto;
import com.business.commerce.dto.UserDto;
import com.business.commerce.exception.UnauthorizedException;
import com.business.commerce.service.UserService;
import com.business.commerce.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huaqiao
 * @since 2021-02-27
 */
@RestController
@RequestMapping("/user")
public class UserController implements BaseController<UserDto> {

    @Autowired
    private UserService userService;

    @Override
    public AjaxResult detail(String id) {
        return null;
    }

    @Override
    public AjaxResult count() {
        return null;
    }

    @Override
    public AjaxResult list(UserDto dto) {
        return null;
    }

    @Override
    public AjaxResult search(SearchDto dto) {
        return null;
    }

    @Override
    public AjaxResult edit(UserDto dto) {
        return null;
    }

    @Override
    public AjaxResult delete(String id) {
        return null;
    }

    @PostMapping("/login")
    public AjaxResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        UserBo userBo = userService.getUser(username);
        if (userBo.getPassword().equals(password)) {
            return AjaxResult.SUCCESS("success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/test")
    public AjaxResult article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return AjaxResult.SUCCESS("验证成功");
        } else {
            return AjaxResult.ERROR("验证失败");
        }
    }

    @GetMapping("/getRoles")
    @RequiresAuthentication
    public AjaxResult getRoles(String userId) {
        return AjaxResult.SUCCESS("You are authenticated", userService.getUserById(userId).getRole());
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public AjaxResult unauthorized() {
        return AjaxResult.NOLOGIN("Unauthorized");
    }



}

