package com.business.commerce.service.impl;

import com.business.commerce.entity.Test;
import com.business.commerce.dao.TestMapper;
import com.business.commerce.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huaqiao
 * @since 2021-02-22
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
