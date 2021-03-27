package com.example.pojo.params;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *前端接受分页参数的类
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PageSizeCurrent {
    private Integer page_size;
    private Integer current;
}
