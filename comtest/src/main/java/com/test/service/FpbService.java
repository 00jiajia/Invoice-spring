package com.test.service;

import com.test.domain.FpbLg;
import com.test.domain.FpbTz;

import java.util.List;

public interface FpbService {
    void  saveFpbLg(FpbLg fpbLg);
    List<FpbTz> queryFpbStockList();
    List<FpbLg>queryFpbLgList();

    String queryFpbStocks();
    String queryFpbLgs();
    boolean updateFpbTz();
    String queryKpzh();
    String queryKpbTzs();
}
