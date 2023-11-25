package com.WorkResource.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 改进返回给前端的数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class hotArticleVo {
    private Long id;

    private String title;
    private Long viewCount;
}
