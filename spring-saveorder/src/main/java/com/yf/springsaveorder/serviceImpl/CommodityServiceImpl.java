package com.yf.springsaveorder.serviceImpl;

import com.yf.springsaveorder.mapper.ICommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: yaofeng
 * @create:2019-07-10-12:30
 **/
@Service
public class CommodityServiceImpl implements ICommodity {

    @Autowired
    private ICommodity iCommodity;

    @Override
    public int updateinventory() {
        int updateinventory = iCommodity.updateinventory();
        return updateinventory;
    }
}
