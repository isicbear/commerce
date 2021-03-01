package com.business.commerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.commerce.bo.UserBo;
import com.business.commerce.dao.UserMapper;
import com.business.commerce.entity.User;
import com.business.commerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huaqiao
 * @since 2021-02-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserBo getUserById(String id) {
        User user = baseMapper.selectById(id);
        return new UserBo(user);
    }

    @Override
    public UserBo getUser(String name) {
        List<User> users = baseMapper.selectList(new QueryWrapper<User>().eq("name", name));
        return new UserBo(users.get(0));
    }
}
