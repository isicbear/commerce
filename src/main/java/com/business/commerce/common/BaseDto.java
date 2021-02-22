package com.business.commerce.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BaseDto extends PageDto  {

    private static final long serialVersionUID = 1835728825990671630L;

    private String id;

    private String createStart;

    private String createEnd;

    private String updateStart;

    private String updateEnd;

    private String createBy;

    private String updateBy;

    private String userId;

}
