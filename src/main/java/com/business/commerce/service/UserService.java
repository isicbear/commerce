package com.business.commerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.commerce.bo.UserBo;
import com.business.commerce.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huaqiao
 * @since 2021-02-27
 */
public interface UserService extends IService<User> {

    UserBo getUserById(String userId);

    UserBo getUser(String name);

}
