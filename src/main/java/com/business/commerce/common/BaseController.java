package com.business.commerce.common;

import org.springframework.web.bind.annotation.*;

public interface BaseController<T> {

    /**
     * 详情
     * @param id 主键
     * @return 详情
     */
    @GetMapping("/detail/{id}")
    AjaxResult detail(@PathVariable String id);

    /**
     * 统计
     * @return 统计信息
     */
    @GetMapping("/count")
    AjaxResult count();

    /**
     * 列表全量查询
     * @param dto 条件
     * @return 分页
     */
    @PostMapping("/list")
    AjaxResult list(@RequestBody T dto);

    /**
     * 搜索
     * @param dto key size current
     * @return 分页
     */
    @PostMapping("/search")
    AjaxResult search(@RequestBody SearchDto dto);

    /**
     * 编辑/新增
     * @param dto 实体
     * @return 状态
     */
    @PostMapping("/edit")
    AjaxResult edit(@RequestBody T dto);

    /**
     * 删除
     * @param id 主键
     * @return 状态
     */
    @DeleteMapping("/delete/{id}")
    AjaxResult delete(@PathVariable String id);

}
