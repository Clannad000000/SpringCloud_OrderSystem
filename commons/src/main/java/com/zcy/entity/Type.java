package com.zcy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 21:55
 * @description：
 * @modified By：
 * @version: $
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Type {
    private Integer id;
    private String name;
}
