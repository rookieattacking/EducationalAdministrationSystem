package org.lanqiao.educationaladministrationsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageHelperUtil<T> {
    private Integer pageSize; // 一页显示多少条
    private Integer pages; // 一共有多少页
    private Integer pageNum;// 当前页
    private Integer total; // 一共有多少条
    private List<T> list; // 数据
}
