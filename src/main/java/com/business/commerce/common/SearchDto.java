package com.business.commerce.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SearchDto extends BaseDto {

    private static final long serialVersionUID = 5262382173463567180L;
    /**
     * 搜索关键字
     */
    private String key;

}
