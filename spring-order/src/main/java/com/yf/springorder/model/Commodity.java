package com.yf.springorder.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: yaofeng
 * @create:2019-07-10-12:14
 **/
@Data
public class Commodity implements Serializable {
    private int id;
    private String name;
    private int inventory;
}
