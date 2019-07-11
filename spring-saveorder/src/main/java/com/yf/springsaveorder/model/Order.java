package com.yf.springsaveorder.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: yaofeng
 * @create:2019-07-11-14:58
 **/
@Data
public class Order implements Serializable {
    private String id;
    private Timestamp timestamp;
    private String name;
    private int status;
    private String messageId;
}
