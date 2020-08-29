package com.zcy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 16:31
 * @description：
 * @modified By：
 * @version: $
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu {
    private Integer id;
    private String name;
    private Double price;
    private String flavor;
    //private Integer tid;
    private Type type;
}
