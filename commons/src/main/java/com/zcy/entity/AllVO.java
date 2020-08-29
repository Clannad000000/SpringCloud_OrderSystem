package com.zcy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 21:25
 * @description：
 * @modified By：
 * @version: $
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class AllVO {
    private Integer code;
    private String msg;
    private Integer count;
    private List data;
}
