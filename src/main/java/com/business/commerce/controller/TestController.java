package com.business.commerce.controller;


import com.business.commerce.common.AjaxResult;
import com.business.commerce.common.BaseController;
import com.business.commerce.common.SearchDto;
import com.business.commerce.dto.TestDto;
import com.business.commerce.kafka.KafkaProducer;
import com.business.commerce.redis.RedisUtils;
import com.business.commerce.service.TestService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaqiao
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/test")
public class TestController implements BaseController<TestDto> {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public AjaxResult detail(String id) {
        return AjaxResult.SUCCESS("success",testService.getById(id));
    }

    @Override
    public AjaxResult count() {
        return null;
    }

    @Override
    public AjaxResult list(TestDto dto) {
        return null;
    }

    @Override
    public AjaxResult search(SearchDto dto) {
        return null;
    }

    @Override
    public AjaxResult edit(TestDto dto) {
        return null;
    }

    @Override
    public AjaxResult delete(String id) {
        return null;
    }

    @Autowired
    private TestService testService;
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("list")
    public AjaxResult list(){
        return AjaxResult.SUCCESS("success",testService.list());
    }

    @GetMapping("kafka")
    public AjaxResult kafkaTest(){
        kafkaProducer.send("send a kafka message");
        return AjaxResult.SUCCESS();
    }

    @GetMapping("redis")
    public AjaxResult redisTest(){
        redisUtils.set("hello","world");
        return AjaxResult.SUCCESS(redisUtils.get("hello").toString());
    }

}

